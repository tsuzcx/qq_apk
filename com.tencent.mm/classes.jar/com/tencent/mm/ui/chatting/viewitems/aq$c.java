package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.b;
import com.tencent.mm.ui.chatting.t.e;

public final class aq$c
  extends t.e
{
  private int scene;
  
  public aq$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public aq$c(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    super(parama);
    AppMethodBeat.i(37354);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      b(new bk(parambv, this.JWz.fJC(), 0, null, '\000'));
    }
    AppMethodBeat.o(37354);
  }
  
  private void b(bk parambk)
  {
    AppMethodBeat.i(37356);
    bv localbv = parambk.dCi;
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(localbv.field_talker);
    Object localObject1 = localbv.field_content;
    int i;
    if (localbv.field_isSend == 0)
    {
      i = 1;
      parambk = "";
      if (i != 0) {
        parambk = localbv.field_talker;
      }
      if ((!x.wb(localbv.field_talker)) || (i == 0) || (((com.tencent.mm.ui.chatting.d.b.d)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ())) {
        break label516;
      }
      i = bl.BJ((String)localObject1);
      if (i == -1) {
        break label516;
      }
      parambk = ((String)localObject1).substring(0, i).trim();
      localObject1 = ((String)localObject1).substring(i + 1).trim();
    }
    label516:
    for (;;)
    {
      bc.aCg();
      localObject1 = c.azI().arq((String)localObject1);
      if ((!af.isNullOrNil(parambk)) && (x.wb(parambk))) {
        parambk = "";
      }
      for (;;)
      {
        Object localObject2 = new li();
        ((li)localObject2).dzI.dzC = 1;
        ((li)localObject2).dzI.dlw = localbv;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
        localObject2 = ((li)localObject2).dzJ.dvD;
        if ((af.isNullOrNil(((bv.b)localObject1).jGd)) && (!((bv.b)localObject1).fwv()))
        {
          ae.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { ((bv.b)localObject1).jGd, Boolean.valueOf(((bv.b)localObject1).fwv()) });
          AppMethodBeat.o(37356);
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", localbv.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", ((bv.b)localObject1).vlC);
        localIntent.putExtra("kwebmap_lng", ((bv.b)localObject1).vlD);
        localIntent.putExtra("kwebmap_scale", ((bv.b)localObject1).dzG);
        localIntent.putExtra("kPoiName", ((bv.b)localObject1).jGd);
        localIntent.putExtra("kisUsername", w.zP(parambk));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject2);
        bc.aCg();
        localIntent.putExtra("kimg_path", c.azQ());
        localIntent.putExtra("map_talker_name", localbv.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", ((bv.b)localObject1).Fcs);
        localIntent.putExtra("kPoiid", ((bv.b)localObject1).vlJ);
        localIntent.putExtra("soso_street_view_url", af.bI(localbv.field_reserved, ""));
        com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(2), "" });
        com.tencent.mm.br.d.a(this.JWz.Kka, "location", ".ui.RedirectUI", localIntent, 2002, new d.a()
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
                ae.e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                AppMethodBeat.o(37353);
                return;
              }
              if (paramAnonymousIntent.getBooleanExtra("kfavorite", false))
              {
                cw localcw = new cw();
                com.tencent.mm.pluginsdk.model.g.a(localcw, paramAnonymousIntent);
                localcw.doL.fragment = aq.c.a(aq.c.this).Kkd;
                localcw.doL.doR = 42;
                com.tencent.mm.sdk.b.a.IvT.l(localcw);
              }
            }
          }
        });
        AppMethodBeat.o(37356);
        return;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
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