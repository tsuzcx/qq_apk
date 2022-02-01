package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.m;
import java.io.IOException;
import java.util.Locale;

public final class h
{
  MMWebView CsB;
  public String CsC;
  c CsD;
  private ao.a CsE;
  ao jdu;
  
  public h()
  {
    AppMethodBeat.i(79192);
    this.CsE = new ao.a()
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
          paramAnonymousMessage = h.this.CsB.getBitmap();
          if (paramAnonymousMessage != null)
          {
            com.tencent.mm.sdk.g.b.c(new h.b(h.this, paramAnonymousMessage), "ViewCaptureHelper_SaveBitmap");
            h.this.CsB = null;
            continue;
            if (h.this.CsD != null) {
              h.this.CsD.NS(h.this.CsC);
            }
          }
        }
      }
    };
    this.jdu = new ao(Looper.getMainLooper(), this.CsE);
    AppMethodBeat.o(79192);
  }
  
  public final void a(MMWebView paramMMWebView, c paramc)
  {
    AppMethodBeat.i(79193);
    this.CsB = paramMMWebView;
    this.CsD = paramc;
    this.jdu.sendEmptyMessage(1);
    AppMethodBeat.o(79193);
  }
  
  public final void eCf()
  {
    AppMethodBeat.i(79194);
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "ViewCaptureHelper_DeleteBitmap");
    AppMethodBeat.o(79194);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(79190);
      if (h.this.CsC == null)
      {
        AppMethodBeat.o(79190);
        return;
      }
      e[] arrayOfe = new e(h.this.CsC).fxU().b(new m()
      {
        public final boolean ui(String paramAnonymousString)
        {
          AppMethodBeat.i(175748);
          boolean bool = paramAnonymousString.matches(".+_.+.\\.jpg");
          AppMethodBeat.o(175748);
          return bool;
        }
      });
      if (arrayOfe != null)
      {
        int j = arrayOfe.length;
        int i = 0;
        while (i < j)
        {
          ac.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[] { Boolean.valueOf(arrayOfe[i].delete()) });
          i += 1;
        }
      }
      h.this.CsC = null;
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
      h.this.CsC = String.format(Locale.US, "%s%s_%08x.jpg", new Object[] { com.tencent.mm.loader.j.b.aph(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode()) });
      try
      {
        f.a(this.mBitmap, 100, Bitmap.CompressFormat.JPEG, h.this.CsC, true);
        ac.i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", new Object[] { this.mBitmap.toString() });
        this.mBitmap.recycle();
        h.this.jdu.sendEmptyMessage(2);
        AppMethodBeat.o(79191);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + localIOException.getMessage());
          h.this.CsC = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void NS(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h
 * JD-Core Version:    0.7.0.1
 */