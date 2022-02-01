package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static volatile b MnY = null;
  public int MnZ;
  public SparseArray<String> Moa;
  public SharedPreferences Mob;
  public boolean cBE;
  public boolean dnt;
  
  public b()
  {
    AppMethodBeat.i(16);
    this.cBE = false;
    this.dnt = false;
    this.MnZ = 0;
    this.Moa = new SparseArray(10);
    this.Mob = null;
    AppMethodBeat.o(16);
  }
  
  public static b fZv()
  {
    AppMethodBeat.i(17);
    if (MnY == null) {
      try
      {
        if (MnY == null) {
          MnY = new b();
        }
        b localb1 = MnY;
        return localb1;
      }
      finally
      {
        AppMethodBeat.o(17);
      }
    }
    b localb2 = MnY;
    AppMethodBeat.o(17);
    return localb2;
  }
  
  public final boolean fZr()
  {
    try
    {
      boolean bool = this.dnt;
      return bool;
    }
    finally {}
  }
  
  public final void fZw()
  {
    try
    {
      this.cBE = true;
      return;
    }
    finally {}
  }
  
  public final SparseArray<String> fZx()
  {
    try
    {
      SparseArray localSparseArray = this.Moa;
      return localSparseArray;
    }
    finally {}
  }
  
  public final SharedPreferences fZy()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.Mob;
      return localSharedPreferences;
    }
    finally {}
  }
  
  public final boolean isInit()
  {
    try
    {
      boolean bool = this.cBE;
      return bool;
    }
    finally {}
  }
  
  public final void zG(boolean paramBoolean)
  {
    try
    {
      this.dnt = paramBoolean;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.a.c.b
 * JD-Core Version:    0.7.0.1
 */