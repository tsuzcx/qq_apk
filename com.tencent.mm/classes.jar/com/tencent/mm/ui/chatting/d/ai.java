package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ab.class)
public class ai
  extends a
  implements ab
{
  public final boolean bF(bu parambu)
  {
    AppMethodBeat.i(35467);
    if (parambu.cTe())
    {
      aj.bx(parambu);
      this.cWM.xR(true);
      AppMethodBeat.o(35467);
      return true;
    }
    AppMethodBeat.o(35467);
    return false;
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35472);
    super.fCC();
    lh locallh = new lh();
    locallh.dyD.dyx = 2;
    com.tencent.mm.sdk.b.a.IbL.l(locallh);
    AppMethodBeat.o(35472);
  }
  
  public final void fEu()
  {
    AppMethodBeat.i(35468);
    final boolean bool1;
    if ((am.aSQ(this.cWM.getTalkerUserName())) || (w.zl(this.cWM.BYG.field_username))) {
      if ((((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).ID(this.cWM.BYG.field_openImAppid) & 0x1000) == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((w.zn(this.cWM.BYG.field_username)) && ((u.aBg() & 0x8) != 0)) {}
      for (final boolean bool2 = true;; bool2 = false)
      {
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.cWM.JOR.getContext(), 1, false);
        locale.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(35463);
            if (bool2)
            {
              paramAnonymousl.c(1, ai.this.cWM.JOR.getMMResources().getString(2131760732));
              paramAnonymousl.c(2, ai.this.cWM.JOR.getMMResources().getString(2131760733));
              AppMethodBeat.o(35463);
              return;
            }
            if ((!ai.a(ai.this)) || (bool1))
            {
              paramAnonymousl.c(1, ai.this.cWM.JOR.getMMResources().getString(2131760732));
              AppMethodBeat.o(35463);
              return;
            }
            paramAnonymousl.c(1, ai.this.cWM.JOR.getMMResources().getString(2131760732));
            paramAnonymousl.c(2, ai.this.cWM.JOR.getMMResources().getString(2131760733));
            AppMethodBeat.o(35463);
          }
        };
        locale.KJz = new n.e()
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
              if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.n(ai.this.cWM.JOR.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(ai.this.cWM.JOR.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label291;
                  }
                  if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEr, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ai.this.cWM.JOR.getContext(), ai.this.cWM.JOR.getMMResources().getString(2131760740, new Object[] { ac.fks() }), 30763, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ai.this.cWM.JOR.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
                AppMethodBeat.o(35464);
                return;
              }
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ai.this.cWM.JOR.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67, null, null);
              ad.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label291:
              ai.this.fEv();
              AppMethodBeat.o(35464);
              return;
              if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.n(ai.this.cWM.JOR.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(ai.this.cWM.JOR.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label557;
                  }
                  if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEr, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ai.this.cWM.JOR.getContext(), ai.this.cWM.JOR.getMMResources().getString(2131760740, new Object[] { ac.fks() }), 30762, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ai.this.cWM.JOR.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
                AppMethodBeat.o(35464);
                return;
              }
              bool = com.tencent.mm.pluginsdk.permission.b.a(ai.this.cWM.JOR.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68, null, null);
              ad.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label557:
              ai.this.fEw();
            }
          }
        };
        locale.cMW();
        AppMethodBeat.o(35468);
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
  
  public final void fEv()
  {
    AppMethodBeat.i(35469);
    com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(1), "" });
    Intent localIntent = new Intent();
    if (this.cWM.fFv()) {
      localIntent.putExtra("type_tag", 2);
    }
    for (;;)
    {
      localIntent.putExtra("map_view_type", 0);
      localIntent.putExtra("map_sender_name", this.cWM.fFr());
      localIntent.putExtra("map_talker_name", this.cWM.getTalkerUserName());
      com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(35469);
      return;
      localIntent.putExtra("type_tag", 1);
    }
  }
  
  public final void fEw()
  {
    AppMethodBeat.i(35470);
    if ((!com.tencent.mm.s.a.cf(this.cWM.JOR.getContext())) && (!com.tencent.mm.s.a.cd(this.cWM.JOR.getContext())) && (!com.tencent.mm.s.a.ch(this.cWM.JOR.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arg(this.cWM.getTalkerUserName()))
      {
        ad.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        h.l(this.cWM.JOR.getContext(), 2131761410, 2131755906);
        AppMethodBeat.o(35470);
        return;
      }
      if (!bt.isNullOrNil(null))
      {
        int j = 0;
        int i = j;
        Object localObject;
        if (com.tencent.mm.bj.d.iru != null)
        {
          i = j;
          if (com.tencent.mm.bj.d.iru.GK(this.cWM.BYG.field_username))
          {
            localObject = com.tencent.mm.bj.d.iru.GJ(this.cWM.BYG.field_username);
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((List)localObject).contains(this.cWM.fFr())) {
                i = 1;
              }
            }
          }
        }
        if (i == 0)
        {
          localObject = new d.a(this.cWM.JOR.getContext());
          ((d.a)localObject).aXG(null);
          ((d.a)localObject).afl(2131760315).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35465);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35465);
            }
          });
          ((d.a)localObject).fMb().show();
          AppMethodBeat.o(35470);
          return;
        }
      }
      ((ao)this.cWM.bh(ao.class)).aWj("fromPluginLocation");
    }
    AppMethodBeat.o(35470);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35473);
    lh locallh = new lh();
    locallh.dyD.dyx = 0;
    locallh.dyD.language = ac.fks();
    if (w.vF(this.cWM.BYG.field_username)) {}
    for (locallh.dyD.dyF = true;; locallh.dyD.dyF = false)
    {
      com.tencent.mm.sdk.b.a.IbL.l(locallh);
      AppMethodBeat.o(35473);
      return;
    }
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35474);
    bw localbw = new bw();
    com.tencent.mm.sdk.b.a.IbL.l(localbw);
    AppMethodBeat.o(35474);
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
          fEv();
          AppMethodBeat.o(35471);
          return;
        }
        fEw();
        AppMethodBeat.o(35471);
        return;
      }
      h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131761869), this.cWM.JOR.getMMResources().getString(2131761885), this.cWM.JOR.getMMResources().getString(2131760598), this.cWM.JOR.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35466);
          paramAnonymousDialogInterface = ai.this.cWM.JOR;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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