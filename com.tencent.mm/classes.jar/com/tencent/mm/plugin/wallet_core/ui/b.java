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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements com.tencent.mm.al.f, a
{
  private CheckBoxPreference DbP;
  am contact;
  Context context;
  private p mCn;
  private CheckBoxPreference prv;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static void tQ(int paramInt)
  {
    AppMethodBeat.i(70644);
    jh localjh = new jh();
    localjh.erT = paramInt;
    localjh.aLk();
    AppMethodBeat.o(70644);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70640);
    this.screen = paramf;
    this.contact = paramam;
    paramf.addPreferencesFromResource(2131951664);
    this.DbP = ((CheckBoxPreference)paramf.aVD("contact_info_wxpay_notify_top"));
    this.prv = ((CheckBoxPreference)paramf.aVD("contact_info_wxpay_notify_not_disturb"));
    cdo();
    com.tencent.mm.kernel.g.aiU().a(1820, this);
    paramf = new com.tencent.mm.plugin.wallet_core.c.i();
    com.tencent.mm.kernel.g.aiU().a(paramf, 0);
    AppMethodBeat.o(70640);
    return true;
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(70641);
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "handleEvent key:%s", new Object[] { paramString });
    if (bt.lQ("contact_info_wxpay_notify_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      d.f(this.context, ".ui.chatting.ChattingUI", paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70641);
      return false;
      if (bt.lQ("contact_info_wxpay_notify_top", paramString))
      {
        if (this.DbP.isChecked())
        {
          w.D(this.contact.field_username, true);
          tQ(3);
        }
        else
        {
          w.E(this.contact.field_username, true);
          tQ(4);
        }
      }
      else if (bt.lQ("contact_info_wxpay_notify_not_disturb", paramString))
      {
        if (this.prv.isChecked())
        {
          w.s(this.contact);
          tQ(5);
        }
        else
        {
          w.t(this.contact);
          tQ(6);
        }
      }
      else if (bt.lQ("contact_info_wxpay_notify_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.e.aW(this.context, "https://kf.qq.com/touch/scene_product.html?scene_id=kf1");
        tQ(7);
      }
      else if (bt.lQ("contact_info_wxpay_notify_clear_data", paramString))
      {
        h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70635);
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aqe("gh_3dfda90e39d6");
            AppMethodBeat.o(70635);
          }
        }, null);
        tQ(8);
      }
      else if (bt.lQ("contact_info_wxpay_notify_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755906);
        this.mCn = h.b(paramString, this.context.getString(2131763362), true, null);
        this.mCn.show();
        com.tencent.mm.kernel.g.aiU().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_3dfda90e39d6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.o(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.aiU().a(paramString, 0);
        tQ(10);
      }
      else if (bt.lQ("contact_info_wxpay_notify_uninstall", paramString))
      {
        h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70636);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eS(b.this.contact.field_username);
            ((com.tencent.mm.api.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.l.class)).a(paramAnonymousDialogInterface, (Activity)b.this.context, b.this.contact);
            b.this.cdo();
            AppMethodBeat.o(70636);
          }
        }, null);
        tQ(9);
      }
    }
  }
  
  public final boolean cdn()
  {
    return true;
  }
  
  final void cdo()
  {
    AppMethodBeat.i(70642);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aVD("contact_info_header_helper");
    localHelperHeaderPreference.aZ(this.contact.field_username, this.contact.adv(), this.context.getString(2131757911));
    if (com.tencent.mm.o.b.lM(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cP("contact_info_wxpay_notify_install", true);
      this.screen.cP("contact_info_wxpay_notify_uninstall", false);
      this.screen.cP("contact_info_wxpay_notify_go_to", false);
      this.screen.cP("contact_info_wxpay_notify_top", false);
      this.screen.cP("contact_info_wxpay_notify_not_disturb", false);
      this.screen.cP("contact_info_wxpay_notify_help", false);
      this.screen.cP("contact_info_wxpay_notify_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTH(this.contact.field_username)) {}
      for (this.DbP.oB = true; this.contact.Pf(); this.DbP.oB = false)
      {
        this.prv.oB = true;
        AppMethodBeat.o(70642);
        return;
      }
      this.prv.oB = false;
      AppMethodBeat.o(70642);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cP("contact_info_wxpay_notify_install", false);
    this.screen.cP("contact_info_wxpay_notify_uninstall", true);
    this.screen.cP("contact_info_wxpay_notify_go_to", true);
    this.screen.cP("contact_info_wxpay_notify_top", true);
    this.screen.cP("contact_info_wxpay_notify_not_disturb", true);
    this.screen.cP("contact_info_wxpay_notify_help", true);
    this.screen.cP("contact_info_wxpay_notify_clear_data", true);
    AppMethodBeat.o(70642);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70643);
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      com.tencent.mm.kernel.g.aiU().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        AppMethodBeat.o(70643);
        return;
        localObject1 = ((com.tencent.mm.pluginsdk.model.o)paramn).eZF();
        ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf("gh_3dfda90e39d6");
        if ((paramn != null) && (!bt.isNullOrNil((String)localObject1))) {
          break;
        }
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramn);
        paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eS(paramn.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.ajC().ajl().set(327825, Boolean.TRUE);
      }
      if (!w.zC(paramn.field_username)) {
        break label1140;
      }
      localObject2 = bt.nullAsNil(paramn.field_username);
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eS((String)localObject2);
      if (paramString != null) {
        paramString.field_username = ((String)localObject1);
      }
      ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eT((String)localObject2);
      paramn.sZ((String)localObject2);
    }
    for (;;)
    {
      paramn.setUsername((String)localObject1);
      if ((int)paramn.gfj == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().ah(paramn);
      }
      if ((int)paramn.gfj <= 0)
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "addContact : insert contact failed");
        break;
      }
      w.u(paramn);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramn.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eS(((aw)localObject1).field_username);
      if ((paramString == null) || (paramString.Kh()))
      {
        ad.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "shouldUpdate");
        as.a.hFO.aI(((aw)localObject1).field_username, "");
        com.tencent.mm.ak.c.CT(((aw)localObject1).field_username);
        break;
      }
      if (!((am)localObject1).fqk()) {
        break;
      }
      ad.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aw)localObject1).ePB) });
      as.a.hFO.aI(((aw)localObject1).field_username, "");
      com.tencent.mm.ak.c.CT(((aw)localObject1).field_username);
      break;
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.i))
      {
        com.tencent.mm.kernel.g.aiU().b(1820, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.i)paramn;
          if (paramString.COI == null) {
            paramString = new cjn();
          }
          while ((paramString != null) && (paramString.GCJ != null) && (paramString.GCJ.GCF != null) && (!paramString.GCJ.GCF.isEmpty()))
          {
            paramInt2 = this.screen.indexOf("contact_info_wxpay_notify_clear_data");
            paramString = paramString.GCJ.GCF.iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                paramn = (bqh)paramString.next();
                if (paramn.GKG.isEmpty())
                {
                  ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "ItemSectionViewData is null");
                  continue;
                  paramString = paramString.COI;
                  break;
                }
                paramInt1 = paramInt2 + 1;
                localObject1 = new PreferenceSmallCategory(this.context);
                this.screen.a((Preference)localObject1, paramInt1);
                paramn = paramn.GKG.iterator();
                for (;;)
                {
                  paramInt2 = paramInt1;
                  if (!paramn.hasNext()) {
                    break;
                  }
                  Object localObject3 = (dlu)paramn.next();
                  if ((((dlu)localObject3).HAk.isEmpty()) || (((dlu)localObject3).HAl.isEmpty()))
                  {
                    ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData data null");
                  }
                  else
                  {
                    localObject1 = (dmo)((dlu)localObject3).HAk.get(0);
                    localObject2 = (dmo)((dlu)localObject3).HAl.get(0);
                    localObject3 = ((dlu)localObject3).FsR;
                    if ((((dmo)localObject1).HAN.isEmpty()) || (bt.isNullOrNil(((dml)((dmo)localObject1).HAN.get(0)).text)) || (localObject3 == null))
                    {
                      ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData inner data null");
                    }
                    else
                    {
                      paramInt1 += 1;
                      b.3 local3 = new b.3(this, this.context);
                      local3.setTitle(((dml)((dmo)localObject1).HAN.get(0)).text);
                      local3.setLayoutResource(2131494804);
                      if ((!((dmo)localObject2).HAN.isEmpty()) && (!bt.isNullOrNil(((dml)((dmo)localObject2).HAN.get(0)).text))) {
                        local3.setSummary(((dml)((dmo)localObject2).HAN.get(0)).text);
                      }
                      this.screen.a(local3, paramInt1);
                      local3.Jtu = new Preference.b()
                      {
                        public final boolean dAh()
                        {
                          AppMethodBeat.i(70639);
                          ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "text(%s) click!", new Object[] { ((dml)this.DbT.HAN.get(0)).text });
                          Bundle localBundle = new Bundle();
                          localBundle.putInt("key_tiny_app_scene", 1000);
                          com.tencent.mm.plugin.wallet_core.utils.g.a(b.this.context, this.DbU, localBundle);
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
          ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin no data");
          AppMethodBeat.o(70643);
          return;
        }
        ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(70643);
      return;
      label1140:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */