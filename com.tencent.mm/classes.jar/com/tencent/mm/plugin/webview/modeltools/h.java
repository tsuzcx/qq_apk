package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Locale;

public final class h
{
  MMWebView Eof;
  public String Eog;
  c Eoh;
  private aq.a Eoi;
  aq jzz;
  
  public h()
  {
    AppMethodBeat.i(79192);
    this.Eoi = new aq.a()
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
          paramAnonymousMessage = h.this.Eof.getBitmap();
          if (paramAnonymousMessage != null)
          {
            com.tencent.mm.sdk.g.b.c(new h.b(h.this, paramAnonymousMessage), "ViewCaptureHelper_SaveBitmap");
            h.this.Eof = null;
            continue;
            if (h.this.Eoh != null) {
              h.this.Eoh.Sa(h.this.Eog);
            }
          }
        }
      }
    };
    this.jzz = new aq(Looper.getMainLooper(), this.Eoi);
    AppMethodBeat.o(79192);
  }
  
  public final void a(MMWebView paramMMWebView, c paramc)
  {
    AppMethodBeat.i(79193);
    this.Eof = paramMMWebView;
    this.Eoh = paramc;
    this.jzz.sendEmptyMessage(1);
    AppMethodBeat.o(79193);
  }
  
  public final void eUL()
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
      if (h.this.Eog == null)
      {
        AppMethodBeat.o(79190);
        return;
      }
      k[] arrayOfk = new k(h.this.Eog).fTg().b(new s()
      {
        public final boolean xH(String paramAnonymousString)
        {
          AppMethodBeat.i(175748);
          boolean bool = paramAnonymousString.matches(".+_.+.\\.jpg");
          AppMethodBeat.o(175748);
          return bool;
        }
      });
      if (arrayOfk != null)
      {
        int j = arrayOfk.length;
        int i = 0;
        while (i < j)
        {
          ae.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[] { Boolean.valueOf(arrayOfk[i].delete()) });
          i += 1;
        }
      }
      h.this.Eog = null;
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
      h.this.Eog = String.format(Locale.US, "%s%s_%08x.jpg", new Object[] { com.tencent.mm.loader.j.b.asj(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode()) });
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(this.mBitmap, 100, Bitmap.CompressFormat.JPEG, h.this.Eog, true);
        ae.i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", new Object[] { this.mBitmap.toString() });
        this.mBitmap.recycle();
        h.this.jzz.sendEmptyMessage(2);
        AppMethodBeat.o(79191);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + localIOException.getMessage());
          h.this.Eog = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void Sa(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h
 * JD-Core Version:    0.7.0.1
 */