package com.tencent.mm.plugin.taskbar.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.g.z;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends w
{
  private static TimeInterpolator bUE;
  private boolean SSx;
  protected ArrayList<RecyclerView.v> bUF;
  protected ArrayList<RecyclerView.v> bUG;
  private ArrayList<b> bUH;
  private ArrayList<a> bUI;
  ArrayList<ArrayList<RecyclerView.v>> bUJ;
  ArrayList<ArrayList<b>> bUK;
  ArrayList<ArrayList<a>> bUL;
  ArrayList<RecyclerView.v> bUM;
  ArrayList<RecyclerView.v> bUN;
  ArrayList<RecyclerView.v> bUO;
  protected ArrayList<RecyclerView.v> bUP;
  
  public c()
  {
    AppMethodBeat.i(264041);
    this.bUF = new ArrayList();
    this.bUG = new ArrayList();
    this.bUH = new ArrayList();
    this.bUI = new ArrayList();
    this.SSx = false;
    this.bUJ = new ArrayList();
    this.bUK = new ArrayList();
    this.bUL = new ArrayList();
    this.bUM = new ArrayList();
    this.bUN = new ArrayList();
    this.bUO = new ArrayList();
    this.bUP = new ArrayList();
    AppMethodBeat.o(264041);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(264047);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.bVc == null) && (locala.bVd == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(264047);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(264057);
    if (parama.bVd == paramv) {
      parama.bVd = null;
    }
    for (;;)
    {
      paramv.caK.setAlpha(1.0F);
      paramv.caK.setTranslationX(0.0F);
      paramv.caK.setTranslationY(0.0F);
      r(paramv);
      AppMethodBeat.o(264057);
      return true;
      if (parama.bVc != paramv) {
        break;
      }
      parama.bVc = null;
    }
    AppMethodBeat.o(264057);
    return false;
  }
  
  private static void ae(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(264070);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).caK.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(264070);
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(264050);
    if (parama.bVc != null) {
      a(parama, parama.bVc);
    }
    if (parama.bVd != null) {
      a(parama, parama.bVd);
    }
    AppMethodBeat.o(264050);
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(264064);
    if (bUE == null) {
      bUE = new ValueAnimator().getInterpolator();
    }
    paramv.caK.animate().setInterpolator(bUE);
    c(paramv);
    AppMethodBeat.o(264064);
  }
  
  public final void IW()
  {
    AppMethodBeat.i(264083);
    int i;
    int j;
    label29:
    int k;
    if (!this.bUF.isEmpty())
    {
      i = 1;
      if (this.bUH.isEmpty()) {
        break label82;
      }
      j = 1;
      if (this.bUI.isEmpty()) {
        break label87;
      }
      k = 1;
      label41:
      if (this.bUG.isEmpty()) {
        break label92;
      }
    }
    label82:
    label87:
    label92:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label98;
      }
      AppMethodBeat.o(264083);
      return;
      i = 0;
      break;
      j = 0;
      break label29;
      k = 0;
      break label41;
    }
    label98:
    Object localObject1 = this.bUF.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      final View localView = ((RecyclerView.v)localObject2).caK;
      final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.bUO.add(localObject2);
      localViewPropertyAnimator.setDuration(Ku()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(264082);
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          c.this.A(this.bUU);
          c.this.bUO.remove(this.bUU);
          c.this.IX();
          AppMethodBeat.o(264082);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(264074);
          c.this.C(this.bUU);
          AppMethodBeat.o(264074);
        }
      }).start();
    }
    this.bUF.clear();
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUH);
      this.bUK.add(localObject1);
      this.bUH.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264077);
          Iterator localIterator = this.bUQ.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (c.b)localIterator.next();
            c localc = c.this;
            RecyclerView.v localv = ((c.b)localObject).bVi;
            int k = ((c.b)localObject).bVe;
            int i = ((c.b)localObject).bVf;
            int m = ((c.b)localObject).bVg;
            int j = ((c.b)localObject).bVh;
            localObject = localv.caK;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            localc.bUN.add(localv);
            localViewPropertyAnimator.setDuration(localc.bZK).setListener(new c.6(localc, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.bUQ.clear();
          c.this.bUK.remove(this.bUQ);
          AppMethodBeat.o(264077);
        }
      };
      this.SSx = false;
      z.a(((b)((ArrayList)localObject1).get(0)).bVi.caK, (Runnable)localObject2, Ku());
    }
    if (k != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUI);
      this.bUL.add(localObject1);
      this.bUI.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264075);
          Iterator localIterator = this.bUS.iterator();
          while (localIterator.hasNext())
          {
            c.a locala = (c.a)localIterator.next();
            c.this.a(locala);
          }
          this.bUS.clear();
          c.this.bUL.remove(this.bUS);
          AppMethodBeat.o(264075);
        }
      };
      if (i == 0) {
        break label449;
      }
      z.a(((a)((ArrayList)localObject1).get(0)).bVc.caK, (Runnable)localObject2, Ku());
    }
    while (m != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUG);
      this.bUJ.add(localObject1);
      this.bUG.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264065);
          Iterator localIterator = this.bUT.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            c localc = c.this;
            View localView = localv.caK;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localc.bUM.add(localv);
            localViewPropertyAnimator.alpha(1.0F).setDuration(localc.Kt()).setListener(new c.5(localc, localv, localView, localViewPropertyAnimator)).start();
          }
          this.bUT.clear();
          c.this.bUJ.remove(this.bUT);
          AppMethodBeat.o(264065);
        }
      };
      if ((i != 0) || (j != 0) || (k != 0))
      {
        z.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).caK, (Runnable)localObject2, Ku());
        AppMethodBeat.o(264083);
        return;
        label449:
        ((Runnable)localObject2).run();
      }
      else
      {
        ((Runnable)localObject2).run();
      }
    }
    AppMethodBeat.o(264083);
  }
  
  final void IX()
  {
    AppMethodBeat.i(264148);
    if (!isRunning()) {
      Kv();
    }
    AppMethodBeat.o(264148);
  }
  
  public final void IY()
  {
    AppMethodBeat.i(264162);
    int i = this.bUH.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.bUH.get(i);
      localObject2 = ((b)localObject1).bVi.caK;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      B(((b)localObject1).bVi);
      this.bUH.remove(i);
      i -= 1;
    }
    i = this.bUF.size() - 1;
    while (i >= 0)
    {
      A((RecyclerView.v)this.bUF.get(i));
      this.bUF.remove(i);
      i -= 1;
    }
    i = this.bUG.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.bUG.get(i);
      ((RecyclerView.v)localObject1).caK.setAlpha(1.0F);
      r((RecyclerView.v)localObject1);
      this.bUG.remove(i);
      i -= 1;
    }
    i = this.bUI.size() - 1;
    while (i >= 0)
    {
      b((a)this.bUI.get(i));
      i -= 1;
    }
    this.bUI.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(264162);
      return;
    }
    i = this.bUK.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUK.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).bVi.caK;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        B(((b)localObject2).bVi);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUK.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.bUJ.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUJ.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).caK.setAlpha(1.0F);
        r((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUJ.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.bUL.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUL.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        b((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUL.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    ae(this.bUO);
    ae(this.bUN);
    ae(this.bUM);
    ae(this.bUP);
    Kv();
    AppMethodBeat.o(264162);
  }
  
  protected final void a(final a parama)
  {
    final View localView = null;
    AppMethodBeat.i(264119);
    Object localObject1 = parama.bVc;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((RecyclerView.v)localObject1).caK)
    {
      Object localObject2 = parama.bVd;
      if (localObject2 != null) {
        localView = ((RecyclerView.v)localObject2).caK;
      }
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).animate().setDuration(this.bZL);
        this.bUP.add(parama.bVc);
        ((ViewPropertyAnimator)localObject2).translationX(parama.bVg - parama.bVe);
        ((ViewPropertyAnimator)localObject2).translationY(parama.bVh - parama.bVf);
        ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(264088);
            this.bUZ.setListener(null);
            this.val$view.setAlpha(1.0F);
            this.val$view.setTranslationX(0.0F);
            this.val$view.setTranslationY(0.0F);
            c.this.r(parama.bVc);
            c.this.bUP.remove(parama.bVc);
            c.this.IX();
            AppMethodBeat.o(264088);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
      }
      if (localView != null)
      {
        localObject1 = localView.animate();
        this.bUP.add(parama.bVd);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(this.bZL).alpha(1.0F).setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(264086);
            this.bVa.setListener(null);
            localView.setAlpha(1.0F);
            localView.setTranslationX(0.0F);
            localView.setTranslationY(0.0F);
            c.this.r(parama.bVd);
            c.this.bUP.remove(parama.bVd);
            c.this.IX();
            AppMethodBeat.o(264086);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
      }
      AppMethodBeat.o(264119);
      return;
    }
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(264091);
    d(paramv);
    this.bUF.add(paramv);
    AppMethodBeat.o(264091);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(264105);
    View localView = paramv.caK;
    paramInt1 += (int)paramv.caK.getTranslationX();
    paramInt2 += (int)paramv.caK.getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      B(paramv);
      AppMethodBeat.o(264105);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.bUH.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(264105);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(264112);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(264112);
      return bool;
    }
    float f1 = paramv1.caK.getTranslationX();
    float f2 = paramv1.caK.getTranslationY();
    float f3 = paramv1.caK.getAlpha();
    d(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.caK.setTranslationX(f1);
    paramv1.caK.setTranslationY(f2);
    paramv1.caK.setAlpha(f3);
    if (paramv2 != null)
    {
      d(paramv2);
      paramv2.caK.setTranslationX(-i);
      paramv2.caK.setTranslationY(-j);
      paramv2.caK.setAlpha(0.0F);
    }
    this.bUI.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(264112);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(264168);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(264168);
      return true;
    }
    AppMethodBeat.o(264168);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(264099);
    d(paramv);
    paramv.caK.setAlpha(0.0F);
    this.bUG.add(paramv);
    AppMethodBeat.o(264099);
    return true;
  }
  
  public final void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(264129);
    View localView = paramv.caK;
    localView.animate().cancel();
    int i = this.bUH.size() - 1;
    while (i >= 0)
    {
      if (((b)this.bUH.get(i)).bVi == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        B(paramv);
        this.bUH.remove(i);
      }
      i -= 1;
    }
    a(this.bUI, paramv);
    if (this.bUF.remove(paramv))
    {
      localView.setAlpha(1.0F);
      A(paramv);
    }
    if (this.bUG.remove(paramv))
    {
      localView.setAlpha(1.0F);
      r(paramv);
    }
    i = this.bUL.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.bUL.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.bUL.remove(i);
      }
      i -= 1;
    }
    i = this.bUK.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.bUK.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((b)localArrayList.get(j)).bVi != paramv) {
            break label299;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          B(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.bUK.remove(i);
          }
        }
        i -= 1;
        break;
        label299:
        j -= 1;
      }
    }
    i = this.bUJ.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.bUJ.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        r(paramv);
        if (localArrayList.isEmpty()) {
          this.bUJ.remove(i);
        }
      }
      i -= 1;
    }
    this.bUO.remove(paramv);
    this.bUM.remove(paramv);
    this.bUP.remove(paramv);
    this.bUN.remove(paramv);
    IX();
    AppMethodBeat.o(264129);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(264139);
    if ((!this.bUG.isEmpty()) || (!this.bUI.isEmpty()) || (!this.bUH.isEmpty()) || (!this.bUF.isEmpty()) || (!this.bUN.isEmpty()) || (!this.bUO.isEmpty()) || (!this.bUM.isEmpty()) || (!this.bUP.isEmpty()) || (!this.bUK.isEmpty()) || (!this.bUJ.isEmpty()) || (!this.bUL.isEmpty()))
    {
      AppMethodBeat.o(264139);
      return true;
    }
    AppMethodBeat.o(264139);
    return false;
  }
  
  protected static final class a
  {
    public RecyclerView.v bVc;
    public RecyclerView.v bVd;
    public int bVe;
    public int bVf;
    public int bVg;
    public int bVh;
    
    private a(RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      this.bVc = paramv1;
      this.bVd = paramv2;
    }
    
    a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramv1, paramv2);
      this.bVe = paramInt1;
      this.bVf = paramInt2;
      this.bVg = paramInt3;
      this.bVh = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(264062);
      String str = "ChangeInfo{oldHolder=" + this.bVc + ", newHolder=" + this.bVd + ", fromX=" + this.bVe + ", fromY=" + this.bVf + ", toX=" + this.bVg + ", toY=" + this.bVh + '}';
      AppMethodBeat.o(264062);
      return str;
    }
  }
  
  static final class b
  {
    public int bVe;
    public int bVf;
    public int bVg;
    public int bVh;
    public RecyclerView.v bVi;
    
    b(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.bVi = paramv;
      this.bVe = paramInt1;
      this.bVf = paramInt2;
      this.bVg = paramInt3;
      this.bVh = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.c
 * JD-Core Version:    0.7.0.1
 */