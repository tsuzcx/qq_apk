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
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.i
{
  public static final b.a BiC;
  private static final String TAG = "MicroMsg.StoryHintProxy";
  private com.tencent.mm.plugin.story.api.i.a BiA;
  private final View.OnClickListener BiB;
  private boolean Bij;
  private int Bik;
  private int Bil;
  private Drawable Bim;
  private Drawable Bin;
  private int Bio;
  private int Bip;
  private int Biq;
  private float Bir;
  private float Bis;
  private float Bit;
  private Paint Biu;
  private View Biv;
  private final com.tencent.mm.plugin.story.a.b Biw;
  private int Bix;
  private final int Biy;
  private final b Biz;
  private final Context context;
  private View.OnClickListener gON;
  private WeakReference<Context> ndc;
  private int pageType;
  private String userName;
  
  static
  {
    AppMethodBeat.i(119377);
    BiC = new b.a((byte)0);
    TAG = "MicroMsg.StoryHintProxy";
    AppMethodBeat.o(119377);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(119376);
    this.context = paramContext;
    this.pageType = -1;
    this.Biw = new com.tencent.mm.plugin.story.a.b();
    this.Bix = -1;
    this.Biz = new b(this);
    this.BiB = ((View.OnClickListener)new c(this));
    AppMethodBeat.o(119376);
  }
  
  private void enj()
  {
    AppMethodBeat.i(119374);
    if (this.Biv != null)
    {
      Object localObject1 = this.Biw.AZr;
      if (localObject1 == null) {
        p.gkB();
      }
      ((AnimatorSet)localObject1).cancel();
      localObject1 = this.Biw;
      Object localObject2 = this.Biv;
      if (localObject2 == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.story.a.b)localObject1).fx((View)localObject2);
      localObject1 = this.Biw;
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).AZr;
      if (localObject2 == null) {
        p.gkB();
      }
      localObject2 = ((AnimatorSet)localObject2).getChildAnimations().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Animator localAnimator = (Animator)((Iterator)localObject2).next();
        if ((localAnimator instanceof ValueAnimator))
        {
          ((ValueAnimator)localAnimator).setRepeatCount(((com.tencent.mm.plugin.story.a.a)localObject1).AZs);
          ((ValueAnimator)localAnimator).setRepeatMode(((com.tencent.mm.plugin.story.a.a)localObject1).AZt);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).AZr;
      if (localObject2 == null) {
        p.gkB();
      }
      ((AnimatorSet)localObject2).setDuration(((com.tencent.mm.plugin.story.a.a)localObject1).mDuration);
      localObject1 = ((com.tencent.mm.plugin.story.a.a)localObject1).AZr;
      if (localObject1 == null) {
        p.gkB();
      }
      ((AnimatorSet)localObject1).start();
      ar.o((Runnable)new d(this), 150L);
    }
    AppMethodBeat.o(119374);
  }
  
  private final void report()
  {
    AppMethodBeat.i(119373);
    Object localObject = h.BjR;
    localObject = h.enI();
    if (this.Bij) {}
    for (long l = 1L;; l = 0L)
    {
      ((ga)localObject).lk(l);
      localObject = h.BjR;
      localObject = h.enI();
      com.tencent.mm.plugin.story.h.i.a locala = com.tencent.mm.plugin.story.h.i.BjS;
      ((ga)localObject).lj(com.tencent.mm.plugin.story.h.i.a.Tb(this.pageType));
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
    View localView = this.Biv;
    if (localView != null)
    {
      int i = (localView.getWidth() - this.Biq) / 2;
      if (localView.getWidth() > this.Biq)
      {
        this.Bis = (this.Biq + i);
        this.Bir = i;
      }
      if (this.Bij)
      {
        localObject = this.Biu;
        if (localObject != null) {
          ((Paint)localObject).setColor(paramInt);
        }
        localObject = this.Biu;
        if (localObject != null) {
          paramCanvas.drawCircle(localView.getWidth() - this.Bit, this.Bit, this.Bit, (Paint)localObject);
        }
        if (!paramBoolean) {
          break label283;
        }
        if (this.Bim == null)
        {
          localObject = g.ad(e.class);
          p.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().so(true);
          this.Bim = ((Drawable)localObject);
          p.g(localObject, "drawable");
          this.Bip = ((Drawable)localObject).getBounds().right;
          this.Bio = ((Drawable)localObject).getBounds().bottom;
        }
      }
      for (Object localObject = this.Bim;; localObject = this.Bin)
      {
        paramCanvas.save();
        paramCanvas.translate(localView.getWidth() - this.Bip - this.Bik, this.Bil);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
        paramCanvas.restore();
        AppMethodBeat.o(119371);
        return;
        label283:
        if (this.Bin == null)
        {
          localObject = g.ad(e.class);
          p.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().so(false);
          this.Bin = ((Drawable)localObject);
          p.g(localObject, "drawable");
          this.Bip = ((Drawable)localObject).getBounds().right;
          this.Bio = ((Drawable)localObject).getBounds().bottom;
        }
      }
    }
    AppMethodBeat.o(119371);
  }
  
  public final void aZ(View paramView)
  {
    AppMethodBeat.i(119370);
    p.h(paramView, "host");
    this.Biv = paramView;
    this.Bik = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
    this.Bil = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
    this.Bit = com.tencent.mm.cb.a.fromDPToPix(this.context, 6);
    this.Biq = paramView.getResources().getDimensionPixelSize(2131165560);
    this.Biu = new Paint();
    paramView = this.Biu;
    if (paramView != null) {
      paramView.setAntiAlias(true);
    }
    paramView = this.Biu;
    if (paramView != null) {
      paramView.setAlpha(0);
    }
    paramView = this.Biu;
    if (paramView != null) {
      paramView.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }
    paramView = ak.getContext();
    p.g(paramView, "MMApplicationContext.getContext()");
    this.Bix = paramView.getResources().getColor(2131100993);
    AppMethodBeat.o(119370);
  }
  
  public final View.OnClickListener ekD()
  {
    return this.BiB;
  }
  
  public final void fn(String paramString, int paramInt)
  {
    this.userName = paramString;
    this.pageType = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != this.BiB) {
      this.gON = paramOnClickListener;
    }
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(119372);
    if (com.tencent.mm.plugin.sns.f.a.azI(this.userName)) {
      paramBoolean = false;
    }
    if (this.Bij != paramBoolean)
    {
      this.Bij = paramBoolean;
      View localView = this.Biv;
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
    this.ndc = new WeakReference(paramContext);
    AppMethodBeat.o(119375);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
  public static final class b
    extends aq
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(119367);
      Object localObject;
      if (paramMessage != null) {
        localObject = paramMessage.obj;
      }
      while ((localObject != null) && ((paramMessage.obj instanceof View)) && (paramMessage.what == b.a(this.BiD)))
      {
        localObject = b.b(this.BiD);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements View.OnClickListener
  {
    private long yVw;
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119368);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      p.h(paramView, "view");
      long l = bu.fpO();
      b.c(this.BiD).removeMessages(b.a(this.BiD));
      b.c(this.BiD).sendMessageDelayed(b.c(this.BiD).obtainMessage(b.a(this.BiD), paramView), ViewConfiguration.getDoubleTapTimeout());
      ae.d(b.access$getTAG$cp(), "onClick lastClick=%s now=%s", new Object[] { Long.valueOf(this.yVw), Long.valueOf(l) });
      if (l - this.yVw < ViewConfiguration.getDoubleTapTimeout())
      {
        b.c(this.BiD).removeMessages(b.a(this.BiD));
        b.d(this.BiD);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119368);
        return;
      }
      this.yVw = l;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119368);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(119369);
      b.enk();
      AppMethodBeat.o(119369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b
 * JD-Core Version:    0.7.0.1
 */