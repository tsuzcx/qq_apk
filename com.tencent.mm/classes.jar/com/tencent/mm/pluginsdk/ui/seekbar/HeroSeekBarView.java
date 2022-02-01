package com.tencent.mm.pluginsdk.ui.seekbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.af.a.a;
import com.tencent.mm.plugin.af.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aw;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentTimeTxt", "Landroid/widget/TextView;", "getCurrentTimeTxt", "()Landroid/widget/TextView;", "currentTimeTxt$delegate", "Lkotlin/Lazy;", "heroSeekBar", "Landroid/widget/SeekBar;", "getHeroSeekBar", "()Landroid/widget/SeekBar;", "heroSeekBar$delegate", "heroSeekBarChangeListener", "Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$OnHeroSeekBarChangeListener;", "getHeroSeekBarChangeListener", "()Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$OnHeroSeekBarChangeListener;", "setHeroSeekBarChangeListener", "(Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$OnHeroSeekBarChangeListener;)V", "hideTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "isSeekBarActive", "", "jumpSeekAnimation", "lastProgressMs", "", "lastUpdateTimeStamp", "local", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "totalTimeMs", "totalTimeText", "getTotalTimeText", "totalTimeText$delegate", "userSeekProgress", "userTouching", "videoPlayDurationProvider", "Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$VideoPlayDurationProvider;", "getVideoPlayDurationProvider", "()Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$VideoPlayDurationProvider;", "setVideoPlayDurationProvider", "(Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$VideoPlayDurationProvider;)V", "formatTime", "", "timeMs", "showSecond", "getProgressTimeMs", "progress", "getSnsVideoShowSeekBarDurationMs", "getSuggestUpdateInterval", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "prepare", "", "release", "reset", "setEnableDrag", "drag", "setHeroProgressDrawable", "resId", "setTotalTimeMs", "updateCurrentProgress", "animation", "updateCurrentText", "updateCurrentTimeMs", "Companion", "OnHeroSeekBarChangeListener", "VideoPlayDurationProvider", "plugin-playvideo_release"})
public final class HeroSeekBarView
  extends LinearLayout
{
  public static final HeroSeekBarView.a RrA;
  public com.tencent.e.i.d<?> BkJ;
  private final f Rrn;
  private final f Rro;
  private final f Rrp;
  private long Rrq;
  private int Rrr;
  private boolean Rrs;
  private int Rrt;
  private long Rru;
  private long Rrv;
  private volatile boolean Rrw;
  private b Rrx;
  private c Rry;
  public boolean Rrz;
  public final ak rcY;
  
  static
  {
    AppMethodBeat.i(204639);
    RrA = new HeroSeekBarView.a((byte)0);
    AppMethodBeat.o(204639);
  }
  
  public HeroSeekBarView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204638);
    this.Rrn = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.Rro = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.Rrp = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.Rrr = -1;
    this.rcY = al.iRe();
    LayoutInflater.from(paramContext).inflate(a.c.hero_seekbar_layout, (ViewGroup)this, true);
    setOnClickListener((View.OnClickListener)HeroSeekBarView.1.RrB);
    getHeroSeekBar().setMax(2500);
    getHeroSeekBar().setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(204951);
        paramAnonymousSeekBar = this.RrC.getHeroSeekBarChangeListener();
        if (paramAnonymousSeekBar != null) {
          paramAnonymousSeekBar.bg(paramAnonymousInt, paramAnonymousBoolean);
        }
        if (paramAnonymousBoolean)
        {
          HeroSeekBarView.a(this.RrC, paramAnonymousInt);
          HeroSeekBarView.b(this.RrC, HeroSeekBarView.d(this.RrC) * paramAnonymousInt);
          HeroSeekBarView.b(this.RrC, paramAnonymousInt);
        }
        AppMethodBeat.o(204951);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(204953);
        HeroSeekBarView.a(this.RrC, true);
        HeroSeekBarView.e(this.RrC);
        paramAnonymousSeekBar = HeroSeekBarView.f(this.RrC);
        if (paramAnonymousSeekBar != null) {
          paramAnonymousSeekBar.cancel(true);
        }
        HeroSeekBarView.c(this.RrC, a.a.hero_seekbar_drawable_select);
        HeroSeekBarView.g(this.RrC).setVisibility(0);
        HeroSeekBarView.h(this.RrC).setVisibility(0);
        HeroSeekBarView.i(this.RrC).setPressed(true);
        HeroSeekBarView.i(this.RrC).setProgressDrawable(com.tencent.mm.ci.a.m(paramContext, a.a.hero_seekbar_drawable_select));
        HeroSeekBarView.i(this.RrC).setThumb(com.tencent.mm.ci.a.m(paramContext, a.a.hero_thumb_press));
        paramAnonymousSeekBar = this.RrC.getHeroSeekBarChangeListener();
        if (paramAnonymousSeekBar != null)
        {
          HeroSeekBarView.c(this.RrC);
          paramAnonymousSeekBar.fUw();
          AppMethodBeat.o(204953);
          return;
        }
        AppMethodBeat.o(204953);
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(204954);
        HeroSeekBarView.a(this.RrC, false);
        paramAnonymousSeekBar = this.RrC.getHeroSeekBarChangeListener();
        if (paramAnonymousSeekBar != null) {
          paramAnonymousSeekBar.agT(HeroSeekBarView.c(this.RrC));
        }
        paramAnonymousSeekBar = HeroSeekBarView.f(this.RrC);
        if (paramAnonymousSeekBar != null) {
          paramAnonymousSeekBar.cancel(true);
        }
        HeroSeekBarView.a(this.RrC, com.tencent.e.h.ZvG.n((Runnable)new a(this), 3000L));
        AppMethodBeat.o(204954);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(HeroSeekBarView.2 param2) {}
        
        public final void run()
        {
          AppMethodBeat.i(204848);
          HeroSeekBarView.c(this.RrD.RrC, a.a.hero_seekbar_drawable_normal);
          HeroSeekBarView.g(this.RrD.RrC).setVisibility(4);
          HeroSeekBarView.h(this.RrD.RrC).setVisibility(4);
          HeroSeekBarView.i(this.RrD.RrC).setProgressDrawable(com.tencent.mm.ci.a.m(this.RrD.$context, a.a.hero_seekbar_drawable_normal));
          HeroSeekBarView.i(this.RrD.RrC).setThumb(com.tencent.mm.ci.a.m(this.RrD.$context, a.a.hero_thumb_normal));
          HeroSeekBarView.d(this.RrD.RrC, HeroSeekBarView.j(this.RrD.RrC));
          HeroSeekBarView.e(this.RrD.RrC);
          AppMethodBeat.o(204848);
        }
      }
    });
    AppMethodBeat.o(204638);
  }
  
  private static String TW(long paramLong)
  {
    AppMethodBeat.i(204635);
    paramLong = kotlin.h.a.N(paramLong * 1.0D / 1000.0D);
    String str = new SimpleDateFormat("mm:ss", Locale.getDefault()).format(new Date(paramLong * 1000L));
    p.j(str, "dataFormat.format(Date(roundeTime))");
    AppMethodBeat.o(204635);
    return str;
  }
  
  private final void aqN(int paramInt)
  {
    AppMethodBeat.i(204632);
    this.Rrt = paramInt;
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (Math.abs(paramInt - getHeroSeekBar().getProgress()) > 10) {
        this.Rrs = true;
      }
      getHeroSeekBar().setProgress(paramInt, false);
      this.Rrs = false;
      AppMethodBeat.o(204632);
      return;
    }
    getHeroSeekBar().setProgress(paramInt);
    AppMethodBeat.o(204632);
  }
  
  private final void aqP(int paramInt)
  {
    AppMethodBeat.i(204634);
    getCurrentTimeTxt().setText((CharSequence)TW(this.Rrq * paramInt / 2500L));
    AppMethodBeat.o(204634);
  }
  
  private final TextView getCurrentTimeTxt()
  {
    AppMethodBeat.i(204622);
    TextView localTextView = (TextView)this.Rrn.getValue();
    AppMethodBeat.o(204622);
    return localTextView;
  }
  
  private final SeekBar getHeroSeekBar()
  {
    AppMethodBeat.i(204624);
    SeekBar localSeekBar = (SeekBar)this.Rrp.getValue();
    AppMethodBeat.o(204624);
    return localSeekBar;
  }
  
  private final int getSnsVideoShowSeekBarDurationMs()
  {
    AppMethodBeat.i(204628);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNt, 16000);
    Log.i("MicroMsg.HeroSeekBarView", "getSnsVideoShowSeekBarDurationMs: ".concat(String.valueOf(i)));
    AppMethodBeat.o(204628);
    return i;
  }
  
  private final TextView getTotalTimeText()
  {
    AppMethodBeat.i(204623);
    TextView localTextView = (TextView)this.Rro.getValue();
    AppMethodBeat.o(204623);
    return localTextView;
  }
  
  private final void setHeroProgressDrawable(int paramInt)
  {
    AppMethodBeat.i(204636);
    Drawable localDrawable = getResources().getDrawable(paramInt);
    Object localObject = getHeroSeekBar().getProgressDrawable();
    p.j(localObject, "heroSeekBar.progressDrawable");
    localObject = ((Drawable)localObject).getBounds();
    p.j(localObject, "heroSeekBar.progressDrawable.bounds");
    getHeroSeekBar().setProgressDrawable(localDrawable);
    localDrawable = getHeroSeekBar().getProgressDrawable();
    p.j(localDrawable, "heroSeekBar.progressDrawable");
    localDrawable.setBounds((Rect)localObject);
    AppMethodBeat.o(204636);
  }
  
  public final long aqO(int paramInt)
  {
    return paramInt * this.Rrq / 2500L;
  }
  
  public final b getHeroSeekBarChangeListener()
  {
    return this.Rrx;
  }
  
  public final int getSuggestUpdateInterval()
  {
    int j = 16;
    AppMethodBeat.i(204631);
    int i;
    if (getVisibility() == 0)
    {
      i = (int)(this.Rrq / 1000L);
      if (i > 16) {
        break label49;
      }
      i = j;
    }
    label49:
    for (;;)
    {
      AppMethodBeat.o(204631);
      return i;
      i = 500;
      break;
    }
  }
  
  public final c getVideoPlayDurationProvider()
  {
    return this.Rry;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204626);
    super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(204626);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(204637);
    kotlinx.coroutines.g.b(this.rcY, null, (m)new g(this, null), 3);
    Log.i("MicroMsg.HeroSeekBarView", "reset");
    AppMethodBeat.o(204637);
  }
  
  public final void setEnableDrag(boolean paramBoolean)
  {
    AppMethodBeat.i(204627);
    Log.i("MicroMsg.HeroSeekBarView", "setEnableDrag ".concat(String.valueOf(paramBoolean)));
    getHeroSeekBar().setEnabled(paramBoolean);
    AppMethodBeat.o(204627);
  }
  
  public final void setHeroSeekBarChangeListener(b paramb)
  {
    this.Rrx = paramb;
  }
  
  public final void setTotalTimeMs(long paramLong)
  {
    AppMethodBeat.i(204629);
    Log.i("MicroMsg.HeroSeekBarView", "setTotalTimeMs ".concat(String.valueOf(paramLong)));
    this.Rrq = paramLong;
    getTotalTimeText().setText((CharSequence)TW(paramLong));
    getHeroSeekBar().getMax();
    AppMethodBeat.o(204629);
  }
  
  public final void setVideoPlayDurationProvider(c paramc)
  {
    this.Rry = paramc;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$OnHeroSeekBarChangeListener;", "", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-playvideo_release"})
  public static abstract interface b
  {
    public abstract void agT(int paramInt);
    
    public abstract void bg(int paramInt, boolean paramBoolean);
    
    public abstract void fUw();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$VideoPlayDurationProvider;", "", "getCurrentPlayTimeMs", "", "plugin-playvideo_release"})
  public static abstract interface c
  {
    public abstract long fUx();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextView>
  {
    d(HeroSeekBarView paramHeroSeekBarView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<SeekBar>
  {
    e(HeroSeekBarView paramHeroSeekBarView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class f
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    public f(HeroSeekBarView paramHeroSeekBarView, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(205007);
      p.k(paramd, "completion");
      paramd = new f(this.RrC, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(205007);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(205012);
      paramObject1 = ((f)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(205012);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(205003);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205003);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        if (HeroSeekBarView.a(this.RrC))
        {
          long l;
          if (!HeroSeekBarView.b(this.RrC))
          {
            localObject = this.RrC.getVideoPlayDurationProvider();
            if (localObject != null)
            {
              l = ((Number)kotlin.d.b.a.b.Xu(((HeroSeekBarView.c)localObject).fUx())).longValue();
              if (HeroSeekBarView.c(this.RrC) <= 0) {
                break label188;
              }
              if (l >= this.RrC.aqO(HeroSeekBarView.c(this.RrC)))
              {
                HeroSeekBarView.a(this.RrC, l);
                HeroSeekBarView.a(this.RrC, -1);
              }
            }
          }
          for (;;)
          {
            this.L$0 = paramObject;
            this.label = 1;
            if (aw.a(16L, this) != locala) {
              break;
            }
            AppMethodBeat.o(205003);
            return locala;
            HeroSeekBarView.a(this.RrC, l);
          }
        }
        break;
      case 1: 
        label188:
        localObject = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      for (;;)
      {
        break;
        paramObject = x.aazN;
        AppMethodBeat.o(205003);
        return paramObject;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class g
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    g(HeroSeekBarView paramHeroSeekBarView, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(205022);
      p.k(paramd, "completion");
      paramd = new g(this.RrC, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(205022);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(205024);
      paramObject1 = ((g)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(205024);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(205018);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205018);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      HeroSeekBarView.a(this.RrC, -1);
      paramObject = x.aazN;
      AppMethodBeat.o(205018);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<TextView>
  {
    h(HeroSeekBarView paramHeroSeekBarView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView
 * JD-Core Version:    0.7.0.1
 */