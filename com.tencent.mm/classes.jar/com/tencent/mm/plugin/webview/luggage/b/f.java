package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.plugin.webview.luggage.q.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class f
  extends a
{
  private a.b CBU;
  
  public f()
  {
    super(3);
    AppMethodBeat.i(78691);
    this.CBU = new a.b()
    {
      public final void bPM()
      {
        AppMethodBeat.i(78690);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        localFavUrlTask.bsM();
        AppMethodBeat.o(78690);
      }
    };
    AppMethodBeat.o(78691);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78693);
    Bundle localBundle = new Bundle();
    localBundle.putLong("msg_id", paramg.mParams.getLong("msg_id", -9223372036854775808L));
    localBundle.putString("sns_local_id", paramg.mParams.getString("sns_local_id"));
    localBundle.putInt("news_svr_id", paramg.mParams.getInt("news_svr_id", 0));
    localBundle.putString("news_svr_tweetid", paramg.mParams.getString("news_svr_tweetid"));
    localBundle.putInt("message_index", paramg.mParams.getInt("message_index", 0));
    Object localObject = paramg.getUrl();
    String str = paramg.cDu();
    localBundle.putString("rawUrl", str);
    if ((!Util.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
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
      ((FavUrlTask)localObject).fKb = localBundle;
      ((FavUrlTask)localObject).bPu();
      if (!((FavUrlTask)localObject).PPe) {
        break label367;
      }
      bb.anM(1);
      paramg.gUB().bkp("sendAppMessage");
      paramg.crX.a(new d()
      {
        public final JSONObject NU()
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
      h.IzE.el(982, 2);
      AppMethodBeat.o(78693);
      return;
      if ((Util.isNullOrNil((String)localObject)) || (((String)localObject).startsWith(str))) {
        break;
      }
      localBundle.putString("rawUrl", (String)localObject);
      localBundle.putLong("msg_id", -9223372036854775808L);
      localBundle.putString("sns_local_id", "");
      break;
      label367:
      e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.CBU);
    }
  }
  
  public final void a(Context paramContext, g paramg, o paramo)
  {
    AppMethodBeat.i(78692);
    if (!paramg.mParams.getBoolean("is_favorite_item", false)) {
      paramo.b(3, paramContext.getString(c.i.plugin_favorite_opt), c.h.bottomsheet_icon_fav);
    }
    AppMethodBeat.o(78692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */