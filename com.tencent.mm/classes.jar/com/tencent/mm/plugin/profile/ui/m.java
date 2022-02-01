package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class m
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private an contact;
  Context context;
  private boolean enable;
  private f screen;
  
  public m(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void ceD()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27215);
    this.enable = v.aBb();
    Object localObject = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757777));
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
      ((f)localObject).cT("contact_info_go_to_sync", bool1);
      localObject = this.screen;
      if (this.enable) {
        break label185;
      }
      bool1 = true;
      label115:
      ((f)localObject).cT("contact_info_remind_me_syncing_tip", bool1);
      this.screen.cT("contact_info_qqsync_install", this.enable);
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
      ((f)localObject).cT("contact_info_qqsync_uninstall", bool1);
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
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27214);
    if (this.enable != v.aBb()) {
      ceD();
    }
    AppMethodBeat.o(27214);
  }
  
  public final boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27212);
    bc.aCg();
    c.ajA().a(this);
    this.screen = paramf;
    this.contact = paraman;
    paramf.addPreferencesFromResource(2131951653);
    ceD();
    AppMethodBeat.o(27212);
    return true;
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(27210);
    if (bu.nullAsNil(paramString).length() <= 0)
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync", "goToSync", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(27210);
        return true;
        h.a(this.context, 2131757775, 2131755906, 2131755714, 2131755691, new m.2(this), null);
      }
    }
    if ("contact_info_remind_me_syncing".equals(paramString))
    {
      paramString = (CheckBoxPreference)this.screen.aXe("contact_info_remind_me_syncing");
      bc.aCg();
      c.ajA().set(65792, Boolean.valueOf(paramString.isChecked()));
      if (paramString.isChecked()) {}
      for (paramString = "1";; paramString = "2")
      {
        cb.F(6, paramString);
        AppMethodBeat.o(27210);
        return true;
      }
    }
    if (paramString.equals("contact_info_qqsync_install"))
    {
      x(this.context, true);
      AppMethodBeat.o(27210);
      return true;
    }
    if (paramString.equals("contact_info_qqsync_uninstall"))
    {
      h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27206);
          m.this.x(m.this.context, false);
          AppMethodBeat.o(27206);
        }
      }, null);
      AppMethodBeat.o(27210);
      return true;
    }
    AppMethodBeat.o(27210);
    return false;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27213);
    bc.aCg();
    c.ajA().b(this);
    AppMethodBeat.o(27213);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void x(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27211);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131763362);; str = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = h.b(paramContext, str, true, null);
      bc.ajU().aw(new Runnable()
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
            cb.F(6, str);
            i = v.aAO();
            if (!bool) {
              break label145;
            }
            i &= 0xFFFFFF7F;
          }
          for (;;)
          {
            bc.aCg();
            c.ajA().set(34, Integer.valueOf(i));
            bc.aCg();
            c.azE().d(new l("", "", "", "", "", "", "", "", i, "", ""));
            if (!paramBoolean)
            {
              bl.BR("qqsync");
              bc.aCg();
              c.azL().aUY("qqsync");
            }
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(27208);
                m.3.this.pnu.dismiss();
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