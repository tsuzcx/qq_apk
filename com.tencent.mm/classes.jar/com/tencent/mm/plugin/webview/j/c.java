package com.tencent.mm.plugin.webview.j;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private a CPb;
  Map<String, String> CPc;
  public MutableLiveData<String> CPd;
  public b CPe;
  String appId;
  public String kLZ;
  
  public c()
  {
    AppMethodBeat.i(82376);
    this.CPb = new a((byte)0);
    this.CPc = new HashMap();
    this.CPd = new MutableLiveData();
    this.CPe = b.CPg;
    AppMethodBeat.o(82376);
  }
  
  private void kK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82378);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = this.CPb;
    localg.field_mediaId = paramString2;
    localg.field_fullpath = paramString1;
    localg.field_fileType = a.fqB;
    localg.field_priority = a.fqo;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 200;
    localg.field_bzScene = 2;
    if (!f.aDD().f(localg))
    {
      ac.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString2 });
      this.CPe = b.CPj;
    }
    AppMethodBeat.o(82378);
  }
  
  public final void kJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82377);
    this.appId = paramString2;
    this.kLZ = paramString1;
    this.CPe = b.CPh;
    long l = System.currentTimeMillis();
    paramString2 = com.tencent.mm.an.c.a("vestacountavatar", l, u.ayc().field_username, String.valueOf(l));
    this.CPc.put(bs.nullAsNil(paramString2), paramString1);
    kK(paramString1, paramString2);
    AppMethodBeat.o(82377);
  }
  
  final class a
    implements g.a
  {
    private a() {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(82372);
      ac.d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      paramc = c.this;
      if (paramd != null) {}
      try
      {
        if ((paramd.field_retCode != 0) || (paramInt != 0)) {
          return 0;
        }
        paramString = (String)c.this.CPc.get(paramString);
        if (!c.this.kLZ.equals(paramString))
        {
          ac.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", new Object[] { c.this.kLZ, paramString });
          return 0;
        }
        ac.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", new Object[] { paramd.field_fileUrl });
        paramString = new k(paramd.field_fileUrl, c.this.appId, paramString);
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
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
      CPg = new b("NONE", 0);
      CPh = new b("LOADING", 1);
      CPi = new b("SUCCESS", 2);
      CPj = new b("FAIL", 3);
      CPk = new b[] { CPg, CPh, CPi, CPj };
      AppMethodBeat.o(82375);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.c
 * JD-Core Version:    0.7.0.1
 */