package com.tencent.toybrick.ui;

import com.tencent.mm.ui.BaseActivity;
import com.tencent.toybrick.c.f;
import java.util.HashMap;

public abstract class BaseToyUI<T extends f>
  extends BaseActivity
{
  private HashMap<String, f> cJ = new HashMap();
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.cJ.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.toybrick.ui.BaseToyUI
 * JD-Core Version:    0.7.0.1
 */