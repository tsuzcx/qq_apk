package com.tencent.mm.plugin.scanner.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.uh;
import com.tencent.mm.f.b.a.nw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.g.e;
import com.tencent.mm.plugin.scanner.g.e.a;
import com.tencent.mm.plugin.scanner.g.e.b;
import com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.ddq;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.scanlib.ui.ScanView;

public final class a
  extends e
  implements i, e.a
{
  public boolean IIH;
  private nw III;
  private int count;
  private String fLj;
  private Bitmap fTG;
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, nw paramnw)
  {
    AppMethodBeat.i(118336);
    this.mode = paramInt;
    this.IOw = paramScanView;
    this.IOx = paramb;
    this.III = paramnw;
    this.context = paramScanView.getContext();
    this.fLj = MD5Util.getMD5String(z.bcZ() + System.currentTimeMillis());
    h.aGY().a(2693, this);
    AppMethodBeat.o(118336);
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(118337);
    if (paramBundle != null)
    {
      this.fTG = ((Bitmap)paramBundle.getParcelable("param_card_bitmap"));
      if (this.fTG != null)
      {
        paramBundle = this.fLj;
        byte[] arrayOfByte = BitmapUtil.Bitmap2Bytes(this.fTG);
        int i = this.count;
        this.count = (i + 1);
        paramBundle = new com.tencent.mm.plugin.scanner.b.b.a(paramBundle, arrayOfByte, i);
        h.aGY().a(paramBundle, 0);
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
    h.aGY().b(2693, this);
    AppMethodBeat.o(118338);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(118340);
    Log.i("MicroMsg.BankCardHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.fLj.equals(((com.tencent.mm.plugin.scanner.b.b.a)paramq).fLj))
      {
        paramString = (com.tencent.mm.plugin.scanner.b.b.a)paramq;
        Object localObject;
        if (d.c.b(paramString.rr.lBS) != null)
        {
          paramString = ((oy)d.c.b(paramString.rr.lBS)).RXk;
          if (paramString == null) {
            break label389;
          }
          paramq = paramString.ROr.text;
          Log.d("MicroMsg.BankCardHandler", "cardNumber %s", new Object[] { paramq });
          paramString = new Rect((int)paramString.ROr.TLh.TUf.rBr, (int)paramString.ROr.TLh.TUf.rBs, (int)paramString.ROr.TLh.TUh.rBr, (int)paramString.ROr.TLh.TUh.rBs);
          Log.i("MicroMsg.BankCardHandler", "cropRect %s", new Object[] { paramString });
          localObject = this.fTG;
          if ((paramString.left < 0) || (paramString.top < 0) || (paramString.width() <= 0) || (paramString.width() > ((Bitmap)localObject).getWidth()) || (paramString.height() <= 0) || (paramString.height() > ((Bitmap)localObject).getHeight())) {
            break label344;
          }
          paramInt1 = 1;
          label264:
          if (paramInt1 == 0) {
            break label389;
          }
          paramString = Bitmap.createBitmap(this.fTG, paramString.left, paramString.top, paramString.width(), paramString.height());
          if ((paramString == null) || (Util.isNullOrNil(paramq))) {
            break label389;
          }
          if (!this.IIH) {
            break label349;
          }
          ConfirmScanBankCardResultUI.c(paramString, paramq);
        }
        for (;;)
        {
          this.III.gnP = 3L;
          t(3, null);
          AppMethodBeat.o(118340);
          return;
          paramString = null;
          break;
          label344:
          paramInt1 = 0;
          break label264;
          label349:
          localObject = new uh();
          ((uh)localObject).fTB.cardId = paramq;
          ((uh)localObject).fTB.fTC = paramString;
          EventCenter.instance.publish((IEvent)localObject);
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
    Log.i("MicroMsg.BankCardHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118339);
      return;
      AppMethodBeat.o(118339);
      return;
      this.IOw.onResume();
      AppMethodBeat.o(118339);
      return;
      this.IOx.cIP();
      AppMethodBeat.o(118339);
      return;
      this.IOw.onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.c.a
 * JD-Core Version:    0.7.0.1
 */