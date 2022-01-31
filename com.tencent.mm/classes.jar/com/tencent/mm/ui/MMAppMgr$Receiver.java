package com.tencent.mm.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

@JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MMAppMgr$Receiver
  extends BroadcastReceiver
{
  private MMAppMgr appMgr;
  
  public MMAppMgr$Receiver(MMAppMgr paramMMAppMgr)
  {
    this.appMgr = paramMMAppMgr;
  }
  
  private static boolean aR(Intent paramIntent)
  {
    AppMethodBeat.i(29567);
    if (!paramIntent.getBooleanExtra("process_is_mm", false))
    {
      AppMethodBeat.o(29567);
      return true;
    }
    if (paramIntent.getIntExtra("process_id", 0) == Process.myPid())
    {
      AppMethodBeat.o(29567);
      return true;
    }
    AppMethodBeat.o(29567);
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(29568);
    if (paramIntent == null)
    {
      AppMethodBeat.o(29568);
      return;
    }
    if ((aw.aas()) || (aw.aau()))
    {
      AppMethodBeat.o(29568);
      return;
    }
    Object localObject = paramIntent.getAction();
    if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(localObject))
    {
      if (!aR(paramIntent))
      {
        ab.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
        AppMethodBeat.o(29568);
        return;
      }
      MMAppMgr.a(this.appMgr, paramIntent, true);
      AppMethodBeat.o(29568);
      return;
    }
    if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(localObject))
    {
      if (!aR(paramIntent))
      {
        ab.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
        AppMethodBeat.o(29568);
        return;
      }
      o.IE();
      MMAppMgr.a(this.appMgr, paramIntent, false);
      if ((MMAppMgr.zbK != null) && (MMAppMgr.zbK.length() > 800)) {
        new ak(Looper.getMainLooper()).post(new MMAppMgr.Receiver.1(this));
      }
      AppMethodBeat.o(29568);
      return;
    }
    if ("com.tencent.mm.ui.ACTION_ABTEST".equals(localObject))
    {
      paramContext = paramIntent.getStringExtra("content");
      if (bo.isNullOrNil(paramContext)) {
        ab.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
      }
      for (;;)
      {
        if ((MMAppMgr.zbK != null) && (MMAppMgr.zbK.length() > 800)) {
          new ak(Looper.getMainLooper()).post(new MMAppMgr.Receiver.2(this));
        }
        AppMethodBeat.o(29568);
        return;
        if (MMAppMgr.zbK == null) {
          MMAppMgr.zbK = new StringBuffer(800);
        }
        MMAppMgr.zbK.append(paramContext);
        ab.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[] { paramContext });
      }
    }
    if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE"))
    {
      int i;
      if (!paramIntent.getBooleanExtra("intent_extra_is_silence_stat", false))
      {
        i = paramIntent.getIntExtra("intent_extra_opcode", 0);
        ab.d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(i)));
        if (aw.RG()) {
          h.qsU.e(10328, new Object[] { Integer.valueOf(i) });
        }
      }
      long l1;
      long l2;
      label646:
      for (;;)
      {
        l1 = paramIntent.getLongExtra("intent_extra_flow_stat_upstream", 0L);
        l2 = paramIntent.getLongExtra("intent_extra_flow_stat_downstream", 0L);
        boolean bool = paramIntent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
        if ((!aw.RG()) || ((l1 == 0L) && (l2 == 0L))) {
          break label658;
        }
        ab.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        n.I((int)l2, (int)l1, 0);
        AppMethodBeat.o(29568);
        return;
        i = paramIntent.getIntExtra("intent_extra_opcode", 0);
        ab.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(i)));
        if (aw.RG())
        {
          if (i == 2)
          {
            int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
            h.qsU.e(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          for (;;)
          {
            if ((i != 4) || (i.dlT() != 4)) {
              break label646;
            }
            paramContext = com.tencent.mm.pluginsdk.model.app.a.dlr();
            if (paramContext == null) {
              break;
            }
            paramContext.dlt();
            break;
            h.qsU.e(11147, new Object[] { Integer.valueOf(i) });
          }
        }
      }
      n.J((int)l2, (int)l1, 0);
      label658:
      AppMethodBeat.o(29568);
      return;
    }
    if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP"))
    {
      MMAppMgr.l(paramContext, true);
      AppMethodBeat.o(29568);
      return;
    }
    if (paramIntent.getAction().equals("MINIQB_OPEN_RET"))
    {
      paramContext = paramIntent.getStringExtra("op_type");
      if ("NOTIFY_RET".equals(paramContext))
      {
        com.tencent.mm.pluginsdk.ui.tools.a.aE(paramIntent);
        AppMethodBeat.o(29568);
        return;
      }
      if ("SEND_TO_FRIENDS".equals(paramContext))
      {
        ab.i("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS");
        if (!com.tencent.mm.kernel.g.RG())
        {
          ab.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, account not ready");
          AppMethodBeat.o(29568);
          return;
        }
        String str2 = paramIntent.getStringExtra("file_path");
        localObject = paramIntent.getStringExtra("file_name");
        String str1 = paramIntent.getStringExtra("to_user");
        paramContext = paramIntent.getStringExtra("send_text");
        if ((bo.isNullOrNil(str2)) || (bo.isNullOrNil((String)localObject)) || (bo.isNullOrNil(str1)))
        {
          ab.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, param empty");
          AppMethodBeat.o(29568);
          return;
        }
        WXFileObject localWXFileObject = new WXFileObject();
        localWXFileObject.setFilePath(str2);
        paramIntent = new WXMediaMessage();
        paramIntent.mediaObject = localWXFileObject;
        paramIntent.title = ((String)localObject);
        paramIntent.description = ((String)localObject);
        localObject = bo.P(str1.split(",")).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          l.a(paramIntent, "", "", str1, 3, null);
          if (!bo.isNullOrNil(paramContext)) {
            com.tencent.mm.plugin.messenger.a.g.bPJ().K(str1, paramContext, t.oF(str1));
          }
        }
      }
      AppMethodBeat.o(29568);
      return;
    }
    ab.e("MicroMsg.MMAppMgr", "unknown broadcast action");
    AppMethodBeat.o(29568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.Receiver
 * JD-Core Version:    0.7.0.1
 */