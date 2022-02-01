package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView;", "Landroid/widget/TextView;", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disappearRunnable", "Ljava/lang/Runnable;", "value", "duration", "getDuration", "()I", "setDuration", "(I)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "runnable", "makeTimeString", "", "d", "onDetachedFromWindow", "", "onVisibility", "isShow", "", "start", "time", "disappearTime", "", "stop", "Companion", "libmmui_release"})
public final class VideoTimeView
  extends TextView
  implements b
{
  public static final a Ymc;
  private int duration;
  private Runnable fKd;
  private final MMHandler mainHandler;
  
  static
  {
    AppMethodBeat.i(164495);
    Ymc = new a((byte)0);
    AppMethodBeat.o(164495);
  }
  
  public VideoTimeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164492);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(a.e.DescTextSize));
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(a.d.White));
    setBackgroundResource(a.f.duration_tip_shape);
    paramContext = getContext();
    p.j(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(a.e.Edge_A);
    paramContext = getContext();
    p.j(paramContext, "context");
    int j = (int)paramContext.getResources().getDimension(a.e.Edge_0_5_A);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164492);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164493);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(a.e.DescTextSize));
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(a.d.White));
    setBackgroundResource(a.f.duration_tip_shape);
    paramContext = getContext();
    p.j(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(a.e.Edge_A);
    paramContext = getContext();
    p.j(paramContext, "context");
    int j = (int)paramContext.getResources().getDimension(a.e.Edge_0_5_A);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164493);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164494);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(a.e.DescTextSize));
    paramContext = getContext();
    p.j(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(a.d.White));
    setBackgroundResource(a.f.duration_tip_shape);
    paramContext = getContext();
    p.j(paramContext, "context");
    paramInt = (int)paramContext.getResources().getDimension(a.e.Edge_A);
    paramContext = getContext();
    p.j(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(a.e.Edge_0_5_A);
    setPadding(paramInt, i, paramInt, i);
    AppMethodBeat.o(164494);
  }
  
  private static String AQ(int paramInt)
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
  
  private void axW(final int paramInt)
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
    final aa.d locald = new aa.d();
    locald.aaBA = paramInt;
    setText((CharSequence)(AQ(locald.aaBA / 60) + ":" + AQ(locald.aaBA % 60)));
    this.fKd = ((Runnable)new b(this, locald, paramInt));
    postDelayed(this.fKd, 1000L);
    AppMethodBeat.o(164487);
  }
  
  private void stop()
  {
    AppMethodBeat.i(164488);
    Runnable localRunnable = this.fKd;
    if (localRunnable != null)
    {
      removeCallbacks(localRunnable);
      AppMethodBeat.o(164488);
      return;
    }
    AppMethodBeat.o(164488);
  }
  
  public final void HB(boolean paramBoolean)
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
    setText((CharSequence)(AQ(paramInt / 60) + ":" + AQ(paramInt % 60)));
    Log.i("MicroMsg.VideoTimeView", "[setDuration] value=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(164485);
  }
  
  public final void start()
  {
    AppMethodBeat.i(164486);
    axW(this.duration);
    AppMethodBeat.o(164486);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/widget/cropview/VideoTimeView$start$2", "Ljava/lang/Runnable;", "run", "", "libmmui_release"})
  public static final class b
    implements Runnable
  {
    b(aa.d paramd, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164484);
      locald.aaBA = i.ov(0, locald.aaBA - 1);
      this.Ymd.setText((CharSequence)(VideoTimeView.axX(locald.aaBA / 60) + ":" + VideoTimeView.axX(locald.aaBA % 60)));
      if (locald.aaBA <= 0) {
        locald.aaBA = paramInt;
      }
      this.Ymd.postDelayed((Runnable)this, 1000L);
      AppMethodBeat.o(164484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.VideoTimeView
 * JD-Core Version:    0.7.0.1
 */