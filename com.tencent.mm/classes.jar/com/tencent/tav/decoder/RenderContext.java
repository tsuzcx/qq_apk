package com.tencent.tav.decoder;

import android.graphics.PointF;
import android.opengl.EGL14;
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
    AppMethodBeat.i(197887);
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
    AppMethodBeat.o(197887);
  }
  
  public static boolean checkEglActionSuccess(String paramString)
  {
    AppMethodBeat.i(197897);
    String str = "";
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      Logger.e("RenderContext", paramString + ": EGL error: 0x" + Integer.toHexString(j));
      str = str + paramString + ": EGL error: 0x" + Integer.toHexString(j);
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): ".concat(String.valueOf(str)));
    }
    if (i == 0)
    {
      AppMethodBeat.o(197897);
      return true;
    }
    AppMethodBeat.o(197897);
    return false;
  }
  
  public static void checkEglError(String paramString)
  {
    AppMethodBeat.i(197896);
    checkEglActionSuccess(paramString);
    AppMethodBeat.o(197896);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(197891);
    if (this.threadId != Thread.currentThread().getId()) {
      Logger.e("RenderContext", "Thread wrong!! ", new RuntimeException());
    }
    AppMethodBeat.o(197891);
  }
  
  public static int createTexture(int paramInt)
  {
    AppMethodBeat.i(197905);
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
    AppMethodBeat.o(197905);
    return i;
  }
  
  /* Error */
  private void eglSetup(EGLContext paramEGLContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 212
    //   4: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11: invokevirtual 173	java/lang/Thread:getId	()J
    //   14: putfield 72	com/tencent/tav/decoder/RenderContext:threadId	J
    //   17: aload_0
    //   18: getfield 68	com/tencent/tav/decoder/RenderContext:released	Z
    //   21: ifeq +11 -> 32
    //   24: ldc 212
    //   26: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: iconst_0
    //   34: invokestatic 216	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   37: putfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   40: aload_0
    //   41: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   44: getstatic 221	android/opengl/EGL14:EGL_NO_DISPLAY	Landroid/opengl/EGLDisplay;
    //   47: if_acmpne +26 -> 73
    //   50: new 142	java/lang/RuntimeException
    //   53: dup
    //   54: ldc 223
    //   56: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   59: pop
    //   60: ldc 212
    //   62: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -36 -> 29
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: iconst_2
    //   74: newarray int
    //   76: astore 4
    //   78: aload_0
    //   79: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   82: aload 4
    //   84: iconst_0
    //   85: aload 4
    //   87: iconst_1
    //   88: invokestatic 227	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   91: ifne +26 -> 117
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   99: new 142	java/lang/RuntimeException
    //   102: dup
    //   103: ldc 229
    //   105: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   108: pop
    //   109: ldc 212
    //   111: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: goto -85 -> 29
    //   117: iconst_1
    //   118: anewarray 231	android/opengl/EGLConfig
    //   121: astore 4
    //   123: iconst_1
    //   124: newarray int
    //   126: astore 5
    //   128: aload_0
    //   129: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   132: bipush 11
    //   134: newarray int
    //   136: dup
    //   137: iconst_0
    //   138: sipush 12324
    //   141: iastore
    //   142: dup
    //   143: iconst_1
    //   144: bipush 8
    //   146: iastore
    //   147: dup
    //   148: iconst_2
    //   149: sipush 12323
    //   152: iastore
    //   153: dup
    //   154: iconst_3
    //   155: bipush 8
    //   157: iastore
    //   158: dup
    //   159: iconst_4
    //   160: sipush 12322
    //   163: iastore
    //   164: dup
    //   165: iconst_5
    //   166: bipush 8
    //   168: iastore
    //   169: dup
    //   170: bipush 6
    //   172: sipush 12352
    //   175: iastore
    //   176: dup
    //   177: bipush 7
    //   179: iconst_4
    //   180: iastore
    //   181: dup
    //   182: bipush 8
    //   184: sipush 12610
    //   187: iastore
    //   188: dup
    //   189: bipush 9
    //   191: iconst_1
    //   192: iastore
    //   193: dup
    //   194: bipush 10
    //   196: sipush 12344
    //   199: iastore
    //   200: iconst_0
    //   201: aload 4
    //   203: iconst_0
    //   204: iconst_1
    //   205: aload 5
    //   207: iconst_0
    //   208: invokestatic 235	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   211: ifne +21 -> 232
    //   214: new 142	java/lang/RuntimeException
    //   217: dup
    //   218: ldc 237
    //   220: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   223: pop
    //   224: ldc 212
    //   226: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: goto -200 -> 29
    //   232: iconst_3
    //   233: newarray int
    //   235: astore 5
    //   237: aload 5
    //   239: dup
    //   240: iconst_0
    //   241: sipush 12440
    //   244: iastore
    //   245: dup
    //   246: iconst_1
    //   247: iconst_2
    //   248: iastore
    //   249: dup
    //   250: iconst_2
    //   251: sipush 12344
    //   254: iastore
    //   255: pop
    //   256: aload_1
    //   257: ifnull +57 -> 314
    //   260: aload_0
    //   261: iconst_1
    //   262: putfield 66	com/tencent/tav/decoder/RenderContext:isSharedContext	Z
    //   265: aload_0
    //   266: aload_0
    //   267: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   270: aload 4
    //   272: iconst_0
    //   273: aaload
    //   274: aload_1
    //   275: aload 5
    //   277: iconst_0
    //   278: invokestatic 241	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   281: putfield 243	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   284: ldc 244
    //   286: invokestatic 195	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   289: aload_0
    //   290: getfield 243	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   293: ifnonnull +72 -> 365
    //   296: new 142	java/lang/RuntimeException
    //   299: dup
    //   300: ldc 246
    //   302: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   305: pop
    //   306: ldc 212
    //   308: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: goto -282 -> 29
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   319: aload 4
    //   321: iconst_0
    //   322: aaload
    //   323: getstatic 249	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   326: aload 5
    //   328: iconst_0
    //   329: invokestatic 241	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   332: putfield 243	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   335: ldc 244
    //   337: invokestatic 195	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   340: aload_0
    //   341: getfield 243	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   344: ifnonnull +21 -> 365
    //   347: new 142	java/lang/RuntimeException
    //   350: dup
    //   351: ldc 246
    //   353: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   356: pop
    //   357: ldc 212
    //   359: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: goto -333 -> 29
    //   365: aload_0
    //   366: getfield 90	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   369: ifnull +72 -> 441
    //   372: aload_0
    //   373: aload_0
    //   374: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   377: aload 4
    //   379: iconst_0
    //   380: aaload
    //   381: aload_0
    //   382: getfield 90	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   385: iconst_1
    //   386: newarray int
    //   388: dup
    //   389: iconst_0
    //   390: sipush 12344
    //   393: iastore
    //   394: iconst_0
    //   395: invokestatic 253	android/opengl/EGL14:eglCreateWindowSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Ljava/lang/Object;[II)Landroid/opengl/EGLSurface;
    //   398: putfield 255	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   401: ldc_w 256
    //   404: invokestatic 161	com/tencent/tav/decoder/RenderContext:checkEglActionSuccess	(Ljava/lang/String;)Z
    //   407: ifeq +8 -> 415
    //   410: aload_0
    //   411: iconst_1
    //   412: putfield 74	com/tencent/tav/decoder/RenderContext:pBufferEnable	Z
    //   415: aload_0
    //   416: getfield 255	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   419: ifnonnull +14 -> 433
    //   422: new 142	java/lang/RuntimeException
    //   425: dup
    //   426: ldc_w 258
    //   429: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   432: pop
    //   433: ldc 212
    //   435: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: goto -409 -> 29
    //   441: aload_0
    //   442: getfield 92	com/tencent/tav/decoder/RenderContext:width	I
    //   445: istore_2
    //   446: aload_0
    //   447: getfield 94	com/tencent/tav/decoder/RenderContext:height	I
    //   450: istore_3
    //   451: aload_0
    //   452: aload_0
    //   453: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   456: aload 4
    //   458: iconst_0
    //   459: aaload
    //   460: iconst_5
    //   461: newarray int
    //   463: dup
    //   464: iconst_0
    //   465: sipush 12375
    //   468: iastore
    //   469: dup
    //   470: iconst_1
    //   471: iload_2
    //   472: iastore
    //   473: dup
    //   474: iconst_2
    //   475: sipush 12374
    //   478: iastore
    //   479: dup
    //   480: iconst_3
    //   481: iload_3
    //   482: iastore
    //   483: dup
    //   484: iconst_4
    //   485: sipush 12344
    //   488: iastore
    //   489: iconst_0
    //   490: invokestatic 262	android/opengl/EGL14:eglCreatePbufferSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;[II)Landroid/opengl/EGLSurface;
    //   493: putfield 255	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   496: goto -95 -> 401
    //   499: astore_1
    //   500: ldc 212
    //   502: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   505: goto -476 -> 29
    //   508: astore_1
    //   509: goto -9 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	this	RenderContext
    //   0	512	1	paramEGLContext	EGLContext
    //   445	27	2	i	int
    //   450	32	3	j	int
    //   76	381	4	localObject	Object
    //   126	201	5	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   2	29	68	finally
    //   32	60	68	finally
    //   60	65	68	finally
    //   73	109	68	finally
    //   109	114	68	finally
    //   117	224	68	finally
    //   224	229	68	finally
    //   232	256	68	finally
    //   260	306	68	finally
    //   306	311	68	finally
    //   314	357	68	finally
    //   357	362	68	finally
    //   365	401	68	finally
    //   401	415	68	finally
    //   415	433	68	finally
    //   433	438	68	finally
    //   441	496	68	finally
    //   500	505	68	finally
    //   32	60	499	java/lang/Exception
    //   73	109	499	java/lang/Exception
    //   117	224	499	java/lang/Exception
    //   232	256	499	java/lang/Exception
    //   260	306	499	java/lang/Exception
    //   314	357	499	java/lang/Exception
    //   365	401	499	java/lang/Exception
    //   401	415	499	java/lang/Exception
    //   415	433	499	java/lang/Exception
    //   441	496	499	java/lang/Exception
    //   32	60	508	java/lang/Error
    //   73	109	508	java/lang/Error
    //   117	224	508	java/lang/Error
    //   232	256	508	java/lang/Error
    //   260	306	508	java/lang/Error
    //   314	357	508	java/lang/Error
    //   365	401	508	java/lang/Error
    //   401	415	508	java/lang/Error
    //   415	433	508	java/lang/Error
    //   441	496	508	java/lang/Error
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(197898);
        if (this.released)
        {
          AppMethodBeat.o(197898);
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
          AppMethodBeat.o(197898);
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
    //   2: ldc_w 303
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 305	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   12: aload_1
    //   13: ifnonnull +12 -> 25
    //   16: ldc_w 303
    //   19: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 79	com/tencent/tav/decoder/RenderContext:videoTextureMap	Ljava/util/HashMap;
    //   29: aload_1
    //   30: invokevirtual 309	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   33: ifeq +17 -> 50
    //   36: aload_0
    //   37: getfield 79	com/tencent/tav/decoder/RenderContext:videoTextureMap	Ljava/util/HashMap;
    //   40: aload_1
    //   41: invokevirtual 313	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 315	com/tencent/tav/decoder/VideoTexture
    //   47: invokevirtual 317	com/tencent/tav/decoder/VideoTexture:release	()V
    //   50: aload_1
    //   51: invokevirtual 320	android/view/Surface:release	()V
    //   54: ldc_w 303
    //   57: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(197900);
    checkThread();
    int i = 0;
    while (i < this.releasingSurfaceCache.size())
    {
      release((Surface)this.releasingSurfaceCache.remove(i));
      i += 1;
    }
    AppMethodBeat.o(197900);
  }
  
  public Surface createOutputSurface(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(197899);
        Surface localSurface1;
        if (this.released)
        {
          localSurface1 = null;
          AppMethodBeat.o(197899);
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
            AppMethodBeat.o(197899);
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
      AppMethodBeat.o(197899);
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
    //   2: ldc_w 364
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 15
    //   10: new 117	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 366
    //   17: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: invokestatic 169	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   23: invokevirtual 173	java/lang/Thread:getId	()J
    //   26: invokevirtual 369	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 372	com/tencent/tav/decoder/logger/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_1
    //   36: ifnonnull +12 -> 48
    //   39: ldc_w 364
    //   42: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: getfield 81	com/tencent/tav/decoder/RenderContext:activeSurfaceCache	Ljava/util/HashMap;
    //   52: aload_1
    //   53: invokevirtual 313	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast 146	java/lang/String
    //   59: astore_2
    //   60: aload_2
    //   61: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +12 -> 76
    //   67: aload_0
    //   68: getfield 83	com/tencent/tav/decoder/RenderContext:freeSurfaceCache	Ljava/util/HashMap;
    //   71: aload_2
    //   72: invokevirtual 309	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 88	com/tencent/tav/decoder/RenderContext:releasingSurfaceCache	Ljava/util/List;
    //   80: aload_1
    //   81: invokeinterface 381 2 0
    //   86: pop
    //   87: ldc_w 364
    //   90: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(197892);
    if (this.eglSurface != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        l = this.eglSurface.getNativeHandle();
        AppMethodBeat.o(197892);
        return l;
      }
      long l = this.eglSurface.getHandle();
      AppMethodBeat.o(197892);
      return l;
    }
    AppMethodBeat.o(197892);
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
    //   2: ldc_w 407
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 305	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   12: aload_0
    //   13: getfield 68	com/tencent/tav/decoder/RenderContext:released	Z
    //   16: ifeq +12 -> 28
    //   19: ldc_w 407
    //   22: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   32: aload_0
    //   33: getfield 255	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   36: aload_0
    //   37: getfield 255	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   40: aload_0
    //   41: getfield 243	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   44: invokestatic 411	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   47: ifne +9 -> 56
    //   50: ldc_w 413
    //   53: invokestatic 195	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   56: ldc_w 407
    //   59: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        AppMethodBeat.i(197904);
        checkThread();
        if (this.released)
        {
          AppMethodBeat.o(197904);
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
      AppMethodBeat.o(197904);
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
    //   2: ldc_w 469
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 68	com/tencent/tav/decoder/RenderContext:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 469
    //   18: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 90	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   28: ifnull +20 -> 48
    //   31: aload_0
    //   32: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   35: aload_0
    //   36: getfield 255	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   39: ldc2_w 470
    //   42: lload_1
    //   43: lmul
    //   44: invokestatic 477	android/opengl/EGLExt:eglPresentationTimeANDROID	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;J)Z
    //   47: pop
    //   48: ldc_w 469
    //   51: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 480
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 305	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   12: aload_0
    //   13: getfield 68	com/tencent/tav/decoder/RenderContext:released	Z
    //   16: ifeq +15 -> 31
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 480
    //   24: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: aload_0
    //   32: getfield 218	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   35: aload_0
    //   36: getfield 255	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   39: invokestatic 483	android/opengl/EGL14:eglSwapBuffers	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   42: istore_1
    //   43: ldc_w 480
    //   46: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(197906);
    String str = "RenderContext{_eglContext=" + this._eglContext + ", isSharedContext=" + this.isSharedContext + ", released=" + this.released + '}';
    AppMethodBeat.o(197906);
    return str;
  }
  
  public void updateViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197889);
    makeCurrent();
    GLES20.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(197889);
  }
  
  public void updateViewport(CGRect paramCGRect)
  {
    AppMethodBeat.i(197888);
    if ((paramCGRect == null) || (paramCGRect.origin == null) || (paramCGRect.size == null))
    {
      AppMethodBeat.o(197888);
      return;
    }
    this.glViewportRect = paramCGRect;
    updateViewport((int)paramCGRect.origin.x, (int)paramCGRect.origin.y, (int)paramCGRect.size.width, (int)paramCGRect.size.height);
    AppMethodBeat.o(197888);
  }
  
  public VideoTexture videoTextureForSurface(Surface paramSurface)
  {
    try
    {
      AppMethodBeat.i(197903);
      paramSurface = (VideoTexture)this.videoTextureMap.get(paramSurface);
      AppMethodBeat.o(197903);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContext
 * JD-Core Version:    0.7.0.1
 */