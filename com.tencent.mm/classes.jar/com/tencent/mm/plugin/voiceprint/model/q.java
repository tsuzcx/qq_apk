package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
  implements f
{
  public q.a pLO = null;
  private String pLf = null;
  private int pLl = 0;
  public String pLy = null;
  public int pLz = -1;
  
  public q()
  {
    au.Dk().a(611, this);
    au.Dk().a(613, this);
  }
  
  public q(q.a parama)
  {
    this();
    this.pLO = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      if (this.pLO != null) {
        this.pLO.bPa();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramm.getType() == 611)
          {
            paramString = (d)paramm;
            this.pLz = paramString.pLe;
            this.pLy = paramString.pLd;
            this.pLf = paramString.pLf;
            y.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[] { Integer.valueOf(this.pLz), this.pLf, Boolean.valueOf(bk.bl(this.pLy)) });
            if (this.pLO != null) {
              this.pLO.PX(this.pLy);
            }
          }
        } while (paramm.getType() != 613);
        if (((j)paramm).Do != 0) {
          break;
        }
        y.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
      } while (this.pLO == null);
      this.pLO.jP(true);
      return;
      y.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
    } while (this.pLO == null);
    this.pLO.jP(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.q
 * JD-Core Version:    0.7.0.1
 */