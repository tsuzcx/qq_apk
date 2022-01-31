package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.mi;
import com.tencent.mm.h.a.mi.b;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.ad.a.c.a;
import com.tencent.mm.plugin.scanner.a.g;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.plugin.scanner.util.d.1;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.protocal.c.jg;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p
  extends i
  implements f, c.a, i.a, b.a
{
  int bID = 0;
  Object bjn = new Object();
  int bufferSize;
  private int mMode = 0;
  long nLO = 80L;
  private e.a nLY = new p.1(this);
  d nMk;
  AtomicBoolean nMl = new AtomicBoolean(false);
  boolean nMm = false;
  boolean nMn = false;
  private Set<Integer> nMo;
  private float nMp = 1.5F;
  byte[] nMq;
  Point nMr;
  int nMs;
  private TextView nMt;
  boolean nMu = false;
  private View.OnClickListener nMv = new p.2(this);
  
  public p(i.b paramb, Point paramPoint, int paramInt1, int paramInt2)
  {
    super(paramb, paramPoint);
    dG(244, 244);
    this.bID = paramInt1;
    this.mMode = paramInt2;
    this.nLD = true;
    this.nLt = 1000L;
    if (bk.fQ(paramb.getContext()) < 100L)
    {
      y.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
      this.nLO = 280L;
    }
  }
  
  public p(i.b paramb, Point paramPoint, int paramInt, Set<Integer> paramSet)
  {
    super(paramb, paramPoint);
    dG(244, 244);
    this.bID = paramInt;
    this.nMo = paramSet;
    this.nLD = true;
    this.nLt = 1000L;
    if (bk.fQ(paramb.getContext()) < 100L)
    {
      y.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
      this.nLO = 280L;
    }
  }
  
  private void a(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 1;
    Activity localActivity = this.nLB.getContext();
    Object localObject = new mi();
    if (paramInt1 == 1)
    {
      ((mi)localObject).bVB.bVD = 0;
      ((mi)localObject).bVB.scanResult = paramString;
      if (!this.nMu) {
        break label167;
      }
      y.d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
      ((mi)localObject).bVB.bcw = 1;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_scan_result", paramString);
      ((Intent)localObject).putExtra("key_scan_result_raw", paramArrayOfByte);
      ((Intent)localObject).putExtra("key_scan_result_type", paramInt1);
      ((Intent)localObject).putExtra("key_scan_result_code_type", paramInt2);
      ((Intent)localObject).putExtra("key_scan_result_code_version", paramInt3);
      localActivity.setResult(-1, (Intent)localObject);
      localActivity.finish();
      localActivity.overridePendingTransition(0, 0);
    }
    label167:
    label297:
    do
    {
      do
      {
        return;
        ((mi)localObject).bVB.bVD = 1;
        break;
        ((mi)localObject).bVB.bcw = 0;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        if ((((mi)localObject).bVC.ret == 1) || (((mi)localObject).bVC.ret == 2))
        {
          localActivity.finish();
          localActivity.overridePendingTransition(0, 0);
        }
        if (paramInt1 != 1) {
          break label297;
        }
        this.nLB.bxy();
        this.nLB.ix(true);
        this.nMm = false;
      } while (((mi)localObject).bVC.ret == 2);
      if (this.nMn) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        this.nLB.a(paramString, paramInt1, paramInt2, paramInt3, this.nLY);
        return;
      }
    } while (paramInt1 != 2);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.e("MicroMsg.scanner.ScanModeQRCode", "result is null");
      this.nMm = false;
      this.nLB.ix(false);
      return;
    }
    paramString = paramString.split(",", 2);
    if ((paramString == null) || (paramString.length < 2))
    {
      y.e("MicroMsg.scanner.ScanModeQRCode", "wrong zbar format");
      this.nMm = false;
      this.nLB.ix(false);
      return;
    }
    paramString = new g(r.Mi(paramString[0]), paramString[1], paramInt2, paramInt3);
    paramString.nGX = this.nMn;
    au.Dk().a(paramString, 0);
    this.nLB.bxy();
    this.nLB.ix(true);
    paramArrayOfByte = this.nLB.getContext();
    this.nLB.getContext().getString(R.l.app_tip);
    this.dnm = h.b(paramArrayOfByte, this.nLB.getContext().getString(R.l.qrcode_scan_default), true, new p.5(this, paramString));
  }
  
  private void bxR()
  {
    if (this.nLB == null) {
      y.e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
    }
    while ((au.Dk().KG() != 6) && (au.Dk().KG() != 4)) {
      return;
    }
    this.nLB.fD(0L);
  }
  
  private void bxV()
  {
    if ((!this.nMl.get()) && (this.bufferSize > 0))
    {
      this.nMl.set(true);
      this.bufferSize -= 1;
      if ((this.nMo != null) && (this.nMo.size() > 0))
      {
        ((d)bxp()).nMo = this.nMo;
        y.i("MicroMsg.scanner.ScanModeQRCode", "try decode,buffer size:" + this.bufferSize);
        if ((com.tencent.mm.plugin.scanner.a.m.nHb.nHe > 0) && (this.nLB != null)) {
          this.nLB.fC(30L);
        }
        if ((this.nMq != null) && (this.nMr != null))
        {
          locald = (d)bxp();
          if (locald.gpg)
          {
            localSet2 = locald.nMo;
            if (localSet2 != null)
            {
              localSet1 = localSet2;
              if (!localSet2.isEmpty()) {}
            }
            else
            {
              localSet1 = d.wT(locald.nOx);
            }
            locald.g(localSet1);
          }
          e.a(new d.1((d)bxp(), this.nMq, this.nMr), "scan_decode", 10);
        }
        if ((com.tencent.mm.plugin.scanner.a.m.nHb.nHe == 30) && (this.nLB != null)) {
          this.nLB.bxH();
        }
      }
    }
    while (this.nLB == null) {
      for (;;)
      {
        d locald;
        Set localSet2;
        Set localSet1;
        return;
        if ((com.tencent.mm.plugin.scanner.a.m.nHb.nHe % 3 < 2) && ((this.mMode == 1) || (this.mMode == 0))) {
          ((d)bxp()).nOx = 3;
        } else {
          ((d)bxp()).nOx = this.mMode;
        }
      }
    }
    this.nLB.fC(0L);
  }
  
  public final void C(Bundle paramBundle)
  {
    if ((paramBundle.containsKey("zoom_action")) && (paramBundle.containsKey("zoom_type")) && (paramBundle.containsKey("zoom_scale")) && (this.nLB != null)) {
      this.nLB.V(paramBundle.getInt("zoom_action"), paramBundle.getInt("zoom_type"), paramBundle.getInt("zoom_scale"));
    }
  }
  
  protected final void a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    synchronized (this.bjn)
    {
      if (this.bufferSize == 1)
      {
        y.d("MicroMsg.scanner.ScanModeQRCode", "decode too slow");
        this.bufferSize = 0;
      }
      if (this.nMr == null) {
        this.nMr = new Point();
      }
      e.post(new p.8(this, paramArrayOfByte, paramPoint, paramInt, paramRect), "prepare_decode_data");
      return;
    }
  }
  
  public final void b(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    this.nMl.set(false);
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
      return;
    }
    if (this.nMm)
    {
      y.w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
      return;
    }
    this.nMm = true;
    y.d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", new Object[] { paramString });
    if (bk.bl(paramString))
    {
      this.nMm = false;
      return;
    }
    if (au.Dk().KG() == 0)
    {
      Toast.makeText(this.nLB.getContext(), this.nLB.getContext().getString(R.l.fmt_iap_err), 0).show();
      this.nMm = false;
      return;
    }
    com.tencent.mm.plugin.scanner.util.m.nPF.stop();
    a(paramInt1, paramString, paramArrayOfByte1, paramInt2, paramInt3);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramActivity == null) {
      return;
    }
    this.nMm = true;
    if (paramInt2 != -1)
    {
      this.nMm = false;
      this.nMl.set(false);
      this.nMn = false;
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.nLB.bxG();
      return;
    }
    if (paramIntent == null)
    {
      y.e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
      this.nMm = false;
      this.nMl.set(false);
      this.nMn = false;
      return;
    }
    this.nMl.set(true);
    au.Hx();
    paramIntent = com.tencent.mm.ui.tools.a.g(paramActivity, paramIntent, com.tencent.mm.model.c.FG());
    y.d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", new Object[] { paramIntent });
    new ah().post(new p.6(this, paramActivity));
    if (this.nMk != null) {
      this.nMk.nm();
    }
    if (this.nLB != null) {
      this.nLB.ix(true);
    }
    com.tencent.mm.plugin.scanner.a.m.nHb.reset();
    com.tencent.mm.plugin.scanner.c.bxd().nGn.a(paramIntent, new p.7(this, paramActivity), null);
  }
  
  public final void bxT()
  {
    this.nLD = false;
  }
  
  public final boolean bxU()
  {
    return this.nLD;
  }
  
  protected final void bxo()
  {
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
      return;
    }
    bxR();
  }
  
  protected final com.tencent.mm.plugin.scanner.util.b bxp()
  {
    if ((this.nMk == null) && (this.nLB != null)) {
      this.nMk = new d(this, this.mMode, this.nLB.bxE());
    }
    return this.nMk;
  }
  
  protected final int bxq()
  {
    return R.i.scan_qrcode_body;
  }
  
  protected final int bxr()
  {
    return 244;
  }
  
  protected final void bxs()
  {
    j(new Rect(0, 0, 0, 0));
    if (this.mMode == 2) {
      this.nLB.b(4, null);
    }
    for (;;)
    {
      this.nLB.a(this);
      onResume();
      return;
      this.nLB.b(0, new p.3(this));
    }
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
    y.i("MicroMsg.scanner.ScanModeQRCode", "decodeFail cost %s", new Object[] { Long.valueOf(paramLong) });
    this.nMl.set(false);
    synchronized (this.bjn)
    {
      bxV();
      return;
    }
  }
  
  public final Context getContext()
  {
    if (this.nLB == null)
    {
      y.e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
      return null;
    }
    return this.nLB.getContext();
  }
  
  protected final void h(Point paramPoint)
  {
    this.nLu = null;
    super.h(paramPoint);
  }
  
  protected final Rect iA(boolean paramBoolean)
  {
    Rect localRect = new Rect(D(true, paramBoolean));
    y.i("MicroMsg.scanner.ScanModeQRCode", "display rect:" + localRect);
    int m = localRect.width();
    int n = localRect.height();
    int j = (int)(m * this.nMp);
    int k = (int)(n * this.nMp);
    int i = j;
    if (j > (int)(this.nLw.x * 0.85F)) {
      i = (int)(this.nLw.x * 0.85F);
    }
    j = k;
    if (k > (int)(this.nLw.y * 0.85F)) {
      j = (int)(this.nLw.y * 0.85F);
    }
    k = j;
    if (j % 2 == 1) {
      k = j - 1;
    }
    j = i;
    if (i % 2 == 1) {
      j = i - 1;
    }
    y.i("MicroMsg.scanner.ScanModeQRCode", "newWidth:%d,newHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
    localRect.left -= (j - m) / 2;
    i = localRect.right;
    localRect.right = ((j - m) / 2 + i);
    localRect.top -= (k - n) / 2;
    localRect.bottom += (k - n) / 2;
    y.i("MicroMsg.scanner.ScanModeQRCode", "scan rect:" + localRect);
    return localRect;
  }
  
  protected final void iB(boolean paramBoolean)
  {
    super.iB(paramBoolean);
    if (this.nMk != null) {
      this.nMk.miw = paramBoolean;
    }
  }
  
  public final void im(boolean paramBoolean)
  {
    if (this.nLB == null)
    {
      y.e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
      return;
    }
    if (paramBoolean)
    {
      this.nLB.ix(false);
      return;
    }
    this.nLB.getContext().finish();
    this.nLB.getContext().overridePendingTransition(0, 0);
  }
  
  protected final void j(Rect paramRect)
  {
    this.nMt = ((TextView)this.nLB.findViewById(R.h.scan_to_my_qrcode));
    this.nMt.setOnClickListener(this.nMv);
    this.gSy = ((TextView)this.nLB.findViewById(R.h.scan_tip_tv));
    if (paramRect.bottom > 0)
    {
      this.nMt.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gSy.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.nLB.getContext(), 13.0F));
      this.gSy.setLayoutParams(localLayoutParams);
    }
    bxR();
    if (this.mMode == 2) {
      this.gSy.setText(R.l.qbar_tip_only_zbar);
    }
    for (;;)
    {
      iz(true);
      return;
      if (this.mMode == 1) {
        this.gSy.setText(R.l.qbar_tip_only_qrcode);
      } else if (this.bID == 1) {
        this.gSy.setText(R.l.qrcode_tip_in_discount_from_addmorefriend);
      } else if (this.bID == 2) {
        this.gSy.setText(R.l.webwx_login_introduction);
      } else {
        this.gSy.setText(R.l.qrcode_tip_in_discount_from_friend);
      }
    }
  }
  
  protected final void onDestroy()
  {
    this.nMq = null;
  }
  
  protected final void onPause()
  {
    super.onPause();
    iz(false);
    au.Dk().b(1061, this);
    au.Dk().b(666, this);
    au.Dk().b(971, this);
  }
  
  protected final void onResume()
  {
    au.Dk().a(1061, this);
    au.Dk().a(666, this);
    au.Dk().a(971, this);
    if (this.nLB == null)
    {
      y.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
      return;
    }
    if (!this.nMn) {
      this.nMm = false;
    }
    bxR();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    boolean bool;
    if ((this.nLB == null) || (paramm == null)) {
      if (paramm == null)
      {
        bool = true;
        y.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        this.nMm = false;
      }
    }
    label730:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if ((paramInt1 == 4) && (paramInt2 == -4))
        {
          h.a(this.nLB.getContext(), R.l.qrcode_no_user_tip, R.l.app_tip, new p.4(this));
          return;
        }
        int i;
        switch (paramInt1)
        {
        default: 
          i = 0;
        }
        while (i != 0)
        {
          im(true);
          return;
          if (au.Dk().KH())
          {
            this.nLB.getContext();
            au.Dk().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
          }
          for (;;)
          {
            i = 1;
            break;
            if (ab.bG(this.nLB.getContext())) {
              j.eY(this.nLB.getContext());
            } else {
              Toast.makeText(this.nLB.getContext(), this.nLB.getContext().getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
            }
          }
          Toast.makeText(this.nLB.getContext(), this.nLB.getContext().getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
          i = 1;
        }
        if ((paramInt1 == 4) && (paramInt2 == -2004))
        {
          h.h(this.nLB.getContext(), R.l.qrcode_ban_by_expose, R.l.app_tip);
          im(true);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Toast.makeText(this.nLB.getContext(), this.nLB.getContext().getString(R.l.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
          im(true);
          return;
        }
        if (paramm.getType() == 1061)
        {
          paramString = ((g)paramm).bxh();
          if (paramString == null)
          {
            y.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
            im(true);
            return;
          }
          y.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(paramString.hQR) });
          if (bk.bl(paramString.sDp))
          {
            im(true);
            return;
          }
          switch (o.a(paramString.hQR, paramString.sDp, this, 4, this.nLY, ((g)paramm).bIj, ((g)paramm).bIk, ((g)paramm).nGX))
          {
          }
          for (;;)
          {
            this.nLB.ix(false);
            return;
            this.nLB.getContext().finish();
            this.nLB.getContext().overridePendingTransition(0, 0);
            return;
            y.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
            continue;
            y.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
            this.nLB.fD(0L);
          }
        }
        if (paramm.getType() != 666) {
          break label730;
        }
      } while (!(paramm instanceof u));
      this.nLB.ix(true);
      this.nLB.getContext().finish();
      this.nLB.getContext().overridePendingTransition(0, 0);
      return;
    } while (paramm.getType() != 971);
    this.nLB.ix(true);
    this.nLB.getContext().finish();
    this.nLB.getContext().overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p
 * JD-Core Version:    0.7.0.1
 */