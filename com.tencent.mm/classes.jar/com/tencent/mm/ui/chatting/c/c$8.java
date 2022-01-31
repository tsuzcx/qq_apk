package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class c$8
  implements ChatFooter.e
{
  c$8(c paramc) {}
  
  public final boolean pu(boolean paramBoolean)
  {
    AppMethodBeat.i(31199);
    if (c.c(this.zEm) == null)
    {
      AppMethodBeat.o(31199);
      return false;
    }
    Object localObject = c.c(this.zEm).cU(false);
    if (localObject == null)
    {
      AppMethodBeat.o(31199);
      return false;
    }
    localObject = ((d.b)localObject).aeF();
    if ((localObject == null) || (((d.b.c)localObject).fvL == null) || (((d.b.c)localObject).fvL.isEmpty()))
    {
      AppMethodBeat.o(31199);
      return false;
    }
    localObject = (com.tencent.mm.aj.j)((d.b.c)localObject).fvL.get(0);
    try
    {
      localObject = new JSONObject(((com.tencent.mm.aj.j)localObject).value);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1083;
      localAppBrandStatObject.cmF = c.c(this.zEm).field_username;
      ((com.tencent.mm.plugin.appbrand.service.j)g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(this.zEm.caz.zJz.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, c.c(this.zEm).field_appId);
      AppMethodBeat.o(31199);
      return true;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(31199);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.8
 * JD-Core Version:    0.7.0.1
 */