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
  public static final v TvS;
  
  static
  {
    AppMethodBeat.i(58262);
    TvS = new v();
    AppMethodBeat.o(58262);
  }
  
  public static String a(e parame, String paramString)
  {
    AppMethodBeat.i(58258);
    p.h(parame, "classDescriptor");
    p.h(paramString, "jvmDescriptor");
    p.h(parame, "$this$internalName");
    Object localObject = kotlin.l.b.a.b.a.b.c.TfZ;
    localObject = kotlin.l.b.a.b.j.d.a.o((l)parame).hJe();
    p.g(localObject, "fqNameSafe.toUnsafe()");
    localObject = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.c)localObject);
    if (localObject != null)
    {
      parame = kotlin.l.b.a.b.j.e.c.e((kotlin.l.b.a.b.f.a)localObject);
      p.g(parame, "JvmClassName.byClassId(it)");
      parame = parame.hKI();
      p.g(parame, "JvmClassName.byClassId(it).internalName");
    }
    for (;;)
    {
      parame = ov(parame, paramString);
      AppMethodBeat.o(58258);
      return parame;
      parame = aa.a(parame, (w)x.TvU);
    }
  }
  
  public static String[] aj(String... paramVarArgs)
  {
    AppMethodBeat.i(58254);
    p.h(paramVarArgs, "signatures");
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
  
  public static String btR(String paramString)
  {
    AppMethodBeat.i(58251);
    p.h(paramString, "name");
    paramString = "java/lang/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58251);
    return paramString;
  }
  
  public static String btS(String paramString)
  {
    AppMethodBeat.i(58252);
    p.h(paramString, "name");
    paramString = "java/util/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58252);
    return paramString;
  }
  
  public static String btT(String paramString)
  {
    AppMethodBeat.i(58253);
    p.h(paramString, "name");
    paramString = "java/util/function/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58253);
    return paramString;
  }
  
  private static String btU(String paramString)
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
  
  public static String e(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(58260);
    p.h(paramString1, "name");
    p.h(paramList, "parameters");
    p.h(paramString2, "ret");
    paramString1 = paramString1 + '(' + j.a((Iterable)paramList, (CharSequence)"", null, null, 0, null, (kotlin.g.a.b)a.TvT, 30) + ')' + btU(paramString2);
    AppMethodBeat.o(58260);
    return paramString1;
  }
  
  public static String ov(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58259);
    p.h(paramString1, "internalName");
    p.h(paramString2, "jvmDescriptor");
    paramString1 = paramString1 + '.' + paramString2;
    AppMethodBeat.o(58259);
    return paramString1;
  }
  
  public static LinkedHashSet<String> r(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58255);
    p.h(paramString, "name");
    p.h(paramVarArgs, "signatures");
    paramString = t(btR(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(58255);
    return paramString;
  }
  
  public static LinkedHashSet<String> s(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58256);
    p.h(paramString, "name");
    p.h(paramVarArgs, "signatures");
    paramString = t(btS(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(58256);
    return paramString;
  }
  
  private static LinkedHashSet<String> t(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58257);
    p.h(paramString, "internalName");
    p.h(paramVarArgs, "signatures");
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
    public static final a TvT;
    
    static
    {
      AppMethodBeat.i(58250);
      TvT = new a();
      AppMethodBeat.o(58250);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.v
 * JD-Core Version:    0.7.0.1
 */