package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.r;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/jump/DemoSingleton;", "Lcom/tencent/mm/plugin/textstatus/jump/ITextStatusJumpSingleton;", "()V", "doJump", "", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "plugin-textstatus_release"})
public final class a
  implements b
{
  public final boolean F(String paramString, List<? extends r> paramList)
  {
    AppMethodBeat.i(258409);
    p.h(paramString, "textStatusID");
    p.h(paramList, "jumpInfos");
    paramString = ((Iterable)paramList).iterator();
    while (paramString.hasNext())
    {
      paramList = ((r)paramString.next()).GaO;
      if (paramList != null) {
        switch (paramList.hashCode())
        {
        default: 
          break;
        case 48: 
          paramList.equals("0");
        }
      }
    }
    AppMethodBeat.o(258409);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.a
 * JD-Core Version:    0.7.0.1
 */