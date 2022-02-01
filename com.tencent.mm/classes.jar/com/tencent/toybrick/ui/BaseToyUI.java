package com.tencent.toybrick.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BaseActivity;
import java.util.HashMap;

public abstract class BaseToyUI<T>
  extends BaseActivity
{
  private HashMap<String, Object> bIx = new HashMap();
  
  public void onDestroy()
  {
    super.onDestroy();
    this.bIx.clear();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.ui.BaseToyUI
 * JD-Core Version:    0.7.0.1
 */