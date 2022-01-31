package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h.c;

final class ContactSocialInfoUI$2
  implements h.c
{
  ContactSocialInfoUI$2(ContactSocialInfoUI paramContactSocialInfoUI, String[] paramArrayOfString) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while ((ContactSocialInfoUI.a(this.mWI) == null) || (ContactSocialInfoUI.a(this.mWI).length() == 0));
              paramInt = ContactSocialInfoUI.a(this.mWI).lastIndexOf(' ') + 1;
            } while (paramInt <= 0);
            ContactSocialInfoUI.a(this.mWI, ContactSocialInfoUI.a(this.mWI).substring(paramInt));
            return;
          } while ((ContactSocialInfoUI.a(this.mWI) == null) || (ContactSocialInfoUI.a(this.mWI).length() == 0));
          paramInt = ContactSocialInfoUI.a(this.mWI).lastIndexOf(' ');
          localObject = ContactSocialInfoUI.a(this.mWI).substring(0, paramInt);
        } while ((localObject == null) || (((String)localObject).length() == 0));
        s.b(ContactSocialInfoUI.b(this.mWI), ((String)localObject).trim());
        return;
      } while ((this.mWJ == null) || (this.mWJ.length <= 2) || (ContactSocialInfoUI.c(this.mWI) == null) || (ContactSocialInfoUI.b(this.mWI) == null));
      if ((ContactSocialInfoUI.c(this.mWI) != null) && (!bk.bl(ContactSocialInfoUI.c(this.mWI).ebN)))
      {
        ContactSocialInfoUI.a(this.mWI, ContactSocialInfoUI.b(this.mWI).field_username, ContactSocialInfoUI.c(this.mWI).ebN);
        return;
      }
      break;
    }
    Object localObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromScene", 2);
    ((Intent)localObject).putExtra("reportArgs", localBundle);
    com.tencent.mm.plugin.profile.a.eUR.k((Intent)localObject, this.mWI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI.2
 * JD-Core Version:    0.7.0.1
 */