package com.tencent.mm.plugin.scanner.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.b.a.eo;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.scanner.d.e;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.plugin.scanner.d.e.b;
import com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.scanlib.ui.ScanView;

public final class a
  extends e
  implements com.tencent.mm.al.g, e.a
{
  private int count;
  private String dpw;
  private Bitmap dxg;
  private eo vNA;
  public boolean vNz;
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, eo parameo)
  {
    AppMethodBeat.i(118336);
    this.mode = paramInt;
    this.vQz = paramScanView;
    this.vQA = paramb;
    this.vNA = parameo;
    this.context = paramScanView.getContext();
    this.dpw = ai.du(u.aqG() + System.currentTimeMillis());
    com.tencent.mm.kernel.g.aeS().a(2693, this);
    AppMethodBeat.o(118336);
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(118337);
    if (paramBundle != null)
    {
      this.dxg = ((Bitmap)paramBundle.getParcelable("param_card_bitmap"));
      if (this.dxg != null)
      {
        paramBundle = this.dpw;
        byte[] arrayOfByte = f.Bitmap2Bytes(this.dxg);
        int i = this.count;
        this.count = (i + 1);
        paramBundle = new com.tencent.mm.plugin.scanner.b.b.a(paramBundle, arrayOfByte, i);
        com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
        AppMethodBeat.o(118337);
        return;
      }
      r(2, null);
    }
    AppMethodBeat.o(118337);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(118338);
    com.tencent.mm.kernel.g.aeS().b(2693, this);
    AppMethodBeat.o(118338);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(118340);
    ad.i("MicroMsg.BankCardHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.dpw.equals(((com.tencent.mm.plugin.scanner.b.b.a)paramn).dpw))
      {
        paramString = (com.tencent.mm.plugin.scanner.b.b.a)paramn;
        Object localObject;
        if (paramString.rr.gUT.gUX != null)
        {
          paramString = ((nb)paramString.rr.gUT.gUX).CKL;
          if (paramString == null) {
            break label389;
          }
          paramn = paramString.CDy.text;
          ad.d("MicroMsg.BankCardHandler", "cardNumber %s", new Object[] { paramn });
          paramString = new Rect((int)paramString.CDy.DRt.DXt.x, (int)paramString.CDy.DRt.DXt.y, (int)paramString.CDy.DRt.DXv.x, (int)paramString.CDy.DRt.DXv.y);
          ad.i("MicroMsg.BankCardHandler", "cropRect %s", new Object[] { paramString });
          localObject = this.dxg;
          if ((paramString.left < 0) || (paramString.top < 0) || (paramString.width() <= 0) || (paramString.width() > ((Bitmap)localObject).getWidth()) || (paramString.height() <= 0) || (paramString.height() > ((Bitmap)localObject).getHeight())) {
            break label344;
          }
          paramInt1 = 1;
          label264:
          if (paramInt1 == 0) {
            break label389;
          }
          paramString = Bitmap.createBitmap(this.dxg, paramString.left, paramString.top, paramString.width(), paramString.height());
          if ((paramString == null) || (bt.isNullOrNil(paramn))) {
            break label389;
          }
          if (!this.vNz) {
            break label349;
          }
          ConfirmScanBankCardResultUI.c(paramString, paramn);
        }
        for (;;)
        {
          this.vNA.dKe = 3L;
          r(3, null);
          AppMethodBeat.o(118340);
          return;
          paramString = null;
          break;
          label344:
          paramInt1 = 0;
          break label264;
          label349:
          localObject = new rn();
          ((rn)localObject).dxb.cardId = paramn;
          ((rn)localObject).dxb.dxc = paramString;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        }
      }
      label389:
      r(2, null);
      AppMethodBeat.o(118340);
      return;
    }
    r(2, null);
    AppMethodBeat.o(118340);
  }
  
  public final void r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(118339);
    ad.i("MicroMsg.BankCardHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118339);
      return;
      AppMethodBeat.o(118339);
      return;
      this.vQz.onResume();
      AppMethodBeat.o(118339);
      return;
      this.vQA.bKq();
      AppMethodBeat.o(118339);
      return;
      this.vQz.onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.c.a
 * JD-Core Version:    0.7.0.1
 */