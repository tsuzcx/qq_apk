package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TrafficStyle
{
  private int mCongestedColor;
  private int mCongestedStrokeColor;
  private int mSeriousCongestedColor;
  private int mSeriousCongestedStrokeColor;
  private int mSlowColor;
  private int mSlowStrokeColor;
  private int mSmoothColor;
  private int mSmoothStrokeColor;
  private int mStrokeWidth;
  private int mWidth;
  
  public TrafficStyle()
  {
    AppMethodBeat.i(209871);
    this.mWidth = 3;
    this.mStrokeWidth = 0;
    this.mSmoothColor = -16722688;
    this.mSlowColor = -16128;
    this.mCongestedColor = -46250;
    this.mSeriousCongestedColor = -7300827;
    this.mSmoothStrokeColor = this.mSmoothColor;
    this.mSlowStrokeColor = this.mSlowColor;
    this.mCongestedStrokeColor = this.mCongestedColor;
    this.mSeriousCongestedStrokeColor = this.mSeriousCongestedColor;
    AppMethodBeat.o(209871);
  }
  
  public TrafficStyle setCongestedColor(int paramInt)
  {
    this.mCongestedColor = paramInt;
    return this;
  }
  
  public TrafficStyle setCongestedStrokeColor(int paramInt)
  {
    this.mCongestedStrokeColor = paramInt;
    return this;
  }
  
  public TrafficStyle setSeriousCongestedColor(int paramInt)
  {
    this.mSeriousCongestedColor = paramInt;
    return this;
  }
  
  public TrafficStyle setSeriousCongestedStrokeColor(int paramInt)
  {
    this.mSeriousCongestedStrokeColor = paramInt;
    return this;
  }
  
  public TrafficStyle setSlowColor(int paramInt)
  {
    this.mSlowColor = paramInt;
    return this;
  }
  
  public TrafficStyle setSlowStrokeColor(int paramInt)
  {
    this.mSlowStrokeColor = paramInt;
    return this;
  }
  
  public TrafficStyle setSmoothColor(int paramInt)
  {
    this.mSmoothColor = paramInt;
    return this;
  }
  
  public TrafficStyle setSmoothStrokeColor(int paramInt)
  {
    this.mSmoothStrokeColor = paramInt;
    return this;
  }
  
  public TrafficStyle setStrokeWidth(int paramInt)
  {
    this.mStrokeWidth = paramInt;
    return this;
  }
  
  public TrafficStyle setWidth(int paramInt)
  {
    this.mWidth = paramInt;
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(209872);
    String str = "TrafficStyle{mWidth=" + this.mWidth + ", mStrokeWidth=" + this.mStrokeWidth + ", mSmoothColor=" + this.mSmoothColor + ", mSlowColor=" + this.mSlowColor + ", mCongestedColor=" + this.mCongestedColor + ", mSeriousCongestedColor=" + this.mSeriousCongestedColor + ", mSmoothStrokeColor=" + this.mSmoothStrokeColor + ", mSlowStrokeColor=" + this.mSlowStrokeColor + ", mCongestedStrokeColor=" + this.mCongestedStrokeColor + ", mSeriousCongestedStrokeColor=" + this.mSeriousCongestedStrokeColor + '}';
    AppMethodBeat.o(209872);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle
 * JD-Core Version:    0.7.0.1
 */