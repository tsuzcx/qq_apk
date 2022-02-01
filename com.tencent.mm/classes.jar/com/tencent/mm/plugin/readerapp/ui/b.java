package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.readerapp.c.c;
import com.tencent.mm.plugin.readerapp.c.g.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private af contact;
  Context context;
  private f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bRv()
  {
    AppMethodBeat.i(102698);
    boolean bool1 = isOpen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951654);
    Object localObject = (HelperHeaderPreference)this.screen.aKk("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757782));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      localObject = (CheckBoxPreference)this.screen.aKk("contact_info_readerappnews_recv_remind");
      boolean bool2 = c.dfx();
      ad.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = ".concat(String.valueOf(bool2)));
      if (localObject != null) {
        ((CheckBoxPreference)localObject).lG = bool2;
      }
      if (!bool1) {
        break;
      }
      this.screen.aKl("contact_info_readerappnews_install");
      AppMethodBeat.o(102698);
      return;
    }
    this.screen.aKl("contact_info_readerappnews_subscribe");
    this.screen.aKl("contact_info_readerappnews_view");
    this.screen.aKl("contact_info_readerappnews_clear_data");
    this.screen.aKl("contact_info_readerappnews_uninstall");
    this.screen.aKl("contact_info_readerappnews_recv_remind");
    AppMethodBeat.o(102698);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(102694);
    if ((u.aqS() & 0x80000) == 0)
    {
      AppMethodBeat.o(102694);
      return true;
    }
    AppMethodBeat.o(102694);
    return false;
  }
  
  static void on(boolean paramBoolean)
  {
    AppMethodBeat.i(102695);
    int i = u.aqM();
    if (paramBoolean)
    {
      i &= 0xFFFFFBFF;
      com.tencent.mm.kernel.g.afB().afk().set(40, Integer.valueOf(i));
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (i = 2;; i = 1)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new com.tencent.mm.bb.g(26, i));
      AppMethodBeat.o(102695);
      return;
      i |= 0x400;
      break;
    }
  }
  
  public static void w(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(102699);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      paramContext = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(102692);
          if (this.okp) {
            b.on(true);
          }
          int i = u.aqS();
          if (this.okp)
          {
            i &= 0xFFF7FFFF;
            com.tencent.mm.kernel.g.afB().afk().set(34, Integer.valueOf(i));
            paramAnonymousMessage = new cau();
            paramAnonymousMessage.CuI = 524288;
            if (!this.okp) {
              break label173;
            }
          }
          label173:
          for (i = 0;; i = 1)
          {
            paramAnonymousMessage.DXj = i;
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(39, paramAnonymousMessage));
            if (!this.okp)
            {
              com.tencent.mm.plugin.readerapp.c.g.a(new g.a()
              {
                public final void dfw()
                {
                  AppMethodBeat.i(102691);
                  if (this.nZT != null) {
                    this.nZT.dismiss();
                  }
                  AppMethodBeat.o(102691);
                }
              });
              b.on(false);
            }
            if (this.tvY != null) {
              this.tvY.a(null, null);
            }
            AppMethodBeat.o(102692);
            return;
            i |= 0x80000;
            break;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(102693);
          if (this.nZT != null)
          {
            this.nZT.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(102693);
        }
      }, 5000L);
      AppMethodBeat.o(102699);
      return;
    }
  }
  
  public final boolean SN(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102696);
    ad.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(102696);
      return false;
    }
    Object localObject;
    if (paramString.equals("contact_info_readerappnews_view"))
    {
      localObject = new Intent(this.context, ReaderAppUI.class);
      ((Intent)localObject).putExtra("type", 20);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.readerapp.b.a.hYu.Ll();
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_subscribe"))
    {
      localObject = new Intent(this.context, ReaderAppSubscribeUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_clear_data"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131757631), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(102689);
          com.tencent.mm.plugin.readerapp.c.g.a(new g.a()
          {
            public final void dfw()
            {
              AppMethodBeat.i(102688);
              this.uVL.dismiss();
              AppMethodBeat.o(102688);
            }
          });
          AppMethodBeat.o(102689);
        }
      }, null);
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_recv_remind"))
    {
      paramString = (CheckBoxPreference)this.screen.aKk(paramString);
      boolean bool3 = c.dfx();
      if (!bool3)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(15413, new Object[] { Integer.valueOf(7), "", "" });
        if (paramString != null) {
          if (bool3) {
            break label486;
          }
        }
      }
      label486:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramString.lG = bool1;
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        on(bool1);
        AppMethodBeat.o(102696);
        return true;
        com.tencent.mm.plugin.report.service.h.vKh.f(15413, new Object[] { Integer.valueOf(6), "", "" });
        break;
      }
    }
    if (paramString.equals("contact_info_readerappnews_install"))
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(15413, new Object[] { Integer.valueOf(5), "", "" });
      w(this.context, true);
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_uninstall"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(102690);
          com.tencent.mm.plugin.report.service.h.vKh.f(15413, new Object[] { Integer.valueOf(4), "", "" });
          b.w(b.this.context, false);
          AppMethodBeat.o(102690);
        }
      }, null);
      AppMethodBeat.o(102696);
      return true;
    }
    ad.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(102696);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(102701);
    int i = bt.i(paramObject, 0);
    ad.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.afB().afk()) || (i <= 0))
    {
      ad.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(102701);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(102701);
      return;
    }
    bRv();
    AppMethodBeat.o(102701);
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(102697);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramaf != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.sU(paramaf.field_username));
      com.tencent.mm.kernel.g.afB().afk().a(this);
      this.contact = paramaf;
      this.screen = paramf;
      bRv();
      AppMethodBeat.o(102697);
      return true;
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(102700);
    com.tencent.mm.kernel.g.afB().afk().b(this);
    com.tencent.mm.plugin.readerapp.b.a.hYu.Ll();
    AppMethodBeat.o(102700);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b
 * JD-Core Version:    0.7.0.1
 */