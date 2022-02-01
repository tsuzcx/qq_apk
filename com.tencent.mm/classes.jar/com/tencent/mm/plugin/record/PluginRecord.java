package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.i;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.b.r;
import com.tencent.mm.sdk.platformtools.ac;

public class PluginRecord
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.record.a.a
{
  private com.tencent.mm.plugin.record.a.g wiD;
  private com.tencent.mm.plugin.record.a.e wiE;
  private com.tencent.mm.plugin.record.b.q wiF;
  private i wiG;
  private r wiH;
  private com.tencent.mm.sdk.b.c wiI;
  
  public PluginRecord()
  {
    AppMethodBeat.i(9429);
    this.wiF = null;
    this.wiG = null;
    this.wiH = new r();
    this.wiI = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(9429);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(9430);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.agR().ghC + "record/");
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) || (!((com.tencent.mm.vfs.e)localObject).isDirectory()))
    {
      ac.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    AppMethodBeat.o(9430);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public i getRecordMsgCDNService()
  {
    AppMethodBeat.i(9435);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.wiG == null) {
      this.wiG = new i();
    }
    i locali = this.wiG;
    AppMethodBeat.o(9435);
    return locali;
  }
  
  public com.tencent.mm.plugin.record.a.e getRecordMsgCDNStorage()
  {
    return this.wiE;
  }
  
  public com.tencent.mm.plugin.record.a.g getRecordMsgInfoStorage()
  {
    return this.wiD;
  }
  
  public com.tencent.mm.plugin.record.b.q getRecordMsgService()
  {
    AppMethodBeat.i(9434);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.wiF == null) {
      this.wiF = new com.tencent.mm.plugin.record.b.q();
    }
    com.tencent.mm.plugin.record.b.q localq = this.wiF;
    AppMethodBeat.o(9434);
    return localq;
  }
  
  public com.tencent.mm.plugin.record.a.g getRecordMsgStorage()
  {
    AppMethodBeat.i(9433);
    com.tencent.mm.plugin.record.a.g localg = getRecordMsgInfoStorage();
    AppMethodBeat.o(9433);
    return localg;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(9431);
    this.wiD = new m(com.tencent.mm.kernel.g.agR().ghG);
    this.wiE = new j(com.tencent.mm.kernel.g.agR().ghG);
    ac.i("MicroMsg.PluginRecord", "on account post reset");
    com.tencent.mm.sdk.b.a.GpY.c(this.wiH);
    com.tencent.mm.sdk.b.a.GpY.c(this.wiI);
    checkDir();
    getRecordMsgService().a(null, false);
    ac.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
    AppMethodBeat.o(9431);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9432);
    ac.d("MicroMsg.PluginRecord", "on account post release");
    com.tencent.mm.sdk.b.a.GpY.d(this.wiH);
    com.tencent.mm.sdk.b.a.GpY.d(this.wiI);
    if (this.wiF != null)
    {
      com.tencent.mm.plugin.record.b.q localq = this.wiF;
      localq.finish();
      com.tencent.mm.kernel.g.agQ().ghe.b(632, localq);
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localq);
    }
    if (this.wiG != null) {
      this.wiG.finish();
    }
    AppMethodBeat.o(9432);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */