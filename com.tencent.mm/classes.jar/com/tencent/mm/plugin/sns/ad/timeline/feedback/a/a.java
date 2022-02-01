package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.i.a;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
  implements i.a
{
  public String DyA;
  public String DyB;
  public long Dyz;
  public int mScene;
  
  private JSONObject eXR()
  {
    AppMethodBeat.i(202180);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.Dyz));
      localJSONObject.put("uxinfo", Util.nullAs(this.DyA, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", Util.nullAs(this.DyB, ""));
      label70:
      AppMethodBeat.o(202180);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  public final String eWH()
  {
    return "timeline_ad_feedback_click_positive_btn";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(202181);
    String str = eXR().toString();
    AppMethodBeat.o(202181);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a
 * JD-Core Version:    0.7.0.1
 */