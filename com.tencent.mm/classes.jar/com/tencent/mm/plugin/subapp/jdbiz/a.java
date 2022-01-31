package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class a
  implements bz.a
{
  com.tencent.mm.sdk.b.c sWx;
  
  public a()
  {
    AppMethodBeat.i(25190);
    this.sWx = new a.1(this);
    AppMethodBeat.o(25190);
  }
  
  public final void a(e.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(25191);
    ab.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    Object localObject = parama.eyJ;
    if (localObject == null)
    {
      ab.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(25191);
      return;
    }
    parama = new c();
    parama.abg(aa.a(((cm)localObject).woR));
    ab.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bo.bf(parama.sWA, ""));
    if (bo.isNullOrNil(parama.sWA)) {
      ab.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().dww();
      AppMethodBeat.o(25191);
      return;
      if (bo.isNullOrNil(parama.sWB))
      {
        ab.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!parama.a(d.cGE().cGJ()))
      {
        ab.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!d.cGE().cGM())
      {
        ab.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
      }
      else
      {
        if (parama.sWA.equals("3"))
        {
          ((cm)localObject).woV = null;
          if ((bo.isNullOrNil(parama.sWL)) || (bo.isNullOrNil(parama.jumpUrl)) || (bo.isNullOrNil(parama.sWM)) || (bo.isNullOrNil(parama.sWN)) || (bo.isNullOrNil(parama.sWK))) {
            ab.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            d.b(parama);
            break;
            if (parama.bzK())
            {
              ab.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              localObject = d.cGE();
              String str = parama.sWB;
              if (bo.isNullOrNil(str)) {}
              for (;;)
              {
                if (!bool) {
                  break label344;
                }
                ab.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + parama.sWB);
                break;
                bool = ((d)localObject).sWT.containsKey(str);
              }
              label344:
              if (!parama.a(d.cGE().cGJ()))
              {
                ab.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                localObject = d.cGE();
                str = parama.sWB;
                if (!bo.isNullOrNil(str)) {
                  ((d)localObject).sWT.put(str, Integer.valueOf(1));
                }
                ab.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + parama.sWB);
                new ak(Looper.getMainLooper()).post(new a.2(this, parama));
              }
            }
          }
        }
        if (parama.sWA.equals("1"))
        {
          d.b(parama);
        }
        else if (parama.sWA.equals("2"))
        {
          d.b(parama);
          h.qsU.e(11178, new Object[] { parama.jumpUrl, parama.sWB, Integer.valueOf(3) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a
 * JD-Core Version:    0.7.0.1
 */