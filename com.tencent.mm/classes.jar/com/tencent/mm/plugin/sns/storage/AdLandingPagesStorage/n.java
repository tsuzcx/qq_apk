package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;

public final class n
{
  public int AcD;
  public int AcE;
  public String QBF;
  public int QLu;
  public int QXL;
  public int QXM;
  public int QXN;
  public int QXO;
  public int QXP;
  public int QXQ;
  private String QXR;
  public String QXS;
  public JSONArray QXT;
  public long enterTime;
  public String extra;
  public int favCount;
  public String hQX;
  public int lsO;
  public int miZ;
  public String rzx;
  public String uxInfo;
  public int xYX;
  
  public n()
  {
    AppMethodBeat.i(97392);
    this.extra = "";
    this.QXT = new JSONArray();
    AppMethodBeat.o(97392);
  }
  
  public final String hkE()
  {
    AppMethodBeat.i(97393);
    this.QXR = this.QXT.toString();
    Log.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[] { this.QXR });
    if (!Util.isNullOrNil(this.QXR)) {}
    try
    {
      this.QXR = URLEncoder.encode(this.QXR, "UTF-8");
      long l1 = 0L;
      try
      {
        long l2 = t.aXD(this.hQX);
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
          String str2 = this.QBF;
        }
      }
      localStringBuilder = new StringBuilder().append(t.uA(l1)).append(",").append(this.uxInfo).append(",").append(this.miZ).append(",").append(this.lsO).append(",").append(this.xYX).append(",").append(this.QXL).append(",").append(this.QXM).append(",").append(this.QXN).append(",").append(this.QXO).append(",").append(this.QXP).append(",").append(this.QXQ).append(",").append(this.AcE).append(",").append(this.AcD).append(",").append(this.favCount).append(",").append(this.QXR).append(",").append(this.enterTime).append(",").append(this.QXS).append(",");
      if (this.QBF == null)
      {
        str1 = "";
        str1 = str1 + "," + this.extra + "," + this.QLu + "," + this.rzx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.n
 * JD-Core Version:    0.7.0.1
 */