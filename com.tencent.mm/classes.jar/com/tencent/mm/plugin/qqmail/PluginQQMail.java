package com.tencent.mm.plugin.qqmail;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.d.a;
import com.tencent.mm.plugin.qqmail.d.aa;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.d.y;
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
  extends com.tencent.mm.kernel.b.f
  implements c, k
{
  private v Hln;
  private com.tencent.mm.plugin.qqmail.d.ab Hlo;
  private a Hlp;
  
  public PluginQQMail()
  {
    AppMethodBeat.i(122630);
    this.Hlp = new a();
    AppMethodBeat.o(122630);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(122631);
    if (paramg.aIE()) {
      com.tencent.mm.vfs.ab.aE("mailapp", "mailapp", 1);
    }
    AppMethodBeat.o(122631);
  }
  
  public void execute(g paramg) {}
  
  public v getNormalMailAppService()
  {
    AppMethodBeat.i(122632);
    h.aHE().aGH();
    if (this.Hln == null) {
      this.Hln = new v();
    }
    v localv = this.Hln;
    AppMethodBeat.o(122632);
    return localv;
  }
  
  public com.tencent.mm.plugin.qqmail.d.ab getShareModeMailAppService()
  {
    AppMethodBeat.i(122633);
    h.aHE().aGH();
    if (this.Hlo == null) {
      this.Hlo = new com.tencent.mm.plugin.qqmail.d.ab();
    }
    com.tencent.mm.plugin.qqmail.d.ab localab = this.Hlo;
    AppMethodBeat.o(122633);
    return localab;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(122634);
    EventCenter.instance.addListener(this.Hlp);
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122629);
        if (!h.aHB())
        {
          AppMethodBeat.o(122629);
          return;
        }
        long l = System.currentTimeMillis();
        Object localObject = new aa();
        if (((aa)localObject).HmC.ESJ.size() > 0)
        {
          int i = 0;
          while (i < ((aa)localObject).HmC.ESJ.size())
          {
            String str = ((y)((aa)localObject).HmC.ESJ.get(i)).BDX;
            ca localca = new ca();
            localca.Jm("qqmail");
            localca.setCreateTime(bq.RP("qqmail"));
            localca.pJ(0);
            localca.setContent(String.format(MMApplicationContext.getContext().getString(e.i.send_mail_fail_prompt), new Object[] { str }));
            localca.setType(1);
            localca.setStatus(3);
            Log.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((n)h.ae(n.class)).eSe().aM(localca)) });
            i += 1;
          }
          ((aa)localObject).HmC.ESJ.clear();
        }
        try
        {
          localObject = Base64.encodeToString(((aa)localObject).HmC.toByteArray(), 0);
          Log.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { localObject });
          h.aHG().aHp().i(282625, localObject);
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
    v localv = this.Hln;
    if (localv != null) {
      localv.reset();
    }
    EventCenter.instance.removeListener(this.Hlp);
    AppMethodBeat.o(122635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.PluginQQMail
 * JD-Core Version:    0.7.0.1
 */