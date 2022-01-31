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

public final class c
{
  private static c sng;
  private com.tencent.mm.kiss.widget.textview.a.a smU = null;
  public int smV = 0;
  
  static
  {
    AppMethodBeat.i(40502);
    sng = new c();
    AppMethodBeat.o(40502);
  }
  
  public static c cxK()
  {
    return sng;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(40500);
    int i = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)(15.0F * com.tencent.mm.cb.a.dr(ah.getContext())));
    if ((this.smU == null) || ((int)this.smU.textSize != i)) {
      this.smU = b.SP().ae(i).jS(ah.getContext().getResources().getColor(2131690482)).jR(16).eLU;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.smU;
    AppMethodBeat.o(40500);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(40501);
    if (this.smV <= 0)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      int j = (int)(ah.getResources().getDimension(2131427808) + ah.getResources().getDimension(2131427808));
      int k = (int)ah.getResources().getDimension(2131428713);
      int m = (int)ah.getResources().getDimension(2131427808);
      this.smV = (i - k - j - m);
      ab.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.smV + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.smV;
    AppMethodBeat.o(40501);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */