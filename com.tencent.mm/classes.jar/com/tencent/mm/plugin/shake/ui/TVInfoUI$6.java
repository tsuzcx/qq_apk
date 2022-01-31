package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.ce;
import com.tencent.mm.h.a.ce.a;
import com.tencent.mm.h.a.ce.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;

final class TVInfoUI$6
  implements h.d
{
  TVInfoUI$6(TVInfoUI paramTVInfoUI) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case -1: 
      h.a(this.odI.mController.uMN, this.odI.mController.uMN.getString(R.l.app_delete_tips), null, null, this.odI.mController.uMN.getString(R.l.app_delete), new h.d()
      {
        public final void bF(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          switch (paramAnonymousInt2)
          {
          default: 
            y.d("MicroMsg.TVInfoUI", "do del cancel");
          }
          ce localce;
          do
          {
            return;
            localce = new ce();
            localce.bIp.bIr = TVInfoUI.6.this.odI.getIntent().getLongExtra("key_favorite_local_id", -1L);
            a.udP.m(localce);
            y.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[] { Long.valueOf(localce.bIp.bIr), Boolean.valueOf(localce.bIq.bIe) });
          } while (!localce.bIq.bIe);
          TVInfoUI.6.this.odI.finish();
        }
      });
      return;
    case 0: 
      TVInfoUI.b(this.odI);
      return;
    case 1: 
      TVInfoUI.c(this.odI);
      return;
    }
    TVInfoUI.d(this.odI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.6
 * JD-Core Version:    0.7.0.1
 */