package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.at.b;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public final class e
  implements com.tencent.mm.pluginsdk.b.a
{
  Context context;
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  boolean isDeleteCancel = false;
  private boolean mVI;
  private HelperHeaderPreference.a mXd;
  private int status;
  p tipDialog = null;
  
  public e(Context paramContext)
  {
    this.context = paramContext;
    this.mXd = new o(paramContext);
    this.status = -1;
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      au.Hx();
      c.Dz().o(7, Integer.valueOf(this.status));
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      au.Hx();
      c.Fv().b(new com.tencent.mm.ay.f(paramInt2, paramInt1));
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private boolean wb(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    boolean bool;
    label22:
    CheckBoxPreference localCheckBoxPreference1;
    CheckBoxPreference localCheckBoxPreference2;
    CheckBoxPreference localCheckBoxPreference3;
    if (paramf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramad == null) {
        break label354;
      }
      bool = true;
      Assert.assertTrue(bool);
      Assert.assertTrue(s.hp(paramad.field_username));
      this.dnn = paramf;
      this.mVI = paramBoolean;
      this.dnp = paramad;
      if (this.status == -1) {
        this.status = q.Gn();
      }
      paramf.addPreferencesFromResource(R.o.contact_info_pref_fmessage);
      localCheckBoxPreference1 = (CheckBoxPreference)paramf.add("contact_info_recommend_qqfriends_to_me");
      localCheckBoxPreference2 = (CheckBoxPreference)paramf.add("contact_info_recommend_mobilefriends_to_me");
      localCheckBoxPreference3 = (CheckBoxPreference)paramf.add("contact_info_recommend_fbfriends_to_me");
      if (wb(256)) {
        break label360;
      }
      paramBoolean = true;
      label127:
      localCheckBoxPreference2.rHo = paramBoolean;
      if (wb(128)) {
        break label365;
      }
      paramBoolean = true;
      label145:
      localCheckBoxPreference1.rHo = paramBoolean;
      if ((q.Gp() & 0x4) == 0) {
        break label370;
      }
      paramBoolean = true;
      label161:
      localCheckBoxPreference3.rHo = paramBoolean;
      ((HelperHeaderPreference)paramf.add("contact_info_header_helper")).a(paramad, this.mXd);
      au.Hx();
      if (bk.g((Integer)c.Dz().get(9, null)) == 0) {
        break label375;
      }
      paramInt = 1;
      label211:
      if (paramInt == 0) {
        break label381;
      }
      paramf.c(paramf.add("contact_info_bind_qq_entry"));
      paramf.c(paramf.add("contact_info_bind_qq_entry_tip"));
      label246:
      if (com.tencent.mm.plugin.account.friend.a.l.WP() != l.a.ffT) {
        break label429;
      }
      paramInt = 1;
      label258:
      if (paramInt == 0) {
        break label435;
      }
      paramf.c(paramf.add("contact_info_bind_mobile_entry"));
      paramf.c(paramf.add("contact_info_bind_mobile_entry_tip"));
    }
    for (;;)
    {
      paramInt = i;
      if ((q.Gu() & 0x2000) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label477;
      }
      paramBoolean = q.GL();
      paramf.c(localCheckBoxPreference3);
      if (paramBoolean) {
        break label461;
      }
      paramf.add("contact_info_bind_fb_entry").setSummary(R.l.settings_bind_qq_unbind);
      return true;
      bool = false;
      break;
      label354:
      bool = false;
      break label22;
      label360:
      paramBoolean = false;
      break label127;
      label365:
      paramBoolean = false;
      break label145;
      label370:
      paramBoolean = false;
      break label161;
      label375:
      paramInt = 0;
      break label211;
      label381:
      paramf.c(localCheckBoxPreference1);
      if (b.Pd()) {
        break label246;
      }
      paramf.c(paramf.add("contact_info_bind_qq_entry"));
      paramf.c(paramf.add("contact_info_bind_qq_entry_tip"));
      break label246;
      label429:
      paramInt = 0;
      break label258;
      label435:
      paramf.c(localCheckBoxPreference2);
      paramf.add("contact_info_bind_mobile_entry").setSummary(R.l.settings_bind_qq_unbind);
    }
    label461:
    paramf.add("contact_info_bind_fb_entry").setSummary(R.l.contact_info_facebookapp_bind_success);
    return true;
    label477:
    paramf.c(paramf.add("contact_info_bind_fb_entry"));
    paramf.c(paramf.add("contact_info_bind_fb_entry_tip"));
    paramf.c(localCheckBoxPreference3);
    return true;
  }
  
  public final boolean awZ()
  {
    com.tencent.mm.plugin.profile.a.eUS.tk();
    this.dnn.add("contact_info_header_helper");
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    boolean bool = false;
    y.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_recommend_qqfriends_to_me"))
    {
      if (!((CheckBoxPreference)this.dnn.add("contact_info_recommend_qqfriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        b(bool, 128, 6);
        return true;
      }
    }
    if (paramString.equals("contact_info_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)this.dnn.add("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
        bool = true;
      }
      b(bool, 256, 7);
      return true;
    }
    if (paramString.equals("contact_info_recommend_fbfriends_to_me"))
    {
      bool = ((CheckBoxPreference)this.dnn.add("contact_info_recommend_fbfriends_to_me")).isChecked();
      y.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + bool + " item value = 4 functionId = 18");
      int i = q.Gp();
      if (bool)
      {
        i |= 0x4;
        au.Hx();
        c.Dz().o(40, Integer.valueOf(i));
        if (!bool) {
          break label247;
        }
      }
      label247:
      for (i = 1;; i = 2)
      {
        au.Hx();
        c.Fv().b(new com.tencent.mm.ay.f(18, i));
        return true;
        i &= 0xFFFFFFFB;
        break;
      }
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent();
      if (this.mVI)
      {
        paramString.putExtra("Chat_User", this.dnp.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        ((Activity)this.context).setResult(-1, paramString);
        ((Activity)this.context).finish();
        return true;
      }
      paramString.putExtra("Chat_User", this.dnp.field_username);
      paramString.putExtra("Chat_Mode", 1);
      paramString.addFlags(67108864);
      com.tencent.mm.plugin.profile.a.eUR.e(paramString, this.context);
      ((Activity)this.context).finish();
      return true;
    }
    if (paramString.equals("contact_info_bind_mobile_entry"))
    {
      com.tencent.mm.plugin.profile.a.eUR.g(new Intent(), this.context);
      return true;
    }
    if (paramString.equals("contact_info_bind_qq_entry"))
    {
      com.tencent.mm.plugin.profile.a.eUR.h(new Intent(), this.context);
      return true;
    }
    if (paramString.equals("contact_info_bind_fb_entry"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      return true;
    }
    if (paramString.equals("contact_info_fmessage_clear_data"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new e.1(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e
 * JD-Core Version:    0.7.0.1
 */