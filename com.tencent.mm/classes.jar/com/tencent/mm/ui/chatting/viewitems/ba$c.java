package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.nw;
import com.tencent.mm.autogen.a.nw.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.br.c.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v.e;

public final class ba$c
  extends v.e
{
  private int scene;
  
  public ba$c(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ba$c(a parama, cc paramcc)
  {
    super(parama);
    AppMethodBeat.i(37354);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      b(new bz(paramcc, this.aeiK.juG(), 0, null, '\000'));
    }
    AppMethodBeat.o(37354);
  }
  
  private void b(bz parambz)
  {
    AppMethodBeat.i(37356);
    cc localcc = parambz.hTm;
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(localcc.field_talker);
    Object localObject1 = localcc.field_content;
    int i;
    if (localcc.field_isSend == 0)
    {
      i = 1;
      parambz = "";
      if (i != 0) {
        parambz = localcc.field_talker;
      }
      if ((!au.bwE(localcc.field_talker)) || (i == 0) || (((e)this.aeiK.cm(e.class)).jqV())) {
        break label511;
      }
      i = br.JG((String)localObject1);
      if (i == -1) {
        break label511;
      }
      parambz = ((String)localObject1).substring(0, i).trim();
      localObject1 = ((String)localObject1).substring(i + 1).trim();
    }
    label511:
    for (;;)
    {
      bh.bCz();
      localObject1 = com.tencent.mm.model.c.bzD().aLV((String)localObject1);
      if ((!ab.isNullOrNil(parambz)) && (au.bwE(parambz))) {
        parambz = "";
      }
      for (;;)
      {
        Object localObject2 = new nw();
        ((nw)localObject2).hQs.hQm = 1;
        ((nw)localObject2).hQs.hzO = localcc;
        ((nw)localObject2).publish();
        localObject2 = ((nw)localObject2).hQt.hLS;
        if ((ab.isNullOrNil(((cc.c)localObject1).poiName)) && (!((cc.c)localObject1).jcx()))
        {
          Log.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", new Object[] { ((cc.c)localObject1).poiName, Boolean.valueOf(((cc.c)localObject1).jcx()) });
          AppMethodBeat.o(37356);
          return;
          i = 0;
          break;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("kMsgId", localcc.field_msgId);
        localIntent.putExtra("map_view_type", 1);
        localIntent.putExtra("kwebmap_slat", ((cc.c)localObject1).KbW);
        localIntent.putExtra("kwebmap_lng", ((cc.c)localObject1).KbX);
        localIntent.putExtra("kwebmap_scale", ((cc.c)localObject1).hQp);
        localIntent.putExtra("kPoiName", ((cc.c)localObject1).poiName);
        localIntent.putExtra("kisUsername", aa.getDisplayName(parambz));
        localIntent.putExtra("Kwebmap_locaion", (String)localObject2);
        bh.bCz();
        localIntent.putExtra("kimg_path", com.tencent.mm.model.c.bzL());
        localIntent.putExtra("map_talker_name", localcc.field_talker);
        localIntent.putExtra("view_type_key", 0);
        localIntent.putExtra("kwebmap_from_to", true);
        localIntent.putExtra("kPoi_url", ((cc.c)localObject1).XOv);
        localIntent.putExtra("kPoiid", ((cc.c)localObject1).Kcd);
        localIntent.putExtra("soso_street_view_url", ab.nullAs(localcc.field_reserved, ""));
        com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(2), "" });
        com.tencent.mm.br.c.a(this.aeiK.aezM, "location", ".ui.RedirectUI", localIntent, 2002, new c.a()
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
                dn localdn = new dn();
                l.a(localdn, paramAnonymousIntent);
                localdn.hDr.fragment = ba.c.a(ba.c.this).aezO;
                localdn.hDr.hDy = 42;
                localdn.publish();
              }
            }
          }
        });
        AppMethodBeat.o(37356);
        return;
      }
    }
  }
  
  public final void a(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(37355);
    if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(37355);
      return;
    }
    b((bz)paramView.getTag());
    AppMethodBeat.o(37355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba.c
 * JD-Core Version:    0.7.0.1
 */