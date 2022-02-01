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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.api.l;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.al.g, com.tencent.mm.pluginsdk.b.a
{
  private CheckBoxPreference Ajc;
  af contact;
  Context context;
  private p lAj;
  private CheckBoxPreference okn;
  private f screen;
  private List<Preference> zUu;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(187173);
    this.zUu = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(187173);
  }
  
  private void a(azl paramazl)
  {
    AppMethodBeat.i(187179);
    if (!com.tencent.mm.n.b.ls(this.contact.field_type))
    {
      edH();
      AppMethodBeat.o(187179);
      return;
    }
    edH();
    if ((paramazl != null) && (paramazl.DxU != null) && (paramazl.DxU.DxQ != null) && (!paramazl.DxU.DxQ.isEmpty()))
    {
      int i = this.screen.indexOf("contact_info_wxpay_collection_go_to");
      paramazl = paramazl.DxU.DxQ.iterator();
      while (paramazl.hasNext())
      {
        Object localObject1 = (bif)paramazl.next();
        if (((bif)localObject1).DFN.isEmpty())
        {
          ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "ItemSectionViewData is null");
        }
        else
        {
          i += 1;
          Object localObject2 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject2, i);
          this.zUu.add(localObject2);
          localObject1 = ((bif)localObject1).DFN.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (dav)((Iterator)localObject1).next();
            if ((((dav)localObject3).EsD.isEmpty()) || (((dav)localObject3).EsE.isEmpty()))
            {
              ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData data null");
            }
            else
            {
              localObject2 = (dbp)((dav)localObject3).EsD.get(0);
              dbp localdbp = (dbp)((dav)localObject3).EsE.get(0);
              localObject3 = ((dav)localObject3).Cvq;
              if ((((dbp)localObject2).Eth.isEmpty()) || (bt.isNullOrNil(((dbm)((dbp)localObject2).Eth.get(0)).text)) || (localObject3 == null))
              {
                ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData inner data null");
              }
              else
              {
                i += 1;
                Preference local3 = new Preference(this.context)
                {
                  public final void onBindView(View paramAnonymousView)
                  {
                    AppMethodBeat.i(187170);
                    super.onBindView(paramAnonymousView);
                    if (this.GfO != null) {
                      paramAnonymousView.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(187169);
                          a.3.this.GfO.dbW();
                          AppMethodBeat.o(187169);
                        }
                      });
                    }
                    AppMethodBeat.o(187170);
                  }
                };
                local3.setTitle(((dbm)((dbp)localObject2).Eth.get(0)).text);
                local3.setLayoutResource(2131494804);
                if ((!localdbp.Eth.isEmpty()) && (!bt.isNullOrNil(((dbm)localdbp.Eth.get(0)).text))) {
                  local3.setSummary(((dbm)localdbp.Eth.get(0)).text);
                }
                this.screen.a(local3, i);
                this.zUu.add(local3);
                local3.GfO = new Preference.b()
                {
                  public final boolean dbW()
                  {
                    AppMethodBeat.i(187171);
                    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "text(%s) click!", new Object[] { ((dbm)this.Ajf.Eth.get(0)).text });
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("key_tiny_app_scene", 1165);
                    com.tencent.mm.plugin.wallet_core.utils.g.a(a.this.context, this.Ajg, localBundle);
                    com.tencent.mm.plugin.report.service.h.vKh.f(19541, new Object[] { Integer.valueOf(1), ((dbm)this.Ajf.Eth.get(0)).text });
                    AppMethodBeat.o(187171);
                    return true;
                  }
                };
              }
            }
          }
        }
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(187179);
      return;
    }
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin no data");
    AppMethodBeat.o(187179);
  }
  
  static void b(azl paramazl)
  {
    AppMethodBeat.i(187180);
    if ((paramazl != null) && (paramazl.DxU != null) && (paramazl.DxU.DxQ != null) && (!paramazl.DxU.DxQ.isEmpty())) {}
    for (;;)
    {
      try
      {
        paramazl = new String(paramazl.toByteArray(), "ISO-8859-1");
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FxG, paramazl);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().eKy();
        AppMethodBeat.o(187180);
        return;
      }
      catch (IOException paramazl)
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "save config exp, " + paramazl.getLocalizedMessage());
      }
      paramazl = " ";
    }
  }
  
  private static azl edG()
  {
    AppMethodBeat.i(187181);
    azl localazl = new azl();
    com.tencent.mm.kernel.g.afC();
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FxG, null);
    if (bt.isNullOrNil(str)) {
      ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "etReceiptAssisPluginResponse failed");
    }
    for (;;)
    {
      AppMethodBeat.o(187181);
      return localazl;
      try
      {
        localazl.parseFrom(str.getBytes("ISO-8859-1"));
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.WxPay.ContactWidgetWxPayCollection", "parseConfig exp, " + localException.getLocalizedMessage());
      }
    }
  }
  
  static void sw(int paramInt)
  {
    AppMethodBeat.i(187178);
    gk localgk = new gk();
    localgk.dZv = paramInt;
    localgk.aBj();
    AppMethodBeat.o(187178);
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(187175);
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "handleEvent key:%s", new Object[] { paramString });
    if (bt.kU("contact_info_wxpay_collection_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      d.e(this.context, ".ui.chatting.ChattingUI", paramString);
      sw(3);
    }
    for (;;)
    {
      AppMethodBeat.o(187175);
      return false;
      if (bt.kU("contact_info_wxpay_collection_top", paramString))
      {
        if (this.Ajc.isChecked())
        {
          w.C(this.contact.field_username, true);
          sw(4);
        }
        else
        {
          w.D(this.contact.field_username, true);
          sw(5);
        }
      }
      else if (bt.kU("contact_info_wxpay_collection_not_disturb", paramString))
      {
        if (this.okn.isChecked())
        {
          w.s(this.contact);
          sw(6);
        }
        else
        {
          w.t(this.contact);
          sw(7);
        }
      }
      else if (bt.kU("contact_info_wxpay_collection_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.e.v("gh_106decc2eec5@app", "/pages/product/productInfo/product.html?code=A4075&producttitle=收款小账本&scene_id=kf5662", 0, 1165);
        sw(8);
      }
      else if (bt.kU("contact_info_wxpay_collection_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187167);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agw("gh_f0a92aa7146c");
            a.sw(9);
            AppMethodBeat.o(187167);
          }
        }, null);
      }
      else if (bt.kU("contact_info_wxpay_collection_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755906);
        this.lAj = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.lAj.show();
        com.tencent.mm.kernel.g.aeS().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_f0a92aa7146c");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.o(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
        com.tencent.mm.kernel.g.afA().gcy.a(new z(new z.a() {}), 0);
        sw(11);
      }
      else if (bt.kU("contact_info_wxpay_collection_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187168);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ei(a.this.contact.field_username);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.bRv();
            a.this.edH();
            a.b(null);
            a.sw(10);
            AppMethodBeat.o(187168);
          }
        }, null);
      }
    }
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(187174);
    this.screen = paramf;
    this.contact = paramaf;
    paramf.addPreferencesFromResource(2131951663);
    this.Ajc = ((CheckBoxPreference)paramf.aKk("contact_info_wxpay_collection_top"));
    this.okn = ((CheckBoxPreference)paramf.aKk("contact_info_wxpay_collection_not_disturb"));
    bRv();
    a(edG());
    com.tencent.mm.kernel.g.aeS().a(2860, this);
    paramf = new com.tencent.mm.plugin.wallet_core.c.k();
    com.tencent.mm.kernel.g.aeS().a(paramf, 0);
    AppMethodBeat.o(187174);
    return true;
  }
  
  public final boolean bRu()
  {
    return true;
  }
  
  final void bRv()
  {
    AppMethodBeat.i(187176);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aKk("contact_info_header_helper");
    localHelperHeaderPreference.aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757906));
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "contact.getUsername():%s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.n.b.ls(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cE("contact_info_wxpay_collection_install", true);
      this.screen.cE("contact_info_wxpay_collection_uninstall", false);
      this.screen.cE("contact_info_wxpay_collection_go_to", false);
      this.screen.cE("contact_info_wxpay_collection_top", false);
      this.screen.cE("contact_info_wxpay_collection_not_disturb", false);
      this.screen.cE("contact_info_wxpay_collection_help", false);
      this.screen.cE("contact_info_wxpay_collection_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIv(this.contact.field_username)) {}
      for (this.Ajc.lG = true; this.contact.Ny(); this.Ajc.lG = false)
      {
        this.okn.lG = true;
        AppMethodBeat.o(187176);
        return;
      }
      this.okn.lG = false;
      AppMethodBeat.o(187176);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cE("contact_info_wxpay_collection_install", false);
    this.screen.cE("contact_info_wxpay_collection_uninstall", true);
    this.screen.cE("contact_info_wxpay_collection_go_to", true);
    this.screen.cE("contact_info_wxpay_collection_top", true);
    this.screen.cE("contact_info_wxpay_collection_not_disturb", true);
    this.screen.cE("contact_info_wxpay_collection_help", true);
    this.screen.cE("contact_info_wxpay_collection_clear_data", true);
    AppMethodBeat.o(187176);
  }
  
  final void edH()
  {
    AppMethodBeat.i(187182);
    if ((this.zUu != null) && (this.zUu.size() > 0))
    {
      Iterator localIterator = this.zUu.iterator();
      while (localIterator.hasNext())
      {
        Preference localPreference = (Preference)localIterator.next();
        this.screen.d(localPreference);
      }
      this.screen.notifyDataSetChanged();
      this.zUu.clear();
    }
    AppMethodBeat.o(187182);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(187177);
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      com.tencent.mm.kernel.g.aeS().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString))) {
          Toast.makeText(aj.getContext(), paramString, 1).show();
        }
      }
      for (;;)
      {
        if (this.lAj != null) {
          this.lAj.dismiss();
        }
        bRv();
        AppMethodBeat.o(187177);
        return;
        localObject = ((com.tencent.mm.pluginsdk.model.o)paramn).evr();
        ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "bind fitness contact %s success", new Object[] { localObject });
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY("gh_f0a92aa7146c");
        if ((paramn != null) && (!bt.isNullOrNil((String)localObject))) {
          break;
        }
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "respUsername == " + (String)localObject + ", contact = " + paramn);
        paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ei(paramn.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.afB().afk().set(327825, Boolean.TRUE);
      }
      if (!w.sC(paramn.field_username)) {
        break label720;
      }
      String str = bt.nullAsNil(paramn.field_username);
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ei(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ej(str);
      paramn.nj(str);
    }
    for (;;)
    {
      paramn.setUsername((String)localObject);
      if ((int)paramn.fId == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ag(paramn);
      }
      if ((int)paramn.fId <= 0)
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "addContact : insert contact failed");
        break;
      }
      w.u(paramn);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramn.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ei(((au)localObject).field_username);
      if ((paramString == null) || (paramString.IY()))
      {
        ad.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "shouldUpdate");
        ar.a.gMW.aB(((au)localObject).field_username, "");
        com.tencent.mm.ak.c.vO(((au)localObject).field_username);
        break;
      }
      if (!((af)localObject).eKF()) {
        break;
      }
      ad.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "update contact, last check time=%d", new Object[] { Integer.valueOf(((au)localObject).evG) });
      ar.a.gMW.aB(((au)localObject).field_username, "");
      com.tencent.mm.ak.c.vO(((au)localObject).field_username);
      break;
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.k))
      {
        com.tencent.mm.kernel.g.aeS().b(2860, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.k)paramn;
          if (paramString.zWc == null) {}
          for (paramString = new azl();; paramString = paramString.zWc)
          {
            a(paramString);
            b(paramString);
            AppMethodBeat.o(187177);
            return;
          }
        }
        ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(187177);
      return;
      label720:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a
 * JD-Core Version:    0.7.0.1
 */