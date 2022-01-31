package com.tencent.mm.plugin.webview.f;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  String appId;
  public String hZV;
  private a vtO;
  Map<String, String> vtP;
  public MutableLiveData<String> vtQ;
  public b vtR;
  
  public b()
  {
    AppMethodBeat.i(10136);
    this.vtO = new a((byte)0);
    this.vtP = new HashMap();
    this.vtQ = new MutableLiveData();
    this.vtR = b.vtT;
    AppMethodBeat.o(10136);
  }
  
  private void hF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10138);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.edp = this.vtO;
    localg.field_mediaId = paramString2;
    localg.field_fullpath = paramString1;
    localg.field_fileType = a.ecQ;
    localg.field_priority = a.ecE;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 200;
    localg.field_bzScene = 2;
    if (!f.afO().e(localg))
    {
      ab.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString2 });
      this.vtR = b.vtW;
    }
    AppMethodBeat.o(10138);
  }
  
  public final void hE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10137);
    this.appId = paramString2;
    this.hZV = paramString1;
    this.vtR = b.vtU;
    long l = System.currentTimeMillis();
    paramString2 = com.tencent.mm.al.c.a("vestacountavatar", l, r.ZS().field_username, String.valueOf(l));
    this.vtP.put(bo.nullAsNil(paramString2), paramString1);
    hF(paramString1, paramString2);
    AppMethodBeat.o(10137);
  }
  
  final class a
    implements g.a
  {
    private a() {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(10132);
      ab.d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      paramc = b.this;
      if (paramd != null) {}
      try
      {
        if ((paramd.field_retCode != 0) || (paramInt != 0)) {
          return 0;
        }
        paramString = (String)b.this.vtP.get(paramString);
        if (!b.this.hZV.equals(paramString))
        {
          ab.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", new Object[] { b.this.hZV, paramString });
          return 0;
        }
        ab.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", new Object[] { paramd.field_fileUrl });
        paramString = new i(paramd.field_fileUrl, b.this.appId, paramString);
        com.tencent.mm.kernel.g.Rc().a(paramString, 0);
        return 0;
      }
      finally
      {
        AppMethodBeat.o(10132);
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] l(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(10135);
      vtT = new b("NONE", 0);
      vtU = new b("LOADING", 1);
      vtV = new b("SUCCESS", 2);
      vtW = new b("FAIL", 3);
      vtX = new b[] { vtT, vtU, vtV, vtW };
      AppMethodBeat.o(10135);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.b
 * JD-Core Version:    0.7.0.1
 */