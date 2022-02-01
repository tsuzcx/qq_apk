package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c.a;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.mp;
import com.tencent.mm.f.a.mp.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class ba$c
  extends t.e
{
  private int scene;
  
  public ba$c(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ba$c(a parama, ca paramca)
  {
    super(parama);
    AppMethodBeat.i(37354);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      b(new by(paramca, this.WBq.hRi(), 0, null, '\000'));
    }
    AppMethodBeat.o(37354);
  }
  
  private void b(by paramby)
  {
    AppMethodBeat.i(37356);
    ca localca = paramby.fNz;
    ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(localca.field_talker);
    Object localObject1 = localca.field_content;
    int i;
    if (localca.field_isSend == 0)
    {
      i = 1;
      paramby = "";
      if (i != 0) {
        paramby = localca.field_talker;
      }
      if ((!ab.Lj(localca.field_talker)) || (i == 0) || (((d)this.WBq.bC(d.class)).hOe())) {
        break label516;
      }
      i = bq.RI((String)localObject1);
      if (i == -1) {
        break label516;
      }
      paramby = ((String)localObject1).substring(0, i).trim();
      localObject1 = ((String)localObject1).substring(i + 1).trim();
    }
    label516:
    for (;;)
    {
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbO().aOV((String)localObject1);
      if ((!ae.isNullOrNil(paramby)) && (ab.Lj(paramby))) {
        paramby = "";
      }
      for (;;)
      {
        Object localObject2 = new mp();
        ((mp)localObject2).fKL.fKG = 1;
        ((mp)localObject2).fKL.fvt = localca;
        EventCenter.instance.publish((IEvent)localObject2);
        localObject2 = ((mp)localObject2).fKM.fGw;
        if ((ae.isNullOrNil(((ca.b)localObject1).poiName)) && (!((ca.b)localObject1).hAr()))
        {
          Log.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { ((ca.b)localObject1).poiName, Boolean.valueOf(((ca.b)localObject1).hAr()) });
          AppMethodBeat.o(37356);
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", localca.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", ((ca.b)localObject1).Ejn);
        localIntent.putExtra("kwebmap_lng", ((ca.b)localObject1).Ejo);
        localIntent.putExtra("kwebmap_scale", ((ca.b)localObject1).fKJ);
        localIntent.putExtra("kPoiName", ((ca.b)localObject1).poiName);
        localIntent.putExtra("kisUsername", aa.PJ(paramby));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject2);
        bh.beI();
        localIntent.putExtra("kimg_path", com.tencent.mm.model.c.bbW());
        localIntent.putExtra("map_talker_name", localca.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", ((ca.b)localObject1).QSw);
        localIntent.putExtra("kPoiid", ((ca.b)localObject1).Eju);
        localIntent.putExtra("soso_street_view_url", ae.nullAs(localca.field_reserved, ""));
        com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(2), "" });
        com.tencent.mm.by.c.a(this.WBq.WQt, "location", ".ui.RedirectUI", localIntent, 2002, new c.a()
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
                Log.e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                AppMethodBeat.o(37353);
                return;
              }
              if (paramAnonymousIntent.getBooleanExtra("kfavorite", false))
              {
                dd localdd = new dd();
                j.a(localdd, paramAnonymousIntent);
                localdd.fyI.fragment = ba.c.a(ba.c.this).WQv;
                localdd.fyI.fyP = 42;
                EventCenter.instance.publish(localdd);
              }
            }
          }
        });
        AppMethodBeat.o(37356);
        return;
      }
    }
  }
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37355);
    if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(37355);
      return;
    }
    b((by)paramView.getTag());
    AppMethodBeat.o(37355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba.c
 * JD-Core Version:    0.7.0.1
 */