package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.q;
import org.xwalk.core.Log;

final class c$51
  implements RadioGroup.OnCheckedChangeListener
{
  c$51(c paramc) {}
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    AppMethodBeat.i(85174);
    if (this.BIO.BIL)
    {
      AppMethodBeat.o(85174);
      return;
    }
    paramRadioGroup = WebView.d.BEp;
    if (paramInt == 2131823321) {
      paramRadioGroup = WebView.d.BEp;
    }
    while (!this.BIO.BIM.equals("all"))
    {
      q.dYn().a(this.BIO.BIM, paramRadioGroup);
      Log.d("WebDebugPage", "webview change to=".concat(String.valueOf(paramRadioGroup)));
      AppMethodBeat.o(85174);
      return;
      if (paramInt == 2131823322) {
        paramRadioGroup = WebView.d.BEq;
      } else if (paramInt == 2131823324) {
        paramRadioGroup = WebView.d.BEr;
      } else if (paramInt == 2131823323) {
        paramRadioGroup = WebView.d.BEs;
      }
    }
    String[] arrayOfString = this.BIO.BDH.getResources().getStringArray(2131755069);
    paramInt = 0;
    while (paramInt < arrayOfString.length)
    {
      q.dYn().a(arrayOfString[paramInt], paramRadioGroup);
      Log.d("WebDebugPage", "webview " + arrayOfString[paramInt] + " change to=" + paramRadioGroup);
      paramInt += 1;
    }
    AppMethodBeat.o(85174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.51
 * JD-Core Version:    0.7.0.1
 */