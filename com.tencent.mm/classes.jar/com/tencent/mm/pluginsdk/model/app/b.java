package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class b
{
  public long XRU;
  public String desc;
  public String md5;
  public long ofU;
  public int qvp;
  public int size;
  public String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30998);
    Map localMap = XmlParser.parseXml(paramString, "msg", null);
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.qvp = Util.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = Util.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.md5 = ((String)localMap.get(".msg.alphainfo.md5"));
    this.XRU = Util.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.ofU = Util.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    Log.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.qvp), this.url, Integer.valueOf(this.size), this.md5, this.desc, Long.valueOf(this.XRU), Long.valueOf(this.ofU) });
    AppMethodBeat.o(30998);
  }
  
  public static b iIn()
  {
    AppMethodBeat.i(30997);
    bh.bCz();
    Object localObject = (String)com.tencent.mm.model.c.ban().d(352273, "");
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = new b((String)localObject);
      if ((!((b)localObject).isValid()) || (((b)localObject).isExpired()))
      {
        iIo();
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
  
  public static void iIo()
  {
    AppMethodBeat.i(31001);
    bh.bCz();
    com.tencent.mm.model.c.ban().B(352273, null);
    bh.bCz();
    com.tencent.mm.model.c.ban().B(352274, null);
    AppMethodBeat.o(31001);
  }
  
  private static boolean iIr()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(31004);
    if (Util.safeParseInt(i.aRC().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(31004);
      return false;
    }
    bh.bCz();
    int i;
    if ((((Integer)com.tencent.mm.model.c.ban().d(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
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
    bh.bCz();
    long l = ((Long)com.tencent.mm.model.c.ban().d(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.XRU) || (System.currentTimeMillis() > this.ofU)) {}
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
    if ((this.qvp > com.tencent.mm.protocal.d.Yxh) && (!Util.isNullOrNil(this.url)) && (!Util.isNullOrNil(this.md5)) && (!Util.isNullOrNil(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(30999);
      return bool;
    }
  }
  
  public final void iIp()
  {
    AppMethodBeat.i(31002);
    cc localcc = new cc();
    localcc.setCreateTime(br.D("weixin", Util.nowSecond()));
    localcc.setType(1);
    localcc.setContent(this.desc);
    Log.d("MicroMsg.AlphaUpdateInfo", Util.secPrint(localcc.field_content));
    localcc.pI(0);
    localcc.BS("weixin");
    localcc.setStatus(3);
    br.B(localcc);
    Log.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    iIo();
    AppMethodBeat.o(31002);
  }
  
  public final void iIq()
  {
    AppMethodBeat.i(31003);
    Log.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (isExpired()))
    {
      AppMethodBeat.o(31003);
      return;
    }
    if (!iIr())
    {
      iIp();
      AppMethodBeat.o(31003);
      return;
    }
    Log.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.md5, Integer.valueOf(this.size), this.desc, this.url });
    com.tencent.mm.plugin.y.d.gdL().h(this.md5, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
    AppMethodBeat.o(31003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.b
 * JD-Core Version:    0.7.0.1
 */