package d.l.b.a.b.b.d.b;

import d.a.e;
import d.a.j;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.f.h;
import d.v;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class r
  extends n
  implements f, t, d.l.b.a.b.d.a.e.p
{
  protected final List<d.l.b.a.b.d.a.e.y> a(Type[] paramArrayOfType, Annotation[][] paramArrayOfAnnotation, boolean paramBoolean)
  {
    d.g.b.p.h(paramArrayOfType, "parameterTypes");
    d.g.b.p.h(paramArrayOfAnnotation, "parameterAnnotations");
    ArrayList localArrayList = new ArrayList(paramArrayOfType.length);
    Object localObject = a.Nah;
    List localList = a.b(ggQ());
    if (localList != null) {}
    int j;
    w localw;
    for (int i = localList.size() - paramArrayOfType.length;; i = 0)
    {
      int k = paramArrayOfType.length;
      j = 0;
      if (j >= k) {
        break label251;
      }
      localObject = w.NaG;
      localw = w.a.j(paramArrayOfType[j]);
      if (localList == null) {
        break label239;
      }
      localObject = (String)j.E(localList, j + i);
      if (localObject != null) {
        break;
      }
      throw ((Throwable)new IllegalStateException(("No parameter with index " + j + '+' + i + " (name=" + giD() + " type=" + localw + ") in " + localList + "@ReflectJavaMember").toString()));
    }
    label191:
    if ((paramBoolean) && (j == e.V(paramArrayOfType))) {}
    for (boolean bool = true;; bool = false)
    {
      localArrayList.add(new y(localw, paramArrayOfAnnotation[j], (String)localObject, bool));
      j += 1;
      break;
      label239:
      localObject = null;
      break label191;
    }
    label251:
    return (List)localArrayList;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof r)) && (d.g.b.p.i(ggQ(), ((r)paramObject).ggQ()));
  }
  
  public final boolean fQB()
  {
    return t.a.b(this);
  }
  
  public final int getModifiers()
  {
    return ggQ().getModifiers();
  }
  
  public abstract Member ggQ();
  
  public final ba ghz()
  {
    return t.a.d(this);
  }
  
  public final d.l.b.a.b.f.f giD()
  {
    Object localObject = ggQ().getName();
    if (localObject != null) {
      return d.l.b.a.b.f.f.bcE((String)localObject);
    }
    localObject = h.Nqs;
    d.g.b.p.g(localObject, "SpecialNames.NO_NAME_PROVIDED");
    return localObject;
  }
  
  public final AnnotatedElement gkC()
  {
    Member localMember = ggQ();
    if (localMember == null) {
      throw new v("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }
    return (AnnotatedElement)localMember;
  }
  
  public final boolean gkM()
  {
    return t.a.a(this);
  }
  
  public final boolean gkN()
  {
    return t.a.c(this);
  }
  
  public int hashCode()
  {
    return ggQ().hashCode();
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + ggQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.r
 * JD-Core Version:    0.7.0.1
 */