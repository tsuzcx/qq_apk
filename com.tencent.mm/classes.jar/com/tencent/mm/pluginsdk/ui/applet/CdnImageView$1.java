package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class CdnImageView$1
  extends ak
{
  CdnImageView$1(CdnImageView paramCdnImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(79716);
    Object localObject = bo.bf(paramMessage.getData().getString("k_url"), "");
    CdnImageView.a(this.vTh, bo.bf(CdnImageView.a(this.vTh), ""));
    if ((bo.isNullOrNil(CdnImageView.a(this.vTh))) && (bo.isNullOrNil((String)localObject)))
    {
      this.vTh.setImageBitmap(null);
      this.vTh.setImageBitmapCompleted(null);
      AppMethodBeat.o(79716);
      return;
    }
    if (!CdnImageView.a(this.vTh).equals(localObject))
    {
      ab.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
      AppMethodBeat.o(79716);
      return;
    }
    paramMessage = paramMessage.getData().getByteArray("k_data");
    if ((paramMessage == null) || (paramMessage.length == 0))
    {
      ab.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
      AppMethodBeat.o(79716);
      return;
    }
    localObject = d.bT(paramMessage);
    o.ahB();
    c.h(CdnImageView.a(this.vTh), (Bitmap)localObject);
    if (CdnImageView.b(this.vTh)) {
      CdnImageView.a(this.vTh, (Bitmap)localObject);
    }
    paramMessage = (Message)localObject;
    if (localObject != null)
    {
      paramMessage = (Message)localObject;
      if (CdnImageView.c(this.vTh) > 0)
      {
        paramMessage = (Message)localObject;
        if (CdnImageView.d(this.vTh) > 0) {
          paramMessage = d.a((Bitmap)localObject, CdnImageView.d(this.vTh), CdnImageView.c(this.vTh), true, false);
        }
      }
    }
    localObject = paramMessage;
    if (CdnImageView.e(this.vTh))
    {
      localObject = paramMessage;
      if (paramMessage != null) {
        localObject = d.a(paramMessage, false, paramMessage.getWidth() * 0.5F);
      }
    }
    if (localObject != null) {
      this.vTh.setImageBitmap((Bitmap)localObject);
    }
    this.vTh.setImageBitmapCompleted((Bitmap)localObject);
    AppMethodBeat.o(79716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView.1
 * JD-Core Version:    0.7.0.1
 */