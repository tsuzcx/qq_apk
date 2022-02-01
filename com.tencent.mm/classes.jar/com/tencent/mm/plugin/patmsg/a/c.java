package com.tencent.mm.plugin.patmsg.a;

import android.view.View;
import android.view.View.OnClickListener;

public abstract interface c
{
  public abstract a getDoubleClickListener();
  
  public abstract View.OnClickListener getOnClickListener();
  
  public abstract int getTagScene();
  
  public abstract String getTagTalker();
  
  public abstract String getTagUsername();
  
  public static abstract interface a
  {
    public abstract boolean fH(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.c
 * JD-Core Version:    0.7.0.1
 */