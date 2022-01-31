package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.jd;
import com.tencent.mm.h.a.jd.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.ui.chatting.t.d;

public final class ac$c
  extends t.d
{
  public ac$c(com.tencent.mm.ui.chatting.c.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    parambi = ((aw)paramView.getTag()).bWO;
    parama = parambi.field_content;
    int i;
    if (parambi.field_isSend == 0)
    {
      i = 1;
      paramView = "";
      if (i != 0) {
        paramView = parambi.field_talker;
      }
      if ((!s.fn(parambi.field_talker)) || (i == 0) || (((com.tencent.mm.ui.chatting.b.b.c)this.vko.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG())) {
        break label482;
      }
      i = bd.iH(parama);
      if (i == -1) {
        break label482;
      }
      paramView = parama.substring(0, i).trim();
      parama = parama.substring(i + 1).trim();
    }
    label482:
    for (;;)
    {
      au.Hx();
      parama = com.tencent.mm.model.c.Fy().HO(parama);
      if ((!ah.bl(paramView)) && (s.fn(paramView))) {
        paramView = "";
      }
      for (;;)
      {
        Object localObject = new jd();
        ((jd)localObject).bRx.bRs = 1;
        ((jd)localObject).bRx.bFH = parambi;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject);
        localObject = ((jd)localObject).bRy.bOn;
        if ((ah.bl(parama.lFn)) && (!parama.cvO()))
        {
          y.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { parama.lFn, Boolean.valueOf(parama.cvO()) });
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", parambi.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", parama.lCJ);
        localIntent.putExtra("kwebmap_lng", parama.lCK);
        localIntent.putExtra("kwebmap_scale", parama.bRv);
        localIntent.putExtra("kPoiName", parama.lFn);
        localIntent.putExtra("kisUsername", r.gV(paramView));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject);
        au.Hx();
        localIntent.putExtra("kimg_path", com.tencent.mm.model.c.FG());
        localIntent.putExtra("map_talker_name", parambi.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", parama.rSW);
        localIntent.putExtra("kPoiid", parama.lCQ);
        localIntent.putExtra("soso_street_view_url", ah.aM(parambi.field_reserved, ""));
        h.nFQ.f(12809, new Object[] { Integer.valueOf(2), "" });
        d.a(this.vko.vtx, "location", ".ui.RedirectUI", localIntent, 2002, new ac.c.1(this));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.c
 * JD-Core Version:    0.7.0.1
 */