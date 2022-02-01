package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;

public final class k
{
  public int Adp;
  public int Adq;
  public int Adr;
  public int Ads;
  public int Adt;
  public int Adu;
  private String Adv;
  public String Adw;
  public JSONArray Adx;
  public String dAg;
  public String dGD;
  public long enterTime;
  public String extra;
  public int fHy;
  public int favCount;
  public int gnM;
  public String kwD;
  public int pWb;
  public int rAM;
  public int rAN;
  public String zGS;
  public int zRN;
  
  public k()
  {
    AppMethodBeat.i(97392);
    this.extra = "";
    this.Adx = new JSONArray();
    AppMethodBeat.o(97392);
  }
  
  public final String ebJ()
  {
    AppMethodBeat.i(97393);
    this.Adv = this.Adx.toString();
    ae.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { this.Adv });
    if (!bu.isNullOrNil(this.Adv)) {}
    try
    {
      this.Adv = URLEncoder.encode(this.Adv, "UTF-8");
      long l1 = 0L;
      try
      {
        long l2 = r.azz(this.dAg);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          String str1;
          ae.e("AdLandingPagesReportInfo", "", new Object[] { localException });
          continue;
          String str2 = this.zGS;
        }
      }
      localStringBuilder = new StringBuilder().append(r.zV(l1)).append(",").append(this.dGD).append(",").append(this.gnM).append(",").append(this.fHy).append(",").append(this.pWb).append(",").append(this.Adp).append(",").append(this.Adq).append(",").append(this.Adr).append(",").append(this.Ads).append(",").append(this.Adt).append(",").append(this.Adu).append(",").append(this.rAN).append(",").append(this.rAM).append(",").append(this.favCount).append(",").append(this.Adv).append(",").append(this.enterTime).append(",").append(this.Adw).append(",");
      if (this.zGS == null)
      {
        str1 = "";
        str1 = str1 + "," + this.extra + "," + this.zRN + "," + this.kwD;
        AppMethodBeat.o(97393);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + localUnsupportedEncodingException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k
 * JD-Core Version:    0.7.0.1
 */