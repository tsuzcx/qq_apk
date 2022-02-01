package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;

public final class k
{
  public String KdZ;
  public int Knp;
  public int KyU;
  public int KyV;
  public int KyW;
  public int KyX;
  public int KyY;
  public int KyZ;
  private String Kza;
  public String Kzb;
  public JSONArray Kzc;
  public long enterTime;
  public String extra;
  public String fLp;
  public int favCount;
  public int iQS;
  public int jJH;
  public String owd;
  public int uQm;
  public String uxInfo;
  public int wGu;
  public int wGv;
  
  public k()
  {
    AppMethodBeat.i(97392);
    this.extra = "";
    this.Kzc = new JSONArray();
    AppMethodBeat.o(97392);
  }
  
  public final String fSu()
  {
    AppMethodBeat.i(97393);
    this.Kza = this.Kzc.toString();
    Log.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { this.Kza });
    if (!Util.isNullOrNil(this.Kza)) {}
    try
    {
      this.Kza = URLEncoder.encode(this.Kza, "UTF-8");
      long l1 = 0L;
      try
      {
        long l2 = t.aZs(this.fLp);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          String str1;
          Log.e("AdLandingPagesReportInfo", "", new Object[] { localException });
          continue;
          String str2 = this.KdZ;
        }
      }
      localStringBuilder = new StringBuilder().append(t.Qu(l1)).append(",").append(this.uxInfo).append(",").append(this.jJH).append(",").append(this.iQS).append(",").append(this.uQm).append(",").append(this.KyU).append(",").append(this.KyV).append(",").append(this.KyW).append(",").append(this.KyX).append(",").append(this.KyY).append(",").append(this.KyZ).append(",").append(this.wGv).append(",").append(this.wGu).append(",").append(this.favCount).append(",").append(this.Kza).append(",").append(this.enterTime).append(",").append(this.Kzb).append(",");
      if (this.KdZ == null)
      {
        str1 = "";
        str1 = str1 + "," + this.extra + "," + this.Knp + "," + this.owd;
        AppMethodBeat.o(97393);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + localUnsupportedEncodingException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k
 * JD-Core Version:    0.7.0.1
 */