package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bf;
import com.tencent.mm.plugin.webview.luggage.r.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends a
{
  private a.b IvJ;
  
  public f()
  {
    super(3);
    AppMethodBeat.i(78691);
    this.IvJ = new a.b()
    {
      public final void onMessageClick()
      {
        AppMethodBeat.i(78690);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        localFavUrlTask.bQt();
        AppMethodBeat.o(78690);
      }
    };
    AppMethodBeat.o(78691);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78693);
    Bundle localBundle = new Bundle();
    localBundle.putLong("msg_id", paramg.ejT.getLong("msg_id", -9223372036854775808L));
    localBundle.putString("sns_local_id", paramg.ejT.getString("sns_local_id"));
    localBundle.putInt("news_svr_id", paramg.ejT.getInt("news_svr_id", 0));
    localBundle.putString("news_svr_tweetid", paramg.ejT.getString("news_svr_tweetid"));
    localBundle.putInt("message_index", paramg.ejT.getInt("message_index", 0));
    Object localObject = paramg.getUrl();
    String str = paramg.dgY();
    localBundle.putString("rawUrl", str);
    if ((!Util.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        localBundle.putString("rawUrl", (String)localObject);
        localBundle.putLong("msg_id", -9223372036854775808L);
      }
      localBundle.putString("preChatName", paramg.ejT.getString("preChatName"));
      localBundle.putInt("preMsgIndex", paramg.ejT.getInt("preMsgIndex", 0));
      localBundle.putString("prePublishId", paramg.ejT.getString("prePublishId"));
      localBundle.putString("preUsername", paramg.ejT.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).hPH = localBundle;
      ((FavUrlTask)localObject).cpB();
      if (!((FavUrlTask)localObject).WFx) {
        break label367;
      }
      bf.atG(1);
      paramg.iuk().bjZ("sendAppMessage");
      paramg.ejR.a(new d()
      {
        public final JSONObject aoe()
        {
          AppMethodBeat.i(296074);
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("scene", "favorite");
            label22:
            AppMethodBeat.o(296074);
            return localJSONObject;
          }
          catch (JSONException localJSONException)
          {
            break label22;
          }
        }
        
        public final String name()
        {
          return "menu:share:appmessage";
        }
      });
    }
    for (;;)
    {
      h.OAn.kJ(982, 2);
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
      e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.IvJ);
    }
  }
  
  public final void a(Context paramContext, g paramg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(78692);
    if (!paramg.ejT.getBoolean("is_favorite_item", false)) {
      params.a(3, paramContext.getString(c.i.plugin_favorite_opt), c.h.bottomsheet_icon_fav, 0);
    }
    AppMethodBeat.o(78692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */