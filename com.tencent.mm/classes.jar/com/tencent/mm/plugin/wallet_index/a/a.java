package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.wallet_index.c.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements bd
{
  private o Iqz;
  
  public a()
  {
    AppMethodBeat.i(71797);
    this.Iqz = new o();
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
    EventCenter.instance.addListener(this.Iqz.IqX);
    EventCenter.instance.addListener(this.Iqz.IqY);
    AppMethodBeat.o(71798);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71799);
    EventCenter.instance.removeListener(this.Iqz.IqX);
    EventCenter.instance.removeListener(this.Iqz.IqY);
    AppMethodBeat.o(71799);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.a.a
 * JD-Core Version:    0.7.0.1
 */