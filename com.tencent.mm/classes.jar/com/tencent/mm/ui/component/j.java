package com.tencent.mm.ui.component;

import android.view.View;

public abstract class j
  extends m
{
  public <T extends View> T findViewById(int paramInt)
  {
    View localView = getFindViewIdRootView();
    if (localView == null) {
      return null;
    }
    return localView.findViewById(paramInt);
  }
  
  protected abstract View getFindViewIdRootView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.j
 * JD-Core Version:    0.7.0.1
 */