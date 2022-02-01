package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static volatile b JXg = null;
  public int JXh;
  public SparseArray<String> JXi;
  public SharedPreferences JXj;
  public boolean cqf;
  public boolean daX;
  
  public b()
  {
    AppMethodBeat.i(16);
    this.cqf = false;
    this.daX = false;
    this.JXh = 0;
    this.JXi = new SparseArray(10);
    this.JXj = null;
    AppMethodBeat.o(16);
  }
  
  public static b fDE()
  {
    AppMethodBeat.i(17);
    if (JXg == null) {
      try
      {
        if (JXg == null) {
          JXg = new b();
        }
        b localb1 = JXg;
        return localb1;
      }
      finally
      {
        AppMethodBeat.o(17);
      }
    }
    b localb2 = JXg;
    AppMethodBeat.o(17);
    return localb2;
  }
  
  public final boolean fDA()
  {
    try
    {
      boolean bool = this.daX;
      return bool;
    }
    finally {}
  }
  
  public final void fDF()
  {
    try
    {
      this.cqf = true;
      return;
    }
    finally {}
  }
  
  public final SparseArray<String> fDG()
  {
    try
    {
      SparseArray localSparseArray = this.JXi;
      return localSparseArray;
    }
    finally {}
  }
  
  public final SharedPreferences fDH()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.JXj;
      return localSharedPreferences;
    }
    finally {}
  }
  
  public final boolean isInit()
  {
    try
    {
      boolean bool = this.cqf;
      return bool;
    }
    finally {}
  }
  
  public final void yF(boolean paramBoolean)
  {
    try
    {
      this.daX = paramBoolean;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.c.b
 * JD-Core Version:    0.7.0.1
 */