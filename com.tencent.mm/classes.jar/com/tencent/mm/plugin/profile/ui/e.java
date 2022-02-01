package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class e
  implements a
{
  private an contact;
  Context context;
  boolean isDeleteCancel;
  private f screen;
  private int status;
  p tipDialog;
  private boolean xfQ;
  private HelperHeaderPreference.a xhB;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(27119);
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.context = paramContext;
    this.xhB = new o(paramContext);
    this.status = -1;
    AppMethodBeat.o(27119);
  }
  
  private boolean Nz(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27121);
    ae.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      bc.aCg();
      c.ajA().set(7, Integer.valueOf(this.status));
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      bc.aCg();
      c.azE().d(new com.tencent.mm.ba.h(paramInt2, paramInt1));
      AppMethodBeat.o(27121);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public final boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
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
      if (paraman == null) {
        break label368;
      }
      bool = true;
      Assert.assertTrue(bool);
      Assert.assertTrue(x.As(paraman.field_username));
      this.screen = paramf;
      this.xfQ = paramBoolean;
      this.contact = paraman;
      if (this.status == -1) {
        this.status = v.aAG();
      }
      paramf.addPreferencesFromResource(2131951641);
      localCheckBoxPreference1 = (CheckBoxPreference)paramf.aXe("contact_info_recommend_qqfriends_to_me");
      localCheckBoxPreference2 = (CheckBoxPreference)paramf.aXe("contact_info_recommend_mobilefriends_to_me");
      localCheckBoxPreference3 = (CheckBoxPreference)paramf.aXe("contact_info_recommend_fbfriends_to_me");
      if (Nz(256)) {
        break label374;
      }
      paramBoolean = true;
      label132:
      localCheckBoxPreference2.setChecked(paramBoolean);
      if (Nz(128)) {
        break label379;
      }
      paramBoolean = true;
      label150:
      localCheckBoxPreference1.setChecked(paramBoolean);
      if ((v.aAI() & 0x4) == 0) {
        break label384;
      }
      paramBoolean = true;
      label166:
      localCheckBoxPreference3.setChecked(paramBoolean);
      ((HelperHeaderPreference)paramf.aXe("contact_info_header_helper")).a(paraman, this.xhB);
      bc.aCg();
      if (bu.o((Integer)c.ajA().get(9, null)) == 0) {
        break label389;
      }
      paramInt = 1;
      label216:
      if (paramInt == 0) {
        break label395;
      }
      paramf.d(paramf.aXe("contact_info_bind_qq_entry"));
      paramf.d(paramf.aXe("contact_info_bind_qq_entry_tip"));
      label251:
      if (com.tencent.mm.plugin.account.friend.a.l.aTn() != l.a.jgH) {
        break label443;
      }
      paramInt = 1;
      label263:
      if (paramInt == 0) {
        break label449;
      }
      paramf.d(paramf.aXe("contact_info_bind_mobile_entry"));
      paramf.d(paramf.aXe("contact_info_bind_mobile_entry_tip"));
      label298:
      paramInt = i;
      if ((v.aAO() & 0x2000) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label490;
      }
      paramBoolean = v.aBi();
      com.tencent.mm.aw.b.aJE();
      paramf.d(localCheckBoxPreference3);
      if (paramBoolean) {
        break label474;
      }
      paramf.aXe("contact_info_bind_fb_entry").setSummary(2131763187);
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
      paramf.d(localCheckBoxPreference1);
      if (com.tencent.mm.aw.b.aJD()) {
        break label251;
      }
      paramf.d(paramf.aXe("contact_info_bind_qq_entry"));
      paramf.d(paramf.aXe("contact_info_bind_qq_entry_tip"));
      break label251;
      label443:
      paramInt = 0;
      break label263;
      label449:
      paramf.d(localCheckBoxPreference2);
      paramf.aXe("contact_info_bind_mobile_entry").setSummary(2131763187);
      break label298;
      label474:
      paramf.aXe("contact_info_bind_fb_entry").setSummary(2131757658);
      continue;
      label490:
      paramf.d(paramf.aXe("contact_info_bind_fb_entry"));
      paramf.d(paramf.aXe("contact_info_bind_fb_entry_tip"));
      paramf.d(localCheckBoxPreference3);
    }
  }
  
  public final boolean abx(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(27120);
    ae.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = ".concat(String.valueOf(paramString)));
    if (bu.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27120);
      return false;
    }
    if (paramString.equals("contact_info_recommend_qqfriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.aXe("contact_info_recommend_qqfriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        h(bool, 128, 6);
        AppMethodBeat.o(27120);
        return true;
      }
    }
    if (paramString.equals("contact_info_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.aXe("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
        bool = true;
      }
      h(bool, 256, 7);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_recommend_fbfriends_to_me"))
    {
      bool = ((CheckBoxPreference)this.screen.aXe("contact_info_recommend_fbfriends_to_me")).isChecked();
      ae.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + bool + " item value = 4 functionId = 18");
      int i = v.aAI();
      if (bool)
      {
        i |= 0x4;
        bc.aCg();
        c.ajA().set(40, Integer.valueOf(i));
        if (!bool) {
          break label270;
        }
      }
      label270:
      for (i = 1;; i = 2)
      {
        bc.aCg();
        c.azE().d(new com.tencent.mm.ba.h(18, i));
        AppMethodBeat.o(27120);
        return true;
        i &= 0xFFFFFFFB;
        break;
      }
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent();
      if (this.xfQ)
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
        com.tencent.mm.plugin.profile.b.iUz.d(paramString, this.context);
        ((Activity)this.context).finish();
      }
    }
    if (paramString.equals("contact_info_bind_mobile_entry"))
    {
      com.tencent.mm.plugin.profile.b.iUz.f(new Intent(), this.context);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_bind_qq_entry"))
    {
      com.tencent.mm.plugin.profile.b.iUz.g(new Intent(), this.context);
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
      com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27117);
          paramAnonymousDialogInterface = e.this;
          paramAnonymousDialogInterface.isDeleteCancel = false;
          Context localContext = paramAnonymousDialogInterface.context;
          paramAnonymousDialogInterface.context.getString(2131755906);
          paramAnonymousDialogInterface.tipDialog = com.tencent.mm.ui.base.h.b(localContext, paramAnonymousDialogInterface.context.getString(2131755936), true, new e.2(paramAnonymousDialogInterface));
          bl.a("fmessage", new e.3(paramAnonymousDialogInterface));
          bc.aCg();
          c.azL().aUY("fmessage");
          AppMethodBeat.o(27117);
        }
      }, null);
      AppMethodBeat.o(27120);
      return true;
    }
    ae.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27120);
    return false;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27123);
    com.tencent.mm.plugin.profile.b.iUA.MM();
    this.screen.aXe("contact_info_header_helper");
    AppMethodBeat.o(27123);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e
 * JD-Core Version:    0.7.0.1
 */