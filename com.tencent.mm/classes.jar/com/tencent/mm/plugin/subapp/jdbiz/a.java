package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Map;

public final class a
  implements cj.a
{
  IListener FJi;
  
  public a()
  {
    AppMethodBeat.i(28865);
    this.FJi = new IListener() {};
    AppMethodBeat.o(28865);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(28866);
    Log.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    parama = parama.heO;
    if (parama == null)
    {
      Log.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(28866);
      return;
    }
    final c localc = new c();
    localc.feed(z.a(parama.KHn));
    Log.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + Util.nullAs(localc.FJl, ""));
    if (Util.isNullOrNil(localc.FJl)) {
      Log.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().gBI();
      AppMethodBeat.o(28866);
      return;
      if (Util.isNullOrNil(localc.FJm))
      {
        Log.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!localc.a(d.fsQ().fsV()))
      {
        Log.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!d.fsQ().fsY())
      {
        Log.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
      }
      else
      {
        String str;
        if (localc.FJl.equals("3"))
        {
          parama.KHr = null;
          if ((Util.isNullOrNil(localc.FJw)) || (Util.isNullOrNil(localc.jumpUrl)) || (Util.isNullOrNil(localc.FJx)) || (Util.isNullOrNil(localc.FJy)) || (Util.isNullOrNil(localc.FJv))) {
            Log.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            d.b(localc);
            break;
            if (localc.dMp())
            {
              Log.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              parama = d.fsQ();
              str = localc.FJm;
              if (Util.isNullOrNil(str)) {}
              for (boolean bool = false;; bool = parama.FJE.containsKey(str))
              {
                if (!bool) {
                  break label357;
                }
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + localc.FJm);
                break;
              }
              label357:
              if (!localc.a(d.fsQ().fsV()))
              {
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                parama = d.fsQ();
                str = localc.FJm;
                if (!Util.isNullOrNil(str)) {
                  parama.FJE.put(str, Integer.valueOf(1));
                }
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + localc.FJm);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(28864);
                    Object localObject = a.this;
                    c localc = localc;
                    bg.aVF();
                    int i = ((Integer)com.tencent.mm.model.c.azQ().get(15, Integer.valueOf(0))).intValue();
                    if ((bg.azz().foreground) && (1 == i))
                    {
                      localObject = d.fO(localc.jumpUrl, 5);
                      JDRemindDialog.a(MMApplicationContext.getContext(), localc.FJw, localc.FJx, localc.FJy, (String)localObject, localc.FJm);
                      h.CyF.a(11178, new Object[] { localObject, d.fsQ().fsV().FJm, Integer.valueOf(5) });
                      AppMethodBeat.o(28864);
                      return;
                    }
                    String str = d.fO(localc.jumpUrl, 4);
                    Bundle localBundle = new Bundle();
                    localBundle.putString("activity_id", localc.FJm);
                    localBundle.putString("jump_url", str);
                    ((ba)bg.getNotification()).a(37, MMApplicationContext.getContext().getString(2131755955), localc.FJv, str, "bizjd", localBundle);
                    EventCenter.instance.addListener(((a)localObject).FJi);
                    h.CyF.a(11178, new Object[] { str, d.fsQ().fsV().FJm, Integer.valueOf(4) });
                    AppMethodBeat.o(28864);
                  }
                });
              }
            }
          }
        }
        if (localc.FJl.equals("1"))
        {
          d.b(localc);
        }
        else if (localc.FJl.equals("2"))
        {
          d.b(localc);
          str = d.fsQ().ftd().username;
          parama = str;
          if (Util.isNullOrNil(str)) {
            parama = d.fsQ().ftc();
          }
          h.CyF.a(11178, new Object[] { parama, localc.FJm, Integer.valueOf(3), Integer.valueOf(1) });
        }
      }
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a
 * JD-Core Version:    0.7.0.1
 */