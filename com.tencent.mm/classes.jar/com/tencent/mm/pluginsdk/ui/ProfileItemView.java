package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mm.storage.as;

public abstract class ProfileItemView
  extends FrameLayout
{
  public as rjX;
  
  public ProfileItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(getLayout(), this);
    init();
  }
  
  public boolean aj(as paramas)
  {
    this.rjX = paramas;
    return eEV();
  }
  
  public abstract boolean eEV();
  
  public abstract int getLayout();
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileItemView
 * JD-Core Version:    0.7.0.1
 */