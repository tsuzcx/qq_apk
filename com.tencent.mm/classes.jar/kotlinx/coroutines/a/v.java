package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"})
public final class v
{
  private static final boolean LED;
  
  static
  {
    AppMethodBeat.i(202355);
    try
    {
      Object localObject1 = p.JfM;
      localObject1 = p.eF(Class.forName("android.os.Build"));
      LED = p.gf(localObject1);
      AppMethodBeat.o(202355);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        p.a locala = p.JfM;
        Object localObject2 = p.eF(q.n(localThrowable));
      }
    }
  }
  
  public static final boolean gaJ()
  {
    return LED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.a.v
 * JD-Core Version:    0.7.0.1
 */