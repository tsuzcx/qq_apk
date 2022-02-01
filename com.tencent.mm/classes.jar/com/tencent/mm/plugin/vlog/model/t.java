package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.c.b.a;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "plugin-vlog_release"})
public final class t
{
  public static final t BXD;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(191227);
    BXD = new t();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(191227);
  }
  
  public static void dlu()
  {
    AppMethodBeat.i(191226);
    Logger.setLogProxy((ILog)new a());
    b localb = b.LKp;
    b.a((b.a)new b());
    AppMethodBeat.o(191226);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "plugin-vlog_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191220);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.d(t.evF() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(191220);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191218);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.e(t.evF() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(191218);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(191219);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.printErrStackTrace(t.evF() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(191219);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191215);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.i(t.evF() + ':' + paramString1, paramString2);
      AppMethodBeat.o(191215);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191217);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.v(t.evF() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(191217);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191216);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.w(t.evF() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(191216);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$2", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "plugin-vlog_release"})
  public static final class b
    implements b.a
  {
    public final void aEH(String paramString)
    {
      AppMethodBeat.i(191225);
      t localt = t.BXD;
      ae.w(t.evF(), paramString);
      AppMethodBeat.o(191225);
    }
    
    public final void kp(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191221);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.d(t.evF() + ':' + paramString1, paramString2);
      AppMethodBeat.o(191221);
    }
    
    public final void kq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191222);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.e(t.evF() + ':' + paramString1, paramString2);
      AppMethodBeat.o(191222);
    }
    
    public final void kr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191223);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.i(t.evF() + ':' + paramString1, paramString2);
      AppMethodBeat.o(191223);
    }
    
    public final void ks(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191224);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.BXD;
      ae.v(t.evF() + ':' + paramString1, paramString2);
      AppMethodBeat.o(191224);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t
 * JD-Core Version:    0.7.0.1
 */