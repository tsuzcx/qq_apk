package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.List;

public abstract interface BubbleGroup
{
  public static final int INVALID_BUBBLE_ID = -1;
  
  public abstract int addBubble(BubbleOptions paramBubbleOptions);
  
  public abstract void clearBubbleGroup();
  
  public abstract boolean containsBubble(int paramInt);
  
  public abstract List<Integer> getBubbleIds();
  
  public abstract boolean remove(int paramInt);
  
  public abstract boolean updateBubble(int paramInt, BubbleOptions paramBubbleOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BubbleGroup
 * JD-Core Version:    0.7.0.1
 */