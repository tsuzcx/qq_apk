package com.tencent.mm.plugin.wallet.wecoin.utils;

import android.os.Looper;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"postSetValue", "", "T", "mld", "Landroidx/lifecycle/MutableLiveData;", "d", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "setValue", "plugin-wxpay_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final <T> void b(x<T> paramx, T paramT)
  {
    AppMethodBeat.i(315717);
    if (paramx == null)
    {
      AppMethodBeat.o(315717);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramx.setValue(paramT);
      AppMethodBeat.o(315717);
      return;
    }
    c(paramx, paramT);
    AppMethodBeat.o(315717);
  }
  
  private static final <T> void c(x<T> paramx, T paramT)
  {
    AppMethodBeat.i(315727);
    i locali = h.ahAA;
    b.a locala = b.Vxh;
    locali.bk((Runnable)b.a.d(paramx, paramT));
    AppMethodBeat.o(315727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.utils.a
 * JD-Core Version:    0.7.0.1
 */