package com.tencent.mm.ui.widget.cedit.edit;

public final class c
{
  long QLo;
  float QLp;
  float QLq;
  long QLr;
  boolean QLs;
  int QLt = 0;
  boolean QLu;
  boolean QLv;
  boolean QLw;
  float ovM;
  float ovN;
  
  public static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= paramInt * paramInt;
  }
  
  public final boolean haT()
  {
    return (this.QLt == 2) || (this.QLt == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.c
 * JD-Core Version:    0.7.0.1
 */