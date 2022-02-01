package com.tencent.mm.ui.widget.pulldown;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/BounceUtil;", "", "()V", "TAG", "", "getAttrs", "", "cls", "Ljava/lang/Class;", "name", "getSuperClassAttrs", "isPullDownEnable", "", "preloadClass", "libmmui_release"})
public final class d
{
  public static final d Ytn;
  
  static
  {
    AppMethodBeat.i(203899);
    Ytn = new d();
    AppMethodBeat.o(203899);
  }
  
  public static Class<?> byz(String paramString)
  {
    AppMethodBeat.i(203896);
    try
    {
      Class localClass = Class.forName(paramString);
      AppMethodBeat.o(203896);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.printErrStackTrace("PullDownUtil", (Throwable)localClassNotFoundException, "", new Object[0]);
      Log.e("PullDownUtil", "Class %s not found in dex", new Object[] { paramString });
      AppMethodBeat.o(203896);
    }
    return null;
  }
  
  private final int bz(Class<?> paramClass)
  {
    AppMethodBeat.i(203897);
    paramClass = paramClass.getSuperclass();
    if (paramClass != null)
    {
      int i = by(paramClass);
      AppMethodBeat.o(203897);
      return i;
    }
    AppMethodBeat.o(203897);
    return 1;
  }
  
  public final int by(Class<?> paramClass)
  {
    AppMethodBeat.i(203895);
    p.k(paramClass, "cls");
    c localc = (c)paramClass.getAnnotation(c.class);
    if (localc != null)
    {
      i = localc.value();
      AppMethodBeat.o(203895);
      return i;
    }
    int i = bz(paramClass);
    AppMethodBeat.o(203895);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.d
 * JD-Core Version:    0.7.0.1
 */