package com.tencent.smtt.sdk;

class bo
  extends Thread
{
  bo(WebView paramWebView, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    this.a.tbsWebviewDestroy(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.bo
 * JD-Core Version:    0.7.0.1
 */