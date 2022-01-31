package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class aj
  extends i<ai>
{
  public static final String[] dXp = { i.a(ai.buS, "WebviewLocalData") };
  
  public aj(e parame)
  {
    super(parame, ai.buS, "WebviewLocalData", null);
  }
  
  public static int ai(String paramString1, String paramString2, String paramString3)
  {
    return (paramString1 + paramString2 + paramString3).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aj
 * JD-Core Version:    0.7.0.1
 */