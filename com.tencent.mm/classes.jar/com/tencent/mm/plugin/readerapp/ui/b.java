package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.readerapp.c.c;
import com.tencent.mm.plugin.readerapp.c.g.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.clm;
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
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void ceD()
  {
    AppMethodBeat.i(102698);
    boolean bool1 = isOpen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951654);
    Object localObject = (HelperHeaderPreference)this.screen.aXe("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).ba(this.contact.field_username, this.contact.adG(), this.context.getString(2131757782));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      localObject = (CheckBoxPreference)this.screen.aXe("contact_info_readerappnews_recv_remind");
      boolean bool2 = c.dGS();
      ae.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = ".concat(String.valueOf(bool2)));
      if (localObject != null) {
        ((CheckBoxPreference)localObject).setChecked(bool2);
      }
      if (!bool1) {
        break;
      }
      this.screen.aXf("contact_info_readerappnews_install");
      AppMethodBeat.o(102698);
      return;
    }
    this.screen.aXf("contact_info_readerappnews_subscribe");
    this.screen.aXf("contact_info_readerappnews_view");
    this.screen.aXf("contact_info_readerappnews_clear_data");
    this.screen.aXf("contact_info_readerappnews_uninstall");
    this.screen.aXf("contact_info_readerappnews_recv_remind");
    AppMethodBeat.o(102698);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(102694);
    if ((v.aAO() & 0x80000) == 0)
    {
      AppMethodBeat.o(102694);
      return true;
    }
    AppMethodBeat.o(102694);
    return false;
  }
  
  static void pM(boolean paramBoolean)
  {
    AppMethodBeat.i(102695);
    int i = v.aAI();
    if (paramBoolean)
    {
      i &= 0xFFFFFBFF;
      com.tencent.mm.kernel.g.ajR().ajA().set(40, Integer.valueOf(i));
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (i = 2;; i = 1)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.ba.h(26, i));
      AppMethodBeat.o(102695);
      return;
      i |= 0x400;
      break;
    }
  }
  
  public static void z(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(102699);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      paramContext = new aq()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(102692);
          if (this.pyd) {
            b.pM(true);
          }
          int i = v.aAO();
          if (this.pyd)
          {
            i &= 0xFFF7FFFF;
            com.tencent.mm.kernel.g.ajR().ajA().set(34, Integer.valueOf(i));
            paramAnonymousMessage = new clm();
            paramAnonymousMessage.FKG = 524288;
            if (!this.pyd) {
              break label173;
            }
          }
          label173:
          for (i = 0;; i = 1)
          {
            paramAnonymousMessage.HxH = i;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(39, paramAnonymousMessage));
            if (!this.pyd)
            {
              com.tencent.mm.plugin.readerapp.c.g.a(new g.a()
              {
                public final void dGR()
                {
                  AppMethodBeat.i(102691);
                  if (this.pnu != null) {
                    this.pnu.dismiss();
                  }
                  AppMethodBeat.o(102691);
                }
              });
              b.pM(false);
            }
            if (this.vTv != null) {
              this.vTv.a(null, null);
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
          if (this.pnu != null)
          {
            this.pnu.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(102693);
        }
      }, 5000L);
      AppMethodBeat.o(102699);
      return;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(102701);
    int i = bu.m(paramObject, 0);
    ae.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.ajR().ajA()) || (i <= 0))
    {
      ae.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(102701);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(102701);
      return;
    }
    ceD();
    AppMethodBeat.o(102701);
  }
  
  public final boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(102697);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paraman != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(x.AE(paraman.field_username));
      com.tencent.mm.kernel.g.ajR().ajA().a(this);
      this.contact = paraman;
      this.screen = paramf;
      ceD();
      AppMethodBeat.o(102697);
      return true;
    }
  }
  
  public final boolean abx(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102696);
    ae.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bu.nullAsNil(paramString).length() <= 0)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.readerapp.b.a.iUA.MM();
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_subscribe"))
    {
      localObject = new Intent(this.context, ReaderAppSubscribeUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_clear_data"))
    {
      com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131757631), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(102689);
          com.tencent.mm.plugin.readerapp.c.g.a(new g.a()
          {
            public final void dGR()
            {
              AppMethodBeat.i(102688);
              this.xCg.dismiss();
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
      paramString = (CheckBoxPreference)this.screen.aXe(paramString);
      boolean bool3 = c.dGS();
      if (!bool3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(15413, new Object[] { Integer.valueOf(7), "", "" });
        if (paramString != null) {
          if (bool3) {
            break label494;
          }
        }
      }
      label494:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramString.setChecked(bool1);
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        pM(bool1);
        AppMethodBeat.o(102696);
        return true;
        com.tencent.mm.plugin.report.service.g.yxI.f(15413, new Object[] { Integer.valueOf(6), "", "" });
        break;
      }
    }
    if (paramString.equals("contact_info_readerappnews_install"))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(15413, new Object[] { Integer.valueOf(5), "", "" });
      z(this.context, true);
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_uninstall"))
    {
      com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(102690);
          com.tencent.mm.plugin.report.service.g.yxI.f(15413, new Object[] { Integer.valueOf(4), "", "" });
          b.z(b.this.context, false);
          AppMethodBeat.o(102690);
        }
      }, null);
      AppMethodBeat.o(102696);
      return true;
    }
    ae.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(102696);
    return false;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(102700);
    com.tencent.mm.kernel.g.ajR().ajA().b(this);
    com.tencent.mm.plugin.readerapp.b.a.iUA.MM();
    AppMethodBeat.o(102700);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b
 * JD-Core Version:    0.7.0.1
 */