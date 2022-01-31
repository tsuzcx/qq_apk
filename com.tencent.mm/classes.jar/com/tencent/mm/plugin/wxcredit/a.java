package com.tencent.mm.plugin.wxcredit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import java.util.HashMap;

public class a
  implements at
{
  static
  {
    AppMethodBeat.i(48599);
    com.tencent.mm.wallet_core.a.h("WXCreditOpenProcess", e.class);
    com.tencent.mm.wallet_core.a.h("WXCreditManagerProcess", d.class);
    AppMethodBeat.o(48599);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a
 * JD-Core Version:    0.7.0.1
 */