package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.i;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.b.r;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginRecord
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.record.a.a
{
  private com.tencent.mm.plugin.record.a.g uZP;
  private com.tencent.mm.plugin.record.a.e uZQ;
  private com.tencent.mm.plugin.record.b.q uZR;
  private i uZS;
  private r uZT;
  private com.tencent.mm.sdk.b.c uZU;
  
  public PluginRecord()
  {
    AppMethodBeat.i(9429);
    this.uZR = null;
    this.uZS = null;
    this.uZT = new r();
    this.uZU = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(9429);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(9430);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.afB().gcW + "record/");
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) || (!((com.tencent.mm.vfs.e)localObject).isDirectory()))
    {
      ad.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    AppMethodBeat.o(9430);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public i getRecordMsgCDNService()
  {
    AppMethodBeat.i(9435);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.uZS == null) {
      this.uZS = new i();
    }
    i locali = this.uZS;
    AppMethodBeat.o(9435);
    return locali;
  }
  
  public com.tencent.mm.plugin.record.a.e getRecordMsgCDNStorage()
  {
    return this.uZQ;
  }
  
  public com.tencent.mm.plugin.record.a.g getRecordMsgInfoStorage()
  {
    return this.uZP;
  }
  
  public com.tencent.mm.plugin.record.b.q getRecordMsgService()
  {
    AppMethodBeat.i(9434);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.uZR == null) {
      this.uZR = new com.tencent.mm.plugin.record.b.q();
    }
    com.tencent.mm.plugin.record.b.q localq = this.uZR;
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
    this.uZP = new m(com.tencent.mm.kernel.g.afB().gda);
    this.uZQ = new j(com.tencent.mm.kernel.g.afB().gda);
    ad.i("MicroMsg.PluginRecord", "on account post reset");
    com.tencent.mm.sdk.b.a.ESL.c(this.uZT);
    com.tencent.mm.sdk.b.a.ESL.c(this.uZU);
    checkDir();
    getRecordMsgService().a(null, false);
    ad.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
    AppMethodBeat.o(9431);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9432);
    ad.d("MicroMsg.PluginRecord", "on account post release");
    com.tencent.mm.sdk.b.a.ESL.d(this.uZT);
    com.tencent.mm.sdk.b.a.ESL.d(this.uZU);
    if (this.uZR != null)
    {
      com.tencent.mm.plugin.record.b.q localq = this.uZR;
      localq.finish();
      com.tencent.mm.kernel.g.afA().gcy.b(632, localq);
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localq);
    }
    if (this.uZS != null) {
      this.uZS.finish();
    }
    AppMethodBeat.o(9432);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */