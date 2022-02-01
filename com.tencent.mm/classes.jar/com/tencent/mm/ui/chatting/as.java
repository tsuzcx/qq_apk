package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class as
  implements aa
{
  private static l<aa, Bundle> JEW;
  private final Map<String, ShowMessageFromWX.Req> JEZ;
  private Context context;
  
  static
  {
    AppMethodBeat.i(34983);
    JEW = new l() {};
    AppMethodBeat.o(34983);
  }
  
  public as(Context paramContext)
  {
    AppMethodBeat.i(34978);
    this.JEZ = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(34978);
  }
  
  public static void bh(Bundle paramBundle)
  {
    AppMethodBeat.i(34979);
    JEW.dV(paramBundle);
    JEW.doNotify();
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
    ad.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[] { paramString1, paramString3 });
    a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34977);
        final ShowMessageFromWX.Req localReq = h.b(as.a(as.this), paramWXMediaMessage, paramString3);
        h.a(as.a(as.this), paramString1, paramString2, localReq, 0, new al()
        {
          public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(193887);
            if (paramAnonymous2Boolean1) {
              as.b(as.this).put(localReq.transaction, localReq);
            }
            if (as.2.this.JFa != null) {
              as.2.this.JFa.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
            }
            AppMethodBeat.o(193887);
          }
        }, null);
        AppMethodBeat.o(34977);
      }
    });
    AppMethodBeat.o(34982);
  }
  
  public final void bg(Bundle paramBundle)
  {
    AppMethodBeat.i(34980);
    ad.d("MicroMsg.WXAppMessageShower", "handleResp, appid = ".concat(String.valueOf(Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid"))));
    paramBundle = new ShowMessageFromWX.Resp(paramBundle);
    ad.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + paramBundle.errCode + ", type = " + paramBundle.getType());
    if ((ShowMessageFromWX.Req)this.JEZ.get(paramBundle.transaction) == null)
    {
      ad.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + paramBundle.transaction);
      AppMethodBeat.o(34980);
      return;
    }
    this.JEZ.remove(paramBundle.transaction);
    AppMethodBeat.o(34980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.as
 * JD-Core Version:    0.7.0.1
 */