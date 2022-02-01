package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements be
{
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(279659);
    e.NRR.init();
    f.NRS.init();
    d locald = d.NRK;
    d.init();
    g.NRT.init();
    AppMethodBeat.o(279659);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(279670);
    e.NRR.oDs.dead();
    f.NRS.oDs.dead();
    d locald = d.NRK;
    g.NRT.oDs.dead();
    AppMethodBeat.o(279670);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.c
 * JD-Core Version:    0.7.0.1
 */