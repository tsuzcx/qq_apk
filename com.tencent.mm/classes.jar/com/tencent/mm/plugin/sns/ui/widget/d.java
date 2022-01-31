package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private static d prp = new d();
  public int prl = 0;
  private com.tencent.mm.kiss.widget.textview.a.a prq = null;
  private com.tencent.mm.kiss.widget.textview.a.a prr = null;
  
  public static d bKB()
  {
    return prp;
  }
  
  public static float getTextSize()
  {
    return com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), (int)(16.0F * com.tencent.mm.cb.a.cJ(ae.getContext())));
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a bKC()
  {
    int i = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), (int)(16.0F * com.tencent.mm.cb.a.cJ(ae.getContext())));
    if ((this.prr == null) || ((int)this.prr.dOB != i))
    {
      b localb = b.EJ().hA(8388627).hB(ae.getContext().getResources().getColor(i.c.normal_text_color)).ab(i);
      localb.dOm.maxLines = 6;
      this.prr = localb.dOm;
    }
    return this.prr;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig()
  {
    int i = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), (int)(16.0F * com.tencent.mm.cb.a.cJ(ae.getContext())));
    if ((this.prq == null) || ((int)this.prq.dOB != i)) {
      this.prq = b.EJ().hA(8388627).hB(ae.getContext().getResources().getColor(i.c.normal_text_color)).ab(i).dOm;
    }
    return this.prq;
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
      this.prl = (i - k - j);
      y.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.prl + " padding: " + j + " marginLeft: " + k + " thisviewPadding: " + m);
    }
    return this.prl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */