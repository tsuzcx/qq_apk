package com.tencent.mm.plugin.voip.model;

import java.util.concurrent.locks.ReentrantLock;

public final class k
{
  private static k pQz = new k();
  private ReentrantLock btU = new ReentrantLock();
  private j pQA;
  
  public static j bQj()
  {
    if (pQz.pQA == null) {
      pQz.btU.lock();
    }
    try
    {
      if (pQz.pQA == null) {
        pQz.pQA = new j();
      }
      return pQz.pQA;
    }
    finally
    {
      pQz.btU.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.k
 * JD-Core Version:    0.7.0.1
 */