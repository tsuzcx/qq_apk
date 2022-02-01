package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

public final class v
{
  public static final v aiXe;
  
  static
  {
    AppMethodBeat.i(58262);
    aiXe = new v();
    AppMethodBeat.o(58262);
  }
  
  public static String[] al(String... paramVarArgs)
  {
    AppMethodBeat.i(58254);
    s.u(paramVarArgs, "signatures");
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
      paramVarArgs = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(58254);
      throw paramVarArgs;
    }
    paramVarArgs = (String[])paramVarArgs;
    AppMethodBeat.o(58254);
    return paramVarArgs;
  }
  
  public static String bIX(String paramString)
  {
    AppMethodBeat.i(58251);
    s.u(paramString, "name");
    paramString = s.X("java/lang/", paramString);
    AppMethodBeat.o(58251);
    return paramString;
  }
  
  public static String bIY(String paramString)
  {
    AppMethodBeat.i(58252);
    s.u(paramString, "name");
    paramString = s.X("java/util/", paramString);
    AppMethodBeat.o(58252);
    return paramString;
  }
  
  public static String bIZ(String paramString)
  {
    AppMethodBeat.i(58253);
    s.u(paramString, "name");
    paramString = s.X("java/util/function/", paramString);
    AppMethodBeat.o(58253);
    return paramString;
  }
  
  private static String bJa(String paramString)
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
    s.u(paramString1, "name");
    s.u(paramList, "parameters");
    s.u(paramString2, "ret");
    paramString1 = paramString1 + '(' + p.a((Iterable)paramList, (CharSequence)"", null, null, 0, null, (b)a.aiXf, 30) + ')' + bJa(paramString2);
    AppMethodBeat.o(58260);
    return paramString1;
  }
  
  public static String ro(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58259);
    s.u(paramString1, "internalName");
    s.u(paramString2, "jvmDescriptor");
    paramString1 = paramString1 + '.' + paramString2;
    AppMethodBeat.o(58259);
    return paramString1;
  }
  
  public static Set<String> s(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(191934);
    s.u(paramString, "name");
    s.u(paramVarArgs, "signatures");
    paramString = u(bIX(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(191934);
    return paramString;
  }
  
  public static Set<String> t(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(191937);
    s.u(paramString, "name");
    s.u(paramVarArgs, "signatures");
    paramString = u(bIY(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(191937);
    return paramString;
  }
  
  private static Set<String> u(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(191942);
    s.u(paramString, "internalName");
    s.u(paramVarArgs, "signatures");
    Collection localCollection = (Collection)new LinkedHashSet();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localCollection.add(paramString + '.' + str);
      i += 1;
    }
    paramString = (Set)localCollection;
    AppMethodBeat.o(191942);
    return paramString;
  }
  
  static final class a
    extends u
    implements b<String, CharSequence>
  {
    public static final a aiXf;
    
    static
    {
      AppMethodBeat.i(58250);
      aiXf = new a();
      AppMethodBeat.o(58250);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.v
 * JD-Core Version:    0.7.0.1
 */