package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import junit.framework.Assert;

public final class e
  implements a
{
  private boolean Bdx;
  private HelperHeaderPreference.a Bfp;
  private as contact;
  Context context;
  boolean isDeleteCancel;
  private f screen;
  private int status;
  q tipDialog;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(27119);
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.context = paramContext;
    this.Bfp = new p(paramContext);
    this.status = -1;
    AppMethodBeat.o(27119);
  }
  
  private boolean UM(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27121);
    Log.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(7, Integer.valueOf(this.status));
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.h(paramInt2, paramInt1));
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
        break label368;
      }
      bool = true;
      Assert.assertTrue(bool);
      Assert.assertTrue(ab.IX(paramas.field_username));
      this.screen = paramf;
      this.Bdx = paramBoolean;
      this.contact = paramas;
      if (this.status == -1) {
        this.status = z.aUc();
      }
      paramf.addPreferencesFromResource(2132017178);
      localCheckBoxPreference1 = (CheckBoxPreference)paramf.bmg("contact_info_recommend_qqfriends_to_me");
      localCheckBoxPreference2 = (CheckBoxPreference)paramf.bmg("contact_info_recommend_mobilefriends_to_me");
      localCheckBoxPreference3 = (CheckBoxPreference)paramf.bmg("contact_info_recommend_fbfriends_to_me");
      if (UM(256)) {
        break label374;
      }
      paramBoolean = true;
      label132:
      localCheckBoxPreference2.setChecked(paramBoolean);
      if (UM(128)) {
        break label379;
      }
      paramBoolean = true;
      label150:
      localCheckBoxPreference1.setChecked(paramBoolean);
      if ((z.aUe() & 0x4) == 0) {
        break label384;
      }
      paramBoolean = true;
      label166:
      localCheckBoxPreference3.setChecked(paramBoolean);
      ((HelperHeaderPreference)paramf.bmg("contact_info_header_helper")).a(paramas, this.Bfp);
      bg.aVF();
      if (Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(9, null)) == 0) {
        break label389;
      }
      paramInt = 1;
      label216:
      if (paramInt == 0) {
        break label395;
      }
      paramf.e(paramf.bmg("contact_info_bind_qq_entry"));
      paramf.e(paramf.bmg("contact_info_bind_qq_entry_tip"));
      label251:
      if (com.tencent.mm.plugin.account.friend.a.l.bnZ() != l.a.keL) {
        break label443;
      }
      paramInt = 1;
      label263:
      if (paramInt == 0) {
        break label449;
      }
      paramf.e(paramf.bmg("contact_info_bind_mobile_entry"));
      paramf.e(paramf.bmg("contact_info_bind_mobile_entry_tip"));
      label298:
      paramInt = i;
      if ((z.aUl() & 0x2000) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label490;
      }
      paramBoolean = z.aUF();
      com.tencent.mm.aw.b.bdF();
      paramf.e(localCheckBoxPreference3);
      if (paramBoolean) {
        break label474;
      }
      paramf.bmg("contact_info_bind_fb_entry").setSummary(2131765355);
    }
    for (;;)
    {
      AppMethodBeat.o(27122);
      return true;
      bool = false;
      break;
      label368:
      bool = false;
      break label28;
      label374:
      paramBoolean = false;
      break label132;
      label379:
      paramBoolean = false;
      break label150;
      label384:
      paramBoolean = false;
      break label166;
      label389:
      paramInt = 0;
      break label216;
      label395:
      paramf.e(localCheckBoxPreference1);
      if (com.tencent.mm.aw.b.bdE()) {
        break label251;
      }
      paramf.e(paramf.bmg("contact_info_bind_qq_entry"));
      paramf.e(paramf.bmg("contact_info_bind_qq_entry_tip"));
      break label251;
      label443:
      paramInt = 0;
      break label263;
      label449:
      paramf.e(localCheckBoxPreference2);
      paramf.bmg("contact_info_bind_mobile_entry").setSummary(2131765355);
      break label298;
      label474:
      paramf.bmg("contact_info_bind_fb_entry").setSummary(2131757886);
      continue;
      label490:
      paramf.e(paramf.bmg("contact_info_bind_fb_entry"));
      paramf.e(paramf.bmg("contact_info_bind_fb_entry_tip"));
      paramf.e(localCheckBoxPreference3);
    }
  }
  
  public final boolean alD(String paramString)
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
      if (!((CheckBoxPreference)this.screen.bmg("contact_info_recommend_qqfriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        i(bool, 128, 6);
        AppMethodBeat.o(27120);
        return true;
      }
    }
    if (paramString.equals("contact_info_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.bmg("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
        bool = true;
      }
      i(bool, 256, 7);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_recommend_fbfriends_to_me"))
    {
      bool = ((CheckBoxPreference)this.screen.bmg("contact_info_recommend_fbfriends_to_me")).isChecked();
      Log.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + bool + " item value = 4 functionId = 18");
      int i = z.aUe();
      if (bool)
      {
        i |= 0x4;
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(40, Integer.valueOf(i));
        if (!bool) {
          break label270;
        }
      }
      label270:
      for (i = 1;; i = 2)
      {
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.h(18, i));
        AppMethodBeat.o(27120);
        return true;
        i &= 0xFFFFFFFB;
        break;
      }
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent();
      if (this.Bdx)
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
        com.tencent.mm.plugin.profile.b.jRt.d(paramString, this.context);
        ((Activity)this.context).finish();
      }
    }
    if (paramString.equals("contact_info_bind_mobile_entry"))
    {
      com.tencent.mm.plugin.profile.b.jRt.f(new Intent(), this.context);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_bind_qq_entry"))
    {
      com.tencent.mm.plugin.profile.b.jRt.g(new Intent(), this.context);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_bind_fb_entry"))
    {
      com.tencent.mm.br.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_fmessage_clear_data"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27117);
          paramAnonymousDialogInterface = e.this;
          paramAnonymousDialogInterface.isDeleteCancel = false;
          Context localContext = paramAnonymousDialogInterface.context;
          paramAnonymousDialogInterface.context.getString(2131755998);
          paramAnonymousDialogInterface.tipDialog = com.tencent.mm.ui.base.h.a(localContext, paramAnonymousDialogInterface.context.getString(2131756029), true, new e.2(paramAnonymousDialogInterface));
          bp.a("fmessage", new e.3(paramAnonymousDialogInterface));
          bg.aVF();
          com.tencent.mm.model.c.aST().bjW("fmessage");
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
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27123);
    com.tencent.mm.plugin.profile.b.jRu.WZ();
    this.screen.bmg("contact_info_header_helper");
    AppMethodBeat.o(27123);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e
 * JD-Core Version:    0.7.0.1
 */