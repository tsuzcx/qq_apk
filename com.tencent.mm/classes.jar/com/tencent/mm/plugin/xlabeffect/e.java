package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.e.b;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectUtil;", "", "()V", "setupXLog", "", "plugin-xlabeffect_release"})
public final class e
{
  public static final e Oeg;
  
  static
  {
    AppMethodBeat.i(221617);
    Oeg = new e();
    AppMethodBeat.o(221617);
  }
  
  public static final void ftw()
  {
    AppMethodBeat.i(221616);
    XEffectLog.a((e.b)new a());
    AppMethodBeat.o(221616);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/xlabeffect/XLabEffectUtil$setupXLog$1", "Lcom/tencent/mm/xeffect/XEffectLog$ILog;", "d", "", "TAG", "", "format", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "plugin-xlabeffect_release"})
  public static final class a
    implements e.b
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(221614);
      p.h(paramVarArgs, "args");
      ad.d(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(221614);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(221615);
      p.h(paramVarArgs, "args");
      ad.e(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(221615);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.e
 * JD-Core Version:    0.7.0.1
 */