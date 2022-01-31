package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.h;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.f.a;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
  extends i
  implements f, b.a
{
  private static int qzu = 300;
  private int cnU;
  private TextView qwc;
  private View qwd;
  private final int qzA;
  private final int qzB;
  private final long qzC;
  private long qzD;
  private final int qzE;
  private f.a qzF;
  private View.OnTouchListener qzG;
  private long qzv;
  h qzw;
  private int qzx;
  private int qzy;
  private long qzz;
  
  public k(i.b paramb, Point paramPoint)
  {
    super(paramb, paramPoint);
    AppMethodBeat.i(81169);
    this.qzv = 130L;
    this.qzx = 0;
    this.qzy = 1;
    this.qzA = 300;
    this.qzB = 400;
    this.qzC = 30000L;
    this.qzE = 50;
    this.qzF = new k.1(this);
    fo(300, 400);
    ab.d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s]", new Object[] { Integer.valueOf(this.qzc), Integer.valueOf(this.qzd) });
    if (bo.hg(paramb.getContext()) < 100L)
    {
      ab.w("MicroMsg.scanner.ScanModeImage", "memory is not much");
      this.qzv = 300L;
    }
    this.cnU = ((int)(System.currentTimeMillis() & 0xFFFFFFFF));
    this.qzD = System.currentTimeMillis();
    AppMethodBeat.o(81169);
  }
  
  private void ciS()
  {
    AppMethodBeat.i(81175);
    if (this.qzg == null)
    {
      ab.e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
      AppMethodBeat.o(81175);
      return;
    }
    if ((g.Rc().adt() == 6) || (g.Rc().adt() == 4)) {
      this.qzg.lg(0L);
    }
    AppMethodBeat.o(81175);
  }
  
  private void ciT()
  {
    AppMethodBeat.i(81178);
    al.d(new k.2(this));
    AppMethodBeat.o(81178);
  }
  
  public final void T(Bundle paramBundle) {}
  
  public final void a(int paramInt1, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(151675);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
      AppMethodBeat.o(151675);
      return;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0))
    {
      ab.w("MicroMsg.scanner.ScanModeImage", "greyData null");
      if ((System.currentTimeMillis() - this.qzz > 1800L + this.qzv) && (((l)this.qza).qDm == true))
      {
        this.qzz = System.currentTimeMillis();
        this.qzg.lg(0L);
        AppMethodBeat.o(151675);
        return;
      }
      this.qzg.lf(this.qzv);
      AppMethodBeat.o(151675);
      return;
    }
    ciT();
    if (this.qzx >= this.qzy)
    {
      ab.i("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
      this.qzg.lf(this.qzv);
      if ((System.currentTimeMillis() - this.qzz > 1800L + this.qzv) && (((l)this.qza).qDm == true))
      {
        this.qzz = System.currentTimeMillis();
        this.qzg.lg(0L);
        AppMethodBeat.o(151675);
        return;
      }
      this.qzg.lf(this.qzv);
      AppMethodBeat.o(151675);
      return;
    }
    this.typeName = paramString2;
    this.qzw = new h(paramArrayOfByte2, paramArrayOfByte2.length, this.cnU);
    g.Rc().a(this.qzw, 0);
    this.qzx += 1;
    this.qzh += paramArrayOfByte2.length;
    ab.d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", new Object[] { Integer.valueOf(this.qzh) });
    if ((System.currentTimeMillis() - this.qzz > 1800L + this.qzv) && (((l)this.qza).qDm == true))
    {
      this.qzz = System.currentTimeMillis();
      this.qzg.lg(0L);
      AppMethodBeat.o(151675);
      return;
    }
    this.qzg.lf(this.qzv);
    AppMethodBeat.o(151675);
  }
  
  protected final void cil()
  {
    AppMethodBeat.i(81174);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
      AppMethodBeat.o(81174);
      return;
    }
    ciS();
    AppMethodBeat.o(81174);
  }
  
  protected final com.tencent.mm.plugin.scanner.util.b cim()
  {
    AppMethodBeat.i(81173);
    int i;
    if (this.qza == null)
    {
      i = 50;
      if (ac.eru.eok > 0)
      {
        i = ac.eru.eok;
        ab.d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", new Object[] { Integer.valueOf(ac.eru.eok) });
      }
      if (!at.is2G(this.qzg.getContext())) {
        break label108;
      }
    }
    label108:
    for (this.qza = new l(this, i - 10, false, this.qzg.ciF());; this.qza = new l(this, i, false, this.qzg.ciF()))
    {
      com.tencent.mm.plugin.scanner.util.b localb = this.qza;
      AppMethodBeat.o(81173);
      return localb;
    }
  }
  
  protected final int cin()
  {
    return 2130970606;
  }
  
  protected final int cio()
  {
    return qzu;
  }
  
  protected final void cip()
  {
    AppMethodBeat.i(81171);
    k(new Rect(0, 0, 0, 0));
    this.qzg.b(4, null);
    onResume();
    AppMethodBeat.o(81171);
  }
  
  protected final boolean ciq()
  {
    return true;
  }
  
  protected final boolean cir()
  {
    return true;
  }
  
  protected final void k(Rect paramRect)
  {
    AppMethodBeat.i(81170);
    this.qwd = this.qzg.findViewById(2131827415);
    this.qwc = ((TextView)this.qzg.findViewById(2131827416));
    this.ivt = ((TextView)this.qzg.findViewById(2131827431));
    this.ivt.setText(t.ge(t.qDQ, this.qzg.getContext().getString(2131302905)));
    if (paramRect.bottom > 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ivt.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.qzg.getContext(), 13.0F));
      this.ivt.setLayoutParams(localLayoutParams);
    }
    if (d.Ll()) {
      this.ivt.setPadding(BackwardSupportUtil.b.b(this.qzg.getContext(), 54.0F), this.ivt.getPaddingTop(), BackwardSupportUtil.b.b(this.qzg.getContext(), 54.0F), this.ivt.getPaddingBottom());
    }
    if (this.qza != null) {
      ((l)this.qza).oIC = this.qzg.ciF();
    }
    ciS();
    kC(true);
    AppMethodBeat.o(81170);
  }
  
  protected final void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(81172);
    super.kE(paramBoolean);
    if (this.qza != null) {
      ((l)this.qza).oIC = paramBoolean;
    }
    AppMethodBeat.o(81172);
  }
  
  public final void le(long paramLong)
  {
    AppMethodBeat.i(81177);
    ab.d("MicroMsg.scanner.ScanModeImage", "decodeFail");
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
      AppMethodBeat.o(81177);
      return;
    }
    ciT();
    if ((System.currentTimeMillis() - this.qzz > 1800L + this.qzv) && (((l)this.qza).qDm == true))
    {
      this.qzz = System.currentTimeMillis();
      this.qzg.lg(0L);
      AppMethodBeat.o(81177);
      return;
    }
    this.qzg.lf(this.qzv);
    AppMethodBeat.o(81177);
  }
  
  protected final void onDestroy() {}
  
  protected final void onPause()
  {
    AppMethodBeat.i(81181);
    super.onPause();
    kC(false);
    g.Rc().b(1062, this);
    AppMethodBeat.o(81181);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(81180);
    g.Rc().a(1062, this);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
      AppMethodBeat.o(81180);
      return;
    }
    this.qzx = 0;
    ciS();
    AppMethodBeat.o(81180);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(81179);
    this.qzx = 0;
    if ((this.qzg == null) || (paramm == null))
    {
      if (paramm == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(81179);
        return;
      }
    }
    if (paramm.getType() == 1062)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label161;
      }
      ab.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.ivt.setText(t.ge(t.qDQ, this.qzg.getContext().getString(2131302905)));
    }
    for (;;)
    {
      if (this.qzw != null) {
        g.Rc().a(this.qzw);
      }
      AppMethodBeat.o(81179);
      return;
      label161:
      this.qzx = this.qzy;
      paramString = (h)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (paramString = (ln)paramString.rr.fsW.fta; paramString == null; paramString = null)
      {
        ab.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
        AppMethodBeat.o(81179);
        return;
      }
      ab.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", new Object[] { Integer.valueOf(paramString.wzP), Integer.valueOf(paramString.wzT) });
      switch (q.a(paramString.jKs, paramString.wzV, this.qzg.getContext(), this.qzg, 3, this.qzF, 0, 0, 0, false, false, this.typeName, -1))
      {
      default: 
        break;
      case 0: 
        this.qzg.ciy();
        if ((this.qzg != null) && (this.qzg.getContext() != null)) {
          this.qzg.ciG();
        }
        break;
      case 1: 
        ab.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        break;
      case 2: 
        ab.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.k
 * JD-Core Version:    0.7.0.1
 */