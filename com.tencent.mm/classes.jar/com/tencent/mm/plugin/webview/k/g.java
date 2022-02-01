package com.tencent.mm.plugin.webview.k;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private g.a XsK;
  Map<String, String> XsL;
  public x<String> XsM;
  public b XsN;
  String appId;
  public String svg;
  
  public g()
  {
    AppMethodBeat.i(82376);
    this.XsK = new g.a(this, (byte)0);
    this.XsL = new HashMap();
    this.XsM = new x();
    this.XsN = b.XsP;
    AppMethodBeat.o(82376);
  }
  
  private void oE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82378);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_VestImgUploadEngine";
    localg.lwL = this.XsK;
    localg.field_mediaId = paramString2;
    localg.field_fullpath = paramString1;
    localg.field_fileType = a.lwl;
    localg.field_priority = a.lvY;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 200;
    localg.field_bzScene = 2;
    if (!k.bHW().g(localg))
    {
      Log.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString2 });
      this.XsN = b.XsS;
    }
    AppMethodBeat.o(82378);
  }
  
  public final void oD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82377);
    this.appId = paramString2;
    this.svg = paramString1;
    this.XsN = b.XsQ;
    long l = System.currentTimeMillis();
    paramString2 = h.a("vestacountavatar", l, z.bBF().field_username, String.valueOf(l));
    this.XsL.put(Util.nullAsNil(paramString2), paramString1);
    oE(paramString1, paramString2);
    AppMethodBeat.o(82377);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(82375);
      XsP = new b("NONE", 0);
      XsQ = new b("LOADING", 1);
      XsR = new b("SUCCESS", 2);
      XsS = new b("FAIL", 3);
      XsT = new b[] { XsP, XsQ, XsR, XsS };
      AppMethodBeat.o(82375);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.g
 * JD-Core Version:    0.7.0.1
 */