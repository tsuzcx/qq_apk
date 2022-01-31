package org.xwalk.core;

import java.util.List;

public abstract class WebViewExtensionListener
{
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract Object onMiscCallBack(String paramString, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.WebViewExtensionListener
 * JD-Core Version:    0.7.0.1
 */