package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.l;
import com.tencent.mm.f.a.me;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.report.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class k
  implements be
{
  private static HashMap<Integer, h.b> nnH;
  private r.a nnI;
  private IListener sCF;
  
  static
  {
    AppMethodBeat.i(143938);
    HashMap localHashMap = new HashMap();
    nnH = localHashMap;
    localHashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(143938);
  }
  
  public k()
  {
    AppMethodBeat.i(143932);
    this.sCF = new IListener() {};
    AppMethodBeat.o(143932);
  }
  
  public static void O(long paramLong, String paramString)
  {
    AppMethodBeat.i(143936);
    me localme = new me();
    localme.fKg.fKh = paramLong;
    localme.fKg.content = paramString;
    EventCenter.instance.publish(localme);
    AppMethodBeat.o(143936);
  }
  
  public static k fBF()
  {
    AppMethodBeat.i(143935);
    k localk = (k)y.as(k.class);
    AppMethodBeat.o(143935);
    return localk;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(143934);
    long l = System.currentTimeMillis();
    String str = h.aHG().cachePath + "CommonOneMicroMsg.db";
    this.nnI = r.a(hashCode(), str, nnH, false);
    Log.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), Util.getStack() });
    EventCenter.instance.addListener(this.sCF);
    AppMethodBeat.o(143934);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(143933);
    if (fBF() != null)
    {
      k localk = fBF();
      if (localk.nnI != null)
      {
        localk.nnI.xW(localk.hashCode());
        localk.nnI = null;
      }
    }
    EventCenter.instance.removeListener(this.sCF);
    AppMethodBeat.o(143933);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.k
 * JD-Core Version:    0.7.0.1
 */