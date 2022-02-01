package kotlin.l.b.a.b.b.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.b.x.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.be;

public abstract class aa
  extends k
  implements ao
{
  public final boolean aiJU;
  private final ab aiJV;
  private final b.a aiKF;
  public x aiKG = null;
  private final ap aiKk;
  public t aiKq;
  public final boolean aiKt;
  public boolean oBZ;
  
  static
  {
    if (!aa.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public aa(ab paramab, t paramt, ap paramap, g paramg, f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, av paramav)
  {
    super(paramap.knp(), paramg, paramf, paramav);
    this.aiJV = paramab;
    this.aiKq = paramt;
    this.aiKk = paramap;
    this.oBZ = paramBoolean1;
    this.aiJU = paramBoolean2;
    this.aiKt = paramBoolean3;
    this.aiKF = parama;
  }
  
  public final void M(Collection<? extends b> paramCollection)
  {
    if (paramCollection == null) {
      aKu(14);
    }
    assert (paramCollection.isEmpty()) : "Overridden accessors should be empty";
  }
  
  protected final Collection<ao> Pn(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = kpb().kof().iterator();
    label80:
    while (localIterator.hasNext())
    {
      Object localObject = (ap)localIterator.next();
      if (paramBoolean) {}
      for (localObject = ((ap)localObject).kpc();; localObject = ((ap)localObject).kpd())
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
  
  public final x c(be parambe)
  {
    if (parambe == null) {
      aKu(7);
    }
    throw new UnsupportedOperationException();
  }
  
  public final boolean knC()
  {
    return false;
  }
  
  public final as knY()
  {
    return kpb().knY();
  }
  
  public final as knZ()
  {
    return kpb().knZ();
  }
  
  public final ab knb()
  {
    ab localab = this.aiJV;
    if (localab == null) {
      aKu(9);
    }
    return localab;
  }
  
  public final t knc()
  {
    t localt = this.aiKq;
    if (localt == null) {
      aKu(10);
    }
    return localt;
  }
  
  public final boolean kng()
  {
    return this.aiKt;
  }
  
  public final boolean kni()
  {
    return false;
  }
  
  public final boolean knj()
  {
    return false;
  }
  
  public final boolean knk()
  {
    return this.aiJU;
  }
  
  public final x koI()
  {
    return this.aiKG;
  }
  
  public final boolean koJ()
  {
    return false;
  }
  
  public final boolean koK()
  {
    return false;
  }
  
  public final boolean koL()
  {
    return false;
  }
  
  public final boolean koM()
  {
    return false;
  }
  
  public final boolean koN()
  {
    return false;
  }
  
  public final x.a<? extends x> koO()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public final List<ba> koa()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      aKu(8);
    }
    return localList;
  }
  
  public final boolean koe()
  {
    return false;
  }
  
  public final b.a koh()
  {
    b.a locala = this.aiKF;
    if (locala == null) {
      aKu(6);
    }
    return locala;
  }
  
  public final boolean kpa()
  {
    return this.oBZ;
  }
  
  public final ap kpb()
  {
    ap localap = this.aiKk;
    if (localap == null) {
      aKu(12);
    }
    return localap;
  }
  
  public abstract ao kqb();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.aa
 * JD-Core Version:    0.7.0.1
 */