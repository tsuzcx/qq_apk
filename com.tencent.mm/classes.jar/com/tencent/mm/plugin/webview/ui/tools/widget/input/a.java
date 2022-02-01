package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.View;

public abstract class a
{
  protected c BwH;
  Context mfC;
  int mfE = 0;
  
  public abstract int btW();
  
  public abstract int btX();
  
  public abstract int btY();
  
  public abstract int getPageCount();
  
  public abstract int getRowCount();
  
  public abstract int getRowSpacing();
  
  public final void setPanelManager(c paramc)
  {
    this.BwH = paramc;
  }
  
  public abstract View vg(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.a
 * JD-Core Version:    0.7.0.1
 */