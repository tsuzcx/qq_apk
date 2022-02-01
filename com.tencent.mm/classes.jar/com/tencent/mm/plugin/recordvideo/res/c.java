package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements az
{
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(206497);
    e.xXw.init();
    f.xXx.init();
    d locald = d.xXs;
    d.init();
    AppMethodBeat.o(206497);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(206498);
    e.xXw.hZz.dead();
    f.xXx.hZz.dead();
    d locald = d.xXs;
    d.unInit();
    AppMethodBeat.o(206498);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.c
 * JD-Core Version:    0.7.0.1
 */