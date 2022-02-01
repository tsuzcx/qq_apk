package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class at
  implements ab
{
  private static l<ab, Bundle> JZN;
  private final Map<String, ShowMessageFromWX.Req> JZQ;
  private Context context;
  
  static
  {
    AppMethodBeat.i(34983);
    JZN = new l() {};
    AppMethodBeat.o(34983);
  }
  
  public at(Context paramContext)
  {
    AppMethodBeat.i(34978);
    this.JZQ = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(34978);
  }
  
  public static void bi(Bundle paramBundle)
  {
    AppMethodBeat.i(34979);
    JZN.dW(paramBundle);
    JZN.doNotify();
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
    ae.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[] { paramString1, paramString3 });
    a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34977);
        final ShowMessageFromWX.Req localReq = h.b(at.a(at.this), paramWXMediaMessage, paramString3);
        h.a(at.a(at.this), paramString1, paramString2, localReq, 0, new al()
        {
          public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(187194);
            if (paramAnonymous2Boolean1) {
              at.b(at.this).put(localReq.transaction, localReq);
            }
            if (at.2.this.JZR != null) {
              at.2.this.JZR.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
            }
            AppMethodBeat.o(187194);
          }
        }, null);
        AppMethodBeat.o(34977);
      }
    });
    AppMethodBeat.o(34982);
  }
  
  public final void bh(Bundle paramBundle)
  {
    AppMethodBeat.i(34980);
    ae.d("MicroMsg.WXAppMessageShower", "handleResp, appid = ".concat(String.valueOf(Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid"))));
    paramBundle = new ShowMessageFromWX.Resp(paramBundle);
    ae.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + paramBundle.errCode + ", type = " + paramBundle.getType());
    if ((ShowMessageFromWX.Req)this.JZQ.get(paramBundle.transaction) == null)
    {
      ae.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + paramBundle.transaction);
      AppMethodBeat.o(34980);
      return;
    }
    this.JZQ.remove(paramBundle.transaction);
    AppMethodBeat.o(34980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.at
 * JD-Core Version:    0.7.0.1
 */