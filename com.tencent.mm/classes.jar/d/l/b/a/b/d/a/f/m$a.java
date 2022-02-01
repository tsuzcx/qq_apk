package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.e;
import d.a.y;
import d.g.a.b;
import d.g.b.p;
import d.k.h;
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

public final class m$a
{
  final String className;
  
  public m$a(String paramString)
  {
    AppMethodBeat.i(58116);
    this.className = localObject;
    AppMethodBeat.o(58116);
  }
  
  public final void i(String paramString, b<? super a, z> paramb)
  {
    AppMethodBeat.i(58115);
    p.h(paramString, "name");
    p.h(paramb, "block");
    Map localMap = this.NhY.NhX;
    paramString = new a(paramString);
    paramb.invoke(paramString);
    paramString = paramString.gmc();
    localMap.put(paramString.first, paramString.second);
    AppMethodBeat.o(58115);
  }
  
  public final class a
  {
    private o<String, r> NhZ;
    private final String msO;
    private final List<o<String, r>> parameters;
    
    public a()
    {
      AppMethodBeat.i(58114);
      this.msO = localObject;
      this.parameters = ((List)new ArrayList());
      this.NhZ = u.S("V", null);
      AppMethodBeat.o(58114);
    }
    
    public final void a(d.l.b.a.b.j.e.d paramd)
    {
      AppMethodBeat.i(58112);
      p.h(paramd, "type");
      this.NhZ = u.S(paramd.getDesc(), null);
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
        localCollection.add(u.S(paramString, paramVarArgs));
        AppMethodBeat.o(58110);
        return;
        i = 0;
        break;
        label63:
        Object localObject1 = e.Z(paramVarArgs);
        paramVarArgs = (Map)new LinkedHashMap(h.lp(ae.aji(d.a.j.a((Iterable)localObject1, 10)), 16));
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
      Object localObject1 = e.Z(paramVarArgs);
      paramVarArgs = (Map)new LinkedHashMap(h.lp(ae.aji(d.a.j.a((Iterable)localObject1, 10)), 16));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        paramVarArgs.put(Integer.valueOf(((y)localObject2).index), (d)((y)localObject2).value);
      }
      this.NhZ = u.S(paramString, new r(paramVarArgs));
      AppMethodBeat.o(58111);
    }
    
    public final o<String, j> gmc()
    {
      AppMethodBeat.i(58113);
      Object localObject1 = v.Njg;
      localObject1 = m.a.this.className;
      Object localObject2 = this.msO;
      Object localObject3 = (Iterable)this.parameters;
      Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add((String)((o)((Iterator)localObject3).next()).first);
      }
      localObject1 = v.nv((String)localObject1, v.e((String)localObject2, (List)localCollection, (String)this.NhZ.first));
      localObject2 = (r)this.NhZ.second;
      localObject3 = (Iterable)this.parameters;
      localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add((r)((o)((Iterator)localObject3).next()).second);
      }
      localObject1 = u.S(localObject1, new j((r)localObject2, (List)localCollection));
      AppMethodBeat.o(58113);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.m.a
 * JD-Core Version:    0.7.0.1
 */