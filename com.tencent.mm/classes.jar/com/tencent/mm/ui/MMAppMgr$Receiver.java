package com.tencent.mm.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import com.jg.JgClassChecked;
import com.tencent.mm.booter.o;
import com.tencent.mm.model.au;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MMAppMgr$Receiver
  extends BroadcastReceiver
{
  private MMAppMgr appMgr;
  
  public MMAppMgr$Receiver() {}
  
  public MMAppMgr$Receiver(MMAppMgr paramMMAppMgr)
  {
    this.appMgr = paramMMAppMgr;
  }
  
  private static boolean ap(Intent paramIntent)
  {
    if (!paramIntent.getBooleanExtra("process_is_mm", false)) {}
    while (paramIntent.getIntExtra("process_id", 0) == Process.myPid()) {
      return true;
    }
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if ((!au.Hp()) && (!au.Hr()))
      {
        String str = paramIntent.getAction();
        if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(str))
        {
          if (!ap(paramIntent))
          {
            y.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
            return;
          }
          MMAppMgr.a(this.appMgr, paramIntent, true);
          this.appMgr.c(paramIntent, true);
          return;
        }
        if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(str))
        {
          if (!ap(paramIntent))
          {
            y.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
            return;
          }
          o.wn();
          MMAppMgr.a(this.appMgr, paramIntent, false);
          this.appMgr.c(paramIntent, false);
          if ((MMAppMgr.uNI == null) || (MMAppMgr.uNI.length() <= 800)) {
            break;
          }
          new ah(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run() {}
          });
          return;
        }
        if (!"com.tencent.mm.ui.ACTION_ABTEST".equals(str)) {
          break label323;
        }
        paramContext = paramIntent.getStringExtra("content");
        if (bk.bl(paramContext)) {
          y.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
        }
        while ((MMAppMgr.uNI != null) && (MMAppMgr.uNI.length() > 800))
        {
          new ah(Looper.getMainLooper()).post(new MMAppMgr.Receiver.2(this));
          return;
          if (MMAppMgr.uNI == null) {
            MMAppMgr.uNI = new StringBuffer(800);
          }
          MMAppMgr.uNI.append(paramContext);
          y.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[] { paramContext });
        }
      }
    }
    label323:
    if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE"))
    {
      int i;
      if (!paramIntent.getBooleanExtra("intent_extra_is_silence_stat", false))
      {
        i = paramIntent.getIntExtra("intent_extra_opcode", 0);
        y.d("MicroMsg.MMAppMgr", "incremental_update = " + i);
        if (au.DK()) {
          h.nFQ.f(10328, new Object[] { Integer.valueOf(i) });
        }
      }
      long l1;
      long l2;
      label623:
      for (;;)
      {
        l1 = paramIntent.getLongExtra("intent_extra_flow_stat_upstream", 0L);
        l2 = paramIntent.getLongExtra("intent_extra_flow_stat_downstream", 0L);
        boolean bool = paramIntent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
        if ((!au.DK()) || ((l1 == 0L) && (l2 == 0L))) {
          break;
        }
        y.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
        if (!bool) {
          break label625;
        }
        n.w((int)l2, (int)l1, 0);
        return;
        i = paramIntent.getIntExtra("intent_extra_opcode", 0);
        y.d("MicroMsg.MMAppMgr", "silence_update_stat = " + i);
        if (au.DK())
        {
          if (i == 2)
          {
            int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
            h.nFQ.f(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          for (;;)
          {
            if ((i != 4) || (i.clj() != 4)) {
              break label623;
            }
            paramContext = com.tencent.mm.pluginsdk.model.app.a.ckJ();
            if (paramContext == null) {
              break;
            }
            paramContext.ckL();
            break;
            h.nFQ.f(11147, new Object[] { Integer.valueOf(i) });
          }
        }
      }
      label625:
      n.x((int)l2, (int)l1, 0);
      return;
    }
    if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP"))
    {
      MMAppMgr.i(paramContext, true);
      return;
    }
    if (paramIntent.getAction().equals("MINIQB_OPEN_RET"))
    {
      com.tencent.mm.pluginsdk.ui.tools.a.ai(paramIntent);
      return;
    }
    y.e("MicroMsg.MMAppMgr", "unknown broadcast action");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.Receiver
 * JD-Core Version:    0.7.0.1
 */