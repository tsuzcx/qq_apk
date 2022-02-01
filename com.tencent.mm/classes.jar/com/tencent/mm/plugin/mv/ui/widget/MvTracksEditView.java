package com.tencent.mm.plugin.mv.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ii;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.j;
import com.tencent.mm.plugin.mv.model.m;
import com.tencent.mm.plugin.mv.ui.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$Provider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_tracks", "", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "callback", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;)V", "debug", "Landroid/widget/TextView;", "draggingIndex", "", "getDraggingIndex", "()I", "setDraggingIndex", "(I)V", "fillingDuration", "", "getFillingDuration", "()J", "fillingWidth", "getFillingWidth", "indicator", "Landroidx/appcompat/widget/AppCompatImageView;", "isEditing", "", "()Z", "isScaling", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scaleStartProgress", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "songDuration", "spaceSize", "getSpaceSize", "thumbHeight", "thumbLoader", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "getThumbLoader", "()Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "setThumbLoader", "(Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;)V", "thumbWidth", "timeDecoration", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeSpanDecoration;", "timeHelper", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;", "touchSlop", "touchX", "", "touchY", "trackProgress", "tracks", "getTracks", "()Ljava/util/List;", "tracksAdapter", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter;", "tracksDuration", "transitionDecoration", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration;", "value", "videoProgress", "getVideoProgress", "setVideoProgress", "(J)V", "widthPerMills", "getWidthPerMills", "()F", "dp", "getDp", "(I)I", "computeProgress", "computeTracksDuration", "", "dimen", "isDragging", "isSelecting", "setTransitionStatus", "index", "enabled", "startSelecting", "stopSelecting", "update", "startTime", "endTime", "needRefresh", "updateFrames", "updateScale", "scale", "Callback", "Companion", "DraggingCallback", "plugin-mv_release"})
public final class MvTracksEditView
  extends FrameLayout
  implements c.d
{
  public static final MvTracksEditView.b Grd;
  private final LinearLayoutManager Arh;
  public long Ggg;
  private g Ggi;
  public final a GqA;
  private TextView GqI;
  public final AppCompatImageView GqQ;
  public final c GqR;
  private int GqS;
  public List<? extends com.tencent.mm.plugin.vlog.ui.thumb.a> GqT;
  private final int GqU;
  private boolean GqV;
  public final b GqW;
  public final d GqX;
  public long GqY;
  private a GqZ;
  private long Gra;
  private long Grb;
  private long Grc;
  private int bhr;
  private int bvH;
  private float jLa;
  private float jLb;
  public final RecyclerView jLl;
  private int thumbHeight;
  public int thumbWidth;
  private final androidx.recyclerview.widget.l zlR;
  
  static
  {
    AppMethodBeat.i(231065);
    Grd = new MvTracksEditView.b((byte)0);
    AppMethodBeat.o(231065);
  }
  
  public MvTracksEditView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(231062);
    this.bhr = -1;
    this.GqS = -1;
    this.GqT = ((List)v.aaAd);
    this.GqU = com.tencent.mm.ci.a.fromDPToPix(paramContext, 4);
    this.GqA = new a();
    this.GqW = new b(paramContext);
    this.GqX = new d(paramContext);
    this.zlR = new androidx.recyclerview.widget.l((l.a)new c());
    Object localObject = ViewConfiguration.get(paramContext);
    p.j(localObject, "ViewConfiguration.get(context)");
    this.bvH = ((ViewConfiguration)localObject).getScaledTouchSlop();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.j.eWV);
    localObject = paramAttributeSet.getDrawable(b.j.Gad);
    this.thumbWidth = paramAttributeSet.getDimensionPixelSize(b.j.Gaf, fim());
    this.thumbHeight = paramAttributeSet.getDimensionPixelSize(b.j.Gae, fim());
    paramAttributeSet.recycle();
    int i = aaa(b.c.Edge_2A);
    i = (int)this.GqW.Gqv + i;
    this.GqQ = new AppCompatImageView(paramContext);
    this.GqQ.setImageDrawable((Drawable)localObject);
    this.GqQ.setVisibility(4);
    this.GqQ.setElevation(aaa(b.c.Edge_0_5_A));
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2, 1);
    paramAttributeSet.topMargin = i;
    addView((View)this.GqQ, (ViewGroup.LayoutParams)paramAttributeSet);
    this.jLl = new RecyclerView(paramContext);
    this.GqR = new c((c.a)new c.a()
    {
      public final void ZX(int paramAnonymousInt)
      {
        AppMethodBeat.i(229822);
        long l = ((com.tencent.mm.plugin.vlog.ui.thumb.a)this.Gre.getTracks().get(paramAnonymousInt)).getTotalDuration();
        if (l < 2000L)
        {
          Log.w("MicroMsg.MvTracksEditView", "video's duration is too short: index=" + paramAnonymousInt + ", duration=" + l);
          AppMethodBeat.o(229822);
          return;
        }
        MvTracksEditView.a(this.Gre, paramAnonymousInt);
        AppMethodBeat.o(229822);
      }
      
      public final void aF(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(229832);
        Log.i("MicroMsg.MvTracksEditView", "onTrackEndChanged: index=" + paramAnonymousInt + ", time=" + paramAnonymousLong);
        MvTracksEditView.a locala = this.Gre.getCallback();
        if (locala != null)
        {
          locala.aF(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(229832);
          return;
        }
        AppMethodBeat.o(229832);
      }
      
      public final void aG(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(229830);
        Log.i("MicroMsg.MvTracksEditView", "onTrackStartChanged: index=" + paramAnonymousInt + ", time=" + paramAnonymousLong);
        MvTracksEditView.a locala = this.Gre.getCallback();
        if (locala != null)
        {
          locala.aG(paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(229830);
          return;
        }
        AppMethodBeat.o(229830);
      }
      
      public final void s(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(229826);
        Log.i("MicroMsg.MvTracksEditView", "onSlidingStarted: index=" + paramAnonymousInt + ", startTime=" + paramAnonymousLong1 + ", endTime=" + paramAnonymousLong2);
        MvTracksEditView.a locala = this.Gre.getCallback();
        if (locala != null)
        {
          locala.s(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
          AppMethodBeat.o(229826);
          return;
        }
        AppMethodBeat.o(229826);
      }
      
      public final void t(final int paramAnonymousInt, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(229828);
        Log.i("MicroMsg.MvTracksEditView", "onSlidingStopped: index=" + paramAnonymousInt + ", startTime=" + paramAnonymousLong1 + ", endTime=" + paramAnonymousLong2);
        this.Gre.post((Runnable)new a(this, paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2));
        MvTracksEditView.a locala = this.Gre.getCallback();
        if (locala != null)
        {
          locala.t(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
          AppMethodBeat.o(229828);
          return;
        }
        AppMethodBeat.o(229828);
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(MvTracksEditView.1 param1, int paramInt, long paramLong1, long paramLong2) {}
        
        public final void run()
        {
          AppMethodBeat.i(233749);
          this.Grf.Gre.u(paramAnonymousInt, paramAnonymousLong1, this.Grg);
          AppMethodBeat.o(233749);
        }
      }
    }, (c.d)this);
    this.jLl.setAdapter((RecyclerView.a)this.GqR);
    this.jLl.setItemAnimator(null);
    this.jLl.setPadding(0, i, 0, 0);
    addView((View)this.jLl, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, i + aaa(b.c.Edge_6A), 16));
    this.GqW.GqA = this.GqA;
    this.jLl.b((RecyclerView.h)this.GqW);
    this.zlR.a(this.jLl);
    this.jLl.b((RecyclerView.h)new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(225387);
        p.k(paramAnonymousRect, "outRect");
        p.k(paramAnonymousView, "view");
        p.k(paramAnonymousRecyclerView, "parent");
        p.k(paramAnonymouss, "state");
        int i = RecyclerView.bh(paramAnonymousView);
        MvTracksEditView.g(this.Gre);
        i = c.ZV(i);
        int j = ((Collection)this.Gre.getTracks()).size();
        if (i >= 0)
        {
          if (j <= i) {
            AppMethodBeat.o(225387);
          }
        }
        else
        {
          AppMethodBeat.o(225387);
          return;
        }
        if ((i < this.Gre.getTracks().size() - 1) || (this.Gre.getFillingWidth() > 0)) {
          paramAnonymousRect.set(0, 0, this.Gre.getSpaceSize(), 0);
        }
        AppMethodBeat.o(225387);
      }
    });
    this.jLl.b((RecyclerView.h)this.GqX);
    this.jLl.setClipToPadding(false);
    this.jLl.setClipChildren(false);
    setClipToPadding(false);
    setClipChildren(false);
    paramContext = new e(paramContext, (e.a)new d(this));
    this.jLl.a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(226286);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        p.k(paramAnonymousRecyclerView, "recyclerView");
        Log.i("MicroMsg.MvTracksEditView", "onScrollStateChanged: newState=".concat(String.valueOf(paramAnonymousInt)));
        if ((paramAnonymousInt == 0) && (!MvTracksEditView.m(this.Gre)))
        {
          this.Gre.setVideoProgress(MvTracksEditView.l(this.Gre));
          Log.d("MicroMsg.MvTracksEditView", "scrolling stopped, progress=" + this.Gre.getVideoProgress());
          paramAnonymousRecyclerView = this.Gre.getCallback();
          if (paramAnonymousRecyclerView != null) {
            paramAnonymousRecyclerView.OM(this.Gre.getVideoProgress());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(226286);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(226282);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        p.k(paramAnonymousRecyclerView, "recyclerView");
        MvTracksEditView.k(this.Gre);
        MvTracksEditView.h(this.Gre).Gqz = MvTracksEditView.l(this.Gre);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(226282);
      }
    });
    this.jLl.a((RecyclerView.k)new RecyclerView.k()
    {
      private float Grh;
      private float Gri;
      private int Grj = 200;
      private long lastClickTime;
      
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(230830);
        p.k(paramAnonymousRecyclerView, "recyclerView");
        p.k(paramAnonymousMotionEvent, "event");
        MvTracksEditView.a(this.Gre, paramAnonymousMotionEvent.getX());
        MvTracksEditView.c(this.Gre, paramAnonymousMotionEvent.getY());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        long l;
        do
        {
          for (bool = false; (!bool) && (!this.Gre.fii()) && (!this.Gre.fih()); bool = false)
          {
            paramContext.onTouchEvent(paramAnonymousMotionEvent);
            if (!MvTracksEditView.j(this.Gre)) {
              break;
            }
            AppMethodBeat.o(230830);
            return true;
            paramAnonymousRecyclerView.ld();
            this.lastClickTime = System.currentTimeMillis();
            this.Grh = MvTracksEditView.a(this.Gre);
            this.Gri = MvTracksEditView.n(this.Gre);
          }
          l = System.currentTimeMillis();
        } while ((l - this.lastClickTime >= this.Grj) || (Math.abs(MvTracksEditView.a(this.Gre) - this.Grh) >= MvTracksEditView.o(this.Gre)) || (Math.abs(MvTracksEditView.n(this.Gre) - this.Gri) >= MvTracksEditView.o(this.Gre)));
        paramAnonymousRecyclerView = MvTracksEditView.e(this.Gre);
        float f1 = MvTracksEditView.a(this.Gre);
        label271:
        Object localObject;
        if ((!paramAnonymousRecyclerView.Grv) || (!d.isAvailable()))
        {
          paramAnonymousRecyclerView = null;
          if (paramAnonymousRecyclerView == null) {
            break label432;
          }
          localObject = this.Gre.getCallback();
          if (localObject != null) {
            ((MvTracksEditView.a)localObject).ZL(paramAnonymousRecyclerView.intValue());
          }
        }
        label410:
        label419:
        label432:
        for (boolean bool = true;; bool = false)
        {
          this.lastClickTime = l;
          break;
          int k = paramAnonymousRecyclerView.offset;
          int i = 0;
          for (;;)
          {
            if (i >= k) {
              break label419;
            }
            localObject = (d.a)paramAnonymousRecyclerView.Gro.get(i);
            float f2 = ((d.a)localObject).left;
            float f3 = ((d.a)localObject).right;
            if ((f1 >= f2) && (f1 <= f3)) {}
            for (int j = 1;; j = 0)
            {
              if (j == 0) {
                break label410;
              }
              paramAnonymousRecyclerView = Integer.valueOf(((d.a)paramAnonymousRecyclerView.Gro.get(i)).index);
              break;
            }
            i += 1;
          }
          paramAnonymousRecyclerView = null;
          break label271;
          AppMethodBeat.o(230830);
          return bool;
        }
      }
      
      public final void ao(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(230829);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$5", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aFi());
        p.k(paramAnonymousRecyclerView, "recyclerView");
        p.k(paramAnonymousMotionEvent, "event");
        if (MvTracksEditView.j(this.Gre)) {
          paramContext.onTouchEvent(paramAnonymousMotionEvent);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$5", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(230829);
      }
    });
    this.Arh = new LinearLayoutManager(0, false);
    this.jLl.setLayoutManager((RecyclerView.LayoutManager)this.Arh);
    AppMethodBeat.o(231062);
  }
  
  private final int aaa(int paramInt)
  {
    AppMethodBeat.i(231056);
    paramInt = getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(231056);
    return paramInt;
  }
  
  private final boolean fig()
  {
    AppMethodBeat.i(231029);
    if ((this.GqV) || (fih()) || (fii()))
    {
      AppMethodBeat.o(231029);
      return true;
    }
    AppMethodBeat.o(231029);
    return false;
  }
  
  private final long fil()
  {
    long l2 = 0L;
    AppMethodBeat.i(231054);
    if (this.jLl.getChildCount() == 0)
    {
      AppMethodBeat.o(231054);
      return 0L;
    }
    View localView1 = null;
    int j = 0;
    int m = this.jLl.getChildCount();
    View localView2;
    int k;
    for (int i = -1;; i = k)
    {
      localView2 = localView1;
      if (j >= m) {
        break;
      }
      localView1 = this.jLl.getChildAt(j);
      k = RecyclerView.bh(localView1);
      i = k;
      localView2 = localView1;
      if (k != -1) {
        break;
      }
      j += 1;
    }
    if ((localView2 == null) || (i == -1))
    {
      Log.i("MicroMsg.MvTracksEditView", "computeProgress: not find view position");
      l1 = this.Gra;
      AppMethodBeat.o(231054);
      return l1;
    }
    j = this.Arh.getItemViewType(localView2);
    float f = -localView2.getLeft() / getWidthPerMills();
    long l1 = l2;
    switch (j)
    {
    default: 
      l1 = l2;
    }
    for (;;)
    {
      this.Gra = (((float)l1 + f));
      l1 = this.Gra;
      AppMethodBeat.o(231054);
      return l1;
      l1 = this.GqY + (getWidth() / 2.0D / getWidthPerMills());
      continue;
      j = c.ZV(i);
      k = ((Collection)getTracks()).size();
      if (j < 0) {}
      while (k <= j)
      {
        Log.i("MicroMsg.MvTracksEditView", "not find view " + i + ' ' + j);
        l1 = this.Gra;
        AppMethodBeat.o(231054);
        return l1;
      }
      l1 = ((com.tencent.mm.plugin.vlog.ui.thumb.a)getTracks().get(j)).NCo + (getWidth() / 2.0D / getWidthPerMills());
    }
  }
  
  private final int fim()
  {
    AppMethodBeat.i(231058);
    Resources localResources = getResources();
    p.j(localResources, "resources");
    int i = (int)(localResources.getDisplayMetrics().density * 48.0F);
    AppMethodBeat.o(231058);
    return i;
  }
  
  public final void aP(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(231055);
    Log.i("MicroMsg.MvTracksEditView", "setTransitionStatus: index=" + paramInt + ", enabled=" + paramBoolean);
    if ((paramBoolean) && (!this.GqX.Gru.contains(Integer.valueOf(paramInt))))
    {
      this.GqX.Gru.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(231055);
      return;
    }
    if (!paramBoolean) {
      this.GqX.Gru.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(231055);
  }
  
  public final boolean fih()
  {
    AppMethodBeat.i(231035);
    if (getDraggingIndex() != -1)
    {
      AppMethodBeat.o(231035);
      return true;
    }
    AppMethodBeat.o(231035);
    return false;
  }
  
  public final boolean fii()
  {
    AppMethodBeat.i(231036);
    if (getSelectedIndex() != -1)
    {
      AppMethodBeat.o(231036);
      return true;
    }
    AppMethodBeat.o(231036);
    return false;
  }
  
  public final void fij()
  {
    AppMethodBeat.i(231047);
    Iterator localIterator = ((Iterable)this.GqT).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (com.tencent.mm.plugin.vlog.ui.thumb.a)localIterator.next();
      float f = ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).getPlayRate() * (((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).width / getWidthPerMills());
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).NCl = ((float)((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).getTotalDuration() / f);
      int i = kotlin.h.a.dm((float)Math.ceil((float)((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).getTotalDuration() / ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).getPlayRate() / (((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).width / getWidthPerMills())));
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).NCm.clear();
      localObject1 = ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).NCm;
      Object localObject2 = (Iterable)i.ou(0, i);
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((ab)localObject2).zD();
        com.tencent.mm.plugin.vlog.ui.thumb.e locale = new com.tencent.mm.plugin.vlog.ui.thumb.e();
        locale.GhA = ((i * f));
        localCollection.add(locale);
      }
      ((LinkedList)localObject1).addAll((Collection)localCollection);
    }
    AppMethodBeat.o(231047);
  }
  
  public final void fik()
  {
    AppMethodBeat.i(231051);
    Object localObject = ((Iterable)this.GqT).iterator();
    long l2 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.vlog.ui.thumb.a locala = (com.tencent.mm.plugin.vlog.ui.thumb.a)((Iterator)localObject).next();
      locala.NCo = l2;
      long l1;
      if (locala.gwv() + l2 < this.Ggg)
      {
        l1 = locala.gwv();
        l2 += l1;
      }
      else
      {
        long l3 = this.Ggg - l2;
        long l4 = locala.gwv();
        if (0L > l4)
        {
          localObject = (Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + l4 + " is less than minimum 0.");
          AppMethodBeat.o(231051);
          throw ((Throwable)localObject);
        }
        if (l3 < 0L) {
          l1 = 0L;
        }
        for (;;)
        {
          locala.NCk = (locala.NCj + l1);
          break;
          l1 = l4;
          if (l3 <= l4) {
            l1 = l3;
          }
        }
      }
    }
    this.GqY = l2;
    localObject = this.GqX;
    if (this.GqY < this.Ggg) {}
    for (boolean bool = true;; bool = false)
    {
      ((d)localObject).Grw = bool;
      Log.i("MicroMsg.MvTracksEditView", "computeTracksDuration: " + this.GqY + ", timeHelper:" + this.GqA.Gqo + ", " + this.GqA.Gqp);
      AppMethodBeat.o(231051);
      return;
    }
  }
  
  public final a getCallback()
  {
    return this.GqZ;
  }
  
  public final int getDraggingIndex()
  {
    return this.GqS;
  }
  
  public final long getFillingDuration()
  {
    AppMethodBeat.i(231024);
    long l = Math.max(this.Ggg - this.GqY, 0L);
    AppMethodBeat.o(231024);
    return l;
  }
  
  public final int getFillingWidth()
  {
    AppMethodBeat.i(231026);
    int i = Math.max((int)((float)getFillingDuration() * getWidthPerMills()), 0);
    AppMethodBeat.o(231026);
    return i;
  }
  
  public final int getSelectedIndex()
  {
    return this.bhr;
  }
  
  public final int getSpaceSize()
  {
    return this.GqU;
  }
  
  public final g getThumbLoader()
  {
    return this.Ggi;
  }
  
  public final List<com.tencent.mm.plugin.vlog.ui.thumb.a> getTracks()
  {
    return this.GqT;
  }
  
  public final long getVideoProgress()
  {
    return this.Grc;
  }
  
  public final float getWidthPerMills()
  {
    return this.GqA.Gqp;
  }
  
  public final void setCallback(a parama)
  {
    this.GqZ = parama;
  }
  
  public final void setDraggingIndex(int paramInt)
  {
    this.GqS = paramInt;
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.bhr = paramInt;
  }
  
  public final void setThumbLoader(g paramg)
  {
    this.Ggi = paramg;
  }
  
  public final void setVideoProgress(long paramLong)
  {
    AppMethodBeat.i(231032);
    this.Grc = paramLong;
    Object localObject;
    if ((this.jLl.getScrollState() == 0) && (!fig()))
    {
      float f1 = (float)(paramLong - fil());
      float f2 = getWidthPerMills();
      localObject = this.GqI;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(paramLong));
      }
      this.jLl.scrollBy((int)(f2 * f1), 0);
      this.GqW.Gqz = paramLong;
    }
    if (fii())
    {
      localObject = this.GqR.GqB;
      if (localObject != null)
      {
        ((kotlin.g.a.b)localObject).invoke(Long.valueOf(this.Grc));
        AppMethodBeat.o(231032);
        return;
      }
    }
    AppMethodBeat.o(231032);
  }
  
  public final void u(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(231040);
    Log.i("MicroMsg.MvTracksEditView", "updateTrack: index=" + paramInt + ", startTime=" + paramLong1 + ", endTime=" + paramLong2);
    com.tencent.mm.plugin.vlog.ui.thumb.a locala = (com.tencent.mm.plugin.vlog.ui.thumb.a)getTracks().get(paramInt);
    locala.NCj = paramLong1;
    locala.NCk = paramLong2;
    fik();
    this.jLl.lF();
    this.GqR.cL(c.ZW(paramInt));
    AppMethodBeat.o(231040);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;", "", "onChooseTransition", "", "index", "", "onDragEnded", "onDragStarted", "onMove", "moveList", "", "Lkotlin/Pair;", "onSeek", "target", "", "onSelectStarted", "startTime", "endTime", "onTrackEndChanged", "time", "onTrackSlidingStarted", "onTrackSlidingStopped", "onTrackStartChanged", "plugin-mv_release"})
  public static abstract interface a
  {
    public abstract void OM(long paramLong);
    
    public abstract void ZL(int paramInt);
    
    public abstract void ZM(int paramInt);
    
    public abstract void aF(int paramInt, long paramLong);
    
    public abstract void aG(int paramInt, long paramLong);
    
    public abstract void fgF();
    
    public abstract void gh(List<o<Integer, Integer>> paramList);
    
    public abstract void r(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void s(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void t(int paramInt, long paramLong1, long paramLong2);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$DraggingCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView;)V", "diffX", "", "moveList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onChildDraw", "", "c", "Landroid/graphics/Canvas;", "dX", "", "dY", "actionState", "isCurrentlyActive", "", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-mv_release"})
  final class c
    extends l.a
  {
    private int Grl;
    private final LinkedList<o<Integer, Integer>> Grm;
    
    public c()
    {
      AppMethodBeat.i(234393);
      this.Grm = new LinkedList();
      AppMethodBeat.o(234393);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(234389);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      if ((this.Gre.fii()) || (paramRecyclerView.getScrollState() != 0) || (!(paramv instanceof c.f)))
      {
        AppMethodBeat.o(234389);
        return 0;
      }
      int i = l.a.cA(15);
      AppMethodBeat.o(234389);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(234392);
      p.k(paramCanvas, "c");
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      if (paramInt == 2)
      {
        super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 - this.Grl, paramFloat2, paramInt, paramBoolean);
        AppMethodBeat.o(234392);
        return;
      }
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1, paramFloat2, paramInt, paramBoolean);
      AppMethodBeat.o(234392);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(234390);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv1, "viewHolder");
      p.k(paramv2, "target");
      if ((!(paramv1 instanceof c.f)) || (!(paramv2 instanceof c.f)))
      {
        AppMethodBeat.o(234390);
        return false;
      }
      int i = c.ZV(((c.f)paramv1).md());
      int j = c.ZV(((c.f)paramv2).md());
      Log.i("MicroMsg.MvTracksEditView", "move " + i + " => " + j);
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)this.Gre.getTracks().get(i)).trackIndex = j;
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)this.Gre.getTracks().get(j)).trackIndex = i;
      Collections.swap(this.Gre.getTracks(), i, j);
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView != null) {
        paramRecyclerView.aF(((c.f)paramv1).md(), ((c.f)paramv2).md());
      }
      this.Grm.add(new o(Integer.valueOf(i), Integer.valueOf(j)));
      AppMethodBeat.o(234390);
      return true;
    }
    
    public final void b(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(234388);
      super.b(paramv, paramInt);
      Log.d("MicroMsg.MvTracksEditView", "onSelectedChanged, viewHolder:" + paramv + ", actionState:" + paramInt);
      if (paramv != null)
      {
        if (!(paramv instanceof c.f))
        {
          paramv = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(234388);
          throw paramv;
        }
        paramInt = (int)MvTracksEditView.a(this.Gre);
        int i = MvTracksEditView.b(this.Gre) / 2;
        Object localObject = paramv.amk;
        p.j(localObject, "viewHolder.itemView");
        this.Grl = (((View)localObject).getLeft() - (int)MvTracksEditView.a(this.Gre) + MvTracksEditView.b(this.Gre) / 2);
        MvTracksEditView.c(this.Gre).au(((c.f)paramv).md(), paramInt - i);
        MvTracksEditView.d(this.Gre).setVisibility(4);
        MvTracksEditView.e(this.Gre).Grv = false;
        MvTracksEditView.f(this.Gre).lF();
        Log.i("MicroMsg.MvTracksEditView", "startDragging: " + c.ZV(((c.f)paramv).md()));
        MvTracksEditView.g(this.Gre).aE(0, MvTracksEditView.g(this.Gre).getItemCount());
        this.Gre.setDraggingIndex(c.ZV(((c.f)paramv).md()));
        MvTracksEditView.f(this.Gre).c((RecyclerView.h)MvTracksEditView.h(this.Gre));
        localObject = this.Gre.getCallback();
        if (localObject != null)
        {
          ((MvTracksEditView.a)localObject).ZM(c.ZV(((c.f)paramv).md()));
          AppMethodBeat.o(234388);
          return;
        }
        AppMethodBeat.o(234388);
        return;
      }
      if (paramInt == 0)
      {
        this.Grl = 0;
        MvTracksEditView.e(this.Gre).Grv = true;
        MvTracksEditView.d(this.Gre).setVisibility(0);
        this.Gre.post((Runnable)new a(this));
        this.Gre.setDraggingIndex(-1);
        paramv = this.Gre.getCallback();
        if (paramv != null) {
          paramv.gh((List)this.Grm);
        }
        MvTracksEditView.f(this.Gre).b((RecyclerView.h)MvTracksEditView.h(this.Gre));
        paramv = this.Gre.getCallback();
        if (paramv != null) {
          paramv.fgF();
        }
        this.Grm.clear();
        MvTracksEditView.i(this.Gre);
        paramv = m.GcA;
        paramv = m.fgi();
        paramv.sP(18L);
        paramv.alR();
        paramv.bpa();
      }
      AppMethodBeat.o(234388);
    }
    
    public final void g(RecyclerView.v paramv)
    {
      AppMethodBeat.i(234391);
      p.k(paramv, "viewHolder");
      AppMethodBeat.o(234391);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MvTracksEditView.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(229120);
        MvTracksEditView.f(this.Grn.Gre).lF();
        Log.i("MicroMsg.MvTracksEditView", "stopDragging: " + this.Grn.Gre.getDraggingIndex());
        MvTracksEditView.g(this.Grn.Gre).aE(0, MvTracksEditView.g(this.Grn.Gre).getItemCount());
        AppMethodBeat.o(229120);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$scaleListener$1", "Lcom/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$OnScaleGestureListener;", "onScale", "", "detector", "Lcom/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-mv_release"})
  public static final class d
    implements e.a
  {
    public final boolean a(e parame)
    {
      AppMethodBeat.i(227633);
      p.k(parame, "detector");
      MvTracksEditView.a(this.Gre, true);
      MvTracksEditView.k(this.Gre);
      MvTracksEditView.a(this.Gre, MvTracksEditView.l(this.Gre));
      AppMethodBeat.o(227633);
      return true;
    }
    
    public final void b(e parame)
    {
      AppMethodBeat.i(227636);
      p.k(parame, "detector");
      MvTracksEditView.a(this.Gre, false);
      parame = m.GcA;
      parame = m.fgi();
      parame.sP(17L);
      parame.alR();
      parame.bpa();
      AppMethodBeat.o(227636);
    }
    
    public final boolean c(e parame)
    {
      AppMethodBeat.i(227638);
      p.k(parame, "detector");
      MvTracksEditView.b(this.Gre, parame.fiq());
      AppMethodBeat.o(227638);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView
 * JD-Core Version:    0.7.0.1
 */