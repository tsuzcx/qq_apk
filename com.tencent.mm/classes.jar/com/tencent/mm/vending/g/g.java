package com.tencent.mm.vending.g;

import java.util.Stack;

final class g
{
  private static g wtX = new g();
  ThreadLocal<Stack<c>> b = new ThreadLocal();
  
  public static g cLd()
  {
    return wtX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.g
 * JD-Core Version:    0.7.0.1
 */