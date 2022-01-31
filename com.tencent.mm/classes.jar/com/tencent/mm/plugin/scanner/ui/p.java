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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.nc.b;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.f.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.plugin.u.a.c.a;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p
  extends i
  implements f, i.a, b.a, c.a
{
  int bufferSize;
  Object ceY;
  int cpY;
  private int mMode;
  private TextView qAa;
  boolean qAb;
  private com.tencent.mm.plugin.scanner.util.i qAc;
  private com.tencent.mm.plugin.scanner.util.i.a qAd;
  private View.OnClickListener qAe;
  private int quA;
  private f.a qzF;
  com.tencent.mm.plugin.scanner.util.e qzR;
  AtomicBoolean qzS;
  boolean qzT;
  boolean qzU;
  private Set<Integer> qzV;
  private float qzW;
  byte[] qzX;
  Point qzY;
  int qzZ;
  long qzv;
  
  public p(i.b paramb, Point paramPoint, int paramInt1, int paramInt2)
  {
    super(paramb, paramPoint);
    AppMethodBeat.i(81212);
    this.qzv = 80L;
    this.cpY = 0;
    this.qzS = new AtomicBoolean(false);
    this.qzT = false;
    this.qzU = false;
    this.mMode = 0;
    this.qzW = 1.5F;
    this.ceY = new Object();
    this.qAb = false;
    this.qAc = null;
    this.qAd = null;
    this.qzF = new p.1(this);
    this.qAe = new p.3(this);
    fo(244, 244);
    this.cpY = paramInt1;
    this.mMode = paramInt2;
    this.qzi = true;
    this.qyY = 1000L;
    ciU();
    if (bo.hg(paramb.getContext()) < 100L)
    {
      ab.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
      this.qzv = 280L;
    }
    AppMethodBeat.o(81212);
  }
  
  public p(i.b paramb, Point paramPoint, int paramInt, Set<Integer> paramSet)
  {
    super(paramb, paramPoint);
    AppMethodBeat.i(81213);
    this.qzv = 80L;
    this.cpY = 0;
    this.qzS = new AtomicBoolean(false);
    this.qzT = false;
    this.qzU = false;
    this.mMode = 0;
    this.qzW = 1.5F;
    this.ceY = new Object();
    this.qAb = false;
    this.qAc = null;
    this.qAd = null;
    this.qzF = new p.1(this);
    this.qAe = new p.3(this);
    fo(244, 244);
    this.cpY = paramInt;
    this.qzV = paramSet;
    this.qzi = true;
    this.qyY = 1000L;
    ciU();
    if (bo.hg(paramb.getContext()) < 100L)
    {
      ab.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
      this.qzv = 280L;
    }
    AppMethodBeat.o(81213);
  }
  
  private void a(int paramInt1, String paramString1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(151684);
    Activity localActivity = this.qzg.getContext();
    nc localnc = new nc();
    if (paramInt1 == 1) {}
    for (localnc.cDm.cDo = 0;; localnc.cDm.cDo = 1)
    {
      localnc.cDm.scanResult = paramString1;
      if (!this.qAb) {
        break;
      }
      ab.d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
      localnc.cDm.bsY = 1;
      com.tencent.mm.sdk.b.a.ymk.l(localnc);
      paramString2 = new Intent();
      paramString2.putExtra("key_scan_result", paramString1);
      paramString2.putExtra("key_scan_result_raw", paramArrayOfByte);
      paramString2.putExtra("key_scan_result_type", paramInt1);
      paramString2.putExtra("key_scan_result_code_type", paramInt2);
      paramString2.putExtra("key_scan_result_code_version", paramInt3);
      localActivity.setResult(-1, paramString2);
      localActivity.finish();
      localActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(151684);
      return;
    }
    localnc.cDm.bsY = 0;
    com.tencent.mm.sdk.b.a.ymk.l(localnc);
    if ((localnc.cDn.ret == 1) || (localnc.cDn.ret == 2))
    {
      localActivity.finish();
      localActivity.overridePendingTransition(0, 0);
    }
    paramArrayOfByte = this.qzg.getContext().getIntent().getBundleExtra("_stat_obj");
    if (paramInt1 == 1)
    {
      this.qzg.ciy();
      this.qzg.kA(true);
      this.qzT = false;
      if (localnc.cDn.ret != 2)
      {
        if (this.qzU) {}
        for (paramInt1 = i;; paramInt1 = 0)
        {
          this.qzg.a(paramString1, paramInt1, paramInt2, paramInt3, paramString2, this.qzF, paramArrayOfByte);
          AppMethodBeat.o(151684);
          return;
        }
      }
    }
    else if (paramInt1 == 2)
    {
      a(paramString1, paramInt2, paramInt3, paramString2, paramArrayOfByte);
    }
    AppMethodBeat.o(151684);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(151685);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      ab.e("MicroMsg.scanner.ScanModeQRCode", "result is null");
      this.qzT = false;
      this.qzg.kA(false);
      AppMethodBeat.o(151685);
      return;
    }
    this.qAc.a(this.qzg.getContext(), paramString1, this.qzU, paramInt1, paramInt2, paramString2, this.qzF, paramBundle, ciR(), false, -1);
    AppMethodBeat.o(151685);
  }
  
  private void ciS()
  {
    AppMethodBeat.i(81221);
    if (this.qzg == null)
    {
      ab.e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
      AppMethodBeat.o(81221);
      return;
    }
    if ((com.tencent.mm.kernel.g.Rc().adt() == 6) || (com.tencent.mm.kernel.g.Rc().adt() == 4)) {
      this.qzg.lg(0L);
    }
    AppMethodBeat.o(81221);
  }
  
  private void ciU()
  {
    AppMethodBeat.i(151682);
    this.qAd = new p.2(this);
    this.qAc = new com.tencent.mm.plugin.scanner.util.i(this.qzg, this.qAd);
    AppMethodBeat.o(151682);
  }
  
  private void ciX()
  {
    AppMethodBeat.i(81233);
    if ((!this.qzS.get()) && (this.bufferSize > 0))
    {
      this.qzS.set(true);
      this.bufferSize -= 1;
      if ((this.qzV != null) && (this.qzV.size() > 0)) {
        ((com.tencent.mm.plugin.scanner.util.e)cim()).qzV = this.qzV;
      }
      for (;;)
      {
        ab.i("MicroMsg.scanner.ScanModeQRCode", "try decode,buffer size:" + this.bufferSize);
        if ((this.quA > 0) && (this.qzg != null)) {
          this.qzg.lf(30L);
        }
        if ((this.qzX != null) && (this.qzY != null))
        {
          ((com.tencent.mm.plugin.scanner.util.e)cim()).cjs();
          ((com.tencent.mm.plugin.scanner.util.e)cim()).a(this.qzX, this.qzY);
        }
        if ((n.qux.quA == 30) && (this.qzg != null)) {
          this.qzg.ciI();
        }
        this.quA += 1;
        AppMethodBeat.o(81233);
        return;
        if ((this.quA % 3 < 2) && ((this.mMode == 1) || (this.mMode == 0))) {
          ((com.tencent.mm.plugin.scanner.util.e)cim()).qCn = 3;
        } else {
          ((com.tencent.mm.plugin.scanner.util.e)cim()).qCn = this.mMode;
        }
      }
    }
    if (this.qzg != null) {
      this.qzg.lf(0L);
    }
    AppMethodBeat.o(81233);
  }
  
  public final void T(Bundle paramBundle)
  {
    AppMethodBeat.i(81232);
    if ((paramBundle.containsKey("zoom_action")) && (paramBundle.containsKey("zoom_type")) && (paramBundle.containsKey("zoom_scale")) && (this.qzg != null)) {
      this.qzg.ag(paramBundle.getInt("zoom_action"), paramBundle.getInt("zoom_type"), paramBundle.getInt("zoom_scale"));
    }
    AppMethodBeat.o(81232);
  }
  
  public final void a(int paramInt1, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(151683);
    this.qzS.set(false);
    this.quA = 0;
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
      AppMethodBeat.o(151683);
      return;
    }
    if (this.qzT)
    {
      ab.w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
      AppMethodBeat.o(151683);
      return;
    }
    this.qzT = true;
    ab.d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", new Object[] { paramString1 });
    if (bo.isNullOrNil(paramString1))
    {
      this.qzT = false;
      AppMethodBeat.o(151683);
      return;
    }
    if ((com.tencent.mm.kernel.g.Rc().adt() == 0) && (!this.qzj))
    {
      Toast.makeText(this.qzg.getContext(), this.qzg.getContext().getString(2131300044), 0).show();
      this.qzT = false;
      AppMethodBeat.o(151683);
      return;
    }
    o.qDy.stop();
    this.typeName = paramString2;
    a(paramInt1, paramString1, paramArrayOfByte1, paramInt2, paramInt3, paramString2);
    AppMethodBeat.o(151683);
  }
  
  protected final void a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(81234);
    synchronized (this.ceY)
    {
      if (this.bufferSize == 1)
      {
        ab.d("MicroMsg.scanner.ScanModeQRCode", "decode too slow");
        this.bufferSize = 0;
      }
      if (this.qzY == null) {
        this.qzY = new Point();
      }
      d.post(new p.8(this, paramArrayOfByte, paramPoint, paramInt, paramRect), "prepare_decode_data");
      AppMethodBeat.o(81234);
      return;
    }
  }
  
  public final void c(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(81229);
    this.qzT = true;
    if (paramInt2 != -1)
    {
      this.qzT = false;
      this.qzS.set(false);
      this.qzU = false;
      AppMethodBeat.o(81229);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81229);
      return;
      if (paramIntent == null)
      {
        ab.e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
        this.qzT = false;
        this.qzS.set(false);
        this.qzU = false;
        AppMethodBeat.o(81229);
        return;
      }
      this.qzS.set(true);
      paramIntent = com.tencent.mm.ui.tools.a.i(paramActivity, paramIntent, com.tencent.mm.plugin.i.c.YK());
      ab.d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", new Object[] { paramIntent });
      new ak().post(new p.6(this, paramActivity));
      if (this.qzR != null) {
        this.qzR.pJ();
      }
      if (this.qzg != null) {
        this.qzg.kA(true);
      }
      n.qux.reset();
      com.tencent.mm.plugin.scanner.e.chX().qtq.a(paramIntent, new p.7(this, paramActivity), null);
      AppMethodBeat.o(81229);
      return;
      this.qzg.ciH();
    }
  }
  
  public final void ciV()
  {
    this.qzi = false;
  }
  
  public final boolean ciW()
  {
    return this.qzi;
  }
  
  protected final void cil()
  {
    AppMethodBeat.i(81220);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
      AppMethodBeat.o(81220);
      return;
    }
    ciS();
    AppMethodBeat.o(81220);
  }
  
  protected final com.tencent.mm.plugin.scanner.util.b cim()
  {
    AppMethodBeat.i(81219);
    if ((this.qzR == null) && (this.qzg != null)) {
      this.qzR = new com.tencent.mm.plugin.scanner.util.e(this, this.mMode, this.qzg.ciF());
    }
    com.tencent.mm.plugin.scanner.util.e locale = this.qzR;
    AppMethodBeat.o(81219);
    return locale;
  }
  
  protected final int cin()
  {
    return 2130970610;
  }
  
  protected final int cio()
  {
    return 244;
  }
  
  protected final void cip()
  {
    AppMethodBeat.i(81218);
    k(new Rect(0, 0, 0, 0));
    if (this.mMode == 2) {
      this.qzg.b(4, null);
    }
    for (;;)
    {
      this.qzg.a(this);
      onResume();
      AppMethodBeat.o(81218);
      return;
      this.qzg.b(0, new p.4(this));
    }
  }
  
  protected final boolean ciq()
  {
    return true;
  }
  
  protected final boolean cir()
  {
    return true;
  }
  
  protected final void g(Point paramPoint)
  {
    AppMethodBeat.i(81214);
    this.qyZ = null;
    super.g(paramPoint);
    AppMethodBeat.o(81214);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(81230);
    if (this.qzg == null)
    {
      ab.e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
      AppMethodBeat.o(81230);
      return null;
    }
    Activity localActivity = this.qzg.getContext();
    AppMethodBeat.o(81230);
    return localActivity;
  }
  
  protected final void k(Rect paramRect)
  {
    AppMethodBeat.i(81217);
    this.qAa = ((TextView)this.qzg.findViewById(2131827437));
    this.qAa.setOnClickListener(this.qAe);
    this.ivt = ((TextView)this.qzg.findViewById(2131827431));
    if (paramRect.bottom > 0)
    {
      this.qAa.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ivt.getLayoutParams();
      localLayoutParams.topMargin = (paramRect.bottom + 0 + BackwardSupportUtil.b.b(this.qzg.getContext(), 13.0F));
      this.ivt.setLayoutParams(localLayoutParams);
    }
    ciS();
    if (this.mMode == 2) {
      this.ivt.setText(2131302190);
    }
    for (;;)
    {
      kC(true);
      AppMethodBeat.o(81217);
      return;
      if (this.mMode == 1) {
        this.ivt.setText(2131302189);
      } else if (this.cpY == 1) {
        this.ivt.setText(2131302254);
      } else if (this.cpY == 2) {
        this.ivt.setText(2131305916);
      } else {
        this.ivt.setText(2131302255);
      }
    }
  }
  
  protected final Rect kD(boolean paramBoolean)
  {
    AppMethodBeat.i(81216);
    Rect localRect = new Rect(H(true, paramBoolean));
    ab.i("MicroMsg.scanner.ScanModeQRCode", "display rect:".concat(String.valueOf(localRect)));
    int m = localRect.width();
    int n = localRect.height();
    int j = (int)(m * this.qzW);
    int k = (int)(n * this.qzW);
    int i = j;
    if (j > (int)(this.qzb.x * 0.85F)) {
      i = (int)(this.qzb.x * 0.85F);
    }
    j = k;
    if (k > (int)(this.qzb.y * 0.85F)) {
      j = (int)(this.qzb.y * 0.85F);
    }
    k = j;
    if (j % 2 == 1) {
      k = j - 1;
    }
    j = i;
    if (i % 2 == 1) {
      j = i - 1;
    }
    ab.i("MicroMsg.scanner.ScanModeQRCode", "newWidth:%d,newHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
    localRect.left -= (j - m) / 2;
    i = localRect.right;
    localRect.right = ((j - m) / 2 + i);
    localRect.top -= (k - n) / 2;
    localRect.bottom += (k - n) / 2;
    ab.i("MicroMsg.scanner.ScanModeQRCode", "scan rect:".concat(String.valueOf(localRect)));
    AppMethodBeat.o(81216);
    return localRect;
  }
  
  protected final void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(81215);
    super.kE(paramBoolean);
    if (this.qzR != null) {
      this.qzR.oIC = paramBoolean;
    }
    AppMethodBeat.o(81215);
  }
  
  public final void kn(boolean paramBoolean)
  {
    AppMethodBeat.i(81231);
    if (this.qzg == null)
    {
      ab.e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
      AppMethodBeat.o(81231);
      return;
    }
    if (paramBoolean)
    {
      this.qzT = false;
      this.qzg.kA(false);
      this.qzT = false;
      AppMethodBeat.o(81231);
      return;
    }
    this.qzg.getContext().finish();
    this.qzg.getContext().overridePendingTransition(0, 0);
    AppMethodBeat.o(81231);
  }
  
  public final void le(long paramLong)
  {
    AppMethodBeat.i(81224);
    ab.i("MicroMsg.scanner.ScanModeQRCode", "decodeFail cost %s", new Object[] { Long.valueOf(paramLong) });
    this.qzS.set(false);
    synchronized (this.ceY)
    {
      ciX();
      AppMethodBeat.o(81224);
      return;
    }
  }
  
  protected final void onDestroy()
  {
    this.qzX = null;
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(81227);
    super.onPause();
    kC(false);
    com.tencent.mm.kernel.g.Rc().b(666, this);
    com.tencent.mm.kernel.g.Rc().b(971, this);
    AppMethodBeat.o(81227);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(81226);
    com.tencent.mm.kernel.g.Rc().a(666, this);
    com.tencent.mm.kernel.g.Rc().a(971, this);
    if (this.qzg == null)
    {
      ab.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
      AppMethodBeat.o(81226);
      return;
    }
    if (!this.qzU) {
      this.qzT = false;
    }
    ciS();
    AppMethodBeat.o(81226);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(81225);
    ab.i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((this.qzg == null) || (paramm == null))
    {
      if (paramm == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        this.qzT = false;
        AppMethodBeat.o(81225);
        return;
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      h.a(this.qzg.getContext(), 2131302246, 2131297087, new p.5(this));
      AppMethodBeat.o(81225);
      return;
    }
    if ((this.qAc != null) && (this.qAc.c(this.qzg.getContext(), paramInt1, paramInt2)))
    {
      kn(true);
      AppMethodBeat.o(81225);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      h.h(this.qzg.getContext(), 2131302239, 2131297087);
      kn(true);
      AppMethodBeat.o(81225);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.qzg.getContext(), this.qzg.getContext().getString(2131300093, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      kn(true);
      AppMethodBeat.o(81225);
      return;
    }
    if (paramm.getType() == 1061)
    {
      paramString = ((com.tencent.mm.plugin.scanner.model.g)paramm).cif();
      if (paramString == null)
      {
        ab.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
        kn(true);
        AppMethodBeat.o(81225);
        return;
      }
      ab.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(paramString.jKs) });
      if (bo.isNullOrNil(paramString.wyR))
      {
        kn(true);
        AppMethodBeat.o(81225);
        return;
      }
      switch (q.a(paramString.jKs, paramString.wyR, this.qzg.getContext(), this.qzg, 4, this.qzF, ((com.tencent.mm.plugin.scanner.model.g)paramm).cpE, ((com.tencent.mm.plugin.scanner.model.g)paramm).cpF, this.qwn, ((com.tencent.mm.plugin.scanner.model.g)paramm).qup, false, this.typeName, -1))
      {
      }
      for (;;)
      {
        this.qzg.kA(false);
        AppMethodBeat.o(81225);
        return;
        this.qzg.getContext().finish();
        this.qzg.getContext().overridePendingTransition(0, 0);
        AppMethodBeat.o(81225);
        return;
        ab.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        continue;
        ab.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
        this.qzg.lg(0L);
      }
    }
    if (paramm.getType() == 666)
    {
      if ((paramm instanceof com.tencent.mm.ao.c))
      {
        this.qzg.kA(true);
        this.qzg.getContext().finish();
        this.qzg.getContext().overridePendingTransition(0, 0);
        AppMethodBeat.o(81225);
      }
    }
    else if (paramm.getType() == 971)
    {
      this.qzg.kA(true);
      this.qzg.getContext().finish();
      this.qzg.getContext().overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(81225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p
 * JD-Core Version:    0.7.0.1
 */