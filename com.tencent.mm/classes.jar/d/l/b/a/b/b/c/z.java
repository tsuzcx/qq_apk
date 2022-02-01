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
  private final ah JtD;
  public d.l.b.a.b.b.ba JtI;
  public final boolean JtL;
  private final b.a JtX;
  public t JtY = null;
  public final boolean Jtm;
  private final w Jtn;
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
    super(paramah.fxq(), paramg, paramf, paraman);
    this.Jtn = paramw;
    this.JtI = paramba;
    this.JtD = paramah;
    this.isDefault = paramBoolean1;
    this.Jtm = paramBoolean2;
    this.JtL = paramBoolean3;
    this.JtX = parama;
  }
  
  public final <V> V a(a.a<V> parama)
  {
    return null;
  }
  
  public final t c(d.l.b.a.b.m.ba paramba)
  {
    if (paramba == null) {
      adP(7);
    }
    throw new UnsupportedOperationException();
  }
  
  public abstract ag fAh();
  
  public final boolean fxB()
  {
    return this.JtL;
  }
  
  public final boolean fxC()
  {
    return false;
  }
  
  public final boolean fxD()
  {
    return false;
  }
  
  public final boolean fxE()
  {
    return this.Jtm;
  }
  
  public final boolean fxR()
  {
    return false;
  }
  
  public final w fxv()
  {
    w localw = this.Jtn;
    if (localw == null) {
      adP(9);
    }
    return localw;
  }
  
  public final d.l.b.a.b.b.ba fxx()
  {
    d.l.b.a.b.b.ba localba = this.JtI;
    if (localba == null) {
      adP(10);
    }
    return localba;
  }
  
  public final t fyN()
  {
    return this.JtY;
  }
  
  public final boolean fyO()
  {
    return false;
  }
  
  public final boolean fyP()
  {
    return false;
  }
  
  public final boolean fyQ()
  {
    return false;
  }
  
  public final boolean fyR()
  {
    return false;
  }
  
  public final boolean fyS()
  {
    return false;
  }
  
  public final t.a<? extends t> fyT()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public final ak fyl()
  {
    return fzf().fyl();
  }
  
  public final ak fym()
  {
    return fzf().fym();
  }
  
  public final List<as> fyn()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      adP(8);
    }
    return localList;
  }
  
  public final boolean fyr()
  {
    return false;
  }
  
  public final b.a fyu()
  {
    b.a locala = this.JtX;
    if (locala == null) {
      adP(6);
    }
    return locala;
  }
  
  public final ah fzf()
  {
    ah localah = this.JtD;
    if (localah == null) {
      adP(12);
    }
    return localah;
  }
  
  public final boolean isDefault()
  {
    return this.isDefault;
  }
  
  public final void s(Collection<? extends b> paramCollection)
  {
    if (paramCollection == null) {
      adP(14);
    }
    assert (paramCollection.isEmpty()) : "Overridden accessors should be empty";
  }
  
  protected final Collection<ag> xU(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = fzf().fys().iterator();
    label80:
    while (localIterator.hasNext())
    {
      Object localObject = (ah)localIterator.next();
      if (paramBoolean) {}
      for (localObject = ((ah)localObject).fzg();; localObject = ((ah)localObject).fzh())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.z
 * JD-Core Version:    0.7.0.1
 */