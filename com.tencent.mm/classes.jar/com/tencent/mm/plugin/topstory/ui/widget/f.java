package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s.a;
import android.support.v7.widget.RecyclerView.s.b;
import android.support.v7.widget.RecyclerView.t;
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
  public RecyclerView anl;
  private final RecyclerView.m asH = new RecyclerView.m()
  {
    boolean awM = false;
    
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(220252);
      b localb = new b();
      localb.bd(paramAnonymousRecyclerView);
      localb.mu(paramAnonymousInt1);
      localb.mu(paramAnonymousInt2);
      a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        this.awM = true;
      }
      a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(220252);
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(126674);
      b localb = new b();
      localb.bd(paramAnonymousRecyclerView);
      localb.mu(paramAnonymousInt);
      a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (this.awM))
      {
        this.awM = false;
        f.this.mv();
      }
      a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(126674);
    }
  };
  protected Scroller awL;
  
  public abstract int a(RecyclerView.i parami, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.i parami);
  
  public abstract int[] a(RecyclerView.i parami, View paramView);
  
  public final boolean aB(int paramInt1, int paramInt2)
  {
    RecyclerView.i locali = this.anl.getLayoutManager();
    if (locali == null) {}
    for (;;)
    {
      return false;
      if (this.anl.getAdapter() != null)
      {
        int i = this.anl.getMinFlingVelocity();
        if ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i))
        {
          if (!(locali instanceof RecyclerView.s.b)) {
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
                localae.atQ = paramInt1;
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
    if (!(parami instanceof RecyclerView.s.b)) {
      return null;
    }
    new ae(this.anl.getContext())
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.t paramAnonymoust, RecyclerView.s.a paramAnonymousa)
      {
        AppMethodBeat.i(126675);
        if (f.this.anl == null)
        {
          AppMethodBeat.o(126675);
          return;
        }
        paramAnonymousView = f.this.a(f.this.anl.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cd(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.VD);
        }
        AppMethodBeat.o(126675);
      }
    };
  }
  
  public final void j(RecyclerView paramRecyclerView)
  {
    if (this.anl == paramRecyclerView) {}
    do
    {
      return;
      if (this.anl != null)
      {
        this.anl.b(this.asH);
        this.anl.setOnFlingListener(null);
      }
      this.anl = paramRecyclerView;
    } while (this.anl == null);
    if (this.anl.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.anl.a(this.asH);
    this.anl.setOnFlingListener(this);
    this.awL = new Scroller(this.anl.getContext(), new DecelerateInterpolator());
    mv();
  }
  
  final void mv()
  {
    if (this.anl == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.anl.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.i)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.i)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.anl.a(localObject[0], localObject[1], null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */