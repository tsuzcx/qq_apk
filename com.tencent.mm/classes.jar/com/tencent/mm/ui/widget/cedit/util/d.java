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
  private static Object agcF;
  private static Method agcG;
  private static float density = -1.0F;
  
  public static void a(View paramView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252167);
    new a(MetaKeyKeyListener.class.getName(), "startSelecting", new Class[] { Spannable.class }).invoke(new Object[] { paramView, paramSpannable });
    AppMethodBeat.o(252167);
  }
  
  public static void b(View paramView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252176);
    new a(MetaKeyKeyListener.class.getName(), "stopSelecting", new Class[] { Spannable.class }).invoke(new Object[] { paramView, paramSpannable });
    AppMethodBeat.o(252176);
  }
  
  public static boolean jHm()
  {
    AppMethodBeat.i(252149);
    if (Build.VERSION.SDK_INT >= 28) {
      try
      {
        Object localObject4 = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
        Object localObject1 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
        localObject4 = (Class)((Method)localObject4).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
        Method localMethod = (Method)((Method)localObject1).invoke(localObject4, new Object[] { "getRuntime", null });
        agcG = (Method)((Method)localObject1).invoke(localObject4, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
        localObject1 = localMethod.invoke(null, new Object[0]);
        agcF = localObject1;
        if (localObject1 != null)
        {
          localObject1 = agcG;
          if (localObject1 != null) {}
        }
        else
        {
          AppMethodBeat.o(252149);
          return false;
        }
        try
        {
          agcG.invoke(agcF, new Object[] { { "L" } });
        }
        finally
        {
          AppMethodBeat.o(252149);
          return false;
        }
        AppMethodBeat.o(252149);
      }
      finally
      {
        System.out.println("soontest reflect bootstrap failed:" + localObject3.getMessage());
        AppMethodBeat.o(252149);
        return false;
      }
    }
    return false;
  }
  
  public static boolean jHn()
  {
    AppMethodBeat.i(252184);
    boolean bool = a.a.jlv().jls();
    AppMethodBeat.o(252184);
    return bool;
  }
  
  public static void k(Spannable paramSpannable)
  {
    AppMethodBeat.i(252158);
    new a(MetaKeyKeyListener.class.getName(), "resetLockedMeta", new Class[] { Spannable.class }).invoke(new Object[] { paramSpannable });
    AppMethodBeat.o(252158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.d
 * JD-Core Version:    0.7.0.1
 */