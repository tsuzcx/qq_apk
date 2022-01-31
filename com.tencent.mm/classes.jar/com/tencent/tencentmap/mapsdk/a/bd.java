package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.LinkedBlockingQueue;

public class bd
{
  private LinkedBlockingQueue<ar> a;
  private LinkedBlockingQueue<be> b;
  
  public void a(ar paramar)
  {
    if (!this.a.offer(paramar)) {
      bc.a("AsyncCall|send queue is full");
    }
  }
  
  public void a(be parambe)
  {
    if (!this.b.offer(parambe)) {
      bc.a("AsyncCall|recv queue is full");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bd
 * JD-Core Version:    0.7.0.1
 */