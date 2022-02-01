package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class j
  implements a, n.b
{
  private static boolean isDeleteCancel = false;
  private af contact;
  private Context context;
  private f screen;
  
  public j(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bRv()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27175);
    boolean bool3 = isOpen();
    boolean bool4 = dcC();
    Object localObject = (HelperHeaderPreference)this.screen.aKk("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757726));
    int i;
    boolean bool1;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cE("contact_info_medianote_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label251;
      }
      bool1 = true;
      label102:
      ((f)localObject).cE("contact_info_medianote_view", bool1);
      if ((!bool3) || (u.arn())) {
        break label276;
      }
      if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("BindQQSwitch"), 1) != 1) {
        break label256;
      }
      bool1 = true;
      label142:
      ad.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
    }
    for (;;)
    {
      localObject = this.screen;
      if (!bool1)
      {
        bool1 = true;
        label161:
        ((f)localObject).cE("contact_info_medianote_sync_to_qqmail", bool1);
        localObject = this.screen;
        if (bool3) {
          break label266;
        }
        bool1 = true;
        label185:
        ((f)localObject).cE("contact_info_medianote_clear_data", bool1);
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
        ((f)localObject).cE("contact_info_medianote_uninstall", bool1);
        ((CheckBoxPreference)this.screen.aKk("contact_info_medianote_sync_to_qqmail")).lG = bool4;
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
  
  private static boolean dcC()
  {
    AppMethodBeat.i(27173);
    int i = u.aqK();
    if (!u.arn())
    {
      if ((i & 0x4000) != 0)
      {
        az.arV();
        c.afk().set(7, Integer.valueOf(i & 0xFFFFBFFF));
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
    if ((u.aqS() & 0x10) == 0)
    {
      AppMethodBeat.o(27172);
      return true;
    }
    AppMethodBeat.o(27172);
    return false;
  }
  
  static void nZ(boolean paramBoolean)
  {
    AppMethodBeat.i(27179);
    int i = u.aqK();
    if (paramBoolean)
    {
      i |= 0x4000;
      az.arV();
      c.afk().set(7, Integer.valueOf(i));
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (i = 1;; i = 2)
    {
      az.arV();
      c.apL().c(new com.tencent.mm.bb.g(13, i));
      AppMethodBeat.o(27179);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
  
  public static void w(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27176);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      localObject = h.b(paramContext, (String)localObject, true, null);
      paramContext = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27166);
          if (this.okp) {
            j.nZ(true);
          }
          int i = u.aqS();
          if (this.okp) {
            i &= 0xFFFFFFEF;
          }
          for (;;)
          {
            az.arV();
            c.afk().set(34, Integer.valueOf(i));
            az.arV();
            c.apL().c(new com.tencent.mm.bb.k("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.okp) {
              j.fG(paramContext);
            }
            if (this.tvY != null) {
              this.tvY.a(null, null);
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
          if (this.tvZ != null)
          {
            this.tvZ.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27167);
        }
      }, 1500L);
      AppMethodBeat.o(27176);
      return;
    }
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(27171);
    ad.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27171);
      return false;
    }
    if (paramString.equals("contact_info_medianote_view"))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", "medianote");
      b.hYt.d(paramString, this.context);
      b.hYu.Ll();
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_sync_to_qqmail"))
    {
      if (!u.arn())
      {
        h.a(this.context, 2131757725, 2131757724, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27163);
            b.hYt.g(new Intent(), j.a(j.this));
            AppMethodBeat.o(27163);
          }
        }, null);
        bRv();
      }
      for (;;)
      {
        AppMethodBeat.o(27171);
        return true;
        nZ(((CheckBoxPreference)this.screen.aKk(paramString)).isChecked());
      }
    }
    if (paramString.equals("contact_info_medianote_clear_data"))
    {
      h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27164);
          j.fG(j.a(j.this));
          AppMethodBeat.o(27164);
        }
      }, null);
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_install"))
    {
      w(this.context, true);
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_uninstall"))
    {
      h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27165);
          j.w(j.a(j.this), false);
          AppMethodBeat.o(27165);
        }
      }, null);
      AppMethodBeat.o(27171);
      return true;
    }
    ad.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27171);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27178);
    int i = bt.i(paramObject, 0);
    ad.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.arV();
    if ((paramn != c.afk()) || (i <= 0))
    {
      ad.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(27178);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(27178);
      return;
    }
    bRv();
    AppMethodBeat.o(27178);
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27174);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramaf != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.sT(paramaf.field_username));
      az.arV();
      c.afk().a(this);
      this.contact = paramaf;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951646);
      bRv();
      AppMethodBeat.o(27174);
      return true;
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27177);
    az.arV();
    c.afk().b(this);
    b.hYu.Ll();
    AppMethodBeat.o(27177);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j
 * JD-Core Version:    0.7.0.1
 */