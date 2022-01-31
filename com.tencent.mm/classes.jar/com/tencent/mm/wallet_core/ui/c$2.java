package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.h.a.ck;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements View.OnClickListener
{
  c$2(c paramc) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.OfflinePopupWindow", "on click know");
    this.wCf.wCd.setVisibility(8);
    paramView = new ck();
    paramView.bIG.bIH = 1;
    a.udP.m(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.2
 * JD-Core Version:    0.7.0.1
 */