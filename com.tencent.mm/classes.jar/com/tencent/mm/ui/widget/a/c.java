package com.tencent.mm.ui.widget.a;

import android.app.Dialog;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.a.a;

public final class c
{
  private static void a(Dialog paramDialog, String paramString)
  {
    AppMethodBeat.i(251806);
    for (;;)
    {
      try
      {
        Message localMessage = (Message)a.jP(paramDialog).get(paramString);
        if (localMessage != null) {
          localMessage.recycle();
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      try
      {
        a.jP(paramDialog).bLs(paramString);
        AppMethodBeat.o(251806);
        return;
      }
      catch (Exception paramDialog)
      {
        AppMethodBeat.o(251806);
        return;
      }
    }
  }
  
  public static void f(Dialog paramDialog)
  {
    AppMethodBeat.i(251800);
    a(paramDialog, "mCancelMessage");
    a(paramDialog, "mDismissMessage");
    a(paramDialog, "mShowMessage");
    try
    {
      paramDialog.setOnCancelListener(null);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          paramDialog.setOnDismissListener(null);
          try
          {
            label33:
            paramDialog.setOnShowListener(null);
            AppMethodBeat.o(251800);
            return;
          }
          catch (Exception paramDialog)
          {
            AppMethodBeat.o(251800);
            return;
          }
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        break label33;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.c
 * JD-Core Version:    0.7.0.1
 */