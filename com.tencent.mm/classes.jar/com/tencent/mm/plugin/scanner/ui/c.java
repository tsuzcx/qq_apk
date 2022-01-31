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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.px;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.lo;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;

public abstract class c
  extends i
  implements com.tencent.mm.plugin.scanner.util.b.a
{
  int qvA = 0;
  private HighlightRectSideView qvB;
  com.tencent.mm.ai.m qvC = null;
  private com.tencent.mm.ui.base.p qvD = null;
  private com.tencent.mm.ui.widget.b.c qvE = null;
  private long qvz;
  
  public c(i.b paramb, Point paramPoint, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    super(paramb, paramPoint);
    this.qze = 0;
    this.qzf = 0;
    float f = getAspectRatio();
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
      this.qzf = ((int)((paramPoint.y / paramDisplayMetrics.density - localPoint.y) / 2.0F));
      fo(localPoint.x, localPoint.y);
      if (bo.hg(paramb.getContext()) >= 100L) {
        break label238;
      }
      ab.w("MicroMsg.BaseScanModeLicence", "memory is not much");
      this.qvz = 280L;
      return;
      paramPoint = new Point(paramDisplayMetrics.heightPixels, paramDisplayMetrics.widthPixels);
      break;
      label226:
      paramInt = (int)(i * f);
    }
    label238:
    this.qvz = 80L;
  }
  
  private void C(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      localpx = new px();
      localpx.cGs.cardType = paramString1;
      localpx.cGs.cGt = 1;
      localpx.cGs.cGu = paramString2;
      if ((this.qza instanceof com.tencent.mm.plugin.scanner.util.m)) {
        localpx.cGs.cGv = ((com.tencent.mm.plugin.scanner.util.m)this.qza).qDq;
      }
      a.ymk.a(localpx, Looper.getMainLooper());
      if (this.qvD != null) {
        this.qvD.dismiss();
      }
      this.qzg.getContext().finish();
      return;
    }
    if (((paramInt & 0x2) > 0) && ((paramInt & 0x1) > 0))
    {
      localpx = new px();
      localpx.cGs.cardType = paramString1;
      localpx.cGs.cGt = 0;
      localpx.cGs.cGu = paramString2;
      a.ymk.a(localpx, Looper.getMainLooper());
      if (this.qvD != null) {
        this.qvD.dismiss();
      }
      this.qzg.getContext().finish();
      return;
    }
    if (this.qvA >= 3)
    {
      localpx = new px();
      localpx.cGs.cardType = paramString1;
      localpx.cGs.cGt = 1;
      localpx.cGs.cGu = paramString2;
      if ((this.qza instanceof com.tencent.mm.plugin.scanner.util.m)) {
        localpx.cGs.cGv = ((com.tencent.mm.plugin.scanner.util.m)this.qza).qDq;
      }
      a.ymk.a(localpx, Looper.getMainLooper());
      if (this.qvD != null) {
        this.qvD.dismiss();
      }
      this.qzg.getContext().finish();
      return;
    }
    if (((paramInt & 0x1) > 0) && (this.qvA < 3))
    {
      if (this.qvD != null) {
        this.qvD.dismiss();
      }
      cim().restartDecoder();
      CG(paramInt);
      cis();
      return;
    }
    px localpx = new px();
    localpx.cGs.cardType = paramString1;
    localpx.cGs.cGt = 0;
    localpx.cGs.cGu = paramString2;
    a.ymk.a(localpx, Looper.getMainLooper());
    if (this.qvD != null) {
      this.qvD.dismiss();
    }
    this.qzg.getContext().finish();
  }
  
  private void CG(int paramInt)
  {
    if ((paramInt & 0x20) > 0) {
      paramInt = 2131302910;
    }
    for (;;)
    {
      Toast.makeText(this.qzg.getContext(), paramInt, 0).show();
      return;
      if ((paramInt & 0x40) > 0) {
        paramInt = 2131302911;
      } else {
        paramInt = 2131302909;
      }
    }
  }
  
  private void cis()
  {
    boolean[] arrayOfBoolean = ((com.tencent.mm.plugin.scanner.util.m)this.qza).cjH();
    this.qvB.setShowRectEdges(arrayOfBoolean);
    this.qzg.lf(this.qvz);
  }
  
  public final void T(Bundle paramBundle) {}
  
  protected abstract com.tencent.mm.plugin.scanner.util.b a(com.tencent.mm.plugin.scanner.util.b.a parama);
  
  public void a(int paramInt1, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2)
  {
    ab.d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
    paramArrayOfByte1 = ((com.tencent.mm.plugin.scanner.util.m)this.qza).qDq;
    paramString1 = cij();
    if (this.qvD != null) {
      this.qvD.dismiss();
    }
    paramArrayOfByte2 = this.qzg.getContext();
    paramArrayOfByte2.getString(2131297087);
    this.qvD = h.b(paramArrayOfByte2, paramArrayOfByte2.getString(2131302912), false, null);
    this.qvD.setOnKeyListener(new c.2(this, paramString1));
    paramArrayOfByte2 = new com.tencent.mm.ai.b.a();
    paramArrayOfByte2.fsX = new lo();
    paramArrayOfByte2.fsY = new lp();
    paramArrayOfByte2.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
    paramArrayOfByte2.funcId = 1803;
    paramArrayOfByte2 = paramArrayOfByte2.ado();
    paramString2 = new ByteArrayOutputStream();
    if (!paramArrayOfByte1.compress(Bitmap.CompressFormat.JPEG, 80, paramString2))
    {
      C(2, paramString1, "");
      return;
    }
    paramArrayOfByte1 = paramString2.toByteArray();
    if (bo.ce(paramArrayOfByte1))
    {
      C(2, paramString1, "");
      return;
    }
    paramString2 = (lo)paramArrayOfByte2.fsV.fta;
    paramString2.wzZ = new com.tencent.mm.bv.b(paramArrayOfByte1);
    if (paramString1.equals("driving")) {
      paramString2.wzY = 0;
    }
    for (;;)
    {
      this.qvC = w.a(paramArrayOfByte2, new c.1(this, paramString1), false);
      return;
      if (paramString1.equals("identity")) {
        paramString2.wzY = 1;
      }
    }
  }
  
  protected abstract String cij();
  
  protected abstract int cik();
  
  protected final void cil() {}
  
  protected final com.tencent.mm.plugin.scanner.util.b cim()
  {
    if (this.qza == null) {
      this.qza = a(this);
    }
    return this.qza;
  }
  
  protected final int cin()
  {
    return 2130970607;
  }
  
  protected final int cio()
  {
    return 0;
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
  
  protected final void dz(View paramView)
  {
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131827433);
      if (localTextView != null) {
        localTextView.setText(paramView.getContext().getString(2131302907, new Object[] { paramView.getContext().getString(cik()) }));
      }
    }
  }
  
  protected abstract float getAspectRatio();
  
  protected final void k(Rect paramRect)
  {
    ab.d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", new Object[] { paramRect });
    HighlightRectSideView localHighlightRectSideView = (HighlightRectSideView)this.qzg.findViewById(2131827432);
    if (localHighlightRectSideView != null) {
      localHighlightRectSideView.setMaskRect(paramRect);
    }
    this.qvB = localHighlightRectSideView;
  }
  
  public final void le(long paramLong)
  {
    ab.d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
    if (this.qzg == null)
    {
      ab.e("MicroMsg.BaseScanModeLicence", "ui callback is null");
      return;
    }
    cis();
  }
  
  protected final void onDestroy() {}
  
  protected final void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c
 * JD-Core Version:    0.7.0.1
 */