package com.tencent.mm.plugin.scanner.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.b.a.la;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.f.e.a;
import com.tencent.mm.plugin.scanner.f.e.b;
import com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.protocal.protobuf.pc;
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
  public boolean CEf;
  private la CEg;
  private int count;
  private String dRM;
  private Bitmap dZM;
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, la paramla)
  {
    AppMethodBeat.i(118336);
    this.mode = paramInt;
    this.CIW = paramScanView;
    this.CIX = paramb;
    this.CEg = paramla;
    this.context = paramScanView.getContext();
    this.dRM = MD5Util.getMD5String(z.aTY() + System.currentTimeMillis());
    g.azz().a(2693, this);
    AppMethodBeat.o(118336);
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(118337);
    if (paramBundle != null)
    {
      this.dZM = ((Bitmap)paramBundle.getParcelable("param_card_bitmap"));
      if (this.dZM != null)
      {
        paramBundle = this.dRM;
        byte[] arrayOfByte = BitmapUtil.Bitmap2Bytes(this.dZM);
        int i = this.count;
        this.count = (i + 1);
        paramBundle = new com.tencent.mm.plugin.scanner.b.b.a(paramBundle, arrayOfByte, i);
        g.azz().a(paramBundle, 0);
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
    g.azz().b(2693, this);
    AppMethodBeat.o(118338);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(118340);
    Log.i("MicroMsg.BankCardHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.dRM.equals(((com.tencent.mm.plugin.scanner.b.b.a)paramq).dRM))
      {
        paramString = (com.tencent.mm.plugin.scanner.b.b.a)paramq;
        Object localObject;
        if (paramString.rr.iLL.iLR != null)
        {
          paramString = ((pc)paramString.rr.iLL.iLR).KVW;
          if (paramString == null) {
            break label389;
          }
          paramq = paramString.KNx.text;
          Log.d("MicroMsg.BankCardHandler", "cardNumber %s", new Object[] { paramq });
          paramString = new Rect((int)paramString.KNx.MzB.MIr.x, (int)paramString.KNx.MzB.MIr.y, (int)paramString.KNx.MzB.MIt.x, (int)paramString.KNx.MzB.MIt.y);
          Log.i("MicroMsg.BankCardHandler", "cropRect %s", new Object[] { paramString });
          localObject = this.dZM;
          if ((paramString.left < 0) || (paramString.top < 0) || (paramString.width() <= 0) || (paramString.width() > ((Bitmap)localObject).getWidth()) || (paramString.height() <= 0) || (paramString.height() > ((Bitmap)localObject).getHeight())) {
            break label344;
          }
          paramInt1 = 1;
          label264:
          if (paramInt1 == 0) {
            break label389;
          }
          paramString = Bitmap.createBitmap(this.dZM, paramString.left, paramString.top, paramString.width(), paramString.height());
          if ((paramString == null) || (Util.isNullOrNil(paramq))) {
            break label389;
          }
          if (!this.CEf) {
            break label349;
          }
          ConfirmScanBankCardResultUI.c(paramString, paramq);
        }
        for (;;)
        {
          this.CEg.erW = 3L;
          r(3, null);
          AppMethodBeat.o(118340);
          return;
          paramString = null;
          break;
          label344:
          paramInt1 = 0;
          break label264;
          label349:
          localObject = new tg();
          ((tg)localObject).dZH.cardId = paramq;
          ((tg)localObject).dZH.dZI = paramString;
          EventCenter.instance.publish((IEvent)localObject);
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
      this.CIW.onResume();
      AppMethodBeat.o(118339);
      return;
      this.CIX.cvn();
      AppMethodBeat.o(118339);
      return;
      this.CIW.onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.c.a
 * JD-Core Version:    0.7.0.1
 */