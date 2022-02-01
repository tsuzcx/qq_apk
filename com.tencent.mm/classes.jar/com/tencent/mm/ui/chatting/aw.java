package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.HashMap;
import java.util.Map;

public final class aw
  implements ad
{
  private static MStorageEvent<ad, Bundle> aemu;
  private final Map<String, ShowMessageFromWX.Req> aemx;
  private Context context;
  
  static
  {
    AppMethodBeat.i(34983);
    aemu = new MStorageEvent() {};
    AppMethodBeat.o(34983);
  }
  
  public aw(Context paramContext)
  {
    AppMethodBeat.i(34978);
    this.aemx = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(34978);
  }
  
  public static void bY(Bundle paramBundle)
  {
    AppMethodBeat.i(34979);
    aemu.event(paramBundle);
    aemu.doNotify();
    AppMethodBeat.o(34979);
  }
  
  public final void a(String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3)
  {
    AppMethodBeat.i(34981);
    a(paramString1, paramWXMediaMessage, paramString2, paramString3, null);
    AppMethodBeat.o(34981);
  }
  
  public final void a(final String paramString1, final WXMediaMessage paramWXMediaMessage, final String paramString2, final String paramString3, final ap paramap)
  {
    AppMethodBeat.i(34982);
    Log.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[] { paramString1, paramString3 });
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34977);
        Object localObject = paramString3;
        if (Util.isNullOrNil(paramString3))
        {
          com.tencent.mm.plugin.openapi.a.gxp();
          localObject = q.bpV(paramString2);
        }
        localObject = h.c(aw.a(aw.this), paramWXMediaMessage, (String)localObject);
        h.a(aw.a(aw.this), paramString1, paramString2, (ShowMessageFromWX.Req)localObject, 0, new ap()
        {
          public final void onLaunchApp(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(253868);
            if (paramAnonymous2Boolean1) {
              aw.b(aw.this).put(this.XSg.transaction, this.XSg);
            }
            if (aw.2.this.aemz != null) {
              aw.2.this.aemz.onLaunchApp(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
            }
            AppMethodBeat.o(253868);
          }
        }, null);
        AppMethodBeat.o(34977);
      }
    });
    AppMethodBeat.o(34982);
  }
  
  public final void bX(Bundle paramBundle)
  {
    AppMethodBeat.i(34980);
    Log.d("MicroMsg.WXAppMessageShower", "handleResp, appid = ".concat(String.valueOf(Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid"))));
    paramBundle = new ShowMessageFromWX.Resp(paramBundle);
    Log.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + paramBundle.errCode + ", type = " + paramBundle.getType());
    if ((ShowMessageFromWX.Req)this.aemx.get(paramBundle.transaction) == null)
    {
      Log.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + paramBundle.transaction);
      AppMethodBeat.o(34980);
      return;
    }
    this.aemx.remove(paramBundle.transaction);
    AppMethodBeat.o(34980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aw
 * JD-Core Version:    0.7.0.1
 */