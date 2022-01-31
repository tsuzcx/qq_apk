package com.tencent.mm.x;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;

public final class c
  implements at
{
  private static c eDt;
  private a eDu;
  
  private c()
  {
    AppMethodBeat.i(77749);
    if (a.eCZ == null) {
      a.eCZ = new a();
    }
    this.eDu = a.eCZ;
    AppMethodBeat.o(77749);
  }
  
  private static c PI()
  {
    try
    {
      AppMethodBeat.i(77750);
      if (eDt == null)
      {
        localc = new c();
        eDt = localc;
        localc.eDu.init();
      }
      c localc = eDt;
      AppMethodBeat.o(77750);
      return localc;
    }
    finally {}
  }
  
  public static a PJ()
  {
    AppMethodBeat.i(77753);
    g.RJ().QQ();
    a locala = PI().eDu;
    AppMethodBeat.o(77753);
    return locala;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(77752);
    this.eDu.init();
    AppMethodBeat.o(77752);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(77751);
    a locala = this.eDu;
    locala.eDb.clear();
    b localb = locala.eDa;
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
    localb.eDj.clear();
    localb.eDl.clear();
    localb.eDk.clear();
    localb.eDm.clear();
    locala.initialized = false;
    AppMethodBeat.o(77751);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.x.c
 * JD-Core Version:    0.7.0.1
 */