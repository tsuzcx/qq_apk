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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.z;
import com.tencent.mm.al.z.a;
import com.tencent.mm.api.l;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.ic;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
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
  implements com.tencent.mm.ak.g, com.tencent.mm.pluginsdk.b.a
{
  private CheckBoxPreference BBx;
  private List<Preference> BmO;
  com.tencent.mm.storage.ai contact;
  Context context;
  private p mcf;
  private CheckBoxPreference oNN;
  private f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(207295);
    this.BmO = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(207295);
  }
  
  private void a(bdd parambdd)
  {
    AppMethodBeat.i(207301);
    if (!com.tencent.mm.n.b.ln(this.contact.field_type))
    {
      etc();
      AppMethodBeat.o(207301);
      return;
    }
    etc();
    if ((parambdd != null) && (parambdd.ETq != null) && (parambdd.ETq.ETm != null) && (!parambdd.ETq.ETm.isEmpty()))
    {
      int i = this.screen.indexOf("contact_info_wxpay_collection_go_to");
      parambdd = parambdd.ETq.ETm.iterator();
      while (parambdd.hasNext())
      {
        Object localObject1 = (blx)parambdd.next();
        if (((blx)localObject1).Fbh.isEmpty())
        {
          ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "ItemSectionViewData is null");
        }
        else
        {
          i += 1;
          Object localObject2 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject2, i);
          this.BmO.add(localObject2);
          localObject1 = ((blx)localObject1).Fbh.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (dgh)((Iterator)localObject1).next();
            if ((((dgh)localObject3).FPF.isEmpty()) || (((dgh)localObject3).FPG.isEmpty()))
            {
              ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData data null");
            }
            else
            {
              localObject2 = (dhb)((dgh)localObject3).FPF.get(0);
              dhb localdhb = (dhb)((dgh)localObject3).FPG.get(0);
              localObject3 = ((dgh)localObject3).DNL;
              if ((((dhb)localObject2).FQj.isEmpty()) || (bs.isNullOrNil(((dgy)((dhb)localObject2).FQj.get(0)).text)) || (localObject3 == null))
              {
                ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData inner data null");
              }
              else
              {
                i += 1;
                Preference local3 = new Preference(this.context)
                {
                  public final void onBindView(View paramAnonymousView)
                  {
                    AppMethodBeat.i(207292);
                    super.onBindView(paramAnonymousView);
                    if (this.HFD != null) {
                      paramAnonymousView.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(207291);
                          a.3.this.HFD.dpE();
                          AppMethodBeat.o(207291);
                        }
                      });
                    }
                    AppMethodBeat.o(207292);
                  }
                };
                local3.setTitle(((dgy)((dhb)localObject2).FQj.get(0)).text);
                local3.setLayoutResource(2131494804);
                if ((!localdhb.FQj.isEmpty()) && (!bs.isNullOrNil(((dgy)localdhb.FQj.get(0)).text))) {
                  local3.setSummary(((dgy)localdhb.FQj.get(0)).text);
                }
                this.screen.a(local3, i);
                this.BmO.add(local3);
                local3.HFD = new Preference.b()
                {
                  public final boolean dpE()
                  {
                    AppMethodBeat.i(207293);
                    ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "text(%s) click!", new Object[] { ((dgy)this.BBB.FQj.get(0)).text });
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("key_tiny_app_scene", 1165);
                    com.tencent.mm.plugin.wallet_core.utils.g.a(a.this.context, this.BBC, localBundle);
                    com.tencent.mm.plugin.report.service.h.wUl.f(19541, new Object[] { Integer.valueOf(1), ((dgy)this.BBB.FQj.get(0)).text });
                    AppMethodBeat.o(207293);
                    return true;
                  }
                };
              }
            }
          }
        }
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(207301);
      return;
    }
    ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin no data");
    AppMethodBeat.o(207301);
  }
  
  static void b(bdd parambdd)
  {
    AppMethodBeat.i(207302);
    if ((parambdd != null) && (parambdd.ETq != null) && (parambdd.ETq.ETm != null) && (!parambdd.ETq.ETm.isEmpty())) {}
    for (;;)
    {
      try
      {
        parambdd = new String(parambdd.toByteArray(), "ISO-8859-1");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWA, parambdd);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().faa();
        AppMethodBeat.o(207302);
        return;
      }
      catch (IOException parambdd)
      {
        ac.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "save config exp, " + parambdd.getLocalizedMessage());
      }
      parambdd = " ";
    }
  }
  
  private static bdd etb()
  {
    AppMethodBeat.i(207303);
    bdd localbdd = new bdd();
    com.tencent.mm.kernel.g.agS();
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GWA, null);
    if (bs.isNullOrNil(str)) {
      ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "etReceiptAssisPluginResponse failed");
    }
    for (;;)
    {
      AppMethodBeat.o(207303);
      return localbdd;
      try
      {
        localbdd.parseFrom(str.getBytes("ISO-8859-1"));
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.WxPay.ContactWidgetWxPayCollection", "parseConfig exp, " + localException.getLocalizedMessage());
      }
    }
  }
  
  static void tn(int paramInt)
  {
    AppMethodBeat.i(207300);
    ic localic = new ic();
    localic.ebn = paramInt;
    localic.aHZ();
    AppMethodBeat.o(207300);
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(207297);
    ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "handleEvent key:%s", new Object[] { paramString });
    if (bs.lr("contact_info_wxpay_collection_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      d.e(this.context, ".ui.chatting.ChattingUI", paramString);
      tn(3);
    }
    for (;;)
    {
      AppMethodBeat.o(207297);
      return false;
      if (bs.lr("contact_info_wxpay_collection_top", paramString))
      {
        if (this.BBx.isChecked())
        {
          w.D(this.contact.field_username, true);
          tn(4);
        }
        else
        {
          w.E(this.contact.field_username, true);
          tn(5);
        }
      }
      else if (bs.lr("contact_info_wxpay_collection_not_disturb", paramString))
      {
        if (this.oNN.isChecked())
        {
          w.s(this.contact);
          tn(6);
        }
        else
        {
          w.t(this.contact);
          tn(7);
        }
      }
      else if (bs.lr("contact_info_wxpay_collection_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.e.v("gh_106decc2eec5@app", "/pages/product/productInfo/product.html?code=A4075&producttitle=收款小账本&scene_id=kf5662", 0, 1165);
        tn(8);
      }
      else if (bs.lr("contact_info_wxpay_collection_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(207289);
            com.tencent.e.h.JZN.aS(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(207288);
                ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "clear record");
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alq("gh_f0a92aa7146c");
                AppMethodBeat.o(207288);
              }
            });
            a.tn(9);
            AppMethodBeat.o(207289);
          }
        }, null);
      }
      else if (bs.lr("contact_info_wxpay_collection_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755906);
        this.mcf = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.mcf.show();
        com.tencent.mm.kernel.g.agi().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_f0a92aa7146c");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.o(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
        com.tencent.mm.kernel.g.agQ().ghe.a(new z(new z.a() {}), 0);
        tn(11);
      }
      else if (bs.lr("contact_info_wxpay_collection_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(207290);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dX(a.this.contact.field_username);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.bYK();
            a.this.etc();
            a.b(null);
            a.tn(10);
            AppMethodBeat.o(207290);
          }
        }, null);
      }
    }
  }
  
  public final boolean a(f paramf, com.tencent.mm.storage.ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(207296);
    this.screen = paramf;
    this.contact = paramai;
    paramf.addPreferencesFromResource(2131951663);
    this.BBx = ((CheckBoxPreference)paramf.aPN("contact_info_wxpay_collection_top"));
    this.oNN = ((CheckBoxPreference)paramf.aPN("contact_info_wxpay_collection_not_disturb"));
    bYK();
    a(etb());
    com.tencent.mm.kernel.g.agi().a(2860, this);
    paramf = new com.tencent.mm.plugin.wallet_core.c.k();
    com.tencent.mm.kernel.g.agi().a(paramf, 0);
    AppMethodBeat.o(207296);
    return true;
  }
  
  public final boolean bYJ()
  {
    return true;
  }
  
  final void bYK()
  {
    AppMethodBeat.i(207298);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    localHelperHeaderPreference.aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757906));
    ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "contact.getUsername():%s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.n.b.ln(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cK("contact_info_wxpay_collection_install", true);
      this.screen.cK("contact_info_wxpay_collection_uninstall", false);
      this.screen.cK("contact_info_wxpay_collection_go_to", false);
      this.screen.cK("contact_info_wxpay_collection_top", false);
      this.screen.cK("contact_info_wxpay_collection_not_disturb", false);
      this.screen.cK("contact_info_wxpay_collection_help", false);
      this.screen.cK("contact_info_wxpay_collection_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNQ(this.contact.field_username)) {}
      for (this.BBx.mF = true; this.contact.Nw(); this.BBx.mF = false)
      {
        this.oNN.mF = true;
        AppMethodBeat.o(207298);
        return;
      }
      this.oNN.mF = false;
      AppMethodBeat.o(207298);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cK("contact_info_wxpay_collection_install", false);
    this.screen.cK("contact_info_wxpay_collection_uninstall", true);
    this.screen.cK("contact_info_wxpay_collection_go_to", true);
    this.screen.cK("contact_info_wxpay_collection_top", true);
    this.screen.cK("contact_info_wxpay_collection_not_disturb", true);
    this.screen.cK("contact_info_wxpay_collection_help", true);
    this.screen.cK("contact_info_wxpay_collection_clear_data", true);
    AppMethodBeat.o(207298);
  }
  
  final void etc()
  {
    AppMethodBeat.i(207304);
    if ((this.BmO != null) && (this.BmO.size() > 0))
    {
      Iterator localIterator = this.BmO.iterator();
      while (localIterator.hasNext())
      {
        Preference localPreference = (Preference)localIterator.next();
        this.screen.d(localPreference);
      }
      this.screen.notifyDataSetChanged();
      this.BmO.clear();
    }
    AppMethodBeat.o(207304);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(207299);
    ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      com.tencent.mm.kernel.g.agi().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bs.isNullOrNil(paramString))) {
          Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), paramString, 1).show();
        }
      }
      for (;;)
      {
        if (this.mcf != null) {
          this.mcf.dismiss();
        }
        bYK();
        AppMethodBeat.o(207299);
        return;
        localObject = ((com.tencent.mm.pluginsdk.model.o)paramn).eKL();
        ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "bind fitness contact %s success", new Object[] { localObject });
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt("gh_f0a92aa7146c");
        if ((paramn != null) && (!bs.isNullOrNil((String)localObject))) {
          break;
        }
        ac.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "respUsername == " + (String)localObject + ", contact = " + paramn);
        paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dX(paramn.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.agR().agA().set(327825, Boolean.TRUE);
      }
      if (!w.wF(paramn.field_username)) {
        break label720;
      }
      String str = bs.nullAsNil(paramn.field_username);
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dX(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dY(str);
      paramn.qp(str);
    }
    for (;;)
    {
      paramn.setUsername((String)localObject);
      if ((int)paramn.fLJ == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ah(paramn);
      }
      if ((int)paramn.fLJ <= 0)
      {
        ac.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "addContact : insert contact failed");
        break;
      }
      w.u(paramn);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramn.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dX(((av)localObject).field_username);
      if ((paramString == null) || (paramString.IH()))
      {
        ac.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "shouldUpdate");
        ar.a.hnw.aJ(((av)localObject).field_username, "");
        com.tencent.mm.aj.c.zU(((av)localObject).field_username);
        break;
      }
      if (!((com.tencent.mm.storage.ai)localObject).fah()) {
        break;
      }
      ac.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "update contact, last check time=%d", new Object[] { Integer.valueOf(((av)localObject).eyc) });
      ar.a.hnw.aJ(((av)localObject).field_username, "");
      com.tencent.mm.aj.c.zU(((av)localObject).field_username);
      break;
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.k))
      {
        com.tencent.mm.kernel.g.agi().b(2860, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.k)paramn;
          if (paramString.Bow == null) {}
          for (paramString = new bdd();; paramString = paramString.Bow)
          {
            a(paramString);
            b(paramString);
            AppMethodBeat.o(207299);
            return;
          }
        }
        ac.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(207299);
      return;
      label720:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a
 * JD-Core Version:    0.7.0.1
 */