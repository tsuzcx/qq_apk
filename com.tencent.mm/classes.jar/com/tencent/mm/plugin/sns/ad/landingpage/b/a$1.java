package com.tencent.mm.plugin.sns.ad.landingpage.b;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class a$1
  implements AdLandingPagesProxy.e
{
  public a$1(WeakReference paramWeakReference, String paramString) {}
  
  public final void aH(Object paramObject)
  {
    AppMethodBeat.i(202045);
    Log.i("LandingPageOpenSdkBackHelper", "getOpenSdkAppInfo, ret=".concat(String.valueOf(paramObject)));
    String str2 = "";
    final String str1 = str2;
    if ((paramObject instanceof String)) {}
    try
    {
      str1 = new JSONObject((String)paramObject).optString("name");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226602);
          TextView localTextView = (TextView)a.1.this.JDH.get();
          if (localTextView != null)
          {
            if (!TextUtils.isEmpty(str1))
            {
              localTextView.setText(a.1.this.JDI + str1);
              AppMethodBeat.o(226602);
            }
          }
          else {
            Log.w("LandingPageOpenSdkBackHelper", "getOpenSdkAppInfo, backTxtViewRef get null");
          }
          AppMethodBeat.o(226602);
        }
      });
      AppMethodBeat.o(202045);
      return;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        str1 = str2;
      }
    }
  }
  
  public final void i(int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.b.a.1
 * JD-Core Version:    0.7.0.1
 */