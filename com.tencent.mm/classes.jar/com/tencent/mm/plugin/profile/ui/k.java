package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.m;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.List;

public final class k
  implements a
{
  private CheckBoxPreference BfA;
  private k.a BfB = null;
  private CheckBoxPreference Bfz;
  final Context mContext;
  private f nRm;
  as rjX = null;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(231872);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onAttach");
    this.nRm = paramf;
    this.rjX = paramas;
    paramf.addPreferencesFromResource(2132017184);
    this.Bfz = ((CheckBoxPreference)paramf.bmg("contact_info_mini_shop_helper_top"));
    this.BfA = ((CheckBoxPreference)paramf.bmg("contact_info_mini_shop_helper_not_disturb"));
    eEy();
    AppMethodBeat.o(231872);
    return true;
  }
  
  public final boolean alD(String paramString)
  {
    int j = 2;
    AppMethodBeat.i(231874);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "handleEvent, key: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(231874);
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
        AppMethodBeat.o(231874);
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
    paramString.putExtra("Chat_User", this.rjX.field_username);
    paramString.putExtra("finish_direct", true);
    com.tencent.mm.br.c.f(this.mContext, ".ui.chatting.ChattingUI", paramString);
    eEz().er(1, 1);
    AppMethodBeat.o(231874);
    return true;
    paramString = (r)com.tencent.mm.kernel.g.af(r.class);
    if (paramString == null) {
      Log.w("MicroMsg.ContactWidgetMiniShopHelper", "gotoMyMiniShop, weAppLauncher is null");
    }
    for (;;)
    {
      AppMethodBeat.o(231874);
      return true;
      localObject = new com.tencent.mm.plugin.appbrand.api.g();
      ((com.tencent.mm.plugin.appbrand.api.g)localObject).appId = "wx4aedf8c9edf9fd72";
      ((com.tencent.mm.plugin.appbrand.api.g)localObject).kHw = "/common/pages/index/index.html";
      ((com.tencent.mm.plugin.appbrand.api.g)localObject).scene = 1165;
      paramString.a(this.mContext, (com.tencent.mm.plugin.appbrand.api.g)localObject);
      eEz().er(2, 1);
    }
    boolean bool = this.Bfz.isChecked();
    paramString = eEz();
    if (bool)
    {
      i = 2;
      paramString.er(3, i);
      if (!bool) {
        break label474;
      }
      ab.E(this.rjX.field_username, true);
    }
    for (;;)
    {
      AppMethodBeat.o(231874);
      return true;
      i = 3;
      break;
      label474:
      ab.F(this.rjX.field_username, true);
    }
    bool = this.BfA.isChecked();
    paramString = eEz();
    if (bool)
    {
      i = j;
      paramString.er(4, i);
      if (!bool) {
        break label539;
      }
      ab.z(this.rjX);
    }
    for (;;)
    {
      AppMethodBeat.o(231874);
      return true;
      i = 3;
      break;
      label539:
      ab.A(this.rjX);
    }
    paramString = new Intent();
    paramString.putExtra("rawUrl", ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.soz, "https://developers.weixin.qq.com/community/minihome/article/doc/000000208c8018662cda04cf35b813"));
    paramString.putExtra("showShare", true);
    paramString.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.c.b(this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramString);
    eEz().er(5, 1);
    AppMethodBeat.o(231874);
    return true;
    com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(2131757858), "", this.mContext.getString(2131755764), this.mContext.getString(2131755761), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(231867);
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231866);
            k.this.eEz().er(6, 1);
            ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEE("gh_579db1f2cf89");
            AppMethodBeat.o(231866);
          }
        });
        AppMethodBeat.o(231867);
      }
    }, null);
    AppMethodBeat.o(231874);
    return true;
    paramString = this.mContext;
    this.mContext.getString(2131755998);
    paramString = com.tencent.mm.ui.base.h.a(paramString, this.mContext.getString(2131765544), true, null);
    paramString.show();
    com.tencent.mm.kernel.g.azz().a(30, new k.2(this, paramString));
    paramString = new ArrayList();
    paramString.add("gh_579db1f2cf89");
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(1));
    com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.pluginsdk.model.p(paramString, (List)localObject, "", ""), 0);
    AppMethodBeat.o(231874);
    return true;
    com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(2131765548), "", this.mContext.getString(2131755764), this.mContext.getString(2131755761), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(231869);
        paramAnonymousDialogInterface = ((com.tencent.mm.api.p)com.tencent.mm.kernel.g.af(com.tencent.mm.api.p.class)).fJ(k.this.rjX.field_username);
        ((m)com.tencent.mm.kernel.g.af(m.class)).a(paramAnonymousDialogInterface, (Activity)k.this.mContext, k.this.rjX);
        k.this.eEy();
        AppMethodBeat.o(231869);
      }
    }, null);
    AppMethodBeat.o(231874);
    return true;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(231873);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onDetach");
    AppMethodBeat.o(231873);
    return true;
  }
  
  final void eEy()
  {
    AppMethodBeat.i(231875);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.nRm.bmg("contact_info_mini_shop_helper_header_helper");
    localHelperHeaderPreference.bk(this.rjX.field_username, this.rjX.arI(), this.mContext.getString(2131757965));
    if (com.tencent.mm.contact.c.oR(this.rjX.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.nRm.jdMethod_do("contact_info_mini_shop_helper_install", true);
      this.nRm.jdMethod_do("contact_info_mini_shop_helper_uninstall", false);
      this.nRm.jdMethod_do("contact_info_mini_shop_helper_go_to", false);
      this.nRm.jdMethod_do("contact_info_mini_shop_helper_my", false);
      this.nRm.jdMethod_do("contact_info_mini_shop_helper_top", false);
      this.nRm.jdMethod_do("contact_info_mini_shop_helper_not_disturb", false);
      this.nRm.jdMethod_do("contact_info_mini_shop_helper_help", false);
      this.nRm.jdMethod_do("contact_info_mini_shop_helper_clear_data", false);
      boolean bool = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bkg(this.rjX.field_username);
      this.Bfz.setChecked(bool);
      this.BfA.setChecked(this.rjX.Zx());
      AppMethodBeat.o(231875);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.nRm.jdMethod_do("contact_info_mini_shop_helper_install", false);
    this.nRm.jdMethod_do("contact_info_mini_shop_helper_uninstall", true);
    this.nRm.jdMethod_do("contact_info_mini_shop_helper_go_to", true);
    this.nRm.jdMethod_do("contact_info_mini_shop_helper_my", true);
    this.nRm.jdMethod_do("contact_info_mini_shop_helper_top", true);
    this.nRm.jdMethod_do("contact_info_mini_shop_helper_not_disturb", true);
    this.nRm.jdMethod_do("contact_info_mini_shop_helper_help", true);
    this.nRm.jdMethod_do("contact_info_mini_shop_helper_clear_data", true);
    AppMethodBeat.o(231875);
  }
  
  final k.a eEz()
  {
    AppMethodBeat.i(231876);
    if (this.BfB == null) {
      this.BfB = new k.a((byte)0);
    }
    k.a locala = this.BfB;
    AppMethodBeat.o(231876);
    return locala;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */