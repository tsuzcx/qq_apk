package com.tencent.tencentmap.mapsdk.a;

class ia$b
  extends ia
{
  Object d;
  
  ia$b(float paramFloat, Object paramObject)
  {
    this.a = paramFloat;
    this.d = paramObject;
    boolean bool;
    if (paramObject != null)
    {
      bool = true;
      this.c = bool;
      if (!this.c) {
        break label48;
      }
    }
    label48:
    for (paramObject = paramObject.getClass();; paramObject = Object.class)
    {
      this.b = paramObject;
      return;
      bool = false;
      break;
    }
  }
  
  public Object a()
  {
    return this.d;
  }
  
  public b e()
  {
    b localb = new b(b(), this.d);
    localb.a(c());
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ia.b
 * JD-Core Version:    0.7.0.1
 */