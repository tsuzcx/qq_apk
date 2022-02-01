package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.p;
import d.q;
import d.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Main$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"})
public final class c
{
  public static final b NJs;
  
  static
  {
    AppMethodBeat.i(107780);
    try
    {
      Object localObject1 = p.MKe;
      localObject1 = p.eL(new a(q(Looper.getMainLooper()), "Main"));
      localObject3 = localObject1;
      if (p.eJ(localObject1)) {
        localObject3 = null;
      }
      NJs = (b)localObject3;
      AppMethodBeat.o(107780);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject3 = p.MKe;
        Object localObject2 = p.eL(q.o(localThrowable));
      }
    }
  }
  
  public static final Handler q(Looper paramLooper)
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
        paramLooper = new v("null cannot be cast to non-null type android.os.Handler");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.android.c
 * JD-Core Version:    0.7.0.1
 */