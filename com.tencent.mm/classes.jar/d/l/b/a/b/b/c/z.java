package d.l.b.a.b.b.c;

import d.l.b.a.b.b.a.a;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ag;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.t;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class z
  extends k
  implements ag
{
  public final boolean LgF;
  private final w LgG;
  private final ah LgW;
  public d.l.b.a.b.b.ba Lhb;
  public final boolean Lhe;
  private final b.a Lhq;
  public t Lhr = null;
  public boolean isDefault;
  
  static
  {
    if (!z.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public z(w paramw, d.l.b.a.b.b.ba paramba, ah paramah, g paramg, f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, an paraman)
  {
    super(paramah.fPU(), paramg, paramf, paraman);
    this.LgG = paramw;
    this.Lhb = paramba;
    this.LgW = paramah;
    this.isDefault = paramBoolean1;
    this.LgF = paramBoolean2;
    this.Lhe = paramBoolean3;
    this.Lhq = parama;
  }
  
  public final <V> V a(a.a<V> parama)
  {
    return null;
  }
  
  public final t c(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      agL(7);
    }
    throw new UnsupportedOperationException();
  }
  
  public final w fPZ()
  {
    w localw = this.LgG;
    if (localw == null) {
      agL(9);
    }
    return localw;
  }
  
  public final ak fQP()
  {
    return fRJ().fQP();
  }
  
  public final ak fQQ()
  {
    return fRJ().fQQ();
  }
  
  public final List<as> fQR()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      agL(8);
    }
    return localList;
  }
  
  public final boolean fQV()
  {
    return false;
  }
  
  public final b.a fQY()
  {
    b.a locala = this.Lhq;
    if (locala == null) {
      agL(6);
    }
    return locala;
  }
  
  public final d.l.b.a.b.b.ba fQb()
  {
    d.l.b.a.b.b.ba localba = this.Lhb;
    if (localba == null) {
      agL(10);
    }
    return localba;
  }
  
  public final boolean fQf()
  {
    return this.Lhe;
  }
  
  public final boolean fQg()
  {
    return false;
  }
  
  public final boolean fQh()
  {
    return false;
  }
  
  public final boolean fQi()
  {
    return this.LgF;
  }
  
  public final boolean fQv()
  {
    return false;
  }
  
  public final ah fRJ()
  {
    ah localah = this.LgW;
    if (localah == null) {
      agL(12);
    }
    return localah;
  }
  
  public final t fRr()
  {
    return this.Lhr;
  }
  
  public final boolean fRs()
  {
    return false;
  }
  
  public final boolean fRt()
  {
    return false;
  }
  
  public final boolean fRu()
  {
    return false;
  }
  
  public final boolean fRv()
  {
    return false;
  }
  
  public final boolean fRw()
  {
    return false;
  }
  
  public final t.a<? extends t> fRx()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public abstract ag fSL();
  
  public final boolean isDefault()
  {
    return this.isDefault;
  }
  
  public final void t(Collection<? extends b> paramCollection)
  {
    if (paramCollection == null) {
      agL(14);
    }
    assert (paramCollection.isEmpty()) : "Overridden accessors should be empty";
  }
  
  protected final Collection<ag> zm(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = fRJ().fQW().iterator();
    label80:
    while (localIterator.hasNext())
    {
      Object localObject = (ah)localIterator.next();
      if (paramBoolean) {}
      for (localObject = ((ah)localObject).fRK();; localObject = ((ah)localObject).fRL())
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.z
 * JD-Core Version:    0.7.0.1
 */