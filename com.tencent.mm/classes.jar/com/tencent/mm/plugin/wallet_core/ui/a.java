package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.aa;
import com.tencent.mm.api.m;
import com.tencent.mm.g.b.a.ne;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements i, com.tencent.mm.pluginsdk.b.a
{
  private List<Preference> HKF;
  private CheckBoxPreference IcE;
  as contact;
  Context context;
  private com.tencent.mm.ui.base.q nUq;
  private CheckBoxPreference qNs;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(214225);
    this.HKF = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(214225);
  }
  
  private void a(btx parambtx)
  {
    AppMethodBeat.i(214231);
    if (!com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      fSv();
      AppMethodBeat.o(214231);
      return;
    }
    fSv();
    if ((parambtx != null) && (parambtx.MaF != null) && (parambtx.MaF.MaA != null) && (!parambtx.MaF.MaA.isEmpty()))
    {
      int i = this.screen.indexOf("contact_info_wxpay_collection_go_to");
      parambtx = parambtx.MaF.MaA.iterator();
      while (parambtx.hasNext())
      {
        Object localObject1 = (cdv)parambtx.next();
        if (((cdv)localObject1).Mjq.isEmpty())
        {
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "ItemSectionViewData is null");
        }
        else
        {
          i += 1;
          Object localObject2 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject2, i);
          this.HKF.add(localObject2);
          localObject1 = ((cdv)localObject1).Mjq.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (egf)((Iterator)localObject1).next();
            if ((((egf)localObject3).Ngf.isEmpty()) || (((egf)localObject3).Ngg.isEmpty()))
            {
              Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData data null");
            }
            else
            {
              localObject2 = (ehf)((egf)localObject3).Ngf.get(0);
              ehf localehf = (ehf)((egf)localObject3).Ngg.get(0);
              localObject3 = ((egf)localObject3).KEP;
              if ((((ehf)localObject2).NgT.isEmpty()) || (Util.isNullOrNil(((ehc)((ehf)localObject2).NgT.get(0)).text)) || (localObject3 == null))
              {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData inner data null");
              }
              else
              {
                i += 1;
                a.3 local3 = new a.3(this, this.context);
                local3.setTitle(((ehc)((ehf)localObject2).NgT.get(0)).text);
                local3.setLayoutResource(2131495538);
                if ((!localehf.NgT.isEmpty()) && (!Util.isNullOrNil(((ehc)localehf.NgT.get(0)).text))) {
                  local3.setSummary(((ehc)localehf.NgT.get(0)).text);
                }
                this.screen.a(local3, i);
                this.HKF.add(local3);
                local3.OZp = new Preference.b()
                {
                  public final boolean a(Preference paramAnonymousPreference)
                  {
                    AppMethodBeat.i(214223);
                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "text(%s) click!", new Object[] { ((ehc)this.IcI.NgT.get(0)).text });
                    paramAnonymousPreference = new Bundle();
                    paramAnonymousPreference.putInt("key_tiny_app_scene", 1165);
                    com.tencent.mm.plugin.wallet_core.utils.g.a(a.this.context, this.IcJ, paramAnonymousPreference);
                    com.tencent.mm.plugin.report.service.h.CyF.a(19541, new Object[] { Integer.valueOf(1), ((ehc)this.IcI.NgT.get(0)).text });
                    AppMethodBeat.o(214223);
                    return true;
                  }
                };
              }
            }
          }
        }
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(214231);
      return;
    }
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin no data");
    AppMethodBeat.o(214231);
  }
  
  static void b(btx parambtx)
  {
    AppMethodBeat.i(214232);
    if ((parambtx != null) && (parambtx.MaF != null) && (parambtx.MaF.MaA != null) && (!parambtx.MaF.MaA.isEmpty())) {}
    for (;;)
    {
      try
      {
        parambtx = new String(parambtx.toByteArray(), "ISO-8859-1");
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnM, parambtx);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().gBI();
        AppMethodBeat.o(214232);
        return;
      }
      catch (IOException parambtx)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "save config exp, " + parambtx.getLocalizedMessage());
      }
      parambtx = " ";
    }
  }
  
  private static btx fSu()
  {
    AppMethodBeat.i(214233);
    btx localbtx = new btx();
    com.tencent.mm.kernel.g.aAi();
    String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OnM, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "etReceiptAssisPluginResponse failed");
    }
    for (;;)
    {
      AppMethodBeat.o(214233);
      return localbtx;
      try
      {
        localbtx.parseFrom(str.getBytes("ISO-8859-1"));
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.WxPay.ContactWidgetWxPayCollection", "parseConfig exp, " + localException.getLocalizedMessage());
      }
    }
  }
  
  static void xV(int paramInt)
  {
    AppMethodBeat.i(214230);
    ne localne = new ne();
    localne.eXG = paramInt;
    localne.bfK();
    AppMethodBeat.o(214230);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(214226);
    this.screen = paramf;
    this.contact = paramas;
    paramf.addPreferencesFromResource(2132017201);
    this.IcE = ((CheckBoxPreference)paramf.bmg("contact_info_wxpay_collection_top"));
    this.qNs = ((CheckBoxPreference)paramf.bmg("contact_info_wxpay_collection_not_disturb"));
    cCt();
    a(fSu());
    com.tencent.mm.kernel.g.azz().a(2860, this);
    paramf = new k();
    com.tencent.mm.kernel.g.azz().a(paramf, 0);
    AppMethodBeat.o(214226);
    return true;
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(214227);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_collection_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.br.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
      xV(3);
    }
    for (;;)
    {
      AppMethodBeat.o(214227);
      return false;
      if (Util.isEqual("contact_info_wxpay_collection_top", paramString))
      {
        if (this.IcE.isChecked())
        {
          ab.E(this.contact.field_username, true);
          xV(4);
        }
        else
        {
          ab.F(this.contact.field_username, true);
          xV(5);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_collection_not_disturb", paramString))
      {
        if (this.qNs.isChecked())
        {
          ab.z(this.contact);
          xV(6);
        }
        else
        {
          ab.A(this.contact);
          xV(7);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_collection_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.f.u("gh_106decc2eec5@app", "/pages/product/productInfo/product.html?code=A4075&producttitle=收款小账本&scene_id=kf5662", 0, 1165);
        xV(8);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new a.1(this), null);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755998);
        this.nUq = com.tencent.mm.ui.base.h.a(paramString, this.context.getString(2131765544), true, null);
        this.nUq.show();
        com.tencent.mm.kernel.g.azz().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_f0a92aa7146c");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.p(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.azz().a(paramString, 0);
        com.tencent.mm.kernel.g.aAg().hqi.a(new aa(new a.5(this)), 0);
        xV(11);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(214220);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ(a.this.contact.field_username);
            ((m)com.tencent.mm.kernel.g.af(m.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.cCt();
            a.this.fSv();
            a.b(null);
            a.xV(10);
            AppMethodBeat.o(214220);
          }
        }, null);
      }
    }
  }
  
  public final boolean cCs()
  {
    return true;
  }
  
  final void cCt()
  {
    AppMethodBeat.i(214228);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    localHelperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758146));
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "contact.getUsername():%s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.jdMethod_do("contact_info_wxpay_collection_install", true);
      this.screen.jdMethod_do("contact_info_wxpay_collection_uninstall", false);
      this.screen.jdMethod_do("contact_info_wxpay_collection_go_to", false);
      this.screen.jdMethod_do("contact_info_wxpay_collection_top", false);
      this.screen.jdMethod_do("contact_info_wxpay_collection_not_disturb", false);
      this.screen.jdMethod_do("contact_info_wxpay_collection_help", false);
      this.screen.jdMethod_do("contact_info_wxpay_collection_clear_data", false);
      if (((l)com.tencent.mm.kernel.g.af(l.class)).aST().bkg(this.contact.field_username)) {
        this.IcE.setChecked(true);
      }
      while (this.contact.Zx())
      {
        this.qNs.setChecked(true);
        AppMethodBeat.o(214228);
        return;
        this.IcE.setChecked(false);
      }
      this.qNs.setChecked(false);
      AppMethodBeat.o(214228);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.jdMethod_do("contact_info_wxpay_collection_install", false);
    this.screen.jdMethod_do("contact_info_wxpay_collection_uninstall", true);
    this.screen.jdMethod_do("contact_info_wxpay_collection_go_to", true);
    this.screen.jdMethod_do("contact_info_wxpay_collection_top", true);
    this.screen.jdMethod_do("contact_info_wxpay_collection_not_disturb", true);
    this.screen.jdMethod_do("contact_info_wxpay_collection_help", true);
    this.screen.jdMethod_do("contact_info_wxpay_collection_clear_data", true);
    AppMethodBeat.o(214228);
  }
  
  final void fSv()
  {
    AppMethodBeat.i(214234);
    if ((this.HKF != null) && (this.HKF.size() > 0))
    {
      Iterator localIterator = this.HKF.iterator();
      while (localIterator.hasNext())
      {
        Preference localPreference = (Preference)localIterator.next();
        this.screen.e(localPreference);
      }
      this.screen.notifyDataSetChanged();
      this.HKF.clear();
    }
    AppMethodBeat.o(214234);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(214229);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    Object localObject;
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.p))
    {
      com.tencent.mm.kernel.g.azz().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
      }
      for (;;)
      {
        if (this.nUq != null) {
          this.nUq.dismiss();
        }
        cCt();
        AppMethodBeat.o(214229);
        return;
        localObject = ((com.tencent.mm.pluginsdk.model.p)paramq).gmD();
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "bind fitness contact %s success", new Object[] { localObject });
        paramq = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_f0a92aa7146c");
        if ((paramq != null) && (!Util.isNullOrNil((String)localObject))) {
          break;
        }
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "respUsername == " + (String)localObject + ", contact = " + paramq);
        paramString = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ(paramq.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(327825, Boolean.TRUE);
      }
      if (!ab.IR(paramq.field_username)) {
        break label720;
      }
      String str = Util.nullAsNil(paramq.field_username);
      paramString = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fK(str);
      paramq.BK(str);
    }
    for (;;)
    {
      paramq.setUsername((String)localObject);
      if ((int)paramq.gMZ == 0) {
        ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().aq(paramq);
      }
      if ((int)paramq.gMZ <= 0)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "addContact : insert contact failed");
        break;
      }
      ab.B(paramq);
      localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramq.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ(((ax)localObject).field_username);
      if ((paramString == null) || (paramString.Uz()))
      {
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "shouldUpdate");
        ay.a.iDq.aL(((ax)localObject).field_username, "");
        com.tencent.mm.aj.c.Mf(((ax)localObject).field_username);
        break;
      }
      if (!((as)localObject).gBQ()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject).fuP) });
      ay.a.iDq.aL(((ax)localObject).field_username, "");
      com.tencent.mm.aj.c.Mf(((ax)localObject).field_username);
      break;
      if ((paramq instanceof k))
      {
        com.tencent.mm.kernel.g.azz().b(2860, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (k)paramq;
          if (paramString.HPJ == null) {}
          for (paramString = new btx();; paramString = paramString.HPJ)
          {
            a(paramString);
            b(paramString);
            AppMethodBeat.o(214229);
            return;
          }
        }
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(214229);
      return;
      label720:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a
 * JD-Core Version:    0.7.0.1
 */