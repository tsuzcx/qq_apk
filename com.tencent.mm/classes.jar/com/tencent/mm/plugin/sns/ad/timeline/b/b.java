package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static boolean V(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {}
    while ((paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 9) && (paramInt != 19)) {
      return false;
    }
    return true;
  }
  
  public static void a(Activity paramActivity, int paramInt1, SnsInfo paramSnsInfo, int paramInt2)
  {
    AppMethodBeat.i(202200);
    paramActivity = aH(paramActivity);
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 2)
    {
      SnsAdClick localSnsAdClick = new SnsAdClick(paramInt1, i, paramSnsInfo.field_snsId, paramInt2, 45);
      com.tencent.mm.plugin.sns.data.k.a(localSnsAdClick, paramActivity, paramSnsInfo, paramInt2);
      r.a(localSnsAdClick);
      AppMethodBeat.o(202200);
      return;
    }
  }
  
  private static com.tencent.mm.plugin.sns.ad.g.k aH(Activity paramActivity)
  {
    AppMethodBeat.i(202201);
    Object localObject2 = null;
    try
    {
      if ((paramActivity instanceof SnsTimeLineUI)) {
        localObject1 = ((SnsTimeLineUI)paramActivity).fjf();
      }
      for (;;)
      {
        AppMethodBeat.o(202201);
        return localObject1;
        localObject1 = localObject2;
        if ((paramActivity instanceof SnsCommentDetailUI)) {
          localObject1 = ((SnsCommentDetailUI)paramActivity).EBv;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.b
 * JD-Core Version:    0.7.0.1
 */