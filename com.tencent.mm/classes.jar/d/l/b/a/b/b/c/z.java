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
  public final boolean NuH;
  private final w NuI;
  private final ah NuY;
  public d.l.b.a.b.b.ba Nvd;
  public final boolean Nvg;
  private final b.a Nvs;
  public t Nvt = null;
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
    super(paramah.glU(), paramg, paramf, paraman);
    this.NuI = paramw;
    this.Nvd = paramba;
    this.NuY = paramah;
    this.isDefault = paramBoolean1;
    this.NuH = paramBoolean2;
    this.Nvg = paramBoolean3;
    this.Nvs = parama;
  }
  
  protected final Collection<ag> An(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = gnK().gmW().iterator();
    label80:
    while (localIterator.hasNext())
    {
      Object localObject = (ah)localIterator.next();
      if (paramBoolean) {}
      for (localObject = ((ah)localObject).gnL();; localObject = ((ah)localObject).gnM())
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
      ajW(7);
    }
    throw new UnsupportedOperationException();
  }
  
  public final w glZ()
  {
    w localw = this.NuI;
    if (localw == null) {
      ajW(9);
    }
    return localw;
  }
  
  public final ak gmP()
  {
    return gnK().gmP();
  }
  
  public final ak gmQ()
  {
    return gnK().gmQ();
  }
  
  public final List<as> gmR()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      ajW(8);
    }
    return localList;
  }
  
  public final boolean gmV()
  {
    return false;
  }
  
  public final b.a gmY()
  {
    b.a locala = this.Nvs;
    if (locala == null) {
      ajW(6);
    }
    return locala;
  }
  
  public final d.l.b.a.b.b.ba gmb()
  {
    d.l.b.a.b.b.ba localba = this.Nvd;
    if (localba == null) {
      ajW(10);
    }
    return localba;
  }
  
  public final boolean gmf()
  {
    return this.Nvg;
  }
  
  public final boolean gmg()
  {
    return false;
  }
  
  public final boolean gmh()
  {
    return false;
  }
  
  public final boolean gmi()
  {
    return this.NuH;
  }
  
  public final boolean gmv()
  {
    return false;
  }
  
  public final ah gnK()
  {
    ah localah = this.NuY;
    if (localah == null) {
      ajW(12);
    }
    return localah;
  }
  
  public final t gns()
  {
    return this.Nvt;
  }
  
  public final boolean gnt()
  {
    return false;
  }
  
  public final boolean gnu()
  {
    return false;
  }
  
  public final boolean gnv()
  {
    return false;
  }
  
  public final boolean gnw()
  {
    return false;
  }
  
  public final boolean gnx()
  {
    return false;
  }
  
  public final t.a<? extends t> gny()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public abstract ag goM();
  
  public final boolean isDefault()
  {
    return this.isDefault;
  }
  
  public final void u(Collection<? extends b> paramCollection)
  {
    if (paramCollection == null) {
      ajW(14);
    }
    assert (paramCollection.isEmpty()) : "Overridden accessors should be empty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.z
 * JD-Core Version:    0.7.0.1
 */