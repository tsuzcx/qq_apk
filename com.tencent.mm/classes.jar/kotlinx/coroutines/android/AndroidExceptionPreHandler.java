package kotlinx.coroutines.android;

import a.c.e;
import a.c.e.c;
import a.f.b.j;
import a.l;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlinx.coroutines.x;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-android"})
@Keep
public final class AndroidExceptionPreHandler
  extends a.c.a
  implements x
{
  public AndroidExceptionPreHandler()
  {
    super((e.c)x.CHx);
    AppMethodBeat.i(118260);
    AppMethodBeat.o(118260);
  }
  
  public final void handleException(e parame, Throwable paramThrowable)
  {
    AppMethodBeat.i(118259);
    j.q(parame, "context");
    j.q(paramThrowable, "exception");
    parame = a.eqb();
    if (parame != null) {}
    for (parame = parame.invoke(null, new Object[0]);; parame = null)
    {
      e locale = parame;
      if (!(parame instanceof Thread.UncaughtExceptionHandler)) {
        locale = null;
      }
      parame = (Thread.UncaughtExceptionHandler)locale;
      if (parame == null) {
        break;
      }
      parame.uncaughtException(Thread.currentThread(), paramThrowable);
      AppMethodBeat.o(118259);
      return;
    }
    AppMethodBeat.o(118259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidExceptionPreHandler
 * JD-Core Version:    0.7.0.1
 */