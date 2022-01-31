package com.tencent.mm.plugin.story.proxy;

import a.l;
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
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i.a;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.j.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.i
{
  private static final String TAG = "MicroMsg.StoryHintProxy";
  public static final b.a sDo;
  private final Context context;
  private View.OnClickListener lPx;
  private int pageType;
  private boolean sCU;
  private int sCV;
  private int sCW;
  private Drawable sCX;
  private Drawable sCY;
  private int sCZ;
  private int sDa;
  private int sDb;
  private float sDc;
  private float sDd;
  private float sDe;
  private Paint sDf;
  private View sDg;
  private final com.tencent.mm.plugin.story.a.b sDh;
  private int sDi;
  private WeakReference<Context> sDj;
  private final int sDk;
  private final b.b sDl;
  private i.a sDm;
  private final View.OnClickListener sDn;
  private String userName;
  
  static
  {
    AppMethodBeat.i(109734);
    sDo = new b.a((byte)0);
    TAG = "MicroMsg.StoryHintProxy";
    AppMethodBeat.o(109734);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(109733);
    this.context = paramContext;
    this.pageType = -1;
    this.sDh = new com.tencent.mm.plugin.story.a.b();
    this.sDi = -1;
    this.sDl = new b.b(this);
    this.sDn = ((View.OnClickListener)new b.c(this));
    AppMethodBeat.o(109733);
  }
  
  private final void IE()
  {
    AppMethodBeat.i(109730);
    Object localObject = com.tencent.mm.plugin.story.g.i.sFa;
    localObject = com.tencent.mm.plugin.story.g.i.cDo();
    if (this.sCU) {}
    for (long l = 1L;; l = 0L)
    {
      ((ba)localObject).cF(l);
      localObject = com.tencent.mm.plugin.story.g.i.sFa;
      localObject = com.tencent.mm.plugin.story.g.i.cDo();
      j.a locala = com.tencent.mm.plugin.story.g.j.sFb;
      ((ba)localObject).cE(j.a.FY(this.pageType));
      AppMethodBeat.o(109730);
      return;
    }
  }
  
  private void cCv()
  {
    AppMethodBeat.i(109731);
    if (this.sDg != null)
    {
      Object localObject1 = this.sDh.sqG;
      if (localObject1 == null) {
        a.f.b.j.ebi();
      }
      ((AnimatorSet)localObject1).cancel();
      localObject1 = this.sDh;
      Object localObject2 = this.sDg;
      if (localObject2 == null) {
        a.f.b.j.ebi();
      }
      ((com.tencent.mm.plugin.story.a.b)localObject1).ef((View)localObject2);
      localObject1 = this.sDh;
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).sqG;
      if (localObject2 == null) {
        a.f.b.j.ebi();
      }
      localObject2 = ((AnimatorSet)localObject2).getChildAnimations().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Animator localAnimator = (Animator)((Iterator)localObject2).next();
        if ((localAnimator instanceof ValueAnimator))
        {
          ((ValueAnimator)localAnimator).setRepeatCount(((com.tencent.mm.plugin.story.a.a)localObject1).sqH);
          ((ValueAnimator)localAnimator).setRepeatMode(((com.tencent.mm.plugin.story.a.a)localObject1).sqI);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).sqG;
      if (localObject2 == null) {
        a.f.b.j.ebi();
      }
      ((AnimatorSet)localObject2).setDuration(((com.tencent.mm.plugin.story.a.a)localObject1).mDuration);
      localObject1 = ((com.tencent.mm.plugin.story.a.a)localObject1).sqG;
      if (localObject1 == null) {
        a.f.b.j.ebi();
      }
      ((AnimatorSet)localObject1).start();
      al.p((Runnable)new b.d(this), 150L);
    }
    AppMethodBeat.o(109731);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(109728);
    a.f.b.j.q(paramCanvas, "canvas");
    if (!n.isShowStoryCheck())
    {
      AppMethodBeat.o(109728);
      return;
    }
    View localView = this.sDg;
    if (localView != null)
    {
      int i = (localView.getWidth() - this.sDb) / 2;
      if (localView.getWidth() > this.sDb)
      {
        this.sDd = (this.sDb + i);
        this.sDc = i;
      }
      if (this.sCU)
      {
        localObject = this.sDf;
        if (localObject != null) {
          ((Paint)localObject).setColor(paramInt);
        }
        localObject = this.sDf;
        if (localObject != null) {
          paramCanvas.drawCircle(localView.getWidth() - this.sDe, this.sDe, this.sDe, (Paint)localObject);
        }
        if (!paramBoolean) {
          break label283;
        }
        if (this.sCX == null)
        {
          localObject = g.G(e.class);
          a.f.b.j.p(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().lO(true);
          this.sCX = ((Drawable)localObject);
          a.f.b.j.p(localObject, "drawable");
          this.sDa = ((Drawable)localObject).getBounds().right;
          this.sCZ = ((Drawable)localObject).getBounds().bottom;
        }
      }
      for (Object localObject = this.sCX;; localObject = this.sCY)
      {
        paramCanvas.save();
        paramCanvas.translate(localView.getWidth() - this.sDa - this.sCV, this.sCW);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
        paramCanvas.restore();
        AppMethodBeat.o(109728);
        return;
        label283:
        if (this.sCY == null)
        {
          localObject = g.G(e.class);
          a.f.b.j.p(localObject, "plugin(IPluginStory::class.java)");
          localObject = ((e)localObject).getStoryUIFactory().lO(false);
          this.sCY = ((Drawable)localObject);
          a.f.b.j.p(localObject, "drawable");
          this.sDa = ((Drawable)localObject).getBounds().right;
          this.sCZ = ((Drawable)localObject).getBounds().bottom;
        }
      }
    }
    AppMethodBeat.o(109728);
  }
  
  public final void aT(View paramView)
  {
    AppMethodBeat.i(109727);
    a.f.b.j.q(paramView, "host");
    this.sDg = paramView;
    this.sCV = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
    this.sCW = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
    this.sDe = com.tencent.mm.cb.a.fromDPToPix(this.context, 6);
    paramView.setOnClickListener(this.sDn);
    this.sDb = paramView.getResources().getDimensionPixelSize(2131427846);
    this.sDf = new Paint();
    paramView = this.sDf;
    if (paramView != null) {
      paramView.setAntiAlias(true);
    }
    paramView = this.sDf;
    if (paramView != null) {
      paramView.setAlpha(0);
    }
    paramView = this.sDf;
    if (paramView != null) {
      paramView.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }
    paramView = ah.getContext();
    a.f.b.j.p(paramView, "MMApplicationContext.getContext()");
    this.sDi = paramView.getResources().getColor(2131690552);
    AppMethodBeat.o(109727);
  }
  
  public final View.OnClickListener czr()
  {
    return this.sDn;
  }
  
  public final void dw(String paramString, int paramInt)
  {
    this.userName = paramString;
    this.pageType = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != this.sDn) {
      this.lPx = paramOnClickListener;
    }
  }
  
  public final void setOnDoubleClickListener(i.a parama)
  {
    this.sDm = parama;
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(109729);
    if (com.tencent.mm.plugin.sns.e.a.ZT(this.userName)) {
      paramBoolean = false;
    }
    if (this.sCU != paramBoolean)
    {
      this.sCU = paramBoolean;
      View localView = this.sDg;
      if (localView != null)
      {
        localView.invalidate();
        AppMethodBeat.o(109729);
        return;
      }
    }
    AppMethodBeat.o(109729);
  }
  
  public final void setWeakContext(Context paramContext)
  {
    AppMethodBeat.i(109732);
    a.f.b.j.q(paramContext, "context");
    this.sDj = new WeakReference(paramContext);
    AppMethodBeat.o(109732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b
 * JD-Core Version:    0.7.0.1
 */