package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.model.al;
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
    this.EqK = new a((byte)0);
    AppMethodBeat.o(80849);
  }
  
  public boolean aIZ(String paramString)
  {
    AppMethodBeat.i(80850);
    boolean bool = super.aIZ(paramString);
    AppMethodBeat.o(80850);
    return bool;
  }
  
  public void eUm()
  {
    AppMethodBeat.i(80851);
    try
    {
      this.Eiu.a(this.Eqz, true, null);
      if (aJA(this.Eqz))
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
      Uri localUri = Uri.parse(this.Eqz);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.Eqz += "http://";
        localObject = Uri.parse(this.Eqz);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        ad.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.EqF) {}
        for (localObject = "";; localObject = this.Eqz)
        {
          this.Eqx = new k.a((String)localObject);
          this.EqF = false;
          if ((!this.Eqt) && (!this.DMC.has(this.Eqz))) {
            break label299;
          }
          if (al.aHn(this.Eqz)) {
            break;
          }
          ad.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.Eqz);
          aJa(this.Eqz);
          AppMethodBeat.o(80851);
          return;
        }
        if (aIY(this.Eqz))
        {
          alz(this.Eqz);
          AppMethodBeat.o(80851);
          return;
        }
        this.hJc.loadUrl(this.Eqz);
        AppMethodBeat.o(80851);
        return;
        label299:
        if (aIY(this.Eqz))
        {
          alz(this.Eqz);
          this.EqA = this.Eqz;
        }
        at(this.Eqz, false);
        AppMethodBeat.o(80851);
        return;
      }
      if (!al.aHn(this.Eqz))
      {
        aJa(this.Eqz);
        AppMethodBeat.o(80851);
        return;
      }
      this.hJc.loadUrl(this.Eqz);
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
      if (b.this.hJc == null)
      {
        ad.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
        AppMethodBeat.o(80847);
        return;
      }
      try
      {
        b.this.Eiu = e.a.G(paramIBinder);
        b.this.Eiu.a(b.this.EqL, b.this.hJc.hashCode());
        b.this.eVx();
        b.this.a(b.this.Eiu, b.this.DMC);
        b.this.eUm();
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