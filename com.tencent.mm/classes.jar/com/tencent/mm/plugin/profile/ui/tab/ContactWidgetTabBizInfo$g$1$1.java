package com.tencent.mm.plugin.profile.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
final class ContactWidgetTabBizInfo$g$1$1
  implements ay.b.a
{
  public static final 1 Bmy;
  
  static
  {
    AppMethodBeat.i(230674);
    Bmy = new 1();
    AppMethodBeat.o(230674);
  }
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(230673);
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(230673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.g.1.1
 * JD-Core Version:    0.7.0.1
 */