package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends com.tencent.mm.plugin.an.a
{
  public static String WKy = "";
  
  public final void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78840);
    final String str1 = com.tencent.mm.plugin.base.model.c.aid(IntentUtil.getStringExtra(paramIntent, "id"));
    final String str2 = com.tencent.mm.plugin.base.model.c.aid(IntentUtil.getStringExtra(paramIntent, "ext_info"));
    Object localObject1 = IntentUtil.getStringExtra(paramIntent, "token");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      Log.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
      AppMethodBeat.o(78840);
      return;
    }
    Object localObject2 = new StringBuilder();
    h.baC();
    if (!((String)localObject1).equals(e.fD(str2, b.getUin())))
    {
      localObject2 = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (localObject2 == null)
      {
        Log.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
        AppMethodBeat.o(78840);
        return;
      }
      localObject3 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if ((localObject3 == null) || (((Set)localObject3).isEmpty()))
      {
        Log.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
        AppMethodBeat.o(78840);
        return;
      }
      localObject2 = new HashSet();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Set)localObject2).add(com.tencent.mm.plugin.base.model.c.fD(str2, (String)((Iterator)localObject3).next()));
      }
      if (!((Set)localObject2).contains(localObject1))
      {
        Log.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[] { localObject1 });
        Toast.makeText(paramContext, paramContext.getString(c.i.wv_launch_shortcut_fail), 1).show();
        AppMethodBeat.o(78840);
        return;
      }
    }
    paramIntent.putExtra("type", 0);
    paramIntent.putExtra("id", "");
    localObject2 = "https://" + WeChatHosts.domainString(c.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + str2;
    localObject1 = localObject2;
    if (!Util.isNullOrNil(WKy)) {
      localObject1 = (String)localObject2 + "&" + WKy;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    ((Intent)localObject2).putExtra("from_shortcut", true);
    ((Intent)localObject2).putExtra("game_hv_menu_appid", str2);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.game.H5GameWebViewUI", (Intent)localObject2);
    af.bHt().Mh(str1);
    localObject1 = IntentUtil.getStringExtra(paramIntent, "digest");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "digest is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((n)h.ax(n.class)).bzA().JE(str1);
    if ((localObject2 == null) || (Util.isNullOrNil(((au)localObject2).aSU())))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((au)localObject2).aSU();
    Object localObject3 = q.bFE().LS(str1);
    if ((localObject3 == null) || (Util.isNullOrNil(((j)localObject3).bFx())))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
      AppMethodBeat.o(78840);
      return;
    }
    if (((String)localObject1).equals(g.getMessageDigest(((String)localObject2 + ((j)localObject3).bFx()).getBytes())))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
      AppMethodBeat.o(78840);
      return;
    }
    localObject1 = com.tencent.mm.modelavatar.d.a(str1, false, -1, null);
    if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
      AppMethodBeat.o(78840);
      return;
    }
    Log.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[] { localObject2 });
    e.j(paramContext, str1, str2, com.tencent.mm.plugin.base.model.c.aid(IntentUtil.getStringExtra(paramIntent, "ext_info_1")));
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78839);
        e.a(MMApplicationContext.getContext(), str1, str2, null);
        AppMethodBeat.o(78839);
      }
    }, 1000L);
    AppMethodBeat.o(78840);
  }
  
  public final int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.d
 * JD-Core Version:    0.7.0.1
 */