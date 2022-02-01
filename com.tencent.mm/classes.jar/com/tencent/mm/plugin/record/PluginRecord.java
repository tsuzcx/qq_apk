package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.b.i;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.k;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.o;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.plugin.record.b.t;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginRecord
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.record.a.a
{
  private h xqm;
  private com.tencent.mm.plugin.record.a.e xqn;
  private s xqo;
  private j xqp;
  private l xqq;
  private t xqr;
  private com.tencent.mm.sdk.b.c xqs;
  
  public PluginRecord()
  {
    AppMethodBeat.i(9429);
    this.xqo = null;
    this.xqp = null;
    this.xqq = null;
    this.xqr = new t();
    this.xqs = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(9429);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(9430);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = new com.tencent.mm.vfs.e(com.tencent.mm.kernel.g.ajC().gBm + "record/");
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) || (!((com.tencent.mm.vfs.e)localObject).isDirectory()))
    {
      ad.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    AppMethodBeat.o(9430);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(213091);
    if (!paramg.akw())
    {
      AppMethodBeat.o(213091);
      return;
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.record.a.f.class, new l());
    AppMethodBeat.o(213091);
  }
  
  public j getRecordMsgCDNService()
  {
    AppMethodBeat.i(9435);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.xqp == null) {
      this.xqp = new j();
    }
    j localj = this.xqp;
    AppMethodBeat.o(9435);
    return localj;
  }
  
  public com.tencent.mm.plugin.record.a.e getRecordMsgCDNStorage()
  {
    return this.xqn;
  }
  
  public h getRecordMsgInfoStorage()
  {
    return this.xqm;
  }
  
  public s getRecordMsgService()
  {
    AppMethodBeat.i(9434);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.xqo == null) {
      this.xqo = new s();
    }
    s locals = this.xqo;
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
    this.xqm = new o(com.tencent.mm.kernel.g.ajC().gBq);
    this.xqn = new k(com.tencent.mm.kernel.g.ajC().gBq);
    ad.i("MicroMsg.PluginRecord", "on account post reset");
    com.tencent.mm.sdk.b.a.IbL.c(this.xqr);
    com.tencent.mm.sdk.b.a.IbL.c(this.xqs);
    checkDir();
    getRecordMsgService().a(null, false);
    ad.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
    AppMethodBeat.o(9431);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9432);
    ad.d("MicroMsg.PluginRecord", "on account post release");
    com.tencent.mm.sdk.b.a.IbL.d(this.xqr);
    com.tencent.mm.sdk.b.a.IbL.d(this.xqs);
    if (this.xqo != null)
    {
      s locals = this.xqo;
      locals.finish();
      com.tencent.mm.kernel.g.ajB().gAO.b(632, locals);
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locals);
    }
    if (this.xqp != null) {
      this.xqp.finish();
    }
    AppMethodBeat.o(9432);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */