package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.au;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.snackbar.a.b;

public final class d
  extends a
{
  private a.b nkf;
  
  public d()
  {
    super(3);
    AppMethodBeat.i(6428);
    this.nkf = new d.3(this);
    AppMethodBeat.o(6428);
  }
  
  public final void a(Context paramContext, e parame)
  {
    AppMethodBeat.i(6430);
    if (!parame.bzu.getBoolean("is_favorite_item", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("msg_id", parame.bzu.getLong("msg_id", -9223372036854775808L));
      localBundle.putString("sns_local_id", parame.bzu.getString("sns_local_id"));
      localBundle.putInt("news_svr_id", parame.bzu.getInt("news_svr_id", 0));
      localBundle.putString("news_svr_tweetid", parame.bzu.getString("news_svr_tweetid"));
      localBundle.putInt("message_index", parame.bzu.getInt("message_index", 0));
      Object localObject = parame.getUrl();
      String str = parame.daZ();
      localBundle.putString("rawUrl", str);
      if ((!bo.isNullOrNil(str)) && (str.endsWith("#rd")))
      {
        str = str.substring(0, str.length() - 3);
        if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
        {
          localBundle.putString("rawUrl", (String)localObject);
          localBundle.putLong("msg_id", -9223372036854775808L);
        }
        localBundle.putString("preChatName", parame.bzu.getString("preChatName"));
        localBundle.putInt("preMsgIndex", parame.bzu.getInt("preMsgIndex", 0));
        localBundle.putString("prePublishId", parame.bzu.getString("prePublishId"));
        localBundle.putString("preUsername", parame.bzu.getString("preUsername"));
        localObject = new FavUrlTask();
        ((FavUrlTask)localObject).actionType = 1;
        ((FavUrlTask)localObject).mEJ = localBundle;
        AppBrandMainProcessService.b((MainProcessTask)localObject);
        if (!((FavUrlTask)localObject).uRc) {
          break label382;
        }
        au.JS(1);
        parame.dbb().agX("sendAppMessage");
        parame.bzs.a(new d.1(this));
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.cT(982, 2);
        AppMethodBeat.o(6430);
        return;
        if ((bo.isNullOrNil((String)localObject)) || (((String)localObject).startsWith(str))) {
          break;
        }
        localBundle.putString("rawUrl", (String)localObject);
        localBundle.putLong("msg_id", -9223372036854775808L);
        localBundle.putString("sns_local_id", "");
        break;
        label382:
        com.tencent.mm.plugin.fav.ui.c.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.nkf);
      }
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131296902), null, null, paramContext.getString(2131296901), new d.2(this, parame));
    com.tencent.mm.plugin.report.service.h.qsU.cT(982, 3);
    AppMethodBeat.o(6430);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6429);
    boolean bool1 = parame.bzu.getBoolean("is_favorite_item", false);
    boolean bool2 = parame.bzu.getBoolean("key_detail_can_delete", true);
    if (!bool1)
    {
      paraml.a(3, paramContext.getString(2131302102), 2131231015);
      AppMethodBeat.o(6429);
      return;
    }
    if (bool2) {
      paraml.a(3, paramContext.getString(2131296901), 2131231009);
    }
    AppMethodBeat.o(6429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */