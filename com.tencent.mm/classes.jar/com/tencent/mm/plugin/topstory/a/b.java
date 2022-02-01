package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.xweb.WebView.c;

public abstract interface b
  extends d
{
  public abstract e getRedDotMgr();
  
  public abstract f getReporter();
  
  public abstract WebView.c getWebViewType();
  
  public abstract void onVideoListUIDestroy(esv paramesv);
  
  public abstract void onVideoListUIPause();
  
  public abstract void onVideoListUIResume();
  
  public abstract boolean openJsAccelerate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b
 * JD-Core Version:    0.7.0.1
 */