package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

public final class as
{
  public static final boolean au(ab paramab)
  {
    AppMethodBeat.i(60826);
    p.h(paramab, "$this$isCustomTypeVariable");
    bg localbg = paramab.gyC();
    paramab = localbg;
    if (!(localbg instanceof k)) {
      paramab = null;
    }
    paramab = (k)paramab;
    if (paramab != null)
    {
      boolean bool = paramab.gqx();
      AppMethodBeat.o(60826);
      return bool;
    }
    AppMethodBeat.o(60826);
    return false;
  }
  
  public static final k av(ab paramab)
  {
    AppMethodBeat.i(60827);
    p.h(paramab, "$this$getCustomTypeVariable");
    bg localbg = paramab.gyC();
    paramab = localbg;
    if (!(localbg instanceof k)) {
      paramab = null;
    }
    paramab = (k)paramab;
    if (paramab != null)
    {
      if (paramab.gqx())
      {
        AppMethodBeat.o(60827);
        return paramab;
      }
      AppMethodBeat.o(60827);
      return null;
    }
    AppMethodBeat.o(60827);
    return null;
  }
  
  public static final ab aw(ab paramab)
  {
    AppMethodBeat.i(60828);
    p.h(paramab, "$this$getSubtypeRepresentative");
    Object localObject2 = paramab.gyC();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ar)) {
      localObject1 = null;
    }
    localObject2 = (ar)localObject1;
    localObject1 = paramab;
    if (localObject2 != null)
    {
      localObject1 = ((ar)localObject2).gxz();
      if (localObject1 != null) {
        break label58;
      }
      localObject1 = paramab;
    }
    label58:
    for (;;)
    {
      AppMethodBeat.o(60828);
      return localObject1;
    }
  }
  
  public static final ab ax(ab paramab)
  {
    AppMethodBeat.i(60829);
    p.h(paramab, "$this$getSupertypeRepresentative");
    Object localObject2 = paramab.gyC();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ar)) {
      localObject1 = null;
    }
    localObject2 = (ar)localObject1;
    localObject1 = paramab;
    if (localObject2 != null)
    {
      localObject1 = ((ar)localObject2).gxA();
      if (localObject1 != null) {
        break label58;
      }
      localObject1 = paramab;
    }
    label58:
    for (;;)
    {
      AppMethodBeat.o(60829);
      return localObject1;
    }
  }
  
  public static final boolean b(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(60830);
    p.h(paramab1, "first");
    p.h(paramab2, "second");
    bg localbg = paramab1.gyC();
    Object localObject = localbg;
    if (!(localbg instanceof ar)) {
      localObject = null;
    }
    localObject = (ar)localObject;
    if (localObject != null)
    {
      bool = ((ar)localObject).ad(paramab2);
      if (!bool)
      {
        localObject = paramab2.gyC();
        paramab2 = (ab)localObject;
        if (!(localObject instanceof ar)) {
          paramab2 = null;
        }
        paramab2 = (ar)paramab2;
        if (paramab2 == null) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool = paramab2.ad(paramab1);; bool = false)
    {
      if (!bool) {
        break label111;
      }
      AppMethodBeat.o(60830);
      return true;
      bool = false;
      break;
    }
    label111:
    AppMethodBeat.o(60830);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.as
 * JD-Core Version:    0.7.0.1
 */