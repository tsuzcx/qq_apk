package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.i;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.b.q;
import com.tencent.mm.plugin.record.b.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public class PluginRecord
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.record.a.a
{
  private com.tencent.mm.plugin.record.a.g pXW;
  private com.tencent.mm.plugin.record.a.e pXX;
  private q pXY;
  private i pXZ;
  private r pYa;
  private com.tencent.mm.sdk.b.c pYb;
  
  public PluginRecord()
  {
    AppMethodBeat.i(135610);
    this.pXY = null;
    this.pXZ = null;
    this.pYa = new r();
    this.pYb = new PluginRecord.1(this);
    AppMethodBeat.o(135610);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(135611);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = new File(com.tencent.mm.kernel.g.RL().eHR + "record/");
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      ab.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
      ((File)localObject).mkdirs();
    }
    AppMethodBeat.o(135611);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public i getRecordMsgCDNService()
  {
    AppMethodBeat.i(135616);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.pXZ == null) {
      this.pXZ = new i();
    }
    i locali = this.pXZ;
    AppMethodBeat.o(135616);
    return locali;
  }
  
  public com.tencent.mm.plugin.record.a.e getRecordMsgCDNStorage()
  {
    return this.pXX;
  }
  
  public com.tencent.mm.plugin.record.a.g getRecordMsgInfoStorage()
  {
    return this.pXW;
  }
  
  public q getRecordMsgService()
  {
    AppMethodBeat.i(135615);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.pXY == null) {
      this.pXY = new q();
    }
    q localq = this.pXY;
    AppMethodBeat.o(135615);
    return localq;
  }
  
  public com.tencent.mm.plugin.record.a.g getRecordMsgStorage()
  {
    AppMethodBeat.i(135614);
    com.tencent.mm.plugin.record.a.g localg = getRecordMsgInfoStorage();
    AppMethodBeat.o(135614);
    return localg;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(135612);
    this.pXW = new m(com.tencent.mm.kernel.g.RL().eHS);
    this.pXX = new j(com.tencent.mm.kernel.g.RL().eHS);
    ab.i("MicroMsg.PluginRecord", "on account post reset");
    com.tencent.mm.sdk.b.a.ymk.c(this.pYa);
    com.tencent.mm.sdk.b.a.ymk.c(this.pYb);
    checkDir();
    getRecordMsgService().a(null, false);
    ab.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
    AppMethodBeat.o(135612);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(135613);
    ab.d("MicroMsg.PluginRecord", "on account post release");
    com.tencent.mm.sdk.b.a.ymk.d(this.pYa);
    com.tencent.mm.sdk.b.a.ymk.d(this.pYb);
    if (this.pXY != null)
    {
      q localq = this.pXY;
      localq.finish();
      com.tencent.mm.kernel.g.RK().eHt.b(632, localq);
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localq);
    }
    if (this.pXZ != null) {
      this.pXZ.finish();
    }
    AppMethodBeat.o(135613);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */