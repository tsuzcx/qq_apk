package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class b
{
  public long QVX;
  public String desc;
  public int lZO;
  public long mcX;
  public String md5;
  public int size;
  public String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30998);
    Map localMap = XmlParser.parseXml(paramString, "msg", null);
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.lZO = Util.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = Util.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.md5 = ((String)localMap.get(".msg.alphainfo.md5"));
    this.QVX = Util.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.mcX = Util.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    Log.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.lZO), this.url, Integer.valueOf(this.size), this.md5, this.desc, Long.valueOf(this.QVX), Long.valueOf(this.mcX) });
    AppMethodBeat.o(30998);
  }
  
  public static b hhn()
  {
    AppMethodBeat.i(30997);
    bh.beI();
    Object localObject = (String)com.tencent.mm.model.c.aHp().b(352273, "");
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = new b((String)localObject);
      if ((!((b)localObject).isValid()) || (((b)localObject).isExpired()))
      {
        hho();
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
  
  public static void hho()
  {
    AppMethodBeat.i(31001);
    bh.beI();
    com.tencent.mm.model.c.aHp().i(352273, null);
    bh.beI();
    com.tencent.mm.model.c.aHp().i(352274, null);
    AppMethodBeat.o(31001);
  }
  
  private static boolean hhr()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(31004);
    if (Util.safeParseInt(h.axc().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(31004);
      return false;
    }
    bh.beI();
    int i;
    if ((((Integer)com.tencent.mm.model.c.aHp().b(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (i == 0)) {
        break label105;
      }
      label75:
      if ((ChannelUtil.updateMode & 0x1) == 0) {
        break label110;
      }
      Log.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
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
      Log.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
    }
  }
  
  private boolean isExpired()
  {
    AppMethodBeat.i(31000);
    bh.beI();
    long l = ((Long)com.tencent.mm.model.c.aHp().b(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.QVX) || (System.currentTimeMillis() > this.mcX)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(31000);
      return bool;
    }
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(30999);
    if ((this.lZO > com.tencent.mm.protocal.d.RAD) && (!Util.isNullOrNil(this.url)) && (!Util.isNullOrNil(this.md5)) && (!Util.isNullOrNil(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(30999);
      return bool;
    }
  }
  
  public final void hhp()
  {
    AppMethodBeat.i(31002);
    ca localca = new ca();
    localca.setCreateTime(bq.z("weixin", Util.nowSecond()));
    localca.setType(1);
    localca.setContent(this.desc);
    Log.d("MicroMsg.AlphaUpdateInfo", Util.secPrint(localca.field_content));
    localca.pJ(0);
    localca.Jm("weixin");
    localca.setStatus(3);
    bq.z(localca);
    Log.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    hho();
    AppMethodBeat.o(31002);
  }
  
  public final void hhq()
  {
    AppMethodBeat.i(31003);
    Log.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (isExpired()))
    {
      AppMethodBeat.o(31003);
      return;
    }
    if (!hhr())
    {
      hhp();
      AppMethodBeat.o(31003);
      return;
    }
    Log.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.md5, Integer.valueOf(this.size), this.desc, this.url });
    com.tencent.mm.plugin.y.d.eUZ().k(this.md5, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
    AppMethodBeat.o(31003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.b
 * JD-Core Version:    0.7.0.1
 */