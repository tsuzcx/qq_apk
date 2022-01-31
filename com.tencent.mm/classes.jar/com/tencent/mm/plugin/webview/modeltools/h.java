package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import java.io.IOException;
import java.util.Locale;

public final class h
{
  ah hcZ = new ah(Looper.getMainLooper(), this.riK);
  MMWebView riH;
  public String riI;
  h.c riJ;
  private ah.a riK = new h.1(this);
  
  public final void a(MMWebView paramMMWebView, h.c paramc)
  {
    this.riH = paramMMWebView;
    this.riJ = paramc;
    this.hcZ.sendEmptyMessage(1);
  }
  
  public final void ccQ()
  {
    com.tencent.mm.sdk.f.e.post(new h.a(this, (byte)0), "ViewCaptureHelper_DeleteBitmap");
  }
  
  private final class b
    implements Runnable
  {
    private Bitmap mBitmap;
    
    public b(Bitmap paramBitmap)
    {
      this.mBitmap = paramBitmap;
    }
    
    public final void run()
    {
      h.this.riI = String.format(Locale.US, "%s%s_%08x.jpg", new Object[] { com.tencent.mm.compatible.util.e.bkH, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode()) });
      try
      {
        c.a(this.mBitmap, 100, Bitmap.CompressFormat.JPEG, h.this.riI, true);
        this.mBitmap.recycle();
        h.this.hcZ.sendEmptyMessage(2);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + localIOException.getMessage());
          h.this.riI = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h
 * JD-Core Version:    0.7.0.1
 */