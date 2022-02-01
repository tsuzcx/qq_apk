package com.tencent.mm.sensitive.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sensitive.b.c;
import com.tencent.mm.sensitive.b.d;
import com.tencent.mm.sensitive.m.b;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/processor/BaseHookSysServiceProcessor;", "Lcom/tencent/mm/sensitive/processor/IHookSysServiceProcessor;", "()V", "TAG", "", "afterHookSuccess", "", "service", "", "getHookCallback", "Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements j
{
  final String TAG = "BaseHookSysServiceProcessor";
  
  public void gD(Object paramObject)
  {
    s.u(paramObject, "service");
  }
  
  public final m.b iUi()
  {
    return (m.b)new a(this);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/sensitive/processor/BaseHookSysServiceProcessor$getHookCallback$1", "Lcom/tencent/mm/sensitive/SystemServiceBinderHooker$HookCallback;", "afterServiceMethodRealCall", "", "method", "Ljava/lang/reflect/Method;", "methodReturnValue", "", "onServiceMethodIntercept", "Lkotlin/Pair;", "", "var1", "var3", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Lkotlin/Pair;", "onServiceMethodInvoke", "var2", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m.b
  {
    a(a parama) {}
    
    public final void a(Method paramMethod, Object paramObject)
    {
      AppMethodBeat.i(240980);
      if (paramMethod == null) {}
      for (paramMethod = null;; paramMethod = paramMethod.getName())
      {
        if ((paramMethod != null) && (paramObject != null))
        {
          d locald = d.acve;
          d.Q(paramMethod, paramObject);
        }
        AppMethodBeat.o(240980);
        return;
      }
    }
    
    public final void e(Method paramMethod)
    {
      AppMethodBeat.i(240966);
      if (paramMethod == null) {}
      for (paramMethod = null;; paramMethod = paramMethod.getName())
      {
        Log.d("Kenneth-methodCall", s.X("[onServiceMethodInvoke] methodName = ", paramMethod));
        AppMethodBeat.o(240966);
        return;
      }
    }
    
    public final r<Boolean, Object> f(Method paramMethod)
    {
      int i = 1;
      AppMethodBeat.i(240975);
      Object localObject1 = d.acve;
      Object localObject2 = (Map)d.gUz();
      label49:
      label86:
      Object localObject3;
      label167:
      boolean bool;
      if (paramMethod == null)
      {
        localObject1 = null;
        localObject1 = (c)((Map)localObject2).get(localObject1);
        if (localObject1 != null) {
          break label313;
        }
        localObject2 = null;
        if (localObject2 != null)
        {
          Object localObject4 = this.acvw;
          String str = ((a)localObject4).TAG;
          StringBuilder localStringBuilder = new StringBuilder("[onServiceMethodIntercept] methodName = ");
          if (paramMethod != null) {
            break label325;
          }
          localObject1 = "";
          localStringBuilder = localStringBuilder.append((String)localObject1).append(", return cache:");
          localObject3 = ((r)localObject2).bsD;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "null";
          }
          Log.w(str, localObject1);
          if (((Boolean)((r)localObject2).bsC).booleanValue()) {
            break label356;
          }
          localObject3 = new StringBuilder("[onServiceMethodIntercept] methodName = ");
          if (paramMethod != null) {
            break label347;
          }
          localObject1 = null;
          Log.d("Kenneth-methodCall", localObject1 + ", return cache:" + ((r)localObject2).bsD);
          bool = true;
          label197:
          localObject1 = com.tencent.mm.sensitive.d.a.acvx;
          localObject4 = ((a)localObject4).iUj();
          if (paramMethod != null) {
            break label361;
          }
          localObject1 = "";
          label217:
          com.tencent.mm.sensitive.d.a.M((String)localObject4, (String)localObject1, bool);
        }
        if ((localObject2 != null) && (!((Boolean)((r)localObject2).bsC).booleanValue())) {
          break label407;
        }
        if (paramMethod == null) {
          break label383;
        }
        localObject1 = com.tencent.mm.sensitive.ui.a.acvO;
        localObject1 = paramMethod.getName();
        s.s(localObject1, "it.name");
        if (com.tencent.mm.sensitive.ui.a.bus((String)localObject1) != true) {
          break label383;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label388;
        }
        paramMethod = new r(Boolean.FALSE, paramMethod.getReturnType().newInstance());
        AppMethodBeat.o(240975);
        return paramMethod;
        localObject1 = paramMethod.getName();
        break;
        label313:
        localObject2 = ((c)localObject1).iUf();
        break label49;
        label325:
        localObject3 = paramMethod.getName();
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label86;
        }
        localObject1 = "";
        break label86;
        label347:
        localObject1 = paramMethod.getName();
        break label167;
        label356:
        bool = false;
        break label197;
        label361:
        localObject3 = paramMethod.getName();
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label217;
        }
        localObject1 = "";
        break label217;
        label383:
        i = 0;
      }
      label388:
      paramMethod = new r(Boolean.TRUE, null);
      AppMethodBeat.o(240975);
      return paramMethod;
      label407:
      AppMethodBeat.o(240975);
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.c.a
 * JD-Core Version:    0.7.0.1
 */