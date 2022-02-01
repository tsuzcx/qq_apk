package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.b.i;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.k;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public class PluginRecord
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, c, com.tencent.mm.plugin.record.a.a
{
  private h BGi;
  private com.tencent.mm.plugin.record.a.e BGj;
  private s BGk;
  private j BGl;
  private l BGm;
  private com.tencent.mm.plugin.record.b.t BGn;
  private IListener BGo;
  
  public PluginRecord()
  {
    AppMethodBeat.i(9429);
    this.BGk = null;
    this.BGl = null;
    this.BGm = null;
    this.BGn = new com.tencent.mm.plugin.record.b.t();
    this.BGo = new IListener() {};
    AppMethodBeat.o(9429);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(9430);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    localObject = new com.tencent.mm.vfs.o(com.tencent.mm.kernel.g.aAh().hqG + "record/");
    if ((!((com.tencent.mm.vfs.o)localObject).exists()) || (!((com.tencent.mm.vfs.o)localObject).isDirectory()))
    {
      Log.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
      ((com.tencent.mm.vfs.o)localObject).mkdirs();
    }
    AppMethodBeat.o(9430);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(215178);
    y.at("record", "record", 19);
    AppMethodBeat.o(215178);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(215179);
    if (!paramg.aBb())
    {
      AppMethodBeat.o(215179);
      return;
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.record.a.f.class, new l());
    AppMethodBeat.o(215179);
  }
  
  public j getRecordMsgCDNService()
  {
    AppMethodBeat.i(9435);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.BGl == null) {
      this.BGl = new j();
    }
    j localj = this.BGl;
    AppMethodBeat.o(9435);
    return localj;
  }
  
  public com.tencent.mm.plugin.record.a.e getRecordMsgCDNStorage()
  {
    return this.BGj;
  }
  
  public h getRecordMsgInfoStorage()
  {
    return this.BGi;
  }
  
  public s getRecordMsgService()
  {
    AppMethodBeat.i(9434);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.BGk == null) {
      this.BGk = new s();
    }
    s locals = this.BGk;
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
    this.BGi = new com.tencent.mm.plugin.record.b.o(com.tencent.mm.kernel.g.aAh().hqK);
    this.BGj = new k(com.tencent.mm.kernel.g.aAh().hqK);
    Log.i("MicroMsg.PluginRecord", "on account post reset");
    EventCenter.instance.addListener(this.BGn);
    EventCenter.instance.addListener(this.BGo);
    checkDir();
    getRecordMsgService().a(null, false);
    Log.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
    AppMethodBeat.o(9431);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(9432);
    Log.d("MicroMsg.PluginRecord", "on account post release");
    EventCenter.instance.removeListener(this.BGn);
    EventCenter.instance.removeListener(this.BGo);
    if (this.BGk != null)
    {
      s locals = this.BGk;
      locals.finish();
      com.tencent.mm.kernel.g.aAg().hqi.b(632, locals);
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locals);
    }
    if (this.BGl != null) {
      this.BGl.finish();
    }
    AppMethodBeat.o(9432);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */