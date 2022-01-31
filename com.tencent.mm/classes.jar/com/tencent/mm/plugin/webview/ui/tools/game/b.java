package com.tencent.mm.plugin.webview.ui.tools.game;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;

public class b
  extends com.tencent.mm.plugin.webview.ui.tools.widget.k
{
  public b(MMWebView paramMMWebView)
  {
    super(paramMMWebView, (byte)0);
    AppMethodBeat.i(8678);
    this.vsF = new b.a(this, (byte)0);
    AppMethodBeat.o(8678);
  }
  
  public boolean aiJ(String paramString)
  {
    AppMethodBeat.i(8679);
    boolean bool = super.aiJ(paramString);
    AppMethodBeat.o(8679);
    return bool;
  }
  
  public void dfX()
  {
    AppMethodBeat.i(8680);
    try
    {
      this.viZ.a(this.vsw, true, null);
      if (ajn(this.vsw))
      {
        AppMethodBeat.o(8680);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + localException.getMessage());
      }
      Uri localUri = Uri.parse(this.vsw);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.vsw += "http://";
        localObject = Uri.parse(this.vsw);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        ab.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        if (this.vsB) {}
        for (localObject = "";; localObject = this.vsw)
        {
          this.vsu = new k.a((String)localObject);
          this.vsB = false;
          if ((!this.vsq) && (!this.voA.has(this.vsw))) {
            break label304;
          }
          if (aj.ahc(this.vsw)) {
            break;
          }
          ab.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.vsw);
          aiK(this.vsw);
          AppMethodBeat.o(8680);
          return;
        }
        if (aip(this.vsw))
        {
          PW(this.vsw);
          AppMethodBeat.o(8680);
          return;
        }
        this.foJ.loadUrl(this.vsw);
        AppMethodBeat.o(8680);
        return;
        label304:
        if (aip(this.vsw))
        {
          PW(this.vsw);
          this.vsx = this.vsw;
        }
        bP(this.vsw, false);
        AppMethodBeat.o(8680);
        return;
      }
      if (!aj.ahc(this.vsw))
      {
        aiK(this.vsw);
        AppMethodBeat.o(8680);
        return;
      }
      this.foJ.loadUrl(this.vsw);
      AppMethodBeat.o(8680);
    }
  }
  
  public final boolean dfY()
  {
    return this.vsC;
  }
  
  public final String dfZ()
  {
    return this.nji;
  }
  
  public final Map dga()
  {
    return this.vsE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.b
 * JD-Core Version:    0.7.0.1
 */