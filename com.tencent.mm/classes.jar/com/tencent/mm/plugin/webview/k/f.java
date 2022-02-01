package com.tencent.mm.plugin.webview.k;

import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b;
import com.tencent.mm.aq.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private f.a QzQ;
  Map<String, String> QzR;
  public r<String> QzS;
  public b QzT;
  String appId;
  public String pqt;
  
  public f()
  {
    AppMethodBeat.i(82376);
    this.QzQ = new f.a(this, (byte)0);
    this.QzR = new HashMap();
    this.QzS = new r();
    this.QzT = b.QzV;
    AppMethodBeat.o(82376);
  }
  
  private void mO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82378);
    g localg = new g();
    localg.taskName = "task_VestImgUploadEngine";
    localg.iUG = this.QzQ;
    localg.field_mediaId = paramString2;
    localg.field_fullpath = paramString1;
    localg.field_fileType = a.iUg;
    localg.field_priority = a.iTT;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 200;
    localg.field_bzScene = 2;
    if (!com.tencent.mm.aq.f.bkg().f(localg))
    {
      Log.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString2 });
      this.QzT = b.QzY;
    }
    AppMethodBeat.o(82378);
  }
  
  public final void mN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82377);
    this.appId = paramString2;
    this.pqt = paramString1;
    this.QzT = b.QzW;
    long l = System.currentTimeMillis();
    paramString2 = c.a("vestacountavatar", l, z.bdN().field_username, String.valueOf(l));
    this.QzR.put(Util.nullAsNil(paramString2), paramString1);
    mO(paramString1, paramString2);
    AppMethodBeat.o(82377);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(82375);
      QzV = new b("NONE", 0);
      QzW = new b("LOADING", 1);
      QzX = new b("SUCCESS", 2);
      QzY = new b("FAIL", 3);
      QzZ = new b[] { QzV, QzW, QzX, QzY };
      AppMethodBeat.o(82375);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.f
 * JD-Core Version:    0.7.0.1
 */