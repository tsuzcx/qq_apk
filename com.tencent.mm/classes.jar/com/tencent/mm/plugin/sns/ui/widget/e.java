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
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;

public final class e
{
  private static e RXf;
  private com.tencent.mm.kiss.widget.textview.a.a RXc = null;
  private int RXd = 0;
  
  static
  {
    AppMethodBeat.i(100505);
    RXf = new e();
    AppMethodBeat.o(100505);
  }
  
  public static e hsR()
  {
    return RXf;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100503);
    int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)(15.0F * com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext())));
    if ((this.RXc == null) || ((int)this.RXc.textSize != i)) {
      this.RXc = b.bbQ().bn(i).sI(MMApplicationContext.getContext().getResources().getColor(b.c.FG_0_5)).sH(16).b(TextUtils.TruncateAt.END).mGZ;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.RXc;
    AppMethodBeat.o(100503);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100504);
    if (this.RXd <= 0)
    {
      i = al.gbR().x;
      int j = (int)(MMApplicationContext.getResources().getDimension(b.d.NormalPadding) + MMApplicationContext.getResources().getDimension(b.d.NormalPadding));
      int k = (int)MMApplicationContext.getResources().getDimension(b.d.sns_timeilne_margin_left);
      int m = (int)MMApplicationContext.getResources().getDimension(b.d.NormalPadding);
      this.RXd = (i - k - j - m);
      if (this.RXd <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.RXd = (i - k - j - m);
        Log.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.RXd + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      if (aw.jkS()) {
        this.RXd = bd.bs(MMApplicationContext.getContext(), b.d.sns_timeline_item_large_screen_width);
      }
      Log.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.RXd + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.RXd;
    AppMethodBeat.o(100504);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */