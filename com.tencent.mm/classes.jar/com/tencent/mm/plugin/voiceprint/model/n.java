package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  implements f
{
  public String fRK = null;
  public String fmR = null;
  public String hcm = null;
  public n.a pLB = null;
  private String pLy = null;
  public int pLz = -1;
  
  public n()
  {
    au.Dk().a(618, this);
    au.Dk().a(616, this);
    au.Dk().a(617, this);
  }
  
  public final void bPb()
  {
    au.Dk().a(new g(this.fRK), 0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      if ((paramInt2 == -34) && (paramm.getType() == 617))
      {
        y.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
        if (this.pLB != null) {
          this.pLB.bPc();
        }
      }
    }
    label73:
    do
    {
      do
      {
        do
        {
          break label73;
          do
          {
            return;
          } while (this.pLB == null);
          this.pLB.bPa();
          return;
          if (paramm.getType() == 618)
          {
            this.fRK = ((e)paramm).dqS;
            y.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[] { Boolean.valueOf(bk.bl(this.fRK)) });
            if (!bk.bl(this.fRK)) {
              bPb();
            }
          }
          if (paramm.getType() == 616)
          {
            paramString = (g)paramm;
            this.pLz = paramString.pLe;
            this.pLy = paramString.pLd;
            y.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.pLz), Boolean.valueOf(bk.bl(this.pLy)) });
            if (this.pLB != null) {
              this.pLB.PX(this.pLy);
            }
          }
        } while (paramm.getType() != 617);
        paramString = (h)paramm;
        if (paramString.Do != 0) {
          break;
        }
        y.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
        this.fmR = paramString.fmR;
      } while (this.pLB == null);
      this.pLB.jO(true);
      return;
      y.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
    } while (this.pLB == null);
    this.pLB.jO(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.n
 * JD-Core Version:    0.7.0.1
 */