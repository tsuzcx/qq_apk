package android.support.v7.widget;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.as;
import android.support.v4.view.r;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends x
{
  private ArrayList<an> rm = new ArrayList();
  private ArrayList<an> rn = new ArrayList();
  private ArrayList<i> ro = new ArrayList();
  private ArrayList<h> rp = new ArrayList();
  private ArrayList<ArrayList<an>> rq = new ArrayList();
  private ArrayList<ArrayList<i>> rr = new ArrayList();
  private ArrayList<ArrayList<h>> rs = new ArrayList();
  private ArrayList<an> rt = new ArrayList();
  private ArrayList<an> ru = new ArrayList();
  private ArrayList<an> rv = new ArrayList();
  private ArrayList<an> rw = new ArrayList();
  
  private void a(h paramh)
  {
    if (paramh.rJ != null) {
      a(paramh, paramh.rJ);
    }
    if (paramh.rK != null) {
      a(paramh, paramh.rK);
    }
  }
  
  private void a(List<h> paramList, an paraman)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      h localh = (h)paramList.get(i);
      if ((a(localh, paraman)) && (localh.rJ == null) && (localh.rK == null)) {
        paramList.remove(localh);
      }
      i -= 1;
    }
  }
  
  private boolean a(h paramh, an paraman)
  {
    if (paramh.rK == paraman) {
      paramh.rK = null;
    }
    for (;;)
    {
      r.c(paraman.ve, 1.0F);
      r.a(paraman.ve, 0.0F);
      r.b(paraman.ve, 0.0F);
      j(paraman);
      return true;
      if (paramh.rJ != paraman) {
        break;
      }
      paramh.rJ = null;
    }
    return false;
  }
  
  private void cH()
  {
    if (!isRunning()) {
      dL();
    }
  }
  
  private void d(an paraman)
  {
    AnimatorCompatHelper.clearInterpolator(paraman.ve);
    c(paraman);
  }
  
  private static void h(List<an> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      r.o(((an)paramList.get(i)).ve).cancel();
      i -= 1;
    }
  }
  
  public final boolean a(an paraman)
  {
    d(paraman);
    this.rm.add(paraman);
    return true;
  }
  
  public final boolean a(an paraman, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paraman.ve;
    paramInt1 = (int)(paramInt1 + r.k(paraman.ve));
    paramInt2 = (int)(paramInt2 + r.l(paraman.ve));
    d(paraman);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      h(paraman);
      return false;
    }
    if (i != 0) {
      r.a(localView, -i);
    }
    if (j != 0) {
      r.b(localView, -j);
    }
    this.ro.add(new i(paraman, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean a(an paraman1, an paraman2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = r.k(paraman1.ve);
    float f2 = r.l(paraman1.ve);
    float f3 = r.h(paraman1.ve);
    d(paraman1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    r.a(paraman1.ve, f1);
    r.b(paraman1.ve, f2);
    r.c(paraman1.ve, f3);
    if ((paraman2 != null) && (paraman2.ve != null))
    {
      d(paraman2);
      r.a(paraman2.ve, -i);
      r.b(paraman2.ve, -j);
      r.c(paraman2.ve, 0.0F);
    }
    this.rp.add(new h(paraman1, paraman2, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean b(an paraman)
  {
    d(paraman);
    r.c(paraman.ve, 0.0F);
    this.rn.add(paraman);
    return true;
  }
  
  public final void c(an paraman)
  {
    View localView = paraman.ve;
    r.o(localView).cancel();
    int i = this.ro.size() - 1;
    while (i >= 0)
    {
      if (((i)this.ro.get(i)).rP == paraman)
      {
        r.b(localView, 0.0F);
        r.a(localView, 0.0F);
        h(paraman);
        this.ro.remove(i);
      }
      i -= 1;
    }
    a(this.rp, paraman);
    if (this.rm.remove(paraman))
    {
      r.c(localView, 1.0F);
      g(paraman);
    }
    if (this.rn.remove(paraman))
    {
      r.c(localView, 1.0F);
      i(paraman);
    }
    i = this.rs.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.rs.get(i);
      a(localArrayList, paraman);
      if (localArrayList.isEmpty()) {
        this.rs.remove(i);
      }
      i -= 1;
    }
    i = this.rr.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.rr.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((i)localArrayList.get(j)).rP != paraman) {
            break label293;
          }
          r.b(localView, 0.0F);
          r.a(localView, 0.0F);
          h(paraman);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.rr.remove(i);
          }
        }
        i -= 1;
        break;
        label293:
        j -= 1;
      }
    }
    i = this.rq.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.rq.get(i);
      if (localArrayList.remove(paraman))
      {
        r.c(localView, 1.0F);
        i(paraman);
        if (localArrayList.isEmpty()) {
          this.rq.remove(i);
        }
      }
      i -= 1;
    }
    this.rv.remove(paraman);
    this.rt.remove(paraman);
    this.rw.remove(paraman);
    this.ru.remove(paraman);
    cH();
  }
  
  public final void cG()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.rm.isEmpty())
    {
      i = 1;
      if (this.ro.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.rp.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.rn.isEmpty()) {
        break label82;
      }
    }
    label72:
    label77:
    label82:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label88;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label24;
      k = 0;
      break label36;
    }
    label88:
    Object localObject1 = this.rm.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (an)((Iterator)localObject1).next();
      final as localas = r.o(((an)localObject2).ve);
      this.rv.add(localObject2);
      localas.a(dI()).b(0.0F).a(new j((an)localObject2)
      {
        public final void y(View paramAnonymousView) {}
        
        public final void z(View paramAnonymousView)
        {
          localas.a(null);
          r.c(paramAnonymousView, 1.0F);
          g.this.g(this.rB);
          g.d(g.this).remove(this.rB);
          g.e(g.this);
        }
      }).start();
    }
    this.rm.clear();
    label260:
    label340:
    long l1;
    label415:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.ro);
      this.rr.add(localObject1);
      this.ro.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = this.rx.iterator();
          while (localIterator.hasNext())
          {
            i locali = (i)localIterator.next();
            g.a(g.this, locali.rP, locali.rL, locali.rM, locali.rN, locali.rO);
          }
          this.rx.clear();
          g.a(g.this).remove(this.rx);
        }
      };
      if (i != 0) {
        r.a(((i)((ArrayList)localObject1).get(0)).rP.ve, (Runnable)localObject2, dI());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.rp);
        this.rs.add(localObject1);
        this.rp.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            Iterator localIterator = this.rz.iterator();
            while (localIterator.hasNext())
            {
              h localh = (h)localIterator.next();
              g.a(g.this, localh);
            }
            this.rz.clear();
            g.b(g.this).remove(this.rz);
          }
        };
        if (i == 0) {
          break label477;
        }
        r.a(((h)((ArrayList)localObject1).get(0)).rJ.ve, (Runnable)localObject2, dI());
      }
      if (m == 0) {
        break label485;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.rn);
      this.rq.add(localObject1);
      this.rn.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = this.rA.iterator();
          while (localIterator.hasNext())
          {
            an localan = (an)localIterator.next();
            g.a(g.this, localan);
          }
          this.rA.clear();
          g.c(g.this).remove(this.rA);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label505;
      }
      if (i == 0) {
        break label487;
      }
      l1 = dI();
      if (j == 0) {
        break label493;
      }
      l2 = dG();
      label425:
      if (k == 0) {
        break label499;
      }
    }
    label477:
    label485:
    label487:
    label493:
    label499:
    for (long l3 = dJ();; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      r.a(((an)((ArrayList)localObject1).get(0)).ve, (Runnable)localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label260;
      ((Runnable)localObject2).run();
      break label340;
      break;
      l1 = 0L;
      break label415;
      l2 = 0L;
      break label425;
    }
    label505:
    ((Runnable)localObject2).run();
  }
  
  public final void cI()
  {
    int i = this.ro.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (i)this.ro.get(i);
      localObject2 = ((i)localObject1).rP.ve;
      r.b((View)localObject2, 0.0F);
      r.a((View)localObject2, 0.0F);
      h(((i)localObject1).rP);
      this.ro.remove(i);
      i -= 1;
    }
    i = this.rm.size() - 1;
    while (i >= 0)
    {
      g((an)this.rm.get(i));
      this.rm.remove(i);
      i -= 1;
    }
    i = this.rn.size() - 1;
    while (i >= 0)
    {
      localObject1 = (an)this.rn.get(i);
      r.c(((an)localObject1).ve, 1.0F);
      i((an)localObject1);
      this.rn.remove(i);
      i -= 1;
    }
    i = this.rp.size() - 1;
    while (i >= 0)
    {
      a((h)this.rp.get(i));
      i -= 1;
    }
    this.rp.clear();
    if (!isRunning()) {
      return;
    }
    i = this.rr.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.rr.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (i)((ArrayList)localObject1).get(j);
        View localView = ((i)localObject2).rP.ve;
        r.b(localView, 0.0F);
        r.a(localView, 0.0F);
        h(((i)localObject2).rP);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.rr.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.rq.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.rq.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (an)((ArrayList)localObject1).get(j);
        r.c(((an)localObject2).ve, 1.0F);
        i((an)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.rq.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.rs.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.rs.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((h)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.rs.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    h(this.rv);
    h(this.ru);
    h(this.rt);
    h(this.rw);
    dL();
  }
  
  public final boolean isRunning()
  {
    return (!this.rn.isEmpty()) || (!this.rp.isEmpty()) || (!this.ro.isEmpty()) || (!this.rm.isEmpty()) || (!this.ru.isEmpty()) || (!this.rv.isEmpty()) || (!this.rt.isEmpty()) || (!this.rw.isEmpty()) || (!this.rr.isEmpty()) || (!this.rq.isEmpty()) || (!this.rs.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.g
 * JD-Core Version:    0.7.0.1
 */