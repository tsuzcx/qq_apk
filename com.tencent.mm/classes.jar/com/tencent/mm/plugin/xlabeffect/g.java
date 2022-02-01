package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.XEffectLog.b;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectUtil;", "", "()V", "setupXLog", "", "plugin-xlabeffect_release"})
public final class g
{
  public static final g QQD;
  
  static
  {
    AppMethodBeat.i(187033);
    QQD = new g();
    AppMethodBeat.o(187033);
  }
  
  public static final void hfh()
  {
    AppMethodBeat.i(187027);
    XEffectLog.a((XEffectLog.b)new a());
    AppMethodBeat.o(187027);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/xlabeffect/XLabEffectUtil$setupXLog$1", "Lcom/tencent/mm/xeffect/XEffectLog$ILog;", "d", "", "TAG", "", "format", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "plugin-xlabeffect_release"})
  public static final class a
    implements XEffectLog.b
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(186911);
      p.k(paramVarArgs, "args");
      Log.d(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(186911);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(186914);
      p.k(paramVarArgs, "args");
      Log.e(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(186914);
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(186912);
      p.k(paramVarArgs, "args");
      Log.i(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(186912);
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(186913);
      p.k(paramVarArgs, "args");
      Log.w(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(186913);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.g
 * JD-Core Version:    0.7.0.1
 */