package com.tencent.tav.decoder;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RenderContext
  implements IDecoderTrack.SurfaceCreator
{
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  private static final String TAG = "RenderContext";
  private EGLContext _eglContext;
  private HashMap<Surface, String> activeSurfaceCache;
  private EGLConfig eglConfig;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private HashMap<String, Surface> freeSurfaceCache;
  private CGRect glViewportRect;
  private int height;
  private boolean isSharedContext;
  private boolean pBufferEnable;
  private RenderContextParams params;
  private volatile boolean released;
  private List<Surface> releasingSurfaceCache;
  private Surface surface;
  private long threadId;
  private HashMap<Surface, VideoTexture> videoTextureMap;
  private int width;
  
  public RenderContext(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }
  
  public RenderContext(int paramInt1, int paramInt2, Surface paramSurface)
  {
    this(paramInt1, paramInt2, paramSurface, null);
  }
  
  public RenderContext(int paramInt1, int paramInt2, Surface paramSurface, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(191187);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.isSharedContext = false;
    this.released = false;
    this.threadId = -1L;
    this.pBufferEnable = false;
    this.videoTextureMap = new HashMap();
    this.activeSurfaceCache = new HashMap();
    this.freeSurfaceCache = new HashMap();
    this.releasingSurfaceCache = new ArrayList();
    this.surface = paramSurface;
    this.width = paramInt1;
    this.height = paramInt2;
    eglSetup(paramEGLContext);
    makeCurrent();
    AppMethodBeat.o(191187);
  }
  
  public static boolean checkEglActionSuccess(String paramString)
  {
    AppMethodBeat.i(191240);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      Logger.e("RenderContext", paramString + ": EGL error: 0x" + Integer.toHexString(j));
      localStringBuilder.append(paramString + ": EGL error: 0x" + Integer.toHexString(j));
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): " + localStringBuilder.toString());
    }
    if (i == 0)
    {
      AppMethodBeat.o(191240);
      return true;
    }
    AppMethodBeat.o(191240);
    return false;
  }
  
  public static void checkEglError(String paramString)
  {
    AppMethodBeat.i(191236);
    checkEglActionSuccess(paramString);
    AppMethodBeat.o(191236);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(191218);
    if (this.threadId != Thread.currentThread().getId()) {
      Logger.e("RenderContext", "线程不对，注意EGL相关的泄露问题！threadId = " + this.threadId + ", Thread.currentThread() name = " + Thread.currentThread().getName(), new RuntimeException());
    }
    AppMethodBeat.o(191218);
  }
  
  private void createEGLSurface()
  {
    AppMethodBeat.i(191214);
    if (this.eglSurface != EGL14.EGL_NO_SURFACE)
    {
      EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
      this.eglSurface = EGL14.EGL_NO_SURFACE;
    }
    if (this.surface != null)
    {
      this.eglSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, this.surface, new int[] { 12344 }, 0);
      AppMethodBeat.o(191214);
      return;
    }
    int i = this.width;
    int j = this.height;
    this.eglSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[] { 12375, i, 12374, j, 12344 }, 0);
    AppMethodBeat.o(191214);
  }
  
  public static int createTexture(int paramInt)
  {
    AppMethodBeat.i(191259);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    checkEglError("glBindTexture mTextureID");
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameteri(paramInt, 10242, 33071);
    GLES20.glTexParameteri(paramInt, 10243, 33071);
    checkEglError("glTexParameter");
    AppMethodBeat.o(191259);
    return i;
  }
  
  /* Error */
  private void eglSetup(EGLContext paramEGLContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 236
    //   4: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 167	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11: invokevirtual 171	java/lang/Thread:getId	()J
    //   14: putfield 81	com/tencent/tav/decoder/RenderContext:threadId	J
    //   17: aload_0
    //   18: getfield 77	com/tencent/tav/decoder/RenderContext:released	Z
    //   21: ifeq +11 -> 32
    //   24: ldc 236
    //   26: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: iconst_0
    //   34: invokestatic 240	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   37: putfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   40: aload_0
    //   41: getfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   44: getstatic 243	android/opengl/EGL14:EGL_NO_DISPLAY	Landroid/opengl/EGLDisplay;
    //   47: if_acmpne +26 -> 73
    //   50: new 152	java/lang/RuntimeException
    //   53: dup
    //   54: ldc 245
    //   56: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   59: pop
    //   60: ldc 236
    //   62: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -36 -> 29
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: iconst_2
    //   74: newarray int
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   81: aload_2
    //   82: iconst_0
    //   83: aload_2
    //   84: iconst_1
    //   85: invokestatic 249	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   88: ifne +26 -> 114
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   96: new 152	java/lang/RuntimeException
    //   99: dup
    //   100: ldc 251
    //   102: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   105: pop
    //   106: ldc 236
    //   108: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -82 -> 29
    //   114: iconst_1
    //   115: anewarray 253	android/opengl/EGLConfig
    //   118: astore_2
    //   119: iconst_1
    //   120: newarray int
    //   122: astore_3
    //   123: aload_0
    //   124: getfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   127: bipush 11
    //   129: newarray int
    //   131: dup
    //   132: iconst_0
    //   133: sipush 12324
    //   136: iastore
    //   137: dup
    //   138: iconst_1
    //   139: bipush 8
    //   141: iastore
    //   142: dup
    //   143: iconst_2
    //   144: sipush 12323
    //   147: iastore
    //   148: dup
    //   149: iconst_3
    //   150: bipush 8
    //   152: iastore
    //   153: dup
    //   154: iconst_4
    //   155: sipush 12322
    //   158: iastore
    //   159: dup
    //   160: iconst_5
    //   161: bipush 8
    //   163: iastore
    //   164: dup
    //   165: bipush 6
    //   167: sipush 12352
    //   170: iastore
    //   171: dup
    //   172: bipush 7
    //   174: iconst_4
    //   175: iastore
    //   176: dup
    //   177: bipush 8
    //   179: sipush 12610
    //   182: iastore
    //   183: dup
    //   184: bipush 9
    //   186: iconst_1
    //   187: iastore
    //   188: dup
    //   189: bipush 10
    //   191: sipush 12344
    //   194: iastore
    //   195: iconst_0
    //   196: aload_2
    //   197: iconst_0
    //   198: iconst_1
    //   199: aload_3
    //   200: iconst_0
    //   201: invokestatic 257	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   204: ifne +22 -> 226
    //   207: new 152	java/lang/RuntimeException
    //   210: dup
    //   211: ldc_w 259
    //   214: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   217: pop
    //   218: ldc 236
    //   220: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: goto -194 -> 29
    //   226: iconst_3
    //   227: newarray int
    //   229: astore_3
    //   230: aload_3
    //   231: dup
    //   232: iconst_0
    //   233: sipush 12440
    //   236: iastore
    //   237: dup
    //   238: iconst_1
    //   239: iconst_2
    //   240: iastore
    //   241: dup
    //   242: iconst_2
    //   243: sipush 12344
    //   246: iastore
    //   247: pop
    //   248: aload_1
    //   249: ifnull +57 -> 306
    //   252: aload_0
    //   253: iconst_1
    //   254: putfield 75	com/tencent/tav/decoder/RenderContext:isSharedContext	Z
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   262: aload_2
    //   263: iconst_0
    //   264: aaload
    //   265: aload_1
    //   266: aload_3
    //   267: iconst_0
    //   268: invokestatic 263	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   271: putfield 265	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   274: ldc_w 266
    //   277: invokestatic 219	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   280: aload_0
    //   281: getfield 265	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   284: ifnonnull +73 -> 357
    //   287: new 152	java/lang/RuntimeException
    //   290: dup
    //   291: ldc_w 268
    //   294: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   297: pop
    //   298: ldc 236
    //   300: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: goto -274 -> 29
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   311: aload_2
    //   312: iconst_0
    //   313: aaload
    //   314: getstatic 271	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   317: aload_3
    //   318: iconst_0
    //   319: invokestatic 263	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   322: putfield 265	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   325: ldc_w 266
    //   328: invokestatic 219	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   331: aload_0
    //   332: getfield 265	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   335: ifnonnull +22 -> 357
    //   338: new 152	java/lang/RuntimeException
    //   341: dup
    //   342: ldc_w 268
    //   345: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   348: pop
    //   349: ldc 236
    //   351: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: goto -325 -> 29
    //   357: aload_0
    //   358: aload_2
    //   359: iconst_0
    //   360: aaload
    //   361: putfield 195	com/tencent/tav/decoder/RenderContext:eglConfig	Landroid/opengl/EGLConfig;
    //   364: aload_0
    //   365: invokespecial 273	com/tencent/tav/decoder/RenderContext:createEGLSurface	()V
    //   368: ldc_w 274
    //   371: invokestatic 159	com/tencent/tav/decoder/RenderContext:checkEglActionSuccess	(Ljava/lang/String;)Z
    //   374: ifeq +8 -> 382
    //   377: aload_0
    //   378: iconst_1
    //   379: putfield 83	com/tencent/tav/decoder/RenderContext:pBufferEnable	Z
    //   382: aload_0
    //   383: getfield 73	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   386: ifnonnull +14 -> 400
    //   389: new 152	java/lang/RuntimeException
    //   392: dup
    //   393: ldc_w 276
    //   396: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   399: pop
    //   400: ldc 236
    //   402: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: goto -376 -> 29
    //   408: ldc 236
    //   410: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: goto -384 -> 29
    //   416: astore_1
    //   417: goto -9 -> 408
    //   420: astore_1
    //   421: goto -13 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	RenderContext
    //   0	424	1	paramEGLContext	EGLContext
    //   76	283	2	localObject	Object
    //   122	196	3	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   2	29	68	finally
    //   32	60	68	finally
    //   60	65	68	finally
    //   73	106	68	finally
    //   106	111	68	finally
    //   114	218	68	finally
    //   218	223	68	finally
    //   226	248	68	finally
    //   252	298	68	finally
    //   298	303	68	finally
    //   306	349	68	finally
    //   349	354	68	finally
    //   357	382	68	finally
    //   382	400	68	finally
    //   400	405	68	finally
    //   408	413	68	finally
    //   32	60	416	java/lang/Error
    //   73	106	416	java/lang/Error
    //   114	218	416	java/lang/Error
    //   226	248	416	java/lang/Error
    //   252	298	416	java/lang/Error
    //   306	349	416	java/lang/Error
    //   357	382	416	java/lang/Error
    //   382	400	416	java/lang/Error
    //   32	60	420	java/lang/Exception
    //   73	106	420	java/lang/Exception
    //   114	218	420	java/lang/Exception
    //   226	248	420	java/lang/Exception
    //   252	298	420	java/lang/Exception
    //   306	349	420	java/lang/Exception
    //   357	382	420	java/lang/Exception
    //   382	400	420	java/lang/Exception
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(191244);
        if (this.released)
        {
          AppMethodBeat.o(191244);
          paramInt = j;
          return paramInt;
        }
        j = GLES20.glCreateShader(paramInt);
        checkEglError("glCreateShader type=".concat(String.valueOf(paramInt)));
        GLES20.glShaderSource(j, paramString);
        GLES20.glCompileShader(j);
        paramString = new int[1];
        GLES20.glGetShaderiv(j, 35713, paramString, 0);
        if (paramString[0] == 0)
        {
          Logger.e("RenderContext", "Could not compile shader " + paramInt + ":");
          Logger.e("RenderContext", " " + GLES20.glGetShaderInfoLog(j));
          GLES20.glDeleteShader(j);
          paramInt = i;
          AppMethodBeat.o(191244);
        }
        else
        {
          paramInt = j;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private void release(Surface paramSurface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 323
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 325	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   12: aload_1
    //   13: ifnonnull +12 -> 25
    //   16: ldc_w 323
    //   19: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 88	com/tencent/tav/decoder/RenderContext:videoTextureMap	Ljava/util/HashMap;
    //   29: aload_1
    //   30: invokevirtual 329	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   33: ifeq +17 -> 50
    //   36: aload_0
    //   37: getfield 88	com/tencent/tav/decoder/RenderContext:videoTextureMap	Ljava/util/HashMap;
    //   40: aload_1
    //   41: invokevirtual 333	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 335	com/tencent/tav/decoder/VideoTexture
    //   47: invokevirtual 337	com/tencent/tav/decoder/VideoTexture:release	()V
    //   50: aload_1
    //   51: invokevirtual 340	android/view/Surface:release	()V
    //   54: ldc_w 323
    //   57: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -38 -> 22
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	RenderContext
    //   0	68	1	paramSurface	Surface
    // Exception table:
    //   from	to	target	type
    //   2	12	63	finally
    //   16	22	63	finally
    //   25	50	63	finally
    //   50	60	63	finally
  }
  
  private void releaseReleadingSurface()
  {
    AppMethodBeat.i(191251);
    checkThread();
    int i = 0;
    while (i < this.releasingSurfaceCache.size())
    {
      release((Surface)this.releasingSurfaceCache.remove(i));
      i += 1;
    }
    AppMethodBeat.o(191251);
  }
  
  public Surface createOutputSurface(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(191248);
        Surface localSurface1;
        if (this.released)
        {
          localSurface1 = null;
          AppMethodBeat.o(191248);
          return localSurface1;
        }
        checkThread();
        releaseReleadingSurface();
        str = paramInt1 + "*" + paramInt2 + "-" + paramInt3;
        if (this.freeSurfaceCache.containsKey(str))
        {
          localSurface1 = (Surface)this.freeSurfaceCache.remove(str);
          if (localSurface1 != null)
          {
            this.activeSurfaceCache.put(localSurface1, str);
            AppMethodBeat.o(191248);
            continue;
          }
        }
        makeCurrent();
      }
      finally {}
      VideoTexture localVideoTexture = new VideoTexture(paramInt1, paramInt2, 36197, paramInt3);
      localVideoTexture.setRenderContext(this);
      Surface localSurface2 = new Surface(localVideoTexture.surfaceTexture());
      this.videoTextureMap.put(localSurface2, localVideoTexture);
      this.activeSurfaceCache.put(localSurface2, str);
      AppMethodBeat.o(191248);
    }
  }
  
  public EGLContext eglContext()
  {
    return this._eglContext;
  }
  
  /* Error */
  public void free(Surface paramSurface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 384
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 15
    //   10: new 118	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 386
    //   17: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: invokestatic 167	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   23: invokevirtual 171	java/lang/Thread:getId	()J
    //   26: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 388	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_1
    //   36: ifnonnull +12 -> 48
    //   39: ldc_w 384
    //   42: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: getfield 90	com/tencent/tav/decoder/RenderContext:activeSurfaceCache	Ljava/util/HashMap;
    //   52: aload_1
    //   53: invokevirtual 333	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast 286	java/lang/String
    //   59: astore_2
    //   60: aload_2
    //   61: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +12 -> 76
    //   67: aload_0
    //   68: getfield 92	com/tencent/tav/decoder/RenderContext:freeSurfaceCache	Ljava/util/HashMap;
    //   71: aload_2
    //   72: invokevirtual 329	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 97	com/tencent/tav/decoder/RenderContext:releasingSurfaceCache	Ljava/util/List;
    //   80: aload_1
    //   81: invokeinterface 397 2 0
    //   86: pop
    //   87: ldc_w 384
    //   90: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: goto -48 -> 45
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	RenderContext
    //   0	101	1	paramSurface	Surface
    //   59	13	2	str	String
    // Exception table:
    //   from	to	target	type
    //   2	35	96	finally
    //   39	45	96	finally
    //   48	76	96	finally
    //   76	93	96	finally
  }
  
  public long getEglSurfaceHandle()
  {
    AppMethodBeat.i(191223);
    if (this.eglSurface != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        l = this.eglSurface.getNativeHandle();
        AppMethodBeat.o(191223);
        return l;
      }
      long l = this.eglSurface.getHandle();
      AppMethodBeat.o(191223);
      return l;
    }
    AppMethodBeat.o(191223);
    return 0L;
  }
  
  public CGRect getGlViewportRect()
  {
    return this.glViewportRect;
  }
  
  public RenderContextParams getParams()
  {
    return this.params;
  }
  
  public int height()
  {
    return this.height;
  }
  
  public boolean isPBufferEnable()
  {
    return this.pBufferEnable;
  }
  
  /* Error */
  public void makeCurrent()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 423
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 325	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   12: aload_0
    //   13: getfield 77	com/tencent/tav/decoder/RenderContext:released	Z
    //   16: ifeq +12 -> 28
    //   19: ldc_w 423
    //   22: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   32: aload_0
    //   33: getfield 73	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   36: aload_0
    //   37: getfield 73	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   40: aload_0
    //   41: getfield 265	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   44: invokestatic 427	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   47: ifne +9 -> 56
    //   50: ldc_w 429
    //   53: invokestatic 219	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   56: ldc_w 423
    //   59: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: goto -37 -> 25
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	RenderContext
    //   65	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	65	finally
    //   28	56	65	finally
    //   56	62	65	finally
  }
  
  public void release()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(191258);
        checkThread();
        if (this.released)
        {
          AppMethodBeat.o(191258);
          return;
        }
        makeCurrent();
        this.released = true;
        releaseReleadingSurface();
        Iterator localIterator = this.videoTextureMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          ((Surface)localIterator.next()).release();
          continue;
        }
        localObject2 = this.videoTextureMap.values().iterator();
      }
      finally {}
      Object localObject2;
      while (((Iterator)localObject2).hasNext()) {
        ((VideoTexture)((Iterator)localObject2).next()).release();
      }
      this.videoTextureMap.clear();
      try
      {
        if (EGL14.eglGetCurrentContext().equals(this._eglContext))
        {
          localObject2 = this.eglDisplay;
          EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
          EGL14.eglMakeCurrent((EGLDisplay)localObject2, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
        if (!this.isSharedContext) {
          EGL14.eglDestroyContext(this.eglDisplay, this._eglContext);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.e("RenderContext", "release", localException);
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          Logger.e("RenderContext", "release", localError);
        }
      }
      this.eglDisplay = null;
      this._eglContext = null;
      this.eglSurface = null;
      this.surface = null;
      AppMethodBeat.o(191258);
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setParams(RenderContextParams paramRenderContextParams)
  {
    this.params = paramRenderContextParams;
  }
  
  /* Error */
  public void setPresentationTime(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 478
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 77	com/tencent/tav/decoder/RenderContext:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 478
    //   18: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 99	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   28: ifnull +20 -> 48
    //   31: aload_0
    //   32: getfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   35: aload_0
    //   36: getfield 73	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   39: ldc2_w 479
    //   42: lload_1
    //   43: lmul
    //   44: invokestatic 486	android/opengl/EGLExt:eglPresentationTimeANDROID	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;J)Z
    //   47: pop
    //   48: ldc_w 478
    //   51: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -33 -> 21
    //   57: astore_3
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_3
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	RenderContext
    //   0	62	1	paramLong	long
    //   57	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	57	finally
    //   24	48	57	finally
    //   48	54	57	finally
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(191190);
    this.surface = paramSurface;
    createEGLSurface();
    makeCurrent();
    AppMethodBeat.o(191190);
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  /* Error */
  public boolean swapBuffers()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 491
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 325	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   12: aload_0
    //   13: getfield 77	com/tencent/tav/decoder/RenderContext:released	Z
    //   16: ifeq +15 -> 31
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 491
    //   24: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: aload_0
    //   32: getfield 189	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   35: aload_0
    //   36: getfield 73	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   39: invokestatic 494	android/opengl/EGL14:eglSwapBuffers	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   42: istore_1
    //   43: ldc_w 491
    //   46: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -22 -> 27
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	RenderContext
    //   20	23	1	bool	boolean
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   21	27	52	finally
    //   31	49	52	finally
  }
  
  public String toString()
  {
    AppMethodBeat.i(191260);
    String str = "RenderContext{_eglContext=" + this._eglContext + ", isSharedContext=" + this.isSharedContext + ", released=" + this.released + '}';
    AppMethodBeat.o(191260);
    return str;
  }
  
  public void updateViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(191200);
    makeCurrent();
    GLES20.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(191200);
  }
  
  public void updateViewport(CGRect paramCGRect)
  {
    AppMethodBeat.i(191198);
    if ((paramCGRect == null) || (paramCGRect.origin == null) || (paramCGRect.size == null))
    {
      AppMethodBeat.o(191198);
      return;
    }
    this.glViewportRect = paramCGRect;
    updateViewport((int)paramCGRect.origin.x, (int)paramCGRect.origin.y, (int)paramCGRect.size.width, (int)paramCGRect.size.height);
    AppMethodBeat.o(191198);
  }
  
  public VideoTexture videoTextureForSurface(Surface paramSurface)
  {
    try
    {
      AppMethodBeat.i(191256);
      paramSurface = (VideoTexture)this.videoTextureMap.get(paramSurface);
      AppMethodBeat.o(191256);
      return paramSurface;
    }
    finally
    {
      paramSurface = finally;
      throw paramSurface;
    }
  }
  
  public int width()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContext
 * JD-Core Version:    0.7.0.1
 */