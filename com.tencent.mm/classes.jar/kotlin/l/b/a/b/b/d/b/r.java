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
    kotlin.g.b.p.k(paramArrayOfType, "parameterTypes");
    kotlin.g.b.p.k(paramArrayOfAnnotation, "parameterAnnotations");
    ArrayList localArrayList = new ArrayList(paramArrayOfType.length);
    Object localObject = a.aaPP;
    List localList = a.b(iDg());
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
      localObject = w.aaQo;
      localw = w.a.j(paramArrayOfType[j]);
      if (localList == null) {
        break label239;
      }
      localObject = (String)j.M(localList, j + i);
      if (localObject != null) {
        break;
      }
      throw ((Throwable)new IllegalStateException(("No parameter with index " + j + '+' + i + " (name=" + iEU() + " type=" + localw + ") in " + localList + "@ReflectJavaMember").toString()));
    }
    label191:
    if ((paramBoolean) && (j == e.Z(paramArrayOfType))) {}
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
    return ((paramObject instanceof r)) && (kotlin.g.b.p.h(iDg(), ((r)paramObject).iDg()));
  }
  
  public int hashCode()
  {
    return iDg().hashCode();
  }
  
  public final ba iDQ()
  {
    return t.a.d(this);
  }
  
  public abstract Member iDg();
  
  public final kotlin.l.b.a.b.f.f iEU()
  {
    Object localObject = iDg().getName();
    if (localObject != null) {
      return kotlin.l.b.a.b.f.f.bHb((String)localObject);
    }
    localObject = h.abfQ;
    kotlin.g.b.p.j(localObject, "SpecialNames.NO_NAME_PROVIDED");
    return localObject;
  }
  
  public final AnnotatedElement iGX()
  {
    Member localMember = iDg();
    if (localMember == null) {
      throw new kotlin.t("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }
    return (AnnotatedElement)localMember;
  }
  
  public final int iHb()
  {
    return iDg().getModifiers();
  }
  
  public final boolean iHk()
  {
    return t.a.a(this);
  }
  
  public final boolean iHl()
  {
    return t.a.c(this);
  }
  
  public final boolean ihW()
  {
    return t.a.b(this);
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + iDg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.r
 * JD-Core Version:    0.7.0.1
 */