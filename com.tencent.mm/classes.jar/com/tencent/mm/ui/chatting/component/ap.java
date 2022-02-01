package com.tencent.mm.ui.chatting.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.cl;
import com.tencent.mm.autogen.a.nw;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.component.api.ag;
import com.tencent.mm.ui.chatting.component.api.ba;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ag.class)
public class ap
  extends a
  implements ag
{
  public final boolean cK(cc paramcc)
  {
    AppMethodBeat.i(35467);
    if (paramcc.fxT())
    {
      an.ct(paramcc);
      this.hlc.jpK();
      AppMethodBeat.o(35467);
      return true;
    }
    AppMethodBeat.o(35467);
    return false;
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35473);
    nw localnw = new nw();
    localnw.hQs.hQm = 0;
    localnw.hQs.language = LocaleUtil.getApplicationLanguage();
    if (au.bwE(this.hlc.Uxa.field_username)) {}
    for (localnw.hQs.hQu = true;; localnw.hQs.hQu = false)
    {
      localnw.publish();
      AppMethodBeat.o(35473);
      return;
    }
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35474);
    new cl().publish();
    AppMethodBeat.o(35474);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35472);
    super.jqF();
    nw localnw = new nw();
    localnw.hQs.hQm = 2;
    localnw.publish();
    AppMethodBeat.o(35472);
  }
  
  public final void jte()
  {
    AppMethodBeat.i(35468);
    final boolean bool1;
    if ((au.bwO(this.hlc.getTalkerUserName())) || (au.bwF(this.hlc.Uxa.field_username))) {
      if ((((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).bl(this.hlc.Uxa.field_openImAppid, 0) & 0x1000) == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((ab.II(this.hlc.Uxa.field_username)) && ((z.bBN() & 0x8) != 0)) {}
      for (final boolean bool2 = true;; bool2 = false)
      {
        com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(this.hlc.aezO.getContext(), 1, false);
        localf.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymouss)
          {
            AppMethodBeat.i(35463);
            if (bool2)
            {
              paramAnonymouss.c(1, ap.this.hlc.aezO.getMMResources().getString(R.l.location_send_poi));
              paramAnonymouss.c(2, ap.this.hlc.aezO.getMMResources().getString(R.l.location_send_share));
              AppMethodBeat.o(35463);
              return;
            }
            if ((!ap.a(ap.this)) || (bool1))
            {
              paramAnonymouss.c(1, ap.this.hlc.aezO.getMMResources().getString(R.l.location_send_poi));
              AppMethodBeat.o(35463);
              return;
            }
            paramAnonymouss.c(1, ap.this.hlc.aezO.getMMResources().getString(R.l.location_send_poi));
            paramAnonymouss.c(2, ap.this.hlc.aezO.getMMResources().getString(R.l.location_send_share));
            AppMethodBeat.o(35463);
          }
        };
        localf.GAC = new u.i()
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
              if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.s(ap.this.hlc.aezO.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.s(ap.this.hlc.aezO.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label291;
                  }
                  if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.sdk.c.a.b(ap.this.hlc.aezO.getContext(), ap.this.hlc.aezO.getMMResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30763, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ap.this.hlc.aezO.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 67);
                AppMethodBeat.o(35464);
                return;
              }
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ap.this.hlc.aezO.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 67, null);
              Log.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label291:
              ap.this.jtf();
              AppMethodBeat.o(35464);
              return;
              if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
              {
                if ((com.tencent.mm.pluginsdk.permission.b.s(ap.this.hlc.aezO.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.s(ap.this.hlc.aezO.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label557;
                  }
                  if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue()) {
                    break;
                  }
                  com.tencent.mm.plugin.account.sdk.c.a.b(ap.this.hlc.aezO.getContext(), ap.this.hlc.aezO.getMMResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30762, true);
                  AppMethodBeat.o(35464);
                  return;
                }
                com.tencent.mm.pluginsdk.permission.b.a(ap.this.hlc.aezO.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68);
                AppMethodBeat.o(35464);
                return;
              }
              bool = com.tencent.mm.pluginsdk.permission.b.a(ap.this.hlc.aezO.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68, null);
              Log.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
              if (!bool)
              {
                AppMethodBeat.o(35464);
                return;
              }
              label557:
              ap.this.jtg();
            }
          }
        };
        localf.dDn();
        AppMethodBeat.o(35468);
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
  
  public final void jtf()
  {
    AppMethodBeat.i(35469);
    com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(1), "" });
    Intent localIntent = new Intent();
    if (this.hlc.juG()) {
      localIntent.putExtra("type_tag", 2);
    }
    for (;;)
    {
      localIntent.putExtra("map_view_type", 0);
      localIntent.putExtra("map_sender_name", this.hlc.getSelfUserName());
      localIntent.putExtra("map_talker_name", this.hlc.getTalkerUserName());
      c.b(this.hlc.aezO.getContext(), "location", ".ui.RedirectUI", localIntent);
      l.kK(3, 10);
      AppMethodBeat.o(35469);
      return;
      localIntent.putExtra("type_tag", 1);
    }
  }
  
  public final void jtg()
  {
    AppMethodBeat.i(35470);
    if ((!com.tencent.mm.n.a.dm(this.hlc.aezO.getContext())) && (!com.tencent.mm.n.a.dl(this.hlc.aezO.getContext())) && (!com.tencent.mm.n.a.dp(this.hlc.aezO.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMO(this.hlc.getTalkerUserName()))
      {
        Log.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        k.s(this.hlc.aezO.getContext(), R.l.multitalk_exit_tip, R.l.app_tip);
        AppMethodBeat.o(35470);
        return;
      }
      if (!Util.isNullOrNil(null))
      {
        int j = 0;
        int i = j;
        Object localObject;
        if (com.tencent.mm.bd.d.oXN != null)
        {
          i = j;
          if (com.tencent.mm.bd.d.oXN.Py(this.hlc.Uxa.field_username))
          {
            localObject = com.tencent.mm.bd.d.oXN.Px(this.hlc.Uxa.field_username);
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((List)localObject).contains(this.hlc.getSelfUserName())) {
                i = 1;
              }
            }
          }
        }
        if (i == 0)
        {
          localObject = new e.a(this.hlc.aezO.getContext());
          ((e.a)localObject).bDw(null);
          ((e.a)localObject).aER(R.l.i_know_it).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35465);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35465);
            }
          });
          ((e.a)localObject).jHH().show();
          AppMethodBeat.o(35470);
          return;
        }
      }
      ((ba)this.hlc.cm(ba.class)).bAT("fromPluginLocation");
      l.kK(3, 10);
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
          jtf();
          AppMethodBeat.o(35471);
          return;
        }
        jtg();
        AppMethodBeat.o(35471);
        return;
      }
      k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.permission_location_request_again_msg), this.hlc.aezO.getMMResources().getString(R.l.permission_tips_title), this.hlc.aezO.getMMResources().getString(R.l.jump_to_settings), this.hlc.aezO.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35466);
          com.tencent.mm.pluginsdk.permission.b.lx(ap.this.hlc.aezO.getContext());
          AppMethodBeat.o(35466);
        }
      }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ap
 * JD-Core Version:    0.7.0.1
 */