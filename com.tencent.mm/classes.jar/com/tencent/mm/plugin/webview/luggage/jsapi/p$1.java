package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class p$1
  implements MMActivity.a
{
  p$1(p paramp, a.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6308);
    if (paramInt1 != (this.uTz.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(6308);
      return;
    }
    if (paramInt2 == -1)
    {
      this.njN.a("", null);
      AppMethodBeat.o(6308);
      return;
    }
    if (paramInt2 == 5)
    {
      HashMap localHashMap = new HashMap();
      paramInt1 = paramIntent.getIntExtra("key_jsapi_pay_err_code", 0);
      paramIntent = bo.nullAsNil(paramIntent.getStringExtra("key_jsapi_pay_err_msg"));
      localHashMap.put("err_code", Integer.valueOf(paramInt1));
      localHashMap.put("err_desc", paramIntent);
      ab.e("MicroMsg.JsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), paramIntent });
      this.njN.c("fail", localHashMap);
      AppMethodBeat.o(6308);
      return;
    }
    this.njN.a("cancel", null);
    AppMethodBeat.o(6308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.p.1
 * JD-Core Version:    0.7.0.1
 */