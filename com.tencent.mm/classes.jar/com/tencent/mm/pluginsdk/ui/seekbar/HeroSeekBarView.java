package com.tencent.mm.pluginsdk.ui.seekbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ag.a.a;
import com.tencent.mm.plugin.ag.a.c;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentTimeTxt", "Landroid/widget/TextView;", "getCurrentTimeTxt", "()Landroid/widget/TextView;", "currentTimeTxt$delegate", "Lkotlin/Lazy;", "heroSeekBar", "Landroid/widget/SeekBar;", "getHeroSeekBar", "()Landroid/widget/SeekBar;", "heroSeekBar$delegate", "heroSeekBarChangeListener", "Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$OnHeroSeekBarChangeListener;", "getHeroSeekBarChangeListener", "()Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$OnHeroSeekBarChangeListener;", "setHeroSeekBarChangeListener", "(Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$OnHeroSeekBarChangeListener;)V", "hideTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "isSeekBarActive", "", "jumpSeekAnimation", "lastProgressMs", "", "lastUpdateTimeStamp", "local", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "totalTimeMs", "totalTimeText", "getTotalTimeText", "totalTimeText$delegate", "userSeekProgress", "userTouching", "videoPlayDurationProvider", "Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$VideoPlayDurationProvider;", "getVideoPlayDurationProvider", "()Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$VideoPlayDurationProvider;", "setVideoPlayDurationProvider", "(Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$VideoPlayDurationProvider;)V", "formatTime", "", "timeMs", "showSecond", "getProgressTimeMs", "progress", "getSnsVideoShowSeekBarDurationMs", "getSuggestUpdateInterval", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "prepare", "", "release", "reset", "setEnableDrag", "drag", "setHeroProgressDrawable", "resId", "setTotalTimeMs", "updateCurrentProgress", "animation", "updateCurrentText", "updateCurrentTimeMs", "Companion", "OnHeroSeekBarChangeListener", "VideoPlayDurationProvider", "plugin-playvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HeroSeekBarView
  extends LinearLayout
{
  public static final HeroSeekBarView.a YnE;
  public com.tencent.threadpool.i.d<?> GQB;
  private final kotlin.j YnF;
  private final kotlin.j YnG;
  private final kotlin.j YnH;
  private long YnI;
  private int YnJ;
  private boolean YnK;
  private int YnL;
  private long YnM;
  private volatile boolean YnN;
  private b YnO;
  private c YnP;
  public boolean YnQ;
  private long ntS;
  public final aq scope;
  
  static
  {
    AppMethodBeat.i(245200);
    YnE = new HeroSeekBarView.a((byte)0);
    AppMethodBeat.o(245200);
  }
  
  public HeroSeekBarView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(245135);
    this.YnF = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.YnG = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.YnH = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.YnJ = -1;
    this.scope = ar.kBZ();
    LayoutInflater.from(paramContext).inflate(a.c.hero_seekbar_layout, (ViewGroup)this, true);
    setOnClickListener(HeroSeekBarView..ExternalSyntheticLambda0.INSTANCE);
    getHeroSeekBar().setMax(2500);
    getHeroSeekBar().setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      private static final void a(HeroSeekBarView paramAnonymousHeroSeekBarView, Context paramAnonymousContext)
      {
        AppMethodBeat.i(245154);
        s.u(paramAnonymousHeroSeekBarView, "this$0");
        s.u(paramAnonymousContext, "$context");
        HeroSeekBarView.c(paramAnonymousHeroSeekBarView, a.a.hero_seekbar_drawable_normal);
        HeroSeekBarView.g(paramAnonymousHeroSeekBarView).setVisibility(4);
        HeroSeekBarView.h(paramAnonymousHeroSeekBarView).setVisibility(4);
        HeroSeekBarView.i(paramAnonymousHeroSeekBarView).setProgressDrawable(com.tencent.mm.cd.a.m(paramAnonymousContext, a.a.hero_seekbar_drawable_normal));
        HeroSeekBarView.i(paramAnonymousHeroSeekBarView).setThumb(com.tencent.mm.cd.a.m(paramAnonymousContext, a.a.hero_thumb_normal));
        HeroSeekBarView.d(paramAnonymousHeroSeekBarView, HeroSeekBarView.j(paramAnonymousHeroSeekBarView));
        HeroSeekBarView.e(paramAnonymousHeroSeekBarView);
        AppMethodBeat.o(245154);
      }
      
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(245161);
        paramAnonymousSeekBar = this.YnR.getHeroSeekBarChangeListener();
        if (paramAnonymousSeekBar != null) {
          paramAnonymousSeekBar.bN(paramAnonymousInt, paramAnonymousBoolean);
        }
        if (paramAnonymousBoolean)
        {
          HeroSeekBarView.a(this.YnR, paramAnonymousInt);
          HeroSeekBarView.b(this.YnR, HeroSeekBarView.d(this.YnR) * paramAnonymousInt);
          HeroSeekBarView.b(this.YnR, paramAnonymousInt);
        }
        AppMethodBeat.o(245161);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(245166);
        HeroSeekBarView.a(this.YnR, true);
        HeroSeekBarView.e(this.YnR);
        paramAnonymousSeekBar = HeroSeekBarView.f(this.YnR);
        if (paramAnonymousSeekBar != null) {
          paramAnonymousSeekBar.cancel(true);
        }
        HeroSeekBarView.c(this.YnR, a.a.hero_seekbar_drawable_select);
        HeroSeekBarView.g(this.YnR).setVisibility(0);
        HeroSeekBarView.h(this.YnR).setVisibility(0);
        HeroSeekBarView.i(this.YnR).setPressed(true);
        HeroSeekBarView.i(this.YnR).setProgressDrawable(com.tencent.mm.cd.a.m(paramContext, a.a.hero_seekbar_drawable_select));
        HeroSeekBarView.i(this.YnR).setThumb(com.tencent.mm.cd.a.m(paramContext, a.a.hero_thumb_press));
        paramAnonymousSeekBar = this.YnR.getHeroSeekBarChangeListener();
        if (paramAnonymousSeekBar != null)
        {
          HeroSeekBarView.c(this.YnR);
          paramAnonymousSeekBar.hmQ();
        }
        AppMethodBeat.o(245166);
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(245170);
        HeroSeekBarView.a(this.YnR, false);
        paramAnonymousSeekBar = this.YnR.getHeroSeekBarChangeListener();
        if (paramAnonymousSeekBar != null) {
          paramAnonymousSeekBar.alM(HeroSeekBarView.c(this.YnR));
        }
        paramAnonymousSeekBar = HeroSeekBarView.f(this.YnR);
        if (paramAnonymousSeekBar != null) {
          paramAnonymousSeekBar.cancel(true);
        }
        HeroSeekBarView.a(this.YnR, com.tencent.threadpool.h.ahAA.o(new HeroSeekBarView.1..ExternalSyntheticLambda0(this.YnR, paramContext), 3000L));
        AppMethodBeat.o(245170);
      }
    });
    AppMethodBeat.o(245135);
  }
  
  private final void awT(int paramInt)
  {
    AppMethodBeat.i(245153);
    this.YnL = paramInt;
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (Math.abs(paramInt - getHeroSeekBar().getProgress()) > 10) {
        this.YnK = true;
      }
      getHeroSeekBar().setProgress(paramInt, false);
      this.YnK = false;
      AppMethodBeat.o(245153);
      return;
    }
    getHeroSeekBar().setProgress(paramInt);
    AppMethodBeat.o(245153);
  }
  
  private final void awV(int paramInt)
  {
    AppMethodBeat.i(245156);
    getCurrentTimeTxt().setText((CharSequence)ym(this.YnI * paramInt / 2500L));
    AppMethodBeat.o(245156);
  }
  
  private static final void dg(View paramView)
  {
    AppMethodBeat.i(245162);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245162);
  }
  
  private final TextView getCurrentTimeTxt()
  {
    AppMethodBeat.i(245138);
    Object localObject = this.YnF.getValue();
    s.s(localObject, "<get-currentTimeTxt>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(245138);
    return localObject;
  }
  
  private final SeekBar getHeroSeekBar()
  {
    AppMethodBeat.i(245147);
    Object localObject = this.YnH.getValue();
    s.s(localObject, "<get-heroSeekBar>(...)");
    localObject = (SeekBar)localObject;
    AppMethodBeat.o(245147);
    return localObject;
  }
  
  private final int getSnsVideoShowSeekBarDurationMs()
  {
    AppMethodBeat.i(245151);
    int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfs, 16000);
    Log.i("MicroMsg.HeroSeekBarView", s.X("getSnsVideoShowSeekBarDurationMs: ", Integer.valueOf(i)));
    AppMethodBeat.o(245151);
    return i;
  }
  
  private final TextView getTotalTimeText()
  {
    AppMethodBeat.i(245142);
    Object localObject = this.YnG.getValue();
    s.s(localObject, "<get-totalTimeText>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(245142);
    return localObject;
  }
  
  private final void setHeroProgressDrawable(int paramInt)
  {
    AppMethodBeat.i(245159);
    Drawable localDrawable = getResources().getDrawable(paramInt);
    Rect localRect = getHeroSeekBar().getProgressDrawable().getBounds();
    s.s(localRect, "heroSeekBar.progressDrawable.bounds");
    getHeroSeekBar().setProgressDrawable(localDrawable);
    getHeroSeekBar().getProgressDrawable().setBounds(localRect);
    AppMethodBeat.o(245159);
  }
  
  private static String ym(long paramLong)
  {
    AppMethodBeat.i(245157);
    paramLong = kotlin.h.a.ai(paramLong * 1.0D / 1000.0D);
    String str = new SimpleDateFormat("mm:ss", Locale.getDefault()).format(new Date(paramLong * 1000L));
    s.s(str, "dataFormat.format(Date(roundeTime))");
    AppMethodBeat.o(245157);
    return str;
  }
  
  public final long awU(int paramInt)
  {
    return paramInt * this.YnI / 2500L;
  }
  
  public final b getHeroSeekBarChangeListener()
  {
    return this.YnO;
  }
  
  public final int getSuggestUpdateInterval()
  {
    int j = 16;
    AppMethodBeat.i(245216);
    int i;
    if (getVisibility() == 0)
    {
      i = (int)(this.YnI / 1000L);
      if (i > 16) {
        break label49;
      }
      i = j;
    }
    label49:
    for (;;)
    {
      AppMethodBeat.o(245216);
      return i;
      i = 500;
      break;
    }
  }
  
  public final c getVideoPlayDurationProvider()
  {
    return this.YnP;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(245210);
    super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(245210);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(245219);
    kotlinx.coroutines.j.a(this.scope, null, null, (m)new g(this, null), 3);
    Log.i("MicroMsg.HeroSeekBarView", "reset");
    AppMethodBeat.o(245219);
  }
  
  public final void setEnableDrag(boolean paramBoolean)
  {
    AppMethodBeat.i(245212);
    Log.i("MicroMsg.HeroSeekBarView", s.X("setEnableDrag ", Boolean.valueOf(paramBoolean)));
    getHeroSeekBar().setEnabled(paramBoolean);
    AppMethodBeat.o(245212);
  }
  
  public final void setHeroSeekBarChangeListener(b paramb)
  {
    this.YnO = paramb;
  }
  
  public final void setTotalTimeMs(long paramLong)
  {
    AppMethodBeat.i(245214);
    Log.i("MicroMsg.HeroSeekBarView", s.X("setTotalTimeMs ", Long.valueOf(paramLong)));
    this.YnI = paramLong;
    getTotalTimeText().setText((CharSequence)ym(paramLong));
    getHeroSeekBar().getMax();
    AppMethodBeat.o(245214);
  }
  
  public final void setVideoPlayDurationProvider(c paramc)
  {
    this.YnP = paramc;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$OnHeroSeekBarChangeListener;", "", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-playvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void alM(int paramInt);
    
    public abstract void bN(int paramInt, boolean paramBoolean);
    
    public abstract void hmQ();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView$VideoPlayDurationProvider;", "", "getCurrentPlayTimeMs", "", "plugin-playvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract long hmR();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<TextView>
  {
    d(HeroSeekBarView paramHeroSeekBarView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<SeekBar>
  {
    e(HeroSeekBarView paramHeroSeekBarView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public f(HeroSeekBarView paramHeroSeekBarView, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(245141);
      paramObject = (kotlin.d.d)new f(this.YnR, paramd);
      AppMethodBeat.o(245141);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(245136);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(245136);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      while (HeroSeekBarView.a(this.YnR))
      {
        long l;
        if (!HeroSeekBarView.b(this.YnR))
        {
          paramObject = this.YnR.getVideoPlayDurationProvider();
          if (paramObject != null)
          {
            l = paramObject.hmR();
            paramObject = this.YnR;
            if (HeroSeekBarView.c(paramObject) <= 0) {
              break label161;
            }
            if (l >= paramObject.awU(HeroSeekBarView.c(paramObject)))
            {
              HeroSeekBarView.a(paramObject, l);
              HeroSeekBarView.a(paramObject, -1);
            }
          }
        }
        for (;;)
        {
          paramObject = (kotlin.d.d)this;
          this.label = 1;
          if (bb.e(16L, paramObject) != locala) {
            break;
          }
          AppMethodBeat.o(245136);
          return locala;
          label161:
          HeroSeekBarView.a(paramObject, l);
        }
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(245136);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    g(HeroSeekBarView paramHeroSeekBarView, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(245143);
      paramObject = (kotlin.d.d)new g(this.YnR, paramd);
      AppMethodBeat.o(245143);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(245140);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(245140);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      HeroSeekBarView.a(this.YnR, -1);
      paramObject = ah.aiuX;
      AppMethodBeat.o(245140);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextView>
  {
    h(HeroSeekBarView paramHeroSeekBarView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView
 * JD-Core Version:    0.7.0.1
 */