package d.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.k;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.t;
import d.l.b.a.b.e.b.b.a;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.f;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.e.c.a.a;
import d.l.b.a.b.e.c.a.d;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.f;
import d.o;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class i
{
  private static final d.l.b.a.b.h.g Nqc;
  public static final i Nqd;
  
  static
  {
    AppMethodBeat.i(59261);
    Nqd = new i();
    d.l.b.a.b.h.g localg = d.l.b.a.b.h.g.grD();
    d.l.b.a.b.e.c.a.a(localg);
    p.g(localg, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
    Nqc = localg;
    AppMethodBeat.o(59261);
  }
  
  public static e.a a(a.m paramm, c paramc, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(59257);
    p.h(paramm, "proto");
    p.h(paramc, "nameResolver");
    p.h(paramh, "typeTable");
    Object localObject = (i.c)paramm;
    i.f localf = d.l.b.a.b.e.c.a.Npe;
    p.g(localf, "JvmProtoBuf.propertySignature");
    localObject = (d.l.b.a.b.e.c.a.c)f.a((i.c)localObject, localf);
    if (localObject == null)
    {
      AppMethodBeat.o(59257);
      return null;
    }
    if (((d.l.b.a.b.e.c.a.c)localObject).gqz()) {}
    for (localObject = ((d.l.b.a.b.e.c.a.c)localObject).Npq; (localObject == null) && (paramBoolean); localObject = null)
    {
      AppMethodBeat.o(59257);
      return null;
    }
    int i;
    if ((localObject != null) && (((a.a)localObject).gnL()))
    {
      i = ((a.a)localObject).NlC;
      if ((localObject == null) || (!((a.a)localObject).gqo())) {
        break label180;
      }
      paramm = paramc.getString(((a.a)localObject).Npn);
    }
    label180:
    do
    {
      paramm = new e.a(paramc.getString(i), paramm);
      AppMethodBeat.o(59257);
      return paramm;
      i = paramm.NlC;
      break;
      paramh = b(d.l.b.a.b.e.b.g.a(paramm, paramh), paramc);
      paramm = paramh;
    } while (paramh != null);
    AppMethodBeat.o(59257);
    return null;
  }
  
  public static e.b a(d.l.b.a.b.e.a.c paramc, c paramc1, h paramh)
  {
    AppMethodBeat.i(59256);
    p.h(paramc, "proto");
    p.h(paramc1, "nameResolver");
    p.h(paramh, "typeTable");
    Object localObject1 = (i.c)paramc;
    Object localObject2 = d.l.b.a.b.e.c.a.Npb;
    p.g(localObject2, "JvmProtoBuf.constructorSignature");
    localObject2 = (d.l.b.a.b.e.c.a.b)f.a((i.c)localObject1, (i.f)localObject2);
    if ((localObject2 != null) && (((d.l.b.a.b.e.c.a.b)localObject2).gnL()))
    {
      localObject1 = paramc1.getString(((d.l.b.a.b.e.c.a.b)localObject2).NlC);
      if ((localObject2 == null) || (!((d.l.b.a.b.e.c.a.b)localObject2).gqo())) {
        break label124;
      }
    }
    for (paramc = paramc1.getString(((d.l.b.a.b.e.c.a.b)localObject2).Npn);; paramc = j.a((Iterable)paramc, (CharSequence)"", (CharSequence)"(", (CharSequence)")V", 0, null, null, 56))
    {
      paramc = new e.b((String)localObject1, paramc);
      AppMethodBeat.o(59256);
      return paramc;
      localObject1 = "<init>";
      break;
      label124:
      paramc = paramc.Nll;
      p.g(paramc, "proto.valueParameterList");
      localObject2 = (Iterable)paramc;
      paramc = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (a.t)((Iterator)localObject2).next();
        p.g(localObject3, "it");
        localObject3 = b(d.l.b.a.b.e.b.g.a((a.t)localObject3, paramh), paramc1);
        if (localObject3 == null)
        {
          AppMethodBeat.o(59256);
          return null;
        }
        paramc.add(localObject3);
      }
    }
  }
  
  public static e.b a(a.h paramh, c paramc, h paramh1)
  {
    AppMethodBeat.i(59255);
    p.h(paramh, "proto");
    p.h(paramc, "nameResolver");
    p.h(paramh1, "typeTable");
    Object localObject1 = (i.c)paramh;
    Object localObject2 = d.l.b.a.b.e.c.a.Npc;
    p.g(localObject2, "JvmProtoBuf.methodSignature");
    localObject1 = (d.l.b.a.b.e.c.a.b)f.a((i.c)localObject1, (i.f)localObject2);
    int i;
    if ((localObject1 != null) && (((d.l.b.a.b.e.c.a.b)localObject1).gnL()))
    {
      i = ((d.l.b.a.b.e.c.a.b)localObject1).NlC;
      if ((localObject1 == null) || (!((d.l.b.a.b.e.c.a.b)localObject1).gqo())) {
        break label128;
      }
    }
    for (paramh = paramc.getString(((d.l.b.a.b.e.c.a.b)localObject1).Npn);; paramh = j.a((Iterable)localObject1, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, null, 56) + paramh)
    {
      paramh = new e.b(paramc.getString(i), paramh);
      AppMethodBeat.o(59255);
      return paramh;
      i = paramh.NlC;
      break;
      label128:
      localObject1 = (Collection)j.eM(d.l.b.a.b.e.b.g.b(paramh, paramh1));
      localObject2 = paramh.Nll;
      p.g(localObject2, "proto.valueParameterList");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        a.t localt = (a.t)((Iterator)localObject3).next();
        p.g(localt, "it");
        ((Collection)localObject2).add(d.l.b.a.b.e.b.g.a(localt, paramh1));
      }
      localObject2 = (Iterable)j.b((Collection)localObject1, (Iterable)localObject2);
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = b((a.p)((Iterator)localObject2).next(), paramc);
        if (localObject3 == null)
        {
          AppMethodBeat.o(59255);
          return null;
        }
        ((Collection)localObject1).add(localObject3);
      }
      localObject1 = (List)localObject1;
      paramh = b(d.l.b.a.b.e.b.g.a(paramh, paramh1), paramc);
      if (paramh == null)
      {
        AppMethodBeat.o(59255);
        return null;
      }
    }
  }
  
  private static g a(InputStream paramInputStream, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59254);
    paramInputStream = a.d.f(paramInputStream, Nqc);
    p.g(paramInputStream, "JvmProtoBuf.StringTableT…this, EXTENSION_REGISTRY)");
    paramInputStream = new g(paramInputStream, paramArrayOfString);
    AppMethodBeat.o(59254);
    return paramInputStream;
  }
  
  private static String b(a.p paramp, c paramc)
  {
    AppMethodBeat.i(59259);
    if (paramp.goY())
    {
      paramp = b.bcC(paramc.akL(paramp.NmG));
      AppMethodBeat.o(59259);
      return paramp;
    }
    AppMethodBeat.o(59259);
    return null;
  }
  
  public static final o<g, d.l.b.a.b.e.a.b> e(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59251);
    p.h(paramArrayOfString1, "data");
    p.h(paramArrayOfString2, "strings");
    paramArrayOfString1 = a.ap(paramArrayOfString1);
    p.g(paramArrayOfString1, "BitEncoding.decodeBytes(data)");
    p.h(paramArrayOfString1, "bytes");
    p.h(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(paramArrayOfString1);
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), d.l.b.a.b.e.a.b.a((InputStream)paramArrayOfString1, Nqc));
    AppMethodBeat.o(59251);
    return paramArrayOfString1;
  }
  
  public static final o<g, a.k> f(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59252);
    p.h(paramArrayOfString1, "data");
    p.h(paramArrayOfString2, "strings");
    paramArrayOfString1 = a.ap(paramArrayOfString1);
    p.g(paramArrayOfString1, "BitEncoding.decodeBytes(data)");
    p.h(paramArrayOfString1, "bytes");
    p.h(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(paramArrayOfString1);
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.k.c((InputStream)paramArrayOfString1, Nqc));
    AppMethodBeat.o(59252);
    return paramArrayOfString1;
  }
  
  public static final boolean f(a.m paramm)
  {
    AppMethodBeat.i(59260);
    p.h(paramm, "proto");
    Object localObject = d.NpS;
    localObject = d.gqX();
    paramm = paramm.e(d.l.b.a.b.e.c.a.Npf);
    p.g(paramm, "proto.getExtension(JvmProtoBuf.flags)");
    paramm = ((b.a)localObject).akK(((Number)paramm).intValue());
    p.g(paramm, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
    boolean bool = paramm.booleanValue();
    AppMethodBeat.o(59260);
    return bool;
  }
  
  public static final o<g, a.h> g(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59253);
    p.h(paramArrayOfString1, "data");
    p.h(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(a.ap(paramArrayOfString1));
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.h.b((InputStream)paramArrayOfString1, Nqc));
    AppMethodBeat.o(59253);
    return paramArrayOfString1;
  }
  
  public static d.l.b.a.b.h.g gqY()
  {
    return Nqc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.c.a.i
 * JD-Core Version:    0.7.0.1
 */