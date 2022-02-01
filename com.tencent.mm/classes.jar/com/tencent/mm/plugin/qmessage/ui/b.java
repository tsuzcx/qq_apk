package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private an contact;
  Context context;
  private f screen;
  private boolean xfQ;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static boolean NP(int paramInt)
  {
    AppMethodBeat.i(27753);
    if ((v.aAG() & paramInt) != 0)
    {
      AppMethodBeat.o(27753);
      return true;
    }
    AppMethodBeat.o(27753);
    return false;
  }
  
  static void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(27756);
    int i = v.aAG();
    if (paramBoolean)
    {
      paramInt1 = i | paramInt1;
      bc.aCg();
      c.ajA().set(7, Integer.valueOf(paramInt1));
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      bc.aCg();
      c.azE().d(new com.tencent.mm.ba.h(paramInt2, paramInt1));
      AppMethodBeat.o(27756);
      return;
      paramInt1 = i & (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(27752);
    if ((v.aAO() & 0x20) == 0)
    {
      AppMethodBeat.o(27752);
      return true;
    }
    AppMethodBeat.o(27752);
    return false;
  }
  
  public static void z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27751);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new aq()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27748);
          b.e(64, this.pyd, 5);
          b.e(8192, this.pyd, 12);
          int i = v.aAO();
          if (this.pyd) {
            i &= 0xFFFFFFDF;
          }
          for (;;)
          {
            bc.aCg();
            c.ajA().set(34, Integer.valueOf(i));
            bc.aCg();
            c.azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.pyd) {
              g.dFm();
            }
            if (this.vTv != null) {
              this.vTv.a(null, null);
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
          if (this.pnu != null)
          {
            this.pnu.dismiss();
            this.uOZ.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27749);
        }
      }, 5000L);
      AppMethodBeat.o(27751);
      return;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27758);
    bc.aCg();
    if (paramn != c.ajA())
    {
      AppMethodBeat.o(27758);
      return;
    }
    ceD();
    AppMethodBeat.o(27758);
  }
  
  public final boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(27754);
    if (paraman != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      Assert.assertTrue(x.Av(paraman.field_username));
      bool1 = bool2;
      if (paramf != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      bc.aCg();
      c.ajA().a(this);
      this.contact = paraman;
      this.xfQ = paramBoolean;
      this.screen = paramf;
      ceD();
      AppMethodBeat.o(27754);
      return true;
    }
  }
  
  public final boolean abx(final String paramString)
  {
    AppMethodBeat.i(27750);
    ae.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bu.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27750);
      return false;
    }
    if (paramString.equals("contact_info_view_message"))
    {
      Object localObject = new Intent(this.context, QConversationUI.class);
      if (this.xfQ) {
        ((Activity)this.context).setResult(-1, (Intent)localObject);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        AppMethodBeat.o(27750);
        return true;
        paramString = this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/qmessage/ui/ContactWidgetQMessage", "viewMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qmessage/ui/ContactWidgetQMessage", "viewMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qmessage_recv_offline_msg"))
    {
      paramString = (CheckBoxPreference)this.screen.aXe(paramString);
      if (paramString.isChecked()) {
        e(64, true, 5);
      }
      for (;;)
      {
        AppMethodBeat.o(27750);
        return true;
        if (!NP(8192))
        {
          e(64, false, 5);
          AppMethodBeat.o(27750);
          return true;
        }
        com.tencent.mm.ui.base.h.a(this.context, 2131757757, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27743);
            b.e(8192, false, 12);
            b.e(64, false, 5);
            AppMethodBeat.o(27743);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27744);
            paramString.setChecked(true);
            b.this.ceD();
            AppMethodBeat.o(27744);
          }
        });
      }
    }
    if (paramString.equals("contact_info_qmessage_display_weixin_online"))
    {
      e(8192, ((CheckBoxPreference)this.screen.aXe(paramString)).isChecked(), 12);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_clear_data"))
    {
      com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27745);
          g.dFm();
          AppMethodBeat.o(27745);
        }
      }, null);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_install"))
    {
      bc.aCg();
      if (bu.o((Integer)c.ajA().get(9, null)) == 0)
      {
        com.tencent.mm.ui.base.h.b(this.context, 2131763508, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27746);
            d.a(b.this.context, "account", "com.tencent.mm.plugin.account.bind.ui.BindQQUI", null);
            AppMethodBeat.o(27746);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(27750);
        return true;
      }
      z(this.context, true);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_uninstall"))
    {
      com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27747);
          b.z(b.this.context, false);
          AppMethodBeat.o(27747);
        }
      }, null);
      AppMethodBeat.o(27750);
      return true;
    }
    ae.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27750);
    return false;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27757);
    bc.aCg();
    c.ajA().b(this);
    com.tencent.mm.plugin.qmessage.a.xpR.MM();
    AppMethodBeat.o(27757);
    return true;
  }
  
  final void ceD()
  {
    AppMethodBeat.i(27755);
    boolean bool1 = isOpen();
    boolean bool2 = NP(64);
    NP(8192);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951650);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    localHelperHeaderPreference.ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757760));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      localHelperHeaderPreference.updateStatus(i);
      if (bool1) {
        break;
      }
      this.screen.aXf("contact_info_view_message");
      this.screen.aXf("contact_info_qmessage_recv_offline_msg");
      this.screen.aXf("contact_info_qmessage_uninstall");
      this.screen.aXf("contact_info_qmessage_clear_data");
      AppMethodBeat.o(27755);
      return;
    }
    this.screen.aXf("contact_info_qmessage_install");
    ((CheckBoxPreference)this.screen.aXe("contact_info_qmessage_recv_offline_msg")).setChecked(bool2);
    AppMethodBeat.o(27755);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b
 * JD-Core Version:    0.7.0.1
 */