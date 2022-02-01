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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMWebView;

public class b
  extends k
{
  public b(MMWebView paramMMWebView)
  {
    super(paramMMWebView, (byte)0);
    AppMethodBeat.i(80849);
    this.EJa = new a((byte)0);
    AppMethodBeat.o(80849);
  }
  
  public boolean aKs(String paramString)
  {
    AppMethodBeat.i(80850);
    boolean bool = super.aKs(paramString);
    AppMethodBeat.o(80850);
    return bool;
  }
  
  public void eXZ()
  {
    AppMethodBeat.i(80851);
    try
    {
      this.EAy.a(this.EIP, true, null);
      if (aKW(this.EIP))
      {
        AppMethodBeat.o(80851);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + localException.getMessage());
      }
      Uri localUri = Uri.parse(this.EIP);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.EIP += "http://";
        localObject = Uri.parse(this.EIP);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        ae.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.EIV) {}
        for (localObject = "";; localObject = this.EIP)
        {
          this.EIN = new k.a((String)localObject);
          this.EIV = false;
          if ((!this.EIJ) && (!this.EeB.has(this.EIP))) {
            break label299;
          }
          if (al.aIG(this.EIP)) {
            break;
          }
          ae.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.EIP);
          aKt(this.EIP);
          AppMethodBeat.o(80851);
          return;
        }
        if (aKr(this.EIP))
        {
          amx(this.EIP);
          AppMethodBeat.o(80851);
          return;
        }
        this.hLV.loadUrl(this.EIP);
        AppMethodBeat.o(80851);
        return;
        label299:
        if (aKr(this.EIP))
        {
          amx(this.EIP);
          this.EIQ = this.EIP;
        }
        at(this.EIP, false);
        AppMethodBeat.o(80851);
        return;
      }
      if (!al.aIG(this.EIP))
      {
        aKt(this.EIP);
        AppMethodBeat.o(80851);
        return;
      }
      this.hLV.loadUrl(this.EIP);
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
      ae.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
      if (b.this.hLV == null)
      {
        ae.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
        AppMethodBeat.o(80847);
        return;
      }
      try
      {
        b.this.EAy = e.a.H(paramIBinder);
        b.this.EAy.a(b.this.EJb, b.this.hLV.hashCode());
        b.this.eZk();
        b.this.a(b.this.EAy, b.this.EeB);
        b.this.eXZ();
        AppMethodBeat.o(80847);
        return;
      }
      catch (Exception paramComponentName)
      {
        ae.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
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