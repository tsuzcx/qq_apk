package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.g.b.y.d;
import d.k.h;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView;", "Landroid/widget/TextView;", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disappearRunnable", "Ljava/lang/Runnable;", "value", "duration", "getDuration", "()I", "setDuration", "(I)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "runnable", "makeTimeString", "", "d", "onDetachedFromWindow", "", "onVisibility", "isShow", "", "start", "time", "disappearTime", "", "stop", "Companion", "libmmui_release"})
public final class VideoTimeView
  extends TextView
  implements b
{
  public static final VideoTimeView.a KWa;
  private Runnable cDO;
  private int duration;
  private final ap hUx;
  
  static
  {
    AppMethodBeat.i(164495);
    KWa = new VideoTimeView.a((byte)0);
    AppMethodBeat.o(164495);
  }
  
  public VideoTimeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164492);
    this.hUx = new ap(Looper.getMainLooper());
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165257));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099828));
    setBackgroundResource(2131231959);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165303);
    paramContext = getContext();
    p.g(paramContext, "context");
    int j = (int)paramContext.getResources().getDimension(2131165274);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164492);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164493);
    this.hUx = new ap(Looper.getMainLooper());
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165257));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099828));
    setBackgroundResource(2131231959);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165303);
    paramContext = getContext();
    p.g(paramContext, "context");
    int j = (int)paramContext.getResources().getDimension(2131165274);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164493);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164494);
    this.hUx = new ap(Looper.getMainLooper());
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165257));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099828));
    setBackgroundResource(2131231959);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramInt = (int)paramContext.getResources().getDimension(2131165303);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165274);
    setPadding(paramInt, i, paramInt, i);
    AppMethodBeat.o(164494);
  }
  
  private void afa(final int paramInt)
  {
    AppMethodBeat.i(164487);
    animate().cancel();
    setAlpha(1.0F);
    setVisibility(0);
    stop();
    if (paramInt < 0)
    {
      AppMethodBeat.o(164487);
      return;
    }
    final y.d locald = new y.d();
    locald.MLT = paramInt;
    setText((CharSequence)(tr(locald.MLT / 60) + ":" + tr(locald.MLT % 60)));
    this.cDO = ((Runnable)new b(this, locald, paramInt));
    postDelayed(this.cDO, 1000L);
    AppMethodBeat.o(164487);
  }
  
  private void stop()
  {
    AppMethodBeat.i(164488);
    Runnable localRunnable = this.cDO;
    if (localRunnable != null)
    {
      removeCallbacks(localRunnable);
      AppMethodBeat.o(164488);
      return;
    }
    AppMethodBeat.o(164488);
  }
  
  private static String tr(int paramInt)
  {
    AppMethodBeat.i(164490);
    if (paramInt < 10)
    {
      str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(164490);
      return str;
    }
    String str = String.valueOf(paramInt);
    AppMethodBeat.o(164490);
    return str;
  }
  
  public final int getDuration()
  {
    return this.duration;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(164489);
    super.onDetachedFromWindow();
    stop();
    AppMethodBeat.o(164489);
  }
  
  public final void setDuration(int paramInt)
  {
    AppMethodBeat.i(164485);
    this.duration = paramInt;
    setText((CharSequence)(tr(paramInt / 60) + ":" + tr(paramInt % 60)));
    ad.i("MicroMsg.VideoTimeView", "[setDuration] value=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(164485);
  }
  
  public final void start()
  {
    AppMethodBeat.i(164486);
    afa(this.duration);
    AppMethodBeat.o(164486);
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(164491);
    if (paramBoolean)
    {
      setVisibility(0);
      AppMethodBeat.o(164491);
      return;
    }
    setVisibility(4);
    AppMethodBeat.o(164491);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/widget/cropview/VideoTimeView$start$2", "Ljava/lang/Runnable;", "run", "", "libmmui_release"})
  public static final class b
    implements Runnable
  {
    b(y.d paramd, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164484);
      locald.MLT = h.lp(0, locald.MLT - 1);
      this.KWb.setText((CharSequence)(VideoTimeView.afb(locald.MLT / 60) + ":" + VideoTimeView.afb(locald.MLT % 60)));
      if (locald.MLT <= 0) {
        locald.MLT = paramInt;
      }
      this.KWb.postDelayed((Runnable)this, 1000L);
      AppMethodBeat.o(164484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.VideoTimeView
 * JD-Core Version:    0.7.0.1
 */