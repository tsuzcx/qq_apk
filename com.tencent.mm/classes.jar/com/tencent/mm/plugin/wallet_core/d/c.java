package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BankcardScene;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends j<BankcardScene>
{
  public static final String[] SQL_CREATE;
  public e db;
  private List<Object> listeners;
  
  static
  {
    AppMethodBeat.i(70599);
    SQL_CREATE = new String[] { j.getCreateSQLs(BankcardScene.info, "WalletBankcardScene") };
    AppMethodBeat.o(70599);
  }
  
  public c(e parame)
  {
    super(parame, BankcardScene.info, "WalletBankcardScene", null);
    AppMethodBeat.i(70591);
    this.listeners = new LinkedList();
    this.db = parame;
    AppMethodBeat.o(70591);
  }
  
  public final boolean TK(int paramInt)
  {
    AppMethodBeat.i(70595);
    String str = "delete from WalletBankcardScene where scene=".concat(String.valueOf(paramInt));
    boolean bool = this.db.execSQL("WalletBankcardScene", str);
    AppMethodBeat.o(70595);
    return bool;
  }
  
  public final boolean a(BankcardScene paramBankcardScene)
  {
    AppMethodBeat.i(70593);
    if (super.insert(paramBankcardScene))
    {
      paramBankcardScene = this.listeners.iterator();
      while (paramBankcardScene.hasNext()) {
        paramBankcardScene.next();
      }
      AppMethodBeat.o(70593);
      return true;
    }
    AppMethodBeat.o(70593);
    return false;
  }
  
  public final boolean aPx()
  {
    AppMethodBeat.i(70594);
    boolean bool = this.db.execSQL("WalletBankcardScene", "delete from WalletBankcardScene");
    AppMethodBeat.o(70594);
    return bool;
  }
  
  public final boolean gz(List<BankcardScene> paramList)
  {
    AppMethodBeat.i(70592);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      super.insert((BankcardScene)paramList.next());
    }
    paramList = this.listeners.iterator();
    while (paramList.hasNext()) {
      paramList.next();
    }
    AppMethodBeat.o(70592);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */