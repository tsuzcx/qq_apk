package com.tencent.mm.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.b.c.a;

final class h$6
  implements Runnable
{
  h$6(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(29316);
    Object localObject1 = com.tencent.mm.sdk.platformtools.ah.dsQ();
    long l1 = ((SharedPreferences)localObject1).getLong("show_sdcard_full_time", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 - l1 > 10800000L) || (l1 > l2)) {}
    Object localObject2;
    int i;
    boolean bool2;
    Object localObject3;
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = this.yXo;
      i = com.tencent.mm.q.a.Oj();
      bool2 = f.Mj();
      ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space _dataRet[%d] checkSdIsFull[%b] needShowAlert[%b] testCode[%d] ", new Object[] { Integer.valueOf(localObject2.hashCode()), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(((h)localObject2).coH) });
      if (((h)localObject2).coH != 1) {
        break;
      }
      i = 1;
      bool1 = true;
      ((h)localObject2).coH = 4;
      if (i != 1) {
        break label800;
      }
      if (!bool1) {
        break label1155;
      }
      bool1 = true;
      localObject3 = new c.a(((h)localObject2).yXg);
      ((c.a)localObject3).Rb(2131298351);
      ((c.a)localObject3).avn(((h)localObject2).yXg.getString(2131298350));
      ((c.a)localObject3).rG(false);
      ((c.a)localObject3).Ri(2131298347).a(new h.3((h)localObject2));
      ((c.a)localObject3).aLZ().show();
      ab.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d show no space notification isShowLackSpaceNotification[%b]", new Object[] { Integer.valueOf(localObject2.hashCode()), Boolean.valueOf(((h)localObject2).yXk) });
      if (!((h)localObject2).yXk)
      {
        aw.getNotification().cancel(45);
        ((h)localObject2).yXk = true;
        localObject3 = new Intent(com.tencent.mm.sdk.platformtools.ah.getContext(), LauncherUI.class);
        localObject3 = PendingIntent.getActivity(com.tencent.mm.sdk.platformtools.ah.getContext(), 45, (Intent)localObject3, 134217728);
        s.c localc = com.tencent.mm.bp.a.br(com.tencent.mm.sdk.platformtools.ah.getContext(), "reminder_channel_id").h(((h)localObject2).getString(2131298351)).e(((h)localObject2).getString(2131298351)).f(((h)localObject2).getString(2131298350)).z(false);
        localc.ya = ((PendingIntent)localObject3);
        localc.g(2, true);
        localObject3 = localc.build();
        ((Notification)localObject3).icon = com.tencent.mm.bp.a.bYt();
        ((Notification)localObject3).flags |= 0x20;
        aw.getNotification().a(45, (Notification)localObject3, false);
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 20L, 1L, false);
      label423:
      ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space isShowAlert[%b]", new Object[] { Integer.valueOf(localObject2.hashCode()), Boolean.valueOf(bool1) });
      label453:
      if (bool1) {
        ((SharedPreferences)localObject1).edit().putLong("show_sdcard_full_time", l2).commit();
      }
      if (!bool1)
      {
        aw.aaz();
        bool1 = ((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yzL, Boolean.FALSE)).booleanValue();
        if (bool1)
        {
          aw.aaz();
          localObject1 = (String)com.tencent.mm.model.c.Ru().get(6, "");
          if (!com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject1)) {
            break label1135;
          }
          aw.aaz();
          bool2 = ((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yzM, Boolean.FALSE)).booleanValue();
          aw.aaz();
          localObject2 = (String)com.tencent.mm.model.c.Ru().get(ac.a.yzN, this.yXo.getString(2131297588));
          ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", new Object[] { Boolean.valueOf(bool1), localObject1, Boolean.valueOf(bool2), localObject2 });
          if (!bool2) {
            break label1071;
          }
          com.tencent.mm.ui.base.h.a(this.yXo.yXg, (String)localObject2, this.yXo.getString(2131297087), this.yXo.getString(2131297018), false, new h.6.1(this, (String)localObject2));
          label681:
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yzL, Boolean.FALSE);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yzN, "");
          aw.aaz();
          com.tencent.mm.model.c.Ru().dww();
        }
      }
      AppMethodBeat.o(29316);
      return;
    }
    if (((h)localObject2).coH == 2)
    {
      bool1 = true;
      i = 2;
    }
    for (;;)
    {
      ((h)localObject2).coH = 0;
      break;
      if (((h)localObject2).coH == 3)
      {
        i = 0;
        bool2 = true;
        bool1 = true;
      }
      else if (((h)localObject2).coH == 4)
      {
        ((h)localObject2).coH = 0;
        bool1 = false;
        break label453;
        label800:
        if (i == 2)
        {
          if (!bool1) {
            break label1155;
          }
          bool1 = true;
          aw.hold();
          localObject3 = new c.a(((h)localObject2).yXg);
          ((c.a)localObject3).Rb(2131298349);
          ((c.a)localObject3).avn(((h)localObject2).yXg.getString(2131298348));
          ((c.a)localObject3).rG(false);
          ((c.a)localObject3).Ri(2131298346).a(new h.4((h)localObject2));
          ((c.a)localObject3).aLZ().show();
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 2L, 1L, false);
          break label423;
        }
        ab.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d cancel no space notification isShowLackSpaceNotification[%b] hadCheckNotification[%b]", new Object[] { Integer.valueOf(localObject2.hashCode()), Boolean.valueOf(((h)localObject2).yXk), Boolean.valueOf(((h)localObject2).yXl) });
        if ((!((h)localObject2).yXl) || (((h)localObject2).yXk))
        {
          aw.getNotification().cancel(45);
          ((h)localObject2).yXk = false;
        }
        ((h)localObject2).yXl = true;
        if ((bool2) && (bool1))
        {
          com.tencent.mm.ui.base.h.d(((h)localObject2).yXg, ((h)localObject2).getString(2131302957), ((h)localObject2).getString(2131302958), ((h)localObject2).getString(2131296892), ((h)localObject2).getString(2131296979), new h.5((h)localObject2), null);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 0L, 1L, false);
          bool1 = true;
          break label423;
          label1071:
          com.tencent.mm.ui.base.h.d(this.yXo.yXg, (String)localObject2, this.yXo.getString(2131297087), this.yXo.getString(2131297018), this.yXo.getString(2131296888), new h.6.2(this, (String)localObject2), new h.6.3(this));
          break label681;
          label1135:
          ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", new Object[] { localObject1 });
          break label681;
        }
        label1155:
        bool1 = false;
        break label423;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29317);
    String str = super.toString() + "|doOnResumeCheck";
    AppMethodBeat.o(29317);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.h.6
 * JD-Core Version:    0.7.0.1
 */