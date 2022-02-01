package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.c.b.a;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "plugin-vlog_release"})
public final class t
{
  public static final t BGf;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(195770);
    BGf = new t();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(195770);
  }
  
  public static void div()
  {
    AppMethodBeat.i(195769);
    Logger.setLogProxy((ILog)new a());
    b localb = b.LnE;
    b.a((b.a)new b());
    AppMethodBeat.o(195769);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "plugin-vlog_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195763);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.d(t.erY() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(195763);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195761);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.e(t.erY() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(195761);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(195762);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.printErrStackTrace(t.erY() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(195762);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195758);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.i(t.erY() + ':' + paramString1, paramString2);
      AppMethodBeat.o(195758);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195760);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.v(t.erY() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(195760);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195759);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.w(t.erY() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(195759);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$2", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "plugin-vlog_release"})
  public static final class b
    implements b.a
  {
    public final void aDo(String paramString)
    {
      AppMethodBeat.i(195768);
      t localt = t.BGf;
      ad.w(t.erY(), paramString);
      AppMethodBeat.o(195768);
    }
    
    public final void kj(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195764);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.d(t.erY() + ':' + paramString1, paramString2);
      AppMethodBeat.o(195764);
    }
    
    public final void kk(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195765);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.e(t.erY() + ':' + paramString1, paramString2);
      AppMethodBeat.o(195765);
    }
    
    public final void kl(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195766);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.i(t.erY() + ':' + paramString1, paramString2);
      AppMethodBeat.o(195766);
    }
    
    public final void km(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195767);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BGf;
      ad.v(t.erY() + ':' + paramString1, paramString2);
      AppMethodBeat.o(195767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t
 * JD-Core Version:    0.7.0.1
 */