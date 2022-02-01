package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.model.av, com.tencent.mm.pluginsdk.b.a, n.b
{
  private ai contact;
  Context context;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bYK()
  {
    boolean bool2 = true;
    AppMethodBeat.i(28365);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    int i;
    if (localObject != null)
    {
      ((HelperHeaderPreference)localObject).aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757821));
      if (bool3)
      {
        i = 1;
        ((HelperHeaderPreference)localObject).updateStatus(i);
      }
    }
    else
    {
      this.screen.cK("contact_info_shake_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label152;
      }
      bool1 = true;
      label105:
      ((f)localObject).cK("contact_info_shake_go_shake", bool1);
      localObject = this.screen;
      if (bool3) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cK("contact_info_shake_uninstall", bool1);
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
    if ((u.axI() & 0x100) == 0)
    {
      AppMethodBeat.o(28363);
      return true;
    }
    AppMethodBeat.o(28363);
    return false;
  }
  
  public static void x(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(28366);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new ao()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(28360);
          int j = u.axI();
          if (this.oNP) {}
          for (int i = j & 0xFFFFFEFF;; i = j | 0x100)
          {
            ac.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[] { Boolean.valueOf(this.oNP), Integer.valueOf(j), Integer.valueOf(i) });
            az.ayM();
            c.agA().set(34, Integer.valueOf(i));
            az.ayM();
            c.awA().c(new l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.oNP) {
              m.dDo();
            }
            if (this.uEr != null) {
              this.uEr.a(null, null);
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
          if (this.oDo != null)
          {
            this.oDo.dismiss();
            this.tAL.sendEmptyMessage(0);
          }
          AppMethodBeat.o(28361);
        }
      }, 1500L);
      AppMethodBeat.o(28366);
      return;
    }
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(28362);
    ac.d("MicroMsg.ContactWidgetShake", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(28362);
      return false;
    }
    if (paramString.equals("contact_info_shake_go_shake"))
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(this.context, ShakeReportUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Activity)this.context).finish();
      AppMethodBeat.o(28362);
      return true;
    }
    if (paramString.equals("contact_info_shake_install"))
    {
      x(this.context, true);
      AppMethodBeat.o(28362);
      return true;
    }
    if (paramString.equals("contact_info_shake_uninstall"))
    {
      h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(28359);
          a.x(a.this.context, false);
          AppMethodBeat.o(28359);
        }
      }, null);
      AppMethodBeat.o(28362);
      return true;
    }
    ac.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28362);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(28369);
    int i = bs.l(paramObject, 0);
    ac.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.ayM();
    if ((paramn != c.agA()) || (i <= 0))
    {
      ac.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(28369);
      return;
    }
    if ((i != 7) && (i != 34))
    {
      AppMethodBeat.o(28369);
      return;
    }
    bYK();
    AppMethodBeat.o(28369);
  }
  
  public final boolean a(f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(28364);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramai != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.wV(paramai.field_username));
      az.ayM();
      c.agA().a(this);
      az.ayM();
      c.a(this);
      this.contact = paramai;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951656);
      bYK();
      AppMethodBeat.o(28364);
      return true;
    }
  }
  
  public final void ayD()
  {
    AppMethodBeat.i(28368);
    bYK();
    AppMethodBeat.o(28368);
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(28367);
    az.ayM();
    c.agA().b(this);
    az.ayM();
    c.b(this);
    com.tencent.mm.plugin.shake.a.iyy.Lj();
    AppMethodBeat.o(28367);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a
 * JD-Core Version:    0.7.0.1
 */