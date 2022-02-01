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
  private static Object YkG;
  private static Method YkH;
  private static float density = -1.0F;
  
  public static void a(View paramView, Spannable paramSpannable)
  {
    AppMethodBeat.i(219995);
    new a(MetaKeyKeyListener.class.getName(), "startSelecting", new Class[] { Spannable.class }).invoke(new Object[] { paramView, paramSpannable });
    AppMethodBeat.o(219995);
  }
  
  public static void b(View paramView, Spannable paramSpannable)
  {
    AppMethodBeat.i(219996);
    new a(MetaKeyKeyListener.class.getName(), "stopSelecting", new Class[] { Spannable.class }).invoke(new Object[] { paramView, paramSpannable });
    AppMethodBeat.o(219996);
  }
  
  public static boolean ibY()
  {
    AppMethodBeat.i(219990);
    if (Build.VERSION.SDK_INT >= 28) {
      try
      {
        Object localObject2 = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
        Object localObject1 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
        localObject2 = (Class)((Method)localObject2).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
        Method localMethod = (Method)((Method)localObject1).invoke(localObject2, new Object[] { "getRuntime", null });
        YkH = (Method)((Method)localObject1).invoke(localObject2, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
        localObject1 = localMethod.invoke(null, new Object[0]);
        YkG = localObject1;
        if (localObject1 != null)
        {
          localObject1 = YkH;
          if (localObject1 != null) {}
        }
        else
        {
          AppMethodBeat.o(219990);
          return false;
        }
        try
        {
          YkH.invoke(YkG, new Object[] { { "L" } });
          AppMethodBeat.o(219990);
          return true;
        }
        catch (Throwable localThrowable1)
        {
          AppMethodBeat.o(219990);
          return false;
        }
        AppMethodBeat.o(219990);
      }
      catch (Throwable localThrowable2)
      {
        System.out.println("soontest reflect bootstrap failed:" + localThrowable2.getMessage());
        AppMethodBeat.o(219990);
        return false;
      }
    }
    return false;
  }
  
  public static boolean ibZ()
  {
    AppMethodBeat.i(219997);
    boolean bool = a.a.hJg().hJd();
    AppMethodBeat.o(219997);
    return bool;
  }
  
  public static void k(Spannable paramSpannable)
  {
    AppMethodBeat.i(219993);
    new a(MetaKeyKeyListener.class.getName(), "resetLockedMeta", new Class[] { Spannable.class }).invoke(new Object[] { paramSpannable });
    AppMethodBeat.o(219993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.d
 * JD-Core Version:    0.7.0.1
 */