package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class SurfaceTextureRenderDelegate
  implements SurfaceTexture.OnFrameAvailableListener, Runnable
{
  private static final String LOG_TAG = "STRenderDelegate";
  private static final short[] drawOrder = { 0, 1, 2, 0, 2, 3 };
  private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}";
  private static final float[] squareCoords;
  private static float squareSize = 1.0F;
  private static final String vertexShaderCode = "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}";
  private ShortBuffer drawListBuffer;
  private EGL10 egl;
  private EGLConfig eglConfig;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface fakeEglSurface;
  private volatile boolean frameAvailable;
  private List<SurfaceTextureRender> mDownStreamSurfaceTextureRenderList;
  private List<SurfaceTexture> mPendingRemoveSurfaceTextureList;
  private List<Runnable> mReleaseRunnableList;
  private volatile boolean mShouldRun;
  private SurfaceTexture mUpstreamSurfaceTexture;
  private boolean mUseFakeSurface;
  private Thread mWorkThread;
  private int shaderProgram;
  private FloatBuffer textureBuffer;
  private final float[] textureCoords;
  private int[] textures;
  private FloatBuffer vertexBuffer;
  private float[] videoTextureTransform;
  
  static
  {
    squareCoords = new float[] { -squareSize, squareSize, 0.0F, -squareSize, -squareSize, 0.0F, squareSize, -squareSize, 0.0F, squareSize, squareSize, 0.0F };
  }
  
  public SurfaceTextureRenderDelegate(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(4336);
    this.textureCoords = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    this.textures = new int[1];
    this.videoTextureTransform = new float[16];
    this.mUpstreamSurfaceTexture = paramSurfaceTexture;
    this.mUpstreamSurfaceTexture.setOnFrameAvailableListener(this);
    this.mReleaseRunnableList = new ArrayList();
    this.mDownStreamSurfaceTextureRenderList = new ArrayList();
    this.mPendingRemoveSurfaceTextureList = new ArrayList();
    this.mShouldRun = true;
    this.mWorkThread = new Thread(this);
    this.mWorkThread.start();
    AppMethodBeat.o(4336);
  }
  
  public SurfaceTextureRenderDelegate(SurfaceTexture paramSurfaceTexture1, SurfaceTexture paramSurfaceTexture2)
  {
    this(paramSurfaceTexture1);
    AppMethodBeat.i(4337);
    addDownStreamSurfaceTexture(paramSurfaceTexture2);
    AppMethodBeat.o(4337);
  }
  
  private EGLConfig chooseEglConfig()
  {
    AppMethodBeat.i(4353);
    Object localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = getConfig();
    if (!this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt, arrayOfEGLConfig, 1, (int[])localObject))
    {
      localObject = new IllegalArgumentException("Failed to choose config: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
      AppMethodBeat.o(4353);
      throw ((Throwable)localObject);
    }
    if (localObject[0] > 0)
    {
      localObject = arrayOfEGLConfig[0];
      AppMethodBeat.o(4353);
      return localObject;
    }
    AppMethodBeat.o(4353);
    return null;
  }
  
  private EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(4352);
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    AppMethodBeat.o(4352);
    return paramEGL10;
  }
  
  private void deinitGL()
  {
    AppMethodBeat.i(4351);
    if (this.fakeEglSurface != EGL10.EGL_NO_SURFACE) {
      this.egl.eglDestroySurface(this.eglDisplay, this.fakeEglSurface);
    }
    Object localObject1 = this.egl;
    EGLDisplay localEGLDisplay = this.eglDisplay;
    EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
    ((EGL10)localObject1).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
    try
    {
      localObject1 = this.mDownStreamSurfaceTextureRenderList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((SurfaceTextureRender)((Iterator)localObject1).next()).deinitGL();
      }
    }
    finally
    {
      AppMethodBeat.o(4351);
    }
    this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
    this.egl.eglTerminate(this.eglDisplay);
    AppMethodBeat.o(4351);
  }
  
  private void eglMakeCurrentContextWithoutSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(4348);
    if (!this.mUseFakeSurface)
    {
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      if (paramEGL10.eglMakeCurrent(paramEGLDisplay, localEGLSurface, localEGLSurface, paramEGLContext)) {}
    }
    else
    {
      if (!this.mUseFakeSurface) {
        new StringBuilder("egl makeCurrent with no surface ").append(paramEGL10.eglGetError());
      }
      if (this.fakeEglSurface == EGL10.EGL_NO_SURFACE)
      {
        this.fakeEglSurface = paramEGL10.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, new int[] { 12375, 1, 12374, 1, 12344 });
        this.mUseFakeSurface = true;
      }
      if (!paramEGL10.eglMakeCurrent(paramEGLDisplay, this.fakeEglSurface, this.fakeEglSurface, paramEGLContext)) {
        new StringBuilder("egl makeCurrent with fake surface ").append(paramEGL10.eglGetError());
      }
    }
    AppMethodBeat.o(4348);
  }
  
  private int[] getConfig()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  private void initGL()
  {
    AppMethodBeat.i(4350);
    this.egl = ((EGL10)EGLContext.getEGL());
    this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.fakeEglSurface = EGL10.EGL_NO_SURFACE;
    int[] arrayOfInt = new int[2];
    this.egl.eglInitialize(this.eglDisplay, arrayOfInt);
    this.eglConfig = chooseEglConfig();
    this.eglContext = createContext(this.egl, this.eglDisplay, this.eglConfig);
    eglMakeCurrentContextWithoutSurface(this.egl, this.eglDisplay, this.eglContext, this.eglConfig);
    AppMethodBeat.o(4350);
  }
  
  private void initOffScreenGL()
  {
    AppMethodBeat.i(4344);
    if (this.egl == null)
    {
      initGL();
      setupVertexBuffer();
      setupTexture();
      loadShaders();
    }
    AppMethodBeat.o(4344);
  }
  
  private void loadShaders()
  {
    AppMethodBeat.i(4345);
    int i = GLES20.glCreateShader(35633);
    GLES20.glShaderSource(i, "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}");
    GLES20.glCompileShader(i);
    checkGlError("Vertex shader compile");
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(j, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}");
    GLES20.glCompileShader(j);
    checkGlError("Pixel shader compile");
    this.shaderProgram = GLES20.glCreateProgram();
    GLES20.glAttachShader(this.shaderProgram, i);
    GLES20.glAttachShader(this.shaderProgram, j);
    GLES20.glLinkProgram(this.shaderProgram);
    checkGlError("Shader program compile");
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(this.shaderProgram, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1) {
      GLES20.glGetProgramInfoLog(this.shaderProgram);
    }
    AppMethodBeat.o(4345);
  }
  
  private void setupTexture()
  {
    AppMethodBeat.i(4349);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.textureBuffer = localByteBuffer.asFloatBuffer();
    this.textureBuffer.put(this.textureCoords);
    this.textureBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.textures, 0);
    checkGlError("Texture generate");
    GLES20.glBindTexture(36197, this.textures[0]);
    checkGlError("Texture bind");
    this.mUpstreamSurfaceTexture.attachToGLContext(this.textures[0]);
    AppMethodBeat.o(4349);
  }
  
  private void setupVertexBuffer()
  {
    AppMethodBeat.i(4346);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(drawOrder.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.drawListBuffer = localByteBuffer.asShortBuffer();
    this.drawListBuffer.put(drawOrder);
    this.drawListBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(squareCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.vertexBuffer = localByteBuffer.asFloatBuffer();
    this.vertexBuffer.put(squareCoords);
    this.vertexBuffer.position(0);
    AppMethodBeat.o(4346);
  }
  
  private void transferToDownStream(List<SurfaceTextureRender> paramList)
  {
    AppMethodBeat.i(4342);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SurfaceTextureRender localSurfaceTextureRender = (SurfaceTextureRender)paramList.next();
      localSurfaceTextureRender.init(this.egl, this.eglContext, this.eglDisplay, this.eglConfig);
      localSurfaceTextureRender.makeCurrent();
      localSurfaceTextureRender.adjustViewPort();
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      GLES20.glUseProgram(this.shaderProgram);
      int i = GLES20.glGetUniformLocation(this.shaderProgram, "texture");
      int j = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinate");
      checkGlError("glGetAttribLocation");
      int k = GLES20.glGetAttribLocation(this.shaderProgram, "vPosition");
      int m = GLES20.glGetUniformLocation(this.shaderProgram, "textureTransform");
      GLES20.glEnableVertexAttribArray(k);
      GLES20.glVertexAttribPointer(k, 3, 5126, false, 12, this.vertexBuffer);
      GLES20.glBindTexture(36197, this.textures[0]);
      GLES20.glActiveTexture(33984);
      GLES20.glUniform1i(i, 0);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(j, 4, 5126, false, 0, this.textureBuffer);
      GLES20.glUniformMatrix4fv(m, 1, false, this.videoTextureTransform, 0);
      GLES20.glDrawElements(4, drawOrder.length, 5123, this.drawListBuffer);
      GLES20.glDisableVertexAttribArray(k);
      GLES20.glDisableVertexAttribArray(j);
      localSurfaceTextureRender.swapBuffer();
    }
    AppMethodBeat.o(4342);
  }
  
  public void addDownStreamSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      AppMethodBeat.i(4339);
      this.mDownStreamSurfaceTextureRenderList.add(new SurfaceTextureRender(paramSurfaceTexture));
      new StringBuilder("mDownStreamSurfaceTextureRenderList size is ").append(this.mDownStreamSurfaceTextureRenderList.size());
      AppMethodBeat.o(4339);
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void addReleaseCallback(Runnable paramRunnable)
  {
    AppMethodBeat.i(4338);
    this.mReleaseRunnableList.add(paramRunnable);
    AppMethodBeat.o(4338);
  }
  
  public void checkGlError(String paramString)
  {
    AppMethodBeat.i(4347);
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      new StringBuilder().append(paramString).append(": glError ").append(GLUtils.getEGLErrorString(i));
    }
    AppMethodBeat.o(4347);
  }
  
  public void destroy()
  {
    this.mShouldRun = false;
  }
  
  public int getAvailableDownStreamCount()
  {
    try
    {
      AppMethodBeat.i(4341);
      int i = this.mDownStreamSurfaceTextureRenderList.size();
      int j = this.mPendingRemoveSurfaceTextureList.size();
      AppMethodBeat.o(4341);
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.frameAvailable = true;
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void removeDownStreamSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      AppMethodBeat.i(4340);
      this.mPendingRemoveSurfaceTextureList.add(paramSurfaceTexture);
      AppMethodBeat.o(4340);
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void run()
  {
    AppMethodBeat.i(4343);
    initOffScreenGL();
    if (this.mShouldRun)
    {
      long l = SystemClock.uptimeMillis();
      eglMakeCurrentContextWithoutSurface(this.egl, this.eglDisplay, this.eglContext, this.eglConfig);
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator2 = this.mDownStreamSurfaceTextureRenderList.iterator();
        while (localIterator2.hasNext())
        {
          SurfaceTextureRender localSurfaceTextureRender = (SurfaceTextureRender)localIterator2.next();
          SurfaceTexture localSurfaceTexture = localSurfaceTextureRender.getSurface();
          if (this.mPendingRemoveSurfaceTextureList.contains(localSurfaceTexture)) {
            localArrayList1.add(localSurfaceTextureRender);
          }
        }
        this.mDownStreamSurfaceTextureRenderList.removeAll(localCollection);
      }
      finally
      {
        AppMethodBeat.o(4343);
      }
      this.mPendingRemoveSurfaceTextureList.clear();
      if (this.frameAvailable)
      {
        this.mUpstreamSurfaceTexture.updateTexImage();
        this.mUpstreamSurfaceTexture.getTransformMatrix(this.videoTextureTransform);
        this.frameAvailable = false;
        ArrayList localArrayList2 = new ArrayList(this.mDownStreamSurfaceTextureRenderList);
        transferToDownStream(localArrayList2);
      }
      for (;;)
      {
        try
        {
          l = SystemClock.uptimeMillis() - l;
          if (l <= 16L) {
            break label229;
          }
          l = 0L;
          Thread.sleep(l);
        }
        catch (InterruptedException localInterruptedException) {}
        break;
        break;
        label229:
        l = 16L - l;
      }
    }
    deinitGL();
    Iterator localIterator1 = this.mReleaseRunnableList.iterator();
    while (localIterator1.hasNext()) {
      ((Runnable)localIterator1.next()).run();
    }
    AppMethodBeat.o(4343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SurfaceTextureRenderDelegate
 * JD-Core Version:    0.7.0.1
 */