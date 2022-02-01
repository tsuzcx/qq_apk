package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static volatile b LRb = null;
  public int LRc;
  public SparseArray<String> LRd;
  public SharedPreferences LRe;
  public boolean cAX;
  public boolean dmr;
  
  public b()
  {
    AppMethodBeat.i(16);
    this.cAX = false;
    this.dmr = false;
    this.LRc = 0;
    this.LRd = new SparseArray(10);
    this.LRe = null;
    AppMethodBeat.o(16);
  }
  
  public static b fUW()
  {
    AppMethodBeat.i(17);
    if (LRb == null) {
      try
      {
        if (LRb == null) {
          LRb = new b();
        }
        b localb1 = LRb;
        return localb1;
      }
      finally
      {
        AppMethodBeat.o(17);
      }
    }
    b localb2 = LRb;
    AppMethodBeat.o(17);
    return localb2;
  }
  
  public final boolean fUS()
  {
    try
    {
      boolean bool = this.dmr;
      return bool;
    }
    finally {}
  }
  
  public final void fUX()
  {
    try
    {
      this.cAX = true;
      return;
    }
    finally {}
  }
  
  public final SparseArray<String> fUY()
  {
    try
    {
      SparseArray localSparseArray = this.LRd;
      return localSparseArray;
    }
    finally {}
  }
  
  public final SharedPreferences fUZ()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.LRe;
      return localSharedPreferences;
    }
    finally {}
  }
  
  public final boolean isInit()
  {
    try
    {
      boolean bool = this.cAX;
      return bool;
    }
    finally {}
  }
  
  public final void zs(boolean paramBoolean)
  {
    try
    {
      this.dmr = paramBoolean;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.c.b
 * JD-Core Version:    0.7.0.1
 */