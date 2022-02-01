package com.tencent.mm.plugin.qmessage.ui;

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
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange
{
  private boolean Bdx;
  private as contact;
  private Context context;
  private f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void C(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27751);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      paramContext = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27748);
          b.f(64, this.qNu, 5);
          b.f(8192, this.qNu, 12);
          int i = z.aUl();
          if (this.qNu) {
            i &= 0xFFFFFFDF;
          }
          for (;;)
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(34, Integer.valueOf(i));
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.qNu) {
              g.eGb();
            }
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27748);
            return;
            i |= 0x20;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(27749);
          if (this.qDa != null)
          {
            this.qDa.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27749);
        }
      }, 5000L);
      AppMethodBeat.o(27751);
      return;
    }
  }
  
  private static boolean Ve(int paramInt)
  {
    AppMethodBeat.i(27753);
    if ((z.aUc() & paramInt) != 0)
    {
      AppMethodBeat.o(27753);
      return true;
    }
    AppMethodBeat.o(27753);
    return false;
  }
  
  private void cCt()
  {
    AppMethodBeat.i(27755);
    boolean bool1 = isOpen();
    boolean bool2 = Ve(64);
    Ve(8192);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017188);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    localHelperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131757997));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      localHelperHeaderPreference.updateStatus(i);
      if (bool1) {
        break;
      }
      this.screen.bmi("contact_info_view_message");
      this.screen.bmi("contact_info_qmessage_recv_offline_msg");
      this.screen.bmi("contact_info_qmessage_uninstall");
      this.screen.bmi("contact_info_qmessage_clear_data");
      AppMethodBeat.o(27755);
      return;
    }
    this.screen.bmi("contact_info_qmessage_install");
    ((CheckBoxPreference)this.screen.bmg("contact_info_qmessage_recv_offline_msg")).setChecked(bool2);
    AppMethodBeat.o(27755);
  }
  
  private static void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(27756);
    int i = z.aUc();
    if (paramBoolean)
    {
      paramInt1 = i | paramInt1;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(7, Integer.valueOf(paramInt1));
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.h(paramInt2, paramInt1));
      AppMethodBeat.o(27756);
      return;
      paramInt1 = i & (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(27752);
    if ((z.aUl() & 0x20) == 0)
    {
      AppMethodBeat.o(27752);
      return true;
    }
    AppMethodBeat.o(27752);
    return false;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(27754);
    if (paramas != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      Assert.assertTrue(ab.Ja(paramas.field_username));
      bool1 = bool2;
      if (paramf != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      bg.aVF();
      com.tencent.mm.model.c.azQ().add(this);
      this.contact = paramas;
      this.Bdx = paramBoolean;
      this.screen = paramf;
      cCt();
      AppMethodBeat.o(27754);
      return true;
    }
  }
  
  public final boolean alD(final String paramString)
  {
    AppMethodBeat.i(27750);
    Log.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27750);
      return false;
    }
    if (paramString.equals("contact_info_view_message"))
    {
      Object localObject = new Intent(this.context, QConversationUI.class);
      if (this.Bdx) {
        ((Activity)this.context).setResult(-1, (Intent)localObject);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        AppMethodBeat.o(27750);
        return true;
        paramString = this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/qmessage/ui/ContactWidgetQMessage", "viewMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qmessage/ui/ContactWidgetQMessage", "viewMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qmessage_recv_offline_msg"))
    {
      paramString = (CheckBoxPreference)this.screen.bmg(paramString);
      if (paramString.isChecked()) {
        e(64, true, 5);
      }
      for (;;)
      {
        AppMethodBeat.o(27750);
        return true;
        if (!Ve(8192))
        {
          e(64, false, 5);
          AppMethodBeat.o(27750);
          return true;
        }
        com.tencent.mm.ui.base.h.a(this.context, 2131757994, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27743);
            b.f(8192, false, 12);
            b.f(64, false, 5);
            AppMethodBeat.o(27743);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27744);
            paramString.setChecked(true);
            b.a(b.this);
            AppMethodBeat.o(27744);
          }
        });
      }
    }
    if (paramString.equals("contact_info_qmessage_display_weixin_online"))
    {
      e(8192, ((CheckBoxPreference)this.screen.bmg(paramString)).isChecked(), 12);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_clear_data"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27745);
          g.eGb();
          AppMethodBeat.o(27745);
        }
      }, null);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_install"))
    {
      bg.aVF();
      if (Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(9, null)) == 0)
      {
        com.tencent.mm.ui.base.h.b(this.context, 2131765696, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27746);
            com.tencent.mm.br.c.a(b.b(b.this), "account", "com.tencent.mm.plugin.account.bind.ui.BindQQUI", null);
            AppMethodBeat.o(27746);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(27750);
        return true;
      }
      C(this.context, true);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27747);
          b.C(b.b(b.this), false);
          AppMethodBeat.o(27747);
        }
      }, null);
      AppMethodBeat.o(27750);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27750);
    return false;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27757);
    bg.aVF();
    com.tencent.mm.model.c.azQ().remove(this);
    com.tencent.mm.plugin.qmessage.a.Bqd.WZ();
    AppMethodBeat.o(27757);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27758);
    bg.aVF();
    if (paramMStorageEx != com.tencent.mm.model.c.azQ())
    {
      AppMethodBeat.o(27758);
      return;
    }
    cCt();
    AppMethodBeat.o(27758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b
 * JD-Core Version:    0.7.0.1
 */