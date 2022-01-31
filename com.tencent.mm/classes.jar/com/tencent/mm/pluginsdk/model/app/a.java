package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class a
{
  public String bIW;
  public int bQo;
  public String desc;
  public long eCv;
  public long rTW;
  public int size;
  public String url;
  
  public a(String paramString)
  {
    Map localMap = bn.s(paramString, "msg");
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.bQo = bk.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = bk.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.bIW = ((String)localMap.get(".msg.alphainfo.md5"));
    this.rTW = bk.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.eCv = bk.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    y.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.bQo), this.url, Integer.valueOf(this.size), this.bIW, this.desc, Long.valueOf(this.rTW), Long.valueOf(this.eCv) });
  }
  
  private boolean caB()
  {
    au.Hx();
    long l = ((Long)com.tencent.mm.model.c.Dz().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.rTW) || (System.currentTimeMillis() > this.eCv)) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static a ckJ()
  {
    au.Hx();
    Object localObject = (String)com.tencent.mm.model.c.Dz().get(352273, "");
    if (!bk.bl((String)localObject))
    {
      localObject = new a((String)localObject);
      if ((!((a)localObject).isValid()) || (((a)localObject).caB()))
      {
        ckK();
        return null;
      }
    }
    else
    {
      return null;
    }
    return localObject;
  }
  
  public static void ckK()
  {
    au.Hx();
    com.tencent.mm.model.c.Dz().o(352273, null);
    au.Hx();
    com.tencent.mm.model.c.Dz().o(352274, null);
  }
  
  private boolean isValid()
  {
    if ((this.bQo > com.tencent.mm.protocal.d.spa) && (!bk.bl(this.url)) && (!bk.bl(this.bIW)) && (!bk.bl(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public final void ckL()
  {
    bi localbi = new bi();
    localbi.bg(bd.o("weixin", bk.UX()));
    localbi.setType(1);
    localbi.setContent(this.desc);
    y.d("MicroMsg.AlphaUpdateInfo", localbi.field_content);
    localbi.fA(0);
    localbi.ec("weixin");
    localbi.setStatus(3);
    bd.h(localbi);
    y.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    ckK();
  }
  
  public final void ckM()
  {
    y.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (caB())) {
      return;
    }
    int i;
    if (bk.ZR(g.AA().getValue("SilentDownloadApkAtWiFi")) != 0) {
      i = 0;
    }
    while (i == 0)
    {
      ckL();
      return;
      au.Hx();
      if ((((Integer)com.tencent.mm.model.c.Dz().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        i = 1;
        label77:
        if ((!aq.isWifi(ae.getContext())) || (i == 0)) {
          break label118;
        }
      }
      label118:
      for (i = 1;; i = 0)
      {
        if ((com.tencent.mm.sdk.platformtools.e.bvl & 0x1) == 0) {
          break label123;
        }
        y.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
        i = 0;
        break;
        i = 0;
        break label77;
      }
      label123:
      y.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
    }
    y.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.bIW, Integer.valueOf(this.size), this.desc, this.url });
    com.tencent.mm.plugin.w.d.bkt().e(this.bIW, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.a
 * JD-Core Version:    0.7.0.1
 */