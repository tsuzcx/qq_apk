package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$2$1$7
  extends ab
{
  a$2$1$7(a.2.1 param1) {}
  
  public final void jD(String paramString)
  {
    y.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onMakePhoneCall" });
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString));
      paramString.addFlags(268435456);
      if (bk.i(a.e(this.qWN.qWI.qWF), paramString)) {
        a.e(this.qWN.qWI.qWF).startActivity(paramString);
      }
      return;
    }
    y.e("FTSSearchWidgetMgr", "onMakePhone null number");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.1.7
 * JD-Core Version:    0.7.0.1
 */