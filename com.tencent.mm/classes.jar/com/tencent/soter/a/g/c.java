package com.tencent.soter.a.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.c.b;

abstract class c
  extends d
{
  protected static void jt(String paramString, int paramInt)
  {
    com.tencent.soter.core.c.d.d("Soter.BaseSoterPrepareKeyTask", "soter: marking preference. key: %s, status: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    try
    {
      if (b.jYt().jYw() != null) {
        b.jYt().jYw().edit().putInt(paramString, paramInt).commit();
      }
      return;
    }
    finally {}
  }
  
  final void b(e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.g.c
 * JD-Core Version:    0.7.0.1
 */