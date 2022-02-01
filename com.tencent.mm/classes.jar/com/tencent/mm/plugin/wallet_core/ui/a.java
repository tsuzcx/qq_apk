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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.aa;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.ji;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.p;
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
  implements com.tencent.mm.ak.f, com.tencent.mm.pluginsdk.b.a
{
  private List<Preference> DeL;
  private CheckBoxPreference Dtt;
  an contact;
  Context context;
  private p mHs;
  private CheckBoxPreference pyb;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(190215);
    this.DeL = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(190215);
  }
  
  private void a(bhz parambhz)
  {
    AppMethodBeat.i(190221);
    if (!com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      eKQ();
      AppMethodBeat.o(190221);
      return;
    }
    eKQ();
    if ((parambhz != null) && (parambhz.GWk != null) && (parambhz.GWk.GWf != null) && (!parambhz.GWk.GWf.isEmpty()))
    {
      int i = this.screen.indexOf("contact_info_wxpay_collection_go_to");
      parambhz = parambhz.GWk.GWf.iterator();
      while (parambhz.hasNext())
      {
        Object localObject1 = (brb)parambhz.next();
        if (((brb)localObject1).Heh.isEmpty())
        {
          ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "ItemSectionViewData is null");
        }
        else
        {
          i += 1;
          Object localObject2 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject2, i);
          this.DeL.add(localObject2);
          localObject1 = ((brb)localObject1).Heh.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (dmr)((Iterator)localObject1).next();
            if ((((dmr)localObject3).HTX.isEmpty()) || (((dmr)localObject3).HTY.isEmpty()))
            {
              ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData data null");
            }
            else
            {
              localObject2 = (dnl)((dmr)localObject3).HTX.get(0);
              dnl localdnl = (dnl)((dmr)localObject3).HTY.get(0);
              localObject3 = ((dmr)localObject3).FLp;
              if ((((dnl)localObject2).HUA.isEmpty()) || (bu.isNullOrNil(((dni)((dnl)localObject2).HUA.get(0)).text)) || (localObject3 == null))
              {
                ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData inner data null");
              }
              else
              {
                i += 1;
                Preference local3 = new Preference(this.context)
                {
                  public final void onBindView(View paramAnonymousView)
                  {
                    AppMethodBeat.i(190212);
                    super.onBindView(paramAnonymousView);
                    if (this.JOj != null) {
                      paramAnonymousView.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(190211);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bd(paramAnonymous2View);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                          a.3.this.JOj.dDy();
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(190211);
                        }
                      });
                    }
                    AppMethodBeat.o(190212);
                  }
                };
                local3.setTitle(((dni)((dnl)localObject2).HUA.get(0)).text);
                local3.setLayoutResource(2131494804);
                if ((!localdnl.HUA.isEmpty()) && (!bu.isNullOrNil(((dni)localdnl.HUA.get(0)).text))) {
                  local3.setSummary(((dni)localdnl.HUA.get(0)).text);
                }
                this.screen.a(local3, i);
                this.DeL.add(local3);
                local3.JOj = new Preference.b()
                {
                  public final boolean dDy()
                  {
                    AppMethodBeat.i(190213);
                    ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "text(%s) click!", new Object[] { ((dni)this.Dtx.HUA.get(0)).text });
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("key_tiny_app_scene", 1165);
                    com.tencent.mm.plugin.wallet_core.utils.g.a(a.this.context, this.Dty, localBundle);
                    com.tencent.mm.plugin.report.service.g.yxI.f(19541, new Object[] { Integer.valueOf(1), ((dni)this.Dtx.HUA.get(0)).text });
                    AppMethodBeat.o(190213);
                    return true;
                  }
                };
              }
            }
          }
        }
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(190221);
      return;
    }
    ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin no data");
    AppMethodBeat.o(190221);
  }
  
  static void b(bhz parambhz)
  {
    AppMethodBeat.i(190222);
    if ((parambhz != null) && (parambhz.GWk != null) && (parambhz.GWk.GWf != null) && (!parambhz.GWk.GWf.isEmpty())) {}
    for (;;)
    {
      try
      {
        parambhz = new String(parambhz.toByteArray(), "ISO-8859-1");
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jeg, parambhz);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().fuc();
        AppMethodBeat.o(190222);
        return;
      }
      catch (IOException parambhz)
      {
        ae.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "save config exp, " + parambhz.getLocalizedMessage());
      }
      parambhz = " ";
    }
  }
  
  private static bhz eKP()
  {
    AppMethodBeat.i(190223);
    bhz localbhz = new bhz();
    com.tencent.mm.kernel.g.ajS();
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jeg, null);
    if (bu.isNullOrNil(str)) {
      ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "etReceiptAssisPluginResponse failed");
    }
    for (;;)
    {
      AppMethodBeat.o(190223);
      return localbhz;
      try
      {
        localbhz.parseFrom(str.getBytes("ISO-8859-1"));
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.WxPay.ContactWidgetWxPayCollection", "parseConfig exp, " + localException.getLocalizedMessage());
      }
    }
  }
  
  static void tW(int paramInt)
  {
    AppMethodBeat.i(190220);
    ji localji = new ji();
    localji.etA = paramInt;
    localji.aLH();
    AppMethodBeat.o(190220);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(190216);
    this.screen = paramf;
    this.contact = paraman;
    paramf.addPreferencesFromResource(2131951663);
    this.Dtt = ((CheckBoxPreference)paramf.aXe("contact_info_wxpay_collection_top"));
    this.pyb = ((CheckBoxPreference)paramf.aXe("contact_info_wxpay_collection_not_disturb"));
    ceD();
    a(eKP());
    com.tencent.mm.kernel.g.ajj().a(2860, this);
    paramf = new k();
    com.tencent.mm.kernel.g.ajj().a(paramf, 0);
    AppMethodBeat.o(190216);
    return true;
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(190217);
    ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "handleEvent key:%s", new Object[] { paramString });
    if (bu.lX("contact_info_wxpay_collection_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      d.f(this.context, ".ui.chatting.ChattingUI", paramString);
      tW(3);
    }
    for (;;)
    {
      AppMethodBeat.o(190217);
      return false;
      if (bu.lX("contact_info_wxpay_collection_top", paramString))
      {
        if (this.Dtt.isChecked())
        {
          x.D(this.contact.field_username, true);
          tW(4);
        }
        else
        {
          x.E(this.contact.field_username, true);
          tW(5);
        }
      }
      else if (bu.lX("contact_info_wxpay_collection_not_disturb", paramString))
      {
        if (this.pyb.isChecked())
        {
          x.z(this.contact);
          tW(6);
        }
        else
        {
          x.A(this.contact);
          tW(7);
        }
      }
      else if (bu.lX("contact_info_wxpay_collection_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.f.u("gh_106decc2eec5@app", "/pages/product/productInfo/product.html?code=A4075&producttitle=收款小账本&scene_id=kf5662", 0, 1165);
        tW(8);
      }
      else if (bu.lX("contact_info_wxpay_collection_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(190209);
            com.tencent.e.h.MqF.aO(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(190208);
                ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "clear record");
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arj("gh_f0a92aa7146c");
                AppMethodBeat.o(190208);
              }
            });
            a.tW(9);
            AppMethodBeat.o(190209);
          }
        }, null);
      }
      else if (bu.lX("contact_info_wxpay_collection_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755906);
        this.mHs = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.mHs.show();
        com.tencent.mm.kernel.g.ajj().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_f0a92aa7146c");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.o(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.ajj().a(paramString, 0);
        com.tencent.mm.kernel.g.ajQ().gDv.a(new aa(new a.5(this)), 0);
        tW(11);
      }
      else if (bu.lX("contact_info_wxpay_collection_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(190210);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eX(a.this.contact.field_username);
            ((com.tencent.mm.api.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.l.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.ceD();
            a.this.eKQ();
            a.b(null);
            a.tW(10);
            AppMethodBeat.o(190210);
          }
        }, null);
      }
    }
  }
  
  public final boolean ceC()
  {
    return true;
  }
  
  final void ceD()
  {
    AppMethodBeat.i(190218);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    localHelperHeaderPreference.ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757906));
    ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "contact.getUsername():%s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cT("contact_info_wxpay_collection_install", true);
      this.screen.cT("contact_info_wxpay_collection_uninstall", false);
      this.screen.cT("contact_info_wxpay_collection_go_to", false);
      this.screen.cT("contact_info_wxpay_collection_top", false);
      this.screen.cT("contact_info_wxpay_collection_not_disturb", false);
      this.screen.cT("contact_info_wxpay_collection_help", false);
      this.screen.cT("contact_info_wxpay_collection_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVi(this.contact.field_username)) {
        this.Dtt.setChecked(true);
      }
      while (this.contact.Pd())
      {
        this.pyb.setChecked(true);
        AppMethodBeat.o(190218);
        return;
        this.Dtt.setChecked(false);
      }
      this.pyb.setChecked(false);
      AppMethodBeat.o(190218);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cT("contact_info_wxpay_collection_install", false);
    this.screen.cT("contact_info_wxpay_collection_uninstall", true);
    this.screen.cT("contact_info_wxpay_collection_go_to", true);
    this.screen.cT("contact_info_wxpay_collection_top", true);
    this.screen.cT("contact_info_wxpay_collection_not_disturb", true);
    this.screen.cT("contact_info_wxpay_collection_help", true);
    this.screen.cT("contact_info_wxpay_collection_clear_data", true);
    AppMethodBeat.o(190218);
  }
  
  final void eKQ()
  {
    AppMethodBeat.i(190224);
    if ((this.DeL != null) && (this.DeL.size() > 0))
    {
      Iterator localIterator = this.DeL.iterator();
      while (localIterator.hasNext())
      {
        Preference localPreference = (Preference)localIterator.next();
        this.screen.d(localPreference);
      }
      this.screen.notifyDataSetChanged();
      this.DeL.clear();
    }
    AppMethodBeat.o(190224);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190219);
    ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      com.tencent.mm.kernel.g.ajj().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bu.isNullOrNil(paramString))) {
          Toast.makeText(ak.getContext(), paramString, 1).show();
        }
      }
      for (;;)
      {
        if (this.mHs != null) {
          this.mHs.dismiss();
        }
        ceD();
        AppMethodBeat.o(190219);
        return;
        localObject = ((com.tencent.mm.pluginsdk.model.o)paramn).fdt();
        ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "bind fitness contact %s success", new Object[] { localObject });
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH("gh_f0a92aa7146c");
        if ((paramn != null) && (!bu.isNullOrNil((String)localObject))) {
          break;
        }
        ae.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "respUsername == " + (String)localObject + ", contact = " + paramn);
        paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eX(paramn.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.ajR().ajA().set(327825, Boolean.TRUE);
      }
      if (!x.Am(paramn.field_username)) {
        break label720;
      }
      String str = bu.nullAsNil(paramn.field_username);
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eX(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eY(str);
      paramn.tu(str);
    }
    for (;;)
    {
      paramn.setUsername((String)localObject);
      if ((int)paramn.ght == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().ao(paramn);
      }
      if ((int)paramn.ght <= 0)
      {
        ae.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "addContact : insert contact failed");
        break;
      }
      x.B(paramn);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramn.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eX(((aw)localObject).field_username);
      if ((paramString == null) || (paramString.Kp()))
      {
        ae.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "shouldUpdate");
        au.a.hIG.aJ(((aw)localObject).field_username, "");
        com.tencent.mm.aj.c.Dv(((aw)localObject).field_username);
        break;
      }
      if (!((an)localObject).fuk()) {
        break;
      }
      ae.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aw)localObject).eRm) });
      au.a.hIG.aJ(((aw)localObject).field_username, "");
      com.tencent.mm.aj.c.Dv(((aw)localObject).field_username);
      break;
      if ((paramn instanceof k))
      {
        com.tencent.mm.kernel.g.ajj().b(2860, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (k)paramn;
          if (paramString.Dgq == null) {}
          for (paramString = new bhz();; paramString = paramString.Dgq)
          {
            a(paramString);
            b(paramString);
            AppMethodBeat.o(190219);
            return;
          }
        }
        ae.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(190219);
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