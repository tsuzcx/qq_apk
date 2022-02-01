package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.qqmail.b.b;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.plugin.qqmail.b.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;

public class PluginQQMail
  extends f
  implements c, com.tencent.mm.plugin.qqmail.b.o
{
  private w vTw;
  private com.tencent.mm.plugin.qqmail.b.ac vTx;
  private b vTy;
  
  public PluginQQMail()
  {
    AppMethodBeat.i(122630);
    this.vTy = new b();
    AppMethodBeat.o(122630);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(122631);
    if (paramg.ahL()) {
      com.tencent.mm.vfs.o.aj("mailapp", "mailapp", 3);
    }
    AppMethodBeat.o(122631);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public w getNormalMailAppService()
  {
    AppMethodBeat.i(122632);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.vTw == null) {
      this.vTw = new w(d.DIc, d.gMK);
    }
    w localw = this.vTw;
    AppMethodBeat.o(122632);
    return localw;
  }
  
  public com.tencent.mm.plugin.qqmail.b.ac getShareModeMailAppService()
  {
    AppMethodBeat.i(122633);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.vTx == null) {
      this.vTx = new com.tencent.mm.plugin.qqmail.b.ac();
    }
    com.tencent.mm.plugin.qqmail.b.ac localac = this.vTx;
    AppMethodBeat.o(122633);
    return localac;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(122634);
    com.tencent.mm.sdk.b.a.GpY.c(this.vTy);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122629);
        if (!com.tencent.mm.kernel.g.agM())
        {
          AppMethodBeat.o(122629);
          return;
        }
        long l = System.currentTimeMillis();
        z localz = new z();
        if (localz.vVe.uEi.size() > 0)
        {
          int i = 0;
          while (i < localz.vVe.uEi.size())
          {
            z.apY(((x)localz.vVe.uEi.get(i)).vTY);
            i += 1;
          }
          localz.vVe.uEi.clear();
          localz.save();
        }
        com.tencent.mm.sdk.platformtools.ac.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(122629);
      }
    });
    AppMethodBeat.o(122634);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(122635);
    w localw = this.vTw;
    if (localw != null) {
      localw.reset();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.vTy);
    AppMethodBeat.o(122635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.PluginQQMail
 * JD-Core Version:    0.7.0.1
 */