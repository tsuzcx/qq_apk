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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.j;
import com.tencent.mm.api.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eqh;
import com.tencent.mm.protocal.protobuf.eqi;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.an.i, com.tencent.mm.pluginsdk.c.a
{
  private CheckBoxPreference OUS;
  private as contact;
  private Context context;
  private Dialog mLP = null;
  private s oTk;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference uoF;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cQY()
  {
    AppMethodBeat.i(269995);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    localHelperHeaderPreference.bf(this.contact.field_username, this.contact.ays(), this.context.getString(a.i.contact_info_wxpay_hk_notify_switch_tip));
    if (com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.dz("contact_info_wxpay_hk_notify_install", true);
      this.screen.dz("contact_info_wxpay_hk_notify_uninstall", false);
      this.screen.dz("contact_info_wxpay_hk_notify_go_to", false);
      this.screen.dz("contact_info_wxpay_hk_notify_top", false);
      this.screen.dz("contact_info_wxpay_hk_notify_not_disturb", false);
      this.screen.dz("contact_info_wxpay_hk_notify_help", false);
      this.screen.dz("contact_info_wxpay_hk_notify_clear_data", false);
      if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF(this.contact.field_username)) {
        this.OUS.setChecked(true);
      }
      while (this.contact.aeg())
      {
        this.uoF.setChecked(true);
        AppMethodBeat.o(269995);
        return;
        this.OUS.setChecked(false);
      }
      this.uoF.setChecked(false);
      AppMethodBeat.o(269995);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.dz("contact_info_wxpay_hk_notify_install", false);
    this.screen.dz("contact_info_wxpay_hk_notify_uninstall", true);
    this.screen.dz("contact_info_wxpay_hk_notify_go_to", true);
    this.screen.dz("contact_info_wxpay_hk_notify_top", true);
    this.screen.dz("contact_info_wxpay_hk_notify_not_disturb", true);
    this.screen.dz("contact_info_wxpay_hk_notify_help", true);
    this.screen.dz("contact_info_wxpay_hk_notify_clear_data", true);
    AppMethodBeat.o(269995);
  }
  
  private void cxh()
  {
    AppMethodBeat.i(270000);
    com.tencent.mm.ui.base.h.a(this.context, this.context.getString(a.i.wallet_unknown_err), "", this.context.getString(a.i.wallet_alert_btn_i_know), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(199073);
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "click AlertDialog");
        AppMethodBeat.o(199073);
      }
    });
    AppMethodBeat.o(270000);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(269989);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "onAttach");
    this.screen = paramf;
    this.contact = paramas;
    paramf.auC(a.m.contact_info_pref_wxpay_hk_notify);
    this.OUS = ((CheckBoxPreference)paramf.byG("contact_info_wxpay_hk_notify_top"));
    this.uoF = ((CheckBoxPreference)paramf.byG("contact_info_wxpay_hk_notify_not_disturb"));
    cQY();
    com.tencent.mm.kernel.h.aGY().a(6855, this);
    paramf = new com.tencent.mm.plugin.wallet_core.c.i();
    com.tencent.mm.kernel.h.aGY().a(paramf, 0);
    AppMethodBeat.o(269989);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(269991);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_hk_notify_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.by.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(269991);
      return false;
      if (Util.isEqual("contact_info_wxpay_hk_notify_top", paramString))
      {
        if (this.OUS.isChecked()) {
          ab.G(this.contact.field_username, true);
        } else {
          ab.H(this.contact.field_username, true);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_hk_notify_not_disturb", paramString))
      {
        if (this.uoF.isChecked()) {
          ab.F(this.contact);
        } else {
          ab.G(this.contact);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_hk_notify_help", paramString))
      {
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "click Help button ");
        com.tencent.mm.kernel.h.aHH();
        paramString = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDc, null);
        if (!Util.isNullOrNil(paramString))
        {
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "jump to h5:%s ", new Object[] { paramString });
          g.bA(this.context, paramString);
        }
        else
        {
          cxh();
        }
      }
      else if (Util.isEqual("contact_info_wxpay_hk_notify_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(a.i.contact_info_clear_data), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(269350);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOO("gh_b4af18eac3d5");
            AppMethodBeat.o(269350);
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
          this.oTk = com.tencent.mm.ui.base.h.a(paramString, this.context.getString(a.i.settings_plugins_installing), true, null);
          this.oTk.show();
          com.tencent.mm.kernel.h.aGY().a(30, this);
          paramString = new LinkedList();
          paramString.add("gh_b4af18eac3d5");
          localObject = new LinkedList();
          ((LinkedList)localObject).add(Integer.valueOf(1));
          paramString = new com.tencent.mm.pluginsdk.model.t(paramString, (List)localObject, "", "");
          com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        }
        else if (Util.isEqual("contact_info_wxpay_hk_notify_uninstall", paramString))
        {
          paramString = new e(this.context, 1, true);
          localObject = new TextView(this.context);
          ((TextView)localObject).setGravity(17);
          ((TextView)localObject).setHeight(com.tencent.mm.ci.a.fromDPToPix(this.context, 56));
          ((TextView)localObject).setTextSize(12.0F);
          ((TextView)localObject).setTextColor(this.context.getResources().getColor(a.c.FG_1));
          ((TextView)localObject).setText(this.context.getResources().getString(a.i.contact_info_wxpay_hk_notify_bottomsheet_title));
          paramString.Z((View)localObject, false);
          paramString.Ynb = true;
          paramString.ODT = new b.4(this);
          paramString.ODU = new b.5(this);
          paramString.eik();
        }
      }
    }
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(269990);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "onDetach");
    com.tencent.mm.kernel.h.aGY().b(30, this);
    com.tencent.mm.kernel.h.aGY().b(6855, this);
    AppMethodBeat.o(269990);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(269992);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "onActivityResult");
    if (paramInt1 == 4)
    {
      Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "requestCode == REQUEST_CODE_DISABLE_PAY_HK");
      if (this.mLP == null) {
        this.mLP = com.tencent.mm.ui.base.h.a(this.context, 3, a.j.LuckyMoneyNoAnimDialog, this.context.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(221430);
            if ((b.a(b.this) != null) && (b.a(b.this).isShowing())) {
              b.a(b.this).dismiss();
            }
            AppMethodBeat.o(221430);
          }
        });
      }
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194434);
          if ((b.a(b.this) != null) && (b.a(b.this).isShowing()))
          {
            b.a(b.this).dismiss();
            b.b(b.this);
          }
          if (!com.tencent.mm.contact.d.rk(b.c(b.this).field_type))
          {
            Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "!contact.isContact() close page");
            Object localObject1 = b.c(b.this).field_username;
            bq.a((String)localObject1, new bq.a()
            {
              public final boolean asH()
              {
                return false;
              }
              
              public final void asI()
              {
                AppMethodBeat.i(237283);
                af.bjv().Up(this.GWQ);
                AppMethodBeat.o(237283);
              }
            });
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv((String)localObject1);
            af.bju().UK((String)localObject1);
            af.bjB().aOx((String)localObject1);
            af.bjD().aOx((String)localObject1);
            Object localObject2 = new Intent();
            ((Intent)localObject2).setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
            ((Intent)localObject2).addFlags(67108864);
            localObject1 = (Activity)b.d(b.this);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayHKNotify$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayHKNotify$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(194434);
        }
      }, 1000L);
    }
    AppMethodBeat.o(269992);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(269999);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      com.tencent.mm.kernel.h.aGY().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
      }
      for (;;)
      {
        if (this.oTk != null) {
          this.oTk.dismiss();
        }
        cQY();
        AppMethodBeat.o(269999);
        return;
        localObject1 = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_b4af18eac3d5");
        if ((paramq != null) && (!Util.isNullOrNil((String)localObject1))) {
          break;
        }
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramq);
        paramString = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(paramq.field_username);
        if (paramString != null) {
          ((p)com.tencent.mm.kernel.h.ae(p.class)).a(paramString);
        }
        com.tencent.mm.kernel.h.aHG().aHp().i(327825, Boolean.TRUE);
      }
      if (!ab.Qk(paramq.field_username)) {
        break label1266;
      }
      localObject2 = Util.nullAsNil(paramq.field_username);
      paramString = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu((String)localObject2);
      if (paramString != null) {
        paramString.field_username = ((String)localObject1);
      }
      ((p)com.tencent.mm.kernel.h.ae(p.class)).gv((String)localObject2);
      paramq.Iy((String)localObject2);
    }
    for (;;)
    {
      paramq.setUsername((String)localObject1);
      if ((int)paramq.jxt == 0) {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().aw(paramq);
      }
      if ((int)paramq.jxt <= 0)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "addContact : insert contact failed");
        break;
      }
      ab.H(paramq);
      localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramq.field_username);
      if (paramString != null)
      {
        ((p)com.tencent.mm.kernel.h.ae(p.class)).b(paramString);
        break;
      }
      paramString = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(((ax)localObject1).field_username);
      if ((paramString == null) || (paramString.YR()))
      {
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "shouldUpdate");
        az.a.ltq.aP(((ax)localObject1).field_username, "");
        com.tencent.mm.am.d.TA(((ax)localObject1).field_username);
        break;
      }
      if (!((as)localObject1).hyb()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject1).hDo) });
      az.a.ltq.aP(((ax)localObject1).field_username, "");
      com.tencent.mm.am.d.TA(((ax)localObject1).field_username);
      break;
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.i))
      {
        com.tencent.mm.kernel.h.aGY().b(6855, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.i)paramq;
          if (paramString.OHO == null) {}
          for (paramString = new cij();; paramString = paramString.OHO)
          {
            if (paramString != null)
            {
              if (!Util.isNullOrNil(paramString.Tpn))
              {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "response.support_center_url：%s", new Object[] { paramString.Tpn });
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDc, paramString.Tpn);
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().hxT();
              }
              if (!Util.isNullOrNil(paramString.Tpm))
              {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "response.disable_hk_wallet_url：%s", new Object[] { paramString.Tpm });
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDd, paramString.Tpm);
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().hxT();
              }
            }
            if ((paramString == null) || (paramString.TjY == null) || (paramString.TjY.TjT == null) || (paramString.TjY.TjT.isEmpty())) {
              break label1236;
            }
            paramInt2 = this.screen.bf("contact_info_wxpay_hk_notify_go_to");
            paramString = paramString.TjY.TjT.iterator();
            for (;;)
            {
              if (!paramString.hasNext()) {
                break label1220;
              }
              paramq = (cmp)paramString.next();
              if (!paramq.Tue.isEmpty()) {
                break;
              }
              Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "ItemSectionViewData is null");
            }
          }
          paramInt1 = paramInt2 + 1;
          localObject1 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject1, paramInt1);
          paramq = paramq.Tue.iterator();
          for (;;)
          {
            paramInt2 = paramInt1;
            if (!paramq.hasNext()) {
              break;
            }
            Object localObject3 = (eqh)paramq.next();
            if ((((eqh)localObject3).UsK.isEmpty()) || (((eqh)localObject3).UsL.isEmpty()))
            {
              Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "TableCellViewData data null");
            }
            else
            {
              localObject1 = (erh)((eqh)localObject3).UsK.get(0);
              localObject2 = (erh)((eqh)localObject3).UsL.get(0);
              localObject3 = ((eqh)localObject3).RGh;
              if ((((erh)localObject1).Uty.isEmpty()) || (Util.isNullOrNil(((ere)((erh)localObject1).Uty.get(0)).text)) || (localObject3 == null))
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
                    AppMethodBeat.i(269948);
                    super.onBindView(paramAnonymousView);
                    if (this.Wsy != null) {
                      paramAnonymousView.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(271908);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bn(paramAnonymous2View);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayHKNotify$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                          b.6.this.Wsy.fpI();
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayHKNotify$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(271908);
                        }
                      });
                    }
                    AppMethodBeat.o(269948);
                  }
                };
                local6.setTitle(((ere)((erh)localObject1).Uty.get(0)).text);
                local6.setLayoutResource(a.g.mm_preference);
                if ((!((erh)localObject2).Uty.isEmpty()) && (!Util.isNullOrNil(((ere)((erh)localObject2).Uty.get(0)).text))) {
                  local6.aF(((ere)((erh)localObject2).Uty.get(0)).text);
                }
                this.screen.a(local6, paramInt1);
                local6.Wsy = new b.7(this, (erh)localObject1, (eaa)localObject3);
              }
            }
          }
          label1220:
          this.screen.notifyDataSetChanged();
          AppMethodBeat.o(269999);
          return;
          label1236:
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "NetSceneGetPayHKPlugin no data");
          AppMethodBeat.o(269999);
          return;
        }
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "NetSceneGetPayHKPlugin fail!");
      }
      AppMethodBeat.o(269999);
      return;
      label1266:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */