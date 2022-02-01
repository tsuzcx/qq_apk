package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mm.storage.am;

public abstract class ProfileItemView
  extends FrameLayout
{
  public am pMt;
  
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
  
  public boolean aa(am paramam)
  {
    this.pMt = paramam;
    return dBj();
  }
  
  public abstract boolean dBj();
  
  public abstract int getLayout();
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileItemView
 * JD-Core Version:    0.7.0.1
 */