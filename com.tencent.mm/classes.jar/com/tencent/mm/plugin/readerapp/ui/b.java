package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.readerapp.c.c;
import com.tencent.mm.plugin.readerapp.c.g.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.dbw;
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
  private as contact;
  private Context context;
  private f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void C(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(102699);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      localObject = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      paramContext = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(102692);
          if (this.qNu) {
            b.sX(true);
          }
          int i = z.aUl();
          if (this.qNu)
          {
            i &= 0xFFF7FFFF;
            com.tencent.mm.kernel.g.aAh().azQ().set(34, Integer.valueOf(i));
            paramAnonymousMessage = new dbw();
            paramAnonymousMessage.KEc = 524288;
            if (!this.qNu) {
              break label173;
            }
          }
          label173:
          for (i = 0;; i = 1)
          {
            paramAnonymousMessage.MGK = i;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(39, paramAnonymousMessage));
            if (!this.qNu)
            {
              com.tencent.mm.plugin.readerapp.c.g.a(new g.a()
              {
                public final void eHF()
                {
                  AppMethodBeat.i(102691);
                  if (this.qDa != null) {
                    this.qDa.dismiss();
                  }
                  AppMethodBeat.o(102691);
                }
              });
              b.sX(false);
            }
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
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
          if (this.qDa != null)
          {
            this.qDa.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(102693);
        }
      }, 5000L);
      AppMethodBeat.o(102699);
      return;
    }
  }
  
  private void cCt()
  {
    AppMethodBeat.i(102698);
    boolean bool1 = isOpen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017192);
    Object localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758022));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).updateStatus(i);
      localObject = (CheckBoxPreference)this.screen.bmg("contact_info_readerappnews_recv_remind");
      boolean bool2 = c.eHG();
      Log.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = ".concat(String.valueOf(bool2)));
      if (localObject != null) {
        ((CheckBoxPreference)localObject).setChecked(bool2);
      }
      if (!bool1) {
        break;
      }
      this.screen.bmi("contact_info_readerappnews_install");
      AppMethodBeat.o(102698);
      return;
    }
    this.screen.bmi("contact_info_readerappnews_subscribe");
    this.screen.bmi("contact_info_readerappnews_view");
    this.screen.bmi("contact_info_readerappnews_clear_data");
    this.screen.bmi("contact_info_readerappnews_uninstall");
    this.screen.bmi("contact_info_readerappnews_recv_remind");
    AppMethodBeat.o(102698);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(102694);
    if ((z.aUl() & 0x80000) == 0)
    {
      AppMethodBeat.o(102694);
      return true;
    }
    AppMethodBeat.o(102694);
    return false;
  }
  
  static void sX(boolean paramBoolean)
  {
    AppMethodBeat.i(102695);
    int i = z.aUe();
    if (paramBoolean)
    {
      i &= 0xFFFFFBFF;
      com.tencent.mm.kernel.g.aAh().azQ().set(40, Integer.valueOf(i));
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (i = 2;; i = 1)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.h(26, i));
      AppMethodBeat.o(102695);
      return;
      i |= 0x400;
      break;
    }
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(102697);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Jj(paramas.field_username));
      com.tencent.mm.kernel.g.aAh().azQ().add(this);
      this.contact = paramas;
      this.screen = paramf;
      cCt();
      AppMethodBeat.o(102697);
      return true;
    }
  }
  
  public final boolean alD(String paramString)
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
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.readerapp.b.a.jRu.WZ();
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_subscribe"))
    {
      localObject = new Intent(this.context, ReaderAppSubscribeUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_clear_data"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757859), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(102689);
          com.tencent.mm.plugin.readerapp.c.g.a(new g.a()
          {
            public final void eHF()
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
    if (paramString.equals("contact_info_readerappnews_recv_remind"))
    {
      paramString = (CheckBoxPreference)this.screen.bmg(paramString);
      boolean bool3 = c.eHG();
      if (!bool3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(15413, new Object[] { Integer.valueOf(7), "", "" });
        if (paramString != null) {
          if (bool3) {
            break label487;
          }
        }
      }
      label487:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramString.setChecked(bool1);
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        sX(bool1);
        AppMethodBeat.o(102696);
        return true;
        com.tencent.mm.plugin.report.service.h.CyF.a(15413, new Object[] { Integer.valueOf(6), "", "" });
        break;
      }
    }
    if (paramString.equals("contact_info_readerappnews_install"))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(15413, new Object[] { Integer.valueOf(5), "", "" });
      C(this.context, true);
      AppMethodBeat.o(102696);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(102690);
          com.tencent.mm.plugin.report.service.h.CyF.a(15413, new Object[] { Integer.valueOf(4), "", "" });
          b.C(b.a(b.this), false);
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
  
  public final boolean cCs()
  {
    AppMethodBeat.i(102700);
    com.tencent.mm.kernel.g.aAh().azQ().remove(this);
    com.tencent.mm.plugin.readerapp.b.a.jRu.WZ();
    AppMethodBeat.o(102700);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(102701);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.g.aAh().azQ()) || (i <= 0))
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
    cCt();
    AppMethodBeat.o(102701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b
 * JD-Core Version:    0.7.0.1
 */