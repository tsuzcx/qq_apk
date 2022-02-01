package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.r.b;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class f
  extends RecyclerView.j
{
  private final RecyclerView.l bZo = new f.1(this);
  protected Scroller cbe;
  public RecyclerView mRecyclerView;
  
  final void KX()
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
    this.mRecyclerView.br(localObject[0], localObject[1]);
  }
  
  public abstract int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.LayoutManager paramLayoutManager);
  
  public final void a(RecyclerView paramRecyclerView)
  {
    if (this.mRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.b(this.bZo);
        this.mRecyclerView.setOnFlingListener(null);
      }
      this.mRecyclerView = paramRecyclerView;
    } while (this.mRecyclerView == null);
    if (this.mRecyclerView.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.mRecyclerView.a(this.bZo);
    this.mRecyclerView.setOnFlingListener(this);
    this.cbe = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
    KX();
  }
  
  public abstract int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView);
  
  public final boolean bC(int paramInt1, int paramInt2)
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
            o localo = f(localLayoutManager);
            if (localo == null)
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
                localo.cag = paramInt1;
                localLayoutManager.startSmoothScroll(localo);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  @Deprecated
  protected o f(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.r.b)) {
      return null;
    }
    new o(this.mRecyclerView.getContext())
    {
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(271708);
        if (f.this.mRecyclerView == null)
        {
          AppMethodBeat.o(271708);
          return;
        }
        paramAnonymousView = f.this.a(f.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = fO(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.bXY);
        }
        AppMethodBeat.o(271708);
      }
      
      public final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */