package com.tencent.mm.plugin.webview.j;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.c.au;
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
  private a BwT;
  Map<String, String> BwU;
  public MutableLiveData<String> BwV;
  public b BwW;
  String appId;
  public String kkH;
  
  public c()
  {
    AppMethodBeat.i(82376);
    this.BwT = new a((byte)0);
    this.BwU = new HashMap();
    this.BwV = new MutableLiveData();
    this.BwW = b.BwY;
    AppMethodBeat.o(82376);
  }
  
  private void ko(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82378);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fnH = this.BwT;
    localg.field_mediaId = paramString2;
    localg.field_fullpath = paramString1;
    localg.field_fileType = a.fnh;
    localg.field_priority = a.fmU;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 200;
    localg.field_bzScene = 2;
    if (!f.awL().e(localg))
    {
      ad.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString2 });
      this.BwW = b.Bxb;
    }
    AppMethodBeat.o(82378);
  }
  
  public final void kn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82377);
    this.appId = paramString2;
    this.kkH = paramString1;
    this.BwW = b.BwZ;
    long l = System.currentTimeMillis();
    paramString2 = com.tencent.mm.ao.c.a("vestacountavatar", l, u.arm().field_username, String.valueOf(l));
    this.BwU.put(bt.nullAsNil(paramString2), paramString1);
    ko(paramString1, paramString2);
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
        paramString = (String)c.this.BwU.get(paramString);
        if (!c.this.kkH.equals(paramString))
        {
          ad.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", new Object[] { c.this.kkH, paramString });
          return 0;
        }
        ad.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", new Object[] { paramd.field_fileUrl });
        paramString = new k(paramd.field_fileUrl, c.this.appId, paramString);
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
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
      BwY = new b("NONE", 0);
      BwZ = new b("LOADING", 1);
      Bxa = new b("SUCCESS", 2);
      Bxb = new b("FAIL", 3);
      Bxc = new b[] { BwY, BwZ, Bxa, Bxb };
      AppMethodBeat.o(82375);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.c
 * JD-Core Version:    0.7.0.1
 */