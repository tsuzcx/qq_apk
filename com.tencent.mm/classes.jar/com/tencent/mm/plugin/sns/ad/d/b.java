package com.tencent.mm.plugin.sns.ad.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import org.json.JSONObject;

public final class b
{
  private static long PNO;
  
  public static void P(Context paramContext, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(310013);
    if (!TextUtils.isEmpty(paramString1))
    {
      new StringBuilder("checkWriteGiftCode, giftCode=").append(paramString1).append(", tip=").append(paramString2);
      if (TextUtils.isEmpty(paramString1)) {}
    }
    try
    {
      ClipboardHelper.setText(MMApplicationContext.getContext(), "wx_ad_giftcode", paramString1);
      if ((!TextUtils.isEmpty(paramString2)) && (Util.milliSecondsToNow(PNO) > 1500L))
      {
        PNO = System.currentTimeMillis();
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309925);
            try
            {
              if ((b.this instanceof Activity))
              {
                boolean bool = ((Activity)b.this).isFinishing();
                if (bool) {
                  return;
                }
              }
              aa.db(b.this, paramString2);
              return;
            }
            finally
            {
              AppMethodBeat.o(309925);
            }
          }
        }, 800L);
      }
      AppMethodBeat.o(310013);
      return;
    }
    finally
    {
      for (;;)
      {
        new StringBuilder("writeDelayDeepLink exp=").append(paramString1.toString());
      }
    }
  }
  
  public static void lK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310003);
    new StringBuilder("writeDelayDeepLink, pkg=").append(paramString1).append(", pageUrl=").append(paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(310003);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wx_ad_pkgname", paramString1);
      localJSONObject.put("wx_ad_deeplink", paramString2);
      ClipboardHelper.setText(MMApplicationContext.getContext(), "wx_ad_deeplink", localJSONObject.toString());
      AppMethodBeat.o(310003);
      return;
    }
    finally
    {
      new StringBuilder("writeDelayDeepLink exp=").append(paramString1.toString());
      AppMethodBeat.o(310003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.b
 * JD-Core Version:    0.7.0.1
 */