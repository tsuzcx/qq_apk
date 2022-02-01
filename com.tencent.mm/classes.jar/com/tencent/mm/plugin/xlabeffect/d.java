package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.XEffectLog.b;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectUtil;", "", "()V", "setupXLog", "", "plugin-xlabeffect_release"})
public final class d
{
  public static final d FaI;
  
  static
  {
    AppMethodBeat.i(218384);
    FaI = new d();
    AppMethodBeat.o(218384);
  }
  
  public static final void fcj()
  {
    AppMethodBeat.i(218383);
    XEffectLog.a((XEffectLog.b)new a());
    AppMethodBeat.o(218383);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/xlabeffect/XLabEffectUtil$setupXLog$1", "Lcom/tencent/mm/xeffect/XEffectLog$ILog;", "d", "", "TAG", "", "format", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "plugin-xlabeffect_release"})
  public static final class a
    implements XEffectLog.b
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(218381);
      p.h(paramVarArgs, "args");
      ae.d(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(218381);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(218382);
      p.h(paramVarArgs, "args");
      ae.e(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(218382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.d
 * JD-Core Version:    0.7.0.1
 */