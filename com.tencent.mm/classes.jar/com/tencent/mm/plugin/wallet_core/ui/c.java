package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.an.j;
import com.tencent.mm.api.q;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.protocal.protobuf.fml;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements com.tencent.mm.am.h, com.tencent.mm.pluginsdk.c.a
{
  private CheckBoxPreference VLf;
  private au contact;
  private Context context;
  private Dialog pIx = null;
  private w rYw;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference xvc;
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cZS()
  {
    AppMethodBeat.i(301230);
    com.tencent.mm.ui.base.k.a(this.context, this.context.getString(a.i.wallet_unknown_err), "", this.context.getString(a.i.wallet_alert_btn_i_know), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(301272);
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "click AlertDialog");
        AppMethodBeat.o(301272);
      }
    });
    AppMethodBeat.o(301230);
  }
  
  private void dvr()
  {
    AppMethodBeat.i(301228);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    localHelperHeaderPreference.bz(this.contact.field_username, this.contact.aSV(), this.context.getString(a.i.contact_info_wxpay_hk_notify_switch_tip));
    if (com.tencent.mm.contact.d.rs(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.eh("contact_info_wxpay_hk_notify_install", true);
      this.screen.eh("contact_info_wxpay_hk_notify_uninstall", false);
      this.screen.eh("contact_info_wxpay_hk_notify_go_to", false);
      this.screen.eh("contact_info_wxpay_hk_notify_top", false);
      this.screen.eh("contact_info_wxpay_hk_notify_not_disturb", false);
      this.screen.eh("contact_info_wxpay_hk_notify_help", false);
      this.screen.eh("contact_info_wxpay_hk_notify_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxV(this.contact.field_username)) {
        this.VLf.setChecked(true);
      }
      while (this.contact.aGe())
      {
        this.xvc.setChecked(true);
        AppMethodBeat.o(301228);
        return;
        this.VLf.setChecked(false);
      }
      this.xvc.setChecked(false);
      AppMethodBeat.o(301228);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.eh("contact_info_wxpay_hk_notify_install", false);
    this.screen.eh("contact_info_wxpay_hk_notify_uninstall", true);
    this.screen.eh("contact_info_wxpay_hk_notify_go_to", true);
    this.screen.eh("contact_info_wxpay_hk_notify_top", true);
    this.screen.eh("contact_info_wxpay_hk_notify_not_disturb", true);
    this.screen.eh("contact_info_wxpay_hk_notify_help", true);
    this.screen.eh("contact_info_wxpay_hk_notify_clear_data", true);
    AppMethodBeat.o(301228);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(301241);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "onAttach");
    this.screen = paramf;
    this.contact = paramau;
    paramf.aBe(a.m.contact_info_pref_wxpay_hk_notify);
    this.VLf = ((CheckBoxPreference)paramf.bAi("contact_info_wxpay_hk_notify_top"));
    this.xvc = ((CheckBoxPreference)paramf.bAi("contact_info_wxpay_hk_notify_not_disturb"));
    dvr();
    com.tencent.mm.kernel.h.aZW().a(6855, this);
    paramf = new com.tencent.mm.plugin.wallet_core.c.i();
    com.tencent.mm.kernel.h.aZW().a(paramf, 0);
    AppMethodBeat.o(301241);
    return true;
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(301250);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_hk_notify_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.br.c.g(this.context, ".ui.chatting.ChattingUI", paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(301250);
      return false;
      if (Util.isEqual("contact_info_wxpay_hk_notify_top", paramString))
      {
        if (this.VLf.isChecked()) {
          ab.K(this.contact.field_username, true);
        } else {
          ab.L(this.contact.field_username, true);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_hk_notify_not_disturb", paramString))
      {
        if (this.xvc.isChecked()) {
          ab.G(this.contact);
        } else {
          ab.H(this.contact);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_hk_notify_help", paramString))
      {
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "click Help button ");
        com.tencent.mm.kernel.h.baF();
        paramString = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adfW, null);
        if (!Util.isNullOrNil(paramString))
        {
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "jump to h5:%s ", new Object[] { paramString });
          com.tencent.mm.wallet_core.ui.i.bC(this.context, paramString);
        }
        else
        {
          cZS();
        }
      }
      else if (Util.isEqual("contact_info_wxpay_hk_notify_clear_data", paramString))
      {
        com.tencent.mm.ui.base.k.b(this.context, this.context.getString(a.i.contact_info_clear_data), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(301278);
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLO("gh_b4af18eac3d5");
            AppMethodBeat.o(301278);
          }
        }, null);
      }
      else
      {
        Object localObject;
        if (Util.isEqual("contact_info_wxpay_hk_notify_install", paramString))
        {
          paramString = this.context;
          this.context.getString(a.i.app_tip);
          this.rYw = com.tencent.mm.ui.base.k.a(paramString, this.context.getString(a.i.settings_plugins_installing), true, null);
          this.rYw.show();
          com.tencent.mm.kernel.h.aZW().a(30, this);
          paramString = new LinkedList();
          paramString.add("gh_b4af18eac3d5");
          localObject = new LinkedList();
          ((LinkedList)localObject).add(Integer.valueOf(1));
          paramString = new v(paramString, (List)localObject, "", "");
          com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        }
        else if (Util.isEqual("contact_info_wxpay_hk_notify_uninstall", paramString))
        {
          paramString = new com.tencent.mm.ui.widget.a.f(this.context, 1, true);
          localObject = new TextView(this.context);
          ((TextView)localObject).setGravity(17);
          ((TextView)localObject).setHeight(com.tencent.mm.cd.a.fromDPToPix(this.context, 56));
          ((TextView)localObject).setTextSize(12.0F);
          ((TextView)localObject).setTextColor(this.context.getResources().getColor(a.c.FG_1));
          ((TextView)localObject).setText(this.context.getResources().getString(a.i.contact_info_wxpay_hk_notify_bottomsheet_title));
          paramString.af((View)localObject, false);
          paramString.ageZ = true;
          paramString.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
            {
              AppMethodBeat.i(301269);
              paramAnonymouss.c(0, c.d(c.this).getResources().getString(a.i.contact_info_wxpay_hk_notify_bottomsheet_content));
              AppMethodBeat.o(301269);
            }
          };
          paramString.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(301262);
              Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "click bottomsheet ");
              com.tencent.mm.kernel.h.baF();
              paramAnonymousMenuItem = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adfX, null);
              if (!Util.isNullOrNil(paramAnonymousMenuItem))
              {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "jump to h5:%s ", new Object[] { paramAnonymousMenuItem });
                com.tencent.mm.wallet_core.ui.i.a(c.d(c.this), paramAnonymousMenuItem, false, 4);
                AppMethodBeat.o(301262);
                return;
              }
              c.e(c.this);
              AppMethodBeat.o(301262);
            }
          };
          paramString.dDn();
        }
      }
    }
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(301242);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "onDetach");
    com.tencent.mm.kernel.h.aZW().b(30, this);
    com.tencent.mm.kernel.h.aZW().b(6855, this);
    AppMethodBeat.o(301242);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(301252);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "onActivityResult");
    if (paramInt1 == 4)
    {
      Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "requestCode == REQUEST_CODE_DISABLE_PAY_HK");
      if (this.pIx == null) {
        this.pIx = com.tencent.mm.ui.base.k.a(this.context, 3, a.j.LuckyMoneyNoAnimDialog, this.context.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(301265);
            if ((c.a(c.this) != null) && (c.a(c.this).isShowing())) {
              c.a(c.this).dismiss();
            }
            AppMethodBeat.o(301265);
          }
        });
      }
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(301268);
          if ((c.a(c.this) != null) && (c.a(c.this).isShowing()))
          {
            c.a(c.this).dismiss();
            c.b(c.this);
          }
          if (!com.tencent.mm.contact.d.rs(c.c(c.this).field_type))
          {
            Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "!contact.isContact() close page");
            Object localObject1 = c.c(c.this).field_username;
            br.a((String)localObject1, new br.a()
            {
              public final boolean aMJ()
              {
                return false;
              }
              
              public final void aMK()
              {
                AppMethodBeat.i(301223);
                af.bHf().Mo(this.MUJ);
                AppMethodBeat.o(301223);
              }
            });
            com.tencent.mm.modelsimple.ac.aY((String)localObject1, 15);
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxK((String)localObject1);
            af.bHe().MJ((String)localObject1);
            af.bHl().aLw((String)localObject1);
            af.bHo().aLw((String)localObject1);
            Object localObject2 = new Intent();
            ((Intent)localObject2).setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
            ((Intent)localObject2).addFlags(67108864);
            localObject1 = (Activity)c.d(c.this);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayHKNotify$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayHKNotify$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(301268);
        }
      }, 1000L);
    }
    AppMethodBeat.o(301252);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(301260);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    Object localObject1;
    Object localObject2;
    if ((paramp instanceof v))
    {
      com.tencent.mm.kernel.h.aZW().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
      }
      for (;;)
      {
        if (this.rYw != null) {
          this.rYw.dismiss();
        }
        dvr();
        AppMethodBeat.o(301260);
        return;
        localObject1 = ((v)paramp).iIc();
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramp = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_b4af18eac3d5");
        if ((paramp != null) && (!Util.isNullOrNil((String)localObject1))) {
          break;
        }
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramp);
        paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(paramp.field_username);
        if (paramString != null) {
          ((q)com.tencent.mm.kernel.h.ax(q.class)).a(paramString);
        }
        com.tencent.mm.kernel.h.baE().ban().B(327825, Boolean.TRUE);
      }
      if (!au.bxa(paramp.field_username)) {
        break label1266;
      }
      localObject2 = Util.nullAsNil(paramp.field_username);
      paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU((String)localObject2);
      if (paramString != null) {
        paramString.field_username = ((String)localObject1);
      }
      ((q)com.tencent.mm.kernel.h.ax(q.class)).hV((String)localObject2);
      paramp.Bd((String)localObject2);
    }
    for (;;)
    {
      paramp.setUsername((String)localObject1);
      if ((int)paramp.maN == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC(paramp);
      }
      if ((int)paramp.maN <= 0)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "addContact : insert contact failed");
        break;
      }
      ab.I(paramp);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramp.field_username);
      if (paramString != null)
      {
        ((q)com.tencent.mm.kernel.h.ax(q.class)).b(paramString);
        break;
      }
      paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(((az)localObject1).field_username);
      if ((paramString == null) || (paramString.aAJ()))
      {
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "shouldUpdate");
        az.a.okP.aZ(((az)localObject1).field_username, "");
        com.tencent.mm.modelavatar.d.LA(((az)localObject1).field_username);
        break;
      }
      if (!((au)localObject1).iZI()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((az)localObject1).kak) });
      az.a.okP.aZ(((az)localObject1).field_username, "");
      com.tencent.mm.modelavatar.d.LA(((az)localObject1).field_username);
      break;
      if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.i))
      {
        com.tencent.mm.kernel.h.aZW().b(6855, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.i)paramp;
          if (paramString.VxA == null) {}
          for (paramString = new cym();; paramString = paramString.VxA)
          {
            if (paramString != null)
            {
              if (!Util.isNullOrNil(paramString.aaDp))
              {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "response.support_center_url：%s", new Object[] { paramString.aaDp });
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().set(at.a.adfW, paramString.aaDp);
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().iZy();
              }
              if (!Util.isNullOrNil(paramString.aaDo))
              {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "response.disable_hk_wallet_url：%s", new Object[] { paramString.aaDo });
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().set(at.a.adfX, paramString.aaDo);
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().iZy();
              }
            }
            if ((paramString == null) || (paramString.aaxA == null) || (paramString.aaxA.aaxw == null) || (paramString.aaxA.aaxw.isEmpty())) {
              break label1236;
            }
            paramInt2 = this.screen.cs("contact_info_wxpay_hk_notify_go_to");
            paramString = paramString.aaxA.aaxw.iterator();
            for (;;)
            {
              if (!paramString.hasNext()) {
                break label1220;
              }
              paramp = (ddc)paramString.next();
              if (!paramp.aaIH.isEmpty()) {
                break;
              }
              Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "ItemSectionViewData is null");
            }
          }
          paramInt1 = paramInt2 + 1;
          localObject1 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject1, paramInt1);
          paramp = paramp.aaIH.iterator();
          for (;;)
          {
            paramInt2 = paramInt1;
            if (!paramp.hasNext()) {
              break;
            }
            Object localObject3 = (fll)paramp.next();
            if ((((fll)localObject3).abLS.isEmpty()) || (((fll)localObject3).abLT.isEmpty()))
            {
              Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "TableCellViewData data null");
            }
            else
            {
              localObject1 = (fmp)((fll)localObject3).abLS.get(0);
              localObject2 = (fmp)((fll)localObject3).abLT.get(0);
              localObject3 = ((fll)localObject3).YCV;
              if ((((fmp)localObject1).abMT.isEmpty()) || (Util.isNullOrNil(((fml)((fmp)localObject1).abMT.get(0)).text)) || (localObject3 == null))
              {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "TableCellViewData inner data null");
              }
              else
              {
                paramInt1 += 1;
                Preference local6 = new Preference(this.context)
                {
                  public final void onBindView(View paramAnonymousView)
                  {
                    AppMethodBeat.i(301264);
                    super.onBindView(paramAnonymousView);
                    if (this.adZO != null) {
                      paramAnonymousView.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
                      {
                        public final void dr(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(301293);
                          c.6.this.adZO.gAW();
                          AppMethodBeat.o(301293);
                        }
                      });
                    }
                    AppMethodBeat.o(301264);
                  }
                };
                local6.setTitle(((fml)((fmp)localObject1).abMT.get(0)).text);
                local6.setLayoutResource(a.g.mm_preference);
                if ((!((fmp)localObject2).abMT.isEmpty()) && (!Util.isNullOrNil(((fml)((fmp)localObject2).abMT.get(0)).text))) {
                  local6.aS(((fml)((fmp)localObject2).abMT.get(0)).text);
                }
                this.screen.a(local6, paramInt1);
                local6.adZO = new Preference.b()
                {
                  public final boolean gAW()
                  {
                    AppMethodBeat.i(301271);
                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "text(%s) click!", new Object[] { ((fml)this.VLk.abMT.get(0)).text });
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("key_tiny_app_scene", 1165);
                    com.tencent.mm.plugin.wallet_core.utils.n.a(c.d(c.this), this.VLl, localBundle);
                    AppMethodBeat.o(301271);
                    return true;
                  }
                };
              }
            }
          }
          label1220:
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(301260);
          return;
          label1236:
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "NetSceneGetPayHKPlugin no data");
          AppMethodBeat.o(301260);
          return;
        }
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "NetSceneGetPayHKPlugin fail!");
      }
      AppMethodBeat.o(301260);
      return;
      label1266:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */