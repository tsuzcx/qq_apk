package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class f
{
  private static f zlp;
  private static final int zls;
  public int zkU = 0;
  private com.tencent.mm.kiss.widget.textview.a.a zlq = null;
  private com.tencent.mm.kiss.widget.textview.a.a zlr = null;
  
  static
  {
    AppMethodBeat.i(100557);
    zlp = new f();
    zls = com.tencent.mm.cc.a.av(ai.getContext(), 2131165200);
    AppMethodBeat.o(100557);
  }
  
  public static f dSL()
  {
    return zlp;
  }
  
  public static float getTextSize()
  {
    AppMethodBeat.i(100556);
    float f = (int)(zls * com.tencent.mm.cc.a.eb(ai.getContext()));
    AppMethodBeat.o(100556);
    return f;
  }
  
  public static void resetConfig()
  {
    f localf = zlp;
    localf.zlq = null;
    localf.zlr = null;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a dSM()
  {
    AppMethodBeat.i(100554);
    int i = (int)(zls * com.tencent.mm.cc.a.eb(ai.getContext()));
    this.zlr = b.ahZ().mu(8388627).mv(ai.getContext().getResources().getColor(2131100711)).ag(i).aia().glF;
    com.tencent.mm.kiss.widget.textview.a.a locala = this.zlr;
    AppMethodBeat.o(100554);
    return locala;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100553);
    int i = (int)(zls * com.tencent.mm.cc.a.eb(ai.getContext()));
    if ((this.zlq == null) || ((int)this.zlq.textSize != i)) {
      this.zlq = b.ahZ().mu(8388627).mv(ai.getContext().getResources().getColor(2131100711)).ag(i).glF;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.zlq;
    AppMethodBeat.o(100553);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100555);
    if (this.zkU <= 0)
    {
      i = af.ddi().x;
      int j = (int)(ai.getResources().getDimension(2131165516) + ai.getResources().getDimension(2131165516));
      int k = (int)ai.getResources().getDimension(2131166840);
      int m = (int)ai.getResources().getDimension(2131165516);
      this.zkU = (i - k - j);
      if (this.zkU <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.zkU = (i - k - j);
        ac.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.zkU + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ac.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.zkU + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.zkU;
    AppMethodBeat.o(100555);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */