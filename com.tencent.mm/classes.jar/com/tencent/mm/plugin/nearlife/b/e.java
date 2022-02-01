package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class e
  implements bd
{
  private com.tencent.mm.pluginsdk.location.a AAX;
  
  public e()
  {
    AppMethodBeat.i(163198);
    this.AAX = new a();
    AppMethodBeat.o(163198);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26559);
    Log.i("MicroMsg.SubCoreNearLife", "onAccountPostReset SubCoreNearLife");
    g.b(com.tencent.mm.plugin.story.api.a.class, new com.tencent.mm.plugin.story.api.a() {});
    g.b(com.tencent.mm.pluginsdk.location.a.class, this.AAX);
    AppMethodBeat.o(26559);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.e
 * JD-Core Version:    0.7.0.1
 */