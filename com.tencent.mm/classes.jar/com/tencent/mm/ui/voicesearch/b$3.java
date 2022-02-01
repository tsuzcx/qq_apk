package com.tencent.mm.ui.voicesearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b$3
  implements Runnable
{
  b$3(b paramb, com.tencent.mm.an.q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(39534);
    Object localObject1 = ((com.tencent.mm.plugin.messenger.a.f)this.ftz).eRV();
    Log.d("MicroMsg.SearchResultAdapter", "count " + ((ebp)localObject1).Tdj);
    if (((ebp)localObject1).Tdj > 0)
    {
      localObject1 = ((ebp)localObject1).Tdk.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ebn)((Iterator)localObject1).next();
        if (ab.uL(((ebn)localObject2).TxF))
        {
          if (b.f(this.XZM) == null) {
            b.a(this.XZM, new LinkedList());
          }
          b.f(this.XZM).add(localObject2);
        }
      }
    }
    Object localObject2 = z.a(((ebp)localObject1).SrH);
    Log.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(localObject2)));
    if (Util.nullAsNil((String)localObject2).length() > 0)
    {
      ebn localebn = new ebn();
      localebn.SrH = ((ebp)localObject1).SrH;
      localebn.TxF = ((ebp)localObject1).TxF;
      localebn.mVB = ((ebp)localObject1).mVB;
      localebn.TtX = ((ebp)localObject1).TtX;
      localebn.mVD = ((ebp)localObject1).mVD;
      localebn.mVH = ((ebp)localObject1).mVH;
      localebn.mVA = ((ebp)localObject1).mVA;
      localebn.mVz = ((ebp)localObject1).mVz;
      localebn.mVy = ((ebp)localObject1).mVy;
      localebn.TxG = ((ebp)localObject1).TxG;
      localebn.TxJ = ((ebp)localObject1).TxJ;
      localebn.TxH = ((ebp)localObject1).TxH;
      localebn.TxI = ((ebp)localObject1).TxI;
      localebn.TxL = ((ebp)localObject1).TxL;
      com.tencent.mm.am.q.bhz().h((String)localObject2, z.a(((ebp)localObject1).RIH));
      if (b.f(this.XZM) == null) {
        b.a(this.XZM, new LinkedList());
      }
      b.f(this.XZM).clear();
      if (ab.uL(localebn.TxF)) {
        b.f(this.XZM).add(localebn);
      }
      Log.d("MicroMsg.SearchResultAdapter", "count " + b.f(this.XZM).size());
    }
    b.b(this.XZM, false);
    AppMethodBeat.o(39534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.3
 * JD-Core Version:    0.7.0.1
 */