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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class f
{
  private static f xYs;
  private static final int xYv;
  public int xXY = 0;
  private com.tencent.mm.kiss.widget.textview.a.a xYt = null;
  private com.tencent.mm.kiss.widget.textview.a.a xYu = null;
  
  static
  {
    AppMethodBeat.i(100557);
    xYs = new f();
    xYv = com.tencent.mm.cd.a.ap(aj.getContext(), 2131165200);
    AppMethodBeat.o(100557);
  }
  
  public static f dEn()
  {
    return xYs;
  }
  
  public static float getTextSize()
  {
    AppMethodBeat.i(100556);
    float f = (int)(xYv * com.tencent.mm.cd.a.dT(aj.getContext()));
    AppMethodBeat.o(100556);
    return f;
  }
  
  public static void resetConfig()
  {
    f localf = xYs;
    localf.xYt = null;
    localf.xYu = null;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a dEo()
  {
    AppMethodBeat.i(100554);
    int i = (int)(xYv * com.tencent.mm.cd.a.dT(aj.getContext()));
    this.xYu = b.agI().mv(8388627).mw(aj.getContext().getResources().getColor(2131100711)).ac(i).agJ().ggZ;
    com.tencent.mm.kiss.widget.textview.a.a locala = this.xYu;
    AppMethodBeat.o(100554);
    return locala;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100553);
    int i = (int)(xYv * com.tencent.mm.cd.a.dT(aj.getContext()));
    if ((this.xYt == null) || ((int)this.xYt.textSize != i)) {
      this.xYt = b.agI().mv(8388627).mw(aj.getContext().getResources().getColor(2131100711)).ac(i).ggZ;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.xYt;
    AppMethodBeat.o(100553);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100555);
    if (this.xXY <= 0)
    {
      i = af.cPz().x;
      int j = (int)(aj.getResources().getDimension(2131165516) + aj.getResources().getDimension(2131165516));
      int k = (int)aj.getResources().getDimension(2131166840);
      int m = (int)aj.getResources().getDimension(2131165516);
      this.xXY = (i - k - j);
      if (this.xXY <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.xXY = (i - k - j);
        ad.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.xXY + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      ad.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.xXY + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.xXY;
    AppMethodBeat.o(100555);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */