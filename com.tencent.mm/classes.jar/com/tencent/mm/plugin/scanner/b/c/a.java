package com.tencent.mm.plugin.scanner.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.b.a.hj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.scanner.d.e;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.plugin.scanner.d.e.b;
import com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.scanlib.ui.ScanView;

public final class a
  extends e
  implements f, e.a
{
  private int count;
  private String dAa;
  private Bitmap dIa;
  public boolean yBE;
  private hj yBF;
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, hj paramhj)
  {
    AppMethodBeat.i(118336);
    this.mode = paramInt;
    this.yFe = paramScanView;
    this.yFf = paramb;
    this.yBF = paramhj;
    this.context = paramScanView.getContext();
    this.dAa = aj.ej(v.aAC() + System.currentTimeMillis());
    g.ajj().a(2693, this);
    AppMethodBeat.o(118336);
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(118337);
    if (paramBundle != null)
    {
      this.dIa = ((Bitmap)paramBundle.getParcelable("param_card_bitmap"));
      if (this.dIa != null)
      {
        paramBundle = this.dAa;
        byte[] arrayOfByte = h.Bitmap2Bytes(this.dIa);
        int i = this.count;
        this.count = (i + 1);
        paramBundle = new com.tencent.mm.plugin.scanner.b.b.a(paramBundle, arrayOfByte, i);
        g.ajj().a(paramBundle, 0);
        AppMethodBeat.o(118337);
        return;
      }
      t(2, null);
    }
    AppMethodBeat.o(118337);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(118338);
    g.ajj().b(2693, this);
    AppMethodBeat.o(118338);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(118340);
    ae.i("MicroMsg.BankCardHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.dAa.equals(((com.tencent.mm.plugin.scanner.b.b.a)paramn).dAa))
      {
        paramString = (com.tencent.mm.plugin.scanner.b.b.a)paramn;
        Object localObject;
        if (paramString.rr.hQE.hQJ != null)
        {
          paramString = ((og)paramString.rr.hQE.hQJ).GbT;
          if (paramString == null) {
            break label389;
          }
          paramn = paramString.FTO.text;
          ae.d("MicroMsg.BankCardHandler", "cardNumber %s", new Object[] { paramn });
          paramString = new Rect((int)paramString.FTO.HqU.HxS.x, (int)paramString.FTO.HqU.HxS.y, (int)paramString.FTO.HqU.HxU.x, (int)paramString.FTO.HqU.HxU.y);
          ae.i("MicroMsg.BankCardHandler", "cropRect %s", new Object[] { paramString });
          localObject = this.dIa;
          if ((paramString.left < 0) || (paramString.top < 0) || (paramString.width() <= 0) || (paramString.width() > ((Bitmap)localObject).getWidth()) || (paramString.height() <= 0) || (paramString.height() > ((Bitmap)localObject).getHeight())) {
            break label344;
          }
          paramInt1 = 1;
          label264:
          if (paramInt1 == 0) {
            break label389;
          }
          paramString = Bitmap.createBitmap(this.dIa, paramString.left, paramString.top, paramString.width(), paramString.height());
          if ((paramString == null) || (bu.isNullOrNil(paramn))) {
            break label389;
          }
          if (!this.yBE) {
            break label349;
          }
          ConfirmScanBankCardResultUI.c(paramString, paramn);
        }
        for (;;)
        {
          this.yBF.dWt = 3L;
          t(3, null);
          AppMethodBeat.o(118340);
          return;
          paramString = null;
          break;
          label344:
          paramInt1 = 0;
          break label264;
          label349:
          localObject = new sj();
          ((sj)localObject).dHV.cardId = paramn;
          ((sj)localObject).dHV.dHW = paramString;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        }
      }
      label389:
      t(2, null);
      AppMethodBeat.o(118340);
      return;
    }
    t(2, null);
    AppMethodBeat.o(118340);
  }
  
  public final void t(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(118339);
    ae.i("MicroMsg.BankCardHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118339);
      return;
      AppMethodBeat.o(118339);
      return;
      this.yFe.onResume();
      AppMethodBeat.o(118339);
      return;
      this.yFf.bXx();
      AppMethodBeat.o(118339);
      return;
      this.yFe.onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.c.a
 * JD-Core Version:    0.7.0.1
 */