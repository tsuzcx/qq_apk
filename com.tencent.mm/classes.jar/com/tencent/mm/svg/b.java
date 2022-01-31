package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  private static a<Paint> yRG;
  private static a<float[]> yRH;
  private static a<Matrix> yRI;
  private static a<Path> yRJ;
  private static final float[] yRK;
  
  static
  {
    AppMethodBeat.i(70062);
    yRG = new a();
    yRH = new a();
    yRI = new a();
    yRJ = new a();
    yRK = new float[9];
    AppMethodBeat.o(70062);
  }
  
  /* Error */
  protected static Paint a(Looper paramLooper, Paint paramPaint)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 46
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 31	com/tencent/mm/svg/b:yRG	Lcom/tencent/mm/svg/a;
    //   11: invokevirtual 50	com/tencent/mm/svg/a:dAa	()Ljava/lang/Object;
    //   14: checkcast 52	android/graphics/Paint
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +38 -> 57
    //   22: new 52	android/graphics/Paint
    //   25: dup
    //   26: invokespecial 53	android/graphics/Paint:<init>	()V
    //   29: astore_2
    //   30: aload_1
    //   31: ifnull +8 -> 39
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 57	android/graphics/Paint:set	(Landroid/graphics/Paint;)V
    //   39: getstatic 31	com/tencent/mm/svg/b:yRG	Lcom/tencent/mm/svg/a;
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual 60	com/tencent/mm/svg/a:a	(Landroid/os/Looper;Ljava/lang/Object;)V
    //   47: ldc 46
    //   49: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_2
    //   56: areturn
    //   57: aload_2
    //   58: invokevirtual 63	android/graphics/Paint:reset	()V
    //   61: goto -31 -> 30
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramLooper	Looper
    //   0	70	1	paramPaint	Paint
    //   17	41	2	localPaint	Paint
    // Exception table:
    //   from	to	target	type
    //   3	18	64	finally
    //   22	30	64	finally
    //   34	39	64	finally
    //   39	52	64	finally
    //   57	61	64	finally
  }
  
  protected static void f(Looper paramLooper)
  {
    try
    {
      AppMethodBeat.i(70057);
      yRG.e(paramLooper);
      yRH.e(paramLooper);
      yRI.e(paramLooper);
      yRJ.e(paramLooper);
      AppMethodBeat.o(70057);
      return;
    }
    finally
    {
      paramLooper = finally;
      throw paramLooper;
    }
  }
  
  /* Error */
  protected static float[] g(Looper paramLooper)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 72
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 33	com/tencent/mm/svg/b:yRH	Lcom/tencent/mm/svg/a;
    //   11: invokevirtual 50	com/tencent/mm/svg/a:dAa	()Ljava/lang/Object;
    //   14: checkcast 73	[F
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +26 -> 45
    //   22: bipush 9
    //   24: newarray float
    //   26: astore_1
    //   27: getstatic 33	com/tencent/mm/svg/b:yRH	Lcom/tencent/mm/svg/a;
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 60	com/tencent/mm/svg/a:a	(Landroid/os/Looper;Ljava/lang/Object;)V
    //   35: ldc 72
    //   37: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: getstatic 39	com/tencent/mm/svg/b:yRK	[F
    //   48: iconst_0
    //   49: aload_1
    //   50: iconst_0
    //   51: bipush 9
    //   53: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   56: goto -29 -> 27
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramLooper	Looper
    //   17	33	1	arrayOfFloat	float[]
    // Exception table:
    //   from	to	target	type
    //   3	18	59	finally
    //   22	27	59	finally
    //   27	40	59	finally
    //   45	56	59	finally
  }
  
  /* Error */
  protected static Matrix h(Looper paramLooper)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 82
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 35	com/tencent/mm/svg/b:yRI	Lcom/tencent/mm/svg/a;
    //   11: invokevirtual 50	com/tencent/mm/svg/a:dAa	()Ljava/lang/Object;
    //   14: checkcast 84	android/graphics/Matrix
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +29 -> 48
    //   22: new 84	android/graphics/Matrix
    //   25: dup
    //   26: invokespecial 85	android/graphics/Matrix:<init>	()V
    //   29: astore_1
    //   30: getstatic 35	com/tencent/mm/svg/b:yRI	Lcom/tencent/mm/svg/a;
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 60	com/tencent/mm/svg/a:a	(Landroid/os/Looper;Ljava/lang/Object;)V
    //   38: ldc 82
    //   40: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: aload_1
    //   49: invokevirtual 86	android/graphics/Matrix:reset	()V
    //   52: goto -22 -> 30
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramLooper	Looper
    //   17	32	1	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   3	18	55	finally
    //   22	30	55	finally
    //   30	43	55	finally
    //   48	52	55	finally
  }
  
  /* Error */
  protected static Path i(Looper paramLooper)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 88
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 37	com/tencent/mm/svg/b:yRJ	Lcom/tencent/mm/svg/a;
    //   11: invokevirtual 50	com/tencent/mm/svg/a:dAa	()Ljava/lang/Object;
    //   14: checkcast 90	android/graphics/Path
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +29 -> 48
    //   22: new 90	android/graphics/Path
    //   25: dup
    //   26: invokespecial 91	android/graphics/Path:<init>	()V
    //   29: astore_1
    //   30: getstatic 37	com/tencent/mm/svg/b:yRJ	Lcom/tencent/mm/svg/a;
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 60	com/tencent/mm/svg/a:a	(Landroid/os/Looper;Ljava/lang/Object;)V
    //   38: ldc 88
    //   40: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: aload_1
    //   49: invokevirtual 92	android/graphics/Path:reset	()V
    //   52: goto -22 -> 30
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramLooper	Looper
    //   17	32	1	localPath	Path
    // Exception table:
    //   from	to	target	type
    //   3	18	55	finally
    //   22	30	55	finally
    //   30	43	55	finally
    //   48	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.b
 * JD-Core Version:    0.7.0.1
 */