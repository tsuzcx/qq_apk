package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class AbsStoryHeaderTipView
  extends RelativeLayout
{
  public AbsStoryHeaderTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsStoryHeaderTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void hqh();
  
  public abstract void huF();
  
  public abstract void huG();
  
  public abstract void onCreateView();
  
  public abstract void onDestroyView();
  
  public abstract void setSnsType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView
 * JD-Core Version:    0.7.0.1
 */