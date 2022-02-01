package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import junit.framework.Assert;

public final class e
  implements a
{
  private boolean GXw;
  private HelperHeaderPreference.a GZn;
  private as contact;
  Context context;
  boolean isDeleteCancel;
  private f screen;
  private int status;
  s tipDialog;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(27119);
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.context = paramContext;
    this.GZn = new p(paramContext);
    this.status = -1;
    AppMethodBeat.o(27119);
  }
  
  private boolean abt(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void m(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27121);
    Log.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      bh.beI();
      com.tencent.mm.model.c.aHp().i(7, Integer.valueOf(this.status));
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.h(paramInt2, paramInt1));
      AppMethodBeat.o(27121);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(27122);
    boolean bool;
    label28:
    CheckBoxPreference localCheckBoxPreference1;
    CheckBoxPreference localCheckBoxPreference2;
    CheckBoxPreference localCheckBoxPreference3;
    if (paramf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramas == null) {
        break label370;
      }
      bool = true;
      Assert.assertTrue(bool);
      Assert.assertTrue(ab.Qq(paramas.field_username));
      this.screen = paramf;
      this.GXw = paramBoolean;
      this.contact = paramas;
      if (this.status == -1) {
        this.status = z.bdd();
      }
      paramf.auC(R.o.eXm);
      localCheckBoxPreference1 = (CheckBoxPreference)paramf.byG("contact_info_recommend_qqfriends_to_me");
      localCheckBoxPreference2 = (CheckBoxPreference)paramf.byG("contact_info_recommend_mobilefriends_to_me");
      localCheckBoxPreference3 = (CheckBoxPreference)paramf.byG("contact_info_recommend_fbfriends_to_me");
      if (abt(256)) {
        break label376;
      }
      paramBoolean = true;
      label133:
      localCheckBoxPreference2.setChecked(paramBoolean);
      if (abt(128)) {
        break label381;
      }
      paramBoolean = true;
      label151:
      localCheckBoxPreference1.setChecked(paramBoolean);
      if ((z.bdf() & 0x4) == 0) {
        break label386;
      }
      paramBoolean = true;
      label167:
      localCheckBoxPreference3.setChecked(paramBoolean);
      ((HelperHeaderPreference)paramf.byG("contact_info_header_helper")).a(paramas, this.GZn);
      bh.beI();
      if (Util.nullAsNil((Integer)com.tencent.mm.model.c.aHp().b(9, null)) == 0) {
        break label391;
      }
      paramInt = 1;
      label217:
      if (paramInt == 0) {
        break label397;
      }
      paramf.d(paramf.byG("contact_info_bind_qq_entry"));
      paramf.d(paramf.byG("contact_info_bind_qq_entry_tip"));
      label252:
      if (com.tencent.mm.plugin.account.friend.a.l.byi() != l.a.mWk) {
        break label445;
      }
      paramInt = 1;
      label264:
      if (paramInt == 0) {
        break label451;
      }
      paramf.d(paramf.byG("contact_info_bind_mobile_entry"));
      paramf.d(paramf.byG("contact_info_bind_mobile_entry_tip"));
      label299:
      paramInt = i;
      if ((z.bdn() & 0x2000) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label494;
      }
      paramBoolean = z.bdH();
      com.tencent.mm.az.b.bmZ();
      paramf.d(localCheckBoxPreference3);
      if (paramBoolean) {
        break label477;
      }
      paramf.byG("contact_info_bind_fb_entry").auI(R.l.settings_bind_qq_unbind);
    }
    for (;;)
    {
      AppMethodBeat.o(27122);
      return true;
      bool = false;
      break;
      label370:
      bool = false;
      break label28;
      label376:
      paramBoolean = false;
      break label133;
      label381:
      paramBoolean = false;
      break label151;
      label386:
      paramBoolean = false;
      break label167;
      label391:
      paramInt = 0;
      break label217;
      label397:
      paramf.d(localCheckBoxPreference1);
      if (com.tencent.mm.az.b.bmY()) {
        break label252;
      }
      paramf.d(paramf.byG("contact_info_bind_qq_entry"));
      paramf.d(paramf.byG("contact_info_bind_qq_entry_tip"));
      break label252;
      label445:
      paramInt = 0;
      break label264;
      label451:
      paramf.d(localCheckBoxPreference2);
      paramf.byG("contact_info_bind_mobile_entry").auI(R.l.settings_bind_qq_unbind);
      break label299;
      label477:
      paramf.byG("contact_info_bind_fb_entry").auI(R.l.contact_info_facebookapp_bind_success);
      continue;
      label494:
      paramf.d(paramf.byG("contact_info_bind_fb_entry"));
      paramf.d(paramf.byG("contact_info_bind_fb_entry_tip"));
      paramf.d(localCheckBoxPreference3);
    }
  }
  
  public final boolean atw(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(27120);
    Log.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27120);
      return false;
    }
    if (paramString.equals("contact_info_recommend_qqfriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.byG("contact_info_recommend_qqfriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        m(bool, 128, 6);
        AppMethodBeat.o(27120);
        return true;
      }
    }
    if (paramString.equals("contact_info_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.byG("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
        bool = true;
      }
      m(bool, 256, 7);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_recommend_fbfriends_to_me"))
    {
      bool = ((CheckBoxPreference)this.screen.byG("contact_info_recommend_fbfriends_to_me")).isChecked();
      Log.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + bool + " item value = 4 functionId = 18");
      int i = z.bdf();
      if (bool)
      {
        i |= 0x4;
        bh.beI();
        com.tencent.mm.model.c.aHp().i(40, Integer.valueOf(i));
        if (!bool) {
          break label270;
        }
      }
      label270:
      for (i = 1;; i = 2)
      {
        bh.beI();
        com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.h(18, i));
        AppMethodBeat.o(27120);
        return true;
        i &= 0xFFFFFFFB;
        break;
      }
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent();
      if (this.GXw)
      {
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        ((Activity)this.context).setResult(-1, paramString);
        ((Activity)this.context).finish();
      }
      for (;;)
      {
        AppMethodBeat.o(27120);
        return true;
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.mIG.d(paramString, this.context);
        ((Activity)this.context).finish();
      }
    }
    if (paramString.equals("contact_info_bind_mobile_entry"))
    {
      com.tencent.mm.plugin.profile.b.mIG.f(new Intent(), this.context);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_bind_qq_entry"))
    {
      com.tencent.mm.plugin.profile.b.mIG.g(new Intent(), this.context);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_bind_fb_entry"))
    {
      com.tencent.mm.by.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_fmessage_clear_data"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27117);
          paramAnonymousDialogInterface = e.this;
          paramAnonymousDialogInterface.isDeleteCancel = false;
          Context localContext = paramAnonymousDialogInterface.context;
          paramAnonymousDialogInterface.context.getString(R.l.app_tip);
          paramAnonymousDialogInterface.tipDialog = com.tencent.mm.ui.base.h.a(localContext, paramAnonymousDialogInterface.context.getString(R.l.app_waiting), true, new e.2(paramAnonymousDialogInterface));
          bq.a("fmessage", new e.3(paramAnonymousDialogInterface));
          bh.beI();
          com.tencent.mm.model.c.bbR().bwv("fmessage");
          AppMethodBeat.o(27117);
        }
      }, null);
      AppMethodBeat.o(27120);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27120);
    return false;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27123);
    com.tencent.mm.plugin.profile.b.mIH.abC();
    this.screen.byG("contact_info_header_helper");
    AppMethodBeat.o(27123);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e
 * JD-Core Version:    0.7.0.1
 */