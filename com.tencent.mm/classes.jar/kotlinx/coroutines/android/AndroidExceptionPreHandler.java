package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.d.a;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k=1, mv={1, 5, 1}, xi=48)
public final class AndroidExceptionPreHandler
  extends a
  implements CoroutineExceptionHandler
{
  private volatile Object _preHandler;
  
  public AndroidExceptionPreHandler()
  {
    super((f.c)CoroutineExceptionHandler.ajvG);
    AppMethodBeat.i(107783);
    this._preHandler = this;
    AppMethodBeat.o(107783);
  }
  
  private final Method preHandler()
  {
    int j = 0;
    AppMethodBeat.i(188924);
    Object localObject1 = this._preHandler;
    if (localObject1 != this)
    {
      localObject1 = (Method)localObject1;
      AppMethodBeat.o(188924);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
        int i = j;
        if (Modifier.isPublic(((Method)localObject1).getModifiers()))
        {
          boolean bool = Modifier.isStatic(((Method)localObject1).getModifiers());
          i = j;
          if (bool) {
            i = 1;
          }
        }
        if (i == 0) {
          continue;
        }
      }
      finally
      {
        Object localObject3 = null;
        continue;
      }
      this._preHandler = localObject1;
      AppMethodBeat.o(188924);
      return localObject1;
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
    if (paramf == null)
    {
      paramf = null;
      if (!(paramf instanceof Thread.UncaughtExceptionHandler)) {
        break label88;
      }
    }
    label88:
    for (paramf = (Thread.UncaughtExceptionHandler)paramf;; paramf = null)
    {
      if (paramf != null) {
        paramf.uncaughtException(localThread, paramThrowable);
      }
      AppMethodBeat.o(107782);
      return;
      paramf = paramf.invoke(null, new Object[0]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidExceptionPreHandler
 * JD-Core Version:    0.7.0.1
 */