package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.model.at;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.Map;

public final class a
  implements cc.a
{
  com.tencent.mm.sdk.b.c yCk;
  
  public a()
  {
    AppMethodBeat.i(28865);
    this.yCk = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(28865);
  }
  
  public final void a(final f.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(28866);
    ad.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    Object localObject = parama.fTo;
    if (localObject == null)
    {
      ad.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(28866);
      return;
    }
    parama = new c();
    parama.apq(z.a(((cs)localObject).Cxz));
    ad.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bt.by(parama.yCn, ""));
    if (bt.isNullOrNil(parama.yCn)) {
      ad.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      az.arV();
      com.tencent.mm.model.c.afk().eKy();
      AppMethodBeat.o(28866);
      return;
      if (bt.isNullOrNil(parama.yCo))
      {
        ad.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!parama.a(d.dLT().dLY()))
      {
        ad.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!d.dLT().dMb())
      {
        ad.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
      }
      else
      {
        if (parama.yCn.equals("3"))
        {
          ((cs)localObject).CxD = null;
          if ((bt.isNullOrNil(parama.yCy)) || (bt.isNullOrNil(parama.jumpUrl)) || (bt.isNullOrNil(parama.yCz)) || (bt.isNullOrNil(parama.yCA)) || (bt.isNullOrNil(parama.yCx))) {
            ad.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            d.b(parama);
            break;
            if (parama.cva())
            {
              ad.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              localObject = d.dLT();
              String str = parama.yCo;
              if (bt.isNullOrNil(str)) {}
              for (;;)
              {
                if (!bool) {
                  break label344;
                }
                ad.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + parama.yCo);
                break;
                bool = ((d)localObject).yCG.containsKey(str);
              }
              label344:
              if (!parama.a(d.dLT().dLY()))
              {
                ad.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                localObject = d.dLT();
                str = parama.yCo;
                if (!bt.isNullOrNil(str)) {
                  ((d)localObject).yCG.put(str, Integer.valueOf(1));
                }
                ad.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + parama.yCo);
                new ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(28864);
                    Object localObject = a.this;
                    c localc = parama;
                    az.arV();
                    int i = ((Integer)com.tencent.mm.model.c.afk().get(15, Integer.valueOf(0))).intValue();
                    if ((az.aeS().foreground) && (1 == i))
                    {
                      localObject = d.eH(localc.jumpUrl, 5);
                      JDRemindDialog.a(aj.getContext(), localc.yCy, localc.yCz, localc.yCA, (String)localObject, localc.yCo);
                      h.vKh.f(11178, new Object[] { localObject, d.dLT().dLY().yCo, Integer.valueOf(5) });
                      AppMethodBeat.o(28864);
                      return;
                    }
                    String str = d.eH(localc.jumpUrl, 4);
                    Bundle localBundle = new Bundle();
                    localBundle.putString("activity_id", localc.yCo);
                    localBundle.putString("jump_url", str);
                    ((at)az.getNotification()).a(37, aj.getContext().getString(2131755866), localc.yCx, str, "bizjd", localBundle);
                    com.tencent.mm.sdk.b.a.ESL.c(((a)localObject).yCk);
                    h.vKh.f(11178, new Object[] { str, d.dLT().dLY().yCo, Integer.valueOf(4) });
                    AppMethodBeat.o(28864);
                  }
                });
              }
            }
          }
        }
        if (parama.yCn.equals("1"))
        {
          d.b(parama);
        }
        else if (parama.yCn.equals("2"))
        {
          d.b(parama);
          h.vKh.f(11178, new Object[] { parama.jumpUrl, parama.yCo, Integer.valueOf(3) });
        }
      }
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a
 * JD-Core Version:    0.7.0.1
 */