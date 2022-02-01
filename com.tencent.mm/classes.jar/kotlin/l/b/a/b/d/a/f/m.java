package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.a.y;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l.b.a.b.d.b.v;
import kotlin.o;
import kotlin.s;
import kotlin.x;

final class m
{
  final Map<String, j> aaXD;
  
  public m()
  {
    AppMethodBeat.i(58117);
    this.aaXD = ((Map)new LinkedHashMap());
    AppMethodBeat.o(58117);
  }
  
  public final class a
  {
    final String className;
    
    public a()
    {
      AppMethodBeat.i(58116);
      this.className = localObject;
      AppMethodBeat.o(58116);
    }
    
    public final void r(String paramString, b<? super a, x> paramb)
    {
      AppMethodBeat.i(58115);
      p.k(paramString, "name");
      p.k(paramb, "block");
      Map localMap = m.this.aaXD;
      paramString = new a(paramString);
      paramb.invoke(paramString);
      paramString = paramString.iIA();
      localMap.put(paramString.Mx, paramString.My);
      AppMethodBeat.o(58115);
    }
    
    public final class a
    {
      private o<String, r> aaXF;
      private final List<o<String, r>> parameters;
      private final String qnk;
      
      public a()
      {
        AppMethodBeat.i(58114);
        this.qnk = localObject;
        this.parameters = ((List)new ArrayList());
        this.aaXF = s.M("V", null);
        AppMethodBeat.o(58114);
      }
      
      public final void a(String paramString, d... paramVarArgs)
      {
        AppMethodBeat.i(58110);
        p.k(paramString, "type");
        p.k(paramVarArgs, "qualifiers");
        Collection localCollection = (Collection)this.parameters;
        int i;
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label63;
          }
        }
        for (paramVarArgs = null;; paramVarArgs = new r(paramVarArgs))
        {
          localCollection.add(s.M(paramString, paramVarArgs));
          AppMethodBeat.o(58110);
          return;
          i = 0;
          break;
          label63:
          Object localObject1 = e.ad(paramVarArgs);
          paramVarArgs = (Map)new LinkedHashMap(i.ov(ae.aDD(kotlin.a.j.a((Iterable)localObject1, 10)), 16));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            paramVarArgs.put(Integer.valueOf(((y)localObject2).index), (d)((y)localObject2).value);
          }
        }
      }
      
      public final void a(kotlin.l.b.a.b.j.e.d paramd)
      {
        AppMethodBeat.i(58112);
        p.k(paramd, "type");
        this.aaXF = s.M(paramd.getDesc(), null);
        AppMethodBeat.o(58112);
      }
      
      public final void b(String paramString, d... paramVarArgs)
      {
        AppMethodBeat.i(58111);
        p.k(paramString, "type");
        p.k(paramVarArgs, "qualifiers");
        Object localObject1 = e.ad(paramVarArgs);
        paramVarArgs = (Map)new LinkedHashMap(i.ov(ae.aDD(kotlin.a.j.a((Iterable)localObject1, 10)), 16));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          paramVarArgs.put(Integer.valueOf(((y)localObject2).index), (d)((y)localObject2).value);
        }
        this.aaXF = s.M(paramString, new r(paramVarArgs));
        AppMethodBeat.o(58111);
      }
      
      public final o<String, j> iIA()
      {
        AppMethodBeat.i(58113);
        Object localObject1 = v.aaYI;
        localObject1 = m.a.this.className;
        Object localObject2 = this.qnk;
        Object localObject3 = (Iterable)this.parameters;
        Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          localCollection.add((String)((o)((Iterator)localObject3).next()).Mx);
        }
        localObject1 = v.pq((String)localObject1, v.d((String)localObject2, (List)localCollection, (String)this.aaXF.Mx));
        localObject2 = (r)this.aaXF.My;
        localObject3 = (Iterable)this.parameters;
        localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          localCollection.add((r)((o)((Iterator)localObject3).next()).My);
        }
        localObject1 = s.M(localObject1, new j((r)localObject2, (List)localCollection));
        AppMethodBeat.o(58113);
        return localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.m
 * JD-Core Version:    0.7.0.1
 */