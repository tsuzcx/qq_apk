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
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class f
{
  private static final int ADC;
  private static f ADz;
  public int ACY = 0;
  private com.tencent.mm.kiss.widget.textview.a.a ADA = null;
  private com.tencent.mm.kiss.widget.textview.a.a ADB = null;
  
  static
  {
    AppMethodBeat.i(100557);
    ADz = new f();
    ADC = com.tencent.mm.cc.a.ay(aj.getContext(), 2131165200);
    AppMethodBeat.o(100557);
  }
  
  public static f efe()
  {
    return ADz;
  }
  
  public static float getTextSize()
  {
    AppMethodBeat.i(100556);
    float f = (int)(ADC * com.tencent.mm.cc.a.eb(aj.getContext()));
    AppMethodBeat.o(100556);
    return f;
  }
  
  public static void resetConfig()
  {
    f localf = ADz;
    localf.ADA = null;
    localf.ADB = null;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a eff()
  {
    AppMethodBeat.i(100554);
    int i = (int)(ADC * com.tencent.mm.cc.a.eb(aj.getContext()));
    if (Build.VERSION.SDK_INT == 28) {}
    for (this.ADB = b.akK().mT(8388627).mU(aj.getContext().getResources().getColor(2131100711)).aj(i).akL().akM().gFp;; this.ADB = b.akK().mT(8388627).mU(aj.getContext().getResources().getColor(2131100711)).aj(i).akL().gFp)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.ADB;
      AppMethodBeat.o(100554);
      return locala;
    }
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100553);
    int i = (int)(ADC * com.tencent.mm.cc.a.eb(aj.getContext()));
    if ((this.ADA == null) || ((int)this.ADA.textSize != i)) {
      if (Build.VERSION.SDK_INT != 28) {
        break label94;
      }
    }
    label94:
    for (this.ADA = b.akK().mT(8388627).mU(aj.getContext().getResources().getColor(2131100711)).aj(i).akM().gFp;; this.ADA = b.akK().mT(8388627).mU(aj.getContext().getResources().getColor(2131100711)).aj(i).gFp)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.ADA;
      AppMethodBeat.o(100553);
      return locala;
    }
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100555);
    if (this.ACY <= 0)
    {
      i = ag.dmE().x;
      int j = (int)(aj.getResources().getDimension(2131165516) + aj.getResources().getDimension(2131165516));
      int k = (int)aj.getResources().getDimension(2131166840);
      int m = (int)aj.getResources().getDimension(2131165516);
      this.ACY = (i - k - j);
      if (this.ACY <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.ACY = (i - k - j);
        ad.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.ACY + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ad.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.ACY + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.ACY;
    AppMethodBeat.o(100555);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */