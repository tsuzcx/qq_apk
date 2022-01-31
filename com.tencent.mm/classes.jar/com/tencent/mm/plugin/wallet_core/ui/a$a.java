package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet.a.h;

public final class a$a
{
  public String mOX;
  public h qAa;
  public double qAb;
  public String qAc;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.qAa != null) {
      localStringBuffer.append("|faovrComposeId: " + this.qAa.qlk);
    }
    localStringBuffer.append("|bankName: " + this.mOX);
    localStringBuffer.append("|bankFavorAmount: " + this.qAb);
    localStringBuffer.append("|bankType: " + this.qAc);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a.a
 * JD-Core Version:    0.7.0.1
 */