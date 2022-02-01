package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.api.q;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.tx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.ecn;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.protocal.protobuf.fml;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
  implements com.tencent.mm.am.h, com.tencent.mm.pluginsdk.c.a
{
  private static final String VLe;
  private CheckBoxPreference VLf;
  private au contact;
  private Context context;
  private w rYw;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference xvc;
  
  static
  {
    AppMethodBeat.i(301256);
    VLe = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf1";
    AppMethodBeat.o(301256);
  }
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static void BI(int paramInt)
  {
    AppMethodBeat.i(70644);
    tx localtx = new tx();
    localtx.jvV = paramInt;
    localtx.bMH();
    AppMethodBeat.o(70644);
  }
  
  private void dvr()
  {
    AppMethodBeat.i(70642);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    localHelperHeaderPreference.bz(this.contact.field_username, this.contact.aSV(), this.context.getString(a.i.contact_info_wxpay_notify_switch_tip));
    if (com.tencent.mm.contact.d.rs(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.eh("contact_info_wxpay_notify_install", true);
      this.screen.eh("contact_info_wxpay_notify_uninstall", false);
      this.screen.eh("contact_info_wxpay_notify_go_to", false);
      this.screen.eh("contact_info_wxpay_notify_top", false);
      this.screen.eh("contact_info_wxpay_notify_not_disturb", false);
      this.screen.eh("contact_info_wxpay_notify_help", false);
      this.screen.eh("contact_info_wxpay_notify_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxV(this.contact.field_username)) {
        this.VLf.setChecked(true);
      }
      while (this.contact.aGe())
      {
        this.xvc.setChecked(true);
        AppMethodBeat.o(70642);
        return;
        this.VLf.setChecked(false);
      }
      this.xvc.setChecked(false);
      AppMethodBeat.o(70642);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.eh("contact_info_wxpay_notify_install", false);
    this.screen.eh("contact_info_wxpay_notify_uninstall", true);
    this.screen.eh("contact_info_wxpay_notify_go_to", true);
    this.screen.eh("contact_info_wxpay_notify_top", true);
    this.screen.eh("contact_info_wxpay_notify_not_disturb", true);
    this.screen.eh("contact_info_wxpay_notify_help", true);
    this.screen.eh("contact_info_wxpay_notify_clear_data", true);
    AppMethodBeat.o(70642);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70640);
    this.screen = paramf;
    this.contact = paramau;
    paramf.aBe(a.m.contact_info_pref_wxpay_notify);
    this.VLf = ((CheckBoxPreference)paramf.bAi("contact_info_wxpay_notify_top"));
    this.xvc = ((CheckBoxPreference)paramf.bAi("contact_info_wxpay_notify_not_disturb"));
    dvr();
    com.tencent.mm.kernel.h.aZW().a(1820, this);
    paramf = new j();
    com.tencent.mm.kernel.h.aZW().a(paramf, 0);
    AppMethodBeat.o(70640);
    return true;
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(70641);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_notify_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.br.c.g(this.context, ".ui.chatting.ChattingUI", paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70641);
      return false;
      if (Util.isEqual("contact_info_wxpay_notify_top", paramString))
      {
        if (this.VLf.isChecked())
        {
          ab.K(this.contact.field_username, true);
          BI(3);
        }
        else
        {
          ab.L(this.contact.field_username, true);
          BI(4);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_notify_not_disturb", paramString))
      {
        if (this.xvc.isChecked())
        {
          ab.G(this.contact);
          BI(5);
        }
        else
        {
          ab.H(this.contact);
          BI(6);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_notify_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.i.bC(this.context, VLe);
        BI(7);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_clear_data", paramString))
      {
        k.b(this.context, this.context.getString(a.i.contact_info_clear_data), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70635);
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLO("gh_3dfda90e39d6");
            AppMethodBeat.o(70635);
          }
        }, null);
        BI(8);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_install", paramString))
      {
        paramString = this.context;
        this.context.getString(a.i.app_tip);
        this.rYw = k.a(paramString, this.context.getString(a.i.settings_plugins_installing), true, null);
        this.rYw.show();
        com.tencent.mm.kernel.h.aZW().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_3dfda90e39d6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new v(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        BI(10);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_uninstall", paramString))
      {
        k.b(this.context, this.context.getString(a.i.settings_plugins_uninstall_hint), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70636);
            paramAnonymousDialogInterface = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(d.a(d.this).field_username);
            ((com.tencent.mm.api.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.n.class)).a(paramAnonymousDialogInterface, (Activity)d.b(d.this), d.a(d.this));
            d.c(d.this);
            AppMethodBeat.o(70636);
          }
        }, null);
        BI(9);
      }
    }
  }
  
  public final boolean dvq()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70643);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    Object localObject1;
    Object localObject2;
    if ((paramp instanceof v))
    {
      com.tencent.mm.kernel.h.aZW().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        AppMethodBeat.o(70643);
        return;
        localObject1 = ((v)paramp).iIc();
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramp = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_3dfda90e39d6");
        if ((paramp != null) && (!Util.isNullOrNil((String)localObject1))) {
          break;
        }
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramp);
        paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(paramp.field_username);
        if (paramString != null) {
          ((q)com.tencent.mm.kernel.h.ax(q.class)).a(paramString);
        }
        com.tencent.mm.kernel.h.baE().ban().B(327825, Boolean.TRUE);
      }
      if (!au.bxa(paramp.field_username)) {
        break label1140;
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
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "addContact : insert contact failed");
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
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "shouldUpdate");
        az.a.okP.aZ(((az)localObject1).field_username, "");
        com.tencent.mm.modelavatar.d.LA(((az)localObject1).field_username);
        break;
      }
      if (!((au)localObject1).iZI()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((az)localObject1).kak) });
      az.a.okP.aZ(((az)localObject1).field_username, "");
      com.tencent.mm.modelavatar.d.LA(((az)localObject1).field_username);
      break;
      if ((paramp instanceof j))
      {
        com.tencent.mm.kernel.h.aZW().b(1820, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (j)paramp;
          if (paramString.VxB == null) {
            paramString = new ecn();
          }
          while ((paramString != null) && (paramString.aaxA != null) && (paramString.aaxA.aaxw != null) && (!paramString.aaxA.aaxw.isEmpty()))
          {
            paramInt2 = this.screen.cs("contact_info_wxpay_notify_clear_data");
            paramString = paramString.aaxA.aaxw.iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                paramp = (ddc)paramString.next();
                if (paramp.aaIH.isEmpty())
                {
                  Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "ItemSectionViewData is null");
                  continue;
                  paramString = paramString.VxB;
                  break;
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
                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData data null");
                  }
                  else
                  {
                    localObject1 = (fmp)((fll)localObject3).abLS.get(0);
                    localObject2 = (fmp)((fll)localObject3).abLT.get(0);
                    localObject3 = ((fll)localObject3).YCV;
                    if ((((fmp)localObject1).abMT.isEmpty()) || (Util.isNullOrNil(((fml)((fmp)localObject1).abMT.get(0)).text)) || (localObject3 == null))
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
                          if (this.adZO != null) {
                            paramAnonymousView.setOnClickListener(new View.OnClickListener()
                            {
                              public final void onClick(View paramAnonymous2View)
                              {
                                AppMethodBeat.i(70637);
                                b localb = new b();
                                localb.cH(paramAnonymous2View);
                                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayNotify$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                                d.3.this.adZO.gAW();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayNotify$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(70637);
                              }
                            });
                          }
                          AppMethodBeat.o(70638);
                        }
                      };
                      local3.setTitle(((fml)((fmp)localObject1).abMT.get(0)).text);
                      local3.setLayoutResource(a.g.mm_preference);
                      if ((!((fmp)localObject2).abMT.isEmpty()) && (!Util.isNullOrNil(((fml)((fmp)localObject2).abMT.get(0)).text))) {
                        local3.aS(((fml)((fmp)localObject2).abMT.get(0)).text);
                      }
                      this.screen.a(local3, paramInt1);
                      local3.adZO = new Preference.b()
                      {
                        public final boolean gAW()
                        {
                          AppMethodBeat.i(70639);
                          Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "text(%s) click!", new Object[] { ((fml)this.VLk.abMT.get(0)).text });
                          Bundle localBundle = new Bundle();
                          localBundle.putInt("key_tiny_app_scene", 1000);
                          com.tencent.mm.plugin.wallet_core.utils.n.a(d.b(d.this), this.VLl, localBundle);
                          AppMethodBeat.o(70639);
                          return true;
                        }
                      };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */