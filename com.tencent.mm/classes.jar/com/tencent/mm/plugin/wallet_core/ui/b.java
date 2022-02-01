package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.m;
import com.tencent.mm.g.b.a.nf;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements com.tencent.mm.ak.i, a
{
  private static final String IcK;
  private CheckBoxPreference IcE;
  private as contact;
  private Context context;
  private com.tencent.mm.ui.base.q nUq;
  private CheckBoxPreference qNs;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(214237);
    IcK = "https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_product.html?scene_id=kf1";
    AppMethodBeat.o(214237);
  }
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cCt()
  {
    AppMethodBeat.i(70642);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    localHelperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758151));
    if (com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.jdMethod_do("contact_info_wxpay_notify_install", true);
      this.screen.jdMethod_do("contact_info_wxpay_notify_uninstall", false);
      this.screen.jdMethod_do("contact_info_wxpay_notify_go_to", false);
      this.screen.jdMethod_do("contact_info_wxpay_notify_top", false);
      this.screen.jdMethod_do("contact_info_wxpay_notify_not_disturb", false);
      this.screen.jdMethod_do("contact_info_wxpay_notify_help", false);
      this.screen.jdMethod_do("contact_info_wxpay_notify_clear_data", false);
      if (((l)com.tencent.mm.kernel.g.af(l.class)).aST().bkg(this.contact.field_username)) {
        this.IcE.setChecked(true);
      }
      while (this.contact.Zx())
      {
        this.qNs.setChecked(true);
        AppMethodBeat.o(70642);
        return;
        this.IcE.setChecked(false);
      }
      this.qNs.setChecked(false);
      AppMethodBeat.o(70642);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.jdMethod_do("contact_info_wxpay_notify_install", false);
    this.screen.jdMethod_do("contact_info_wxpay_notify_uninstall", true);
    this.screen.jdMethod_do("contact_info_wxpay_notify_go_to", true);
    this.screen.jdMethod_do("contact_info_wxpay_notify_top", true);
    this.screen.jdMethod_do("contact_info_wxpay_notify_not_disturb", true);
    this.screen.jdMethod_do("contact_info_wxpay_notify_help", true);
    this.screen.jdMethod_do("contact_info_wxpay_notify_clear_data", true);
    AppMethodBeat.o(70642);
  }
  
  private static void xV(int paramInt)
  {
    AppMethodBeat.i(70644);
    nf localnf = new nf();
    localnf.eXG = paramInt;
    localnf.bfK();
    AppMethodBeat.o(70644);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(70640);
    this.screen = paramf;
    this.contact = paramas;
    paramf.addPreferencesFromResource(2132017202);
    this.IcE = ((CheckBoxPreference)paramf.bmg("contact_info_wxpay_notify_top"));
    this.qNs = ((CheckBoxPreference)paramf.bmg("contact_info_wxpay_notify_not_disturb"));
    cCt();
    com.tencent.mm.kernel.g.azz().a(1820, this);
    paramf = new com.tencent.mm.plugin.wallet_core.c.i();
    com.tencent.mm.kernel.g.azz().a(paramf, 0);
    AppMethodBeat.o(70640);
    return true;
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(70641);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_notify_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.br.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70641);
      return false;
      if (Util.isEqual("contact_info_wxpay_notify_top", paramString))
      {
        if (this.IcE.isChecked())
        {
          ab.E(this.contact.field_username, true);
          xV(3);
        }
        else
        {
          ab.F(this.contact.field_username, true);
          xV(4);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_notify_not_disturb", paramString))
      {
        if (this.qNs.isChecked())
        {
          ab.z(this.contact);
          xV(5);
        }
        else
        {
          ab.A(this.contact);
          xV(6);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_notify_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.f.bn(this.context, IcK);
        xV(7);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_clear_data", paramString))
      {
        h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new b.1(this), null);
        xV(8);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_install", paramString))
      {
        paramString = this.context;
        this.context.getString(2131755998);
        this.nUq = h.a(paramString, this.context.getString(2131765544), true, null);
        this.nUq.show();
        com.tencent.mm.kernel.g.azz().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_3dfda90e39d6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new com.tencent.mm.pluginsdk.model.p(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.g.azz().a(paramString, 0);
        xV(10);
      }
      else if (Util.isEqual("contact_info_wxpay_notify_uninstall", paramString))
      {
        h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70636);
            paramAnonymousDialogInterface = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ(b.a(b.this).field_username);
            ((m)com.tencent.mm.kernel.g.af(m.class)).a(paramAnonymousDialogInterface, (Activity)b.b(b.this), b.a(b.this));
            b.c(b.this);
            AppMethodBeat.o(70636);
          }
        }, null);
        xV(9);
      }
    }
  }
  
  public final boolean cCs()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(70643);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.p))
    {
      com.tencent.mm.kernel.g.azz().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
        AppMethodBeat.o(70643);
        return;
        localObject1 = ((com.tencent.mm.pluginsdk.model.p)paramq).gmD();
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "bind fitness contact %s success", new Object[] { localObject1 });
        paramq = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_3dfda90e39d6");
        if ((paramq != null) && (!Util.isNullOrNil((String)localObject1))) {
          break;
        }
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "respUsername == " + (String)localObject1 + ", contact = " + paramq);
        paramString = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ(paramq.field_username);
        if (paramString != null) {
          ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).a(paramString);
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(327825, Boolean.TRUE);
      }
      if (!ab.IR(paramq.field_username)) {
        break label1140;
      }
      localObject2 = Util.nullAsNil(paramq.field_username);
      paramString = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ((String)localObject2);
      if (paramString != null) {
        paramString.field_username = ((String)localObject1);
      }
      ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fK((String)localObject2);
      paramq.BK((String)localObject2);
    }
    for (;;)
    {
      paramq.setUsername((String)localObject1);
      if ((int)paramq.gMZ == 0) {
        ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().aq(paramq);
      }
      if ((int)paramq.gMZ <= 0)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "addContact : insert contact failed");
        break;
      }
      ab.B(paramq);
      localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramq.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ(((ax)localObject1).field_username);
      if ((paramString == null) || (paramString.Uz()))
      {
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "shouldUpdate");
        ay.a.iDq.aL(((ax)localObject1).field_username, "");
        com.tencent.mm.aj.c.Mf(((ax)localObject1).field_username);
        break;
      }
      if (!((as)localObject1).gBQ()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject1).fuP) });
      ay.a.iDq.aL(((ax)localObject1).field_username, "");
      com.tencent.mm.aj.c.Mf(((ax)localObject1).field_username);
      break;
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.i))
      {
        com.tencent.mm.kernel.g.azz().b(1820, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.i)paramq;
          if (paramString.HPG == null) {
            paramString = new dap();
          }
          while ((paramString != null) && (paramString.MaF != null) && (paramString.MaF.MaA != null) && (!paramString.MaF.MaA.isEmpty()))
          {
            paramInt2 = this.screen.indexOf("contact_info_wxpay_notify_clear_data");
            paramString = paramString.MaF.MaA.iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                paramq = (cdv)paramString.next();
                if (paramq.Mjq.isEmpty())
                {
                  Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "ItemSectionViewData is null");
                  continue;
                  paramString = paramString.HPG;
                  break;
                }
                paramInt1 = paramInt2 + 1;
                localObject1 = new PreferenceSmallCategory(this.context);
                this.screen.a((Preference)localObject1, paramInt1);
                paramq = paramq.Mjq.iterator();
                for (;;)
                {
                  paramInt2 = paramInt1;
                  if (!paramq.hasNext()) {
                    break;
                  }
                  Object localObject3 = (egf)paramq.next();
                  if ((((egf)localObject3).Ngf.isEmpty()) || (((egf)localObject3).Ngg.isEmpty()))
                  {
                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData data null");
                  }
                  else
                  {
                    localObject1 = (ehf)((egf)localObject3).Ngf.get(0);
                    localObject2 = (ehf)((egf)localObject3).Ngg.get(0);
                    localObject3 = ((egf)localObject3).KEP;
                    if ((((ehf)localObject1).NgT.isEmpty()) || (Util.isNullOrNil(((ehc)((ehf)localObject1).NgT.get(0)).text)) || (localObject3 == null))
                    {
                      Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData inner data null");
                    }
                    else
                    {
                      paramInt1 += 1;
                      b.3 local3 = new b.3(this, this.context);
                      local3.setTitle(((ehc)((ehf)localObject1).NgT.get(0)).text);
                      local3.setLayoutResource(2131495538);
                      if ((!((ehf)localObject2).NgT.isEmpty()) && (!Util.isNullOrNil(((ehc)((ehf)localObject2).NgT.get(0)).text))) {
                        local3.setSummary(((ehc)((ehf)localObject2).NgT.get(0)).text);
                      }
                      this.screen.a(local3, paramInt1);
                      local3.OZp = new Preference.b()
                      {
                        public final boolean a(Preference paramAnonymousPreference)
                        {
                          AppMethodBeat.i(214235);
                          Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "text(%s) click!", new Object[] { ((ehc)this.IcI.NgT.get(0)).text });
                          paramAnonymousPreference = new Bundle();
                          paramAnonymousPreference.putInt("key_tiny_app_scene", 1000);
                          com.tencent.mm.plugin.wallet_core.utils.g.a(b.b(b.this), this.IcJ, paramAnonymousPreference);
                          AppMethodBeat.o(214235);
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
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin no data");
          AppMethodBeat.o(70643);
          return;
        }
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(70643);
      return;
      label1140:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */