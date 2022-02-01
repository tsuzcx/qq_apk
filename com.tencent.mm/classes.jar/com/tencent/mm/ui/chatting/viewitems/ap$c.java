package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.ky.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.b;
import com.tencent.mm.ui.chatting.s.e;

public final class ap$c
  extends s.e
{
  private int scene;
  
  public ap$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ap$c(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    super(parama);
    AppMethodBeat.i(37354);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      b(new bj(parambo, this.HNS.foQ(), 0, null, '\000'));
    }
    AppMethodBeat.o(37354);
  }
  
  private void b(bj parambj)
  {
    AppMethodBeat.i(37356);
    bo localbo = parambj.dpq;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(localbo.field_talker);
    Object localObject1 = localbo.field_content;
    int i;
    if (localbo.field_isSend == 0)
    {
      i = 1;
      parambj = "";
      if (i != 0) {
        parambj = localbo.field_talker;
      }
      if ((!w.sQ(localbo.field_talker)) || (i == 0) || (((com.tencent.mm.ui.chatting.c.b.d)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo())) {
        break label516;
      }
      i = bi.yi((String)localObject1);
      if (i == -1) {
        break label516;
      }
      parambj = ((String)localObject1).substring(0, i).trim();
      localObject1 = ((String)localObject1).substring(i + 1).trim();
    }
    label516:
    for (;;)
    {
      az.ayM();
      localObject1 = c.awD().alx((String)localObject1);
      if ((!ae.isNullOrNil(parambj)) && (w.sQ(parambj))) {
        parambj = "";
      }
      for (;;)
      {
        Object localObject2 = new ky();
        ((ky)localObject2).dmP.dmJ = 1;
        ((ky)localObject2).dmP.cZc = localbo;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject2 = ((ky)localObject2).dmQ.diM;
        if ((ae.isNullOrNil(((bo.b)localObject1).gPy)) && (!((bo.b)localObject1).fcn()))
        {
          ac.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { ((bo.b)localObject1).gPy, Boolean.valueOf(((bo.b)localObject1).fcn()) });
          AppMethodBeat.o(37356);
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", localbo.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", ((bo.b)localObject1).tWI);
        localIntent.putExtra("kwebmap_lng", ((bo.b)localObject1).tWJ);
        localIntent.putExtra("kwebmap_scale", ((bo.b)localObject1).dmN);
        localIntent.putExtra("kPoiName", ((bo.b)localObject1).gPy);
        localIntent.putExtra("kisUsername", v.wk(parambj));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject2);
        az.ayM();
        localIntent.putExtra("kimg_path", c.awL());
        localIntent.putExtra("map_talker_name", localbo.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", ((bo.b)localObject1).DfY);
        localIntent.putExtra("kPoiid", ((bo.b)localObject1).tWP);
        localIntent.putExtra("soso_street_view_url", ae.bG(localbo.field_reserved, ""));
        com.tencent.mm.plugin.report.service.h.wUl.f(12809, new Object[] { Integer.valueOf(2), "" });
        com.tencent.mm.br.d.a(this.HNS.HZC, "location", ".ui.RedirectUI", localIntent, 2002, new d.a()
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
                ac.e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                AppMethodBeat.o(37353);
                return;
              }
              if (paramAnonymousIntent.getBooleanExtra("kfavorite", false))
              {
                cs localcs = new cs();
                com.tencent.mm.pluginsdk.model.g.a(localcs, paramAnonymousIntent);
                localcs.dck.fragment = ap.c.a(ap.c.this).HZF;
                localcs.dck.dcq = 42;
                com.tencent.mm.sdk.b.a.GpY.l(localcs);
              }
            }
          }
        });
        AppMethodBeat.o(37356);
        return;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37355);
    b((bj)paramView.getTag());
    AppMethodBeat.o(37355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.c
 * JD-Core Version:    0.7.0.1
 */