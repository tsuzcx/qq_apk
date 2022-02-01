package com.tencent.mm.plugin.sns.ad.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.j.b;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
  extends j.b
{
  private String JxY;
  private String adExtInfo;
  private String fLp;
  private String finderUsername;
  private int result;
  private int source;
  private String uxInfo;
  
  public final void bw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(270614);
    try
    {
      paramJSONObject.putOpt("snsid", this.fLp);
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      AppMethodBeat.o(270614);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(270614);
    }
  }
  
  public final void bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(270615);
    try
    {
      paramJSONObject.putOpt("finderUsername", this.finderUsername);
      paramJSONObject.putOpt("finderLiveNoticeId", this.JxY);
      paramJSONObject.putOpt("result", Integer.valueOf(this.result));
      paramJSONObject.putOpt("source", Integer.valueOf(this.source));
      AppMethodBeat.o(270615);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(270615);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270613);
    this.fLp = Util.nullAsNil(paramString1);
    this.uxInfo = Util.nullAsNil(paramString2);
    this.adExtInfo = Util.nullAsNil(paramString3);
    this.finderUsername = Util.nullAsNil(paramString4);
    this.JxY = Util.nullAsNil(paramString5);
    this.result = paramInt1;
    this.source = paramInt2;
    AppMethodBeat.o(270613);
  }
  
  public final String fJK()
  {
    return "sns_ad_finder_live_notice_reserve";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.a
 * JD-Core Version:    0.7.0.1
 */