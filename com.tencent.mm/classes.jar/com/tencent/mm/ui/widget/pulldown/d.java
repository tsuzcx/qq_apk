package com.tencent.mm.ui.widget.pulldown;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/BounceUtil;", "", "()V", "TAG", "", "getAttrs", "", "cls", "Ljava/lang/Class;", "name", "getSuperClassAttrs", "isPullDownEnable", "", "preloadClass", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d aglB;
  
  static
  {
    AppMethodBeat.i(251955);
    aglB = new d();
    AppMethodBeat.o(251955);
  }
  
  public static Class<?> bzX(String paramString)
  {
    AppMethodBeat.i(251944);
    try
    {
      Class localClass = Class.forName(paramString);
      AppMethodBeat.o(251944);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.printErrStackTrace("PullDownUtil", (Throwable)localClassNotFoundException, "", new Object[0]);
      Log.e("PullDownUtil", "Class %s not found in dex", new Object[] { paramString });
      AppMethodBeat.o(251944);
    }
    return null;
  }
  
  private final int cj(Class<?> paramClass)
  {
    AppMethodBeat.i(251949);
    paramClass = paramClass.getSuperclass();
    if (paramClass != null)
    {
      int i = ci(paramClass);
      AppMethodBeat.o(251949);
      return i;
    }
    AppMethodBeat.o(251949);
    return 1;
  }
  
  public final int ci(Class<?> paramClass)
  {
    AppMethodBeat.i(251961);
    s.u(paramClass, "cls");
    Object localObject = (c)paramClass.getAnnotation(c.class);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((c)localObject).value()))
    {
      i = cj(paramClass);
      AppMethodBeat.o(251961);
      return i;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(251961);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.d
 * JD-Core Version:    0.7.0.1
 */