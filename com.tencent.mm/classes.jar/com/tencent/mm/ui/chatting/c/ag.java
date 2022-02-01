package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=z.class)
public class ag
  extends a
  implements z
{
  public final boolean bz(bo parambo)
  {
    AppMethodBeat.i(35467);
    if (parambo.cKP())
    {
      aj.bt(parambo);
      this.cLy.xg(true);
      AppMethodBeat.o(35467);
      return true;
    }
    AppMethodBeat.o(35467);
    return false;
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35473);
    ky localky = new ky();
    localky.dmP.dmJ = 0;
    localky.dmP.aTm = ab.eUO();
    if (w.sQ(this.cLy.AzG.field_username)) {}
    for (localky.dmP.dmR = true;; localky.dmP.dmR = false)
    {
      com.tencent.mm.sdk.b.a.GpY.l(localky);
      AppMethodBeat.o(35473);
      return;
    }
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35474);
    bt localbt = new bt();
    com.tencent.mm.sdk.b.a.GpY.l(localbt);
    AppMethodBeat.o(35474);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35472);
    super.fmj();
    ky localky = new ky();
    localky.dmP.dmJ = 2;
    com.tencent.mm.sdk.b.a.GpY.l(localky);
    AppMethodBeat.o(35472);
  }
  
  public final void fnX()
  {
    AppMethodBeat.i(35468);
    final boolean bool1;
    if ((ai.aNc(this.cLy.getTalkerUserName())) || (w.wq(this.cLy.AzG.field_username))) {
      if ((((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).Fn(this.cLy.AzG.field_openImAppid) & 0x1000) == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((w.ws(this.cLy.AzG.field_username)) && ((u.ayg() & 0x8) != 0)) {}
      for (final boolean bool2 = true;; bool2 = false)
      {
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.cLy.HZF.getContext(), 1, false);
        locale.ISu = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(35463);
            if (bool2)
            {
              paramAnonymousl.c(1, ag.this.cLy.HZF.getMMResources().getString(2131760732));
              paramAnonymousl.c(2, ag.this.cLy.HZF.getMMResources().getString(2131760733));
              AppMethodBeat.o(35463);
              return;
            }
            if ((!ag.a(ag.this)) || (bool1))
            {
              paramAnonymousl.c(1, ag.this.cLy.HZF.getMMResources().getString(2131760732));
              AppMethodBeat.o(35463);
              return;
            }
            paramAnonymousl.c(1, ag.this.cLy.HZF.getMMResources().getString(2131760732));
            paramAnonymousl.c(2, ag.this.cLy.HZF.getMMResources().getString(2131760733));
            AppMethodBeat.o(35463);
          }
        };
        locale.ISv = new n.d()
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
              if (com.tencent.mm.aw.b.CQ((String)g.agR().agA().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.o(ag.this.cLy.HZF.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(ag.this.cLy.HZF.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label291;
                  }
                  if (((Boolean)g.agR().agA().get(ah.a.GRN, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ag.this.cLy.HZF.getContext(), ag.this.cLy.HZF.getMMResources().getString(2131760740, new Object[] { ab.eUO() }), 30763, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ag.this.cLy.HZF.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
                AppMethodBeat.o(35464);
                return;
              }
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ag.this.cLy.HZF.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67, null, null);
              ac.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label291:
              ag.this.fnY();
              AppMethodBeat.o(35464);
              return;
              if (com.tencent.mm.aw.b.CQ((String)g.agR().agA().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.o(ag.this.cLy.HZF.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(ag.this.cLy.HZF.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label557;
                  }
                  if (((Boolean)g.agR().agA().get(ah.a.GRN, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ag.this.cLy.HZF.getContext(), ag.this.cLy.HZF.getMMResources().getString(2131760740, new Object[] { ab.eUO() }), 30762, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ag.this.cLy.HZF.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
                AppMethodBeat.o(35464);
                return;
              }
              bool = com.tencent.mm.pluginsdk.permission.b.a(ag.this.cLy.HZF.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68, null, null);
              ac.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label557:
              ag.this.fnZ();
            }
          }
        };
        locale.cED();
        AppMethodBeat.o(35468);
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
  
  public final void fnY()
  {
    AppMethodBeat.i(35469);
    com.tencent.mm.plugin.report.service.h.wUl.f(12809, new Object[] { Integer.valueOf(1), "" });
    Intent localIntent = new Intent();
    if (this.cLy.foQ()) {
      localIntent.putExtra("type_tag", 2);
    }
    for (;;)
    {
      localIntent.putExtra("map_view_type", 0);
      localIntent.putExtra("map_sender_name", this.cLy.foM());
      localIntent.putExtra("map_talker_name", this.cLy.getTalkerUserName());
      com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(35469);
      return;
      localIntent.putExtra("type_tag", 1);
    }
  }
  
  public final void fnZ()
  {
    AppMethodBeat.i(35470);
    if ((!com.tencent.mm.r.a.ci(this.cLy.HZF.getContext())) && (!com.tencent.mm.r.a.cf(this.cLy.HZF.getContext())) && (!com.tencent.mm.r.a.ck(this.cLy.HZF.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amk(this.cLy.getTalkerUserName()))
      {
        ac.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        com.tencent.mm.ui.base.h.l(this.cLy.HZF.getContext(), 2131761410, 2131755906);
        AppMethodBeat.o(35470);
        return;
      }
      if (!bs.isNullOrNil(null))
      {
        int j = 0;
        int i = j;
        Object localObject;
        if (com.tencent.mm.bi.d.hXY != null)
        {
          i = j;
          if (com.tencent.mm.bi.d.hXY.DF(this.cLy.AzG.field_username))
          {
            localObject = com.tencent.mm.bi.d.hXY.DE(this.cLy.AzG.field_username);
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((List)localObject).contains(this.cLy.foM())) {
                i = 1;
              }
            }
          }
        }
        if (i == 0)
        {
          localObject = new d.a(this.cLy.HZF.getContext());
          ((d.a)localObject).aRI(null);
          ((d.a)localObject).acM(2131760315).b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35465);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35465);
            }
          });
          ((d.a)localObject).fvp().show();
          AppMethodBeat.o(35470);
          return;
        }
      }
      ((ak)this.cLy.bf(ak.class)).aQq("fromPluginLocation");
    }
    AppMethodBeat.o(35470);
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
          fnY();
          AppMethodBeat.o(35471);
          return;
        }
        fnZ();
        AppMethodBeat.o(35471);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131761869), this.cLy.HZF.getMMResources().getString(2131761885), this.cLy.HZF.getMMResources().getString(2131760598), this.cLy.HZF.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35466);
          paramAnonymousDialogInterface = ag.this.cLy.HZF;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35466);
        }
      }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ag
 * JD-Core Version:    0.7.0.1
 */