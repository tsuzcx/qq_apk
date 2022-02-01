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
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kp;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.j;
import com.tencent.mm.plugin.mv.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.ah;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$Provider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_tracks", "", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "callback", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;)V", "debug", "Landroid/widget/TextView;", "dragToDeleteTrackIndex", "", "draggingIndex", "getDraggingIndex", "()I", "setDraggingIndex", "(I)V", "fillingDuration", "", "getFillingDuration", "()J", "fillingWidth", "getFillingWidth", "indicator", "Landroidx/appcompat/widget/AppCompatImageView;", "isEditing", "", "()Z", "isScaling", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scaleStartProgress", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "songDuration", "spaceSize", "getSpaceSize", "thumbHeight", "thumbLoader", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "getThumbLoader", "()Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "setThumbLoader", "(Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;)V", "thumbWidth", "timeDecoration", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeSpanDecoration;", "timeHelper", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;", "touchRawY", "", "touchSlop", "touchX", "touchY", "trackProgress", "tracks", "getTracks", "()Ljava/util/List;", "tracksAdapter", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter;", "tracksDuration", "transitionDecoration", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration;", "value", "videoProgress", "getVideoProgress", "setVideoProgress", "(J)V", "widthPerMills", "getWidthPerMills", "()F", "dp", "getDp", "(I)I", "changeTrackOrder", "", "fromPosition", "toPosition", "computeProgress", "computeTracksDuration", "deleteToUpdate", "dimen", "isDragging", "isSelecting", "setTransitionStatus", "index", "enabled", "startSelecting", "stopSelecting", "update", "startTime", "endTime", "needRefresh", "updateFrames", "updateScale", "scale", "Callback", "Companion", "DeleteDragType", "DraggingCallback", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MvTracksEditView
  extends FrameLayout
  implements c.d
{
  public static final MvTracksEditView.b MkS;
  private final LinearLayoutManager AJH;
  private final androidx.recyclerview.widget.k Emo;
  public long Mbr;
  private com.tencent.mm.plugin.mv.ui.c.b Mbx;
  public final a MkC;
  private TextView MkK;
  public final AppCompatImageView MkT;
  public final c MkU;
  private int MkV;
  public List<? extends com.tencent.mm.plugin.vlog.ui.thumb.a> MkW;
  private final int MkX;
  private float MkY;
  private boolean MkZ;
  public final b Mla;
  public final d Mlb;
  public long Mlc;
  private a Mld;
  private long Mle;
  private long Mlf;
  private int Mlg;
  private long Mlh;
  private int dbk;
  private int doK;
  private float mkm;
  private float mkn;
  public final RecyclerView mkw;
  private int thumbHeight;
  public int thumbWidth;
  
  static
  {
    AppMethodBeat.i(286903);
    MkS = new MvTracksEditView.b((byte)0);
    AppMethodBeat.o(286903);
  }
  
  public MvTracksEditView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286715);
    this.dbk = -1;
    this.MkV = -1;
    this.MkW = ((List)ab.aivy);
    this.MkX = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    this.MkC = new a();
    this.Mla = new b(paramContext);
    this.Mlb = new d(paramContext);
    this.Emo = new androidx.recyclerview.widget.k((k.a)new d());
    this.doK = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.Mlg = -1;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.j.hay);
    s.s(paramAttributeSet, "context.obtainStyledAttr…yleable.MvTracksEditView)");
    Drawable localDrawable = paramAttributeSet.getDrawable(b.j.LWk);
    this.thumbWidth = paramAttributeSet.getDimensionPixelSize(b.j.LWm, gsp());
    this.thumbHeight = paramAttributeSet.getDimensionPixelSize(b.j.LWl, gsp());
    paramAttributeSet.recycle();
    int i = aet(b.c.Edge_2A);
    i = (int)this.Mla.Mkx + i;
    this.MkT = new AppCompatImageView(paramContext);
    this.MkT.setImageDrawable(localDrawable);
    this.MkT.setVisibility(4);
    this.MkT.setElevation(aet(b.c.Edge_0_5_A));
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2, 1);
    paramAttributeSet.topMargin = i;
    addView((View)this.MkT, (ViewGroup.LayoutParams)paramAttributeSet);
    this.mkw = new RecyclerView(paramContext);
    this.MkU = new c((c.a)new c.a()
    {
      private static final void b(MvTracksEditView paramAnonymousMvTracksEditView, int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(286606);
        s.u(paramAnonymousMvTracksEditView, "this$0");
        paramAnonymousMvTracksEditView.t(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(286606);
      }
      
      public final void aM(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(286650);
        Log.i("MicroMsg.MvTracksEditView", "onTrackEndChanged: index=" + paramAnonymousInt + ", time=" + paramAnonymousLong);
        MvTracksEditView.a locala = this.Mli.getCallback();
        if (locala != null) {
          locala.aM(paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(286650);
      }
      
      public final void aN(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(286647);
        Log.i("MicroMsg.MvTracksEditView", "onTrackStartChanged: index=" + paramAnonymousInt + ", time=" + paramAnonymousLong);
        MvTracksEditView.a locala = this.Mli.getCallback();
        if (locala != null) {
          locala.aN(paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(286647);
      }
      
      public final void aeq(int paramAnonymousInt)
      {
        AppMethodBeat.i(286625);
        long l = ((com.tencent.mm.plugin.vlog.ui.thumb.a)this.Mli.getTracks().get(paramAnonymousInt)).getTotalDuration();
        if (l < 2000L)
        {
          Log.w("MicroMsg.MvTracksEditView", "video's duration is too short: index=" + paramAnonymousInt + ", duration=" + l);
          AppMethodBeat.o(286625);
          return;
        }
        MvTracksEditView.b(this.Mli, paramAnonymousInt);
        AppMethodBeat.o(286625);
      }
      
      public final void r(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(286633);
        Log.i("MicroMsg.MvTracksEditView", "onSlidingStarted: index=" + paramAnonymousInt + ", startTime=" + paramAnonymousLong1 + ", endTime=" + paramAnonymousLong2);
        MvTracksEditView.a locala = this.Mli.getCallback();
        if (locala != null) {
          locala.r(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(286633);
      }
      
      public final void s(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(286643);
        Log.i("MicroMsg.MvTracksEditView", "onSlidingStopped: index=" + paramAnonymousInt + ", startTime=" + paramAnonymousLong1 + ", endTime=" + paramAnonymousLong2);
        this.Mli.post(new MvTracksEditView.1..ExternalSyntheticLambda0(this.Mli, paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2));
        MvTracksEditView.a locala = this.Mli.getCallback();
        if (locala != null) {
          locala.s(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(286643);
      }
    }, (c.d)this);
    this.mkw.setAdapter((RecyclerView.a)this.MkU);
    this.mkw.setItemAnimator(null);
    this.mkw.setPadding(0, i, 0, 0);
    addView((View)this.mkw, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, i + aet(b.c.Edge_6A), 16));
    this.Mla.MkC = this.MkC;
    this.mkw.a((RecyclerView.h)this.Mla);
    this.Emo.a(this.mkw);
    this.mkw.a((RecyclerView.h)new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(286613);
        s.u(paramAnonymousRect, "outRect");
        s.u(paramAnonymousView, "view");
        s.u(paramAnonymousRecyclerView, "parent");
        s.u(paramAnonymouss, "state");
        int i = RecyclerView.bA(paramAnonymousView);
        MvTracksEditView.g(this.Mli);
        int j = c.aeo(i);
        if (j >= 0) {
          if (j <= this.Mli.getTracks().size() - 1) {
            i = 1;
          }
        }
        while (i == 0)
        {
          AppMethodBeat.o(286613);
          return;
          i = 0;
          continue;
          i = 0;
        }
        if ((j < this.Mli.getTracks().size() - 1) || (this.Mli.getFillingWidth() > 0)) {
          paramAnonymousRect.set(0, 0, this.Mli.getSpaceSize(), 0);
        }
        AppMethodBeat.o(286613);
      }
    });
    this.mkw.a((RecyclerView.h)this.Mlb);
    this.mkw.setClipToPadding(false);
    this.mkw.setClipChildren(false);
    setClipToPadding(false);
    setClipChildren(false);
    paramContext = new e(paramContext, (e.a)new e(this));
    this.mkw.a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(286617);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        s.u(paramAnonymousRecyclerView, "recyclerView");
        Log.i("MicroMsg.MvTracksEditView", s.X("onScrollStateChanged: newState=", Integer.valueOf(paramAnonymousInt)));
        if ((paramAnonymousInt == 0) && (!MvTracksEditView.o(this.Mli)))
        {
          this.Mli.setVideoProgress(MvTracksEditView.n(this.Mli));
          Log.d("MicroMsg.MvTracksEditView", s.X("scrolling stopped, progress=", Long.valueOf(this.Mli.getVideoProgress())));
          paramAnonymousRecyclerView = this.Mli.getCallback();
          if (paramAnonymousRecyclerView != null) {
            paramAnonymousRecyclerView.sK(this.Mli.getVideoProgress());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(286617);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(286602);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        s.u(paramAnonymousRecyclerView, "recyclerView");
        MvTracksEditView.m(this.Mli);
        MvTracksEditView.h(this.Mli).MkB = MvTracksEditView.n(this.Mli);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(286602);
      }
    });
    this.mkw.a((RecyclerView.k)new RecyclerView.k()
    {
      private float Mlj;
      private float Mlk;
      private int Mll = 200;
      private long lastClickTime;
      
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        boolean bool3 = false;
        boolean bool2 = false;
        AppMethodBeat.i(286630);
        s.u(paramAnonymousRecyclerView, "recyclerView");
        s.u(paramAnonymousMotionEvent, "event");
        MvTracksEditView.b(this.Mli, paramAnonymousMotionEvent.getX());
        MvTracksEditView.c(this.Mli, paramAnonymousMotionEvent.getY());
        MvTracksEditView.d(this.Mli, paramAnonymousMotionEvent.getRawY());
        boolean bool1 = bool2;
        switch (paramAnonymousMotionEvent.getAction())
        {
        default: 
          bool1 = bool2;
        }
        float f1;
        Object localObject;
        int m;
        for (;;)
        {
          if ((!bool1) && (!this.Mli.gsk()) && (!this.Mli.gsj()))
          {
            paramContext.onTouchEvent(paramAnonymousMotionEvent);
            if (MvTracksEditView.p(this.Mli))
            {
              AppMethodBeat.o(286630);
              return true;
              paramAnonymousRecyclerView.JO();
              this.lastClickTime = System.currentTimeMillis();
              this.Mlj = MvTracksEditView.a(this.Mli);
              this.Mlk = MvTracksEditView.q(this.Mli);
              bool1 = false;
              continue;
              long l = System.currentTimeMillis();
              bool1 = bool2;
              if (l - this.lastClickTime < this.Mll)
              {
                bool1 = bool2;
                if (Math.abs(MvTracksEditView.a(this.Mli) - this.Mlj) < MvTracksEditView.r(this.Mli))
                {
                  bool1 = bool2;
                  if (Math.abs(MvTracksEditView.q(this.Mli) - this.Mlk) < MvTracksEditView.r(this.Mli))
                  {
                    paramAnonymousRecyclerView = MvTracksEditView.e(this.Mli);
                    f1 = MvTracksEditView.a(this.Mli);
                    if ((!paramAnonymousRecyclerView.rKp) || (!d.isAvailable()))
                    {
                      paramAnonymousRecyclerView = null;
                      bool1 = bool3;
                      if (paramAnonymousRecyclerView != null)
                      {
                        localObject = this.Mli.getCallback();
                        if (localObject != null) {
                          ((MvTracksEditView.a)localObject).adY(paramAnonymousRecyclerView.intValue());
                        }
                        bool1 = true;
                      }
                      this.lastClickTime = l;
                    }
                    else
                    {
                      m = paramAnonymousRecyclerView.offset;
                      if (m <= 0) {
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        int k;
        for (int j = 0;; j = k)
        {
          k = j + 1;
          localObject = (d.a)paramAnonymousRecyclerView.Mls.get(j);
          float f2 = ((d.a)localObject).left;
          int i;
          if (f1 <= ((d.a)localObject).right) {
            if (f2 <= f1) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label457;
            }
            paramAnonymousRecyclerView = Integer.valueOf(((d.a)paramAnonymousRecyclerView.Mls.get(j)).index);
            break;
            i = 0;
            continue;
            i = 0;
          }
          label457:
          if (k >= m)
          {
            paramAnonymousRecyclerView = null;
            break;
            AppMethodBeat.o(286630);
            return bool1;
          }
        }
      }
      
      public final void aX(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(286611);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$5", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aYj());
        s.u(paramAnonymousRecyclerView, "recyclerView");
        s.u(paramAnonymousMotionEvent, "event");
        if (MvTracksEditView.p(this.Mli)) {
          paramContext.onTouchEvent(paramAnonymousMotionEvent);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$5", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(286611);
      }
    });
    this.AJH = new LinearLayoutManager(0, false);
    this.mkw.setLayoutManager((RecyclerView.LayoutManager)this.AJH);
    AppMethodBeat.o(286715);
  }
  
  private final int aet(int paramInt)
  {
    AppMethodBeat.i(286749);
    paramInt = getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(286749);
    return paramInt;
  }
  
  private final boolean gsi()
  {
    AppMethodBeat.i(286722);
    if ((this.MkZ) || (gsj()) || (gsk()))
    {
      AppMethodBeat.o(286722);
      return true;
    }
    AppMethodBeat.o(286722);
    return false;
  }
  
  private final long gso()
  {
    int k = 0;
    AppMethodBeat.i(286742);
    if (this.mkw.getChildCount() == 0)
    {
      AppMethodBeat.o(286742);
      return 0L;
    }
    View localView = null;
    int m = this.mkw.getChildCount();
    int i;
    int j;
    if (m > 0)
    {
      i = 0;
      j = i + 1;
      localView = this.mkw.getChildAt(i);
      i = RecyclerView.bA(localView);
      if ((i == -1) && (j < m)) {}
    }
    for (;;)
    {
      if ((localView == null) || (i == -1))
      {
        Log.i("MicroMsg.MvTracksEditView", "computeProgress: not find view position");
        l = this.Mle;
        AppMethodBeat.o(286742);
        return l;
      }
      j = this.AJH.getItemViewType(localView);
      float f = -localView.getLeft() / getWidthPerMills();
      switch (j)
      {
      case 3: 
      default: 
        l = 0L;
      }
      for (;;)
      {
        this.Mle = (((float)l + f));
        l = this.Mle;
        AppMethodBeat.o(286742);
        return l;
        l = 0L;
        continue;
        l = this.Mlc + (getWidth() / 2.0D / getWidthPerMills());
        continue;
        m = c.aeo(i);
        j = k;
        if (m >= 0)
        {
          j = k;
          if (m <= getTracks().size() - 1) {
            j = 1;
          }
        }
        if (j == 0) {
          break;
        }
        l = ((com.tencent.mm.plugin.vlog.ui.thumb.a)getTracks().get(m)).UoU + (getWidth() / 2.0D / getWidthPerMills());
      }
      Log.i("MicroMsg.MvTracksEditView", "not find view " + i + ' ' + m);
      long l = this.Mle;
      AppMethodBeat.o(286742);
      return l;
      i = j;
      break;
      i = -1;
    }
  }
  
  private final int gsp()
  {
    AppMethodBeat.i(286755);
    int i = (int)(getResources().getDisplayMetrics().density * 48.0F);
    AppMethodBeat.o(286755);
    return i;
  }
  
  public final void bq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(287024);
    Log.i("MicroMsg.MvTracksEditView", "setTransitionStatus: index=" + paramInt + ", enabled=" + paramBoolean);
    if ((paramBoolean) && (!this.Mlb.Mly.contains(Integer.valueOf(paramInt))))
    {
      this.Mlb.Mly.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(287024);
      return;
    }
    if (!paramBoolean) {
      this.Mlb.Mly.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(287024);
  }
  
  public final a getCallback()
  {
    return this.Mld;
  }
  
  public final int getDraggingIndex()
  {
    return this.MkV;
  }
  
  public final long getFillingDuration()
  {
    AppMethodBeat.i(286934);
    long l = Math.max(this.Mbr - this.Mlc, 0L);
    AppMethodBeat.o(286934);
    return l;
  }
  
  public final int getFillingWidth()
  {
    AppMethodBeat.i(286939);
    int i = Math.max((int)((float)getFillingDuration() * getWidthPerMills()), 0);
    AppMethodBeat.o(286939);
    return i;
  }
  
  public final int getSelectedIndex()
  {
    return this.dbk;
  }
  
  public final int getSpaceSize()
  {
    return this.MkX;
  }
  
  public final com.tencent.mm.plugin.mv.ui.c.b getThumbLoader()
  {
    return this.Mbx;
  }
  
  public final List<com.tencent.mm.plugin.vlog.ui.thumb.a> getTracks()
  {
    return this.MkW;
  }
  
  public final long getVideoProgress()
  {
    return this.Mlh;
  }
  
  public final float getWidthPerMills()
  {
    return this.MkC.Mks;
  }
  
  public final boolean gsj()
  {
    AppMethodBeat.i(286981);
    if (getDraggingIndex() != -1)
    {
      AppMethodBeat.o(286981);
      return true;
    }
    AppMethodBeat.o(286981);
    return false;
  }
  
  public final boolean gsk()
  {
    AppMethodBeat.i(286986);
    if (getSelectedIndex() != -1)
    {
      AppMethodBeat.o(286986);
      return true;
    }
    AppMethodBeat.o(286986);
    return false;
  }
  
  public final void gsl()
  {
    AppMethodBeat.i(286999);
    gsn();
    this.MkC.reset(this.Mlc);
    gsm();
    this.MkT.setVisibility(0);
    this.mkw.Kp();
    this.MkU.bZE.notifyChanged();
    AppMethodBeat.o(286999);
  }
  
  public final void gsm()
  {
    AppMethodBeat.i(287009);
    Iterator localIterator = ((Iterable)this.MkW).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (com.tencent.mm.plugin.vlog.ui.thumb.a)localIterator.next();
      float f = ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).getPlayRate() * (((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).width / getWidthPerMills());
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).UoR = ((float)((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).getTotalDuration() / f);
      int i = kotlin.h.a.eH((float)Math.ceil((float)((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).getTotalDuration() / ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).getPlayRate() / (((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).width / getWidthPerMills())));
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).UoS.clear();
      localObject1 = ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).UoS;
      Object localObject2 = (Iterable)kotlin.k.k.qt(0, i);
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((ah)localObject2).Zo();
        com.tencent.mm.plugin.vlog.ui.thumb.e locale = new com.tencent.mm.plugin.vlog.ui.thumb.e();
        locale.GvM = ((i * f));
        localCollection.add(locale);
      }
      ((LinkedList)localObject1).addAll((Collection)localCollection);
    }
    AppMethodBeat.o(287009);
  }
  
  public final void gsn()
  {
    AppMethodBeat.i(287018);
    Object localObject = ((Iterable)this.MkW).iterator();
    long l1 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.vlog.ui.thumb.a locala = (com.tencent.mm.plugin.vlog.ui.thumb.a)((Iterator)localObject).next();
      locala.UoU = l1;
      long l2;
      if (locala.hUo() + l1 < this.Mbr) {
        l2 = locala.hUo();
      }
      for (;;)
      {
        l1 = l2 + l1;
        break;
        l2 = kotlin.k.k.B(this.Mbr - l1, 0L, locala.hUo());
        locala.UoQ = (locala.UoP + l2);
      }
    }
    this.Mlc = l1;
    localObject = this.Mlb;
    if (this.Mlc < this.Mbr) {}
    for (boolean bool = true;; bool = false)
    {
      ((d)localObject).Mlz = bool;
      Log.i("MicroMsg.MvTracksEditView", "computeTracksDuration: " + this.Mlc + ", timeHelper:" + this.MkC.Mkr + ", " + this.MkC.Mks);
      AppMethodBeat.o(287018);
      return;
    }
  }
  
  public final void ki(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287031);
    if ((paramInt1 == -1) || (paramInt2 == -1) || (paramInt1 == paramInt2))
    {
      AppMethodBeat.o(287031);
      return;
    }
    ArrayList localArrayList = (ArrayList)this.MkW;
    Object localObject = localArrayList.remove(paramInt1);
    s.s(localObject, "it.removeAt(fromPosition)");
    localArrayList.add(paramInt2, (com.tencent.mm.plugin.vlog.ui.thumb.a)localObject);
    if (paramInt1 > paramInt2) {}
    for (localObject = new r(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));; localObject = new r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)))
    {
      paramInt1 = ((Number)((r)localObject).bsC).intValue();
      int i = ((Number)((r)localObject).bsD).intValue();
      if (paramInt1 <= i) {
        do
        {
          paramInt2 = paramInt1;
          paramInt1 = paramInt2 + 1;
          ((com.tencent.mm.plugin.vlog.ui.thumb.a)localArrayList.get(paramInt2)).trackIndex = paramInt2;
        } while (paramInt2 != i);
      }
      AppMethodBeat.o(287031);
      return;
    }
  }
  
  public final void setCallback(a parama)
  {
    this.Mld = parama;
  }
  
  public final void setDraggingIndex(int paramInt)
  {
    this.MkV = paramInt;
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.dbk = paramInt;
  }
  
  public final void setThumbLoader(com.tencent.mm.plugin.mv.ui.c.b paramb)
  {
    this.Mbx = paramb;
  }
  
  public final void setVideoProgress(long paramLong)
  {
    AppMethodBeat.i(286974);
    this.Mlh = paramLong;
    Object localObject;
    if ((this.mkw.getScrollState() == 0) && (!gsi()))
    {
      float f1 = (float)(paramLong - gso());
      float f2 = getWidthPerMills();
      localObject = this.MkK;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(paramLong));
      }
      this.mkw.scrollBy((int)(f2 * f1), 0);
      this.Mla.MkB = paramLong;
    }
    if (gsk())
    {
      localObject = this.MkU.MkG;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Long.valueOf(this.Mlh));
      }
    }
    AppMethodBeat.o(286974);
  }
  
  public final void t(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(286992);
    Log.i("MicroMsg.MvTracksEditView", "updateTrack: index=" + paramInt + ", startTime=" + paramLong1 + ", endTime=" + paramLong2);
    com.tencent.mm.plugin.vlog.ui.thumb.a locala = (com.tencent.mm.plugin.vlog.ui.thumb.a)getTracks().get(paramInt);
    locala.UoP = paramLong1;
    locala.UoQ = paramLong2;
    gsn();
    this.mkw.Kp();
    this.MkU.fV(c.aep(paramInt));
    AppMethodBeat.o(286992);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;", "", "handleDragDelete", "", "touchY", "", "type", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$DeleteDragType;", "index", "", "onChooseTransition", "", "onDragEnded", "onDragStarted", "onMove", "fromPosition", "toPosition", "onSeek", "target", "", "onSelectStarted", "startTime", "endTime", "onTrackEndChanged", "time", "onTrackSlidingStarted", "onTrackSlidingStopped", "onTrackStartChanged", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract boolean a(float paramFloat, MvTracksEditView.c paramc, int paramInt);
    
    public abstract void aM(int paramInt, long paramLong);
    
    public abstract void aN(int paramInt, long paramLong);
    
    public abstract void adY(int paramInt);
    
    public abstract void adZ(int paramInt);
    
    public abstract void gZ(int paramInt1, int paramInt2);
    
    public abstract void gql();
    
    public abstract void q(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void r(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void s(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void sK(long paramLong);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$DeleteDragType;", "", "(Ljava/lang/String;I)V", "MOVE", "END", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(286600);
      Mln = new c("MOVE", 0);
      Mlo = new c("END", 1);
      Mlp = new c[] { Mln, Mlo };
      AppMethodBeat.o(286600);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$DraggingCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView;)V", "diffX", "", "toPosition", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onChildDraw", "", "c", "Landroid/graphics/Canvas;", "dX", "", "dY", "actionState", "isCurrentlyActive", "", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class d
    extends k.a
  {
    private int Mlq;
    private int Mlr;
    
    public d()
    {
      AppMethodBeat.i(286586);
      this.Mlr = -1;
      AppMethodBeat.o(286586);
    }
    
    private static final void s(MvTracksEditView paramMvTracksEditView)
    {
      AppMethodBeat.i(286603);
      s.u(paramMvTracksEditView, "this$0");
      MvTracksEditView.f(paramMvTracksEditView).Kp();
      Log.i("MicroMsg.MvTracksEditView", s.X("stopDragging: ", Integer.valueOf(paramMvTracksEditView.getDraggingIndex())));
      MvTracksEditView.g(paramMvTracksEditView).by(0, MvTracksEditView.g(paramMvTracksEditView).getItemCount());
      AppMethodBeat.o(286603);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(286654);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      if ((this.Mli.gsk()) || (paramRecyclerView.getScrollState() != 0) || (!(paramv instanceof c.f)))
      {
        AppMethodBeat.o(286654);
        return 0;
      }
      int i = k.a.bk(15, 0);
      AppMethodBeat.o(286654);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(286694);
      s.u(paramCanvas, "c");
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      if (paramInt == 2)
      {
        MvTracksEditView.a locala = this.Mli.getCallback();
        if (locala != null) {
          locala.a(MvTracksEditView.l(this.Mli) + paramFloat2, MvTracksEditView.c.Mln, this.Mli.getDraggingIndex());
        }
        super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 - this.Mlq, paramFloat2, paramInt, paramBoolean);
        AppMethodBeat.o(286694);
        return;
      }
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1, paramFloat2, paramInt, paramBoolean);
      AppMethodBeat.o(286694);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(286669);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv1, "viewHolder");
      s.u(paramv2, "target");
      if ((!(paramv1 instanceof c.f)) || (!(paramv2 instanceof c.f)))
      {
        AppMethodBeat.o(286669);
        return false;
      }
      int i = c.aeo(((c.f)paramv1).KJ());
      int j = c.aeo(((c.f)paramv2).KJ());
      this.Mlr = c.aeo(((c.f)paramv2).KJ());
      Log.i("MicroMsg.MvTracksEditView", "move " + i + " => " + j);
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView != null) {
        paramRecyclerView.bz(((c.f)paramv1).KJ(), ((c.f)paramv2).KJ());
      }
      AppMethodBeat.o(286669);
      return true;
    }
    
    public final void b(RecyclerView.v paramv, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(286645);
      super.b(paramv, paramInt);
      Log.d("MicroMsg.MvTracksEditView", "onSelectedChanged, viewHolder:" + paramv + ", actionState:" + paramInt);
      if (paramv != null)
      {
        if (!(paramv instanceof c.f))
        {
          paramv = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(286645);
          throw paramv;
        }
        paramInt = (int)MvTracksEditView.a(this.Mli);
        i = MvTracksEditView.b(this.Mli) / 2;
        this.Mlq = (((c.f)paramv).caK.getLeft() - (int)MvTracksEditView.a(this.Mli) + MvTracksEditView.b(this.Mli) / 2);
        MvTracksEditView.c(this.Mli).bo(((c.f)paramv).KJ(), paramInt - i);
        MvTracksEditView.d(this.Mli).setVisibility(4);
        MvTracksEditView.e(this.Mli).rKp = false;
        MvTracksEditView.f(this.Mli).Kp();
        Log.i("MicroMsg.MvTracksEditView", s.X("startDragging: ", Integer.valueOf(((c.f)paramv).gsh())));
        MvTracksEditView.g(this.Mli).by(0, MvTracksEditView.g(this.Mli).getItemCount());
        this.Mli.setDraggingIndex(((c.f)paramv).gsh());
        MvTracksEditView.a(this.Mli, ((c.f)paramv).gsh());
        MvTracksEditView.f(this.Mli).b((RecyclerView.h)MvTracksEditView.h(this.Mli));
        MvTracksEditView.a locala = this.Mli.getCallback();
        if (locala != null)
        {
          locala.adZ(((c.f)paramv).gsh());
          AppMethodBeat.o(286645);
        }
      }
      else if (paramInt == 0)
      {
        this.Mlq = 0;
        MvTracksEditView.e(this.Mli).rKp = true;
        MvTracksEditView.d(this.Mli).setVisibility(0);
        paramv = this.Mli.getCallback();
        if ((paramv != null) && (paramv.a(0.0F, MvTracksEditView.c.Mlo, MvTracksEditView.i(this.Mli)) == true)) {}
        for (paramInt = i; paramInt != 0; paramInt = 0)
        {
          MvTracksEditView.f(this.Mli).a((RecyclerView.h)MvTracksEditView.h(this.Mli));
          ((ArrayList)MvTracksEditView.j(this.Mli)).remove(MvTracksEditView.i(this.Mli));
          this.Mli.gsl();
          this.Mli.setDraggingIndex(-1);
          MvTracksEditView.a(this.Mli, -1);
          this.Mlr = -1;
          AppMethodBeat.o(286645);
          return;
        }
        this.Mli.ki(MvTracksEditView.i(this.Mli), this.Mlr);
        this.Mli.post(new MvTracksEditView.d..ExternalSyntheticLambda0(this.Mli));
        this.Mli.setDraggingIndex(-1);
        paramv = this.Mli.getCallback();
        if (paramv != null) {
          paramv.gZ(MvTracksEditView.i(this.Mli), this.Mlr);
        }
        MvTracksEditView.a(this.Mli, -1);
        this.Mlr = -1;
        MvTracksEditView.f(this.Mli).a((RecyclerView.h)MvTracksEditView.h(this.Mli));
        paramv = this.Mli.getCallback();
        if (paramv != null) {
          paramv.gql();
        }
        MvTracksEditView.k(this.Mli);
        paramv = m.LYc;
        paramv = m.gpJ();
        paramv.ioV = 18L;
        paramv.iXw = 0;
        paramv.bMH();
      }
      AppMethodBeat.o(286645);
    }
    
    public final void h(RecyclerView.v paramv)
    {
      AppMethodBeat.i(286682);
      s.u(paramv, "viewHolder");
      AppMethodBeat.o(286682);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$scaleListener$1", "Lcom/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector$OnScaleGestureListener;", "onScale", "", "detector", "Lcom/tencent/mm/plugin/mv/ui/widget/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements e.a
  {
    e(MvTracksEditView paramMvTracksEditView) {}
    
    public final boolean a(e parame)
    {
      AppMethodBeat.i(286579);
      s.u(parame, "detector");
      MvTracksEditView.a(this.Mli, true);
      MvTracksEditView.m(this.Mli);
      MvTracksEditView.a(this.Mli, MvTracksEditView.n(this.Mli));
      AppMethodBeat.o(286579);
      return true;
    }
    
    public final void b(e parame)
    {
      AppMethodBeat.i(286588);
      s.u(parame, "detector");
      MvTracksEditView.a(this.Mli, false);
      parame = m.LYc;
      parame = m.gpJ();
      parame.ioV = 17L;
      parame.iXw = 0;
      parame.bMH();
      AppMethodBeat.o(286588);
    }
    
    public final boolean c(e parame)
    {
      AppMethodBeat.i(286599);
      s.u(parame, "detector");
      MvTracksEditView localMvTracksEditView = this.Mli;
      int i;
      float f;
      if (parame.gss()) {
        if (((parame.Mmq) && (parame.Mmb < parame.Mmc)) || ((!parame.Mmq) && (parame.Mmb > parame.Mmc)))
        {
          i = 1;
          f = Math.abs(1.0F - parame.Mmb / parame.Mmc) * 0.5F;
          if (parame.Mmc <= parame.Mml) {
            break label150;
          }
          if (i == 0) {
            break label121;
          }
          f = 1.0F + f;
        }
      }
      for (;;)
      {
        MvTracksEditView.a(localMvTracksEditView, f);
        AppMethodBeat.o(286599);
        return true;
        i = 0;
        break;
        label121:
        f = 1.0F - f;
        continue;
        if (parame.Mmc > 0.0F) {
          f = parame.Mmb / parame.Mmc;
        } else {
          label150:
          f = 1.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView
 * JD-Core Version:    0.7.0.1
 */