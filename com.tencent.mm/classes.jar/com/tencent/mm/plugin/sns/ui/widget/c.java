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
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  private static c LtM;
  private com.tencent.mm.kiss.widget.textview.a.a LtJ = null;
  private int LtK = 0;
  
  static
  {
    AppMethodBeat.i(100505);
    LtM = new c();
    AppMethodBeat.o(100505);
  }
  
  public static c fZA()
  {
    return LtM;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100503);
    int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)(15.0F * com.tencent.mm.ci.a.ez(MMApplicationContext.getContext())));
    if ((this.LtJ == null) || ((int)this.LtJ.textSize != i)) {
      this.LtJ = b.aIT().as(i).sL(MMApplicationContext.getContext().getResources().getColor(i.c.sns_comment_color)).sK(16).b(TextUtils.TruncateAt.END).kgG;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.LtJ;
    AppMethodBeat.o(100503);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100504);
    if (this.LtK <= 0)
    {
      i = aj.eSY().x;
      int j = (int)(MMApplicationContext.getResources().getDimension(i.d.NormalPadding) + MMApplicationContext.getResources().getDimension(i.d.NormalPadding));
      int k = (int)MMApplicationContext.getResources().getDimension(i.d.sns_timeilne_margin_left);
      int m = (int)MMApplicationContext.getResources().getDimension(i.d.NormalPadding);
      this.LtK = (i - k - j - m);
      if (this.LtK <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.LtK = (i - k - j - m);
        Log.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.LtK + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      Log.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.LtK + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.LtK;
    AppMethodBeat.o(100504);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */