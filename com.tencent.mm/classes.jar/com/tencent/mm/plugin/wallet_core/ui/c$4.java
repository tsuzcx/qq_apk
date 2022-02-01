package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference.b;
import java.util.LinkedList;

final class c$4
  implements Preference.b
{
  c$4(c paramc, erh paramerh, eaa parameaa) {}
  
  public final boolean fpI()
  {
    AppMethodBeat.i(70639);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "text(%s) click!", new Object[] { ((ere)this.OUW.Uty.get(0)).text });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_tiny_app_scene", 1000);
    k.a(c.b(this.OVc), this.OUX, localBundle);
    AppMethodBeat.o(70639);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.c.4
 * JD-Core Version:    0.7.0.1
 */