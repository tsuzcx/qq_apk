package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements bc, com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void C(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(28366);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      paramContext = h.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(28360);
          int j = z.aUl();
          if (this.qNu) {}
          for (int i = j & 0xFFFFFEFF;; i = j | 0x100)
          {
            Log.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[] { Boolean.valueOf(this.qNu), Integer.valueOf(j), Integer.valueOf(i) });
            bg.aVF();
            c.azQ().set(34, Integer.valueOf(i));
            bg.aVF();
            c.aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.qNu) {
              m.eUp();
            }
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
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
          if (this.qDa != null)
          {
            this.qDa.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(28361);
        }
      }, 1500L);
      AppMethodBeat.o(28366);
      return;
    }
  }
  
  private void cCt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(28365);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    int i;
    if (localObject != null)
    {
      ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758061));
      if (bool3)
      {
        i = 1;
        ((HelperHeaderPreference)localObject).updateStatus(i);
      }
    }
    else
    {
      this.screen.jdMethod_do("contact_info_shake_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label152;
      }
      bool1 = true;
      label105:
      ((f)localObject).jdMethod_do("contact_info_shake_go_shake", bool1);
      localObject = this.screen;
      if (bool3) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).jdMethod_do("contact_info_shake_uninstall", bool1);
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
    if ((z.aUl() & 0x100) == 0)
    {
      AppMethodBeat.o(28363);
      return true;
    }
    AppMethodBeat.o(28363);
    return false;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(28364);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Jh(paramas.field_username));
      bg.aVF();
      c.azQ().add(this);
      bg.aVF();
      c.a(this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2132017194);
      cCt();
      AppMethodBeat.o(28364);
      return true;
    }
  }
  
  public final void aVw()
  {
    AppMethodBeat.i(28368);
    cCt();
    AppMethodBeat.o(28368);
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(28362);
    Log.d("MicroMsg.ContactWidgetShake", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(28362);
      return false;
    }
    if (paramString.equals("contact_info_shake_go_shake"))
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(this.context, ShakeReportUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Activity)this.context).finish();
      AppMethodBeat.o(28362);
      return true;
    }
    if (paramString.equals("contact_info_shake_install"))
    {
      C(this.context, true);
      AppMethodBeat.o(28362);
      return true;
    }
    if (paramString.equals("contact_info_shake_uninstall"))
    {
      h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(28359);
          a.C(a.a(a.this), false);
          AppMethodBeat.o(28359);
        }
      }, null);
      AppMethodBeat.o(28362);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28362);
    return false;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(28367);
    bg.aVF();
    c.azQ().remove(this);
    bg.aVF();
    c.b(this);
    com.tencent.mm.plugin.shake.a.jRu.WZ();
    AppMethodBeat.o(28367);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(28369);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bg.aVF();
    if ((paramMStorageEx != c.azQ()) || (i <= 0))
    {
      Log.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(28369);
      return;
    }
    if ((i != 7) && (i != 34))
    {
      AppMethodBeat.o(28369);
      return;
    }
    cCt();
    AppMethodBeat.o(28369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a
 * JD-Core Version:    0.7.0.1
 */