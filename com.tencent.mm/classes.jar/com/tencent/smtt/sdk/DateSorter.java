package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter
{
  public static int DAY_COUNT;
  private android.webkit.DateSorter a;
  private IX5DateSorter b;
  
  static
  {
    AppMethodBeat.i(63898);
    a();
    DAY_COUNT = 5;
    AppMethodBeat.o(63898);
  }
  
  public DateSorter(Context paramContext)
  {
    AppMethodBeat.i(63893);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      this.b = localbz.c().h(paramContext);
      AppMethodBeat.o(63893);
      return;
    }
    this.a = new android.webkit.DateSorter(paramContext);
    AppMethodBeat.o(63893);
  }
  
  private static boolean a()
  {
    AppMethodBeat.i(63897);
    boolean bool2 = false;
    bz localbz = bz.a();
    boolean bool1 = bool2;
    if (localbz != null)
    {
      bool1 = bool2;
      if (localbz.b()) {
        bool1 = true;
      }
    }
    AppMethodBeat.o(63897);
    return bool1;
  }
  
  public long getBoundary(int paramInt)
  {
    AppMethodBeat.i(63896);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      l = this.b.getBoundary(paramInt);
      AppMethodBeat.o(63896);
      return l;
    }
    long l = this.a.getBoundary(paramInt);
    AppMethodBeat.o(63896);
    return l;
  }
  
  public int getIndex(long paramLong)
  {
    AppMethodBeat.i(63894);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      i = this.b.getIndex(paramLong);
      AppMethodBeat.o(63894);
      return i;
    }
    int i = this.a.getIndex(paramLong);
    AppMethodBeat.o(63894);
    return i;
  }
  
  public String getLabel(int paramInt)
  {
    AppMethodBeat.i(63895);
    Object localObject = bz.a();
    if ((localObject != null) && (((bz)localObject).b()))
    {
      localObject = this.b.getLabel(paramInt);
      AppMethodBeat.o(63895);
      return localObject;
    }
    localObject = this.a.getLabel(paramInt);
    AppMethodBeat.o(63895);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.DateSorter
 * JD-Core Version:    0.7.0.1
 */