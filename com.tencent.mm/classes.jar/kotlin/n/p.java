package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
public class p
  extends o
{
  public static final String bJB(String paramString)
  {
    AppMethodBeat.i(129467);
    s.u(paramString, "$this$trimIndent");
    paramString = n.rr(paramString, "");
    AppMethodBeat.o(129467);
    return paramString;
  }
  
  private static final int bJC(String paramString)
  {
    AppMethodBeat.i(129469);
    CharSequence localCharSequence = (CharSequence)paramString;
    int k = localCharSequence.length();
    int i = 0;
    int j;
    if (i < k) {
      if (!a.I(localCharSequence.charAt(i)))
      {
        j = 1;
        label42:
        if (j == 0) {
          break label68;
        }
      }
    }
    for (;;)
    {
      if (i != -1) {
        break label80;
      }
      i = paramString.length();
      AppMethodBeat.o(129469);
      return i;
      j = 0;
      break label42;
      label68:
      i += 1;
      break;
      i = -1;
    }
    label80:
    AppMethodBeat.o(129469);
    return i;
  }
  
  private static final b<String, String> bJD(String paramString)
  {
    AppMethodBeat.i(129470);
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (b)a.ajuZ;
      AppMethodBeat.o(129470);
      return paramString;
    }
    paramString = (b)new b(paramString);
    AppMethodBeat.o(129470);
    return paramString;
  }
  
  public static final String rq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190910);
    s.u(paramString1, "$this$trimMargin");
    s.u(paramString2, "marginPrefix");
    s.u(paramString1, "$this$replaceIndentByMargin");
    s.u("", "newIndent");
    s.u(paramString2, "marginPrefix");
    if (!n.bp((CharSequence)paramString2)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = (Throwable)new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
      AppMethodBeat.o(190910);
      throw paramString1;
    }
    Object localObject = n.bw((CharSequence)paramString1);
    int m = paramString1.length();
    int n = "".length();
    int i1 = ((List)localObject).size();
    b localb = bJD("");
    int i2 = kotlin.a.p.oE((List)localObject);
    paramString1 = (Iterable)localObject;
    Collection localCollection = (Collection)new ArrayList();
    i = 0;
    Iterator localIterator = paramString1.iterator();
    while (localIterator.hasNext())
    {
      paramString1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject = (String)paramString1;
      if (((i == 0) || (i == i2)) && (n.bp((CharSequence)localObject)))
      {
        paramString1 = null;
        if (paramString1 != null)
        {
          localCollection.add(paramString1);
          i = j;
        }
      }
      else
      {
        paramString1 = (CharSequence)localObject;
        i = 0;
        int i3 = paramString1.length();
        int k;
        if (i < i3) {
          if (!a.I(paramString1.charAt(i)))
          {
            k = 1;
            label267:
            if (k == 0) {
              break label334;
            }
          }
        }
        for (;;)
        {
          if (i != -1)
          {
            s.u(localObject, "$this$startsWith");
            s.u(paramString2, "prefix");
            if (((String)localObject).startsWith(paramString2, i))
            {
              k = paramString2.length();
              if (localObject == null)
              {
                paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(190910);
                throw paramString1;
                k = 0;
                break label267;
                label334:
                i += 1;
                break;
                i = -1;
                continue;
              }
              paramString1 = ((String)localObject).substring(i + k);
              s.s(paramString1, "(this as java.lang.String).substring(startIndex)");
            }
          }
        }
        for (;;)
        {
          if (paramString1 != null)
          {
            String str = (String)localb.invoke(paramString1);
            paramString1 = str;
            if (str != null) {
              break;
            }
          }
          paramString1 = (String)localObject;
          break;
          paramString1 = null;
        }
      }
      i = j;
    }
    paramString1 = ((StringBuilder)kotlin.a.p.a((Iterable)localCollection, (Appendable)new StringBuilder(m + n * i1), (CharSequence)"\n", null, null, 0, null, null, 124)).toString();
    s.s(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    AppMethodBeat.o(190910);
    return paramString1;
  }
  
  public static final String rr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129468);
    s.u(paramString1, "$this$replaceIndent");
    s.u(paramString2, "newIndent");
    Object localObject1 = n.bw((CharSequence)paramString1);
    Object localObject3 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    int i;
    label109:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (!n.bp((CharSequence)localObject4)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label109;
        }
        ((Collection)localObject2).add(localObject4);
        break;
      }
    }
    localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Integer.valueOf(bJC((String)((Iterator)localObject3).next())));
    }
    localObject2 = (Integer)kotlin.a.p.z((Iterable)localObject2);
    int j;
    int m;
    int n;
    int i1;
    int i2;
    if (localObject2 != null)
    {
      j = ((Integer)localObject2).intValue();
      m = paramString1.length();
      n = paramString2.length();
      i1 = ((List)localObject1).size();
      localObject2 = bJD(paramString2);
      i2 = kotlin.a.p.oE((List)localObject1);
      paramString1 = (Iterable)localObject1;
      localObject3 = (Collection)new ArrayList();
      localObject4 = paramString1.iterator();
      i = 0;
    }
    for (;;)
    {
      label275:
      if (!((Iterator)localObject4).hasNext()) {
        break label398;
      }
      paramString1 = ((Iterator)localObject4).next();
      int k = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      paramString2 = (String)paramString1;
      if (((i == 0) || (i == i2)) && (n.bp((CharSequence)paramString2))) {
        paramString1 = null;
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label392;
        }
        ((Collection)localObject3).add(paramString1);
        i = k;
        break label275;
        j = 0;
        break;
        paramString1 = n.jO(paramString2, j);
        if (paramString1 != null)
        {
          localObject1 = (String)((b)localObject2).invoke(paramString1);
          paramString1 = (String)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramString1 = paramString2;
        }
      }
      label392:
      i = k;
    }
    label398:
    paramString1 = ((StringBuilder)kotlin.a.p.a((Iterable)localObject3, (Appendable)new StringBuilder(m + n * i1), (CharSequence)"\n", null, null, 0, null, null, 124)).toString();
    s.s(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    AppMethodBeat.o(129468);
    return paramString1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "line", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends u
    implements b<String, String>
  {
    public static final a ajuZ;
    
    static
    {
      AppMethodBeat.i(129443);
      ajuZ = new a();
      AppMethodBeat.o(129443);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "line", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements b<String, String>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.p
 * JD-Core Version:    0.7.0.1
 */