package com.tencent.mm.plugin.record;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.st;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.model.RecordOperationListener;
import com.tencent.mm.plugin.record.model.j;
import com.tencent.mm.plugin.record.model.k;
import com.tencent.mm.plugin.record.model.l;
import com.tencent.mm.plugin.record.model.m;
import com.tencent.mm.plugin.record.model.p;
import com.tencent.mm.plugin.record.model.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.u;

public class PluginRecord
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, a
{
  private com.tencent.mm.plugin.record.a.h NzP;
  private e NzQ;
  private t NzR;
  private k NzS;
  private m NzT;
  private RecordOperationListener NzU;
  private IListener NzV;
  
  public PluginRecord()
  {
    AppMethodBeat.i(9429);
    this.NzR = null;
    this.NzS = null;
    this.NzT = null;
    this.NzU = new RecordOperationListener();
    this.NzV = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(9429);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(9430);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = new u(com.tencent.mm.kernel.h.baE().mCJ + "record/");
    if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory()))
    {
      Log.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
      ((u)localObject).jKY();
    }
    AppMethodBeat.o(9430);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(305272);
    af.aR("record", "record", 147);
    AppMethodBeat.o(305272);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(305274);
    if (!paramg.bbA())
    {
      AppMethodBeat.o(305274);
      return;
    }
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.record.a.f.class, new m());
    AppMethodBeat.o(305274);
  }
  
  public k getRecordMsgCDNService()
  {
    AppMethodBeat.i(9435);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.NzS == null) {
      this.NzS = new k();
    }
    k localk = this.NzS;
    AppMethodBeat.o(9435);
    return localk;
  }
  
  public e getRecordMsgCDNStorage()
  {
    return this.NzQ;
  }
  
  public com.tencent.mm.plugin.record.a.h getRecordMsgInfoStorage()
  {
    return this.NzP;
  }
  
  public t getRecordMsgService()
  {
    AppMethodBeat.i(9434);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.NzR == null) {
      this.NzR = new t();
    }
    t localt = this.NzR;
    AppMethodBeat.o(9434);
    return localt;
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
    this.NzP = new p(com.tencent.mm.kernel.h.baE().mCN);
    this.NzQ = new l(com.tencent.mm.kernel.h.baE().mCN);
    Log.i("MicroMsg.PluginRecord", "on account post reset");
    this.NzU.alive();
    this.NzV.alive();
    checkDir();
    getRecordMsgService().a(null, false);
    Log.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
    AppMethodBeat.o(9431);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9432);
    Log.d("MicroMsg.PluginRecord", "on account post release");
    this.NzU.dead();
    this.NzV.dead();
    if (this.NzR != null)
    {
      t localt = this.NzR;
      localt.finish();
      com.tencent.mm.kernel.h.baD().mCm.b(632, localt);
      ((a)com.tencent.mm.kernel.h.az(a.class)).getRecordMsgCDNStorage().b(localt);
    }
    if (this.NzS != null) {
      this.NzS.finish();
    }
    AppMethodBeat.o(9432);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */