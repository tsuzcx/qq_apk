package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.x;
import kotlin.n.n;
import kotlin.r;

public final class f
  extends x
  implements kotlin.l.b.a.b.m.ak
{
  public f(al paramal1, al paramal2)
  {
    this(paramal1, paramal2, false);
    AppMethodBeat.i(58007);
    AppMethodBeat.o(58007);
  }
  
  private f(al paramal1, al paramal2, boolean paramBoolean)
  {
    super(paramal1, paramal2);
    AppMethodBeat.i(58006);
    if (!paramBoolean)
    {
      paramBoolean = kotlin.l.b.a.b.m.a.e.ajqY.d((ad)paramal1, (ad)paramal2);
      if ((kotlin.ak.aiuY) && (!paramBoolean))
      {
        paramal1 = (Throwable)new AssertionError("Lower bound " + paramal1 + " of a flexible type must be a subtype of the upper bound " + paramal2);
        AppMethodBeat.o(58006);
        throw paramal1;
      }
    }
    AppMethodBeat.o(58006);
  }
  
  private static final List<String> a(c paramc, ad paramad)
  {
    AppMethodBeat.i(192152);
    Object localObject = (Iterable)paramad.klR();
    paramad = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramad.add(paramc.a((az)((Iterator)localObject).next()));
    }
    paramc = (List)paramad;
    AppMethodBeat.o(192152);
    return paramc;
  }
  
  private x d(g paramg)
  {
    AppMethodBeat.i(58003);
    s.u(paramg, "kotlinTypeRefiner");
    paramg = (x)new f((al)paramg.aD((ad)this.ajpE), (al)paramg.aD((ad)this.ajpF), true);
    AppMethodBeat.o(58003);
    return paramg;
  }
  
  private static final String rl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192156);
    if (!n.c((CharSequence)paramString1, '<'))
    {
      AppMethodBeat.o(192156);
      return paramString1;
    }
    paramString1 = n.a(paramString1, '<') + '<' + paramString2 + '>' + n.c(paramString1, '>');
    AppMethodBeat.o(192156);
    return paramString1;
  }
  
  public final String a(c paramc, kotlin.l.b.a.b.i.f paramf)
  {
    AppMethodBeat.i(58002);
    s.u(paramc, "renderer");
    s.u(paramf, "options");
    String str2 = paramc.b((ad)this.ajpE);
    String str1 = paramc.b((ad)this.ajpF);
    if (paramf.kyH())
    {
      paramc = "raw (" + str2 + ".." + str1 + ')';
      AppMethodBeat.o(58002);
      return paramc;
    }
    if (this.ajpF.klR().isEmpty())
    {
      paramc = paramc.a(str2, str1, a.aE((ad)this));
      AppMethodBeat.o(58002);
      return paramc;
    }
    paramf = a(paramc, (ad)this.ajpE);
    Object localObject1 = a(paramc, (ad)this.ajpF);
    String str3 = p.a((Iterable)paramf, (CharSequence)", ", null, null, 0, null, (b)f.a.aiUu, 30);
    paramf = (Iterable)p.d((Iterable)paramf, (Iterable)localObject1);
    int i;
    if ((!(paramf instanceof Collection)) || (!((Collection)paramf).isEmpty()))
    {
      paramf = paramf.iterator();
      if (paramf.hasNext())
      {
        Object localObject2 = (r)paramf.next();
        localObject1 = (String)((r)localObject2).bsC;
        localObject2 = (String)((r)localObject2).bsD;
        if ((s.p(localObject1, n.c((String)localObject2, (CharSequence)"out "))) || (s.p(localObject2, "*")))
        {
          i = 1;
          label293:
          if (i != 0) {
            break label340;
          }
          i = 0;
          label299:
          if (i == 0) {
            break label347;
          }
        }
      }
    }
    label340:
    label347:
    for (paramf = rl(str1, str3);; paramf = str1)
    {
      str1 = rl(str2, str3);
      if (!s.p(str1, paramf)) {
        break label353;
      }
      AppMethodBeat.o(58002);
      return str1;
      i = 0;
      break label293;
      break;
      i = 1;
      break label299;
    }
    label353:
    paramc = paramc.a(str1, paramf, a.aE((ad)this));
    AppMethodBeat.o(58002);
    return paramc;
  }
  
  public final h knP()
  {
    AppMethodBeat.i(57999);
    Object localObject = kzm().knA();
    if ((localObject instanceof kotlin.l.b.a.b.b.e)) {}
    for (localObject = (kotlin.l.b.a.b.b.e)localObject; localObject == null; localObject = null)
    {
      localObject = (Throwable)new IllegalStateException(s.X("Incorrect classifier: ", kzm().knA()).toString());
      AppMethodBeat.o(57999);
      throw ((Throwable)localObject);
    }
    localObject = ((kotlin.l.b.a.b.b.e)localObject).a((bc)new e());
    s.s(localObject, "classDescriptor.getMemberScope(RawSubstitution())");
    AppMethodBeat.o(57999);
    return localObject;
  }
  
  public final al ksx()
  {
    return this.ajpE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.f
 * JD-Core Version:    0.7.0.1
 */