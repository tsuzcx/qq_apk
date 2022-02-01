package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
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
  implements bd
{
  private static HashMap<Integer, h.b> kvw;
  private r.a kvx;
  private IListener ptp;
  
  static
  {
    AppMethodBeat.i(143938);
    HashMap localHashMap = new HashMap();
    kvw = localHashMap;
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
    this.ptp = new IListener() {};
    AppMethodBeat.o(143932);
  }
  
  public static void G(long paramLong, String paramString)
  {
    AppMethodBeat.i(143936);
    ln localln = new ln();
    localln.dQQ.dQR = paramLong;
    localln.dQQ.content = paramString;
    EventCenter.instance.publish(localln);
    AppMethodBeat.o(143936);
  }
  
  public static k eOK()
  {
    AppMethodBeat.i(143935);
    k localk = (k)y.at(k.class);
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
    String str = g.aAh().cachePath + "CommonOneMicroMsg.db";
    this.kvx = r.a(hashCode(), str, kvw, false);
    Log.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), Util.getStack() });
    EventCenter.instance.addListener(this.ptp);
    AppMethodBeat.o(143934);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(143933);
    if (eOK() != null)
    {
      k localk = eOK();
      if (localk.kvx != null)
      {
        localk.kvx.uS(localk.hashCode());
        localk.kvx = null;
      }
    }
    EventCenter.instance.removeListener(this.ptp);
    AppMethodBeat.o(143933);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.k
 * JD-Core Version:    0.7.0.1
 */