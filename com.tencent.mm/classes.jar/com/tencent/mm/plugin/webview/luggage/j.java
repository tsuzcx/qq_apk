package com.tencent.mm.plugin.webview.luggage;

import java.util.LinkedList;

public final class j
{
  private static LinkedList<e> rcA = new LinkedList();
  
  public static LinkedList<e> cbl()
  {
    return rcA;
  }
  
  public static void h(e parame)
  {
    rcA.add(parame);
  }
  
  public static void i(e parame)
  {
    rcA.remove(parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.j
 * JD-Core Version:    0.7.0.1
 */