package android.support.v7.widget;

import android.support.v4.view.r;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class af
{
  final ArrayList<an> wj = new ArrayList();
  private ArrayList<an> wk = null;
  final ArrayList<an> wl = new ArrayList();
  private final List<an> wm = Collections.unmodifiableList(this.wj);
  private int wn = 2;
  private ae wo;
  private al wp;
  
  public af(RecyclerView paramRecyclerView) {}
  
  private an a(long paramLong, int paramInt, boolean paramBoolean)
  {
    paramInt = this.wj.size() - 1;
    an localan;
    while (paramInt >= 0)
    {
      localan = (an)this.wj.get(paramInt);
      if ((localan.wV == -1L) && (!localan.ey()))
      {
        if (localan.wW == 0)
        {
          localan.addFlags(32);
          if ((localan.isRemoved()) && (!this.vQ.vC.em())) {
            localan.setFlags(2, 14);
          }
          return localan;
        }
        this.wj.remove(paramInt);
        this.vQ.removeDetachedView(localan.wT, false);
        aD(localan.wT);
      }
      paramInt -= 1;
    }
    paramInt = this.wl.size() - 1;
    while (paramInt >= 0)
    {
      localan = (an)this.wl.get(paramInt);
      if (localan.wV == -1L)
      {
        if (localan.wW == 0)
        {
          this.wl.remove(paramInt);
          return localan;
        }
        aG(paramInt);
      }
      paramInt -= 1;
    }
    return null;
  }
  
  private void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView, true);
      }
      i -= 1;
    }
    if (!paramBoolean) {
      return;
    }
    if (paramViewGroup.getVisibility() == 4)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setVisibility(4);
      return;
    }
    i = paramViewGroup.getVisibility();
    paramViewGroup.setVisibility(4);
    paramViewGroup.setVisibility(i);
  }
  
  private an aH(int paramInt)
  {
    int j = 0;
    int k;
    if (this.wk != null)
    {
      k = this.wk.size();
      if (k != 0) {}
    }
    else
    {
      return null;
    }
    int i = 0;
    an localan;
    while (i < k)
    {
      localan = (an)this.wk.get(i);
      if ((!localan.ey()) && (localan.ev() == paramInt))
      {
        localan.addFlags(32);
        return localan;
      }
      i += 1;
    }
    if (RecyclerView.g(this.vQ).hasStableIds())
    {
      paramInt = this.vQ.uQ.m(paramInt, 0);
      if ((paramInt > 0) && (paramInt < RecyclerView.g(this.vQ).getItemCount()))
      {
        RecyclerView.g(this.vQ);
        paramInt = j;
        while (paramInt < k)
        {
          localan = (an)this.wk.get(paramInt);
          if ((!localan.ey()) && (localan.wV == -1L))
          {
            localan.addFlags(32);
            return localan;
          }
          paramInt += 1;
        }
      }
    }
    return null;
  }
  
  private an d(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int k = this.wj.size();
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = (an)this.wj.get(i);
      if ((!((an)localObject).ey()) && (((an)localObject).ev() == paramInt) && (!((an)localObject).eB()) && ((ak.p(this.vQ.vC)) || (!((an)localObject).isRemoved())))
      {
        ((an)localObject).addFlags(32);
        return localObject;
      }
      i += 1;
    }
    d locald = this.vQ.uR;
    k = locald.sZ.size();
    i = 0;
    if (i < k)
    {
      localObject = (View)locald.sZ.get(i);
      an localan = locald.sX.af((View)localObject);
      if ((localan.ev() == paramInt) && (!localan.eB()))
      {
        label172:
        if (localObject != null) {
          this.vQ.vs.c(this.vQ.af((View)localObject));
        }
        k = this.wl.size();
        i = j;
      }
    }
    for (;;)
    {
      if (i >= k) {
        break label276;
      }
      localObject = (an)this.wl.get(i);
      if ((!((an)localObject).eB()) && (((an)localObject).ev() == paramInt))
      {
        this.wl.remove(i);
        return localObject;
        i += 1;
        break;
        localObject = null;
        break label172;
      }
      i += 1;
    }
    label276:
    return null;
  }
  
  private void eh()
  {
    int i = this.wl.size() - 1;
    while (i >= 0)
    {
      aG(i);
      i -= 1;
    }
    this.wl.clear();
  }
  
  private void q(an paraman)
  {
    r.a(paraman.wT, null);
    s(paraman);
    paraman.xg = null;
    ei().o(paraman);
  }
  
  private void s(an paraman)
  {
    if (RecyclerView.o(this.vQ) != null) {
      RecyclerView.o(this.vQ);
    }
    if (RecyclerView.g(this.vQ) != null) {
      RecyclerView.g(this.vQ);
    }
    if (this.vQ.vC != null) {
      this.vQ.vC.t(paraman);
    }
  }
  
  public final void aC(View paramView)
  {
    an localan = RecyclerView.ap(paramView);
    if (localan.eE()) {
      this.vQ.removeDetachedView(paramView, false);
    }
    if (localan.ew()) {
      localan.ex();
    }
    for (;;)
    {
      p(localan);
      return;
      if (localan.ey()) {
        localan.ez();
      }
    }
  }
  
  final void aD(View paramView)
  {
    paramView = RecyclerView.ap(paramView);
    an.x(paramView);
    paramView.ez();
    p(paramView);
  }
  
  public final int aE(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.vQ.vC.getItemCount())) {
      throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + this.vQ.vC.getItemCount());
    }
    if (!this.vQ.vC.em()) {
      return paramInt;
    }
    return this.vQ.uQ.aj(paramInt);
  }
  
  final void aE(View paramView)
  {
    paramView = RecyclerView.ap(paramView);
    paramView.f(this);
    if ((!paramView.eD()) || (!RecyclerView.i(this.vQ)))
    {
      if ((paramView.eB()) && (!paramView.isRemoved()) && (!RecyclerView.g(this.vQ).hasStableIds())) {
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
      }
      this.wj.add(paramView);
      return;
    }
    if (this.wk == null) {
      this.wk = new ArrayList();
    }
    this.wk.add(paramView);
  }
  
  public final View aF(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt >= this.vQ.vC.getItemCount())) {
      throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + this.vQ.vC.getItemCount());
    }
    Object localObject1;
    int i;
    if (this.vQ.vC.em())
    {
      localObject1 = aH(paramInt);
      if (localObject1 != null) {
        i = 1;
      }
    }
    for (int j = i;; j = 0)
    {
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = d(paramInt, false);
        localObject1 = localObject2;
        i = j;
        if (localObject2 != null)
        {
          if (((an)localObject2).isRemoved()) {
            break label406;
          }
          if ((((an)localObject2).un < 0) || (((an)localObject2).un >= RecyclerView.g(this.vQ).getItemCount()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position".concat(String.valueOf(localObject2)));
            i = 0;
            break;
          }
          if (this.vQ.vC.em()) {
            break label364;
          }
          RecyclerView.g(this.vQ);
          if (((an)localObject2).wW == 0) {
            break label364;
          }
          i = 0;
          if (i != 0) {
            break label427;
          }
          ((an)localObject2).addFlags(4);
          if (!((an)localObject2).ew()) {
            break label411;
          }
          this.vQ.removeDetachedView(((an)localObject2).wT, false);
          ((an)localObject2).ex();
          label253:
          p((an)localObject2);
          localObject1 = null;
          i = j;
        }
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        int k = i;
        if (localObject1 == null)
        {
          k = this.vQ.uQ.aj(paramInt);
          if ((k < 0) || (k >= RecyclerView.g(this.vQ).getItemCount()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + this.vQ.vC.getItemCount());
            label364:
            if (RecyclerView.g(this.vQ).hasStableIds())
            {
              long l = ((an)localObject2).wV;
              RecyclerView.g(this.vQ);
              if (l != -1L)
              {
                i = 0;
                break;
              }
            }
            label406:
            i = 1;
            break;
            label411:
            if (!((an)localObject2).ey()) {
              break label253;
            }
            ((an)localObject2).ez();
            break label253;
            label427:
            i = 1;
            localObject1 = localObject2;
            continue;
          }
          RecyclerView.g(this.vQ);
          localObject2 = localObject1;
          j = i;
          if (RecyclerView.g(this.vQ).hasStableIds())
          {
            RecyclerView.g(this.vQ);
            localObject1 = a(-1L, 0, false);
            localObject2 = localObject1;
            j = i;
            if (localObject1 != null)
            {
              ((an)localObject1).un = k;
              j = 1;
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (this.wp != null)
            {
              localObject3 = this.wp.eq();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject2 = this.vQ.af((View)localObject3);
                if (localObject2 == null) {
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                }
                localObject1 = localObject2;
                if (((an)localObject2).eu()) {
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                }
              }
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = ei().aD(0);
            if (localObject2 != null)
            {
              ((an)localObject2).df();
              if ((RecyclerView.dS()) && ((((an)localObject2).wT instanceof ViewGroup))) {
                a((ViewGroup)((an)localObject2).wT, false);
              }
            }
          }
          localObject3 = localObject2;
          k = j;
          if (localObject2 == null)
          {
            localObject1 = RecyclerView.g(this.vQ);
            localObject2 = this.vQ;
            android.support.v4.os.f.beginSection("RV CreateView");
            localObject2 = ((t)localObject1).b((ViewGroup)localObject2);
            ((an)localObject2).wW = 0;
            android.support.v4.os.f.endSection();
          }
        }
        for (;;)
        {
          if ((this.vQ.vC.em()) && (((an)localObject2).isBound()))
          {
            ((an)localObject2).wX = paramInt;
            paramInt = 0;
          }
          for (;;)
          {
            localObject1 = ((an)localObject2).wT.getLayoutParams();
            if (localObject1 == null)
            {
              localObject1 = (RecyclerView.LayoutParams)this.vQ.generateDefaultLayoutParams();
              ((an)localObject2).wT.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              label770:
              ((RecyclerView.LayoutParams)localObject1).wd = ((an)localObject2);
              if ((j == 0) || (paramInt == 0)) {
                break label983;
              }
            }
            for (;;)
            {
              ((RecyclerView.LayoutParams)localObject1).wf = bool;
              return ((an)localObject2).wT;
              if ((((an)localObject2).isBound()) && (!((an)localObject2).eC()) && (!((an)localObject2).eB())) {
                break label989;
              }
              i = this.vQ.uQ.aj(paramInt);
              ((an)localObject2).xg = this.vQ;
              RecyclerView.g(this.vQ).b((an)localObject2, i);
              localObject1 = ((an)localObject2).wT;
              if (this.vQ.dD())
              {
                if (r.h((View)localObject1) == 0) {
                  r.f((View)localObject1, 1);
                }
                if (!r.e((View)localObject1)) {
                  r.a((View)localObject1, RecyclerView.n(this.vQ).xh);
                }
              }
              if (this.vQ.vC.em()) {
                ((an)localObject2).wX = paramInt;
              }
              paramInt = 1;
              break;
              if (!this.vQ.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
              {
                localObject1 = (RecyclerView.LayoutParams)this.vQ.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                ((an)localObject2).wT.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                break label770;
              }
              localObject1 = (RecyclerView.LayoutParams)localObject1;
              break label770;
              label983:
              bool = false;
            }
            label989:
            paramInt = 0;
          }
          localObject2 = localObject3;
          j = k;
        }
        i = j;
      }
      localObject1 = null;
    }
  }
  
  final void aG(int paramInt)
  {
    q((an)this.wl.get(paramInt));
    this.wl.remove(paramInt);
  }
  
  public final void clear()
  {
    this.wj.clear();
    eh();
  }
  
  final void dN()
  {
    int j = 0;
    int k = this.wl.size();
    int i = 0;
    while (i < k)
    {
      ((an)this.wl.get(i)).es();
      i += 1;
    }
    k = this.wj.size();
    i = 0;
    while (i < k)
    {
      ((an)this.wj.get(i)).es();
      i += 1;
    }
    if (this.wk != null)
    {
      k = this.wk.size();
      i = j;
      while (i < k)
      {
        ((an)this.wk.get(i)).es();
        i += 1;
      }
    }
  }
  
  final void dP()
  {
    int j;
    int i;
    if ((RecyclerView.g(this.vQ) != null) && (RecyclerView.g(this.vQ).hasStableIds()))
    {
      j = this.wl.size();
      i = 0;
    }
    while (i < j)
    {
      an localan = (an)this.wl.get(i);
      if (localan != null)
      {
        localan.addFlags(6);
        localan.z(null);
      }
      i += 1;
      continue;
      eh();
    }
  }
  
  public final List<an> eg()
  {
    return this.wm;
  }
  
  final ae ei()
  {
    if (this.wo == null) {
      this.wo = new ae();
    }
    return this.wo;
  }
  
  final void p(an paraman)
  {
    int j = 1;
    boolean bool = true;
    if ((paraman.ew()) || (paraman.wT.getParent() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paraman.ew()).append(" isAttached:");
      if (paraman.wT.getParent() != null) {}
      for (;;)
      {
        throw new IllegalArgumentException(bool);
        bool = false;
      }
    }
    if (paraman.eE()) {
      throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: ".concat(String.valueOf(paraman)));
    }
    if (paraman.eu()) {
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
    }
    bool = an.w(paraman);
    if ((RecyclerView.g(this.vQ) != null) && (bool)) {
      RecyclerView.g(this.vQ);
    }
    int i;
    if (paraman.eH()) {
      if (!paraman.aK(78))
      {
        i = this.wl.size();
        if ((i == this.wn) && (i > 0)) {
          aG(0);
        }
        if (i < this.wn)
        {
          this.wl.add(paraman);
          i = 1;
          if (i == 0) {
            q(paraman);
          }
        }
      }
    }
    for (;;)
    {
      this.vQ.vC.t(paraman);
      if ((i == 0) && (j == 0) && (bool)) {
        paraman.xg = null;
      }
      return;
      j = 0;
      continue;
      i = 0;
      break;
      j = 0;
      i = 0;
    }
  }
  
  final void r(an paraman)
  {
    if ((!paraman.eD()) || (!RecyclerView.i(this.vQ)) || (this.wk == null)) {
      this.wj.remove(paraman);
    }
    for (;;)
    {
      an.x(paraman);
      paraman.ez();
      return;
      this.wk.remove(paraman);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.af
 * JD-Core Version:    0.7.0.1
 */