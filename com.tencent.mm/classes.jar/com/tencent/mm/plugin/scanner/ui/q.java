package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.modelsimple.w.b;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Map;

@h(dsp={BaseScanUI.class})
public final class q
  extends i
  implements f, com.tencent.mm.plugin.scanner.util.b.a
{
  private static int qzu = 300;
  private com.tencent.mm.modelgeo.b.a dZA;
  private float dZu;
  private float dZv;
  private com.tencent.mm.modelgeo.d fwu;
  private boolean fwx;
  private boolean ogA;
  private float pitch;
  private int qAk;
  private int qAl;
  private String qAm;
  private String qAn;
  private boolean qAo;
  private float qAp;
  private boolean qAq;
  private boolean qAr;
  private boolean qAs;
  private q.a qAt;
  protected ak qAu;
  private TextView qwc;
  private final int qzA;
  private final int qzB;
  
  public q(i.b paramb, Point paramPoint)
  {
    super(paramb, paramPoint);
    AppMethodBeat.i(81242);
    this.qzA = 300;
    this.qzB = 400;
    this.qAo = false;
    this.qAp = -10000.0F;
    this.pitch = -10000.0F;
    this.qAq = false;
    this.qAr = false;
    this.qAs = false;
    this.fwx = false;
    this.dZA = new q.1(this);
    this.qAu = new q.2(this);
    fo(300, 400);
    AppMethodBeat.o(81242);
  }
  
  private void ciS()
  {
    AppMethodBeat.i(81247);
    if (this.qzg == null)
    {
      ab.e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
      AppMethodBeat.o(81247);
      return;
    }
    if ((g.RG()) && ((g.Rc().adt() == 6) || (g.Rc().adt() == 4)))
    {
      this.qzg.lg(0L);
      ciZ();
    }
    AppMethodBeat.o(81247);
  }
  
  private void ciZ()
  {
    AppMethodBeat.i(81243);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
      AppMethodBeat.o(81243);
      return;
    }
    if (this.fwu == null) {
      this.fwu = com.tencent.mm.modelgeo.d.agQ();
    }
    this.dZu = -85.0F;
    this.dZv = -1000.0F;
    this.qAl = -1000;
    this.qAk = 1;
    this.qAm = "";
    this.qAn = "";
    this.fwu.a(this.dZA, true);
    AppMethodBeat.o(81243);
  }
  
  public final void T(Bundle paramBundle) {}
  
  public final void a(int paramInt1, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2) {}
  
  protected final void cil()
  {
    AppMethodBeat.i(81246);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
      AppMethodBeat.o(81246);
      return;
    }
    ciS();
    AppMethodBeat.o(81246);
  }
  
  protected final b cim()
  {
    return null;
  }
  
  protected final int cin()
  {
    return 2130970611;
  }
  
  protected final int cio()
  {
    return qzu;
  }
  
  protected final void cip()
  {
    AppMethodBeat.i(81245);
    k(new Rect(0, 0, 0, 0));
    this.qzg.b(4, null);
    onResume();
    AppMethodBeat.o(81245);
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
    AppMethodBeat.i(81244);
    this.qwc = ((TextView)this.qzg.findViewById(2131827416));
    this.qwc.setText(2131302918);
    this.ivt = ((TextView)this.qzg.findViewById(2131827431));
    if (paramRect.bottom > 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ivt.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.qzg.getContext(), 13.0F));
      this.ivt.setLayoutParams(localLayoutParams);
    }
    if (com.tencent.mm.compatible.e.d.Ll()) {
      this.ivt.setPadding(BackwardSupportUtil.b.b(this.qzg.getContext(), 54.0F), this.ivt.getPaddingTop(), BackwardSupportUtil.b.b(this.qzg.getContext(), 54.0F), this.ivt.getPaddingBottom());
    }
    ciS();
    kC(true);
    AppMethodBeat.o(81244);
  }
  
  public final void le(long paramLong) {}
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(81251);
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    AppMethodBeat.o(81251);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(81250);
    this.qAq = true;
    kC(false);
    if (g.RG()) {
      g.Rc().b(424, this);
    }
    if (this.qAu != null) {
      this.qAu.removeMessages(0);
    }
    AppMethodBeat.o(81250);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(81249);
    this.qAq = false;
    if (g.RG()) {
      g.Rc().a(424, this);
    }
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
      AppMethodBeat.o(81249);
      return;
    }
    ciS();
    AppMethodBeat.o(81249);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(81248);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
      AppMethodBeat.o(81248);
      return;
    }
    this.qAs = false;
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81248);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(81248);
        return;
      }
      this.qAs = true;
      paramString = ((w)paramm).ajW();
      if ((paramString == null) || (paramString.wzV == null))
      {
        ab.d("MicroMsg.scanner.ScanModeStreetView", "resp null");
        AppMethodBeat.o(81248);
        return;
      }
      ab.i("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramString.jKs) });
      if (paramString.jKs == 0)
      {
        paramString = w.us(paramString.wzV);
        if (bo.isNullOrNil(paramString))
        {
          ab.e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
          AppMethodBeat.o(81248);
          return;
        }
        if (this.qAt == null) {
          this.qAt = new q.a(this, (byte)0);
        }
        this.qAt.url = paramString;
        al.ae(this.qAt);
        al.p(this.qAt, 800L);
        AppMethodBeat.o(81248);
        return;
      }
      if (paramString.jKs == 2)
      {
        if ((this.qAu == null) || (this.qAq))
        {
          AppMethodBeat.o(81248);
          return;
        }
        this.qAu.removeMessages(0);
        this.qAu.sendEmptyMessageDelayed(0, 1000L);
        AppMethodBeat.o(81248);
        return;
      }
      if (paramString.jKs == 1) {
        try
        {
          paramString = paramString.wzV;
          if (paramString != null)
          {
            paramString = br.F(paramString, "recommend");
            if (paramString != null)
            {
              paramm = w.b.f(paramString, ".recommend");
              w.b localb = new w.b();
              localb.title = bo.nullAsNil((String)paramString.get(".recommend.title"));
              localb.desc = bo.nullAsNil((String)paramString.get(".recommend.desc"));
              localb.fQb = paramm;
            }
          }
          AppMethodBeat.o(81248);
          return;
        }
        catch (Exception paramString)
        {
          ab.printErrStackTrace("MicroMsg.scanner.ScanModeStreetView", paramString, "", new Object[0]);
          ab.e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", new Object[] { paramString.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.q
 * JD-Core Version:    0.7.0.1
 */