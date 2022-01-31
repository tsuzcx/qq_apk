package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.PointF;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  static final int rra = b.rrq * b.rrq;
  boolean mIsShowing;
  int mScreenHeight;
  int mScreenWidth;
  a.a rrb;
  final a.b rrc;
  boolean rrd;
  PointF rre = new PointF();
  boolean rrf;
  boolean rrg;
  
  public a(a.b paramb)
  {
    this.rrc = paramb;
    paramb = (WindowManager)ae.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2002;
    localLayoutParams.format = 1;
    localLayoutParams.flags = 40;
    localLayoutParams.gravity = 85;
    localLayoutParams.width = b.rrr;
    localLayoutParams.height = b.rrr;
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    this.rrb = new a.a(ae.getContext());
    try
    {
      this.rrb.setVisibility(8);
      paramb.addView(this.rrb, localLayoutParams);
      return;
    }
    catch (Exception paramb)
    {
      y.e("MicroMsg.BagCancelController", "showCanceller add failed %s", new Object[] { paramb });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a
 * JD-Core Version:    0.7.0.1
 */