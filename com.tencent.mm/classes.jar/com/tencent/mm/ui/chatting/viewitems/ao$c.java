package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kp.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.b;
import com.tencent.mm.ui.chatting.s.e;

public final class ao$c
  extends s.e
{
  private int scene;
  
  public ao$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ao$c(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    super(parama);
    AppMethodBeat.i(37354);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      b(new bi(parambl, this.Gob.eZb(), 0, null, '\000'));
    }
    AppMethodBeat.o(37354);
  }
  
  private void b(bi parambi)
  {
    AppMethodBeat.i(37356);
    bl localbl = parambi.drF;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(localbl.field_talker);
    Object localObject1 = localbl.field_content;
    int i;
    if (localbl.field_isSend == 0)
    {
      i = 1;
      parambi = "";
      if (i != 0) {
        parambi = localbl.field_talker;
      }
      if ((!w.pF(localbl.field_talker)) || (i == 0) || (((com.tencent.mm.ui.chatting.c.b.d)this.Gob.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC())) {
        break label516;
      }
      i = com.tencent.mm.model.bi.uc((String)localObject1);
      if (i == -1) {
        break label516;
      }
      parambi = ((String)localObject1).substring(0, i).trim();
      localObject1 = ((String)localObject1).substring(i + 1).trim();
    }
    label516:
    for (;;)
    {
      az.arV();
      localObject1 = c.apO().agD((String)localObject1);
      if ((!ae.isNullOrNil(parambi)) && (w.pF(parambi))) {
        parambi = "";
      }
      for (;;)
      {
        Object localObject2 = new kp();
        ((kp)localObject2).dpf.doZ = 1;
        ((kp)localObject2).dpf.dbD = localbl;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject2 = ((kp)localObject2).dpg.dld;
        if ((ae.isNullOrNil(((bl.b)localObject1).goQ)) && (!((bl.b)localObject1).eMI()))
        {
          ad.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { ((bl.b)localObject1).goQ, Boolean.valueOf(((bl.b)localObject1).eMI()) });
          AppMethodBeat.o(37356);
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", localbl.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", ((bl.b)localObject1).sOv);
        localIntent.putExtra("kwebmap_lng", ((bl.b)localObject1).sOw);
        localIntent.putExtra("kwebmap_scale", ((bl.b)localObject1).dpd);
        localIntent.putExtra("kPoiName", ((bl.b)localObject1).goQ);
        localIntent.putExtra("kisUsername", v.sh(parambi));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject2);
        az.arV();
        localIntent.putExtra("kimg_path", c.apW());
        localIntent.putExtra("map_talker_name", localbl.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", ((bl.b)localObject1).BNO);
        localIntent.putExtra("kPoiid", ((bl.b)localObject1).sOC);
        localIntent.putExtra("soso_street_view_url", ae.by(localbl.field_reserved, ""));
        com.tencent.mm.plugin.report.service.h.vKh.f(12809, new Object[] { Integer.valueOf(2), "" });
        com.tencent.mm.bs.d.a(this.Gob.GzG, "location", ".ui.RedirectUI", localIntent, 2002, new d.a()
        {
          public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(37353);
            switch (paramAnonymousInt1)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(37353);
              return;
              if (paramAnonymousIntent == null)
              {
                ad.e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                AppMethodBeat.o(37353);
                return;
              }
              if (paramAnonymousIntent.getBooleanExtra("kfavorite", false))
              {
                cs localcs = new cs();
                com.tencent.mm.pluginsdk.model.g.a(localcs, paramAnonymousIntent);
                localcs.deQ.fragment = ao.c.a(ao.c.this).GzJ;
                localcs.deQ.deW = 42;
                com.tencent.mm.sdk.b.a.ESL.l(localcs);
              }
            }
          }
        });
        AppMethodBeat.o(37356);
        return;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37355);
    b((bi)paramView.getTag());
    AppMethodBeat.o(37355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.c
 * JD-Core Version:    0.7.0.1
 */