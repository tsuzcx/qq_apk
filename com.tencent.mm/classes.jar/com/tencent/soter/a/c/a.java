package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;

public class a
{
  private static volatile a wPy = null;
  public boolean bHn = false;
  public boolean dBn = false;
  public SharedPreferences wPA = null;
  public SparseArray<String> wPz = new SparseArray(10);
  
  public static a cPy()
  {
    if (wPy == null) {
      try
      {
        if (wPy == null) {
          wPy = new a();
        }
        a locala = wPy;
        return locala;
      }
      finally {}
    }
    return wPy;
  }
  
  public final SparseArray<String> cPA()
  {
    try
    {
      SparseArray localSparseArray = this.wPz;
      return localSparseArray;
    }
    finally {}
  }
  
  public final SharedPreferences cPB()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.wPA;
      return localSharedPreferences;
    }
    finally {}
  }
  
  public final boolean cPw()
  {
    try
    {
      boolean bool = this.bHn;
      return bool;
    }
    finally {}
  }
  
  public final void cPz()
  {
    try
    {
      this.dBn = true;
      return;
    }
    finally {}
  }
  
  public final boolean isInit()
  {
    try
    {
      boolean bool = this.dBn;
      return bool;
    }
    finally {}
  }
  
  public final void ok(boolean paramBoolean)
  {
    try
    {
      this.bHn = paramBoolean;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.a.c.a
 * JD-Core Version:    0.7.0.1
 */