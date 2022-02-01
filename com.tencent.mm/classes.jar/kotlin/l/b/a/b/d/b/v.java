package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.t;

public final class v
{
  public static final v aaYI;
  
  static
  {
    AppMethodBeat.i(58262);
    aaYI = new v();
    AppMethodBeat.o(58262);
  }
  
  public static String a(e parame, String paramString)
  {
    AppMethodBeat.i(58258);
    p.k(parame, "classDescriptor");
    p.k(paramString, "jvmDescriptor");
    p.k(parame, "$this$internalName");
    Object localObject = kotlin.l.b.a.b.a.b.c.aaIT;
    localObject = kotlin.l.b.a.b.j.d.a.o((l)parame).iNy();
    p.j(localObject, "fqNameSafe.toUnsafe()");
    localObject = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.c)localObject);
    if (localObject != null)
    {
      parame = kotlin.l.b.a.b.j.e.c.e((kotlin.l.b.a.b.f.a)localObject);
      p.j(parame, "JvmClassName.byClassId(it)");
      parame = parame.iOY();
      p.j(parame, "JvmClassName.byClassId(it).internalName");
    }
    for (;;)
    {
      parame = pq(parame, paramString);
      AppMethodBeat.o(58258);
      return parame;
      parame = aa.a(parame, (w)x.aaYK);
    }
  }
  
  public static String[] aj(String... paramVarArgs)
  {
    AppMethodBeat.i(58254);
    p.k(paramVarArgs, "signatures");
    Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localCollection.add("<init>(" + str + ")V");
      i += 1;
    }
    paramVarArgs = ((Collection)localCollection).toArray(new String[0]);
    if (paramVarArgs == null)
    {
      paramVarArgs = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(58254);
      throw paramVarArgs;
    }
    paramVarArgs = (String[])paramVarArgs;
    AppMethodBeat.o(58254);
    return paramVarArgs;
  }
  
  public static String bGU(String paramString)
  {
    AppMethodBeat.i(58251);
    p.k(paramString, "name");
    paramString = "java/lang/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58251);
    return paramString;
  }
  
  public static String bGV(String paramString)
  {
    AppMethodBeat.i(58252);
    p.k(paramString, "name");
    paramString = "java/util/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58252);
    return paramString;
  }
  
  public static String bGW(String paramString)
  {
    AppMethodBeat.i(58253);
    p.k(paramString, "name");
    paramString = "java/util/function/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58253);
    return paramString;
  }
  
  private static String bGX(String paramString)
  {
    AppMethodBeat.i(58261);
    if (paramString.length() > 1)
    {
      paramString = "L" + paramString + ';';
      AppMethodBeat.o(58261);
      return paramString;
    }
    AppMethodBeat.o(58261);
    return paramString;
  }
  
  public static String d(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(58260);
    p.k(paramString1, "name");
    p.k(paramList, "parameters");
    p.k(paramString2, "ret");
    paramString1 = paramString1 + '(' + j.a((Iterable)paramList, (CharSequence)"", null, null, 0, null, (kotlin.g.a.b)a.aaYJ, 30) + ')' + bGX(paramString2);
    AppMethodBeat.o(58260);
    return paramString1;
  }
  
  public static String pq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58259);
    p.k(paramString1, "internalName");
    p.k(paramString2, "jvmDescriptor");
    paramString1 = paramString1 + '.' + paramString2;
    AppMethodBeat.o(58259);
    return paramString1;
  }
  
  public static LinkedHashSet<String> q(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58255);
    p.k(paramString, "name");
    p.k(paramVarArgs, "signatures");
    paramString = s(bGU(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(58255);
    return paramString;
  }
  
  public static LinkedHashSet<String> r(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58256);
    p.k(paramString, "name");
    p.k(paramVarArgs, "signatures");
    paramString = s(bGV(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(58256);
    return paramString;
  }
  
  private static LinkedHashSet<String> s(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58257);
    p.k(paramString, "internalName");
    p.k(paramVarArgs, "signatures");
    Collection localCollection = (Collection)new LinkedHashSet();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localCollection.add(paramString + '.' + str);
      i += 1;
    }
    paramString = (LinkedHashSet)localCollection;
    AppMethodBeat.o(58257);
    return paramString;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<String, String>
  {
    public static final a aaYJ;
    
    static
    {
      AppMethodBeat.i(58250);
      aaYJ = new a();
      AppMethodBeat.o(58250);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.v
 * JD-Core Version:    0.7.0.1
 */