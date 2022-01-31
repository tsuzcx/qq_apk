package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.e;

final class SingleChatInfoUI$3
  implements ContactListExpandPreference.a
{
  SingleChatInfoUI$3(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final void gh(int paramInt) {}
  
  public final void gi(int paramInt)
  {
    String str = SingleChatInfoUI.b(this.uQS).Ed(paramInt);
    Object localObject2 = ah.pm(SingleChatInfoUI.b(this.uQS).Ef(paramInt));
    Object localObject1 = localObject2;
    if (ah.bl((String)localObject2))
    {
      au.Hx();
      bv localbv = c.Fx().Id(str);
      localObject1 = localObject2;
      if (localbv != null)
      {
        localObject1 = localObject2;
        if (!ah.bl(localbv.field_encryptUsername)) {
          localObject1 = localbv.field_conRemark;
        }
      }
    }
    if (ah.bl(str)) {
      return;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("Contact_User", str);
    ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
    ((Intent)localObject2).putExtra("Contact_Nick", ah.pm(SingleChatInfoUI.b(this.uQS).Ee(paramInt)));
    ((Intent)localObject2).putExtra("Contact_RoomMember", true);
    localObject1 = ((j)g.r(j.class)).Fw().abl(str);
    if ((localObject1 != null) && ((int)((a)localObject1).dBe > 0) && (a.gR(((ao)localObject1).field_type))) {
      e.a((Intent)localObject2, str);
    }
    ((Intent)localObject2).putExtra("Kdel_from", 0);
    ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", 9);
    d.b(this.uQS, "profile", ".ui.ContactInfoUI", (Intent)localObject2, 0);
  }
  
  public final void gj(int paramInt)
  {
    SingleChatInfoUI.c(this.uQS);
  }
  
  public final void xy()
  {
    if (SingleChatInfoUI.b(this.uQS) != null) {
      SingleChatInfoUI.b(this.uQS).cmP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.3
 * JD-Core Version:    0.7.0.1
 */