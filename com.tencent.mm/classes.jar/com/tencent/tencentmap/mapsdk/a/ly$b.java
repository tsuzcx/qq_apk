package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.a;
import com.tencent.map.lib.b;
import com.tencent.map.lib.c;
import java.lang.ref.WeakReference;

public class ly$b
  implements a
{
  private final WeakReference<ly> a;
  
  public ly$b(ly paramly)
  {
    this.a = new WeakReference(paramly);
  }
  
  public jt a()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return null;
    }
    return ((ly)this.a.get()).b;
  }
  
  public kt b()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return null;
    }
    return ((ly)this.a.get()).c;
  }
  
  public b c()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return null;
    }
    return ((ly)this.a.get()).d;
  }
  
  public c d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ly.b
 * JD-Core Version:    0.7.0.1
 */