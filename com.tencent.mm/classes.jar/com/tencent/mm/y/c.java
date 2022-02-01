package com.tencent.mm.y;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements aw
{
  private static c gdd;
  private a gde;
  
  private c()
  {
    AppMethodBeat.i(150086);
    if (a.gcK == null) {
      a.gcK = new a();
    }
    this.gde = a.gcK;
    AppMethodBeat.o(150086);
  }
  
  private static c aeG()
  {
    try
    {
      AppMethodBeat.i(150087);
      if (gdd == null)
      {
        localc = new c();
        gdd = localc;
        localc.gde.init();
      }
      c localc = gdd;
      AppMethodBeat.o(150087);
      return localc;
    }
    finally {}
  }
  
  public static a aeH()
  {
    AppMethodBeat.i(150090);
    g.agP().afT();
    a locala = aeG().gde;
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
    this.gde.init();
    AppMethodBeat.o(150089);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(150088);
    a locala = this.gde;
    locala.listeners.clear();
    b localb = locala.gcL;
    ac.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.gcT.clear();
    localb.gcV.clear();
    localb.gcU.clear();
    localb.gcW.clear();
    locala.initialized = false;
    AppMethodBeat.o(150088);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.y.c
 * JD-Core Version:    0.7.0.1
 */