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
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class f
{
  private static f AVa;
  private static final int AVd;
  public int AUz = 0;
  private com.tencent.mm.kiss.widget.textview.a.a AVb = null;
  private com.tencent.mm.kiss.widget.textview.a.a AVc = null;
  
  static
  {
    AppMethodBeat.i(100557);
    AVa = new f();
    AVd = com.tencent.mm.cb.a.ay(ak.getContext(), 2131165200);
    AppMethodBeat.o(100557);
  }
  
  public static f eiL()
  {
    return AVa;
  }
  
  public static float getTextSize()
  {
    AppMethodBeat.i(100556);
    float f = (int)(AVd * com.tencent.mm.cb.a.ef(ak.getContext()));
    AppMethodBeat.o(100556);
    return f;
  }
  
  public static void resetConfig()
  {
    f localf = AVa;
    localf.AVb = null;
    localf.AVc = null;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a eiM()
  {
    AppMethodBeat.i(100554);
    int i = (int)(AVd * com.tencent.mm.cb.a.ef(ak.getContext()));
    if (Build.VERSION.SDK_INT == 28) {}
    for (this.AVc = b.akZ().mW(8388627).mX(ak.getContext().getResources().getColor(2131100711)).aj(i).ala().alb().gHW;; this.AVc = b.akZ().mW(8388627).mX(ak.getContext().getResources().getColor(2131100711)).aj(i).ala().gHW)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.AVc;
      AppMethodBeat.o(100554);
      return locala;
    }
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100553);
    int i = (int)(AVd * com.tencent.mm.cb.a.ef(ak.getContext()));
    if ((this.AVb == null) || ((int)this.AVb.textSize != i)) {
      if (Build.VERSION.SDK_INT != 28) {
        break label94;
      }
    }
    label94:
    for (this.AVb = b.akZ().mW(8388627).mX(ak.getContext().getResources().getColor(2131100711)).aj(i).alb().gHW;; this.AVb = b.akZ().mW(8388627).mX(ak.getContext().getResources().getColor(2131100711)).aj(i).gHW)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.AVb;
      AppMethodBeat.o(100553);
      return locala;
    }
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100555);
    if (this.AUz <= 0)
    {
      i = ah.dpC().x;
      int j = (int)(ak.getResources().getDimension(2131165516) + ak.getResources().getDimension(2131165516));
      int k = (int)ak.getResources().getDimension(2131166840);
      int m = (int)ak.getResources().getDimension(2131165516);
      this.AUz = (i - k - j);
      if (this.AUz <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.AUz = (i - k - j);
        ae.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.AUz + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ae.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.AUz + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.AUz;
    AppMethodBeat.o(100555);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */