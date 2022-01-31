package com.tencent.tencentmap.mapsdk.a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

final class uo$1
  implements Runnable
{
  uo$1(int paramInt) {}
  
  public final void run()
  {
    int i = -1;
    ua localua = ua.a();
    if (localua != null) {
      i = localua.b("worldTileCount");
    }
    if ((i <= 0) && (this.a <= 0)) {
      return;
    }
    if (i > 0) {
      i += this.a;
    }
    for (;;)
    {
      for (;;)
      {
        String str = "https://pr.map.qq.com/pingd?" + uo.a(i);
        try
        {
          int j = ((HttpURLConnection)new URL(str).openConnection()).getResponseCode();
          if (localua == null) {
            break;
          }
          if (j != 200) {
            break label129;
          }
          localua.a(new String[] { "worldTileCount" });
          return;
        }
        catch (IOException localIOException) {}
      }
      if (localua == null) {
        break;
      }
      localua.a("worldTileCount", i);
      return;
      i = this.a;
    }
    label129:
    localua.a("worldTileCount", i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uo.1
 * JD-Core Version:    0.7.0.1
 */