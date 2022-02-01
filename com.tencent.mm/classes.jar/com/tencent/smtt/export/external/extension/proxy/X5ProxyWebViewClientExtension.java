package com.tencent.smtt.export.external.extension.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;

public abstract class X5ProxyWebViewClientExtension
  extends ProxyWebViewClientExtension
{
  public X5ProxyWebViewClientExtension(WebViewWizardBase paramWebViewWizardBase)
  {
    this.mWebViewClientExt = ((IX5WebViewClientExtension)paramWebViewWizardBase.newInstance("com.tencent.smtt.webkit.WebViewClientExtension"));
  }
  
  public X5ProxyWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    this.mWebViewClientExt = paramIX5WebViewClientExtension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension
 * JD-Core Version:    0.7.0.1
 */