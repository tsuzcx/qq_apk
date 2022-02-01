package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class ac
  implements bd
{
  public static void eGs()
  {
    AppMethodBeat.i(122793);
    bp.Kx("qqmail");
    ((l)g.af(l.class)).aST().bjW("qqmail");
    ((k)g.ah(k.class)).getNormalMailAppService().clearData();
    AppMethodBeat.o(122793);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(122792);
    if ((paramInt & 0x1) != 0) {
      eGs();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ac
 * JD-Core Version:    0.7.0.1
 */