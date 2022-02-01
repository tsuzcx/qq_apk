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
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f
{
  private static f Luk;
  private static final int Lun;
  public int LtK = 0;
  private com.tencent.mm.kiss.widget.textview.a.a Lul = null;
  private com.tencent.mm.kiss.widget.textview.a.a Lum = null;
  
  static
  {
    AppMethodBeat.i(100557);
    Luk = new f();
    Lun = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), i.d.BodyTextSize);
    AppMethodBeat.o(100557);
  }
  
  public static f fZG()
  {
    return Luk;
  }
  
  public static float getTextSize()
  {
    AppMethodBeat.i(100556);
    float f = (int)(Lun * com.tencent.mm.ci.a.ez(MMApplicationContext.getContext()));
    AppMethodBeat.o(100556);
    return f;
  }
  
  public static void resetConfig()
  {
    f localf = Luk;
    localf.Lul = null;
    localf.Lum = null;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a fZH()
  {
    AppMethodBeat.i(100554);
    int i = (int)(Lun * com.tencent.mm.ci.a.ez(MMApplicationContext.getContext()));
    if (Build.VERSION.SDK_INT == 28) {}
    for (this.Lum = b.aIT().sK(8388627).sL(MMApplicationContext.getContext().getResources().getColor(i.c.normal_text_color)).as(i).aIU().aIV().kgG;; this.Lum = b.aIT().sK(8388627).sL(MMApplicationContext.getContext().getResources().getColor(i.c.normal_text_color)).as(i).aIU().kgG)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.Lum;
      AppMethodBeat.o(100554);
      return locala;
    }
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100553);
    int i = (int)(Lun * com.tencent.mm.ci.a.ez(MMApplicationContext.getContext()));
    if ((this.Lul == null) || ((int)this.Lul.textSize != i)) {
      if (Build.VERSION.SDK_INT != 28) {
        break label95;
      }
    }
    label95:
    for (this.Lul = b.aIT().sK(8388627).sL(MMApplicationContext.getContext().getResources().getColor(i.c.normal_text_color)).as(i).aIV().kgG;; this.Lul = b.aIT().sK(8388627).sL(MMApplicationContext.getContext().getResources().getColor(i.c.normal_text_color)).as(i).kgG)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.Lul;
      AppMethodBeat.o(100553);
      return locala;
    }
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100555);
    if (this.LtK <= 0)
    {
      i = aj.eSY().x;
      int j = (int)(MMApplicationContext.getResources().getDimension(i.d.NormalPadding) + MMApplicationContext.getResources().getDimension(i.d.NormalPadding));
      int k = (int)MMApplicationContext.getResources().getDimension(i.d.sns_timeilne_margin_left);
      int m = (int)MMApplicationContext.getResources().getDimension(i.d.NormalPadding);
      this.LtK = (i - k - j);
      if (this.LtK <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.LtK = (i - k - j);
        Log.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.LtK + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      Log.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.LtK + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.LtK;
    AppMethodBeat.o(100555);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */