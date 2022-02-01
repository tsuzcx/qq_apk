package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.d.a;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class a
  implements d.a
{
  public int mScene;
  public long xLI;
  public String xLJ;
  public String xLK;
  
  private JSONObject dFV()
  {
    AppMethodBeat.i(199990);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.xLI));
      localJSONObject.put("uxinfo", bs.bG(this.xLJ, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", bs.bG(this.xLK, ""));
      label70:
      AppMethodBeat.o(199990);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  public final String dFW()
  {
    return "timeline_ad_feedback_click_positive_btn";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(199991);
    String str = dFV().toString();
    AppMethodBeat.o(199991);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a
 * JD-Core Version:    0.7.0.1
 */