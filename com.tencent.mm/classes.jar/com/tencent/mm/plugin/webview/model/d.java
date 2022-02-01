package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.am.ag;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends com.tencent.mm.plugin.y.a
{
  public static String DSx = "";
  
  public final int getType()
  {
    return 2;
  }
  
  public final void k(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78840);
    final String str1 = com.tencent.mm.plugin.base.model.c.Wv(y.getStringExtra(paramIntent, "id"));
    final String str2 = com.tencent.mm.plugin.base.model.c.Wv(y.getStringExtra(paramIntent, "ext_info"));
    Object localObject1 = y.getStringExtra(paramIntent, "token");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ad.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
      AppMethodBeat.o(78840);
      return;
    }
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    if (!((String)localObject1).equals(e.eE(str2, com.tencent.mm.kernel.a.getUin())))
    {
      localObject2 = aj.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (localObject2 == null)
      {
        ad.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
        AppMethodBeat.o(78840);
        return;
      }
      localObject3 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if ((localObject3 == null) || (((Set)localObject3).isEmpty()))
      {
        ad.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
        AppMethodBeat.o(78840);
        return;
      }
      localObject2 = new HashSet();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Set)localObject2).add(com.tencent.mm.plugin.base.model.c.eE(str2, (String)((Iterator)localObject3).next()));
      }
      if (!((Set)localObject2).contains(localObject1))
      {
        ad.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[] { localObject1 });
        Toast.makeText(paramContext, paramContext.getString(2131766274), 1).show();
        AppMethodBeat.o(78840);
        return;
      }
    }
    paramIntent.putExtra("type", 0);
    paramIntent.putExtra("id", "");
    localObject2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=".concat(String.valueOf(str2));
    localObject1 = localObject2;
    if (!bt.isNullOrNil(DSx)) {
      localObject1 = (String)localObject2 + "&" + DSx;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    ((Intent)localObject2).putExtra("from_shortcut", true);
    ((Intent)localObject2).putExtra("game_hv_menu_appid", str2);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.game.H5GameWebViewUI", (Intent)localObject2);
    ag.aGl().Dx(str1);
    localObject1 = y.getStringExtra(paramIntent, "digest");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ad.i("MicroMsg.WebViewShortcutEntry", "digest is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(str1);
    if ((localObject2 == null) || (bt.isNullOrNil(((am)localObject2).adu())))
    {
      ad.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((am)localObject2).adu();
    Object localObject3 = p.aEx().Dj(str1);
    if ((localObject3 == null) || (bt.isNullOrNil(((i)localObject3).aEr())))
    {
      ad.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
      AppMethodBeat.o(78840);
      return;
    }
    if (((String)localObject1).equals(com.tencent.mm.b.g.getMessageDigest(((String)localObject2 + ((i)localObject3).aEr()).getBytes())))
    {
      ad.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
      AppMethodBeat.o(78840);
      return;
    }
    localObject1 = com.tencent.mm.ak.c.a(str1, false, -1, null);
    if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
    {
      ad.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
      AppMethodBeat.o(78840);
      return;
    }
    ad.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[] { localObject2 });
    e.d(paramContext, str1, str2, com.tencent.mm.plugin.base.model.c.Wv(y.getStringExtra(paramIntent, "ext_info_1")));
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78839);
        e.a(aj.getContext(), str1, str2, null);
        AppMethodBeat.o(78839);
      }
    }, 1000L);
    AppMethodBeat.o(78840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.d
 * JD-Core Version:    0.7.0.1
 */