package d.l.b.a.b.e.b;

import d.a.e;
import d.a.j;
import d.a.v;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

public abstract class a
{
  public static final a JJT = new a((byte)0);
  public final int JJQ;
  private final List<Integer> JJR;
  private final int[] JJS;
  public final int major;
  public final int minor;
  
  public a(int... paramVarArgs)
  {
    this.JJS = paramVarArgs;
    paramVarArgs = e.j(this.JJS, 0);
    int i;
    if (paramVarArgs != null)
    {
      i = paramVarArgs.intValue();
      this.major = i;
      paramVarArgs = e.j(this.JJS, 1);
      if (paramVarArgs == null) {
        break label133;
      }
      i = paramVarArgs.intValue();
      label58:
      this.minor = i;
      paramVarArgs = e.j(this.JJS, 2);
      i = j;
      if (paramVarArgs != null) {
        i = paramVarArgs.intValue();
      }
      this.JJQ = i;
      if (this.JJS.length <= 3) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramVarArgs = j.m((Iterable)e.N(this.JJS).subList(3, this.JJS.length));; paramVarArgs = (List)v.Jgl)
    {
      this.JJR = paramVarArgs;
      return;
      i = -1;
      break;
      i = -1;
      break label58;
    }
  }
  
  protected final boolean a(a parama)
  {
    k.h(parama, "ourVersion");
    if (this.major == 0) {
      if ((parama.major != 0) || (this.minor != parama.minor)) {}
    }
    while ((this.major == parama.major) && (this.minor <= parama.minor))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && (k.g(getClass(), paramObject.getClass())) && (this.major == ((a)paramObject).major) && (this.minor == ((a)paramObject).minor) && (this.JJQ == ((a)paramObject).JJQ) && (k.g(this.JJR, ((a)paramObject).JJR));
  }
  
  public int hashCode()
  {
    int i = this.major;
    i += i * 31 + this.minor;
    i += i * 31 + this.JJQ;
    return i + (i * 31 + this.JJR.hashCode());
  }
  
  public String toString()
  {
    Object localObject = this.JJS;
    ArrayList localArrayList = new ArrayList();
    int k = localObject.length;
    int i = 0;
    if (i < k)
    {
      int m = localObject[i];
      if (m != -1) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label67;
        }
        localArrayList.add(Integer.valueOf(m));
        i += 1;
        break;
      }
    }
    label67:
    localObject = (List)localArrayList;
    if (((List)localObject).isEmpty()) {
      return "unknown";
    }
    return j.a((Iterable)localObject, (CharSequence)".", null, null, 0, null, null, 62);
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.e.b.a
 * JD-Core Version:    0.7.0.1
 */