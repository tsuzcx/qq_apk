package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.model.au;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.Map;

public final class a
  implements cd.a
{
  com.tencent.mm.sdk.b.c BgZ;
  
  public a()
  {
    AppMethodBeat.i(28865);
    this.BgZ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(28865);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(28866);
    ad.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    parama = parama.gqE;
    if (parama == null)
    {
      ad.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(28866);
      return;
    }
    final c localc = new c();
    localc.azH(z.a(parama.Fvk));
    ad.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bt.bI(localc.Bhc, ""));
    if (bt.isNullOrNil(localc.Bhc)) {
      ad.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().fqc();
      AppMethodBeat.o(28866);
      return;
      if (bt.isNullOrNil(localc.Bhd))
      {
        ad.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!localc.a(d.emI().emN()))
      {
        ad.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!d.emI().emQ())
      {
        ad.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
      }
      else
      {
        String str;
        if (localc.Bhc.equals("3"))
        {
          parama.Fvo = null;
          if ((bt.isNullOrNil(localc.Bhn)) || (bt.isNullOrNil(localc.jumpUrl)) || (bt.isNullOrNil(localc.Bho)) || (bt.isNullOrNil(localc.Bhp)) || (bt.isNullOrNil(localc.Bhm))) {
            ad.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            d.b(localc);
            break;
            if (localc.cQB())
            {
              ad.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              parama = d.emI();
              str = localc.Bhd;
              if (bt.isNullOrNil(str)) {}
              for (boolean bool = false;; bool = parama.Bhv.containsKey(str))
              {
                if (!bool) {
                  break label357;
                }
                ad.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + localc.Bhd);
                break;
              }
              label357:
              if (!localc.a(d.emI().emN()))
              {
                ad.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                parama = d.emI();
                str = localc.Bhd;
                if (!bt.isNullOrNil(str)) {
                  parama.Bhv.put(str, Integer.valueOf(1));
                }
                ad.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + localc.Bhd);
                new ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(28864);
                    Object localObject = a.this;
                    c localc = localc;
                    ba.aBQ();
                    int i = ((Integer)com.tencent.mm.model.c.ajl().get(15, Integer.valueOf(0))).intValue();
                    if ((ba.aiU().foreground) && (1 == i))
                    {
                      localObject = d.fh(localc.jumpUrl, 5);
                      JDRemindDialog.a(aj.getContext(), localc.Bhn, localc.Bho, localc.Bhp, (String)localObject, localc.Bhd);
                      g.yhR.f(11178, new Object[] { localObject, d.emI().emN().Bhd, Integer.valueOf(5) });
                      AppMethodBeat.o(28864);
                      return;
                    }
                    String str = d.fh(localc.jumpUrl, 4);
                    Bundle localBundle = new Bundle();
                    localBundle.putString("activity_id", localc.Bhd);
                    localBundle.putString("jump_url", str);
                    ((au)ba.getNotification()).a(37, aj.getContext().getString(2131755866), localc.Bhm, str, "bizjd", localBundle);
                    com.tencent.mm.sdk.b.a.IbL.c(((a)localObject).BgZ);
                    g.yhR.f(11178, new Object[] { str, d.emI().emN().Bhd, Integer.valueOf(4) });
                    AppMethodBeat.o(28864);
                  }
                });
              }
            }
          }
        }
        if (localc.Bhc.equals("1"))
        {
          d.b(localc);
        }
        else if (localc.Bhc.equals("2"))
        {
          d.b(localc);
          str = d.emI().emV().username;
          parama = str;
          if (bt.isNullOrNil(str)) {
            parama = d.emI().emU();
          }
          g.yhR.f(11178, new Object[] { parama, localc.Bhd, Integer.valueOf(3), Integer.valueOf(1) });
        }
      }
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a
 * JD-Core Version:    0.7.0.1
 */