package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ChangeNumView
  extends TextView
{
  private int FNL = -1;
  private int ImS = 0;
  private boolean ImT = false;
  private final int ImU = 100;
  private int max = 0;
  private int min = 0;
  
  public ChangeNumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChangeNumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setInteral(int paramInt)
  {
    this.FNL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.ChangeNumView
 * JD-Core Version:    0.7.0.1
 */