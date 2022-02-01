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
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.b;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.i
{
  public static final a LNv;
  private static final String TAG = "MicroMsg.StoryHintProxy";
  private boolean LNc;
  private int LNd;
  private int LNe;
  private Drawable LNf;
  private Drawable LNg;
  private int LNh;
  private int LNi;
  private int LNj;
  private float LNk;
  private float LNl;
  private float LNm;
  private Paint LNn;
  private View LNo;
  private final com.tencent.mm.plugin.story.a.b LNp;
  private int LNq;
  private final int LNr;
  private final b LNs;
  private com.tencent.mm.plugin.story.api.i.a LNt;
  private final View.OnClickListener LNu;
  private final Context context;
  private View.OnClickListener kte;
  private int pageType;
  private WeakReference<Context> sFh;
  private String userName;
  
  static
  {
    AppMethodBeat.i(119377);
    LNv = new a((byte)0);
    TAG = "MicroMsg.StoryHintProxy";
    AppMethodBeat.o(119377);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(119376);
    this.context = paramContext;
    this.pageType = -1;
    this.LNp = new com.tencent.mm.plugin.story.a.b();
    this.LNq = -1;
    this.LNs = new b(this);
    this.LNu = ((View.OnClickListener)new c(this));
    AppMethodBeat.o(119376);
  }
  
  private void ged()
  {
    AppMethodBeat.i(119374);
    if (this.LNo != null)
    {
      Object localObject1 = this.LNp.LEr;
      if (localObject1 == null) {
        p.iCn();
      }
      ((AnimatorSet)localObject1).cancel();
      localObject1 = this.LNp;
      Object localObject2 = this.LNo;
      if (localObject2 == null) {
        p.iCn();
      }
      ((com.tencent.mm.plugin.story.a.b)localObject1).gV((View)localObject2);
      localObject1 = this.LNp;
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).LEr;
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((AnimatorSet)localObject2).getChildAnimations().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Animator localAnimator = (Animator)((Iterator)localObject2).next();
        if ((localAnimator instanceof ValueAnimator))
        {
          ((ValueAnimator)localAnimator).setRepeatCount(((com.tencent.mm.plugin.story.a.a)localObject1).LEs);
          ((ValueAnimator)localAnimator).setRepeatMode(((com.tencent.mm.plugin.story.a.a)localObject1).LEt);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).LEr;
      if (localObject2 == null) {
        p.iCn();
      }
      ((AnimatorSet)localObject2).setDuration(((com.tencent.mm.plugin.story.a.a)localObject1).mDuration);
      localObject1 = ((com.tencent.mm.plugin.story.a.a)localObject1).LEr;
      if (localObject1 == null) {
        p.iCn();
      }
      ((AnimatorSet)localObject1).start();
      MMHandlerThread.postToMainThreadDelayed((Runnable)new d(this), 150L);
    }
    AppMethodBeat.o(119374);
  }
  
  private final void report()
  {
    AppMethodBeat.i(119373);
    Object localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    localObject = com.tencent.mm.plugin.story.h.h.geE();
    if (this.LNc) {}
    for (long l = 1L;; l = 0L)
    {
      ((lx)localObject).wo(l);
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      localObject = com.tencent.mm.plugin.story.h.h.geE();
      com.tencent.mm.plugin.story.h.i.a locala = com.tencent.mm.plugin.story.h.i.LOK;
      ((lx)localObject).wn(com.tencent.mm.plugin.story.h.i.a.ais(this.pageType));
      AppMethodBeat.o(119373);
      return;
    }
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119371);
    p.k(paramCanvas, "canvas");
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(119371);
      return;
    }
    View localView = this.LNo;
    if (localView != null)
    {
      int i = (localView.getWidth() - this.LNj) / 2;
      if (localView.getWidth() > this.LNj)
      {
        this.LNl = (this.LNj + i);
        this.LNk = i;
      }
      if (this.LNc)
      {
        localObject = this.LNn;
        if (localObject != null) {
          ((Paint)localObject).setColor(paramInt);
        }
        localObject = this.LNn;
        if (localObject != null) {
          paramCanvas.drawCircle(localView.getWidth() - this.LNm, this.LNm, this.LNm, (Paint)localObject);
        }
        if (!paramBoolean) {
          break label283;
        }
        if (this.LNf == null)
        {
          localObject = com.tencent.mm.kernel.h.ag(e.class);
          p.j(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().zn(true);
          this.LNf = ((Drawable)localObject);
          p.j(localObject, "drawable");
          this.LNi = ((Drawable)localObject).getBounds().right;
          this.LNh = ((Drawable)localObject).getBounds().bottom;
        }
      }
      for (Object localObject = this.LNf;; localObject = this.LNg)
      {
        paramCanvas.save();
        paramCanvas.translate(localView.getWidth() - this.LNi - this.LNd, this.LNe);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
        paramCanvas.restore();
        AppMethodBeat.o(119371);
        return;
        label283:
        if (this.LNg == null)
        {
          localObject = com.tencent.mm.kernel.h.ag(e.class);
          p.j(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().zn(false);
          this.LNg = ((Drawable)localObject);
          p.j(localObject, "drawable");
          this.LNi = ((Drawable)localObject).getBounds().right;
          this.LNh = ((Drawable)localObject).getBounds().bottom;
        }
      }
    }
    AppMethodBeat.o(119371);
  }
  
  public final void g(View paramView)
  {
    AppMethodBeat.i(119370);
    p.k(paramView, "host");
    this.LNo = paramView;
    this.LNd = com.tencent.mm.ci.a.fromDPToPix(this.context, 2);
    this.LNe = com.tencent.mm.ci.a.fromDPToPix(this.context, 2);
    this.LNm = com.tencent.mm.ci.a.fromDPToPix(this.context, 6);
    this.LNj = paramView.getResources().getDimensionPixelSize(a.b.SmallAvatarSize);
    this.LNn = new Paint();
    paramView = this.LNn;
    if (paramView != null) {
      paramView.setAntiAlias(true);
    }
    paramView = this.LNn;
    if (paramView != null) {
      paramView.setAlpha(0);
    }
    paramView = this.LNn;
    if (paramView != null) {
      paramView.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }
    paramView = MMApplicationContext.getContext();
    p.j(paramView, "MMApplicationContext.getContext()");
    this.LNq = paramView.getResources().getColor(a.a.Lzh);
    AppMethodBeat.o(119370);
  }
  
  public final View.OnClickListener gbx()
  {
    return this.LNu;
  }
  
  public final void gp(String paramString, int paramInt)
  {
    this.userName = paramString;
    this.pageType = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != this.LNu) {
      this.kte = paramOnClickListener;
    }
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(119372);
    if (com.tencent.mm.plugin.sns.f.a.aZB(this.userName)) {
      paramBoolean = false;
    }
    if (this.LNc != paramBoolean)
    {
      this.LNc = paramBoolean;
      View localView = this.LNo;
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
    p.k(paramContext, "context");
    this.sFh = new WeakReference(paramContext);
    AppMethodBeat.o(119375);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
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
      while ((localObject != null) && ((paramMessage.obj instanceof View)) && (paramMessage.what == b.a(this.LNw)))
      {
        localObject = b.b(this.LNw);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements View.OnClickListener
  {
    private long JfM;
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119368);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      p.k(paramView, "view");
      long l = Util.nowMilliSecond();
      b.c(this.LNw).removeMessages(b.a(this.LNw));
      b.c(this.LNw).sendMessageDelayed(b.c(this.LNw).obtainMessage(b.a(this.LNw), paramView), ViewConfiguration.getDoubleTapTimeout());
      Log.d(b.access$getTAG$cp(), "onClick lastClick=%s now=%s", new Object[] { Long.valueOf(this.JfM), Long.valueOf(l) });
      if (l - this.JfM < ViewConfiguration.getDoubleTapTimeout())
      {
        b.c(this.LNw).removeMessages(b.a(this.LNw));
        b.d(this.LNw);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119368);
        return;
      }
      this.JfM = l;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119368);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(119369);
      b.gee();
      AppMethodBeat.o(119369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b
 * JD-Core Version:    0.7.0.1
 */