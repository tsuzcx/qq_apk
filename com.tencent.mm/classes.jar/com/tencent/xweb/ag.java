package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ag
{
  private JSONStringer MqE;
  private int MqF;
  private String MqG;
  private String MqH;
  private String MqI;
  private String MqJ;
  private String MqK;
  private int MqL;
  private long MqM;
  private WebView MqN;
  private final String TAG;
  private int bufferSize;
  private String cacheKey;
  
  public ag(int paramInt1, int paramInt2, WebView paramWebView)
  {
    AppMethodBeat.i(156933);
    this.TAG = "XWebScript";
    this.MqE = new JSONStringer();
    this.MqF = 0;
    this.MqL = 0;
    this.MqF = paramInt1;
    this.MqL = paramInt2;
    this.MqN = paramWebView;
    AppMethodBeat.o(156933);
  }
  
  public final void bbb(String paramString)
  {
    AppMethodBeat.i(221738);
    nb(paramString, "path");
    AppMethodBeat.o(221738);
  }
  
  public final void bbc(String paramString)
  {
    AppMethodBeat.i(156935);
    nb(paramString, "string");
    AppMethodBeat.o(156935);
  }
  
  public final void bbd(String paramString)
  {
    this.MqK = paramString;
  }
  
  public final void bbe(String paramString)
  {
    this.MqJ = paramString;
  }
  
  public final void na(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156934);
    nb(paramString1, "path");
    this.MqI = paramString2;
    AppMethodBeat.o(156934);
  }
  
  public final void nb(String paramString1, String paramString2)
  {
    this.MqH = paramString1;
    this.MqG = paramString2;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(156936);
    int i = j;
    if (this.MqN != null)
    {
      if (this.MqN.supportFeature(2002)) {
        break label43;
      }
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(156936);
      return "";
      label43:
      if (TextUtils.isEmpty(this.MqH))
      {
        Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.MqH);
        i = j;
      }
      else if (TextUtils.isEmpty(this.MqG))
      {
        Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.MqG);
        i = j;
      }
      else if (this.MqF < 0)
      {
        Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.MqF);
        i = j;
      }
      else if ((this.MqM != 0L) && (this.bufferSize <= 0))
      {
        Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
        i = j;
      }
      else if ((this.bufferSize != 0) && (this.MqM == 0L))
      {
        Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.MqM);
        i = j;
      }
      else if ((!TextUtils.isEmpty(this.MqK)) && (!this.MqN.supportFeature(2008)))
      {
        Log.e("XWebScript", "not support jsparam as file path , apk ver = " + XWalkEnvironment.getAvailableVersion());
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
        localObject2 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.MqF).key("cache_option").value(this.MqL).key("js_src_kind").value(this.MqG).key("js_src").value(this.MqH);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.cacheKey)) {
          localObject1 = ((JSONStringer)localObject2).key("cache_key").value(this.cacheKey);
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.MqI)) {
          localObject2 = ((JSONStringer)localObject1).key("append_script").value(this.MqI);
        }
        if (TextUtils.isEmpty(this.MqK)) {
          continue;
        }
        localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("path").key("js_param").value(this.MqK);
        ((JSONStringer)localObject1).endObject();
        localStringBuilder.append(((JSONStringer)localObject1).toString());
        if ((this.MqN != null) && (this.MqN.supportFeature(2004))) {
          localStringBuilder.append("XWEB_SCRIPT_END\n\r" + this.MqJ);
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        Log.e("XWebScript", "xweb script create failed " + localException.getMessage());
        continue;
      }
      localObject1 = localStringBuilder.toString();
      AppMethodBeat.o(156936);
      return localObject1;
      localObject1 = localObject2;
      if (this.MqM != 0L)
      {
        localObject1 = localObject2;
        if (this.bufferSize != 0) {
          localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.MqM)).key("js_param_length").value(this.bufferSize);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ag
 * JD-Core Version:    0.7.0.1
 */