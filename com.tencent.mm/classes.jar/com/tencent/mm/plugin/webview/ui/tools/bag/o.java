package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class o
  implements InvocationHandler
{
  private boolean mEnable;
  private n rsQ;
  private h rsR = new o.1(this);
  
  private o() {}
  
  private o(g paramg, boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
    if (paramBoolean) {
      this.rsQ = new n(paramg);
    }
  }
  
  public static h a(g paramg, boolean paramBoolean)
  {
    paramg = new o(paramg, paramBoolean);
    return (h)Proxy.newProxyInstance(o.class.getClassLoader(), new Class[] { h.class }, paramg);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (!this.mEnable) {
      try
      {
        paramObject = paramMethod.invoke(this.rsR, paramArrayOfObject);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        y.i("MicroMsg.WebViewUIBagHelperProxy", "not enable mEmptyHelper invoke e:%s", new Object[] { paramObject });
        throw paramObject.getCause();
      }
    }
    try
    {
      paramObject = paramMethod.invoke(this.rsQ, paramArrayOfObject);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      y.i("MicroMsg.WebViewUIBagHelperProxy", "mWebViewUIBagHelper invoke e:%s", new Object[] { paramObject });
      throw paramObject.getCause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.o
 * JD-Core Version:    0.7.0.1
 */