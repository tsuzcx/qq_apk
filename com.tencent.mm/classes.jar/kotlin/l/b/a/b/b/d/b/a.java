package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

final class a
{
  private static a aaPO;
  public static final a aaPP;
  
  static
  {
    AppMethodBeat.i(57394);
    aaPP = new a();
    AppMethodBeat.o(57394);
  }
  
  private static a a(Member paramMember)
  {
    AppMethodBeat.i(57392);
    p.k(paramMember, "member");
    paramMember = paramMember.getClass();
    try
    {
      Method localMethod = paramMember.getMethod("getParameters", new Class[0]);
      paramMember = new a(localMethod, b.bW(paramMember).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
      AppMethodBeat.o(57392);
      return paramMember;
    }
    catch (NoSuchMethodException paramMember)
    {
      paramMember = new a(null, null);
      AppMethodBeat.o(57392);
    }
    return paramMember;
  }
  
  public static List<String> b(Member paramMember)
  {
    AppMethodBeat.i(57393);
    p.k(paramMember, "member");
    Object localObject2 = aaPO;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a(paramMember);
      aaPO = (a)localObject1;
    }
    localObject2 = ((a)localObject1).aaPQ;
    if (localObject2 == null)
    {
      AppMethodBeat.o(57393);
      return null;
    }
    localObject1 = ((a)localObject1).aaPR;
    if (localObject1 == null)
    {
      AppMethodBeat.o(57393);
      return null;
    }
    paramMember = ((Method)localObject2).invoke(paramMember, new Object[0]);
    if (paramMember == null)
    {
      paramMember = new t("null cannot be cast to non-null type kotlin.Array<*>");
      AppMethodBeat.o(57393);
      throw paramMember;
    }
    paramMember = (Object[])paramMember;
    localObject2 = (Collection)new ArrayList(paramMember.length);
    int j = paramMember.length;
    int i = 0;
    while (i < j)
    {
      Object localObject3 = ((Method)localObject1).invoke(paramMember[i], new Object[0]);
      if (localObject3 == null)
      {
        paramMember = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(57393);
        throw paramMember;
      }
      ((Collection)localObject2).add((String)localObject3);
      i += 1;
    }
    paramMember = (List)localObject2;
    AppMethodBeat.o(57393);
    return paramMember;
  }
  
  public static final class a
  {
    final Method aaPQ;
    final Method aaPR;
    
    public a(Method paramMethod1, Method paramMethod2)
    {
      this.aaPQ = paramMethod1;
      this.aaPR = paramMethod2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.a
 * JD-Core Version:    0.7.0.1
 */