package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class a
{
  public String cqq;
  public int cxH;
  public String desc;
  public long fSm;
  public int size;
  public String url;
  public long vKR;
  
  public a(String paramString)
  {
    AppMethodBeat.i(27305);
    Map localMap = br.F(paramString, "msg");
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.cxH = bo.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = bo.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.cqq = ((String)localMap.get(".msg.alphainfo.md5"));
    this.vKR = bo.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.fSm = bo.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    ab.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.cxH), this.url, Integer.valueOf(this.size), this.cqq, this.desc, Long.valueOf(this.vKR), Long.valueOf(this.fSm) });
    AppMethodBeat.o(27305);
  }
  
  public static a dlr()
  {
    AppMethodBeat.i(27304);
    aw.aaz();
    Object localObject = (String)com.tencent.mm.model.c.Ru().get(352273, "");
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = new a((String)localObject);
      if ((!((a)localObject).isValid()) || (((a)localObject).isExpired()))
      {
        dls();
        AppMethodBeat.o(27304);
        return null;
      }
    }
    else
    {
      AppMethodBeat.o(27304);
      return null;
    }
    AppMethodBeat.o(27304);
    return localObject;
  }
  
  public static void dls()
  {
    AppMethodBeat.i(27308);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(352273, null);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(352274, null);
    AppMethodBeat.o(27308);
  }
  
  private static boolean dlv()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(27311);
    if (bo.apV(com.tencent.mm.m.g.Nq().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(27311);
      return false;
    }
    aw.aaz();
    int i;
    if ((((Integer)com.tencent.mm.model.c.Ru().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!at.isWifi(ah.getContext())) || (i == 0)) {
        break label105;
      }
      label75:
      if ((com.tencent.mm.sdk.platformtools.g.bWw & 0x1) == 0) {
        break label110;
      }
      ab.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(27311);
      return bool1;
      i = 0;
      break;
      label105:
      bool1 = false;
      break label75;
      label110:
      ab.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
    }
  }
  
  private boolean isExpired()
  {
    AppMethodBeat.i(27307);
    aw.aaz();
    long l = ((Long)com.tencent.mm.model.c.Ru().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.vKR) || (System.currentTimeMillis() > this.fSm)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(27307);
      return bool;
    }
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(27306);
    if ((this.cxH > com.tencent.mm.protocal.d.whH) && (!bo.isNullOrNil(this.url)) && (!bo.isNullOrNil(this.cqq)) && (!bo.isNullOrNil(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(27306);
      return bool;
    }
  }
  
  public final void dlt()
  {
    AppMethodBeat.i(27309);
    bi localbi = new bi();
    localbi.fQ(bf.x("weixin", bo.aox()));
    localbi.setType(1);
    localbi.setContent(this.desc);
    ab.d("MicroMsg.AlphaUpdateInfo", localbi.field_content);
    localbi.hL(0);
    localbi.kj("weixin");
    localbi.setStatus(3);
    bf.l(localbi);
    ab.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    dls();
    AppMethodBeat.o(27309);
  }
  
  public final void dlu()
  {
    AppMethodBeat.i(27310);
    ab.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (isExpired()))
    {
      AppMethodBeat.o(27310);
      return;
    }
    if (!dlv())
    {
      dlt();
      AppMethodBeat.o(27310);
      return;
    }
    ab.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.cqq, Integer.valueOf(this.size), this.desc, this.url });
    com.tencent.mm.plugin.p.d.bSu().e(this.cqq, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
    AppMethodBeat.o(27310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.a
 * JD-Core Version:    0.7.0.1
 */