package com.tencent.mm.plugin.scanner.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.vx;
import com.tencent.mm.autogen.mmdata.rpt.ro;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.g.f;
import com.tencent.mm.plugin.scanner.g.f.a;
import com.tencent.mm.plugin.scanner.g.f.b;
import com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI;
import com.tencent.mm.protocal.protobuf.agl;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.scanlib.ui.ScanView;

public final class a
  extends f<Bundle>
  implements com.tencent.mm.am.h, f.a
{
  public boolean OOF;
  private ro OOG;
  private int count;
  private String hQR;
  private Bitmap hZE;
  
  public a(int paramInt, ScanView paramScanView, f.b paramb, ro paramro)
  {
    AppMethodBeat.i(118336);
    this.mode = paramInt;
    this.OVy = paramScanView;
    this.OVz = paramb;
    this.OOG = paramro;
    this.context = paramScanView.getContext();
    this.hQR = MD5Util.getMD5String(z.bAM() + System.currentTimeMillis());
    com.tencent.mm.kernel.h.aZW().a(2693, this);
    AppMethodBeat.o(118336);
  }
  
  public final void aS(Bundle paramBundle)
  {
    AppMethodBeat.i(313406);
    if (paramBundle != null)
    {
      this.hZE = ((Bitmap)paramBundle.getParcelable("param_card_bitmap"));
      if (this.hZE != null)
      {
        paramBundle = this.hQR;
        byte[] arrayOfByte = BitmapUtil.Bitmap2Bytes(this.hZE);
        int i = this.count;
        this.count = (i + 1);
        paramBundle = new com.tencent.mm.plugin.scanner.b.b.a(paramBundle, arrayOfByte, i);
        com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
        AppMethodBeat.o(313406);
        return;
      }
      w(2, null);
    }
    AppMethodBeat.o(313406);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(118338);
    com.tencent.mm.kernel.h.aZW().b(2693, this);
    AppMethodBeat.o(118338);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(118340);
    Log.i("MicroMsg.BankCardHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.hQR.equals(((com.tencent.mm.plugin.scanner.b.b.a)paramp).hQR))
      {
        paramString = (com.tencent.mm.plugin.scanner.b.b.a)paramp;
        Object localObject;
        if (c.c.b(paramString.rr.otC) != null)
        {
          paramString = ((qh)c.c.b(paramString.rr.otC)).YVc;
          if (paramString == null) {
            break label386;
          }
          paramp = paramString.YLF.text;
          Log.d("MicroMsg.BankCardHandler", "cardNumber %s", new Object[] { paramp });
          paramString = new Rect((int)paramString.YLF.abbg.abkP.x, (int)paramString.YLF.abbg.abkP.y, (int)paramString.YLF.abbg.abkR.x, (int)paramString.YLF.abbg.abkR.y);
          Log.i("MicroMsg.BankCardHandler", "cropRect %s", new Object[] { paramString });
          localObject = this.hZE;
          if ((paramString.left < 0) || (paramString.top < 0) || (paramString.width() <= 0) || (paramString.width() > ((Bitmap)localObject).getWidth()) || (paramString.height() <= 0) || (paramString.height() > ((Bitmap)localObject).getHeight())) {
            break label344;
          }
          paramInt1 = 1;
          label264:
          if (paramInt1 == 0) {
            break label386;
          }
          paramString = Bitmap.createBitmap(this.hZE, paramString.left, paramString.top, paramString.width(), paramString.height());
          if ((paramString == null) || (Util.isNullOrNil(paramp))) {
            break label386;
          }
          if (!this.OOF) {
            break label349;
          }
          ConfirmScanBankCardResultUI.f(paramString, paramp);
        }
        for (;;)
        {
          this.OOG.iqr = 3L;
          w(3, null);
          AppMethodBeat.o(118340);
          return;
          paramString = null;
          break;
          label344:
          paramInt1 = 0;
          break label264;
          label349:
          localObject = new vx();
          ((vx)localObject).hZz.cardId = paramp;
          ((vx)localObject).hZz.hZA = paramString;
          ((vx)localObject).publish();
        }
      }
      label386:
      w(2, null);
      AppMethodBeat.o(118340);
      return;
    }
    w(2, null);
    AppMethodBeat.o(118340);
  }
  
  public final void w(int paramInt, Bundle paramBundle)
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
      this.OVy.onResume();
      AppMethodBeat.o(118339);
      return;
      this.OVz.dmh();
      AppMethodBeat.o(118339);
      return;
      this.OVy.onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.c.a
 * JD-Core Version:    0.7.0.1
 */