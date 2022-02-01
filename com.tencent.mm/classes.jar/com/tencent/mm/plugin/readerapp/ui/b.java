package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.readerapp.a.h;
import com.tencent.mm.plugin.readerapp.a.i;
import com.tencent.mm.plugin.readerapp.model.d;
import com.tencent.mm.plugin.readerapp.model.d.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.edx;
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
  private au contact;
  private Context context;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  static void changeNews(boolean paramBoolean)
  {
    AppMethodBeat.i(102695);
    int i = z.bAU();
    if (paramBoolean)
    {
      i &= 0xFFFFFBFF;
      com.tencent.mm.kernel.h.baE().ban().B(40, Integer.valueOf(i));
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (i = 2;; i = 1)
    {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new com.tencent.mm.ay.h(26, i));
      AppMethodBeat.o(102695);
      return;
      i |= 0x400;
      break;
    }
  }
  
  private void dvr()
  {
    AppMethodBeat.i(102698);
    boolean bool1 = isOpen();
    this.screen.removeAll();
    this.screen.aBe(a.i.NvE);
    Object localObject = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bz(this.contact.field_username, this.contact.aSV(), this.context.getString(a.h.NvA));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      localObject = (CheckBoxPreference)this.screen.bAi("contact_info_readerappnews_recv_remind");
      boolean bool2 = com.tencent.mm.plugin.readerapp.model.b.gFz();
      Log.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = ".concat(String.valueOf(bool2)));
      if (localObject != null) {
        ((CheckBoxPreference)localObject).setChecked(bool2);
      }
      ((CheckBoxPreference)this.screen.bAi("contact_info_readerappnews_mute")).setChecked(this.contact.aGe());
      ((CheckBoxPreference)this.screen.bAi("contact_info_readerappnews_top")).setChecked(this.contact.aSQ());
      if (!bool1) {
        break;
      }
      this.screen.bAk("contact_info_readerappnews_install");
      AppMethodBeat.o(102698);
      return;
    }
    this.screen.bAk("contact_info_readerappnews_subscribe");
    this.screen.bAk("contact_info_readerappnews_view");
    this.screen.bAk("contact_info_readerappnews_clear_data");
    this.screen.bAk("contact_info_readerappnews_uninstall");
    this.screen.bAk("contact_info_readerappnews_recv_remind");
    this.screen.bAk("contact_info_readerappnews_mute");
    this.screen.bAk("contact_info_readerappnews_top");
    AppMethodBeat.o(102698);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(102694);
    if ((z.bBf() & 0x80000) == 0)
    {
      AppMethodBeat.o(102694);
      return true;
    }
    AppMethodBeat.o(102694);
    return false;
  }
  
  public final void M(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(102699);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(a.h.settings_plugins_installing);; localObject = paramContext.getString(a.h.settings_plugins_uninstalling))
    {
      paramContext.getString(a.h.app_tip);
      localObject = k.a(paramContext, (String)localObject, true, null);
      paramContext = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(102692);
          int i = z.bBf();
          if (paramBoolean)
          {
            i &= 0xFFF7FFFF;
            com.tencent.mm.kernel.h.baE().ban().B(34, Integer.valueOf(i));
            paramAnonymousMessage = new edx();
            paramAnonymousMessage.YBX = 524288;
            if (!paramBoolean) {
              break label163;
            }
            i = 0;
            label59:
            paramAnonymousMessage.abiW = i;
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(39, paramAnonymousMessage));
            if (paramBoolean) {
              break label168;
            }
            d.a(new d.a()
            {
              public final boolean aMJ()
              {
                return false;
              }
              
              public final void gFy()
              {
                AppMethodBeat.i(102691);
                if (this.xif != null) {
                  this.xif.dismiss();
                }
                AppMethodBeat.o(102691);
              }
            });
            b.changeNews(false);
          }
          for (;;)
          {
            if (this.KNw != null) {
              this.KNw.onNotifyChange(null, null);
            }
            AppMethodBeat.o(102692);
            return;
            i |= 0x80000;
            break;
            label163:
            i = 1;
            break label59;
            label168:
            b.changeNews(true);
            ab.H(b.b(b.this));
          }
        }
      };
      com.tencent.threadpool.h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102693);
          if (this.xif != null)
          {
            this.xif.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(102693);
        }
      }, 5000L);
      AppMethodBeat.o(102699);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(102697);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramau != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(au.bwg(paramau.field_username));
      com.tencent.mm.kernel.h.baE().ban().add(this);
      this.contact = paramau;
      this.screen = paramf;
      dvr();
      AppMethodBeat.o(102697);
      return true;
    }
  }
  
  public final boolean anl(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102696);
    Log.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(102696);
      return false;
    }
    Object localObject;
    if (paramString.equals("contact_info_readerappnews_view"))
    {
      localObject = new Intent(this.context, ReaderAppUI.class);
      ((Intent)localObject).putExtra("type", 20);
      ((Intent)localObject).setFlags(67108864);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.readerapp.b.a.pFo.aDx();
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_subscribe"))
    {
      localObject = new Intent(this.context, ReaderAppSubscribeUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_clear_data"))
    {
      k.b(this.context, this.context.getString(a.h.contact_info_clear_data_alert), "", this.context.getString(a.h.app_clear), this.context.getString(a.h.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(102689);
          d.a(new d.a()
          {
            public final boolean aMJ()
            {
              return false;
            }
            
            public final void gFy()
            {
              AppMethodBeat.i(102688);
              this.val$progressDialog.dismiss();
              AppMethodBeat.o(102688);
            }
          });
          AppMethodBeat.o(102689);
        }
      }, null);
      AppMethodBeat.o(102696);
      return true;
    }
    boolean bool1;
    if (paramString.equals("contact_info_readerappnews_recv_remind"))
    {
      paramString = (CheckBoxPreference)this.screen.bAi(paramString);
      boolean bool3 = com.tencent.mm.plugin.readerapp.model.b.gFz();
      if (!bool3)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(7), "", "" });
        if (paramString != null) {
          if (bool3) {
            break label503;
          }
        }
      }
      label503:
      for (bool1 = true;; bool1 = false)
      {
        paramString.setChecked(bool1);
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        changeNews(bool1);
        AppMethodBeat.o(102696);
        return true;
        com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(6), "", "" });
        break;
      }
    }
    if (paramString.equals("contact_info_readerappnews_top"))
    {
      bool1 = ((CheckBoxPreference)this.screen.bAi(paramString)).isChecked();
      Log.d("MicroMsg.ContactWidgetReaderAppNews", "placed appnews to the top");
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(13) });
        ab.K("newsapp", true);
      }
      for (;;)
      {
        AppMethodBeat.o(102696);
        return true;
        com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(14) });
        ab.L("newsapp", true);
      }
    }
    if (paramString.equals("contact_info_readerappnews_mute"))
    {
      this.screen.bAi(paramString);
      if (this.contact.aGe())
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(11) });
        ab.H(this.contact);
      }
      for (;;)
      {
        AppMethodBeat.o(102696);
        return true;
        com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(12) });
        ab.G(this.contact);
      }
    }
    if (paramString.equals("contact_info_readerappnews_install"))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(5), "", "" });
      M(this.context, true);
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_uninstall"))
    {
      k.b(this.context, this.context.getString(a.h.settings_plugins_uninstall_hint), "", this.context.getString(a.h.app_clear), this.context.getString(a.h.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(102690);
          com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(4), "", "" });
          b.this.M(b.a(b.this), false);
          AppMethodBeat.o(102690);
        }
      }, null);
      AppMethodBeat.o(102696);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(102696);
    return false;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(102700);
    com.tencent.mm.kernel.h.baE().ban().remove(this);
    com.tencent.mm.plugin.readerapp.b.a.pFo.aDx();
    AppMethodBeat.o(102700);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(102701);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.baE().ban()) || (i <= 0))
    {
      Log.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(102701);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(102701);
      return;
    }
    dvr();
    AppMethodBeat.o(102701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b
 * JD-Core Version:    0.7.0.1
 */