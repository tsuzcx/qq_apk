package com.tencent.soter.core.c;

import junit.framework.Assert;

public final class h
{
  private static volatile h.a wOU = new h.1();
  
  public static void a(h.a parama)
  {
    Assert.assertNotNull(parama);
    wOU = parama;
  }
  
  public static void cPr()
  {
    wOU.cPt();
  }
  
  public static boolean cPs()
  {
    return wOU.cPs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */