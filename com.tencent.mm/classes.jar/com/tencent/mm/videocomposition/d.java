package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import d.l;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "video_composition_release"})
public final class d
{
  public static final d LJp;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(194961);
    LJp = new d();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(194961);
  }
  
  public static void dlu()
  {
    AppMethodBeat.i(194960);
    Logger.setLogProxy((ILog)new a());
    AppMethodBeat.o(194960);
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"com/tencent/mm/videocomposition/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "video_composition_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194959);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LJp;
      b.d(d.fTX() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(194959);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194957);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LJp;
      b.e(d.fTX() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(194957);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(194958);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LJp;
      b.printErrStackTrace(d.fTX() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(194958);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194954);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LJp;
      b.i(d.fTX() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(194954);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194956);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LJp;
      b.v(d.fTX() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(194956);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194955);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LJp;
      localStringBuilder.append(d.fTX()).append(':').append(paramString1);
      b.y(String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(194955);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.d
 * JD-Core Version:    0.7.0.1
 */