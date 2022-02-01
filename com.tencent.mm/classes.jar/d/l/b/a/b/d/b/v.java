package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.b.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public final class v
{
  public static final v JEQ;
  
  static
  {
    AppMethodBeat.i(58262);
    JEQ = new v();
    AppMethodBeat.o(58262);
  }
  
  public static String a(e parame, String paramString)
  {
    AppMethodBeat.i(58258);
    k.h(parame, "classDescriptor");
    k.h(paramString, "jvmDescriptor");
    k.h(parame, "$this$internalName");
    Object localObject = d.l.b.a.b.a.b.c.JoY;
    localObject = d.l.b.a.b.j.d.a.o((d.l.b.a.b.b.l)parame).fHc();
    k.g(localObject, "fqNameSafe.toUnsafe()");
    localObject = d.l.b.a.b.a.b.c.c((d.l.b.a.b.f.c)localObject);
    if (localObject != null)
    {
      parame = d.l.b.a.b.j.e.c.e((d.l.b.a.b.f.a)localObject);
      k.g(parame, "JvmClassName.byClassId(it)");
      parame = parame.fJb();
      k.g(parame, "JvmClassName.byClassId(it).internalName");
    }
    for (;;)
    {
      parame = mw(parame, paramString);
      AppMethodBeat.o(58258);
      return parame;
      parame = aa.a(parame, (w)x.JES);
    }
  }
  
  public static String aQv(String paramString)
  {
    AppMethodBeat.i(58251);
    k.h(paramString, "name");
    paramString = "java/lang/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58251);
    return paramString;
  }
  
  public static String aQw(String paramString)
  {
    AppMethodBeat.i(58252);
    k.h(paramString, "name");
    paramString = "java/util/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58252);
    return paramString;
  }
  
  public static String aQx(String paramString)
  {
    AppMethodBeat.i(58253);
    k.h(paramString, "name");
    paramString = "java/util/function/".concat(String.valueOf(paramString));
    AppMethodBeat.o(58253);
    return paramString;
  }
  
  private static String aQy(String paramString)
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
  
  public static String[] ag(String... paramVarArgs)
  {
    AppMethodBeat.i(58254);
    k.h(paramVarArgs, "signatures");
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
      paramVarArgs = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(58254);
      throw paramVarArgs;
    }
    paramVarArgs = (String[])paramVarArgs;
    AppMethodBeat.o(58254);
    return paramVarArgs;
  }
  
  public static String f(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(58260);
    k.h(paramString1, "name");
    k.h(paramList, "parameters");
    k.h(paramString2, "ret");
    paramString1 = paramString1 + '(' + j.a((Iterable)paramList, (CharSequence)"", null, null, 0, null, (d.g.a.b)a.JER, 30) + ')' + aQy(paramString2);
    AppMethodBeat.o(58260);
    return paramString1;
  }
  
  public static String mw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58259);
    k.h(paramString1, "internalName");
    k.h(paramString2, "jvmDescriptor");
    paramString1 = paramString1 + '.' + paramString2;
    AppMethodBeat.o(58259);
    return paramString1;
  }
  
  public static LinkedHashSet<String> r(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58255);
    k.h(paramString, "name");
    k.h(paramVarArgs, "signatures");
    paramString = t(aQv(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(58255);
    return paramString;
  }
  
  public static LinkedHashSet<String> s(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58256);
    k.h(paramString, "name");
    k.h(paramVarArgs, "signatures");
    paramString = t(aQw(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(58256);
    return paramString;
  }
  
  private static LinkedHashSet<String> t(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(58257);
    k.h(paramString, "internalName");
    k.h(paramVarArgs, "signatures");
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
    extends d.g.b.l
    implements d.g.a.b<String, String>
  {
    public static final a JER;
    
    static
    {
      AppMethodBeat.i(58250);
      JER = new a();
      AppMethodBeat.o(58250);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.v
 * JD-Core Version:    0.7.0.1
 */