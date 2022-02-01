package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ag
{
  private JSONStringer MNI;
  private int MNJ;
  private String MNK;
  private String MNL;
  private String MNM;
  private String MNN;
  private String MNO;
  private int MNP;
  private long MNQ;
  private WebView MNR;
  private final String TAG;
  private int bufferSize;
  public String cacheKey;
  
  public ag(int paramInt1, int paramInt2, WebView paramWebView)
  {
    AppMethodBeat.i(156933);
    this.TAG = "XWebScript";
    this.MNI = new JSONStringer();
    this.MNJ = 0;
    this.MNP = 0;
    this.MNJ = paramInt1;
    this.MNP = paramInt2;
    this.MNR = paramWebView;
    AppMethodBeat.o(156933);
  }
  
  public final void bcE(String paramString)
  {
    AppMethodBeat.i(224547);
    nh(paramString, "path");
    AppMethodBeat.o(224547);
  }
  
  public final void bcF(String paramString)
  {
    AppMethodBeat.i(156935);
    nh(paramString, "string");
    AppMethodBeat.o(156935);
  }
  
  public final void bcG(String paramString)
  {
    this.MNO = paramString;
  }
  
  public final void bcH(String paramString)
  {
    this.MNN = paramString;
  }
  
  public final void ng(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156934);
    nh(paramString1, "path");
    this.MNM = paramString2;
    AppMethodBeat.o(156934);
  }
  
  public final void nh(String paramString1, String paramString2)
  {
    this.MNL = paramString1;
    this.MNK = paramString2;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(156936);
    int i = j;
    if (this.MNR != null)
    {
      if (this.MNR.supportFeature(2002)) {
        break label43;
      }
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(156936);
      return "";
      label43:
      if (TextUtils.isEmpty(this.MNL))
      {
        Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.MNL);
        i = j;
      }
      else if (TextUtils.isEmpty(this.MNK))
      {
        Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.MNK);
        i = j;
      }
      else if (this.MNJ < 0)
      {
        Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.MNJ);
        i = j;
      }
      else if ((this.MNQ != 0L) && (this.bufferSize <= 0))
      {
        Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
        i = j;
      }
      else if ((this.bufferSize != 0) && (this.MNQ == 0L))
      {
        Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.MNQ);
        i = j;
      }
      else if ((!TextUtils.isEmpty(this.MNO)) && (!this.MNR.supportFeature(2008)))
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
        localObject2 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.MNJ).key("cache_option").value(this.MNP).key("js_src_kind").value(this.MNK).key("js_src").value(this.MNL);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.cacheKey)) {
          localObject1 = ((JSONStringer)localObject2).key("cache_key").value(this.cacheKey);
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.MNM)) {
          localObject2 = ((JSONStringer)localObject1).key("append_script").value(this.MNM);
        }
        if (TextUtils.isEmpty(this.MNO)) {
          continue;
        }
        localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("path").key("js_param").value(this.MNO);
        ((JSONStringer)localObject1).endObject();
        localStringBuilder.append(((JSONStringer)localObject1).toString());
        if ((this.MNR != null) && (this.MNR.supportFeature(2004))) {
          localStringBuilder.append("XWEB_SCRIPT_END\n\r" + this.MNN);
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
      if (this.MNQ != 0L)
      {
        localObject1 = localObject2;
        if (this.bufferSize != 0) {
          localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.MNQ)).key("js_param_length").value(this.bufferSize);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ag
 * JD-Core Version:    0.7.0.1
 */