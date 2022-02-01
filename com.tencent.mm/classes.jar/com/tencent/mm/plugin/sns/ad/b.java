package com.tencent.mm.plugin.sns.ad;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  implements e
{
  public final void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(268097);
    Log.i("SnsAdService", "openAdCanvasById, canvasId=" + paramLong + ", source=" + paramInt + ", adInfoXml=" + paramString1 + ", extra=" + paramString2);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landing_pages_pageid", paramLong);
    localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
    localIntent.putExtra("sns_landig_pages_from_source", paramInt);
    localIntent.putExtra("sns_landing_pages_ad_info", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("sns_landing_pages_extra_param", paramString2);
    }
    c.b(MMApplicationContext.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
    AppMethodBeat.o(268097);
  }
  
  public final String aYm(String paramString)
  {
    AppMethodBeat.i(268099);
    paramString = m.aYm(paramString);
    AppMethodBeat.o(268099);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b
 * JD-Core Version:    0.7.0.1
 */