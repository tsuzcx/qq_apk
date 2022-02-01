package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.xweb.WebView.c;

public abstract interface b
  extends d
{
  public abstract e getRedDotMgr();
  
  public abstract f getReporter();
  
  public abstract WebView.c getWebViewType();
  
  public abstract void onVideoListUIDestroy(eit parameit);
  
  public abstract void onVideoListUIPause();
  
  public abstract void onVideoListUIResume();
  
  public abstract boolean openJsAccelerate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b
 * JD-Core Version:    0.7.0.1
 */