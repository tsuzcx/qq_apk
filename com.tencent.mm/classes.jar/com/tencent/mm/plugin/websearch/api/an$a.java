package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.y;

public final class an$a
{
  public String bVO;
  public int clear;
  public long eud = System.currentTimeMillis();
  public String id;
  public long lSJ;
  public int qTU;
  public int qUS;
  public int qUT;
  public int qUU;
  int qUV;
  public String text;
  public long timestamp;
  public int type;
  
  public final boolean isValid()
  {
    if (this.clear == 1) {
      return false;
    }
    if (this.qUT > d.spa)
    {
      y.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.qUT), Integer.valueOf(d.spa) });
      return false;
    }
    if (System.currentTimeMillis() > this.eud + this.lSJ * 1000L) {}
    for (int i = 1; i != 0; i = 0)
    {
      y.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
      return false;
    }
    String str = this.qUS + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
    if (aa.Bs(0) >= this.qTU) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.qTU), Integer.valueOf(aa.Bs(0)), Long.valueOf(this.timestamp), Long.valueOf(an.bZL()) });
      if ((aa.Bs(0) < this.qTU) || (this.timestamp <= an.bZL())) {
        break;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.an.a
 * JD-Core Version:    0.7.0.1
 */