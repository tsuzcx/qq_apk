package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.by;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class ab
  implements be
{
  public static void gEe()
  {
    AppMethodBeat.i(122793);
    br.JO("qqmail");
    ((n)h.ax(n.class)).bzG().bxK("qqmail");
    ((j)h.az(j.class)).getNormalMailAppService().clearData();
    AppMethodBeat.o(122793);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(122792);
    if ((paramInt & 0x1) != 0) {
      gEe();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ab
 * JD-Core Version:    0.7.0.1
 */