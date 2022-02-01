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
import kotlin.Metadata;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView;", "Landroid/widget/TextView;", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disappearRunnable", "Ljava/lang/Runnable;", "value", "duration", "getDuration", "()I", "setDuration", "(I)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "runnable", "makeTimeString", "", "d", "onDetachedFromWindow", "", "onVisibility", "isShow", "", "start", "time", "disappearTime", "", "stop", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VideoTimeView
  extends TextView
  implements a
{
  public static final VideoTimeView.a agdQ;
  private int duration;
  private Runnable hPJ;
  private final MMHandler mainHandler;
  
  static
  {
    AppMethodBeat.i(164495);
    agdQ = new VideoTimeView.a((byte)0);
    AppMethodBeat.o(164495);
  }
  
  public VideoTimeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164492);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    setTextSize(0, getContext().getResources().getDimension(a.e.DescTextSize));
    setTextColor(getContext().getResources().getColor(a.d.White));
    setBackgroundResource(a.f.duration_tip_shape);
    int i = (int)getContext().getResources().getDimension(a.e.Edge_A);
    int j = (int)getContext().getResources().getDimension(a.e.Edge_0_5_A);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164492);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164493);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    setTextSize(0, getContext().getResources().getDimension(a.e.DescTextSize));
    setTextColor(getContext().getResources().getColor(a.d.White));
    setBackgroundResource(a.f.duration_tip_shape);
    int i = (int)getContext().getResources().getDimension(a.e.Edge_A);
    int j = (int)getContext().getResources().getDimension(a.e.Edge_0_5_A);
    setPadding(i, j, i, j);
    AppMethodBeat.o(164493);
  }
  
  public VideoTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164494);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    setTextSize(0, getContext().getResources().getDimension(a.e.DescTextSize));
    setTextColor(getContext().getResources().getColor(a.d.White));
    setBackgroundResource(a.f.duration_tip_shape);
    paramInt = (int)getContext().getResources().getDimension(a.e.Edge_A);
    int i = (int)getContext().getResources().getDimension(a.e.Edge_0_5_A);
    setPadding(paramInt, i, paramInt, i);
    AppMethodBeat.o(164494);
  }
  
  private static String Bf(int paramInt)
  {
    AppMethodBeat.i(164490);
    if (paramInt < 10)
    {
      String str = s.X("0", Integer.valueOf(paramInt));
      AppMethodBeat.o(164490);
      return str;
    }
    AppMethodBeat.o(164490);
    return String.valueOf(paramInt);
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
    ah.d locald = new ah.d();
    locald.aixb = paramInt;
    setText((CharSequence)(Bf(locald.aixb / 60) + ':' + Bf(locald.aixb % 60)));
    this.hPJ = ((Runnable)new b(locald, this, paramInt));
    postDelayed(this.hPJ, 1000L);
    AppMethodBeat.o(164487);
  }
  
  private void stop()
  {
    AppMethodBeat.i(164488);
    Runnable localRunnable = this.hPJ;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(164488);
  }
  
  public final void Nx(boolean paramBoolean)
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
    setText((CharSequence)(Bf(paramInt / 60) + ':' + Bf(paramInt % 60)));
    Log.i("MicroMsg.VideoTimeView", s.X("[setDuration] value=", Integer.valueOf(paramInt)));
    AppMethodBeat.o(164485);
  }
  
  public final void start()
  {
    AppMethodBeat.i(164486);
    start(this.duration);
    AppMethodBeat.o(164486);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/widget/cropview/VideoTimeView$start$2", "Ljava/lang/Runnable;", "run", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    b(ah.d paramd, VideoTimeView paramVideoTimeView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164484);
      this.DPl.aixb = k.qu(0, this.DPl.aixb - 1);
      jdField_this.setText((CharSequence)(VideoTimeView.aEF(this.DPl.aixb / 60) + ':' + VideoTimeView.aEF(this.DPl.aixb % 60)));
      if (this.DPl.aixb <= 0) {
        this.DPl.aixb = paramInt;
      }
      jdField_this.postDelayed((Runnable)this, 1000L);
      AppMethodBeat.o(164484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.VideoTimeView
 * JD-Core Version:    0.7.0.1
 */