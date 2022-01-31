package com.tencent.mm.ui;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.bk;

final class CheckCanSubscribeBizUI$2
  implements com.tencent.mm.ah.w.a
{
  CheckCanSubscribeBizUI$2(CheckCanSubscribeBizUI paramCheckCanSubscribeBizUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    paramb = (oq)paramb.ecF.ecN;
    CheckCanSubscribeBizUI.a(this.uHE, paramb.sMf);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!bk.bl(paramb.sMf)) && (!bk.bl(paramb.kWm)))
    {
      CheckCanSubscribeBizUI.b(this.uHE, paramb.kWm);
      CheckCanSubscribeBizUI.c(this.uHE, paramb.sMg);
      CheckCanSubscribeBizUI.b(this.uHE);
      return 0;
    }
    if (w.a.a(this.uHE, paramInt1, paramInt2, paramString, 7))
    {
      this.uHE.setResult(5);
      this.uHE.finish();
      return 0;
    }
    CheckCanSubscribeBizUI.c(this.uHE);
    this.uHE.setResult(3);
    this.uHE.finish();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI.2
 * JD-Core Version:    0.7.0.1
 */