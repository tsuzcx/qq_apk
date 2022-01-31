package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.ui.chatting.s.e;

public final class af$c
  extends s.e
{
  public af$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33260);
    parambi = ((az)paramView.getTag()).cEE;
    parama = parambi.field_content;
    int i;
    if (parambi.field_isSend == 0)
    {
      i = 1;
      paramView = "";
      if (i != 0) {
        paramView = parambi.field_talker;
      }
      if ((!t.lA(parambi.field_talker)) || (i == 0) || (((com.tencent.mm.ui.chatting.c.b.d)this.zzP.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv())) {
        break label498;
      }
      i = bf.pt(parama);
      if (i == -1) {
        break label498;
      }
      paramView = parama.substring(0, i).trim();
      parama = parama.substring(i + 1).trim();
    }
    label498:
    for (;;)
    {
      aw.aaz();
      parama = c.YC().Tz(parama);
      if ((!ah.isNullOrNil(paramView)) && (t.lA(paramView))) {
        paramView = "";
      }
      for (;;)
      {
        Object localObject = new jm();
        ((jm)localObject).cyZ.cyU = 1;
        ((jm)localObject).cyZ.cmQ = parambi;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
        localObject = ((jm)localObject).cza.cvF;
        if ((ah.isNullOrNil(parama.eSM)) && (!parama.dyw()))
        {
          ab.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { parama.eSM, Boolean.valueOf(parama.dyw()) });
          AppMethodBeat.o(33260);
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", parambi.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", parama.nZV);
        localIntent.putExtra("kwebmap_lng", parama.nZW);
        localIntent.putExtra("kwebmap_scale", parama.cyX);
        localIntent.putExtra("kPoiName", parama.eSM);
        localIntent.putExtra("kisUsername", s.nE(paramView));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject);
        aw.aaz();
        localIntent.putExtra("kimg_path", c.YK());
        localIntent.putExtra("map_talker_name", parambi.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", parama.vJU);
        localIntent.putExtra("kPoiid", parama.oac);
        localIntent.putExtra("soso_street_view_url", ah.bf(parambi.field_reserved, ""));
        com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(2), "" });
        com.tencent.mm.bq.d.a(this.zzP.zJx, "location", ".ui.RedirectUI", localIntent, 2002, new af.c.1(this));
        AppMethodBeat.o(33260);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.c
 * JD-Core Version:    0.7.0.1
 */