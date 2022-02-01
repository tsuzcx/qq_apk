package com.tencent.mm.plugin.qqmail;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.qqmail.d.aa;
import com.tencent.mm.plugin.qqmail.d.ab;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.d.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.util.LinkedList;

public class PluginQQMail
  extends f
  implements c, k
{
  private v BqU;
  private ab BqV;
  private com.tencent.mm.plugin.qqmail.d.a BqW;
  
  public PluginQQMail()
  {
    AppMethodBeat.i(122630);
    this.BqW = new com.tencent.mm.plugin.qqmail.d.a();
    AppMethodBeat.o(122630);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(122631);
    if (paramg.aBb()) {
      com.tencent.mm.vfs.y.at("mailapp", "mailapp", 3);
    }
    AppMethodBeat.o(122631);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public v getNormalMailAppService()
  {
    AppMethodBeat.i(122632);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.BqU == null) {
      this.BqU = new v();
    }
    v localv = this.BqU;
    AppMethodBeat.o(122632);
    return localv;
  }
  
  public ab getShareModeMailAppService()
  {
    AppMethodBeat.i(122633);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.BqV == null) {
      this.BqV = new ab();
    }
    ab localab = this.BqV;
    AppMethodBeat.o(122633);
    return localab;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(122634);
    EventCenter.instance.addListener(this.BqW);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122629);
        if (!com.tencent.mm.kernel.g.aAc())
        {
          AppMethodBeat.o(122629);
          return;
        }
        long l = System.currentTimeMillis();
        Object localObject = new aa();
        if (((aa)localObject).Bsj.zns.size() > 0)
        {
          int i = 0;
          while (i < ((aa)localObject).Bsj.zns.size())
          {
            String str = ((com.tencent.mm.plugin.qqmail.d.y)((aa)localObject).Bsj.zns.get(i)).Bru;
            ca localca = new ca();
            localca.Cy("qqmail");
            localca.setCreateTime(bp.Kw("qqmail"));
            localca.nv(0);
            localca.setContent(String.format(MMApplicationContext.getContext().getString(2131765212), new Object[] { str }));
            localca.setType(1);
            localca.setStatus(3);
            Log.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aC(localca)) });
            i += 1;
          }
          ((aa)localObject).Bsj.zns.clear();
        }
        try
        {
          localObject = Base64.encodeToString(((aa)localObject).Bsj.toByteArray(), 0);
          Log.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { localObject });
          com.tencent.mm.kernel.g.aAh().azQ().set(282625, localObject);
          Log.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(122629);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localIOException, "", new Object[0]);
            Log.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
          }
        }
      }
    });
    AppMethodBeat.o(122634);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(122635);
    v localv = this.BqU;
    if (localv != null) {
      localv.reset();
    }
    EventCenter.instance.removeListener(this.BqW);
    AppMethodBeat.o(122635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.PluginQQMail
 * JD-Core Version:    0.7.0.1
 */