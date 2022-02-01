package d.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.b.as;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ae;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.m;

public final class d
{
  static final av a(av paramav, as paramas)
  {
    AppMethodBeat.i(60037);
    if ((paramas == null) || (paramav.gcC() == bh.LLV))
    {
      AppMethodBeat.o(60037);
      return paramav;
    }
    if (paramas.fRg() == paramav.gcC())
    {
      if (paramav.gcB())
      {
        paramas = d.l.b.a.b.l.b.LJP;
        k.g(paramas, "LockBasedStorageManager.NO_LOCKS");
        paramav = (av)new ax((ab)new ae(paramas, (d.g.a.a)new a(paramav)));
        AppMethodBeat.o(60037);
        return paramav;
      }
      paramav = (av)new ax(paramav.fRV());
      AppMethodBeat.o(60037);
      return paramav;
    }
    paramav = (av)new ax(b(paramav));
    AppMethodBeat.o(60037);
    return paramav;
  }
  
  public static final boolean ae(ab paramab)
  {
    AppMethodBeat.i(60035);
    k.h(paramab, "$this$isCaptured");
    boolean bool = paramab.gbz() instanceof b;
    AppMethodBeat.o(60035);
    return bool;
  }
  
  private static ab b(av paramav)
  {
    AppMethodBeat.i(60034);
    k.h(paramav, "typeProjection");
    paramav = (ab)new a(paramav);
    AppMethodBeat.o(60034);
    return paramav;
  }
  
  static final class a
    extends l
    implements d.g.a.a<ab>
  {
    a(av paramav)
    {
      super();
    }
  }
  
  public static final class b
    extends m
  {
    b(ay paramay1, ay paramay2)
    {
      super();
    }
    
    public final av O(ab paramab)
    {
      Object localObject = null;
      AppMethodBeat.i(60033);
      k.h(paramab, "key");
      av localav = super.O(paramab);
      if (localav != null)
      {
        paramab = paramab.gbz().fQq();
        if ((paramab instanceof as)) {
          break label65;
        }
        paramab = localObject;
      }
      label65:
      for (;;)
      {
        paramab = d.a(localav, (as)paramab);
        AppMethodBeat.o(60033);
        return paramab;
        AppMethodBeat.o(60033);
        return null;
      }
    }
    
    public final boolean gbB()
    {
      return this.LFr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.a.a.d
 * JD-Core Version:    0.7.0.1
 */