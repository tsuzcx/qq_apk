package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.aa;
import com.tencent.mm.am.aa.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.jg;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
  implements com.tencent.mm.al.f, com.tencent.mm.pluginsdk.b.a
{
  private List<Preference> CNd;
  private CheckBoxPreference DbP;
  am contact;
  Context context;
  private p mCn;
  private CheckBoxPreference prv;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(199335);
    this.CNd = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(199335);
  }
  
  private void a(bhj parambhj)
  {
    AppMethodBeat.i(199341);
    if (!com.tencent.mm.o.b.lM(this.contact.field_type))
    {
      eHi();
      AppMethodBeat.o(199341);
      return;
    }
    eHi();
    if ((parambhj != null) && (parambhj.GCJ != null) && (parambhj.GCJ.GCF != null) && (!parambhj.GCJ.GCF.isEmpty()))
    {
      int i = this.screen.indexOf("contact_info_wxpay_collection_go_to");
      parambhj = parambhj.GCJ.GCF.iterator();
      while (parambhj.hasNext())
      {
        Object localObject1 = (bqh)parambhj.next();
        if (((bqh)localObject1).GKG.isEmpty())
        {
          ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "ItemSectionViewData is null");
        }
        else
        {
          i += 1;
          Object localObject2 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject2, i);
          this.CNd.add(localObject2);
          localObject1 = ((bqh)localObject1).GKG.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (dlu)((Iterator)localObject1).next();
            if ((((dlu)localObject3).HAk.isEmpty()) || (((dlu)localObject3).HAl.isEmpty()))
            {
              ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData data null");
            }
            else
            {
              localObject2 = (dmo)((dlu)localObject3).HAk.get(0);
              dmo localdmo = (dmo)((dlu)localObject3).HAl.get(0);
              localObject3 = ((dlu)localObject3).FsR;
              if ((((dmo)localObject2).HAN.isEmpty()) || (bt.isNullOrNil(((dml)((dmo)localObject2).HAN.get(0)).text)) || (localObject3 == null))
              {
                ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData inner data null");
              }
              else
              {
                i += 1;
                a.3 local3 = new a.3(this, this.context);
                local3.setTitle(((dml)((dmo)localObject2).HAN.get(0)).text);
                local3.setLayoutResource(2131494804);
                if ((!localdmo.HAN.isEmpty()) && (!bt.isNullOrNil(((dml)localdmo.HAN.get(0)).text))) {
                  local3.setSummary(((dml)localdmo.HAN.get(0)).text);
                }
                this.screen.a(local3, i);
                this.CNd.add(local3);
                local3.Jtu = new Preference.b()
                {
                  public final boolean dAh()
                  {
                    AppMethodBeat.i(199333);
                    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "text(%s) click!", new Object[] { ((dml)this.DbT.HAN.get(0)).text });
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("key_tiny_app_scene", 1165);
                    com.tencent.mm.plugin.wallet_core.utils.g.a(a.this.context, this.DbU, localBundle);
                    com.tencent.mm.plugin.report.service.g.yhR.f(19541, new Object[] { Integer.valueOf(1), ((dml)this.DbT.HAN.get(0)).text });
                    AppMethodBeat.o(199333);
                    return true;
                  }
                };
              }
            }
          }
        }
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(199341);
      return;
    }
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin no data");
    AppMethodBeat.o(199341);
  }
  
  static void b(bhj parambhj)
  {
    AppMethodBeat.i(199342);
    if ((parambhj != null) && (parambhj.GCJ != null) && (parambhj.GCJ.GCF != null) && (!parambhj.GCJ.GCF.isEmpty())) {}
    for (;;)
    {
      try
      {
        parambhj = new String(parambhj.toByteArray(), "ISO-8859-1");
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJA, parambhj);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().fqc();
        AppMethodBeat.o(199342);
        return;
      }
      catch (IOException parambhj)
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "save config exp, " + parambhj.getLocalizedMessage());
      }
      parambhj = " ";
    }
  }
  
  private static bhj eHh()
  {
    AppMethodBeat.i(199343);
    bhj localbhj = new bhj();
    com.tencent.mm.kernel.g.ajD();
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IJA, null);
    if (bt.isNullOrNil(str)) {
      ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "etReceiptAssisPluginResponse failed");
    }
    for (;;)
    {
      AppMethodBeat.o(199343);
      return localbhj;
      try
      {
        localbhj.parseFrom(str.getBytes("ISO-8859-1"));
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.WxPay.ContactWidgetWxPayCollection", "parseConfig exp, " + localException.getLocalizedMessage());
      }
    }
  }
  
  static void tQ(int paramInt)
  {
    AppMethodBeat.i(199340);
    jg localjg = new jg();
    localjg.erT = paramInt;
    localjg.aLk();
    AppMethodBeat.o(199340);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(199336);
    this.screen = paramf;
    this.contact = paramam;
    paramf.addPreferencesFromResource(2131951663);
    this.DbP = ((CheckBoxPreference)paramf.aVD("contact_info_wxpay_collection_top"));
    this.prv = ((CheckBoxPreference)paramf.aVD("contact_info_wxpay_collection_not_disturb"));
    cdo();
    a(eHh());
    com.tencent.mm.kernel.g.aiU().a(2860, this);
    paramf = new k();
    com.tencent.mm.kernel.g.aiU().a(paramf, 0);
    AppMethodBeat.o(199336);
    return true;
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(199337);
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "handleEvent key:%s", new Object[] { paramString });
    if (bt.lQ("contact_info_wxpay_collection_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      d.f(this.context, ".ui.chatting.ChattingUI", paramString);
      tQ(3);
    }
    for (;;)
    {
      AppMethodBeat.o(199337);
      return false;
      if (bt.lQ("contact_info_wxpay_collection_top", paramString))
      {
        if (this.DbP.isChecked())
        {
          w.D(this.contact.field_username, true);
          tQ(4);
        }
        else
        {
          w.E(this.contact.field_username, true);
          tQ(5);
        }
      }
      else if (bt.lQ("contact_info_wxpay_collection_not_disturb", paramString))
      {
        if (this.prv.isChecked())
        {
          w.s(this.contact);
          tQ(6);
        }
        else
        {
          w.t(this.contact);
          tQ(7);
        }
      }
      else if (bt.lQ("contact_info_wxpay_collection_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.e.v("gh_106decc2eec5@app", "/pages/product/productInfo/product.html?code=A4075&producttitle=收款小账本&scene_id=kf5662", 0, 1165);
        tQ(8);
      }
      else if (bt.lQ("contact_info_wxpay_collection_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(199329);
            com.tencent.e.h.LTJ.aR(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(199328);
                ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "clear record");
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aqe("gh_f0a92aa7146c");
                AppMethodBeat.o(199328);
              }
            });
            a.tQ(9);
            AppMethodBeat.o(199329);
          }
        }, null);
      }
      else if (bt.lQ("contact_info_wxpay_collection_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755906);
        this.mCn = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.mCn.show();
        com.tencent.mm.kernel.g.aiU().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_f0a92aa7146c");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.o(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.aiU().a(paramString, 0);
        com.tencent.mm.kernel.g.ajB().gAO.a(new aa(new aa.a() {}), 0);
        tQ(11);
      }
      else if (bt.lQ("contact_info_wxpay_collection_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(199330);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eS(a.this.contact.field_username);
            ((com.tencent.mm.api.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.l.class)).a(paramAnonymousDialogInterface, (Activity)a.this.context, a.this.contact);
            a.this.cdo();
            a.this.eHi();
            a.b(null);
            a.tQ(10);
            AppMethodBeat.o(199330);
          }
        }, null);
      }
    }
  }
  
  public final boolean cdn()
  {
    return true;
  }
  
  final void cdo()
  {
    AppMethodBeat.i(199338);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aVD("contact_info_header_helper");
    localHelperHeaderPreference.aZ(this.contact.field_username, this.contact.adv(), this.context.getString(2131757906));
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "contact.getUsername():%s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.o.b.lM(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cP("contact_info_wxpay_collection_install", true);
      this.screen.cP("contact_info_wxpay_collection_uninstall", false);
      this.screen.cP("contact_info_wxpay_collection_go_to", false);
      this.screen.cP("contact_info_wxpay_collection_top", false);
      this.screen.cP("contact_info_wxpay_collection_not_disturb", false);
      this.screen.cP("contact_info_wxpay_collection_help", false);
      this.screen.cP("contact_info_wxpay_collection_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTH(this.contact.field_username)) {}
      for (this.DbP.oB = true; this.contact.Pf(); this.DbP.oB = false)
      {
        this.prv.oB = true;
        AppMethodBeat.o(199338);
        return;
      }
      this.prv.oB = false;
      AppMethodBeat.o(199338);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cP("contact_info_wxpay_collection_install", false);
    this.screen.cP("contact_info_wxpay_collection_uninstall", true);
    this.screen.cP("contact_info_wxpay_collection_go_to", true);
    this.screen.cP("contact_info_wxpay_collection_top", true);
    this.screen.cP("contact_info_wxpay_collection_not_disturb", true);
    this.screen.cP("contact_info_wxpay_collection_help", true);
    this.screen.cP("contact_info_wxpay_collection_clear_data", true);
    AppMethodBeat.o(199338);
  }
  
  final void eHi()
  {
    AppMethodBeat.i(199344);
    if ((this.CNd != null) && (this.CNd.size() > 0))
    {
      Iterator localIterator = this.CNd.iterator();
      while (localIterator.hasNext())
      {
        Preference localPreference = (Preference)localIterator.next();
        this.screen.d(localPreference);
      }
      this.screen.notifyDataSetChanged();
      this.CNd.clear();
    }
    AppMethodBeat.o(199344);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(199339);
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      com.tencent.mm.kernel.g.aiU().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString))) {
          Toast.makeText(aj.getContext(), paramString, 1).show();
        }
      }
      for (;;)
      {
        if (this.mCn != null) {
          this.mCn.dismiss();
        }
        cdo();
        AppMethodBeat.o(199339);
        return;
        localObject = ((com.tencent.mm.pluginsdk.model.o)paramn).eZF();
        ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "bind fitness contact %s success", new Object[] { localObject });
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf("gh_f0a92aa7146c");
        if ((paramn != null) && (!bt.isNullOrNil((String)localObject))) {
          break;
        }
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "respUsername == " + (String)localObject + ", contact = " + paramn);
        paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eS(paramn.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.ajC().ajl().set(327825, Boolean.TRUE);
      }
      if (!w.zC(paramn.field_username)) {
        break label720;
      }
      String str = bt.nullAsNil(paramn.field_username);
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eS(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eT(str);
      paramn.sZ(str);
    }
    for (;;)
    {
      paramn.setUsername((String)localObject);
      if ((int)paramn.gfj == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().ah(paramn);
      }
      if ((int)paramn.gfj <= 0)
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "addContact : insert contact failed");
        break;
      }
      w.u(paramn);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramn.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eS(((aw)localObject).field_username);
      if ((paramString == null) || (paramString.Kh()))
      {
        ad.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "shouldUpdate");
        as.a.hFO.aI(((aw)localObject).field_username, "");
        com.tencent.mm.ak.c.CT(((aw)localObject).field_username);
        break;
      }
      if (!((am)localObject).fqk()) {
        break;
      }
      ad.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aw)localObject).ePB) });
      as.a.hFO.aI(((aw)localObject).field_username, "");
      com.tencent.mm.ak.c.CT(((aw)localObject).field_username);
      break;
      if ((paramn instanceof k))
      {
        com.tencent.mm.kernel.g.aiU().b(2860, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (k)paramn;
          if (paramString.COL == null) {}
          for (paramString = new bhj();; paramString = paramString.COL)
          {
            a(paramString);
            b(paramString);
            AppMethodBeat.o(199339);
            return;
          }
        }
        ad.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(199339);
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