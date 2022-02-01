package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/util/ExptSettingLogic;", "", "()V", "isInnerUser", "", "isRedOrPurple", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d agsY;
  
  static
  {
    AppMethodBeat.i(233993);
    agsY = new d();
    AppMethodBeat.o(233993);
  }
  
  public static boolean jJv()
  {
    AppMethodBeat.i(233987);
    if (!BuildInfo.DEBUG) {
      if ((!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label42;
      }
    }
    label42:
    for (int i = 1; (i != 0) || (WeChatEnvironment.hasDebugger()); i = 0)
    {
      AppMethodBeat.o(233987);
      return true;
    }
    AppMethodBeat.o(233987);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.d
 * JD-Core Version:    0.7.0.1
 */