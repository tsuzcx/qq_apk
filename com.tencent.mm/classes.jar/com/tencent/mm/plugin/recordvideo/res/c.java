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
    AppMethodBeat.i(218359);
    e.HVb.init();
    f.HVc.init();
    d locald = d.HUX;
    d.init();
    g.HVd.init();
    AppMethodBeat.o(218359);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(218366);
    e.HVb.lKQ.dead();
    f.HVc.lKQ.dead();
    d locald = d.HUX;
    g.HVd.lKQ.dead();
    AppMethodBeat.o(218366);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.c
 * JD-Core Version:    0.7.0.1
 */