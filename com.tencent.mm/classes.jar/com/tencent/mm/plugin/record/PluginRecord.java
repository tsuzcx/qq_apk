package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.re;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.b.i;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.k;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.o;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.q;

public class PluginRecord
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, a
{
  private com.tencent.mm.plugin.record.a.h HCm;
  private e HCn;
  private s HCo;
  private j HCp;
  private l HCq;
  private com.tencent.mm.plugin.record.b.t HCr;
  private IListener HCs;
  
  public PluginRecord()
  {
    AppMethodBeat.i(9429);
    this.HCo = null;
    this.HCp = null;
    this.HCq = null;
    this.HCr = new com.tencent.mm.plugin.record.b.t();
    this.HCs = new IListener() {};
    AppMethodBeat.o(9429);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(9430);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = new q(com.tencent.mm.kernel.h.aHG().kcB + "record/");
    if ((!((q)localObject).ifE()) || (!((q)localObject).isDirectory()))
    {
      Log.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
      ((q)localObject).ifL();
    }
    AppMethodBeat.o(9430);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(210531);
    ab.aE("record", "record", 147);
    AppMethodBeat.o(210531);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(210532);
    if (!paramg.aIE())
    {
      AppMethodBeat.o(210532);
      return;
    }
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.record.a.f.class, new l());
    AppMethodBeat.o(210532);
  }
  
  public j getRecordMsgCDNService()
  {
    AppMethodBeat.i(9435);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.HCp == null) {
      this.HCp = new j();
    }
    j localj = this.HCp;
    AppMethodBeat.o(9435);
    return localj;
  }
  
  public e getRecordMsgCDNStorage()
  {
    return this.HCn;
  }
  
  public com.tencent.mm.plugin.record.a.h getRecordMsgInfoStorage()
  {
    return this.HCm;
  }
  
  public s getRecordMsgService()
  {
    AppMethodBeat.i(9434);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.HCo == null) {
      this.HCo = new s();
    }
    s locals = this.HCo;
    AppMethodBeat.o(9434);
    return locals;
  }
  
  public com.tencent.mm.plugin.record.a.h getRecordMsgStorage()
  {
    AppMethodBeat.i(9433);
    com.tencent.mm.plugin.record.a.h localh = getRecordMsgInfoStorage();
    AppMethodBeat.o(9433);
    return localh;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(9431);
    this.HCm = new o(com.tencent.mm.kernel.h.aHG().kcF);
    this.HCn = new k(com.tencent.mm.kernel.h.aHG().kcF);
    Log.i("MicroMsg.PluginRecord", "on account post reset");
    EventCenter.instance.addListener(this.HCr);
    EventCenter.instance.addListener(this.HCs);
    checkDir();
    getRecordMsgService().a(null, false);
    Log.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
    AppMethodBeat.o(9431);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9432);
    Log.d("MicroMsg.PluginRecord", "on account post release");
    EventCenter.instance.removeListener(this.HCr);
    EventCenter.instance.removeListener(this.HCs);
    if (this.HCo != null)
    {
      s locals = this.HCo;
      locals.finish();
      com.tencent.mm.kernel.h.aHF().kcd.b(632, locals);
      ((a)com.tencent.mm.kernel.h.ag(a.class)).getRecordMsgCDNStorage().b(locals);
    }
    if (this.HCp != null) {
      this.HCp.finish();
    }
    AppMethodBeat.o(9432);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */