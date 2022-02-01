package com.tencent.mm.ui.widget.cedit.edit;

public final class c
{
  long agcf;
  float agcg;
  float agch;
  long agci;
  boolean agcj;
  int agck = 0;
  boolean agcl;
  boolean agcm;
  boolean agcn;
  float uJC;
  float uJD;
  
  public static boolean b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= paramInt * paramInt;
  }
  
  public final boolean jHc()
  {
    return (this.agck == 2) || (this.agck == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.c
 * JD-Core Version:    0.7.0.1
 */