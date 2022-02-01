package kotlin.l.b.a.b.e.b;

import java.util.ArrayList;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.b.s;

public abstract class a
{
  public static final a.a ajcg = new a.a((byte)0);
  public final int aaGW;
  private final int[] ajch;
  private final List<Integer> ajci;
  public final int rid;
  public final int rie;
  
  public a(int... paramVarArgs)
  {
    this.ajch = paramVarArgs;
    paramVarArgs = k.A(this.ajch, 0);
    int i;
    if (paramVarArgs == null)
    {
      i = -1;
      this.rid = i;
      paramVarArgs = k.A(this.ajch, 1);
      if (paramVarArgs != null) {
        break label125;
      }
      i = -1;
      label52:
      this.rie = i;
      paramVarArgs = k.A(this.ajch, 2);
      if (paramVarArgs != null) {
        break label133;
      }
      i = j;
      label72:
      this.aaGW = i;
      if (this.ajch.length <= 3) {
        break label141;
      }
    }
    label133:
    label141:
    for (paramVarArgs = p.p((Iterable)k.Y(this.ajch).subList(3, this.ajch.length));; paramVarArgs = (List)ab.aivy)
    {
      this.ajci = paramVarArgs;
      return;
      i = paramVarArgs.intValue();
      break;
      label125:
      i = paramVarArgs.intValue();
      break label52;
      i = paramVarArgs.intValue();
      break label72;
    }
  }
  
  protected final boolean a(a parama)
  {
    s.u(parama, "ourVersion");
    if (this.rid == 0) {
      if ((parama.rid != 0) || (this.rie != parama.rie)) {}
    }
    while ((this.rid == parama.rid) && (this.rie <= parama.rie))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean bR(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.rid > paramInt1) {}
    do
    {
      do
      {
        return true;
        if (this.rid < paramInt1) {
          return false;
        }
      } while (this.rie > paramInt2);
      if (this.rie < paramInt2) {
        return false;
      }
    } while (this.aaGW >= paramInt3);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && (s.p(getClass(), paramObject.getClass())) && (this.rid == ((a)paramObject).rid) && (this.rie == ((a)paramObject).rie) && (this.aaGW == ((a)paramObject).aaGW) && (s.p(this.ajci, ((a)paramObject).ajci));
  }
  
  public int hashCode()
  {
    int i = this.rid;
    i += i * 31 + this.rie;
    i += i * 31 + this.aaGW;
    return i + (i * 31 + this.ajci.hashCode());
  }
  
  public String toString()
  {
    Object localObject = this.ajch;
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
    return p.a((Iterable)localObject, (CharSequence)".", null, null, 0, null, null, 62);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.a
 * JD-Core Version:    0.7.0.1
 */