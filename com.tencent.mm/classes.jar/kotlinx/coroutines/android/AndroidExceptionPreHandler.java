package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.d.a;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.l;
import kotlinx.coroutines.CoroutineExceptionHandler;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"})
@Keep
public final class AndroidExceptionPreHandler
  extends a
  implements CoroutineExceptionHandler
{
  private volatile Object _preHandler;
  
  public AndroidExceptionPreHandler()
  {
    super((f.c)CoroutineExceptionHandler.abww);
    AppMethodBeat.i(107783);
    this._preHandler = this;
    AppMethodBeat.o(107783);
  }
  
  private final Method preHandler()
  {
    AppMethodBeat.i(243910);
    Object localObject1 = this._preHandler;
    if (localObject1 != (AndroidExceptionPreHandler)this)
    {
      localObject1 = (Method)localObject1;
      AppMethodBeat.o(243910);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
        if (!Modifier.isPublic(((Method)localObject1).getModifiers())) {
          continue;
        }
        boolean bool = Modifier.isStatic(((Method)localObject1).getModifiers());
        if (!bool) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        Object localObject2 = null;
        continue;
      }
      this._preHandler = localObject1;
      AppMethodBeat.o(243910);
      return localObject1;
      i = 0;
      continue;
      localObject1 = null;
    }
  }
  
  public final void handleException(f paramf, Throwable paramThrowable)
  {
    AppMethodBeat.i(107782);
    Thread localThread = Thread.currentThread();
    if (Build.VERSION.SDK_INT >= 28)
    {
      localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
      AppMethodBeat.o(107782);
      return;
    }
    paramf = preHandler();
    if (paramf != null) {}
    for (paramf = paramf.invoke(null, new Object[0]);; paramf = null)
    {
      f localf = paramf;
      if (!(paramf instanceof Thread.UncaughtExceptionHandler)) {
        localf = null;
      }
      paramf = (Thread.UncaughtExceptionHandler)localf;
      if (paramf == null) {
        break;
      }
      paramf.uncaughtException(localThread, paramThrowable);
      AppMethodBeat.o(107782);
      return;
    }
    AppMethodBeat.o(107782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidExceptionPreHandler
 * JD-Core Version:    0.7.0.1
 */