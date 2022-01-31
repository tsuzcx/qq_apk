package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;

public final class an$b
{
  public Bundle kke = null;
  
  public an$b(an paraman, Bundle paramBundle)
  {
    this.kke = paramBundle;
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    if (this.kke != null)
    {
      if ((paramObject instanceof String)) {
        this.kke.putString(paramString, (String)paramObject);
      }
    }
    else {
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      this.kke.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Integer))
    {
      this.kke.putInt(paramString, ((Integer)paramObject).intValue());
      return;
    }
    y.w("MicroMsg.WebviewReporter", "put unknow type value.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an.b
 * JD-Core Version:    0.7.0.1
 */