package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "container", "Landroid/view/View;", "currentLine", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eventListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "getEventListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;)V", "isDragged", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "lyricScroller", "Landroid/support/v7/widget/LinearSmoothScroller;", "mLyricInfoList", "", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "scrollListener", "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1;", "titleView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "clearPlayingFlag", "", "pos", "curPos", "findShowLine", "time", "", "hasLrc", "initEntryList", "prepareViews", "runOnUi", "r", "Ljava/lang/Runnable;", "setCurrentTime", "smooth", "setLyricObj", "setSongInfo", "songName", "", "singer", "setVisibility", "visibility", "Companion", "FastLineScroller", "LineNoSmoothScroller", "LineScroller", "LyricInfo", "MusicMvLyricConvertData", "MusicMvLyricConverter", "OnLyricEventListener", "plugin-mv_release"})
public final class MusicMvLyricView
  extends RelativeLayout
{
  private static final int AxL;
  private static final int Ayk;
  public static final MusicMvLyricView.a Ayl;
  private com.tencent.mm.plugin.music.model.e Amv;
  private int Amw;
  private List<e> Aor;
  private WxRecyclerView Aye;
  public final MusicMvMarqueeTextView Ayf;
  private h Ayg;
  private boolean Ayh;
  private ae Ayi;
  private final m Ayj;
  private View jxm;
  private ArrayList<f> kgc;
  private WxRecyclerAdapter<f> tFp;
  private LinearLayoutManager vKp;
  
  static
  {
    AppMethodBeat.i(257572);
    Ayl = new MusicMvLyricView.a((byte)0);
    AxL = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    Ayk = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 320);
    AppMethodBeat.o(257572);
  }
  
  public MusicMvLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(257571);
    AppMethodBeat.o(257571);
  }
  
  public MusicMvLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(257570);
    this.kgc = new ArrayList();
    this.Aor = ((List)new ArrayList());
    this.Amw = -1;
    this.Ayj = new m(this);
    this.jxm = View.inflate(paramContext, 2131495787, (ViewGroup)this);
    this.tFp = new WxRecyclerAdapter((f)new i(this), this.kgc, true);
    paramAttributeSet = this.jxm;
    if (paramAttributeSet != null) {}
    for (paramAttributeSet = (WxRecyclerView)paramAttributeSet.findViewById(2131304299);; paramAttributeSet = null)
    {
      this.Aye = paramAttributeSet;
      paramAttributeSet = this.Aye;
      if (paramAttributeSet != null) {
        paramAttributeSet.setAdapter((RecyclerView.a)this.tFp);
      }
      getContext();
      this.vKp = new LinearLayoutManager(1, false);
      paramAttributeSet = this.Aye;
      if (paramAttributeSet != null) {
        paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)this.vKp);
      }
      paramAttributeSet = this.Aye;
      if (paramAttributeSet != null) {
        paramAttributeSet.b((RecyclerView.h)new MusicMvLyricView.j());
      }
      paramAttributeSet = this.Aye;
      if (paramAttributeSet != null) {
        paramAttributeSet.a((RecyclerView.l)this.Ayj);
      }
      paramAttributeSet = this.tFp;
      if (paramAttributeSet != null) {
        paramAttributeSet.RqP = ((g.c)new k(this));
      }
      paramAttributeSet = this.jxm;
      if (paramAttributeSet != null)
      {
        paramAttributeSet = paramAttributeSet.findViewById(2131297168);
        if (paramAttributeSet != null) {
          paramAttributeSet.setOnClickListener((View.OnClickListener)new l(this));
        }
      }
      setTag(this);
      paramAttributeSet = findViewById(2131308287);
      p.g(paramAttributeSet, "findViewById(R.id.song_info_tv)");
      this.Ayf = ((MusicMvMarqueeTextView)paramAttributeSet);
      this.Ayf.setTextSize(com.tencent.mm.cb.a.fromDPToPix(paramContext, 17));
      this.Ayf.setTextColor(-1);
      AppMethodBeat.o(257570);
      return;
    }
  }
  
  public final void E(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(257568);
    d.h((kotlin.g.a.a)new n(this, paramLong, paramBoolean));
    AppMethodBeat.o(257568);
  }
  
  public final h getEventListener()
  {
    return this.Ayg;
  }
  
  public final void setEventListener(h paramh)
  {
    this.Ayg = paramh;
  }
  
  public final void setLyricObj(com.tencent.mm.plugin.music.model.e parame)
  {
    AppMethodBeat.i(257567);
    this.Amv = parame;
    if (this.Amv == null)
    {
      Log.e("MicroMsg.MusicMvCommentView", "null == lyricObj, maybe you not setLyricObj, check ！！！");
      AppMethodBeat.o(257567);
      return;
    }
    parame = this.Amv;
    if (parame != null)
    {
      this.Aor.clear();
      Object localObject1 = this.tFp;
      if (localObject1 != null)
      {
        localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
        if (localObject1 != null) {
          ((List)localObject1).clear();
        }
      }
      int j = parame.euw();
      int i = 0;
      while (i < j)
      {
        localObject1 = parame.SQ(i);
        p.g(localObject1, "lyricObj.getSentence(i)");
        if (!((e.a)localObject1).isEmpty())
        {
          long l = ((e.a)localObject1).timestamp;
          localObject1 = ((e.a)localObject1).content;
          p.g(localObject1, "sentence.content");
          Object localObject2 = new e(l, (String)localObject1);
          localObject1 = new f((e)localObject2);
          this.Aor.add(localObject2);
          localObject2 = this.tFp;
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
      parame = this.tFp;
      if (parame != null)
      {
        parame.notifyDataSetChanged();
        AppMethodBeat.o(257567);
        return;
      }
      AppMethodBeat.o(257567);
      return;
    }
    AppMethodBeat.o(257567);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(257566);
    super.setVisibility(paramInt);
    if (paramInt == 8) {
      this.Ayh = false;
    }
    AppMethodBeat.o(257566);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$FastLineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-mv_release"})
  public final class b
    extends MusicMvLyricView.d
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(257547);
      AppMethodBeat.o(257547);
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(257546);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 25.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(257546);
      return f;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineNoSmoothScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForDeceleration", "", "dx", "plugin-mv_release"})
  public final class c
    extends MusicMvLyricView.d
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(257549);
      AppMethodBeat.o(257549);
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(257548);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 0.1F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(257548);
      return f;
    }
    
    public final int cc(int paramInt)
    {
      return 1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "action", "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-mv_release"})
  public class d
    extends ae
  {
    public d()
    {
      super();
      AppMethodBeat.i(257552);
      AppMethodBeat.o(257552);
    }
    
    public float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(257551);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 300.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(257551);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(257550);
      p.h(paramView, "targetView");
      p.h(params, "state");
      p.h(parama, "action");
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
          m = com.tencent.mm.cb.a.fromDPToPix(MusicMvLyricView.this.getContext(), 75);
          if (j >= m) {
            break;
          }
          i = m - j;
          j = cc(i);
          parama.a(0, -i, j, (Interpolator)this.VQ);
          AppMethodBeat.o(257550);
          return;
        }
        if (i - k < m)
        {
          i = i - m - k;
          j = cc(i);
          parama.a(0, -i, j, (Interpolator)this.VQ);
        }
        AppMethodBeat.o(257550);
        return;
      }
      params = new int[2];
      WxRecyclerView localWxRecyclerView = MusicMvLyricView.b(MusicMvLyricView.this);
      if (localWxRecyclerView != null) {
        localWxRecyclerView.getLocationInWindow(params);
      }
      int i = (int)(MusicMvLyricView.this.getHeight() * 0.37F) - params[1] - paramView.getTop() + MusicMvLyricView.ewr();
      int j = cc(i);
      parama.a(0, -i, j, (Interpolator)this.VQ);
      AppMethodBeat.o(257550);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "", "time", "", "text", "", "playing", "", "(JLjava/lang/String;Z)V", "getPlaying", "()Z", "setPlaying", "(Z)V", "<set-?>", "getText", "()Ljava/lang/String;", "getTime", "()J", "compareTo", "", "entry", "plugin-mv_release"})
  public static final class e
    implements Comparable<e>
  {
    boolean bfW;
    String text;
    long time;
    
    public e(long paramLong, String paramString)
    {
      AppMethodBeat.i(257554);
      this.time = paramLong;
      this.text = paramString;
      this.bfW = false;
      AppMethodBeat.o(257554);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "lyricInfo", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;)V", "getLyricInfo", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "getItemId", "", "getItemType", "", "plugin-mv_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvLyricView.e Ayn;
    
    public f(MusicMvLyricView.e parame)
    {
      AppMethodBeat.i(257556);
      this.Ayn = parame;
      AppMethodBeat.o(257556);
    }
    
    public final int cxn()
    {
      return 7;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(257555);
      long l = this.Ayn.hashCode();
      AppMethodBeat.o(257555);
      return l;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-mv_release"})
  public final class g
    extends com.tencent.mm.view.recyclerview.e<MusicMvLyricView.f>
  {
    public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
    {
      AppMethodBeat.i(257557);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      AppMethodBeat.o(257557);
    }
    
    public final int getLayoutId()
    {
      return 2131495786;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "", "onBackClick", "", "onLineClick", "position", "", "time", "", "plugin-mv_release"})
  public static abstract interface h
  {
    public abstract void Hu(long paramLong);
    
    public abstract void evS();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class i
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(257559);
      Log.i("MicroMsg.MusicMvCommentView", "getItemConvert, type:".concat(String.valueOf(paramInt)));
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new MusicMvLyricView.g(this.Aym);
      AppMethodBeat.o(257559);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class k
    implements g.c<h>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(MusicMvLyricView paramMusicMvLyricView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257562);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.Aym.getEventListener();
      if (paramView != null) {
        paramView.evS();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257562);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-mv_release"})
  public static final class m
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(257563);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if ((!MusicMvLyricView.a(this.Aym)) && (paramInt == 1)) {
        MusicMvLyricView.a(this.Aym, true);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(257563);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257564);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(257564);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView
 * JD-Core Version:    0.7.0.1
 */