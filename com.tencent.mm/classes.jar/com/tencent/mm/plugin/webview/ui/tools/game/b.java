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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.MMWebView;

public class b
  extends k
{
  public b(MMWebView paramMMWebView)
  {
    super(paramMMWebView, (byte)0);
    AppMethodBeat.i(80849);
    this.CMK = new a((byte)0);
    AppMethodBeat.o(80849);
  }
  
  public boolean aDy(String paramString)
  {
    AppMethodBeat.i(80850);
    boolean bool = super.aDy(paramString);
    AppMethodBeat.o(80850);
    return bool;
  }
  
  public void eFq()
  {
    AppMethodBeat.i(80851);
    try
    {
      this.CEK.a(this.CMz, true, null);
      if (aDY(this.CMz))
      {
        AppMethodBeat.o(80851);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + localException.getMessage());
      }
      Uri localUri = Uri.parse(this.CMz);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.CMz += "http://";
        localObject = Uri.parse(this.CMz);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        ac.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.CMF) {}
        for (localObject = "";; localObject = this.CMz)
        {
          this.CMx = new k.a((String)localObject);
          this.CMF = false;
          if ((!this.CMt) && (!this.Cjy.has(this.CMz))) {
            break label299;
          }
          if (ak.aBN(this.CMz)) {
            break;
          }
          ac.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.CMz);
          aDz(this.CMz);
          AppMethodBeat.o(80851);
          return;
        }
        if (aDx(this.CMz))
        {
          ahb(this.CMz);
          AppMethodBeat.o(80851);
          return;
        }
        this.hqK.loadUrl(this.CMz);
        AppMethodBeat.o(80851);
        return;
        label299:
        if (aDx(this.CMz))
        {
          ahb(this.CMz);
          this.CMA = this.CMz;
        }
        cl(this.CMz, false);
        AppMethodBeat.o(80851);
        return;
      }
      if (!ak.aBN(this.CMz))
      {
        aDz(this.CMz);
        AppMethodBeat.o(80851);
        return;
      }
      this.hqK.loadUrl(this.CMz);
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
      ac.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
      if (b.this.hqK == null)
      {
        ac.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
        AppMethodBeat.o(80847);
        return;
      }
      try
      {
        b.this.CEK = e.a.G(paramIBinder);
        b.this.CEK.a(b.this.CML, b.this.hqK.hashCode());
        b.this.eGx();
        b.this.a(b.this.CEK, b.this.Cjy);
        b.this.eFq();
        AppMethodBeat.o(80847);
        return;
      }
      catch (Exception paramComponentName)
      {
        ac.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
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