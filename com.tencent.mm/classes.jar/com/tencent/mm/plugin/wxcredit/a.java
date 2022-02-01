package com.tencent.mm.plugin.wxcredit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements aw
{
  static
  {
    AppMethodBeat.i(72241);
    com.tencent.mm.wallet_core.a.i("WXCreditOpenProcess", e.class);
    com.tencent.mm.wallet_core.a.i("WXCreditManagerProcess", d.class);
    AppMethodBeat.o(72241);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a
 * JD-Core Version:    0.7.0.1
 */