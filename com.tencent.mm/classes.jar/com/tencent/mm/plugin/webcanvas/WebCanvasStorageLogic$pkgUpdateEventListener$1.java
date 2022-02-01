package com.tencent.mm.plugin.webcanvas;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ael;
import com.tencent.mm.autogen.a.ael.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgDownloadCompleteNotifyEvent;", "callback", "", "event", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebCanvasStorageLogic$pkgUpdateEventListener$1
  extends IListener<ael>
{
  WebCanvasStorageLogic$pkgUpdateEventListener$1(f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(261133);
    AppMethodBeat.o(261133);
  }
  
  private static boolean a(ael paramael)
  {
    AppMethodBeat.i(261154);
    s.u(paramael, "event");
    Log.v("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s, debugType: %s", new Object[] { paramael.ijc.appId, Integer.valueOf(paramael.ijc.eul) });
    if (paramael.ijc.eul != 0)
    {
      AppMethodBeat.o(261154);
      return true;
    }
    String str1 = paramael.ijc.appId;
    if ((!s.p("wxf337cbaa27790d8e", str1)) && (!s.p("wxfedb0854e2b1820d", str1)) && (!s.p("wx97b7aebac2183fd2", str1)))
    {
      localObject = k.WkZ;
      if (!k.ioL().contains(str1))
      {
        AppMethodBeat.o(261154);
        return false;
      }
    }
    Object localObject = (x)h.ax(x.class);
    if (localObject != null) {
      ((x)localObject).bM(str1, paramael.ijc.version);
    }
    Log.i("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s, version=%d, md5=%s", new Object[] { str1, Integer.valueOf(paramael.ijc.version), paramael.ijc.md5 });
    if (str1 != null) {
      switch (str1.hashCode())
      {
      }
    }
    for (;;)
    {
      localObject = j.WkY;
      j.xC(62L);
      label234:
      boolean bool;
      if ((s.p("wxfedb0854e2b1820d", str1)) || (s.p("wx97b7aebac2183fd2", str1)))
      {
        localObject = k.WkZ;
        s.s(str1, "tmpAppId");
        bool = k.aE(str1, paramael.ijc.filePath, paramael.ijc.version);
        label281:
        if (bool)
        {
          localObject = k.WkZ;
          localObject = k.bhW(str1);
          if (!y.ZC((String)localObject)) {
            y.bDX((String)localObject);
          }
          String str2 = (String)localObject + '/' + System.currentTimeMillis() + ".wcpkg";
          y.O(paramael.ijc.filePath, str2, false);
          localObject = new vn();
          ((vn)localObject).appId = str1;
          ((vn)localObject).path = ah.v(new u(str2).jKT());
          ((vn)localObject).version = paramael.ijc.version;
          ((vn)localObject).eul = paramael.ijc.eul;
          ((vn)localObject).md5 = paramael.ijc.md5;
        }
      }
      try
      {
        paramael = k.WkZ;
        k.a(str1, (vn)localObject);
        if (s.p(str1, "wxfedb0854e2b1820d"))
        {
          paramael = j.WkY;
          j.xC(44L);
        }
        for (;;)
        {
          k.ioU().get(str1);
          k.ioU().get(str1);
          AppMethodBeat.o(261154);
          return false;
          if (!str1.equals("wx97b7aebac2183fd2")) {
            break;
          }
          localObject = j.WkY;
          j.xC(61L);
          break label234;
          if (!str1.equals("wxf337cbaa27790d8e")) {
            break;
          }
          localObject = j.WkY;
          j.xC(51L);
          break label234;
          if (!str1.equals("wxfedb0854e2b1820d")) {
            break;
          }
          localObject = j.WkY;
          j.xC(41L);
          break label234;
          localObject = k.b.Wll;
          s.s(str1, "tmpAppId");
          localObject = paramael.ijc.filePath;
          s.s(localObject, "event.data.filePath");
          k.b.nJ(str1, (String)localObject);
          bool = y.ZC(paramael.ijc.filePath);
          break label281;
          if (s.p(str1, "wxf337cbaa27790d8e"))
          {
            paramael = j.WkY;
            j.xC(53L);
          }
        }
      }
      catch (Exception paramael)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebCanvasStorageLogic", s.X("save pkg info fail ", paramael.getMessage()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.WebCanvasStorageLogic.pkgUpdateEventListener.1
 * JD-Core Version:    0.7.0.1
 */