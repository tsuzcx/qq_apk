package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  extends i
  implements com.tencent.mm.ai.f, b.a
{
  private int cnU;
  private final int qzA;
  private final int qzB;
  private final int qzE;
  com.tencent.mm.plugin.scanner.model.f qzJ;
  private int qzK;
  private TextView qzL;
  private TextView qzM;
  private final int qzN;
  private final int qzO;
  private ak qzP;
  int qzx;
  int qzy;
  private long qzz;
  
  public o(i.b paramb, Point paramPoint)
  {
    super(paramb, paramPoint, (byte)0);
    AppMethodBeat.i(81186);
    this.qzx = 0;
    this.qzy = 2;
    this.qzK = 0;
    this.qzA = 184;
    this.qzB = 46;
    this.qzE = 50;
    this.qzN = 5000;
    this.qzO = 8000;
    this.qzP = new o.1(this);
    fo(184, 46);
    ab.d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s]", new Object[] { Integer.valueOf(this.qzc), Integer.valueOf(this.qzd) });
    this.cnU = ((int)(System.currentTimeMillis() & 0xFFFFFFFF));
    AppMethodBeat.o(81186);
  }
  
  private void ciS()
  {
    AppMethodBeat.i(81193);
    if (this.qzg == null)
    {
      ab.e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
      AppMethodBeat.o(81193);
      return;
    }
    if ((g.Rc().adt() == 6) || (g.Rc().adt() == 4))
    {
      this.qzg.lg(0L);
      AppMethodBeat.o(81193);
      return;
    }
    this.qzL.setText("");
    this.qzM.setText("");
    this.qzg.kA(true);
    AppMethodBeat.o(81193);
  }
  
  private void gc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(81197);
    if (!bo.isNullOrNil(paramString1))
    {
      this.ivt.setVisibility(8);
      this.qzL.setText(paramString1);
      this.qzL.setVisibility(0);
    }
    while (!bo.isNullOrNil(paramString2))
    {
      this.ivt.setVisibility(8);
      this.qzM.setText(paramString2);
      this.qzM.setVisibility(0);
      AppMethodBeat.o(81197);
      return;
      this.qzL.setText("");
    }
    this.qzM.setText("");
    AppMethodBeat.o(81197);
  }
  
  protected final Rect H(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(81189);
    if ((paramBoolean1) || (this.qyZ == null))
    {
      if (t.cjO())
      {
        localObject = new Point();
        this.qzg.getContext().getWindowManager().getDefaultDisplay().getRealSize((Point)localObject);
        this.qyZ = new Rect(0, 0, ((Point)localObject).x, ((Point)localObject).y);
      }
    }
    else
    {
      localObject = this.qyZ;
      AppMethodBeat.o(81189);
      return localObject;
    }
    Object localObject = super.H(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(81189);
    return localObject;
  }
  
  public final void T(Bundle paramBundle) {}
  
  public final void a(int paramInt1, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(151677);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
      AppMethodBeat.o(151677);
      return;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0))
    {
      boolean bool;
      if (paramArrayOfByte2 == null)
      {
        bool = true;
        ab.w("MicroMsg.scanner.ScanModeOCR", "greyData null:[%s]", new Object[] { Boolean.valueOf(bool) });
        if ((System.currentTimeMillis() - this.qzz <= 1840L) || (((l)this.qza).qDm != true)) {
          break label126;
        }
        this.qzz = System.currentTimeMillis();
        this.qzg.lg(0L);
      }
      for (;;)
      {
        this.qzK = 0;
        AppMethodBeat.o(151677);
        return;
        bool = false;
        break;
        label126:
        this.qzg.lf(40L);
      }
    }
    if (this.qzx >= this.qzy)
    {
      if ((System.currentTimeMillis() - this.qzz > 1840L) && (((l)this.qza).qDm == true))
      {
        this.qzz = System.currentTimeMillis();
        this.qzg.lg(0L);
      }
      for (;;)
      {
        ab.w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", new Object[] { Integer.valueOf(this.qzx), Integer.valueOf(this.qzy) });
        AppMethodBeat.o(151677);
        return;
        this.qzg.lf(40L);
      }
    }
    this.qzJ = new com.tencent.mm.plugin.scanner.model.f(paramArrayOfByte2, "en", "zh_CN", this.cnU);
    g.Rc().a(this.qzJ, 0);
    this.qzx += 1;
    this.qzP.removeMessages(0);
    if (at.is2G(this.qzg.getContext()))
    {
      this.qzP.sendEmptyMessageDelayed(0, 8000L);
      this.qzh += paramArrayOfByte2.length;
      ab.d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", new Object[] { Integer.valueOf(this.qzh), Integer.valueOf(this.qzK), Integer.valueOf(this.qzy) });
      if ((System.currentTimeMillis() - this.qzz <= 1840L) || (((l)this.qza).qDm != true)) {
        break label490;
      }
      this.qzz = System.currentTimeMillis();
      this.qzg.lg(0L);
    }
    for (;;)
    {
      ab.v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.qzx + "," + this.qzK);
      AppMethodBeat.o(151677);
      return;
      this.qzP.sendEmptyMessageDelayed(0, 5000L);
      break;
      label490:
      this.qzg.lf(40L);
    }
  }
  
  protected final void cil()
  {
    AppMethodBeat.i(81192);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
      AppMethodBeat.o(81192);
      return;
    }
    ciS();
    AppMethodBeat.o(81192);
  }
  
  protected final com.tencent.mm.plugin.scanner.util.b cim()
  {
    AppMethodBeat.i(81191);
    int i;
    if (this.qza == null)
    {
      i = 50;
      if (ac.eru.eok > 0)
      {
        i = ac.eru.eok;
        ab.d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", new Object[] { Integer.valueOf(ac.eru.eok) });
      }
      if (!at.is2G(this.qzg.getContext())) {
        break label110;
      }
    }
    label110:
    for (this.qza = new l(this, i - 10, true, this.qzg.ciF());; this.qza = new l(this, i, true, this.qzg.ciF()))
    {
      com.tencent.mm.plugin.scanner.util.b localb = this.qza;
      AppMethodBeat.o(81191);
      return localb;
    }
  }
  
  protected final int cin()
  {
    return 2130970608;
  }
  
  protected final int cio()
  {
    return 0;
  }
  
  protected final void cip()
  {
    AppMethodBeat.i(81188);
    k(new Rect(0, 0, 0, 0));
    this.qzg.b(4, null);
    this.qzg.lg(0L);
    onResume();
    AppMethodBeat.o(81188);
  }
  
  protected final boolean ciq()
  {
    return true;
  }
  
  protected final boolean cir()
  {
    return false;
  }
  
  protected final void k(Rect paramRect)
  {
    AppMethodBeat.i(81187);
    this.ivt = ((TextView)this.qzg.findViewById(2131827431));
    this.qzM = ((TextView)this.qzg.findViewById(2131827435));
    this.qzL = ((TextView)this.qzg.findViewById(2131827434));
    this.ivt = ((TextView)this.qzg.findViewById(2131827431));
    if (paramRect.bottom > 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ivt.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.qzg.getContext(), 13.0F));
      this.ivt.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.qzL.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.qzg.getContext(), 13.0F));
      this.qzL.setLayoutParams(localLayoutParams);
      this.qzL.setVisibility(4);
    }
    if (d.Ll())
    {
      this.ivt.setPadding(BackwardSupportUtil.b.b(this.qzg.getContext(), 54.0F), this.ivt.getPaddingTop(), BackwardSupportUtil.b.b(this.qzg.getContext(), 54.0F), this.ivt.getPaddingBottom());
      this.qzL.setPadding(BackwardSupportUtil.b.b(this.qzg.getContext(), 54.0F), this.qzL.getPaddingTop(), BackwardSupportUtil.b.b(this.qzg.getContext(), 54.0F), this.qzL.getPaddingBottom());
    }
    if (this.qza != null) {
      ((l)this.qza).oIC = this.qzg.ciF();
    }
    ciS();
    kC(true);
    AppMethodBeat.o(81187);
  }
  
  protected final void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(81190);
    super.kE(paramBoolean);
    if (this.qza != null) {
      ((l)this.qza).oIC = paramBoolean;
    }
    AppMethodBeat.o(81190);
  }
  
  public final void le(long paramLong)
  {
    AppMethodBeat.i(81195);
    ab.d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
      AppMethodBeat.o(81195);
      return;
    }
    if ((System.currentTimeMillis() - this.qzz > 1840L) && (((l)this.qza).qDm == true))
    {
      this.qzz = System.currentTimeMillis();
      this.qzg.lg(0L);
      AppMethodBeat.o(81195);
      return;
    }
    this.qzg.lf(40L);
    AppMethodBeat.o(81195);
  }
  
  protected final void onDestroy() {}
  
  protected final void onPause()
  {
    AppMethodBeat.i(81199);
    kC(false);
    g.Rc().b(392, this);
    AppMethodBeat.o(81199);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(81198);
    g.Rc().a(392, this);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
      AppMethodBeat.o(81198);
      return;
    }
    ciS();
    AppMethodBeat.o(81198);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(81196);
    this.qzP.removeMessages(0);
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81196);
      return;
      this.qzx -= 1;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        this.qzz -= 300L;
        gc(null, null);
        AppMethodBeat.o(81196);
        return;
      }
      ab.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (com.tencent.mm.plugin.scanner.model.f)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (paramString = (bgn)paramString.rr.fsW.fta; paramString == null; paramString = null)
      {
        ab.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
        gc(null, null);
        AppMethodBeat.o(81196);
        return;
      }
      ab.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", new Object[] { Integer.valueOf(paramString.wzP), Integer.valueOf(paramString.wzT), paramString.xvO, paramString.xvP });
      if (bo.isNullOrNil(paramString.xvP))
      {
        AppMethodBeat.o(81196);
        return;
      }
      gc(paramString.xvO, paramString.xvP);
      if (this.qzJ != null) {
        g.Rc().a(this.qzJ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.o
 * JD-Core Version:    0.7.0.1
 */