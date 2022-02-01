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
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.Locale;

public final class h
{
  MMWebView Jbj;
  public String Jbk;
  c Jbl;
  private MMHandler.Callback Jbm;
  MMHandler kAn;
  
  public h()
  {
    AppMethodBeat.i(79192);
    this.Jbm = new MMHandler.Callback()
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
          paramAnonymousMessage = h.this.Jbj.getBitmap();
          if (paramAnonymousMessage != null)
          {
            ThreadPool.post(new h.b(h.this, paramAnonymousMessage), "ViewCaptureHelper_SaveBitmap");
            h.this.Jbj = null;
            continue;
            if (h.this.Jbl != null) {
              h.this.Jbl.abF(h.this.Jbk);
            }
          }
        }
      }
    };
    this.kAn = new MMHandler(Looper.getMainLooper(), this.Jbm);
    AppMethodBeat.o(79192);
  }
  
  public final void a(MMWebView paramMMWebView, c paramc)
  {
    AppMethodBeat.i(79193);
    this.Jbj = paramMMWebView;
    this.Jbl = paramc;
    this.kAn.sendEmptyMessage(1);
    AppMethodBeat.o(79193);
  }
  
  public final void gdA()
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
      if (h.this.Jbk == null)
      {
        AppMethodBeat.o(79190);
        return;
      }
      o[] arrayOfo = new o(h.this.Jbk).heq().b(new w()
      {
        public final boolean accept(o paramAnonymouso, String paramAnonymousString)
        {
          AppMethodBeat.i(211029);
          boolean bool = paramAnonymousString.matches(".+_.+.\\.jpg");
          AppMethodBeat.o(211029);
          return bool;
        }
      });
      if (arrayOfo != null)
      {
        int j = arrayOfo.length;
        int i = 0;
        while (i < j)
        {
          Log.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[] { Boolean.valueOf(arrayOfo[i].delete()) });
          i += 1;
        }
      }
      h.this.Jbk = null;
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
      h.this.Jbk = String.format(Locale.US, "%s%s_%08x.jpg", new Object[] { b.aKJ(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode()) });
      try
      {
        BitmapUtil.saveBitmapToImage(this.mBitmap, 100, Bitmap.CompressFormat.JPEG, h.this.Jbk, true);
        Log.i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", new Object[] { this.mBitmap.toString() });
        this.mBitmap.recycle();
        h.this.kAn.sendEmptyMessage(2);
        AppMethodBeat.o(79191);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + localIOException.getMessage());
          h.this.Jbk = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void abF(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h
 * JD-Core Version:    0.7.0.1
 */