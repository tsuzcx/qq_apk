package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

public final class m$a
{
  final String className;
  
  public m$a(String paramString)
  {
    AppMethodBeat.i(58116);
    this.className = localObject;
    AppMethodBeat.o(58116);
  }
  
  public final void x(String paramString, b<? super a, ah> paramb)
  {
    AppMethodBeat.i(58115);
    s.u(paramString, "name");
    s.u(paramb, "block");
    Map localMap = this.aiVO.aiVN;
    paramString = new a(paramString);
    paramb.invoke(paramString);
    paramString = paramString.ksH();
    localMap.put(paramString.bsC, paramString.bsD);
    AppMethodBeat.o(58115);
  }
  
  public final class a
  {
    private final List<kotlin.r<String, r>> aiED;
    private kotlin.r<String, r> aiVP;
    private final String trR;
    
    public a()
    {
      AppMethodBeat.i(58114);
      this.trR = localObject;
      this.aiED = ((List)new ArrayList());
      this.aiVP = kotlin.v.Y("V", null);
      AppMethodBeat.o(58114);
    }
    
    public final void a(String paramString, e... paramVarArgs)
    {
      AppMethodBeat.i(58110);
      s.u(paramString, "type");
      s.u(paramVarArgs, "qualifiers");
      Collection localCollection = (Collection)this.aiED;
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
        localCollection.add(kotlin.v.Y(paramString, paramVarArgs));
        AppMethodBeat.o(58110);
        return;
        i = 0;
        break;
        label63:
        Object localObject1 = kotlin.a.k.ah(paramVarArgs);
        paramVarArgs = (Map)new LinkedHashMap(kotlin.k.k.qu(ak.aKi(p.a((Iterable)localObject1, 10)), 16));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          paramVarArgs.put(Integer.valueOf(((ae)localObject2).index), (e)((ae)localObject2).value);
        }
      }
    }
    
    public final void a(kotlin.l.b.a.b.j.e.e parame)
    {
      AppMethodBeat.i(58112);
      s.u(parame, "type");
      parame = parame.getDesc();
      s.s(parame, "type.desc");
      this.aiVP = kotlin.v.Y(parame, null);
      AppMethodBeat.o(58112);
    }
    
    public final void b(String paramString, e... paramVarArgs)
    {
      AppMethodBeat.i(58111);
      s.u(paramString, "type");
      s.u(paramVarArgs, "qualifiers");
      Object localObject1 = kotlin.a.k.ah(paramVarArgs);
      paramVarArgs = (Map)new LinkedHashMap(kotlin.k.k.qu(ak.aKi(p.a((Iterable)localObject1, 10)), 16));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        paramVarArgs.put(Integer.valueOf(((ae)localObject2).index), (e)((ae)localObject2).value);
      }
      this.aiVP = kotlin.v.Y(paramString, new r(paramVarArgs));
      AppMethodBeat.o(58111);
    }
    
    public final kotlin.r<String, k> ksH()
    {
      AppMethodBeat.i(58113);
      Object localObject1 = kotlin.l.b.a.b.d.b.v.aiXe;
      localObject1 = m.a.this.className;
      Object localObject2 = this.trR;
      Object localObject3 = (Iterable)this.aiED;
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add((String)((kotlin.r)((Iterator)localObject3).next()).bsC);
      }
      localObject1 = kotlin.l.b.a.b.d.b.v.ro((String)localObject1, kotlin.l.b.a.b.d.b.v.d((String)localObject2, (List)localCollection, (String)this.aiVP.bsC));
      localObject2 = (r)this.aiVP.bsD;
      localObject3 = (Iterable)this.aiED;
      localCollection = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add((r)((kotlin.r)((Iterator)localObject3).next()).bsD);
      }
      localObject1 = kotlin.v.Y(localObject1, new k((r)localObject2, (List)localCollection));
      AppMethodBeat.o(58113);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.m.a
 * JD-Core Version:    0.7.0.1
 */