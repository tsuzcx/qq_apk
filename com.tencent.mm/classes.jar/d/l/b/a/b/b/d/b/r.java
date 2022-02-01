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
    Object localObject = a.Nxn;
    List localList = a.b(gls());
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
      localObject = w.NxM;
      localw = w.a.j(paramArrayOfType[j]);
      if (localList == null) {
        break label239;
      }
      localObject = (String)j.F(localList, j + i);
      if (localObject != null) {
        break;
      }
      throw ((Throwable)new IllegalStateException(("No parameter with index " + j + '+' + i + " (name=" + gnf() + " type=" + localw + ") in " + localList + "@ReflectJavaMember").toString()));
    }
    label191:
    if ((paramBoolean) && (j == e.U(paramArrayOfType))) {}
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
    return ((paramObject instanceof r)) && (d.g.b.p.i(gls(), ((r)paramObject).gls()));
  }
  
  public final boolean fUX()
  {
    return t.a.b(this);
  }
  
  public final int getModifiers()
  {
    return gls().getModifiers();
  }
  
  public abstract Member gls();
  
  public final ba gmb()
  {
    return t.a.d(this);
  }
  
  public final d.l.b.a.b.f.f gnf()
  {
    Object localObject = gls().getName();
    if (localObject != null) {
      return d.l.b.a.b.f.f.bei((String)localObject);
    }
    localObject = h.NNy;
    d.g.b.p.g(localObject, "SpecialNames.NO_NAME_PROVIDED");
    return localObject;
  }
  
  public final AnnotatedElement gpe()
  {
    Member localMember = gls();
    if (localMember == null) {
      throw new v("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }
    return (AnnotatedElement)localMember;
  }
  
  public final boolean gpo()
  {
    return t.a.a(this);
  }
  
  public final boolean gpp()
  {
    return t.a.c(this);
  }
  
  public int hashCode()
  {
    return gls().hashCode();
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + gls();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.r
 * JD-Core Version:    0.7.0.1
 */