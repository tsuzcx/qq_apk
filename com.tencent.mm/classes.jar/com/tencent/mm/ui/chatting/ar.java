package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class ar
  implements aa
{
  private static l<aa, Bundle> zCT;
  private Context context;
  private final Map<String, ShowMessageFromWX.Req> zCW;
  
  static
  {
    AppMethodBeat.i(31094);
    zCT = new ar.1();
    AppMethodBeat.o(31094);
  }
  
  public ar(Context paramContext)
  {
    AppMethodBeat.i(31089);
    this.zCW = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(31089);
  }
  
  public static void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(31090);
    zCT.cy(paramBundle);
    zCT.doNotify();
    AppMethodBeat.o(31090);
  }
  
  public final void a(String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31092);
    a(paramString1, paramWXMediaMessage, paramString2, paramString3, null);
    AppMethodBeat.o(31092);
  }
  
  public final void a(String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3, ai paramai)
  {
    AppMethodBeat.i(31093);
    ab.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[] { paramString1, paramString3 });
    a.post(new ar.2(this, paramWXMediaMessage, paramString3, paramString1, paramString2, paramai));
    AppMethodBeat.o(31093);
  }
  
  public final void aH(Bundle paramBundle)
  {
    AppMethodBeat.i(31091);
    ab.d("MicroMsg.WXAppMessageShower", "handleResp, appid = ".concat(String.valueOf(Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid"))));
    paramBundle = new ShowMessageFromWX.Resp(paramBundle);
    ab.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + paramBundle.errCode + ", type = " + paramBundle.getType());
    if ((ShowMessageFromWX.Req)this.zCW.get(paramBundle.transaction) == null)
    {
      ab.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + paramBundle.transaction);
      AppMethodBeat.o(31091);
      return;
    }
    this.zCW.remove(paramBundle.transaction);
    AppMethodBeat.o(31091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ar
 * JD-Core Version:    0.7.0.1
 */