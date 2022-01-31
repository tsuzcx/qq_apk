package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import java.util.HashMap;
import java.util.Map;

public final class z
{
  public static int tNf = 123;
  public static int tNg = 456;
  public int accountType;
  public String cnJ;
  public b gnD;
  private x tNh;
  public y tNi;
  public WalletLqtSaveFetchUI tNj;
  public String tNk;
  public int tNl;
  public int tNm;
  public String tNn;
  public Bankcard tNo;
  public Map<String, String> tNp;
  
  public z()
  {
    AppMethodBeat.i(45318);
    this.tNh = null;
    this.tNi = null;
    this.tNj = null;
    this.tNp = new HashMap();
    AppMethodBeat.o(45318);
  }
  
  public z(x paramx, y paramy, WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI)
  {
    AppMethodBeat.i(45319);
    this.tNh = null;
    this.tNi = null;
    this.tNj = null;
    this.tNp = new HashMap();
    this.tNh = paramx;
    this.tNi = paramy;
    this.tNj = paramWalletLqtSaveFetchUI;
    AppMethodBeat.o(45319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.z
 * JD-Core Version:    0.7.0.1
 */