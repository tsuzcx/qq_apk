package com.tencent.mm.plugin.webview.k;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Locale;

public final class h
{
  MMWebView XsU;
  public String XsV;
  c XsW;
  private MMHandler.Callback XsX;
  MMHandler qse;
  
  public h()
  {
    AppMethodBeat.i(295710);
    this.XsX = new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(295772);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(295772);
          return false;
          paramAnonymousMessage = h.this.XsU.getBitmap();
          if (paramAnonymousMessage != null)
          {
            ThreadPool.post(new h.b(h.this, paramAnonymousMessage), "ViewCaptureHelper_SaveBitmap");
            h.this.XsU = null;
            continue;
            if (h.this.XsW != null) {
              h.this.XsW.acB(h.this.XsV);
            }
          }
        }
      }
    };
    this.qse = new MMHandler(Looper.getMainLooper(), this.XsX);
    AppMethodBeat.o(295710);
  }
  
  public final void a(MMWebView paramMMWebView, c paramc)
  {
    AppMethodBeat.i(295715);
    this.XsU = paramMMWebView;
    this.XsW = paramc;
    this.qse.sendEmptyMessage(1);
    AppMethodBeat.o(295715);
  }
  
  public final void iCR()
  {
    AppMethodBeat.i(295720);
    ThreadPool.post(new a((byte)0), "ViewCaptureHelper_DeleteBitmap");
    AppMethodBeat.o(295720);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(295760);
      if (h.this.XsV == null)
      {
        AppMethodBeat.o(295760);
        return;
      }
      u[] arrayOfu = new u(h.this.XsV).jKP().b(new ad()
      {
        public final boolean accept(u paramAnonymousu, String paramAnonymousString)
        {
          AppMethodBeat.i(295678);
          boolean bool = paramAnonymousString.matches(".+_.+.\\.jpg");
          AppMethodBeat.o(295678);
          return bool;
        }
      });
      if (arrayOfu != null)
      {
        int j = arrayOfu.length;
        int i = 0;
        while (i < j)
        {
          Log.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[] { Boolean.valueOf(arrayOfu[i].diJ()) });
          i += 1;
        }
      }
      h.this.XsV = null;
      AppMethodBeat.o(295760);
    }
  }
  
  final class b
    implements Runnable
  {
    private Bitmap mBitmap;
    
    public b(Bitmap paramBitmap)
    {
      this.mBitmap = paramBitmap;
    }
    
    public final void run()
    {
      AppMethodBeat.i(295758);
      h.this.XsV = String.format(Locale.US, "%s%s_%08x.jpg", new Object[] { b.bmz(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode()) });
      try
      {
        BitmapUtil.saveBitmapToImage(this.mBitmap, 100, Bitmap.CompressFormat.JPEG, h.this.XsV, true);
        Log.i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", new Object[] { this.mBitmap.toString() });
        this.mBitmap.recycle();
        h.this.qse.sendEmptyMessage(2);
        AppMethodBeat.o(295758);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + localIOException.getMessage());
          h.this.XsV = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void acB(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.h
 * JD-Core Version:    0.7.0.1
 */