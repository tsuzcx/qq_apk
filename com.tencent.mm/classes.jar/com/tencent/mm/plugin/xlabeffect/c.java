package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.c.b.a;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/xlabeffect/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "plugin-xlabeffect_release"})
public final class c
{
  public static final c QPp;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(186995);
    QPp = new c();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(186995);
  }
  
  public static void eON()
  {
    AppMethodBeat.i(186990);
    Logger.setLogProxy((ILog)new a());
    Logger.setLevel(2);
    b localb = b.YJP;
    b.a((b.a)new b());
    AppMethodBeat.o(186990);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/xlabeffect/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "plugin-xlabeffect_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187231);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.d(c.heW() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(187231);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187227);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.e(c.heW() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(187227);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(187230);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.printErrStackTrace(c.heW() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(187230);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187221);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.i(c.heW() + ':' + paramString1, paramString2);
      AppMethodBeat.o(187221);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187226);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.v(c.heW() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(187226);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187223);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.w(c.heW() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(187223);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/xlabeffect/TAVKitLog$setUp$2", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "plugin-xlabeffect_release"})
  public static final class b
    implements b.a
  {
    public final void boR(String paramString)
    {
      AppMethodBeat.i(186973);
      c localc = c.QPp;
      Log.w(c.heW(), paramString);
      AppMethodBeat.o(186973);
    }
    
    public final void mZ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186965);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.d(c.heW() + ':' + paramString1, paramString2);
      AppMethodBeat.o(186965);
    }
    
    public final void na(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186969);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.e(c.heW() + ':' + paramString1, paramString2);
      AppMethodBeat.o(186969);
    }
    
    public final void nb(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186971);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.i(c.heW() + ':' + paramString1, paramString2);
      AppMethodBeat.o(186971);
    }
    
    public final void nc(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186972);
      StringBuilder localStringBuilder = new StringBuilder();
      c localc = c.QPp;
      Log.v(c.heW() + ':' + paramString1, paramString2);
      AppMethodBeat.o(186972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.c
 * JD-Core Version:    0.7.0.1
 */