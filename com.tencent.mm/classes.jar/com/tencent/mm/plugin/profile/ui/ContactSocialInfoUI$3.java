package com.tencent.mm.plugin.profile.ui;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.e.b;
import com.tencent.mm.ag.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ContactSocialInfoUI$3
  implements e.b
{
  ContactSocialInfoUI$3(ContactSocialInfoUI paramContactSocialInfoUI, e parame, String paramString1, String paramString2) {}
  
  public final int bl(int paramInt1, int paramInt2)
  {
    this.eba.JU();
    y.i("MicroMsg.ContactSocialInfoUI", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      o.JQ();
      Bitmap localBitmap = d.kh(this.dol);
      if (ContactSocialInfoUI.a(this.mWI, this.mWK, localBitmap))
      {
        Toast.makeText(this.mWI.mController.uMN, this.mWI.mController.uMN.getString(R.l.contact_info_save_avater_ok), 0).show();
        return 0;
      }
    }
    Toast.makeText(this.mWI.mController.uMN, this.mWI.mController.uMN.getString(R.l.contact_info_save_avater_fail), 0).show();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI.3
 * JD-Core Version:    0.7.0.1
 */