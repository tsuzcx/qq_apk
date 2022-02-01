package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class n
  implements com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private boolean enable;
  private f screen;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void D(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27211);
    if (paramBoolean) {}
    for (String str = paramContext.getString(R.l.settings_plugins_installing);; str = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = h.a(paramContext, str, true, null);
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27209);
          n.wa(paramBoolean);
          if (!paramBoolean) {
            n.access$300();
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27208);
              n.3.this.ucb.dismiss();
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
  
  private void cQY()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27215);
    this.enable = z.bdA();
    Object localObject = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bf(this.contact.field_username, this.contact.ays(), this.context.getString(R.l.eyT));
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
      ((f)localObject).dz("contact_info_go_to_sync", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label186;
      }
      bool1 = true;
      label116:
      ((f)localObject).dz("contact_info_remind_me_syncing_tip", bool1);
      this.screen.dz("contact_info_qqsync_install", this.enable);
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
      ((f)localObject).dz("contact_info_qqsync_uninstall", bool1);
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
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27212);
    bh.beI();
    c.aHp().add(this);
    this.screen = paramf;
    this.contact = paramas;
    paramf.auC(R.o.eXu);
    cQY();
    AppMethodBeat.o(27212);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(27210);
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27210);
      return false;
    }
    if ("contact_info_go_to_sync".equals(paramString))
    {
      if (q.u(this.context, "com.tencent.qqpim"))
      {
        Object localObject = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
        ((Intent)localObject).addFlags(268435456);
        paramString = this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(27210);
        return true;
        h.a(this.context, R.l.eyS, R.l.app_tip, R.l.app_download, R.l.app_cancel, new n.2(this), null);
      }
    }
    if ("contact_info_remind_me_syncing".equals(paramString))
    {
      paramString = (CheckBoxPreference)this.screen.byG("contact_info_remind_me_syncing");
      bh.beI();
      c.aHp().i(65792, Boolean.valueOf(paramString.isChecked()));
      if (paramString.isChecked()) {}
      for (paramString = "1";; paramString = "2")
      {
        cg.K(6, paramString);
        AppMethodBeat.o(27210);
        return true;
      }
    }
    if (paramString.equals("contact_info_qqsync_install"))
    {
      D(this.context, true);
      AppMethodBeat.o(27210);
      return true;
    }
    if (paramString.equals("contact_info_qqsync_uninstall"))
    {
      h.c(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new n.1(this), null);
      AppMethodBeat.o(27210);
      return true;
    }
    AppMethodBeat.o(27210);
    return false;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27213);
    bh.beI();
    c.aHp().remove(this);
    AppMethodBeat.o(27213);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27214);
    if (this.enable != z.bdA()) {
      cQY();
    }
    AppMethodBeat.o(27214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n
 * JD-Core Version:    0.7.0.1
 */