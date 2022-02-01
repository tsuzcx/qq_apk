package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void a(Activity paramActivity, int paramInt1, SnsInfo paramSnsInfo, int paramInt2)
  {
    AppMethodBeat.i(269361);
    paramActivity = aN(paramActivity);
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 2)
    {
      SnsAdClick localSnsAdClick = new SnsAdClick(paramInt1, i, paramSnsInfo.field_snsId, paramInt2, 45);
      m.a(localSnsAdClick, paramActivity, paramSnsInfo, paramInt2);
      t.a(localSnsAdClick);
      AppMethodBeat.o(269361);
      return;
    }
  }
  
  private static l aN(Activity paramActivity)
  {
    AppMethodBeat.i(269362);
    Object localObject2 = null;
    try
    {
      if ((paramActivity instanceof SnsTimeLineUI)) {
        localObject1 = ((SnsTimeLineUI)paramActivity).fXs();
      }
      for (;;)
      {
        AppMethodBeat.o(269362);
        return localObject1;
        localObject1 = localObject2;
        if ((paramActivity instanceof SnsCommentDetailUI)) {
          localObject1 = ((SnsCommentDetailUI)paramActivity).KPn;
        }
      }
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        Log.e("AdTagClickableHelper", paramActivity.toString());
        Object localObject1 = localObject2;
      }
    }
  }
  
  public static boolean ag(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {}
    while ((paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 9) && (paramInt != 19)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.c
 * JD-Core Version:    0.7.0.1
 */