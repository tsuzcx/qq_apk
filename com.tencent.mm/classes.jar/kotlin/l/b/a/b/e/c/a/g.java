package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.t;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.e.b.e;
import kotlin.l.b.a.b.e.c.a.a;
import kotlin.l.b.a.b.e.c.a.d;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.e;
import kotlin.r;

public final class g
{
  public static final g ajem;
  private static final kotlin.l.b.a.b.h.g ajen;
  
  static
  {
    AppMethodBeat.i(59261);
    ajem = new g();
    kotlin.l.b.a.b.h.g localg = kotlin.l.b.a.b.h.g.kyf();
    kotlin.l.b.a.b.e.c.a.a(localg);
    s.s(localg, "newInstance().apply(JvmP…f::registerAllExtensions)");
    ajen = localg;
    AppMethodBeat.o(59261);
  }
  
  public static d.a a(a.m paramm, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(59257);
    s.u(paramm, "proto");
    s.u(paramc, "nameResolver");
    s.u(paramg, "typeTable");
    Object localObject = (i.c)paramm;
    i.e locale = kotlin.l.b.a.b.e.c.a.ajdo;
    s.s(locale, "propertySignature");
    localObject = (kotlin.l.b.a.b.e.c.a.c)e.a((i.c)localObject, locale);
    if (localObject == null)
    {
      AppMethodBeat.o(59257);
      return null;
    }
    if (((kotlin.l.b.a.b.e.c.a.c)localObject).kxl()) {}
    for (localObject = ((kotlin.l.b.a.b.e.c.a.c)localObject).ajdB; (localObject == null) && (paramBoolean); localObject = null)
    {
      AppMethodBeat.o(59257);
      return null;
    }
    int i;
    if ((localObject != null) && (((a.a)localObject).hasName()))
    {
      i = ((a.a)localObject).aiZC;
      if ((localObject == null) || (!((a.a)localObject).kxa())) {
        break label180;
      }
      paramm = paramc.getString(((a.a)localObject).ajdy);
    }
    label180:
    do
    {
      paramm = new d.a(paramc.getString(i), paramm);
      AppMethodBeat.o(59257);
      return paramm;
      i = paramm.aiZC;
      break;
      paramg = b(kotlin.l.b.a.b.e.b.f.a(paramm, paramg), paramc);
      paramm = paramg;
    } while (paramg != null);
    AppMethodBeat.o(59257);
    return null;
  }
  
