package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
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

@com.tencent.mm.ui.chatting.c.a.a(eYT=z.class)
public class ag
  extends a
  implements z
{
  public final boolean bx(bl parambl)
  {
    AppMethodBeat.i(35467);
    if (parambl.cxD())
    {
      aj.br(parambl);
      this.cOd.wc(true);
      AppMethodBeat.o(35467);
      return true;
    }
    AppMethodBeat.o(35467);
    return false;
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35473);
    kp localkp = new kp();
    localkp.dpf.doZ = 0;
    localkp.dpf.aSt = ac.eFu();
    if (w.pF(this.cOd.zgX.field_username)) {}
    for (localkp.dpf.dph = true;; localkp.dpf.dph = false)
    {
      com.tencent.mm.sdk.b.a.ESL.l(localkp);
      AppMethodBeat.o(35473);
      return;
    }
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35474);
    com.tencent.mm.g.a.bt localbt = new com.tencent.mm.g.a.bt();
    com.tencent.mm.sdk.b.a.ESL.l(localbt);
    AppMethodBeat.o(35474);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35472);
    super.eWx();
    kp localkp = new kp();
    localkp.dpf.doZ = 2;
    com.tencent.mm.sdk.b.a.ESL.l(localkp);
    AppMethodBeat.o(35472);
  }
  
  public final void eYl()
  {
    AppMethodBeat.i(35468);
    final boolean bool1;
    if ((af.aHH(this.cOd.getTalkerUserName())) || (w.sn(this.cOd.zgX.field_username))) {
      if ((((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).Bi(this.cOd.zgX.field_openImAppid) & 0x1000) == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((w.sp(this.cOd.zgX.field_username)) && ((u.arq() & 0x8) != 0)) {}
      for (final boolean bool2 = true;; bool2 = false)
      {
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.cOd.GzJ.getContext(), 1, false);
        locale.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(35463);
            if (bool2)
            {
              paramAnonymousl.c(1, ag.this.cOd.GzJ.getMMResources().getString(2131760732));
              paramAnonymousl.c(2, ag.this.cOd.GzJ.getMMResources().getString(2131760733));
              AppMethodBeat.o(35463);
              return;
            }
            if ((!ag.a(ag.this)) || (bool1))
            {
              paramAnonymousl.c(1, ag.this.cOd.GzJ.getMMResources().getString(2131760732));
              AppMethodBeat.o(35463);
              return;
            }
            paramAnonymousl.c(1, ag.this.cOd.GzJ.getMMResources().getString(2131760732));
            paramAnonymousl.c(2, ag.this.cOd.GzJ.getMMResources().getString(2131760733));
            AppMethodBeat.o(35463);
          }
        };
        locale.HrY = new n.d()
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
              if (com.tencent.mm.ax.b.yL((String)g.afB().afk().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.o(ag.this.cOd.GzJ.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(ag.this.cOd.GzJ.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label291;
                  }
                  if (((Boolean)g.afB().afk().get(ae.a.FtT, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ag.this.cOd.GzJ.getContext(), ag.this.cOd.GzJ.getMMResources().getString(2131760740, new Object[] { ac.eFu() }), 30763, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ag.this.cOd.GzJ.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
                AppMethodBeat.o(35464);
                return;
              }
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ag.this.cOd.GzJ.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67, null, null);
              ad.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label291:
              ag.this.eYm();
              AppMethodBeat.o(35464);
              return;
              if (com.tencent.mm.ax.b.yL((String)g.afB().afk().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.o(ag.this.cOd.GzJ.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(ag.this.cOd.GzJ.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label557;
                  }
                  if (((Boolean)g.afB().afk().get(ae.a.FtT, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ag.this.cOd.GzJ.getContext(), ag.this.cOd.GzJ.getMMResources().getString(2131760740, new Object[] { ac.eFu() }), 30762, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ag.this.cOd.GzJ.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
                AppMethodBeat.o(35464);
                return;
              }
              bool = com.tencent.mm.pluginsdk.permission.b.a(ag.this.cOd.GzJ.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68, null, null);
              ad.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label557:
              ag.this.eYn();
            }
          }
        };
        locale.csG();
        AppMethodBeat.o(35468);
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
  
  public final void eYm()
  {
    AppMethodBeat.i(35469);
    com.tencent.mm.plugin.report.service.h.vKh.f(12809, new Object[] { Integer.valueOf(1), "" });
    Intent localIntent = new Intent();
    if (this.cOd.eZb()) {
      localIntent.putExtra("type_tag", 2);
    }
    for (;;)
    {
      localIntent.putExtra("map_view_type", 0);
      localIntent.putExtra("map_sender_name", this.cOd.eYX());
      localIntent.putExtra("map_talker_name", this.cOd.getTalkerUserName());
      com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(35469);
      return;
      localIntent.putExtra("type_tag", 1);
    }
  }
  
  public final void eYn()
  {
    AppMethodBeat.i(35470);
    if ((!com.tencent.mm.r.a.ce(this.cOd.GzJ.getContext())) && (!com.tencent.mm.r.a.cc(this.cOd.GzJ.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.model.a)g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahp(this.cOd.getTalkerUserName()))
      {
        ad.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        com.tencent.mm.ui.base.h.j(this.cOd.GzJ.getContext(), 2131761410, 2131755906);
        AppMethodBeat.o(35470);
        return;
      }
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(null))
      {
        int j = 0;
        int i = j;
        Object localObject;
        if (com.tencent.mm.bj.d.hxx != null)
        {
          i = j;
          if (com.tencent.mm.bj.d.hxx.zA(this.cOd.zgX.field_username))
          {
            localObject = com.tencent.mm.bj.d.hxx.zz(this.cOd.zgX.field_username);
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((List)localObject).contains(this.cOd.eYX())) {
                i = 1;
              }
            }
          }
        }
        if (i == 0)
        {
          localObject = new d.a(this.cOd.GzJ.getContext());
          ((d.a)localObject).aMg(null);
          ((d.a)localObject).aaB(2131760315).b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35465);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35465);
            }
          });
          ((d.a)localObject).fft().show();
          AppMethodBeat.o(35470);
          return;
        }
      }
      ((ak)this.cOd.be(ak.class)).aKN("fromPluginLocation");
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
          eYm();
          AppMethodBeat.o(35471);
          return;
        }
        eYn();
        AppMethodBeat.o(35471);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131761869), this.cOd.GzJ.getMMResources().getString(2131761885), this.cOd.GzJ.getMMResources().getString(2131760598), this.cOd.GzJ.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35466);
          paramAnonymousDialogInterface = ag.this.cOd.GzJ;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35466);
        }
      }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ag
 * JD-Core Version:    0.7.0.1
 */