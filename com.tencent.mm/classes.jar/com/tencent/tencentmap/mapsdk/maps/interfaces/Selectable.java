package com.tencent.tencentmap.mapsdk.maps.interfaces;

public abstract interface Selectable
{
  public abstract boolean isSelected();
  
  public abstract void setSelected(boolean paramBoolean);
  
  public abstract <T> void setSelectedListener(OnSelectedListener<T> paramOnSelectedListener);
  
  public static abstract interface OnSelectedListener<T>
  {
    public abstract void onSelected(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
 * JD-Core Version:    0.7.0.1
 */