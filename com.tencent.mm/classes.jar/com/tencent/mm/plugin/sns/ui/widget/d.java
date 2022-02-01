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

public final class d
{
  private static d zlg;
  private com.tencent.mm.kiss.widget.textview.a.a zkT = null;
  public int zkU = 0;
  
  static
  {
    AppMethodBeat.i(100531);
    zlg = new d();
    AppMethodBeat.o(100531);
  }
  
  public static d dSI()
  {
    return zlg;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100529);
    int i = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), (int)(15.0F * com.tencent.mm.cc.a.eb(ai.getContext())));
    if ((this.zkT == null) || ((int)this.zkT.textSize != i)) {
      this.zkT = b.ahZ().ag(i).mv(ai.getContext().getResources().getColor(2131100907)).mu(16).glF;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.zkT;
    AppMethodBeat.o(100529);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100530);
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
        ac.i("MicroMsg.SnsCommentPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.zkU + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ac.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.zkU + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.zkU;
    AppMethodBeat.o(100530);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */