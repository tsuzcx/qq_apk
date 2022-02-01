package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.decoder.logger.ILog;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "v", "msg", "w", "plugin-vlog_release"})
public final class o$a
  implements ILog
{
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207558);
    StringBuilder localStringBuilder = new StringBuilder();
    o localo = o.AnM;
    ac.d(o.efx() + ':' + paramString1, String.valueOf(paramString2));
    AppMethodBeat.o(207558);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207555);
    StringBuilder localStringBuilder = new StringBuilder();
    o localo = o.AnM;
    ac.e(o.efx() + ':' + paramString1, String.valueOf(paramString2));
    AppMethodBeat.o(207555);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(207557);
    StringBuilder localStringBuilder = new StringBuilder();
    o localo = o.AnM;
    ac.printErrStackTrace(o.efx() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
    AppMethodBeat.o(207557);
  }
  
  public final void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(207556);
    StringBuilder localStringBuilder = new StringBuilder();
    o localo = o.AnM;
    ac.printErrStackTrace(o.efx() + ':' + paramString, paramThrowable, "", new Object[0]);
    AppMethodBeat.o(207556);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(207552);
    k.h(paramVarArgs, "args");
    Object localObject = new StringBuilder();
    o localo = o.AnM;
    localObject = o.efx() + ':' + paramString1;
    paramString1 = z.KUT;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = String.format(paramString1, Arrays.copyOf(new Object[] { paramVarArgs }, 1));
    k.g(paramString1, "java.lang.String.format(format, *args)");
    ac.i((String)localObject, paramString1);
    AppMethodBeat.o(207552);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207554);
    StringBuilder localStringBuilder = new StringBuilder();
    o localo = o.AnM;
    ac.v(o.efx() + ':' + paramString1, String.valueOf(paramString2));
    AppMethodBeat.o(207554);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207553);
    StringBuilder localStringBuilder = new StringBuilder();
    o localo = o.AnM;
    ac.w(o.efx() + ':' + paramString1, String.valueOf(paramString2));
    AppMethodBeat.o(207553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.o.a
 * JD-Core Version:    0.7.0.1
 */