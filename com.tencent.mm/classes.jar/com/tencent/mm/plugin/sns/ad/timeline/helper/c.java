package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.g.l;
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
    AppMethodBeat.i(311120);
    paramActivity = bp(paramActivity);
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 2)
    {
      SnsAdClick localSnsAdClick = new SnsAdClick(paramInt1, i, paramSnsInfo.field_snsId, paramInt2, 45);
      m.a(localSnsAdClick, paramActivity, paramSnsInfo, paramInt2);
      t.a(localSnsAdClick);
      AppMethodBeat.o(311120);
      return;
    }
  }
  
  public static boolean ai(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {}
    while ((paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 9) && (paramInt != 19)) {
      return false;
    }
    return true;
  }
  
  private static l bp(Activity paramActivity)
  {
    AppMethodBeat.i(311131);
    Object localObject2 = null;
    try
    {
      if ((paramActivity instanceof SnsTimeLineUI)) {
        localObject1 = ((SnsTimeLineUI)paramActivity).hpK();
      }
      for (;;)
      {
        AppMethodBeat.o(311131);
        return localObject1;
        localObject1 = localObject2;
        if ((paramActivity instanceof SnsCommentDetailUI)) {
          localObject1 = ((SnsCommentDetailUI)paramActivity).RoZ;
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("AdTagClickableHelper", paramActivity.toString());
        Object localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.c
 * JD-Core Version:    0.7.0.1
 */