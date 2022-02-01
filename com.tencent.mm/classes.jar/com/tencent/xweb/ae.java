package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ae
{
  private JSONStringer INM;
  private int INN;
  private String INO;
  private String INP;
  private String INQ;
  private String INR;
  private String INS;
  private int INU;
  private long INV;
  private WebView INW;
  private final String TAG;
  private int bufferSize;
  private String cacheKey;
  
  public ae(int paramInt1, int paramInt2, WebView paramWebView)
  {
    AppMethodBeat.i(156933);
    this.TAG = "XWebScript";
    this.INM = new JSONStringer();
    this.INN = 0;
    this.INU = 0;
    this.INN = paramInt1;
    this.INU = paramInt2;
    this.INW = paramWebView;
    AppMethodBeat.o(156933);
  }
  
  public final void aPf(String paramString)
  {
    AppMethodBeat.i(205029);
    mc(paramString, "path");
    AppMethodBeat.o(205029);
  }
  
  public final void aPg(String paramString)
  {
    AppMethodBeat.i(156935);
    mc(paramString, "string");
    AppMethodBeat.o(156935);
  }
  
  public final void aPh(String paramString)
  {
    this.INS = paramString;
  }
  
  public final void aPi(String paramString)
  {
    this.INR = paramString;
  }
  
  public final void mb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156934);
    mc(paramString1, "path");
    this.INQ = paramString2;
    AppMethodBeat.o(156934);
  }
  
  public final void mc(String paramString1, String paramString2)
  {
    this.INP = paramString1;
    this.INO = paramString2;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(156936);
    int i = j;
    if (this.INW != null)
    {
      if (this.INW.supportFeature(2002)) {
        break label43;
      }
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(156936);
      return "";
      label43:
      if (TextUtils.isEmpty(this.INP))
      {
        Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.INP);
        i = j;
      }
      else if (TextUtils.isEmpty(this.INO))
      {
        Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.INO);
        i = j;
      }
      else if (this.INN < 0)
      {
        Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.INN);
        i = j;
      }
      else if ((this.INV != 0L) && (this.bufferSize <= 0))
      {
        Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
        i = j;
      }
      else if ((this.bufferSize != 0) && (this.INV == 0L))
      {
        Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.INV);
        i = j;
      }
      else if ((!TextUtils.isEmpty(this.INS)) && (!this.INW.supportFeature(2008)))
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
        localObject2 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.INN).key("cache_option").value(this.INU).key("js_src_kind").value(this.INO).key("js_src").value(this.INP);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.cacheKey)) {
          localObject1 = ((JSONStringer)localObject2).key("cache_key").value(this.cacheKey);
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.INQ)) {
          localObject2 = ((JSONStringer)localObject1).key("append_script").value(this.INQ);
        }
        if (TextUtils.isEmpty(this.INS)) {
          continue;
        }
        localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("path").key("js_param").value(this.INS);
        ((JSONStringer)localObject1).endObject();
        localStringBuilder.append(((JSONStringer)localObject1).toString());
        if ((this.INW != null) && (this.INW.supportFeature(2004))) {
          localStringBuilder.append("XWEB_SCRIPT_END\n\r" + this.INR);
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
      if (this.INV != 0L)
      {
        localObject1 = localObject2;
        if (this.bufferSize != 0) {
          localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.INV)).key("js_param_length").value(this.bufferSize);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ae
 * JD-Core Version:    0.7.0.1
 */