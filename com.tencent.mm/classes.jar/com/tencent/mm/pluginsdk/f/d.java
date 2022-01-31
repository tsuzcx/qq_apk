package com.tencent.mm.pluginsdk.f;

import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  public static d rVJ = new d("default");
  private boolean lwA = false;
  private ConcurrentHashMap<String, Integer> rVG = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> rVH = new ConcurrentHashMap();
  private String rVI = "";
  
  public d(String paramString)
  {
    if (b.cqk()) {
      this.lwA = true;
    }
    this.rVI = paramString;
  }
  
  public final void Wd(String paramString)
  {
    if (!this.lwA) {}
    label156:
    label159:
    for (;;)
    {
      return;
      int i;
      if (this.rVG.containsKey(paramString))
      {
        i = ((Integer)this.rVG.get(paramString)).intValue();
        i += 1;
        this.rVG.put(paramString, Integer.valueOf(i));
        if (!this.rVH.containsKey(paramString)) {
          break label156;
        }
      }
      for (long l = ((Long)this.rVH.get(paramString)).longValue();; l = 0L)
      {
        if (System.currentTimeMillis() - l <= 1000L) {
          break label159;
        }
        new StringBuilder().append(this.rVI).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.rVG.put(paramString, Integer.valueOf(0));
        this.rVH.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.d
 * JD-Core Version:    0.7.0.1
 */