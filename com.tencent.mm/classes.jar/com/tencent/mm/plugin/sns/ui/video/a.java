package com.tencent.mm.plugin.sns.ui.video;

import android.graphics.Rect;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;

public abstract interface a
{
  public abstract void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt);
  
  public abstract Rect getDisplayRect();
  
  public abstract void onUIPause();
  
  public abstract void pause();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.a
 * JD-Core Version:    0.7.0.1
 */