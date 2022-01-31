package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.view.i;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window.Callback;

public final class c
  extends i
{
  private Activity mActivity;
  
  public c(Window.Callback paramCallback, Activity paramActivity)
  {
    super(paramCallback);
    this.mActivity = paramActivity;
  }
  
  public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.mActivity.onWindowStartingActionMode(paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.b.c
 * JD-Core Version:    0.7.0.1
 */