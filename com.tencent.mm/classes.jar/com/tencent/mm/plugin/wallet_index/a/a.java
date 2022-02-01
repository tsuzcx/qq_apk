package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wallet_index.c.n;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements aw
{
  private n AwU;
  
  public a()
  {
    AppMethodBeat.i(71797);
    this.AwU = new n();
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
    com.tencent.mm.sdk.b.a.ESL.c(this.AwU.Axp);
    com.tencent.mm.sdk.b.a.ESL.c(this.AwU.Axq);
    AppMethodBeat.o(71798);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71799);
    com.tencent.mm.sdk.b.a.ESL.d(this.AwU.Axp);
    com.tencent.mm.sdk.b.a.ESL.d(this.AwU.Axq);
    AppMethodBeat.o(71799);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.a.a
 * JD-Core Version:    0.7.0.1
 */