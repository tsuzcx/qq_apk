package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.j.a;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
  implements j.a
{
  public long PZu;
  public String PZv;
  public String PZw;
  public int mScene;
  
  private JSONObject hbM()
  {
    AppMethodBeat.i(310987);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("snsid", String.valueOf(this.PZu));
      localJSONObject.put("uxinfo", Util.nullAs(this.PZv, ""));
      localJSONObject.put("scene", this.mScene);
      localJSONObject.put("adExtInfo", Util.nullAs(this.PZw, ""));
      label70:
      AppMethodBeat.o(310987);
      return localJSONObject;
    }
    finally
    {
      break label70;
    }
  }
  
  public final String gZE()
  {
    return "timeline_ad_feedback_click_positive_btn";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(310996);
    String str = hbM().toString();
    AppMethodBeat.o(310996);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a
 * JD-Core Version:    0.7.0.1
 */