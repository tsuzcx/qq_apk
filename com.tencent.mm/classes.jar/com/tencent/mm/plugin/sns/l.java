package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class l
  implements i
{
  public final String C(bi parambi)
  {
    return p.C(parambi);
  }
  
  public final void Z(bi parambi)
  {
    String str = p.C(parambi);
    Object localObject;
    bvo localbvo;
    if (str != null)
    {
      localObject = Base64.decode(str, 0);
      localbvo = new bvo();
    }
    try
    {
      localbvo.aH((byte[])localObject);
      localObject = localbvo.tMm;
      if (localObject == null) {
        return;
      }
    }
    catch (Exception parambi)
    {
      y.printErrStackTrace("MicroMsg.SnsStatExtUtil", parambi, "", new Object[0]);
      return;
    }
    if (parambi.field_talker.endsWith("@chatroom")) {}
    for (parambi = p.a.eEK.value;; parambi = p.a.eEJ.value)
    {
      y.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { parambi, str, localbvo.tMm.tMp, localbvo.tMm.tMq });
      ((c)g.r(c.class)).f(13235, new Object[] { parambi, localbvo.tMm.tMp, localbvo.tMm.tMq });
      return;
    }
  }
  
  public final String a(String paramString, PString paramPString)
  {
    return p.a(paramString, paramPString);
  }
  
  public final void a(String paramString, u.b paramb, bi parambi)
  {
    if (parambi.aVK())
    {
      parambi = g.a.gp(parambi.field_content);
      if ((parambi != null) && (!bk.bl(parambi.bYN))) {
        paramb.h(paramString, parambi.bYN);
      }
    }
  }
  
  public final void b(String paramString, d paramd)
  {
    p.b(paramString, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l
 * JD-Core Version:    0.7.0.1
 */