package com.tencent.mm.z.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import java.lang.reflect.Method;

public final class a
  implements q
{
  public static boolean hU;
  private static a mvo;
  private Handler mH;
  private Runnable mRunnable;
  
  static
  {
    AppMethodBeat.i(233959);
    mvo = new a();
    hU = false;
    AppMethodBeat.o(233959);
  }
  
  private a()
  {
    AppMethodBeat.i(233942);
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233945);
        a.aXU();
        a.aXV();
        AppMethodBeat.o(233945);
      }
    };
    this.mH = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(233942);
  }
  
  private static Method b(Class paramClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(233948);
    Method localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
    localMethod.setAccessible(true);
    paramClass = (Method)localMethod.invoke(paramClass, paramVarArgs);
    AppMethodBeat.o(233948);
    return paramClass;
  }
  
  public static void start()
  {
    AppMethodBeat.i(233944);
    if (hU)
    {
      AppMethodBeat.o(233944);
      return;
    }
    hU = true;
    AppForegroundDelegate.heY.a(mvo);
    AppMethodBeat.o(233944);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(233965);
    this.mH.postDelayed(this.mRunnable, 30000L);
    AppMethodBeat.o(233965);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(233962);
    this.mH.removeCallbacks(this.mRunnable);
    AppMethodBeat.o(233962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.z.a.a
 * JD-Core Version:    0.7.0.1
 */