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
  private final ah TkG;
  public kotlin.l.b.a.b.b.ba TkL;
  public final boolean TkO;
  public final boolean Tkp;
  private final w Tkq;
  private final b.a Tla;
  public t Tlb = null;
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
  
  public z(w paramw, kotlin.l.b.a.b.b.ba paramba, ah paramah, g paramg, f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, an paraman)
  {
    super(paramah.hzx(), paramg, paramf, paraman);
    this.Tkq = paramw;
    this.TkL = paramba;
    this.TkG = paramah;
    this.isDefault = paramBoolean1;
    this.Tkp = paramBoolean2;
    this.TkO = paramBoolean3;
    this.Tla = parama;
  }
  
  protected final Collection<ag> EE(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = hBm().hAy().iterator();
    label80:
    while (localIterator.hasNext())
    {
      Object localObject = (ah)localIterator.next();
      if (paramBoolean) {}
      for (localObject = ((ah)localObject).hBn();; localObject = ((ah)localObject).hBo())
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
      atM(7);
    }
    throw new UnsupportedOperationException();
  }
  
  public final b.a hAA()
  {
    b.a locala = this.Tla;
    if (locala == null) {
      atM(6);
    }
    return locala;
  }
  
  public final t hAU()
  {
    return this.Tlb;
  }
  
  public final boolean hAV()
  {
    return false;
  }
  
  public final boolean hAW()
  {
    return false;
  }
  
  public final boolean hAX()
  {
    return false;
  }
  
  public final boolean hAY()
  {
    return false;
  }
  
  public final boolean hAZ()
  {
    return false;
  }
  
  public final ak hAr()
  {
    return hBm().hAr();
  }
  
  public final ak hAs()
  {
    return hBm().hAs();
  }
  
  public final List<as> hAt()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      atM(8);
    }
    return localList;
  }
  
  public final boolean hAx()
  {
    return false;
  }
  
  public final t.a<? extends t> hBa()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public final ah hBm()
  {
    ah localah = this.TkG;
    if (localah == null) {
      atM(12);
    }
    return localah;
  }
  
  public abstract ag hCo();
  
  public final w hzC()
  {
    w localw = this.Tkq;
    if (localw == null) {
      atM(9);
    }
    return localw;
  }
  
  public final kotlin.l.b.a.b.b.ba hzE()
  {
    kotlin.l.b.a.b.b.ba localba = this.TkL;
    if (localba == null) {
      atM(10);
    }
    return localba;
  }
  
  public final boolean hzI()
  {
    return this.TkO;
  }
  
  public final boolean hzJ()
  {
    return false;
  }
  
  public final boolean hzK()
  {
    return false;
  }
  
  public final boolean hzX()
  {
    return false;
  }
  
  public final boolean isDefault()
  {
    return this.isDefault;
  }
  
  public final boolean isExternal()
  {
    return this.Tkp;
  }
  
  public final void x(Collection<? extends b> paramCollection)
  {
    if (paramCollection == null) {
      atM(14);
    }
    assert (paramCollection.isEmpty()) : "Overridden accessors should be empty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.z
 * JD-Core Version:    0.7.0.1
 */