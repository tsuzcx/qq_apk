package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.g.a;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class a
  implements g.a
{
  public int mScene;
  public long zaX;
  public String zaY;
  public String zaZ;
  
  private JSONObject dRP()
  {
    AppMethodBeat.i(197636);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.zaX));
      localJSONObject.put("uxinfo", bt.bI(this.zaY, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", bt.bI(this.zaZ, ""));
      label70:
      AppMethodBeat.o(197636);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
  
  public final String dRQ()
  {
    return "timeline_ad_feedback_click_positive_btn";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(197637);
    String str = dRP().toString();
    AppMethodBeat.o(197637);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a
 * JD-Core Version:    0.7.0.1
 */