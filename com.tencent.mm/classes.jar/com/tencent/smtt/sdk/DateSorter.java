package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter
  extends z
{
  public static int DAY_COUNT;
  private android.webkit.DateSorter a;
  private IX5DateSorter b;
  
  static
  {
    AppMethodBeat.i(54072);
    isX5Core();
    DAY_COUNT = 5;
    AppMethodBeat.o(54072);
  }
  
  public DateSorter(Context paramContext)
  {
    AppMethodBeat.i(54068);
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      this.b = getCoreMessy().createDateSorter(paramContext);
      AppMethodBeat.o(54068);
      return;
    }
    this.a = new android.webkit.DateSorter(paramContext);
    AppMethodBeat.o(54068);
  }
  
  public long getBoundary(int paramInt)
  {
    AppMethodBeat.i(54071);
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      l = this.b.getBoundary(paramInt);
      AppMethodBeat.o(54071);
      return l;
    }
    long l = this.a.getBoundary(paramInt);
    AppMethodBeat.o(54071);
    return l;
  }
  
  public int getIndex(long paramLong)
  {
    AppMethodBeat.i(54069);
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      i = this.b.getIndex(paramLong);
      AppMethodBeat.o(54069);
      return i;
    }
    int i = this.a.getIndex(paramLong);
    AppMethodBeat.o(54069);
    return i;
  }
  
  public String getLabel(int paramInt)
  {
    AppMethodBeat.i(54070);
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      localObject = this.b.getLabel(paramInt);
      AppMethodBeat.o(54070);
      return localObject;
    }
    localObject = this.a.getLabel(paramInt);
    AppMethodBeat.o(54070);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.DateSorter
 * JD-Core Version:    0.7.0.1
 */