package com.tencent.mm.plugin.qqmail;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.model.BindQQEventListenerImpl;
import com.tencent.mm.plugin.qqmail.model.aa;
import com.tencent.mm.plugin.qqmail.model.j;
import com.tencent.mm.plugin.qqmail.model.u;
import com.tencent.mm.plugin.qqmail.model.x;
import com.tencent.mm.plugin.qqmail.model.y;
import com.tencent.mm.plugin.qqmail.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.af;
import java.io.IOException;
import java.util.LinkedList;

public class PluginQQMail
  extends com.tencent.mm.kernel.b.f
  implements c, j
{
  private u Nja;
  private aa Njb;
  private BindQQEventListenerImpl Njc;
  
  public PluginQQMail()
  {
    AppMethodBeat.i(122630);
    this.Njc = new BindQQEventListenerImpl();
    AppMethodBeat.o(122630);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(122631);
    if (paramg.bbA()) {
      af.aR("mailapp", "mailapp", 1);
    }
    AppMethodBeat.o(122631);
  }
  
  public void execute(g paramg) {}
  
  public u getNormalMailAppService()
  {
    AppMethodBeat.i(122632);
    h.baC().aZJ();
    if (this.Nja == null) {
      this.Nja = new u();
    }
    u localu = this.Nja;
    AppMethodBeat.o(122632);
    return localu;
  }
  
  public aa getShareModeMailAppService()
  {
    AppMethodBeat.i(122633);
    h.baC().aZJ();
    if (this.Njb == null) {
      this.Njb = new aa();
    }
    aa localaa = this.Njb;
    AppMethodBeat.o(122633);
    return localaa;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(122634);
    this.Njc.alive();
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122629);
        if (!h.baz())
        {
          AppMethodBeat.o(122629);
          return;
        }
        long l = System.currentTimeMillis();
        Object localObject = new z();
        if (((z)localObject).Nkq.KNn.size() > 0)
        {
          int i = 0;
          while (i < ((z)localObject).Nkq.KNn.size())
          {
            String str = ((x)((z)localObject).Nkq.KNn.get(i)).Hox;
            cc localcc = new cc();
            localcc.BS("qqmail");
            localcc.setCreateTime(br.JN("qqmail"));
            localcc.pI(0);
            localcc.setContent(String.format(MMApplicationContext.getContext().getString(e.i.send_mail_fail_prompt), new Object[] { str }));
            localcc.setType(1);
            localcc.setStatus(3);
            Log.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((n)h.ax(n.class)).gaZ().ba(localcc)) });
            i += 1;
          }
          ((z)localObject).Nkq.KNn.clear();
        }
        try
        {
          localObject = Base64.encodeToString(((z)localObject).Nkq.toByteArray(), 0);
          Log.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { localObject });
          h.baE().ban().B(282625, localObject);
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
    u localu = this.Nja;
    if (localu != null) {
      localu.reset();
    }
    this.Njc.dead();
    AppMethodBeat.o(122635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.PluginQQMail
 * JD-Core Version:    0.7.0.1
 */