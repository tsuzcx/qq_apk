package com.tencent.mm.plugin.topstory.ui.home;

import android.os.Build;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

final class b$2
  extends v
{
  b$2(b paramb) {}
  
  public final void xQ()
  {
    if (bk.bl(ac.Ru("discoverSearchEntry").optString("wording")))
    {
      y.e("MicroMsg.TopStory.TopStoryUIComponentImpl", "empty title");
      return;
    }
    ao.i("", 0, 0, 36);
    String str = aa.Bm(36);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("topStoryScene", String.valueOf(this.pEb.cbF.scene));
      localHashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("from", URLEncoder.encode(this.pEb.pDR.getString(b.g.top_story_assistor), "utf8"));
      g.DN();
      localHashMap.put("uin", a.CL());
      localHashMap.put("timeZone", URLEncoder.encode(bk.crV(), "utf8"));
      localHashMap.put("ostype", d.soW);
      label189:
      ((j)g.r(j.class)).a(this.pEb.pDR, "", str, localHashMap);
      f.nEG.f(15449, new Object[] { Integer.valueOf(0) });
      return;
    }
    catch (Exception localException)
    {
      break label189;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.2
 * JD-Core Version:    0.7.0.1
 */