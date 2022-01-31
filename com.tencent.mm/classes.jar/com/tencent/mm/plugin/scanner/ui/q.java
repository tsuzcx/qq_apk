package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.modelsimple.v.b;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

@com.tencent.mm.sdk.platformtools.f(cqs={BaseScanUI.class})
public final class q
  extends i
  implements com.tencent.mm.ah.f, b.a
{
  private static int nLN = 300;
  private float dia;
  private float dib;
  private a.a dig = new q.1(this);
  private c egs;
  private boolean egv = false;
  private TextView nID;
  private final int nLT = 300;
  private final int nLU = 400;
  private int nMC;
  private int nMD;
  private String nME;
  private String nMF;
  private boolean nMG = false;
  private float nMH = -10000.0F;
  private boolean nMI = false;
  private boolean nMJ = false;
  private boolean nMK = false;
  private q.a nML;
  protected ah nMM = new q.2(this);
  private float pitch = -10000.0F;
  
  public q(i.b paramb, Point paramPoint)
  {
    super(paramb, paramPoint);
    dG(300, 400);
  }
  
  private void bxR()
  {
    if (this.nLB == null) {
      y.e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
    }
    do
    {
      do
      {
        return;
        if (this.nMJ)
        {
          this.nLB.ix(true);
          return;
        }
      } while ((!au.DK()) || ((au.Dk().KG() != 6) && (au.Dk().KG() != 4)));
      this.nLB.fD(0L);
    } while (this.egs != null);
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
      return;
    }
    if (this.egs == null) {
      this.egs = c.Ob();
    }
    this.dia = -85.0F;
    this.dib = -1000.0F;
    this.nMD = -1000;
    this.nMC = 1;
    this.nME = "";
    this.nMF = "";
    this.egs.a(this.dig, true);
  }
  
  public final void C(Bundle paramBundle) {}
  
  public final void b(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3) {}
  
  protected final void bxo()
  {
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
      return;
    }
    bxR();
  }
  
  protected final b bxp()
  {
    return null;
  }
  
  protected final int bxq()
  {
    return R.i.scan_street_view_body;
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
  
  public final void fB(long paramLong) {}
  
  protected final void j(Rect paramRect)
  {
    this.nID = ((TextView)this.nLB.findViewById(R.h.scan_no_network_tips));
    this.nID.setText(R.l.scan_no_network);
    this.gSy = ((TextView)this.nLB.findViewById(R.h.scan_tip_tv));
    if (paramRect.bottom > 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gSy.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.nLB.getContext(), 13.0F));
      this.gSy.setLayoutParams(localLayoutParams);
    }
    if (d.yN()) {
      this.gSy.setPadding(BackwardSupportUtil.b.b(this.nLB.getContext(), 54.0F), this.gSy.getPaddingTop(), BackwardSupportUtil.b.b(this.nLB.getContext(), 54.0F), this.gSy.getPaddingBottom());
    }
    bxR();
    iz(true);
  }
  
  protected final void onDestroy() {}
  
  protected final void onPause()
  {
    this.nMI = true;
    iz(false);
    if (au.DK()) {
      au.Dk().b(424, this);
    }
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
    if (this.nMM != null) {
      this.nMM.removeMessages(0);
    }
  }
  
  protected final void onResume()
  {
    this.nMI = false;
    if (au.DK()) {
      au.Dk().a(424, this);
    }
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
      return;
    }
    bxR();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.nLB == null) {
      y.w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
    }
    for (;;)
    {
      return;
      this.nMK = false;
      switch (paramm.getType())
      {
      default: 
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return;
      }
      this.nMK = true;
      paramString = ((v)paramm).QP();
      if ((paramString == null) || (paramString.sDW == null))
      {
        y.d("MicroMsg.scanner.ScanModeStreetView", "resp null");
        return;
      }
      y.i("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramString.hQR) });
      if (paramString.hQR == 0)
      {
        paramString = v.nf(paramString.sDW);
        if (bk.bl(paramString))
        {
          y.e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
          return;
        }
        if (this.nML == null) {
          this.nML = new q.a(this, (byte)0);
        }
        this.nML.url = paramString;
        ai.S(this.nML);
        ai.l(this.nML, 800L);
        return;
      }
      if (paramString.hQR == 2)
      {
        if ((this.nMM != null) && (!this.nMI))
        {
          this.nMM.removeMessages(0);
          this.nMM.sendEmptyMessageDelayed(0, 1000L);
        }
      }
      else if (paramString.hQR == 1) {
        try
        {
          paramString = paramString.sDW;
          if (paramString != null)
          {
            paramString = bn.s(paramString, "recommend");
            if (paramString != null)
            {
              paramm = v.b.f(paramString, ".recommend");
              v.b localb = new v.b();
              localb.title = bk.pm((String)paramString.get(".recommend.title"));
              localb.desc = bk.pm((String)paramString.get(".recommend.desc"));
              localb.eAm = paramm;
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          y.printErrStackTrace("MicroMsg.scanner.ScanModeStreetView", paramString, "", new Object[0]);
          y.e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", new Object[] { paramString.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.q
 * JD-Core Version:    0.7.0.1
 */