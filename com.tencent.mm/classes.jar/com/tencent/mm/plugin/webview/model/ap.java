package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ap
  extends com.tencent.mm.plugin.af.a
{
  public static String rgV = "";
  
  public final int getType()
  {
    return 2;
  }
  
  public final void j(Context paramContext, Intent paramIntent)
  {
    String str1 = com.tencent.mm.plugin.base.model.c.decrypt(t.j(paramIntent, "id"));
    String str2 = com.tencent.mm.plugin.base.model.c.decrypt(t.j(paramIntent, "ext_info"));
    Object localObject1 = t.j(paramIntent, "token");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      y.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
      return;
    }
    Object localObject2 = new StringBuilder();
    au.Hx();
    if (!((String)localObject1).equals(com.tencent.mm.plugin.base.model.d.cm(str2, com.tencent.mm.model.c.CK())))
    {
      localObject2 = ae.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (localObject2 == null)
      {
        y.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
        return;
      }
      localObject3 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if ((localObject3 == null) || (((Set)localObject3).isEmpty()))
      {
        y.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
        return;
      }
      localObject2 = new HashSet();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Set)localObject2).add(com.tencent.mm.plugin.base.model.c.cm(str2, (String)((Iterator)localObject3).next()));
      }
      if (!((Set)localObject2).contains(localObject1))
      {
        y.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[] { localObject1 });
        Toast.makeText(paramContext, paramContext.getString(R.l.wv_launch_shortcut_fail), 1).show();
        return;
      }
    }
    paramIntent.putExtra("type", 0);
    paramIntent.putExtra("id", "");
    localObject2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + str2;
    localObject1 = localObject2;
    if (!bk.bl(rgV)) {
      localObject1 = (String)localObject2 + "&" + rgV;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    ((Intent)localObject2).putExtra("from_shortcut", true);
    ((Intent)localObject2).putExtra("game_hv_menu_appid", str2);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.game.H5GameWebViewUI", (Intent)localObject2);
    z.MK().kC(str1);
    localObject1 = t.j(paramIntent, "digest");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      y.i("MicroMsg.WebViewShortcutEntry", "digest is null");
      return;
    }
    au.Hx();
    localObject2 = com.tencent.mm.model.c.Fw().abl(str1);
    if ((localObject2 == null) || (bk.bl(((ad)localObject2).Bp())))
    {
      y.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
      return;
    }
    localObject2 = ((ad)localObject2).Bp();
    Object localObject3 = o.Kh().kp(str1);
    if ((localObject3 == null) || (bk.bl(((h)localObject3).JY())))
    {
      y.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
      return;
    }
    if (((String)localObject1).equals(g.o(((String)localObject2 + ((h)localObject3).JY()).getBytes())))
    {
      y.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
      return;
    }
    localObject1 = b.a(str1, false, -1);
    if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
    {
      y.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
      return;
    }
    y.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[] { localObject2 });
    com.tencent.mm.plugin.base.model.d.e(paramContext, str1, str2, com.tencent.mm.plugin.base.model.c.decrypt(t.j(paramIntent, "ext_info_1")));
    ai.l(new ap.1(this, str1, str2), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ap
 * JD-Core Version:    0.7.0.1
 */