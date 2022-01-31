package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.c;
import com.tencent.mm.ai.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class c$8
  implements ChatFooter.e
{
  c$8(c paramc) {}
  
  public final boolean me(boolean paramBoolean)
  {
    if (c.c(this.voK) == null) {
      return false;
    }
    Object localObject = c.c(this.voK).bS(false);
    if (localObject == null) {
      return false;
    }
    localObject = ((d.b)localObject).LY();
    if ((localObject == null) || (((d.b.c)localObject).efJ == null) || (((d.b.c)localObject).efJ.isEmpty())) {
      return false;
    }
    localObject = (j)((d.b.c)localObject).efJ.get(0);
    try
    {
      localObject = new JSONObject(((j)localObject).value);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1083;
      localAppBrandStatObject.bFv = c.c(this.voK).field_username;
      ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(this.voK.byx.vtz.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, c.c(this.voK).field_appId);
      return true;
    }
    catch (JSONException localJSONException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.8
 * JD-Core Version:    0.7.0.1
 */