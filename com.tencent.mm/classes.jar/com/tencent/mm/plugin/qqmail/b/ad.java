package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class ad
  implements aw
{
  public static void deg()
  {
    AppMethodBeat.i(122793);
    bi.uk("qqmail");
    ((k)g.ab(k.class)).apR().aIl("qqmail");
    ((o)g.ad(o.class)).getNormalMailAppService().clearData();
    AppMethodBeat.o(122793);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(122792);
    if ((paramInt & 0x1) != 0) {
      deg();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ad
 * JD-Core Version:    0.7.0.1
 */