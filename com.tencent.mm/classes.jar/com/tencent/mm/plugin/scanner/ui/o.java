package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.protocal.c.azk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends i
  implements com.tencent.mm.ah.f, b.a
{
  private int igH;
  int nLQ = 0;
  int nLR = 2;
  private long nLS;
  private final int nLT = 184;
  private final int nLU = 46;
  private final int nLX = 50;
  com.tencent.mm.plugin.scanner.a.f nMc;
  private int nMd = 0;
  private TextView nMe;
  private TextView nMf;
  private final int nMg = 5000;
  private final int nMh = 8000;
  private ah nMi = new o.1(this);
  
  public o(i.b paramb, Point paramPoint)
  {
    super(paramb, paramPoint, (byte)0);
    dG(184, 46);
    y.d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s]", new Object[] { Integer.valueOf(this.nLx), Integer.valueOf(this.nLy) });
    this.igH = ((int)(System.currentTimeMillis() & 0xFFFFFFFF));
  }
  
  private void bxR()
  {
    if (this.nLB == null)
    {
      y.e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
      return;
    }
    if ((au.Dk().KG() == 6) || (au.Dk().KG() == 4))
    {
      this.nLB.fD(0L);
      return;
    }
    this.nMe.setText("");
    this.nMf.setText("");
    this.nLB.ix(true);
  }
  
  private void eB(String paramString1, String paramString2)
  {
    if (!bk.bl(paramString1))
    {
      this.gSy.setVisibility(8);
      this.nMe.setText(paramString1);
      this.nMe.setVisibility(0);
    }
    while (!bk.bl(paramString2))
    {
      this.gSy.setVisibility(8);
      this.nMf.setText(paramString2);
      this.nMf.setVisibility(0);
      return;
      this.nMe.setText("");
    }
    this.nMf.setText("");
  }
  
  public final void C(Bundle paramBundle) {}
  
  protected final Rect D(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (this.nLu == null))
    {
      if (r.byE())
      {
        Point localPoint = new Point();
        this.nLB.getContext().getWindowManager().getDefaultDisplay().getRealSize(localPoint);
        this.nLu = new Rect(0, 0, localPoint.x, localPoint.y);
      }
    }
    else {
      return this.nLu;
    }
    return super.D(paramBoolean1, paramBoolean2);
  }
  
  public final void b(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
      return;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0))
    {
      boolean bool;
      if (paramArrayOfByte2 == null)
      {
        bool = true;
        y.w("MicroMsg.scanner.ScanModeOCR", "greyData null:[%s]", new Object[] { Boolean.valueOf(bool) });
        if ((System.currentTimeMillis() - this.nLS <= 1840L) || (((j)this.nLv).nPt != true)) {
          break label111;
        }
        this.nLS = System.currentTimeMillis();
        this.nLB.fD(0L);
      }
      for (;;)
      {
        this.nMd = 0;
        return;
        bool = false;
        break;
        label111:
        this.nLB.fC(40L);
      }
    }
    if (this.nLQ >= this.nLR)
    {
      if ((System.currentTimeMillis() - this.nLS > 1840L) && (((j)this.nLv).nPt == true))
      {
        this.nLS = System.currentTimeMillis();
        this.nLB.fD(0L);
      }
      for (;;)
      {
        y.w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", new Object[] { Integer.valueOf(this.nLQ), Integer.valueOf(this.nLR) });
        return;
        this.nLB.fC(40L);
      }
    }
    this.nMc = new com.tencent.mm.plugin.scanner.a.f(paramArrayOfByte2, "en", "zh_CN", this.igH);
    au.Dk().a(this.nMc, 0);
    this.nLQ += 1;
    this.nMi.removeMessages(0);
    if (aq.is2G(this.nLB.getContext()))
    {
      this.nMi.sendEmptyMessageDelayed(0, 8000L);
      this.nLC += paramArrayOfByte2.length;
      y.d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", new Object[] { Integer.valueOf(this.nLC), Integer.valueOf(this.nMd), Integer.valueOf(this.nLR) });
      if ((System.currentTimeMillis() - this.nLS <= 1840L) || (((j)this.nLv).nPt != true)) {
        break label462;
      }
      this.nLS = System.currentTimeMillis();
      this.nLB.fD(0L);
    }
    for (;;)
    {
      y.v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.nLQ + "," + this.nMd);
      return;
      this.nMi.sendEmptyMessageDelayed(0, 5000L);
      break;
      label462:
      this.nLB.fC(40L);
    }
  }
  
  protected final void bxo()
  {
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
      return;
    }
    bxR();
  }
  
  protected final com.tencent.mm.plugin.scanner.util.b bxp()
  {
    int i;
    if (this.nLv == null)
    {
      i = 50;
      if (q.dyd.dwq > 0)
      {
        i = q.dyd.dwq;
        y.d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", new Object[] { Integer.valueOf(q.dyd.dwq) });
      }
      if (!aq.is2G(this.nLB.getContext())) {
        break label96;
      }
    }
    label96:
    for (this.nLv = new j(this, i - 10, true, this.nLB.bxE());; this.nLv = new j(this, i, true, this.nLB.bxE())) {
      return this.nLv;
    }
  }
  
  protected final int bxq()
  {
    return R.i.scan_ocr_body;
  }
  
  protected final int bxr()
  {
    return 0;
  }
  
  protected final void bxs()
  {
    j(new Rect(0, 0, 0, 0));
    this.nLB.b(4, null);
    this.nLB.fD(0L);
    onResume();
  }
  
  protected final boolean bxt()
  {
    return true;
  }
  
  protected final boolean bxu()
  {
    return false;
  }
  
  public final void fB(long paramLong)
  {
    y.d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
      return;
    }
    if ((System.currentTimeMillis() - this.nLS > 1840L) && (((j)this.nLv).nPt == true))
    {
      this.nLS = System.currentTimeMillis();
      this.nLB.fD(0L);
      return;
    }
    this.nLB.fC(40L);
  }
  
  protected final void iB(boolean paramBoolean)
  {
    super.iB(paramBoolean);
    if (this.nLv != null) {
      ((j)this.nLv).miw = paramBoolean;
    }
  }
  
  protected final void j(Rect paramRect)
  {
    this.gSy = ((TextView)this.nLB.findViewById(R.h.scan_tip_tv));
    this.nMf = ((TextView)this.nLB.findViewById(R.h.ocr_result_tips));
    this.nMe = ((TextView)this.nLB.findViewById(R.h.ocr_source_tv));
    this.gSy = ((TextView)this.nLB.findViewById(R.h.scan_tip_tv));
    if (paramRect.bottom > 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gSy.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.nLB.getContext(), 13.0F));
      this.gSy.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.nMe.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.nLB.getContext(), 13.0F));
      this.nMe.setLayoutParams(localLayoutParams);
      this.nMe.setVisibility(4);
    }
    if (d.yN())
    {
      this.gSy.setPadding(BackwardSupportUtil.b.b(this.nLB.getContext(), 54.0F), this.gSy.getPaddingTop(), BackwardSupportUtil.b.b(this.nLB.getContext(), 54.0F), this.gSy.getPaddingBottom());
      this.nMe.setPadding(BackwardSupportUtil.b.b(this.nLB.getContext(), 54.0F), this.nMe.getPaddingTop(), BackwardSupportUtil.b.b(this.nLB.getContext(), 54.0F), this.nMe.getPaddingBottom());
    }
    if (this.nLv != null) {
      ((j)this.nLv).miw = this.nLB.bxE();
    }
    bxR();
    iz(true);
  }
  
  protected final void onDestroy() {}
  
  protected final void onPause()
  {
    iz(false);
    au.Dk().b(392, this);
  }
  
  protected final void onResume()
  {
    au.Dk().a(392, this);
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
      return;
    }
    bxR();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    this.nMi.removeMessages(0);
    switch (paramm.getType())
    {
    }
    do
    {
      do
      {
        return;
        this.nLQ -= 1;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          y.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          this.nLS -= 300L;
          eB(null, null);
          return;
        }
        y.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.scanner.a.f)paramm;
        if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
        for (paramString = (azk)paramString.dmK.ecF.ecN; paramString == null; paramString = null)
        {
          y.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
          eB(null, null);
          return;
        }
        y.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", new Object[] { Integer.valueOf(paramString.sDQ), Integer.valueOf(paramString.sDU), paramString.tvD, paramString.tvE });
      } while (bk.bl(paramString.tvE));
      eB(paramString.tvD, paramString.tvE);
    } while (this.nMc == null);
    au.Dk().c(this.nMc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.o
 * JD-Core Version:    0.7.0.1
 */