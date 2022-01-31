package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.dr;
import com.tencent.mm.h.a.dr.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.protocal.c.apx;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class g$42
  extends com.tencent.mm.sdk.b.c<dr>
{
  g$42(g paramg)
  {
    this.udX = dr.class.getName().hashCode();
  }
  
  private boolean a(final dr paramdr)
  {
    String str1;
    int i;
    int j;
    double d1;
    double d2;
    String str2;
    boolean bool4;
    boolean bool1;
    boolean bool2;
    Object localObject1;
    if ((paramdr != null) && ((paramdr instanceof dr)))
    {
      System.currentTimeMillis();
      g.m(this.rzi);
      g.a(this.rzi, System.currentTimeMillis());
      str1 = paramdr.bKh.bKf;
      i = paramdr.bKh.bKi;
      j = paramdr.bKh.bKj & 0xFFFF;
      d1 = paramdr.bKh.bKl;
      d2 = paramdr.bKh.bKk;
      y.i("MicroMsg.MsgHandler", "[MsgHandler][IBeaconRangeResult],iBeacon = %s", new Object[] { str1 + "," + i + "," + j + "," + d1 });
      str2 = str1 + "," + i + "," + j;
      boolean bool3 = false;
      bool4 = false;
      bool1 = false;
      bool2 = false;
      if (g.n(this.rzi).containsKey(str2)) {
        break label858;
      }
      paramdr = new apw();
      paramdr.dCX = str1;
      paramdr.major = i;
      paramdr.minor = j;
      g.n(this.rzi).put(str2, paramdr);
      bool1 = bool3;
      if (g.o(this.rzi).containsKey(str1 + "," + i))
      {
        localObject1 = (List)g.o(this.rzi).get(str1 + "," + i);
        bool1 = bool3;
        if (localObject1 != null) {
          localObject1 = ((List)localObject1).iterator();
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (apx)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((apx)localObject2).tlR == null) || (((apx)localObject2).tlR.isEmpty())) {
          break label1080;
        }
        localObject2 = ((apx)localObject2).tlR.iterator();
        apz localapz;
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localapz = (apz)((Iterator)localObject2).next();
        } while ((j < localapz.tlS) || (j > localapz.tlT));
      }
      label643:
      label1080:
      for (bool1 = true; bool1; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          g.p(this.rzi).add(paramdr);
          localObject1 = null;
          paramdr = (dr)localObject1;
          if (g.j(this.rzi) != null)
          {
            paramdr = (dr)localObject1;
            if (g.j(this.rzi).ndL != null)
            {
              paramdr = g.j(this.rzi).ndL.get("url");
              if (paramdr == null) {
                break label851;
              }
              paramdr = paramdr.toString();
              paramdr = bk.pm(g.q(this.rzi).TL(paramdr));
            }
          }
          bool2 = bool1;
          if (!g.r(this.rzi))
          {
            g.b(this.rzi, true);
            paramdr = new k(g.p(this.rzi), bk.pm(paramdr));
            g.p(this.rzi).clear();
            au.Dk().a(1704, new f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
              {
                if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                {
                  paramAnonymousString = (acd)paramdr.esv.ecF.ecN;
                  if (paramAnonymousString.jxl == 0)
                  {
                    paramAnonymousString = paramAnonymousString.tbd;
                    paramAnonymousm = new StringBuilder();
                    Iterator localIterator = paramAnonymousString.iterator();
                    while (localIterator.hasNext())
                    {
                      Object localObject = (apx)localIterator.next();
                      String str = ((apx)localObject).dCX + "," + ((apx)localObject).major;
                      if (g.o(g.42.this.rzi).containsKey(str)) {
                        paramAnonymousString = (List)g.o(g.42.this.rzi).get(str);
                      }
                      for (;;)
                      {
                        paramAnonymousString.add(localObject);
                        paramAnonymousm.append("{uuid:" + ((apx)localObject).dCX + ",major:" + ((apx)localObject).major + ",minors:[");
                        paramAnonymousString = ((apx)localObject).tlR.iterator();
                        while (paramAnonymousString.hasNext())
                        {
                          localObject = (apz)paramAnonymousString.next();
                          paramAnonymousm.append(((apz)localObject).tlS + "-" + ((apz)localObject).tlT + ",");
                        }
                        paramAnonymousString = new ArrayList();
                        g.o(g.42.this.rzi).put(str, paramAnonymousString);
                      }
                      paramAnonymousm.append("]},");
                    }
                    y.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + paramAnonymousm.toString());
                  }
                }
                au.Dk().b(1704, this);
                g.b(g.42.this.rzi, false);
              }
            });
            au.Dk().a(paramdr, 0);
            bool2 = bool1;
          }
        }
        y.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check and find] find:%s", new Object[] { String.valueOf(bool2) + "," + str2 });
        for (;;)
        {
          try
          {
            paramdr = (e)g.s(this.rzi).get();
            if (paramdr == null) {
              continue;
            }
            if (bool2)
            {
              y.i("FindBeaconBug", "find Msghandler");
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("uuid", str1);
              ((Bundle)localObject1).putInt("major", i);
              ((Bundle)localObject1).putInt("minor", j);
              ((Bundle)localObject1).putDouble("accuracy", d2);
              ((Bundle)localObject1).putDouble("rssi", d1);
              ((Bundle)localObject1).putFloat("heading", g.t(this.rzi));
              paramdr.b(40002, (Bundle)localObject1);
            }
          }
          catch (RemoteException paramdr)
          {
            label851:
            label858:
            y.i("MicroMsg.MsgHandler", "[MsgHandler]callback failure:%s", new Object[] { paramdr.getMessage() });
            continue;
          }
          y.i("MicroMsg.MsgHandler", "[MsgHandler]result iBeacon = %s,beaconMap.size:%d", new Object[] { g.n(this.rzi).get(str2), Integer.valueOf(g.n(this.rzi).size()) });
          return false;
          paramdr = "";
          break;
          paramdr = (List)g.o(this.rzi).get(str1 + "," + i);
          bool2 = bool4;
          if (paramdr == null) {
            break label643;
          }
          paramdr = paramdr.iterator();
          bool2 = bool1;
          if (!paramdr.hasNext()) {
            break label643;
          }
          localObject1 = (apx)paramdr.next();
          bool2 = bool1;
          if (localObject1 != null)
          {
            bool2 = bool1;
            if (((apx)localObject1).tlR != null)
            {
              bool2 = bool1;
              if (!((apx)localObject1).tlR.isEmpty())
              {
                localObject1 = ((apx)localObject1).tlR.iterator();
                bool2 = bool1;
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (apz)((Iterator)localObject1).next();
                  if ((j < ((apz)localObject2).tlS) || (j > ((apz)localObject2).tlT)) {
                    continue;
                  }
                  bool2 = true;
                }
              }
            }
          }
          bool1 = bool2;
          if (bool2)
          {
            break label643;
            y.i("FindBeaconBug", "callbacker is null");
          }
        }
      }
      bool2 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.42
 * JD-Core Version:    0.7.0.1
 */