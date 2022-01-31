package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;

final class ContactSocialInfoUI$2
  implements h.c
{
  ContactSocialInfoUI$2(ContactSocialInfoUI paramContactSocialInfoUI, String[] paramArrayOfString) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(23441);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23441);
      return;
      if ((ContactSocialInfoUI.a(this.pzE) == null) || (ContactSocialInfoUI.a(this.pzE).length() == 0))
      {
        AppMethodBeat.o(23441);
        return;
      }
      paramInt = ContactSocialInfoUI.a(this.pzE).lastIndexOf(' ') + 1;
      if (paramInt > 0)
      {
        ContactSocialInfoUI.a(this.pzE, ContactSocialInfoUI.a(this.pzE).substring(paramInt));
        AppMethodBeat.o(23441);
        return;
        if ((ContactSocialInfoUI.a(this.pzE) == null) || (ContactSocialInfoUI.a(this.pzE).length() == 0))
        {
          AppMethodBeat.o(23441);
          return;
        }
        paramInt = ContactSocialInfoUI.a(this.pzE).lastIndexOf(' ');
        Object localObject = ContactSocialInfoUI.a(this.pzE).substring(0, paramInt);
        if ((localObject == null) || (((String)localObject).length() == 0))
        {
          AppMethodBeat.o(23441);
          return;
        }
        t.b(ContactSocialInfoUI.b(this.pzE), ((String)localObject).trim());
        AppMethodBeat.o(23441);
        return;
        if ((this.hKi == null) || (this.hKi.length <= 2) || (ContactSocialInfoUI.c(this.pzE) == null) || (ContactSocialInfoUI.b(this.pzE) == null))
        {
          AppMethodBeat.o(23441);
          return;
        }
        if ((ContactSocialInfoUI.c(this.pzE) != null) && (!bo.isNullOrNil(ContactSocialInfoUI.c(this.pzE).fsf)))
        {
          ContactSocialInfoUI.a(this.pzE, ContactSocialInfoUI.b(this.pzE).field_username, ContactSocialInfoUI.c(this.pzE).fsf);
          AppMethodBeat.o(23441);
          return;
        }
        localObject = new Intent();
        Bundle localBundle = new Bundle();
        localBundle.putInt("fromScene", 2);
        ((Intent)localObject).putExtra("reportArgs", localBundle);
        b.gmO.j((Intent)localObject, this.pzE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI.2
 * JD-Core Version:    0.7.0.1
 */