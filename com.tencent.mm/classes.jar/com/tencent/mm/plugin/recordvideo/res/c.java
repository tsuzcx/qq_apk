package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements ax
{
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(200236);
    e.xHB.init();
    f.xHC.init();
    d locald = d.xHx;
    d.init();
    AppMethodBeat.o(200236);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(200237);
    e.xHB.hWH.dead();
    f.xHC.hWH.dead();
    d locald = d.xHx;
    d.unInit();
    AppMethodBeat.o(200237);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.c
 * JD-Core Version:    0.7.0.1
 */