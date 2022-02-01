package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements av, com.tencent.mm.pluginsdk.b.a, n.b
{
  private af contact;
  Context context;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bRv()
  {
    boolean bool2 = true;
    AppMethodBeat.i(28365);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.aKk("contact_info_header_helper");
    int i;
    if (localObject != null)
    {
      ((HelperHeaderPreference)localObject).aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757821));
      if (bool3)
      {
        i = 1;
        ((HelperHeaderPreference)localObject).updateStatus(i);
      }
    }
    else
    {
      this.screen.cE("contact_info_shake_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label152;
      }
      bool1 = true;
      label105:
      ((f)localObject).cE("contact_info_shake_go_shake", bool1);
      localObject = this.screen;
      if (bool3) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cE("contact_info_shake_uninstall", bool1);
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
    if ((u.aqS() & 0x100) == 0)
    {
      AppMethodBeat.o(28363);
      return true;
    }
    AppMethodBeat.o(28363);
    return false;
  }
  
  public static void w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(28366);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(28360);
          int j = u.aqS();
          if (this.okp) {}
          for (int i = j & 0xFFFFFEFF;; i = j | 0x100)
          {
            ad.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[] { Boolean.valueOf(this.okp), Integer.valueOf(j), Integer.valueOf(i) });
            az.arV();
            c.afk().set(34, Integer.valueOf(i));
            az.arV();
            c.apL().c(new com.tencent.mm.bb.k("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.okp) {
              m.dpe();
            }
            if (this.tvY != null) {
              this.tvY.a(null, null);
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
          if (this.nZT != null)
          {
            this.nZT.dismiss();
            this.ssV.sendEmptyMessage(0);
          }
          AppMethodBeat.o(28361);
        }
      }, 1500L);
      AppMethodBeat.o(28366);
      return;
    }
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(28362);
    ad.d("MicroMsg.ContactWidgetShake", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(28362);
      return false;
    }
    if (paramString.equals("contact_info_shake_go_shake"))
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(this.context, ShakeReportUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Activity)this.context).finish();
      AppMethodBeat.o(28362);
      return true;
    }
    if (paramString.equals("contact_info_shake_install"))
    {
      w(this.context, true);
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
          a.w(a.this.context, false);
          AppMethodBeat.o(28359);
        }
      }, null);
      AppMethodBeat.o(28362);
      return true;
    }
    ad.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28362);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(28369);
    int i = bt.i(paramObject, 0);
    ad.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.arV();
    if ((paramn != c.afk()) || (i <= 0))
    {
      ad.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(28369);
      return;
    }
    if ((i != 7) && (i != 34))
    {
      AppMethodBeat.o(28369);
      return;
    }
    bRv();
    AppMethodBeat.o(28369);
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(28364);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramaf != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.sS(paramaf.field_username));
      az.arV();
      c.afk().a(this);
      az.arV();
      c.a(this);
      this.contact = paramaf;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951656);
      bRv();
      AppMethodBeat.o(28364);
      return true;
    }
  }
  
  public final void arM()
  {
    AppMethodBeat.i(28368);
    bRv();
    AppMethodBeat.o(28368);
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(28367);
    az.arV();
    c.afk().b(this);
    az.arV();
    c.b(this);
    com.tencent.mm.plugin.shake.a.hYu.Ll();
    AppMethodBeat.o(28367);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a
 * JD-Core Version:    0.7.0.1
 */