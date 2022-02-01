package com.tencent.mm.sensitive.b;

import com.tencent.mm.sensitive.a.e;
import com.tencent.mm.sensitive.d.a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/methodconfig/BaseMethodMethodCheck;", "Lcom/tencent/mm/sensitive/methodconfig/IMethodCheckConfig;", "()V", "cache", "", "getCache", "()Ljava/lang/Object;", "setCache", "(Ljava/lang/Object;)V", "cacheUpdateTime", "", "getCacheUpdateTime", "()J", "setCacheUpdateTime", "(J)V", "updateReturnValue", "", "value", "Lkotlin/Pair;", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  implements c
{
  private Object acvc;
  public long acvd;
  
  public void gC(Object paramObject)
  {
    this.acvc = paramObject;
    this.acvd = System.currentTimeMillis();
  }
  
  public r<Boolean, Object> iUf()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = iUg();
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (((e)((Iterator)localObject1).next()).iUe()) {
              continue;
            }
            i = 0;
            if (i != 0) {
              return new r(Boolean.TRUE, null);
            }
            localObject1 = new r(Boolean.FALSE, this.acvc);
            return localObject1;
          }
        }
      }
      finally
      {
        a locala = a.acvx;
        a.pB("BaseMethodMethodCheck", s.X("seviceName.value crash:", iUh()));
        return new r(Boolean.TRUE, null);
      }
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.b
 * JD-Core Version:    0.7.0.1
 */