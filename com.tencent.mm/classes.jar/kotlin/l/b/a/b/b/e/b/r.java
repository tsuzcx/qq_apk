package kotlin.l.b.a.b.b.e.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.bi;
import kotlin.l.b.a.b.d.a.e.aa;
import kotlin.l.b.a.b.f.h;

public abstract class r
  extends n
  implements f, t, kotlin.l.b.a.b.d.a.e.p
{
  protected final List<aa> a(Type[] paramArrayOfType, Annotation[][] paramArrayOfAnnotation, boolean paramBoolean)
  {
    s.u(paramArrayOfType, "parameterTypes");
    s.u(paramArrayOfAnnotation, "parameterAnnotations");
    ArrayList localArrayList = new ArrayList(paramArrayOfType.length);
    Object localObject = a.aiML;
    List localList = a.b(kmy());
    int i;
    int m;
    if (localList == null)
    {
      i = 0;
      m = paramArrayOfType.length - 1;
      if (m < 0) {}
    }
    int k;
    label261:
    for (int j = 0;; j = k)
    {
      k = j + 1;
      localObject = w.aiNn;
      w localw = w.a.l(paramArrayOfType[j]);
      if (localList == null)
      {
        localObject = null;
        label87:
        if ((!paramBoolean) || (j != k.ad(paramArrayOfType))) {
          break label255;
        }
      }
      label255:
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(new y(localw, paramArrayOfAnnotation[j], (String)localObject, bool));
        if (k <= m) {
          break label261;
        }
        return (List)localArrayList;
        i = localList.size() - paramArrayOfType.length;
        break;
        localObject = (String)kotlin.a.p.ae(localList, j + i);
        if (localObject == null) {
          throw ((Throwable)new IllegalStateException(("No parameter with index " + j + '+' + i + " (name=" + kok() + " type=" + localw + ") in " + localList + "@ReflectJavaMember").toString()));
        }
        break label87;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof r)) && (s.p(kmy(), ((r)paramObject).kmy()));
  }
  
  public int hashCode()
  {
    return kmy().hashCode();
  }
  
  public final boolean jNm()
  {
    return t.a.b(this);
  }
  
  public abstract Member kmy();
  
  public final kotlin.l.b.a.b.f.f kok()
  {
    Object localObject1 = kmy().getName();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = kotlin.l.b.a.b.f.f.bJe((String)localObject1))
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = h.ajeJ;
        s.s(localObject2, "NO_NAME_PROVIDED");
      }
      return localObject2;
    }
  }
  
  public final boolean kqA()
  {
    s.u(this, "this");
    return false;
  }
  
  public final int kqC()
  {
    return kmy().getModifiers();
  }
  
  public final boolean kqM()
  {
    return t.a.a(this);
  }
  
  public final boolean kqN()
  {
    return t.a.c(this);
  }
  
  public final bi kqO()
  {
    return t.a.d(this);
  }
  
  public final AnnotatedElement kqw()
  {
    return (AnnotatedElement)kmy();
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + kmy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.r
 * JD-Core Version:    0.7.0.1
 */