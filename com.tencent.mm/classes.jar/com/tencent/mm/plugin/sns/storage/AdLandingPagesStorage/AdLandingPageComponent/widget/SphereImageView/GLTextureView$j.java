package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class GLTextureView$j
{
  private static String TAG = "GLThreadManager";
  private boolean rAJ;
  private int rAK;
  private boolean rAL;
  boolean rAM;
  private boolean rAN;
  GLTextureView.i rAO;
  
  public final void b(GLTextureView.i parami)
  {
    try
    {
      AppMethodBeat.i(145354);
      GLTextureView.i.a(parami);
      if (this.rAO == parami) {
        this.rAO = null;
      }
      notifyAll();
      AppMethodBeat.o(145354);
      return;
    }
    finally {}
  }
  
  public final void c(GLTextureView.i parami)
  {
    AppMethodBeat.i(145355);
    if (this.rAO == parami) {
      this.rAO = null;
    }
    notifyAll();
    AppMethodBeat.o(145355);
  }
  
  public final boolean crO()
  {
    try
    {
      boolean bool = this.rAN;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean crP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 61
    //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:crQ	()V
    //   11: aload_0
    //   12: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAM	Z
    //   15: ifne +14 -> 29
    //   18: iconst_1
    //   19: istore_1
    //   20: ldc 61
    //   22: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: ldc 61
    //   33: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -11 -> 25
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	j
    //   19	12	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	39	finally
    //   20	25	39	finally
    //   31	36	39	finally
  }
  
  final void crQ()
  {
    if (!this.rAJ) {
      this.rAJ = true;
    }
  }
  
  /* Error */
  public final void e(javax.microedition.khronos.opengles.GL10 paramGL10)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 71
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 73	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAL	Z
    //   13: ifne +65 -> 78
    //   16: aload_0
    //   17: invokevirtual 64	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:crQ	()V
    //   20: aload_1
    //   21: sipush 7937
    //   24: invokeinterface 79 2 0
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAK	I
    //   34: ldc 82
    //   36: if_icmpge +23 -> 59
    //   39: aload_1
    //   40: ldc 84
    //   42: invokevirtual 90	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: ifne +41 -> 86
    //   48: iconst_1
    //   49: istore_2
    //   50: aload_0
    //   51: iload_2
    //   52: putfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAM	Z
    //   55: aload_0
    //   56: invokevirtual 50	java/lang/Object:notifyAll	()V
    //   59: aload_0
    //   60: getfield 66	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAM	Z
    //   63: ifne +28 -> 91
    //   66: iload_3
    //   67: istore_2
    //   68: aload_0
    //   69: iload_2
    //   70: putfield 59	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAN	Z
    //   73: aload_0
    //   74: iconst_1
    //   75: putfield 73	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAL	Z
    //   78: ldc 71
    //   80: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: iconst_0
    //   87: istore_2
    //   88: goto -38 -> 50
    //   91: iconst_0
    //   92: istore_2
    //   93: goto -25 -> 68
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	j
    //   0	101	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   49	44	2	bool1	boolean
    //   1	66	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	48	96	finally
    //   50	59	96	finally
    //   59	66	96	finally
    //   68	78	96	finally
    //   78	83	96	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.j
 * JD-Core Version:    0.7.0.1
 */