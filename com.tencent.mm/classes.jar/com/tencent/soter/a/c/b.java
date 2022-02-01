package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static volatile b Zta = null;
  public int Ztb;
  public SparseArray<String> Ztc;
  public SharedPreferences Ztd;
  public boolean fxw;
  public boolean isInit;
  
  public b()
  {
    AppMethodBeat.i(16);
    this.isInit = false;
    this.fxw = false;
    this.Ztb = 0;
    this.Ztc = new SparseArray(10);
    this.Ztd = null;
    AppMethodBeat.o(16);
  }
  
  public static b ipf()
  {
    AppMethodBeat.i(17);
    if (Zta == null) {
      try
      {
        if (Zta == null) {
          Zta = new b();
        }
        b localb1 = Zta;
        return localb1;
      }
      finally
      {
        AppMethodBeat.o(17);
      }
    }
    b localb2 = Zta;
    AppMethodBeat.o(17);
    return localb2;
  }
  
  public final void Ir(boolean paramBoolean)
  {
    try
    {
      this.fxw = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean ipb()
  {
    try
    {
      boolean bool = this.fxw;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ipg()
  {
    try
    {
      this.isInit = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final SparseArray<String> iph()
  {
    try
    {
      SparseArray localSparseArray = this.Ztc;
      return localSparseArray;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final SharedPreferences ipi()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.Ztd;
      return localSharedPreferences;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean isInit()
  {
    try
    {
      boolean bool = this.isInit;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.c.b
 * JD-Core Version:    0.7.0.1
 */