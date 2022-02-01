package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.Map;

public final class a
  implements cl.a
{
  IListener SEw;
  
  public a()
  {
    AppMethodBeat.i(28865);
    this.SEw = new JDSysMsgNotifyLsn.1(this, f.hfK);
    AppMethodBeat.o(28865);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(28866);
    Log.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    parama = parama.mpN;
    if (parama == null)
    {
      Log.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(28866);
      return;
    }
    final c localc = new c();
    localc.feed(w.a(parama.YFG));
    Log.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + Util.nullAs(localc.SEz, ""));
    if (Util.isNullOrNil(localc.SEz)) {
      Log.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().iZy();
      AppMethodBeat.o(28866);
      return;
      if (Util.isNullOrNil(localc.rBJ))
      {
        Log.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!localc.a(d.hAI().hAN()))
      {
        Log.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!d.hAI().hAQ())
      {
        Log.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
      }
      else
      {
        String str;
        if (localc.SEz.equals("3"))
        {
          parama.YFK = null;
          if ((Util.isNullOrNil(localc.SEJ)) || (Util.isNullOrNil(localc.jumpUrl)) || (Util.isNullOrNil(localc.SEK)) || (Util.isNullOrNil(localc.SEL)) || (Util.isNullOrNil(localc.SEI))) {
            Log.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            d.b(localc);
            break;
            if (localc.dgl())
            {
              Log.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              parama = d.hAI();
              str = localc.rBJ;
              if (Util.isNullOrNil(str)) {}
              for (boolean bool = false;; bool = parama.SER.containsKey(str))
              {
                if (!bool) {
                  break label357;
                }
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + localc.rBJ);
                break;
              }
              label357:
              if (!localc.a(d.hAI().hAN()))
              {
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                parama = d.hAI();
                str = localc.rBJ;
                if (!Util.isNullOrNil(str)) {
                  parama.SER.put(str, Integer.valueOf(1));
                }
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + localc.rBJ);
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(28864);
                    Object localObject = a.this;
                    c localc = localc;
                    bh.bCz();
                    int i = ((Integer)com.tencent.mm.model.c.ban().d(15, Integer.valueOf(0))).intValue();
                    if ((bh.aZW().foreground) && (1 == i))
                    {
                      localObject = d.hm(localc.jumpUrl, 5);
                      JDRemindDialog.a(MMApplicationContext.getContext(), localc.SEJ, localc.SEK, localc.SEL, (String)localObject, localc.rBJ);
                      h.OAn.b(11178, new Object[] { localObject, d.hAI().hAN().rBJ, Integer.valueOf(5) });
                      AppMethodBeat.o(28864);
                      return;
                    }
                    String str = d.hm(localc.jumpUrl, 4);
                    Bundle localBundle = new Bundle();
                    localBundle.putString("activity_id", localc.rBJ);
                    localBundle.putString("jump_url", str);
                    ((bb)bh.getNotification()).a(37, MMApplicationContext.getContext().getString(R.l.app_pushcontent_title), localc.SEI, str, "bizjd", localBundle);
                    ((a)localObject).SEw.alive();
                    h.OAn.b(11178, new Object[] { str, d.hAI().hAN().rBJ, Integer.valueOf(4) });
                    AppMethodBeat.o(28864);
                  }
                });
              }
            }
          }
        }
        if (localc.SEz.equals("1"))
        {
          d.b(localc);
        }
        else if (localc.SEz.equals("2"))
        {
          d.b(localc);
          str = d.hAI().hAV().username;
          parama = str;
          if (Util.isNullOrNil(str)) {
            parama = d.hAI().hAU();
          }
          h.OAn.b(11178, new Object[] { parama, localc.rBJ, Integer.valueOf(3), Integer.valueOf(1) });
        }
      }
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a
 * JD-Core Version:    0.7.0.1
 */