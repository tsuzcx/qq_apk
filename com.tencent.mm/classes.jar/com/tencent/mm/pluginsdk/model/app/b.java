package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import java.util.Map;

public final class b
{
  public int BPw;
  public long BPx;
  public String desc;
  public long huV;
  public String md5;
  public int size;
  public String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30998);
    Map localMap = bw.K(paramString, "msg");
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.BPw = bt.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = bt.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.md5 = ((String)localMap.get(".msg.alphainfo.md5"));
    this.BPx = bt.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.huV = bt.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    ad.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.BPw), this.url, Integer.valueOf(this.size), this.md5, this.desc, Long.valueOf(this.BPx), Long.valueOf(this.huV) });
    AppMethodBeat.o(30998);
  }
  
  private static boolean evC()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(31004);
    if (bt.aGh(g.Zd().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(31004);
      return false;
    }
    az.arV();
    int i;
    if ((((Integer)com.tencent.mm.model.c.afk().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!ay.isWifi(aj.getContext())) || (i == 0)) {
        break label105;
      }
      label75:
      if ((i.cJT & 0x1) == 0) {
        break label110;
      }
      ad.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
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
      ad.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
    }
  }
  
  public static b evy()
  {
    AppMethodBeat.i(30997);
    az.arV();
    Object localObject = (String)com.tencent.mm.model.c.afk().get(352273, "");
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = new b((String)localObject);
      if ((!((b)localObject).isValid()) || (((b)localObject).isExpired()))
      {
        evz();
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
  
  public static void evz()
  {
    AppMethodBeat.i(31001);
    az.arV();
    com.tencent.mm.model.c.afk().set(352273, null);
    az.arV();
    com.tencent.mm.model.c.afk().set(352274, null);
    AppMethodBeat.o(31001);
  }
  
  private boolean isExpired()
  {
    AppMethodBeat.i(31000);
    az.arV();
    long l = ((Long)com.tencent.mm.model.c.afk().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.BPx) || (System.currentTimeMillis() > this.huV)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(31000);
      return bool;
    }
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(30999);
    if ((this.BPw > com.tencent.mm.protocal.d.CpK) && (!bt.isNullOrNil(this.url)) && (!bt.isNullOrNil(this.md5)) && (!bt.isNullOrNil(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(30999);
      return bool;
    }
  }
  
  public final void evA()
  {
    AppMethodBeat.i(31002);
    bl localbl = new bl();
    localbl.kY(bi.y("weixin", bt.aGK()));
    localbl.setType(1);
    localbl.setContent(this.desc);
    ad.d("MicroMsg.AlphaUpdateInfo", localbl.field_content);
    localbl.jV(0);
    localbl.nY("weixin");
    localbl.setStatus(3);
    bi.u(localbl);
    ad.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    evz();
    AppMethodBeat.o(31002);
  }
  
  public final void evB()
  {
    AppMethodBeat.i(31003);
    ad.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (isExpired()))
    {
      AppMethodBeat.o(31003);
      return;
    }
    if (!evC())
    {
      evA();
      AppMethodBeat.o(31003);
      return;
    }
    ad.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.md5, Integer.valueOf(this.size), this.desc, this.url });
    com.tencent.mm.plugin.q.d.cRq().e(this.md5, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
    AppMethodBeat.o(31003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.b
 * JD-Core Version:    0.7.0.1
 */