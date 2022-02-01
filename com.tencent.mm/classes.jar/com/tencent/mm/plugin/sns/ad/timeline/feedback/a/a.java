package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.j.a;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
  implements j.a
{
  public long JIs;
  public String JIt;
  public String JIu;
  public int mScene;
  
  private JSONObject fLu()
  {
    AppMethodBeat.i(207338);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.JIs));
      localJSONObject.put("uxinfo", Util.nullAs(this.JIt, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", Util.nullAs(this.JIu, ""));
      label70:
      AppMethodBeat.o(207338);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  public final String fJK()
  {
    return "timeline_ad_feedback_click_positive_btn";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(207339);
    String str = fLu().toString();
    AppMethodBeat.o(207339);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a
 * JD-Core Version:    0.7.0.1
 */