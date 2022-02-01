package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.net.URI;
import java.net.URL;

public final class n
  implements com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private boolean enable;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void A(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27211);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131765544);; str = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      paramContext = h.a(paramContext, str, true, null);
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27209);
          n.sJ(paramBoolean);
          if (!paramBoolean) {
            n.access$300();
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27208);
              n.3.this.qDa.dismiss();
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
  
  private void cCt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27215);
    this.enable = z.aUy();
    Object localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758017));
    int i;
    if (this.enable)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      localObject = this.screen;
      if (this.enable) {
        break label180;
      }
      bool1 = true;
      label89:
      ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("contact_info_go_to_sync", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label185;
      }
      bool1 = true;
      label115:
      ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("contact_info_remind_me_syncing_tip", bool1);
      this.screen.jdMethod_do("contact_info_qqsync_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label190;
      }
    }
    label180:
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("contact_info_qqsync_uninstall", bool1);
      AppMethodBeat.o(27215);
      return;
      i = 0;
      break;
      bool1 = false;
      break label89;
      bool1 = false;
      break label115;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27212);
    bg.aVF();
    c.azQ().add(this);
    this.screen = paramf;
    this.contact = paramas;
    paramf.addPreferencesFromResource(2132017191);
    cCt();
    AppMethodBeat.o(27212);
    return true;
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(27210);
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27210);
      return false;
    }
    if ("contact_info_go_to_sync".equals(paramString))
    {
      if (q.s(this.context, "com.tencent.qqpim"))
      {
        Object localObject = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
        ((Intent)localObject).addFlags(268435456);
        paramString = this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(27210);
        return true;
        h.a(this.context, 2131758015, 2131755998, 2131755785, 2131755761, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27207);
            paramAnonymousDialogInterface = "http://tools.3g.qq.com/j/wechatandriodpim";
            Object localObject;
            if (ChannelUtil.channelId == 1)
            {
              localObject = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
              if (Util.isIntentAvailable(n.a(n.this), (Intent)localObject))
              {
                paramAnonymousDialogInterface = n.a(n.this);
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(27207);
                return;
              }
              paramAnonymousDialogInterface = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
            }
            try
            {
              paramAnonymousDialogInterface = new URL(paramAnonymousDialogInterface);
              paramAnonymousDialogInterface = new URI(paramAnonymousDialogInterface.getProtocol(), paramAnonymousDialogInterface.getUserInfo(), paramAnonymousDialogInterface.getHost(), paramAnonymousDialogInterface.getPort(), paramAnonymousDialogInterface.getPath(), paramAnonymousDialogInterface.getQuery(), paramAnonymousDialogInterface.getRef()).toURL();
              localObject = new g.a();
              ((g.a)localObject).all("qqpim.apk");
              ((g.a)localObject).alj(paramAnonymousDialogInterface.toString());
              ((g.a)localObject).kS(true);
              ((g.a)localObject).Fl(1);
              com.tencent.mm.plugin.downloader.model.f.cBv().a(((g.a)localObject).qIY);
              AppMethodBeat.o(27207);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              Log.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[] { paramAnonymousDialogInterface.toString() });
              AppMethodBeat.o(27207);
            }
          }
        }, null);
      }
    }
    if ("contact_info_remind_me_syncing".equals(paramString))
    {
      paramString = (CheckBoxPreference)this.screen.bmg("contact_info_remind_me_syncing");
      bg.aVF();
      c.azQ().set(65792, Boolean.valueOf(paramString.isChecked()));
      if (paramString.isChecked()) {}
      for (paramString = "1";; paramString = "2")
      {
        cf.I(6, paramString);
        AppMethodBeat.o(27210);
        return true;
      }
    }
    if (paramString.equals("contact_info_qqsync_install"))
    {
      A(this.context, true);
      AppMethodBeat.o(27210);
      return true;
    }
    if (paramString.equals("contact_info_qqsync_uninstall"))
    {
      h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27206);
          n.a(n.this, n.a(n.this));
          AppMethodBeat.o(27206);
        }
      }, null);
      AppMethodBeat.o(27210);
      return true;
    }
    AppMethodBeat.o(27210);
    return false;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27213);
    bg.aVF();
    c.azQ().remove(this);
    AppMethodBeat.o(27213);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27214);
    if (this.enable != z.aUy()) {
      cCt();
    }
    AppMethodBeat.o(27214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n
 * JD-Core Version:    0.7.0.1
 */