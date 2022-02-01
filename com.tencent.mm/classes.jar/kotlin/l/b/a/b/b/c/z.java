package kotlin.l.b.a.b.b.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.t.a;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;

public abstract class z
  extends k
  implements ag
{
  private final ah aaNA;
  public kotlin.l.b.a.b.b.ba aaNF;
  public final boolean aaNI;
  private final b.a aaNU;
  public t aaNV = null;
  public final boolean aaNj;
  private final w aaNk;
  public boolean lJx;
  
  static
  {
    if (!z.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public z(w paramw, kotlin.l.b.a.b.b.ba paramba, ah paramah, g paramg, f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, an paraman)
  {
    super(paramah.iDJ(), paramg, paramf, paraman);
    this.aaNk = paramw;
    this.aaNF = paramba;
    this.aaNA = paramah;
    this.lJx = paramBoolean1;
    this.aaNj = paramBoolean2;
    this.aaNI = paramBoolean3;
    this.aaNU = parama;
  }
  
  protected final Collection<ag> Jk(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = iFB().iEL().iterator();
    label80:
    while (localIterator.hasNext())
    {
      Object localObject = (ah)localIterator.next();
      if (paramBoolean) {}
      for (localObject = ((ah)localObject).iFC();; localObject = ((ah)localObject).iFD())
      {
        if (localObject == null) {
          break label80;
        }
        localArrayList.add(localObject);
        break;
      }
    }
    return localArrayList;
  }
  
  public final <V> V a(a.a<V> parama)
  {
    return null;
  }
  
  public final t c(kotlin.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      aDG(7);
    }
    throw new UnsupportedOperationException();
  }
  
  public final w iDO()
  {
    w localw = this.aaNk;
    if (localw == null) {
      aDG(9);
    }
    return localw;
  }
  
  public final kotlin.l.b.a.b.b.ba iDQ()
  {
    kotlin.l.b.a.b.b.ba localba = this.aaNF;
    if (localba == null) {
      aDG(10);
    }
    return localba;
  }
  
  public final boolean iDU()
  {
    return this.aaNI;
  }
  
  public final boolean iDV()
  {
    return false;
  }
  
  public final boolean iDW()
  {
    return false;
  }
  
  public final boolean iDX()
  {
    return this.aaNj;
  }
  
  public final ak iEE()
  {
    return iFB().iEE();
  }
  
  public final ak iEF()
  {
    return iFB().iEF();
  }
  
  public final List<as> iEG()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      aDG(8);
    }
    return localList;
  }
  
  public final boolean iEK()
  {
    return false;
  }
  
  public final b.a iEN()
  {
    b.a locala = this.aaNU;
    if (locala == null) {
      aDG(6);
    }
    return locala;
  }
  
  public final boolean iEk()
  {
    return false;
  }
  
  public final boolean iFA()
  {
    return this.lJx;
  }
  
  public final ah iFB()
  {
    ah localah = this.aaNA;
    if (localah == null) {
      aDG(12);
    }
    return localah;
  }
  
  public final t iFi()
  {
    return this.aaNV;
  }
  
  public final boolean iFj()
  {
    return false;
  }
  
  public final boolean iFk()
  {
    return false;
  }
  
  public final boolean iFl()
  {
    return false;
  }
  
  public final boolean iFm()
  {
    return false;
  }
  
  public final boolean iFn()
  {
    return false;
  }
  
  public final t.a<? extends t> iFo()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public abstract ag iGD();
  
  public final void v(Collection<? extends b> paramCollection)
  {
    if (paramCollection == null) {
      aDG(14);
    }
    assert (paramCollection.isEmpty()) : "Overridden accessors should be empty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.z
 * JD-Core Version:    0.7.0.1
 */