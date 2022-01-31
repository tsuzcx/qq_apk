package com.tencent.toybrick.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.toybrick.c.f;
import java.util.HashMap;

public abstract class BaseToyUI<T extends f>
  extends BaseActivity
{
  private HashMap<String, f> dw = new HashMap();
  
  public void onDestroy()
  {
    super.onDestroy();
    this.dw.clear();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.toybrick.ui.BaseToyUI
 * JD-Core Version:    0.7.0.1
 */