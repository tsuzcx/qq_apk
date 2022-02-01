package kotlin.l.b.a.b.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.ah;
import kotlin.g.b.s;
import kotlin.k.g;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.c.y;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.e.a.l;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.l.m;

public final class b
  extends kotlin.l.b.a.b.k.a.p
  implements kotlin.l.b.a.b.a.b
{
  public static final a ajnc;
  private final boolean ajnd;
  
  static
  {
    AppMethodBeat.i(60389);
    ajnc = new a((byte)0);
    AppMethodBeat.o(60389);
  }
  
  private b(c paramc, m paramm, ae paramae, a.l paraml, kotlin.l.b.a.b.e.a.a parama, boolean paramBoolean)
  {
    super(paramc, paramm, paramae, paraml, (kotlin.l.b.a.b.e.b.a)parama);
    AppMethodBeat.i(192284);
    this.ajnd = false;
    AppMethodBeat.o(192284);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192300);
    String str = "builtins package fragment for " + this.aiIl + " from " + kotlin.l.b.a.b.j.d.a.F((l)this);
    AppMethodBeat.o(192300);
    return str;
  }
  
  public static final class a
  {
    public static b a(c paramc, m paramm, ae paramae, InputStream paramInputStream)
    {
      AppMethodBeat.i(60387);
      s.u(paramc, "fqName");
      s.u(paramm, "storageManager");
      s.u(paramae, "module");
      s.u(paramInputStream, "inputStream");
      paramInputStream = (Closeable)paramInputStream;
      try
      {
        Object localObject1 = (InputStream)paramInputStream;
        Object localObject2 = kotlin.l.b.a.b.e.a.a.ajbR;
        s.u(localObject1, "stream");
        localObject2 = new DataInputStream((InputStream)localObject1);
        Object localObject3 = (Iterable)new g(1, ((DataInputStream)localObject2).readInt());
        Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ((ah)localObject3).Zo();
          localCollection.add(Integer.valueOf(((DataInputStream)localObject2).readInt()));
        }
        return paramc;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(60387);
          throw paramc;
        }
        finally
        {
          kotlin.f.b.a(paramInputStream, paramc);
          AppMethodBeat.o(60387);
        }
        localObject2 = kotlin.a.p.I((Collection)localCollection);
        localObject2 = new kotlin.l.b.a.b.e.a.a(Arrays.copyOf((int[])localObject2, localObject2.length));
        if (!((kotlin.l.b.a.b.e.a.a)localObject2).axM())
        {
          paramc = new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + kotlin.l.b.a.b.e.a.a.ajbS + ", actual " + localObject2 + ". Please update Kotlin");
          AppMethodBeat.o(60387);
          throw paramc;
        }
        localObject1 = a.l.d((InputStream)localObject1, a.ajnb.ajlB);
        kotlin.f.b.a(paramInputStream, null);
        s.s(localObject1, "proto");
        paramc = new b(paramc, paramm, paramae, (a.l)localObject1, (kotlin.l.b.a.b.e.a.a)localObject2);
        AppMethodBeat.o(60387);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */