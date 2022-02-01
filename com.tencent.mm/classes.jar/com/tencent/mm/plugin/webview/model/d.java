package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.af;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends com.tencent.mm.plugin.x.a
{
  public static String CoZ = "";
  
  public final int getType()
  {
    return 2;
  }
  
  public final void k(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78840);
    final String str1 = com.tencent.mm.plugin.base.model.c.SY(x.getStringExtra(paramIntent, "id"));
    final String str2 = com.tencent.mm.plugin.base.model.c.SY(x.getStringExtra(paramIntent, "ext_info"));
    Object localObject1 = x.getStringExtra(paramIntent, "token");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ac.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
      AppMethodBeat.o(78840);
      return;
    }
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    if (!((String)localObject1).equals(e.ev(str2, com.tencent.mm.kernel.a.getUin())))
    {
      localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (localObject2 == null)
      {
        ac.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
        AppMethodBeat.o(78840);
        return;
      }
      localObject3 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if ((localObject3 == null) || (((Set)localObject3).isEmpty()))
      {
        ac.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
        AppMethodBeat.o(78840);
        return;
      }
      localObject2 = new HashSet();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Set)localObject2).add(com.tencent.mm.plugin.base.model.c.ev(str2, (String)((Iterator)localObject3).next()));
      }
      if (!((Set)localObject2).contains(localObject1))
      {
        ac.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[] { localObject1 });
        Toast.makeText(paramContext, paramContext.getString(2131766274), 1).show();
        AppMethodBeat.o(78840);
        return;
      }
    }
    paramIntent.putExtra("type", 0);
    paramIntent.putExtra("id", "");
    localObject2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=".concat(String.valueOf(str2));
    localObject1 = localObject2;
    if (!bs.isNullOrNil(CoZ)) {
      localObject1 = (String)localObject2 + "&" + CoZ;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    ((Intent)localObject2).putExtra("from_shortcut", true);
    ((Intent)localObject2).putExtra("game_hv_menu_appid", str2);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.game.H5GameWebViewUI", (Intent)localObject2);
    af.aDi().Ay(str1);
    localObject1 = x.getStringExtra(paramIntent, "digest");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ac.i("MicroMsg.WebViewShortcutEntry", "digest is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(str1);
    if ((localObject2 == null) || (bs.isNullOrNil(((com.tencent.mm.storage.ai)localObject2).aaR())))
    {
      ac.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((com.tencent.mm.storage.ai)localObject2).aaR();
    Object localObject3 = p.aBw().Ak(str1);
    if ((localObject3 == null) || (bs.isNullOrNil(((i)localObject3).aBp())))
    {
      ac.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
      AppMethodBeat.o(78840);
      return;
    }
    if (((String)localObject1).equals(com.tencent.mm.b.g.getMessageDigest(((String)localObject2 + ((i)localObject3).aBp()).getBytes())))
    {
      ac.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
      AppMethodBeat.o(78840);
      return;
    }
    localObject1 = com.tencent.mm.aj.c.a(str1, false, -1, null);
    if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
    {
      ac.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
      AppMethodBeat.o(78840);
      return;
    }
    ac.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[] { localObject2 });
    e.d(paramContext, str1, str2, com.tencent.mm.plugin.base.model.c.SY(x.getStringExtra(paramIntent, "ext_info_1")));
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78839);
        e.a(com.tencent.mm.sdk.platformtools.ai.getContext(), str1, str2, null);
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