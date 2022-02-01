package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.plugin.webview.luggage.p.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class f
  extends a
{
  private a.b sXH;
  
  public f()
  {
    super(3);
    AppMethodBeat.i(78691);
    this.sXH = new a.b()
    {
      public final void beL()
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
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.f paramf)
  {
    AppMethodBeat.i(78693);
    Bundle localBundle = new Bundle();
    localBundle.putLong("msg_id", paramf.mParams.getLong("msg_id", -9223372036854775808L));
    localBundle.putString("sns_local_id", paramf.mParams.getString("sns_local_id"));
    localBundle.putInt("news_svr_id", paramf.mParams.getInt("news_svr_id", 0));
    localBundle.putString("news_svr_tweetid", paramf.mParams.getString("news_svr_tweetid"));
    localBundle.putInt("message_index", paramf.mParams.getInt("message_index", 0));
    Object localObject = paramf.getUrl();
    String str = paramf.bLL();
    localBundle.putString("rawUrl", str);
    if ((!bs.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        localBundle.putString("rawUrl", (String)localObject);
        localBundle.putLong("msg_id", -9223372036854775808L);
      }
      localBundle.putString("preChatName", paramf.mParams.getString("preChatName"));
      localBundle.putInt("preMsgIndex", paramf.mParams.getInt("preMsgIndex", 0));
      localBundle.putString("prePublishId", paramf.mParams.getString("prePublishId"));
      localBundle.putString("preUsername", paramf.mParams.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).dmf = localBundle;
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).CkX) {
        break label367;
      }
      ax.UT(1);
      paramf.eAt().aBA("sendAppMessage");
      paramf.bXF.a(new c()
      {
        public final JSONObject Aq()
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
      h.wUl.dB(982, 2);
      AppMethodBeat.o(78693);
      return;
      if ((bs.isNullOrNil((String)localObject)) || (((String)localObject).startsWith(str))) {
        break;
      }
      localBundle.putString("rawUrl", (String)localObject);
      localBundle.putLong("msg_id", -9223372036854775808L);
      localBundle.putString("sns_local_id", "");
      break;
      label367:
      e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.sXH);
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.f paramf, l paraml)
  {
    AppMethodBeat.i(78692);
    if (!paramf.mParams.getBoolean("is_favorite_item", false)) {
      paraml.a(3, paramContext.getString(2131761941), 2131689808);
    }
    AppMethodBeat.o(78692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */