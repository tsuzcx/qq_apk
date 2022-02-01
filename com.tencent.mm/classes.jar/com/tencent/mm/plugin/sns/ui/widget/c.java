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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class c
{
  private static c zkW;
  private com.tencent.mm.kiss.widget.textview.a.a zkT = null;
  private int zkU = 0;
  
  static
  {
    AppMethodBeat.i(100505);
    zkW = new c();
    AppMethodBeat.o(100505);
  }
  
  public static c dSH()
  {
    return zkW;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100503);
    int i = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)(15.0F * com.tencent.mm.cc.a.eb(ai.getContext())));
    if ((this.zkT == null) || ((int)this.zkT.textSize != i)) {
      this.zkT = b.ahZ().ag(i).mv(ai.getContext().getResources().getColor(2131100907)).mu(16).a(TextUtils.TruncateAt.END).glF;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.zkT;
    AppMethodBeat.o(100503);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100504);
    if (this.zkU <= 0)
    {
      i = af.ddi().x;
      int j = (int)(ai.getResources().getDimension(2131165516) + ai.getResources().getDimension(2131165516));
      int k = (int)ai.getResources().getDimension(2131166840);
      int m = (int)ai.getResources().getDimension(2131165516);
      this.zkU = (i - k - j - m);
      if (this.zkU <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.zkU = (i - k - j - m);
        ac.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.zkU + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ac.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.zkU + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.zkU;
    AppMethodBeat.o(100504);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */