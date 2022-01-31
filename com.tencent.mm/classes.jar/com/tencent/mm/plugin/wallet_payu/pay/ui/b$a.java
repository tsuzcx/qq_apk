package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.a;

final class b$a
{
  public o.a qGg;
  public String qOm;
  public Bankcard qOn;
  public FavorPayInfo qOo;
  public boolean qOp;
  public b.b qOq;
  public DialogInterface.OnCancelListener qOr;
  
  public b$a(b paramb, String paramString, Bankcard paramBankcard, FavorPayInfo paramFavorPayInfo, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, o.a parama, b.b paramb1)
  {
    this.qOm = paramString;
    this.qOn = paramBankcard;
    this.qOo = paramFavorPayInfo;
    this.qOp = paramBoolean;
    this.qOr = paramOnCancelListener;
    this.qGg = parama;
    this.qOq = paramb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.b.a
 * JD-Core Version:    0.7.0.1
 */