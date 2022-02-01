package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class e
  implements a
{
  private ai contact;
  Context context;
  boolean isDeleteCancel;
  private f screen;
  private int status;
  p tipDialog;
  private boolean vIS;
  private HelperHeaderPreference.a vKB;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(27119);
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.context = paramContext;
    this.vKB = new o(paramContext);
    this.status = -1;
    AppMethodBeat.o(27119);
  }
  
  private boolean Lr(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27121);
    ac.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      az.ayM();
      c.agA().set(7, Integer.valueOf(this.status));
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      az.ayM();
      c.awA().c(new com.tencent.mm.ba.h(paramInt2, paramInt1));
      AppMethodBeat.o(27121);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public final boolean WZ(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(27120);
    ac.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = ".concat(String.valueOf(paramString)));
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27120);
      return false;
    }
    if (paramString.equals("contact_info_recommend_qqfriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.aPN("contact_info_recommend_qqfriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        f(bool, 128, 6);
        AppMethodBeat.o(27120);
        return true;
      }
    }
    if (paramString.equals("contact_info_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.aPN("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
        bool = true;
      }
      f(bool, 256, 7);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_recommend_fbfriends_to_me"))
    {
      bool = ((CheckBoxPreference)this.screen.aPN("contact_info_recommend_fbfriends_to_me")).isChecked();
      ac.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + bool + " item value = 4 functionId = 18");
      int i = u.axC();
      if (bool)
      {
        i |= 0x4;
        az.ayM();
        c.agA().set(40, Integer.valueOf(i));
        if (!bool) {
          break label268;
        }
      }
      label268:
      for (i = 1;; i = 2)
      {
        az.ayM();
        c.awA().c(new com.tencent.mm.ba.h(18, i));
        AppMethodBeat.o(27120);
        return true;
        i &= 0xFFFFFFFB;
        break;
      }
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent();
      if (this.vIS)
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
        com.tencent.mm.plugin.profile.b.iyx.d(paramString, this.context);
        ((Activity)this.context).finish();
      }
    }
    if (paramString.equals("contact_info_bind_mobile_entry"))
    {
      com.tencent.mm.plugin.profile.b.iyx.f(new Intent(), this.context);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_bind_qq_entry"))
    {
      com.tencent.mm.plugin.profile.b.iyx.g(new Intent(), this.context);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_bind_fb_entry"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_fmessage_clear_data"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27117);
          paramAnonymousDialogInterface = e.this;
          paramAnonymousDialogInterface.isDeleteCancel = false;
          Context localContext = paramAnonymousDialogInterface.context;
          paramAnonymousDialogInterface.context.getString(2131755906);
          paramAnonymousDialogInterface.tipDialog = com.tencent.mm.ui.base.h.b(localContext, paramAnonymousDialogInterface.context.getString(2131755936), true, new e.2(paramAnonymousDialogInterface));
          bi.a("fmessage", new e.3(paramAnonymousDialogInterface));
          az.ayM();
          c.awG().aNG("fmessage");
          AppMethodBeat.o(27117);
        }
      }, null);
      AppMethodBeat.o(27120);
      return true;
    }
    ac.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27120);
    return false;
  }
  
  public final boolean a(f paramf, ai paramai, boolean paramBoolean, int paramInt)
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
      if (paramai == null) {
        break label373;
      }
      bool = true;
      Assert.assertTrue(bool);
      Assert.assertTrue(w.wL(paramai.field_username));
      this.screen = paramf;
      this.vIS = paramBoolean;
      this.contact = paramai;
      if (this.status == -1) {
        this.status = u.axA();
      }
      paramf.addPreferencesFromResource(2131951641);
      localCheckBoxPreference1 = (CheckBoxPreference)paramf.aPN("contact_info_recommend_qqfriends_to_me");
      localCheckBoxPreference2 = (CheckBoxPreference)paramf.aPN("contact_info_recommend_mobilefriends_to_me");
      localCheckBoxPreference3 = (CheckBoxPreference)paramf.aPN("contact_info_recommend_fbfriends_to_me");
      if (Lr(256)) {
        break label379;
      }
      paramBoolean = true;
      label133:
      localCheckBoxPreference2.mF = paramBoolean;
      if (Lr(128)) {
        break label384;
      }
      paramBoolean = true;
      label151:
      localCheckBoxPreference1.mF = paramBoolean;
      if ((u.axC() & 0x4) == 0) {
        break label389;
      }
      paramBoolean = true;
      label167:
      localCheckBoxPreference3.mF = paramBoolean;
      ((HelperHeaderPreference)paramf.aPN("contact_info_header_helper")).a(paramai, this.vKB);
      az.ayM();
      if (bs.m((Integer)c.agA().get(9, null)) == 0) {
        break label394;
      }
      paramInt = 1;
      label218:
      if (paramInt == 0) {
        break label400;
      }
      paramf.d(paramf.aPN("contact_info_bind_qq_entry"));
      paramf.d(paramf.aPN("contact_info_bind_qq_entry_tip"));
      label254:
      if (com.tencent.mm.plugin.account.friend.a.l.aPC() != l.a.iKF) {
        break label449;
      }
      paramInt = 1;
      label266:
      if (paramInt == 0) {
        break label455;
      }
      paramf.d(paramf.aPN("contact_info_bind_mobile_entry"));
      paramf.d(paramf.aPN("contact_info_bind_mobile_entry_tip"));
      label302:
      paramInt = i;
      if ((u.axI() & 0x2000) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label498;
      }
      paramBoolean = u.axZ();
      com.tencent.mm.aw.b.aGd();
      paramf.d(localCheckBoxPreference3);
      if (paramBoolean) {
        break label481;
      }
      paramf.aPN("contact_info_bind_fb_entry").setSummary(2131763187);
    }
    for (;;)
    {
      AppMethodBeat.o(27122);
      return true;
      bool = false;
      break;
      label373:
      bool = false;
      break label28;
      label379:
      paramBoolean = false;
      break label133;
      label384:
      paramBoolean = false;
      break label151;
      label389:
      paramBoolean = false;
      break label167;
      label394:
      paramInt = 0;
      break label218;
      label400:
      paramf.d(localCheckBoxPreference1);
      if (com.tencent.mm.aw.b.aGc()) {
        break label254;
      }
      paramf.d(paramf.aPN("contact_info_bind_qq_entry"));
      paramf.d(paramf.aPN("contact_info_bind_qq_entry_tip"));
      break label254;
      label449:
      paramInt = 0;
      break label266;
      label455:
      paramf.d(localCheckBoxPreference2);
      paramf.aPN("contact_info_bind_mobile_entry").setSummary(2131763187);
      break label302;
      label481:
      paramf.aPN("contact_info_bind_fb_entry").setSummary(2131757658);
      continue;
      label498:
      paramf.d(paramf.aPN("contact_info_bind_fb_entry"));
      paramf.d(paramf.aPN("contact_info_bind_fb_entry_tip"));
      paramf.d(localCheckBoxPreference3);
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27123);
    com.tencent.mm.plugin.profile.b.iyy.Lj();
    this.screen.aPN("contact_info_header_helper");
    AppMethodBeat.o(27123);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e
 * JD-Core Version:    0.7.0.1
 */