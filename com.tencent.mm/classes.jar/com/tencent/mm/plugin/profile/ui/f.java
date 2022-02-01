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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.ay.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;
import junit.framework.Assert;

public final class f
  implements a
{
  private boolean MVt;
  private HelperHeaderPreference.a MXq;
  private au contact;
  Context context;
  boolean isDeleteCancel;
  private com.tencent.mm.ui.base.preference.f screen;
  private int status;
  w tipDialog;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(27119);
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.context = paramContext;
    this.MXq = new q(paramContext);
    this.status = -1;
    AppMethodBeat.o(27119);
  }
  
  private boolean afN(int paramInt)
  {
    return (this.status & paramInt) != 0;
  }
  
  private void p(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27121);
    Log.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    if (paramBoolean)
    {
      this.status |= paramInt1;
      bh.bCz();
      com.tencent.mm.model.c.ban().B(7, Integer.valueOf(this.status));
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new h(paramInt2, paramInt1));
      AppMethodBeat.o(27121);
      return;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
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
      if (paramau == null) {
        break label379;
      }
      bool = true;
      Assert.assertTrue(bool);
      Assert.assertTrue(au.bvT(paramau.field_username));
      this.screen = paramf;
      this.MVt = paramBoolean;
      this.contact = paramau;
      if (this.status == -1) {
        this.status = z.bAQ();
      }
      paramf.aBe(R.o.haO);
      localCheckBoxPreference1 = (CheckBoxPreference)paramf.bAi("contact_info_recommend_qqfriends_to_me");
      localCheckBoxPreference2 = (CheckBoxPreference)paramf.bAi("contact_info_recommend_mobilefriends_to_me");
      localCheckBoxPreference3 = (CheckBoxPreference)paramf.bAi("contact_info_recommend_fbfriends_to_me");
      if (afN(256)) {
        break label385;
      }
      paramBoolean = true;
      label133:
      localCheckBoxPreference2.setChecked(paramBoolean);
      if (afN(128)) {
        break label390;
      }
      paramBoolean = true;
      label151:
      localCheckBoxPreference1.setChecked(paramBoolean);
      if ((z.bAU() & 0x4) == 0) {
        break label395;
      }
      paramBoolean = true;
      label167:
      localCheckBoxPreference3.setChecked(paramBoolean);
      ((HelperHeaderPreference)paramf.bAi("contact_info_header_helper")).a(paramau, this.MXq);
      bh.bCz();
      if (Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(9, null)) == 0) {
        break label400;
      }
      paramInt = 1;
      label217:
      if (paramInt == 0) {
        break label406;
      }
      paramf.e(paramf.bAi("contact_info_bind_qq_entry"));
      paramf.e(paramf.bAi("contact_info_bind_qq_entry_tip"));
      label252:
      if (i.bWW() != i.a.pSQ) {
        break label454;
      }
      paramInt = 1;
      label264:
      if (paramInt == 0) {
        break label460;
      }
      paramf.e(paramf.bAi("contact_info_bind_mobile_entry"));
      paramf.e(paramf.bAi("contact_info_bind_mobile_entry_tip"));
      label299:
      paramInt = i;
      if ((z.bBf() & 0x2000) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label533;
      }
      paramBoolean = z.bBz();
      if ((!com.tencent.mm.au.b.bKL()) || (!paramBoolean)) {
        break label486;
      }
      paramf.e(paramf.bAi("contact_info_bind_fb_entry"));
      paramf.e(paramf.bAi("contact_info_bind_fb_entry_tip"));
    }
    for (;;)
    {
      AppMethodBeat.o(27122);
      return true;
      bool = false;
      break;
      label379:
      bool = false;
      break label28;
      label385:
      paramBoolean = false;
      break label133;
      label390:
      paramBoolean = false;
      break label151;
      label395:
      paramBoolean = false;
      break label167;
      label400:
      paramInt = 0;
      break label217;
      label406:
      paramf.e(localCheckBoxPreference1);
      if (com.tencent.mm.au.b.bKK()) {
        break label252;
      }
      paramf.e(paramf.bAi("contact_info_bind_qq_entry"));
      paramf.e(paramf.bAi("contact_info_bind_qq_entry_tip"));
      break label252;
      label454:
      paramInt = 0;
      break label264;
      label460:
      paramf.e(localCheckBoxPreference2);
      paramf.bAi("contact_info_bind_mobile_entry").aBk(R.l.settings_bind_qq_unbind);
      break label299;
      label486:
      paramf.e(localCheckBoxPreference3);
      if (!paramBoolean)
      {
        paramf.bAi("contact_info_bind_fb_entry").aBk(R.l.settings_bind_qq_unbind);
      }
      else
      {
        paramf.bAi("contact_info_bind_fb_entry").aBk(R.l.contact_info_facebookapp_bind_success);
        continue;
        label533:
        paramf.e(paramf.bAi("contact_info_bind_fb_entry"));
        paramf.e(paramf.bAi("contact_info_bind_fb_entry_tip"));
        paramf.e(localCheckBoxPreference3);
      }
    }
  }
  
  public final boolean anl(String paramString)
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
      if (!((CheckBoxPreference)this.screen.bAi("contact_info_recommend_qqfriends_to_me")).isChecked()) {}
      for (bool = true;; bool = false)
      {
        p(bool, 128, 6);
        AppMethodBeat.o(27120);
        return true;
      }
    }
    if (paramString.equals("contact_info_recommend_mobilefriends_to_me"))
    {
      if (!((CheckBoxPreference)this.screen.bAi("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
        bool = true;
      }
      p(bool, 256, 7);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_recommend_fbfriends_to_me"))
    {
      bool = ((CheckBoxPreference)this.screen.bAi("contact_info_recommend_fbfriends_to_me")).isChecked();
      Log.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + bool + " item value = 4 functionId = 18");
      int i = z.bAU();
      if (bool)
      {
        i |= 0x4;
        bh.bCz();
        com.tencent.mm.model.c.ban().B(40, Integer.valueOf(i));
        if (!bool) {
          break label270;
        }
      }
      label270:
      for (i = 1;; i = 2)
      {
        bh.bCz();
        com.tencent.mm.model.c.bzz().d(new h(18, i));
        AppMethodBeat.o(27120);
        return true;
        i &= 0xFFFFFFFB;
        break;
      }
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent();
      if (this.MVt)
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
        com.tencent.mm.plugin.profile.b.pFn.d(paramString, this.context);
        ((Activity)this.context).finish();
      }
    }
    if (paramString.equals("contact_info_bind_mobile_entry"))
    {
      com.tencent.mm.plugin.profile.b.pFn.f(new Intent(), this.context);
      AppMethodBeat.o(27120);
      return true;
    }
    if (paramString.equals("contact_info_bind_qq_entry"))
    {
      com.tencent.mm.plugin.profile.b.pFn.g(new Intent(), this.context);
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
      k.b(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27117);
          paramAnonymousDialogInterface = f.this;
          paramAnonymousDialogInterface.isDeleteCancel = false;
          Context localContext = paramAnonymousDialogInterface.context;
          paramAnonymousDialogInterface.context.getString(R.l.app_tip);
          paramAnonymousDialogInterface.tipDialog = k.a(localContext, paramAnonymousDialogInterface.context.getString(R.l.app_waiting), true, new f.2(paramAnonymousDialogInterface));
          br.a("fmessage", new f.3(paramAnonymousDialogInterface));
          ac.aY("fmessage", 15);
          bh.bCz();
          com.tencent.mm.model.c.bzG().bxK("fmessage");
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
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27123);
    com.tencent.mm.plugin.profile.b.pFo.aDx();
    this.screen.bAi("contact_info_header_helper");
    AppMethodBeat.o(27123);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f
 * JD-Core Version:    0.7.0.1
 */