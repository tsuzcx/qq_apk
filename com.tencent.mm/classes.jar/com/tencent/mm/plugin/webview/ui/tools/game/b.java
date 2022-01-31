package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.model.ae;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

public class b
  extends k
{
  public b(MMWebView paramMMWebView)
  {
    super(paramMMWebView, (byte)0);
    this.rCt = new a((byte)0);
  }
  
  public boolean TI(String paramString)
  {
    return super.TI(paramString);
  }
  
  protected final void cfO()
  {
    try
    {
      this.rsT.a(this.rCk, true, null);
      if (Ud(this.rCk)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + localException.getMessage());
      }
      Uri localUri = Uri.parse(this.rCk);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.rCk += "http://";
        localObject = Uri.parse(this.rCk);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        y.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.rCp) {}
        for (localObject = "";; localObject = this.rCk)
        {
          this.rCi = new k.a((String)localObject);
          this.rCp = false;
          if ((!this.rCe) && (!this.rxH.has(this.rCk))) {
            break label274;
          }
          if (ae.Sg(this.rCk)) {
            break;
          }
          y.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.rCk);
          TJ(this.rCk);
          return;
        }
        if (Tl(this.rCk))
        {
          TH(this.rCk);
          return;
        }
        this.dYF.loadUrl(this.rCk);
        return;
        label274:
        if (Tl(this.rCk))
        {
          TH(this.rCk);
          this.rCl = this.rCk;
        }
        bq(this.rCk, false);
        return;
      }
      if (!ae.Sg(this.rCk))
      {
        TJ(this.rCk);
        return;
      }
      this.dYF.loadUrl(this.rCk);
    }
  }
  
  private final class a
    extends k.c
  {
    private a()
    {
      super();
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      y.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
      if (b.this.dYF == null)
      {
        y.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
        return;
      }
      try
      {
        b.this.rsT = d.a.H(paramIBinder);
        b.this.rsT.a(b.this.rCu, b.this.dYF.hashCode());
        b.this.cgP();
        b.this.a(b.this.rsT, b.this.rxH);
        b.this.cfO();
        return;
      }
      catch (Exception paramComponentName)
      {
        y.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[] { paramComponentName.getMessage() });
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      super.onServiceDisconnected(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.b
 * JD-Core Version:    0.7.0.1
 */