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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends com.tencent.mm.plugin.y.a
{
  public static String Ekx = "";
  
  public final int getType()
  {
    return 2;
  }
  
  public final void k(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78840);
    final String str1 = com.tencent.mm.plugin.base.model.c.Xh(z.getStringExtra(paramIntent, "id"));
    final String str2 = com.tencent.mm.plugin.base.model.c.Xh(z.getStringExtra(paramIntent, "ext_info"));
    Object localObject1 = z.getStringExtra(paramIntent, "token");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ae.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
      AppMethodBeat.o(78840);
      return;
    }
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    if (!((String)localObject1).equals(e.eH(str2, com.tencent.mm.kernel.a.getUin())))
    {
      localObject2 = ak.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (localObject2 == null)
      {
        ae.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
        AppMethodBeat.o(78840);
        return;
      }
      localObject3 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if ((localObject3 == null) || (((Set)localObject3).isEmpty()))
      {
        ae.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
        AppMethodBeat.o(78840);
        return;
      }
      localObject2 = new HashSet();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Set)localObject2).add(com.tencent.mm.plugin.base.model.c.eH(str2, (String)((Iterator)localObject3).next()));
      }
      if (!((Set)localObject2).contains(localObject1))
      {
        ae.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[] { localObject1 });
        Toast.makeText(paramContext, paramContext.getString(2131766274), 1).show();
        AppMethodBeat.o(78840);
        return;
      }
    }
    paramIntent.putExtra("type", 0);
    paramIntent.putExtra("id", "");
    localObject2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=".concat(String.valueOf(str2));
    localObject1 = localObject2;
    if (!bu.isNullOrNil(Ekx)) {
      localObject1 = (String)localObject2 + "&" + Ekx;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    ((Intent)localObject2).putExtra("from_shortcut", true);
    ((Intent)localObject2).putExtra("game_hv_menu_appid", str2);
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.game.H5GameWebViewUI", (Intent)localObject2);
    ag.aGB().DZ(str1);
    localObject1 = z.getStringExtra(paramIntent, "digest");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ae.i("MicroMsg.WebViewShortcutEntry", "digest is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(str1);
    if ((localObject2 == null) || (bu.isNullOrNil(((an)localObject2).adF())))
    {
      ae.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
      AppMethodBeat.o(78840);
      return;
    }
    localObject2 = ((an)localObject2).adF();
    Object localObject3 = p.aEN().DL(str1);
    if ((localObject3 == null) || (bu.isNullOrNil(((i)localObject3).aEH())))
    {
      ae.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
      AppMethodBeat.o(78840);
      return;
    }
    if (((String)localObject1).equals(com.tencent.mm.b.g.getMessageDigest(((String)localObject2 + ((i)localObject3).aEH()).getBytes())))
    {
      ae.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
      AppMethodBeat.o(78840);
      return;
    }
    localObject1 = com.tencent.mm.aj.c.a(str1, false, -1, null);
    if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
    {
      ae.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
      AppMethodBeat.o(78840);
      return;
    }
    ae.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[] { localObject2 });
    e.d(paramContext, str1, str2, com.tencent.mm.plugin.base.model.c.Xh(z.getStringExtra(paramIntent, "ext_info_1")));
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78839);
        e.a(ak.getContext(), str1, str2, null);
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