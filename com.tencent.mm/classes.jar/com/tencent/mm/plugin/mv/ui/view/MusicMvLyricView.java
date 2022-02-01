package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "container", "Landroid/view/View;", "currentLine", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eventListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "getEventListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;)V", "firstVisibleItemPos", "", "getFirstVisibleItemPos", "()[I", "setFirstVisibleItemPos", "([I)V", "isDragged", "", "lastVisibleItemPos", "getLastVisibleItemPos", "setLastVisibleItemPos", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getLyricRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setLyricRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "lyricScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "mLyricInfoList", "", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "scrollListener", "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1;", "titleView", "Landroid/widget/TextView;", "clearPlayingFlag", "", "pos", "curPos", "findShowLine", "time", "", "hasLrc", "initEntryList", "prepareViews", "runOnUi", "r", "Ljava/lang/Runnable;", "setCurrentTime", "smooth", "setLyricObj", "setSongInfo", "songName", "", "singer", "setVisibility", "visibility", "Companion", "FastLineScroller", "LineNoSmoothScroller", "LineScroller", "LyricInfo", "MusicMvLyricConvertData", "MusicMvLyricConverter", "OnLyricEventListener", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvLyricView
  extends RelativeLayout
{
  public static final MusicMvLyricView.a MiC;
  private static final int MiJ;
  private static final int Mio;
  private LinearLayoutManager AJH;
  private WxRecyclerAdapter<f> ALE;
  private boolean BwV;
  private e LOA;
  private int LOB;
  private List<e> LQx;
  private WxRecyclerView MiD;
  private h MiE;
  private o MiF;
  private int[] MiG;
  private int[] MiH;
  private final l MiI;
  private View hDw;
  private ArrayList<f> pUj;
  private final TextView titleView;
  
  static
  {
    AppMethodBeat.i(287164);
    MiC = new MusicMvLyricView.a((byte)0);
    Mio = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    MiJ = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 320);
    AppMethodBeat.o(287164);
  }
  
  public MusicMvLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287071);
    AppMethodBeat.o(287071);
  }
  
  public MusicMvLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287064);
    this.pUj = new ArrayList();
    this.LQx = ((List)new ArrayList());
    this.LOB = -1;
    this.MiG = new int[2];
    this.MiH = new int[2];
    this.MiI = new l(this);
    this.hDw = View.inflate(paramContext, b.f.LVA, (ViewGroup)this);
    this.ALE = new WxRecyclerAdapter((g)new i(this), this.pUj, true);
    paramContext = this.hDw;
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = (WxRecyclerView)paramContext.findViewById(b.e.LSZ))
    {
      this.MiD = paramContext;
      paramContext = this.MiD;
      if (paramContext != null) {
        paramContext.setAdapter((RecyclerView.a)this.ALE);
      }
      getContext();
      this.AJH = new LinearLayoutManager(1, false);
      paramContext = this.MiD;
      if (paramContext != null) {
        paramContext.setLayoutManager((RecyclerView.LayoutManager)this.AJH);
      }
      paramContext = this.MiD;
      if (paramContext != null) {
        paramContext.a((RecyclerView.h)new j());
      }
      paramContext = this.MiD;
      if (paramContext != null) {
        paramContext.a((RecyclerView.l)this.MiI);
      }
      paramContext = this.ALE;
      if (paramContext != null) {
        paramContext.agOe = ((i.c)new k(this));
      }
      paramContext = this.hDw;
      if (paramContext != null)
      {
        paramContext = paramContext.findViewById(b.e.EFG);
        if (paramContext != null) {
          paramContext.setOnClickListener(new MusicMvLyricView..ExternalSyntheticLambda0(this));
        }
      }
      setTag(this);
      paramContext = findViewById(b.e.LUO);
      s.s(paramContext, "findViewById(R.id.song_info_tv)");
      this.titleView = ((TextView)paramContext);
      this.titleView.setTextColor(-1);
      setClickable(true);
      AppMethodBeat.o(287064);
      return;
    }
  }
  
  private static final void a(MusicMvLyricView paramMusicMvLyricView, View paramView)
  {
    AppMethodBeat.i(287087);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramMusicMvLyricView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvLyricView, "this$0");
    paramMusicMvLyricView = paramMusicMvLyricView.getEventListener();
    if (paramMusicMvLyricView != null) {
      paramMusicMvLyricView.eft();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287087);
  }
  
  public final void N(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(287420);
    d.uiThread((kotlin.g.a.a)new m(this, paramLong, paramBoolean));
    AppMethodBeat.o(287420);
  }
  
  public final h getEventListener()
  {
    return this.MiE;
  }
  
  public final int[] getFirstVisibleItemPos()
  {
    return this.MiG;
  }
  
  public final int[] getLastVisibleItemPos()
  {
    return this.MiH;
  }
  
  public final WxRecyclerView getLyricRv()
  {
    return this.MiD;
  }
  
  public final void kE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(287408);
    s.u(paramString1, "songName");
    if (paramString2 != null) {
      paramString1 = paramString1 + '·' + paramString2;
    }
    for (;;)
    {
      this.titleView.setText((CharSequence)paramString1);
      AppMethodBeat.o(287408);
      return;
    }
  }
  
  public final void setEventListener(h paramh)
  {
    this.MiE = paramh;
  }
  
  public final void setFirstVisibleItemPos(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(287379);
    s.u(paramArrayOfInt, "<set-?>");
    this.MiG = paramArrayOfInt;
    AppMethodBeat.o(287379);
  }
  
  public final void setLastVisibleItemPos(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(287393);
    s.u(paramArrayOfInt, "<set-?>");
    this.MiH = paramArrayOfInt;
    AppMethodBeat.o(287393);
  }
  
  public final void setLyricObj(e parame)
  {
    AppMethodBeat.i(287417);
    this.LOA = parame;
    if (this.LOA == null)
    {
      Log.e("MicroMsg.MusicMvCommentView", "null == lyricObj, maybe you not setLyricObj, check ！！！");
      AppMethodBeat.o(287417);
      return;
    }
    parame = this.LOA;
    Object localObject1;
    int i;
    int k;
    if (parame != null)
    {
      this.LQx.clear();
      localObject1 = this.ALE;
      if (localObject1 != null)
      {
        localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
        if (localObject1 != null) {
          ((List)localObject1).clear();
        }
      }
      i = 0;
      k = parame.LMm.size();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject1 = parame.adz(i);
      s.s(localObject1, "lyricObj.getSentence(i)");
      if (!((e.a)localObject1).isEmpty())
      {
        long l = ((e.a)localObject1).timestamp;
        localObject1 = ((e.a)localObject1).content;
        s.s(localObject1, "sentence.content");
        Object localObject2 = new e(l, (String)localObject1);
        localObject1 = new f((e)localObject2);
        this.LQx.add(localObject2);
        localObject2 = this.ALE;
        if (localObject2 != null)
        {
          localObject2 = (List)((WxRecyclerAdapter)localObject2).data;
          if (localObject2 != null) {
            ((List)localObject2).add(localObject1);
          }
        }
      }
      if (j >= k)
      {
        parame = this.ALE;
        if (parame != null) {
          parame.bZE.notifyChanged();
        }
        AppMethodBeat.o(287417);
        return;
      }
      i = j;
    }
  }
  
  public final void setLyricRv(WxRecyclerView paramWxRecyclerView)
  {
    this.MiD = paramWxRecyclerView;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(287402);
    super.setVisibility(paramInt);
    if (paramInt == 8) {
      this.BwV = false;
    }
    AppMethodBeat.o(287402);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$FastLineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends MusicMvLyricView.d
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(287054);
      AppMethodBeat.o(287054);
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(287061);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 25.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(287061);
      return f;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineNoSmoothScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForDeceleration", "", "dx", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends MusicMvLyricView.d
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(287056);
      AppMethodBeat.o(287056);
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(287073);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 0.1F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(287073);
      return f;
    }
    
    public final int fO(int paramInt)
    {
      return 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LineScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;Landroid/content/Context;)V", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class d
    extends o
  {
    public d()
    {
      super();
      AppMethodBeat.i(287080);
      AppMethodBeat.o(287080);
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(287092);
      s.u(paramView, "targetView");
      s.u(params, "state");
      s.u(parama, "action");
      int i;
      int j;
      if (MusicMvLyricView.d(MusicMvLyricView.this))
      {
        params = MusicMvLyricView.this.getLyricRv();
        if (params == null) {}
        int k;
        int m;
        for (i = 0;; i = params.getHeight())
        {
          j = paramView.getTop();
          k = paramView.getBottom();
          m = com.tencent.mm.cd.a.fromDPToPix(MusicMvLyricView.this.getContext(), 75);
          if (j >= m) {
            break;
          }
          i = m - j;
          j = fO(i);
          parama.a(0, -i, j, (Interpolator)this.bXY);
          AppMethodBeat.o(287092);
          return;
        }
        if (i - k < m)
        {
          i = i - m - k;
          j = fO(i);
          parama.a(0, -i, j, (Interpolator)this.bXY);
          AppMethodBeat.o(287092);
        }
      }
      else
      {
        params = new int[2];
        WxRecyclerView localWxRecyclerView = MusicMvLyricView.this.getLyricRv();
        if (localWxRecyclerView != null) {
          localWxRecyclerView.getLocationInWindow(params);
        }
        i = (int)(MusicMvLyricView.this.getHeight() * 0.37F) - params[1] - paramView.getTop() + MusicMvLyricView.grB();
        j = fO(i);
        parama.a(0, -i, j, (Interpolator)this.bXY);
      }
      AppMethodBeat.o(287092);
    }
    
    public float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(287097);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 300.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(287097);
      return f;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "", "time", "", "text", "", "playing", "", "(JLjava/lang/String;Z)V", "getPlaying", "()Z", "setPlaying", "(Z)V", "<set-?>", "getText", "()Ljava/lang/String;", "getTime", "()J", "compareTo", "", "entry", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Comparable<e>
  {
    boolean cJs;
    String text;
    long time;
    
    public e(long paramLong, String paramString)
    {
      AppMethodBeat.i(287082);
      this.time = paramLong;
      this.text = paramString;
      this.cJs = false;
      AppMethodBeat.o(287082);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "lyricInfo", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;)V", "getLyricInfo", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$LyricInfo;", "getItemId", "", "getItemType", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvLyricView.e MiL;
    
    public f(MusicMvLyricView.e parame)
    {
      AppMethodBeat.i(287059);
      this.MiL = parame;
      AppMethodBeat.o(287059);
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(287065);
      long l = this.MiL.hashCode();
      AppMethodBeat.o(287065);
      return l;
    }
    
    public final int bZB()
    {
      return 7;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class g
    extends f<MusicMvLyricView.f>
  {
    public g()
    {
      AppMethodBeat.i(287067);
      AppMethodBeat.o(287067);
    }
    
    private static final void b(MusicMvLyricView paramMusicMvLyricView, View paramView)
    {
      AppMethodBeat.i(287076);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramMusicMvLyricView);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramMusicMvLyricView, "this$0");
      paramView = k.aeZF;
      paramMusicMvLyricView = paramMusicMvLyricView.getContext();
      s.s(paramMusicMvLyricView, "context");
      ((h)k.nq(paramMusicMvLyricView).q(h.class)).gqJ();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$MusicMvLyricConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287076);
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(287096);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramj, "holder");
      AppMethodBeat.o(287096);
    }
    
    public final int getLayoutId()
    {
      return b.f.LVz;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "", "onBackClick", "", "onDragged", "onLineClick", "position", "", "time", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface h
  {
    public abstract void eft();
    
    public abstract void gqK();
    
    public abstract void sL(long paramLong);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements g
  {
    i(MusicMvLyricView paramMusicMvLyricView) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(287146);
      Log.i("MicroMsg.MusicMvCommentView", s.X("getItemConvert, type:", Integer.valueOf(paramInt)));
      f localf = (f)new MusicMvLyricView.g(this.MiK);
      AppMethodBeat.o(287146);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(287176);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int j = RecyclerView.bA(paramView);
      paramView = paramRecyclerView.getAdapter();
      if (paramView == null) {}
      for (int i = 0; j == 0; i = paramView.getItemCount())
      {
        paramRect.top = MusicMvLyricView.grD();
        AppMethodBeat.o(287176);
        return;
      }
      if (j == i - 1)
      {
        paramRect.top = MusicMvLyricView.grB();
        paramRect.bottom = MusicMvLyricView.grD();
        AppMethodBeat.o(287176);
        return;
      }
      paramRect.top = MusicMvLyricView.grB();
      AppMethodBeat.o(287176);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements i.c<j>
  {
    k(MusicMvLyricView paramMusicMvLyricView) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    extends RecyclerView.l
  {
    l(MusicMvLyricView paramMusicMvLyricView) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(287183);
      Object localObject = new b();
      ((b)localObject).cH(paramRecyclerView);
      ((b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if ((!MusicMvLyricView.d(this.MiK)) && (paramInt == 1))
      {
        MusicMvLyricView.a(this.MiK, true);
        paramRecyclerView = this.MiK.getEventListener();
        if (paramRecyclerView != null) {
          paramRecyclerView.gqK();
        }
      }
      paramRecyclerView = MusicMvLyricView.c(this.MiK);
      if (paramRecyclerView != null)
      {
        paramInt = paramRecyclerView.Ju();
        paramRecyclerView = this.MiK;
        localObject = paramRecyclerView.getLyricRv();
        if (localObject != null)
        {
          localObject = ((WxRecyclerView)localObject).fU(paramInt);
          if (localObject != null)
          {
            localObject = ((RecyclerView.v)localObject).caK;
            if (localObject != null) {
              ((View)localObject).getLocationOnScreen(paramRecyclerView.getFirstVisibleItemPos());
            }
          }
        }
      }
      paramRecyclerView = MusicMvLyricView.c(this.MiK);
      if (paramRecyclerView != null)
      {
        paramInt = paramRecyclerView.Jw();
        paramRecyclerView = this.MiK;
        localObject = paramRecyclerView.getLyricRv();
        if (localObject != null)
        {
          localObject = ((WxRecyclerView)localObject).fU(paramInt);
          if (localObject != null)
          {
            localObject = ((RecyclerView.v)localObject).caK;
            if (localObject != null) {
              ((View)localObject).getLocationOnScreen(paramRecyclerView.getLastVisibleItemPos());
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(287183);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287187);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(287187);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<ah>
  {
    m(MusicMvLyricView paramMusicMvLyricView, long paramLong, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView
 * JD-Core Version:    0.7.0.1
 */