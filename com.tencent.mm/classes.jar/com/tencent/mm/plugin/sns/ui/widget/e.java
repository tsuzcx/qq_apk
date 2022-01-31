package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class e
{
  private static e snn;
  private static final int snq;
  public int smV = 0;
  private com.tencent.mm.kiss.widget.textview.a.a sno = null;
  private com.tencent.mm.kiss.widget.textview.a.a snp = null;
  
  static
  {
    AppMethodBeat.i(40522);
    snn = new e();
    snq = com.tencent.mm.cb.a.ap(ah.getContext(), 2131427507);
    AppMethodBeat.o(40522);
  }
  
  public static e cxN()
  {
    return snn;
  }
  
  public static float getTextSize()
  {
    AppMethodBeat.i(40521);
    float f = (int)(snq * com.tencent.mm.cb.a.dr(ah.getContext()));
    AppMethodBeat.o(40521);
    return f;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a cxO()
  {
    AppMethodBeat.i(40519);
    int i = (int)(snq * com.tencent.mm.cb.a.dr(ah.getContext()));
    if ((this.snp == null) || ((int)this.snp.textSize != i)) {
      this.snp = b.SP().jR(8388627).jS(ah.getContext().getResources().getColor(2131690322)).ae(i).SQ().eLU;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.snp;
    AppMethodBeat.o(40519);
    return locala;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(40518);
    int i = (int)(snq * com.tencent.mm.cb.a.dr(ah.getContext()));
    if ((this.sno == null) || ((int)this.sno.textSize != i)) {
      this.sno = b.SP().jR(8388627).jS(ah.getContext().getResources().getColor(2131690322)).ae(i).eLU;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.sno;
    AppMethodBeat.o(40518);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(40520);
    if (this.smV <= 0)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      int j = (int)(ah.getResources().getDimension(2131427808) + ah.getResources().getDimension(2131427808));
      int k = (int)ah.getResources().getDimension(2131428713);
      int m = (int)ah.getResources().getDimension(2131427808);
      this.smV = (i - k - j);
      ab.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.smV + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.smV;
    AppMethodBeat.o(40520);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */