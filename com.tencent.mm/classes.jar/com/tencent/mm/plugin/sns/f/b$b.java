package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.y;

final class b$b
{
  long okm;
  StringBuffer ovU = new StringBuffer();
  String ovV;
  long ovW;
  long ovX;
  String ovY;
  String ovZ;
  
  public b$b(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.ovV = paramString1;
    this.ovY = paramString2;
    this.ovZ = paramString3;
    this.okm = paramLong;
    this.ovW = System.currentTimeMillis();
    this.ovU.append("0:0:");
  }
  
  public b$b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.ovV = paramString1;
    this.ovY = paramString2;
    this.ovZ = paramString3;
    this.okm = paramLong;
    this.ovW = System.currentTimeMillis();
    this.ovU.append("1:0:" + paramString4);
  }
  
  public final void Of(String paramString)
  {
    y.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult " + paramString);
    if (this.ovU.length() != 0) {
      this.ovU.append("|");
    }
    this.ovU.append(paramString);
  }
  
  public final void wn()
  {
    this.ovX = System.currentTimeMillis();
    y.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.okm + " uxinfo:" + this.ovV + " actionresult: " + this.ovU + " " + this.ovW + " " + this.ovX);
    h.nFQ.f(11988, new Object[] { this.ovZ, this.ovY, "", "", i.fN(this.okm), this.ovV, this.ovU, Long.valueOf(this.ovW / 1000L), Long.valueOf(this.ovX / 1000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.b.b
 * JD-Core Version:    0.7.0.1
 */