package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.o;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.report.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class k
  implements be
{
  private static HashMap<Integer, h.b> qkO;
  private o.a qkP;
  private IListener vIz;
  
  static
  {
    AppMethodBeat.i(143938);
    HashMap localHashMap = new HashMap();
    qkO = localHashMap;
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
    this.vIz = new SubCoreReport.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(143932);
  }
  
  public static void ad(long paramLong, String paramString)
  {
    AppMethodBeat.i(143936);
    nk localnk = new nk();
    localnk.hPM.hPN = paramLong;
    localnk.hPM.content = paramString;
    localnk.publish();
    AppMethodBeat.o(143936);
  }
  
  public static k gNY()
  {
    AppMethodBeat.i(143935);
    k localk = (k)y.aL(k.class);
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
    String str = h.baE().cachePath + "CommonOneMicroMsg.db";
    this.qkP = o.a(hashCode(), str, qkO, false);
    Log.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l), Util.getStack() });
    this.vIz.alive();
    AppMethodBeat.o(143934);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(143933);
    if (gNY() != null)
    {
      k localk = gNY();
      if (localk.qkP != null)
      {
        localk.qkP.yb(localk.hashCode());
        localk.qkP = null;
      }
    }
    this.vIz.dead();
    AppMethodBeat.o(143933);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.k
 * JD-Core Version:    0.7.0.1
 */