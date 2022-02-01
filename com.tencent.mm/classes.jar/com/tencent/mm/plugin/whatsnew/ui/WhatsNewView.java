package com.tencent.mm.plugin.whatsnew.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.c;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView;", "Landroid/widget/FrameLayout;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "bubblesView", "Lcom/tencent/mm/plugin/whatsnew/ui/BubblesView;", "content", "Landroid/view/ViewGroup;", "fallback", "Landroid/widget/ImageView;", "indicator", "Lcom/tencent/mm/plugin/whatsnew/ui/LegacyCircleIndicator;", "isVideoPrepared", "", "mask", "Landroid/view/View;", "onFinish", "Lkotlin/Function0;", "", "getOnFinish", "()Lkotlin/jvm/functions/Function0;", "setOnFinish", "(Lkotlin/jvm/functions/Function0;)V", "subtitlesView", "Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewSubtitlesView;", "videoFd", "Landroid/content/res/AssetFileDescriptor;", "videoView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoTextureView;", "viewPager", "Lcom/tencent/mm/ui/mogic/WxViewPager;", "animateToFinish", "animateToNext", "cancelAnimator", "fadeIn", "initVideoPlayer", "onAttachedToWindow", "onCompletion", "onDestroy", "onError", "what", "extra", "onGetVideoSize", "width", "height", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "ratio", "", "pixels", "onPageSelected", "onPlayTime", "playTime", "videoTime", "onPrepared", "onStart", "onStop", "setupViews", "Companion", "HolderAdapter", "app_release"})
public final class WhatsNewView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener, j.a
{
  private static final int[] JPs;
  public static final WhatsNewView.a JPt;
  private final ImageView JPj;
  private final VideoTextureView JPk;
  final View JPl;
  private final LegacyCircleIndicator JPm;
  private final WhatsNewSubtitlesView JPn;
  private final BubblesView JPo;
  private AssetFileDescriptor JPp;
  private boolean JPq;
  private kotlin.g.a.a<x> JPr;
  private ValueAnimator animator;
  final ViewGroup oeO;
  private final WxViewPager rnc;
  
  static
  {
    AppMethodBeat.i(231018);
    JPt = new WhatsNewView.a((byte)0);
    JPs = new int[] { 2131691805, 2131691806, 2131691807, 2131691808, 2131691809 };
    AppMethodBeat.o(231018);
  }
  
