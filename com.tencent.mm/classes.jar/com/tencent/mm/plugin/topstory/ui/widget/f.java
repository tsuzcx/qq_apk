package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class f
  extends RecyclerView.k
{
  public RecyclerView akA;
  private final RecyclerView.m apU = new RecyclerView.m()
  {
    boolean atZ = false;
    
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(202288);
      b localb = new b();
      localb.be(paramAnonymousRecyclerView);
      localb.lT(paramAnonymousInt1);
      localb.lT(paramAnonymousInt2);
      a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        this.atZ = true;
      }
      a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202288);
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(126674);
      b localb = new b();
      localb.be(paramAnonymousRecyclerView);
      localb.lT(paramAnonymousInt);
      a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (this.atZ))
      {
        this.atZ = false;
        f.this.lU();
      }
      a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(126674);
    }
  };
  protected Scroller atY;
  
  public abstract int a(RecyclerView.i parami, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.i parami);
  
  public abstract int[] a(RecyclerView.i parami, View paramView);
  
  public final boolean aA(int paramInt1, int paramInt2)
  {
    RecyclerView.i locali = this.akA.getLayoutManager();
    if (locali == null) {}
    for (;;)
    {
      return false;
      if (this.akA.getAdapter() != null)
      {
        int i = this.akA.getMinFlingVelocity();
        if ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i))
        {
          if (!(locali instanceof RecyclerView.r.b)) {
            paramInt1 = 0;
          }
          while (paramInt1 != 0)
          {
            return true;
            ae localae = f(locali);
            if (localae == null)
            {
              paramInt1 = 0;
            }
            else
            {
              paramInt1 = a(locali, paramInt1, paramInt2);
              if (paramInt1 == -1)
              {
                paramInt1 = 0;
              }
              else
              {
                localae.ard = paramInt1;
                locali.a(localae);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  @Deprecated
  protected ae f(RecyclerView.i parami)
  {
    if (!(parami instanceof RecyclerView.r.b)) {
      return null;
    }
    new ae(this.akA.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(126675);
        if (f.this.akA == null)
        {
          AppMethodBeat.o(126675);
          return;
        }
        paramAnonymousView = f.this.a(f.this.akA.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cd(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.SS);
        }
        AppMethodBeat.o(126675);
      }
    };
  }
  
  public final void j(RecyclerView paramRecyclerView)
  {
    if (this.akA == paramRecyclerView) {}
    do
    {
      return;
      if (this.akA != null)
      {
        this.akA.b(this.apU);
        this.akA.setOnFlingListener(null);
      }
      this.akA = paramRecyclerView;
    } while (this.akA == null);
    if (this.akA.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.akA.a(this.apU);
    this.akA.setOnFlingListener(this);
    this.atY = new Scroller(this.akA.getContext(), new DecelerateInterpolator());
    lU();
  }
  
  final void lU()
  {
    if (this.akA == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.akA.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.i)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.i)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.akA.a(localObject[0], localObject[1], null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */