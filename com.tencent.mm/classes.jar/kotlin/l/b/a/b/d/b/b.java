package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.d;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.j.b.h;
import kotlin.l.b.a.b.j.b.j;
import kotlin.l.b.a.b.j.b.k;
import kotlin.l.b.a.b.j.b.k.a;
import kotlin.l.b.a.b.j.b.q;
import kotlin.l.b.a.b.m.ad;

public final class b
  extends a<c, g<?>>
{
  private final ag aiBS;
  private final ae aiEx;
  private final kotlin.l.b.a.b.k.a.e aiWm;
  
  public b(ae paramae, ag paramag, kotlin.l.b.a.b.l.m paramm, m paramm1)
  {
    super(paramm, paramm1);
    AppMethodBeat.i(58180);
    this.aiEx = paramae;
    this.aiBS = paramag;
    this.aiWm = new kotlin.l.b.a.b.k.a.e(this.aiEx, this.aiBS);
    AppMethodBeat.o(58180);
  }
  
  protected final o.a a(kotlin.l.b.a.b.f.b paramb, final av paramav, final List<c> paramList)
  {
    AppMethodBeat.i(58179);
    s.u(paramb, "annotationClassId");
    s.u(paramav, "source");
    s.u(paramList, "result");
    paramb = (o.a)new a(this, w.a(this.aiEx, paramb, this.aiBS), paramList, paramav);
    AppMethodBeat.o(58179);
    return paramb;
  }
  
  public static final class a
    implements o.a
  {
    final HashMap<kotlin.l.b.a.b.f.f, g<?>> aiWn;
    
    a(b paramb, kotlin.l.b.a.b.b.e parame, List<c> paramList, av paramav)
    {
      AppMethodBeat.i(58176);
      this.aiWn = new HashMap();
      AppMethodBeat.o(58176);
    }
    
    static g<?> b(kotlin.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58175);
      paramObject = h.ajjE.jdMethod_if(paramObject);
      if (paramObject == null)
      {
        paramObject = k.ajjJ;
        paramf = (g)k.a.bJo(s.X("Unsupported annotation argument: ", paramf));
        AppMethodBeat.o(58175);
        return paramf;
      }
      AppMethodBeat.o(58175);
      return paramObject;
    }
    
    public final o.a a(final kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(58173);
      s.u(paramf, "name");
      s.u(paramb, "classId");
      final ArrayList localArrayList = new ArrayList();
      b localb = this.aiWo;
      av localav = av.aiHu;
      s.s(localav, "NO_SOURCE");
      paramb = localb.a(paramb, localav, (List)localArrayList);
      s.checkNotNull(paramb);
      paramf = (o.a)new a(paramb, this, paramf, localArrayList);
      AppMethodBeat.o(58173);
      return paramf;
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58169);
      if (paramf != null) {
        ((Map)this.aiWn).put(paramf, b(paramf, paramObject));
      }
      AppMethodBeat.o(58169);
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf1, kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf2)
    {
      AppMethodBeat.i(58171);
      s.u(paramf1, "name");
      s.u(paramb, "enumClassId");
      s.u(paramf2, "enumEntryName");
      ((Map)this.aiWn).put(paramf1, new j(paramb, paramf2));
      AppMethodBeat.o(58171);
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.j.b.f paramf1)
    {
      AppMethodBeat.i(58170);
      s.u(paramf, "name");
      s.u(paramf1, "value");
      ((Map)this.aiWn).put(paramf, new q(paramf1));
      AppMethodBeat.o(58170);
    }
    
    public final void azp()
    {
      AppMethodBeat.i(58174);
      paramList.add(new d((ad)this.aiWp.koj(), (Map)this.aiWn, paramav));
      AppMethodBeat.o(58174);
    }
    
    public final o.b o(final kotlin.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(58172);
      s.u(paramf, "name");
      paramf = (o.b)new b(this, paramf, this.aiWo, this.aiWp);
      AppMethodBeat.o(58172);
      return paramf;
    }
    
    public static final class a
      implements o.a
    {
      a(o.a parama, b.a parama1, kotlin.l.b.a.b.f.f paramf, ArrayList<c> paramArrayList)
      {
        AppMethodBeat.i(191932);
        this.aiWr = this.aiWs;
        AppMethodBeat.o(191932);
      }
      
      public final o.a a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.f.b paramb)
      {
        AppMethodBeat.i(58160);
        s.u(paramf, "name");
        s.u(paramb, "classId");
        paramf = this.aiWr.a(paramf, paramb);
        AppMethodBeat.o(58160);
        return paramf;
      }
      
      public final void a(kotlin.l.b.a.b.f.f paramf, Object paramObject)
      {
        AppMethodBeat.i(58159);
        this.aiWr.a(paramf, paramObject);
        AppMethodBeat.o(58159);
      }
      
      public final void a(kotlin.l.b.a.b.f.f paramf1, kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf2)
      {
        AppMethodBeat.i(58163);
        s.u(paramf1, "name");
        s.u(paramb, "enumClassId");
        s.u(paramf2, "enumEntryName");
        this.aiWr.a(paramf1, paramb, paramf2);
        AppMethodBeat.o(58163);
      }
      
      public final void a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.j.b.f paramf1)
      {
        AppMethodBeat.i(58162);
        s.u(paramf, "name");
        s.u(paramf1, "value");
        this.aiWr.a(paramf, paramf1);
        AppMethodBeat.o(58162);
      }
      
      public final void azp()
      {
        AppMethodBeat.i(58158);
        this.aiWs.azp();
        ((Map)jdField_this.aiWn).put(paramf, new kotlin.l.b.a.b.j.b.a((c)p.oO((List)localArrayList)));
        AppMethodBeat.o(58158);
      }
      
      public final o.b o(kotlin.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58161);
        s.u(paramf, "name");
        paramf = this.aiWr.o(paramf);
        AppMethodBeat.o(58161);
        return paramf;
      }
    }
    
    public static final class b
      implements o.b
    {
      final ArrayList<g<?>> aiWu;
      
      b(b.a parama, kotlin.l.b.a.b.f.f paramf, b paramb, kotlin.l.b.a.b.b.e parame)
      {
        AppMethodBeat.i(191931);
        this.aiWu = new ArrayList();
        AppMethodBeat.o(191931);
      }
      
      public final void a(kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf)
      {
        AppMethodBeat.i(58165);
        s.u(paramb, "enumClassId");
        s.u(paramf, "enumEntryName");
        this.aiWu.add(new j(paramb, paramf));
        AppMethodBeat.o(58165);
      }
      
      public final void a(kotlin.l.b.a.b.j.b.f paramf)
      {
        AppMethodBeat.i(58166);
        s.u(paramf, "value");
        this.aiWu.add(new q(paramf));
        AppMethodBeat.o(58166);
      }
      
      public final void azp()
      {
        AppMethodBeat.i(58167);
        Object localObject1 = kotlin.l.b.a.b.d.a.a.a.b(paramf, this.aiWp);
        if (localObject1 != null)
        {
          Map localMap = (Map)this.aiWt.aiWn;
          kotlin.l.b.a.b.f.f localf = paramf;
          Object localObject2 = h.ajjE;
          localObject2 = kotlin.l.b.a.b.o.a.cn(this.aiWu);
          localObject1 = ((bd)localObject1).koG();
          s.s(localObject1, "parameter.type");
          localMap.put(localf, h.a((List)localObject2, (ad)localObject1));
        }
        AppMethodBeat.o(58167);
      }
      
      public final o.a e(kotlin.l.b.a.b.f.b paramb)
      {
        AppMethodBeat.i(191938);
        s.u(paramb, "classId");
        final ArrayList localArrayList = new ArrayList();
        b localb = this.aiWv;
        av localav = av.aiHu;
        s.s(localav, "NO_SOURCE");
        paramb = localb.a(paramb, localav, (List)localArrayList);
        s.checkNotNull(paramb);
        paramb = (o.a)new a(paramb, this, localArrayList);
        AppMethodBeat.o(191938);
        return paramb;
      }
      
      public final void hY(Object paramObject)
      {
        AppMethodBeat.i(58164);
        this.aiWu.add(b.a.b(paramf, paramObject));
        AppMethodBeat.o(58164);
      }
      
      public static final class a
        implements o.a
      {
        a(o.a parama, b.a.b paramb, ArrayList<c> paramArrayList)
        {
          AppMethodBeat.i(191948);
          this.aiWr = this.aiWs;
          AppMethodBeat.o(191948);
        }
        
        public final o.a a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.f.b paramb)
        {
          AppMethodBeat.i(191951);
          s.u(paramf, "name");
          s.u(paramb, "classId");
          paramf = this.aiWr.a(paramf, paramb);
          AppMethodBeat.o(191951);
          return paramf;
        }
        
        public final void a(kotlin.l.b.a.b.f.f paramf, Object paramObject)
        {
          AppMethodBeat.i(191950);
          this.aiWr.a(paramf, paramObject);
          AppMethodBeat.o(191950);
        }
        
        public final void a(kotlin.l.b.a.b.f.f paramf1, kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf2)
        {
          AppMethodBeat.i(191957);
          s.u(paramf1, "name");
          s.u(paramb, "enumClassId");
          s.u(paramf2, "enumEntryName");
          this.aiWr.a(paramf1, paramb, paramf2);
          AppMethodBeat.o(191957);
        }
        
        public final void a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.j.b.f paramf1)
        {
          AppMethodBeat.i(191956);
          s.u(paramf, "name");
          s.u(paramf1, "value");
          this.aiWr.a(paramf, paramf1);
          AppMethodBeat.o(191956);
        }
        
        public final void azp()
        {
          AppMethodBeat.i(191960);
          this.aiWs.azp();
          jdField_this.aiWu.add(new kotlin.l.b.a.b.j.b.a((c)p.oO((List)localArrayList)));
          AppMethodBeat.o(191960);
        }
        
        public final o.b o(kotlin.l.b.a.b.f.f paramf)
        {
          AppMethodBeat.i(191954);
          s.u(paramf, "name");
          paramf = this.aiWr.o(paramf);
          AppMethodBeat.o(191954);
          return paramf;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.b
 * JD-Core Version:    0.7.0.1
 */