package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.e;
import d.a.y;
import d.g.a.b;
import d.g.b.p;
import d.l.b.a.b.d.b.v;
import d.o;
import d.u;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class m
{
  final Map<String, j> NFd;
  
  public m()
  {
    AppMethodBeat.i(58117);
    this.NFd = ((Map)new LinkedHashMap());
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
    
    public final void j(String paramString, b<? super a, z> paramb)
    {
      AppMethodBeat.i(58115);
      p.h(paramString, "name");
      p.h(paramb, "block");
      Map localMap = m.this.NFd;
      paramString = new a(paramString);
      paramb.invoke(paramString);
      paramString = paramString.gqE();
      localMap.put(paramString.first, paramString.second);
      AppMethodBeat.o(58115);
    }
    
    public final class a
    {
      private o<String, r> NFf;
      private final String mxL;
      private final List<o<String, r>> parameters;
      
      public a()
      {
        AppMethodBeat.i(58114);
        this.mxL = localObject;
        this.parameters = ((List)new ArrayList());
        this.NFf = u.R("V", null);
        AppMethodBeat.o(58114);
      }
      
      public final void a(d.l.b.a.b.j.e.d paramd)
      {
        AppMethodBeat.i(58112);
        p.h(paramd, "type");
        this.NFf = u.R(paramd.getDesc(), null);
        AppMethodBeat.o(58112);
      }
      
      public final void a(String paramString, d... paramVarArgs)
      {
        AppMethodBeat.i(58110);
        p.h(paramString, "type");
        p.h(paramVarArgs, "qualifiers");
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
          localCollection.add(u.R(paramString, paramVarArgs));
          AppMethodBeat.o(58110);
          return;
          i = 0;
          break;
          label63:
          Object localObject1 = e.Y(paramVarArgs);
          paramVarArgs = (Map)new LinkedHashMap(d.k.j.lw(ae.ajS(d.a.j.a((Iterable)localObject1, 10)), 16));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            paramVarArgs.put(Integer.valueOf(((y)localObject2).index), (d)((y)localObject2).value);
          }
        }
      }
      
      public final void b(String paramString, d... paramVarArgs)
      {
        AppMethodBeat.i(58111);
        p.h(paramString, "type");
        p.h(paramVarArgs, "qualifiers");
        Object localObject1 = e.Y(paramVarArgs);
        paramVarArgs = (Map)new LinkedHashMap(d.k.j.lw(ae.ajS(d.a.j.a((Iterable)localObject1, 10)), 16));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          paramVarArgs.put(Integer.valueOf(((y)localObject2).index), (d)((y)localObject2).value);
        }
        this.NFf = u.R(paramString, new r(paramVarArgs));
        AppMethodBeat.o(58111);
      }
      
      public final o<String, j> gqE()
      {
        AppMethodBeat.i(58113);
        Object localObject1 = v.NGm;
        localObject1 = m.a.this.className;
        Object localObject2 = this.mxL;
        Object localObject3 = (Iterable)this.parameters;
        Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          localCollection.add((String)((o)((Iterator)localObject3).next()).first);
        }
        localObject1 = v.nB((String)localObject1, v.e((String)localObject2, (List)localCollection, (String)this.NFf.first));
        localObject2 = (r)this.NFf.second;
        localObject3 = (Iterable)this.parameters;
        localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          localCollection.add((r)((o)((Iterator)localObject3).next()).second);
        }
        localObject1 = u.R(localObject1, new j((r)localObject2, (List)localCollection));
        AppMethodBeat.o(58113);
        return localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.m
 * JD-Core Version:    0.7.0.1
 */