package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$2$2$2
  extends ad
{
  a$2$2$2(a.2.2 param2) {}
  
  public final void qt(String paramString)
  {
    AppMethodBeat.i(91380);
    ab.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onMakePhoneCall" });
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramString))));
      paramString.addFlags(268435456);
      if (bo.k(a.g(this.uLV.uLU.uLR), paramString)) {
        a.g(this.uLV.uLU.uLR).startActivity(paramString);
      }
      AppMethodBeat.o(91380);
      return;
    }
    ab.e("FTSSearchWidgetMgr", "onMakePhone null number");
    AppMethodBeat.o(91380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.2.2
 * JD-Core Version:    0.7.0.1
 */