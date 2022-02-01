package com.tencent.mm.plugin.profile.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/BizProfileUtil;", "", "()V", "Companion", "app_release"})
public final class b
{
  public static final a BlS;
  
  static
  {
    AppMethodBeat.i(230665);
    BlS = new a((byte)0);
    AppMethodBeat.o(230665);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/BizProfileUtil$Companion;", "", "()V", "isBlack", "", "str", "", "app_release"})
  public static final class a
  {
    public static boolean aKA(String paramString)
    {
      AppMethodBeat.i(230664);
      paramString = (CharSequence)paramString;
      if ((paramString == null) || (n.aL(paramString)))
      {
        AppMethodBeat.o(230664);
        return true;
      }
      AppMethodBeat.o(230664);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.b
 * JD-Core Version:    0.7.0.1
 */