package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.app.Activity;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bj;

public final class c
{
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(197671);
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.setThumpViewScaleType(ImageView.ScaleType.CENTER_CROP);
      paramSnsAdTimelineVideoView.setMute(true);
    }
    AppMethodBeat.o(197671);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197672);
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.getLayoutParams();
      paramSnsAdTimelineVideoView.width = paramInt1;
      paramSnsAdTimelineVideoView.height = paramInt2;
    }
    AppMethodBeat.o(197672);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, f paramf, Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(197676);
    ad.d("NormalVideoAdHelper", "cleanPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramSnsAdTimelineVideoView != null) && (paramf != null) && (paramActivity != null)) {
      paramf.a(paramSnsAdTimelineVideoView, paramActivity.hashCode());
    }
    AppMethodBeat.o(197676);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, f paramf, p paramp, Activity paramActivity, byn parambyn, int paramInt, bj parambj)
  {
    AppMethodBeat.i(197677);
    ad.d("NormalVideoAdHelper", "setPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramSnsAdTimelineVideoView != null) && (paramf != null) && (paramp != null) && (paramActivity != null) && (parambyn != null)) {
      paramf.a(paramp, parambyn, paramSnsAdTimelineVideoView, paramActivity.hashCode(), parambj, paramp.QM(32));
    }
    AppMethodBeat.o(197677);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, boolean paramBoolean)
  {
    AppMethodBeat.i(197673);
    ad.d("NormalVideoAdHelper", "setPlayerVisibility is called, the  isNewPlayerVisible is ".concat(String.valueOf(paramBoolean)));
    if (paramSnsAdTimelineVideoView != null) {
      if (!paramBoolean) {
        break label40;
      }
    }
    label40:
    for (int i = 0;; i = 8)
    {
      paramSnsAdTimelineVideoView.setVisibility(i);
      AppMethodBeat.o(197673);
      return;
    }
  }
  
  public static void b(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(197674);
    ad.d("NormalVideoAdHelper", "play is called");
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.setShouldPlayWhenPrepared(true);
      long l1 = paramSnsAdTimelineVideoView.getDurationMs();
      long l2 = paramSnsAdTimelineVideoView.getCurrentPositionMs();
      ad.d("NormalVideoAdHelper", "the duration is " + l1 + ", the current is " + l2);
      if ((l2 >= l1) && (l2 > 0L))
      {
        ad.e("NormalVideoAdHelper", "the current is more than duration, do restart!");
        if (paramSnsAdTimelineVideoView.zGF)
        {
          paramSnsAdTimelineVideoView.restart();
          AppMethodBeat.o(197674);
        }
      }
      else
      {
        paramSnsAdTimelineVideoView.start();
      }
    }
    AppMethodBeat.o(197674);
  }
  
  public static void c(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(197675);
    ad.d("NormalVideoAdHelper", "pause is called");
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.pause();
      paramSnsAdTimelineVideoView.setShouldPlayWhenPrepared(false);
    }
    AppMethodBeat.o(197675);
  }
  
  public static boolean dRY()
  {
    AppMethodBeat.i(197670);
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.qqz, 0);
      ad.i("NormalVideoAdHelper", "the sns ad new player is ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(197670);
        return true;
      }
      AppMethodBeat.o(197670);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197670);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c
 * JD-Core Version:    0.7.0.1
 */