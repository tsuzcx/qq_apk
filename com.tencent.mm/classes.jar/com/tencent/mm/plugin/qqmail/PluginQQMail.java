package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.b;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.plugin.qqmail.b.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.LinkedList;

public class PluginQQMail
  extends f
  implements c, com.tencent.mm.plugin.qqmail.b.o
{
  private w uKF;
  private ac uKG;
  private b uKH;
  
  public PluginQQMail()
  {
    AppMethodBeat.i(122630);
    this.uKH = new b();
    AppMethodBeat.o(122630);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(122631);
    if (paramg.agu()) {
      com.tencent.mm.vfs.o.i("mailapp", "mailapp", 3, true);
    }
    AppMethodBeat.o(122631);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public w getNormalMailAppService()
  {
    AppMethodBeat.i(122632);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.uKF == null) {
      this.uKF = new w(d.CpK, d.glX);
    }
    w localw = this.uKF;
    AppMethodBeat.o(122632);
    return localw;
  }
  
  public ac getShareModeMailAppService()
  {
    AppMethodBeat.i(122633);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.uKG == null) {
      this.uKG = new ac();
    }
    ac localac = this.uKG;
    AppMethodBeat.o(122633);
    return localac;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(122634);
    com.tencent.mm.sdk.b.a.ESL.c(this.uKH);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122629);
        if (!com.tencent.mm.kernel.g.afw())
        {
          AppMethodBeat.o(122629);
          return;
        }
        long l = System.currentTimeMillis();
        z localz = new z();
        if (localz.uMo.tvP.size() > 0)
        {
          int i = 0;
          while (i < localz.uMo.tvP.size())
          {
            z.akZ(((x)localz.uMo.tvP.get(i)).uLh);
            i += 1;
          }
          localz.uMo.tvP.clear();
          localz.save();
        }
        ad.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(122629);
      }
    });
    AppMethodBeat.o(122634);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(122635);
    w localw = this.uKF;
    if (localw != null) {
      localw.reset();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.uKH);
    AppMethodBeat.o(122635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.PluginQQMail
 * JD-Core Version:    0.7.0.1
 */