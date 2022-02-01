package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView;", "Landroid/widget/TextView;", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disappearRunnable", "Ljava/lang/Runnable;", "value", "duration", "getDuration", "()I", "setDuration", "(I)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "runnable", "makeTimeString", "", "d", "onDetachedFromWindow", "", "onVisibility", "isShow", "", "start", "time", "disappearTime", "", "stop", "Companion", "libmmui_release"})
public final class VideoTimeView
  extends TextView
  implements b
{
  public static final a QNo;
  private Runnable dQN;
  private int duration;
  private final MMHandler mainHandler;
  
  static
  {
    AppMethodBeat.i(164495);
    QNo = new a((byte)0);
    AppMethodBeat.o(164495);
  }
  
  public VideoTimeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164492);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165261));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099844));
    setBackgroundResource(2131232044);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165314);
    paramContext = getContext();
    p.g(paramContext, "context");
    int j = (int)paramContext.getResources().getDimension(2131165277);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164492);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164493);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165261));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099844));
    setBackgroundResource(2131232044);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165314);
    paramContext = getContext();
    p.g(paramContext, "context");
    int j = (int)paramContext.getResources().getDimension(2131165277);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164493);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164494);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextSize(0, paramContext.getResources().getDimension(2131165261));
    paramContext = getContext();
    p.g(paramContext, "context");
    setTextColor(paramContext.getResources().getColor(2131099844));
    setBackgroundResource(2131232044);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramInt = (int)paramContext.getResources().getDimension(2131165314);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165277);
    setPadding(paramInt, i, paramInt, i);
    AppMethodBeat.o(164494);
  }
  
  private void start(final int paramInt)
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
    final z.d locald = new z.d();
    locald.SYE = paramInt;
    setText((CharSequence)(xt(locald.SYE / 60) + ":" + xt(locald.SYE % 60)));
    this.dQN = ((Runnable)new b(this, locald, paramInt));
    postDelayed(this.dQN, 1000L);
    AppMethodBeat.o(164487);
  }
  
  private void stop()
  {
    AppMethodBeat.i(164488);
    Runnable localRunnable = this.dQN;
    if (localRunnable != null)
    {
      removeCallbacks(localRunnable);
      AppMethodBeat.o(164488);
      return;
    }
    AppMethodBeat.o(164488);
  }
  
  private static String xt(int paramInt)
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
  
  public final void Df(boolean paramBoolean)
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
    setText((CharSequence)(xt(paramInt / 60) + ":" + xt(paramInt % 60)));
    Log.i("MicroMsg.VideoTimeView", "[setDuration] value=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(164485);
  }
  
  public final void start()
  {
    AppMethodBeat.i(164486);
    start(this.duration);
    AppMethodBeat.o(164486);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/widget/cropview/VideoTimeView$start$2", "Ljava/lang/Runnable;", "run", "", "libmmui_release"})
  public static final class b
    implements Runnable
  {
    b(z.d paramd, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164484);
      locald.SYE = j.mZ(0, locald.SYE - 1);
      this.QNp.setText((CharSequence)(VideoTimeView.aoL(locald.SYE / 60) + ":" + VideoTimeView.aoL(locald.SYE % 60)));
      if (locald.SYE <= 0) {
        locald.SYE = paramInt;
      }
      this.QNp.postDelayed((Runnable)this, 1000L);
      AppMethodBeat.o(164484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.VideoTimeView
 * JD-Core Version:    0.7.0.1
 */