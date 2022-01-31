package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class c$a
  implements f
{
  String hcm;
  final LinkedList<String> nkA;
  LinkedList<Integer> nkB;
  private final c.d nkC;
  
  public c$a(c.d paramd)
  {
    Object localObject;
    this.nkC = localObject;
    this.nkA = new LinkedList();
  }
  
  private final void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    com.tencent.mm.kernel.g.Dk().b(30, (f)this);
    c.d locald = this.nkC;
    if (locald != null) {
      locald.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    a.d.b.g.k(paramm, "scene");
    Object localObject = c.nkz;
    y.d(c.access$getTAG$cp(), "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramm.getType() != 30)
    {
      paramString = c.nkz;
      y.w(c.access$getTAG$cp(), "not expected scene,  type = " + paramm.getType());
      return;
    }
    if (((com.tencent.mm.pluginsdk.model.m)paramm).ckD() == 2)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        b(false, true, this.hcm, "");
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -34)) {
        paramm = this.nkD.context.getString(a.f.fmessage_request_too_offen);
      }
    }
    for (;;)
    {
      b(false, false, this.hcm, paramm);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramm = this.nkD.context.getString(a.f.fmessage_user_not_support);
      }
      else if ((paramInt1 == 4) && ((paramInt2 == -24) || (paramInt2 == -101)))
      {
        paramm = paramString;
        if (paramString != null) {}
      }
      else
      {
        paramm = this.nkD.context.getString(a.f.sendrequest_send_fail);
        continue;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          b(true, false, this.hcm, "");
          return;
        }
        if (paramInt2 == -44)
        {
          com.tencent.mm.kernel.g.Dk().d((com.tencent.mm.ah.m)new com.tencent.mm.pluginsdk.model.m(2, (List)this.nkA, (List)this.nkB, "", ""));
          return;
        }
        if (paramInt2 == -87)
        {
          b(false, false, this.hcm, this.nkD.context.getString(a.f.contact_info_biz_join_fans_limit));
          return;
        }
        if ((paramInt2 == -24) && (!bk.bl(paramString)))
        {
          localObject = this.hcm;
          paramm = paramString;
          if (paramString == null) {
            paramm = "";
          }
          b(false, false, (String)localObject, paramm);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -22)) {
          paramm = this.nkD.context.getString(a.f.addcontact_fail_blacklist);
        } else {
          paramm = this.nkD.context.getString(a.f.addcontact_fail);
        }
      }
    }
  }
  
  public final void onStart()
  {
    com.tencent.mm.kernel.g.Dk().a(30, (f)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c.a
 * JD-Core Version:    0.7.0.1
 */