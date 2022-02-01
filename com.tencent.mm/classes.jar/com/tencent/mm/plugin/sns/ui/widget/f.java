package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f
{
  private static f FfF;
  private static final int FfI;
  private com.tencent.mm.kiss.widget.textview.a.a FfG = null;
  private com.tencent.mm.kiss.widget.textview.a.a FfH = null;
  public int Fff = 0;
  
  static
  {
    AppMethodBeat.i(100557);
    FfF = new f();
    FfI = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131165203);
    AppMethodBeat.o(100557);
  }
  
  public static f fll()
  {
    return FfF;
  }
  
  public static float getTextSize()
  {
    AppMethodBeat.i(100556);
    float f = (int)(FfI * com.tencent.mm.cb.a.ez(MMApplicationContext.getContext()));
    AppMethodBeat.o(100556);
    return f;
  }
  
  public static void resetConfig()
  {
    f localf = FfF;
    localf.FfG = null;
    localf.FfH = null;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a flm()
  {
    AppMethodBeat.i(100554);
    int i = (int)(FfI * com.tencent.mm.cb.a.ez(MMApplicationContext.getContext()));
    if (Build.VERSION.SDK_INT == 28) {}
    for (this.FfH = b.aBq().qk(8388627).ql(MMApplicationContext.getContext().getResources().getColor(2131100904)).as(i).aBr().aBs().huK;; this.FfH = b.aBq().qk(8388627).ql(MMApplicationContext.getContext().getResources().getColor(2131100904)).as(i).aBr().huK)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.FfH;
      AppMethodBeat.o(100554);
      return locala;
    }
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100553);
    int i = (int)(FfI * com.tencent.mm.cb.a.ez(MMApplicationContext.getContext()));
    if ((this.FfG == null) || ((int)this.FfG.textSize != i)) {
      if (Build.VERSION.SDK_INT != 28) {
        break label94;
      }
    }
    label94:
    for (this.FfG = b.aBq().qk(8388627).ql(MMApplicationContext.getContext().getResources().getColor(2131100904)).as(i).aBs().huK;; this.FfG = b.aBq().qk(8388627).ql(MMApplicationContext.getContext().getResources().getColor(2131100904)).as(i).huK)
    {
      com.tencent.mm.kiss.widget.textview.a.a locala = this.FfG;
      AppMethodBeat.o(100553);
      return locala;
    }
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100555);
    if (this.Fff <= 0)
    {
      i = aj.ejr().x;
      int j = (int)(MMApplicationContext.getResources().getDimension(2131165534) + MMApplicationContext.getResources().getDimension(2131165534));
      int k = (int)MMApplicationContext.getResources().getDimension(2131166967);
      int m = (int)MMApplicationContext.getResources().getDimension(2131165534);
      this.Fff = (i - k - j);
      if (this.Fff <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.Fff = (i - k - j);
        Log.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.Fff + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      Log.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.Fff + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.Fff;
    AppMethodBeat.o(100555);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */