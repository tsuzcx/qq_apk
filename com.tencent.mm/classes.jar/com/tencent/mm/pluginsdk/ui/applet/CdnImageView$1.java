package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class CdnImageView$1
  extends ah
{
  CdnImageView$1(CdnImageView paramCdnImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject = bk.aM(paramMessage.getData().getString("k_url"), "");
    CdnImageView.a(this.sbY, bk.aM(CdnImageView.a(this.sbY), ""));
    if ((bk.bl(CdnImageView.a(this.sbY))) && (bk.bl((String)localObject)))
    {
      this.sbY.setImageBitmap(null);
      this.sbY.setImageBitmapCompleted(null);
      return;
    }
    if (!CdnImageView.a(this.sbY).equals(localObject))
    {
      y.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
      return;
    }
    paramMessage = paramMessage.getData().getByteArray("k_data");
    if ((paramMessage == null) || (paramMessage.length == 0))
    {
      y.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
      return;
    }
    localObject = com.tencent.mm.sdk.platformtools.c.bu(paramMessage);
    o.OI();
    com.tencent.mm.as.c.g(CdnImageView.a(this.sbY), (Bitmap)localObject);
    if (CdnImageView.b(this.sbY)) {
      CdnImageView.a(this.sbY, (Bitmap)localObject);
    }
    paramMessage = (Message)localObject;
    if (localObject != null)
    {
      paramMessage = (Message)localObject;
      if (CdnImageView.c(this.sbY) > 0)
      {
        paramMessage = (Message)localObject;
        if (CdnImageView.d(this.sbY) > 0) {
          paramMessage = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject, CdnImageView.d(this.sbY), CdnImageView.c(this.sbY), true, false);
        }
      }
    }
    localObject = paramMessage;
    if (CdnImageView.e(this.sbY))
    {
      localObject = paramMessage;
      if (paramMessage != null) {
        localObject = com.tencent.mm.sdk.platformtools.c.a(paramMessage, false, paramMessage.getWidth() * 0.5F);
      }
    }
    if (localObject != null) {
      this.sbY.setImageBitmap((Bitmap)localObject);
    }
    this.sbY.setImageBitmapCompleted((Bitmap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView.1
 * JD-Core Version:    0.7.0.1
 */