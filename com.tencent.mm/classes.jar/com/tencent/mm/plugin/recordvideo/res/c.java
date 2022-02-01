package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements bd
{
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(237202);
    e.BYn.init();
    f.BYo.init();
    d locald = d.BYj;
    d.init();
    g.BYp.init();
    AppMethodBeat.o(237202);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(237203);
    e.BYn.iUx.dead();
    f.BYo.iUx.dead();
    d locald = d.BYj;
    g.BYp.iUx.dead();
    AppMethodBeat.o(237203);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.c
 * JD-Core Version:    0.7.0.1
 */