package com.tencent.tencentmap.mapsdk.a;

import com.qq.navi.Handler;
import java.util.concurrent.LinkedBlockingQueue;

public class bf
  extends Handler
{
  private LinkedBlockingQueue<bg> a;
  
  public void a(bg parambg, bk parambk)
  {
    parambg.i = parambk;
    this.a.offer(parambg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bf
 * JD-Core Version:    0.7.0.1
 */