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
import com.tencent.mm.api.l;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.c.i;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements com.tencent.mm.al.g, a
{
  private CheckBoxPreference Ajc;
  af contact;
  Context context;
  private p lAj;
  private CheckBoxPreference okn;
  private f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static void sw(int paramInt)
  {
    AppMethodBeat.i(70644);
    gl localgl = new gl();
    localgl.dZv = paramInt;
    localgl.aBj();
    AppMethodBeat.o(70644);
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(70641);
    ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "handleEvent key:%s", new Object[] { paramString });
    if (bt.kU("contact_info_wxpay_notify_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      d.e(this.context, ".ui.chatting.ChattingUI", paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70641);
      return false;
      if (bt.kU("contact_info_wxpay_notify_top", paramString))
      {
        if (this.Ajc.isChecked())
        {
          w.C(this.contact.field_username, true);
          sw(3);
        }
        else
        {
          w.D(this.contact.field_username, true);
          sw(4);
        }
      }
      else if (bt.kU("contact_info_wxpay_notify_not_disturb", paramString))
      {
        if (this.okn.isChecked())
        {
          w.s(this.contact);
          sw(5);
        }
        else
        {
          w.t(this.contact);
          sw(6);
        }
      }
      else if (bt.kU("contact_info_wxpay_notify_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.e.aS(this.context, "https://kf.qq.com/touch/scene_product.html?scene_id=kf1");
        sw(7);
      }
      else if (bt.kU("contact_info_wxpay_notify_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70635);
            ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().agw("gh_3dfda90e39d6");
            AppMethodBeat.o(70635);
          }
        }, null);
        sw(8);
      }
      else if (bt.kU("contact_info_wxpay_notify_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755906);
        this.lAj = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.lAj.show();
        com.tencent.mm.kernel.g.aeS().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_3dfda90e39d6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.o(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
        sw(10);
      }
      else if (bt.kU("contact_info_wxpay_notify_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70636);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ei(b.this.contact.field_username);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).a(paramAnonymousDialogInterface, (Activity)b.this.context, b.this.contact);
            b.this.bRv();
            AppMethodBeat.o(70636);
          }
        }, null);
        sw(9);
      }
    }
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70640);
    this.screen = paramf;
    this.contact = paramaf;
    paramf.addPreferencesFromResource(2131951664);
    this.Ajc = ((CheckBoxPreference)paramf.aKk("contact_info_wxpay_notify_top"));
    this.okn = ((CheckBoxPreference)paramf.aKk("contact_info_wxpay_notify_not_disturb"));
    bRv();
    com.tencent.mm.kernel.g.aeS().a(1820, this);
    paramf = new i();
    com.tencent.mm.kernel.g.aeS().a(paramf, 0);
    AppMethodBeat.o(70640);
    return true;
  }
  
  public final boolean bRu()
  {
    return true;
  }
  
  final void bRv()
  {
    AppMethodBeat.i(70642);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aKk("contact_info_header_helper");
    localHelperHeaderPreference.aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757911));
    if (com.tencent.mm.n.b.ls(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cE("contact_info_wxpay_notify_install", true);
      this.screen.cE("contact_info_wxpay_notify_uninstall", false);
      this.screen.cE("contact_info_wxpay_notify_go_to", false);
      this.screen.cE("contact_info_wxpay_notify_top", false);
      this.screen.cE("contact_info_wxpay_notify_not_disturb", false);
      this.screen.cE("contact_info_wxpay_notify_help", false);
      this.screen.cE("contact_info_wxpay_notify_clear_data", false);
      if (((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIv(this.contact.field_username)) {}
      for (this.Ajc.lG = true; this.contact.Ny(); this.Ajc.lG = false)
      {
        this.okn.lG = true;
        AppMethodBeat.o(70642);
        return;
      }
      this.okn.lG = false;
      AppMethodBeat.o(70642);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cE("contact_info_wxpay_notify_install", false);
    this.screen.cE("contact_info_wxpay_notify_uninstall", true);
    this.screen.cE("contact_info_wxpay_notify_go_to", true);
    this.screen.cE("contact_info_wxpay_notify_top", true);
    this.screen.cE("contact_info_wxpay_notify_not_disturb", true);
    this.screen.cE("contact_info_wxpay_notify_help", true);
    this.screen.cE("contact_info_wxpay_notify_clear_data", true);
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
      com.tencent.mm.kernel.g.aeS().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        AppMethodBeat.o(70643);
        return;
        localObject1 = ((com.tencent.mm.pluginsdk.model.o)paramn).evr();
        ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramn = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY("gh_3dfda90e39d6");
        if ((paramn != null) && (!bt.isNullOrNil((String)localObject1))) {
          break;
        }
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramn);
        paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ei(paramn.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.afB().afk().set(327825, Boolean.TRUE);
      }
      if (!w.sC(paramn.field_username)) {
        break label1140;
      }
      localObject2 = bt.nullAsNil(paramn.field_username);
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ei((String)localObject2);
      if (paramString != null) {
        paramString.field_username = ((String)localObject1);
      }
      ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ej((String)localObject2);
      paramn.nj((String)localObject2);
    }
    for (;;)
    {
      paramn.setUsername((String)localObject1);
      if ((int)paramn.fId == 0) {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().ag(paramn);
      }
      if ((int)paramn.fId <= 0)
      {
        ad.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "addContact : insert contact failed");
        break;
      }
      w.u(paramn);
      localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramn.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).ei(((au)localObject1).field_username);
      if ((paramString == null) || (paramString.IY()))
      {
        ad.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "shouldUpdate");
        ar.a.gMW.aB(((au)localObject1).field_username, "");
        com.tencent.mm.ak.c.vO(((au)localObject1).field_username);
        break;
      }
      if (!((af)localObject1).eKF()) {
        break;
      }
      ad.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((au)localObject1).evG) });
      ar.a.gMW.aB(((au)localObject1).field_username, "");
      com.tencent.mm.ak.c.vO(((au)localObject1).field_username);
      break;
      if ((paramn instanceof i))
      {
        com.tencent.mm.kernel.g.aeS().b(1820, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (i)paramn;
          if (paramString.zVZ == null) {
            paramString = new bzq();
          }
          while ((paramString != null) && (paramString.DxU != null) && (paramString.DxU.DxQ != null) && (!paramString.DxU.DxQ.isEmpty()))
          {
            paramInt2 = this.screen.indexOf("contact_info_wxpay_notify_clear_data");
            paramString = paramString.DxU.DxQ.iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                paramn = (bif)paramString.next();
                if (paramn.DFN.isEmpty())
                {
                  ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "ItemSectionViewData is null");
                  continue;
                  paramString = paramString.zVZ;
                  break;
                }
                paramInt1 = paramInt2 + 1;
                localObject1 = new PreferenceSmallCategory(this.context);
                this.screen.a((Preference)localObject1, paramInt1);
                paramn = paramn.DFN.iterator();
                for (;;)
                {
                  paramInt2 = paramInt1;
                  if (!paramn.hasNext()) {
                    break;
                  }
                  Object localObject3 = (dav)paramn.next();
                  if ((((dav)localObject3).EsD.isEmpty()) || (((dav)localObject3).EsE.isEmpty()))
                  {
                    ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData data null");
                  }
                  else
                  {
                    localObject1 = (dbp)((dav)localObject3).EsD.get(0);
                    localObject2 = (dbp)((dav)localObject3).EsE.get(0);
                    localObject3 = ((dav)localObject3).Cvq;
                    if ((((dbp)localObject1).Eth.isEmpty()) || (bt.isNullOrNil(((dbm)((dbp)localObject1).Eth.get(0)).text)) || (localObject3 == null))
                    {
                      ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData inner data null");
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
                          if (this.GfO != null) {
                            paramAnonymousView.setOnClickListener(new View.OnClickListener()
                            {
                              public final void onClick(View paramAnonymous2View)
                              {
                                AppMethodBeat.i(70637);
                                b.3.this.GfO.dbW();
                                AppMethodBeat.o(70637);
                              }
                            });
                          }
                          AppMethodBeat.o(70638);
                        }
                      };
                      local3.setTitle(((dbm)((dbp)localObject1).Eth.get(0)).text);
                      local3.setLayoutResource(2131494804);
                      if ((!((dbp)localObject2).Eth.isEmpty()) && (!bt.isNullOrNil(((dbm)((dbp)localObject2).Eth.get(0)).text))) {
                        local3.setSummary(((dbm)((dbp)localObject2).Eth.get(0)).text);
                      }
                      this.screen.a(local3, paramInt1);
                      local3.GfO = new Preference.b()
                      {
                        public final boolean dbW()
                        {
                          AppMethodBeat.i(70639);
                          ad.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "text(%s) click!", new Object[] { ((dbm)this.Ajf.Eth.get(0)).text });
                          Bundle localBundle = new Bundle();
                          localBundle.putInt("key_tiny_app_scene", 1000);
                          com.tencent.mm.plugin.wallet_core.utils.g.a(b.this.context, this.Ajg, localBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */