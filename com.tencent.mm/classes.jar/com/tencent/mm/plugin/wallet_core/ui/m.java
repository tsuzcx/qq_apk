package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
{
  private m.a qFl;
  
  public m(m.a parama)
  {
    this(parama, (byte)0);
  }
  
  private m(m.a parama, byte paramByte)
  {
    super(2, null);
    this.qFl = parama;
  }
  
  protected final void AX(int paramInt)
  {
    Context localContext = ae.getContext();
    super.AX(paramInt);
    if (paramInt == 5) {
      eY(localContext.getResources().getColor(a.c.white), localContext.getResources().getColor(a.c.sns_link_bg_color));
    }
  }
  
  public final void onClick(View paramView)
  {
    if (this.qFl != null) {
      this.qFl.aEP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m
 * JD-Core Version:    0.7.0.1
 */