package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.n;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.snackbar.a.b;

public final class d
  extends a
{
  private a.b kNz = new d.3(this);
  
  public d()
  {
    super(3);
  }
  
  public final void a(Context paramContext, e parame)
  {
    if (!parame.biV.getBoolean("is_favorite_item", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("msg_id", parame.biV.getLong("msg_id", -9223372036854775808L));
      localBundle.putString("sns_local_id", parame.biV.getString("sns_local_id"));
      localBundle.putInt("news_svr_id", parame.biV.getInt("news_svr_id", 0));
      localBundle.putString("news_svr_tweetid", parame.biV.getString("news_svr_tweetid"));
      localBundle.putInt("message_index", parame.biV.getInt("message_index", 0));
      Object localObject = parame.getUrl();
      String str = parame.caV();
      localBundle.putString("rawUrl", str);
      if ((!bk.bl(str)) && (str.endsWith("#rd")))
      {
        str = str.substring(0, str.length() - 3);
        if ((!bk.bl((String)localObject)) && (!((String)localObject).startsWith(str)))
        {
          localBundle.putString("rawUrl", (String)localObject);
          localBundle.putLong("msg_id", -9223372036854775808L);
        }
      }
      for (;;)
      {
        localBundle.putString("preChatName", parame.biV.getString("preChatName"));
        localBundle.putInt("preMsgIndex", parame.biV.getInt("preMsgIndex", 0));
        localBundle.putString("prePublishId", parame.biV.getString("prePublishId"));
        localBundle.putString("preUsername", parame.biV.getString("preUsername"));
        localObject = new FavUrlTask();
        ((FavUrlTask)localObject).actionType = 1;
        ((FavUrlTask)localObject).kke = localBundle;
        LuggageMainProcessService.b((MainProcessTask)localObject);
        if (!((FavUrlTask)localObject).rbu) {
          break;
        }
        ak.BY(1);
        parame.caX().RS("sendAppMessage");
        parame.biT.a(new d.1(this));
        return;
        if ((!bk.bl((String)localObject)) && (!((String)localObject).startsWith(str)))
        {
          localBundle.putString("rawUrl", (String)localObject);
          localBundle.putLong("msg_id", -9223372036854775808L);
          localBundle.putString("sns_local_id", "");
        }
      }
      com.tencent.mm.plugin.fav.ui.c.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.kNz);
      return;
    }
    h.a(paramContext, paramContext.getString(R.l.app_delete_tips), null, null, paramContext.getString(R.l.app_delete), new d.2(this, parame, paramContext));
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    boolean bool1 = parame.biV.getBoolean("is_favorite_item", false);
    boolean bool2 = parame.biV.getBoolean("key_detail_can_delete", true);
    if (!bool1) {
      paraml.a(3, paramContext.getString(R.l.plugin_favorite_opt), R.k.bottomsheet_icon_fav);
    }
    while (!bool2) {
      return;
    }
    paraml.a(3, paramContext.getString(R.l.app_delete), R.k.bottomsheet_icon_del);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */