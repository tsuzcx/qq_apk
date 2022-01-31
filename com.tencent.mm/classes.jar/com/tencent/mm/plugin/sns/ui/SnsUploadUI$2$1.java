package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.h.a.qy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.tools.a.c.a;

final class SnsUploadUI$2$1
  implements c.a
{
  SnsUploadUI$2$1(SnsUploadUI.2 param2) {}
  
  public final void eP(String paramString)
  {
    int i = SnsUploadUI.o(this.pjr.pjp).getSyncFlag();
    g.DQ();
    g.DP().Dz().o(68404, Integer.valueOf(i));
    SnsUploadUI.a(this.pjr.pjp, SnsUploadUI.f(this.pjr.pjp).getText().toString());
    i = SnsUploadUI.f(this.pjr.pjp).getPasterLen();
    int j = SnsUploadUI.o(this.pjr.pjp).getPrivated();
    int k = SnsUploadUI.o(this.pjr.pjp).getSyncFlag();
    SnsUploadUI.p(this.pjr.pjp);
    if (SnsUploadUI.q(this.pjr.pjp)) {
      this.pjr.pjp.setResult(-1, new Intent());
    }
    if ((SnsUploadUI.d(this.pjr.pjp) instanceof ag)) {
      ((ag)SnsUploadUI.d(this.pjr.pjp)).oSj = SnsUploadUI.r(this.pjr.pjp).getCurLocation();
    }
    if ((SnsUploadUI.d(this.pjr.pjp) instanceof ad)) {
      SnsUploadUI.f(this.pjr.pjp).setText("");
    }
    paramString = new PInt();
    SnsUploadUI.d(this.pjr.pjp).a(j, k, SnsUploadUI.o(this.pjr.pjp).getTwitterAccessToken(), SnsUploadUI.s(this.pjr.pjp), SnsUploadUI.t(this.pjr.pjp).getAtList(), SnsUploadUI.r(this.pjr.pjp).getLocation(), i, SnsUploadUI.u(this.pjr.pjp), SnsUploadUI.v(this.pjr.pjp), paramString, SnsUploadUI.w(this.pjr.pjp), SnsUploadUI.x(this.pjr.pjp), SnsUploadUI.y(this.pjr.pjp));
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    long l1 = SnsUploadUI.z(this.pjr.pjp);
    long l2 = bk.UX();
    if (SnsUploadUI.A(this.pjr.pjp))
    {
      i = 0;
      localh.f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramString.value) });
      l1 = SnsUploadUI.z(this.pjr.pjp);
      l2 = bk.UX();
      if (!SnsUploadUI.A(this.pjr.pjp)) {
        break label678;
      }
      i = 0;
      label463:
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramString.value) });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10910, "1");
      if (!bk.bl(SnsUploadUI.B(this.pjr.pjp)))
      {
        if (!SnsUploadUI.u(this.pjr.pjp)) {
          break label683;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(11455, new Object[] { "", SnsUploadUI.B(this.pjr.pjp), Integer.valueOf(-1), Integer.valueOf(-1) });
      }
    }
    for (;;)
    {
      if (SnsUploadUI.C(this.pjr.pjp))
      {
        paramString = new Intent(this.pjr.pjp, SnsTimeLineUI.class);
        paramString.putExtra("sns_resume_state", false);
        paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
        paramString.addFlags(67108864);
        this.pjr.pjp.startActivity(paramString);
      }
      paramString = new qy();
      a.udP.m(paramString);
      return;
      i = 1;
      break;
      label678:
      i = 1;
      break label463;
      label683:
      com.tencent.mm.plugin.report.service.h.nFQ.f(11455, new Object[] { SnsUploadUI.B(this.pjr.pjp), "", Integer.valueOf(-1), Integer.valueOf(-1) });
    }
  }
  
  public final void xB() {}
  
  public final void xC()
  {
    com.tencent.mm.ui.base.h.h(this.pjr.pjp, i.j.sns_upload_post_text_invalid_more, i.j.sns_upload_post_text_invalid_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.2.1
 * JD-Core Version:    0.7.0.1
 */