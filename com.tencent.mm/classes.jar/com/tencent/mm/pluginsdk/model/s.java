package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.mm.m.c;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

public final class s
{
  private static volatile s rTK = null;
  
  public static int DE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 5;
    case 0: 
      return bk.getInt(g.AB().H("QQBroswer", "RecommendCount"), 5);
    }
    return 2147483647;
  }
  
  public static void DF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      h.nFQ.f(10998, new Object[] { Integer.valueOf(0) });
      return;
    }
    h.nFQ.f(11091, new Object[] { Integer.valueOf(0) });
  }
  
  public static void DG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      h.nFQ.f(10998, new Object[] { Integer.valueOf(1) });
      return;
    }
    h.nFQ.f(11091, new Object[] { Integer.valueOf(1) });
  }
  
  public static void DH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      h.nFQ.f(10998, new Object[] { Integer.valueOf(3) });
      return;
    }
    h.nFQ.f(11091, new Object[] { Integer.valueOf(3) });
  }
  
  public static void DI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      h.nFQ.f(10998, new Object[] { Integer.valueOf(2) });
      return;
    }
    h.nFQ.f(11091, new Object[] { Integer.valueOf(2) });
  }
  
  public static s ckE()
  {
    if (rTK == null) {}
    try
    {
      if (rTK == null) {
        rTK = new s();
      }
      return rTK;
    }
    finally {}
  }
  
  public static r u(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return new o();
    case 2: 
      return new a(paramBundle);
    }
    return new w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.s
 * JD-Core Version:    0.7.0.1
 */