package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.b.a.bu;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
  extends i
  implements b.a
{
  private long qvz;
  private long qws;
  private HighlightRectSideView qzo;
  boolean qzp;
  private bu qzq;
  private View.OnClickListener qzr;
  
  public j(i.b paramb, Point paramPoint, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    super(paramb, paramPoint);
    AppMethodBeat.i(81159);
    this.qzp = false;
    this.qzq = new bu();
    this.qzr = new j.1(this);
    if (paramInt == 1)
    {
      paramPoint = new Point(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      paramInt = paramPoint.y - (int)(118.0F * paramDisplayMetrics.density);
      paramPoint = new Point((int)((int)(paramInt * 1.586F) / paramDisplayMetrics.density), (int)(paramInt / paramDisplayMetrics.density));
      paramb.getContext().setResult(0);
      this.qze = 0;
      this.qzf = 64;
      fo(paramPoint.x, paramPoint.y);
      if (bo.hg(paramb.getContext()) >= 100L) {
        break label218;
      }
      ab.w("MicroMsg.ScanModeBankCard", "memory is not much");
    }
    label218:
    for (this.qvz = 280L;; this.qvz = 80L)
    {
      paramb = this.qzq;
      paramb.cRG = 1L;
      paramb.ake();
      this.qws = System.currentTimeMillis();
      AppMethodBeat.o(81159);
      return;
      paramPoint = new Point(paramDisplayMetrics.heightPixels, paramDisplayMetrics.widthPixels);
      break;
    }
  }
  
  public final void T(Bundle paramBundle) {}
  
  public final void a(int paramInt1, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(151674);
    ab.d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d", new Object[] { Integer.valueOf(paramInt1) });
    if (3 != paramInt1)
    {
      ab.e("MicroMsg.ScanModeBankCard", "decode success, but result type error:".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(151674);
      return;
    }
    paramArrayOfByte1 = this.qzq;
    paramArrayOfByte1.cRG = 2L;
    paramArrayOfByte1.cYV = (System.currentTimeMillis() - this.qws);
    paramArrayOfByte1.ake();
    paramArrayOfByte1 = ((h)this.qza).cju();
    if (this.qzp)
    {
      this.qzg.ciH();
      ConfirmScanBankCardResultUI.c(paramArrayOfByte1, paramString1);
      AppMethodBeat.o(151674);
      return;
    }
    paramArrayOfByte2 = new pv();
    paramArrayOfByte2.cGp.cardId = paramString1;
    paramArrayOfByte2.cGp.cGq = paramArrayOfByte1;
    a.ymk.l(paramArrayOfByte2);
    this.qzg.getContext().finish();
    AppMethodBeat.o(151674);
  }
  
  protected final void cil() {}
  
  protected final b cim()
  {
    AppMethodBeat.i(81161);
    if ((this.qza == null) && (this.qzg != null)) {
      this.qza = new h(this, this.qzg.ciF(), this.qzp);
    }
    b localb = this.qza;
    AppMethodBeat.o(81161);
    return localb;
  }
  
  protected final int cin()
  {
    return 2130970598;
  }
  
  protected final int cio()
  {
    return 300;
  }
  
  protected final void cip() {}
  
  protected final boolean ciq()
  {
    return false;
  }
  
  protected final boolean cir()
  {
    return false;
  }
  
  protected final void k(Rect paramRect)
  {
    AppMethodBeat.i(81163);
    LinearLayout localLinearLayout = (LinearLayout)this.qzg.findViewById(2131827408);
    TextView localTextView = (TextView)this.qzg.findViewById(2131827409);
    this.qzo = ((HighlightRectSideView)this.qzg.findViewById(2131827411));
    this.qzo.setMaskRect(paramRect);
    paramRect = this.qzg.getContext().getIntent();
    if (paramRect != null)
    {
      paramRect = bo.bf(paramRect.getStringExtra("bank_card_owner"), "");
      localTextView.setText(String.format(this.qzg.getContext().getResources().getString(2131302886), new Object[] { paramRect }));
    }
    for (;;)
    {
      if (bo.isNullOrNil(paramRect))
      {
        localLinearLayout.setVisibility(8);
        AppMethodBeat.o(81163);
        return;
      }
      localLinearLayout.setVisibility(0);
      ((ImageView)this.qzg.findViewById(2131827410)).setOnClickListener(this.qzr);
      AppMethodBeat.o(81163);
      return;
      paramRect = null;
    }
  }
  
  protected final void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(81162);
    super.kE(paramBoolean);
    if ((this.qza != null) && (this.qzg != null))
    {
      h localh = (h)this.qza;
      paramBoolean = this.qzg.ciF();
      ab.d("MicroMsg.ScanBankCardDecoder", "need rotate:".concat(String.valueOf(paramBoolean)));
      localh.qCF = paramBoolean;
    }
    AppMethodBeat.o(81162);
  }
  
  public final void le(long paramLong)
  {
    AppMethodBeat.i(81165);
    ab.d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
    if (this.qzg == null)
    {
      ab.e("MicroMsg.ScanModeBankCard", "ui callback is null");
      AppMethodBeat.o(81165);
      return;
    }
    boolean[] arrayOfBoolean = ((h)this.qza).qCH;
    this.qzo.setShowRectEdges(arrayOfBoolean);
    this.qzg.lf(this.qvz);
    AppMethodBeat.o(81165);
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(81160);
    bu localbu = this.qzq;
    localbu.cRG = 4L;
    localbu.ake();
    AppMethodBeat.o(81160);
  }
  
  protected final void onPause() {}
  
  protected final void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.j
 * JD-Core Version:    0.7.0.1
 */