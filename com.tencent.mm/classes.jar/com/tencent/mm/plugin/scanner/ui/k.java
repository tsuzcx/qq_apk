package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.protocal.c.ji;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends i
  implements f, b.a
{
  private static int nLN = 300;
  private int igH;
  private TextView nID;
  private View nIE;
  private long nLO = 130L;
  h nLP;
  private int nLQ = 0;
  private int nLR = 1;
  private long nLS;
  private final int nLT = 300;
  private final int nLU = 400;
  private final long nLV = 30000L;
  private long nLW;
  private final int nLX = 50;
  private e.a nLY = new k.1(this);
  private View.OnTouchListener nLZ;
  
  public k(i.b paramb, Point paramPoint)
  {
    super(paramb, paramPoint);
    dG(300, 400);
    y.d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s]", new Object[] { Integer.valueOf(this.nLx), Integer.valueOf(this.nLy) });
    if (bk.fQ(paramb.getContext()) < 100L)
    {
      y.w("MicroMsg.scanner.ScanModeImage", "memory is not much");
      this.nLO = 300L;
    }
    this.igH = ((int)(System.currentTimeMillis() & 0xFFFFFFFF));
    this.nLW = System.currentTimeMillis();
  }
  
  private void bxR()
  {
    if (this.nLB == null) {
      y.e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
    }
    while ((au.Dk().KG() != 6) && (au.Dk().KG() != 4)) {
      return;
    }
    this.nLB.fD(0L);
  }
  
  private void bxS()
  {
    ai.d(new k.2(this));
  }
  
  public final void C(Bundle paramBundle) {}
  
  public final void b(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
      return;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0))
    {
      y.w("MicroMsg.scanner.ScanModeImage", "greyData null");
      if ((System.currentTimeMillis() - this.nLS > 1800L + this.nLO) && (((j)this.nLv).nPt == true))
      {
        this.nLS = System.currentTimeMillis();
        this.nLB.fD(0L);
        return;
      }
      this.nLB.fC(this.nLO);
      return;
    }
    bxS();
    if (this.nLQ >= this.nLR)
    {
      y.i("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
      this.nLB.fC(this.nLO);
      if ((System.currentTimeMillis() - this.nLS > 1800L + this.nLO) && (((j)this.nLv).nPt == true))
      {
        this.nLS = System.currentTimeMillis();
        this.nLB.fD(0L);
        return;
      }
      this.nLB.fC(this.nLO);
      return;
    }
    this.nLP = new h(paramArrayOfByte2, paramArrayOfByte2.length, this.igH);
    au.Dk().a(this.nLP, 0);
    this.nLQ += 1;
    this.nLC += paramArrayOfByte2.length;
    y.d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", new Object[] { Integer.valueOf(this.nLC) });
    if ((System.currentTimeMillis() - this.nLS > 1800L + this.nLO) && (((j)this.nLv).nPt == true))
    {
      this.nLS = System.currentTimeMillis();
      this.nLB.fD(0L);
      return;
    }
    this.nLB.fC(this.nLO);
  }
  
  protected final void bxo()
  {
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
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
        y.d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", new Object[] { Integer.valueOf(q.dyd.dwq) });
      }
      if (!aq.is2G(this.nLB.getContext())) {
        break label95;
      }
    }
    label95:
    for (this.nLv = new j(this, i - 10, false, this.nLB.bxE());; this.nLv = new j(this, i, false, this.nLB.bxE())) {
      return this.nLv;
    }
  }
  
  protected final int bxq()
  {
    return R.i.scan_image_body;
  }
  
  protected final int bxr()
  {
    return nLN;
  }
  
  protected final void bxs()
  {
    j(new Rect(0, 0, 0, 0));
    this.nLB.b(4, null);
    onResume();
  }
  
  protected final boolean bxt()
  {
    return true;
  }
  
  protected final boolean bxu()
  {
    return true;
  }
  
  public final void fB(long paramLong)
  {
    y.d("MicroMsg.scanner.ScanModeImage", "decodeFail");
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
      return;
    }
    bxS();
    if ((System.currentTimeMillis() - this.nLS > 1800L + this.nLO) && (((j)this.nLv).nPt == true))
    {
      this.nLS = System.currentTimeMillis();
      this.nLB.fD(0L);
      return;
    }
    this.nLB.fC(this.nLO);
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
    this.nIE = this.nLB.findViewById(R.h.scan_no_data_mask);
    this.nID = ((TextView)this.nLB.findViewById(R.h.scan_no_network_tips));
    this.gSy = ((TextView)this.nLB.findViewById(R.h.scan_tip_tv));
    this.gSy.setText(r.eD(r.nPX, this.nLB.getContext().getString(R.l.scan_img_tips_focus)));
    if (paramRect.bottom > 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gSy.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.nLB.getContext(), 13.0F));
      this.gSy.setLayoutParams(localLayoutParams);
    }
    if (d.yN()) {
      this.gSy.setPadding(BackwardSupportUtil.b.b(this.nLB.getContext(), 54.0F), this.gSy.getPaddingTop(), BackwardSupportUtil.b.b(this.nLB.getContext(), 54.0F), this.gSy.getPaddingBottom());
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
    super.onPause();
    iz(false);
    au.Dk().b(1062, this);
  }
  
  protected final void onResume()
  {
    au.Dk().a(1062, this);
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
      return;
    }
    this.nLQ = 0;
    bxR();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    this.nLQ = 0;
    boolean bool;
    if ((this.nLB == null) || (paramm == null)) {
      if (paramm == null)
      {
        bool = true;
        y.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      if (paramm.getType() == 1062)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          y.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          this.gSy.setText(r.eD(r.nPX, this.nLB.getContext().getString(R.l.scan_img_tips_focus)));
        }
        while (this.nLP != null)
        {
          au.Dk().c(this.nLP);
          return;
          this.nLQ = this.nLR;
          paramString = (h)paramm;
          if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
          for (paramString = (ji)paramString.dmK.ecF.ecN; paramString == null; paramString = null)
          {
            y.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
            return;
          }
          y.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", new Object[] { Integer.valueOf(paramString.sDQ), Integer.valueOf(paramString.sDU) });
          switch (o.a(paramString.hQR, paramString.sDW, this, 3, this.nLY, 0, 0, false))
          {
          default: 
            break;
          case 0: 
            this.nLB.bxy();
            if ((this.nLB != null) && (this.nLB.getContext() != null)) {
              this.nLB.bxF();
            }
            break;
          case 1: 
            y.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
            break;
          case 2: 
            y.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.k
 * JD-Core Version:    0.7.0.1
 */