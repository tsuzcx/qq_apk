package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.c.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.h.a;

final class j$1
  implements h.a
{
  j$1(j paramj) {}
  
  public final boolean dVn()
  {
    AppMethodBeat.i(10550);
    SharedPreferences localSharedPreferences = a.dVu().dVx();
    if (localSharedPreferences != null)
    {
      boolean bool = localSharedPreferences.getBoolean(j.access$000(), false);
      d.i("Soter.TaskInit", "soter: is triggered OOM: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(10550);
      return bool;
    }
    AppMethodBeat.o(10550);
    return false;
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void dVo()
  {
    AppMethodBeat.i(10549);
    d.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
    Object localObject = a.dVu().dVx();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(j.access$000(), true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    AppMethodBeat.o(10549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.a.g.j.1
 * JD-Core Version:    0.7.0.1
 */