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
import com.tencent.mm.api.l;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.c.i;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements com.tencent.mm.ak.g, a
{
  private CheckBoxPreference BBx;
  com.tencent.mm.storage.ai contact;
  Context context;
  private p mcf;
  private CheckBoxPreference oNN;
  private f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static void tn(int paramInt)
  {
    AppMethodBeat.i(70644);
    id localid = new id();
    localid.ebn = paramInt;
    localid.aHZ();
    AppMethodBeat.o(70644);
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(70641);
    ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "handleEvent key:%s", new Object[] { paramString });
    if (bs.lr("contact_info_wxpay_notify_go_to", paramString))
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
      if (bs.lr("contact_info_wxpay_notify_top", paramString))
      {
        if (this.BBx.isChecked())
        {
          w.D(this.contact.field_username, true);
          tn(3);
        }
        else
        {
          w.E(this.contact.field_username, true);
          tn(4);
        }
      }
      else if (bs.lr("contact_info_wxpay_notify_not_disturb", paramString))
      {
        if (this.oNN.isChecked())
        {
          w.s(this.contact);
          tn(5);
        }
        else
        {
          w.t(this.contact);
          tn(6);
        }
      }
      else if (bs.lr("contact_info_wxpay_notify_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.e.aT(this.context, "https://kf.qq.com/touch/scene_product.html?scene_id=kf1");
        tn(7);
      }
      else if (bs.lr("contact_info_wxpay_notify_clear_data", paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70635);
            ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alq("gh_3dfda90e39d6");
            AppMethodBeat.o(70635);
          }
        }, null);
        tn(8);
      }
      else if (bs.lr("contact_info_wxpay_notify_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755906);
        this.mcf = com.tencent.mm.ui.base.h.b(paramString, this.context.getString(2131763362), true, null);
        this.mcf.show();
        com.tencent.mm.kernel.g.agi().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_3dfda90e39d6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.o(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
        tn(10);
      }
      else if (bs.lr("contact_info_wxpay_notify_uninstall", paramString))
      {
        com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70636);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dX(b.this.contact.field_username);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).a(paramAnonymousDialogInterface, (Activity)b.this.context, b.this.contact);
            b.this.bYK();
            AppMethodBeat.o(70636);
          }
        }, null);
        tn(9);
      }
    }
  }
  
  public final boolean a(f paramf, com.tencent.mm.storage.ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70640);
    this.screen = paramf;
    this.contact = paramai;
    paramf.addPreferencesFromResource(2131951664);
    this.BBx = ((CheckBoxPreference)paramf.aPN("contact_info_wxpay_notify_top"));
    this.oNN = ((CheckBoxPreference)paramf.aPN("contact_info_wxpay_notify_not_disturb"));
    bYK();
    com.tencent.mm.kernel.g.agi().a(1820, this);
    paramf = new i();
    com.tencent.mm.kernel.g.agi().a(paramf, 0);
    AppMethodBeat.o(70640);
    return true;
  }
  
  public final boolean bYJ()
  {
    return true;
  }
  
  final void bYK()
  {
    AppMethodBeat.i(70642);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    localHelperHeaderPreference.aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757911));
    if (com.tencent.mm.n.b.ln(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cK("contact_info_wxpay_notify_install", true);
      this.screen.cK("contact_info_wxpay_notify_uninstall", false);
      this.screen.cK("contact_info_wxpay_notify_go_to", false);
      this.screen.cK("contact_info_wxpay_notify_top", false);
      this.screen.cK("contact_info_wxpay_notify_not_disturb", false);
      this.screen.cK("contact_info_wxpay_notify_help", false);
      this.screen.cK("contact_info_wxpay_notify_clear_data", false);
      if (((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNQ(this.contact.field_username)) {}
      for (this.BBx.mF = true; this.contact.Nw(); this.BBx.mF = false)
      {
        this.oNN.mF = true;
        AppMethodBeat.o(70642);
        return;
      }
      this.oNN.mF = false;
      AppMethodBeat.o(70642);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cK("contact_info_wxpay_notify_install", false);
    this.screen.cK("contact_info_wxpay_notify_uninstall", true);
    this.screen.cK("contact_info_wxpay_notify_go_to", true);
    this.screen.cK("contact_info_wxpay_notify_top", true);
    this.screen.cK("contact_info_wxpay_notify_not_disturb", true);
    this.screen.cK("contact_info_wxpay_notify_help", true);
    this.screen.cK("contact_info_wxpay_notify_clear_data", true);
    AppMethodBeat.o(70642);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70643);
    ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      com.tencent.mm.kernel.g.agi().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        AppMethodBeat.o(70643);
        return;
        localObject1 = ((com.tencent.mm.pluginsdk.model.o)paramn).eKL();
        ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramn = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt("gh_3dfda90e39d6");
        if ((paramn != null) && (!bs.isNullOrNil((String)localObject1))) {
          break;
        }
        ac.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramn);
        paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dX(paramn.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.agR().agA().set(327825, Boolean.TRUE);
      }
      if (!w.wF(paramn.field_username)) {
        break label1140;
      }
      localObject2 = bs.nullAsNil(paramn.field_username);
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dX((String)localObject2);
      if (paramString != null) {
        paramString.field_username = ((String)localObject1);
      }
      ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dY((String)localObject2);
      paramn.qp((String)localObject2);
    }
    for (;;)
    {
      paramn.setUsername((String)localObject1);
      if ((int)paramn.fLJ == 0) {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().ah(paramn);
      }
      if ((int)paramn.fLJ <= 0)
      {
        ac.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "addContact : insert contact failed");
        break;
      }
      w.u(paramn);
      localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramn.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).dX(((av)localObject1).field_username);
      if ((paramString == null) || (paramString.IH()))
      {
        ac.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "shouldUpdate");
        ar.a.hnw.aJ(((av)localObject1).field_username, "");
        com.tencent.mm.aj.c.zU(((av)localObject1).field_username);
        break;
      }
      if (!((com.tencent.mm.storage.ai)localObject1).fah()) {
        break;
      }
      ac.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((av)localObject1).eyc) });
      ar.a.hnw.aJ(((av)localObject1).field_username, "");
      com.tencent.mm.aj.c.zU(((av)localObject1).field_username);
      break;
      if ((paramn instanceof i))
      {
        com.tencent.mm.kernel.g.agi().b(1820, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (i)paramn;
          if (paramString.Bot == null) {
            paramString = new ceo();
          }
          while ((paramString != null) && (paramString.ETq != null) && (paramString.ETq.ETm != null) && (!paramString.ETq.ETm.isEmpty()))
          {
            paramInt2 = this.screen.indexOf("contact_info_wxpay_notify_clear_data");
            paramString = paramString.ETq.ETm.iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                paramn = (blx)paramString.next();
                if (paramn.Fbh.isEmpty())
                {
                  ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "ItemSectionViewData is null");
                  continue;
                  paramString = paramString.Bot;
                  break;
                }
                paramInt1 = paramInt2 + 1;
                localObject1 = new PreferenceSmallCategory(this.context);
                this.screen.a((Preference)localObject1, paramInt1);
                paramn = paramn.Fbh.iterator();
                for (;;)
                {
                  paramInt2 = paramInt1;
                  if (!paramn.hasNext()) {
                    break;
                  }
                  Object localObject3 = (dgh)paramn.next();
                  if ((((dgh)localObject3).FPF.isEmpty()) || (((dgh)localObject3).FPG.isEmpty()))
                  {
                    ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData data null");
                  }
                  else
                  {
                    localObject1 = (dhb)((dgh)localObject3).FPF.get(0);
                    localObject2 = (dhb)((dgh)localObject3).FPG.get(0);
                    localObject3 = ((dgh)localObject3).DNL;
                    if ((((dhb)localObject1).FQj.isEmpty()) || (bs.isNullOrNil(((dgy)((dhb)localObject1).FQj.get(0)).text)) || (localObject3 == null))
                    {
                      ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData inner data null");
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
                          if (this.HFD != null) {
                            paramAnonymousView.setOnClickListener(new View.OnClickListener()
                            {
                              public final void onClick(View paramAnonymous2View)
                              {
                                AppMethodBeat.i(70637);
                                b.3.this.HFD.dpE();
                                AppMethodBeat.o(70637);
                              }
                            });
                          }
                          AppMethodBeat.o(70638);
                        }
                      };
                      local3.setTitle(((dgy)((dhb)localObject1).FQj.get(0)).text);
                      local3.setLayoutResource(2131494804);
                      if ((!((dhb)localObject2).FQj.isEmpty()) && (!bs.isNullOrNil(((dgy)((dhb)localObject2).FQj.get(0)).text))) {
                        local3.setSummary(((dgy)((dhb)localObject2).FQj.get(0)).text);
                      }
                      this.screen.a(local3, paramInt1);
                      local3.HFD = new Preference.b()
                      {
                        public final boolean dpE()
                        {
                          AppMethodBeat.i(70639);
                          ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "text(%s) click!", new Object[] { ((dgy)this.BBB.FQj.get(0)).text });
                          Bundle localBundle = new Bundle();
                          localBundle.putInt("key_tiny_app_scene", 1000);
                          com.tencent.mm.plugin.wallet_core.utils.g.a(b.this.context, this.BBC, localBundle);
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
          ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin no data");
          AppMethodBeat.o(70643);
          return;
        }
        ac.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin fail!");
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