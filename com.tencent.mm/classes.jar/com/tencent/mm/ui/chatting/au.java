package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.HashMap;
import java.util.Map;

public final class au
  implements ab
{
  private static MStorageEvent<ab, Bundle> WEU;
  private final Map<String, ShowMessageFromWX.Req> WEX;
  private Context context;
  
  static
  {
    AppMethodBeat.i(34983);
    WEU = new MStorageEvent() {};
    AppMethodBeat.o(34983);
  }
  
  public au(Context paramContext)
  {
    AppMethodBeat.i(34978);
    this.WEX = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(34978);
  }
  
  public static void bs(Bundle paramBundle)
  {
    AppMethodBeat.i(34979);
    WEU.event(paramBundle);
    WEU.doNotify();
    AppMethodBeat.o(34979);
  }
  
  public final void a(String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3)
  {
    AppMethodBeat.i(34981);
    a(paramString1, paramWXMediaMessage, paramString2, paramString3, null);
    AppMethodBeat.o(34981);
  }
  
  public final void a(final String paramString1, final WXMediaMessage paramWXMediaMessage, final String paramString2, final String paramString3, final al paramal)
  {
    AppMethodBeat.i(34982);
    Log.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[] { paramString1, paramString3 });
    com.tencent.mm.co.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34977);
        Object localObject = paramString3;
        if (Util.isNullOrNil(paramString3))
        {
          com.tencent.mm.plugin.ab.a.fmB();
          localObject = n.bqg(paramString2);
        }
        localObject = h.c(au.a(au.this), paramWXMediaMessage, (String)localObject);
        h.a(au.a(au.this), paramString1, paramString2, (ShowMessageFromWX.Req)localObject, 0, new al()
        {
          public final void y(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(287530);
            if (paramAnonymous2Boolean1) {
              au.b(au.this).put(this.QWj.transaction, this.QWj);
            }
            if (au.2.this.WEZ != null) {
              au.2.this.WEZ.y(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
            }
            AppMethodBeat.o(287530);
          }
        }, null);
        AppMethodBeat.o(34977);
      }
    });
    AppMethodBeat.o(34982);
  }
  
  public final void br(Bundle paramBundle)
  {
    AppMethodBeat.i(34980);
    Log.d("MicroMsg.WXAppMessageShower", "handleResp, appid = ".concat(String.valueOf(Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid"))));
    paramBundle = new ShowMessageFromWX.Resp(paramBundle);
    Log.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + paramBundle.errCode + ", type = " + paramBundle.getType());
    if ((ShowMessageFromWX.Req)this.WEX.get(paramBundle.transaction) == null)
    {
      Log.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + paramBundle.transaction);
      AppMethodBeat.o(34980);
      return;
    }
    this.WEX.remove(paramBundle.transaction);
    AppMethodBeat.o(34980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.au
 * JD-Core Version:    0.7.0.1
 */