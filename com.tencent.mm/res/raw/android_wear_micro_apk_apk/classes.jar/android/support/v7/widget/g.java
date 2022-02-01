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
  private ArrayList<an> tc = new ArrayList();
  private ArrayList<an> td = new ArrayList();
  private ArrayList<i> te = new ArrayList();
  private ArrayList<h> tf = new ArrayList();
  private ArrayList<ArrayList<an>> tg = new ArrayList();
  private ArrayList<ArrayList<i>> th = new ArrayList();
  private ArrayList<ArrayList<h>> ti = new ArrayList();
  private ArrayList<an> tj = new ArrayList();
  private ArrayList<an> tk = new ArrayList();
  private ArrayList<an> tl = new ArrayList();
  private ArrayList<an> tm = new ArrayList();
  
  private void a(h paramh)
  {
    if (paramh.tz != null) {
      a(paramh, paramh.tz);
    }
    if (paramh.tA != null) {
      a(paramh, paramh.tA);
    }
  }
  
  private void a(List<h> paramList, an paraman)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      h localh = (h)paramList.get(i);
      if ((a(localh, paraman)) && (localh.tz == null) && (localh.tA == null)) {
        paramList.remove(localh);
      }
      i -= 1;
    }
  }
  
  private boolean a(h paramh, an paraman)
  {
    if (paramh.tA == paraman) {
      paramh.tA = null;
    }
    for (;;)
    {
      r.c(paraman.wT, 1.0F);
      r.a(paraman.wT, 0.0F);
      r.b(paraman.wT, 0.0F);
      j(paraman);
      return true;
      if (paramh.tz != paraman) {
        break;
      }
      paramh.tz = null;
    }
    return false;
  }
  
  private void cP()
  {
    if (!isRunning()) {
      dZ();
    }
  }
  
  private void d(an paraman)
  {
    AnimatorCompatHelper.clearInterpolator(paraman.wT);
    c(paraman);
  }
  
  private static void h(List<an> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      r.p(((an)paramList.get(i)).wT).cancel();
      i -= 1;
    }
  }
  
  public final boolean a(an paraman)
  {
    d(paraman);
    this.tc.add(paraman);
    return true;
  }
  
  public final boolean a(an paraman, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paraman.wT;
    paramInt1 = (int)(paramInt1 + r.l(paraman.wT));
    paramInt2 = (int)(paramInt2 + r.m(paraman.wT));
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
    this.te.add(new i(paraman, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean a(an paraman1, an paraman2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = r.l(paraman1.wT);
    float f2 = r.m(paraman1.wT);
    float f3 = r.i(paraman1.wT);
    d(paraman1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    r.a(paraman1.wT, f1);
    r.b(paraman1.wT, f2);
    r.c(paraman1.wT, f3);
    if ((paraman2 != null) && (paraman2.wT != null))
    {
      d(paraman2);
      r.a(paraman2.wT, -i);
      r.b(paraman2.wT, -j);
      r.c(paraman2.wT, 0.0F);
    }
    this.tf.add(new h(paraman1, paraman2, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean b(an paraman)
  {
    d(paraman);
    r.c(paraman.wT, 0.0F);
    this.td.add(paraman);
    return true;
  }
  
  public final void c(an paraman)
  {
    View localView = paraman.wT;
    r.p(localView).cancel();
    int i = this.te.size() - 1;
    while (i >= 0)
    {
      if (((i)this.te.get(i)).tF == paraman)
      {
        r.b(localView, 0.0F);
        r.a(localView, 0.0F);
        h(paraman);
        this.te.remove(i);
      }
      i -= 1;
    }
    a(this.tf, paraman);
    if (this.tc.remove(paraman))
    {
      r.c(localView, 1.0F);
      g(paraman);
    }
    if (this.td.remove(paraman))
    {
      r.c(localView, 1.0F);
      i(paraman);
    }
    i = this.ti.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.ti.get(i);
      a(localArrayList, paraman);
      if (localArrayList.isEmpty()) {
        this.ti.remove(i);
      }
      i -= 1;
    }
    i = this.th.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.th.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((i)localArrayList.get(j)).tF != paraman) {
            break label293;
          }
          r.b(localView, 0.0F);
          r.a(localView, 0.0F);
          h(paraman);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.th.remove(i);
          }
        }
        i -= 1;
        break;
        label293:
        j -= 1;
      }
    }
    i = this.tg.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.tg.get(i);
      if (localArrayList.remove(paraman))
      {
        r.c(localView, 1.0F);
        i(paraman);
        if (localArrayList.isEmpty()) {
          this.tg.remove(i);
        }
      }
      i -= 1;
    }
    this.tl.remove(paraman);
    this.tj.remove(paraman);
    this.tm.remove(paraman);
    this.tk.remove(paraman);
    cP();
  }
  
  public final void cO()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.tc.isEmpty())
    {
      i = 1;
      if (this.te.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.tf.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.td.isEmpty()) {
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
    Object localObject1 = this.tc.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (an)((Iterator)localObject1).next();
      final as localas = r.p(((an)localObject2).wT);
      this.tl.add(localObject2);
      localas.b(dW()).c(0.0F).a(new j((an)localObject2)
      {
        public final void D(View paramAnonymousView) {}
        
        public final void E(View paramAnonymousView)
        {
          localas.a(null);
          r.c(paramAnonymousView, 1.0F);
          g.this.g(this.tr);
          g.d(g.this).remove(this.tr);
          g.e(g.this);
        }
      }).start();
    }
    this.tc.clear();
    label260:
    label340:
    long l1;
    label415:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.te);
      this.th.add(localObject1);
      this.te.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = this.tn.iterator();
          while (localIterator.hasNext())
          {
            i locali = (i)localIterator.next();
            g.a(g.this, locali.tF, locali.tB, locali.tC, locali.tD, locali.tE);
          }
          this.tn.clear();
          g.a(g.this).remove(this.tn);
        }
      };
      if (i != 0) {
        r.a(((i)((ArrayList)localObject1).get(0)).tF.wT, (Runnable)localObject2, dW());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.tf);
        this.ti.add(localObject1);
        this.tf.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            Iterator localIterator = this.tp.iterator();
            while (localIterator.hasNext())
            {
              h localh = (h)localIterator.next();
              g.a(g.this, localh);
            }
            this.tp.clear();
            g.b(g.this).remove(this.tp);
          }
        };
        if (i == 0) {
          break label477;
        }
        r.a(((h)((ArrayList)localObject1).get(0)).tz.wT, (Runnable)localObject2, dW());
      }
      if (m == 0) {
        break label485;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.td);
      this.tg.add(localObject1);
      this.td.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = this.tq.iterator();
          while (localIterator.hasNext())
          {
            an localan = (an)localIterator.next();
            g.a(g.this, localan);
          }
          this.tq.clear();
          g.c(g.this).remove(this.tq);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label505;
      }
      if (i == 0) {
        break label487;
      }
      l1 = dW();
      if (j == 0) {
        break label493;
      }
      l2 = dU();
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
    for (long l3 = dX();; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      r.a(((an)((ArrayList)localObject1).get(0)).wT, (Runnable)localObject2, l1 + l2);
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
  
  public final void cQ()
  {
    int i = this.te.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (i)this.te.get(i);
      localObject2 = ((i)localObject1).tF.wT;
      r.b((View)localObject2, 0.0F);
      r.a((View)localObject2, 0.0F);
      h(((i)localObject1).tF);
      this.te.remove(i);
      i -= 1;
    }
    i = this.tc.size() - 1;
    while (i >= 0)
    {
      g((an)this.tc.get(i));
      this.tc.remove(i);
      i -= 1;
    }
    i = this.td.size() - 1;
    while (i >= 0)
    {
      localObject1 = (an)this.td.get(i);
      r.c(((an)localObject1).wT, 1.0F);
      i((an)localObject1);
      this.td.remove(i);
      i -= 1;
    }
    i = this.tf.size() - 1;
    while (i >= 0)
    {
      a((h)this.tf.get(i));
      i -= 1;
    }
    this.tf.clear();
    if (!isRunning()) {
      return;
    }
    i = this.th.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.th.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (i)((ArrayList)localObject1).get(j);
        View localView = ((i)localObject2).tF.wT;
        r.b(localView, 0.0F);
        r.a(localView, 0.0F);
        h(((i)localObject2).tF);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.th.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.tg.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.tg.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (an)((ArrayList)localObject1).get(j);
        r.c(((an)localObject2).wT, 1.0F);
        i((an)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.tg.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.ti.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.ti.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((h)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.ti.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    h(this.tl);
    h(this.tk);
    h(this.tj);
    h(this.tm);
    dZ();
  }
  
  public final boolean isRunning()
  {
    return (!this.td.isEmpty()) || (!this.tf.isEmpty()) || (!this.te.isEmpty()) || (!this.tc.isEmpty()) || (!this.tk.isEmpty()) || (!this.tl.isEmpty()) || (!this.tj.isEmpty()) || (!this.tm.isEmpty()) || (!this.th.isEmpty()) || (!this.tg.isEmpty()) || (!this.ti.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.g
 * JD-Core Version:    0.7.0.1
 */