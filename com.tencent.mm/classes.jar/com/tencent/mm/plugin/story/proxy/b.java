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
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ox;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.story.api.i
{
  public static final b.a SpR;
  private static final String TAG;
  private boolean SpS;
  private int SpT;
  private int SpU;
  private Drawable SpV;
  private Drawable SpW;
  private int SpX;
  private int SpY;
  private int SpZ;
  private float Sqa;
  private float Sqb;
  private float Sqc;
  private Paint Sqd;
  private final com.tencent.mm.plugin.story.a.b Sqe;
  private int Sqf;
  private final int Sqg;
  private final b Sqh;
  private com.tencent.mm.plugin.story.api.i.a Sqi;
  private final View.OnClickListener Sqj;
  private final Context context;
  private View host;
  private View.OnClickListener mWW;
  private int pageType;
  private String userName;
  private WeakReference<Context> vKO;
  
  static
  {
    AppMethodBeat.i(119377);
    SpR = new b.a((byte)0);
    TAG = "MicroMsg.StoryHintProxy";
    AppMethodBeat.o(119377);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(119376);
    this.context = paramContext;
    this.pageType = -1;
    this.Sqe = new com.tencent.mm.plugin.story.a.b();
    this.Sqf = -1;
    this.Sqh = new b(this);
    this.Sqj = ((View.OnClickListener)new c(this));
    AppMethodBeat.o(119376);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(366949);
    s.u(paramb, "this$0");
    paramb = MMApplicationContext.getContext().getSystemService("vibrator");
    if ((paramb instanceof Vibrator)) {
      ((Vibrator)paramb).vibrate(10L);
    }
    AppMethodBeat.o(366949);
  }
  
  private void hxx()
  {
    AppMethodBeat.i(119374);
    if (this.host != null)
    {
      Object localObject1 = this.Sqe.Sid;
      s.checkNotNull(localObject1);
      ((AnimatorSet)localObject1).cancel();
      localObject1 = this.Sqe;
      Object localObject2 = this.host;
      s.checkNotNull(localObject2);
      ((com.tencent.mm.plugin.story.a.b)localObject1).kb((View)localObject2);
      localObject1 = this.Sqe;
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).Sid;
      s.checkNotNull(localObject2);
      localObject2 = ((AnimatorSet)localObject2).getChildAnimations().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Animator localAnimator = (Animator)((Iterator)localObject2).next();
        if ((localAnimator instanceof ValueAnimator))
        {
          ((ValueAnimator)localAnimator).setRepeatCount(((com.tencent.mm.plugin.story.a.a)localObject1).Sie);
          ((ValueAnimator)localAnimator).setRepeatMode(((com.tencent.mm.plugin.story.a.a)localObject1).Sif);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.story.a.a)localObject1).Sid;
      s.checkNotNull(localObject2);
      ((AnimatorSet)localObject2).setDuration(((com.tencent.mm.plugin.story.a.a)localObject1).mDuration);
      localObject1 = ((com.tencent.mm.plugin.story.a.a)localObject1).Sid;
      s.checkNotNull(localObject1);
      ((AnimatorSet)localObject1).start();
      MMHandlerThread.postToMainThreadDelayed(new b..ExternalSyntheticLambda0(this), 150L);
    }
    AppMethodBeat.o(119374);
  }
  
  private final void report()
  {
    AppMethodBeat.i(119373);
    Object localObject = com.tencent.mm.plugin.story.g.h.SqZ;
    localObject = com.tencent.mm.plugin.story.g.h.hxW();
    if (this.SpS) {}
    for (long l = 1L;; l = 0L)
    {
      ((ox)localObject).jjo = l;
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      localObject = com.tencent.mm.plugin.story.g.h.hxW();
      com.tencent.mm.plugin.story.g.i.a locala = com.tencent.mm.plugin.story.g.i.Srx;
      ((ox)localObject).jjn = com.tencent.mm.plugin.story.g.i.a.ans(this.pageType);
      AppMethodBeat.o(119373);
      return;
    }
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(119371);
    s.u(paramCanvas, "canvas");
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(119371);
      return;
    }
    View localView = this.host;
    if (localView != null)
    {
      int i = (localView.getWidth() - this.SpZ) / 2;
      if (localView.getWidth() > this.SpZ)
      {
        this.Sqb = (this.SpZ + i);
        this.Sqa = i;
      }
      if (this.SpS)
      {
        localObject = this.Sqd;
        if (localObject != null) {
          ((Paint)localObject).setColor(paramInt);
        }
        localObject = this.Sqd;
        if (localObject != null) {
          paramCanvas.drawCircle(localView.getWidth() - this.Sqc, this.Sqc, this.Sqc, (Paint)localObject);
        }
        if (!paramBoolean) {
          break label263;
        }
        if (this.SpV == null)
        {
          localObject = ((e)com.tencent.mm.kernel.h.az(e.class)).getStoryUIFactory().EE(true);
          this.SpV = ((Drawable)localObject);
          this.SpY = ((Drawable)localObject).getBounds().right;
          this.SpX = ((Drawable)localObject).getBounds().bottom;
        }
      }
    }
    for (Object localObject = this.SpV;; localObject = this.SpW)
    {
      paramCanvas.save();
      paramCanvas.translate(localView.getWidth() - this.SpY - this.SpT, this.SpU);
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      paramCanvas.restore();
      AppMethodBeat.o(119371);
      return;
      label263:
      if (this.SpW == null)
      {
        localObject = ((e)com.tencent.mm.kernel.h.az(e.class)).getStoryUIFactory().EE(false);
        this.SpW = ((Drawable)localObject);
        this.SpY = ((Drawable)localObject).getBounds().right;
        this.SpX = ((Drawable)localObject).getBounds().bottom;
      }
    }
  }
  
  public final void g(View paramView)
  {
    AppMethodBeat.i(119370);
    s.u(paramView, "host");
    this.host = paramView;
    this.SpT = com.tencent.mm.cd.a.fromDPToPix(this.context, 2);
    this.SpU = com.tencent.mm.cd.a.fromDPToPix(this.context, 2);
    this.Sqc = com.tencent.mm.cd.a.fromDPToPix(this.context, 6);
    this.SpZ = paramView.getResources().getDimensionPixelSize(a.b.SmallAvatarSize);
    this.Sqd = new Paint();
    paramView = this.Sqd;
    if (paramView != null) {
      paramView.setAntiAlias(true);
    }
    paramView = this.Sqd;
    if (paramView != null) {
      paramView.setAlpha(0);
    }
    paramView = this.Sqd;
    if (paramView != null) {
      paramView.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }
    this.Sqf = MMApplicationContext.getContext().getResources().getColor(a.a.ScU);
    AppMethodBeat.o(119370);
  }
  
  public final void hj(String paramString, int paramInt)
  {
    this.userName = paramString;
    this.pageType = paramInt;
  }
  
  public final View.OnClickListener huQ()
  {
    return this.Sqj;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != this.Sqj) {
      this.mWW = paramOnClickListener;
    }
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(119372);
    if (com.tencent.mm.plugin.sns.easteregg.a.aXM(this.userName)) {
      paramBoolean = false;
    }
    if (this.SpS != paramBoolean)
    {
      this.SpS = paramBoolean;
      View localView = this.host;
      if (localView != null) {
        localView.invalidate();
      }
    }
    AppMethodBeat.o(119372);
  }
  
  public final void setWeakContext(Context paramContext)
  {
    AppMethodBeat.i(119375);
    s.u(paramContext, "context");
    this.vKO = new WeakReference(paramContext);
    AppMethodBeat.o(119375);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(b paramb) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(119367);
      Object localObject;
      if (paramMessage == null) {
        localObject = null;
      }
      while ((localObject != null) && ((paramMessage.obj instanceof View)) && (paramMessage.what == b.b(this.Sqk)))
      {
        localObject = b.c(this.Sqk);
        if (localObject != null)
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new NullPointerException("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(119367);
            throw paramMessage;
            localObject = paramMessage.obj;
          }
          else
          {
            ((View.OnClickListener)localObject).onClick((View)paramMessage);
          }
        }
      }
      AppMethodBeat.o(119367);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements View.OnClickListener
  {
    private long Pqz;
    
    c(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119368);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      s.u(paramView, "view");
      long l = Util.nowMilliSecond();
      b.d(this.Sqk).removeMessages(b.b(this.Sqk));
      b.d(this.Sqk).sendMessageDelayed(b.d(this.Sqk).obtainMessage(b.b(this.Sqk), paramView), ViewConfiguration.getDoubleTapTimeout());
      Log.d(b.access$getTAG$cp(), "onClick lastClick=%s now=%s", new Object[] { Long.valueOf(this.Pqz), Long.valueOf(l) });
      if (l - this.Pqz < ViewConfiguration.getDoubleTapTimeout())
      {
        b.d(this.Sqk).removeMessages(b.b(this.Sqk));
        b.e(this.Sqk);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119368);
        return;
      }
      this.Pqz = l;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b
 * JD-Core Version:    0.7.0.1
 */