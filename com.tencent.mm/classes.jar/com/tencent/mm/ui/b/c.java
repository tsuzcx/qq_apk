package com.tencent.mm.ui.b;

import android.app.Activity;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window.Callback;
import androidx.appcompat.view.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(141517);
    paramCallback = this.mActivity.onWindowStartingActionMode(paramCallback);
    AppMethodBeat.o(141517);
    return paramCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.b.c
 * JD-Core Version:    0.7.0.1
 */