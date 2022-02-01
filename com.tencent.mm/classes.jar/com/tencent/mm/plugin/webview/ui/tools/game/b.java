package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;

public class b
  extends k
{
  public b(MMWebView paramMMWebView)
  {
    super(paramMMWebView, (byte)0);
    AppMethodBeat.i(80849);
    this.JyR = new a((byte)0);
    AppMethodBeat.o(80849);
  }
  
  public boolean baG(String paramString)
  {
    AppMethodBeat.i(80850);
    boolean bool = super.baG(paramString);
    AppMethodBeat.o(80850);
    return bool;
  }
  
  public void ghe()
  {
    AppMethodBeat.i(80851);
    try
    {
      this.JpV.a(this.JyF, true, null);
      if (bbm(this.JyF))
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
      Uri localUri = Uri.parse(this.JyF);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.JyF += "http://";
        localObject = Uri.parse(this.JyF);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        Log.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.JyL) {}
        for (localObject = "";; localObject = this.JyF)
        {
          this.JyD = new k.a((String)localObject);
          this.JyL = false;
          if ((!this.Jyz) && (!this.IRi.has(this.JyF))) {
            break label299;
          }
          if (al.aYH(this.JyF)) {
            break;
          }
          Log.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.JyF);
          baH(this.JyF);
          AppMethodBeat.o(80851);
          return;
        }
        if (baF(this.JyF))
        {
          azM(this.JyF);
          AppMethodBeat.o(80851);
          return;
        }
        this.iGY.loadUrl(this.JyF);
        AppMethodBeat.o(80851);
        return;
        label299:
        if (baF(this.JyF))
        {
          azM(this.JyF);
          this.JyG = this.JyF;
        }
        av(this.JyF, false);
        AppMethodBeat.o(80851);
        return;
      }
      if (!al.aYH(this.JyF))
      {
        baH(this.JyF);
        AppMethodBeat.o(80851);
        return;
      }
      this.iGY.loadUrl(this.JyF);
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
      Log.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
      if (b.this.iGY == null)
      {
        Log.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
        AppMethodBeat.o(80847);
        return;
      }
      try
      {
        b.this.JpV = e.a.H(paramIBinder);
        b.this.JpV.a(b.this.JyS, b.this.iGY.hashCode());
        b.this.giq();
        b.this.a(b.this.JpV, b.this.IRi);
        b.this.ghe();
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.b
 * JD-Core Version:    0.7.0.1
 */