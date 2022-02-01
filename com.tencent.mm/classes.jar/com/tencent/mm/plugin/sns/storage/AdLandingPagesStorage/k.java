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
  public String dpC;
  public String dvK;
  public long enterTime;
  public String extra;
  public int fOf;
  public int favCount;
  public int fjS;
  public String jyu;
  public int oIw;
  public int pZR;
  public int pZS;
  public String wMY;
  public int wXj;
  public int xig;
  public int xih;
  public int xii;
  public int xij;
  public int xik;
  public int xil;
  private String xim;
  public String xin;
  public JSONArray xio;
  
  public k()
  {
    AppMethodBeat.i(97392);
    this.extra = "";
    this.xio = new JSONArray();
    AppMethodBeat.o(97392);
  }
  
  public final String dxq()
  {
    AppMethodBeat.i(97393);
    this.xim = this.xio.toString();
    ad.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { this.xim });
    if (!bt.isNullOrNil(this.xim)) {}
    try
    {
      this.xim = URLEncoder.encode(this.xim, "UTF-8");
      long l1 = 0L;
      try
      {
        long l2 = q.anR(this.dpC);
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
          String str2 = this.wMY;
        }
      }
      localStringBuilder = new StringBuilder().append(q.st(l1)).append(",").append(this.dvK).append(",").append(this.fOf).append(",").append(this.fjS).append(",").append(this.oIw).append(",").append(this.xig).append(",").append(this.xih).append(",").append(this.xii).append(",").append(this.xij).append(",").append(this.xik).append(",").append(this.xil).append(",").append(this.pZS).append(",").append(this.pZR).append(",").append(this.favCount).append(",").append(this.xim).append(",").append(this.enterTime).append(",").append(this.xin).append(",");
      if (this.wMY == null)
      {
        str1 = "";
        str1 = str1 + "," + this.extra + "," + this.wXj + "," + this.jyu;
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