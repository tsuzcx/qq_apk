package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMWebView;

public class b
  extends k
{
  public b(MMWebView paramMMWebView)
  {
    super(paramMMWebView, (byte)0);
    AppMethodBeat.i(80849);
    this.BuB = new a((byte)0);
    AppMethodBeat.o(80849);
  }
  
  public boolean ayh(String paramString)
  {
    AppMethodBeat.i(80850);
    boolean bool = super.ayh(paramString);
    AppMethodBeat.o(80850);
    return bool;
  }
  
  public void epW()
  {
    AppMethodBeat.i(80851);
    try
    {
      this.BmD.a(this.Buq, true, null);
      if (ayH(this.Buq))
      {
        AppMethodBeat.o(80851);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + localException.getMessage());
      }
      Uri localUri = Uri.parse(this.Buq);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.Buq += "http://";
        localObject = Uri.parse(this.Buq);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        ad.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.Buw) {}
        for (localObject = "";; localObject = this.Buq)
        {
          this.Buo = new k.a((String)localObject);
          this.Buw = false;
          if ((!this.Buk) && (!this.ARl.has(this.Buq))) {
            break label299;
          }
          if (ak.awv(this.Buq)) {
            break;
          }
          ad.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.Buq);
          ayi(this.Buq);
          AppMethodBeat.o(80851);
          return;
        }
        if (ayg(this.Buq))
        {
          acj(this.Buq);
          AppMethodBeat.o(80851);
          return;
        }
        this.gQk.loadUrl(this.Buq);
        AppMethodBeat.o(80851);
        return;
        label299:
        if (ayg(this.Buq))
        {
          acj(this.Buq);
          this.Bur = this.Buq;
        }
        cf(this.Buq, false);
        AppMethodBeat.o(80851);
        return;
      }
      if (!ak.awv(this.Buq))
      {
        ayi(this.Buq);
        AppMethodBeat.o(80851);
        return;
      }
      this.gQk.loadUrl(this.Buq);
      AppMethodBeat.o(80851);
    }
  }
  
  final class a
    extends k.c
  {
    private a()
    {
      super();
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(80847);
      ad.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
      if (b.this.gQk == null)
      {
        ad.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
        AppMethodBeat.o(80847);
        return;
      }
      try
      {
        b.this.BmD = e.a.G(paramIBinder);
        b.this.BmD.a(b.this.BuC, b.this.gQk.hashCode());
        b.this.erd();
        b.this.a(b.this.BmD, b.this.ARl);
        b.this.epW();
        AppMethodBeat.o(80847);
        return;
      }
      catch (Exception paramComponentName)
      {
        ad.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
        AppMethodBeat.o(80847);
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(80848);
      super.onServiceDisconnected(paramComponentName);
      AppMethodBeat.o(80848);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.b
 * JD-Core Version:    0.7.0.1
 */