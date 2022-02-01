package kotlin.l.b.a.b.b.d.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.f.h;

public abstract class r
  extends n
  implements f, t, kotlin.l.b.a.b.d.a.e.p
{
  protected final List<kotlin.l.b.a.b.d.a.e.y> a(Type[] paramArrayOfType, Annotation[][] paramArrayOfAnnotation, boolean paramBoolean)
  {
    kotlin.g.b.p.h(paramArrayOfType, "parameterTypes");
    kotlin.g.b.p.h(paramArrayOfAnnotation, "parameterAnnotations");
    ArrayList localArrayList = new ArrayList(paramArrayOfType.length);
    Object localObject = a.TmV;
    List localList = a.b(hyV());
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
      localObject = w.Tnu;
      localw = w.a.b(paramArrayOfType[j]);
      if (localList == null) {
        break label239;
      }
      localObject = (String)j.L(localList, j + i);
      if (localObject != null) {
        break;
      }
      throw ((Throwable)new IllegalStateException(("No parameter with index " + j + '+' + i + " (name=" + hAH() + " type=" + localw + ") in " + localList + "@ReflectJavaMember").toString()));
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
    return ((paramObject instanceof r)) && (kotlin.g.b.p.j(hyV(), ((r)paramObject).hyV()));
  }
  
  public final int getModifiers()
  {
    return hyV().getModifiers();
  }
  
  public final kotlin.l.b.a.b.f.f hAH()
  {
    Object localObject = hyV().getName();
    if (localObject != null) {
      return kotlin.l.b.a.b.f.f.btY((String)localObject);
    }
    localObject = h.TDd;
    kotlin.g.b.p.g(localObject, "SpecialNames.NO_NAME_PROVIDED");
    return localObject;
  }
  
  public final AnnotatedElement hCG()
  {
    Member localMember = hyV();
    if (localMember == null) {
      throw new kotlin.t("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }
    return (AnnotatedElement)localMember;
  }
  
  public final boolean hCQ()
  {
    return t.a.a(this);
  }
  
  public final boolean hCR()
  {
    return t.a.c(this);
  }
  
  public int hashCode()
  {
    return hyV().hashCode();
  }
  
  public final boolean hgu()
  {
    return t.a.b(this);
  }
  
  public abstract Member hyV();
  
  public final ba hzE()
  {
    return t.a.d(this);
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + hyV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.r
 * JD-Core Version:    0.7.0.1
 */