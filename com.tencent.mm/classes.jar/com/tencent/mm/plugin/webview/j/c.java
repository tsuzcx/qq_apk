package com.tencent.mm.plugin.webview.j;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private a Etb;
  Map<String, String> Etc;
  public MutableLiveData<String> Etd;
  public b Ete;
  String appId;
  public String liC;
  
  public c()
  {
    AppMethodBeat.i(82376);
    this.Etb = new a((byte)0);
    this.Etc = new HashMap();
    this.Etd = new MutableLiveData();
    this.Ete = b.Etg;
    AppMethodBeat.o(82376);
  }
  
  private void lh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82378);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_VestImgUploadEngine";
    localg.fJj = this.Etb;
    localg.field_mediaId = paramString2;
    localg.field_fullpath = paramString1;
    localg.field_fileType = a.fII;
    localg.field_priority = a.fIv;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 200;
    localg.field_bzScene = 2;
    if (!f.aGI().f(localg))
    {
      ad.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString2 });
      this.Ete = b.Etj;
    }
    AppMethodBeat.o(82378);
  }
  
  public final void lg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82377);
    this.appId = paramString2;
    this.liC = paramString1;
    this.Ete = b.Eth;
    long l = System.currentTimeMillis();
    paramString2 = com.tencent.mm.ao.c.a("vestacountavatar", l, u.aAY().field_username, String.valueOf(l));
    this.Etc.put(bt.nullAsNil(paramString2), paramString1);
    lh(paramString1, paramString2);
    AppMethodBeat.o(82377);
  }
  
  final class a
    implements g.a
  {
    private a() {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(82372);
      ad.d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      paramc = c.this;
      if (paramd != null) {}
      try
      {
        if ((paramd.field_retCode != 0) || (paramInt != 0)) {
          return 0;
        }
        paramString = (String)c.this.Etc.get(paramString);
        if (!c.this.liC.equals(paramString))
        {
          ad.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", new Object[] { c.this.liC, paramString });
          return 0;
        }
        ad.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", new Object[] { paramd.field_fileUrl });
        paramString = new k(paramd.field_fileUrl, c.this.appId, paramString);
        com.tencent.mm.kernel.g.aiU().a(paramString, 0);
        return 0;
      }
      finally
      {
        AppMethodBeat.o(82372);
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(82375);
      Etg = new b("NONE", 0);
      Eth = new b("LOADING", 1);
      Eti = new b("SUCCESS", 2);
      Etj = new b("FAIL", 3);
      Etk = new b[] { Etg, Eth, Eti, Etj };
      AppMethodBeat.o(82375);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.c
 * JD-Core Version:    0.7.0.1
 */