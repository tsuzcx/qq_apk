package com.tencent.mm.plugin.n;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements b, com.tencent.mm.kernel.b.c
{
  private static c lnN;
  
  public static String FG()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    g.DQ();
    return g.DP().dKt + "image/";
  }
  
  public static String FH()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    g.DQ();
    return g.DP().dKt + "image2/";
  }
  
  public static c bbt()
  {
    try
    {
      if (lnN == null) {
        lnN = new c();
      }
      c localc = lnN;
      return localc;
    }
    finally {}
  }
  
  public static String bbu()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    g.DQ();
    return g.DP().dKt + "bizmsg/";
  }
  
  public final List<String> collectStoragePaths()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "image/", "image2/", "sfs", "bizmsg/" });
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.n.c
 * JD-Core Version:    0.7.0.1
 */