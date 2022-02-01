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
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  private static c ADa;
  private com.tencent.mm.kiss.widget.textview.a.a ACX = null;
  private int ACY = 0;
  
  static
  {
    AppMethodBeat.i(100505);
    ADa = new c();
    AppMethodBeat.o(100505);
  }
  
  public static c efa()
  {
    return ADa;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100503);
    int i = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), (int)(15.0F * com.tencent.mm.cc.a.eb(aj.getContext())));
    if ((this.ACX == null) || ((int)this.ACX.textSize != i)) {
      this.ACX = b.akK().aj(i).mU(aj.getContext().getResources().getColor(2131100907)).mT(16).a(TextUtils.TruncateAt.END).gFp;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.ACX;
    AppMethodBeat.o(100503);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100504);
    if (this.ACY <= 0)
    {
      i = ag.dmE().x;
      int j = (int)(aj.getResources().getDimension(2131165516) + aj.getResources().getDimension(2131165516));
      int k = (int)aj.getResources().getDimension(2131166840);
      int m = (int)aj.getResources().getDimension(2131165516);
      this.ACY = (i - k - j - m);
      if (this.ACY <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.ACY = (i - k - j - m);
        ad.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.ACY + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ad.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.ACY + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.ACY;
    AppMethodBeat.o(100504);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */