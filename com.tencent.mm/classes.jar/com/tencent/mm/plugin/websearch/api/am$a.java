package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class am$a
{
  public String cDz;
  public int clear;
  public long fJQ;
  public long ghy;
  public String id;
  public String text;
  public long timestamp;
  public int type;
  public int uJc;
  public int uKd;
  public int uKe;
  public int uKf;
  int uKg;
  
  public am$a()
  {
    AppMethodBeat.i(124206);
    this.fJQ = System.currentTimeMillis();
    AppMethodBeat.o(124206);
  }
  
  private boolean isExpired()
  {
    AppMethodBeat.i(151921);
    if (System.currentTimeMillis() > this.fJQ + this.ghy * 1000L)
    {
      AppMethodBeat.o(151921);
      return true;
    }
    AppMethodBeat.o(151921);
    return false;
  }
  
  final String aCR()
  {
    AppMethodBeat.i(124208);
    String str = this.id + "&" + this.uKd + "&" + this.uKe + "&" + this.ghy + "&" + this.uJc + "&" + this.type + "&" + this.text + "&" + this.cDz + "&" + this.timestamp + "&" + this.uKf + "&" + this.fJQ + "&" + this.uKg;
    AppMethodBeat.o(124208);
    return str;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(124207);
    if (this.clear == 1)
    {
      AppMethodBeat.o(124207);
      return false;
    }
    if (this.uKe > d.whH)
    {
      ab.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.uKe), Integer.valueOf(d.whH) });
      AppMethodBeat.o(124207);
      return false;
    }
    if (isExpired())
    {
      ab.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
      AppMethodBeat.o(124207);
      return false;
    }
    String str = this.uKd + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
    if (aa.Jf(0) >= this.uJc) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.uJc), Integer.valueOf(aa.Jf(0)), Long.valueOf(this.timestamp), Long.valueOf(am.cZG()) });
      if ((aa.Jf(0) < this.uJc) || (this.timestamp <= am.cZG())) {
        break;
      }
      AppMethodBeat.o(124207);
      return true;
    }
    AppMethodBeat.o(124207);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.am.a
 * JD-Core Version:    0.7.0.1
 */