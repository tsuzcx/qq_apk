package com.tinkerboots.sdk.b;

import java.util.HashSet;

public final class c
{
  private static String xnT;
  private static HashSet<String> xnU = new HashSet();
  
  public static String cUa()
  {
    if (xnT == null) {
      return "";
    }
    return xnT;
  }
  
  public static boolean cUb()
  {
    if (xnT == null) {
      return false;
    }
    return xnU.contains(xnT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */