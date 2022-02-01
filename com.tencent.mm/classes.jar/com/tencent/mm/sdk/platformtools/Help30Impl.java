package com.tencent.mm.sdk.platformtools;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Help30Impl
{
  private static final String GPU_TAG = "MicroMsg.GPU_TAG";
  private static final int MIN_TEXTURE_SIZE = 2048;
  private EGLContext mEGLContext;
  private EGLDisplay mEGLDisplay;
  private EGLSurface mEGLSurface;
  private int maxTextureSize;
  
  private Help30Impl()
  {
    AppMethodBeat.i(157557);
    this.maxTextureSize = 2048;
    Log.i("MicroMsg.GPU_TAG", "pennqin, init Help30Impl.");
    AppMethodBeat.o(157557);
  }
  
  private void eglSetup()
  {
    AppMethodBeat.i(243938);
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      Log.e("MicroMsg.GPU_TAG", "EGL_NO_DISPLAY");
      AppMethodBeat.o(243938);
      return;
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      Log.e("MicroMsg.GPU_TAG", "eglInitialize");
      AppMethodBeat.o(243938);
      return;
    }
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGL14.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344 }, 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0);
    this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, localObject[0], new int[] { 12344 }, 0);
    EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
    AppMethodBeat.o(243938);
  }
  
  public static Help30Impl getInstance()
  {
    return Singleton.instance;
  }
  
  private void release()
  {
    AppMethodBeat.i(185117);
    if (EGL14.EGL_NO_DISPLAY != this.mEGLDisplay)
    {
      EGLDisplay localEGLDisplay = this.mEGLDisplay;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLSurface = EGL14.EGL_NO_SURFACE;
    AppMethodBeat.o(185117);
  }
  
  public boolean canUseHardwareAcceleration(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243980);
    Log.d("MicroMsg.GPU_TAG", "canUseHardwareAcceleration maxTextureSize %s w %s h %s.", new Object[] { Integer.valueOf(this.maxTextureSize), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 < this.maxTextureSize) && (paramInt2 < this.maxTextureSize))
    {
      AppMethodBeat.o(243980);
      return true;
    }
    AppMethodBeat.o(243980);
    return false;
  }
  
  public void decideLayerType(View paramView, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(243976);
    Log.d("MicroMsg.GPU_TAG", "decideLayerType maxTextureSize %s.", new Object[] { Integer.valueOf(this.maxTextureSize) });
    if (paramInt1 < this.maxTextureSize)
    {
      paramInt1 = i;
      if (paramInt2 < this.maxTextureSize) {}
    }
    else
    {
      paramInt1 = 1;
    }
    if (paramView.getLayerType() != paramInt1) {
      paramView.setLayerType(paramInt1, null);
    }
    AppMethodBeat.o(243976);
  }
  
  public int getMaxTextureSize()
  {
    return this.maxTextureSize;
  }
  
  public void setLayerType(View paramView)
  {
    AppMethodBeat.i(243969);
    if (paramView.getLayerType() == 1)
    {
      AppMethodBeat.o(243969);
      return;
    }
    paramView.setLayerType(1, null);
    AppMethodBeat.o(243969);
  }
  
  /* Error */
  public void updateTextureMaxSize()
  {
    // Byte code:
    //   0: sipush 2048
    //   3: istore_1
    //   4: ldc 158
    //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 13
    //   11: ldc 160
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 36	com/tencent/mm/sdk/platformtools/Help30Impl:maxTextureSize	I
    //   23: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: invokespecial 164	com/tencent/mm/sdk/platformtools/Help30Impl:eglSetup	()V
    //   34: iconst_1
    //   35: newarray int
    //   37: astore_2
    //   38: sipush 3379
    //   41: aload_2
    //   42: iconst_0
    //   43: invokestatic 170	android/opengl/GLES10:glGetIntegerv	(I[II)V
    //   46: aload_2
    //   47: iconst_0
    //   48: iaload
    //   49: sipush 2048
    //   52: if_icmple +7 -> 59
    //   55: aload_2
    //   56: iconst_0
    //   57: iaload
    //   58: istore_1
    //   59: aload_0
    //   60: iload_1
    //   61: putfield 36	com/tencent/mm/sdk/platformtools/Help30Impl:maxTextureSize	I
    //   64: ldc 13
    //   66: ldc 172
    //   68: iconst_2
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_2
    //   75: iconst_0
    //   76: iaload
    //   77: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_0
    //   84: getfield 36	com/tencent/mm/sdk/platformtools/Help30Impl:maxTextureSize	I
    //   87: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: iconst_0
    //   95: putstatic 178	com/tencent/mm/sdk/platformtools/ForceGpuUtil:canGetTextureSize	Z
    //   98: aload_0
    //   99: invokespecial 180	com/tencent/mm/sdk/platformtools/Help30Impl:release	()V
    //   102: ldc 158
    //   104: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore_2
    //   109: ldc 13
    //   111: aload_2
    //   112: ldc 182
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload_2
    //   121: invokevirtual 188	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   124: aastore
    //   125: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: ldc 158
    //   130: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: return
    //   134: astore_2
    //   135: ldc 13
    //   137: aload_2
    //   138: ldc 194
    //   140: iconst_1
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload_2
    //   147: invokevirtual 188	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   150: aastore
    //   151: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: iconst_0
    //   155: putstatic 178	com/tencent/mm/sdk/platformtools/ForceGpuUtil:canGetTextureSize	Z
    //   158: aload_0
    //   159: invokespecial 180	com/tencent/mm/sdk/platformtools/Help30Impl:release	()V
    //   162: ldc 158
    //   164: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: return
    //   168: astore_2
    //   169: ldc 13
    //   171: aload_2
    //   172: ldc 182
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_2
    //   181: invokevirtual 188	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   184: aastore
    //   185: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: ldc 158
    //   190: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: return
    //   194: astore_2
    //   195: iconst_0
    //   196: putstatic 178	com/tencent/mm/sdk/platformtools/ForceGpuUtil:canGetTextureSize	Z
    //   199: aload_0
    //   200: invokespecial 180	com/tencent/mm/sdk/platformtools/Help30Impl:release	()V
    //   203: ldc 158
    //   205: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_2
    //   209: athrow
    //   210: astore_3
    //   211: ldc 13
    //   213: aload_3
    //   214: ldc 182
    //   216: iconst_1
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_3
    //   223: invokevirtual 188	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   226: aastore
    //   227: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: goto -27 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	Help30Impl
    //   3	58	1	i	int
    //   37	38	2	arrayOfInt	int[]
    //   108	13	2	localThrowable1	java.lang.Throwable
    //   134	13	2	localThrowable2	java.lang.Throwable
    //   168	13	2	localThrowable3	java.lang.Throwable
    //   194	15	2	localObject	Object
    //   210	13	3	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   98	102	108	finally
    //   30	46	134	finally
    //   59	94	134	finally
    //   158	162	168	finally
    //   135	154	194	finally
    //   199	203	210	finally
  }
  
  static class Singleton
  {
    static Help30Impl instance;
    
    static
    {
      AppMethodBeat.i(157556);
      instance = new Help30Impl(null);
      AppMethodBeat.o(157556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Help30Impl
 * JD-Core Version:    0.7.0.1
 */