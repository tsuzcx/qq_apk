package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class a
  implements bx.a
{
  com.tencent.mm.sdk.b.c puW = new a.1(this);
  
  public final void a(e.a parama)
  {
    y.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    Object localObject = parama.dBs;
    if (localObject == null)
    {
      y.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      return;
    }
    parama = new b();
    parama.Om(aa.a(((cd)localObject).svH));
    y.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bk.aM(parama.puZ, ""));
    if (bk.bl(parama.puZ)) {
      y.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().mC(true);
      return;
      if (bk.bl(parama.pva))
      {
        y.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!parama.a(c.bLK().bLP()))
      {
        y.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!c.bLS())
      {
        y.e("MicroMsg.JDSysMsgNotifyLsn", "no entrance, ignore msg");
      }
      else
      {
        if (parama.puZ.equals("3"))
        {
          ((cd)localObject).svL = null;
          if ((bk.bl(parama.pvk)) || (bk.bl(parama.jumpUrl)) || (bk.bl(parama.pvl)) || (bk.bl(parama.pvm)) || (bk.bl(parama.pvj))) {
            y.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            c.b(parama);
            break;
            if (parama.bLD())
            {
              y.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              localObject = c.bLK();
              String str = parama.pva;
              if (bk.bl(str)) {}
              for (boolean bool = false;; bool = ((c)localObject).pvp.containsKey(str))
              {
                if (!bool) {
                  break label324;
                }
                y.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + parama.pva);
                break;
              }
              label324:
              if (!parama.a(c.bLK().bLP()))
              {
                y.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                localObject = c.bLK();
                str = parama.pva;
                if (!bk.bl(str)) {
                  ((c)localObject).pvp.put(str, Integer.valueOf(1));
                }
                y.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + parama.pva);
                new ah(Looper.getMainLooper()).post(new a.2(this, parama));
              }
            }
          }
        }
        if (parama.puZ.equals("1")) {
          c.b(parama);
        } else if (parama.puZ.equals("2")) {
          c.b(parama);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a
 * JD-Core Version:    0.7.0.1
 */