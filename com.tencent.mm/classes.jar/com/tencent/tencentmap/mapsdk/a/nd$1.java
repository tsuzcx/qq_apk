package com.tencent.tencentmap.mapsdk.a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

final class nd$1
  implements Runnable
{
  nd$1(w paramw, int paramInt) {}
  
  public final void run()
  {
    int i = -1;
    if (this.a != null) {
      i = this.a.b("worldTileCount");
    }
    if ((i <= 0) && (this.b <= 0)) {
      return;
    }
    if (i > 0) {
      i += this.b;
    }
    for (;;)
    {
      for (;;)
      {
        String str = "https://pr.map.qq.com/pingd?" + lq.a(i);
        try
        {
          int j = ((HttpURLConnection)new URL(str).openConnection()).getResponseCode();
          if (this.a == null) {
            break;
          }
          if (j != 200) {
            break label140;
          }
          this.a.a(new String[] { "worldTileCount" });
          return;
        }
        catch (IOException localIOException) {}
      }
      if (this.a == null) {
        break;
      }
      this.a.a("worldTileCount", i);
      return;
      i = this.b;
    }
    label140:
    this.a.a("worldTileCount", i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nd.1
 * JD-Core Version:    0.7.0.1
 */