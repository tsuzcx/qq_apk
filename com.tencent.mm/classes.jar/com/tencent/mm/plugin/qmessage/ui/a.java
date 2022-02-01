package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.qmessage.model.d;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements h, com.tencent.mm.pluginsdk.c.a
{
  private au contact;
  private Context context;
  private ProgressDialog lzP;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void dvr()
  {
    AppMethodBeat.i(27740);
    com.tencent.mm.plugin.qmessage.model.c localc = com.tencent.mm.plugin.qmessage.model.f.gDI().aSj(this.contact.field_username);
    if ((localc == null) || (Util.nullAsNil(localc.getUsername()).length() <= 0))
    {
      Log.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      AppMethodBeat.o(27740);
      return;
    }
    if (Util.nullAsNil(localc.bQo()).length() <= 0) {
      Log.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference1 = this.screen.bAi("contact_info_qcontact_sex");
    Preference localPreference2 = this.screen.bAi("contact_info_qcontact_age");
    Preference localPreference3 = this.screen.bAi("contact_info_qcontact_birthday");
    Preference localPreference4 = this.screen.bAi("contact_info_qcontact_address");
    a.a locala = new a.a(this, (byte)0);
    locala.aSk(localc.bQo());
    if (localPreference1 != null) {
      localPreference1.aS(locala.gDL());
    }
    if (localPreference2 != null) {
      localPreference2.aS(locala.gDM());
    }
    if (localPreference3 != null) {
      localPreference3.aS(locala.gDO());
    }
    if (localPreference4 != null) {
      localPreference4.aS(locala.gDN());
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(27740);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27739);
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paramau == null) {
        break label558;
      }
      paramBoolean = true;
      label25:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(au.bwN(paramau.field_username));
      bh.aZW().a(140, this);
      this.contact = paramau;
      this.screen = paramf;
      paramf.aBe(R.o.haT);
      paramf = (NormalUserHeaderPreference)paramf.bAi("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.Ynh = "ContactWidgetQContact";
        paramf.onDetach();
        bh.bCz();
        com.tencent.mm.model.c.bzA().add(paramf);
        bh.bCz();
        com.tencent.mm.model.c.bzB().a(paramf);
        q.bFp().d(paramf);
        paramf.contact = paramau;
        paramf.PCB = 0;
        paramf.pPi = null;
        paramf.YmR = paramf.lzt.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        paramf.Yna = paramf.lzt.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        paramf.YmX = paramf.lzt.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        paramf.YmY = paramf.lzt.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        paramf.YmZ = paramf.lzt.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        paramf.MZv = paramf.lzt.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        paramf.Ynb = paramf.lzt.getIntent().getStringExtra("Contact_RoomNickname");
        if (paramau.field_deleteFlag != 1) {
          break label563;
        }
        paramBoolean = true;
        label275:
        paramf.MZb = paramBoolean;
        paramf.lyn = paramf.lzt.getIntent().getStringExtra("room_name");
        if (Util.nullAsNil(paramau.field_username).length() <= 0) {
          break label568;
        }
        paramBoolean = true;
        label312:
        Assert.assertTrue("initView: contact username is null", paramBoolean);
        paramf.initView();
      }
      dvr();
      paramau = com.tencent.mm.plugin.qmessage.model.f.gDI().aSj(this.contact.field_username);
      if (paramau != null)
      {
        paramf = paramau;
        if (Util.nullAsNil(paramau.getUsername()).length() > 0) {}
      }
      else
      {
        Log.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
        paramf = new com.tencent.mm.plugin.qmessage.model.c();
        paramf.username = this.contact.field_username;
        paramf.eQp = -1;
        com.tencent.mm.plugin.qmessage.model.f.gDI().a(paramf);
      }
      if (paramf.Nim == 1)
      {
        paramau = this.contact.field_username;
        if (Util.nullAsNil(paramf.bQo()).length() > 0) {
          break label573;
        }
      }
    }
    label558:
    label563:
    label568:
    label573:
    for (paramInt = 1;; paramInt = 0)
    {
      paramBoolean = bool;
      if (Util.nullAsNil(paramau).length() > 0) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      paramf = new HashSet();
      paramf.add(paramau);
      paramf = new com.tencent.mm.plugin.qmessage.model.a(paramf);
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27736);
          bh.aZW().a(paramf, 0);
          AppMethodBeat.o(27736);
        }
      });
      if (paramInt != 0)
      {
        paramau = this.context;
        this.context.getString(R.l.app_tip);
        this.lzP = k.a(paramau, this.context.getString(R.l.app_loading_data), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(27737);
            bh.aZW().a(paramf);
            AppMethodBeat.o(27737);
          }
        });
      }
      AppMethodBeat.o(27739);
      return true;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label25;
      paramBoolean = false;
      break label275;
      paramBoolean = false;
      break label312;
    }
  }
  
  public final boolean anl(String paramString)
  {
    return true;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27741);
    bh.aZW().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.screen.bAi("contact_info_header_normal");
    if (localNormalUserHeaderPreference != null) {
      localNormalUserHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27741);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 1;
    AppMethodBeat.i(27742);
    if (paramp.getType() != 140)
    {
      AppMethodBeat.o(27742);
      return;
    }
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
      switch (paramInt1)
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label183;
        }
        AppMethodBeat.o(27742);
        return;
        if (!z.pBz) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
        continue;
        if (!z.pBz) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      }
    }
    label183:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.qmessage.model.f.gDI().aSj(this.contact.field_username);
      if ((paramString != null) && (Util.nullAsNil(paramString.getUsername()).length() > 0)) {
        break label261;
      }
      Log.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
    }
    for (;;)
    {
      dvr();
      AppMethodBeat.o(27742);
      return;
      label261:
      paramString.eQp = 8;
      paramString.Nim = 0;
      if (!com.tencent.mm.plugin.qmessage.model.f.gDI().a(this.contact.field_username, paramString)) {
        Log.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a
 * JD-Core Version:    0.7.0.1
 */