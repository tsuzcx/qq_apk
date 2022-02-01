package com.tencent.mm.plugin.profile.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/BizProfileUtil;", "", "()V", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a NcM;
  
  static
  {
    AppMethodBeat.i(305875);
    NcM = new a((byte)0);
    AppMethodBeat.o(305875);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/BizProfileUtil$Companion;", "", "()V", "isBlack", "", "str", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean aSf(String paramString)
    {
      AppMethodBeat.i(305895);
      paramString = (CharSequence)paramString;
      if ((paramString == null) || (n.bp(paramString)))
      {
        AppMethodBeat.o(305895);
        return true;
      }
      AppMethodBeat.o(305895);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.b
 * JD-Core Version:    0.7.0.1
 */