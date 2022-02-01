package com.tencent.mm.y;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements bd
{
  private static c hmh;
  private a hmi;
  
  private c()
  {
    AppMethodBeat.i(150086);
    if (a.hlO == null) {
      a.hlO = new a();
    }
    this.hmi = a.hlO;
    AppMethodBeat.o(150086);
  }
  
  private static c axU()
  {
    try
    {
      AppMethodBeat.i(150087);
      if (hmh == null)
      {
        localc = new c();
        hmh = localc;
        localc.hmi.init();
      }
      c localc = hmh;
      AppMethodBeat.o(150087);
      return localc;
    }
    finally {}
  }
  
  public static a axV()
  {
    AppMethodBeat.i(150090);
    g.aAf().azk();
    a locala = axU().hmi;
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
    this.hmi.init();
    AppMethodBeat.o(150089);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(150088);
    a locala = this.hmi;
    locala.listeners.clear();
    b localb = locala.hlP;
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.hlX.clear();
    localb.hlZ.clear();
    localb.hlY.clear();
    localb.hma.clear();
    locala.initialized = false;
    AppMethodBeat.o(150088);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.y.c
 * JD-Core Version:    0.7.0.1
 */