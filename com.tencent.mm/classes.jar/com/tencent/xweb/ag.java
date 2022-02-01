package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class ag
{
  private JSONStringer KAj;
  private int KAk;
  private String KAl;
  private String KAm;
  private String KAn;
  private String KAo;
  private String KAp;
  private int KAq;
  private long KAr;
  private WebView KAs;
  private final String TAG;
  private int bufferSize;
  private String cacheKey;
  
  public ag(int paramInt1, int paramInt2, WebView paramWebView)
  {
    AppMethodBeat.i(156933);
    this.TAG = "XWebScript";
    this.KAj = new JSONStringer();
    this.KAk = 0;
    this.KAq = 0;
    this.KAk = paramInt1;
    this.KAq = paramInt2;
    this.KAs = paramWebView;
    AppMethodBeat.o(156933);
  }
  
  public final void aUY(String paramString)
  {
    AppMethodBeat.i(210392);
    mD(paramString, "path");
    AppMethodBeat.o(210392);
  }
  
  public final void aUZ(String paramString)
  {
    AppMethodBeat.i(156935);
    mD(paramString, "string");
    AppMethodBeat.o(156935);
  }
  
  public final void aVa(String paramString)
  {
    this.KAp = paramString;
  }
  
  public final void aVb(String paramString)
  {
    this.KAo = paramString;
  }
  
  public final void mC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156934);
    mD(paramString1, "path");
    this.KAn = paramString2;
    AppMethodBeat.o(156934);
  }
  
  public final void mD(String paramString1, String paramString2)
  {
    this.KAm = paramString1;
    this.KAl = paramString2;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(156936);
    int i = j;
    if (this.KAs != null)
    {
      if (this.KAs.supportFeature(2002)) {
        break label43;
      }
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(156936);
      return "";
      label43:
      if (TextUtils.isEmpty(this.KAm))
      {
        Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.KAm);
        i = j;
      }
      else if (TextUtils.isEmpty(this.KAl))
      {
        Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.KAl);
        i = j;
      }
      else if (this.KAk < 0)
      {
        Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.KAk);
        i = j;
      }
      else if ((this.KAr != 0L) && (this.bufferSize <= 0))
      {
        Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
        i = j;
      }
      else if ((this.bufferSize != 0) && (this.KAr == 0L))
      {
        Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.KAr);
        i = j;
      }
      else if ((!TextUtils.isEmpty(this.KAp)) && (!this.KAs.supportFeature(2008)))
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
        localObject2 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.KAk).key("cache_option").value(this.KAq).key("js_src_kind").value(this.KAl).key("js_src").value(this.KAm);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.cacheKey)) {
          localObject1 = ((JSONStringer)localObject2).key("cache_key").value(this.cacheKey);
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.KAn)) {
          localObject2 = ((JSONStringer)localObject1).key("append_script").value(this.KAn);
        }
        if (TextUtils.isEmpty(this.KAp)) {
          continue;
        }
        localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("path").key("js_param").value(this.KAp);
        ((JSONStringer)localObject1).endObject();
        localStringBuilder.append(((JSONStringer)localObject1).toString());
        if ((this.KAs != null) && (this.KAs.supportFeature(2004))) {
          localStringBuilder.append("XWEB_SCRIPT_END\n\r" + this.KAo);
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
      if (this.KAr != 0L)
      {
        localObject1 = localObject2;
        if (this.bufferSize != 0) {
          localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.KAr)).key("js_param_length").value(this.bufferSize);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ag
 * JD-Core Version:    0.7.0.1
 */