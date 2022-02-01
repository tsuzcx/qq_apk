package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.api.q;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
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
import com.tencent.mm.ui.base.w;
import java.util.LinkedList;

public final class a
  implements com.tencent.mm.am.h, com.tencent.mm.pluginsdk.c.a
{
  private static final String VLe;
  private CheckBoxPreference VLf;
  private au contact;
  private Context context;
  private int pUt;
  private w rYw;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference xvc;
  
  static
  {
    AppMethodBeat.i(301243);
    VLe = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/product/wechatpay_app.html?scene_id=kf594";
    AppMethodBeat.o(301243);
  }
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void dvr()
  {
    AppMethodBeat.i(301233);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    localHelperHeaderPreference.bz(this.contact.field_username, this.contact.aSV(), this.context.getString(a.i.contact_info_wxpay_business_collection_switch_tip));
    if (com.tencent.mm.contact.d.rs(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.eh("contact_info_wxpay_business_collection_install", true);
      this.screen.eh("contact_info_wxpay_business_collection_uninstall", false);
      this.screen.eh("contact_info_wxpay_business_collection_go_to", false);
      this.screen.eh("contact_info_wxpay_business_collection_top", false);
      this.screen.eh("contact_info_wxpay_business_collection_not_disturb", false);
      this.screen.eh("contact_info_wxpay_business_collection_help", false);
      this.screen.eh("contact_info_wxpay_business_collection_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxV(this.contact.field_username)) {
        this.VLf.setChecked(true);
      }
      while (this.contact.aGe())
      {
        this.xvc.setChecked(true);
        AppMethodBeat.o(301233);
        return;
        this.VLf.setChecked(false);
      }
      this.xvc.setChecked(false);
      AppMethodBeat.o(301233);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.eh("contact_info_wxpay_business_collection_install", false);
    this.screen.eh("contact_info_wxpay_business_collection_uninstall", true);
    this.screen.eh("contact_info_wxpay_business_collection_go_to", true);
    this.screen.eh("contact_info_wxpay_business_collection_top", true);
    this.screen.eh("contact_info_wxpay_business_collection_not_disturb", true);
    this.screen.eh("contact_info_wxpay_business_collection_help", true);
    this.screen.eh("contact_info_wxpay_business_collection_clear_data", true);
    AppMethodBeat.o(301233);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(301249);
    this.screen = paramf;
    this.contact = paramau;
    this.pUt = paramInt;
    paramf.aBe(a.m.contact_info_pref_wxpay_business_collection);
    this.VLf = ((CheckBoxPreference)paramf.bAi("contact_info_wxpay_business_collection_top"));
    this.xvc = ((CheckBoxPreference)paramf.bAi("contact_info_wxpay_business_collection_not_disturb"));
    dvr();
    AppMethodBeat.o(301249);
    return true;
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(301257);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayBussinessCollection", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_business_collection_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.br.c.g(this.context, ".ui.chatting.ChattingUI", paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(301257);
      return false;
      if (Util.isEqual("contact_info_wxpay_business_collection_top", paramString))
      {
        if (this.VLf.isChecked()) {
          ab.K(this.contact.field_username, true);
        } else {
          ab.L(this.contact.field_username, true);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_business_collection_not_disturb", paramString))
      {
        if (this.xvc.isChecked()) {
          ab.G(this.contact);
        } else {
          ab.H(this.contact);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_business_collection_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.i.bC(this.context, VLe);
      }
      else if (Util.isEqual("contact_info_wxpay_business_collection_clear_data", paramString))
      {
        k.b(this.context, this.context.getString(a.i.contact_info_clear_data), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(301226);
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLO("gh_e087bb5b95e6");
            AppMethodBeat.o(301226);
          }
        }, null);
      }
      else if (Util.isEqual("contact_info_wxpay_business_collection_install", paramString))
      {
        paramString = this.context;
        this.context.getString(a.i.app_tip);
        this.rYw = k.a(paramString, this.context.getString(a.i.settings_plugins_installing), true, null);
        this.rYw.show();
        com.tencent.mm.kernel.h.aZW().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_e087bb5b95e6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(this.pUt));
        paramString = new v(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      }
      else if (Util.isEqual("contact_info_wxpay_business_collection_uninstall", paramString))
      {
        k.b(this.context, this.context.getString(a.i.settings_plugins_uninstall_hint), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(301234);
            paramAnonymousDialogInterface = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(a.a(a.this).field_username);
            ((com.tencent.mm.api.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.n.class)).a(paramAnonymousDialogInterface, (Activity)a.b(a.this), a.a(a.this));
            a.c(a.this);
            AppMethodBeat.o(301234);
          }
        }, null);
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
    AppMethodBeat.i(301266);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayBussinessCollection", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramp instanceof v))
    {
      com.tencent.mm.kernel.h.aZW().b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label171;
      }
      Log.e("MicroMsg.WxPay.ContactWidgetWxPayBussinessCollection", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
      }
    }
    label171:
    Object localObject;
    for (;;)
    {
      if (this.rYw != null) {
        this.rYw.dismiss();
      }
      dvr();
      AppMethodBeat.o(301266);
      return;
      localObject = ((v)paramp).iIc();
      Log.i("MicroMsg.WxPay.ContactWidgetWxPayBussinessCollection", "bind fitness contact %s success", new Object[] { localObject });
      paramp = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_e087bb5b95e6");
      if ((paramp != null) && (!Util.isNullOrNil((String)localObject))) {
        break;
      }
      Log.e("MicroMsg.WxPay.ContactWidgetWxPayBussinessCollection", "respUsername == " + (String)localObject + ", contact = " + paramp);
      paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(paramp.field_username);
      if (paramString != null) {
        ((q)com.tencent.mm.kernel.h.ax(q.class)).a(paramString);
      }
      com.tencent.mm.kernel.h.baE().ban().B(327825, Boolean.TRUE);
    }
    if (au.bxa(paramp.field_username))
    {
      String str = Util.nullAsNil(paramp.field_username);
      paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      ((q)com.tencent.mm.kernel.h.ax(q.class)).hV(str);
      paramp.Bd(str);
    }
    for (;;)
    {
      paramp.setUsername((String)localObject);
      if ((int)paramp.maN == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC(paramp);
      }
      if ((int)paramp.maN <= 0)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayBussinessCollection", "addContact : insert contact failed");
        break;
      }
      ab.I(paramp);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramp.field_username);
      if (paramString != null)
      {
        ((q)com.tencent.mm.kernel.h.ax(q.class)).b(paramString);
        break;
      }
      paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(((az)localObject).field_username);
      if ((paramString == null) || (paramString.aAJ()))
      {
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayBussinessCollection", "shouldUpdate");
        az.a.okP.aZ(((az)localObject).field_username, "");
        com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
        break;
      }
      if (!((au)localObject).iZI()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayBussinessCollection", "update contact, last check time=%d", new Object[] { Integer.valueOf(((az)localObject).kak) });
      az.a.okP.aZ(((az)localObject).field_username, "");
      com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
      break;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a
 * JD-Core Version:    0.7.0.1
 */