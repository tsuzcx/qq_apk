package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.api.q;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.List;

public final class l
  implements a
{
  private CheckBoxPreference MXA;
  private CheckBoxPreference MXB;
  private l.a MXC = null;
  final Context mContext;
  private com.tencent.mm.ui.base.preference.f pkD;
  au xVS = null;
  
  public l(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(305578);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onAttach");
    this.pkD = paramf;
    this.xVS = paramau;
    paramf.aBe(R.o.haS);
    this.MXA = ((CheckBoxPreference)paramf.bAi("contact_info_mini_shop_helper_top"));
    this.MXB = ((CheckBoxPreference)paramf.bAi("contact_info_mini_shop_helper_not_disturb"));
    gBG();
    AppMethodBeat.o(305578);
    return true;
  }
  
  public final boolean anl(final String paramString)
  {
    int j = 2;
    AppMethodBeat.i(305585);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "handleEvent, key: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(305585);
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
        AppMethodBeat.o(305585);
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
    paramString.putExtra("Chat_User", this.xVS.field_username);
    paramString.putExtra("finish_direct", true);
    com.tencent.mm.br.c.g(this.mContext, ".ui.chatting.ChattingUI", paramString);
    gBH().fI(1, 1);
    AppMethodBeat.o(305585);
    return true;
    paramString = (t)com.tencent.mm.kernel.h.ax(t.class);
    if (paramString == null) {
      Log.w("MicroMsg.ContactWidgetMiniShopHelper", "gotoMyMiniShop, weAppLauncher is null");
    }
    for (;;)
    {
      AppMethodBeat.o(305585);
      return true;
      localObject = new g();
      ((g)localObject).appId = "wx4aedf8c9edf9fd72";
      ((g)localObject).qAF = "/common/pages/index/index.html";
      ((g)localObject).scene = 1165;
      paramString.a(this.mContext, (g)localObject);
      gBH().fI(2, 1);
    }
    boolean bool = this.MXA.isChecked();
    paramString = gBH();
    if (bool)
    {
      i = 2;
      paramString.fI(3, i);
      if (!bool) {
        break label474;
      }
      ab.K(this.xVS.field_username, true);
    }
    for (;;)
    {
      AppMethodBeat.o(305585);
      return true;
      i = 3;
      break;
      label474:
      ab.L(this.xVS.field_username, true);
    }
    bool = this.MXB.isChecked();
    paramString = gBH();
    if (bool)
    {
      i = j;
      paramString.fI(4, i);
      if (!bool) {
        break label539;
      }
      ab.G(this.xVS);
    }
    for (;;)
    {
      AppMethodBeat.o(305585);
      return true;
      i = 3;
      break;
      label539:
      ab.H(this.xVS);
    }
    paramString = new Intent();
    paramString.putExtra("rawUrl", ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztB, "https://developers.weixin.qq.com/community/minihome/article/doc/000000208c8018662cda04cf35b813"));
    paramString.putExtra("showShare", true);
    paramString.putExtra("allow_mix_content_mode", false);
    com.tencent.mm.br.c.b(this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramString);
    gBH().fI(5, 1);
    AppMethodBeat.o(305585);
    return true;
    k.b(this.mContext, this.mContext.getString(R.l.contact_info_clear_data), "", this.mContext.getString(R.l.app_clear), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(305554);
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(305687);
            l.this.gBH().fI(6, 1);
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLO("gh_579db1f2cf89");
            AppMethodBeat.o(305687);
          }
        });
        AppMethodBeat.o(305554);
      }
    }, null);
    AppMethodBeat.o(305585);
    return true;
    paramString = this.mContext;
    this.mContext.getString(R.l.app_tip);
    paramString = k.a(paramString, this.mContext.getString(R.l.settings_plugins_installing), true, null);
    paramString.show();
    com.tencent.mm.kernel.h.aZW().a(30, new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(305557);
        Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, errType: %d, errCode: %d, errMsg: %s, scene: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousp.getType()) });
        if ((paramAnonymousp instanceof v))
        {
          com.tencent.mm.kernel.h.aZW().b(30, this);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            break label126;
          }
          Log.w("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, fail");
          if ((4 == paramAnonymousInt1) && (-24 == paramAnonymousInt2) && (!Util.isNullOrNil(paramAnonymousString))) {
            Toast.makeText(MMApplicationContext.getContext(), paramAnonymousString, 1).show();
          }
        }
        label126:
        Object localObject;
        for (;;)
        {
          paramString.dismiss();
          l.this.gBG();
          AppMethodBeat.o(305557);
          return;
          localObject = ((v)paramAnonymousp).iIc();
          Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, respUsername: ".concat(String.valueOf(localObject)));
          paramAnonymousp = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_579db1f2cf89");
          if ((paramAnonymousp != null) && (!Util.isNullOrNil((String)localObject))) {
            break;
          }
          Log.e("MicroMsg.ContactWidgetMiniShopHelper", "updateContact, contact: %s, respUsername: %s", new Object[] { paramAnonymousp, localObject });
          paramAnonymousString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(paramAnonymousp.field_username);
          if (paramAnonymousString != null) {
            ((q)com.tencent.mm.kernel.h.ax(q.class)).a(paramAnonymousString);
          }
          com.tencent.mm.kernel.h.baE().ban().B(327825, Boolean.TRUE);
        }
        if (au.bxa(paramAnonymousp.field_username))
        {
          String str = Util.nullAsNil(paramAnonymousp.field_username);
          paramAnonymousString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(str);
          if (paramAnonymousString == null) {
            paramAnonymousString.field_username = ((String)localObject);
          }
          ((q)com.tencent.mm.kernel.h.ax(q.class)).hV(str);
          paramAnonymousp.Bd(str);
        }
        for (;;)
        {
          paramAnonymousp.setUsername((String)localObject);
          if ((int)paramAnonymousp.maN == 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC(paramAnonymousp);
          }
          if ((int)paramAnonymousp.maN <= 0)
          {
            Log.e("MicroMsg.ContactWidgetMiniShopHelper", "updateContact, insert contact fail");
            break;
          }
          ab.I(paramAnonymousp);
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramAnonymousp.field_username);
          if (paramAnonymousString != null)
          {
            ((q)com.tencent.mm.kernel.h.ax(q.class)).b(paramAnonymousString);
            break;
          }
          paramAnonymousString = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(((az)localObject).field_username);
          if ((paramAnonymousString == null) || (paramAnonymousString.aAJ()))
          {
            Log.i("MicroMsg.ContactWidgetMiniShopHelper", "updateBizInfoInNeed, shouldUpdate");
            az.a.okP.aZ(((az)localObject).field_username, "");
            com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
            break;
          }
          if (!((au)localObject).iZI()) {
            break;
          }
          Log.i("MicroMsg.ContactWidgetMiniShopHelper", "updateBizInfoInNeed, last check time:" + ((az)localObject).kak);
          az.a.okP.aZ(((az)localObject).field_username, "");
          com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
          break;
          paramAnonymousString = null;
        }
      }
    });
    paramString = new ArrayList();
    paramString.add("gh_579db1f2cf89");
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(1));
    com.tencent.mm.kernel.h.aZW().a(new v(paramString, (List)localObject, "", ""), 0);
    AppMethodBeat.o(305585);
    return true;
    k.b(this.mContext, this.mContext.getString(R.l.settings_plugins_uninstall_hint), "", this.mContext.getString(R.l.app_clear), this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(305551);
        paramAnonymousDialogInterface = ((q)com.tencent.mm.kernel.h.ax(q.class)).hU(l.this.xVS.field_username);
        ((com.tencent.mm.api.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.n.class)).a(paramAnonymousDialogInterface, (Activity)l.this.mContext, l.this.xVS);
        l.this.gBG();
        AppMethodBeat.o(305551);
      }
    }, null);
    AppMethodBeat.o(305585);
    return true;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(305581);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onDetach");
    AppMethodBeat.o(305581);
    return true;
  }
  
  final void gBG()
  {
    AppMethodBeat.i(305590);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.pkD.bAi("contact_info_mini_shop_helper_header_helper");
    localHelperHeaderPreference.bz(this.xVS.field_username, this.xVS.aSU(), this.mContext.getString(R.l.gBz));
    if (com.tencent.mm.contact.d.rs(this.xVS.field_type))
    {
      localHelperHeaderPreference.updateStatus(1);
      this.pkD.eh("contact_info_mini_shop_helper_install", true);
      this.pkD.eh("contact_info_mini_shop_helper_uninstall", false);
      this.pkD.eh("contact_info_mini_shop_helper_go_to", false);
      this.pkD.eh("contact_info_mini_shop_helper_my", false);
      this.pkD.eh("contact_info_mini_shop_helper_top", false);
      this.pkD.eh("contact_info_mini_shop_helper_not_disturb", false);
      this.pkD.eh("contact_info_mini_shop_helper_help", false);
      this.pkD.eh("contact_info_mini_shop_helper_clear_data", false);
      boolean bool = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxV(this.xVS.field_username);
      this.MXA.setChecked(bool);
      this.MXB.setChecked(this.xVS.aGe());
      AppMethodBeat.o(305590);
      return;
    }
    localHelperHeaderPreference.updateStatus(0);
    this.pkD.eh("contact_info_mini_shop_helper_install", false);
    this.pkD.eh("contact_info_mini_shop_helper_uninstall", true);
    this.pkD.eh("contact_info_mini_shop_helper_go_to", true);
    this.pkD.eh("contact_info_mini_shop_helper_my", true);
    this.pkD.eh("contact_info_mini_shop_helper_top", true);
    this.pkD.eh("contact_info_mini_shop_helper_not_disturb", true);
    this.pkD.eh("contact_info_mini_shop_helper_help", true);
    this.pkD.eh("contact_info_mini_shop_helper_clear_data", true);
    AppMethodBeat.o(305590);
  }
  
  final l.a gBH()
  {
    AppMethodBeat.i(305596);
    if (this.MXC == null) {
      this.MXC = new l.a((byte)0);
    }
    l.a locala = this.MXC;
    AppMethodBeat.o(305596);
    return locala;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l
 * JD-Core Version:    0.7.0.1
 */