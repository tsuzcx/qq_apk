package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference.b;
import java.util.LinkedList;

final class a$4
  implements Preference.b
{
  a$4(a parama, erh paramerh, eaa parameaa) {}
  
  public final boolean fpI()
  {
    AppMethodBeat.i(212472);
    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "text(%s) click!", new Object[] { ((ere)this.OUW.Uty.get(0)).text });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_tiny_app_scene", 1165);
    k.a(a.b(this.OUT), this.OUX, localBundle);
    h.IzE.a(19541, new Object[] { Integer.valueOf(1), ((ere)this.OUW.Uty.get(0)).text });
    AppMethodBeat.o(212472);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a.4
 * JD-Core Version:    0.7.0.1
 */