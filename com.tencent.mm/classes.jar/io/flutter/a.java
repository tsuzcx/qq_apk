package io.flutter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.a.c;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;

public final class a
{
  private static a aanP;
  private static boolean aanQ;
  public c aanR;
  public DeferredComponentManager deferredComponentManager;
  
  private a(c paramc, DeferredComponentManager paramDeferredComponentManager)
  {
    this.aanR = paramc;
    this.deferredComponentManager = paramDeferredComponentManager;
  }
  
  public static a iAc()
  {
    AppMethodBeat.i(254830);
    aanQ = true;
    if (aanP == null)
    {
      localObject = new a();
      if (((a)localObject).aanR == null) {
        ((a)localObject).aanR = new c();
      }
      aanP = new a(((a)localObject).aanR, ((a)localObject).deferredComponentManager, (byte)0);
    }
    Object localObject = aanP;
    AppMethodBeat.o(254830);
    return localObject;
  }
  
  public static final class a
  {
    c aanR;
    DeferredComponentManager deferredComponentManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.a
 * JD-Core Version:    0.7.0.1
 */