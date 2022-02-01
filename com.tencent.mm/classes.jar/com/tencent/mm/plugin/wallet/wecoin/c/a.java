package com.tencent.mm.plugin.wallet.wecoin.c;

import android.arch.lifecycle.MutableLiveData;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"postSetValue", "", "T", "mld", "Landroid/arch/lifecycle/MutableLiveData;", "d", "(Landroid/arch/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "setValue", "plugin-wxpay_release"})
public final class a
{
  public static final <T> void a(MutableLiveData<T> paramMutableLiveData, T paramT)
  {
    AppMethodBeat.i(212914);
    if (paramMutableLiveData == null)
    {
      AppMethodBeat.o(212914);
      return;
    }
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    if (localThread == localLooper.getThread())
    {
      paramMutableLiveData.setValue(paramT);
      AppMethodBeat.o(212914);
      return;
    }
    b(paramMutableLiveData, paramT);
    AppMethodBeat.o(212914);
  }
  
  private static final <T> void b(MutableLiveData<T> paramMutableLiveData, T paramT)
  {
    AppMethodBeat.i(212915);
    i locali = h.RTc;
    b.a locala = b.HPp;
    locali.aV((Runnable)b.a.c(paramMutableLiveData, paramT));
    AppMethodBeat.o(212915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.c.a
 * JD-Core Version:    0.7.0.1
 */