package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.mm.h.a.tz;
import com.tencent.mm.h.a.ub;
import com.tencent.mm.m.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.c.bvv;
import com.tencent.mm.protocal.c.cjl;
import com.tencent.mm.protocal.c.ckf;
import com.tencent.mm.protocal.c.ckg;
import com.tencent.mm.protocal.c.ckh;
import com.tencent.mm.protocal.c.cki;
import com.tencent.mm.protocal.c.ckm;
import com.tencent.mm.protocal.c.clo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends a
{
  protected final boolean Bh(int paramInt)
  {
    switch (paramInt)
    {
    case 11024: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11022));
    localArrayList.add(Integer.valueOf(11023));
    localArrayList.add(Integer.valueOf(11025));
    localArrayList.add(Integer.valueOf(11024));
    localArrayList.add(Integer.valueOf(11026));
    localArrayList.add(Integer.valueOf(11029));
    return localArrayList;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      Object localObject = new cki();
      try
      {
        ((cki)localObject).aH(paramArrayOfByte);
        com.tencent.mm.plugin.wear.model.a.bYL().qRA.a(new m.a((cki)localObject));
        com.tencent.mm.plugin.wear.model.a.bYL().qRw.Rg(((cki)localObject).tXp);
        com.tencent.mm.plugin.wear.model.c.a.ez(2, ((cki)localObject).pyo);
        com.tencent.mm.plugin.wear.model.c.a.Bf(2);
        continue;
        localObject = new ckh();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((ckh)localObject).aH(paramArrayOfByte);
          com.tencent.mm.plugin.messenger.a.g.bhI().D(((ckh)localObject).tXp, ((ckh)localObject).sRA, s.hW(((ckh)localObject).tXp));
          au.Hx();
          c.FB().abx(((ckh)localObject).tXp);
          com.tencent.mm.plugin.wear.model.c.a.ez(3, ((ckh)localObject).pyo);
          com.tencent.mm.plugin.wear.model.c.a.Bf(5);
          continue;
          localObject = new ckg();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            ((ckg)localObject).aH(paramArrayOfByte);
            com.tencent.mm.plugin.messenger.a.g.bhI().D(((ckg)localObject).tXp, ((ckg)localObject).sRA, s.hW(((ckg)localObject).tXp));
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().m(ae.getContext(), ((ckg)localObject).tXp, ((ckg)localObject).sRE);
            au.Hx();
            c.FB().abx(((ckg)localObject).tXp);
            com.tencent.mm.plugin.wear.model.c.a.ez(8, ((ckg)localObject).pyo);
            com.tencent.mm.plugin.wear.model.c.a.Bf(4);
            continue;
            localObject = new ckf();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((ckf)localObject).aH(paramArrayOfByte);
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().m(ae.getContext(), ((ckf)localObject).tXp, ((ckf)localObject).sRE);
              au.Hx();
              c.FB().abx(((ckf)localObject).tXp);
              com.tencent.mm.plugin.wear.model.c.a.ez(7, ((ckf)localObject).pyo);
              com.tencent.mm.plugin.wear.model.c.a.Bf(3);
              continue;
              localObject = new ckm();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                ((ckm)localObject).aH(paramArrayOfByte);
                com.tencent.mm.plugin.wear.model.a.bYL();
                paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.bYL().qRu.qRL.qSA;
                if (paramArrayOfByte == null)
                {
                  y.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                  continue;
                }
                y.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(((ckm)localObject).tXP), h.g("yyyy-MM-dd HH:mm:ss", ((ckm)localObject).tXQ / 1000L) });
                localclo = new clo();
                bvv localbvv = new bvv();
                if (((ckm)localObject).tXP > 0)
                {
                  paramInt = ((ckm)localObject).tXP;
                  localbvv.hQP = paramInt;
                  localbvv.sSK = ((int)(((ckm)localObject).tXQ / 1000L));
                  Calendar localCalendar = Calendar.getInstance();
                  localCalendar.setTimeInMillis(((ckm)localObject).tXQ);
                  localbvv.tMC = localCalendar.get(1);
                  localbvv.tMD = (localCalendar.get(2) + 1);
                  localbvv.tME = localCalendar.get(5);
                  localbvv.tMF = localCalendar.get(11);
                  localbvv.tMG = localCalendar.get(12);
                  localbvv.tMH = localCalendar.get(13);
                  localclo.tYL.add(localbvv);
                  localObject = new ub();
                }
              }
              catch (IOException paramArrayOfByte)
              {
                try
                {
                  for (;;)
                  {
                    clo localclo;
                    ((ub)localObject).cez.data = localclo.toByteArray();
                    label640:
                    ((ub)localObject).cez.bHz = 4;
                    ((ub)localObject).cez.bwK = paramArrayOfByte.tXi;
                    ((ub)localObject).cez.bJp = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
                    break;
                    paramInt = 0;
                    continue;
                    if ((!com.tencent.mm.plugin.wear.model.a.bYL().qRu.bYQ()) || (com.tencent.mm.m.g.AA().getInt("WearLuckyBlock", 0) != 0)) {
                      return null;
                    }
                    long l1 = 0L;
                    try
                    {
                      long l2 = Long.valueOf(new String(paramArrayOfByte)).longValue();
                      l1 = l2;
                    }
                    catch (Exception paramArrayOfByte)
                    {
                      label737:
                      break label737;
                    }
                    paramArrayOfByte = new tz();
                    paramArrayOfByte.cen.action = 1;
                    paramArrayOfByte.cen.bHR = l1;
                    com.tencent.mm.sdk.b.a.udP.a(paramArrayOfByte, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.ez(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.Bf(11);
                    break;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                  }
                  paramArrayOfByte = paramArrayOfByte;
                }
                catch (IOException localIOException)
                {
                  break label640;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.m
 * JD-Core Version:    0.7.0.1
 */