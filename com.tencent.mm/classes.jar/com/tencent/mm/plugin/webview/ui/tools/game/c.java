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

public class c
  extends k
{
  public c(MMWebView paramMMWebView)
  {
    super(paramMMWebView, (byte)0);
    AppMethodBeat.i(80849);
    this.Qxc = new a((byte)0);
    AppMethodBeat.o(80849);
  }
  
  public boolean bmE(String paramString)
  {
    AppMethodBeat.i(80850);
    boolean bool = super.bmE(paramString);
    AppMethodBeat.o(80850);
    return bool;
  }
  
  public void hax()
  {
    AppMethodBeat.i(80851);
    try
    {
      this.Qnq.a(this.QwQ, true, null);
      if (bnk(this.QwQ))
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
      Uri localUri = Uri.parse(this.QwQ);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.QwQ += "http://";
        localObject = Uri.parse(this.QwQ);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        Log.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.QwW) {}
        for (localObject = "";; localObject = this.QwQ)
        {
          this.QwO = new k.a((String)localObject);
          this.QwW = false;
          if ((!this.QwK) && (!this.pIm.has(this.QwQ))) {
            break label299;
          }
          if (al.bkB(this.QwQ)) {
            break;
          }
          Log.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.QwQ);
          bmF(this.QwQ);
          AppMethodBeat.o(80851);
          return;
        }
        if (bmD(this.QwQ))
        {
          aJy(this.QwQ);
          AppMethodBeat.o(80851);
          return;
        }
        this.lxa.loadUrl(this.QwQ);
        AppMethodBeat.o(80851);
        return;
        label299:
        if (bmD(this.QwQ))
        {
          aJy(this.QwQ);
          this.QwR = this.QwQ;
        }
        ax(this.QwQ, false);
        AppMethodBeat.o(80851);
        return;
      }
      if (!al.bkB(this.QwQ))
      {
        bmF(this.QwQ);
        AppMethodBeat.o(80851);
        return;
      }
      this.lxa.loadUrl(this.QwQ);
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
      if (c.a(c.this) == null)
      {
        Log.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
        AppMethodBeat.o(80847);
        return;
      }
      try
      {
        c.a(c.this, e.a.L(paramIBinder));
        c.d(c.this).a(c.b(c.this), c.c(c.this).hashCode());
        c.e(c.this);
        c.a(c.this, c.f(c.this), c.g(c.this));
        c.this.hax();
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