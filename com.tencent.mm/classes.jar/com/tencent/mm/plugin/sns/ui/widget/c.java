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
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  private static c Ffh;
  private com.tencent.mm.kiss.widget.textview.a.a Ffe = null;
  private int Fff = 0;
  
  static
  {
    AppMethodBeat.i(100505);
    Ffh = new c();
    AppMethodBeat.o(100505);
  }
  
  public static c flh()
  {
    return Ffh;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    AppMethodBeat.i(100503);
    int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)(15.0F * com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())));
    if ((this.Ffe == null) || ((int)this.Ffe.textSize != i)) {
      this.Ffe = b.aBq().as(i).ql(MMApplicationContext.getContext().getResources().getColor(2131101124)).qk(16).b(TextUtils.TruncateAt.END).huK;
    }
    com.tencent.mm.kiss.widget.textview.a.a locala = this.Ffe;
    AppMethodBeat.o(100503);
    return locala;
  }
  
  public final int getViewWidth()
  {
    AppMethodBeat.i(100504);
    if (this.Fff <= 0)
    {
      i = aj.ejr().x;
      int j = (int)(MMApplicationContext.getResources().getDimension(2131165534) + MMApplicationContext.getResources().getDimension(2131165534));
      int k = (int)MMApplicationContext.getResources().getDimension(2131166967);
      int m = (int)MMApplicationContext.getResources().getDimension(2131165534);
      this.Fff = (i - k - j - m);
      if (this.Fff <= 0)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        i = localDisplayMetrics.widthPixels;
        this.Fff = (i - k - j - m);
        Log.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "try again, screenWidth " + i + " textViewWidth " + this.Fff + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
      }
      Log.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "finally, screenWidth " + i + " textViewWidth " + this.Fff + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    int i = this.Fff;
    AppMethodBeat.o(100504);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */