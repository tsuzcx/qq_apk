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
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.ckh;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements com.tencent.mm.ak.f, com.tencent.mm.pluginsdk.b.a
{
  private CheckBoxPreference Dtt;
  an contact;
  Context context;
  private p mHs;
  private CheckBoxPreference pyb;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static void tW(int paramInt)
  {
    AppMethodBeat.i(70644);
    jj localjj = new jj();
    localjj.etA = paramInt;
    localjj.aLH();
    AppMethodBeat.o(70644);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70640);
    this.screen = paramf;
    this.contact = paraman;
    paramf.addPreferencesFromResource(2131951664);
    this.Dtt = ((CheckBoxPreference)paramf.aXe("contact_info_wxpay_notify_top"));
    this.pyb = ((CheckBoxPreference)paramf.aXe("contact_info_wxpay_notify_not_disturb"));
    ceD();
    com.tencent.mm.kernel.g.ajj().a(1820, this);
    paramf = new com.tencent.mm.plugin.wallet_core.c.i();
    com.tencent.mm.kernel.g.ajj().a(paramf, 0);
    AppMethodBeat.o(70640);
    return true;
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(70641);
    ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "handleEvent key:%s", new Object[] { paramString });
    if (bu.lX("contact_info_wxpay_notify_go_to", paramString))
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
      if (bu.lX("contact_info_wxpay_notify_top", paramString))
      {
        if (this.Dtt.isChecked())
        {
          x.D(this.contact.field_username, true);
          tW(3);
        }
        else
        {
          x.E(this.contact.field_username, true);
          tW(4);
        }
      }
      else if (bu.lX("contact_info_wxpay_notify_not_disturb", paramString))
      {
        if (this.pyb.isChecked())
        {
          x.z(this.contact);
          tW(5);
        }
        else
        {
          x.A(this.contact);
          tW(6);
        }
      }
      else if (bu.lX("contact_info_wxpay_notify_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.f.aY(this.context, "https://kf.qq.com/touch/scene_product.html?scene_id=kf1");
        tW(7);
      }
      else if (bu.lX("contact_info_wxpay_notify_clear_data", paramString))
      {
        h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70635);
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arj("gh_3dfda90e39d6");
            AppMethodBeat.o(70635);
          }
        }, null);
        tW(8);
      }
      else if (bu.lX("contact_info_wxpay_notify_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755906);
        this.mHs = h.b(paramString, this.context.getString(2131763362), true, null);
        this.mHs.show();
        com.tencent.mm.kernel.g.ajj().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_3dfda90e39d6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.o(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.ajj().a(paramString, 0);
        tW(10);
      }
      else if (bu.lX("contact_info_wxpay_notify_uninstall", paramString))
      {
        h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70636);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eX(b.this.contact.field_username);
            ((com.tencent.mm.api.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.l.class)).a(paramAnonymousDialogInterface, (Activity)b.this.context, b.this.contact);
            b.this.ceD();
            AppMethodBeat.o(70636);
          }
        }, null);
        tW(9);
      }
    }
  }
  
  public final boolean ceC()
  {
    return true;
  }
  
  final void ceD()
  {
    AppMethodBeat.i(70642);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    localHelperHeaderPreference.ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757911));
    if (com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.cT("contact_info_wxpay_notify_install", true);
      this.screen.cT("contact_info_wxpay_notify_uninstall", false);
      this.screen.cT("contact_info_wxpay_notify_go_to", false);
      this.screen.cT("contact_info_wxpay_notify_top", false);
      this.screen.cT("contact_info_wxpay_notify_not_disturb", false);
      this.screen.cT("contact_info_wxpay_notify_help", false);
      this.screen.cT("contact_info_wxpay_notify_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVi(this.contact.field_username)) {
        this.Dtt.setChecked(true);
      }
      while (this.contact.Pd())
      {
        this.pyb.setChecked(true);
        AppMethodBeat.o(70642);
        return;
        this.Dtt.setChecked(false);
      }
      this.pyb.setChecked(false);
      AppMethodBeat.o(70642);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.cT("contact_info_wxpay_notify_install", false);
    this.screen.cT("contact_info_wxpay_notify_uninstall", true);
    this.screen.cT("contact_info_wxpay_notify_go_to", true);
    this.screen.cT("contact_info_wxpay_notify_top", true);
    this.screen.cT("contact_info_wxpay_notify_not_disturb", true);
    this.screen.cT("contact_info_wxpay_notify_help", true);
    this.screen.cT("contact_info_wxpay_notify_clear_data", true);
    AppMethodBeat.o(70642);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70643);
    ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      com.tencent.mm.kernel.g.ajj().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        AppMethodBeat.o(70643);
        return;
        localObject1 = ((com.tencent.mm.pluginsdk.model.o)paramn).fdt();
        ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH("gh_3dfda90e39d6");
        if ((paramn != null) && (!bu.isNullOrNil((String)localObject1))) {
          break;
        }
        ae.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramn);
        paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eX(paramn.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.ajR().ajA().set(327825, Boolean.TRUE);
      }
      if (!x.Am(paramn.field_username)) {
        break label1140;
      }
      localObject2 = bu.nullAsNil(paramn.field_username);
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eX((String)localObject2);
      if (paramString != null) {
        paramString.field_username = ((String)localObject1);
      }
      ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eY((String)localObject2);
      paramn.tu((String)localObject2);
    }
    for (;;)
    {
      paramn.setUsername((String)localObject1);
      if ((int)paramn.ght == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().ao(paramn);
      }
      if ((int)paramn.ght <= 0)
      {
        ae.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "addContact : insert contact failed");
        break;
      }
      x.B(paramn);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramn.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.o.class)).eX(((aw)localObject1).field_username);
      if ((paramString == null) || (paramString.Kp()))
      {
        ae.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "shouldUpdate");
        au.a.hIG.aJ(((aw)localObject1).field_username, "");
        com.tencent.mm.aj.c.Dv(((aw)localObject1).field_username);
        break;
      }
      if (!((an)localObject1).fuk()) {
        break;
      }
      ae.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aw)localObject1).eRm) });
      au.a.hIG.aJ(((aw)localObject1).field_username, "");
      com.tencent.mm.aj.c.Dv(((aw)localObject1).field_username);
      break;
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.i))
      {
        com.tencent.mm.kernel.g.ajj().b(1820, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.i)paramn;
          if (paramString.Dgn == null) {
            paramString = new ckh();
          }
          while ((paramString != null) && (paramString.GWk != null) && (paramString.GWk.GWf != null) && (!paramString.GWk.GWf.isEmpty()))
          {
            paramInt2 = this.screen.indexOf("contact_info_wxpay_notify_clear_data");
            paramString = paramString.GWk.GWf.iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                paramn = (brb)paramString.next();
                if (paramn.Heh.isEmpty())
                {
                  ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "ItemSectionViewData is null");
                  continue;
                  paramString = paramString.Dgn;
                  break;
                }
                paramInt1 = paramInt2 + 1;
                localObject1 = new PreferenceSmallCategory(this.context);
                this.screen.a((Preference)localObject1, paramInt1);
                paramn = paramn.Heh.iterator();
                for (;;)
                {
                  paramInt2 = paramInt1;
                  if (!paramn.hasNext()) {
                    break;
                  }
                  Object localObject3 = (dmr)paramn.next();
                  if ((((dmr)localObject3).HTX.isEmpty()) || (((dmr)localObject3).HTY.isEmpty()))
                  {
                    ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData data null");
                  }
                  else
                  {
                    localObject1 = (dnl)((dmr)localObject3).HTX.get(0);
                    localObject2 = (dnl)((dmr)localObject3).HTY.get(0);
                    localObject3 = ((dmr)localObject3).FLp;
                    if ((((dnl)localObject1).HUA.isEmpty()) || (bu.isNullOrNil(((dni)((dnl)localObject1).HUA.get(0)).text)) || (localObject3 == null))
                    {
                      ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData inner data null");
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
                          if (this.JOj != null) {
                            paramAnonymousView.setOnClickListener(new View.OnClickListener()
                            {
                              public final void onClick(View paramAnonymous2View)
                              {
                                AppMethodBeat.i(70637);
                                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                                localb.bd(paramAnonymous2View);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayNotify$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                                b.3.this.JOj.dDy();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayNotify$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(70637);
                              }
                            });
                          }
                          AppMethodBeat.o(70638);
                        }
                      };
                      local3.setTitle(((dni)((dnl)localObject1).HUA.get(0)).text);
                      local3.setLayoutResource(2131494804);
                      if ((!((dnl)localObject2).HUA.isEmpty()) && (!bu.isNullOrNil(((dni)((dnl)localObject2).HUA.get(0)).text))) {
                        local3.setSummary(((dni)((dnl)localObject2).HUA.get(0)).text);
                      }
                      this.screen.a(local3, paramInt1);
                      local3.JOj = new Preference.b()
                      {
                        public final boolean dDy()
                        {
                          AppMethodBeat.i(70639);
                          ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "text(%s) click!", new Object[] { ((dni)this.Dtx.HUA.get(0)).text });
                          Bundle localBundle = new Bundle();
                          localBundle.putInt("key_tiny_app_scene", 1000);
                          com.tencent.mm.plugin.wallet_core.utils.g.a(b.this.context, this.Dty, localBundle);
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
          ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin no data");
          AppMethodBeat.o(70643);
          return;
        }
        ae.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin fail!");
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