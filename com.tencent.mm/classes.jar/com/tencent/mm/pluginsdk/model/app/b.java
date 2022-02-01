package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class b
{
  public long FeT;
  public String desc;
  public int ioL;
  public long irN;
  public String md5;
  public int size;
  public String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30998);
    Map localMap = bx.M(paramString, "msg");
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.ioL = bu.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = bu.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.md5 = ((String)localMap.get(".msg.alphainfo.md5"));
    this.FeT = bu.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.irN = bu.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    ae.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.ioL), this.url, Integer.valueOf(this.size), this.md5, this.desc, Long.valueOf(this.FeT), Long.valueOf(this.irN) });
    AppMethodBeat.o(30998);
  }
  
  public static b fdA()
  {
    AppMethodBeat.i(30997);
    bc.aCg();
    Object localObject = (String)com.tencent.mm.model.c.ajA().get(352273, "");
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = new b((String)localObject);
      if ((!((b)localObject).isValid()) || (((b)localObject).isExpired()))
      {
        fdB();
        AppMethodBeat.o(30997);
        return null;
      }
    }
    else
    {
      AppMethodBeat.o(30997);
      return null;
    }
    AppMethodBeat.o(30997);
    return localObject;
  }
  
  public static void fdB()
  {
    AppMethodBeat.i(31001);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(352273, null);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(352274, null);
    AppMethodBeat.o(31001);
  }
  
  private static boolean fdE()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(31004);
    if (bu.aSB(g.acL().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(31004);
      return false;
    }
    bc.aCg();
    int i;
    if ((((Integer)com.tencent.mm.model.c.ajA().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!az.isWifi(ak.getContext())) || (i == 0)) {
        break label105;
      }
      label75:
      if ((k.cSO & 0x1) == 0) {
        break label110;
      }
      ae.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(31004);
      return bool1;
      i = 0;
      break;
      label105:
      bool1 = false;
      break label75;
      label110:
      ae.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
    }
  }
  
  private boolean isExpired()
  {
    AppMethodBeat.i(31000);
    bc.aCg();
    long l = ((Long)com.tencent.mm.model.c.ajA().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.FeT) || (System.currentTimeMillis() > this.irN)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(31000);
      return bool;
    }
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(30999);
    if ((this.ioL > com.tencent.mm.protocal.d.FFH) && (!bu.isNullOrNil(this.url)) && (!bu.isNullOrNil(this.md5)) && (!bu.isNullOrNil(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(30999);
      return bool;
    }
  }
  
  public final void fdC()
  {
    AppMethodBeat.i(31002);
    bv localbv = new bv();
    localbv.qN(bl.B("weixin", bu.aRi()));
    localbv.setType(1);
    localbv.setContent(this.desc);
    ae.d("MicroMsg.AlphaUpdateInfo", localbv.field_content);
    localbv.kt(0);
    localbv.ui("weixin");
    localbv.setStatus(3);
    bl.v(localbv);
    ae.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    fdB();
    AppMethodBeat.o(31002);
  }
  
  public final void fdD()
  {
    AppMethodBeat.i(31003);
    ae.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (isExpired()))
    {
      AppMethodBeat.o(31003);
      return;
    }
    if (!fdE())
    {
      fdC();
      AppMethodBeat.o(31003);
      return;
    }
    ae.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.md5, Integer.valueOf(this.size), this.desc, this.url });
    com.tencent.mm.plugin.q.d.drw().h(this.md5, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
    AppMethodBeat.o(31003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.b
 * JD-Core Version:    0.7.0.1
 */