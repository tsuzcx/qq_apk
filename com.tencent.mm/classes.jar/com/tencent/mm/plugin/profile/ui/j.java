package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.c.a;
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
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.v;
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
  
  public static void F(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27176);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      localObject = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      paramContext = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27166);
          if (this.uoH) {
            j.vZ(true);
          }
          int i = z.bdn();
          if (this.uoH) {
            i &= 0xFFFFFFEF;
          }
          for (;;)
          {
            bh.beI();
            c.aHp().i(34, Integer.valueOf(i));
            bh.beI();
            c.bbK().d(new com.tencent.mm.bd.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.uoH) {
              j.access$100(paramContext);
            }
            if (this.ESS != null) {
              this.ESS.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27166);
            return;
            i |= 0x10;
          }
        }
      };
      com.tencent.e.h.ZvG.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27167);
          if (this.ucj != null)
          {
            this.ucj.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27167);
        }
      }, 1500L);
      AppMethodBeat.o(27176);
      return;
    }
  }
  
  private void cQY()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27175);
    boolean bool3 = isOpen();
    boolean bool4 = fqp();
    Object localObject = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bf(this.contact.field_username, this.contact.ays(), this.context.getString(R.l.eyG));
    int i;
    boolean bool1;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.dz("contact_info_medianote_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label252;
      }
      bool1 = true;
      label103:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_medianote_view", bool1);
      if ((!bool3) || (z.bdO())) {
        break label277;
      }
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("BindQQSwitch"), 1) != 1) {
        break label257;
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
        label162:
        ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_medianote_sync_to_qqmail", bool1);
        localObject = this.screen;
        if (bool3) {
          break label267;
        }
        bool1 = true;
        label186:
        ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_medianote_clear_data", bool1);
        localObject = this.screen;
        if (bool3) {
          break label272;
        }
      }
      label257:
      label267:
      label272:
      for (bool1 = bool2;; bool1 = false)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_medianote_uninstall", bool1);
        ((CheckBoxPreference)this.screen.byG("contact_info_medianote_sync_to_qqmail")).setChecked(bool4);
        AppMethodBeat.o(27175);
        return;
        i = 0;
        break;
        label252:
        bool1 = false;
        break label103;
        bool1 = false;
        break label143;
        bool1 = false;
        break label162;
        bool1 = false;
        break label186;
      }
      label277:
      bool1 = bool3;
    }
  }
  
  private static boolean fqp()
  {
    AppMethodBeat.i(27173);
    int i = z.bdd();
    if (!z.bdO())
    {
      if ((i & 0x4000) != 0)
      {
        bh.beI();
        c.aHp().i(7, Integer.valueOf(i & 0xFFFFBFFF));
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
    if ((z.bdn() & 0x10) == 0)
    {
      AppMethodBeat.o(27172);
      return true;
    }
    AppMethodBeat.o(27172);
    return false;
  }
  
  static void vZ(boolean paramBoolean)
  {
    AppMethodBeat.i(27179);
    int i = z.bdd();
    if (paramBoolean)
    {
      i |= 0x4000;
      bh.beI();
      c.aHp().i(7, Integer.valueOf(i));
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (i = 1;; i = 2)
    {
      bh.beI();
      c.bbK().d(new com.tencent.mm.bd.h(13, i));
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
      Assert.assertTrue(ab.QB(paramas.field_username));
      bh.beI();
      c.aHp().add(this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.auC(R.o.eXp);
      cQY();
      AppMethodBeat.o(27174);
      return true;
    }
  }
  
  public final boolean atw(String paramString)
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
      b.mIG.d(paramString, this.context);
      b.mIH.abC();
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_sync_to_qqmail"))
    {
      if (!z.bdO())
      {
        com.tencent.mm.ui.base.h.a(this.context, R.l.contact_info_medianote_sync_to_qqmail_alert_tip, R.l.eyF, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27163);
            b.mIG.g(new Intent(), j.a(j.this));
            AppMethodBeat.o(27163);
          }
        }, null);
        cQY();
      }
      for (;;)
      {
        AppMethodBeat.o(27171);
        return true;
        vZ(((CheckBoxPreference)this.screen.byG(paramString)).isChecked());
      }
    }
    if (paramString.equals("contact_info_medianote_clear_data"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
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
      F(this.context, true);
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27165);
          j.F(j.a(j.this), false);
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
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27177);
    bh.beI();
    c.aHp().remove(this);
    b.mIH.abC();
    AppMethodBeat.o(27177);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27178);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.beI();
    if ((paramMStorageEx != c.aHp()) || (i <= 0))
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
    cQY();
    AppMethodBeat.o(27178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j
 * JD-Core Version:    0.7.0.1
 */