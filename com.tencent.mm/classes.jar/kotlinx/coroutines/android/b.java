package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.ba.a;
import kotlinx.coroutines.bi;
import kotlinx.coroutines.cm;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends cm
  implements ba
{
  public bi a(long paramLong, Runnable paramRunnable, f paramf)
  {
    return ba.a.b(paramLong, paramRunnable, paramf);
  }
  
  public abstract b kCQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.android.b
 * JD-Core Version:    0.7.0.1
 */