package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.XEffectLog.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectUtil;", "", "()V", "setupXLog", "", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m XMr;
  
  static
  {
    AppMethodBeat.i(261642);
    XMr = new m();
    AppMethodBeat.o(261642);
  }
  
  public static final void iGg()
  {
    AppMethodBeat.i(261639);
    XEffectLog.a((XEffectLog.b)new a());
    AppMethodBeat.o(261639);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/xlabeffect/XLabEffectUtil$setupXLog$1", "Lcom/tencent/mm/xeffect/XEffectLog$ILog;", "d", "", "TAG", "", "format", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements XEffectLog.b
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(261602);
      s.u(paramVarArgs, "args");
      Log.d(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(261602);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(261607);
      s.u(paramVarArgs, "args");
      Log.e(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(261607);
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(261603);
      s.u(paramVarArgs, "args");
      Log.i(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(261603);
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(261604);
      s.u(paramVarArgs, "args");
      Log.w(paramString1, paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(261604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.m
 * JD-Core Version:    0.7.0.1
 */