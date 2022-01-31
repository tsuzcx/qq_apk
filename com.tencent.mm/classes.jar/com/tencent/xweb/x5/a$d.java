package com.tencent.xweb.x5;

public final class a$d<T>
  implements com.tencent.smtt.sdk.ValueCallback<T>
{
  android.webkit.ValueCallback<T> xkl;
  
  public a$d(android.webkit.ValueCallback<T> paramValueCallback)
  {
    this.xkl = paramValueCallback;
  }
  
  public final void onReceiveValue(T paramT)
  {
    if (this.xkl != null) {
      this.xkl.onReceiveValue(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.a.d
 * JD-Core Version:    0.7.0.1
 */