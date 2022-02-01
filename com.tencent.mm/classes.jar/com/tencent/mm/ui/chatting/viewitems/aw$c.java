package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c.a;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.ly.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class aw$c
  extends t.e
{
  private int scene;
  
  public aw$c(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public aw$c(a parama, ca paramca)
  {
    super(parama);
    AppMethodBeat.i(37354);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      b(new bq(paramca, this.PhN.gRM(), 0, null, '\000'));
    }
    AppMethodBeat.o(37354);
  }
  
  private void b(bq parambq)
  {
    AppMethodBeat.i(37356);
    ca localca = parambq.dTX;
    ((b)g.af(b.class)).akR(localca.field_talker);
    Object localObject1 = localca.field_content;
    int i;
    if (localca.field_isSend == 0)
    {
      i = 1;
      parambq = "";
      if (i != 0) {
        parambq = localca.field_talker;
      }
      if ((!ab.Eq(localca.field_talker)) || (i == 0) || (((d)this.PhN.bh(d.class)).gOP())) {
        break label516;
      }
      i = bp.Kp((String)localObject1);
      if (i == -1) {
        break label516;
      }
      parambq = ((String)localObject1).substring(0, i).trim();
      localObject1 = ((String)localObject1).substring(i + 1).trim();
    }
    label516:
    for (;;)
    {
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSQ().aEL((String)localObject1);
      if ((!af.isNullOrNil(parambq)) && (ab.Eq(parambq))) {
        parambq = "";
      }
      for (;;)
      {
        Object localObject2 = new ly();
        ((ly)localObject2).dRv.dRq = 1;
        ((ly)localObject2).dRv.dCM = localca;
        EventCenter.instance.publish((IEvent)localObject2);
        localObject2 = ((ly)localObject2).dRw.dNk;
        if ((af.isNullOrNil(((ca.b)localObject1).kHV)) && (!((ca.b)localObject1).gEb()))
        {
          Log.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { ((ca.b)localObject1).kHV, Boolean.valueOf(((ca.b)localObject1).gEb()) });
          AppMethodBeat.o(37356);
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", localca.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", ((ca.b)localObject1).yFu);
        localIntent.putExtra("kwebmap_lng", ((ca.b)localObject1).yFv);
        localIntent.putExtra("kwebmap_scale", ((ca.b)localObject1).dRt);
        localIntent.putExtra("kPoiName", ((ca.b)localObject1).kHV);
        localIntent.putExtra("kisUsername", aa.getDisplayName(parambq));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject2);
        bg.aVF();
        localIntent.putExtra("kimg_path", com.tencent.mm.model.c.aSY());
        localIntent.putExtra("map_talker_name", localca.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", ((ca.b)localObject1).JTr);
        localIntent.putExtra("kPoiid", ((ca.b)localObject1).yFB);
        localIntent.putExtra("soso_street_view_url", af.nullAs(localca.field_reserved, ""));
        com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(2), "" });
        com.tencent.mm.br.c.a(this.PhN.Pwa, "location", ".ui.RedirectUI", localIntent, 2002, new c.a()
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
                cz localcz = new cz();
                com.tencent.mm.pluginsdk.model.h.a(localcz, paramAnonymousIntent);
                localcz.dFZ.fragment = aw.c.a(aw.c.this).Pwc;
                localcz.dFZ.dGf = 42;
                EventCenter.instance.publish(localcz);
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
    b((bq)paramView.getTag());
    AppMethodBeat.o(37355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.c
 * JD-Core Version:    0.7.0.1
 */