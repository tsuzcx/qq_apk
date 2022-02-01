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
import com.tencent.mm.ao.aa;
import com.tencent.mm.api.m;
import com.tencent.mm.api.p;
import com.tencent.mm.f.b.a.qd;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eqh;
import com.tencent.mm.protocal.protobuf.eqi;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.erh;
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
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.an.i, com.tencent.mm.pluginsdk.c.a
{
  private List<Preference> OCA;
  private CheckBoxPreference OUS;
  private as contact;
  private Context context;
  private s oTk;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference uoF;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(276161);
    this.OCA = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(276161);
  }
  
  private static void Bv(int paramInt)
  {
    AppMethodBeat.i(276169);
    qd localqd = new qd();
    localqd.hal = paramInt;
    localqd.bpa();
    AppMethodBeat.o(276169);
  }
  
  private void a(cbp paramcbp)
  {
    AppMethodBeat.i(276171);
    if (!com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      gLb();
      AppMethodBeat.o(276171);
      return;
    }
    gLb();
    if ((paramcbp != null) && (paramcbp.TjY != null) && (paramcbp.TjY.TjT != null) && (!paramcbp.TjY.TjT.isEmpty()))
    {
      int i = this.screen.bf("contact_info_wxpay_collection_go_to");
      paramcbp = paramcbp.TjY.TjT.iterator();
      while (paramcbp.hasNext())
      {
        Object localObject1 = (cmp)paramcbp.next();
        if (((cmp)localObject1).Tue.isEmpty())
        {
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "ItemSectionViewData is null");
        }
        else
        {
          i += 1;
          Object localObject2 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject2, i);
          this.OCA.add(localObject2);
          localObject1 = ((cmp)localObject1).Tue.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (eqh)((Iterator)localObject1).next();
            if ((((eqh)localObject3).UsK.isEmpty()) || (((eqh)localObject3).UsL.isEmpty()))
            {
              Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData data null");
            }
            else
            {
              localObject2 = (erh)((eqh)localObject3).UsK.get(0);
              erh localerh = (erh)((eqh)localObject3).UsL.get(0);
              localObject3 = ((eqh)localObject3).RGh;
              if ((((erh)localObject2).Uty.isEmpty()) || (Util.isNullOrNil(((ere)((erh)localObject2).Uty.get(0)).text)) || (localObject3 == null))
              {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData inner data null");
              }
              else
              {
                i += 1;
                Preference local3 = new Preference(this.context)
                {
                  public final void onBindView(View paramAnonymousView)
                  {
                    AppMethodBeat.i(273052);
                    super.onBindView(paramAnonymousView);
                    if (this.Wsy != null) {
                      paramAnonymousView.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(226640);
                          b localb = new b();
                          localb.bn(paramAnonymous2View);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                          a.3.this.Wsy.fpI();
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(226640);
                        }
                      });
                    }
                    AppMethodBeat.o(273052);
                  }
                };
                local3.setTitle(((ere)((erh)localObject2).Uty.get(0)).text);
                local3.setLayoutResource(a.g.mm_preference);
                if ((!localerh.Uty.isEmpty()) && (!Util.isNullOrNil(((ere)localerh.Uty.get(0)).text))) {
                  local3.aF(((ere)localerh.Uty.get(0)).text);
                }
                this.screen.a(local3, i);
                this.OCA.add(local3);
                local3.Wsy = new a.4(this, (erh)localObject2, (eaa)localObject3);
              }
            }
          }
        }
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(276171);
      return;
    }
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin no data");
    AppMethodBeat.o(276171);
  }
  
  private static void b(cbp paramcbp)
  {
    AppMethodBeat.i(276172);
    if ((paramcbp != null) && (paramcbp.TjY != null) && (paramcbp.TjY.TjT != null) && (!paramcbp.TjY.TjT.isEmpty())) {}
    for (;;)
    {
      try
      {
        paramcbp = new String(paramcbp.toByteArray(), "ISO-8859-1");
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDa, paramcbp);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().hxT();
        AppMethodBeat.o(276172);
        return;
      }
      catch (IOException paramcbp)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "save config exp, " + paramcbp.getLocalizedMessage());
      }
      paramcbp = " ";
    }
  }
  
  private void cQY()
  {
    AppMethodBeat.i(276166);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    localHelperHeaderPreference.bf(this.contact.field_username, this.contact.ays(), this.context.getString(a.i.contact_info_wxpay_collection_switch_tip));
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "contact.getUsername():%s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.dz("contact_info_wxpay_collection_install", true);
      this.screen.dz("contact_info_wxpay_collection_uninstall", false);
      this.screen.dz("contact_info_wxpay_collection_go_to", false);
      this.screen.dz("contact_info_wxpay_collection_top", false);
      this.screen.dz("contact_info_wxpay_collection_not_disturb", false);
      this.screen.dz("contact_info_wxpay_collection_help", false);
      this.screen.dz("contact_info_wxpay_collection_clear_data", false);
      if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF(this.contact.field_username)) {
        this.OUS.setChecked(true);
      }
      while (this.contact.aeg())
      {
        this.uoF.setChecked(true);
        AppMethodBeat.o(276166);
        return;
        this.OUS.setChecked(false);
      }
      this.uoF.setChecked(false);
      AppMethodBeat.o(276166);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.dz("contact_info_wxpay_collection_install", false);
    this.screen.dz("contact_info_wxpay_collection_uninstall", true);
    this.screen.dz("contact_info_wxpay_collection_go_to", true);
    this.screen.dz("contact_info_wxpay_collection_top", true);
    this.screen.dz("contact_info_wxpay_collection_not_disturb", true);
    this.screen.dz("contact_info_wxpay_collection_help", true);
    this.screen.dz("contact_info_wxpay_collection_clear_data", true);
    AppMethodBeat.o(276166);
  }
  
  private static cbp gLa()
  {
    AppMethodBeat.i(276173);
    cbp localcbp = new cbp();
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDa, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "etReceiptAssisPluginResponse failed");
    }
    for (;;)
    {
      AppMethodBeat.o(276173);
      return localcbp;
      try
      {
        localcbp.parseFrom(str.getBytes("ISO-8859-1"));
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.WxPay.ContactWidgetWxPayCollection", "parseConfig exp, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private void gLb()
  {
    AppMethodBeat.i(276174);
    if ((this.OCA != null) && (this.OCA.size() > 0))
    {
      Iterator localIterator = this.OCA.iterator();
      while (localIterator.hasNext())
      {
        Preference localPreference = (Preference)localIterator.next();
        this.screen.d(localPreference);
      }
      this.screen.notifyDataSetChanged();
      this.OCA.clear();
    }
    AppMethodBeat.o(276174);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(276162);
    this.screen = paramf;
    this.contact = paramas;
    paramf.auC(a.m.contact_info_pref_wxpay_collection);
    this.OUS = ((CheckBoxPreference)paramf.byG("contact_info_wxpay_collection_top"));
    this.uoF = ((CheckBoxPreference)paramf.byG("contact_info_wxpay_collection_not_disturb"));
    cQY();
    a(gLa());
    com.tencent.mm.kernel.h.aGY().a(2860, this);
    paramf = new l();
    com.tencent.mm.kernel.h.aGY().a(paramf, 0);
    AppMethodBeat.o(276162);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(276165);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_collection_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.by.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
      Bv(3);
    }
    for (;;)
    {
      AppMethodBeat.o(276165);
      return false;
      if (Util.isEqual("contact_info_wxpay_collection_top", paramString))
      {
        if (this.OUS.isChecked())
        {
          ab.G(this.contact.field_username, true);
          Bv(4);
        }
        else
        {
          ab.H(this.contact.field_username, true);
          Bv(5);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_collection_not_disturb", paramString))
      {
        if (this.uoF.isChecked())
        {
          ab.F(this.contact);
          Bv(6);
        }
        else
        {
          ab.G(this.contact);
          Bv(7);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_collection_help", paramString))
      {
        g.v("gh_106decc2eec5@app", "/pages/product/productInfo/product.html?code=A4075&producttitle=收款小账本&scene_id=kf5662", 0, 1165);
        Bv(8);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(a.i.contact_info_clear_data), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(271060);
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(251106);
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "clear record");
                ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOO("gh_f0a92aa7146c");
                AppMethodBeat.o(251106);
              }
            });
            a.amC(9);
            AppMethodBeat.o(271060);
          }
        }, null);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_install", paramString))
      {
        paramString = this.context;
        this.context.getString(a.i.app_tip);
        this.oTk = com.tencent.mm.ui.base.h.a(paramString, this.context.getString(a.i.settings_plugins_installing), true, null);
        this.oTk.show();
        com.tencent.mm.kernel.h.aGY().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_f0a92aa7146c");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.t(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        com.tencent.mm.kernel.h.aHF().kcd.a(new aa(new a.5(this)), 0);
        Bv(11);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(a.i.settings_plugins_uninstall_hint), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(272244);
            paramAnonymousDialogInterface = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(a.a(a.this).field_username);
            ((m)com.tencent.mm.kernel.h.ae(m.class)).a(paramAnonymousDialogInterface, (Activity)a.b(a.this), a.a(a.this));
            a.c(a.this);
            a.d(a.this);
            a.gLc();
            a.amC(10);
            AppMethodBeat.o(272244);
          }
        }, null);
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
    AppMethodBeat.i(276168);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    Object localObject;
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      com.tencent.mm.kernel.h.aGY().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        AppMethodBeat.o(276168);
        return;
        localObject = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "bind fitness contact %s success", new Object[] { localObject });
        paramq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_f0a92aa7146c");
        if ((paramq != null) && (!Util.isNullOrNil((String)localObject))) {
          break;
        }
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "respUsername == " + (String)localObject + ", contact = " + paramq);
        paramString = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(paramq.field_username);
        if (paramString != null) {
          ((p)com.tencent.mm.kernel.h.ae(p.class)).a(paramString);
        }
        com.tencent.mm.kernel.h.aHG().aHp().i(327825, Boolean.TRUE);
      }
      if (!ab.Qk(paramq.field_username)) {
        break label720;
      }
      String str = Util.nullAsNil(paramq.field_username);
      paramString = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      ((p)com.tencent.mm.kernel.h.ae(p.class)).gv(str);
      paramq.Iy(str);
    }
    for (;;)
    {
      paramq.setUsername((String)localObject);
      if ((int)paramq.jxt == 0) {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().aw(paramq);
      }
      if ((int)paramq.jxt <= 0)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "addContact : insert contact failed");
        break;
      }
      ab.H(paramq);
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramq.field_username);
      if (paramString != null)
      {
        ((p)com.tencent.mm.kernel.h.ae(p.class)).b(paramString);
        break;
      }
      paramString = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(((ax)localObject).field_username);
      if ((paramString == null) || (paramString.YR()))
      {
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "shouldUpdate");
        az.a.ltq.aP(((ax)localObject).field_username, "");
        com.tencent.mm.am.d.TA(((ax)localObject).field_username);
        break;
      }
      if (!((as)localObject).hyb()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject).hDo) });
      az.a.ltq.aP(((ax)localObject).field_username, "");
      com.tencent.mm.am.d.TA(((ax)localObject).field_username);
      break;
      if ((paramq instanceof l))
      {
        com.tencent.mm.kernel.h.aGY().b(2860, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (l)paramq;
          if (paramString.OHS == null) {}
          for (paramString = new cbp();; paramString = paramString.OHS)
          {
            a(paramString);
            b(paramString);
            AppMethodBeat.o(276168);
            return;
          }
        }
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(276168);
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