package com.tencent.mm.plugin.qqmail;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.qqmail.d.aa;
import com.tencent.mm.plugin.qqmail.d.ab;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.d.y;
import com.tencent.mm.plugin.qqmail.d.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.LinkedList;

public class PluginQQMail
  extends f
  implements c, k
{
  private v xba;
  private ab xbb;
  private com.tencent.mm.plugin.qqmail.d.a xbc;
  
  public PluginQQMail()
  {
    AppMethodBeat.i(122630);
    this.xbc = new com.tencent.mm.plugin.qqmail.d.a();
    AppMethodBeat.o(122630);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(122631);
    if (paramg.akw()) {
      o.an("mailapp", "mailapp", 3);
    }
    AppMethodBeat.o(122631);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public v getNormalMailAppService()
  {
    AppMethodBeat.i(122632);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.xba == null) {
      this.xba = new v();
    }
    v localv = this.xba;
    AppMethodBeat.o(122632);
    return localv;
  }
  
  public ab getShareModeMailAppService()
  {
    AppMethodBeat.i(122633);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.xbb == null) {
      this.xbb = new ab();
    }
    ab localab = this.xbb;
    AppMethodBeat.o(122633);
    return localab;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(122634);
    com.tencent.mm.sdk.b.a.IbL.c(this.xbc);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122629);
        if (!com.tencent.mm.kernel.g.ajx())
        {
          AppMethodBeat.o(122629);
          return;
        }
        long l = System.currentTimeMillis();
        Object localObject = new aa();
        if (((aa)localObject).xco.vHi.size() > 0)
        {
          int i = 0;
          while (i < ((aa)localObject).xco.vHi.size())
          {
            String str = ((y)((aa)localObject).xco.vHi.get(i)).xbA;
            bu localbu = new bu();
            localbu.tN("qqmail");
            localbu.qA(bj.Bo("qqmail"));
            localbu.kr(0);
            localbu.setContent(String.format(aj.getContext().getString(2131763061), new Object[] { str }));
            localbu.setType(1);
            localbu.setStatus(3);
            ad.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as(localbu)) });
            i += 1;
          }
          ((aa)localObject).xco.vHi.clear();
        }
        try
        {
          localObject = Base64.encodeToString(((aa)localObject).xco.toByteArray(), 0);
          ad.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { localObject });
          com.tencent.mm.kernel.g.ajC().ajl().set(282625, localObject);
          ad.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(122629);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localIOException, "", new Object[0]);
            ad.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
          }
        }
      }
    });
    AppMethodBeat.o(122634);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(122635);
    v localv = this.xba;
    if (localv != null) {
      localv.reset();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.xbc);
    AppMethodBeat.o(122635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.PluginQQMail
 * JD-Core Version:    0.7.0.1
 */