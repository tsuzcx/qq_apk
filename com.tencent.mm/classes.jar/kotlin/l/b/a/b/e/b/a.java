package kotlin.l.b.a.b.e.b;

import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;

public abstract class a
{
  public static final a TAS = new a((byte)0);
  public final int TAP;
  private final List<Integer> TAQ;
  private final int[] TAR;
  public final int major;
  public final int minor;
  
  public a(int... paramVarArgs)
  {
    this.TAR = paramVarArgs;
    paramVarArgs = e.m(this.TAR, 0);
    int i;
    if (paramVarArgs != null)
    {
      i = paramVarArgs.intValue();
      this.major = i;
      paramVarArgs = e.m(this.TAR, 1);
      if (paramVarArgs == null) {
        break label133;
      }
      i = paramVarArgs.intValue();
      label58:
      this.minor = i;
      paramVarArgs = e.m(this.TAR, 2);
      i = j;
      if (paramVarArgs != null) {
        i = paramVarArgs.intValue();
      }
      this.TAP = i;
      if (this.TAR.length <= 3) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramVarArgs = j.p((Iterable)e.W(this.TAR).subList(3, this.TAR.length));; paramVarArgs = (List)v.SXr)
    {
      this.TAQ = paramVarArgs;
      return;
      i = -1;
      break;
      i = -1;
      break label58;
    }
  }
  
  protected final boolean a(a parama)
  {
    p.h(parama, "ourVersion");
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
    return (paramObject != null) && (p.j(getClass(), paramObject.getClass())) && (this.major == ((a)paramObject).major) && (this.minor == ((a)paramObject).minor) && (this.TAP == ((a)paramObject).TAP) && (p.j(this.TAQ, ((a)paramObject).TAQ));
  }
  
  public int hashCode()
  {
    int i = this.major;
    i += i * 31 + this.minor;
    i += i * 31 + this.TAP;
    return i + (i * 31 + this.TAQ.hashCode());
  }
  
  public String toString()
  {
    Object localObject = this.TAR;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.a
 * JD-Core Version:    0.7.0.1
 */