package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ow;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Map;

public final class a
  implements ck.a
{
  IListener Mdg;
  
  public a()
  {
    AppMethodBeat.i(28865);
    this.Mdg = new IListener() {};
    AppMethodBeat.o(28865);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(28866);
    Log.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    parama = parama.jQG;
    if (parama == null)
    {
      Log.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(28866);
      return;
    }
    final c localc = new c();
    localc.feed(z.a(parama.RIF));
    Log.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + Util.nullAs(localc.Mdj, ""));
    if (Util.isNullOrNil(localc.Mdj)) {
      Log.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().hxT();
      AppMethodBeat.o(28866);
      return;
      if (Util.isNullOrNil(localc.oym))
      {
        Log.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!localc.a(d.ghp().ghu()))
      {
        Log.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!d.ghp().ghx())
      {
        Log.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
      }
      else
      {
        String str;
        if (localc.Mdj.equals("3"))
        {
          parama.RIJ = null;
          if ((Util.isNullOrNil(localc.Mdt)) || (Util.isNullOrNil(localc.jumpUrl)) || (Util.isNullOrNil(localc.Mdu)) || (Util.isNullOrNil(localc.Mdv)) || (Util.isNullOrNil(localc.Mds))) {
            Log.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            d.b(localc);
            break;
            if (localc.eqj())
            {
              Log.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              parama = d.ghp();
              str = localc.oym;
              if (Util.isNullOrNil(str)) {}
              for (boolean bool = false;; bool = parama.MdB.containsKey(str))
              {
                if (!bool) {
                  break label357;
                }
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + localc.oym);
                break;
              }
              label357:
              if (!localc.a(d.ghp().ghu()))
              {
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                parama = d.ghp();
                str = localc.oym;
                if (!Util.isNullOrNil(str)) {
                  parama.MdB.put(str, Integer.valueOf(1));
                }
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + localc.oym);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(28864);
                    Object localObject = a.this;
                    c localc = localc;
                    bh.beI();
                    int i = ((Integer)com.tencent.mm.model.c.aHp().b(15, Integer.valueOf(0))).intValue();
                    if ((bh.aGY().foreground) && (1 == i))
                    {
                      localObject = d.gs(localc.jumpUrl, 5);
                      JDRemindDialog.a(MMApplicationContext.getContext(), localc.Mdt, localc.Mdu, localc.Mdv, (String)localObject, localc.oym);
                      h.IzE.a(11178, new Object[] { localObject, d.ghp().ghu().oym, Integer.valueOf(5) });
                      AppMethodBeat.o(28864);
                      return;
                    }
                    String str = d.gs(localc.jumpUrl, 4);
                    Bundle localBundle = new Bundle();
                    localBundle.putString("activity_id", localc.oym);
                    localBundle.putString("jump_url", str);
                    ((bb)bh.getNotification()).a(37, MMApplicationContext.getContext().getString(R.l.app_pushcontent_title), localc.Mds, str, "bizjd", localBundle);
                    EventCenter.instance.addListener(((a)localObject).Mdg);
                    h.IzE.a(11178, new Object[] { str, d.ghp().ghu().oym, Integer.valueOf(4) });
                    AppMethodBeat.o(28864);
                  }
                });
              }
            }
          }
        }
        if (localc.Mdj.equals("1"))
        {
          d.b(localc);
        }
        else if (localc.Mdj.equals("2"))
        {
          d.b(localc);
          str = d.ghp().ghC().username;
          parama = str;
          if (Util.isNullOrNil(str)) {
            parama = d.ghp().ghB();
          }
          h.IzE.a(11178, new Object[] { parama, localc.oym, Integer.valueOf(3), Integer.valueOf(1) });
        }
      }
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a
 * JD-Core Version:    0.7.0.1
 */