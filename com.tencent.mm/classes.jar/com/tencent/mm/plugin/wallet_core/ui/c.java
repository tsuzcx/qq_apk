package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.api.m;
import com.tencent.mm.api.p;
import com.tencent.mm.f.b.a.qe;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eqh;
import com.tencent.mm.protocal.protobuf.eqi;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  implements com.tencent.mm.an.i, com.tencent.mm.pluginsdk.c.a
{
  private static final String OVb;
  private CheckBoxPreference OUS;
  private as contact;
  private Context context;
  private s oTk;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference uoF;
  
  static
  {
    AppMethodBeat.i(226022);
    OVb = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf1";
    AppMethodBeat.o(226022);
  }
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static void Bv(int paramInt)
  {
    AppMethodBeat.i(70644);
    qe localqe = new qe();
    localqe.hal = paramInt;
    localqe.bpa();
    AppMethodBeat.o(70644);
  }
  
  private void cQY()
  {
    AppMethodBeat.i(70642);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    localHelperHeaderPreference.bf(this.contact.field_username, this.contact.ays(), this.context.getString(a.i.contact_info_wxpay_notify_switch_tip));
    if (com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.dz("contact_info_wxpay_notify_install", true);
      this.screen.dz("contact_info_wxpay_notify_uninstall", false);
      this.screen.dz("contact_info_wxpay_notify_go_to", false);
      this.screen.dz("contact_info_wxpay_notify_top", false);
      this.screen.dz("contact_info_wxpay_notify_not_disturb", false);
      this.screen.dz("contact_info_wxpay_notify_help", false);
      this.screen.dz("contact_info_wxpay_notify_clear_data", false);
      if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF(this.contact.field_username)) {
        this.OUS.setChecked(true);
      }
      while (this.contact.aeg())
      {
        this.uoF.setChecked(true);
        AppMethodBeat.o(70642);
        return;
        this.OUS.setChecked(false);
      }
      this.uoF.setChecked(false);
      AppMethodBeat.o(70642);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.dz("contact_info_wxpay_notify_install", false);
    this.screen.dz("contact_info_wxpay_notify_uninstall", true);
    this.screen.dz("contact_info_wxpay_notify_go_to", true);
    this.screen.dz("contact_info_wxpay_notify_top", true);
    this.screen.dz("contact_info_wxpay_notify_not_disturb", true);
    this.screen.dz("contact_info_wxpay_notify_help", true);
    this.screen.dz("contact_info_wxpay_notify_clear_data", true);
    AppMethodBeat.o(70642);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70640);
    this.screen = paramf;
    this.contact = paramas;
    paramf.auC(a.m.contact_info_pref_wxpay_notify);
    this.OUS = ((CheckBoxPreference)paramf.byG("contact_info_wxpay_notify_top"));
    this.uoF = ((CheckBoxPreference)paramf.byG("contact_info_wxpay_notify_not_disturb"));
    cQY();
    com.tencent.mm.kernel.h.aGY().a(1820, this);
    paramf = new j();
    com.tencent.mm.kernel.h.aGY().a(paramf, 0);
    AppMethodBeat.o(70640);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(70641);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_notify_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.by.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70641);
      return false;
      if (Util.isEqual("contact_info_wxpay_notify_top", paramString))
      {
        if (this.OUS.isChecked())
        {
          ab.G(this.contact.field_username, true);
          Bv(3);
        }
        else
        {
          ab.H(this.contact.field_username, true);
          Bv(4);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_notify_not_disturb", paramString))
      {
        if (this.uoF.isChecked())
        {
          ab.F(this.contact);
          Bv(5);
        }
        else
        {
          ab.G(this.contact);
          Bv(6);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_notify_help", paramString))
      {
        g.bA(this.context, OVb);
        Bv(7);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(a.i.contact_info_clear_data), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70635);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOO("gh_3dfda90e39d6");
            AppMethodBeat.o(70635);
          }
        }, null);
        Bv(8);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_install", paramString))
      {
        paramString = this.context;
        this.context.getString(a.i.app_tip);
        this.oTk = com.tencent.mm.ui.base.h.a(paramString, this.context.getString(a.i.settings_plugins_installing), true, null);
        this.oTk.show();
        com.tencent.mm.kernel.h.aGY().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_3dfda90e39d6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.t(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        Bv(10);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(a.i.settings_plugins_uninstall_hint), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70636);
            paramAnonymousDialogInterface = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(c.a(c.this).field_username);
            ((m)com.tencent.mm.kernel.h.ae(m.class)).a(paramAnonymousDialogInterface, (Activity)c.b(c.this), c.a(c.this));
            c.c(c.this);
            AppMethodBeat.o(70636);
          }
        }, null);
        Bv(9);
      }
    }
  }
  
  public final boolean cQX()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70643);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      com.tencent.mm.kernel.h.aGY().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        AppMethodBeat.o(70643);
        return;
        localObject1 = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_3dfda90e39d6");
        if ((paramq != null) && (!Util.isNullOrNil((String)localObject1))) {
          break;
        }
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramq);
        paramString = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(paramq.field_username);
        if (paramString != null) {
          ((p)com.tencent.mm.kernel.h.ae(p.class)).a(paramString);
        }
        com.tencent.mm.kernel.h.aHG().aHp().i(327825, Boolean.TRUE);
      }
      if (!ab.Qk(paramq.field_username)) {
        break label1140;
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
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "addContact : insert contact failed");
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
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "shouldUpdate");
        az.a.ltq.aP(((ax)localObject1).field_username, "");
        com.tencent.mm.am.d.TA(((ax)localObject1).field_username);
        break;
      }
      if (!((as)localObject1).hyb()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject1).hDo) });
      az.a.ltq.aP(((ax)localObject1).field_username, "");
      com.tencent.mm.am.d.TA(((ax)localObject1).field_username);
      break;
      if ((paramq instanceof j))
      {
        com.tencent.mm.kernel.h.aGY().b(1820, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (j)paramq;
          if (paramString.OHP == null) {
            paramString = new dkd();
          }
          while ((paramString != null) && (paramString.TjY != null) && (paramString.TjY.TjT != null) && (!paramString.TjY.TjT.isEmpty()))
          {
            paramInt2 = this.screen.bf("contact_info_wxpay_notify_clear_data");
            paramString = paramString.TjY.TjT.iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                paramq = (cmp)paramString.next();
                if (paramq.Tue.isEmpty())
                {
                  Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "ItemSectionViewData is null");
                  continue;
                  paramString = paramString.OHP;
                  break;
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
                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData data null");
                  }
                  else
                  {
                    localObject1 = (erh)((eqh)localObject3).UsK.get(0);
                    localObject2 = (erh)((eqh)localObject3).UsL.get(0);
                    localObject3 = ((eqh)localObject3).RGh;
                    if ((((erh)localObject1).Uty.isEmpty()) || (Util.isNullOrNil(((ere)((erh)localObject1).Uty.get(0)).text)) || (localObject3 == null))
                    {
                      Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData inner data null");
                    }
                    else
                    {
                      paramInt1 += 1;
                      Preference local3 = new Preference(this.context)
                      {
                        public final void onBindView(View paramAnonymousView)
                        {
                          AppMethodBeat.i(70638);
                          super.onBindView(paramAnonymousView);
                          if (this.Wsy != null) {
                            paramAnonymousView.setOnClickListener(new View.OnClickListener()
                            {
                              public final void onClick(View paramAnonymous2View)
                              {
                                AppMethodBeat.i(70637);
                                b localb = new b();
                                localb.bn(paramAnonymous2View);
                                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayNotify$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                                c.3.this.Wsy.fpI();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayNotify$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(70637);
                              }
                            });
                          }
                          AppMethodBeat.o(70638);
                        }
                      };
                      local3.setTitle(((ere)((erh)localObject1).Uty.get(0)).text);
                      local3.setLayoutResource(a.g.mm_preference);
                      if ((!((erh)localObject2).Uty.isEmpty()) && (!Util.isNullOrNil(((ere)((erh)localObject2).Uty.get(0)).text))) {
                        local3.aF(((ere)((erh)localObject2).Uty.get(0)).text);
                      }
                      this.screen.a(local3, paramInt1);
                      local3.Wsy = new c.4(this, (erh)localObject1, (eaa)localObject3);
                    }
                  }
                }
              }
            }
            this.screen.notifyDataSetChanged();
            AppMethodBeat.o(70643);
            return;
          }
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin no data");
          AppMethodBeat.o(70643);
          return;
        }
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(70643);
      return;
      label1140:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */