package com.tencent.mm.plugin.wallet.wecoin.c;

import android.os.Looper;
import androidx.lifecycle.r;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"postSetValue", "", "T", "mld", "Landroidx/lifecycle/MutableLiveData;", "d", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "setValue", "plugin-wxpay_release"})
public final class a
{
  public static final <T> void a(r<T> paramr, T paramT)
  {
    AppMethodBeat.i(266139);
    if (paramr == null)
    {
      AppMethodBeat.o(266139);
      return;
    }
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    if (localThread == localLooper.getThread())
    {
      paramr.setValue(paramT);
      AppMethodBeat.o(266139);
      return;
    }
    b(paramr, paramT);
    AppMethodBeat.o(266139);
  }
  
  private static final <T> void b(r<T> paramr, T paramT)
  {
    AppMethodBeat.i(266140);
    i locali = h.ZvG;
    b.a locala = b.OHx;
    locali.bc((Runnable)b.a.c(paramr, paramT));
    AppMethodBeat.o(266140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.c.a
 * JD-Core Version:    0.7.0.1
 */