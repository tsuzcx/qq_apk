package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  public String bRV;
  public long diQ;
  public int dip;
  public String extra = "";
  public String ggA;
  public int jYM;
  public int jYN;
  public int kEd;
  public int oDu;
  public int oKO;
  public int oKP;
  public int oKQ;
  public int oKR;
  public int oKS;
  public int oKT;
  public int oKU;
  public int oKV;
  public String oKW;
  public String oKX;
  public String ovV;
  public String ovY;
  
  public final String bFW()
  {
    long l1 = 0L;
    try
    {
      long l2 = i.Ng(this.bRV);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        String str1;
        y.e("AdLandingPagesReportInfo", "", new Object[] { localException });
        continue;
        String str2 = this.ovY;
      }
    }
    localStringBuilder = new StringBuilder().append(i.fN(l1)).append(",").append(this.ovV).append(",").append(this.oKO).append(",").append(this.dip).append(",").append(this.oKP).append(",").append(this.oKQ).append(",").append(this.oKR).append(",").append(this.oKS).append(",").append(this.oKT).append(",").append(this.oKU).append(",").append(this.oKV).append(",").append(this.jYN).append(",").append(this.jYM).append(",").append(this.kEd).append(",").append(this.oKW).append(",").append(this.diQ).append(",").append(this.oKX).append(",");
    if (this.ovY == null)
    {
      str1 = "";
      return str1 + "," + this.extra + "," + this.oDu + "," + this.ggA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k
 * JD-Core Version:    0.7.0.1
 */