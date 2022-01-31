package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.ak.c;
import com.tencent.mm.as.a.b.e;
import com.tencent.mm.as.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f
  implements com.tencent.mm.as.a.c.b
{
  private final byte[] scd;
  
  public f()
  {
    com.tencent.mm.kernel.g.DN().CX();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    this.scd = com.tencent.mm.a.g.p((a.CL() + "mmbiz").getBytes());
  }
  
  public final com.tencent.mm.as.a.d.b ms(String paramString)
  {
    y.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", new Object[] { paramString });
    for (;;)
    {
      Object localObject1;
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject2 = (HttpURLConnection)new URL(paramString).openConnection();
        ((HttpURLConnection)localObject2).setConnectTimeout(15000);
        ((HttpURLConnection)localObject2).setReadTimeout(20000);
        if (q.mp(paramString)) {
          ((HttpURLConnection)localObject2).setRequestProperty("Referer", q.iQ(d.spa));
        }
        if (((HttpURLConnection)localObject2).getResponseCode() < 300)
        {
          if (paramString == null) {
            break label358;
          }
          if ((paramString.startsWith("http://mmbiz.qpic.cn")) || (paramString.startsWith("http://mmbiz.qlogo.cn")) || (paramString.startsWith("https://mmbiz.qpic.cn"))) {
            break label350;
          }
          if (!paramString.startsWith("https://mmbiz.qlogo.cn")) {
            break label358;
          }
          break label350;
          if ((i == 0) || (c.b((HttpURLConnection)localObject2) == 0)) {}
        }
        else
        {
          ((HttpURLConnection)localObject2).disconnect();
          y.w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
          localObject1 = null;
          if (localObject1 == null) {
            break label355;
          }
          long l2 = System.currentTimeMillis();
          if ((!q.OQ()) || (bk.bl(((com.tencent.mm.as.a.d.b)localObject1).aRN)) || (!q.mp(paramString)) || (!((com.tencent.mm.as.a.d.b)localObject1).aRN.equals("image/webp"))) {
            break label344;
          }
          bool = true;
          y.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", new Object[] { Boolean.valueOf(bool) });
          l1 = l2 - l1;
          y.d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", new Object[] { Long.valueOf(l1) });
          h.nFQ.a(86L, 4L, l1, false);
          if (!bool) {
            break label355;
          }
          h.nFQ.a(86L, 17L, l1, false);
          return localObject1;
        }
        localObject1 = ((HttpURLConnection)localObject2).getInputStream();
        localObject2 = ((HttpURLConnection)localObject2).getContentType();
        localObject1 = new com.tencent.mm.as.a.d.b(e.r((InputStream)localObject1), (String)localObject2, (byte)0);
        continue;
        boolean bool = false;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
        return new com.tencent.mm.as.a.d.b(null, null, (byte)0);
      }
      label344:
      continue;
      label350:
      int i = 1;
      continue;
      label355:
      return localObject1;
      label358:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.f
 * JD-Core Version:    0.7.0.1
 */