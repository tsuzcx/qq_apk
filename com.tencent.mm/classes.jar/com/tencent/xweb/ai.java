package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ai
{
  private final String TAG;
  private int aabA;
  private String aabB;
  private String aabC;
  private String aabD;
  private String aabE;
  private String aabF;
  private int aabG;
  private long aabH;
  private WebView aabI;
  private JSONStringer aabz;
  private int bufferSize;
  public String cacheKey;
  
  public ai(int paramInt1, int paramInt2, WebView paramWebView)
  {
    AppMethodBeat.i(156933);
    this.TAG = "XWebScript";
    this.aabz = new JSONStringer();
    this.aabA = 0;
    this.aabG = 0;
    this.aabA = paramInt1;
    this.aabG = paramInt2;
    this.aabI = paramWebView;
    AppMethodBeat.o(156933);
  }
  
  public final void bFn(String paramString)
  {
    AppMethodBeat.i(292725);
    oY(paramString, "path");
    AppMethodBeat.o(292725);
  }
  
  public final void bFo(String paramString)
  {
    AppMethodBeat.i(156935);
    oY(paramString, "string");
    AppMethodBeat.o(156935);
  }
  
  public final void bFp(String paramString)
  {
    this.aabF = paramString;
  }
  
  public final void bFq(String paramString)
  {
    this.aabE = paramString;
  }
  
  public final void oX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156934);
    oY(paramString1, "path");
    this.aabD = paramString2;
    AppMethodBeat.o(156934);
  }
  
  public final void oY(String paramString1, String paramString2)
  {
    this.aabC = paramString1;
    this.aabB = paramString2;
  }
  
  public final void setCacheKey(String paramString)
  {
    this.cacheKey = paramString;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(156936);
    int i = j;
    if (this.aabI != null)
    {
      if (this.aabI.supportFeature(2002)) {
        break label43;
      }
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(156936);
      return "";
      label43:
      if (TextUtils.isEmpty(this.aabC))
      {
        Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.aabC);
        i = j;
      }
      else if (TextUtils.isEmpty(this.aabB))
      {
        Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.aabB);
        i = j;
      }
      else if (this.aabA < 0)
      {
        Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.aabA);
        i = j;
      }
      else if ((this.aabH != 0L) && (this.bufferSize <= 0))
      {
        Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
        i = j;
      }
      else if ((this.bufferSize != 0) && (this.aabH == 0L))
      {
        Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.aabH);
        i = j;
      }
      else if ((!TextUtils.isEmpty(this.aabF)) && (!this.aabI.supportFeature(2008)))
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
        localObject2 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.aabA).key("cache_option").value(this.aabG).key("js_src_kind").value(this.aabB).key("js_src").value(this.aabC);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.cacheKey)) {
          localObject1 = ((JSONStringer)localObject2).key("cache_key").value(this.cacheKey);
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.aabD)) {
          localObject2 = ((JSONStringer)localObject1).key("append_script").value(this.aabD);
        }
        if (TextUtils.isEmpty(this.aabF)) {
          continue;
        }
        localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("path").key("js_param").value(this.aabF);
        ((JSONStringer)localObject1).endObject();
        localStringBuilder.append(((JSONStringer)localObject1).toString());
        if ((this.aabI != null) && (this.aabI.supportFeature(2004))) {
          localStringBuilder.append("XWEB_SCRIPT_END\n\r" + this.aabE);
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
      if (this.aabH != 0L)
      {
        localObject1 = localObject2;
        if (this.bufferSize != 0) {
          localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.aabH)).key("js_param_length").value(this.bufferSize);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ai
 * JD-Core Version:    0.7.0.1
 */