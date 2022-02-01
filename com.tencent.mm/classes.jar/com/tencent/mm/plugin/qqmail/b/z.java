package com.tencent.mm.plugin.qqmail.b;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import java.io.IOException;
import java.util.LinkedList;

public final class z
{
  public y uMo;
  
  public z()
  {
    AppMethodBeat.i(122760);
    String str = (String)g.afB().afk().get(282625, "");
    try
    {
      this.uMo = new y();
      this.uMo.parseFrom(Base64.decode(str, 0));
      AppMethodBeat.o(122760);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localException, "", new Object[0]);
      ad.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
      this.uMo = new y();
      AppMethodBeat.o(122760);
    }
  }
  
  public static void akZ(String paramString)
  {
    AppMethodBeat.i(122762);
    bl localbl = new bl();
    localbl.nY("qqmail");
    localbl.kY(bi.uj("qqmail"));
    localbl.jV(0);
    localbl.setContent(String.format(aj.getContext().getString(2131763061), new Object[] { paramString }));
    localbl.setType(1);
    localbl.setStatus(3);
    ad.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((k)g.ab(k.class)).cOI().an(localbl)) });
    AppMethodBeat.o(122762);
  }
  
  public final void akY(String paramString)
  {
    AppMethodBeat.i(122761);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
      AppMethodBeat.o(122761);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < this.uMo.tvP.size())
      {
        if (((x)this.uMo.tvP.get(i)).uLh.equals(paramString)) {
          this.uMo.tvP.remove(i);
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
      String str = Base64.encodeToString(this.uMo.toByteArray(), 0);
      ad.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { str });
      g.afB().afk().set(282625, str);
      AppMethodBeat.o(122763);
      return;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localIOException, "", new Object[0]);
      ad.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
      AppMethodBeat.o(122763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.z
 * JD-Core Version:    0.7.0.1
 */