package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class j
  implements a, MStorageEx.IOnStorageChange
{
  private static boolean isDeleteCancel = false;
  private as contact;
  private Context context;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public j(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void C(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27176);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      localObject = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      paramContext = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27166);
          if (this.qNu) {
            j.sI(true);
          }
          int i = z.aUl();
          if (this.qNu) {
            i &= 0xFFFFFFEF;
          }
          for (;;)
          {
            bg.aVF();
            c.azQ().set(34, Integer.valueOf(i));
            bg.aVF();
            c.aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.qNu) {
              j.access$100(paramContext);
            }
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27166);
            return;
            i |= 0x10;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(27167);
          if (this.qDi != null)
          {
            this.qDi.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27167);
        }
      }, 1500L);
      AppMethodBeat.o(27176);
      return;
    }
  }
  
  private void cCt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27175);
    boolean bool3 = isOpen();
    boolean bool4 = eEx();
    Object localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131757957));
    int i;
    boolean bool1;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.jdMethod_do("contact_info_medianote_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label251;
      }
      bool1 = true;
      label102:
      ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("contact_info_medianote_view", bool1);
      if ((!bool3) || (z.aUM())) {
        break label276;
      }
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("BindQQSwitch"), 1) != 1) {
        break label256;
      }
      bool1 = true;
      label142:
      Log.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
    }
    for (;;)
    {
      localObject = this.screen;
      if (!bool1)
      {
        bool1 = true;
        label161:
        ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("contact_info_medianote_sync_to_qqmail", bool1);
        localObject = this.screen;
        if (bool3) {
          break label266;
        }
        bool1 = true;
        label185:
        ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("contact_info_medianote_clear_data", bool1);
        localObject = this.screen;
        if (bool3) {
          break label271;
        }
      }
      label256:
      label266:
      label271:
      for (bool1 = bool2;; bool1 = false)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("contact_info_medianote_uninstall", bool1);
        ((CheckBoxPreference)this.screen.bmg("contact_info_medianote_sync_to_qqmail")).setChecked(bool4);
        AppMethodBeat.o(27175);
        return;
        i = 0;
        break;
        label251:
        bool1 = false;
        break label102;
        bool1 = false;
        break label142;
        bool1 = false;
        break label161;
        bool1 = false;
        break label185;
      }
      label276:
      bool1 = bool3;
    }
  }
  
  private static boolean eEx()
  {
    AppMethodBeat.i(27173);
    int i = z.aUc();
    if (!z.aUM())
    {
      if ((i & 0x4000) != 0)
      {
        bg.aVF();
        c.azQ().set(7, Integer.valueOf(i & 0xFFFFBFFF));
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
    if ((z.aUl() & 0x10) == 0)
    {
      AppMethodBeat.o(27172);
      return true;
    }
    AppMethodBeat.o(27172);
    return false;
  }
  
  static void sI(boolean paramBoolean)
  {
    AppMethodBeat.i(27179);
    int i = z.aUc();
    if (paramBoolean)
    {
      i |= 0x4000;
      bg.aVF();
      c.azQ().set(7, Integer.valueOf(i));
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (i = 1;; i = 2)
    {
      bg.aVF();
      c.aSM().d(new com.tencent.mm.ba.h(13, i));
      AppMethodBeat.o(27179);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27174);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Ji(paramas.field_username));
      bg.aVF();
      c.azQ().add(this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2132017183);
      cCt();
      AppMethodBeat.o(27174);
      return true;
    }
  }
  
  public final boolean alD(String paramString)
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
      b.jRt.d(paramString, this.context);
      b.jRu.WZ();
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_sync_to_qqmail"))
    {
      if (!z.aUM())
      {
        com.tencent.mm.ui.base.h.a(this.context, 2131757956, 2131757955, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27163);
            b.jRt.g(new Intent(), j.a(j.this));
            AppMethodBeat.o(27163);
          }
        }, null);
        cCt();
      }
      for (;;)
      {
        AppMethodBeat.o(27171);
        return true;
        sI(((CheckBoxPreference)this.screen.bmg(paramString)).isChecked());
      }
    }
    if (paramString.equals("contact_info_medianote_clear_data"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27164);
          j.access$100(j.a(j.this));
          AppMethodBeat.o(27164);
        }
      }, null);
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_install"))
    {
      C(this.context, true);
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27165);
          j.C(j.a(j.this), false);
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
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27177);
    bg.aVF();
    c.azQ().remove(this);
    b.jRu.WZ();
    AppMethodBeat.o(27177);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27178);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bg.aVF();
    if ((paramMStorageEx != c.azQ()) || (i <= 0))
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
    cCt();
    AppMethodBeat.o(27178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j
 * JD-Core Version:    0.7.0.1
 */