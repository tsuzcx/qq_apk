package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/util/ExptSettingLogic;", "", "()V", "isInnerUser", "", "isRedOrPurple", "libcompatible_release"})
public final class d
{
  public static final d YyA;
  
  static
  {
    AppMethodBeat.i(261312);
    YyA = new d();
    AppMethodBeat.o(261312);
  }
  
  public static boolean ien()
  {
    AppMethodBeat.i(261308);
    if (!BuildInfo.DEBUG) {
      if ((!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label42;
      }
    }
    label42:
    for (int i = 1; (i != 0) || (WeChatEnvironment.hasDebugger()); i = 0)
    {
      AppMethodBeat.o(261308);
      return true;
    }
    AppMethodBeat.o(261308);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.d
 * JD-Core Version:    0.7.0.1
 */