  public static d.b a(kotlin.l.b.a.b.e.a.c paramc, kotlin.l.b.a.b.e.b.c paramc1, kotlin.l.b.a.b.e.b.g paramg)
  {
    AppMethodBeat.i(59256);
    s.u(paramc, "proto");
    s.u(paramc1, "nameResolver");
    s.u(paramg, "typeTable");
    Object localObject1 = (i.c)paramc;
    Object localObject2 = kotlin.l.b.a.b.e.c.a.ajdl;
    s.s(localObject2, "constructorSignature");
    localObject2 = (kotlin.l.b.a.b.e.c.a.b)e.a((i.c)localObject1, (i.e)localObject2);
    if ((localObject2 != null) && (((kotlin.l.b.a.b.e.c.a.b)localObject2).hasName()))
    {
      localObject1 = paramc1.getString(((kotlin.l.b.a.b.e.c.a.b)localObject2).aiZC);
      if ((localObject2 == null) || (!((kotlin.l.b.a.b.e.c.a.b)localObject2).kxa())) {
        break label124;
      }
    }
    for (paramc = paramc1.getString(((kotlin.l.b.a.b.e.c.a.b)localObject2).ajdy);; paramc = p.a((Iterable)paramc, (CharSequence)"", (CharSequence)"(", (CharSequence)")V", 0, null, null, 56))
    {
      paramc = new d.b((String)localObject1, paramc);
      AppMethodBeat.o(59256);
      return paramc;
      localObject1 = "<init>";
      break;
      label124:
      paramc = paramc.aiZl;
      s.s(paramc, "proto.valueParameterList");
      localObject2 = (Iterable)paramc;
      paramc = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (a.t)((Iterator)localObject2).next();
        s.s(localObject3, "it");
        localObject3 = b(kotlin.l.b.a.b.e.b.f.a((a.t)localObject3, paramg), paramc1);
        if (localObject3 == null)
        {
          AppMethodBeat.o(59256);
          return null;
        }
        paramc.add(localObject3);
      }
    }
  }
  
  public static d.b a(a.h paramh, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.g paramg)
  {
    AppMethodBeat.i(59255);
    s.u(paramh, "proto");
    s.u(paramc, "nameResolver");
    s.u(paramg, "typeTable");
    Object localObject1 = (i.c)paramh;
    Object localObject2 = kotlin.l.b.a.b.e.c.a.ajdm;
    s.s(localObject2, "methodSignature");
    localObject1 = (kotlin.l.b.a.b.e.c.a.b)e.a((i.c)localObject1, (i.e)localObject2);
    int i;
    if ((localObject1 != null) && (((kotlin.l.b.a.b.e.c.a.b)localObject1).hasName()))
    {
      i = ((kotlin.l.b.a.b.e.c.a.b)localObject1).aiZC;
      if ((localObject1 == null) || (!((kotlin.l.b.a.b.e.c.a.b)localObject1).kxa())) {
        break label128;
      }
    }
    for (paramh = paramc.getString(((kotlin.l.b.a.b.e.c.a.b)localObject1).ajdy);; paramh = s.X(p.a((Iterable)localObject1, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, null, 56), paramh))
    {
      paramh = new d.b(paramc.getString(i), paramh);
      AppMethodBeat.o(59255);
      return paramh;
      i = paramh.aiZC;
      break;
      label128:
      localObject1 = (Collection)p.hs(kotlin.l.b.a.b.e.b.f.b(paramh, paramg));
      localObject2 = paramh.aiZl;
      s.s(localObject2, "proto.valueParameterList");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        a.t localt = (a.t)((Iterator)localObject3).next();
        s.s(localt, "it");
        ((Collection)localObject2).add(kotlin.l.b.a.b.e.b.f.a(localt, paramg));
      }
      localObject2 = (Iterable)p.b((Collection)localObject1, (Iterable)localObject2);
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
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
      paramh = b(kotlin.l.b.a.b.e.b.f.a(paramh, paramg), paramc);
      if (paramh == null)
      {
        AppMethodBeat.o(59255);
        return null;
      }
    }
  }
  
  private static f a(InputStream paramInputStream, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59254);
    paramInputStream = a.d.f(paramInputStream, ajen);
    s.s(paramInputStream, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
    paramInputStream = new f(paramInputStream, paramArrayOfString);
    AppMethodBeat.o(59254);
    return paramInputStream;
  }
  
  private static String b(a.p paramp, kotlin.l.b.a.b.e.b.c paramc)
  {
    AppMethodBeat.i(59259);
    if (paramp.kvM())
    {
      paramp = b.bJc(paramc.aLW(paramp.ajaG));
      AppMethodBeat.o(59259);
      return paramp;
    }
    AppMethodBeat.o(59259);
    return null;
  }
  
  public static final r<f, kotlin.l.b.a.b.e.a.b> f(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59251);
    s.u(paramArrayOfString1, "data");
    s.u(paramArrayOfString2, "strings");
    paramArrayOfString1 = a.an(paramArrayOfString1);
    s.s(paramArrayOfString1, "decodeBytes(data)");
    s.u(paramArrayOfString1, "bytes");
    s.u(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(paramArrayOfString1);
    paramArrayOfString1 = new r(a((InputStream)paramArrayOfString1, paramArrayOfString2), kotlin.l.b.a.b.e.a.b.a((InputStream)paramArrayOfString1, ajen));
    AppMethodBeat.o(59251);
    return paramArrayOfString1;
  }
  
  public static final boolean f(a.m paramm)
  {
    AppMethodBeat.i(59260);
    s.u(paramm, "proto");
    Object localObject = c.ajdZ;
    localObject = c.kxJ();
    paramm = paramm.e(kotlin.l.b.a.b.e.c.a.ajdp);
    s.s(paramm, "proto.getExtension(JvmProtoBuf.flags)");
    paramm = ((b.a)localObject).aLV(((Number)paramm).intValue());
    s.s(paramm, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
    boolean bool = paramm.booleanValue();
    AppMethodBeat.o(59260);
    return bool;
  }
  
  public static final r<f, a.k> g(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59252);
    s.u(paramArrayOfString1, "data");
    s.u(paramArrayOfString2, "strings");
    paramArrayOfString1 = a.an(paramArrayOfString1);
    s.s(paramArrayOfString1, "decodeBytes(data)");
    s.u(paramArrayOfString1, "bytes");
    s.u(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(paramArrayOfString1);
    paramArrayOfString1 = new r(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.k.c((InputStream)paramArrayOfString1, ajen));
    AppMethodBeat.o(59252);
    return paramArrayOfString1;
  }
  
  public static final r<f, a.h> h(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(59253);
    s.u(paramArrayOfString1, "data");
    s.u(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(a.an(paramArrayOfString1));
    paramArrayOfString1 = new r(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.h.b((InputStream)paramArrayOfString1, ajen));
    AppMethodBeat.o(59253);
    return paramArrayOfString1;
  }
  
  public static kotlin.l.b.a.b.h.g kxK()
  {
    return ajen;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.g
 * JD-Core Version:    0.7.0.1
 */