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

final class b$7
  implements Preference.b
{
  b$7(b paramb, erh paramerh, eaa parameaa) {}
  
  public final boolean fpI()
  {
    AppMethodBeat.i(275278);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayHKNotify", "text(%s) click!", new Object[] { ((ere)this.OUW.Uty.get(0)).text });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_tiny_app_scene", 1165);
    k.a(b.d(this.OUY), this.OUX, localBundle);
    AppMethodBeat.o(275278);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b.7
 * JD-Core Version:    0.7.0.1
 */