package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class an
{
  private final String TAG;
  private int aiga;
  private String aigb;
  private String aigc;
  public String aigd;
  public String aige;
  public String aigf;
  private int aigg;
  private long aigh;
  private WebView aigi;
  private int bufferSize;
  public String mgR;
  
  public an(int paramInt1, int paramInt2, WebView paramWebView)
  {
    AppMethodBeat.i(156933);
    this.TAG = "XWebScript";
    this.aiga = 0;
    this.aigg = 0;
    this.aiga = paramInt1;
    this.aigg = paramInt2;
    this.aigi = paramWebView;
    AppMethodBeat.o(156933);
  }
  
  public final void qU(String paramString1, String paramString2)
  {
    this.aigc = paramString1;
    this.aigb = paramString2;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(156936);
    int i = j;
    if (this.aigi != null)
    {
      if (this.aigi.supportFeature(2002)) {
        break label43;
      }
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(156936);
      return "";
      label43:
      if (TextUtils.isEmpty(this.aigc))
      {
        Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.aigc);
        i = j;
      }
      else if (TextUtils.isEmpty(this.aigb))
      {
        Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.aigb);
        i = j;
      }
      else if (this.aiga < 0)
      {
        Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.aiga);
        i = j;
      }
      else if ((this.aigh != 0L) && (this.bufferSize <= 0))
      {
        Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
        i = j;
      }
      else if ((this.bufferSize != 0) && (this.aigh == 0L))
      {
        Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.aigh);
        i = j;
      }
      else if ((!TextUtils.isEmpty(this.aigf)) && (!this.aigi.supportFeature(2008)))
      {
        Log.e("XWebScript", "not support jsparam as file path, apk ver = " + XWalkEnvironment.getAvailableVersion());
        i = j;
      }
      else
      {
        i = 1;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("//XWEB_SCRIPT:");
    Object localObject1 = new JSONStringer();
    for (;;)
    {
      try
      {
        localObject3 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.aiga).key("cache_option").value(this.aigg).key("js_src_kind").value(this.aigb).key("js_src").value(this.aigc);
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(this.mgR)) {
          localObject1 = ((JSONStringer)localObject3).key("cache_key").value(this.mgR);
        }
        localObject3 = localObject1;
        if (!TextUtils.isEmpty(this.aigd)) {
          localObject3 = ((JSONStringer)localObject1).key("append_script").value(this.aigd);
        }
        if (TextUtils.isEmpty(this.aigf)) {
          continue;
        }
        localObject1 = ((JSONStringer)localObject3).key("js_param_kind").value("path").key("js_param").value(this.aigf);
        ((JSONStringer)localObject1).endObject();
        localStringBuilder.append(((JSONStringer)localObject1).toString());
        if ((this.aigi != null) && (this.aigi.supportFeature(2004))) {
          localStringBuilder.append("XWEB_SCRIPT_END\n\r" + this.aige);
        }
      }
      finally
      {
        Object localObject3;
        Log.e("XWebScript", "xweb script create failed, error:".concat(String.valueOf(localObject2)));
        continue;
      }
      localObject1 = localStringBuilder.toString();
      AppMethodBeat.o(156936);
      return localObject1;
      localObject1 = localObject3;
      if (this.aigh != 0L)
      {
        localObject1 = localObject3;
        if (this.bufferSize != 0) {
          localObject1 = ((JSONStringer)localObject3).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.aigh)).key("js_param_length").value(this.bufferSize);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.an
 * JD-Core Version:    0.7.0.1
 */