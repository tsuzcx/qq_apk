package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalUserHeaderPreference$3
  implements View.OnClickListener
{
  NormalUserHeaderPreference$3(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28073);
    NormalUserHeaderPreference.c(this.wbA);
    paramView = this.wbA;
    aw.aaz();
    Object localObject = c.YA().arw(paramView.contact.field_username);
    if ((localObject != null) && ((int)((a)localObject).euF != 0) && (((aq)localObject).field_username.equals(paramView.contact.field_username))) {
      paramView.contact = ((ad)localObject);
    }
    if (!a.je(paramView.contact.field_type))
    {
      localObject = new Intent();
      ((Intent)localObject).setClassName(paramView.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
      ((Intent)localObject).putExtra("Contact_Scene", paramView.qQk);
      ((Intent)localObject).putExtra("Contact_mode_name_type", 0);
      ((Intent)localObject).putExtra("Contact_ModStrangerRemark", true);
      ((Intent)localObject).putExtra("Contact_User", paramView.contact.field_username);
      ((Intent)localObject).putExtra("Contact_Nick", paramView.contact.field_nickname);
      ((Intent)localObject).putExtra("Contact_RemarkName", paramView.contact.field_conRemark);
      ((Activity)paramView.mContext).startActivity((Intent)localObject);
      AppMethodBeat.o(28073);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).setClassName(paramView.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
    ((Intent)localObject).putExtra("Contact_Scene", paramView.qQk);
    ((Intent)localObject).putExtra("Contact_User", paramView.contact.field_username);
    ((Intent)localObject).putExtra("Contact_RoomNickname", paramView.cmc.getIntent().getStringExtra("Contact_RoomNickname"));
    ((Activity)paramView.mContext).startActivity((Intent)localObject);
    AppMethodBeat.o(28073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.3
 * JD-Core Version:    0.7.0.1
 */