package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.gl.e.f;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class jv$1
  implements e.f
{
  jv$1(jv paramjv) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    EGLContext localEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    if (jv.b(this.a) == null)
    {
      jv.a(this.a, new jx(paramEGL10, localEGLContext, paramEGLDisplay, paramEGLConfig, jv.c(this.a), ji.a()));
      jv.b(this.a).start();
    }
    return localEGLContext;
  }
  
  /* Error */
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: newarray byte
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 16	com/tencent/tencentmap/mapsdk/a/jv$1:a	Lcom/tencent/tencentmap/mapsdk/a/jv;
    //   9: aload 4
    //   11: invokestatic 60	com/tencent/tencentmap/mapsdk/a/jv:a	(Lcom/tencent/tencentmap/mapsdk/a/jv;[B)V
    //   14: aload 4
    //   16: monitorenter
    //   17: aload 4
    //   19: ldc2_w 61
    //   22: invokevirtual 66	java/lang/Object:wait	(J)V
    //   25: aload 4
    //   27: monitorexit
    //   28: aload_0
    //   29: getfield 16	com/tencent/tencentmap/mapsdk/a/jv$1:a	Lcom/tencent/tencentmap/mapsdk/a/jv;
    //   32: invokestatic 68	com/tencent/tencentmap/mapsdk/a/jv:a	(Lcom/tencent/tencentmap/mapsdk/a/jv;)V
    //   35: aload_1
    //   36: aload_2
    //   37: getstatic 72	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   40: getstatic 72	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   43: getstatic 26	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   46: invokeinterface 76 5 0
    //   51: pop
    //   52: aload_1
    //   53: aload_2
    //   54: aload_3
    //   55: invokeinterface 80 3 0
    //   60: pop
    //   61: return
    //   62: astore_1
    //   63: aload 4
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore 5
    //   70: goto -45 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	1
    //   0	73	1	paramEGL10	EGL10
    //   0	73	2	paramEGLDisplay	EGLDisplay
    //   0	73	3	paramEGLContext	EGLContext
    //   3	61	4	arrayOfByte	byte[]
    //   68	1	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   17	25	62	finally
    //   25	28	62	finally
    //   63	66	62	finally
    //   17	25	68	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jv.1
 * JD-Core Version:    0.7.0.1
 */