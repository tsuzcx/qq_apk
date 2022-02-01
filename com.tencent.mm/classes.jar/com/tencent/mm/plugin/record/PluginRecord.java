package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.po;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.b.i;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.o;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.plugin.record.b.t;
import com.tencent.mm.sdk.platformtools.ae;

public class PluginRecord
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.record.a.a
{
  private h xGj;
  private com.tencent.mm.plugin.record.a.e xGk;
  private s xGl;
  private j xGm;
  private l xGn;
  private t xGo;
  private com.tencent.mm.sdk.b.c xGp;
  
  public PluginRecord()
  {
    AppMethodBeat.i(9429);
    this.xGl = null;
    this.xGm = null;
    this.xGn = null;
    this.xGo = new t();
    this.xGp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(9429);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(9430);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = new com.tencent.mm.vfs.k(com.tencent.mm.kernel.g.ajR().gDT + "record/");
    if ((!((com.tencent.mm.vfs.k)localObject).exists()) || (!((com.tencent.mm.vfs.k)localObject).isDirectory()))
    {
      ae.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.k)localObject).mkdirs();
    }
    AppMethodBeat.o(9430);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(221831);
    if (!paramg.akL())
    {
      AppMethodBeat.o(221831);
      return;
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.record.a.f.class, new l());
    AppMethodBeat.o(221831);
  }
  
  public j getRecordMsgCDNService()
  {
    AppMethodBeat.i(9435);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.xGm == null) {
      this.xGm = new j();
    }
    j localj = this.xGm;
    AppMethodBeat.o(9435);
    return localj;
  }
  
  public com.tencent.mm.plugin.record.a.e getRecordMsgCDNStorage()
  {
    return this.xGk;
  }
  
  public h getRecordMsgInfoStorage()
  {
    return this.xGj;
  }
  
  public s getRecordMsgService()
  {
    AppMethodBeat.i(9434);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.xGl == null) {
      this.xGl = new s();
    }
    s locals = this.xGl;
    AppMethodBeat.o(9434);
    return locals;
  }
  
  public h getRecordMsgStorage()
  {
    AppMethodBeat.i(9433);
    h localh = getRecordMsgInfoStorage();
    AppMethodBeat.o(9433);
    return localh;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(9431);
    this.xGj = new o(com.tencent.mm.kernel.g.ajR().gDX);
    this.xGk = new com.tencent.mm.plugin.record.b.k(com.tencent.mm.kernel.g.ajR().gDX);
    ae.i("MicroMsg.PluginRecord", "on account post reset");
    com.tencent.mm.sdk.b.a.IvT.c(this.xGo);
    com.tencent.mm.sdk.b.a.IvT.c(this.xGp);
    checkDir();
    getRecordMsgService().a(null, false);
    ae.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
    AppMethodBeat.o(9431);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9432);
    ae.d("MicroMsg.PluginRecord", "on account post release");
    com.tencent.mm.sdk.b.a.IvT.d(this.xGo);
    com.tencent.mm.sdk.b.a.IvT.d(this.xGp);
    if (this.xGl != null)
    {
      s locals = this.xGl;
      locals.finish();
      com.tencent.mm.kernel.g.ajQ().gDv.b(632, locals);
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locals);
    }
    if (this.xGm != null) {
      this.xGm.finish();
    }
    AppMethodBeat.o(9432);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */