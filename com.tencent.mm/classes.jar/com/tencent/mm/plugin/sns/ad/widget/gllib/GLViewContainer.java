package com.tencent.mm.plugin.sns.ad.widget.gllib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLViewContainer
  extends GLSurfaceView
  implements c
{
  private boolean Qga;
  private a Qgb;
  private int Qgc;
  private HashMap<Integer, Integer> Qgd;
  private ArrayList<a> Qge;
  private boolean Qgf;
  private boolean Qgg;
  private final float[] Qgh;
  private final float[] Qgi;
  private Context mContext;
  private final float[] mQc;
  private int sDE;
  private int sDF;
  
  public GLViewContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GLViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310126);
    this.Qga = false;
    this.Qgd = new HashMap();
    this.Qge = new ArrayList();
    this.Qgf = false;
    this.Qgg = true;
    this.Qgh = new float[16];
    this.Qgi = new float[16];
    this.mQc = new float[16];
    this.mContext = paramContext;
    setEGLContextClientVersion(2);
    if (this.Qgg)
    {
      setZOrderOnTop(true);
      setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      getHolder().setFormat(1);
    }
    this.Qgb = new a(paramContext);
    setRenderer(this.Qgb);
    if (this.Qgf)
    {
      setRenderMode(1);
      AppMethodBeat.o(310126);
      return;
    }
    setRenderMode(0);
    AppMethodBeat.o(310126);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(310201);
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310136);
        GLViewContainer.a(GLViewContainer.this).add(parama);
        if (GLViewContainer.b(GLViewContainer.this))
        {
          parama.a(GLViewContainer.this, GLViewContainer.c(GLViewContainer.this));
          if ((GLViewContainer.d(GLViewContainer.this) != 0) && (GLViewContainer.e(GLViewContainer.this) != 0)) {
            parama.onSizeChanged(GLViewContainer.d(GLViewContainer.this), GLViewContainer.e(GLViewContainer.this));
          }
        }
        AppMethodBeat.o(310136);
      }
    });
    AppMethodBeat.o(310201);
  }
  
  public final int aH(Bitmap paramBitmap)
  {
    AppMethodBeat.i(310211);
    int j = -1;
    int i = j;
    if (paramBitmap != null)
    {
      int k = paramBitmap.hashCode();
      if (this.Qgd.containsKey(Integer.valueOf(k))) {
        j = ((Integer)this.Qgd.get(Integer.valueOf(k))).intValue();
      }
      i = j;
      if (j <= 0)
      {
        j = e.aI(paramBitmap);
        i = j;
        if (j > 0)
        {
          this.Qgd.put(Integer.valueOf(k), Integer.valueOf(j));
          i = j;
        }
      }
    }
    AppMethodBeat.o(310211);
    return i;
  }
  
  public final a ajW(int paramInt)
  {
    AppMethodBeat.i(310197);
    if ((paramInt < 0) || (paramInt >= getChildCount()))
    {
      AppMethodBeat.o(310197);
      return null;
    }
    a locala = (a)this.Qge.get(paramInt);
    AppMethodBeat.o(310197);
    return locala;
  }
  
  public int getChildCount()
  {
    AppMethodBeat.i(310189);
    int i = this.Qge.size();
    AppMethodBeat.o(310189);
    return i;
  }
  
  public Rect getGlobalVisibleRect()
  {
    AppMethodBeat.i(310216);
    Rect localRect = new Rect();
    getGlobalVisibleRect(localRect);
    AppMethodBeat.o(310216);
    return localRect;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(310223);
    if (!this.Qgf) {
      requestRender();
    }
    AppMethodBeat.o(310223);
  }
  
  protected void lh(int paramInt1, int paramInt2) {}
  
  public final void removeAllViews()
  {
    AppMethodBeat.i(310206);
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310137);
        Iterator localIterator = GLViewContainer.a(GLViewContainer.this).iterator();
        while (localIterator.hasNext()) {
          ((a)localIterator.next()).onDetach();
        }
        GLViewContainer.a(GLViewContainer.this).clear();
        AppMethodBeat.o(310137);
      }
    });
    AppMethodBeat.o(310206);
  }
  
  public final class a
    implements GLSurfaceView.Renderer
  {
    int Qgl = 0;
    Context mContext;
    long mStartTime = 0L;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final void onDrawFrame(GL10 paramGL10)
    {
      AppMethodBeat.i(310153);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      paramGL10 = GLViewContainer.a(GLViewContainer.this).iterator();
      while (paramGL10.hasNext()) {
        ((a)paramGL10.next()).y(GLViewContainer.j(GLViewContainer.this));
      }
      if (this.Qgl == 0) {
        this.mStartTime = System.currentTimeMillis();
      }
      this.Qgl += 1;
      if (this.Qgl == 20)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.mStartTime;
        Log.i("GLViewContainer", "FrameRate=" + this.Qgl * 1000.0F / (float)(l1 - l2));
        this.mStartTime = 0L;
        this.Qgl = 0;
      }
      AppMethodBeat.o(310153);
    }
    
    public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(310145);
      Log.i("GLViewContainer", "onSurfaceChanged, w=" + paramInt1 + ", h=" + paramInt2);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      float f = paramInt1 / paramInt2;
      Matrix.orthoM(GLViewContainer.h(GLViewContainer.this), 0, -f, f, -1.0F, 1.0F, -10.0F, 10.0F);
      Matrix.setLookAtM(GLViewContainer.i(GLViewContainer.this), 0, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
      Matrix.multiplyMM(GLViewContainer.j(GLViewContainer.this), 0, GLViewContainer.h(GLViewContainer.this), 0, GLViewContainer.i(GLViewContainer.this), 0);
      GLViewContainer.b(GLViewContainer.this, paramInt1);
      GLViewContainer.c(GLViewContainer.this, paramInt2);
      GLViewContainer.this.lh(paramInt1, paramInt2);
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        paramGL10 = GLViewContainer.a(GLViewContainer.this).iterator();
        while (paramGL10.hasNext()) {
          ((a)paramGL10.next()).onSizeChanged(paramInt1, paramInt2);
        }
      }
      AppMethodBeat.o(310145);
    }
    
    public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      AppMethodBeat.i(310140);
      Log.i("GLViewContainer", "onSurfaceCreated");
      paramGL10 = GLViewContainer.this;
      long l1 = System.currentTimeMillis();
      int i = e.loadShader(35633, "attribute vec4 aPosition;attribute vec2 aTextureCoord;uniform mat4 uMVPMatrix;varying vec2 vTextureCoord;void main(){gl_Position = uMVPMatrix * aPosition;\nvTextureCoord = aTextureCoord;\n}");
      int j = e.loadShader(35632, "precision lowp float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D uTexture;void main() {gl_FragColor = texture2D(uTexture, vTextureCoord);float alpha = uAlpha;gl_FragColor.a = gl_FragColor.a * alpha;gl_FragColor.r = gl_FragColor.r * alpha;gl_FragColor.g = gl_FragColor.g * alpha;gl_FragColor.b = gl_FragColor.b * alpha;}");
      int k = GLES20.glCreateProgram();
      GLES20.glAttachShader(k, i);
      GLES20.glAttachShader(k, j);
      GLES20.glLinkProgram(k);
      long l2 = System.currentTimeMillis();
      Log.i("GLProgramLoader", "loadProgram, cost=" + (l2 - l1) + ", progrom=" + k);
      GLViewContainer.a(paramGL10, k);
      GLViewContainer.f(GLViewContainer.this).clear();
      GLViewContainer.g(GLViewContainer.this);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      paramGL10 = GLViewContainer.a(GLViewContainer.this).iterator();
      while (paramGL10.hasNext()) {
        ((a)paramGL10.next()).a(GLViewContainer.this, GLViewContainer.c(GLViewContainer.this));
      }
      AppMethodBeat.o(310140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.gllib.GLViewContainer
 * JD-Core Version:    0.7.0.1
 */