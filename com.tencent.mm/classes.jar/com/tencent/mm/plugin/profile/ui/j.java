package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.x;
import junit.framework.Assert;

public final class j
  implements com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private HelperHeaderPreference.a MXx;
  private au contact;
  private Context context;
  private f screen;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(27154);
    this.context = paramContext;
    this.MXx = new t(paramContext);
    AppMethodBeat.o(27154);
  }
  
  public static void M(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27159);
    if (paramBoolean) {}
    for (String str = paramContext.getString(R.l.settings_plugins_installing);; str = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27153);
          if (j.this != null) {
            j.this.dismiss();
          }
          int i = z.bBf();
          edx localedx;
          if (paramBoolean)
          {
            i &= 0xFEFFFFFF;
            bh.bCz();
            com.tencent.mm.model.c.ban().B(34, Integer.valueOf(i));
            localedx = new edx();
            localedx.YBX = 16777216;
            if (!paramBoolean) {
              break label176;
            }
          }
          label176:
          for (i = 0;; i = 1)
          {
            localedx.abiW = i;
            bh.bCz();
            com.tencent.mm.model.c.bzz().d(new k.a(39, localedx));
            if (this.KNw != null) {
              this.KNw.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27153);
            return false;
            i |= 0x1000000;
            bh.bCz();
            com.tencent.mm.model.c.ban().B(286722, "");
            bh.bCz();
            com.tencent.mm.model.c.ban().B(286721, "");
            bh.bCz();
            com.tencent.mm.model.c.ban().B(286723, "");
            break;
          }
        }
      }, false).startTimer(1500L);
      AppMethodBeat.o(27159);
      return;
    }
  }
  
  private void dvr()
  {
    AppMethodBeat.i(27158);
    boolean bool = gBE();
    this.screen.removeAll();
    this.screen.aBe(R.o.haP);
    ((HelperHeaderPreference)this.screen.bAi("contact_info_header_helper")).a(this.contact, this.MXx);
    if (bool)
    {
      this.screen.eh("contact_info_linkedin_account", false);
      this.screen.bAk("contact_info_linkedin_install");
      AppMethodBeat.o(27158);
      return;
    }
    this.screen.eh("contact_info_linkedin_account", true);
    this.screen.bAk("contact_info_linkedin_uninstall");
    AppMethodBeat.o(27158);
  }
  
  private static boolean gBE()
  {
    AppMethodBeat.i(27155);
    if ((z.bBf() & 0x1000000) == 0)
    {
      AppMethodBeat.o(27155);
      return true;
    }
    AppMethodBeat.o(27155);
    return false;
  }
  
  public final boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27157);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramau != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(au.bwl(paramau.field_username));
      bh.bCz();
      com.tencent.mm.model.c.ban().add(this);
      this.contact = paramau;
      this.screen = paramf;
      dvr();
      AppMethodBeat.o(27157);
      return true;
    }
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(27156);
    Log.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27156);
      return false;
    }
    if (paramString.equals("contact_info_linkedin_install"))
    {
      M(this.context, true);
      AppMethodBeat.o(27156);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_uninstall"))
    {
      k.b(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27152);
          j.M(j.a(j.this), false);
          AppMethodBeat.o(27152);
        }
      }, null);
      AppMethodBeat.o(27156);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_account"))
    {
      Intent localIntent = new Intent(this.context, BindLinkedInUI.class);
      com.tencent.mm.hellhoundlib.a.a.a((Activity)this.context, com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/profile/ui/ContactWidgetLinkedIn", "handleEvent", "(Ljava/lang/String;)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    }
    Log.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27156);
    return false;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27160);
    bh.bCz();
    com.tencent.mm.model.c.ban().remove(this);
    this.screen.bAi("contact_info_header_helper");
    b.pFo.aDx();
    AppMethodBeat.o(27160);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27161);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      dvr();
    }
    AppMethodBeat.o(27161);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27162);
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      if ((paramInt == 40) || (paramInt == 34)) {
        dvr();
      }
    }
    AppMethodBeat.o(27162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j
 * JD-Core Version:    0.7.0.1
 */