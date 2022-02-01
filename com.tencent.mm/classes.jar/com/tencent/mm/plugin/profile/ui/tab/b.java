package com.tencent.mm.plugin.profile.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/BizProfileUtil;", "", "()V", "Companion", "app_release"})
public final class b
{
  public static final a Hgd;
  
  static
  {
    AppMethodBeat.i(269556);
    Hgd = new a((byte)0);
    AppMethodBeat.o(269556);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/BizProfileUtil$Companion;", "", "()V", "isBlack", "", "str", "", "app_release"})
  public static final class a
  {
    public static boolean aUY(String paramString)
    {
      AppMethodBeat.i(274828);
      paramString = (CharSequence)paramString;
      if ((paramString == null) || (n.ba(paramString)))
      {
        AppMethodBeat.o(274828);
        return true;
      }
      AppMethodBeat.o(274828);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.b
 * JD-Core Version:    0.7.0.1
 */