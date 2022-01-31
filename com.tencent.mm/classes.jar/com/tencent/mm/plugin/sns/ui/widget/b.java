package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  private static b prm = new b();
  private com.tencent.mm.kiss.widget.textview.a.a prk = null;
  public int prl = 0;
  
  public static b bKA()
  {
    return prm;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    int i = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), (int)(15.0F * com.tencent.mm.cb.a.cJ(ae.getContext())));
    if ((this.prk == null) || ((int)this.prk.dOB != i)) {
      this.prk = com.tencent.mm.kiss.widget.textview.a.b.EJ().ab(i).hB(ae.getContext().getResources().getColor(i.c.sns_comment_color)).hA(16).dOm;
    }
    return this.prk;
  }
  
  public final int getViewWidth()
  {
    if (this.prl <= 0)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      int j = (int)(ae.getResources().getDimension(i.d.NormalPadding) + ae.getResources().getDimension(i.d.NormalPadding));
      int k = (int)ae.getResources().getDimension(i.d.sns_timeilne_margin_left);
      int m = (int)ae.getResources().getDimension(i.d.NormalPadding);
      this.prl = (i - k - j - m);
      y.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.prl + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    return this.prl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */