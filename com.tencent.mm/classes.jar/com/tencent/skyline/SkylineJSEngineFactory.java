package com.tencent.skyline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/skyline/SkylineJSEngineFactory;", "", "()V", "sSkylineJSEngineFactory", "Lcom/tencent/skyline/ISkylineJSEngineFactory;", "getSSkylineJSEngineFactory", "()Lcom/tencent/skyline/ISkylineJSEngineFactory;", "setSSkylineJSEngineFactory", "(Lcom/tencent/skyline/ISkylineJSEngineFactory;)V", "createJSEngine", "", "callback", "Lcom/tencent/skyline/ISkylineJSEngineCallback;", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public final class SkylineJSEngineFactory
{
  public static final SkylineJSEngineFactory INSTANCE;
  private static ISkylineJSEngineFactory sSkylineJSEngineFactory;
  
  static
  {
    AppMethodBeat.i(210722);
    INSTANCE = new SkylineJSEngineFactory();
    sSkylineJSEngineFactory = (ISkylineJSEngineFactory)new ISkylineJSEngineFactory()
    {
      public final void createJSEngine(ISkylineJSEngineCallback paramAnonymousISkylineJSEngineCallback)
      {
        AppMethodBeat.i(210686);
        s.t(paramAnonymousISkylineJSEngineCallback, "callback");
        paramAnonymousISkylineJSEngineCallback.onDone(false, -1L, -1L);
        AppMethodBeat.o(210686);
      }
    };
    AppMethodBeat.o(210722);
  }
  
  public final void createJSEngine(ISkylineJSEngineCallback paramISkylineJSEngineCallback)
  {
    AppMethodBeat.i(210735);
    s.t(paramISkylineJSEngineCallback, "callback");
    ISkylineJSEngineFactory localISkylineJSEngineFactory = sSkylineJSEngineFactory;
    if (localISkylineJSEngineFactory != null)
    {
      localISkylineJSEngineFactory.createJSEngine(paramISkylineJSEngineCallback);
      AppMethodBeat.o(210735);
      return;
    }
    AppMethodBeat.o(210735);
  }
  
  public final ISkylineJSEngineFactory getSSkylineJSEngineFactory()
  {
    return sSkylineJSEngineFactory;
  }
  
  public final void setSSkylineJSEngineFactory(ISkylineJSEngineFactory paramISkylineJSEngineFactory)
  {
    sSkylineJSEngineFactory = paramISkylineJSEngineFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.skyline.SkylineJSEngineFactory
 * JD-Core Version:    0.7.0.1
 */