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
  public final boolean MXB;
  private final w MXC;
  private final ah MXS;
  public d.l.b.a.b.b.ba MXX;
  public final boolean MYa;
  private final b.a MYm;
  public t MYn = null;
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
    super(paramah.ghs(), paramg, paramf, paraman);
    this.MXC = paramw;
    this.MXX = paramba;
    this.MXS = paramah;
    this.isDefault = paramBoolean1;
    this.MXB = paramBoolean2;
    this.MYa = paramBoolean3;
    this.MYm = parama;
  }
  
  protected final Collection<ag> Aa(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = gji().giu().iterator();
    label80:
    while (localIterator.hasNext())
    {
      Object localObject = (ah)localIterator.next();
      if (paramBoolean) {}
      for (localObject = ((ah)localObject).gjj();; localObject = ((ah)localObject).gjk())
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
  
  public final t c(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      ajm(7);
    }
    throw new UnsupportedOperationException();
  }
  
  public final boolean ghD()
  {
    return this.MYa;
  }
  
  public final boolean ghE()
  {
    return false;
  }
  
  public final boolean ghF()
  {
    return false;
  }
  
  public final boolean ghG()
  {
    return this.MXB;
  }
  
  public final boolean ghT()
  {
    return false;
  }
  
  public final w ghx()
  {
    w localw = this.MXC;
    if (localw == null) {
      ajm(9);
    }
    return localw;
  }
  
  public final d.l.b.a.b.b.ba ghz()
  {
    d.l.b.a.b.b.ba localba = this.MXX;
    if (localba == null) {
      ajm(10);
    }
    return localba;
  }
  
  public final t giQ()
  {
    return this.MYn;
  }
  
  public final boolean giR()
  {
    return false;
  }
  
  public final boolean giS()
  {
    return false;
  }
  
  public final boolean giT()
  {
    return false;
  }
  
  public final boolean giU()
  {
    return false;
  }
  
  public final boolean giV()
  {
    return false;
  }
  
  public final t.a<? extends t> giW()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public final ak gin()
  {
    return gji().gin();
  }
  
  public final ak gio()
  {
    return gji().gio();
  }
  
  public final List<as> gip()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      ajm(8);
    }
    return localList;
  }
  
  public final boolean git()
  {
    return false;
  }
  
  public final b.a giw()
  {
    b.a locala = this.MYm;
    if (locala == null) {
      ajm(6);
    }
    return locala;
  }
  
  public final ah gji()
  {
    ah localah = this.MXS;
    if (localah == null) {
      ajm(12);
    }
    return localah;
  }
  
  public abstract ag gkk();
  
  public final boolean isDefault()
  {
    return this.isDefault;
  }
  
  public final void u(Collection<? extends b> paramCollection)
  {
    if (paramCollection == null) {
      ajm(14);
    }
    assert (paramCollection.isEmpty()) : "Overridden accessors should be empty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.z
 * JD-Core Version:    0.7.0.1
 */