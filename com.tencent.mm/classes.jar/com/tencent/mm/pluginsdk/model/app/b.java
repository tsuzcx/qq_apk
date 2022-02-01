package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import java.util.Map;

public final class b
{
  public int DhK;
  public long DhL;
  public String desc;
  public long hVx;
  public String md5;
  public int size;
  public String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(30998);
    Map localMap = bv.L(paramString, "msg");
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.DhK = bs.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = bs.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.md5 = ((String)localMap.get(".msg.alphainfo.md5"));
    this.DhL = bs.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.hVx = bs.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    ac.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.DhK), this.url, Integer.valueOf(this.size), this.md5, this.desc, Long.valueOf(this.DhL), Long.valueOf(this.hVx) });
    AppMethodBeat.o(30998);
  }
  
  public static b eKS()
  {
    AppMethodBeat.i(30997);
    az.ayM();
    Object localObject = (String)com.tencent.mm.model.c.agA().get(352273, "");
    if (!bs.isNullOrNil((String)localObject))
    {
      localObject = new b((String)localObject);
      if ((!((b)localObject).isValid()) || (((b)localObject).isExpired()))
      {
        eKT();
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
  
  public static void eKT()
  {
    AppMethodBeat.i(31001);
    az.ayM();
    com.tencent.mm.model.c.agA().set(352273, null);
    az.ayM();
    com.tencent.mm.model.c.agA().set(352274, null);
    AppMethodBeat.o(31001);
  }
  
  private static boolean eKW()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(31004);
    if (bs.aLy(g.ZY().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(31004);
      return false;
    }
    az.ayM();
    int i;
    if ((((Integer)com.tencent.mm.model.c.agA().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!ax.isWifi(ai.getContext())) || (i == 0)) {
        break label105;
      }
      label75:
      if ((i.cHa & 0x1) == 0) {
        break label110;
      }
      ac.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
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
      ac.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
    }
  }
  
  private boolean isExpired()
  {
    AppMethodBeat.i(31000);
    az.ayM();
    long l = ((Long)com.tencent.mm.model.c.agA().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.DhL) || (System.currentTimeMillis() > this.hVx)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(31000);
      return bool;
    }
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(30999);
    if ((this.DhK > com.tencent.mm.protocal.d.DIc) && (!bs.isNullOrNil(this.url)) && (!bs.isNullOrNil(this.md5)) && (!bs.isNullOrNil(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(30999);
      return bool;
    }
  }
  
  public final void eKU()
  {
    AppMethodBeat.i(31002);
    bo localbo = new bo();
    localbo.oA(bi.z("weixin", bs.aNx()));
    localbo.setType(1);
    localbo.setContent(this.desc);
    ac.d("MicroMsg.AlphaUpdateInfo", localbo.field_content);
    localbo.jT(0);
    localbo.re("weixin");
    localbo.setStatus(3);
    bi.u(localbo);
    ac.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    eKT();
    AppMethodBeat.o(31002);
  }
  
  public final void eKV()
  {
    AppMethodBeat.i(31003);
    ac.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (isExpired()))
    {
      AppMethodBeat.o(31003);
      return;
    }
    if (!eKW())
    {
      eKU();
      AppMethodBeat.o(31003);
      return;
    }
    ac.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.md5, Integer.valueOf(this.size), this.desc, this.url });
    com.tencent.mm.plugin.q.d.dfa().h(this.md5, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
    AppMethodBeat.o(31003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.b
 * JD-Core Version:    0.7.0.1
 */