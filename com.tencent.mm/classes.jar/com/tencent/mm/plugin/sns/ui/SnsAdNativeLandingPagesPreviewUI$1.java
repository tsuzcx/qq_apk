package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class SnsAdNativeLandingPagesPreviewUI$1
  implements w.a
{
  SnsAdNativeLandingPagesPreviewUI$1(SnsAdNativeLandingPagesPreviewUI paramSnsAdNativeLandingPagesPreviewUI, View paramView, int paramInt, String paramString1, String paramString2, long paramLong, Intent paramIntent) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(38607);
    this.val$progressBar.setVisibility(8);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      if (this.rLN == 1) {
        ab.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", new Object[] { this.rLO, this.rLP, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m localm;
    String str;
    do
    {
      do
      {
        for (;;)
        {
          this.rLQ.finish();
          AppMethodBeat.o(38607);
          return 0;
          ab.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", new Object[] { Long.valueOf(this.rCP), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
        if (this.rLN != 1) {
          break;
        }
        paramm = ((amr)paramb.fsW.fta).xdq.dqj();
        ab.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", new Object[] { this.rLO, this.rLP, paramm });
      } while (TextUtils.isEmpty(paramm));
      this.val$intent.putExtra("sns_landing_pages_xml", paramm);
      if (!SnsAdNativeLandingPagesPreviewUI.h(this.val$intent, paramm))
      {
        this.rLQ.finish();
        AppMethodBeat.o(38607);
        return 0;
      }
      SnsAdNativeLandingPagesPreviewUI.a(this.rLQ, this.val$intent, paramm);
      localm = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.csa();
      paramb = this.rLO;
      str = this.rLP;
    } while ((TextUtils.isEmpty(paramm)) || (TextUtils.isEmpty(paramb)));
    if (!bo.isNullOrNil(str)) {}
    for (paramString = paramb + str;; paramString = paramb)
    {
      localm.rCN.put(paramString, paramm);
      paramString = new x();
      paramString.field_canvasId = paramb;
      paramString.field_canvasXml = paramm;
      paramString.field_canvasExt = str;
      localm.rCM.a(paramString);
      break;
      paramString = (afo)paramb.fsW.fta;
      ab.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(this.rCP), paramString.wYL });
      if (TextUtils.isEmpty(paramString.wYL)) {
        break;
      }
      this.val$intent.putExtra("sns_landing_pages_xml", paramString.wYL);
      if (!SnsAdNativeLandingPagesPreviewUI.h(this.val$intent, paramString.wYL))
      {
        this.rLQ.finish();
        AppMethodBeat.o(38607);
        return 0;
      }
      SnsAdNativeLandingPagesPreviewUI.a(this.rLQ, this.val$intent, paramString.wYL);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.csa().u(this.rCP, paramString.wYL);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */