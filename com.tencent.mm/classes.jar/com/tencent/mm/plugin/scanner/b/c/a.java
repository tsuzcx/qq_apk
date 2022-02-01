package com.tencent.mm.plugin.scanner.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.b.a.ge;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.scanner.d.e;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.plugin.scanner.d.e.b;
import com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.scanlib.ui.ScanView;

public final class a
  extends e
  implements com.tencent.mm.ak.g, e.a
{
  private int count;
  private String dnh;
  private Bitmap duT;
  public boolean wXU;
  private ge wXV;
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, ge paramge)
  {
    AppMethodBeat.i(118336);
    this.mode = paramInt;
    this.xbg = paramScanView;
    this.xbh = paramb;
    this.wXV = paramge;
    this.context = paramScanView.getContext();
    this.dnh = ah.dg(u.axw() + System.currentTimeMillis());
    com.tencent.mm.kernel.g.agi().a(2693, this);
    AppMethodBeat.o(118336);
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(118337);
    if (paramBundle != null)
    {
      this.duT = ((Bitmap)paramBundle.getParcelable("param_card_bitmap"));
      if (this.duT != null)
      {
        paramBundle = this.dnh;
        byte[] arrayOfByte = f.Bitmap2Bytes(this.duT);
        int i = this.count;
        this.count = (i + 1);
        paramBundle = new com.tencent.mm.plugin.scanner.b.b.a(paramBundle, arrayOfByte, i);
        com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
        AppMethodBeat.o(118337);
        return;
      }
      s(2, null);
    }
    AppMethodBeat.o(118337);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(118338);
    com.tencent.mm.kernel.g.agi().b(2693, this);
    AppMethodBeat.o(118338);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(118340);
    ac.i("MicroMsg.BankCardHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.dnh.equals(((com.tencent.mm.plugin.scanner.b.b.a)paramn).dnh))
      {
        paramString = (com.tencent.mm.plugin.scanner.b.b.a)paramn;
        Object localObject;
        if (paramString.rr.hvs.hvw != null)
        {
          paramString = ((ni)paramString.rr.hvs.hvw).Edn;
          if (paramString == null) {
            break label389;
          }
          paramn = paramString.DVX.text;
          ac.d("MicroMsg.BankCardHandler", "cardNumber %s", new Object[] { paramn });
          paramString = new Rect((int)paramString.DVX.FnL.Fun.x, (int)paramString.DVX.FnL.Fun.y, (int)paramString.DVX.FnL.Fup.x, (int)paramString.DVX.FnL.Fup.y);
          ac.i("MicroMsg.BankCardHandler", "cropRect %s", new Object[] { paramString });
          localObject = this.duT;
          if ((paramString.left < 0) || (paramString.top < 0) || (paramString.width() <= 0) || (paramString.width() > ((Bitmap)localObject).getWidth()) || (paramString.height() <= 0) || (paramString.height() > ((Bitmap)localObject).getHeight())) {
            break label344;
          }
          paramInt1 = 1;
          label264:
          if (paramInt1 == 0) {
            break label389;
          }
          paramString = Bitmap.createBitmap(this.duT, paramString.left, paramString.top, paramString.width(), paramString.height());
          if ((paramString == null) || (bs.isNullOrNil(paramn))) {
            break label389;
          }
          if (!this.wXU) {
            break label349;
          }
          ConfirmScanBankCardResultUI.c(paramString, paramn);
        }
        for (;;)
        {
          this.wXV.dHY = 3L;
          s(3, null);
          AppMethodBeat.o(118340);
          return;
          paramString = null;
          break;
          label344:
          paramInt1 = 0;
          break label264;
          label349:
          localObject = new rw();
          ((rw)localObject).duO.cardId = paramn;
          ((rw)localObject).duO.duP = paramString;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        }
      }
      label389:
      s(2, null);
      AppMethodBeat.o(118340);
      return;
    }
    s(2, null);
    AppMethodBeat.o(118340);
  }
  
  public final void s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(118339);
    ac.i("MicroMsg.BankCardHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118339);
      return;
      AppMethodBeat.o(118339);
      return;
      this.xbg.onResume();
      AppMethodBeat.o(118339);
      return;
      this.xbh.bRD();
      AppMethodBeat.o(118339);
      return;
      this.xbg.onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.c.a
 * JD-Core Version:    0.7.0.1
 */