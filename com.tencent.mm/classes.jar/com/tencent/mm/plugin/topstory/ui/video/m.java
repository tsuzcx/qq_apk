package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.ak.f;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byh;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class m
{
  b pEp;
  String pFR;
  Map<String, byh> pFS = Collections.synchronizedMap(new HashMap());
  Set<String> pFT = Collections.synchronizedSet(new HashSet());
  private int pFU = 0;
  
  static long N(long paramLong1, long paramLong2)
  {
    long l = 0L;
    if (paramLong2 != 0L) {
      l = 100L * paramLong1 / paramLong2;
    }
    return l;
  }
  
  public final void akT()
  {
    this.pFU -= 1;
    y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.pFU) });
    if (this.pFU <= 0)
    {
      bOo();
      this.pFT.clear();
      e.post(new m.b(this, this.pFR), "TopStory.DeleteVideoFolderTask");
      this.pEp = null;
    }
  }
  
  public final void bOo()
  {
    Iterator localIterator = this.pFT.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f.Nd().lM(str);
    }
  }
  
  public final void d(b paramb)
  {
    this.pFU += 1;
    y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", new Object[] { Integer.valueOf(this.pFU) });
    this.pEp = paramb;
    this.pFR = g.PJ(paramb.bNv().tNY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m
 * JD-Core Version:    0.7.0.1
 */