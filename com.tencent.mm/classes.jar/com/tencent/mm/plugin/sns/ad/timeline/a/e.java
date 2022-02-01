package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.app.Activity;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bk;

public final class e
{
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(219143);
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.setThumpViewScaleType(ImageView.ScaleType.CENTER_CROP);
      paramSnsAdTimelineVideoView.setMute(true);
    }
    AppMethodBeat.o(219143);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219144);
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.getLayoutParams();
      paramSnsAdTimelineVideoView.width = paramInt1;
      paramSnsAdTimelineVideoView.height = paramInt2;
    }
    AppMethodBeat.o(219144);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, com.tencent.mm.plugin.sns.model.g paramg, Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(219148);
    ae.d("NormalVideoAdHelper", "cleanPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramSnsAdTimelineVideoView != null) && (paramg != null) && (paramActivity != null)) {
      paramg.a(paramSnsAdTimelineVideoView, paramActivity.hashCode());
    }
    AppMethodBeat.o(219148);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, com.tencent.mm.plugin.sns.model.g paramg, p paramp, Activity paramActivity, bzh parambzh, int paramInt, bk parambk)
  {
    AppMethodBeat.i(219149);
    ae.d("NormalVideoAdHelper", "setPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramSnsAdTimelineVideoView != null) && (paramg != null) && (paramp != null) && (paramActivity != null) && (parambzh != null)) {
      paramg.a(paramp, parambzh, paramSnsAdTimelineVideoView, paramActivity.hashCode(), parambk, paramp.Rt(32));
    }
    AppMethodBeat.o(219149);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, boolean paramBoolean)
  {
    AppMethodBeat.i(219145);
    ae.d("NormalVideoAdHelper", "setPlayerVisibility is called, the  isNewPlayerVisible is ".concat(String.valueOf(paramBoolean)));
    if (paramSnsAdTimelineVideoView != null) {
      if (!paramBoolean) {
        break label40;
      }
    }
    label40:
    for (int i = 0;; i = 8)
    {
      paramSnsAdTimelineVideoView.setVisibility(i);
      AppMethodBeat.o(219145);
      return;
    }
  }
  
  public static void b(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(219146);
    ae.d("NormalVideoAdHelper", "play is called");
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.setShouldPlayWhenPrepared(true);
      long l1 = paramSnsAdTimelineVideoView.getDurationMs();
      long l2 = paramSnsAdTimelineVideoView.getCurrentPositionMs();
      ae.d("NormalVideoAdHelper", "the duration is " + l1 + ", the current is " + l2);
      if ((l2 >= l1) && (l2 > 0L))
      {
        ae.e("NormalVideoAdHelper", "the current is more than duration, do restart!");
        if (paramSnsAdTimelineVideoView.zXN)
        {
          paramSnsAdTimelineVideoView.restart();
          AppMethodBeat.o(219146);
        }
      }
      else
      {
        paramSnsAdTimelineVideoView.start();
      }
    }
    AppMethodBeat.o(219146);
  }
  
  public static void c(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(219147);
    ae.d("NormalVideoAdHelper", "pause is called");
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.pause();
      paramSnsAdTimelineVideoView.setShouldPlayWhenPrepared(false);
    }
    AppMethodBeat.o(219147);
  }
  
  public static boolean dVw()
  {
    AppMethodBeat.i(219142);
    try
    {
      int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qxh, 0);
      ae.i("NormalVideoAdHelper", "the sns ad new player is ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(219142);
        return true;
      }
      AppMethodBeat.o(219142);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219142);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.e
 * JD-Core Version:    0.7.0.1
 */