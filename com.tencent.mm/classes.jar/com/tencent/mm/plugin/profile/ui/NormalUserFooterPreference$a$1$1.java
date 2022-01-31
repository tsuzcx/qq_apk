package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    Object localObject1;
    Object localObject2;
    switch (paramMenuItem.getItemId())
    {
    case 8: 
    default: 
      return;
    case 2: 
      if (NormalUserFooterPreference.a(this.mYF.mYE.mYC).Bi())
      {
        s.n(NormalUserFooterPreference.a(this.mYF.mYE.mYC));
        h.bC(NormalUserFooterPreference.b(this.mYF.mYE.mYC), NormalUserFooterPreference.b(this.mYF.mYE.mYC).getString(R.l.contact_info_unset_favour_start_biz_tips));
      }
      for (;;)
      {
        paramMenuItem = this.mYF.mYE.mYC;
        au.Hx();
        NormalUserFooterPreference.a(paramMenuItem, c.Fw().abl(NormalUserFooterPreference.a(this.mYF.mYE.mYC).field_username));
        return;
        s.m(NormalUserFooterPreference.a(this.mYF.mYE.mYC));
        h.bC(NormalUserFooterPreference.b(this.mYF.mYE.mYC), NormalUserFooterPreference.b(this.mYF.mYE.mYC).getString(R.l.contact_info_favour_start_biz_tips));
      }
    case 3: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("sns_permission_userName", NormalUserFooterPreference.a(this.mYF.mYE.mYC).field_username);
      paramMenuItem.putExtra("sns_permission_anim", true);
      paramMenuItem.putExtra("sns_permission_block_scene", 1);
      d.b(NormalUserFooterPreference.b(this.mYF.mYE.mYC), "sns", ".ui.SnsPermissionUI", paramMenuItem);
      return;
    case 4: 
      paramMenuItem = this.mYF.mYE;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Select_Talker_Name", NormalUserFooterPreference.a(paramMenuItem.mYC).field_username);
      ((Intent)localObject1).putExtra("Select_block_List", NormalUserFooterPreference.a(paramMenuItem.mYC).field_username);
      ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
      ((Intent)localObject1).putExtra("Select_Send_Card", true);
      ((Intent)localObject1).putExtra("mutil_select_is_ret", true);
      com.tencent.mm.plugin.profile.a.eUR.a((Intent)localObject1, NormalUserFooterPreference.b(paramMenuItem.mYC));
      return;
    case 1: 
      this.mYF.mYE.mYC.ebu.bV("hide_btn");
      this.mYF.mYE.mYC.ebu.doNotify();
      NormalUserFooterPreference.a locala = this.mYF.mYE;
      paramMenuItem = locala.mYC;
      au.Hx();
      NormalUserFooterPreference.a(paramMenuItem, c.Fw().abl(NormalUserFooterPreference.a(locala.mYC).field_username));
      if (!com.tencent.mm.n.a.gR(NormalUserFooterPreference.a(locala.mYC).field_type))
      {
        locala.KW(NormalUserFooterPreference.a(locala.mYC).field_username);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(locala.mYC));
      localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(locala.mYC).field_username);
      localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(locala.mYC).getIntent().getStringExtra("Contact_RoomNickname"));
      localIntent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(locala.mYC).cCP);
      localObject2 = "";
      localObject1 = localObject2;
      String str;
      if (!NormalUserFooterPreference.a(locala.mYC).Bm())
      {
        localObject1 = NormalUserFooterPreference.b(locala.mYC).getIntent().getStringExtra("Contact_Mobile_MD5");
        str = NormalUserFooterPreference.b(locala.mYC).getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if ((!bk.bl((String)localObject1)) || (!bk.bl(str))) {
          break label764;
        }
        paramMenuItem = localObject3;
        if (!bk.bl(NormalUserFooterPreference.a(locala.mYC).field_username)) {
          paramMenuItem = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(NormalUserFooterPreference.a(locala.mYC).field_username);
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (paramMenuItem != null)
        {
          localObject1 = localObject2;
          if (!bk.bl(paramMenuItem.Wv())) {
            localObject1 = bk.pm(paramMenuItem.WD()).replace(" ", "");
          }
        }
        localIntent.putExtra("contact_phone_number_by_md5", (String)localObject1);
        com.tencent.mm.plugin.profile.a.eUR.n(localIntent, locala.mYC.mContext);
        return;
        if (bk.bl((String)localObject1))
        {
          paramMenuItem = localObject3;
          if (bk.bl(str)) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI((String)localObject1);
          if (localObject1 != null)
          {
            paramMenuItem = (MenuItem)localObject1;
            if (!bk.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wv())) {}
          }
          else
          {
            paramMenuItem = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI(str);
          }
        }
      }
    case 5: 
      if (NormalUserFooterPreference.a(this.mYF.mYE.mYC).Bg())
      {
        NormalUserFooterPreference.a.a(this.mYF.mYE);
        return;
      }
      paramMenuItem = View.inflate(this.mYF.mYE.mYC.mContext, R.i.mm_alert_checkbox, null);
      paramMenuItem.setPadding(0, 0, 0, 0);
      localObject1 = (TextView)paramMenuItem.findViewById(R.h.mm_alert_dialog_info);
      ((TextView)localObject1).setPadding(0, 0, 0, 0);
      if (ad.aaU(NormalUserFooterPreference.a(this.mYF.mYE.mYC).field_username))
      {
        paramInt = R.l.contact_info_movein_blacklist_confirm_for_openim;
        ((TextView)localObject1).setText(paramInt);
        localObject1 = (CheckBox)paramMenuItem.findViewById(R.h.mm_alert_dialog_cb);
        ((CheckBox)localObject1).setChecked(false);
        localObject2 = (TextView)paramMenuItem.findViewById(R.h.mm_alert_dialog_cb_txt);
        ((TextView)localObject2).setText(R.l.contact_info_movein_blacklist_expose_confirm);
        if (NormalUserFooterPreference.a(this.mYF.mYE.mYC).getSource() != 18) {
          break label1089;
        }
        ((CheckBox)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
      }
      for (;;)
      {
        h.a(this.mYF.mYE.mYC.mContext, true, this.mYF.mYE.mYC.mContext.getString(R.l.contact_info_movein_blacklist), paramMenuItem, this.mYF.mYE.mYC.mContext.getString(R.l.app_ok), this.mYF.mYE.mYC.mContext.getString(R.l.app_cancel), new NormalUserFooterPreference.a.1.1.1(this, (CheckBox)localObject1), null);
        return;
        paramInt = R.l.contact_info_movein_blacklist_confirm;
        break;
        ((CheckBox)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
    case 6: 
      localObject1 = View.inflate(this.mYF.mYE.mYC.mContext, R.i.mm_alert_checkbox, null);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      localObject2 = (TextView)((View)localObject1).findViewById(R.h.mm_alert_dialog_info);
      ((TextView)localObject2).setPadding(0, 0, 0, 0);
      if (s.hi(NormalUserFooterPreference.a(this.mYF.mYE.mYC).field_username))
      {
        paramMenuItem = this.mYF.mYE.mYC.mContext.getString(R.l.del_groupcard_warning, new Object[] { NormalUserFooterPreference.a(this.mYF.mYE.mYC).Bq() });
        ((TextView)localObject2).setText(paramMenuItem);
        paramMenuItem = (CheckBox)((View)localObject1).findViewById(R.h.mm_alert_dialog_cb);
        paramMenuItem.setChecked(false);
        localObject2 = (TextView)((View)localObject1).findViewById(R.h.mm_alert_dialog_cb_txt);
        ((TextView)localObject2).setText(R.l.contact_info_movein_blacklist_expose_confirm);
        if (NormalUserFooterPreference.a(this.mYF.mYE.mYC).getSource() != 18) {
          break label1430;
        }
        paramMenuItem.setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
      }
      for (;;)
      {
        h.a(this.mYF.mYE.mYC.mContext, true, this.mYF.mYE.mYC.mContext.getString(R.l.contact_info_delete_contact), (View)localObject1, this.mYF.mYE.mYC.mContext.getString(R.l.app_delete), this.mYF.mYE.mYC.mContext.getString(R.l.app_cancel), new NormalUserFooterPreference.a.1.1.2(this, paramMenuItem), null, R.e.alert_btn_color_warn);
        return;
        paramMenuItem = this.mYF.mYE.mYC.mContext.getString(R.l.del_contact_warning, new Object[] { NormalUserFooterPreference.a(this.mYF.mYE.mYC).Bq() });
        break;
        paramMenuItem.setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
    case 7: 
      label764:
      paramMenuItem = this.mYF.mYE;
      label1089:
      y.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.a(paramMenuItem.mYC).field_username);
      label1430:
      com.tencent.mm.plugin.base.model.b.U(NormalUserFooterPreference.b(paramMenuItem.mYC), NormalUserFooterPreference.a(paramMenuItem.mYC).field_username);
      ai.l(new NormalUserFooterPreference.a.10(paramMenuItem), 1000L);
      return;
    }
    NormalUserFooterPreference.a.c(this.mYF.mYE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1.1
 * JD-Core Version:    0.7.0.1
 */