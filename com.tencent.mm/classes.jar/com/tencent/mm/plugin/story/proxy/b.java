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
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.i
{
  private static final String TAG = "MicroMsg.StoryHintProxy";
  public static final b.a zzF;
  private final Context context;
  private View.OnClickListener gst;
  private WeakReference<Context> mxr;
  private int pageType;
  private String userName;
  private boolean zyM;
  private int zyN;
  private int zyO;
  private Drawable zyP;
  private Drawable zyQ;
  private int zyR;
  private int zyS;
  private int zyT;
  private float zyU;
  private float zyV;
  private float zyW;
  private Paint zyX;
  private View zyY;
  private final com.tencent.mm.plugin.story.a.b zyZ;
  private int zzA;
  private final int zzB;
  private final b zzC;
  private com.tencent.mm.plugin.story.api.i.a zzD;
  private final View.OnClickListener zzE;
  
  static
  {
    AppMethodBeat.i(119377);
    zzF = new b.a((byte)0);
    TAG = "MicroMsg.StoryHintProxy";
    AppMethodBeat.o(119377);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(119376);
    this.context = paramContext;
    this.pageType = -1;
    this.zyZ = new com.tencent.mm.plugin.story.a.b();
    this.zzA = -1;
    this.zzC = new b(this);
    this.zzE = ((View.OnClickListener)new c(this));
    AppMethodBeat.o(119376);
  }
  
  private void dXl()
  {
    AppMethodBeat.i(119374);
    if (this.zyY != null)
    {
      Object localObject1 = this.zyZ.zpU;
      if (localObject1 == null) {
        k.fOy();
      }
      ((AnimatorSet)localObject1).cancel();
      localObject1 = this.zyZ;
      Object localObject2 = this.zyY;
      if (localObject2 == null) {
        k.fOy();
      }
      ((com.tencent.mm.plugin.story.a.b)localObject1).fk((View)localObject2);
      localObject1 = this.zyZ;
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).zpU;
      if (localObject2 == null) {
        k.fOy();
      }
      localObject2 = ((AnimatorSet)localObject2).getChildAnimations().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Animator localAnimator = (Animator)((Iterator)localObject2).next();
        if ((localAnimator instanceof ValueAnimator))
        {
          ((ValueAnimator)localAnimator).setRepeatCount(((com.tencent.mm.plugin.story.a.a)localObject1).zpV);
          ((ValueAnimator)localAnimator).setRepeatMode(((com.tencent.mm.plugin.story.a.a)localObject1).zpW);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).zpU;
      if (localObject2 == null) {
        k.fOy();
      }
      ((AnimatorSet)localObject2).setDuration(((com.tencent.mm.plugin.story.a.a)localObject1).mDuration);
      localObject1 = ((com.tencent.mm.plugin.story.a.a)localObject1).zpU;
      if (localObject1 == null) {
        k.fOy();
      }
      ((AnimatorSet)localObject1).start();
      ap.n((Runnable)new d(this), 150L);
    }
    AppMethodBeat.o(119374);
  }
  
  private final void report()
  {
    AppMethodBeat.i(119373);
    Object localObject = h.zAU;
    localObject = h.dXK();
    if (this.zyM) {}
    for (long l = 1L;; l = 0L)
    {
      ((ez)localObject).jn(l);
      localObject = h.zAU;
      localObject = h.dXK();
      com.tencent.mm.plugin.story.h.i.a locala = com.tencent.mm.plugin.story.h.i.zAV;
      ((ez)localObject).jm(com.tencent.mm.plugin.story.h.i.a.QL(this.pageType));
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
    View localView = this.zyY;
    if (localView != null)
    {
      int i = (localView.getWidth() - this.zyT) / 2;
      if (localView.getWidth() > this.zyT)
      {
        this.zyV = (this.zyT + i);
        this.zyU = i;
      }
      if (this.zyM)
      {
        localObject = this.zyX;
        if (localObject != null) {
          ((Paint)localObject).setColor(paramInt);
        }
        localObject = this.zyX;
        if (localObject != null) {
          paramCanvas.drawCircle(localView.getWidth() - this.zyW, this.zyW, this.zyW, (Paint)localObject);
        }
        if (!paramBoolean) {
          break label283;
        }
        if (this.zyP == null)
        {
          localObject = g.ad(e.class);
          k.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().rB(true);
          this.zyP = ((Drawable)localObject);
          k.g(localObject, "drawable");
          this.zyS = ((Drawable)localObject).getBounds().right;
          this.zyR = ((Drawable)localObject).getBounds().bottom;
        }
      }
      for (Object localObject = this.zyP;; localObject = this.zyQ)
      {
        paramCanvas.save();
        paramCanvas.translate(localView.getWidth() - this.zyS - this.zyN, this.zyO);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
        paramCanvas.restore();
        AppMethodBeat.o(119371);
        return;
        label283:
        if (this.zyQ == null)
        {
          localObject = g.ad(e.class);
          k.g(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().rB(false);
          this.zyQ = ((Drawable)localObject);
          k.g(localObject, "drawable");
          this.zyS = ((Drawable)localObject).getBounds().right;
          this.zyR = ((Drawable)localObject).getBounds().bottom;
        }
      }
    }
    AppMethodBeat.o(119371);
  }
  
  public final void aZ(View paramView)
  {
    AppMethodBeat.i(119370);
    k.h(paramView, "host");
    this.zyY = paramView;
    this.zyN = com.tencent.mm.cc.a.fromDPToPix(this.context, 2);
    this.zyO = com.tencent.mm.cc.a.fromDPToPix(this.context, 2);
    this.zyW = com.tencent.mm.cc.a.fromDPToPix(this.context, 6);
    paramView.setOnClickListener(this.zzE);
    this.zyT = paramView.getResources().getDimensionPixelSize(2131165560);
    this.zyX = new Paint();
    paramView = this.zyX;
    if (paramView != null) {
      paramView.setAntiAlias(true);
    }
    paramView = this.zyX;
    if (paramView != null) {
      paramView.setAlpha(0);
    }
    paramView = this.zyX;
    if (paramView != null) {
      paramView.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }
    paramView = ai.getContext();
    k.g(paramView, "MMApplicationContext.getContext()");
    this.zzA = paramView.getResources().getColor(2131100993);
    AppMethodBeat.o(119370);
  }
  
  public final View.OnClickListener dUH()
  {
    return this.zzE;
  }
  
  public final void eM(String paramString, int paramInt)
  {
    this.userName = paramString;
    this.pageType = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != this.zzE) {
      this.gst = paramOnClickListener;
    }
  }
  
  public final void setOnDoubleClickListener(com.tencent.mm.plugin.story.api.i.a parama)
  {
    this.zzD = parama;
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(119372);
    if (com.tencent.mm.plugin.sns.f.a.atm(this.userName)) {
      paramBoolean = false;
    }
    if (this.zyM != paramBoolean)
    {
      this.zyM = paramBoolean;
      View localView = this.zyY;
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
    this.mxr = new WeakReference(paramContext);
    AppMethodBeat.o(119375);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
  public static final class b
    extends ao
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(119367);
      Object localObject;
      if (paramMessage != null) {
        localObject = paramMessage.obj;
      }
      while ((localObject != null) && ((paramMessage.obj instanceof View)) && (paramMessage.what == b.a(this.zzG)))
      {
        localObject = b.b(this.zzG);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements View.OnClickListener
  {
    private long xoP;
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119368);
      k.h(paramView, "view");
      long l = bs.eWj();
      b.c(this.zzG).removeMessages(b.a(this.zzG));
      b.c(this.zzG).sendMessageDelayed(b.c(this.zzG).obtainMessage(b.a(this.zzG), paramView), ViewConfiguration.getDoubleTapTimeout());
      ac.d(b.access$getTAG$cp(), "onClick lastClick=%s now=%s", new Object[] { Long.valueOf(this.xoP), Long.valueOf(l) });
      if (l - this.xoP < ViewConfiguration.getDoubleTapTimeout())
      {
        b.c(this.zzG).removeMessages(b.a(this.zzG));
        b.d(this.zzG);
        AppMethodBeat.o(119368);
        return;
      }
      this.xoP = l;
      AppMethodBeat.o(119368);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(119369);
      b.dXm();
      AppMethodBeat.o(119369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b
 * JD-Core Version:    0.7.0.1
 */