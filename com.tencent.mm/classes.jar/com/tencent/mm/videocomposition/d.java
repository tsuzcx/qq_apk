package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import d.l;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "video_composition_release"})
public final class d
{
  public static final d LmF;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(220825);
    LmF = new d();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(220825);
  }
  
  public static void div()
  {
    AppMethodBeat.i(220824);
    Logger.setLogProxy((ILog)new a());
    AppMethodBeat.o(220824);
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"com/tencent/mm/videocomposition/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "video_composition_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220823);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LmF;
      b.d(d.fPB() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(220823);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220821);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LmF;
      b.e(d.fPB() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(220821);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(220822);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LmF;
      b.printErrStackTrace(d.fPB() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(220822);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220818);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LmF;
      b.i(d.fPB() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(220818);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220820);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LmF;
      b.v(d.fPB() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(220820);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220819);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.LmF;
      localStringBuilder.append(d.fPB()).append(':').append(paramString1);
      b.y(String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(220819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.videocomposition.d
 * JD-Core Version:    0.7.0.1
 */