package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, iBN=1)
public class p
  extends o
{
  public static final String bHx(String paramString)
  {
    AppMethodBeat.i(129467);
    kotlin.g.b.p.k(paramString, "$this$trimIndent");
    paramString = n.pt(paramString, "");
    AppMethodBeat.o(129467);
    return paramString;
  }
  
  private static final int bHy(String paramString)
  {
    AppMethodBeat.i(129469);
    CharSequence localCharSequence = (CharSequence)paramString;
    int k = localCharSequence.length();
    int i = 0;
    int j;
    if (i < k) {
      if (!a.O(localCharSequence.charAt(i)))
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
  
  private static final b<String, String> bHz(String paramString)
  {
    AppMethodBeat.i(129470);
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (b)a.abvO;
      AppMethodBeat.o(129470);
      return paramString;
    }
    paramString = (b)new b(paramString);
    AppMethodBeat.o(129470);
    return paramString;
  }
  
  public static final String pt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129468);
    kotlin.g.b.p.k(paramString1, "$this$replaceIndent");
    kotlin.g.b.p.k(paramString2, "newIndent");
    Object localObject1 = n.bh((CharSequence)paramString1);
    Object localObject3 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    int i;
    label109:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (!n.ba((CharSequence)localObject4)) {}
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
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Integer.valueOf(bHy((String)((Iterator)localObject3).next())));
    }
    localObject2 = (Integer)j.y((Iterable)localObject2);
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
      localObject2 = bHz(paramString2);
      i2 = j.lk((List)localObject1);
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
        j.iBO();
      }
      paramString2 = (String)paramString1;
      if (((i == 0) || (i == i2)) && (n.ba((CharSequence)paramString2))) {
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
        paramString1 = n.iE(paramString2, j);
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
    paramString1 = ((StringBuilder)j.a((Iterable)localObject3, (Appendable)new StringBuilder(m + n * i1), (CharSequence)"\n", null, null, 0, null, null, 124)).toString();
    kotlin.g.b.p.j(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    AppMethodBeat.o(129468);
    return paramString1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "line", "invoke"})
  static final class a
    extends q
    implements b<String, String>
  {
    public static final a abvO;
    
    static
    {
      AppMethodBeat.i(129443);
      abvO = new a();
      AppMethodBeat.o(129443);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "line", "invoke"})
  static final class b
    extends q
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