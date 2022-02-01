package com.tencent.mm.wexnet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/WeXNet;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WeXNet
{
  public static final a Companion;
  
  static
  {
    AppMethodBeat.i(231589);
    Companion = new a((byte)0);
    AppMethodBeat.o(231589);
  }
  
  private static final native SessionCreateResult createSession(String paramString, Options paramOptions);
  
  private static final native void releaseSession(long paramLong);
  
  private static final native Result run(SessionKeeper paramSessionKeeper, Map<String, TensorCpuB> paramMap1, Map<String, TensorCpuB> paramMap2);
  
  public static final SessionCreateResult tryCreateSession(String paramString, Options paramOptions)
  {
    AppMethodBeat.i(231550);
    paramString = a.tryCreateSession(paramString, paramOptions);
    AppMethodBeat.o(231550);
    return paramString;
  }
  
  public static final void tryReleaseSession(long paramLong)
  {
    AppMethodBeat.i(231563);
    a.jPH();
    a.releaseSession(paramLong);
    AppMethodBeat.o(231563);
  }
  
  public static final Result tryRun(SessionKeeper paramSessionKeeper, Map<String, TensorCpuB> paramMap1, Map<String, TensorCpuB> paramMap2)
  {
    AppMethodBeat.i(231557);
    paramSessionKeeper = a.tryRun(paramSessionKeeper, paramMap1, paramMap2);
    AppMethodBeat.o(231557);
    return paramSessionKeeper;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/WeXNet$Companion;", "", "()V", "createSession", "Lcom/tencent/mm/wexnet/SessionCreateResult;", "modelFilePath", "", "options", "Lcom/tencent/mm/wexnet/Options;", "releaseSession", "", "sessionPtr", "", "run", "Lcom/tencent/mm/wexnet/Result;", "sessionKeeper", "Lcom/tencent/mm/wexnet/SessionKeeper;", "inputTensors", "", "Lcom/tencent/mm/wexnet/TensorCpuB;", "outputTensors", "tryCreateSession", "tryLoadLib", "tryReleaseSession", "tryRun", "XNetLibNotLoadedException", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static void jPH()
    {
      AppMethodBeat.i(231543);
      if (!c.agWk.jPM())
      {
        a locala = new a();
        AppMethodBeat.o(231543);
        throw locala;
      }
      AppMethodBeat.o(231543);
    }
    
    static void releaseSession(long paramLong)
    {
      AppMethodBeat.i(231553);
      WeXNet.access$releaseSession(paramLong);
      AppMethodBeat.o(231553);
    }
    
    public static SessionCreateResult tryCreateSession(String paramString, Options paramOptions)
    {
      AppMethodBeat.i(231528);
      s.u(paramString, "modelFilePath");
      s.u(paramOptions, "options");
      jPH();
      paramString = WeXNet.access$createSession(paramString, paramOptions);
      AppMethodBeat.o(231528);
      return paramString;
    }
    
    public static Result tryRun(SessionKeeper paramSessionKeeper, Map<String, TensorCpuB> paramMap1, Map<String, TensorCpuB> paramMap2)
    {
      AppMethodBeat.i(231535);
      s.u(paramSessionKeeper, "sessionKeeper");
      s.u(paramMap1, "inputTensors");
      s.u(paramMap2, "outputTensors");
      jPH();
      paramSessionKeeper = WeXNet.access$run(paramSessionKeeper, paramMap1, paramMap2);
      AppMethodBeat.o(231535);
      return paramSessionKeeper;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/WeXNet$Companion$XNetLibNotLoadedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends Exception
    {
      public a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wexnet.WeXNet
 * JD-Core Version:    0.7.0.1
 */