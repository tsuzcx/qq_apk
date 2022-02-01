package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class b
{
  public int EMv;
  public long EMw;
  public String desc;
  public long ioS;
  public String md5;
  public int size;
  public String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30998);
    Map localMap = bw.M(paramString, "msg");
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.EMv = bt.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = bt.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.md5 = ((String)localMap.get(".msg.alphainfo.md5"));
    this.EMw = bt.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.ioS = bt.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    ad.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.EMv), this.url, Integer.valueOf(this.size), this.md5, this.desc, Long.valueOf(this.EMw), Long.valueOf(this.ioS) });
    AppMethodBeat.o(30998);
  }
  
  public static b eZM()
  {
    AppMethodBeat.i(30997);
    ba.aBQ();
    Object localObject = (String)com.tencent.mm.model.c.ajl().get(352273, "");
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = new b((String)localObject);
      if ((!((b)localObject).isValid()) || (((b)localObject).isExpired()))
      {
        eZN();
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
  
  public static void eZN()
  {
    AppMethodBeat.i(31001);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(352273, null);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(352274, null);
    AppMethodBeat.o(31001);
  }
  
  private static boolean eZQ()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(31004);
    if (bt.aRe(g.acA().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(31004);
      return false;
    }
    ba.aBQ();
    int i;
    if ((((Integer)com.tencent.mm.model.c.ajl().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!ay.isWifi(aj.getContext())) || (i == 0)) {
        break label105;
      }
      label75:
      if ((j.cSe & 0x1) == 0) {
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
  
  private boolean isExpired()
  {
    AppMethodBeat.i(31000);
    ba.aBQ();
    long l = ((Long)com.tencent.mm.model.c.ajl().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.EMw) || (System.currentTimeMillis() > this.ioS)) {}
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
    if ((this.EMv > com.tencent.mm.protocal.d.Fnj) && (!bt.isNullOrNil(this.url)) && (!bt.isNullOrNil(this.md5)) && (!bt.isNullOrNil(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(30999);
      return bool;
    }
  }
  
  public final void eZO()
  {
    AppMethodBeat.i(31002);
    bu localbu = new bu();
    localbu.qA(bj.B("weixin", bt.aQJ()));
    localbu.setType(1);
    localbu.setContent(this.desc);
    ad.d("MicroMsg.AlphaUpdateInfo", localbu.field_content);
    localbu.kr(0);
    localbu.tN("weixin");
    localbu.setStatus(3);
    bj.v(localbu);
    ad.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    eZN();
    AppMethodBeat.o(31002);
  }
  
  public final void eZP()
  {
    AppMethodBeat.i(31003);
    ad.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (isExpired()))
    {
      AppMethodBeat.o(31003);
      return;
    }
    if (!eZQ())
    {
      eZO();
      AppMethodBeat.o(31003);
      return;
    }
    ad.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.md5, Integer.valueOf(this.size), this.desc, this.url });
    com.tencent.mm.plugin.q.d.doy().h(this.md5, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
    AppMethodBeat.o(31003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.b
 * JD-Core Version:    0.7.0.1
 */