package com.tencent.mm.ui.contact.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b.a;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/MvvmAddressUIReporter;", "", "()V", "onCreateStartTime", "", "getOnCreateStartTime", "()J", "setOnCreateStartTime", "(J)V", "reportSessionId", "", "getReportSessionId", "()Ljava/lang/String;", "setReportSessionId", "(Ljava/lang/String;)V", "reportType", "getReportType", "setReportType", "onCreateBefore", "", "report", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private String afid = "";
  private long afie;
  private String qYC = "";
  
  public final void aNS()
  {
    AppMethodBeat.i(253224);
    this.afie = cn.bDw();
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpU, b.a.agrX, 0) == 1) {}
    for (this.afid = "MvvmAddressUI";; this.afid = "AddressUI")
    {
      String str = UUID.randomUUID().toString();
      s.s(str, "randomUUID().toString()");
      this.qYC = str;
      AppMethodBeat.o(253224);
      return;
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(253229);
    if (!Util.isNullOrNil(this.qYC))
    {
      kx localkx = new kx();
      Object localObject = localkx.tS(this.afid).tT(this.qYC);
      ((kx)localObject).iYo = 0L;
      ((kx)localObject).ijA = (cn.bDw() - this.afie);
      ((kx)localObject).bMH();
      localObject = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((a)localkx);
      this.qYC = "";
    }
    AppMethodBeat.o(253229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.e
 * JD-Core Version:    0.7.0.1
 */