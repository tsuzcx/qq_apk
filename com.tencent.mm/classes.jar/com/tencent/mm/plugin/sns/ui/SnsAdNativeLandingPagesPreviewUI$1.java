package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class SnsAdNativeLandingPagesPreviewUI$1
  implements w.a
{
  SnsAdNativeLandingPagesPreviewUI$1(SnsAdNativeLandingPagesPreviewUI paramSnsAdNativeLandingPagesPreviewUI, View paramView, int paramInt, String paramString1, String paramString2, long paramLong, Intent paramIntent) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb, com.tencent.mm.ah.m paramm)
  {
    this.oTP.setVisibility(8);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      if (this.oTQ == 1) {
        com.tencent.mm.sdk.platformtools.y.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", new Object[] { this.oTR, this.oTS, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
          this.oTT.finish();
          return 0;
          com.tencent.mm.sdk.platformtools.y.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", new Object[] { Long.valueOf(this.oLe), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
        if (this.oTQ != 1) {
          break;
        }
        paramm = ((ahq)paramb.ecF.ecN).tff.coM();
        com.tencent.mm.sdk.platformtools.y.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", new Object[] { this.oTR, this.oTS, paramm });
      } while (TextUtils.isEmpty(paramm));
      this.val$intent.putExtra("sns_landing_pages_xml", paramm);
      if (!SnsAdNativeLandingPagesPreviewUI.h(this.val$intent, paramm))
      {
        this.oTT.finish();
        return 0;
      }
      SnsAdNativeLandingPagesPreviewUI.a(this.oTT, this.val$intent, paramm);
      localm = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.bFY();
      paramb = this.oTR;
      str = this.oTS;
    } while ((TextUtils.isEmpty(paramm)) || (TextUtils.isEmpty(paramb)));
    if (!bk.bl(str)) {}
    for (paramString = paramb + str;; paramString = paramb)
    {
      localm.oLc.put(paramString, paramm);
      paramString = new x();
      paramString.field_canvasId = paramb;
      paramString.field_canvasXml = paramm;
      paramString.field_canvasExt = str;
      localm.oLb.a(paramString);
      break;
      paramString = (aaw)paramb.ecF.ecN;
      com.tencent.mm.sdk.platformtools.y.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(this.oLe), paramString.tau });
      if (TextUtils.isEmpty(paramString.tau)) {
        break;
      }
      this.val$intent.putExtra("sns_landing_pages_xml", paramString.tau);
      if (!SnsAdNativeLandingPagesPreviewUI.h(this.val$intent, paramString.tau))
      {
        this.oTT.finish();
        return 0;
      }
      SnsAdNativeLandingPagesPreviewUI.a(this.oTT, this.val$intent, paramString.tau);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.bFY().t(this.oLe, paramString.tau);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */