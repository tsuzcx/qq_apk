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
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.i
{
  public static final b.a ARe;
  private static final String TAG = "MicroMsg.StoryHintProxy";
  private boolean AQL;
  private int AQM;
  private int AQN;
  private Drawable AQO;
  private Drawable AQP;
  private int AQQ;
  private int AQR;
  private int AQS;
  private float AQT;
  private float AQU;
  private float AQV;
  private Paint AQW;
  private View AQX;
  private final com.tencent.mm.plugin.story.a.b AQY;
  private int AQZ;
  private final int ARa;
  private final b ARb;
  private com.tencent.mm.plugin.story.api.i.a ARc;
  private final View.OnClickListener ARd;
  private final Context context;
  private View.OnClickListener gMe;
  private WeakReference<Context> mXV;
  private int pageType;
  private String userName;
  
  static
  {
    AppMethodBeat.i(119377);
    ARe = new b.a((byte)0);
    TAG = "MicroMsg.StoryHintProxy";
    AppMethodBeat.o(119377);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(119376);
    this.context = paramContext;
    this.pageType = -1;
    this.AQY = new com.tencent.mm.plugin.story.a.b();
    this.AQZ = -1;
    this.ARb = new b(this);
    this.ARd = ((View.OnClickListener)new c(this));
    AppMethodBeat.o(119376);
  }
  
  private void ejA()
  {
    AppMethodBeat.i(119374);
    if (this.AQX != null)
    {
      Object localObject1 = this.AQY.AHO;
      if (localObject1 == null) {
        p.gfZ();
      }
      ((AnimatorSet)localObject1).cancel();
      localObject1 = this.AQY;
      Object localObject2 = this.AQX;
      if (localObject2 == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.story.a.b)localObject1).fy((View)localObject2);
      localObject1 = this.AQY;
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).AHO;
      if (localObject2 == null) {
        p.gfZ();
      }
      localObject2 = ((AnimatorSet)localObject2).getChildAnimations().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Animator localAnimator = (Animator)((Iterator)localObject2).next();
        if ((localAnimator instanceof ValueAnimator))
        {
          ((ValueAnimator)localAnimator).setRepeatCount(((com.tencent.mm.plugin.story.a.a)localObject1).AHP);
          ((ValueAnimator)localAnimator).setRepeatMode(((com.tencent.mm.plugin.story.a.a)localObject1).AHQ);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).AHO;
      if (localObject2 == null) {
        p.gfZ();
      }
      ((AnimatorSet)localObject2).setDuration(((com.tencent.mm.plugin.story.a.a)localObject1).mDuration);
      localObject1 = ((com.tencent.mm.plugin.story.a.a)localObject1).AHO;
      if (localObject1 == null) {
        p.gfZ();
      }
      ((AnimatorSet)localObject1).start();
      aq.o((Runnable)new d(this), 150L);
    }
    AppMethodBeat.o(119374);
  }
  
  private final void report()
  {
    AppMethodBeat.i(119373);
    Object localObject = h.ASt;
    localObject = h.ejZ();
    if (this.AQL) {}
    for (long l = 1L;; l = 0L)
    {
      ((fy)localObject).kZ(l);
      localObject = h.ASt;
      localObject = h.ejZ();
      com.tencent.mm.plugin.story.h.i.a locala = com.tencent.mm.plugin.story.h.i.ASu;
      ((fy)localObject).kY(com.tencent.mm.plugin.story.h.i.a.Su(this.pageType));
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
    View localView = this.AQX;
    if (localView != null)
    {
      int i = (localView.getWidth() - this.AQS) / 2;
      if (localView.getWidth() > this.AQS)
      {
        this.AQU = (this.AQS + i);
        this.AQT = i;
      }
      if (this.AQL)
      {
        localObject = this.AQW;
        if (localObject != null) {
          ((Paint)localObject).setColor(paramInt);
        }
        localObject = this.AQW;
        if (localObject != null) {
          paramCanvas.drawCircle(localView.getWidth() - this.AQV, this.AQV, this.AQV, (Paint)localObject);
        }
        if (!paramBoolean) {
          break label283;
        }
        if (this.AQO == null)
        {
          localObject = g.ad(e.class);
          p.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().sh(true);
          this.AQO = ((Drawable)localObject);
          p.g(localObject, "drawable");
          this.AQR = ((Drawable)localObject).getBounds().right;
          this.AQQ = ((Drawable)localObject).getBounds().bottom;
        }
      }
      for (Object localObject = this.AQO;; localObject = this.AQP)
      {
        paramCanvas.save();
        paramCanvas.translate(localView.getWidth() - this.AQR - this.AQM, this.AQN);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
        paramCanvas.restore();
        AppMethodBeat.o(119371);
        return;
        label283:
        if (this.AQP == null)
        {
          localObject = g.ad(e.class);
          p.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().sh(false);
          this.AQP = ((Drawable)localObject);
          p.g(localObject, "drawable");
          this.AQR = ((Drawable)localObject).getBounds().right;
          this.AQQ = ((Drawable)localObject).getBounds().bottom;
        }
      }
    }
    AppMethodBeat.o(119371);
  }
  
  public final void aZ(View paramView)
  {
    AppMethodBeat.i(119370);
    p.h(paramView, "host");
    this.AQX = paramView;
    this.AQM = com.tencent.mm.cc.a.fromDPToPix(this.context, 2);
    this.AQN = com.tencent.mm.cc.a.fromDPToPix(this.context, 2);
    this.AQV = com.tencent.mm.cc.a.fromDPToPix(this.context, 6);
    this.AQS = paramView.getResources().getDimensionPixelSize(2131165560);
    this.AQW = new Paint();
    paramView = this.AQW;
    if (paramView != null) {
      paramView.setAntiAlias(true);
    }
    paramView = this.AQW;
    if (paramView != null) {
      paramView.setAlpha(0);
    }
    paramView = this.AQW;
    if (paramView != null) {
      paramView.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }
    paramView = aj.getContext();
    p.g(paramView, "MMApplicationContext.getContext()");
    this.AQZ = paramView.getResources().getColor(2131100993);
    AppMethodBeat.o(119370);
  }
  
  public final View.OnClickListener egV()
  {
    return this.ARd;
  }
  
  public final void fe(String paramString, int paramInt)
  {
    this.userName = paramString;
    this.pageType = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != this.ARd) {
      this.gMe = paramOnClickListener;
    }
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(119372);
    if (com.tencent.mm.plugin.sns.f.a.ayr(this.userName)) {
      paramBoolean = false;
    }
    if (this.AQL != paramBoolean)
    {
      this.AQL = paramBoolean;
      View localView = this.AQX;
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
    this.mXV = new WeakReference(paramContext);
    AppMethodBeat.o(119375);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
  public static final class b
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(119367);
      Object localObject;
      if (paramMessage != null) {
        localObject = paramMessage.obj;
      }
      while ((localObject != null) && ((paramMessage.obj instanceof View)) && (paramMessage.what == b.a(this.ARf)))
      {
        localObject = b.b(this.ARf);
        if (localObject != null)
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new v("null cannot be cast to non-null type android.view.View");
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements View.OnClickListener
  {
    private long yFr;
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119368);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      p.h(paramView, "view");
      long l = bt.flT();
      b.c(this.ARf).removeMessages(b.a(this.ARf));
      b.c(this.ARf).sendMessageDelayed(b.c(this.ARf).obtainMessage(b.a(this.ARf), paramView), ViewConfiguration.getDoubleTapTimeout());
      ad.d(b.access$getTAG$cp(), "onClick lastClick=%s now=%s", new Object[] { Long.valueOf(this.yFr), Long.valueOf(l) });
      if (l - this.yFr < ViewConfiguration.getDoubleTapTimeout())
      {
        b.c(this.ARf).removeMessages(b.a(this.ARf));
        b.d(this.ARf);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119368);
        return;
      }
      this.yFr = l;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119368);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(119369);
      b.ejB();
      AppMethodBeat.o(119369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b
 * JD-Core Version:    0.7.0.1
 */