package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.d.b;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class d
{
  private static final String TAG = "MicroMsg.TAVKit";
  public static final d agDG;
  
  static
  {
    AppMethodBeat.i(233488);
    agDG = new d();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(233488);
  }
  
  public static void fXr()
  {
    AppMethodBeat.i(233472);
    Logger.setLogProxy((ILog)new a());
    Logger.setLevel(2);
    AppMethodBeat.o(233472);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/videocomposition/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(233482);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.agDG;
      b.d(d.jLR() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(233482);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(233473);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.agDG;
      b.e(d.jLR() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(233473);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(233478);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.agDG;
      b.printErrStackTrace(d.jLR() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(233478);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(233459);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.agDG;
      b.i(d.jLR() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(233459);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(233471);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.agDG;
      b.v(d.jLR() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(233471);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(233464);
      StringBuilder localStringBuilder = new StringBuilder();
      d locald = d.agDG;
      localStringBuilder.append(d.jLR()).append(':').append(paramString1);
      b.s(String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(233464);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.d
 * JD-Core Version:    0.7.0.1
 */