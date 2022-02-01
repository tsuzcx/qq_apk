package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
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

public final class i
{
  private static i RXL;
  private static final int RXO;
  private com.tencent.mm.kiss.widget.textview.a.a RXM = null;
  private com.tencent.mm.kiss.widget.textview.a.a RXN = null;
  public int RXd = 0;
  
  static
  {
    AppMethodBeat.i(100557);
    RXL = new i();
    RXO = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), b.d.BodyTextSize);
    AppMethodBeat.o(100557);
  }
  
  public static float getTextSize()
  {
    AppMethodBeat.i(100556);
    float f = (int)(RXO * com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()));
    AppMethodBeat.o(100556);
    return f;
  }
  
  public static i hsX()
  {
    return RXL;
  }
  
  public static void resetConfig()
  {
    i locali = RXL;
    locali.RXM = null;
    locali.RXN = null;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100553);
    int i = (int)(RXO * com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()));
    if ((this.RXM == null) || ((int)this.RXM.textSize != i)) {
      if (Build.VERSION.SDK_INT != 28) {
        break label95;
      }
    }
    label95:
    for (this.RXM = b.bbQ().sH(8388627).sI(MMApplicationContext.getContext().getResources().getColor(b.c.normal_text_color)).bn(i).bbS().mGZ;; this.RXM = b.bbQ().sH(8388627).sI(MMApplicationContext.getContext().getResources().getColor(b.c.normal_text_color)).bn(i).mGZ)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.RXM;
      AppMethodBeat.o(100553);
      return locala;
    }
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100555);
    if (this.RXd <= 0)
    {
      i = al.gbR().x;
      int j = (int)(MMApplicationContext.getResources().getDimension(b.d.NormalPadding) + MMApplicationContext.getResources().getDimension(b.d.NormalPadding));
      int k = (int)MMApplicationContext.getResources().getDimension(b.d.sns_timeilne_margin_left);
      int m = (int)MMApplicationContext.getResources().getDimension(b.d.NormalPadding);
      this.RXd = (i - k - j);
      if (this.RXd <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.RXd = (i - k - j);
        Log.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.RXd + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      if (aw.jkS()) {
        this.RXd = bd.bs(MMApplicationContext.getContext(), b.d.sns_timeline_item_large_screen_width);
      }
      Log.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.RXd + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.RXd;
    AppMethodBeat.o(100555);
    return i;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a hsY()
  {
    AppMethodBeat.i(100554);
    int i = (int)(RXO * com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()));
    if (Build.VERSION.SDK_INT == 28) {}
    for (this.RXN = b.bbQ().sH(8388627).sI(MMApplicationContext.getContext().getResources().getColor(b.c.normal_text_color)).bn(i).bbR().bbS().mGZ;; this.RXN = b.bbQ().sH(8388627).sI(MMApplicationContext.getContext().getResources().getColor(b.c.normal_text_color)).bn(i).bbR().mGZ)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.RXN;
      AppMethodBeat.o(100554);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */