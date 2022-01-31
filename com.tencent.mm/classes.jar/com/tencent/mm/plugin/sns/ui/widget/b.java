package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  private static b smX;
  private com.tencent.mm.kiss.widget.textview.a.a smU = null;
  private int smV = 0;
  
  static
  {
    AppMethodBeat.i(40478);
    smX = new b();
    AppMethodBeat.o(40478);
  }
  
  public static b cxJ()
  {
    return smX;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(40476);
    int i = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), (int)(15.0F * com.tencent.mm.cb.a.dr(ah.getContext())));
    if ((this.smU == null) || ((int)this.smU.textSize != i)) {
      this.smU = com.tencent.mm.kiss.widget.textview.a.b.SP().ae(i).jS(ah.getContext().getResources().getColor(2131690482)).jR(16).a(TextUtils.TruncateAt.END).eLU;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.smU;
    AppMethodBeat.o(40476);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(40477);
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
    AppMethodBeat.o(40477);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */