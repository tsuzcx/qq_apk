package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abe;
import com.tencent.mm.g.a.abe.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgDownloadCompleteNotifyEvent;", "callback", "", "event", "webview-sdk_release"})
public final class m$g
  extends IListener<abe>
{
  private static boolean a(abe paramabe)
  {
    boolean bool = true;
    AppMethodBeat.i(224710);
    p.h(paramabe, "event");
    Log.v("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s", new Object[] { paramabe.eiw.appId });
    if (paramabe.eiw.eix != 0)
    {
      AppMethodBeat.o(224710);
      return true;
    }
    str = paramabe.eiw.appId;
    Object localObject1;
    if (((p.j("wxf337cbaa27790d8e", str) ^ true)) && ((p.j("wxfedb0854e2b1820d", str) ^ true)) && ((p.j("wx97b7aebac2183fd2", str) ^ true)))
    {
      localObject1 = m.IAG;
      if (!m.fWI().contains(str))
      {
        AppMethodBeat.o(224710);
        return false;
      }
    }
    Log.i("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s, version=%d, md5=%s", new Object[] { str, Integer.valueOf(paramabe.eiw.version), paramabe.eiw.md5 });
    label167:
    label207:
    Object localObject2;
    if (str == null)
    {
      localObject1 = l.IAx;
      l.LV(62L);
      if ((!p.j("wxfedb0854e2b1820d", str)) && (!p.j("wx97b7aebac2183fd2", str))) {
        break label556;
      }
      bool = m.a(m.IAG, str, paramabe.eiw.filePath, paramabe.eiw.version);
      if (bool)
      {
        localObject1 = new StringBuilder();
        localObject2 = m.IAG;
        localObject1 = m.fWG() + '/' + str;
        if (!s.YS((String)localObject1)) {
          s.boN((String)localObject1);
        }
        localObject2 = (String)localObject1 + '/' + System.currentTimeMillis() + ".wcpkg";
        s.nw(paramabe.eiw.filePath, (String)localObject2);
        localObject1 = new tu();
        ((tu)localObject1).appId = str;
        ((tu)localObject1).path = new o((String)localObject2).getAbsolutePath();
        ((tu)localObject1).version = paramabe.eiw.version;
        ((tu)localObject1).eix = paramabe.eiw.eix;
        ((tu)localObject1).md5 = paramabe.eiw.md5;
      }
    }
    for (;;)
    {
      try
      {
        paramabe = m.IAG;
        paramabe = m.fWT();
        localObject2 = m.IAG;
        p.g(str, "tmpAppId");
        paramabe.encode(m.aWD(str), ((tu)localObject1).toByteArray());
        int i = str.hashCode();
        switch (i)
        {
        }
      }
      catch (Exception paramabe)
      {
        label556:
        Log.e("MicroMsg.WebCanvasStorageLogic", "save pkg info fail " + paramabe.getMessage());
        continue;
        if (!str.equals("wxfedb0854e2b1820d")) {
          continue;
        }
        paramabe = l.IAx;
        l.LV(44L);
        continue;
      }
      AppMethodBeat.o(224710);
      return false;
      switch (str.hashCode())
      {
      default: 
        break;
      case -1635202514: 
        if (!str.equals("wx97b7aebac2183fd2")) {
          break;
        }
        localObject1 = l.IAx;
        l.LV(61L);
        break;
      case -215862887: 
        if (!str.equals("wxf337cbaa27790d8e")) {
          break;
        }
        localObject1 = l.IAx;
        l.LV(51L);
        break;
      case -1154368401: 
        if (!str.equals("wxfedb0854e2b1820d")) {
          break;
        }
        localObject1 = l.IAx;
        l.LV(41L);
        break label167;
        h.CyF.a(20780, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        break label207;
        if (str.equals("wxf337cbaa27790d8e"))
        {
          paramabe = l.IAx;
          l.LV(53L);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.m.g
 * JD-Core Version:    0.7.0.1
 */