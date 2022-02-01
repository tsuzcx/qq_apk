package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.x;
import junit.framework.Assert;

public final class k
  implements a, MStorageEx.IOnStorageChange
{
  private static boolean isDeleteCancel = false;
  private au contact;
  private Context context;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public k(Context paramContext)
  {
    this.context = paramContext;
  }
  
  static void Aw(boolean paramBoolean)
  {
    AppMethodBeat.i(27179);
    int i = z.bAQ();
    if (paramBoolean)
    {
      i |= 0x4000;
      bh.bCz();
      c.ban().B(7, Integer.valueOf(i));
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (i = 1;; i = 2)
    {
      bh.bCz();
      c.bzz().d(new com.tencent.mm.ay.h(13, i));
      AppMethodBeat.o(27179);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
  
  public static void M(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27176);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      localObject = com.tencent.mm.ui.base.k.a(paramContext, (String)localObject, true, null);
      paramContext = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27166);
          if (this.xve) {
            k.Aw(true);
          }
          int i = z.bBf();
          if (this.xve) {
            i &= 0xFFFFFFEF;
          }
          for (;;)
          {
            bh.bCz();
            c.ban().B(34, Integer.valueOf(i));
            bh.bCz();
            c.bzz().d(new com.tencent.mm.ay.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.xve) {
              k.access$100(paramContext);
            }
            if (this.KNw != null) {
              this.KNw.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27166);
            return;
            i |= 0x10;
          }
        }
      };
      com.tencent.threadpool.h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27167);
          if (k.this != null)
          {
            k.this.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27167);
        }
      }, 1500L);
      AppMethodBeat.o(27176);
      return;
    }
  }
  
  private void dvr()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27175);
    boolean bool3 = isOpen();
    boolean bool4 = gBF();
    Object localObject = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bz(this.contact.field_username, this.contact.aSV(), this.context.getString(R.l.gBy));
    int i;
    boolean bool1;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.eh("contact_info_medianote_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label257;
      }
      bool1 = true;
      label103:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_medianote_view", bool1);
      if ((!bool3) || (z.bBG())) {
        break label282;
      }
      if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("BindQQSwitch"), 1) != 1) {
        break label262;
      }
      bool1 = true;
      label143:
      Log.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
    }
    for (;;)
    {
      localObject = this.screen;
      if (!bool1)
      {
        bool1 = true;
        label163:
        ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_medianote_sync_to_qqmail", bool1);
        localObject = this.screen;
        if (bool3) {
          break label272;
        }
        bool1 = true;
        label188:
        ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_medianote_clear_data", bool1);
        localObject = this.screen;
        if (bool3) {
          break label277;
        }
      }
      label257:
      label262:
      label272:
      label277:
      for (bool1 = bool2;; bool1 = false)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_medianote_uninstall", bool1);
        ((CheckBoxPreference)this.screen.bAi("contact_info_medianote_sync_to_qqmail")).setChecked(bool4);
        AppMethodBeat.o(27175);
        return;
        i = 0;
        break;
        bool1 = false;
        break label103;
        bool1 = false;
        break label143;
        bool1 = false;
        break label163;
        bool1 = false;
        break label188;
      }
      label282:
      bool1 = bool3;
    }
  }
  
  private static boolean gBF()
  {
    AppMethodBeat.i(27173);
    int i = z.bAQ();
    if (!z.bBG())
    {
      if ((i & 0x4000) != 0)
      {
        bh.bCz();
        c.ban().B(7, Integer.valueOf(i & 0xFFFFBFFF));
      }
      AppMethodBeat.o(27173);
      return false;
    }
    if ((i & 0x4000) != 0)
    {
      AppMethodBeat.o(27173);
      return true;
    }
    AppMethodBeat.o(27173);
    return false;
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(27172);
    if ((z.bBf() & 0x10) == 0)
    {
      AppMethodBeat.o(27172);
      return true;
    }
    AppMethodBeat.o(27172);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27174);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramau != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(au.bwf(paramau.field_username));
      bh.bCz();
      c.ban().add(this);
      this.contact = paramau;
      this.screen = paramf;
      paramf.aBe(R.o.haR);
      dvr();
      AppMethodBeat.o(27174);
      return true;
    }
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(27171);
    Log.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27171);
      return false;
    }
    if (paramString.equals("contact_info_medianote_view"))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", "medianote");
      b.pFn.d(paramString, this.context);
      b.pFo.aDx();
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_sync_to_qqmail"))
    {
      if (!z.bBG())
      {
        com.tencent.mm.ui.base.k.a(this.context, R.l.contact_info_medianote_sync_to_qqmail_alert_tip, R.l.gBx, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27163);
            b.pFn.g(new Intent(), k.a(k.this));
            AppMethodBeat.o(27163);
          }
        }, null);
        dvr();
      }
      for (;;)
      {
        AppMethodBeat.o(27171);
        return true;
        Aw(((CheckBoxPreference)this.screen.bAi(paramString)).isChecked());
      }
    }
    if (paramString.equals("contact_info_medianote_clear_data"))
    {
      com.tencent.mm.ui.base.k.b(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27164);
          k.access$100(k.a(k.this));
          AppMethodBeat.o(27164);
        }
      }, null);
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_install"))
    {
      M(this.context, true);
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_uninstall"))
    {
      com.tencent.mm.ui.base.k.b(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27165);
          k.M(k.a(k.this), false);
          AppMethodBeat.o(27165);
        }
      }, null);
      AppMethodBeat.o(27171);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27171);
    return false;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27177);
    bh.bCz();
    c.ban().remove(this);
    b.pFo.aDx();
    AppMethodBeat.o(27177);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27178);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.bCz();
    if ((paramMStorageEx != c.ban()) || (i <= 0))
    {
      Log.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(27178);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(27178);
      return;
    }
    dvr();
    AppMethodBeat.o(27178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */