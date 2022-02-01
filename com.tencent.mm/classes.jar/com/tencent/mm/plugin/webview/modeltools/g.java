package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.z;
import java.io.IOException;
import java.util.Locale;

public final class g
{
  MMWebView PXB;
  public String PXC;
  c PXD;
  private MMHandler.Callback PXE;
  MMHandler ntw;
  
  public g()
  {
    AppMethodBeat.i(79192);
    this.PXE = new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(79188);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(79188);
          return false;
          paramAnonymousMessage = g.this.PXB.getBitmap();
          if (paramAnonymousMessage != null)
          {
            ThreadPool.post(new g.b(g.this, paramAnonymousMessage), "ViewCaptureHelper_SaveBitmap");
            g.this.PXB = null;
            continue;
            if (g.this.PXD != null) {
              g.this.PXD.ajA(g.this.PXC);
            }
          }
        }
      }
    };
    this.ntw = new MMHandler(Looper.getMainLooper(), this.PXE);
    AppMethodBeat.o(79192);
  }
  
  public final void a(MMWebView paramMMWebView, c paramc)
  {
    AppMethodBeat.i(79193);
    this.PXB = paramMMWebView;
    this.PXD = paramc;
    this.ntw.sendEmptyMessage(1);
    AppMethodBeat.o(79193);
  }
  
  public final void gWy()
  {
    AppMethodBeat.i(79194);
    ThreadPool.post(new a((byte)0), "ViewCaptureHelper_DeleteBitmap");
    AppMethodBeat.o(79194);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(79190);
      if (g.this.PXC == null)
      {
        AppMethodBeat.o(79190);
        return;
      }
      q[] arrayOfq = new q(g.this.PXC).ifB().b(new z()
      {
        public final boolean accept(q paramAnonymousq, String paramAnonymousString)
        {
          AppMethodBeat.i(215610);
          boolean bool = paramAnonymousString.matches(".+_.+.\\.jpg");
          AppMethodBeat.o(215610);
          return bool;
        }
      });
      if (arrayOfq != null)
      {
        int j = arrayOfq.length;
        int i = 0;
        while (i < j)
        {
          Log.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[] { Boolean.valueOf(arrayOfq[i].cFq()) });
          i += 1;
        }
      }
      g.this.PXC = null;
      AppMethodBeat.o(79190);
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
      AppMethodBeat.i(79191);
      g.this.PXC = String.format(Locale.US, "%s%s_%08x.jpg", new Object[] { b.aSL(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode()) });
      try
      {
        BitmapUtil.saveBitmapToImage(this.mBitmap, 100, Bitmap.CompressFormat.JPEG, g.this.PXC, true);
        Log.i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", new Object[] { this.mBitmap.toString() });
        this.mBitmap.recycle();
        g.this.ntw.sendEmptyMessage(2);
        AppMethodBeat.o(79191);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + localIOException.getMessage());
          g.this.PXC = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void ajA(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g
 * JD-Core Version:    0.7.0.1
 */