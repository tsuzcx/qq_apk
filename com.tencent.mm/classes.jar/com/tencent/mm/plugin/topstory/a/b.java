package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.c.byf;
import com.tencent.xweb.WebView.d;

public abstract interface b
  extends d
{
  public abstract e getRedDotMgr();
  
  public abstract f getReporter();
  
  public abstract WebView.d getWebViewType();
  
  public abstract void onVideoListUIDestroy(byf parambyf);
  
  public abstract void onVideoListUIPause();
  
  public abstract void onVideoListUIResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b
 * JD-Core Version:    0.7.0.1
 */