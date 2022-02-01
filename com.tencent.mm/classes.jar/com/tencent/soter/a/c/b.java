package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static volatile b Ivx = null;
  public SharedPreferences IvA;
  public int Ivy;
  public SparseArray<String> Ivz;
  public boolean csX;
  public boolean ddz;
  
  public b()
  {
    AppMethodBeat.i(16);
    this.csX = false;
    this.ddz = false;
    this.Ivy = 0;
    this.Ivz = new SparseArray(10);
    this.IvA = null;
    AppMethodBeat.o(16);
  }
  
  public static b fno()
  {
    AppMethodBeat.i(17);
    if (Ivx == null) {
      try
      {
        if (Ivx == null) {
          Ivx = new b();
        }
        b localb1 = Ivx;
        return localb1;
      }
      finally
      {
        AppMethodBeat.o(17);
      }
    }
    b localb2 = Ivx;
    AppMethodBeat.o(17);
    return localb2;
  }
  
  public final boolean fnk()
  {
    try
    {
      boolean bool = this.ddz;
      return bool;
    }
    finally {}
  }
  
  public final void fnp()
  {
    try
    {
      this.csX = true;
      return;
    }
    finally {}
  }
  
  public final SparseArray<String> fnq()
  {
    try
    {
      SparseArray localSparseArray = this.Ivz;
      return localSparseArray;
    }
    finally {}
  }
  
  public final SharedPreferences fnr()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.IvA;
      return localSharedPreferences;
    }
    finally {}
  }
  
  public final boolean isInit()
  {
    try
    {
      boolean bool = this.csX;
      return bool;
    }
    finally {}
  }
  
  public final void xv(boolean paramBoolean)
  {
    try
    {
      this.ddz = paramBoolean;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.c.b
 * JD-Core Version:    0.7.0.1
 */