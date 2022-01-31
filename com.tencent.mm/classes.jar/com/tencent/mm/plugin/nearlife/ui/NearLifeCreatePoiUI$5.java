package com.tencent.mm.plugin.nearlife.ui;

import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class NearLifeCreatePoiUI$5
  implements b.a
{
  NearLifeCreatePoiUI$5(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void b(Addr paramAddr)
  {
    String str1 = bk.pm(paramAddr.elb) + bk.pm(paramAddr.eld);
    String str2 = bk.pm(paramAddr.ele) + bk.pm(paramAddr.elf);
    y.d("MicroMsg.NearLifeCreatePoiUI", "get address:" + str1);
    if (bk.bl(NearLifeCreatePoiUI.e(this.mFF).getText().toString())) {
      NearLifeCreatePoiUI.e(this.mFF).setText(str1);
    }
    if ((bk.bl(NearLifeCreatePoiUI.f(this.mFF).getText().toString())) && (!bk.bl(str2))) {
      NearLifeCreatePoiUI.f(this.mFF).setText(str2);
    }
    NearLifeCreatePoiUI.a(this.mFF, paramAddr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.5
 * JD-Core Version:    0.7.0.1
 */