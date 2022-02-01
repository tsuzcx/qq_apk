package com.tencent.mm.y;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements az
{
  private static c gzu;
  private a gzv;
  
  private c()
  {
    AppMethodBeat.i(150086);
    if (a.gzb == null) {
      a.gzb = new a();
    }
    this.gzv = a.gzb;
    AppMethodBeat.o(150086);
  }
  
  private static c ahH()
  {
    try
    {
      AppMethodBeat.i(150087);
      if (gzu == null)
      {
        localc = new c();
        gzu = localc;
        localc.gzv.init();
      }
      c localc = gzu;
      AppMethodBeat.o(150087);
      return localc;
    }
    finally {}
  }
  
  public static a ahI()
  {
    AppMethodBeat.i(150090);
    g.ajP().aiU();
    a locala = ahH().gzv;
    AppMethodBeat.o(150090);
    return locala;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150089);
    this.gzv.init();
    AppMethodBeat.o(150089);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(150088);
    a locala = this.gzv;
    locala.listeners.clear();
    b localb = locala.gzc;
    ae.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.gzk.clear();
    localb.gzm.clear();
    localb.gzl.clear();
    localb.gzn.clear();
    locala.initialized = false;
    AppMethodBeat.o(150088);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.y.c
 * JD-Core Version:    0.7.0.1
 */