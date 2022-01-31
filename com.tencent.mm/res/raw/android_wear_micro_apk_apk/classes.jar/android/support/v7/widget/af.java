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
  private al uA;
  final ArrayList<an> uu = new ArrayList();
  private ArrayList<an> uv = null;
  final ArrayList<an> uw = new ArrayList();
  private final List<an> ux = Collections.unmodifiableList(this.uu);
  private int uy = 2;
  private ae uz;
  
  public af(RecyclerView paramRecyclerView) {}
  
  private an a(long paramLong, int paramInt, boolean paramBoolean)
  {
    paramInt = this.uu.size() - 1;
    an localan;
    while (paramInt >= 0)
    {
      localan = (an)this.uu.get(paramInt);
      if ((localan.vg == -1L) && (!localan.ej()))
      {
        if (localan.vh == 0)
        {
          localan.addFlags(32);
          if ((localan.isRemoved()) && (!this.ua.tM.dY())) {
            localan.setFlags(2, 14);
          }
          return localan;
        }
        this.uu.remove(paramInt);
        this.ua.removeDetachedView(localan.ve, false);
        aw(localan.ve);
      }
      paramInt -= 1;
    }
    paramInt = this.uw.size() - 1;
    while (paramInt >= 0)
    {
      localan = (an)this.uw.get(paramInt);
      if (localan.vg == -1L)
      {
        if (localan.vh == 0)
        {
          this.uw.remove(paramInt);
          return localan;
        }
        au(paramInt);
      }
      paramInt -= 1;
    }
    return null;
  }
  
  private an av(int paramInt)
  {
    int j = 0;
    int k;
    if (this.uv != null)
    {
      k = this.uv.size();
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
      localan = (an)this.uv.get(i);
      if ((!localan.ej()) && (localan.eg() == paramInt))
      {
        localan.addFlags(32);
        return localan;
      }
      i += 1;
    }
    if (RecyclerView.g(this.ua).hasStableIds())
    {
      paramInt = this.ua.ta.l(paramInt, 0);
      if ((paramInt > 0) && (paramInt < RecyclerView.g(this.ua).getItemCount()))
      {
        RecyclerView.g(this.ua);
        paramInt = j;
        while (paramInt < k)
        {
          localan = (an)this.uv.get(paramInt);
          if ((!localan.ej()) && (localan.vg == -1L))
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
  
  private void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        b((ViewGroup)localView, true);
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
  
  private an c(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int k = this.uu.size();
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = (an)this.uu.get(i);
      if ((!((an)localObject).ej()) && (((an)localObject).eg() == paramInt) && (!((an)localObject).em()) && ((ak.p(this.ua.tM)) || (!((an)localObject).isRemoved())))
      {
        ((an)localObject).addFlags(32);
        return localObject;
      }
      i += 1;
    }
    d locald = this.ua.tb;
    k = locald.rj.size();
    i = 0;
    if (i < k)
    {
      localObject = (View)locald.rj.get(i);
      an localan = locald.rh.Z((View)localObject);
      if ((localan.eg() == paramInt) && (!localan.em()))
      {
        label172:
        if (localObject != null) {
          this.ua.tC.c(this.ua.Z((View)localObject));
        }
        k = this.uw.size();
        i = j;
      }
    }
    for (;;)
    {
      if (i >= k) {
        break label276;
      }
      localObject = (an)this.uw.get(i);
      if ((!((an)localObject).em()) && (((an)localObject).eg() == paramInt))
      {
        this.uw.remove(i);
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
  
  private void q(an paraman)
  {
    r.a(paraman.ve, null);
    if (RecyclerView.o(this.ua) != null) {
      RecyclerView.o(this.ua);
    }
    if (RecyclerView.g(this.ua) != null) {
      RecyclerView.g(this.ua);
    }
    if (this.ua.tM != null) {
      this.ua.tM.s(paraman);
    }
    paraman.vr = null;
    dU().o(paraman);
  }
  
  public final int as(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.ua.tM.getItemCount())) {
      throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + this.ua.tM.getItemCount());
    }
    if (!this.ua.tM.dY()) {
      return paramInt;
    }
    return this.ua.ta.Y(paramInt);
  }
  
  public final View at(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt >= this.ua.tM.getItemCount())) {
      throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + this.ua.tM.getItemCount());
    }
    Object localObject1;
    int i;
    if (this.ua.tM.dY())
    {
      localObject1 = av(paramInt);
      if (localObject1 != null) {
        i = 1;
      }
    }
    for (int j = i;; j = 0)
    {
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = c(paramInt, false);
        localObject1 = localObject2;
        i = j;
        if (localObject2 != null)
        {
          if (((an)localObject2).isRemoved()) {
            break label425;
          }
          if ((((an)localObject2).sx < 0) || (((an)localObject2).sx >= RecyclerView.g(this.ua).getItemCount()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + localObject2);
            i = 0;
            break;
          }
          if (this.ua.tM.dY()) {
            break label377;
          }
          RecyclerView.g(this.ua);
          i = ((an)localObject2).sx;
          if (((an)localObject2).vh == 0) {
            break label377;
          }
          i = 0;
          if (i != 0) {
            break label446;
          }
          ((an)localObject2).addFlags(4);
          if (!((an)localObject2).eh()) {
            break label430;
          }
          this.ua.removeDetachedView(((an)localObject2).ve, false);
          ((an)localObject2).ei();
          label266:
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
          k = this.ua.ta.Y(paramInt);
          if ((k < 0) || (k >= RecyclerView.g(this.ua).getItemCount()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + this.ua.tM.getItemCount());
            label377:
            if (RecyclerView.g(this.ua).hasStableIds())
            {
              long l = ((an)localObject2).vg;
              RecyclerView.g(this.ua);
              i = ((an)localObject2).sx;
              if (l != -1L)
              {
                i = 0;
                break;
              }
            }
            label425:
            i = 1;
            break;
            label430:
            if (!((an)localObject2).ej()) {
              break label266;
            }
            ((an)localObject2).ek();
            break label266;
            label446:
            i = 1;
            localObject1 = localObject2;
            continue;
          }
          RecyclerView.g(this.ua);
          localObject2 = localObject1;
          j = i;
          if (RecyclerView.g(this.ua).hasStableIds())
          {
            RecyclerView.g(this.ua);
            localObject1 = a(-1L, 0, false);
            localObject2 = localObject1;
            j = i;
            if (localObject1 != null)
            {
              ((an)localObject1).sx = k;
              j = 1;
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (this.uA != null)
            {
              localObject3 = this.uA.ec();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject2 = this.ua.Z((View)localObject3);
                if (localObject2 == null) {
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                }
                localObject1 = localObject2;
                if (((an)localObject2).ef()) {
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                }
              }
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = dU().ar(0);
            if (localObject2 != null)
            {
              ((an)localObject2).es();
              if ((RecyclerView.dE()) && ((((an)localObject2).ve instanceof ViewGroup))) {
                b((ViewGroup)((an)localObject2).ve, false);
              }
            }
          }
          localObject3 = localObject2;
          k = j;
          if (localObject2 == null)
          {
            localObject1 = RecyclerView.g(this.ua);
            localObject2 = this.ua;
            android.support.v4.os.f.beginSection("RV CreateView");
            localObject2 = ((t)localObject1).c((ViewGroup)localObject2);
            ((an)localObject2).vh = 0;
            android.support.v4.os.f.endSection();
          }
        }
        for (;;)
        {
          if ((this.ua.tM.dY()) && (((an)localObject2).isBound()))
          {
            ((an)localObject2).vi = paramInt;
            paramInt = 0;
          }
          for (;;)
          {
            localObject1 = ((an)localObject2).ve.getLayoutParams();
            if (localObject1 == null)
            {
              localObject1 = (RecyclerView.LayoutParams)this.ua.generateDefaultLayoutParams();
              ((an)localObject2).ve.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              label789:
              ((RecyclerView.LayoutParams)localObject1).uo = ((an)localObject2);
              if ((j == 0) || (paramInt == 0)) {
                break label1002;
              }
            }
            for (;;)
            {
              ((RecyclerView.LayoutParams)localObject1).uq = bool;
              return ((an)localObject2).ve;
              if ((((an)localObject2).isBound()) && (!((an)localObject2).en()) && (!((an)localObject2).em())) {
                break label1008;
              }
              i = this.ua.ta.Y(paramInt);
              ((an)localObject2).vr = this.ua;
              RecyclerView.g(this.ua).b((an)localObject2, i);
              localObject1 = ((an)localObject2).ve;
              if (this.ua.dt())
              {
                if (r.g((View)localObject1) == 0) {
                  r.c((View)localObject1, 1);
                }
                if (!r.d((View)localObject1)) {
                  r.a((View)localObject1, RecyclerView.n(this.ua).vs);
                }
              }
              if (this.ua.tM.dY()) {
                ((an)localObject2).vi = paramInt;
              }
              paramInt = 1;
              break;
              if (!this.ua.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
              {
                localObject1 = (RecyclerView.LayoutParams)this.ua.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                ((an)localObject2).ve.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                break label789;
              }
              localObject1 = (RecyclerView.LayoutParams)localObject1;
              break label789;
              label1002:
              bool = false;
            }
            label1008:
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
  
  final void au(int paramInt)
  {
    q((an)this.uw.get(paramInt));
    this.uw.remove(paramInt);
  }
  
  public final void av(View paramView)
  {
    an localan = RecyclerView.ai(paramView);
    if (localan.ep()) {
      this.ua.removeDetachedView(paramView, false);
    }
    if (localan.eh()) {
      localan.ei();
    }
    for (;;)
    {
      p(localan);
      return;
      if (localan.ej()) {
        localan.ek();
      }
    }
  }
  
  final void aw(View paramView)
  {
    paramView = RecyclerView.ai(paramView);
    an.w(paramView);
    paramView.ek();
    p(paramView);
  }
  
  final void ax(View paramView)
  {
    paramView = RecyclerView.ai(paramView);
    paramView.f(this);
    if ((!paramView.eo()) || (!RecyclerView.i(this.ua)))
    {
      if ((paramView.em()) && (!paramView.isRemoved()) && (!RecyclerView.g(this.ua).hasStableIds())) {
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
      }
      this.uu.add(paramView);
      return;
    }
    if (this.uv == null) {
      this.uv = new ArrayList();
    }
    this.uv.add(paramView);
  }
  
  public final void clear()
  {
    this.uu.clear();
    dT();
  }
  
  public final List<an> dS()
  {
    return this.ux;
  }
  
  final void dT()
  {
    int i = this.uw.size() - 1;
    while (i >= 0)
    {
      au(i);
      i -= 1;
    }
    this.uw.clear();
  }
  
  final ae dU()
  {
    if (this.uz == null) {
      this.uz = new ae();
    }
    return this.uz;
  }
  
  final void dz()
  {
    int j = 0;
    int k = this.uw.size();
    int i = 0;
    while (i < k)
    {
      ((an)this.uw.get(i)).ee();
      i += 1;
    }
    k = this.uu.size();
    i = 0;
    while (i < k)
    {
      ((an)this.uu.get(i)).ee();
      i += 1;
    }
    if (this.uv != null)
    {
      k = this.uv.size();
      i = j;
      while (i < k)
      {
        ((an)this.uv.get(i)).ee();
        i += 1;
      }
    }
  }
  
  final void p(an paraman)
  {
    int j = 1;
    boolean bool = true;
    if ((paraman.eh()) || (paraman.ve.getParent() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paraman.eh()).append(" isAttached:");
      if (paraman.ve.getParent() != null) {}
      for (;;)
      {
        throw new IllegalArgumentException(bool);
        bool = false;
      }
    }
    if (paraman.ep()) {
      throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paraman);
    }
    if (paraman.ef()) {
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
    }
    bool = an.v(paraman);
    if ((RecyclerView.g(this.ua) != null) && (bool)) {
      RecyclerView.g(this.ua);
    }
    int i;
    if (paraman.et()) {
      if (!paraman.ay(78))
      {
        i = this.uw.size();
        if ((i == this.uy) && (i > 0)) {
          au(0);
        }
        if (i < this.uy)
        {
          this.uw.add(paraman);
          i = 1;
          if (i == 0) {
            q(paraman);
          }
        }
      }
    }
    for (;;)
    {
      this.ua.tM.s(paraman);
      if ((i == 0) && (j == 0) && (bool)) {
        paraman.vr = null;
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
    if ((!paraman.eo()) || (!RecyclerView.i(this.ua)) || (this.uv == null)) {
      this.uu.remove(paraman);
    }
    for (;;)
    {
      an.w(paraman);
      paraman.ek();
      return;
      this.uv.remove(paraman);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.af
 * JD-Core Version:    0.7.0.1
 */