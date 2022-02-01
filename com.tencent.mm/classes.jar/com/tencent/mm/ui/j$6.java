package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

final class j$6
  implements Runnable
{
  j$6(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(33149);
    Object localObject1 = MMApplicationContext.getDefaultPreference();
    long l1 = ((SharedPreferences)localObject1).getLong("show_sdcard_full_time", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 - l1 > 10800000L) || (l1 > l2)) {}
    Object localObject2;
    int i;
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = this.VVy;
      i = a.aAi();
      bool2 = e.avB();
      Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space _dataRet[%d] checkSdIsFull[%b] needShowAlert[%b] testCode[%d] ", new Object[] { Integer.valueOf(localObject2.hashCode()), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(((j)localObject2).fxA) });
      if (((j)localObject2).fxA != 1) {
        break;
      }
      i = 1;
      bool1 = true;
      ((j)localObject2).fxA = 4;
      if (!bool2) {
        break label585;
      }
      if (!bool1) {
        break label777;
      }
      com.tencent.mm.ui.base.h.c(((j)localObject2).zwS, ((j)localObject2).getString(R.l.sdcard_full), ((j)localObject2).getString(R.l.sdcard_full_title), ((j)localObject2).getString(R.l.app_clear_mm), ((j)localObject2).getString(R.l.app_ignore), new j.4((j)localObject2), null);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(282L, 0L, 1L, false);
      bool1 = true;
      label214:
      Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space isShowAlert[%b]", new Object[] { Integer.valueOf(localObject2.hashCode()), Boolean.valueOf(bool1) });
      label244:
      if (bool1) {
        ((SharedPreferences)localObject1).edit().putLong("show_sdcard_full_time", l2).commit();
      }
      if (!bool1)
      {
        bh.beI();
        bool1 = ((Boolean)c.aHp().get(ar.a.ViL, Boolean.FALSE)).booleanValue();
        if (bool1)
        {
          bh.beI();
          localObject1 = (String)c.aHp().b(6, "");
          if (!Util.isNullOrNil((String)localObject1)) {
            break label847;
          }
          bh.beI();
          bool2 = ((Boolean)c.aHp().get(ar.a.ViM, Boolean.FALSE)).booleanValue();
          bh.beI();
          localObject2 = (String)c.aHp().get(ar.a.ViN, this.VVy.getString(R.l.bind_mcontact_security_bander_hint));
          Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", new Object[] { Boolean.valueOf(bool1), localObject1, Boolean.valueOf(bool2), localObject2 });
          if (!bool2) {
            break label783;
          }
          com.tencent.mm.ui.base.h.a(this.VVy.zwS, (String)localObject2, this.VVy.getString(R.l.app_tip), this.VVy.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33146);
              Intent localIntent = new Intent();
              localIntent.setClass(j.6.this.VVy.zwS, BindMobileUI.class);
              localIntent.putExtra("kstyle_bind_wording", new BindWordingContent(this.oET, ""));
              MMWizardActivity.aH(j.6.this.VVy.zwS, localIntent);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33146);
            }
          });
          label470:
          bh.beI();
          c.aHp().set(ar.a.ViL, Boolean.FALSE);
          bh.beI();
          c.aHp().set(ar.a.ViN, "");
          bh.beI();
          c.aHp().hxT();
        }
      }
      AppMethodBeat.o(33149);
      return;
    }
    if (((j)localObject2).fxA == 2)
    {
      bool1 = true;
      i = 2;
    }
    for (;;)
    {
      ((j)localObject2).fxA = 0;
      break;
      if (((j)localObject2).fxA == 3)
      {
        bool2 = true;
        bool1 = true;
      }
      else if (((j)localObject2).fxA == 4)
      {
        ((j)localObject2).fxA = 0;
        bool1 = false;
        break label244;
        label585:
        if (i == 2)
        {
          if (!bool1) {
            break label777;
          }
          bool1 = true;
          bh.aGF();
          d.a locala = new d.a(((j)localObject2).zwS);
          locala.ayc(R.l.check_db_size_tip_dangerous_title);
          locala.bBd(((j)localObject2).zwS.getString(R.l.check_db_size_tip_dangerous_message));
          locala.HG(false);
          locala.ayj(R.l.check_db_size_btn_dangerous_message).c(new j.5((j)localObject2));
          locala.icu().show();
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(282L, 2L, 1L, false);
          break label214;
        }
        Log.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d cancel no space notification isShowLackSpaceNotification[%b] hadCheckNotification[%b]", new Object[] { Integer.valueOf(localObject2.hashCode()), Boolean.valueOf(((j)localObject2).VVu), Boolean.valueOf(((j)localObject2).VVv) });
        if ((!((j)localObject2).VVv) || (((j)localObject2).VVu))
        {
          bh.getNotification().cancel(45);
          ((j)localObject2).VVu = false;
        }
        ((j)localObject2).VVv = true;
        label777:
        bool1 = false;
        break label214;
        label783:
        com.tencent.mm.ui.base.h.c(this.VVy.zwS, (String)localObject2, this.VVy.getString(R.l.app_tip), this.VVy.getString(R.l.app_ok), this.VVy.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33147);
            Intent localIntent = new Intent();
            localIntent.setClass(j.6.this.VVy.zwS, BindMobileUI.class);
            localIntent.putExtra("kstyle_bind_wording", new BindWordingContent(this.oET, ""));
            MMWizardActivity.aH(j.6.this.VVy.zwS, localIntent);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(33147);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33148);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(33148);
          }
        });
        break label470;
        label847:
        Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", new Object[] { localObject1 });
        break label470;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(33150);
    String str = super.toString() + "|doOnResumeCheck";
    AppMethodBeat.o(33150);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.j.6
 * JD-Core Version:    0.7.0.1
 */