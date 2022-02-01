package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.x;
import com.tencent.threadpool.i;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private boolean MVt;
  private au contact;
  private Context context;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void M(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27751);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = k.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27748);
          b.m(64, this.xve, 5);
          b.m(8192, this.xve, 12);
          int i = z.bBf();
          if (this.xve) {
            i &= 0xFFFFFFDF;
          }
          for (;;)
          {
            bh.bCz();
            com.tencent.mm.model.c.ban().B(34, Integer.valueOf(i));
            bh.bCz();
            com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.xve) {
              com.tencent.mm.plugin.qmessage.model.f.gDK();
            }
            if (this.KNw != null) {
              this.KNw.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27748);
            return;
            i |= 0x20;
          }
        }
      };
      com.tencent.threadpool.h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27749);
          if (b.this != null)
          {
            b.this.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27749);
        }
      }, 5000L);
      AppMethodBeat.o(27751);
      return;
    }
  }
  
  private static boolean afZ(int paramInt)
  {
    AppMethodBeat.i(27753);
    if ((z.bAQ() & paramInt) != 0)
    {
      AppMethodBeat.o(27753);
      return true;
    }
    AppMethodBeat.o(27753);
    return false;
  }
  
  private void dvr()
  {
    AppMethodBeat.i(27755);
    boolean bool1 = isOpen();
    boolean bool2 = afZ(64);
    afZ(8192);
    this.screen.removeAll();
    this.screen.aBe(R.o.haU);
    HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    localHelperHeaderPreference.bz(this.contact.field_username, this.contact.aSV(), this.context.getString(R.l.gBJ));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      localHelperHeaderPreference.updateStatus(i);
      if (bool1) {
        break;
      }
      this.screen.bAk("contact_info_view_message");
      this.screen.bAk("contact_info_qmessage_recv_offline_msg");
      this.screen.bAk("contact_info_qmessage_uninstall");
      this.screen.bAk("contact_info_qmessage_clear_data");
      AppMethodBeat.o(27755);
      return;
    }
    this.screen.bAk("contact_info_qmessage_install");
    ((CheckBoxPreference)this.screen.bAi("contact_info_qmessage_recv_offline_msg")).setChecked(bool2);
    AppMethodBeat.o(27755);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(27752);
    if ((z.bBf() & 0x20) == 0)
    {
      AppMethodBeat.o(27752);
      return true;
    }
    AppMethodBeat.o(27752);
    return false;
  }
  
  private static void l(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(27756);
    int i = z.bAQ();
    if (paramBoolean)
    {
      paramInt1 = i | paramInt1;
      bh.bCz();
      com.tencent.mm.model.c.ban().B(7, Integer.valueOf(paramInt1));
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.h(paramInt2, paramInt1));
      AppMethodBeat.o(27756);
      return;
      paramInt1 = i & (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(27754);
    if (paramau != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      Assert.assertTrue(au.bvX(paramau.field_username));
      bool1 = bool2;
      if (paramf != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      bh.bCz();
      com.tencent.mm.model.c.ban().add(this);
      this.contact = paramau;
      this.MVt = paramBoolean;
      this.screen = paramf;
      dvr();
      AppMethodBeat.o(27754);
      return true;
    }
  }
  
  public final boolean anl(final String paramString)
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
      if (this.MVt) {
        ((Activity)this.context).setResult(-1, (Intent)localObject);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        AppMethodBeat.o(27750);
        return true;
        paramString = this.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/qmessage/ui/ContactWidgetQMessage", "viewMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/qmessage/ui/ContactWidgetQMessage", "viewMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramString.equals("contact_info_qmessage_recv_offline_msg"))
    {
      paramString = (CheckBoxPreference)this.screen.bAi(paramString);
      if (paramString.isChecked()) {
        l(64, true, 5);
      }
      for (;;)
      {
        AppMethodBeat.o(27750);
        return true;
        if (!afZ(8192))
        {
          l(64, false, 5);
          AppMethodBeat.o(27750);
          return true;
        }
        k.a(this.context, R.l.gBI, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27743);
            b.m(8192, false, 12);
            b.m(64, false, 5);
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
      l(8192, ((CheckBoxPreference)this.screen.bAi(paramString)).isChecked(), 12);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_clear_data"))
    {
      k.b(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27745);
          com.tencent.mm.plugin.qmessage.model.f.gDK();
          AppMethodBeat.o(27745);
        }
      }, null);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_install"))
    {
      bh.bCz();
      if (Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(9, null)) == 0)
      {
        k.b(this.context, R.l.settings_weibo_notice, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      M(this.context, true);
      AppMethodBeat.o(27750);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_uninstall"))
    {
      k.b(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27747);
          b.M(b.b(b.this), false);
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
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27757);
    bh.bCz();
    com.tencent.mm.model.c.ban().remove(this);
    com.tencent.mm.plugin.qmessage.a.gDG().aDx();
    AppMethodBeat.o(27757);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27758);
    bh.bCz();
    if (paramMStorageEx != com.tencent.mm.model.c.ban())
    {
      AppMethodBeat.o(27758);
      return;
    }
    dvr();
    AppMethodBeat.o(27758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b
 * JD-Core Version:    0.7.0.1
 */