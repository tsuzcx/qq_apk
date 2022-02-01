package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;

public final class k
{
  public String dnn;
  public String dtx;
  public long enterTime;
  public String extra;
  public int fRQ;
  public int favCount;
  public int fnm;
  public String jYR;
  public int plW;
  public int qIy;
  public int qIz;
  public String xZE;
  public int yjY;
  public int yuU;
  public int yuV;
  public int yuW;
  public int yuX;
  public int yuY;
  public int yuZ;
  private String yva;
  public String yvb;
  public JSONArray yvc;
  
  public k()
  {
    AppMethodBeat.i(97392);
    this.extra = "";
    this.yvc = new JSONArray();
    AppMethodBeat.o(97392);
  }
  
  public final String dLP()
  {
    AppMethodBeat.i(97393);
    this.yva = this.yvc.toString();
    ac.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { this.yva });
    if (!bs.isNullOrNil(this.yva)) {}
    try
    {
      this.yva = URLEncoder.encode(this.yva, "UTF-8");
      long l1 = 0L;
      try
      {
        long l2 = q.atd(this.dnn);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          String str1;
          ac.e("AdLandingPagesReportInfo", "", new Object[] { localException });
          continue;
          String str2 = this.xZE;
        }
      }
      localStringBuilder = new StringBuilder().append(q.wW(l1)).append(",").append(this.dtx).append(",").append(this.fRQ).append(",").append(this.fnm).append(",").append(this.plW).append(",").append(this.yuU).append(",").append(this.yuV).append(",").append(this.yuW).append(",").append(this.yuX).append(",").append(this.yuY).append(",").append(this.yuZ).append(",").append(this.qIz).append(",").append(this.qIy).append(",").append(this.favCount).append(",").append(this.yva).append(",").append(this.enterTime).append(",").append(this.yvb).append(",");
      if (this.xZE == null)
      {
        str1 = "";
        str1 = str1 + "," + this.extra + "," + this.yjY + "," + this.jYR;
        AppMethodBeat.o(97393);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ac.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + localUnsupportedEncodingException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k
 * JD-Core Version:    0.7.0.1
 */