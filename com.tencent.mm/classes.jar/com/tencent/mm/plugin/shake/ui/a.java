package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements ay, com.tencent.mm.pluginsdk.b.a, n.b
{
  private an contact;
  Context context;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void ceD()
  {
    boolean bool2 = true;
    AppMethodBeat.i(28365);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    int i;
    if (localObject != null)
    {
      ((HelperHeaderPreference)localObject).ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757821));
      if (bool3)
      {
        i = 1;
        ((HelperHeaderPreference)localObject).updateStatus(i);
      }
    }
    else
    {
      this.screen.cT("contact_info_shake_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label152;
      }
      bool1 = true;
      label105:
      ((f)localObject).cT("contact_info_shake_go_shake", bool1);
      localObject = this.screen;
      if (bool3) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cT("contact_info_shake_uninstall", bool1);
      AppMethodBeat.o(28365);
      return;
      i = 0;
      break;
      bool1 = false;
      break label105;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(28363);
    if ((v.aAO() & 0x100) == 0)
    {
      AppMethodBeat.o(28363);
      return true;
    }
    AppMethodBeat.o(28363);
    return false;
  }
  
  public static void z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(28366);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new aq()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(28360);
          int j = v.aAO();
          if (this.pyd) {}
          for (int i = j & 0xFFFFFEFF;; i = j | 0x100)
          {
            ae.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[] { Boolean.valueOf(this.pyd), Integer.valueOf(j), Integer.valueOf(i) });
            bc.aCg();
            c.ajA().set(34, Integer.valueOf(i));
            bc.aCg();
            c.azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.pyd) {
              m.dSo();
            }
            if (this.vTv != null) {
              this.vTv.a(null, null);
            }
            AppMethodBeat.o(28360);
            return;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(28361);
          if (this.pnu != null)
          {
            this.pnu.dismiss();
            this.uOZ.sendEmptyMessage(0);
          }
          AppMethodBeat.o(28361);
        }
      }, 1500L);
      AppMethodBeat.o(28366);
      return;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(28369);
    int i = bu.m(paramObject, 0);
    ae.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    bc.aCg();
    if ((paramn != c.ajA()) || (i <= 0))
    {
      ae.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(28369);
      return;
    }
    if ((i != 7) && (i != 34))
    {
      AppMethodBeat.o(28369);
      return;
    }
    ceD();
    AppMethodBeat.o(28369);
  }
  
  public final boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(28364);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paraman != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(x.AC(paraman.field_username));
      bc.aCg();
      c.ajA().a(this);
      bc.aCg();
      c.a(this);
      this.contact = paraman;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951656);
      ceD();
      AppMethodBeat.o(28364);
      return true;
    }
  }
  
  public final void aBX()
  {
    AppMethodBeat.i(28368);
    ceD();
    AppMethodBeat.o(28368);
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(28362);
    ae.d("MicroMsg.ContactWidgetShake", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bu.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(28362);
      return false;
    }
    if (paramString.equals("contact_info_shake_go_shake"))
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(this.context, ShakeReportUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Activity)this.context).finish();
      AppMethodBeat.o(28362);
      return true;
    }
    if (paramString.equals("contact_info_shake_install"))
    {
      z(this.context, true);
      AppMethodBeat.o(28362);
      return true;
    }
    if (paramString.equals("contact_info_shake_uninstall"))
    {
      h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(28359);
          a.z(a.this.context, false);
          AppMethodBeat.o(28359);
        }
      }, null);
      AppMethodBeat.o(28362);
      return true;
    }
    ae.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28362);
    return false;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(28367);
    bc.aCg();
    c.ajA().b(this);
    bc.aCg();
    c.b(this);
    com.tencent.mm.plugin.shake.a.iUA.MM();
    AppMethodBeat.o(28367);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a
 * JD-Core Version:    0.7.0.1
 */