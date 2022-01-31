package com.tencent.mm.plugin.qqmail.b;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.LinkedList;

public final class y
{
  x neG;
  
  public y()
  {
    String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(282625, "");
    try
    {
      this.neG = new x();
      this.neG.aH(Base64.decode(str, 0));
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
      this.neG = new x();
    }
  }
  
  static void Lm(String paramString)
  {
    bi localbi = new bi();
    localbi.ec("qqmail");
    localbi.bg(bd.iK("qqmail"));
    localbi.fA(0);
    localbi.setContent(String.format(ae.getContext().getString(b.j.send_mail_fail_prompt), new Object[] { paramString }));
    localbi.setType(1);
    localbi.setStatus(3);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(localbi)) });
  }
  
  public final void Ll(String paramString)
  {
    if (bk.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < this.neG.maL.size())
      {
        if (((w)this.neG.maL.get(i)).ndx.equals(paramString)) {
          this.neG.maL.remove(i);
        }
      }
      else
      {
        save();
        return;
      }
      i += 1;
    }
  }
  
  final void save()
  {
    try
    {
      String str = Base64.encodeToString(this.neG.toByteArray(), 0);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { str });
      com.tencent.mm.kernel.g.DP().Dz().o(282625, str);
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localIOException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.y
 * JD-Core Version:    0.7.0.1
 */