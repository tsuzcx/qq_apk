package com.tencent.mm.plugin.webview.k;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private a JBm;
  Map<String, String> JBn;
  public MutableLiveData<String> JBo;
  public b JBp;
  String appId;
  public String msl;
  
  public c()
  {
    AppMethodBeat.i(82376);
    this.JBm = new a((byte)0);
    this.JBn = new HashMap();
    this.JBo = new MutableLiveData();
    this.JBp = b.JBr;
    AppMethodBeat.o(82376);
  }
  
  private void mn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82378);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_VestImgUploadEngine";
    localg.gqy = this.JBm;
    localg.field_mediaId = paramString2;
    localg.field_fullpath = paramString1;
    localg.field_fileType = a.gpY;
    localg.field_priority = a.gpL;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 200;
    localg.field_bzScene = 2;
    if (!f.baQ().f(localg))
    {
      Log.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString2 });
      this.JBp = b.JBu;
    }
    AppMethodBeat.o(82378);
  }
  
  public final void mm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82377);
    this.appId = paramString2;
    this.msl = paramString1;
    this.JBp = b.JBs;
    long l = System.currentTimeMillis();
    paramString2 = com.tencent.mm.an.c.a("vestacountavatar", l, z.aUL().field_username, String.valueOf(l));
    this.JBn.put(Util.nullAsNil(paramString2), paramString1);
    mn(paramString1, paramString2);
    AppMethodBeat.o(82377);
  }
  
  final class a
    implements g.a
  {
    private a() {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(82372);
      Log.d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      paramc = c.this;
      if (paramd != null) {}
      try
      {
        if ((paramd.field_retCode != 0) || (paramInt != 0)) {
          return 0;
        }
        paramString = (String)c.this.JBn.get(paramString);
        if (!c.this.msl.equals(paramString))
        {
          Log.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", new Object[] { c.this.msl, paramString });
          return 0;
        }
        Log.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", new Object[] { paramd.field_fileUrl });
        paramString = new k(paramd.field_fileUrl, c.this.appId, paramString);
        com.tencent.mm.kernel.g.azz().a(paramString, 0);
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
      JBr = new b("NONE", 0);
      JBs = new b("LOADING", 1);
      JBt = new b("SUCCESS", 2);
      JBu = new b("FAIL", 3);
      JBv = new b[] { JBr, JBs, JBt, JBu };
      AppMethodBeat.o(82375);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.c
 * JD-Core Version:    0.7.0.1
 */