package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.XEffectLog.b;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectUtil;", "", "()V", "setupXLog", "", "plugin-xlabeffect_release"})
public final class d
{
  public static final d JRC;
  
  static
  {
    AppMethodBeat.i(215243);
    JRC = new d();
    AppMethodBeat.o(215243);
  }
  
  public static final void gls()
  {
    AppMethodBeat.i(215242);
    XEffectLog.a((XEffectLog.b)new a());
    AppMethodBeat.o(215242);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/xlabeffect/XLabEffectUtil$setupXLog$1", "Lcom/tencent/mm/xeffect/XEffectLog$ILog;", "d", "", "TAG", "", "format", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "plugin-xlabeffect_release"})
  public static final class a
    implements XEffectLog.b
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(215239);
      p.h(paramVarArgs, "args");
      Log.d(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(215239);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(215241);
      p.h(paramVarArgs, "args");
      Log.e(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(215241);
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(215240);
      p.h(paramVarArgs, "args");
      Log.i(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(215240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.d
 * JD-Core Version:    0.7.0.1
 */