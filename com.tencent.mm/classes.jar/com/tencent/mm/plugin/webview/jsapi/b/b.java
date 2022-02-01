package com.tencent.mm.plugin.webview.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/media/WebViewEnv;", "", "()V", "childView", "", "getChildView", "()Z", "setChildView", "(Z)V", "extData", "", "getExtData", "()Ljava/lang/String;", "setExtData", "(Ljava/lang/String;)V", "fontLevel", "", "fontScale", "heightPercent", "", "getHeightPercent", "()F", "setHeightPercent", "(F)V", "immersiveMode", "getImmersiveMode", "()I", "setImmersiveMode", "(I)V", "isPreload", "setPreload", "getEnv", "setFontSize", "", "level", "scale", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a WFj;
  public int WFk;
  public boolean WFl;
  private int WFm = -1;
  private int WFn = -1;
  public String extData = "";
  public float heightPercent;
  public boolean rsE;
  
  static
  {
    AppMethodBeat.i(295237);
    WFj = new a((byte)0);
    AppMethodBeat.o(295237);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String getEnv()
  {
    AppMethodBeat.i(295249);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("immersiveMode", this.WFk);
    ((JSONObject)localObject).put("childView", this.WFl);
    if ((this.WFm >= 0) && (this.WFn >= 0))
    {
      ((JSONObject)localObject).put("fontLevel", this.WFm);
      ((JSONObject)localObject).put("fontScale", this.WFn);
    }
    CharSequence localCharSequence = (CharSequence)this.extData;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((JSONObject)localObject).put("extData", this.extData);
      }
      if (this.heightPercent > 0.0F) {
        ((JSONObject)localObject).put("heightPercent", Float.valueOf(this.heightPercent));
      }
      ((JSONObject)localObject).put("isPreload", this.rsE);
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "env.toString()");
      Log.i("MicroMsg.WebViewEnv", s.X("getEnv ", localObject));
      AppMethodBeat.o(295249);
      return localObject;
    }
  }
  
  public final void ni(int paramInt1, int paramInt2)
  {
    this.WFm = paramInt1;
    this.WFn = paramInt2;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/media/WebViewEnv$Companion;", "", "()V", "TAG", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.b.b
 * JD-Core Version:    0.7.0.1
 */