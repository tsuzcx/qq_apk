package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$a
{
  public static int lastType = 0;
  private static Toast tDF = null;
  
  public static void aO(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(142238);
    paramContext = paramContext.getApplicationContext();
    if (lastType != paramInt)
    {
      tDF = null;
      lastType = paramInt;
    }
    if (tDF == null) {
      tDF = Toast.makeText(paramContext, "", 1);
    }
    paramContext = View.inflate(paramContext, 2131495312, null);
    if (paramInt == 1) {
      ((TextView)paramContext.findViewById(2131304383)).setText(2131761212);
    }
    for (;;)
    {
      tDF.setView(paramContext);
      tDF.show();
      AppMethodBeat.o(142238);
      return;
      if (paramInt == 3) {
        ((TextView)paramContext.findViewById(2131304383)).setText(2131761213);
      } else {
        ((TextView)paramContext.findViewById(2131304383)).setText(2131761214);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.t.a
 * JD-Core Version:    0.7.0.1
 */