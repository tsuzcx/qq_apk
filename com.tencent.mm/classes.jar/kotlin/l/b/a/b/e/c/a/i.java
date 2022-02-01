package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.t;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.f;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.c.a.a;
import kotlin.l.b.a.b.e.c.a.d;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.e;
import kotlin.o;

public final class i
{
  private static final kotlin.l.b.a.b.h.g abfA;
  public static final i abfB;
  
  static
  {
    AppMethodBeat.i(59261);
    abfB = new i();
    kotlin.l.b.a.b.h.g localg = kotlin.l.b.a.b.h.g.iNN();
    kotlin.l.b.a.b.e.c.a.a(localg);
    p.j(localg, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
    abfA = localg;
    AppMethodBeat.o(59261);
  }
  
  public static e.a a(a.m paramm, c paramc, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(59257);
    p.k(paramm, "proto");
    p.k(paramc, "nameResolver");
    p.k(paramh, "typeTable");
    Object localObject = (i.c)paramm;
    i.e locale = kotlin.l.b.a.b.e.c.a.abeC;
    p.j(locale, "JvmProtoBuf.propertySignature");
    localObject = (kotlin.l.b.a.b.e.c.a.c)f.a((i.c)localObject, locale);
    if (localObject == null)
    {
      AppMethodBeat.o(59257);
      return null;
    }
    if (((kotlin.l.b.a.b.e.c.a.c)localObject).iMS()) {}
    for (localObject = ((kotlin.l.b.a.b.e.c.a.c)localObject).abeO; (localObject == null) && (paramBoolean); localObject = null)
    {
      AppMethodBeat.o(59257);
      return null;
    }
    int i;
    if ((localObject != null) && (((a.a)localObject).Cc()))
    {
      i = ((a.a)localObject).abbb;
      if ((localObject == null) || (!((a.a)localObject).iMH())) {
        break label180;
      }
      paramm = paramc.getString(((a.a)localObject).abeL);
    }
    label180:
    do
    {
      paramm = new e.a(paramc.getString(i), paramm);
      AppMethodBeat.o(59257);
      return paramm;
      i = paramm.abbb;
      break;
      paramh = b(kotlin.l.b.a.b.e.b.g.a(paramm, paramh), paramc);
      paramm = paramh;
    } while (paramh != null);
    AppMethodBeat.o(59257);
    return null;
  }
  
  public static e.b a(kotlin.l.b.a.b.e.a.c paramc, c paramc1, h paramh)
  {
    AppMethodBeat.i(59256);
    p.k(paramc, "proto");
    p.k(paramc1, "nameResolver");
    p.k(paramh, "typeTable");
    Object localObject1 = (i.c)paramc;
    Object localObject2 = kotlin.l.b.a.b.e.c.a.abez;
    p.j(localObject2, "JvmProtoBuf.constructorSignature");
    localObject2 = (kotlin.l.b.a.b.e.c.a.b)f.a((i.c)localObject1, (i.e)localObject2);
    if ((localObject2 != null) && (((kotlin.l.b.a.b.e.c.a.b)localObject2).Cc()))
    {
      localObject1 = paramc1.getString(((kotlin.l.b.a.b.e.c.a.b)localObject2).abbb);
      if ((localObject2 == null) || (!((kotlin.l.b.a.b.e.c.a.b)localObject2).iMH())) {
        break label124;
      }
    }
    for (paramc = paramc1.getString(((kotlin.l.b.a.b.e.c.a.b)localObject2).abeL);; paramc = j.a((Iterable)paramc, (CharSequence)"", (CharSequence)"(", (CharSequence)")V", 0, null, null, 56))
    {
      paramc = new e.b((String)localObject1, paramc);
      AppMethodBeat.o(59256);
      return paramc;
      localObject1 = "<init>";
      break;
      label124:
      paramc = paramc.abaK;
      p.j(paramc, "proto.valueParameterList");
      localObject2 = (Iterable)paramc;
      paramc = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (a.t)((Iterator)localObject2).next();
        p.j(localObject3, "it");
        localObject3 = b(kotlin.l.b.a.b.e.b.g.a((a.t)localObject3, paramh), paramc1);
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
    p.k(paramh, "proto");
    p.k(paramc, "nameResolver");
    p.k(paramh1, "typeTable");
    Object localObject1 = (i.c)paramh;
    Object localObject2 = kotlin.l.b.a.b.e.c.a.abeA;
    p.j(localObject2, "JvmProtoBuf.methodSignature");
    localObject1 = (kotlin.l.b.a.b.e.c.a.b)f.a((i.c)localObject1, (i.e)localObject2);
    int i;
    if ((localObject1 != null) && (((kotlin.l.b.a.b.e.c.a.b)localObject1).Cc()))
    {
      i = ((kotlin.l.b.a.b.e.c.a.b)localObject1).abbb;
      if ((localObject1 == null) || (!((kotlin.l.b.a.b.e.c.a.b)localObject1).iMH())) {
        break label128;
      }
    }
    for (paramh = paramc.getString(((kotlin.l.b.a.b.e.c.a.b)localObject1).abeL);; paramh = j.a((Iterable)localObject1, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, null, 56) + paramh)
    {
      paramh = new e.b(paramc.getString(i), paramh);
      AppMethodBeat.o(59255);
      return paramh;
      i = paramh.abbb;
      break;
      label128:
      localObject1 = (Collection)j.eY(kotlin.l.b.a.b.e.b.g.b(paramh, paramh1));
      localObject2 = paramh.abaK;
      p.j(localObject2, "proto.valueParameterList");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        a.t localt = (a.t)((Iterator)localObject3).next();
        p.j(localt, "it");
        ((Collection)localObject2).add(kotlin.l.b.a.b.e.b.g.a(localt, paramh1));
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
      paramh = b(kotlin.l.b.a.b.e.b.g.a(paramh, paramh1), paramc);
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
    paramInputStream = a.d.f(paramInputStream, abfA);
    p.j(paramInputStream, "JvmProtoBuf.StringTableT…this, EXTENSION_REGISTRY)");
    paramInputStream = new g(paramInputStream, paramArrayOfString);
    AppMethodBeat.o(59254);
    return paramInputStream;
  }
  
  private static String b(a.p paramp, c paramc)
  {
    AppMethodBeat.i(59259);
    if (paramp.iLr())
    {
      paramp = b.bGZ(paramc.aFf(paramp.abcf));
      AppMethodBeat.o(59259);
      return paramp;
    }
    AppMethodBeat.o(59259);
    return null;
  }
  
  public static final o<g, kotlin.l.b.a.b.e.a.b> e(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59251);
    p.k(paramArrayOfString1, "data");
    p.k(paramArrayOfString2, "strings");
    paramArrayOfString1 = a.al(paramArrayOfString1);
    p.j(paramArrayOfString1, "BitEncoding.decodeBytes(data)");
    p.k(paramArrayOfString1, "bytes");
    p.k(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(paramArrayOfString1);
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), kotlin.l.b.a.b.e.a.b.a((InputStream)paramArrayOfString1, abfA));
    AppMethodBeat.o(59251);
    return paramArrayOfString1;
  }
  
  public static final o<g, a.k> f(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59252);
    p.k(paramArrayOfString1, "data");
    p.k(paramArrayOfString2, "strings");
    paramArrayOfString1 = a.al(paramArrayOfString1);
    p.j(paramArrayOfString1, "BitEncoding.decodeBytes(data)");
    p.k(paramArrayOfString1, "bytes");
    p.k(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(paramArrayOfString1);
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.k.c((InputStream)paramArrayOfString1, abfA));
    AppMethodBeat.o(59252);
    return paramArrayOfString1;
  }
  
  public static final boolean f(a.m paramm)
  {
    AppMethodBeat.i(59260);
    p.k(paramm, "proto");
    Object localObject = d.abfq;
    localObject = d.iNq();
    paramm = paramm.d(kotlin.l.b.a.b.e.c.a.abeD);
    p.j(paramm, "proto.getExtension(JvmProtoBuf.flags)");
    paramm = ((b.a)localObject).aFe(((Number)paramm).intValue());
    p.j(paramm, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
    boolean bool = paramm.booleanValue();
    AppMethodBeat.o(59260);
    return bool;
  }
  
  public static final o<g, a.h> g(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59253);
    p.k(paramArrayOfString1, "data");
    p.k(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(a.al(paramArrayOfString1));
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.h.b((InputStream)paramArrayOfString1, abfA));
    AppMethodBeat.o(59253);
    return paramArrayOfString1;
  }
  
  public static kotlin.l.b.a.b.h.g iNr()
  {
    return abfA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.i
 * JD-Core Version:    0.7.0.1
 */