package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.at.a.b.e;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.at.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.HttpURLConnection;
import java.net.URL;

final class f$a
{
  static b tC(String paramString)
  {
    AppMethodBeat.i(154236);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    localHttpURLConnection.setConnectTimeout(15000);
    localHttpURLConnection.setReadTimeout(20000);
    if (q.tv(paramString)) {
      localHttpURLConnection.setRequestProperty("Referer", q.lE(d.whH));
    }
    if (localHttpURLConnection.getResponseCode() < 300) {
      if ((paramString == null) || ((!paramString.startsWith("http://mmbiz.qpic.cn")) && (!paramString.startsWith("http://mmbiz.qlogo.cn")) && (!paramString.startsWith("https://mmbiz.qpic.cn")) && (!paramString.startsWith("https://mmbiz.qlogo.cn")))) {
        break label141;
      }
    }
    label141:
    for (int i = 1; (i != 0) && (c.c(localHttpURLConnection) != 0); i = 0)
    {
      bo.b(localHttpURLConnection.getInputStream());
      localHttpURLConnection.disconnect();
      ab.w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
      AppMethodBeat.o(154236);
      return null;
    }
    paramString = localHttpURLConnection.getInputStream();
    Object localObject = localHttpURLConnection.getContentType();
    localObject = new b(e.u(paramString), (String)localObject, (byte)0);
    bo.b(paramString);
    if (localHttpURLConnection != null) {}
    try
    {
      localHttpURLConnection.disconnect();
      label182:
      AppMethodBeat.o(154236);
      return localObject;
    }
    catch (Exception paramString)
    {
      break label182;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.f.a
 * JD-Core Version:    0.7.0.1
 */