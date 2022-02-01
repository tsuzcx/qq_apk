package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;

public final class k
{
  public String DQS;
  public int DZU;
  public int ElM;
  public int ElN;
  public int ElO;
  public int ElP;
  public int ElQ;
  public int ElR;
  private String ElS;
  public String ElT;
  public JSONArray ElU;
  public String dRS;
  public long enterTime;
  public String extra;
  public int favCount;
  public int gYH;
  public int gmJ;
  public String lAN;
  public int rna;
  public int tar;
  public int tas;
  public String uxInfo;
  
  public k()
  {
    AppMethodBeat.i(97392);
    this.extra = "";
    this.ElU = new JSONArray();
    AppMethodBeat.o(97392);
  }
  
  public final String feA()
  {
    AppMethodBeat.i(97393);
    this.ElS = this.ElU.toString();
    Log.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { this.ElS });
    if (!Util.isNullOrNil(this.ElS)) {}
    try
    {
      this.ElS = URLEncoder.encode(this.ElS, "UTF-8");
      long l1 = 0L;
      try
      {
        long l2 = r.aOw(this.dRS);
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
          String str2 = this.DQS;
        }
      }
      localStringBuilder = new StringBuilder().append(r.Jb(l1)).append(",").append(this.uxInfo).append(",").append(this.gYH).append(",").append(this.gmJ).append(",").append(this.rna).append(",").append(this.ElM).append(",").append(this.ElN).append(",").append(this.ElO).append(",").append(this.ElP).append(",").append(this.ElQ).append(",").append(this.ElR).append(",").append(this.tas).append(",").append(this.tar).append(",").append(this.favCount).append(",").append(this.ElS).append(",").append(this.enterTime).append(",").append(this.ElT).append(",");
      if (this.DQS == null)
      {
        str1 = "";
        str1 = str1 + "," + this.extra + "," + this.DZU + "," + this.lAN;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k
 * JD-Core Version:    0.7.0.1
 */