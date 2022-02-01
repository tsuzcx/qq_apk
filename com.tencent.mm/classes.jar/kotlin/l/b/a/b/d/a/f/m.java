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
import kotlin.l.b.a.b.d.b.v;
import kotlin.o;
import kotlin.s;
import kotlin.x;

final class m
{
  final Map<String, j> TuJ;
  
  public m()
  {
    AppMethodBeat.i(58117);
    this.TuJ = ((Map)new LinkedHashMap());
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
    
    public final void p(String paramString, b<? super a, x> paramb)
    {
      AppMethodBeat.i(58115);
      p.h(paramString, "name");
      p.h(paramb, "block");
      Map localMap = m.this.TuJ;
      paramString = new a(paramString);
      paramb.invoke(paramString);
      paramString = paramString.hEg();
      localMap.put(paramString.first, paramString.second);
      AppMethodBeat.o(58115);
    }
    
    public final class a
    {
      private o<String, r> TuL;
      private final String nlH;
      private final List<o<String, r>> parameters;
      
      public a()
      {
        AppMethodBeat.i(58114);
        this.nlH = localObject;
        this.parameters = ((List)new ArrayList());
        this.TuL = s.U("V", null);
        AppMethodBeat.o(58114);
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
          localCollection.add(s.U(paramString, paramVarArgs));
          AppMethodBeat.o(58110);
          return;
          i = 0;
          break;
          label63:
          Object localObject1 = e.Z(paramVarArgs);
          paramVarArgs = (Map)new LinkedHashMap(kotlin.k.j.mZ(ae.atJ(kotlin.a.j.a((Iterable)localObject1, 10)), 16));
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
        p.h(paramd, "type");
        this.TuL = s.U(paramd.getDesc(), null);
        AppMethodBeat.o(58112);
      }
      
      public final void b(String paramString, d... paramVarArgs)
      {
        AppMethodBeat.i(58111);
        p.h(paramString, "type");
        p.h(paramVarArgs, "qualifiers");
        Object localObject1 = e.Z(paramVarArgs);
        paramVarArgs = (Map)new LinkedHashMap(kotlin.k.j.mZ(ae.atJ(kotlin.a.j.a((Iterable)localObject1, 10)), 16));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          paramVarArgs.put(Integer.valueOf(((y)localObject2).index), (d)((y)localObject2).value);
        }
        this.TuL = s.U(paramString, new r(paramVarArgs));
        AppMethodBeat.o(58111);
      }
      
      public final o<String, j> hEg()
      {
        AppMethodBeat.i(58113);
        Object localObject1 = v.TvS;
        localObject1 = m.a.this.className;
        Object localObject2 = this.nlH;
        Object localObject3 = (Iterable)this.parameters;
        Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          localCollection.add((String)((o)((Iterator)localObject3).next()).first);
        }
        localObject1 = v.ov((String)localObject1, v.e((String)localObject2, (List)localCollection, (String)this.TuL.first));
        localObject2 = (r)this.TuL.second;
        localObject3 = (Iterable)this.parameters;
        localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          localCollection.add((r)((o)((Iterator)localObject3).next()).second);
        }
        localObject1 = s.U(localObject1, new j((r)localObject2, (List)localCollection));
        AppMethodBeat.o(58113);
        return localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.m
 * JD-Core Version:    0.7.0.1
 */