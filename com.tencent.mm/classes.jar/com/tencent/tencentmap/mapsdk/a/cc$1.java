package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;

class cc$1
  implements Runnable
{
  cc$1(cc paramcc) {}
  
  public void run()
  {
    long l = Millis100TimeProvider.INSTANCE.currentTimeMillis();
    int i = this.a.a();
    if (i > 0) {
      bc.a("cleanSize:" + i + " cost:" + (Millis100TimeProvider.INSTANCE.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cc.1
 * JD-Core Version:    0.7.0.1
 */