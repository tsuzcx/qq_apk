package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;
import org.xwalk.core.Log;
import org.xwalk.core.R.array;
import org.xwalk.core.R.id;

final class a$40
  implements RadioGroup.OnCheckedChangeListener
{
  a$40(a parama) {}
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (this.xlg.xle) {}
    for (;;)
    {
      return;
      paramRadioGroup = WebView.d.xhn;
      if (paramInt == R.id.WV_AUTO) {
        paramRadioGroup = WebView.d.xhn;
      }
      while (!this.xlg.xlf.equals("all"))
      {
        k.cSk().a(this.xlg.xlf, paramRadioGroup);
        Log.d("WebDebugPage", "webview change to=" + paramRadioGroup);
        return;
        if (paramInt == R.id.WV_XWALK) {
          paramRadioGroup = WebView.d.xho;
        } else if (paramInt == R.id.WV_X5) {
          paramRadioGroup = WebView.d.xhp;
        } else if (paramInt == R.id.WV_SYS) {
          paramRadioGroup = WebView.d.xhq;
        }
      }
      String[] arrayOfString = this.xlg.xgK.getResources().getStringArray(R.array.webviewmodules);
      paramInt = 0;
      while (paramInt < arrayOfString.length)
      {
        k.cSk().a(arrayOfString[paramInt], paramRadioGroup);
        Log.d("WebDebugPage", "webview " + arrayOfString[paramInt] + " change to=" + paramRadioGroup);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.40
 * JD-Core Version:    0.7.0.1
 */