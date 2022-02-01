package kotlin.l.b.a.b.m;

import java.util.Collection;
import java.util.Collections;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.l.m;

public abstract class b
  extends h
{
  public b(m paramm)
  {
    super(paramm);
  }
  
  protected final Collection<ad> PE(boolean paramBoolean)
  {
    Object localObject2 = knz().knp();
    if (!(localObject2 instanceof kotlin.l.b.a.b.b.e))
    {
      localObject1 = Collections.emptyList();
      if (localObject1 == null) {
        aKu(3);
      }
      return localObject1;
    }
    Object localObject1 = new kotlin.l.b.a.b.o.e();
    localObject2 = (kotlin.l.b.a.b.b.e)localObject2;
    ((Collection)localObject1).add(((kotlin.l.b.a.b.b.e)localObject2).koj());
    localObject2 = ((kotlin.l.b.a.b.b.e)localObject2).knr();
    if ((paramBoolean) && (localObject2 != null)) {
      ((Collection)localObject1).add(((kotlin.l.b.a.b.b.e)localObject2).koj());
    }
    return localObject1;
  }
  
  protected final boolean a(kotlin.l.b.a.b.b.h paramh)
  {
    if (paramh == null) {
      aKu(2);
    }
    if ((paramh instanceof kotlin.l.b.a.b.b.e))
    {
      Object localObject = knz();
      s.u(localObject, "first");
      s.u(paramh, "second");
      boolean bool;
      if (!s.p(((kotlin.l.b.a.b.b.h)localObject).kok(), paramh.kok())) {
        bool = false;
      }
      while (bool)
      {
        return true;
        localObject = ((kotlin.l.b.a.b.b.h)localObject).knp();
        for (paramh = paramh.knp();; paramh = paramh.knp())
        {
          if ((localObject == null) || (paramh == null)) {
            break label202;
          }
          if ((localObject instanceof ae))
          {
            bool = paramh instanceof ae;
            break;
          }
          if ((paramh instanceof ae))
          {
            bool = false;
            break;
          }
          if ((localObject instanceof ah))
          {
            if (((paramh instanceof ah)) && (s.p(((ah)localObject).koY(), ((ah)paramh).koY()))) {
              break label202;
            }
            bool = false;
            break;
          }
          if ((paramh instanceof ah))
          {
            bool = false;
            break;
          }
          if (!s.p(((l)localObject).kok(), paramh.kok()))
          {
            bool = false;
            break;
          }
          localObject = ((l)localObject).knp();
        }
        label202:
        bool = true;
      }
    }
    return false;
  }
  
  public abstract kotlin.l.b.a.b.b.e knz();
  
  public final kotlin.l.b.a.b.a.h koV()
  {
    kotlin.l.b.a.b.a.h localh = a.G(knz());
    if (localh == null) {
      aKu(1);
    }
    return localh;
  }
  
  protected final ad kpI()
  {
    if (kotlin.l.b.a.b.a.h.e(knz())) {
      return null;
    }
    return koV().kmO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.b
 * JD-Core Version:    0.7.0.1
 */