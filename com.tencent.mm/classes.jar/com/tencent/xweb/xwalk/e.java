package com.tencent.xweb.xwalk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.xweb.a.a;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import java.util.Map;
import org.xwalk.core.XWalkWebResourceRequest;

public final class e
{
  public static final class g
    implements h
  {
    ValueCallback<Boolean> xlT;
    
    public g(ValueCallback<Boolean> paramValueCallback)
    {
      this.xlT = paramValueCallback;
    }
    
    public final void cancel()
    {
      this.xlT.onReceiveValue(Boolean.valueOf(false));
    }
    
    public final void proceed()
    {
      this.xlT.onReceiveValue(Boolean.valueOf(true));
    }
  }
  
  public static final class h
    implements l
  {
    private String method;
    private Map<String, String> rXB;
    private Uri xjH;
    private boolean xjI;
    private boolean xjJ;
    a xjK;
    
    public h(XWalkWebResourceRequest paramXWalkWebResourceRequest)
    {
      this.xjH = paramXWalkWebResourceRequest.getUrl();
      this.xjI = paramXWalkWebResourceRequest.isForMainFrame();
      this.xjJ = paramXWalkWebResourceRequest.hasGesture();
      this.method = paramXWalkWebResourceRequest.getMethod();
      this.rXB = paramXWalkWebResourceRequest.getRequestHeaders();
      this.xjK = new a(this);
    }
    
    public final String getMethod()
    {
      return this.method;
    }
    
    public final Map<String, String> getRequestHeaders()
    {
      return this.rXB;
    }
    
    public final Uri getUrl()
    {
      return this.xjH;
    }
    
    public final boolean hasGesture()
    {
      return this.xjJ;
    }
    
    public final boolean isForMainFrame()
    {
      return this.xjI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e
 * JD-Core Version:    0.7.0.1
 */