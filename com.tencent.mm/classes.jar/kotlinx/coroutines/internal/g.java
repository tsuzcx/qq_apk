package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"})
public final class g
{
  private static final boolean OgN;
  
  static
  {
    AppMethodBeat.i(209305);
    try
    {
      Object localObject1 = p.Nhh;
      localObject1 = p.eO(Class.forName("android.os.Build"));
      OgN = p.eL(localObject1);
      AppMethodBeat.o(209305);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        p.a locala = p.Nhh;
        Object localObject2 = p.eO(q.p(localThrowable));
      }
    }
  }
  
  public static final boolean gAz()
  {
    return OgN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.g
 * JD-Core Version:    0.7.0.1
 */