package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class o
  implements com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private au contact;
  private Context context;
  private boolean enable;
  private f screen;
  
  public o(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void G(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27211);
    if (paramBoolean) {}
    for (String str = paramContext.getString(R.l.settings_plugins_installing);; str = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = k.a(paramContext, str, true, null);
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27209);
          o.Ax(paramBoolean);
          if (!paramBoolean) {
            o.access$300();
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27208);
              o.3.this.xif.dismiss();
              AppMethodBeat.o(27208);
            }
          });
          AppMethodBeat.o(27209);
        }
      });
      AppMethodBeat.o(27211);
      return;
    }
  }
  
  private void dvr()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27215);
    this.enable = z.bBs();
    Object localObject = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bz(this.contact.field_username, this.contact.aSV(), this.context.getString(R.l.gBL));
    int i;
    if (this.enable)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      localObject = this.screen;
      if (this.enable) {
        break label181;
      }
      bool1 = true;
      label90:
      ((f)localObject).eh("contact_info_go_to_sync", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label186;
      }
      bool1 = true;
      label116:
      ((f)localObject).eh("contact_info_remind_me_syncing_tip", bool1);
      this.screen.eh("contact_info_qqsync_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label191;
      }
    }
    label181:
    label186:
    label191:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).eh("contact_info_qqsync_uninstall", bool1);
      AppMethodBeat.o(27215);
      return;
      i = 0;
      break;
      bool1 = false;
      break label90;
      bool1 = false;
      break label116;
    }
  }
  
  public final boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27212);
    bh.bCz();
    c.ban().add(this);
    this.screen = paramf;
    this.contact = paramau;
    paramf.aBe(R.o.haV);
    dvr();
    AppMethodBeat.o(27212);
    return true;
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(27210);
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27210);
      return false;
    }
    if ("contact_info_go_to_sync".equals(paramString))
    {
      if (u.y(this.context, "com.tencent.qqpim"))
      {
        Object localObject = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
        ((Intent)localObject).addFlags(268435456);
        paramString = this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(27210);
        return true;
        k.a(this.context, R.l.gBK, R.l.app_tip, R.l.app_download, R.l.app_cancel, new o.2(this), null);
      }
    }
    if ("contact_info_remind_me_syncing".equals(paramString))
    {
      paramString = (CheckBoxPreference)this.screen.bAi("contact_info_remind_me_syncing");
      bh.bCz();
      c.ban().B(65792, Boolean.valueOf(paramString.isChecked()));
      if (paramString.isChecked()) {}
      for (paramString = "1";; paramString = "2")
      {
        ch.P(6, paramString);
        AppMethodBeat.o(27210);
        return true;
      }
    }
    if (paramString.equals("contact_info_qqsync_install"))
    {
      G(this.context, true);
      AppMethodBeat.o(27210);
      return true;
    }
    if (paramString.equals("contact_info_qqsync_uninstall"))
    {
      k.b(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new o.1(this), null);
      AppMethodBeat.o(27210);
      return true;
    }
    AppMethodBeat.o(27210);
    return false;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27213);
    bh.bCz();
    c.ban().remove(this);
    AppMethodBeat.o(27213);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27214);
    if (this.enable != z.bBs()) {
      dvr();
    }
    AppMethodBeat.o(27214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.o
 * JD-Core Version:    0.7.0.1
 */