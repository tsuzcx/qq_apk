package com.tencent.mm.ui.component;

import android.view.View;

public abstract class f
  extends b
{
  public <T extends View> T findViewById(int paramInt)
  {
    View localView = getFindIdDelegateView();
    if (localView == null) {
      return null;
    }
    return localView.findViewById(paramInt);
  }
  
  protected abstract View getFindIdDelegateView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.f
 * JD-Core Version:    0.7.0.1
 */