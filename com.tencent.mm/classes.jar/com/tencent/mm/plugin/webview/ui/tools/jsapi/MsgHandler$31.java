package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.fa;
import com.tencent.mm.autogen.a.fa.a;
import com.tencent.mm.plugin.webview.model.n;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dax;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MsgHandler$31
  extends IListener<fa>
{
  MsgHandler$31(j paramj, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(297402);
    this.__eventId = fa.class.getName().hashCode();
    AppMethodBeat.o(297402);
  }
  
  private boolean a(final fa paramfa)
  {
    AppMethodBeat.i(297416);
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
    if ((paramfa != null) && ((paramfa instanceof fa)))
    {
      System.currentTimeMillis();
      j.n(this.XjI);
      j.a(this.XjI, System.currentTimeMillis());
      str1 = paramfa.hFk.hFi;
      i = paramfa.hFk.hFl;
      j = paramfa.hFk.hFm & 0xFFFF;
      d1 = paramfa.hFk.hFo;
      d2 = paramfa.hFk.hFn;
      Log.i("MicroMsg.MsgHandler", "[MsgHandler][IBeaconRangeResult],iBeacon = %s", new Object[] { str1 + "," + i + "," + j + "," + d1 });
      str2 = str1 + "," + i + "," + j;
      boolean bool3 = false;
      bool4 = false;
      bool1 = false;
      bool2 = false;
      if (j.o(this.XjI).containsKey(str2)) {
        break label869;
      }
      paramfa = new daw();
      paramfa.uuid = str1;
      paramfa.rid = i;
      paramfa.rie = j;
      j.o(this.XjI).put(str2, paramfa);
      bool1 = bool3;
      if (j.p(this.XjI).containsKey(str1 + "," + i))
      {
        localObject1 = (List)j.p(this.XjI).get(str1 + "," + i);
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
        localObject2 = (dax)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((dax)localObject2).aaGs == null) || (((dax)localObject2).aaGs.isEmpty())) {
          break label1091;
        }
        localObject2 = ((dax)localObject2).aaGs.iterator();
        daz localdaz;
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localdaz = (daz)((Iterator)localObject2).next();
        } while ((j < localdaz.aaGt) || (j > localdaz.aaGu));
      }
      label648:
      label1091:
      for (bool1 = true; bool1; bool1 = bool2)
      {
        bool2 = bool1;
        if (!bool1)
        {
          j.q(this.XjI).add(paramfa);
          localObject1 = null;
          paramfa = (fa)localObject1;
          if (j.j(this.XjI) != null)
          {
            paramfa = (fa)localObject1;
            if (j.j(this.XjI).params != null)
            {
              paramfa = j.j(this.XjI).params.get("url");
              if (paramfa == null) {
                break label862;
              }
              paramfa = paramfa.toString();
              paramfa = Util.nullAsNil(j.r(this.XjI).bmp(paramfa));
            }
          }
          bool2 = bool1;
          if (!j.s(this.XjI))
          {
            j.a(this.XjI, true);
            paramfa = new n(j.q(this.XjI), Util.nullAsNil(paramfa));
            j.q(this.XjI).clear();
            com.tencent.mm.kernel.h.aZW().a(1704, new com.tencent.mm.am.h()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
              {
                AppMethodBeat.i(297316);
                if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                {
                  paramAnonymousString = (cfe)c.c.b(paramfa.oDw.otC);
                  if (paramAnonymousString.ytv == 0)
                  {
                    paramAnonymousString = paramAnonymousString.aaoP;
                    paramAnonymousp = new StringBuilder();
                    Iterator localIterator = paramAnonymousString.iterator();
                    while (localIterator.hasNext())
                    {
                      Object localObject = (dax)localIterator.next();
                      String str = ((dax)localObject).uuid + "," + ((dax)localObject).rid;
                      if (j.p(MsgHandler.31.this.XjI).containsKey(str)) {
                        paramAnonymousString = (List)j.p(MsgHandler.31.this.XjI).get(str);
                      }
                      for (;;)
                      {
                        paramAnonymousString.add(localObject);
                        paramAnonymousp.append("{uuid:" + ((dax)localObject).uuid + ",major:" + ((dax)localObject).rid + ",minors:[");
                        paramAnonymousString = ((dax)localObject).aaGs.iterator();
                        while (paramAnonymousString.hasNext())
                        {
                          localObject = (daz)paramAnonymousString.next();
                          paramAnonymousp.append(((daz)localObject).aaGt + "-" + ((daz)localObject).aaGu + ",");
                        }
                        paramAnonymousString = new ArrayList();
                        j.p(MsgHandler.31.this.XjI).put(str, paramAnonymousString);
                      }
                      paramAnonymousp.append("]},");
                    }
                    Log.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + paramAnonymousp.toString());
                  }
                }
                com.tencent.mm.kernel.h.aZW().b(1704, this);
                j.a(MsgHandler.31.this.XjI, false);
                AppMethodBeat.o(297316);
              }
            });
            com.tencent.mm.kernel.h.aZW().a(paramfa, 0);
            bool2 = bool1;
          }
        }
        Log.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check and find] find:%s", new Object[] { String.valueOf(bool2) + "," + str2 });
        for (;;)
        {
          try
          {
            paramfa = (f)j.t(this.XjI).get();
            if (paramfa == null) {
              continue;
            }
            if (bool2)
            {
              Log.i("FindBeaconBug", "find Msghandler");
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("uuid", str1);
              ((Bundle)localObject1).putInt("major", i);
              ((Bundle)localObject1).putInt("minor", j);
              ((Bundle)localObject1).putDouble("accuracy", d2);
              ((Bundle)localObject1).putDouble("rssi", d1);
              ((Bundle)localObject1).putFloat("heading", j.u(this.XjI));
              paramfa.i(40002, (Bundle)localObject1);
            }
          }
          catch (RemoteException paramfa)
          {
            label862:
            label869:
            Log.i("MicroMsg.MsgHandler", "[MsgHandler]callback failure:%s", new Object[] { paramfa.getMessage() });
            continue;
          }
          Log.i("MicroMsg.MsgHandler", "[MsgHandler]result iBeacon = %s,beaconMap.size:%d", new Object[] { j.o(this.XjI).get(str2), Integer.valueOf(j.o(this.XjI).size()) });
          AppMethodBeat.o(297416);
          return false;
          paramfa = "";
          break;
          paramfa = (List)j.p(this.XjI).get(str1 + "," + i);
          bool2 = bool4;
          if (paramfa == null) {
            break label648;
          }
          paramfa = paramfa.iterator();
          bool2 = bool1;
          if (!paramfa.hasNext()) {
            break label648;
          }
          localObject1 = (dax)paramfa.next();
          bool2 = bool1;
          if (localObject1 != null)
          {
            bool2 = bool1;
            if (((dax)localObject1).aaGs != null)
            {
              bool2 = bool1;
              if (!((dax)localObject1).aaGs.isEmpty())
              {
                localObject1 = ((dax)localObject1).aaGs.iterator();
                bool2 = bool1;
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (daz)((Iterator)localObject1).next();
                  if ((j < ((daz)localObject2).aaGt) || (j > ((daz)localObject2).aaGu)) {
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
            break label648;
            Log.i("FindBeaconBug", "callbacker is null");
          }
        }
      }
      bool2 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.MsgHandler.31
 * JD-Core Version:    0.7.0.1
 */