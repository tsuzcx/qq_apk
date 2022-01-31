package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

public class LoadDataWebviewUI
  extends PreLoadWebViewUI
{
  private CountDownLatch ruV = new CountDownLatch(1);
  
  public void aoX()
  {
    super.aoX();
    this.ruV.countDown();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI
 * JD-Core Version:    0.7.0.1
 */