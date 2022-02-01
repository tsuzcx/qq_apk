package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"})
public final class f
{
  private static final boolean LSK;
  
  static
  {
    AppMethodBeat.i(191203);
    try
    {
      Object localObject1 = p.KTg;
      localObject1 = p.eI(Class.forName("android.os.Build"));
      LSK = p.eF(localObject1);
      AppMethodBeat.o(191203);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        p.a locala = p.KTg;
        Object localObject2 = p.eI(q.n(localThrowable));
      }
    }
  }
  
  public static final boolean gey()
  {
    return LSK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.f
 * JD-Core Version:    0.7.0.1
 */