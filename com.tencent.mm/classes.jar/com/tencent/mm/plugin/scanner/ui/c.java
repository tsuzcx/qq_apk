package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.h.a.ov;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.protocal.c.jk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class c
  extends i
  implements com.tencent.mm.plugin.scanner.util.b.a
{
  private long nHZ;
  int nIa = 0;
  private HighlightRectSideView nIb;
  m nIc = null;
  private com.tencent.mm.ui.base.p nId = null;
  private com.tencent.mm.ui.widget.a.c nIe = null;
  
  public c(i.b paramb, Point paramPoint, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    super(paramb, paramPoint);
    this.nLz = 0;
    this.nLA = 0;
    float f = bxl();
    int i;
    if (paramInt == 1)
    {
      paramPoint = new Point(paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
      i = (int)(paramPoint.y * 0.8F);
      paramInt = (int)(paramPoint.x * 0.8F);
      if (i * f <= paramPoint.x) {
        break label226;
      }
      i = (int)(paramInt / f);
    }
    for (;;)
    {
      Point localPoint = new Point((int)(paramInt / paramDisplayMetrics.density), (int)(i / paramDisplayMetrics.density));
      this.nLA = ((int)((paramPoint.y / paramDisplayMetrics.density - localPoint.y) / 2.0F));
      dG(localPoint.x, localPoint.y);
      if (bk.fQ(paramb.getContext()) >= 100L) {
        break label238;
      }
      y.w("MicroMsg.BaseScanModeLicence", "memory is not much");
      this.nHZ = 280L;
      return;
      paramPoint = new Point(paramDisplayMetrics.heightPixels, paramDisplayMetrics.widthPixels);
      break;
      label226:
      paramInt = (int)(i * f);
    }
    label238:
    this.nHZ = 80L;
  }
  
  private void bxv()
  {
    boolean[] arrayOfBoolean = ((k)this.nLv).byx();
    this.nIb.setShowRectEdges(arrayOfBoolean);
    this.nLB.fC(this.nHZ);
  }
  
  private void s(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      localov = new ov();
      localov.bYr.cardType = paramString1;
      localov.bYr.bYs = 1;
      localov.bYr.bYt = paramString2;
      if ((this.nLv instanceof k)) {
        localov.bYr.bYu = ((k)this.nLv).nPx;
      }
      a.udP.a(localov, Looper.getMainLooper());
      if (this.nId != null) {
        this.nId.dismiss();
      }
      this.nLB.getContext().finish();
      return;
    }
    if (((paramInt & 0x2) > 0) && ((paramInt & 0x1) > 0))
    {
      localov = new ov();
      localov.bYr.cardType = paramString1;
      localov.bYr.bYs = 0;
      localov.bYr.bYt = paramString2;
      a.udP.a(localov, Looper.getMainLooper());
      if (this.nId != null) {
        this.nId.dismiss();
      }
      this.nLB.getContext().finish();
      return;
    }
    if (this.nIa >= 3)
    {
      localov = new ov();
      localov.bYr.cardType = paramString1;
      localov.bYr.bYs = 1;
      localov.bYr.bYt = paramString2;
      if ((this.nLv instanceof k)) {
        localov.bYr.bYu = ((k)this.nLv).nPx;
      }
      a.udP.a(localov, Looper.getMainLooper());
      if (this.nId != null) {
        this.nId.dismiss();
      }
      this.nLB.getContext().finish();
      return;
    }
    if (((paramInt & 0x1) > 0) && (this.nIa < 3))
    {
      if (this.nId != null) {
        this.nId.dismiss();
      }
      bxp().byg();
      if ((paramInt & 0x20) > 0) {
        paramInt = R.l.scan_license_image_incomplete;
      }
      for (;;)
      {
        Toast.makeText(this.nLB.getContext(), paramInt, 0).show();
        bxv();
        return;
        if ((paramInt & 0x40) > 0) {
          paramInt = R.l.scan_license_image_too_dark;
        } else {
          paramInt = R.l.scan_license_continue;
        }
      }
    }
    ov localov = new ov();
    localov.bYr.cardType = paramString1;
    localov.bYr.bYs = 0;
    localov.bYr.bYt = paramString2;
    a.udP.a(localov, Looper.getMainLooper());
    if (this.nId != null) {
      this.nId.dismiss();
    }
    this.nLB.getContext().finish();
  }
  
  public final void C(Bundle paramBundle) {}
  
  protected abstract com.tencent.mm.plugin.scanner.util.b a(com.tencent.mm.plugin.scanner.util.b.a parama);
  
  public void b(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
    paramArrayOfByte1 = ((k)this.nLv).nPx;
    paramString = bxm();
    if (this.nId != null) {
      this.nId.dismiss();
    }
    paramArrayOfByte2 = this.nLB.getContext();
    paramArrayOfByte2.getString(R.l.app_tip);
    this.nId = h.b(paramArrayOfByte2, paramArrayOfByte2.getString(R.l.scan_license_server_recognising), false, null);
    this.nId.setOnKeyListener(new c.2(this, paramString));
    paramArrayOfByte2 = new com.tencent.mm.ah.b.a();
    paramArrayOfByte2.ecH = new jj();
    paramArrayOfByte2.ecI = new jk();
    paramArrayOfByte2.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
    paramArrayOfByte2.ecG = 1803;
    paramArrayOfByte2 = paramArrayOfByte2.Kt();
    Object localObject = new ByteArrayOutputStream();
    if (!paramArrayOfByte1.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject))
    {
      s(2, paramString, "");
      return;
    }
    paramArrayOfByte1 = ((ByteArrayOutputStream)localObject).toByteArray();
    if (bk.bE(paramArrayOfByte1))
    {
      s(2, paramString, "");
      return;
    }
    localObject = (jj)paramArrayOfByte2.ecE.ecN;
    ((jj)localObject).sEa = new com.tencent.mm.bv.b(paramArrayOfByte1);
    if (paramString.equals("driving")) {
      ((jj)localObject).sDZ = 0;
    }
    for (;;)
    {
      this.nIc = w.a(paramArrayOfByte2, new c.1(this, paramString), false);
      return;
      if (paramString.equals("identity")) {
        ((jj)localObject).sDZ = 1;
      }
    }
  }
  
  protected abstract float bxl();
  
  protected abstract String bxm();
  
  protected abstract int bxn();
  
  protected final void bxo() {}
  
  protected final com.tencent.mm.plugin.scanner.util.b bxp()
  {
    if (this.nLv == null) {
      this.nLv = a(this);
    }
    return this.nLv;
  }
  
  protected final int bxq()
  {
    return R.i.scan_licence;
  }
  
  protected final int bxr()
  {
    return 0;
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
  
  protected final void cK(View paramView)
  {
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(R.h.card_tips);
      if (localTextView != null) {
        localTextView.setText(paramView.getContext().getString(R.l.scan_licence_tips, new Object[] { paramView.getContext().getString(bxn()) }));
      }
    }
  }
  
  public final void fB(long paramLong)
  {
    y.d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
    if (this.nLB == null)
    {
      y.e("MicroMsg.BaseScanModeLicence", "ui callback is null");
      return;
    }
    bxv();
  }
  
  protected final void j(Rect paramRect)
  {
    y.d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", new Object[] { paramRect });
    HighlightRectSideView localHighlightRectSideView = (HighlightRectSideView)this.nLB.findViewById(R.h.card_highlight);
    if (localHighlightRectSideView != null) {
      localHighlightRectSideView.setMaskRect(paramRect);
    }
    this.nIb = localHighlightRectSideView;
  }
  
  protected final void onDestroy() {}
  
  protected final void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c
 * JD-Core Version:    0.7.0.1
 */