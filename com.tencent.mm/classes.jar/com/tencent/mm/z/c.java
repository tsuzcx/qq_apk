package com.tencent.mm.z;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements ax
{
  private static c gwN;
  private a gwO;
  
  private c()
  {
    AppMethodBeat.i(150086);
    if (a.gwu == null) {
      a.gwu = new a();
    }
    this.gwO = a.gwu;
    AppMethodBeat.o(150086);
  }
  
  private static c ahs()
  {
    try
    {
      AppMethodBeat.i(150087);
      if (gwN == null)
      {
        localc = new c();
        gwN = localc;
        localc.gwO.init();
      }
      c localc = gwN;
      AppMethodBeat.o(150087);
      return localc;
    }
    finally {}
  }
  
  public static a aht()
  {
    AppMethodBeat.i(150090);
    g.ajA().aiF();
    a locala = ahs().gwO;
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
    this.gwO.init();
    AppMethodBeat.o(150089);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(150088);
    a locala = this.gwO;
    locala.listeners.clear();
    b localb = locala.gwv;
    ad.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.gwD.clear();
    localb.gwF.clear();
    localb.gwE.clear();
    localb.gwG.clear();
    locala.initialized = false;
    AppMethodBeat.o(150088);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.z.c
 * JD-Core Version:    0.7.0.1
 */