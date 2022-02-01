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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.aa;
import com.tencent.mm.api.q;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.protocal.protobuf.fml;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.am.h, com.tencent.mm.pluginsdk.c.a
{
  private CheckBoxPreference VLf;
  private List<Preference> VrM;
  private au contact;
  private Context context;
  private w rYw;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference xvc;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(301227);
    this.VrM = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(301227);
  }
  
  private static void BI(int paramInt)
  {
    AppMethodBeat.i(301232);
    tw localtw = new tw();
    localtw.jvV = paramInt;
    localtw.bMH();
    AppMethodBeat.o(301232);
  }
  
  private void a(cqw paramcqw)
  {
    AppMethodBeat.i(301236);
    if (!com.tencent.mm.contact.d.rs(this.contact.field_type))
    {
      iks();
      AppMethodBeat.o(301236);
      return;
    }
    iks();
    if ((paramcqw != null) && (paramcqw.aaxA != null) && (paramcqw.aaxA.aaxw != null) && (!paramcqw.aaxA.aaxw.isEmpty()))
    {
      int i = this.screen.cs("contact_info_wxpay_collection_go_to");
      paramcqw = paramcqw.aaxA.aaxw.iterator();
      while (paramcqw.hasNext())
      {
        Object localObject1 = (ddc)paramcqw.next();
        if (((ddc)localObject1).aaIH.isEmpty())
        {
          Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "ItemSectionViewData is null");
        }
        else
        {
          i += 1;
          Object localObject2 = new PreferenceSmallCategory(this.context);
          this.screen.a((Preference)localObject2, i);
          this.VrM.add(localObject2);
          localObject1 = ((ddc)localObject1).aaIH.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (fll)((Iterator)localObject1).next();
            if ((((fll)localObject3).abLS.isEmpty()) || (((fll)localObject3).abLT.isEmpty()))
            {
              Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData data null");
            }
            else
            {
              localObject2 = (fmp)((fll)localObject3).abLS.get(0);
              fmp localfmp = (fmp)((fll)localObject3).abLT.get(0);
              localObject3 = ((fll)localObject3).YCV;
              if ((((fmp)localObject2).abMT.isEmpty()) || (Util.isNullOrNil(((fml)((fmp)localObject2).abMT.get(0)).text)) || (localObject3 == null))
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
                    AppMethodBeat.i(301307);
                    super.onBindView(paramAnonymousView);
                    if (this.adZO != null) {
                      paramAnonymousView.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous2View)
                        {
                          AppMethodBeat.i(301299);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.cH(paramAnonymous2View);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                          b.3.this.adZO.gAW();
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(301299);
                        }
                      });
                    }
                    AppMethodBeat.o(301307);
                  }
                };
                local3.setTitle(((fml)((fmp)localObject2).abMT.get(0)).text);
                local3.setLayoutResource(a.g.mm_preference);
                if ((!localfmp.abMT.isEmpty()) && (!Util.isNullOrNil(((fml)localfmp.abMT.get(0)).text))) {
                  local3.aS(((fml)localfmp.abMT.get(0)).text);
                }
                this.screen.a(local3, i);
                this.VrM.add(local3);
                local3.adZO = new Preference.b()
                {
                  public final boolean gAW()
                  {
                    AppMethodBeat.i(301312);
                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "text(%s) click!", new Object[] { ((fml)this.VLk.abMT.get(0)).text });
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("key_tiny_app_scene", 1165);
                    com.tencent.mm.plugin.wallet_core.utils.n.a(b.b(b.this), this.VLl, localBundle);
                    com.tencent.mm.plugin.report.service.h.OAn.b(19541, new Object[] { Integer.valueOf(1), ((fml)this.VLk.abMT.get(0)).text });
                    AppMethodBeat.o(301312);
                    return true;
                  }
                };
              }
            }
          }
        }
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(301236);
      return;
    }
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin no data");
    AppMethodBeat.o(301236);
  }
  
  private static void b(cqw paramcqw)
  {
    AppMethodBeat.i(301237);
    if ((paramcqw != null) && (paramcqw.aaxA != null) && (paramcqw.aaxA.aaxw != null) && (!paramcqw.aaxA.aaxw.isEmpty())) {}
    for (;;)
    {
      try
      {
        paramcqw = new String(paramcqw.toByteArray(), "ISO-8859-1");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adfU, paramcqw);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().iZy();
        AppMethodBeat.o(301237);
        return;
      }
      catch (IOException paramcqw)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "save config exp, " + paramcqw.getLocalizedMessage());
      }
      paramcqw = " ";
    }
  }
  
  private void dvr()
  {
    AppMethodBeat.i(301229);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    localHelperHeaderPreference.bz(this.contact.field_username, this.contact.aSV(), this.context.getString(a.i.contact_info_wxpay_collection_switch_tip));
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "contact.getUsername():%s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.contact.d.rs(this.contact.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.screen.eh("contact_info_wxpay_collection_install", true);
      this.screen.eh("contact_info_wxpay_collection_uninstall", false);
      this.screen.eh("contact_info_wxpay_collection_go_to", false);
      this.screen.eh("contact_info_wxpay_collection_top", false);
      this.screen.eh("contact_info_wxpay_collection_not_disturb", false);
      this.screen.eh("contact_info_wxpay_collection_help", false);
      this.screen.eh("contact_info_wxpay_collection_clear_data", false);
      if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxV(this.contact.field_username)) {
        this.VLf.setChecked(true);
      }
      while (this.contact.aGe())
      {
        this.xvc.setChecked(true);
        AppMethodBeat.o(301229);
        return;
        this.VLf.setChecked(false);
      }
      this.xvc.setChecked(false);
      AppMethodBeat.o(301229);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.screen.eh("contact_info_wxpay_collection_install", false);
    this.screen.eh("contact_info_wxpay_collection_uninstall", true);
    this.screen.eh("contact_info_wxpay_collection_go_to", true);
    this.screen.eh("contact_info_wxpay_collection_top", true);
    this.screen.eh("contact_info_wxpay_collection_not_disturb", true);
    this.screen.eh("contact_info_wxpay_collection_help", true);
    this.screen.eh("contact_info_wxpay_collection_clear_data", true);
    AppMethodBeat.o(301229);
  }
  
  private static cqw ikr()
  {
    AppMethodBeat.i(301240);
    cqw localcqw = new cqw();
    com.tencent.mm.kernel.h.baF();
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adfU, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "etReceiptAssisPluginResponse failed");
    }
    for (;;)
    {
      AppMethodBeat.o(301240);
      return localcqw;
      try
      {
        localcqw.parseFrom(str.getBytes("ISO-8859-1"));
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.WxPay.ContactWidgetWxPayCollection", "parseConfig exp, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private void iks()
  {
    AppMethodBeat.i(301244);
    if ((this.VrM != null) && (this.VrM.size() > 0))
    {
      Iterator localIterator = this.VrM.iterator();
      while (localIterator.hasNext())
      {
        Preference localPreference = (Preference)localIterator.next();
        this.screen.e(localPreference);
      }
      this.screen.notifyDataSetChanged();
      this.VrM.clear();
    }
    AppMethodBeat.o(301244);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(301258);
    this.screen = paramf;
    this.contact = paramau;
    paramf.aBe(a.m.contact_info_pref_wxpay_collection);
    this.VLf = ((CheckBoxPreference)paramf.bAi("contact_info_wxpay_collection_top"));
    this.xvc = ((CheckBoxPreference)paramf.bAi("contact_info_wxpay_collection_not_disturb"));
    dvr();
    a(ikr());
    com.tencent.mm.kernel.h.aZW().a(2860, this);
    paramf = new l();
    com.tencent.mm.kernel.h.aZW().a(paramf, 0);
    AppMethodBeat.o(301258);
    return true;
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(301261);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "handleEvent key:%s", new Object[] { paramString });
    if (Util.isEqual("contact_info_wxpay_collection_go_to", paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.br.c.g(this.context, ".ui.chatting.ChattingUI", paramString);
      BI(3);
    }
    for (;;)
    {
      AppMethodBeat.o(301261);
      return false;
      if (Util.isEqual("contact_info_wxpay_collection_top", paramString))
      {
        if (this.VLf.isChecked())
        {
          ab.K(this.contact.field_username, true);
          BI(4);
        }
        else
        {
          ab.L(this.contact.field_username, true);
          BI(5);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_collection_not_disturb", paramString))
      {
        if (this.xvc.isChecked())
        {
          ab.G(this.contact);
          BI(6);
        }
        else
        {
          ab.H(this.contact);
          BI(7);
        }
      }
      else if (Util.isEqual("contact_info_wxpay_collection_help", paramString))
      {
        com.tencent.mm.wallet_core.ui.i.y("gh_106decc2eec5@app", "/pages/product/productInfo/product.html?code=A4075&producttitle=收款小账本&scene_id=kf5662", 0, 1165);
        BI(8);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_clear_data", paramString))
      {
        k.b(this.context, this.context.getString(a.i.contact_info_clear_data), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(301309);
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(301298);
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "clear record");
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLO("gh_f0a92aa7146c");
                AppMethodBeat.o(301298);
              }
            });
            b.asr(9);
            AppMethodBeat.o(301309);
          }
        }, null);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_install", paramString))
      {
        paramString = this.context;
        this.context.getString(a.i.app_tip);
        this.rYw = k.a(paramString, this.context.getString(a.i.settings_plugins_installing), true, null);
        this.rYw.show();
        com.tencent.mm.kernel.h.aZW().a(30, this);
        paramString = new LinkedList();
        paramString.add("gh_f0a92aa7146c");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramString = new v(paramString, localLinkedList, "", "");
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        com.tencent.mm.kernel.h.baD().mCm.a(new aa(new b.5(this)), 0);
        BI(11);
      }
      else if (Util.isEqual("contact_info_wxpay_collection_uninstall", paramString))
      {
        k.b(this.context, this.context.getString(a.i.settings_plugins_uninstall_hint), "", this.context.getString(a.i.app_clear), this.context.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(301306);
            paramAnonymousDialogInterface = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(b.a(b.this).field_username);
            ((com.tencent.mm.api.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.n.class)).a(paramAnonymousDialogInterface, (Activity)b.b(b.this), b.a(b.this));
            b.c(b.this);
            b.d(b.this);
            b.ikt();
            b.asr(10);
            AppMethodBeat.o(301306);
          }
        }, null);
      }
    }
  }
  
  public final boolean dvq()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(301267);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    Object localObject;
    if ((paramp instanceof v))
    {
      com.tencent.mm.kernel.h.aZW().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
      }
      for (;;)
      {
        if (this.rYw != null) {
          this.rYw.dismiss();
        }
        dvr();
        AppMethodBeat.o(301267);
        return;
        localObject = ((v)paramp).iIc();
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "bind fitness contact %s success", new Object[] { localObject });
        paramp = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_f0a92aa7146c");
        if ((paramp != null) && (!Util.isNullOrNil((String)localObject))) {
          break;
        }
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "respUsername == " + (String)localObject + ", contact = " + paramp);
        paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(paramp.field_username);
        if (paramString != null) {
          ((q)com.tencent.mm.kernel.h.ax(q.class)).a(paramString);
        }
        com.tencent.mm.kernel.h.baE().ban().B(327825, Boolean.TRUE);
      }
      if (!au.bxa(paramp.field_username)) {
        break label720;
      }
      String str = Util.nullAsNil(paramp.field_username);
      paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(str);
      if (paramString != null) {
        paramString.field_username = ((String)localObject);
      }
      ((q)com.tencent.mm.kernel.h.ax(q.class)).hV(str);
      paramp.Bd(str);
    }
    for (;;)
    {
      paramp.setUsername((String)localObject);
      if ((int)paramp.maN == 0) {
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC(paramp);
      }
      if ((int)paramp.maN <= 0)
      {
        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "addContact : insert contact failed");
        break;
      }
      ab.I(paramp);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramp.field_username);
      if (paramString != null)
      {
        ((q)com.tencent.mm.kernel.h.ax(q.class)).b(paramString);
        break;
      }
      paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(((az)localObject).field_username);
      if ((paramString == null) || (paramString.aAJ()))
      {
        Log.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "shouldUpdate");
        az.a.okP.aZ(((az)localObject).field_username, "");
        com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
        break;
      }
      if (!((au)localObject).iZI()) {
        break;
      }
      Log.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "update contact, last check time=%d", new Object[] { Integer.valueOf(((az)localObject).kak) });
      az.a.okP.aZ(((az)localObject).field_username, "");
      com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
      break;
      if ((paramp instanceof l))
      {
        com.tencent.mm.kernel.h.aZW().b(2860, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (l)paramp;
          if (paramString.VxF == null) {}
          for (paramString = new cqw();; paramString = paramString.VxF)
          {
            a(paramString);
            b(paramString);
            AppMethodBeat.o(301267);
            return;
          }
        }
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin fail!");
      }
      AppMethodBeat.o(301267);
      return;
      label720:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */