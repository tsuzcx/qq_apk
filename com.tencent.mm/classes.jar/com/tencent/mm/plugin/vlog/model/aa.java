package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.c.b.a;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "plugin-vlog_release"})
public final class aa
{
  public static final aa Gzi;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(190657);
    Gzi = new aa();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(190657);
  }
  
  public static void efp()
  {
    AppMethodBeat.i(190656);
    Logger.setLogProxy((ILog)new a());
    Logger.setLevel(2);
    Logger.setLevel(2);
    Logger.setLevel(2);
    b localb = b.Rii;
    b.a((b.a)new b());
    AppMethodBeat.o(190656);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "plugin-vlog_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190650);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.d(aa.fBx() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(190650);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190648);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.e(aa.fBx() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(190648);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(190649);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.printErrStackTrace(aa.fBx() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(190649);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190645);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.i(aa.fBx() + ':' + paramString1, paramString2);
      AppMethodBeat.o(190645);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190647);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.v(aa.fBx() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(190647);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190646);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.w(aa.fBx() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(190646);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$2", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "plugin-vlog_release"})
  public static final class b
    implements b.a
  {
    public final void aTZ(String paramString)
    {
      AppMethodBeat.i(190655);
      aa localaa = aa.Gzi;
      Log.w(aa.fBx(), paramString);
      AppMethodBeat.o(190655);
    }
    
    public final void lh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190651);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.d(aa.fBx() + ':' + paramString1, paramString2);
      AppMethodBeat.o(190651);
    }
    
    public final void li(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190652);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.e(aa.fBx() + ':' + paramString1, paramString2);
      AppMethodBeat.o(190652);
    }
    
    public final void lj(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190653);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.i(aa.fBx() + ':' + paramString1, paramString2);
      AppMethodBeat.o(190653);
    }
    
    public final void lk(String paramString1, String paramString2)
    {
      AppMethodBeat.i(190654);
      StringBuilder localStringBuilder = new StringBuilder();
      aa localaa = aa.Gzi;
      Log.v(aa.fBx() + ':' + paramString1, paramString2);
      AppMethodBeat.o(190654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.aa
 * JD-Core Version:    0.7.0.1
 */