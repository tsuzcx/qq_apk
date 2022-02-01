package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "container", "Landroid/view/View;", "currentLine", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eventListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "getEventListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;)V", "isDragged", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "lyricScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "mLyricInfoList", "", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "scrollListener", "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1;", "titleView", "Landroid/widget/TextView;", "clearPlayingFlag", "", "pos", "curPos", "findShowLine", "time", "", "hasLrc", "initEntryList", "prepareViews", "runOnUi", "r", "Ljava/lang/Runnable;", "setCurrentTime", "smooth", "setLyricObj", "setSongInfo", "songName", "", "singer", "setVisibility", "visibility", "Companion", "FastLineScroller", "LineNoSmoothScroller", "LineScroller", "LyricInfo", "MusicMvLyricConvertData", "MusicMvLyricConverter", "OnLyricEventListener", "plugin-mv_release"})
public final class MusicMvLyricView
  extends RelativeLayout
{
  private static final int GoT;
  public static final MusicMvLyricView.a GoU;
  private static final int Gou;
  private LinearLayoutManager Arh;
  private com.tencent.mm.plugin.music.model.e FTB;
  private int FTC;
  private List<e> FVz;
  private WxRecyclerView GoO;
  private h GoP;
  private boolean GoQ;
  private androidx.recyclerview.widget.p GoR;
  private final m GoS;
  private View fyN;
  private ArrayList<f> mXB;
  public final TextView titleView;
  private WxRecyclerAdapter<f> xnR;
  
  static
  {
    AppMethodBeat.i(236583);
    GoU = new MusicMvLyricView.a((byte)0);
    Gou = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    GoT = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 320);
    AppMethodBeat.o(236583);
  }
  
  public MusicMvLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(236582);
    AppMethodBeat.o(236582);
  }
  
  public MusicMvLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236581);
    this.mXB = new ArrayList();
    this.FVz = ((List)new ArrayList());
    this.FTC = -1;
    this.GoS = new m(this);
    this.fyN = View.inflate(paramContext, b.f.FZD, (ViewGroup)this);
    this.xnR = new WxRecyclerAdapter((f)new i(this), this.mXB, true);
    paramContext = this.fyN;
    if (paramContext != null) {}
    for (paramContext = (WxRecyclerView)paramContext.findViewById(b.e.FXz);; paramContext = null)
    {
      this.GoO = paramContext;
      paramContext = this.GoO;
      if (paramContext != null) {
        paramContext.setAdapter((RecyclerView.a)this.xnR);
      }
      getContext();
      this.Arh = new LinearLayoutManager(1, false);
      paramContext = this.GoO;
      if (paramContext != null) {
        paramContext.setLayoutManager((RecyclerView.LayoutManager)this.Arh);
      }
      paramContext = this.GoO;
      if (paramContext != null) {
        paramContext.b((RecyclerView.h)new MusicMvLyricView.j());
      }
      paramContext = this.GoO;
      if (paramContext != null) {
        paramContext.a((RecyclerView.l)this.GoS);
      }
      paramContext = this.xnR;
      if (paramContext != null) {
        paramContext.YSn = ((h.c)new k(this));
      }
      paramContext = this.fyN;
      if (paramContext != null)
      {
        paramContext = paramContext.findViewById(b.e.zCT);
        if (paramContext != null) {
          paramContext.setOnClickListener((View.OnClickListener)new l(this));
        }
      }
      setTag(this);
      paramContext = findViewById(b.e.FZc);
      kotlin.g.b.p.j(paramContext, "findViewById(R.id.song_info_tv)");
      this.titleView = ((TextView)paramContext);
      this.titleView.setTextColor(-1);
      setClickable(true);
      AppMethodBeat.o(236581);
      return;
    }
  }
  
  public final void E(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(236577);
    d.uiThread((kotlin.g.a.a)new n(this, paramLong, paramBoolean));
    AppMethodBeat.o(236577);
  }
  
  public final h getEventListener()
  {
    return this.GoP;
  }
  
  public final void setEventListener(h paramh)
  {
    this.GoP = paramh;
  }
  
  public final void setLyricObj(com.tencent.mm.plugin.music.model.e parame)
  {
    AppMethodBeat.i(236576);
    this.FTB = parame;
    if (this.FTB == null)
    {
      Log.e("MicroMsg.MusicMvCommentView", "null == lyricObj, maybe you not setLyricObj, check ！！！");
      AppMethodBeat.o(236576);
      return;
    }
    parame = this.FTB;
    if (parame != null)
    {
      this.FVz.clear();
      Object localObject1 = this.xnR;
      if (localObject1 != null)
      {
        localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
        if (localObject1 != null) {
          ((List)localObject1).clear();
        }
      }
      int j = parame.feO();
      int i = 0;
      while (i < j)
      {
        localObject1 = parame.Zm(i);
        kotlin.g.b.p.j(localObject1, "lyricObj.getSentence(i)");
        if (!((e.a)localObject1).isEmpty())
        {
          long l = ((e.a)localObject1).timestamp;
          localObject1 = ((e.a)localObject1).content;
          kotlin.g.b.p.j(localObject1, "sentence.content");
          Object localObject2 = new e(l, (String)localObject1);
          localObject1 = new f((e)localObject2);
          this.FVz.add(localObject2);
          localObject2 = this.xnR;
          if (localObject2 != null)
          {
            localObject2 = (List)((WxRecyclerAdapter)localObject2).data;
            if (localObject2 != null) {
              ((List)localObject2).add(localObject1);
            }
          }
        }
        i += 1;
      }
      parame = this.xnR;
      if (parame != null)
      {
        parame.notifyDataSetChanged();
        AppMethodBeat.o(236576);
        return;
      }
      AppMethodBeat.o(236576);
      return;
    }
    AppMethodBeat.o(236576);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(236575);
    super.setVisibility(paramInt);
    if (paramInt == 8) {
      this.GoQ = false;
    }
    AppMethodBeat.o(236575);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$FastLineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-mv_release"})
  public final class b
    extends MusicMvLyricView.d
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(236187);
      AppMethodBeat.o(236187);
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(236186);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = 25.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(236186);
      return f;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineNoSmoothScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForDeceleration", "", "dx", "plugin-mv_release"})
  public final class c
    extends MusicMvLyricView.d
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(225266);
      AppMethodBeat.o(225266);
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(225265);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = 0.1F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(225265);
      return f;
    }
    
    public final int cE(int paramInt)
    {
      return 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-mv_release"})
  public class d
    extends androidx.recyclerview.widget.p
  {
    public d()
    {
      super();
      AppMethodBeat.i(243165);
      AppMethodBeat.o(243165);
    }
    
    public float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(243163);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = 300.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(243163);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(243162);
      kotlin.g.b.p.k(paramView, "targetView");
      kotlin.g.b.p.k(params, "state");
      kotlin.g.b.p.k(parama, "action");
      if (MusicMvLyricView.a(MusicMvLyricView.this))
      {
        params = MusicMvLyricView.b(MusicMvLyricView.this);
        if (params != null) {}
        int k;
        int m;
        for (i = params.getHeight();; i = 0)
        {
          j = paramView.getTop();
          k = paramView.getBottom();
          m = com.tencent.mm.ci.a.fromDPToPix(MusicMvLyricView.this.getContext(), 75);
          if (j >= m) {
            break;
          }
          i = m - j;
          j = cE(i);
          parama.a(0, -i, j, (Interpolator)this.aju);
          AppMethodBeat.o(243162);
          return;
        }
        if (i - k < m)
        {
          i = i - m - k;
          j = cE(i);
          parama.a(0, -i, j, (Interpolator)this.aju);
        }
        AppMethodBeat.o(243162);
        return;
      }
      params = new int[2];
      WxRecyclerView localWxRecyclerView = MusicMvLyricView.b(MusicMvLyricView.this);
      if (localWxRecyclerView != null) {
        localWxRecyclerView.getLocationInWindow(params);
      }
      int i = (int)(MusicMvLyricView.this.getHeight() * 0.37F) - params[1] - paramView.getTop() + MusicMvLyricView.fhK();
      int j = cE(i);
      parama.a(0, -i, j, (Interpolator)this.aju);
      AppMethodBeat.o(243162);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "", "time", "", "text", "", "playing", "", "(JLjava/lang/String;Z)V", "getPlaying", "()Z", "setPlaying", "(Z)V", "<set-?>", "getText", "()Ljava/lang/String;", "getTime", "()J", "compareTo", "", "entry", "plugin-mv_release"})
  public static final class e
    implements Comparable<e>
  {
    boolean aPw;
    String text;
    long time;
    
    public e(long paramLong, String paramString)
    {
      AppMethodBeat.i(229908);
      this.time = paramLong;
      this.text = paramString;
      this.aPw = false;
      AppMethodBeat.o(229908);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "lyricInfo", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;)V", "getLyricInfo", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "getItemId", "", "getItemType", "", "plugin-mv_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvLyricView.e GoW;
    
    public f(MusicMvLyricView.e parame)
    {
      AppMethodBeat.i(227796);
      this.GoW = parame;
      AppMethodBeat.o(227796);
    }
    
    public final int bAQ()
    {
      return 7;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(227792);
      long l = this.GoW.hashCode();
      AppMethodBeat.o(227792);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"})
  public final class g
    extends com.tencent.mm.view.recyclerview.e<MusicMvLyricView.f>
  {
    public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
    {
      AppMethodBeat.i(225999);
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      kotlin.g.b.p.k(parami, "holder");
      AppMethodBeat.o(225999);
    }
    
    public final int getLayoutId()
    {
      return b.f.FZC;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "", "onBackClick", "", "onDragged", "onLineClick", "position", "", "time", "", "plugin-mv_release"})
  public static abstract interface h
  {
    public abstract void OO(long paramLong);
    
    public abstract void dvz();
    
    public abstract void fha();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class i
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(225754);
      Log.i("MicroMsg.MusicMvCommentView", "getItemConvert, type:".concat(String.valueOf(paramInt)));
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new MusicMvLyricView.g(this.GoV);
      AppMethodBeat.o(225754);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class k
    implements h.c<i>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(MusicMvLyricView paramMusicMvLyricView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242931);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.GoV.getEventListener();
      if (paramView != null) {
        paramView.dvz();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242931);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-mv_release"})
  public static final class m
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(225269);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if ((!MusicMvLyricView.a(this.GoV)) && (paramInt == 1))
      {
        MusicMvLyricView.a(this.GoV, true);
        paramRecyclerView = this.GoV.getEventListener();
        if (paramRecyclerView != null) {
          paramRecyclerView.fha();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(225269);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(225274);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(225274);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(MusicMvLyricView paramMusicMvLyricView, long paramLong, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView
 * JD-Core Version:    0.7.0.1
 */