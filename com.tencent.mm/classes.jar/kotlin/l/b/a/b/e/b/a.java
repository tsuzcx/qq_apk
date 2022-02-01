package kotlin.l.b.a.b.e.b;

import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;

public abstract class a
{
  public static final a abdH = new a((byte)0);
  public final int TsL;
  private final List<Integer> abdF;
  private final int[] abdG;
  public final int oey;
  public final int oez;
  
  public a(int... paramVarArgs)
  {
    this.abdG = paramVarArgs;
    paramVarArgs = e.m(this.abdG, 0);
    int i;
    if (paramVarArgs != null)
    {
      i = paramVarArgs.intValue();
      this.oey = i;
      paramVarArgs = e.m(this.abdG, 1);
      if (paramVarArgs == null) {
        break label133;
      }
      i = paramVarArgs.intValue();
      label58:
      this.oez = i;
      paramVarArgs = e.m(this.abdG, 2);
      i = j;
      if (paramVarArgs != null) {
        i = paramVarArgs.intValue();
      }
      this.TsL = i;
      if (this.abdG.length <= 3) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramVarArgs = j.p((Iterable)e.V(this.abdG).subList(3, this.abdG.length));; paramVarArgs = (List)v.aaAd)
    {
      this.abdF = paramVarArgs;
      return;
      i = -1;
      break;
      i = -1;
      break label58;
    }
  }
  
  protected final boolean a(a parama)
  {
    p.k(parama, "ourVersion");
    if (this.oey == 0) {
      if ((parama.oey != 0) || (this.oez != parama.oez)) {}
    }
    while ((this.oey == parama.oey) && (this.oez <= parama.oez))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && (p.h(getClass(), paramObject.getClass())) && (this.oey == ((a)paramObject).oey) && (this.oez == ((a)paramObject).oez) && (this.TsL == ((a)paramObject).TsL) && (p.h(this.abdF, ((a)paramObject).abdF));
  }
  
  public int hashCode()
  {
    int i = this.oey;
    i += i * 31 + this.oez;
    i += i * 31 + this.TsL;
    return i + (i * 31 + this.abdF.hashCode());
  }
  
  public String toString()
  {
    Object localObject = this.abdG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.a
 * JD-Core Version:    0.7.0.1
 */