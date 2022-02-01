package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;

public final class k
{
  public String dFy;
  public String dzb;
  public long enterTime;
  public String extra;
  public int fFu;
  public int favCount;
  public int glr;
  public String ktn;
  public int pPw;
  public int rsA;
  public int rsz;
  public int zAN;
  public int zMi;
  public int zMj;
  public int zMk;
  public int zMl;
  public int zMm;
  public int zMn;
  private String zMo;
  public String zMp;
  public JSONArray zMq;
  public String zpD;
  
  public k()
  {
    AppMethodBeat.i(97392);
    this.extra = "";
    this.zMq = new JSONArray();
    AppMethodBeat.o(97392);
  }
  
  public final String dYf()
  {
    AppMethodBeat.i(97393);
    this.zMo = this.zMq.toString();
    ad.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { this.zMo });
    if (!bt.isNullOrNil(this.zMo)) {}
    try
    {
      this.zMo = URLEncoder.encode(this.zMo, "UTF-8");
      long l1 = 0L;
      try
      {
        long l2 = q.ayi(this.dzb);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          String str1;
          ad.e("AdLandingPagesReportInfo", "", new Object[] { localException });
          continue;
          String str2 = this.zpD;
        }
      }
      localStringBuilder = new StringBuilder().append(q.zw(l1)).append(",").append(this.dFy).append(",").append(this.glr).append(",").append(this.fFu).append(",").append(this.pPw).append(",").append(this.zMi).append(",").append(this.zMj).append(",").append(this.zMk).append(",").append(this.zMl).append(",").append(this.zMm).append(",").append(this.zMn).append(",").append(this.rsA).append(",").append(this.rsz).append(",").append(this.favCount).append(",").append(this.zMo).append(",").append(this.enterTime).append(",").append(this.zMp).append(",");
      if (this.zpD == null)
      {
        str1 = "";
        str1 = str1 + "," + this.extra + "," + this.zAN + "," + this.ktn;
        AppMethodBeat.o(97393);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + localUnsupportedEncodingException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k
 * JD-Core Version:    0.7.0.1
 */