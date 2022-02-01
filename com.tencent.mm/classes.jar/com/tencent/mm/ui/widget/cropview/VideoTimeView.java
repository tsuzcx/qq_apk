package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.g.b.v.d;
import d.k.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView;", "Landroid/widget/TextView;", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disappearRunnable", "Ljava/lang/Runnable;", "value", "duration", "getDuration", "()I", "setDuration", "(I)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "runnable", "makeTimeString", "", "d", "onDetachedFromWindow", "", "onVisibility", "isShow", "", "start", "time", "disappearTime", "", "stop", "Companion", "libmmui_release"})
public final class VideoTimeView
  extends TextView
  implements b
{
  public static final VideoTimeView.a JeR;
  private Runnable csS;
  private int duration;
  private final ao hBR;
  
  static
  {
    AppMethodBeat.i(164495);
    JeR = new VideoTimeView.a((byte)0);
    AppMethodBeat.o(164495);
  }
  
  public VideoTimeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164492);
    this.hBR = new ao(Looper.getMainLooper());
    paramContext = getContext();
    k.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165257));
    paramContext = getContext();
    k.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099828));
    setBackgroundResource(2131231959);
    paramContext = getContext();
    k.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165303);
    paramContext = getContext();
    k.g(paramContext, "context");
    int j = (int)paramContext.getResources().getDimension(2131165274);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164492);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164493);
    this.hBR = new ao(Looper.getMainLooper());
    paramContext = getContext();
    k.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165257));
    paramContext = getContext();
    k.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099828));
    setBackgroundResource(2131231959);
    paramContext = getContext();
    k.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165303);
    paramContext = getContext();
    k.g(paramContext, "context");
    int j = (int)paramContext.getResources().getDimension(2131165274);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164493);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164494);
    this.hBR = new ao(Looper.getMainLooper());
    paramContext = getContext();
    k.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165257));
    paramContext = getContext();
    k.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099828));
    setBackgroundResource(2131231959);
    paramContext = getContext();
    k.g(paramContext, "context");
    paramInt = (int)paramContext.getResources().getDimension(2131165303);
    paramContext = getContext();
    k.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165274);
    setPadding(paramInt, i, paramInt, i);
    AppMethodBeat.o(164494);
  }
  
  private void acD(final int paramInt)
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
    final v.d locald = new v.d();
    locald.KUO = paramInt;
    setText((CharSequence)(sO(locald.KUO / 60) + ":" + sO(locald.KUO % 60)));
    this.csS = ((Runnable)new b(this, locald, paramInt));
    postDelayed(this.csS, 1000L);
    AppMethodBeat.o(164487);
  }
  
  private static String sO(int paramInt)
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
  
  private void stop()
  {
    AppMethodBeat.i(164488);
    Runnable localRunnable = this.csS;
    if (localRunnable != null)
    {
      removeCallbacks(localRunnable);
      AppMethodBeat.o(164488);
      return;
    }
    AppMethodBeat.o(164488);
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
    setText((CharSequence)(sO(paramInt / 60) + ":" + sO(paramInt % 60)));
    ac.i("MicroMsg.VideoTimeView", "[setDuration] value=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(164485);
  }
  
  public final void start()
  {
    AppMethodBeat.i(164486);
    acD(this.duration);
    AppMethodBeat.o(164486);
  }
  
  public final void yb(boolean paramBoolean)
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/ui/widget/cropview/VideoTimeView$start$2", "Ljava/lang/Runnable;", "run", "", "libmmui_release"})
  public static final class b
    implements Runnable
  {
    b(v.d paramd, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164484);
      locald.KUO = h.la(0, locald.KUO - 1);
      this.JeS.setText((CharSequence)(VideoTimeView.acE(locald.KUO / 60) + ":" + VideoTimeView.acE(locald.KUO % 60)));
      if (locald.KUO <= 0) {
        locald.KUO = paramInt;
      }
      this.JeS.postDelayed((Runnable)this, 1000L);
      AppMethodBeat.o(164484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.VideoTimeView
 * JD-Core Version:    0.7.0.1
 */