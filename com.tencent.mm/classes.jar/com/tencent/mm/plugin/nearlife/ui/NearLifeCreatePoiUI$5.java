package com.tencent.mm.plugin.nearlife.ui;

import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class NearLifeCreatePoiUI$5
  implements c.a
{
  NearLifeCreatePoiUI$5(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void b(Addr paramAddr)
  {
    AppMethodBeat.i(26602);
    String str1 = Util.nullAsNil(paramAddr.iUQ) + Util.nullAsNil(paramAddr.iUS);
    String str2 = Util.nullAsNil(paramAddr.iUT) + Util.nullAsNil(paramAddr.iUU);
    Log.d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str1)));
    if (Util.isNullOrNil(NearLifeCreatePoiUI.e(this.ACu).getText().toString())) {
      NearLifeCreatePoiUI.e(this.ACu).setText(str1);
    }
    if ((Util.isNullOrNil(NearLifeCreatePoiUI.f(this.ACu).getText().toString())) && (!Util.isNullOrNil(str2))) {
      NearLifeCreatePoiUI.f(this.ACu).setText(str2);
    }
    NearLifeCreatePoiUI.a(this.ACu, paramAddr);
    AppMethodBeat.o(26602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.5
 * JD-Core Version:    0.7.0.1
 */