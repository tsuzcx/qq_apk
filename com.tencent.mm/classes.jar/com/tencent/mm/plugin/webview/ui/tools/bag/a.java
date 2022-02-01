package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.PointF;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.c;

public final class a
{
  static final int EwV;
  a.a EwW;
  final b EwX;
  boolean EwY;
  PointF EwZ;
  boolean Exa;
  boolean Exb;
  boolean mIsShowing;
  int mScreenHeight;
  int mScreenWidth;
  
  static
  {
    int i = b.Exj;
    EwV = i * i;
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(80412);
    this.EwZ = new PointF();
    this.EwX = paramb;
    paramb = (WindowManager)ak.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.lA(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 85;
      localLayoutParams.width = b.Exk;
      localLayoutParams.height = b.Exk;
      localLayoutParams.x = 0;
      localLayoutParams.y = 0;
      this.EwW = new a.a(ak.getContext());
      try
      {
        this.EwW.setVisibility(8);
        paramb.addView(this.EwW, localLayoutParams);
        AppMethodBeat.o(80412);
        return;
      }
      catch (Exception paramb)
      {
        ae.e("MicroMsg.BagCancelController", "showCanceller add failed %s", new Object[] { paramb });
        AppMethodBeat.o(80412);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void eXn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a
 * JD-Core Version:    0.7.0.1
 */