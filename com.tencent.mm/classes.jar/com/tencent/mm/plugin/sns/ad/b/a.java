package com.tencent.mm.plugin.sns.ad.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.j.b;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
  extends j.b
{
  private String PLN;
  private String adExtInfo;
  private String finderUsername;
  private String hQX;
  private int result;
  private int source;
  private String uxInfo;
  
  public final void bN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(309707);
    try
    {
      paramJSONObject.putOpt("snsid", this.hQX);
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      return;
    }
    finally
    {
      AppMethodBeat.o(309707);
    }
  }
  
  public final void bO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(309714);
    try
    {
      paramJSONObject.putOpt("finderUsername", this.finderUsername);
      paramJSONObject.putOpt("finderLiveNoticeId", this.PLN);
      paramJSONObject.putOpt("result", Integer.valueOf(this.result));
      paramJSONObject.putOpt("source", Integer.valueOf(this.source));
      return;
    }
    finally
    {
      AppMethodBeat.o(309714);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309692);
    this.hQX = Util.nullAsNil(paramString1);
    this.uxInfo = Util.nullAsNil(paramString2);
    this.adExtInfo = Util.nullAsNil(paramString3);
    this.finderUsername = Util.nullAsNil(paramString4);
    this.PLN = Util.nullAsNil(paramString5);
    this.result = paramInt1;
    this.source = paramInt2;
    AppMethodBeat.o(309692);
  }
  
  public final String gZE()
  {
    return "sns_ad_finder_live_notice_reserve";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.a
 * JD-Core Version:    0.7.0.1
 */