  public WhatsNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public WhatsNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(231016);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    FrameLayout.inflate(paramContext, 2131497095, (ViewGroup)this);
    paramAttributeSet = findViewById(2131304501);
    p.g(paramAttributeSet, "findViewById(R.id.mask)");
    this.JPl = paramAttributeSet;
    paramAttributeSet = findViewById(2131299180);
    p.g(paramAttributeSet, "findViewById(R.id.content)");
    this.oeO = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131309864);
    p.g(paramAttributeSet, "findViewById(R.id.view_pager)");
    this.rnc = ((WxViewPager)paramAttributeSet);
    paramAttributeSet = findViewById(2131302642);
    p.g(paramAttributeSet, "findViewById(R.id.indicator)");
    this.JPm = ((LegacyCircleIndicator)paramAttributeSet);
    paramAttributeSet = findViewById(2131308747);
    p.g(paramAttributeSet, "findViewById(R.id.subtitles)");
    this.JPn = ((WhatsNewSubtitlesView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297857);
    p.g(paramAttributeSet, "findViewById(R.id.bubbles)");
    this.JPo = ((BubblesView)paramAttributeSet);
    paramAttributeSet = findViewById(2131300428);
    p.g(paramAttributeSet, "findViewById(R.id.fallback)");
    this.JPj = ((ImageView)paramAttributeSet);
    if (Build.VERSION.SDK_INT < 28)
    {
      this.JPk = new VideoTextureView(paramContext);
      paramContext = findViewById(2131309842);
      p.g(paramContext, "findViewById(R.id.video_view_container)");
      ((RelativeLayout)paramContext).addView((View)this.JPk, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      gla();
      AppMethodBeat.o(231016);
      return;
      this.JPk = null;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void gla()
  {
    AppMethodBeat.i(231004);
    this.rnc.setAdapter((q)new WhatsNewView.b());
    this.JPm.setupViewPager(this.rnc);
    Object localObject1 = this.JPn;
    Object localObject2 = JPs;
    p.h(localObject2, "imageIds");
    ((WhatsNewSubtitlesView)localObject1).removeAllViews();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject2[i];
      WeImageView localWeImageView = new WeImageView(((WhatsNewSubtitlesView)localObject1).getContext());
      localWeImageView.setImageResource(k);
      localWeImageView.setIconColor(android.support.v4.content.b.n(((WhatsNewSubtitlesView)localObject1).getContext(), 2131099678));
      localWeImageView.setVisibility(8);
      localWeImageView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      ((WhatsNewSubtitlesView)localObject1).addView((View)localWeImageView);
      i += 1;
    }
    localObject1 = ((WhatsNewSubtitlesView)localObject1).getChildAt(0);
    p.g(localObject1, "getChildAt(0)");
    ((View)localObject1).setVisibility(0);
    localObject1 = this.JPn.getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(231004);
      throw ((Throwable)localObject1);
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).topMargin = kotlin.h.a.K(com.tencent.mm.cb.a.jo(getContext()) * 0.2D);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    ((FrameLayout.LayoutParams)localObject1).width = com.tencent.mm.cb.a.fromDPToPix(getContext(), 240);
    ((FrameLayout.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 160);
    if (com.tencent.mm.cb.a.E(getContext(), com.tencent.mm.cb.a.jn(getContext())) < 320)
    {
      ((FrameLayout.LayoutParams)localObject1).width = ((int)(((FrameLayout.LayoutParams)localObject1).width * 0.8F));
      ((FrameLayout.LayoutParams)localObject1).height = ((int)(((FrameLayout.LayoutParams)localObject1).height * 0.8F));
    }
    this.JPn.requestLayout();
    localObject1 = new c(getContext(), (GestureDetector.OnGestureListener)new h(this));
    this.rnc.setOnTouchListener((View.OnTouchListener)new WhatsNewView.g((c)localObject1));
    this.rnc.setOnPageChangeListener((ViewPager.OnPageChangeListener)this);
    if (this.JPk != null)
    {
      Log.w("MicroMsg.WhatsNewView", "use video player view, sdk_int=" + Build.VERSION.SDK_INT);
      this.JPj.setVisibility(0);
      this.JPj.setImageResource(2131235795);
      this.JPk.setVisibility(0);
      localObject1 = this.JPk;
      try
      {
        localObject2 = getResources();
        p.g(localObject2, "resources");
        this.JPp = ((Resources)localObject2).getAssets().openFd("video/wsn_background.mp4");
        ((VideoTextureView)localObject1).setVideoCallback((j.a)this);
        localObject2 = this.JPp;
        if (localObject2 != null) {
          ((VideoTextureView)localObject1).a(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
        }
        ((VideoTextureView)localObject1).setAlpha(0.0F);
        ((VideoTextureView)localObject1).setOneTimeVideoTextureUpdateCallback((j.e)new f(this, (VideoTextureView)localObject1));
        ((VideoTextureView)localObject1).setMute(true);
        ((VideoTextureView)localObject1).setScaleType(i.e.Kcc);
        AppMethodBeat.o(231004);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WhatsNewView", (Throwable)localException, "openFD error %s", new Object[] { localException.getMessage() });
        }
      }
    }
    Log.w("MicroMsg.WhatsNewView", "use bubbles view, sdk_int=" + Build.VERSION.SDK_INT);
    this.JPo.setVisibility(0);
    AppMethodBeat.o(231004);
  }
  
  private final void glb()
  {
    AppMethodBeat.i(231008);
    Log.i("MicroMsg.WhatsNewView", "animateToFinish: current=" + this.rnc.getCurrentItem());
    ValueAnimator localValueAnimator = this.animator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    float f = Math.abs(this.oeO.getTranslationX() / this.oeO.getWidth());
    localValueAnimator = ValueAnimator.ofFloat(new float[] { f, 1.0F });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new WhatsNewView.c(this, f));
    localValueAnimator.setDuration((500.0F * (1.0F - f)));
    localValueAnimator.addListener((Animator.AnimatorListener)new WhatsNewView.d(this, f));
    localValueAnimator.start();
    this.animator = localValueAnimator;
    AppMethodBeat.o(231008);
  }
  
  public final void eo(int paramInt1, int paramInt2) {}
  
  public final int fh(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final kotlin.g.a.a<x> getOnFinish()
  {
    return this.JPr;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(231015);
    super.onAttachedToWindow();
    Log.w("MicroMsg.WhatsNewView", "onAttachedToWindow");
    this.JPo.JOz = SystemClock.uptimeMillis();
    AppMethodBeat.o(231015);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(231011);
    Log.w("MicroMsg.WhatsNewView", "on video completion");
    VideoTextureView localVideoTextureView = this.JPk;
    if (localVideoTextureView != null)
    {
      localVideoTextureView.q(0.0D);
      AppMethodBeat.o(231011);
      return;
    }
    AppMethodBeat.o(231011);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(231014);
    Log.i("MicroMsg.WhatsNewView", "onDestroy");
    Object localObject = this.JPk;
    if (localObject != null) {
      ((VideoTextureView)localObject).stop();
    }
    try
    {
      localObject = this.JPp;
      if (localObject != null)
      {
        ((AssetFileDescriptor)localObject).close();
        AppMethodBeat.o(231014);
        return;
      }
      AppMethodBeat.o(231014);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WhatsNewView", (Throwable)localException, "close loopVideoAssetFD error %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(231014);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231009);
    Log.e("MicroMsg.WhatsNewView", "play video error! what: %d.", new Object[] { Integer.valueOf(paramInt1) });
    VideoTextureView localVideoTextureView = this.JPk;
    if (localVideoTextureView != null) {
      localVideoTextureView.setAlpha(0.0F);
    }
    this.JPj.setAlpha(1.0F);
    AppMethodBeat.o(231009);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(231007);
    Log.i("MicroMsg.WhatsNewView", "onPageScrollStateChanged: ".concat(String.valueOf(paramInt)));
    this.JPm.onPageScrollStateChanged(paramInt);
    if ((paramInt == 1) && (this.rnc.getCurrentItem() != JPs.length))
    {
      Object localObject1 = this.animator;
      int j;
      Object localObject2;
      if (localObject1 != null)
      {
        if (((ValueAnimator)localObject1).isRunning() == true)
        {
          localObject1 = this.animator;
          if (localObject1 != null) {
            ((ValueAnimator)localObject1).cancel();
          }
          localObject1 = this.JPn;
          j = this.rnc.getCurrentItem();
          h.ez("select ".concat(String.valueOf(j)));
          Object localObject3 = (Iterable)kotlin.k.j.mY(0, ((WhatsNewSubtitlesView)localObject1).getChildCount());
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            paramInt = ((ab)localObject3).nextInt();
            ((Collection)localObject2).add(((WhatsNewSubtitlesView)localObject1).getChildAt(paramInt));
          }
        }
      }
      else
      {
        AppMethodBeat.o(231007);
        return;
        localObject1 = ((Iterable)localObject2).iterator();
        paramInt = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          int i = paramInt + 1;
          if (paramInt < 0) {
            kotlin.a.j.hxH();
          }
          localObject2 = (View)localObject2;
          if (paramInt == j)
          {
            p.g(localObject2, "childView");
            ((View)localObject2).setVisibility(0);
            ((View)localObject2).setAlpha(1.0F);
            ((View)localObject2).setTranslationX(0.0F);
            paramInt = i;
          }
          else
          {
            p.g(localObject2, "childView");
            ((View)localObject2).setVisibility(8);
            paramInt = i;
          }
        }
      }
    }
    AppMethodBeat.o(231007);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(231005);
    Log.i("MicroMsg.WhatsNewView", "onPageScrolled: " + paramInt1 + ", " + paramFloat + ", " + paramInt2);
    this.JPm.onPageScrolled(paramInt1, paramFloat, paramInt2);
    ValueAnimator localValueAnimator = this.animator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true))
    {
      AppMethodBeat.o(231005);
      return;
    }
    if (paramInt1 >= JPs.length - 1)
    {
      this.oeO.setTranslationX(-this.oeO.getWidth() * paramFloat);
      this.JPl.setAlpha(1.0F - paramFloat);
    }
    this.JPn.y(paramInt1, paramFloat);
    AppMethodBeat.o(231005);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(231006);
    Log.i("MicroMsg.WhatsNewView", "onPageSelected: ".concat(String.valueOf(paramInt)));
    this.JPm.onPageSelected(paramInt);
    ValueAnimator localValueAnimator = this.animator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true))
    {
      AppMethodBeat.o(231006);
      return;
    }
    if (paramInt >= JPs.length)
    {
      glb();
      AppMethodBeat.o(231006);
      return;
    }
    AppMethodBeat.o(231006);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(231012);
    Log.i("MicroMsg.WhatsNewView", "onStart");
    if (this.JPq)
    {
      VideoTextureView localVideoTextureView = this.JPk;
      if (localVideoTextureView != null) {
        localVideoTextureView.start();
      }
    }
    this.JPo.JOz = SystemClock.uptimeMillis();
    AppMethodBeat.o(231012);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(231013);
    Log.i("MicroMsg.WhatsNewView", "onStop");
    VideoTextureView localVideoTextureView = this.JPk;
    if (localVideoTextureView != null)
    {
      localVideoTextureView.pause();
      AppMethodBeat.o(231013);
      return;
    }
    AppMethodBeat.o(231013);
  }
  
  public final void setOnFinish(kotlin.g.a.a<x> parama)
  {
    this.JPr = parama;
  }
  
  public final void tf()
  {
    AppMethodBeat.i(231010);
    Log.i("MicroMsg.WhatsNewView", "onPrepared");
    VideoTextureView localVideoTextureView = this.JPk;
    if (localVideoTextureView != null) {
      localVideoTextureView.start();
    }
    this.JPq = true;
    AppMethodBeat.o(231010);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTextureUpdate"})
  static final class f
    implements j.e
  {
    f(WhatsNewView paramWhatsNewView, VideoTextureView paramVideoTextureView) {}
    
    public final void bLh()
    {
      AppMethodBeat.i(230997);
      Log.i("MicroMsg.WhatsNewView", "on video rendered");
      this.UtJ.setAlpha(1.0F);
      WhatsNewView.h(this.JPu).setAlpha(0.0F);
      AppMethodBeat.o(230997);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapConfirmed", "", "e", "Landroid/view/MotionEvent;", "app_release"})
  public static final class h
    extends GestureDetector.SimpleOnGestureListener
  {
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(231003);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(231003);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(231002);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(231002);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(231001);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(231001);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(230999);
      if (WhatsNewView.a(this.JPu).getCurrentItem() >= WhatsNewView.glc().length - 1) {
        WhatsNewView.b(this.JPu);
      }
      for (;;)
      {
        AppMethodBeat.o(230999);
        return true;
        WhatsNewView.c(this.JPu);
      }
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(231000);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(231000);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewView
 * JD-Core Version:    0.7.0.1
 */