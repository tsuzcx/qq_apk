package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ag
{
  private JSONStringer SAE;
  private int SAF;
  private String SAG;
  private String SAH;
  private String SAI;
  private String SAJ;
  private String SAK;
  private int SAL;
  private long SAM;
  private WebView SAN;
  private final String TAG;
  private int bufferSize;
  public String cacheKey;
  
  public ag(int paramInt1, int paramInt2, WebView paramWebView)
  {
    AppMethodBeat.i(156933);
    this.TAG = "XWebScript";
    this.SAE = new JSONStringer();
    this.SAF = 0;
    this.SAL = 0;
    this.SAF = paramInt1;
    this.SAL = paramInt2;
    this.SAN = paramWebView;
    AppMethodBeat.o(156933);
  }
  
  public final void bso(String paramString)
  {
    AppMethodBeat.i(258707);
    oc(paramString, "path");
    AppMethodBeat.o(258707);
  }
  
  public final void bsp(String paramString)
  {
    AppMethodBeat.i(156935);
    oc(paramString, "string");
    AppMethodBeat.o(156935);
  }
  
  public final void bsq(String paramString)
  {
    this.SAK = paramString;
  }
  
  public final void bsr(String paramString)
  {
    this.SAJ = paramString;
  }
  
  public final void ob(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156934);
    oc(paramString1, "path");
    this.SAI = paramString2;
    AppMethodBeat.o(156934);
  }
  
  public final void oc(String paramString1, String paramString2)
  {
    this.SAH = paramString1;
    this.SAG = paramString2;
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
    if (this.SAN != null)
    {
      if (this.SAN.supportFeature(2002)) {
        break label43;
      }
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(156936);
      return "";
      label43:
      if (TextUtils.isEmpty(this.SAH))
      {
        Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.SAH);
        i = j;
      }
      else if (TextUtils.isEmpty(this.SAG))
      {
        Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.SAG);
        i = j;
      }
      else if (this.SAF < 0)
      {
        Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.SAF);
        i = j;
      }
      else if ((this.SAM != 0L) && (this.bufferSize <= 0))
      {
        Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
        i = j;
      }
      else if ((this.bufferSize != 0) && (this.SAM == 0L))
      {
        Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.SAM);
        i = j;
      }
      else if ((!TextUtils.isEmpty(this.SAK)) && (!this.SAN.supportFeature(2008)))
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
        localObject2 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.SAF).key("cache_option").value(this.SAL).key("js_src_kind").value(this.SAG).key("js_src").value(this.SAH);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.cacheKey)) {
          localObject1 = ((JSONStringer)localObject2).key("cache_key").value(this.cacheKey);
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.SAI)) {
          localObject2 = ((JSONStringer)localObject1).key("append_script").value(this.SAI);
        }
        if (TextUtils.isEmpty(this.SAK)) {
          continue;
        }
        localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("path").key("js_param").value(this.SAK);
        ((JSONStringer)localObject1).endObject();
        localStringBuilder.append(((JSONStringer)localObject1).toString());
        if ((this.SAN != null) && (this.SAN.supportFeature(2004))) {
          localStringBuilder.append("XWEB_SCRIPT_END\n\r" + this.SAJ);
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
      if (this.SAM != 0L)
      {
        localObject1 = localObject2;
        if (this.bufferSize != 0) {
          localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.SAM)).key("js_param_length").value(this.bufferSize);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ag
 * JD-Core Version:    0.7.0.1
 */