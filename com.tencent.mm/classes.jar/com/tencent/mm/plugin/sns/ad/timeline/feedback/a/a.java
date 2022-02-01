package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.g.a;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class a
  implements g.a
{
  public int mScene;
  public String zrA;
  public long zry;
  public String zrz;
  
  private JSONObject dVn()
  {
    AppMethodBeat.i(219102);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.zry));
      localJSONObject.put("uxinfo", bu.bI(this.zrz, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", bu.bI(this.zrA, ""));
      label70:
      AppMethodBeat.o(219102);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  public final String dVo()
  {
    return "timeline_ad_feedback_click_positive_btn";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(219103);
    String str = dVn().toString();
    AppMethodBeat.o(219103);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a
 * JD-Core Version:    0.7.0.1
 */