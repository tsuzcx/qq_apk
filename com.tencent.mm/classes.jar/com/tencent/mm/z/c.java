package com.tencent.mm.z;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements aw
{
  private static c fYx;
  private a fYy;
  
  private c()
  {
    AppMethodBeat.i(150086);
    if (a.fYd == null) {
      a.fYd = new a();
    }
    this.fYy = a.fYd;
    AppMethodBeat.o(150086);
  }
  
  private static c adq()
  {
    try
    {
      AppMethodBeat.i(150087);
      if (fYx == null)
      {
        localc = new c();
        fYx = localc;
        localc.fYy.init();
      }
      c localc = fYx;
      AppMethodBeat.o(150087);
      return localc;
    }
    finally {}
  }
  
  public static a adr()
  {
    AppMethodBeat.i(150090);
    g.afz().aeD();
    a locala = adq().fYy;
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
    this.fYy.init();
    AppMethodBeat.o(150089);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(150088);
    a locala = this.fYy;
    locala.fYf.clear();
    b localb = locala.fYe;
    ad.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.fYn.clear();
    localb.fYp.clear();
    localb.fYo.clear();
    localb.fYq.clear();
    locala.initialized = false;
    AppMethodBeat.o(150088);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.z.c
 * JD-Core Version:    0.7.0.1
 */