package com.tencent.mm.plugin.qqmail;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.qqmail.d.aa;
import com.tencent.mm.plugin.qqmail.d.ab;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.d.y;
import com.tencent.mm.plugin.qqmail.d.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.LinkedList;

public class PluginQQMail
  extends f
  implements c, k
{
  private v xqR;
  private ab xqS;
  private com.tencent.mm.plugin.qqmail.d.a xqT;
  
  public PluginQQMail()
  {
    AppMethodBeat.i(122630);
    this.xqT = new com.tencent.mm.plugin.qqmail.d.a();
    AppMethodBeat.o(122630);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(122631);
    if (paramg.akL()) {
      u.ap("mailapp", "mailapp", 3);
    }
    AppMethodBeat.o(122631);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public v getNormalMailAppService()
  {
    AppMethodBeat.i(122632);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.xqR == null) {
      this.xqR = new v();
    }
    v localv = this.xqR;
    AppMethodBeat.o(122632);
    return localv;
  }
  
  public ab getShareModeMailAppService()
  {
    AppMethodBeat.i(122633);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.xqS == null) {
      this.xqS = new ab();
    }
    ab localab = this.xqS;
    AppMethodBeat.o(122633);
    return localab;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(122634);
    com.tencent.mm.sdk.b.a.IvT.c(this.xqT);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122629);
        if (!com.tencent.mm.kernel.g.ajM())
        {
          AppMethodBeat.o(122629);
          return;
        }
        long l = System.currentTimeMillis();
        Object localObject = new aa();
        if (((aa)localObject).xsf.vTm.size() > 0)
        {
          int i = 0;
          while (i < ((aa)localObject).xsf.vTm.size())
          {
            String str = ((y)((aa)localObject).xsf.vTm.get(i)).xrr;
            bv localbv = new bv();
            localbv.ui("qqmail");
            localbv.qN(bl.BQ("qqmail"));
            localbv.kt(0);
            localbv.setContent(String.format(ak.getContext().getString(2131763061), new Object[] { str }));
            localbv.setType(1);
            localbv.setStatus(3);
            ae.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", new Object[] { Long.valueOf(((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ar(localbv)) });
            i += 1;
          }
          ((aa)localObject).xsf.vTm.clear();
        }
        try
        {
          localObject = Base64.encodeToString(((aa)localObject).xsf.toByteArray(), 0);
          ae.d("MicroMsg.ShareMailInfoMgr", "save %s", new Object[] { localObject });
          com.tencent.mm.kernel.g.ajR().ajA().set(282625, localObject);
          ae.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(122629);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localIOException, "", new Object[0]);
            ae.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
          }
        }
      }
    });
    AppMethodBeat.o(122634);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(122635);
    v localv = this.xqR;
    if (localv != null) {
      localv.reset();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.xqT);
    AppMethodBeat.o(122635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.PluginQQMail
 * JD-Core Version:    0.7.0.1
 */