package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class j
  implements a, n.b
{
  private static boolean isDeleteCancel = false;
  private am contact;
  private Context context;
  private f screen;
  
  public j(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cdo()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27175);
    boolean bool3 = isOpen();
    boolean bool4 = dAN();
    Object localObject = (HelperHeaderPreference)this.screen.aVD("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aZ(this.contact.field_username, this.contact.adv(), this.context.getString(2131757726));
    int i;
    boolean bool1;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cP("contact_info_medianote_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label251;
      }
      bool1 = true;
      label102:
      ((f)localObject).cP("contact_info_medianote_view", bool1);
      if ((!bool3) || (u.aAZ())) {
        break label276;
      }
      if (bt.getInt(g.acA().getValue("BindQQSwitch"), 1) != 1) {
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
        ((f)localObject).cP("contact_info_medianote_sync_to_qqmail", bool1);
        localObject = this.screen;
        if (bool3) {
          break label266;
        }
        bool1 = true;
        label185:
        ((f)localObject).cP("contact_info_medianote_clear_data", bool1);
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
        ((f)localObject).cP("contact_info_medianote_uninstall", bool1);
        ((CheckBoxPreference)this.screen.aVD("contact_info_medianote_sync_to_qqmail")).oB = bool4;
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
  
  private static boolean dAN()
  {
    AppMethodBeat.i(27173);
    int i = u.aAq();
    if (!u.aAZ())
    {
      if ((i & 0x4000) != 0)
      {
        ba.aBQ();
        c.ajl().set(7, Integer.valueOf(i & 0xFFFFBFFF));
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
    if ((u.aAy() & 0x10) == 0)
    {
      AppMethodBeat.o(27172);
      return true;
    }
    AppMethodBeat.o(27172);
    return false;
  }
  
  static void ps(boolean paramBoolean)
  {
    AppMethodBeat.i(27179);
    int i = u.aAq();
    if (paramBoolean)
    {
      i |= 0x4000;
      ba.aBQ();
      c.ajl().set(7, Integer.valueOf(i));
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (i = 1;; i = 2)
    {
      ba.aBQ();
      c.azo().c(new com.tencent.mm.bb.h(13, i));
      AppMethodBeat.o(27179);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
  
  public static void z(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27176);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      paramContext = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27166);
          if (this.prx) {
            j.ps(true);
          }
          int i = u.aAy();
          if (this.prx) {
            i &= 0xFFFFFFEF;
          }
          for (;;)
          {
            ba.aBQ();
            c.ajl().set(34, Integer.valueOf(i));
            ba.aBQ();
            c.azo().c(new com.tencent.mm.bb.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.prx) {
              j.access$100(paramContext);
            }
            if (this.vHr != null) {
              this.vHr.a(null, null);
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
          if (this.pgW != null)
          {
            this.pgW.dismiss();
            paramContext.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27167);
        }
      }, 1500L);
      AppMethodBeat.o(27176);
      return;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27178);
    int i = bt.m(paramObject, 0);
    ad.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    ba.aBQ();
    if ((paramn != c.ajl()) || (i <= 0))
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
    cdo();
    AppMethodBeat.o(27178);
  }
  
  public final boolean a(f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27174);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramam != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.zT(paramam.field_username));
      ba.aBQ();
      c.ajl().a(this);
      this.contact = paramam;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951646);
      cdo();
      AppMethodBeat.o(27174);
      return true;
    }
  }
  
  public final boolean aaG(String paramString)
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
      b.iRG.d(paramString, this.context);
      b.iRH.MR();
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_sync_to_qqmail"))
    {
      if (!u.aAZ())
      {
        com.tencent.mm.ui.base.h.a(this.context, 2131757725, 2131757724, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27163);
            b.iRG.g(new Intent(), j.a(j.this));
            AppMethodBeat.o(27163);
          }
        }, null);
        cdo();
      }
      for (;;)
      {
        AppMethodBeat.o(27171);
        return true;
        ps(((CheckBoxPreference)this.screen.aVD(paramString)).isChecked());
      }
    }
    if (paramString.equals("contact_info_medianote_clear_data"))
    {
      com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
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
      z(this.context, true);
      AppMethodBeat.o(27171);
      return true;
    }
    if (paramString.equals("contact_info_medianote_uninstall"))
    {
      com.tencent.mm.ui.base.h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27165);
          j.z(j.a(j.this), false);
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
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27177);
    ba.aBQ();
    c.ajl().b(this);
    b.iRH.MR();
    AppMethodBeat.o(27177);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j
 * JD-Core Version:    0.7.0.1
 */