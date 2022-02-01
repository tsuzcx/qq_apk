package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.by;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.net.URI;
import java.net.URL;

public final class m
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private ai contact;
  Context context;
  private boolean enable;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public m(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bYK()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27215);
    this.enable = u.axT();
    Object localObject = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757777));
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
      ((com.tencent.mm.ui.base.preference.f)localObject).cK("contact_info_go_to_sync", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label185;
      }
      bool1 = true;
      label115:
      ((com.tencent.mm.ui.base.preference.f)localObject).cK("contact_info_remind_me_syncing_tip", bool1);
      this.screen.cK("contact_info_qqsync_install", this.enable);
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
      ((com.tencent.mm.ui.base.preference.f)localObject).cK("contact_info_qqsync_uninstall", bool1);
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
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(27210);
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27210);
      return false;
    }
    if ("contact_info_go_to_sync".equals(paramString))
    {
      if (q.t(this.context, "com.tencent.qqpim"))
      {
        Object localObject = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
        ((Intent)localObject).addFlags(268435456);
        paramString = this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(27210);
        return true;
        h.b(this.context, 2131757775, 2131755906, 2131755714, 2131755691, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27207);
            paramAnonymousDialogInterface = "http://tools.3g.qq.com/j/wechatandriodpim";
            Object localObject;
            if (com.tencent.mm.sdk.platformtools.i.cGY == 1)
            {
              localObject = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
              if (bs.ah(m.this.context, (Intent)localObject))
              {
                paramAnonymousDialogInterface = m.this.context;
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
              ((g.a)localObject).WF("qqpim.apk");
              ((g.a)localObject).WD(paramAnonymousDialogInterface.toString());
              ((g.a)localObject).jF(true);
              ((g.a)localObject).AG(1);
              com.tencent.mm.plugin.downloader.model.f.bXJ().a(((g.a)localObject).oJg);
              AppMethodBeat.o(27207);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              ac.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[] { paramAnonymousDialogInterface.toString() });
              AppMethodBeat.o(27207);
            }
          }
        }, null);
      }
    }
    if ("contact_info_remind_me_syncing".equals(paramString))
    {
      paramString = (CheckBoxPreference)this.screen.aPN("contact_info_remind_me_syncing");
      az.ayM();
      c.agA().set(65792, Boolean.valueOf(paramString.isChecked()));
      if (paramString.isChecked()) {}
      for (paramString = "1";; paramString = "2")
      {
        by.F(6, paramString);
        AppMethodBeat.o(27210);
        return true;
      }
    }
    if (paramString.equals("contact_info_qqsync_install"))
    {
      v(this.context, true);
      AppMethodBeat.o(27210);
      return true;
    }
    if (paramString.equals("contact_info_qqsync_uninstall"))
    {
      h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27206);
          m.this.v(m.this.context, false);
          AppMethodBeat.o(27206);
        }
      }, null);
      AppMethodBeat.o(27210);
      return true;
    }
    AppMethodBeat.o(27210);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27214);
    if (this.enable != u.axT()) {
      bYK();
    }
    AppMethodBeat.o(27214);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27212);
    az.ayM();
    c.agA().a(this);
    this.screen = paramf;
    this.contact = paramai;
    paramf.addPreferencesFromResource(2131951653);
    bYK();
    AppMethodBeat.o(27212);
    return true;
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27213);
    az.ayM();
    c.agA().b(this);
    AppMethodBeat.o(27213);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void v(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27211);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131763362);; str = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = h.b(paramContext, str, true, null);
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27209);
          boolean bool = paramBoolean;
          String str;
          int i;
          if (bool)
          {
            str = "3";
            by.F(6, str);
            i = u.axI();
            if (!bool) {
              break label145;
            }
            i &= 0xFFFFFF7F;
          }
          for (;;)
          {
            az.ayM();
            c.agA().set(34, Integer.valueOf(i));
            az.ayM();
            c.awA().c(new l("", "", "", "", "", "", "", "", i, "", ""));
            if (!paramBoolean)
            {
              bi.yq("qqsync");
              az.ayM();
              c.awG().aNG("qqsync");
            }
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(27208);
                m.3.this.oDo.dismiss();
                AppMethodBeat.o(27208);
              }
            });
            AppMethodBeat.o(27209);
            return;
            str = "4";
            break;
            label145:
            i |= 0x80;
          }
        }
      });
      AppMethodBeat.o(27211);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m
 * JD-Core Version:    0.7.0.1
 */