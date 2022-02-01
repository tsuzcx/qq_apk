package com.tencent.xweb.xwalk;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.af;
import com.tencent.xweb.internal.IWebView;
import org.xwalk.core.Log;

public final class s
{
  private final IWebView aipF;
  private int oG = -1;
  
  public s(IWebView paramIWebView)
  {
    this.aipF = paramIWebView;
  }
  
  public final a C(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(212803);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase("onContentHeightChanged")))
    {
      int i = paramBundle.getInt("height");
      if (i != this.oG)
      {
        this.oG = i;
        if ((this.aipF != null) && (this.aipF.getWebViewCallbackClient() != null))
        {
          Log.i("XWebWebViewClientExtensionInterceptor", "onContentHeightChanged, height:".concat(String.valueOf(i)));
          this.aipF.getWebViewCallbackClient().Bv(i);
          paramString = new a(true);
          AppMethodBeat.o(212803);
          return paramString;
        }
      }
    }
    paramString = new a(false);
    AppMethodBeat.o(212803);
    return paramString;
  }
  
  public static final class a
  {
    public boolean aipG = false;
    public Object result = null;
    
    public a(boolean paramBoolean)
    {
      this.aipG = paramBoolean;
      this.result = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.s
 * JD-Core Version:    0.7.0.1
 */