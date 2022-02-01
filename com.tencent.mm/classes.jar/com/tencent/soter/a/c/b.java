package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static volatile b ahxO = null;
  public int ahxP;
  public SparseArray<String> ahxQ;
  public SharedPreferences ahxR;
  public boolean hCb;
  public boolean isInit;
  
  public b()
  {
    AppMethodBeat.i(16);
    this.isInit = false;
    this.hCb = false;
    this.ahxP = 0;
    this.ahxQ = new SparseArray(10);
    this.ahxR = null;
    AppMethodBeat.o(16);
  }
  
  public static b jYt()
  {
    AppMethodBeat.i(17);
    if (ahxO == null) {
      try
      {
        if (ahxO == null) {
          ahxO = new b();
        }
        b localb1 = ahxO;
        return localb1;
      }
      finally
      {
        AppMethodBeat.o(17);
      }
    }
    b localb2 = ahxO;
    AppMethodBeat.o(17);
    return localb2;
  }
  
  public final void Ot(boolean paramBoolean)
  {
    try
    {
      this.hCb = paramBoolean;
      return;
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
  
  public final boolean jYp()
  {
    try
    {
      boolean bool = this.hCb;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void jYu()
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
  
  public final SparseArray<String> jYv()
  {
    try
    {
      SparseArray localSparseArray = this.ahxQ;
      return localSparseArray;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final SharedPreferences jYw()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.ahxR;
      return localSharedPreferences;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.c.b
 * JD-Core Version:    0.7.0.1
 */