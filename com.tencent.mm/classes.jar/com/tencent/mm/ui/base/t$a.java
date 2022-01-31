package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$a
{
  private static Toast nbU = null;
  public static int zne = 0;
  
  public static void aC(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106878);
    paramContext = paramContext.getApplicationContext();
    if (zne != paramInt)
    {
      nbU = null;
      zne = paramInt;
    }
    if (nbU == null) {
      nbU = Toast.makeText(paramContext, "", 1);
    }
    paramContext = View.inflate(paramContext, 2130970617, null);
    if (paramInt == 1) {
      ((TextView)paramContext.findViewById(2131827465)).setText(2131301543);
    }
    for (;;)
    {
      nbU.setView(paramContext);
      nbU.show();
      AppMethodBeat.o(106878);
      return;
      if (paramInt == 3) {
        ((TextView)paramContext.findViewById(2131827465)).setText(2131301544);
      } else {
        ((TextView)paramContext.findViewById(2131827465)).setText(2131301545);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.t.a
 * JD-Core Version:    0.7.0.1
 */