package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ad.class)
public class ak
  extends a
  implements ad
{
  public final boolean bU(ca paramca)
  {
    AppMethodBeat.i(35467);
    if (paramca.dOS())
    {
      com.tencent.mm.ui.chatting.ak.bL(paramca);
      this.dom.BN(true);
      AppMethodBeat.o(35467);
      return true;
    }
    AppMethodBeat.o(35467);
    return false;
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35473);
    ly locally = new ly();
    locally.dRv.dRq = 0;
    locally.dRv.language = LocaleUtil.getApplicationLanguage();
    if (ab.Eq(this.dom.GUe.field_username)) {}
    for (locally.dRv.dRx = true;; locally.dRv.dRx = false)
    {
      EventCenter.instance.publish(locally);
      AppMethodBeat.o(35473);
      return;
    }
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35474);
    by localby = new by();
    EventCenter.instance.publish(localby);
    AppMethodBeat.o(35474);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35472);
    super.gOK();
    ly locally = new ly();
    locally.dRv.dRq = 2;
    EventCenter.instance.publish(locally);
    AppMethodBeat.o(35472);
  }
  
  public final void gQI()
  {
    AppMethodBeat.i(35468);
    final boolean bool1;
    if ((com.tencent.mm.storage.as.bjp(this.dom.getTalkerUserName())) || (ab.Iy(this.dom.GUe.field_username))) {
      if ((((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).RZ(this.dom.GUe.field_openImAppid) & 0x1000) == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((ab.IB(this.dom.GUe.field_username)) && ((z.aUT() & 0x8) != 0)) {}
      for (final boolean bool2 = true;; bool2 = false)
      {
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.dom.Pwc.getContext(), 1, false);
        locale.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymousm)
          {
            AppMethodBeat.i(35463);
            if (bool2)
            {
              paramAnonymousm.d(1, ak.this.dom.Pwc.getMMResources().getString(2131762473));
              paramAnonymousm.d(2, ak.this.dom.Pwc.getMMResources().getString(2131762474));
              AppMethodBeat.o(35463);
              return;
            }
            if ((!ak.a(ak.this)) || (bool1))
            {
              paramAnonymousm.d(1, ak.this.dom.Pwc.getMMResources().getString(2131762473));
              AppMethodBeat.o(35463);
              return;
            }
            paramAnonymousm.d(1, ak.this.dom.Pwc.getMMResources().getString(2131762473));
            paramAnonymousm.d(2, ak.this.dom.Pwc.getMMResources().getString(2131762474));
            AppMethodBeat.o(35463);
          }
        };
        locale.HLY = new o.g()
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
              if (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.n(ak.this.dom.Pwc.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(ak.this.dom.Pwc.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label291;
                  }
                  if (((Boolean)g.aAh().azQ().get(ar.a.Oho, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ak.this.dom.Pwc.getContext(), ak.this.dom.Pwc.getMMResources().getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), 30763, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ak.this.dom.Pwc.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 67);
                AppMethodBeat.o(35464);
                return;
              }
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ak.this.dom.Pwc.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 67, null, null);
              Log.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label291:
              ak.this.gQJ();
              AppMethodBeat.o(35464);
              return;
              if (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.n(ak.this.dom.Pwc.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(ak.this.dom.Pwc.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label557;
                  }
                  if (((Boolean)g.aAh().azQ().get(ar.a.Oho, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.a.b.a.b(ak.this.dom.Pwc.getContext(), ak.this.dom.Pwc.getMMResources().getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), 30762, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ak.this.dom.Pwc.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68);
                AppMethodBeat.o(35464);
                return;
              }
              bool = com.tencent.mm.pluginsdk.permission.b.a(ak.this.dom.Pwc.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68, null, null);
              Log.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label557:
              ak.this.gQK();
            }
          }
        };
        locale.dGm();
        AppMethodBeat.o(35468);
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
  
  public final void gQJ()
  {
    AppMethodBeat.i(35469);
    com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(1), "" });
    Intent localIntent = new Intent();
    if (this.dom.gRM()) {
      localIntent.putExtra("type_tag", 2);
    }
    for (;;)
    {
      localIntent.putExtra("map_view_type", 0);
      localIntent.putExtra("map_sender_name", this.dom.gRI());
      localIntent.putExtra("map_talker_name", this.dom.getTalkerUserName());
      c.b(this.dom.Pwc.getContext(), "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(35469);
      return;
      localIntent.putExtra("type_tag", 1);
    }
  }
  
  public final void gQK()
  {
    AppMethodBeat.i(35470);
    if ((!com.tencent.mm.q.a.cC(this.dom.Pwc.getContext())) && (!com.tencent.mm.q.a.cA(this.dom.Pwc.getContext())) && (!com.tencent.mm.q.a.cE(this.dom.Pwc.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.model.d)g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH(this.dom.getTalkerUserName()))
      {
        Log.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        com.tencent.mm.ui.base.h.n(this.dom.Pwc.getContext(), 2131763265, 2131755998);
        AppMethodBeat.o(35470);
        return;
      }
      if (!Util.isNullOrNil(null))
      {
        int j = 0;
        int i = j;
        Object localObject;
        if (com.tencent.mm.bi.d.jpA != null)
        {
          i = j;
          if (com.tencent.mm.bi.d.jpA.PZ(this.dom.GUe.field_username))
          {
            localObject = com.tencent.mm.bi.d.jpA.PY(this.dom.GUe.field_username);
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((List)localObject).contains(this.dom.gRI())) {
                i = 1;
              }
            }
          }
        }
        if (i == 0)
        {
          localObject = new d.a(this.dom.Pwc.getContext());
          ((d.a)localObject).boo(null);
          ((d.a)localObject).aoV(2131761757).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35465);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35465);
            }
          });
          ((d.a)localObject).hbn().show();
          AppMethodBeat.o(35470);
          return;
        }
      }
      ((com.tencent.mm.ui.chatting.d.b.as)this.dom.bh(com.tencent.mm.ui.chatting.d.b.as.class)).bmP("fromPluginLocation");
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
          gQJ();
          AppMethodBeat.o(35471);
          return;
        }
        gQK();
        AppMethodBeat.o(35471);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131763874), this.dom.Pwc.getMMResources().getString(2131763890), this.dom.Pwc.getMMResources().getString(2131762043), this.dom.Pwc.getMMResources().getString(2131756929), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35466);
          paramAnonymousDialogInterface = ak.this.dom.Pwc;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35466);
        }
      }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ak
 * JD-Core Version:    0.7.0.1
 */