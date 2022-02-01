package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.lh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.b;
import com.tencent.mm.ui.chatting.s.e;

public final class aq$c
  extends s.e
{
  private int scene;
  
  public aq$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public aq$c(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    super(parama);
    AppMethodBeat.i(37354);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      b(new bk(parambu, this.JBI.fFv(), 0, null, '\000'));
    }
    AppMethodBeat.o(37354);
  }
  
  private void b(bk parambk)
  {
    AppMethodBeat.i(37356);
    bu localbu = parambk.dBd;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(localbu.field_talker);
    Object localObject1 = localbu.field_content;
    int i;
    if (localbu.field_isSend == 0)
    {
      i = 1;
      parambk = "";
      if (i != 0) {
        parambk = localbu.field_talker;
      }
      if ((!w.vF(localbu.field_talker)) || (i == 0) || (((com.tencent.mm.ui.chatting.d.b.d)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH())) {
        break label516;
      }
      i = bj.Bh((String)localObject1);
      if (i == -1) {
        break label516;
      }
      parambk = ((String)localObject1).substring(0, i).trim();
      localObject1 = ((String)localObject1).substring(i + 1).trim();
    }
    label516:
    for (;;)
    {
      ba.aBQ();
      localObject1 = c.azs().aql((String)localObject1);
      if ((!af.isNullOrNil(parambk)) && (w.vF(parambk))) {
        parambk = "";
      }
      for (;;)
      {
        Object localObject2 = new lh();
        ((lh)localObject2).dyD.dyx = 1;
        ((lh)localObject2).dyD.dku = localbu;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject2 = ((lh)localObject2).dyE.duy;
        if ((af.isNullOrNil(((bu.b)localObject1).jDf)) && (!((bu.b)localObject1).fsu()))
        {
          ad.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { ((bu.b)localObject1).jDf, Boolean.valueOf(((bu.b)localObject1).fsu()) });
          AppMethodBeat.o(37356);
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", localbu.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", ((bu.b)localObject1).uZr);
        localIntent.putExtra("kwebmap_lng", ((bu.b)localObject1).uZs);
        localIntent.putExtra("kwebmap_scale", ((bu.b)localObject1).dyB);
        localIntent.putExtra("kPoiName", ((bu.b)localObject1).jDf);
        localIntent.putExtra("kisUsername", v.zf(parambk));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject2);
        ba.aBQ();
        localIntent.putExtra("kimg_path", c.azA());
        localIntent.putExtra("map_talker_name", localbu.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", ((bu.b)localObject1).EJU);
        localIntent.putExtra("kPoiid", ((bu.b)localObject1).uZy);
        localIntent.putExtra("soso_street_view_url", af.bI(localbu.field_reserved, ""));
        com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(2), "" });
        com.tencent.mm.bs.d.a(this.JBI.JOO, "location", ".ui.RedirectUI", localIntent, 2002, new d.a()
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
                cv localcv = new cv();
                com.tencent.mm.pluginsdk.model.g.a(localcv, paramAnonymousIntent);
                localcv.dnG.fragment = aq.c.a(aq.c.this).JOR;
                localcv.dnG.dnM = 42;
                com.tencent.mm.sdk.b.a.IbL.l(localcv);
              }
            }
          }
        });
        AppMethodBeat.o(37356);
        return;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37355);
    b((bk)paramView.getTag());
    AppMethodBeat.o(37355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.c
 * JD-Core Version:    0.7.0.1
 */