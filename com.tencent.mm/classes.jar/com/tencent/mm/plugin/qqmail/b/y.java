package com.tencent.mm.plugin.qqmail.b;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.LinkedList;

public final class y
{
  x pJV;
  
  public y()
  {
    AppMethodBeat.i(68027);
    String str = (String)g.RL().Ru().get(282625, "");
    try
    {
      this.pJV = new x();
      this.pJV.parseFrom(Base64.decode(str, 0));
      AppMethodBeat.o(68027);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localException, "", new Object[0]);
      ab.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
      this.pJV = new x();
      AppMethodBeat.o(68027);
    }
  }
  
  static void Xw(String paramString)
  {
    AppMethodBeat.i(68029);
    bi localbi = new bi();
    localbi.kj("qqmail");
    localbi.fQ(bf.py("qqmail"));
    localbi.hL(0);
    localbi.setContent(String.format(ah.getContext().getString(2131303112), new Object[] { paramString }));
    localbi.setType(1);
    localbi.setStatus(3);
    ab.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((j)g.E(j.class)).bPQ().Z(localbi)) });
    AppMethodBeat.o(68029);
  }
  
  public final void Xv(String paramString)
  {
    AppMethodBeat.i(68028);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
      AppMethodBeat.o(68028);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < this.pJV.oBk.size())
      {
        if (((w)this.pJV.oBk.get(i)).pIO.equals(paramString)) {
          this.pJV.oBk.remove(i);
        }
      }
      else
      {
        save();
        AppMethodBeat.o(68028);
        return;
      }
      i += 1;
    }
  }
  
  final void save()
  {
    AppMethodBeat.i(68030);
    try
    {
      String str = Base64.encodeToString(this.pJV.toByteArray(), 0);
      ab.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { str });
      g.RL().Ru().set(282625, str);
      AppMethodBeat.o(68030);
      return;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localIOException, "", new Object[0]);
      ab.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
      AppMethodBeat.o(68030);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.y
 * JD-Core Version:    0.7.0.1
 */