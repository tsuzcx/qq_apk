package com.tencent.mm.plugin.scanner.scan_goods_new.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
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
    AppMethodBeat.i(313971);
    a.OWG.init();
    AppMethodBeat.o(313971);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(313986);
    a locala = a.OWG;
    Log.e("MicroMsg.ScanProductModelResLogic", "unInit");
    a.oDs.dead();
    a.aNm();
    AppMethodBeat.o(313986);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.res.c
 * JD-Core Version:    0.7.0.1
 */