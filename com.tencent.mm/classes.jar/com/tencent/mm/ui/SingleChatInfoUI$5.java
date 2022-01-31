package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.e;

final class SingleChatInfoUI$5
  implements ContactListExpandPreference.a
{
  SingleChatInfoUI$5(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final void JR()
  {
    AppMethodBeat.i(29871);
    if (SingleChatInfoUI.c(this.zfe) != null) {
      SingleChatInfoUI.c(this.zfe).dnF();
    }
    AppMethodBeat.o(29871);
  }
  
  public final void iw(int paramInt) {}
  
  public final void ix(int paramInt)
  {
    AppMethodBeat.i(29870);
    String str = SingleChatInfoUI.c(this.zfe).Mb(paramInt);
    Object localObject2 = ah.nullAsNil(SingleChatInfoUI.c(this.zfe).Md(paramInt));
    Object localObject1 = localObject2;
    if (ah.isNullOrNil((String)localObject2))
    {
      aw.aaz();
      bv localbv = c.YB().TM(str);
      localObject1 = localObject2;
      if (localbv != null)
      {
        localObject1 = localObject2;
        if (!ah.isNullOrNil(localbv.field_encryptUsername)) {
          localObject1 = localbv.field_conRemark;
        }
      }
    }
    if (ah.isNullOrNil(str))
    {
      AppMethodBeat.o(29870);
      return;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("Contact_User", str);
    ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
    ((Intent)localObject2).putExtra("Contact_Nick", ah.nullAsNil(SingleChatInfoUI.c(this.zfe).Mc(paramInt)));
    ((Intent)localObject2).putExtra("Contact_RoomMember", true);
    ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", 9);
    localObject1 = ((j)g.E(j.class)).YA().arw(str);
    if ((localObject1 != null) && ((int)((a)localObject1).euF > 0) && (a.je(((aq)localObject1).field_type))) {
      e.a((Intent)localObject2, str);
    }
    ((Intent)localObject2).putExtra("Kdel_from", 0);
    d.b(this.zfe, "profile", ".ui.ContactInfoUI", (Intent)localObject2, 0);
    AppMethodBeat.o(29870);
  }
  
  public final void iy(int paramInt)
  {
    AppMethodBeat.i(29872);
    SingleChatInfoUI.d(this.zfe);
    AppMethodBeat.o(29872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.5
 * JD-Core Version:    0.7.0.1
 */