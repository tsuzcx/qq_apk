package com.tencent.mm.plugin.sns.ad.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import org.json.JSONObject;

public final class a
{
  private static long Jzl;
  
  public static void O(Context paramContext, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(227897);
    if (!TextUtils.isEmpty(paramString1))
    {
      new StringBuilder("checkWriteGiftCode, giftCode=").append(paramString1).append(", tip=").append(paramString2);
      if (TextUtils.isEmpty(paramString1)) {}
    }
    try
    {
      ClipboardHelper.setText(MMApplicationContext.getContext(), "wx_ad_giftcode", paramString1);
      if ((!TextUtils.isEmpty(paramString2)) && (Util.milliSecondsToNow(Jzl) > 1500L))
      {
        Jzl = System.currentTimeMillis();
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199275);
            try
            {
              if ((this.val$context instanceof Activity))
              {
                boolean bool = ((Activity)this.val$context).isFinishing();
                if (bool)
                {
                  AppMethodBeat.o(199275);
                  return;
                }
              }
              w.cR(this.val$context, paramString2);
              AppMethodBeat.o(199275);
              return;
            }
            catch (Throwable localThrowable)
            {
              AppMethodBeat.o(199275);
            }
          }
        }, 800L);
      }
      AppMethodBeat.o(227897);
      return;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        new StringBuilder("writeDelayDeepLink exp=").append(paramString1.toString());
      }
    }
  }
  
  public static void kl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227894);
    new StringBuilder("writeDelayDeepLink, pkg=").append(paramString1).append(", pageUrl=").append(paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(227894);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wx_ad_pkgname", paramString1);
      localJSONObject.put("wx_ad_deeplink", paramString2);
      ClipboardHelper.setText(MMApplicationContext.getContext(), "wx_ad_deeplink", localJSONObject.toString());
      AppMethodBeat.o(227894);
      return;
    }
    catch (Throwable paramString1)
    {
      new StringBuilder("writeDelayDeepLink exp=").append(paramString1.toString());
      AppMethodBeat.o(227894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.a
 * JD-Core Version:    0.7.0.1
 */