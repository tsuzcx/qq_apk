package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.app.Activity;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;

public final class f
{
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(202228);
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.setThumpViewScaleType(ImageView.ScaleType.CENTER_CROP);
      paramSnsAdTimelineVideoView.setMute(true);
    }
    AppMethodBeat.o(202228);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202229);
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.getLayoutParams();
      paramSnsAdTimelineVideoView.width = paramInt1;
      paramSnsAdTimelineVideoView.height = paramInt2;
    }
    AppMethodBeat.o(202229);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, com.tencent.mm.plugin.sns.model.g paramg, Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(202233);
    Log.d("NormalVideoAdHelper", "cleanPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramSnsAdTimelineVideoView != null) && (paramg != null) && (paramActivity != null)) {
      paramg.a(paramSnsAdTimelineVideoView, paramActivity.hashCode());
    }
    AppMethodBeat.o(202233);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, com.tencent.mm.plugin.sns.model.g paramg, SnsInfo paramSnsInfo, Activity paramActivity, cnb paramcnb, int paramInt, bp parambp)
  {
    AppMethodBeat.i(202234);
    Log.d("NormalVideoAdHelper", "setPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramSnsAdTimelineVideoView != null) && (paramg != null) && (paramSnsInfo != null) && (paramActivity != null) && (paramcnb != null)) {
      paramg.a(paramSnsInfo, paramcnb, paramSnsAdTimelineVideoView, paramActivity.hashCode(), parambp, paramSnsInfo.isAd());
    }
    AppMethodBeat.o(202234);
  }
  
  public static void a(SnsAdTimelineVideoView paramSnsAdTimelineVideoView, boolean paramBoolean)
  {
    AppMethodBeat.i(202230);
    Log.d("NormalVideoAdHelper", "setPlayerVisibility is called, the  isNewPlayerVisible is ".concat(String.valueOf(paramBoolean)));
    if (paramSnsAdTimelineVideoView != null) {
      if (!paramBoolean) {
        break label40;
      }
    }
    label40:
    for (int i = 0;; i = 8)
    {
      paramSnsAdTimelineVideoView.setVisibility(i);
      AppMethodBeat.o(202230);
      return;
    }
  }
  
  public static void b(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(202231);
    Log.d("NormalVideoAdHelper", "play is called");
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.setShouldPlayWhenPrepared(true);
      long l1 = paramSnsAdTimelineVideoView.getDurationMs();
      long l2 = paramSnsAdTimelineVideoView.getCurrentPositionMs();
      Log.d("NormalVideoAdHelper", "the duration is " + l1 + ", the current is " + l2);
      if ((l2 >= l1) && (l2 > 0L))
      {
        Log.e("NormalVideoAdHelper", "the current is more than duration, do restart!");
        if (paramSnsAdTimelineVideoView.vbV)
        {
          paramSnsAdTimelineVideoView.restart();
          AppMethodBeat.o(202231);
        }
      }
      else
      {
        paramSnsAdTimelineVideoView.start();
      }
    }
    AppMethodBeat.o(202231);
  }
  
  public static void c(SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(202232);
    Log.d("NormalVideoAdHelper", "pause is called");
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView.pause();
      paramSnsAdTimelineVideoView.setShouldPlayWhenPrepared(false);
    }
    AppMethodBeat.o(202232);
  }
  
  public static boolean eXW()
  {
    AppMethodBeat.i(202227);
    try
    {
      int i = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rOU, 0);
      Log.i("NormalVideoAdHelper", "the sns ad new player is ".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(202227);
        return true;
      }
      AppMethodBeat.o(202227);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202227);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.f
 * JD-Core Version:    0.7.0.1
 */