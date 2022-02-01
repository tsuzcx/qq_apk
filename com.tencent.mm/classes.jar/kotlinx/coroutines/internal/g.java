package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"})
public final class g
{
  private static final boolean NJH;
  
  static
  {
    AppMethodBeat.i(190814);
    try
    {
      Object localObject1 = p.MKe;
      localObject1 = p.eL(Class.forName("android.os.Build"));
      NJH = p.eI(localObject1);
      AppMethodBeat.o(190814);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        p.a locala = p.MKe;
        Object localObject2 = p.eL(q.o(localThrowable));
      }
    }
  }
  
  public static final boolean gvX()
  {
    return NJH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.g
 * JD-Core Version:    0.7.0.1
 */