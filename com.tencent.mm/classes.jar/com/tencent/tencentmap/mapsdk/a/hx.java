package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

class hx
  extends ib
{
  private boolean g = true;
  
  public hx(ia.a... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public hx a()
  {
    ArrayList localArrayList = this.e;
    int j = this.e.size();
    ia.a[] arrayOfa = new ia.a[j];
    int i = 0;
    while (i < j)
    {
      arrayOfa[i] = ((ia.a)((ia)localArrayList.get(i)).d());
      i += 1;
    }
    return new hx(arrayOfa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.hx
 * JD-Core Version:    0.7.0.1
 */