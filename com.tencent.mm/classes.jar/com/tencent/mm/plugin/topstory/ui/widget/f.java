package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class f
  extends RecyclerView.j
{
  private final RecyclerView.l asS = new f.1(this);
  protected Scroller awJ;
  public RecyclerView mRecyclerView;
  
  public abstract int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.LayoutManager paramLayoutManager);
  
  public abstract int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView);
  
  public final boolean av(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    if (localLayoutManager == null) {}
    for (;;)
    {
      return false;
      if (this.mRecyclerView.getAdapter() != null)
      {
        int i = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i))
        {
          if (!(localLayoutManager instanceof RecyclerView.r.b)) {
            paramInt1 = 0;
          }
          while (paramInt1 != 0)
          {
            return true;
            ae localae = f(localLayoutManager);
            if (localae == null)
            {
              paramInt1 = 0;
            }
            else
            {
              paramInt1 = a(localLayoutManager, paramInt1, paramInt2);
              if (paramInt1 == -1)
              {
                paramInt1 = 0;
              }
              else
              {
                localae.atO = paramInt1;
                localLayoutManager.startSmoothScroll(localae);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  @Deprecated
  protected ae f(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.r.b)) {
      return null;
    }
    new ae(this.mRecyclerView.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(126675);
        if (f.this.mRecyclerView == null)
        {
          AppMethodBeat.o(126675);
          return;
        }
        paramAnonymousView = f.this.a(f.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cc(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.VQ);
        }
        AppMethodBeat.o(126675);
      }
    };
  }
  
  public final void f(RecyclerView paramRecyclerView)
  {
    if (this.mRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.b(this.asS);
        this.mRecyclerView.setOnFlingListener(null);
      }
      this.mRecyclerView = paramRecyclerView;
    } while (this.mRecyclerView == null);
    if (this.mRecyclerView.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.mRecyclerView.a(this.asS);
    this.mRecyclerView.setOnFlingListener(this);
    this.awJ = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
    mz();
  }
  
  final void mz()
  {
    if (this.mRecyclerView == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.mRecyclerView.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.LayoutManager)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.LayoutManager)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.mRecyclerView.a(localObject[0], localObject[1], null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */