package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.R.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.aq;

public final class b
{
  public static int rri = ;
  public static final int rrj = aq.gA(ae.getContext());
  public static final int rrk = ae.getContext().getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
  public static final int rrl = ae.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_size);
  public static final int rrm = ae.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_margin);
  public static final int rrn = ae.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_indicator_size);
  public static final int rro;
  public static final float rrp;
  public static final int rrq;
  public static final int rrr;
  public static final float rrs;
  
  static
  {
    int i = ae.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_indicator_container_size);
    rro = i;
    rrp = i / rrn;
    rrq = ae.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_canceller_size);
    i = ae.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_canceller_container_size);
    rrr = i;
    rrs = i / rrq;
  }
  
  private static int ceT()
  {
    boolean bool = aq.gw(ae.getContext());
    if (bool) {}
    for (int i = aq.gv(ae.getContext());; i = 0)
    {
      y.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight show:%b height:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      return i;
    }
  }
  
  public static void ceU()
  {
    rri = ceT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */