package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.tools.a.c.a;

final class SightUploadUI$5$1
  implements c.a
{
  SightUploadUI$5$1(SightUploadUI.5 param5, int paramInt) {}
  
  public final void eP(String paramString)
  {
    paramString = new PInt();
    SightUploadUI.j(this.oTE.oTB).a(SightUploadUI.c(this.oTE.oTB), 0, null, SightUploadUI.d(this.oTE.oTB), null, SightUploadUI.e(this.oTE.oTB).getLocation(), this.oTD, SightUploadUI.f(this.oTE.oTB), SightUploadUI.g(this.oTE.oTB), paramString, "", SightUploadUI.h(this.oTE.oTB), SightUploadUI.i(this.oTE.oTB));
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    long l1 = SightUploadUI.k(this.oTE.oTB);
    long l2 = bk.UX();
    if (SightUploadUI.l(this.oTE.oTB))
    {
      i = 0;
      localh.f(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramString.value) });
      l1 = SightUploadUI.k(this.oTE.oTB);
      l2 = bk.UX();
      if (!SightUploadUI.l(this.oTE.oTB)) {
        break label267;
      }
    }
    label267:
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SightUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramString.value) });
      return;
      i = 1;
      break;
    }
  }
  
  public final void xB() {}
  
  public final void xC()
  {
    com.tencent.mm.ui.base.h.h(this.oTE.oTB, i.j.sns_upload_post_text_invalid_more, i.j.sns_upload_post_text_invalid_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.5.1
 * JD-Core Version:    0.7.0.1
 */