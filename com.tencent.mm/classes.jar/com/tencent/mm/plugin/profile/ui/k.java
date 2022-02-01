package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.api.m;
import com.tencent.mm.api.p;
import com.tencent.mm.by.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.List;

public final class k
  implements a
{
  private CheckBoxPreference GZx;
  private CheckBoxPreference GZy;
  private k.a GZz = null;
  final Context mContext;
  private f mrf;
  as uNk = null;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(198947);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onAttach");
    this.mrf = paramf;
    this.uNk = paramas;
    paramf.auC(R.o.eXq);
    this.GZx = ((CheckBoxPreference)paramf.byG("contact_info_mini_shop_helper_top"));
    this.GZy = ((CheckBoxPreference)paramf.byG("contact_info_mini_shop_helper_not_disturb"));
    fqq();
    AppMethodBeat.o(198947);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    int j = 2;
    AppMethodBeat.i(198954);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "handleEvent, key: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(198954);
      return false;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(198954);
        return false;
        if (paramString.equals("contact_info_mini_shop_helper_go_to"))
        {
          i = 0;
          continue;
          if (paramString.equals("contact_info_mini_shop_helper_my"))
          {
            i = 1;
            continue;
            if (paramString.equals("contact_info_mini_shop_helper_top"))
            {
              i = 2;
              continue;
              if (paramString.equals("contact_info_mini_shop_helper_not_disturb"))
              {
                i = 3;
                continue;
                if (paramString.equals("contact_info_mini_shop_helper_help"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("contact_info_mini_shop_helper_clear_data"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("contact_info_mini_shop_helper_install"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("contact_info_mini_shop_helper_uninstall")) {
                        i = 7;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramString = new Intent();
    paramString.putExtra("Chat_User", this.uNk.field_username);
    paramString.putExtra("finish_direct", true);
    c.f(this.mContext, ".ui.chatting.ChattingUI", paramString);
    fqr().eP(1, 1);
    AppMethodBeat.o(198954);
    return true;
    paramString = (r)com.tencent.mm.kernel.h.ae(r.class);
    if (paramString == null) {
      Log.w("MicroMsg.ContactWidgetMiniShopHelper", "gotoMyMiniShop, weAppLauncher is null");
    }
    for (;;)
    {
      AppMethodBeat.o(198954);
      return true;
      localObject = new g();
      ((g)localObject).appId = "wx4aedf8c9edf9fd72";
      ((g)localObject).nBq = "/common/pages/index/index.html";
      ((g)localObject).scene = 1165;
      paramString.a(this.mContext, (g)localObject);
      fqr().eP(2, 1);
    }
    boolean bool = this.GZx.isChecked();
    paramString = fqr();
    if (bool)
    {
      i = 2;
      paramString.eP(3, i);
      if (!bool) {
        break label474;
      }
      ab.G(this.uNk.field_username, true);
    }
    for (;;)
    {
      AppMethodBeat.o(198954);
      return true;
      i = 3;
      break;
      label474:
      ab.H(this.uNk.field_username, true);
    }
    bool = this.GZy.isChecked();
    paramString = fqr();
    if (bool)
    {
      i = j;
      paramString.eP(4, i);
      if (!bool) {
        break label539;
      }
      ab.F(this.uNk);
    }
    for (;;)
    {
      AppMethodBeat.o(198954);
      return true;
      i = 3;
      break;
      label539:
      ab.G(this.uNk);
    }
    paramString = new Intent();
    paramString.putExtra("rawUrl", ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vZZ, "https://developers.weixin.qq.com/community/minihome/article/doc/000000208c8018662cda04cf35b813"));
    paramString.putExtra("showShare", true);
    paramString.putExtra("allow_mix_content_mode", false);
    c.b(this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramString);
    fqr().eP(5, 1);
    AppMethodBeat.o(198954);
    return true;
    com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(R.l.contact_info_clear_data), "", this.mContext.getString(R.l.app_clear), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(269427);
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(282888);
            k.this.fqr().eP(6, 1);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOO("gh_579db1f2cf89");
            AppMethodBeat.o(282888);
          }
        });
        AppMethodBeat.o(269427);
      }
    }, null);
    AppMethodBeat.o(198954);
    return true;
    paramString = this.mContext;
    this.mContext.getString(R.l.app_tip);
    paramString = com.tencent.mm.ui.base.h.a(paramString, this.mContext.getString(R.l.settings_plugins_installing), true, null);
    paramString.show();
    com.tencent.mm.kernel.h.aGY().a(30, new k.2(this, paramString));
    paramString = new ArrayList();
    paramString.add("gh_579db1f2cf89");
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(1));
    com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.pluginsdk.model.t(paramString, (List)localObject, "", ""), 0);
    AppMethodBeat.o(198954);
    return true;
    com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(R.l.settings_plugins_uninstall_hint), "", this.mContext.getString(R.l.app_clear), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(212454);
        paramAnonymousDialogInterface = ((p)com.tencent.mm.kernel.h.ae(p.class)).gu(k.this.uNk.field_username);
        ((m)com.tencent.mm.kernel.h.ae(m.class)).a(paramAnonymousDialogInterface, (Activity)k.this.mContext, k.this.uNk);
        k.this.fqq();
        AppMethodBeat.o(212454);
      }
    }, null);
    AppMethodBeat.o(198954);
    return true;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(198949);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onDetach");
    AppMethodBeat.o(198949);
    return true;
  }
  
  final void fqq()
  {
    AppMethodBeat.i(198958);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.mrf.byG("contact_info_mini_shop_helper_header_helper");
    localHelperHeaderPreference.bf(this.uNk.field_username, this.uNk.ayr(), this.mContext.getString(R.l.eyH));
    if (d.rk(this.uNk.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.mrf.dz("contact_info_mini_shop_helper_install", true);
      this.mrf.dz("contact_info_mini_shop_helper_uninstall", false);
      this.mrf.dz("contact_info_mini_shop_helper_go_to", false);
      this.mrf.dz("contact_info_mini_shop_helper_my", false);
      this.mrf.dz("contact_info_mini_shop_helper_top", false);
      this.mrf.dz("contact_info_mini_shop_helper_not_disturb", false);
      this.mrf.dz("contact_info_mini_shop_helper_help", false);
      this.mrf.dz("contact_info_mini_shop_helper_clear_data", false);
      boolean bool = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF(this.uNk.field_username);
      this.GZx.setChecked(bool);
      this.GZy.setChecked(this.uNk.aeg());
      AppMethodBeat.o(198958);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.mrf.dz("contact_info_mini_shop_helper_install", false);
    this.mrf.dz("contact_info_mini_shop_helper_uninstall", true);
    this.mrf.dz("contact_info_mini_shop_helper_go_to", true);
    this.mrf.dz("contact_info_mini_shop_helper_my", true);
    this.mrf.dz("contact_info_mini_shop_helper_top", true);
    this.mrf.dz("contact_info_mini_shop_helper_not_disturb", true);
    this.mrf.dz("contact_info_mini_shop_helper_help", true);
    this.mrf.dz("contact_info_mini_shop_helper_clear_data", true);
    AppMethodBeat.o(198958);
  }
  
  final k.a fqr()
  {
    AppMethodBeat.i(198962);
    if (this.GZz == null) {
      this.GZz = new k.a((byte)0);
    }
    k.a locala = this.GZz;
    AppMethodBeat.o(198962);
    return locala;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */