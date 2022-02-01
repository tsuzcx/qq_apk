package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(d1={""}, d2={"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final b ajxc;
  private static volatile Choreographer choreographer;
  
  static
  {
    AppMethodBeat.i(107780);
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(new a(n(Looper.getMainLooper())));
      localObject3 = localObject1;
      if (Result.isFailure-impl(localObject1)) {
        localObject3 = null;
      }
      ajxc = (b)localObject3;
      AppMethodBeat.o(107780);
      return;
    }
    finally
    {
      for (;;)
      {
        Object localObject3 = Result.Companion;
        Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
      }
    }
  }
  
  public static final b a(Handler paramHandler, String paramString)
  {
    AppMethodBeat.i(188911);
    paramHandler = (b)new a(paramHandler, paramString);
    AppMethodBeat.o(188911);
    return paramHandler;
  }
  
  public static final Handler n(Looper paramLooper)
  {
    AppMethodBeat.i(107779);
    if (Build.VERSION.SDK_INT < 16)
    {
      paramLooper = new Handler(paramLooper);
      AppMethodBeat.o(107779);
      return paramLooper;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramLooper = Handler.class.getDeclaredMethod("createAsync", new Class[] { Looper.class }).invoke(null, new Object[] { paramLooper });
      if (paramLooper == null)
      {
        paramLooper = new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        AppMethodBeat.o(107779);
        throw paramLooper;
      }
      paramLooper = (Handler)paramLooper;
      AppMethodBeat.o(107779);
      return paramLooper;
    }
    try
    {
      Constructor localConstructor = Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE });
      paramLooper = (Handler)localConstructor.newInstance(new Object[] { paramLooper, null, Boolean.TRUE });
      AppMethodBeat.o(107779);
      return paramLooper;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramLooper = new Handler(paramLooper);
      AppMethodBeat.o(107779);
    }
    return paramLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.android.c
 * JD-Core Version:    0.7.0.1
 */