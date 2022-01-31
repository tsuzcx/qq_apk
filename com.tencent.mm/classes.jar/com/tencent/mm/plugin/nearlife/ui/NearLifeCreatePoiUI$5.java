package com.tencent.mm.plugin.nearlife.ui;

import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class NearLifeCreatePoiUI$5
  implements c.a
{
  NearLifeCreatePoiUI$5(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void b(Addr paramAddr)
  {
    AppMethodBeat.i(22976);
    String str1 = bo.nullAsNil(paramAddr.fBs) + bo.nullAsNil(paramAddr.fBu);
    String str2 = bo.nullAsNil(paramAddr.fBv) + bo.nullAsNil(paramAddr.fBw);
    ab.d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str1)));
    if (bo.isNullOrNil(NearLifeCreatePoiUI.e(this.pfL).getText().toString())) {
      NearLifeCreatePoiUI.e(this.pfL).setText(str1);
    }
    if ((bo.isNullOrNil(NearLifeCreatePoiUI.f(this.pfL).getText().toString())) && (!bo.isNullOrNil(str2))) {
      NearLifeCreatePoiUI.f(this.pfL).setText(str2);
    }
    NearLifeCreatePoiUI.a(this.pfL, paramAddr);
    AppMethodBeat.o(22976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.5
 * JD-Core Version:    0.7.0.1
 */