package com.tencent.mm.plugin.sns.ad.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.i.b;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
  extends i.b
{
  private String adExtInfo;
  private String dRS;
  private String finderLiveNoticeId;
  private String finderUsername;
  private int result;
  private int source;
  private String uxInfo;
  
  public final void bn(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(201860);
    try
    {
      paramJSONObject.putOpt("snsid", this.dRS);
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      AppMethodBeat.o(201860);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(201860);
    }
  }
  
  public final void bo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(201861);
    try
    {
      paramJSONObject.putOpt("finderUsername", this.finderUsername);
      paramJSONObject.putOpt("finderLiveNoticeId", this.finderLiveNoticeId);
      paramJSONObject.putOpt("result", Integer.valueOf(this.result));
      paramJSONObject.putOpt("source", Integer.valueOf(this.source));
      AppMethodBeat.o(201861);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(201861);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201859);
    this.dRS = Util.nullAsNil(paramString1);
    this.uxInfo = Util.nullAsNil(paramString2);
    this.adExtInfo = Util.nullAsNil(paramString3);
    this.finderUsername = Util.nullAsNil(paramString4);
    this.finderLiveNoticeId = Util.nullAsNil(paramString5);
    this.result = paramInt1;
    this.source = paramInt2;
    AppMethodBeat.o(201859);
  }
  
  public final String eWH()
  {
    return "sns_ad_finder_live_notice_reserve";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a
 * JD-Core Version:    0.7.0.1
 */