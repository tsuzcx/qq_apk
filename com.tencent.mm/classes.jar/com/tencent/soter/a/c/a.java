package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile a BmX = null;
  public int BmY;
  public SparseArray<String> BmZ;
  public SharedPreferences Bna;
  public boolean bRB;
  public boolean coB;
  
  public a()
  {
    AppMethodBeat.i(10465);
    this.bRB = false;
    this.coB = false;
    this.BmY = 0;
    this.BmZ = new SparseArray(10);
    this.Bna = null;
    AppMethodBeat.o(10465);
  }
  
  public static a dVu()
  {
    AppMethodBeat.i(10466);
    if (BmX == null) {
      try
      {
        if (BmX == null) {
          BmX = new a();
        }
        a locala1 = BmX;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(10466);
      }
    }
    a locala2 = BmX;
    AppMethodBeat.o(10466);
    return locala2;
  }
  
  public final boolean dVs()
  {
    try
    {
      boolean bool = this.coB;
      return bool;
    }
    finally {}
  }
  
  public final void dVv()
  {
    try
    {
      this.bRB = true;
      return;
    }
    finally {}
  }
  
  public final SparseArray<String> dVw()
  {
    try
    {
      SparseArray localSparseArray = this.BmZ;
      return localSparseArray;
    }
    finally {}
  }
  
  public final SharedPreferences dVx()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.Bna;
      return localSharedPreferences;
    }
    finally {}
  }
  
  public final boolean isInit()
  {
    try
    {
      boolean bool = this.bRB;
      return bool;
    }
    finally {}
  }
  
  public final void rW(boolean paramBoolean)
  {
    try
    {
      this.coB = paramBoolean;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.soter.a.c.a
 * JD-Core Version:    0.7.0.1
 */