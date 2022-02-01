package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class ac
  implements ax
{
  public static void dCm()
  {
    AppMethodBeat.i(122793);
    bj.Bp("qqmail");
    ((l)g.ab(l.class)).azv().aTx("qqmail");
    ((k)g.ad(k.class)).getNormalMailAppService().clearData();
    AppMethodBeat.o(122793);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(122792);
    if ((paramInt & 0x1) != 0) {
      dCm();
    }
    AppMethodBeat.o(122792);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean) {}
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ac
 * JD-Core Version:    0.7.0.1
 */