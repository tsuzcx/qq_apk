package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$a
{
  public static int lastType = 0;
  private static Toast xfv = null;
  
  public static void aP(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(142238);
    paramContext = paramContext.getApplicationContext();
    if (lastType != paramInt)
    {
      xfv = null;
      lastType = paramInt;
    }
    if (xfv == null) {
      xfv = Toast.makeText(paramContext, "", 1);
    }
    paramContext = View.inflate(paramContext, 2131496170, null);
    if (paramInt == 1) {
      ((TextView)paramContext.findViewById(2131307346)).setText(2131762999);
    }
    for (;;)
    {
      xfv.setView(paramContext);
      xfv.show();
      AppMethodBeat.o(142238);
      return;
      if (paramInt == 3) {
        ((TextView)paramContext.findViewById(2131307346)).setText(2131763000);
      } else {
        ((TextView)paramContext.findViewById(2131307346)).setText(2131763001);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.u.a
 * JD-Core Version:    0.7.0.1
 */