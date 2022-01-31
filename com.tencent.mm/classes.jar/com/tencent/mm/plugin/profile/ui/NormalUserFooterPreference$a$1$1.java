package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalUserFooterPreference$a$1$1
  implements n.d
{
  NormalUserFooterPreference$a$1$1(NormalUserFooterPreference.a.1 param1) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(23674);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23674);
      return;
      if (NormalUserFooterPreference.a(this.pCg.pCf.pCe).NY())
      {
        t.n(NormalUserFooterPreference.a(this.pCg.pCf.pCe));
        h.bO(NormalUserFooterPreference.b(this.pCg.pCf.pCe), NormalUserFooterPreference.b(this.pCg.pCf.pCe).getString(2131298823));
      }
      for (;;)
      {
        paramMenuItem = this.pCg.pCf.pCe;
        aw.aaz();
        NormalUserFooterPreference.a(paramMenuItem, c.YA().arw(NormalUserFooterPreference.a(this.pCg.pCf.pCe).field_username));
        AppMethodBeat.o(23674);
        return;
        t.m(NormalUserFooterPreference.a(this.pCg.pCf.pCe));
        h.bO(NormalUserFooterPreference.b(this.pCg.pCf.pCe), NormalUserFooterPreference.b(this.pCg.pCf.pCe).getString(2131298605));
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("sns_permission_userName", NormalUserFooterPreference.a(this.pCg.pCf.pCe).field_username);
      paramMenuItem.putExtra("sns_permission_anim", true);
      paramMenuItem.putExtra("sns_permission_block_scene", 1);
      d.b(NormalUserFooterPreference.b(this.pCg.pCf.pCe), "sns", ".ui.SnsPermissionUI", paramMenuItem);
      AppMethodBeat.o(23674);
      return;
      paramMenuItem = this.pCg.pCf;
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Select_Talker_Name", NormalUserFooterPreference.a(paramMenuItem.pCe).field_username);
      ((Intent)localObject1).putExtra("Select_block_List", NormalUserFooterPreference.a(paramMenuItem.pCe).field_username);
      ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
      ((Intent)localObject1).putExtra("Select_Send_Card", true);
      ((Intent)localObject1).putExtra("mutil_select_is_ret", true);
      com.tencent.mm.plugin.profile.b.gmO.a((Intent)localObject1, NormalUserFooterPreference.b(paramMenuItem.pCe));
      AppMethodBeat.o(23674);
      return;
      this.pCg.pCf.pCe.frK.cy("hide_btn");
      this.pCg.pCf.pCe.frK.doNotify();
      NormalUserFooterPreference.a locala = this.pCg.pCf;
      paramMenuItem = locala.pCe;
      aw.aaz();
      NormalUserFooterPreference.a(paramMenuItem, c.YA().arw(NormalUserFooterPreference.a(locala.pCe).field_username));
      if (!com.tencent.mm.n.a.je(NormalUserFooterPreference.a(locala.pCe).field_type))
      {
        locala.Xg(NormalUserFooterPreference.a(locala.pCe).field_username);
        AppMethodBeat.o(23674);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(locala.pCe));
      localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(locala.pCe).field_username);
      localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(locala.pCe).getIntent().getStringExtra("Contact_RoomNickname"));
      localIntent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(locala.pCe).dqZ);
      Object localObject2 = "";
      localObject1 = localObject2;
      String str;
      if (!NormalUserFooterPreference.a(locala.pCe).Ob())
      {
        localObject1 = NormalUserFooterPreference.b(locala.pCe).getIntent().getStringExtra("Contact_Mobile_MD5");
        str = NormalUserFooterPreference.b(locala.pCe).getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if ((!bo.isNullOrNil((String)localObject1)) || (!bo.isNullOrNil(str))) {
          break label803;
        }
        paramMenuItem = localObject3;
        if (!bo.isNullOrNil(NormalUserFooterPreference.a(locala.pCe).field_username)) {
          paramMenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(NormalUserFooterPreference.a(locala.pCe).field_username);
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (paramMenuItem != null)
        {
          localObject1 = localObject2;
          if (!bo.isNullOrNil(paramMenuItem.Al())) {
            localObject1 = bo.nullAsNil(paramMenuItem.aqf()).replace(" ", "");
          }
        }
        localIntent.putExtra("contact_phone_number_by_md5", (String)localObject1);
        com.tencent.mm.plugin.profile.b.gmO.m(localIntent, locala.pCe.mContext);
        AppMethodBeat.o(23674);
        return;
        label803:
        if (bo.isNullOrNil((String)localObject1))
        {
          paramMenuItem = localObject3;
          if (bo.isNullOrNil(str)) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject1);
          if (localObject1 != null)
          {
            paramMenuItem = (MenuItem)localObject1;
            if (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Al())) {}
          }
          else
          {
            paramMenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(str);
          }
        }
      }
      if (NormalUserFooterPreference.a(this.pCg.pCf.pCe).NW())
      {
        NormalUserFooterPreference.a.a(this.pCg.pCf);
        AppMethodBeat.o(23674);
        return;
      }
      paramMenuItem = View.inflate(this.pCg.pCf.pCe.mContext, 2130970141, null);
      paramMenuItem.setPadding(0, 0, 0, 0);
      localObject1 = (TextView)paramMenuItem.findViewById(2131826140);
      ((TextView)localObject1).setPadding(0, 0, 0, 0);
      if (ad.arf(NormalUserFooterPreference.a(this.pCg.pCf.pCe).field_username))
      {
        paramInt = 2131298677;
        ((TextView)localObject1).setText(paramInt);
        localObject1 = (CheckBox)paramMenuItem.findViewById(2131826141);
        ((CheckBox)localObject1).setChecked(false);
        localObject2 = (TextView)paramMenuItem.findViewById(2131826142);
        ((TextView)localObject2).setText(2131298678);
        if (NormalUserFooterPreference.a(this.pCg.pCf.pCe).getSource() != 18) {
          break label1140;
        }
        ((CheckBox)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
      }
      for (;;)
      {
        h.a(this.pCg.pCf.pCe.mContext, true, this.pCg.pCf.pCe.mContext.getString(2131298675), paramMenuItem, this.pCg.pCf.pCe.mContext.getString(2131297018), this.pCg.pCf.pCe.mContext.getString(2131296888), new NormalUserFooterPreference.a.1.1.1(this, (CheckBox)localObject1), null);
        AppMethodBeat.o(23674);
        return;
        paramInt = 2131298676;
        break;
        label1140:
        ((CheckBox)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
      localObject1 = View.inflate(this.pCg.pCf.pCe.mContext, 2130970141, null);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      localObject2 = (TextView)((View)localObject1).findViewById(2131826140);
      ((TextView)localObject2).setPadding(0, 0, 0, 0);
      if (t.nR(NormalUserFooterPreference.a(this.pCg.pCf.pCe).field_username))
      {
        paramMenuItem = this.pCg.pCf.pCe.mContext.getString(2131298937, new Object[] { NormalUserFooterPreference.a(this.pCg.pCf.pCe).Of() });
        ((TextView)localObject2).setText(paramMenuItem);
        paramMenuItem = (CheckBox)((View)localObject1).findViewById(2131826141);
        paramMenuItem.setChecked(false);
        localObject2 = (TextView)((View)localObject1).findViewById(2131826142);
        ((TextView)localObject2).setText(2131298678);
        if (NormalUserFooterPreference.a(this.pCg.pCf.pCe).getSource() != 18) {
          break label1487;
        }
        paramMenuItem.setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
      }
      for (;;)
      {
        h.a(this.pCg.pCf.pCe.mContext, true, this.pCg.pCf.pCe.mContext.getString(2131298582), (View)localObject1, this.pCg.pCf.pCe.mContext.getString(2131296901), this.pCg.pCf.pCe.mContext.getString(2131296888), new NormalUserFooterPreference.a.1.1.2(this, paramMenuItem), null, 2131689667);
        AppMethodBeat.o(23674);
        return;
        paramMenuItem = this.pCg.pCf.pCe.mContext.getString(2131298935, new Object[] { NormalUserFooterPreference.a(this.pCg.pCf.pCe).Of() });
        break;
        label1487:
        paramMenuItem.setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
      paramMenuItem = this.pCg.pCf;
      ab.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.a(paramMenuItem.pCe).field_username);
      com.tencent.mm.plugin.base.model.b.Z(NormalUserFooterPreference.b(paramMenuItem.pCe), NormalUserFooterPreference.a(paramMenuItem.pCe).field_username);
      al.p(new NormalUserFooterPreference.a.10(paramMenuItem), 1000L);
      AppMethodBeat.o(23674);
      return;
      NormalUserFooterPreference.a.c(this.pCg.pCf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1.1
 * JD-Core Version:    0.7.0.1
 */