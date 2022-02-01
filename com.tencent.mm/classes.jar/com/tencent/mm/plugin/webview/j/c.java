package com.tencent.mm.plugin.webview.j;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private c.a ELv;
  Map<String, String> ELw;
  public MutableLiveData<String> ELx;
  public b ELy;
  String appId;
  public String lmo;
  
  public c()
  {
    AppMethodBeat.i(82376);
    this.ELv = new c.a(this, (byte)0);
    this.ELw = new HashMap();
    this.ELx = new MutableLiveData();
    this.ELy = b.ELA;
    AppMethodBeat.o(82376);
  }
  
  private void lo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82378);
    g localg = new g();
    localg.fLl = "task_VestImgUploadEngine";
    localg.fLm = this.ELv;
    localg.field_mediaId = paramString2;
    localg.field_fullpath = paramString1;
    localg.field_fileType = a.fKM;
    localg.field_priority = a.fKz;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 200;
    localg.field_bzScene = 2;
    if (!f.aGZ().f(localg))
    {
      ae.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString2 });
      this.ELy = b.ELD;
    }
    AppMethodBeat.o(82378);
  }
  
  public final void ln(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82377);
    this.appId = paramString2;
    this.lmo = paramString1;
    this.ELy = b.ELB;
    long l = System.currentTimeMillis();
    paramString2 = com.tencent.mm.an.c.a("vestacountavatar", l, v.aBo().field_username, String.valueOf(l));
    this.ELw.put(bu.nullAsNil(paramString2), paramString1);
    lo(paramString1, paramString2);
    AppMethodBeat.o(82377);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(82375);
      ELA = new b("NONE", 0);
      ELB = new b("LOADING", 1);
      ELC = new b("SUCCESS", 2);
      ELD = new b("FAIL", 3);
      ELE = new b[] { ELA, ELB, ELC, ELD };
      AppMethodBeat.o(82375);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.c
 * JD-Core Version:    0.7.0.1
 */