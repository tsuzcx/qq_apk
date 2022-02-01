package com.tencent.mm.plugin.story.proxy;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.i
{
  public static final b.a Fts;
  private static final String TAG = "MicroMsg.StoryHintProxy";
  private boolean FsZ;
  private int Fta;
  private int Ftb;
  private Drawable Ftc;
  private Drawable Ftd;
  private int Fte;
  private int Ftf;
  private int Ftg;
  private float Fth;
  private float Fti;
  private float Ftj;
  private Paint Ftk;
  private View Ftl;
  private final com.tencent.mm.plugin.story.a.b Ftm;
  private int Ftn;
  private final int Fto;
  private final b Ftp;
  private com.tencent.mm.plugin.story.api.i.a Ftq;
  private final View.OnClickListener Ftr;
  private final Context context;
  private View.OnClickListener hEZ;
  private WeakReference<Context> ooi;
  private int pageType;
  private String userName;
  
  static
  {
    AppMethodBeat.i(119377);
    Fts = new b.a((byte)0);
    TAG = "MicroMsg.StoryHintProxy";
    AppMethodBeat.o(119377);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(119376);
    this.context = paramContext;
    this.pageType = -1;
    this.Ftm = new com.tencent.mm.plugin.story.a.b();
    this.Ftn = -1;
    this.Ftp = new b(this);
    this.Ftr = ((View.OnClickListener)new c(this));
    AppMethodBeat.o(119376);
  }
  
  private void fpJ()
  {
    AppMethodBeat.i(119374);
    if (this.Ftl != null)
    {
      Object localObject1 = this.Ftm.Fkp;
      if (localObject1 == null) {
        p.hyc();
      }
      ((AnimatorSet)localObject1).cancel();
      localObject1 = this.Ftm;
      Object localObject2 = this.Ftl;
      if (localObject2 == null) {
        p.hyc();
      }
      ((com.tencent.mm.plugin.story.a.b)localObject1).fO((View)localObject2);
      localObject1 = this.Ftm;
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).Fkp;
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = ((AnimatorSet)localObject2).getChildAnimations().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Animator localAnimator = (Animator)((Iterator)localObject2).next();
        if ((localAnimator instanceof ValueAnimator))
        {
          ((ValueAnimator)localAnimator).setRepeatCount(((com.tencent.mm.plugin.story.a.a)localObject1).Fkq);
          ((ValueAnimator)localAnimator).setRepeatMode(((com.tencent.mm.plugin.story.a.a)localObject1).Fkr);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).Fkp;
      if (localObject2 == null) {
        p.hyc();
      }
      ((AnimatorSet)localObject2).setDuration(((com.tencent.mm.plugin.story.a.a)localObject1).mDuration);
      localObject1 = ((com.tencent.mm.plugin.story.a.a)localObject1).Fkp;
      if (localObject1 == null) {
        p.hyc();
      }
      ((AnimatorSet)localObject1).start();
      MMHandlerThread.postToMainThreadDelayed((Runnable)new d(this), 150L);
    }
    AppMethodBeat.o(119374);
  }
  
  private final void report()
  {
    AppMethodBeat.i(119373);
    Object localObject = h.FuH;
    localObject = h.fqi();
    if (this.FsZ) {}
    for (long l = 1L;; l = 0L)
    {
      ((jo)localObject).sm(l);
      localObject = h.FuH;
      localObject = h.fqi();
      com.tencent.mm.plugin.story.h.i.a locala = com.tencent.mm.plugin.story.h.i.FuI;
      ((jo)localObject).sl(com.tencent.mm.plugin.story.h.i.a.aaX(this.pageType));
      AppMethodBeat.o(119373);
      return;
    }
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119371);
    p.h(paramCanvas, "canvas");
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(119371);
      return;
    }
    View localView = this.Ftl;
    if (localView != null)
    {
      int i = (localView.getWidth() - this.Ftg) / 2;
      if (localView.getWidth() > this.Ftg)
      {
        this.Fti = (this.Ftg + i);
        this.Fth = i;
      }
      if (this.FsZ)
      {
        localObject = this.Ftk;
        if (localObject != null) {
          ((Paint)localObject).setColor(paramInt);
        }
        localObject = this.Ftk;
        if (localObject != null) {
          paramCanvas.drawCircle(localView.getWidth() - this.Ftj, this.Ftj, this.Ftj, (Paint)localObject);
        }
        if (!paramBoolean) {
          break label283;
        }
        if (this.Ftc == null)
        {
          localObject = g.ah(e.class);
          p.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().vJ(true);
          this.Ftc = ((Drawable)localObject);
          p.g(localObject, "drawable");
          this.Ftf = ((Drawable)localObject).getBounds().right;
          this.Fte = ((Drawable)localObject).getBounds().bottom;
        }
      }
      for (Object localObject = this.Ftc;; localObject = this.Ftd)
      {
        paramCanvas.save();
        paramCanvas.translate(localView.getWidth() - this.Ftf - this.Fta, this.Ftb);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
        paramCanvas.restore();
        AppMethodBeat.o(119371);
        return;
        label283:
        if (this.Ftd == null)
        {
          localObject = g.ah(e.class);
          p.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().vJ(false);
          this.Ftd = ((Drawable)localObject);
          p.g(localObject, "drawable");
          this.Ftf = ((Drawable)localObject).getBounds().right;
          this.Fte = ((Drawable)localObject).getBounds().bottom;
        }
      }
    }
    AppMethodBeat.o(119371);
  }
  
  public final void ba(View paramView)
  {
    AppMethodBeat.i(119370);
    p.h(paramView, "host");
    this.Ftl = paramView;
    this.Fta = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
    this.Ftb = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
    this.Ftj = com.tencent.mm.cb.a.fromDPToPix(this.context, 6);
    this.Ftg = paramView.getResources().getDimensionPixelSize(2131165578);
    this.Ftk = new Paint();
    paramView = this.Ftk;
    if (paramView != null) {
      paramView.setAntiAlias(true);
    }
    paramView = this.Ftk;
    if (paramView != null) {
      paramView.setAlpha(0);
    }
    paramView = this.Ftk;
    if (paramView != null) {
      paramView.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }
    paramView = MMApplicationContext.getContext();
    p.g(paramView, "MMApplicationContext.getContext()");
    this.Ftn = paramView.getResources().getColor(2131101223);
    AppMethodBeat.o(119370);
  }
  
  public final void fL(String paramString, int paramInt)
  {
    this.userName = paramString;
    this.pageType = paramInt;
  }
  
  public final View.OnClickListener fne()
  {
    return this.Ftr;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != this.Ftr) {
      this.hEZ = paramOnClickListener;
    }
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(119372);
    if (com.tencent.mm.plugin.sns.f.a.aOF(this.userName)) {
      paramBoolean = false;
    }
    if (this.FsZ != paramBoolean)
    {
      this.FsZ = paramBoolean;
      View localView = this.Ftl;
      if (localView != null)
      {
        localView.invalidate();
        AppMethodBeat.o(119372);
        return;
      }
    }
    AppMethodBeat.o(119372);
  }
  
  public final void setWeakContext(Context paramContext)
  {
    AppMethodBeat.i(119375);
    p.h(paramContext, "context");
    this.ooi = new WeakReference(paramContext);
    AppMethodBeat.o(119375);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
  public static final class b
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(119367);
      Object localObject;
      if (paramMessage != null) {
        localObject = paramMessage.obj;
      }
      while ((localObject != null) && ((paramMessage.obj instanceof View)) && (paramMessage.what == b.a(this.Ftt)))
      {
        localObject = b.b(this.Ftt);
        if (localObject != null)
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(119367);
            throw paramMessage;
            localObject = null;
          }
          else
          {
            ((View.OnClickListener)localObject).onClick((View)paramMessage);
            AppMethodBeat.o(119367);
            return;
          }
        }
      }
      AppMethodBeat.o(119367);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements View.OnClickListener
  {
    private long Dal;
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119368);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      p.h(paramView, "view");
      long l = Util.nowMilliSecond();
      b.c(this.Ftt).removeMessages(b.a(this.Ftt));
      b.c(this.Ftt).sendMessageDelayed(b.c(this.Ftt).obtainMessage(b.a(this.Ftt), paramView), ViewConfiguration.getDoubleTapTimeout());
      Log.d(b.access$getTAG$cp(), "onClick lastClick=%s now=%s", new Object[] { Long.valueOf(this.Dal), Long.valueOf(l) });
      if (l - this.Dal < ViewConfiguration.getDoubleTapTimeout())
      {
        b.c(this.Ftt).removeMessages(b.a(this.Ftt));
        b.d(this.Ftt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119368);
        return;
      }
      this.Dal = l;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119368);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(119369);
      b.fpK();
      AppMethodBeat.o(119369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b
 * JD-Core Version:    0.7.0.1
 */