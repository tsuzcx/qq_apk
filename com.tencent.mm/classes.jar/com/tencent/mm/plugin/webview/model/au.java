package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class au
  extends com.tencent.mm.plugin.w.a
{
  public static String uXj = "";
  
  public final int getType()
  {
    return 2;
  }
  
  public final void l(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(6801);
    String str1 = c.decrypt(w.n(paramIntent, "id"));
    String str2 = c.decrypt(w.n(paramIntent, "ext_info"));
    Object localObject1 = w.n(paramIntent, "token");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ab.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
      AppMethodBeat.o(6801);
      return;
    }
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    if (!((String)localObject1).equals(av.de(str2, com.tencent.mm.kernel.a.getUin())))
    {
      localObject2 = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (localObject2 == null)
      {
        ab.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
        AppMethodBeat.o(6801);
        return;
      }
      localObject3 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if ((localObject3 == null) || (((Set)localObject3).isEmpty()))
      {
        ab.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
        AppMethodBeat.o(6801);
        return;
      }
      localObject2 = new HashSet();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Set)localObject2).add(c.de(str2, (String)((Iterator)localObject3).next()));
      }
      if (!((Set)localObject2).contains(localObject1))
      {
        ab.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[] { localObject1 });
        Toast.makeText(paramContext, paramContext.getString(2131306026), 1).show();
        AppMethodBeat.o(6801);
        return;
      }
    }
    paramIntent.putExtra("type", 0);
    paramIntent.putExtra("id", "");
    localObject2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=".concat(String.valueOf(str2));
    localObject1 = localObject2;
    if (!bo.isNullOrNil(uXj)) {
      localObject1 = (String)localObject2 + "&" + uXj;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    ((Intent)localObject2).putExtra("from_shortcut", true);
    ((Intent)localObject2).putExtra("game_hv_menu_appid", str2);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    d.b(paramContext, "webview", ".ui.tools.game.H5GameWebViewUI", (Intent)localObject2);
    z.afu().rw(str1);
    localObject1 = w.n(paramIntent, "digest");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ab.i("MicroMsg.WebViewShortcutEntry", "digest is null");
      AppMethodBeat.o(6801);
      return;
    }
    localObject2 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(str1);
    if ((localObject2 == null) || (bo.isNullOrNil(((ad)localObject2).Oe())))
    {
      ab.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
      AppMethodBeat.o(6801);
      return;
    }
    localObject2 = ((ad)localObject2).Oe();
    Object localObject3 = o.adg().rj(str1);
    if ((localObject3 == null) || (bo.isNullOrNil(((h)localObject3).acY())))
    {
      ab.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
      AppMethodBeat.o(6801);
      return;
    }
    if (((String)localObject1).equals(com.tencent.mm.a.g.w(((String)localObject2 + ((h)localObject3).acY()).getBytes())))
    {
      ab.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
      AppMethodBeat.o(6801);
      return;
    }
    localObject1 = b.b(str1, false, -1);
    if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
    {
      ab.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
      AppMethodBeat.o(6801);
      return;
    }
    ab.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[] { localObject2 });
    av.f(paramContext, str1, str2, c.decrypt(w.n(paramIntent, "ext_info_1")));
    al.p(new au.1(this, str1, str2), 1000L);
    AppMethodBeat.o(6801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.au
 * JD-Core Version:    0.7.0.1
 */