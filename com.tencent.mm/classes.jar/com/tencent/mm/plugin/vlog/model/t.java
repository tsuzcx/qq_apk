package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "plugin-vlog_release"})
public final class t
{
  public static final t LqH;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(200874);
    LqH = new t();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(200874);
  }
  
  public static void cLD()
  {
    AppMethodBeat.i(200873);
    Logger.setLogger((ILog)new a());
    AppMethodBeat.o(200873);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/model/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "args", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "v", "msg", "w", "plugin-vlog_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(200872);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.LqH;
      ad.d(t.fYF() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(200872);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(200869);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.LqH;
      ad.e(t.fYF() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(200869);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(200871);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.LqH;
      ad.printErrStackTrace(t.fYF() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(200871);
    }
    
    public final void e(String paramString, Throwable paramThrowable)
    {
      AppMethodBeat.i(200870);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.LqH;
      ad.e(t.fYF() + ':' + paramString, String.valueOf(paramThrowable));
      AppMethodBeat.o(200870);
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(200866);
      k.h(paramVarArgs, "args");
      Object localObject = new StringBuilder();
      t localt = t.LqH;
      localObject = t.fYF() + ':' + paramString1;
      paramString1 = z.Jhz;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      paramString1 = String.format(paramString1, Arrays.copyOf(new Object[] { paramVarArgs }, 1));
      k.g(paramString1, "java.lang.String.format(format, *args)");
      ad.i((String)localObject, paramString1);
      AppMethodBeat.o(200866);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(200868);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.LqH;
      ad.v(t.fYF() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(200868);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(200867);
      StringBuilder localStringBuilder = new StringBuilder();
      t localt = t.LqH;
      ad.w(t.fYF() + ':' + paramString1, String.valueOf(paramString2));
      AppMethodBeat.o(200867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t
 * JD-Core Version:    0.7.0.1
 */