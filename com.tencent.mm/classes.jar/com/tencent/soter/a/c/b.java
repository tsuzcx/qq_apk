package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static volatile b RQw = null;
  public int RQx;
  public SparseArray<String> RQy;
  public SharedPreferences RQz;
  public boolean dEI;
  public boolean isInit;
  
  public b()
  {
    AppMethodBeat.i(16);
    this.isInit = false;
    this.dEI = false;
    this.RQx = 0;
    this.RQy = new SparseArray(10);
    this.RQz = null;
    AppMethodBeat.o(16);
  }
  
  public static b hlG()
  {
    AppMethodBeat.i(17);
    if (RQw == null) {
      try
      {
        if (RQw == null) {
          RQw = new b();
        }
        b localb1 = RQw;
        return localb1;
      }
      finally
      {
        AppMethodBeat.o(17);
      }
    }
    b localb2 = RQw;
    AppMethodBeat.o(17);
    return localb2;
  }
  
  public final void DQ(boolean paramBoolean)
  {
    try
    {
      this.dEI = paramBoolean;
      return;
    }
    finally {}
  }
  
  public final boolean hlC()
  {
    try
    {
      boolean bool = this.dEI;
      return bool;
    }
    finally {}
  }
  
  public final void hlH()
  {
    try
    {
      this.isInit = true;
      return;
    }
    finally {}
  }
  
  public final SparseArray<String> hlI()
  {
    try
    {
      SparseArray localSparseArray = this.RQy;
      return localSparseArray;
    }
    finally {}
  }
  
  public final SharedPreferences hlJ()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.RQz;
      return localSharedPreferences;
    }
    finally {}
  }
  
  public final boolean isInit()
  {
    try
    {
      boolean bool = this.isInit;
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.c.b
 * JD-Core Version:    0.7.0.1
 */