package com.tencent.mm.plugin.qqmail.b;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import java.io.IOException;
import java.util.LinkedList;

public final class z
{
  public y vVe;
  
  public z()
  {
    AppMethodBeat.i(122760);
    String str = (String)g.agR().agA().get(282625, "");
    try
    {
      this.vVe = new y();
      this.vVe.parseFrom(Base64.decode(str, 0));
      AppMethodBeat.o(122760);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localException, "", new Object[0]);
      ac.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
      this.vVe = new y();
      AppMethodBeat.o(122760);
    }
  }
  
  public static void apY(String paramString)
  {
    AppMethodBeat.i(122762);
    bo localbo = new bo();
    localbo.re("qqmail");
    localbo.oA(bi.yp("qqmail"));
    localbo.jT(0);
    localbo.setContent(String.format(ai.getContext().getString(2131763061), new Object[] { paramString }));
    localbo.setType(1);
    localbo.setStatus(3);
    ac.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((k)g.ab(k.class)).dcr().ap(localbo)) });
    AppMethodBeat.o(122762);
  }
  
  public final void apX(String paramString)
  {
    AppMethodBeat.i(122761);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
      AppMethodBeat.o(122761);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < this.vVe.uEi.size())
      {
        if (((x)this.vVe.uEi.get(i)).vTY.equals(paramString)) {
          this.vVe.uEi.remove(i);
        }
      }
      else
      {
        save();
        AppMethodBeat.o(122761);
        return;
      }
      i += 1;
    }
  }
  
  public final void save()
  {
    AppMethodBeat.i(122763);
    try
    {
      String str = Base64.encodeToString(this.vVe.toByteArray(), 0);
      ac.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { str });
      g.agR().agA().set(282625, str);
      AppMethodBeat.o(122763);
      return;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localIOException, "", new Object[0]);
      ac.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
      AppMethodBeat.o(122763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.z
 * JD-Core Version:    0.7.0.1
 */