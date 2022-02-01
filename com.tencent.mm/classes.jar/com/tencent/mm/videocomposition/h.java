package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "video_composition_release"})
public final class h
{
  public static final h Rhg;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(216752);
    Rhg = new h();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(216752);
  }
  
  public static void efp()
  {
    AppMethodBeat.i(216751);
    Logger.setLogProxy((ILog)new a());
    Logger.setLevel(2);
    AppMethodBeat.o(216751);
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"com/tencent/mm/videocomposition/TAVKitLog$setUp$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "msg", "w", "video_composition_release"})
  public static final class a
    implements ILog
  {
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(216750);
      StringBuilder localStringBuilder = new StringBuilder();
      h localh = h.Rhg;
      b.d(h.hfk() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(216750);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(216748);
      StringBuilder localStringBuilder = new StringBuilder();
      h localh = h.Rhg;
      b.e(h.hfk() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(216748);
    }
    
    public final void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      AppMethodBeat.i(216749);
      StringBuilder localStringBuilder = new StringBuilder();
      h localh = h.Rhg;
      b.printErrStackTrace(h.hfk() + ':' + paramString1, paramThrowable, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(216749);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(216745);
      StringBuilder localStringBuilder = new StringBuilder();
      h localh = h.Rhg;
      b.i(h.hfk() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(216745);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(216747);
      StringBuilder localStringBuilder = new StringBuilder();
      h localh = h.Rhg;
      b.v(h.hfk() + ':' + paramString1, String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(216747);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(216746);
      StringBuilder localStringBuilder = new StringBuilder();
      h localh = h.Rhg;
      localStringBuilder.append(h.hfk()).append(':').append(paramString1);
      b.s(String.valueOf(paramString2), new Object[0]);
      AppMethodBeat.o(216746);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.h
 * JD-Core Version:    0.7.0.1
 */