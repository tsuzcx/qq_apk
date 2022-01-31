package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
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
    NormalUserHeaderPreference.c(this.siZ);
    paramView = this.siZ;
    au.Hx();
    Object localObject = c.Fw().abl(paramView.dnp.field_username);
    if ((localObject != null) && ((int)((a)localObject).dBe != 0) && (((ao)localObject).field_username.equals(paramView.dnp.field_username))) {
      paramView.dnp = ((ad)localObject);
    }
    if (!a.gR(paramView.dnp.field_type))
    {
      localObject = new Intent();
      ((Intent)localObject).setClassName(paramView.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
      ((Intent)localObject).putExtra("Contact_Scene", paramView.ocd);
      ((Intent)localObject).putExtra("Contact_mode_name_type", 0);
      ((Intent)localObject).putExtra("Contact_ModStrangerRemark", true);
      ((Intent)localObject).putExtra("Contact_User", paramView.dnp.field_username);
      ((Intent)localObject).putExtra("Contact_Nick", paramView.dnp.field_nickname);
      ((Intent)localObject).putExtra("Contact_RemarkName", paramView.dnp.field_conRemark);
      ((Activity)paramView.mContext).startActivity((Intent)localObject);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).setClassName(paramView.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
    ((Intent)localObject).putExtra("Contact_Scene", paramView.ocd);
    ((Intent)localObject).putExtra("Contact_User", paramView.dnp.field_username);
    ((Intent)localObject).putExtra("Contact_RoomNickname", paramView.bER.getIntent().getStringExtra("Contact_RoomNickname"));
    ((Activity)paramView.mContext).startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.3
 * JD-Core Version:    0.7.0.1
 */