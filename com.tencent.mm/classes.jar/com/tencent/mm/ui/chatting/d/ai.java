package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=ab.class)
public class ai
  extends a
  implements ab
{
  public final boolean bE(bv parambv)
  {
    AppMethodBeat.i(35467);
    if (parambv.cVJ())
    {
      ak.bw(parambv);
      this.cXJ.xY(true);
      AppMethodBeat.o(35467);
      return true;
    }
    AppMethodBeat.o(35467);
    return false;
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35473);
    li localli = new li();
    localli.dzI.dzC = 0;
    localli.dzI.language = ad.fom();
    if (x.wb(this.cXJ.Cqh.field_username)) {}
    for (localli.dzI.dzK = true;; localli.dzI.dzK = false)
    {
      com.tencent.mm.sdk.b.a.IvT.l(localli);
      AppMethodBeat.o(35473);
      return;
    }
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35474);
    bw localbw = new bw();
    com.tencent.mm.sdk.b.a.IvT.l(localbw);
    AppMethodBeat.o(35474);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35472);
    super.fGE();
    li localli = new li();
    localli.dzI.dzC = 2;
    com.tencent.mm.sdk.b.a.IvT.l(localli);
    AppMethodBeat.o(35472);
  }
  
  public final void fIA()
  {
    AppMethodBeat.i(35470);
    if ((!com.tencent.mm.r.a.ch(this.cXJ.Kkd.getContext())) && (!com.tencent.mm.r.a.cf(this.cXJ.Kkd.getContext())) && (!com.tencent.mm.r.a.cj(this.cXJ.Kkd.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).aso(this.cXJ.getTalkerUserName()))
      {
        ae.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        h.l(this.cXJ.Kkd.getContext(), 2131761410, 2131755906);
        AppMethodBeat.o(35470);
        return;
      }
      if (!bu.isNullOrNil(null))
      {
        int j = 0;
        int i = j;
        Object localObject;
        if (com.tencent.mm.bi.d.iuo != null)
        {
          i = j;
          if (com.tencent.mm.bi.d.iuo.Hm(this.cXJ.Cqh.field_username))
          {
            localObject = com.tencent.mm.bi.d.iuo.Hl(this.cXJ.Cqh.field_username);
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((List)localObject).contains(this.cXJ.fJy())) {
                i = 1;
              }
            }
          }
        }
        if (i == 0)
        {
          localObject = new d.a(this.cXJ.Kkd.getContext());
          ((d.a)localObject).aZi(null);
          ((d.a)localObject).afU(2131760315).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35465);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35465);
            }
          });
          ((d.a)localObject).fQv().show();
          AppMethodBeat.o(35470);
          return;
        }
      }
      ((ap)this.cXJ.bh(ap.class)).aXK("fromPluginLocation");
    }
    AppMethodBeat.o(35470);
  }
  
  public final void fIy()
  {
    AppMethodBeat.i(35468);
    final boolean bool1;
    if ((an.aUq(this.cXJ.getTalkerUserName())) || (x.zV(this.cXJ.Cqh.field_username))) {
      if ((((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Jc(this.cXJ.Cqh.field_openImAppid) & 0x1000) == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((x.zX(this.cXJ.Cqh.field_username)) && ((v.aBw() & 0x8) != 0)) {}
      for (final boolean bool2 = true;; bool2 = false)
      {
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.cXJ.Kkd.getContext(), 1, false);
        locale.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(35463);
            if (bool2)
            {
              paramAnonymousl.d(1, ai.this.cXJ.Kkd.getMMResources().getString(2131760732));
              paramAnonymousl.d(2, ai.this.cXJ.Kkd.getMMResources().getString(2131760733));
              AppMethodBeat.o(35463);
              return;
            }
            if ((!ai.a(ai.this)) || (bool1))
            {
              paramAnonymousl.d(1, ai.this.cXJ.Kkd.getMMResources().getString(2131760732));
              AppMethodBeat.o(35463);
              return;
            }
            paramAnonymousl.d(1, ai.this.cXJ.Kkd.getMMResources().getString(2131760732));
            paramAnonymousl.d(2, ai.this.cXJ.Kkd.getMMResources().getString(2131760733));
            AppMethodBeat.o(35463);
          }
        };
        locale.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(35464);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(35464);
              return;
              if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.n(ai.this.cXJ.Kkd.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(ai.this.cXJ.Kkd.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label291;
                  }
                  if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ai.this.cXJ.Kkd.getContext(), ai.this.cXJ.Kkd.getMMResources().getString(2131760740, new Object[] { ad.fom() }), 30763, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ai.this.cXJ.Kkd.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
                AppMethodBeat.o(35464);
                return;
              }
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ai.this.cXJ.Kkd.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67, null, null);
              ae.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label291:
              ai.this.fIz();
              AppMethodBeat.o(35464);
              return;
              if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.n(ai.this.cXJ.Kkd.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(ai.this.cXJ.Kkd.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label557;
                  }
                  if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ai.this.cXJ.Kkd.getContext(), ai.this.cXJ.Kkd.getMMResources().getString(2131760740, new Object[] { ad.fom() }), 30762, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ai.this.cXJ.Kkd.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
                AppMethodBeat.o(35464);
                return;
              }
              bool = com.tencent.mm.pluginsdk.permission.b.a(ai.this.cXJ.Kkd.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68, null, null);
              ae.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label557:
              ai.this.fIA();
            }
          }
        };
        locale.cPF();
        AppMethodBeat.o(35468);
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
  
  public final void fIz()
  {
    AppMethodBeat.i(35469);
    com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(1), "" });
    Intent localIntent = new Intent();
    if (this.cXJ.fJC()) {
      localIntent.putExtra("type_tag", 2);
    }
    for (;;)
    {
      localIntent.putExtra("map_view_type", 0);
      localIntent.putExtra("map_sender_name", this.cXJ.fJy());
      localIntent.putExtra("map_talker_name", this.cXJ.getTalkerUserName());
      com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(35469);
      return;
      localIntent.putExtra("type_tag", 1);
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(35471);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35471);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        if (paramInt == 67)
        {
          fIz();
          AppMethodBeat.o(35471);
          return;
        }
        fIA();
        AppMethodBeat.o(35471);
        return;
      }
      h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131761869), this.cXJ.Kkd.getMMResources().getString(2131761885), this.cXJ.Kkd.getMMResources().getString(2131760598), this.cXJ.Kkd.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35466);
          paramAnonymousDialogInterface = ai.this.cXJ.Kkd;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35466);
        }
      }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ai
 * JD-Core Version:    0.7.0.1
 */