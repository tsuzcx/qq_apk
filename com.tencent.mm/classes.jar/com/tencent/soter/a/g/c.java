package com.tencent.soter.a.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.soter.a.c.a;

abstract class c
  extends d
{
  protected static void dV(String paramString, int paramInt)
  {
    com.tencent.soter.core.c.d.d("Soter.BaseSoterPrepareKeyTask", "soter: marking preference. key: %s, status: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    try
    {
      if (a.cPy().cPB() != null) {
        a.cPy().cPB().edit().putInt(paramString, paramInt).apply();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.c
 * JD-Core Version:    0.7.0.1
 */