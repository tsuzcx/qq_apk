package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONStringer;
import org.xwalk.core.Log;

public final class aa
{
  private JSONStringer BEB;
  private int BEC;
  private String BED;
  private String BEE;
  private String BEF;
  private String BEG;
  private int BEH;
  private long BEI;
  private WebView BEJ;
  private final String TAG;
  private int bufferSize;
  private String cacheKey;
  
  public aa(int paramInt1, int paramInt2, WebView paramWebView)
  {
    AppMethodBeat.i(151437);
    this.TAG = "XWebScript";
    this.BEB = new JSONStringer();
    this.BEC = 0;
    this.BEH = 0;
    this.BEC = paramInt1;
    this.BEH = paramInt2;
    this.BEJ = paramWebView;
    AppMethodBeat.o(151437);
  }
  
  public final void M(long paramLong, int paramInt)
  {
    this.BEI = paramLong;
    this.bufferSize = paramInt;
  }
  
  public final void aya(String paramString)
  {
    AppMethodBeat.i(151438);
    ja(paramString, "string");
    AppMethodBeat.o(151438);
  }
  
  public final void ayb(String paramString)
  {
    this.BEG = paramString;
  }
  
  public final void ja(String paramString1, String paramString2)
  {
    this.BEE = paramString1;
    this.BED = paramString2;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(151439);
    int i = j;
    if (this.BEJ != null)
    {
      if (this.BEJ.supportFeature(2002)) {
        break label43;
      }
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(151439);
      return "";
      label43:
      if (TextUtils.isEmpty(this.BEE))
      {
        Log.e("XWebScript", "checkValid failed jsSrcValue invalid = " + this.BEE);
        i = j;
      }
      else if (TextUtils.isEmpty(this.BED))
      {
        Log.e("XWebScript", "checkValid failed jsSrcKind invalid = " + this.BED);
        i = j;
      }
      else if (this.BEC < 0)
      {
        Log.e("XWebScript", "checkValid failed compile mode invalid = " + this.BEC);
        i = j;
      }
      else if ((this.BEI != 0L) && (this.bufferSize <= 0))
      {
        Log.e("XWebScript", "checkValid failed bufferSize invalid = " + this.bufferSize);
        i = j;
      }
      else if ((this.bufferSize != 0) && (this.BEI == 0L))
      {
        Log.e("XWebScript", "checkValid failed bufferAddr invalid = " + this.BEI);
        i = j;
      }
      else
      {
        i = 1;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("//XWEB_SCRIPT:");
    Object localObject1 = new JSONStringer();
    try
    {
      Object localObject2 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.BEC).key("cache_option").value(this.BEH).key("js_src_kind").value(this.BED).key("js_src").value(this.BEE);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.cacheKey)) {
        localObject1 = ((JSONStringer)localObject2).key("cache_key").value(this.cacheKey);
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(this.BEF)) {
        localObject2 = ((JSONStringer)localObject1).key("append_script").value(this.BEF);
      }
      localObject1 = localObject2;
      if (this.BEI != 0L)
      {
        localObject1 = localObject2;
        if (this.bufferSize != 0) {
          localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.BEI)).key("js_param_length").value(this.bufferSize);
        }
      }
      ((JSONStringer)localObject1).endObject();
      localStringBuilder.append(((JSONStringer)localObject1).toString());
      if ((this.BEJ != null) && (this.BEJ.supportFeature(2004))) {
        localStringBuilder.append("XWEB_SCRIPT_END\n\r" + this.BEG);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWebScript", "xweb script create failed " + localException.getMessage());
      }
    }
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(151439);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.aa
 * JD-Core Version:    0.7.0.1
 */