package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class n$1
  implements MMActivity.a
{
  n$1(n paramn, a.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != (this.rdC.hashCode() & 0xFFFF)) {
      return;
    }
    if (paramInt2 == -1)
    {
      this.kNj.a("", null);
      return;
    }
    if (paramInt2 == 5)
    {
      HashMap localHashMap = new HashMap();
      paramInt1 = paramIntent.getIntExtra("key_jsapi_pay_err_code", 0);
      paramIntent = bk.pm(paramIntent.getStringExtra("key_jsapi_pay_err_msg"));
      localHashMap.put("err_code", Integer.valueOf(paramInt1));
      localHashMap.put("err_desc", paramIntent);
      y.e("MicroMsg.JsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), paramIntent });
      this.kNj.c("fail", localHashMap);
      return;
    }
    this.kNj.a("cancel", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.n.1
 * JD-Core Version:    0.7.0.1
 */