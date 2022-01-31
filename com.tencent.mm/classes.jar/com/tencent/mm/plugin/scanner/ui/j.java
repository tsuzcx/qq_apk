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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.ot;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends i
  implements b.a
{
  private long nHZ;
  private HighlightRectSideView nLI;
  boolean nLJ = false;
  private View.OnClickListener nLK = new j.1(this);
  
  public j(i.b paramb, Point paramPoint, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    super(paramb, paramPoint);
    if (paramInt == 1) {}
    for (paramPoint = new Point(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);; paramPoint = new Point(paramDisplayMetrics.heightPixels, paramDisplayMetrics.widthPixels))
    {
      paramInt = paramPoint.y - (int)(118.0F * paramDisplayMetrics.density);
      paramPoint = new Point((int)((int)(paramInt * 1.586F) / paramDisplayMetrics.density), (int)(paramInt / paramDisplayMetrics.density));
      paramb.getContext().setResult(0);
      this.nLz = 0;
      this.nLA = 64;
      dG(paramPoint.x, paramPoint.y);
      if (bk.fQ(paramb.getContext()) >= 100L) {
        break;
      }
      y.w("MicroMsg.ScanModeBankCard", "memory is not much");
      this.nHZ = 280L;
      return;
    }
    this.nHZ = 80L;
  }
  
  public final void C(Bundle paramBundle) {}
  
  public final void b(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d", new Object[] { Integer.valueOf(paramInt1) });
    if (3 != paramInt1)
    {
      y.e("MicroMsg.ScanModeBankCard", "decode success, but result type error:" + paramInt1);
      return;
    }
    paramArrayOfByte1 = ((g)this.nLv).byo();
    if (this.nLJ)
    {
      this.nLB.bxG();
      ConfirmScanBankCardResultUI.c(paramArrayOfByte1, paramString);
      return;
    }
    paramArrayOfByte2 = new ot();
    paramArrayOfByte2.bYo.cardId = paramString;
    paramArrayOfByte2.bYo.bYp = paramArrayOfByte1;
    a.udP.m(paramArrayOfByte2);
    this.nLB.getContext().finish();
  }
  
  protected final void bxo() {}
  
  protected final b bxp()
  {
    if ((this.nLv == null) && (this.nLB != null)) {
      this.nLv = new g(this, this.nLB.bxE(), this.nLJ);
    }
    return this.nLv;
  }
  
  protected final int bxq()
  {
    return R.i.scan_bank_card;
  }
  
  protected final int bxr()
  {
    return 300;
  }
  
  protected final void bxs() {}
  
  protected final boolean bxt()
  {
    return false;
  }
  
  protected final boolean bxu()
  {
    return false;
  }
  
  public final void fB(long paramLong)
  {
    y.d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
    if (this.nLB == null)
    {
      y.e("MicroMsg.ScanModeBankCard", "ui callback is null");
      return;
    }
    boolean[] arrayOfBoolean = ((g)this.nLv).nOQ;
    this.nLI.setShowRectEdges(arrayOfBoolean);
    this.nLB.fC(this.nHZ);
  }
  
  protected final void iB(boolean paramBoolean)
  {
    super.iB(paramBoolean);
    if ((this.nLv != null) && (this.nLB != null))
    {
      g localg = (g)this.nLv;
      paramBoolean = this.nLB.bxE();
      y.d("MicroMsg.ScanBankCardDecoder", "need rotate:" + paramBoolean);
      localg.nOO = paramBoolean;
    }
  }
  
  protected final void j(Rect paramRect)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.nLB.findViewById(R.h.bank_card_container);
    TextView localTextView = (TextView)this.nLB.findViewById(R.h.bank_card_owner);
    this.nLI = ((HighlightRectSideView)this.nLB.findViewById(R.h.bank_card_highlight));
    this.nLI.setMaskRect(paramRect);
    paramRect = this.nLB.getContext().getIntent();
    if (paramRect != null)
    {
      paramRect = bk.aM(paramRect.getStringExtra("bank_card_owner"), "");
      localTextView.setText(String.format(this.nLB.getContext().getResources().getString(R.l.scan_bank_owner), new Object[] { paramRect }));
    }
    for (;;)
    {
      if (bk.bl(paramRect))
      {
        localLinearLayout.setVisibility(8);
        return;
      }
      localLinearLayout.setVisibility(0);
      ((ImageView)this.nLB.findViewById(R.h.bank_card_declare)).setOnClickListener(this.nLK);
      return;
      paramRect = null;
    }
  }
  
  protected final void onDestroy() {}
  
  protected final void onPause() {}
  
  protected final void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.j
 * JD-Core Version:    0.7.0.1
 */