package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  private static c xYa;
  private com.tencent.mm.kiss.widget.textview.a.a xXX = null;
  private int xXY = 0;
  
  static
  {
    AppMethodBeat.i(100505);
    xYa = new c();
    AppMethodBeat.o(100505);
  }
  
  public static c dEj()
  {
    return xYa;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100503);
    int i = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)(15.0F * com.tencent.mm.cd.a.dT(aj.getContext())));
    if ((this.xXX == null) || ((int)this.xXX.textSize != i)) {
      this.xXX = b.agI().ac(i).mw(aj.getContext().getResources().getColor(2131100907)).mv(16).a(TextUtils.TruncateAt.END).ggZ;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.xXX;
    AppMethodBeat.o(100503);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100504);
    if (this.xXY <= 0)
    {
      i = af.cPz().x;
      int j = (int)(aj.getResources().getDimension(2131165516) + aj.getResources().getDimension(2131165516));
      int k = (int)aj.getResources().getDimension(2131166840);
      int m = (int)aj.getResources().getDimension(2131165516);
      this.xXY = (i - k - j - m);
      if (this.xXY <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.xXY = (i - k - j - m);
        ad.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.xXY + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ad.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.xXY + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.xXY;
    AppMethodBeat.o(100504);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */