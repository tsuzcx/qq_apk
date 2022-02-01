package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.a.c;

public class i
  extends Dialog
{
  private static final String TAG = "MicroMsg.MMDialog";
  private c iOnDialogDismissListener;
  private Runnable mHijackDismissAction;
  private final Runnable mReplaceRunnable;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(141874);
    this.mReplaceRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141873);
        try
        {
          ae.i("MicroMsg.MMDialog", "run on hijack runnable");
          i.this.mHijackDismissAction.run();
          AppMethodBeat.o(141873);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.MMDialog", "protect : " + localException.getMessage());
          AppMethodBeat.o(141873);
        }
      }
    };
    hijackDismissAction();
    AppMethodBeat.o(141874);
  }
  
  public i(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(141875);
    this.mReplaceRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141873);
        try
        {
          ae.i("MicroMsg.MMDialog", "run on hijack runnable");
          i.this.mHijackDismissAction.run();
          AppMethodBeat.o(141873);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.MMDialog", "protect : " + localException.getMessage());
          AppMethodBeat.o(141873);
        }
      }
    };
    hijackDismissAction();
    AppMethodBeat.o(141875);
  }
  
  /* Error */
  private void hijackDismissAction()
  {
    // Byte code:
    //   0: ldc 54
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 60	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 28
    //   10: if_icmple +9 -> 19
    //   13: ldc 54
    //   15: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: ldc 4
    //   21: ldc 62
    //   23: invokevirtual 68	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   26: astore_1
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 74	java/lang/reflect/Field:setAccessible	(Z)V
    //   32: ldc 70
    //   34: ldc 76
    //   36: invokevirtual 68	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   39: astore_2
    //   40: aload_2
    //   41: iconst_1
    //   42: invokevirtual 74	java/lang/reflect/Field:setAccessible	(Z)V
    //   45: aload_2
    //   46: aload_1
    //   47: aload_1
    //   48: invokevirtual 80	java/lang/reflect/Field:getModifiers	()I
    //   51: bipush 239
    //   53: iand
    //   54: invokevirtual 84	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   57: aload_0
    //   58: aload_1
    //   59: aload_0
    //   60: invokevirtual 88	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 90	java/lang/Runnable
    //   66: putfield 47	com/tencent/mm/ui/base/i:mHijackDismissAction	Ljava/lang/Runnable;
    //   69: aload_1
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 31	com/tencent/mm/ui/base/i:mReplaceRunnable	Ljava/lang/Runnable;
    //   75: invokevirtual 94	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   78: ldc 54
    //   80: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_1
    //   85: ldc 10
    //   87: ldc 96
    //   89: invokestatic 102	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc 54
    //   94: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_1
    //   99: ldc 10
    //   101: ldc 104
    //   103: invokestatic 102	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: ldc 54
    //   108: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: return
    //   112: astore_2
    //   113: goto -56 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	i
    //   26	44	1	localField1	java.lang.reflect.Field
    //   84	1	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   98	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   39	7	2	localField2	java.lang.reflect.Field
    //   112	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   19	32	84	java/lang/NoSuchFieldException
    //   32	57	84	java/lang/NoSuchFieldException
    //   57	78	84	java/lang/NoSuchFieldException
    //   19	32	98	java/lang/IllegalAccessException
    //   32	57	98	java/lang/IllegalAccessException
    //   57	78	98	java/lang/IllegalAccessException
    //   32	57	112	java/lang/Exception
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(141876);
    try
    {
      super.dismiss();
      if (this.iOnDialogDismissListener != null) {
        this.iOnDialogDismissListener.onDialogDismiss(this);
      }
      AppMethodBeat.o(141876);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.MMDialog", localException, "", new Object[0]);
      }
    }
  }
  
  public void setiOnDialogDismissListener(c paramc)
  {
    this.iOnDialogDismissListener = paramc;
  }
  
  public void show()
  {
    AppMethodBeat.i(141877);
    try
    {
      super.show();
      AppMethodBeat.o(141877);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MMDialog", localException, "", new Object[0]);
      AppMethodBeat.o(141877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.i
 * JD-Core Version:    0.7.0.1
 */