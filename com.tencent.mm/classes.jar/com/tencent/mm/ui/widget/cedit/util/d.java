package com.tencent.mm.ui.widget.cedit.util;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.a.a.a;
import java.io.PrintStream;
import java.lang.reflect.Method;

public final class d
{
  private static Object QLO;
  private static Method QLP;
  private static float density = -1.0F;
  
  public static void a(View paramView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206132);
    new a(MetaKeyKeyListener.class.getName(), "startSelecting", new Class[] { Spannable.class }).invoke(new Object[] { paramView, paramSpannable });
    AppMethodBeat.o(206132);
  }
  
  public static void b(View paramView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206133);
    new a(MetaKeyKeyListener.class.getName(), "stopSelecting", new Class[] { Spannable.class }).invoke(new Object[] { paramView, paramSpannable });
    AppMethodBeat.o(206133);
  }
  
  public static boolean haY()
  {
    AppMethodBeat.i(206130);
    if (Build.VERSION.SDK_INT >= 28) {
      try
      {
        Object localObject2 = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
        Object localObject1 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
        localObject2 = (Class)((Method)localObject2).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
        Method localMethod = (Method)((Method)localObject1).invoke(localObject2, new Object[] { "getRuntime", null });
        QLP = (Method)((Method)localObject1).invoke(localObject2, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
        localObject1 = localMethod.invoke(null, new Object[0]);
        QLO = localObject1;
        if (localObject1 != null)
        {
          localObject1 = QLP;
          if (localObject1 != null) {}
        }
        else
        {
          AppMethodBeat.o(206130);
          return false;
        }
        try
        {
          QLP.invoke(QLO, new Object[] { { "L" } });
          AppMethodBeat.o(206130);
          return true;
        }
        catch (Throwable localThrowable1)
        {
          AppMethodBeat.o(206130);
          return false;
        }
        AppMethodBeat.o(206130);
      }
      catch (Throwable localThrowable2)
      {
        System.out.println("soontest reflect bootstrap failed:" + localThrowable2.getMessage());
        AppMethodBeat.o(206130);
        return false;
      }
    }
    return false;
  }
  
  public static boolean haZ()
  {
    AppMethodBeat.i(206134);
    boolean bool = a.a.gKe().gKc();
    AppMethodBeat.o(206134);
    return bool;
  }
  
  public static void resetLockedMeta(Spannable paramSpannable)
  {
    AppMethodBeat.i(206131);
    new a(MetaKeyKeyListener.class.getName(), "resetLockedMeta", new Class[] { Spannable.class }).invoke(new Object[] { paramSpannable });
    AppMethodBeat.o(206131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.d
 * JD-Core Version:    0.7.0.1
 */