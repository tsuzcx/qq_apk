package com.tencent.mm.plugin.wepkg;

import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class a$2
  extends InputStream
{
  private InputStream aQO = null;
  
  a$2(String paramString) {}
  
  public final int read()
  {
    if (this.aQO == null)
    {
      y.i("MicroMsg.CommJsLoader", "read from network");
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.rBr).openConnection();
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setReadTimeout(5000);
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setInstanceFollowRedirects(true);
      int i = localHttpURLConnection.getResponseCode();
      y.i("MicroMsg.CommJsLoader", "read status code = " + i);
      this.aQO = localHttpURLConnection.getInputStream();
    }
    if (this.aQO != null) {
      return this.aQO.read();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.a.2
 * JD-Core Version:    0.7.0.1
 */