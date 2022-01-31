package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class i
  extends Dialog
{
  private static final String TAG = "MicroMsg.MMDialog";
  private Runnable mHijackDismissAction;
  private final Runnable mReplaceRunnable;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142748);
    this.mReplaceRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142747);
        try
        {
          ab.i("MicroMsg.MMDialog", "run on hijack runnable");
          i.this.mHijackDismissAction.run();
          AppMethodBeat.o(142747);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.MMDialog", "protect : " + localException.getMessage());
          AppMethodBeat.o(142747);
        }
      }
    };
    hijackDismissAction();
    AppMethodBeat.o(142748);
  }
  
  public i(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(142749);
    this.mReplaceRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142747);
        try
        {
          ab.i("MicroMsg.MMDialog", "run on hijack runnable");
          i.this.mHijackDismissAction.run();
          AppMethodBeat.o(142747);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.MMDialog", "protect : " + localException.getMessage());
          AppMethodBeat.o(142747);
        }
      }
    };
    hijackDismissAction();
    AppMethodBeat.o(142749);
  }
  
  /* Error */
  private void hijackDismissAction()
  {
    // Byte code:
    //   0: ldc 52
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 4
    //   7: ldc 54
    //   9: invokevirtual 60	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   12: astore_1
    //   13: aload_1
    //   14: iconst_1
    //   15: invokevirtual 66	java/lang/reflect/Field:setAccessible	(Z)V
    //   18: ldc 62
    //   20: ldc 68
    //   22: invokevirtual 60	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   25: astore_2
    //   26: aload_2
    //   27: iconst_1
    //   28: invokevirtual 66	java/lang/reflect/Field:setAccessible	(Z)V
    //   31: aload_2
    //   32: aload_1
    //   33: aload_1
    //   34: invokevirtual 72	java/lang/reflect/Field:getModifiers	()I
    //   37: bipush 239
    //   39: iand
    //   40: invokevirtual 76	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   43: aload_0
    //   44: aload_1
    //   45: aload_0
    //   46: invokevirtual 80	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 82	java/lang/Runnable
    //   52: putfield 45	com/tencent/mm/ui/base/i:mHijackDismissAction	Ljava/lang/Runnable;
    //   55: aload_1
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 29	com/tencent/mm/ui/base/i:mReplaceRunnable	Ljava/lang/Runnable;
    //   61: invokevirtual 86	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   64: ldc 52
    //   66: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: astore_1
    //   71: ldc 10
    //   73: ldc 88
    //   75: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: ldc 52
    //   80: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_1
    //   85: ldc 10
    //   87: ldc 96
    //   89: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc 52
    //   94: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_2
    //   99: goto -56 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	i
    //   12	44	1	localField1	java.lang.reflect.Field
    //   70	1	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   84	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   25	7	2	localField2	java.lang.reflect.Field
    //   98	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   5	18	70	java/lang/NoSuchFieldException
    //   18	43	70	java/lang/NoSuchFieldException
    //   43	64	70	java/lang/NoSuchFieldException
    //   5	18	84	java/lang/IllegalAccessException
    //   18	43	84	java/lang/IllegalAccessException
    //   43	64	84	java/lang/IllegalAccessException
    //   18	43	98	java/lang/Exception
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(106525);
    try
    {
      super.dismiss();
      AppMethodBeat.o(106525);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMDialog", localException, "", new Object[0]);
      AppMethodBeat.o(106525);
    }
  }
  
  public void show()
  {
    AppMethodBeat.i(106526);
    try
    {
      super.show();
      AppMethodBeat.o(106526);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMDialog", localException, "", new Object[0]);
      AppMethodBeat.o(106526);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.i
 * JD-Core Version:    0.7.0.1
 */