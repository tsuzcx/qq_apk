package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.PointF;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.c;

public final class a
{
  static final int EeS;
  a.a EeT;
  final b EeU;
  boolean EeV;
  PointF EeW;
  boolean EeX;
  boolean EeY;
  boolean mIsShowing;
  int mScreenHeight;
  int mScreenWidth;
  
  static
  {
    int i = b.Efg;
    EeS = i * i;
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(80412);
    this.EeW = new PointF();
    this.EeU = paramb;
    paramb = (WindowManager)aj.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.ly(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 85;
      localLayoutParams.width = b.Efh;
      localLayoutParams.height = b.Efh;
      localLayoutParams.x = 0;
      localLayoutParams.y = 0;
      this.EeT = new a.a(aj.getContext());
      try
      {
        this.EeT.setVisibility(8);
        paramb.addView(this.EeT, localLayoutParams);
        AppMethodBeat.o(80412);
        return;
      }
      catch (Exception paramb)
      {
        ad.e("MicroMsg.BagCancelController", "showCanceller add failed %s", new Object[] { paramb });
        AppMethodBeat.o(80412);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void eTA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a
 * JD-Core Version:    0.7.0.1
 */