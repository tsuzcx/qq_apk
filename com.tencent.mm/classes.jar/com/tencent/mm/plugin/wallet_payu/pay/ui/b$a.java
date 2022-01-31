package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.q.a;

final class b$a
{
  public String uDt;
  public Bankcard uDu;
  public FavorPayInfo uDv;
  public boolean uDw;
  public b.b uDx;
  public DialogInterface.OnCancelListener uDy;
  public q.a utl;
  
  public b$a(b paramb, String paramString, Bankcard paramBankcard, FavorPayInfo paramFavorPayInfo, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, q.a parama, b.b paramb1)
  {
    this.uDt = paramString;
    this.uDu = paramBankcard;
    this.uDv = paramFavorPayInfo;
    this.uDw = paramBoolean;
    this.uDy = paramOnCancelListener;
    this.utl = parama;
    this.uDx = paramb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.b.a
 * JD-Core Version:    0.7.0.1
 */