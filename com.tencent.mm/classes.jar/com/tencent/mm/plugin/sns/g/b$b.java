package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;

final class b$b
{
  String cFe;
  long qYx;
  StringBuffer rkP;
  long rkQ;
  long rkR;
  String rkS;
  String rkT;
  
  public b$b(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36762);
    this.rkP = new StringBuffer();
    this.cFe = paramString1;
    this.rkS = paramString2;
    this.rkT = paramString3;
    this.qYx = paramLong;
    this.rkQ = System.currentTimeMillis();
    this.rkP.append("0:0:");
    AppMethodBeat.o(36762);
  }
  
  public b$b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(36761);
    this.rkP = new StringBuffer();
    this.cFe = paramString1;
    this.rkS = paramString2;
    this.rkT = paramString3;
    this.qYx = paramLong;
    this.rkQ = System.currentTimeMillis();
    this.rkP.append("1:0:".concat(String.valueOf(paramString4)));
    AppMethodBeat.o(36761);
  }
  
  public final void IE()
  {
    AppMethodBeat.i(36766);
    this.rkR = System.currentTimeMillis();
    ab.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.qYx + " uxinfo:" + this.cFe + " actionresult: " + this.rkP + " " + this.rkQ + " " + this.rkR);
    h.qsU.e(11988, new Object[] { this.rkT, this.rkS, "", "", i.lq(this.qYx), this.cFe, this.rkP, Long.valueOf(this.rkQ / 1000L), Long.valueOf(this.rkR / 1000L) });
    AppMethodBeat.o(36766);
  }
  
  public final void aaZ(String paramString)
  {
    AppMethodBeat.i(36763);
    ab.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult ".concat(String.valueOf(paramString)));
    if (this.rkP.length() != 0) {
      this.rkP.append("|");
    }
    this.rkP.append(paramString);
    AppMethodBeat.o(36763);
  }
  
  public final boolean cpY()
  {
    AppMethodBeat.i(36764);
    if ((this.rkP == null) || (this.rkP.length() == 0))
    {
      AppMethodBeat.o(36764);
      return false;
    }
    if (this.rkP.toString().startsWith("1:0"))
    {
      AppMethodBeat.o(36764);
      return true;
    }
    AppMethodBeat.o(36764);
    return false;
  }
  
  public final boolean cpZ()
  {
    AppMethodBeat.i(36765);
    if ((this.rkP == null) || (this.rkP.length() == 0))
    {
      AppMethodBeat.o(36765);
      return false;
    }
    AppMethodBeat.o(36765);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.b.b
 * JD-Core Version:    0.7.0.1
 */