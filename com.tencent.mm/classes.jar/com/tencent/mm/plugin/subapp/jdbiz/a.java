package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.Map;

public final class a
  implements cf.a
{
  com.tencent.mm.sdk.b.c Byx;
  
  public a()
  {
    AppMethodBeat.i(28865);
    this.Byx = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(28865);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(28866);
    ae.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    parama = parama.gte;
    if (parama == null)
    {
      ae.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(28866);
      return;
    }
    final c localc = new c();
    localc.aAY(z.a(parama.FNI));
    ae.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bu.bI(localc.ByA, ""));
    if (bu.isNullOrNil(localc.ByA)) {
      ae.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().fuc();
      AppMethodBeat.o(28866);
      return;
      if (bu.isNullOrNil(localc.ByB))
      {
        ae.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!localc.a(d.eqr().eqw()))
      {
        ae.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!d.eqr().eqz())
      {
        ae.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
      }
      else
      {
        String str;
        if (localc.ByA.equals("3"))
        {
          parama.FNM = null;
          if ((bu.isNullOrNil(localc.ByL)) || (bu.isNullOrNil(localc.jumpUrl)) || (bu.isNullOrNil(localc.ByM)) || (bu.isNullOrNil(localc.ByN)) || (bu.isNullOrNil(localc.ByK))) {
            ae.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            d.b(localc);
            break;
            if (localc.cTg())
            {
              ae.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              parama = d.eqr();
              str = localc.ByB;
              if (bu.isNullOrNil(str)) {}
              for (boolean bool = false;; bool = parama.ByT.containsKey(str))
              {
                if (!bool) {
                  break label357;
                }
                ae.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + localc.ByB);
                break;
              }
              label357:
              if (!localc.a(d.eqr().eqw()))
              {
                ae.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                parama = d.eqr();
                str = localc.ByB;
                if (!bu.isNullOrNil(str)) {
                  parama.ByT.put(str, Integer.valueOf(1));
                }
                ae.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + localc.ByB);
                new aq(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(28864);
                    Object localObject = a.this;
                    c localc = localc;
                    bc.aCg();
                    int i = ((Integer)com.tencent.mm.model.c.ajA().get(15, Integer.valueOf(0))).intValue();
                    if ((bc.ajj().foreground) && (1 == i))
                    {
                      localObject = d.fq(localc.jumpUrl, 5);
                      JDRemindDialog.a(ak.getContext(), localc.ByL, localc.ByM, localc.ByN, (String)localObject, localc.ByB);
                      g.yxI.f(11178, new Object[] { localObject, d.eqr().eqw().ByB, Integer.valueOf(5) });
                      AppMethodBeat.o(28864);
                      return;
                    }
                    String str = d.fq(localc.jumpUrl, 4);
                    Bundle localBundle = new Bundle();
                    localBundle.putString("activity_id", localc.ByB);
                    localBundle.putString("jump_url", str);
                    ((aw)bc.getNotification()).a(37, ak.getContext().getString(2131755866), localc.ByK, str, "bizjd", localBundle);
                    com.tencent.mm.sdk.b.a.IvT.c(((a)localObject).Byx);
                    g.yxI.f(11178, new Object[] { str, d.eqr().eqw().ByB, Integer.valueOf(4) });
                    AppMethodBeat.o(28864);
                  }
                });
              }
            }
          }
        }
        if (localc.ByA.equals("1"))
        {
          d.b(localc);
        }
        else if (localc.ByA.equals("2"))
        {
          d.b(localc);
          str = d.eqr().eqE().username;
          parama = str;
          if (bu.isNullOrNil(str)) {
            parama = d.eqr().eqD();
          }
          g.yxI.f(11178, new Object[] { parama, localc.ByB, Integer.valueOf(3), Integer.valueOf(1) });
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