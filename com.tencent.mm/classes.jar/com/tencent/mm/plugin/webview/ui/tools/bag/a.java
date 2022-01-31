package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.PointF;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  static final int vhf;
  boolean mIsShowing;
  int mScreenHeight;
  int mScreenWidth;
  a.a vhg;
  final a.b vhh;
  boolean vhi;
  PointF vhj;
  boolean vhk;
  boolean vhl;
  
  static
  {
    int i = b.vhv;
    vhf = i * i;
  }
  
  public a(a.b paramb)
  {
    AppMethodBeat.i(8145);
    this.vhj = new PointF();
    this.vhh = paramb;
    paramb = (WindowManager)ah.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.fv(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 85;
      localLayoutParams.width = b.vhw;
      localLayoutParams.height = b.vhw;
      localLayoutParams.x = 0;
      localLayoutParams.y = 0;
      this.vhg = new a.a(ah.getContext());
      try
      {
        this.vhg.setVisibility(8);
        paramb.addView(this.vhg, localLayoutParams);
        AppMethodBeat.o(8145);
        return;
      }
      catch (Exception paramb)
      {
        ab.e("MicroMsg.BagCancelController", "showCanceller add failed %s", new Object[] { paramb });
        AppMethodBeat.o(8145);
      }
    }
  }
  
  public final void dfa()
  {
    AppMethodBeat.i(8146);
    WindowManager localWindowManager = (WindowManager)ah.getContext().getSystemService("window");
    try
    {
      localWindowManager.removeView(this.vhg);
      AppMethodBeat.o(8146);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.BagCancelController", "whenBagUnAttach remove failed %s", new Object[] { localException });
      AppMethodBeat.o(8146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a
 * JD-Core Version:    0.7.0.1
 */