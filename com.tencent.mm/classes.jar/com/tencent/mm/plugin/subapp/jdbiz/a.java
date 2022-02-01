package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.my;
import com.tencent.mm.model.at;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.Map;

public final class a
  implements cc.a
{
  com.tencent.mm.sdk.b.c zPy;
  
  public a()
  {
    AppMethodBeat.i(28865);
    this.zPy = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(28865);
  }
  
  public final void a(final f.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(28866);
    ac.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    Object localObject = parama.fXi;
    if (localObject == null)
    {
      ac.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(28866);
      return;
    }
    parama = new c();
    parama.auB(z.a(((cu)localObject).DPV));
    ac.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bs.bG(parama.zPB, ""));
    if (bs.isNullOrNil(parama.zPB)) {
      ac.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      az.ayM();
      com.tencent.mm.model.c.agA().faa();
      AppMethodBeat.o(28866);
      return;
      if (bs.isNullOrNil(parama.zPC))
      {
        ac.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!parama.a(d.eat().eay()))
      {
        ac.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!d.eat().eaB())
      {
        ac.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
      }
      else
      {
        if (parama.zPB.equals("3"))
        {
          ((cu)localObject).DPZ = null;
          if ((bs.isNullOrNil(parama.zPM)) || (bs.isNullOrNil(parama.jumpUrl)) || (bs.isNullOrNil(parama.zPN)) || (bs.isNullOrNil(parama.zPO)) || (bs.isNullOrNil(parama.zPL))) {
            ac.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            d.b(parama);
            break;
            if (parama.cIm())
            {
              ac.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              localObject = d.eat();
              String str = parama.zPC;
              if (bs.isNullOrNil(str)) {}
              for (;;)
              {
                if (!bool) {
                  break label344;
                }
                ac.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + parama.zPC);
                break;
                bool = ((d)localObject).zPU.containsKey(str);
              }
              label344:
              if (!parama.a(d.eat().eay()))
              {
                ac.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                localObject = d.eat();
                str = parama.zPC;
                if (!bs.isNullOrNil(str)) {
                  ((d)localObject).zPU.put(str, Integer.valueOf(1));
                }
                ac.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + parama.zPC);
                new ao(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(28864);
                    Object localObject = a.this;
                    c localc = parama;
                    az.ayM();
                    int i = ((Integer)com.tencent.mm.model.c.agA().get(15, Integer.valueOf(0))).intValue();
                    if ((az.agi().foreground) && (1 == i))
                    {
                      localObject = d.eP(localc.jumpUrl, 5);
                      JDRemindDialog.a(ai.getContext(), localc.zPM, localc.zPN, localc.zPO, (String)localObject, localc.zPC);
                      h.wUl.f(11178, new Object[] { localObject, d.eat().eay().zPC, Integer.valueOf(5) });
                      AppMethodBeat.o(28864);
                      return;
                    }
                    String str = d.eP(localc.jumpUrl, 4);
                    Bundle localBundle = new Bundle();
                    localBundle.putString("activity_id", localc.zPC);
                    localBundle.putString("jump_url", str);
                    ((at)az.getNotification()).a(37, ai.getContext().getString(2131755866), localc.zPL, str, "bizjd", localBundle);
                    com.tencent.mm.sdk.b.a.GpY.c(((a)localObject).zPy);
                    h.wUl.f(11178, new Object[] { str, d.eat().eay().zPC, Integer.valueOf(4) });
                    AppMethodBeat.o(28864);
                  }
                });
              }
            }
          }
        }
        if (parama.zPB.equals("1"))
        {
          d.b(parama);
        }
        else if (parama.zPB.equals("2"))
        {
          d.b(parama);
          h.wUl.f(11178, new Object[] { parama.jumpUrl, parama.zPC, Integer.valueOf(3) });
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