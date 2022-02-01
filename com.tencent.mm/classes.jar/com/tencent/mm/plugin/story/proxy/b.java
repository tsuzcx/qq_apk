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
import com.tencent.mm.g.b.a.dl;
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
import d.g.b.k;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.i
{
  private static final String TAG = "MicroMsg.StoryHintProxy";
  public static final a ymg;
  private final Context context;
  private WeakReference<Context> lVp;
  private int pageType;
  private View.OnClickListener pgj;
  private String userName;
  private boolean ylN;
  private int ylO;
  private int ylP;
  private Drawable ylQ;
  private Drawable ylR;
  private int ylS;
  private int ylT;
  private int ylU;
  private float ylV;
  private float ylW;
  private float ylX;
  private Paint ylY;
  private View ylZ;
  private final com.tencent.mm.plugin.story.a.b yma;
  private int ymb;
  private final int ymc;
  private final b ymd;
  private com.tencent.mm.plugin.story.api.i.a yme;
  private final View.OnClickListener ymf;
  
  static
  {
    AppMethodBeat.i(119377);
    ymg = new a((byte)0);
    TAG = "MicroMsg.StoryHintProxy";
    AppMethodBeat.o(119377);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(119376);
    this.context = paramContext;
    this.pageType = -1;
    this.yma = new com.tencent.mm.plugin.story.a.b();
    this.ymb = -1;
    this.ymd = new b(this);
    this.ymf = ((View.OnClickListener)new c(this));
    AppMethodBeat.o(119376);
  }
  
  private void dIK()
  {
    AppMethodBeat.i(119374);
    if (this.ylZ != null)
    {
      Object localObject1 = this.yma.ycU;
      if (localObject1 == null) {
        k.fvU();
      }
      ((AnimatorSet)localObject1).cancel();
      localObject1 = this.yma;
      Object localObject2 = this.ylZ;
      if (localObject2 == null) {
        k.fvU();
      }
      ((com.tencent.mm.plugin.story.a.b)localObject1).eX((View)localObject2);
      localObject1 = this.yma;
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).ycU;
      if (localObject2 == null) {
        k.fvU();
      }
      localObject2 = ((AnimatorSet)localObject2).getChildAnimations().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Animator localAnimator = (Animator)((Iterator)localObject2).next();
        if ((localAnimator instanceof ValueAnimator))
        {
          ((ValueAnimator)localAnimator).setRepeatCount(((com.tencent.mm.plugin.story.a.a)localObject1).ycV);
          ((ValueAnimator)localAnimator).setRepeatMode(((com.tencent.mm.plugin.story.a.a)localObject1).ycW);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).ycU;
      if (localObject2 == null) {
        k.fvU();
      }
      ((AnimatorSet)localObject2).setDuration(((com.tencent.mm.plugin.story.a.a)localObject1).mDuration);
      localObject1 = ((com.tencent.mm.plugin.story.a.a)localObject1).ycU;
      if (localObject1 == null) {
        k.fvU();
      }
      ((AnimatorSet)localObject1).start();
      aq.n((Runnable)new d(this), 150L);
    }
    AppMethodBeat.o(119374);
  }
  
  private final void report()
  {
    AppMethodBeat.i(119373);
    Object localObject = h.ynv;
    localObject = h.dJj();
    if (this.ylN) {}
    for (long l = 1L;; l = 0L)
    {
      ((dl)localObject).ga(l);
      localObject = h.ynv;
      localObject = h.dJj();
      com.tencent.mm.plugin.story.h.i.a locala = com.tencent.mm.plugin.story.h.i.ynw;
      ((dl)localObject).fZ(com.tencent.mm.plugin.story.h.i.a.OF(this.pageType));
      AppMethodBeat.o(119373);
      return;
    }
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119371);
    k.h(paramCanvas, "canvas");
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(119371);
      return;
    }
    View localView = this.ylZ;
    if (localView != null)
    {
      int i = (localView.getWidth() - this.ylU) / 2;
      if (localView.getWidth() > this.ylU)
      {
        this.ylW = (this.ylU + i);
        this.ylV = i;
      }
      if (this.ylN)
      {
        localObject = this.ylY;
        if (localObject != null) {
          ((Paint)localObject).setColor(paramInt);
        }
        localObject = this.ylY;
        if (localObject != null) {
          paramCanvas.drawCircle(localView.getWidth() - this.ylX, this.ylX, this.ylX, (Paint)localObject);
        }
        if (!paramBoolean) {
          break label283;
        }
        if (this.ylQ == null)
        {
          localObject = g.ad(e.class);
          k.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().qD(true);
          this.ylQ = ((Drawable)localObject);
          k.g(localObject, "drawable");
          this.ylT = ((Drawable)localObject).getBounds().right;
          this.ylS = ((Drawable)localObject).getBounds().bottom;
        }
      }
      for (Object localObject = this.ylQ;; localObject = this.ylR)
      {
        paramCanvas.save();
        paramCanvas.translate(localView.getWidth() - this.ylT - this.ylO, this.ylP);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
        paramCanvas.restore();
        AppMethodBeat.o(119371);
        return;
        label283:
        if (this.ylR == null)
        {
          localObject = g.ad(e.class);
          k.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().qD(false);
          this.ylR = ((Drawable)localObject);
          k.g(localObject, "drawable");
          this.ylT = ((Drawable)localObject).getBounds().right;
          this.ylS = ((Drawable)localObject).getBounds().bottom;
        }
      }
    }
    AppMethodBeat.o(119371);
  }
  
  public final void aZ(View paramView)
  {
    AppMethodBeat.i(119370);
    k.h(paramView, "host");
    this.ylZ = paramView;
    this.ylO = com.tencent.mm.cd.a.fromDPToPix(this.context, 2);
    this.ylP = com.tencent.mm.cd.a.fromDPToPix(this.context, 2);
    this.ylX = com.tencent.mm.cd.a.fromDPToPix(this.context, 6);
    paramView.setOnClickListener(this.ymf);
    this.ylU = paramView.getResources().getDimensionPixelSize(2131165560);
    this.ylY = new Paint();
    paramView = this.ylY;
    if (paramView != null) {
      paramView.setAntiAlias(true);
    }
    paramView = this.ylY;
    if (paramView != null) {
      paramView.setAlpha(0);
    }
    paramView = this.ylY;
    if (paramView != null) {
      paramView.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }
    paramView = aj.getContext();
    k.g(paramView, "MMApplicationContext.getContext()");
    this.ymb = paramView.getResources().getColor(2131100993);
    AppMethodBeat.o(119370);
  }
  
  public final View.OnClickListener dGg()
  {
    return this.ymf;
  }
  
  public final void eE(String paramString, int paramInt)
  {
    this.userName = paramString;
    this.pageType = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != this.ymf) {
      this.pgj = paramOnClickListener;
    }
  }
  
  public final void setOnDoubleClickListener(com.tencent.mm.plugin.story.api.i.a parama)
  {
    this.yme = parama;
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(119372);
    if (com.tencent.mm.plugin.sns.g.a.aoa(this.userName)) {
      paramBoolean = false;
    }
    if (this.ylN != paramBoolean)
    {
      this.ylN = paramBoolean;
      View localView = this.ylZ;
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
    k.h(paramContext, "context");
    this.lVp = new WeakReference(paramContext);
    AppMethodBeat.o(119375);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
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
      while ((localObject != null) && ((paramMessage.obj instanceof View)) && (paramMessage.what == b.a(this.ymh)))
      {
        localObject = b.b(this.ymh);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements View.OnClickListener
  {
    private long wdB;
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119368);
      k.h(paramView, "view");
      long l = bt.eGO();
      b.c(this.ymh).removeMessages(b.a(this.ymh));
      b.c(this.ymh).sendMessageDelayed(b.c(this.ymh).obtainMessage(b.a(this.ymh), paramView), ViewConfiguration.getDoubleTapTimeout());
      ad.d(b.access$getTAG$cp(), "onClick lastClick=%s now=%s", new Object[] { Long.valueOf(this.wdB), Long.valueOf(l) });
      if (l - this.wdB < ViewConfiguration.getDoubleTapTimeout())
      {
        b.c(this.ymh).removeMessages(b.a(this.ymh));
        b.d(this.ymh);
        AppMethodBeat.o(119368);
        return;
      }
      this.wdB = l;
      AppMethodBeat.o(119368);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(119369);
      b.dIL();
      AppMethodBeat.o(119369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b
 * JD-Core Version:    0.7.0.1
 */