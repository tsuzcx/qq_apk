package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.d.b;
import com.tencent.mm.videocomposition.d.b.a;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c XJQ;
  
  static
  {
    AppMethodBeat.i(261648);
    XJQ = new c();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(261648);
  }
  
  public static void fXr()
  {
    AppMethodBeat.i(261641);
    Logger.setLogProxy((ILog)new a());
    Logger.setLevel(2);
    b localb = b.agFH;
    b.a((b.a)new b());
    AppMethodBeat.o(261641);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/xlabeffect/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261633);
      Log.d(c.aUw() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(261633);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261628);
      Log.e(c.aUw() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(261628);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(261631);
      Log.printErrStackTrace(c.aUw() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(261631);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261621);
      Log.i(c.aUw() + ':' + paramString1, paramString2);
      AppMethodBeat.o(261621);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261626);
      Log.v(c.aUw() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(261626);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261624);
      Log.w(c.aUw() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(261624);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/xlabeffect/TAVKitLog$setUp$2", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.a
  {
    public final void boH(String paramString)
    {
      AppMethodBeat.i(261632);
      Log.w(c.aUw(), paramString);
      AppMethodBeat.o(261632);
    }
    
    public final int getLogLevel()
    {
      return 0;
    }
    
    public final void oU(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261623);
      Log.d(c.aUw() + ':' + paramString1, paramString2);
      AppMethodBeat.o(261623);
    }
    
    public final void oV(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261625);
      Log.e(c.aUw() + ':' + paramString1, paramString2);
      AppMethodBeat.o(261625);
    }
    
    public final void oW(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261627);
      Log.i(c.aUw() + ':' + paramString1, paramString2);
      AppMethodBeat.o(261627);
    }
    
    public final void oX(String paramString1, String paramString2)
    {
      AppMethodBeat.i(261630);
      Log.v(c.aUw() + ':' + paramString1, paramString2);
      AppMethodBeat.o(261630);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.c
 * JD-Core Version:    0.7.0.1
 */