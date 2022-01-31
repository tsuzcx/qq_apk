package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;

final class b$4
  implements Runnable
{
  b$4(b paramb, String paramString, ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    if (this.xlK.xlG == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.xlK.xlG;
      String str = this.xlL;
      localObject = ((XWAppBrandEngine)localObject).evaluateJavascript(((XWAppBrandEngine)localObject).mInstance, str);
    } while (this.xlM == null);
    this.xlM.onReceiveValue(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.4
 * JD-Core Version:    0.7.0.1
 */