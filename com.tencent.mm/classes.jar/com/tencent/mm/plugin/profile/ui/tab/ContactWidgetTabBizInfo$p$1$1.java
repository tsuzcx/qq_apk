package com.tencent.mm.plugin.profile.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
final class ContactWidgetTabBizInfo$p$1$1
  implements az.b.a
{
  public static final 1 HgS;
  
  static
  {
    AppMethodBeat.i(203578);
    HgS = new 1();
    AppMethodBeat.o(203578);
  }
  
  public final void s(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203575);
    Log.i("MicroMsg.ContactWidgetTabBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(203575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.p.1.1
 * JD-Core Version:    0.7.0.1
 */