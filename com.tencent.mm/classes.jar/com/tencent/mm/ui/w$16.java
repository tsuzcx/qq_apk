package com.tencent.mm.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class w$16
  implements Runnable
{
  w$16(w paramw, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(141344);
    Object localObject = w.b(this.Wad);
    int i;
    if (this.qsT)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      String str = w.c(this.Wad).getString(a.k.idc_url);
      if (!Util.isNullOrNil(this.uDN)) {
        break label172;
      }
      localObject = w.c(this.Wad).getString(a.k.disaster_default_tips_default);
      label65:
      if (this.val$url == null) {
        break label180;
      }
      SpannableString localSpannableString = new SpannableString((String)localObject + str);
      localSpannableString.setSpan(new ForegroundColorSpan(-10119449), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
      w.d(this.Wad).setText(localSpannableString);
    }
    for (;;)
    {
      w.b(this.Wad).invalidate();
      w.e(this.Wad).invalidate();
      AppMethodBeat.o(141344);
      return;
      i = 8;
      break;
      label172:
      localObject = this.uDN;
      break label65;
      label180:
      Log.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
      w.d(this.Wad).setText((CharSequence)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.w.16
 * JD-Core Version:    0.7.0.1
 */