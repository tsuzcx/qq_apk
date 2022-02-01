package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;

public class c
  extends n
{
  public c(MMWebView paramMMWebView)
  {
    super(paramMMWebView, (byte)0);
    AppMethodBeat.i(80849);
    this.XpW = new a((byte)0);
    AppMethodBeat.o(80849);
  }
  
  public boolean bmi(String paramString)
  {
    AppMethodBeat.i(80850);
    boolean bool = super.bmi(paramString);
    AppMethodBeat.o(80850);
    return bool;
  }
  
  public void iAK()
  {
    AppMethodBeat.i(80851);
    try
    {
      this.XfE.a(this.XpK, true, null);
      if (bmR(this.XpK))
      {
        AppMethodBeat.o(80851);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + localException.getMessage());
      }
      Uri localUri = Uri.parse(this.XpK);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.XpK += "http://";
        localObject = Uri.parse(this.XpK);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        Log.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.XpQ) {}
        for (localObject = "";; localObject = this.XpK)
        {
          this.XpI = new n.a((String)localObject);
          this.XpQ = false;
          if ((!this.XpE) && (!this.sNd.has(this.XpK))) {
            break label299;
          }
          if (al.bkm(this.XpK)) {
            break;
          }
          Log.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.XpK);
          bmj(this.XpK);
          AppMethodBeat.o(80851);
          return;
        }
        if (bmh(this.XpK))
        {
          aGm(this.XpK);
          AppMethodBeat.o(80851);
          return;
        }
        this.ooz.loadUrl(this.XpK);
        AppMethodBeat.o(80851);
        return;
        label299:
        if (bmh(this.XpK))
        {
          aGm(this.XpK);
          this.XpL = this.XpK;
        }
        aJ(this.XpK, false);
        AppMethodBeat.o(80851);
        return;
      }
      if (!al.bkm(this.XpK))
      {
        bmj(this.XpK);
        AppMethodBeat.o(80851);
        return;
      }
      this.ooz.loadUrl(this.XpK);
      AppMethodBeat.o(80851);
    }
  }
  
  final class a
    extends n.c
  {
    private a()
    {
      super();
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(80847);
      Log.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
      if (c.a(c.this) == null)
      {
        Log.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
        AppMethodBeat.o(80847);
        return;
      }
      try
      {
        c.a(c.this, e.a.Q(paramIBinder));
        c.d(c.this).a(c.b(c.this), c.c(c.this).hashCode());
        c.e(c.this);
        c.a(c.this, c.f(c.this), c.g(c.this));
        c.this.iAK();
        AppMethodBeat.o(80847);
        return;
      }
      catch (Exception paramComponentName)
      {
        Log.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c
 * JD-Core Version:    0.7.0.1
 */