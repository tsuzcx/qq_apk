package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.ba;
import com.tencent.mm.plugin.webview.luggage.q.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class f
  extends a
{
  private a.b ufz;
  
  public f()
  {
    super(3);
    AppMethodBeat.i(78691);
    this.ufz = new a.b()
    {
      public final void biY()
      {
        AppMethodBeat.i(78690);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        AppBrandMainProcessService.a(localFavUrlTask);
        AppMethodBeat.o(78690);
      }
    };
    AppMethodBeat.o(78691);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78693);
    Bundle localBundle = new Bundle();
    localBundle.putLong("msg_id", paramg.mParams.getLong("msg_id", -9223372036854775808L));
    localBundle.putString("sns_local_id", paramg.mParams.getString("sns_local_id"));
    localBundle.putInt("news_svr_id", paramg.mParams.getInt("news_svr_id", 0));
    localBundle.putString("news_svr_tweetid", paramg.mParams.getString("news_svr_tweetid"));
    localBundle.putInt("message_index", paramg.mParams.getInt("message_index", 0));
    Object localObject = paramg.getUrl();
    String str = paramg.bRn();
    localBundle.putString("rawUrl", str);
    if ((!bu.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        localBundle.putString("rawUrl", (String)localObject);
        localBundle.putLong("msg_id", -9223372036854775808L);
      }
      localBundle.putString("preChatName", paramg.mParams.getString("preChatName"));
      localBundle.putInt("preMsgIndex", paramg.mParams.getInt("preMsgIndex", 0));
      localBundle.putString("prePublishId", paramg.mParams.getString("prePublishId"));
      localBundle.putString("preUsername", paramg.mParams.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).dyY = localBundle;
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).Egc) {
        break label367;
      }
      ba.Xq(1);
      paramg.eSV().aIs("sendAppMessage");
      paramg.chX.a(new d()
      {
        public final JSONObject BP()
        {
          return null;
        }
        
        public final String name()
        {
          return "menu:share:appmessage";
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(982, 2);
      AppMethodBeat.o(78693);
      return;
      if ((bu.isNullOrNil((String)localObject)) || (((String)localObject).startsWith(str))) {
        break;
      }
      localBundle.putString("rawUrl", (String)localObject);
      localBundle.putLong("msg_id", -9223372036854775808L);
      localBundle.putString("sns_local_id", "");
      break;
      label367:
      e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.ufz);
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, l paraml)
  {
    AppMethodBeat.i(78692);
    if (!paramg.mParams.getBoolean("is_favorite_item", false)) {
      paraml.a(3, paramContext.getString(2131761941), 2131689808);
    }
    AppMethodBeat.o(78692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */