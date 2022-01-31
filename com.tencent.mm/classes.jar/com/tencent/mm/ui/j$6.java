package com.tencent.mm.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.a.c.a;

final class j$6
  implements Runnable
{
  j$6(j paramj) {}
  
  public final void run()
  {
    Object localObject1 = ae.cqS();
    long l1 = ((SharedPreferences)localObject1).getLong("show_sdcard_full_time", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 - l1 > 10800000L) || (l1 > l2)) {}
    Object localObject2;
    int i;
    boolean bool2;
    Object localObject3;
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = this.uJI;
      i = com.tencent.mm.q.a.Bu();
      bool2 = f.zG();
      y.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space _dataRet[%d] checkSdIsFull[%b] needShowAlert[%b] testCode[%d] ", new Object[] { Integer.valueOf(localObject2.hashCode()), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(((j)localObject2).bHt) });
      if (((j)localObject2).bHt != 1) {
        break;
      }
      i = 1;
      bool1 = true;
      ((j)localObject2).bHt = 4;
      if (i != 1) {
        break label791;
      }
      if (!bool1) {
        break label1146;
      }
      bool1 = true;
      localObject3 = new c.a(((j)localObject2).uJA);
      ((c.a)localObject3).Ip(R.l.check_db_size_tip_normal_title);
      ((c.a)localObject3).aeA(((j)localObject2).uJA.getString(R.l.check_db_size_tip_normal_message));
      ((c.a)localObject3).nW(false);
      ((c.a)localObject3).Is(R.l.check_db_size_btn_message).a(new j.3((j)localObject2));
      ((c.a)localObject3).aoP().show();
      y.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d show no space notification isShowLackSpaceNotification[%b]", new Object[] { Integer.valueOf(localObject2.hashCode()), Boolean.valueOf(((j)localObject2).uJE) });
      if (!((j)localObject2).uJE)
      {
        au.getNotification().cancel(45);
        ((j)localObject2).uJE = true;
        localObject3 = new Intent(ae.getContext(), LauncherUI.class);
        localObject3 = PendingIntent.getActivity(ae.getContext(), 45, (Intent)localObject3, 134217728);
        localObject3 = new Notification.Builder(ae.getContext()).setTicker(((j)localObject2).getString(R.l.check_db_size_tip_normal_title)).setContentTitle(((j)localObject2).getString(R.l.check_db_size_tip_normal_title)).setContentText(((j)localObject2).getString(R.l.check_db_size_tip_normal_message)).setAutoCancel(false).setContentIntent((PendingIntent)localObject3).setOngoing(true).build();
        ((Notification)localObject3).icon = com.tencent.mm.bq.a.bSL();
        ((Notification)localObject3).flags |= 0x20;
        au.getNotification().a(45, (Notification)localObject3, false);
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(282L, 20L, 1L, false);
      label416:
      y.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space isShowAlert[%b]", new Object[] { Integer.valueOf(localObject2.hashCode()), Boolean.valueOf(bool1) });
      label446:
      if (bool1) {
        ((SharedPreferences)localObject1).edit().putLong("show_sdcard_full_time", l2).commit();
      }
      if (!bool1)
      {
        au.Hx();
        bool1 = ((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.upL, Boolean.valueOf(false))).booleanValue();
        if (bool1)
        {
          au.Hx();
          localObject1 = (String)com.tencent.mm.model.c.Dz().get(6, "");
          if (!ah.bl((String)localObject1)) {
            break label1126;
          }
          au.Hx();
          bool2 = ((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.upM, Boolean.valueOf(false))).booleanValue();
          au.Hx();
          localObject2 = (String)com.tencent.mm.model.c.Dz().get(ac.a.upN, this.uJI.getString(R.l.bind_mcontact_security_bander_hint));
          y.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", new Object[] { Boolean.valueOf(bool1), localObject1, Boolean.valueOf(bool2), localObject2 });
          if (!bool2) {
            break label1062;
          }
          com.tencent.mm.ui.base.h.a(this.uJI.uJA, (String)localObject2, this.uJI.getString(R.l.app_tip), this.uJI.getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              Intent localIntent = new Intent();
              localIntent.setClass(j.6.this.uJI.uJA, BindMobileUI.class);
              localIntent.putExtra("kstyle_bind_wording", new BindWordingContent(this.gkP, ""));
              MMWizardActivity.C(j.6.this.uJI.uJA, localIntent);
              paramAnonymousDialogInterface.dismiss();
            }
          });
          label676:
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.upL, Boolean.valueOf(false));
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.upN, "");
          au.Hx();
          com.tencent.mm.model.c.Dz().mC(true);
        }
      }
      return;
    }
    if (((j)localObject2).bHt == 2)
    {
      bool1 = true;
      i = 2;
    }
    for (;;)
    {
      ((j)localObject2).bHt = 0;
      break;
      if (((j)localObject2).bHt == 3)
      {
        i = 0;
        bool2 = true;
        bool1 = true;
      }
      else if (((j)localObject2).bHt == 4)
      {
        ((j)localObject2).bHt = 0;
        bool1 = false;
        break label446;
        label791:
        if (i == 2)
        {
          if (!bool1) {
            break label1146;
          }
          bool1 = true;
          au.hold();
          localObject3 = new c.a(((j)localObject2).uJA);
          ((c.a)localObject3).Ip(R.l.check_db_size_tip_dangerous_title);
          ((c.a)localObject3).aeA(((j)localObject2).uJA.getString(R.l.check_db_size_tip_dangerous_message));
          ((c.a)localObject3).nW(false);
          ((c.a)localObject3).Is(R.l.check_db_size_btn_dangerous_message).a(new j.4((j)localObject2));
          ((c.a)localObject3).aoP().show();
          com.tencent.mm.plugin.report.service.h.nFQ.a(282L, 2L, 1L, false);
          break label416;
        }
        y.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d cancel no space notification isShowLackSpaceNotification[%b] hadCheckNotification[%b]", new Object[] { Integer.valueOf(localObject2.hashCode()), Boolean.valueOf(((j)localObject2).uJE), Boolean.valueOf(((j)localObject2).uJF) });
        if ((!((j)localObject2).uJF) || (((j)localObject2).uJE))
        {
          au.getNotification().cancel(45);
          ((j)localObject2).uJE = false;
        }
        ((j)localObject2).uJF = true;
        if ((bool2) && (bool1))
        {
          com.tencent.mm.ui.base.h.a(((j)localObject2).uJA, ((j)localObject2).getString(R.l.sdcard_full), ((j)localObject2).getString(R.l.sdcard_full_title), ((j)localObject2).getString(R.l.app_clear_mm), ((j)localObject2).getString(R.l.app_ignore), new j.5((j)localObject2), null);
          com.tencent.mm.plugin.report.service.h.nFQ.a(282L, 0L, 1L, false);
          bool1 = true;
          break label416;
          label1062:
          com.tencent.mm.ui.base.h.a(this.uJI.uJA, (String)localObject2, this.uJI.getString(R.l.app_tip), this.uJI.getString(R.l.app_ok), this.uJI.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              Intent localIntent = new Intent();
              localIntent.setClass(j.6.this.uJI.uJA, BindMobileUI.class);
              localIntent.putExtra("kstyle_bind_wording", new BindWordingContent(this.gkP, ""));
              MMWizardActivity.C(j.6.this.uJI.uJA, localIntent);
              paramAnonymousDialogInterface.dismiss();
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              paramAnonymousDialogInterface.dismiss();
            }
          });
          break label676;
          label1126:
          y.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", new Object[] { localObject1 });
          break label676;
        }
        label1146:
        bool1 = false;
        break label416;
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|doOnResumeCheck";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.j.6
 * JD-Core Version:    0.7.0.1
 */