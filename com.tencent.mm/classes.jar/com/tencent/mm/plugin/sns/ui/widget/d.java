package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class d
{
  private static d AUM;
  private com.tencent.mm.kiss.widget.textview.a.a AUy = null;
  public int AUz = 0;
  
  static
  {
    AppMethodBeat.i(100531);
    AUM = new d();
    AppMethodBeat.o(100531);
  }
  
  public static d eiI()
  {
    return AUM;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100529);
    int i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)(15.0F * com.tencent.mm.cb.a.ef(ak.getContext())));
    if ((this.AUy == null) || ((int)this.AUy.textSize != i)) {
      this.AUy = b.akZ().aj(i).mX(ak.getContext().getResources().getColor(2131100907)).mW(16).gHW;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.AUy;
    AppMethodBeat.o(100529);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100530);
    if (this.AUz <= 0)
    {
      i = ah.dpC().x;
      int j = (int)(ak.getResources().getDimension(2131165516) + ak.getResources().getDimension(2131165516));
      int k = (int)ak.getResources().getDimension(2131166840);
      int m = (int)ak.getResources().getDimension(2131165516);
      this.AUz = (i - k - j - m);
      if (this.AUz <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.AUz = (i - k - j - m);
        ae.i("MicroMsg.SnsCommentPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.AUz + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ae.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.AUz + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.AUz;
    AppMethodBeat.o(100530);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */