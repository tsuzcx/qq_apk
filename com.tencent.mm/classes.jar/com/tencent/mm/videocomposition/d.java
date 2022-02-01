package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "video_composition_release"})
public final class d
{
  private static final String TAG = "MicroMsg.TAVKit";
  public static final d YHZ;
  
  static
  {
    AppMethodBeat.i(247945);
    YHZ = new d();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(247945);
  }
  
  public static void eON()
  {
    AppMethodBeat.i(247943);
    Logger.setLogProxy((ILog)new a());
    Logger.setLevel(2);
    AppMethodBeat.o(247943);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"com/tencent/mm/videocomposition/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "video_composition_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(247938);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.YHZ;
      b.d(d.igD() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(247938);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(247934);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.YHZ;
      b.e(d.igD() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(247934);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(247937);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.YHZ;
      b.printErrStackTrace(d.igD() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(247937);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(247928);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.YHZ;
      b.i(d.igD() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(247928);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(247933);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.YHZ;
      b.v(d.igD() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(247933);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(247931);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.YHZ;
      localStringBuilder.append(d.igD()).append(':').append(paramString1);
      b.r(String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(247931);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.d
 * JD-Core Version:    0.7.0.1
 */