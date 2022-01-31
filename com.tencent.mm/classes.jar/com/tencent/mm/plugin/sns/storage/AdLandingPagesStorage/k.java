package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;

public final class k
{
  public String cFe;
  public String czw;
  public int dZJ;
  public long eaj;
  public String extra;
  public String hyW;
  public int lsc;
  public int mtf;
  public int mtg;
  public int nan;
  public int rCA;
  public int rCB;
  public int rCC;
  public int rCD;
  public int rCE;
  public int rCF;
  private String rCG;
  public String rCH;
  public JSONArray rCI;
  public int rCz;
  public String rkS;
  public int rtf;
  
  public k()
  {
    AppMethodBeat.i(37782);
    this.extra = "";
    this.rCI = new JSONArray();
    AppMethodBeat.o(37782);
  }
  
  public final String crZ()
  {
    AppMethodBeat.i(37783);
    this.rCG = this.rCI.toString();
    ab.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { this.rCG });
    if (!bo.isNullOrNil(this.rCG)) {}
    try
    {
      this.rCG = URLEncoder.encode(this.rCG, "UTF-8");
      long l1 = 0L;
      try
      {
        long l2 = i.ZN(this.czw);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          String str1;
          ab.e("AdLandingPagesReportInfo", "", new Object[] { localException });
          continue;
          String str2 = this.rkS;
        }
      }
      localStringBuilder = new StringBuilder().append(i.lq(l1)).append(",").append(this.cFe).append(",").append(this.rCz).append(",").append(this.dZJ).append(",").append(this.lsc).append(",").append(this.rCA).append(",").append(this.rCB).append(",").append(this.rCC).append(",").append(this.rCD).append(",").append(this.rCE).append(",").append(this.rCF).append(",").append(this.mtg).append(",").append(this.mtf).append(",").append(this.nan).append(",").append(this.rCG).append(",").append(this.eaj).append(",").append(this.rCH).append(",");
      if (this.rkS == null)
      {
        str1 = "";
        str1 = str1 + "," + this.extra + "," + this.rtf + "," + this.hyW;
        AppMethodBeat.o(37783);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + localUnsupportedEncodingException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k
 * JD-Core Version:    0.7.0.1
 */