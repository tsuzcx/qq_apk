package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.util.p.a;
import com.tencent.mm.plugin.scanner.util.p.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class ScanTranslationCaptureUI$6
  implements p.a
{
  ScanTranslationCaptureUI$6(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void a(String paramString, p.b paramb)
  {
    if ((!bk.bl(paramString)) && (paramString.equals(ScanTranslationCaptureUI.v(this.nNm))))
    {
      ScanTranslationCaptureUI.g(this.nNm)[3] = ((int)(System.currentTimeMillis() - ScanTranslationCaptureUI.h(this.nNm)[1]));
      y.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", new Object[] { Integer.valueOf(ScanTranslationCaptureUI.g(this.nNm)[3]) });
    }
    switch (paramb.errCode)
    {
    case -21006: 
    default: 
      return;
    case 0: 
      if (!bk.H(new String[] { paramb.fileId, paramb.aeskey }))
      {
        y.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", new Object[] { paramb.fileId });
        ScanTranslationCaptureUI.h(this.nNm)[2] = System.currentTimeMillis();
        paramString = new com.tencent.mm.plugin.scanner.a.e(ScanTranslationCaptureUI.w(this.nNm), com.tencent.mm.a.e.bJ(ScanTranslationCaptureUI.o(this.nNm)), paramb.fileId, paramb.aeskey);
        g.Dk().a(paramString, 0);
        return;
      }
      ScanTranslationCaptureUI.g(this.nNm)[2] = 3;
      h.bC(this.nNm, this.nNm.getString(R.l.scan_translating_no_result));
      return;
    }
    h.a(this.nNm, this.nNm.getString(R.l.file_explorer_cannot_open_file), this.nNm.getString(R.l.app_tip), new ScanTranslationCaptureUI.6.1(this));
    ScanTranslationCaptureUI.g(this.nNm)[2] = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.6
 * JD-Core Version:    0.7.0.1
 */