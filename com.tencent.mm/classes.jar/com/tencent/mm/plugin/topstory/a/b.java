package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.xweb.WebView.WebViewKind;

public abstract interface b
  extends com.tencent.mm.kernel.b.d
{
  public abstract d getRedDotMgr();
  
  public abstract e getReporter();
  
  public abstract WebView.WebViewKind getWebViewType();
  
  public abstract void onVideoListUIDestroy(foe paramfoe);
  
  public abstract void onVideoListUIPause();
  
  public abstract void onVideoListUIResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b
 * JD-Core Version:    0.7.0.1
 */