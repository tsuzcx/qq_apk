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
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends com.tencent.mm.plugin.x.a
{
  public static String IXv = "";
  
  public final int getType()
  {
    return 2;
  }
  
  public final void k(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78840);
    final String str1 = com.tencent.mm.plugin.base.model.c.ahb(IntentUtil.getStringExtra(paramIntent, "id"));
    final String str2 = com.tencent.mm.plugin.base.model.c.ahb(IntentUtil.getStringExtra(paramIntent, "ext_info"));
    Object localObject1 = IntentUtil.getStringExtra(paramIntent, "token");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      Log.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
      AppMethodBeat.o(78840);
      return;
    }
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    if (!((String)localObject1).equals(e.eY(str2, com.tencent.mm.kernel.a.getUin())))
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
        ((Set)localObject2).add(com.tencent.mm.plugin.base.model.c.eY(str2, (String)((Iterator)localObject3).next()));
      }
      if (!((Set)localObject2).contains(localObject1))
      {
        Log.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[] { localObject1 });
        Toast.makeText(paramContext, paramContext.getString(2131768785), 1).show();
        AppMethodBeat.o(78840);
        return;
      }
    }
    paramIntent.putExtra("type", 0);
    paramIntent.putExtra("id", "");
    localObject2 = "https://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + str2;
    localObject1 = localObject2;
    if (!Util.isNullOrNil(IXv)) {
      localObject1 = (String)localObject2 + "&" + IXv;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    ((Intent)localObject2).putExtra("from_shortcut", true);
    ((Intent)localObject2).putExtra("game_hv_menu_appid", str2);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.game.H5GameWebViewUI", (Intent)localObject2);
    ag.bau().MN(str1);
    localObject1 = IntentUtil.getStringExtra(paramIntent, "digest");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "digest is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str1);
    if ((localObject2 == null) || (Util.isNullOrNil(((as)localObject2).arI())))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((as)localObject2).arI();
    Object localObject3 = p.aYB().Mx(str1);
    if ((localObject3 == null) || (Util.isNullOrNil(((i)localObject3).aYu())))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
      AppMethodBeat.o(78840);
      return;
    }
    if (((String)localObject1).equals(com.tencent.mm.b.g.getMessageDigest(((String)localObject2 + ((i)localObject3).aYu()).getBytes())))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
      AppMethodBeat.o(78840);
      return;
    }
    localObject1 = com.tencent.mm.aj.c.a(str1, false, -1, null);
    if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
    {
      Log.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
      AppMethodBeat.o(78840);
      return;
    }
    Log.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[] { localObject2 });
    e.g(paramContext, str1, str2, com.tencent.mm.plugin.base.model.c.ahb(IntentUtil.getStringExtra(paramIntent, "ext_info_1")));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.d
 * JD-Core Version:    0.7.0.1
 */