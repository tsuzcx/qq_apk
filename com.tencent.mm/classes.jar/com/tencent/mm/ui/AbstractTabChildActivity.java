package com.tencent.mm.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class AbstractTabChildActivity
  extends AppCompatActivity
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildActivity
 * JD-Core Version:    0.7.0.1
 */