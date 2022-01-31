package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.tools.b.c.a;

final class SnsUploadUI$3$1
  implements c.a
{
  SnsUploadUI$3$1(SnsUploadUI.3 param3) {}
  
  public final void JU() {}
  
  public final void kY(String paramString)
  {
    AppMethodBeat.i(145651);
    int i = SnsUploadUI.o(this.sbT.sbR).getSyncFlag();
    g.RM();
    g.RL().Ru().set(68404, Integer.valueOf(i));
    SnsUploadUI.a(this.sbT.sbR, SnsUploadUI.f(this.sbT.sbR).getText().toString());
    i = SnsUploadUI.f(this.sbT.sbR).getPasterLen();
    int j = SnsUploadUI.o(this.sbT.sbR).getPrivated();
    int k = SnsUploadUI.o(this.sbT.sbR).getSyncFlag();
    SnsUploadUI.p(this.sbT.sbR);
    if (SnsUploadUI.q(this.sbT.sbR)) {
      this.sbT.sbR.setResult(-1, new Intent());
    }
    if ((SnsUploadUI.d(this.sbT.sbR) instanceof ag)) {
      ((ag)SnsUploadUI.d(this.sbT.sbR)).rKc = SnsUploadUI.r(this.sbT.sbR).getCurLocation();
    }
    if ((SnsUploadUI.d(this.sbT.sbR) instanceof ad)) {
      SnsUploadUI.f(this.sbT.sbR).setText("");
    }
    paramString = new PInt();
    SnsUploadUI.d(this.sbT.sbR).a(j, k, SnsUploadUI.o(this.sbT.sbR).getTwitterAccessToken(), SnsUploadUI.s(this.sbT.sbR), SnsUploadUI.t(this.sbT.sbR).getAtList(), SnsUploadUI.r(this.sbT.sbR).getLocation(), i, SnsUploadUI.u(this.sbT.sbR), SnsUploadUI.v(this.sbT.sbR), paramString, SnsUploadUI.w(this.sbT.sbR), SnsUploadUI.x(this.sbT.sbR), SnsUploadUI.y(this.sbT.sbR));
    SnsUploadUI.z(this.sbT.sbR);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    long l1 = SnsUploadUI.A(this.sbT.sbR);
    long l2 = bo.aox();
    if (SnsUploadUI.B(this.sbT.sbR))
    {
      i = 0;
      localh.e(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramString.value), i.cnT() });
      l1 = SnsUploadUI.A(this.sbT.sbR);
      l2 = bo.aox();
      if (!SnsUploadUI.B(this.sbT.sbR)) {
        break label721;
      }
      i = 0;
      label484:
      ab.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramString.value) });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10910, "1");
      if (!bo.isNullOrNil(SnsUploadUI.C(this.sbT.sbR)))
      {
        if (!SnsUploadUI.u(this.sbT.sbR)) {
          break label726;
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(11455, new Object[] { "", SnsUploadUI.C(this.sbT.sbR), Integer.valueOf(-1), Integer.valueOf(-1) });
      }
    }
    for (;;)
    {
      if (SnsUploadUI.D(this.sbT.sbR))
      {
        paramString = new Intent(this.sbT.sbR, SnsTimeLineUI.class);
        paramString.putExtra("sns_resume_state", false);
        paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
        paramString.addFlags(67108864);
        this.sbT.sbR.startActivity(paramString);
      }
      l.aF(this.sbT.sbR.getIntent());
      paramString = new sk();
      a.ymk.l(paramString);
      AppMethodBeat.o(145651);
      return;
      i = 1;
      break;
      label721:
      i = 1;
      break label484;
      label726:
      com.tencent.mm.plugin.report.service.h.qsU.e(11455, new Object[] { SnsUploadUI.C(this.sbT.sbR), "", Integer.valueOf(-1), Integer.valueOf(-1) });
    }
  }
  
  public final void vn()
  {
    AppMethodBeat.i(145652);
    com.tencent.mm.ui.base.h.h(this.sbT.sbR, 2131304037, 2131304038);
    AppMethodBeat.o(145652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.3.1
 * JD-Core Version:    0.7.0.1
 */