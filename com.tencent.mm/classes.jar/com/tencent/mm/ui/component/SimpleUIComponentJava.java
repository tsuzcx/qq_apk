package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.view.View;

public abstract class SimpleUIComponentJava
  extends ViewModel
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.SimpleUIComponentJava
 * JD-Core Version:    0.7.0.1
 */