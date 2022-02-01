package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.wallet_index.model.WalletGetA8KeyRedirectListener;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements be
{
  private WalletGetA8KeyRedirectListener VZW;
  
  public a()
  {
    AppMethodBeat.i(71797);
    this.VZW = new WalletGetA8KeyRedirectListener();
    AppMethodBeat.o(71797);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(71798);
    this.VZW.Way.alive();
    this.VZW.Waz.alive();
    AppMethodBeat.o(71798);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71799);
    this.VZW.Way.dead();
    this.VZW.Waz.dead();
    AppMethodBeat.o(71799);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.a.a
 * JD-Core Version:    0.7.0.1
 */