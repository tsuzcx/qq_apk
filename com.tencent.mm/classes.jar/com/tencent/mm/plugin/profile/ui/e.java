package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.g;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class e
  implements a
{
  private ad contact;
  Context context;
  boolean isDeleteCancel;
  private boolean pyp;
  private HelperHeaderPreference.a pzZ;
  private f screen;
  private int status;
  p tipDialog;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(23504);
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.context = paramContext;
    this.pzZ = new o(paramContext);
    this.status = -1;
    AppMethodBeat.o(23504);
  }
  
  private boolean BF(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23506);
    ab.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      aw.aaz();
      c.Ru().set(7, Integer.valueOf(this.status));
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      aw.aaz();
      c.Yz().c(new g(paramInt2, paramInt1));
      AppMethodBeat.o(23506);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(23505);
    ab.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(23505);
      return false;
    }
    if (paramString.equals("contact_info_recommend_qqfriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.atx("contact_info_recommend_qqfriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        f(bool, 128, 6);
        AppMethodBeat.o(23505);
        return true;
      }
    }
    if (paramString.equals("contact_info_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.atx("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
        bool = true;
      }
      f(bool, 256, 7);
      AppMethodBeat.o(23505);
      return true;
    }
    if (paramString.equals("contact_info_recommend_fbfriends_to_me"))
    {
      bool = ((CheckBoxPreference)this.screen.atx("contact_info_recommend_fbfriends_to_me")).isChecked();
      ab.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + bool + " item value = 4 functionId = 18");
      int i = r.Zt();
      if (bool)
      {
        i |= 0x4;
        aw.aaz();
        c.Ru().set(40, Integer.valueOf(i));
        if (!bool) {
          break label268;
        }
      }
      label268:
      for (i = 1;; i = 2)
      {
        aw.aaz();
        c.Yz().c(new g(18, i));
        AppMethodBeat.o(23505);
        return true;
        i &= 0xFFFFFFFB;
        break;
      }
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent();
      if (this.pyp)
      {
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        ((Activity)this.context).setResult(-1, paramString);
        ((Activity)this.context).finish();
      }
      for (;;)
      {
        AppMethodBeat.o(23505);
        return true;
        paramString.putExtra("Chat_User", this.contact.field_username);
        paramString.putExtra("Chat_Mode", 1);
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.gmO.d(paramString, this.context);
        ((Activity)this.context).finish();
      }
    }
    if (paramString.equals("contact_info_bind_mobile_entry"))
    {
      com.tencent.mm.plugin.profile.b.gmO.f(new Intent(), this.context);
      AppMethodBeat.o(23505);
      return true;
    }
    if (paramString.equals("contact_info_bind_qq_entry"))
    {
      com.tencent.mm.plugin.profile.b.gmO.g(new Intent(), this.context);
      AppMethodBeat.o(23505);
      return true;
    }
    if (paramString.equals("contact_info_bind_fb_entry"))
    {
      d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
      AppMethodBeat.o(23505);
      return true;
    }
    if (paramString.equals("contact_info_fmessage_clear_data"))
    {
      h.d(this.context, this.context.getString(2131298571), "", this.context.getString(2131296891), this.context.getString(2131296888), new e.1(this), null);
      AppMethodBeat.o(23505);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(23505);
    return false;
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(23507);
    boolean bool;
    label28:
    CheckBoxPreference localCheckBoxPreference1;
    CheckBoxPreference localCheckBoxPreference2;
    CheckBoxPreference localCheckBoxPreference3;
    if (paramf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramad == null) {
        break label373;
      }
      bool = true;
      Assert.assertTrue(bool);
      Assert.assertTrue(t.nY(paramad.field_username));
      this.screen = paramf;
      this.pyp = paramBoolean;
      this.contact = paramad;
      if (this.status == -1) {
        this.status = r.Zr();
      }
      paramf.addPreferencesFromResource(2131165207);
      localCheckBoxPreference1 = (CheckBoxPreference)paramf.atx("contact_info_recommend_qqfriends_to_me");
      localCheckBoxPreference2 = (CheckBoxPreference)paramf.atx("contact_info_recommend_mobilefriends_to_me");
      localCheckBoxPreference3 = (CheckBoxPreference)paramf.atx("contact_info_recommend_fbfriends_to_me");
      if (BF(256)) {
        break label379;
      }
      paramBoolean = true;
      label133:
      localCheckBoxPreference2.vxW = paramBoolean;
      if (BF(128)) {
        break label384;
      }
      paramBoolean = true;
      label151:
      localCheckBoxPreference1.vxW = paramBoolean;
      if ((r.Zt() & 0x4) == 0) {
        break label389;
      }
      paramBoolean = true;
      label167:
      localCheckBoxPreference3.vxW = paramBoolean;
      ((HelperHeaderPreference)paramf.atx("contact_info_header_helper")).a(paramad, this.pzZ);
      aw.aaz();
      if (bo.g((Integer)c.Ru().get(9, null)) == 0) {
        break label394;
      }
      paramInt = 1;
      label218:
      if (paramInt == 0) {
        break label400;
      }
      paramf.d(paramf.atx("contact_info_bind_qq_entry"));
      paramf.d(paramf.atx("contact_info_bind_qq_entry_tip"));
      label254:
      if (l.aqq() != l.a.gxB) {
        break label449;
      }
      paramInt = 1;
      label266:
      if (paramInt == 0) {
        break label455;
      }
      paramf.d(paramf.atx("contact_info_bind_mobile_entry"));
      paramf.d(paramf.atx("contact_info_bind_mobile_entry_tip"));
      label302:
      paramInt = i;
      if ((r.Zy() & 0x2000) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label498;
      }
      paramBoolean = r.ZP();
      com.tencent.mm.au.b.aif();
      paramf.d(localCheckBoxPreference3);
      if (paramBoolean) {
        break label481;
      }
      paramf.atx("contact_info_bind_fb_entry").setSummary(2131303219);
    }
    for (;;)
    {
      AppMethodBeat.o(23507);
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
      if (com.tencent.mm.au.b.aie()) {
        break label254;
      }
      paramf.d(paramf.atx("contact_info_bind_qq_entry"));
      paramf.d(paramf.atx("contact_info_bind_qq_entry_tip"));
      break label254;
      label449:
      paramInt = 0;
      break label266;
      label455:
      paramf.d(localCheckBoxPreference2);
      paramf.atx("contact_info_bind_mobile_entry").setSummary(2131303219);
      break label302;
      label481:
      paramf.atx("contact_info_bind_fb_entry").setSummary(2131298598);
      continue;
      label498:
      paramf.d(paramf.atx("contact_info_bind_fb_entry"));
      paramf.d(paramf.atx("contact_info_bind_fb_entry_tip"));
      paramf.d(localCheckBoxPreference3);
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23508);
    com.tencent.mm.plugin.profile.b.gmP.BO();
    this.screen.atx("contact_info_header_helper");
    AppMethodBeat.o(23508);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e
 * JD-Core Version:    0.7.0.1
 */