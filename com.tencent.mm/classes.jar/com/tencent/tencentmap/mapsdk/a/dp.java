package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.nt;
import java.util.HashMap;

public class dp
{
  private static dp c;
  private do a;
  private boolean b;
  
  private dp()
  {
    AppMethodBeat.i(101092);
    this.a = new ds();
    this.b = false;
    AppMethodBeat.o(101092);
  }
  
  public static dp a()
  {
    try
    {
      AppMethodBeat.i(150133);
      if (c == null) {
        c = new dp();
      }
      dp localdp = c;
      AppMethodBeat.o(150133);
      return localdp;
    }
    finally {}
  }
  
  public dq a(String paramString)
  {
    AppMethodBeat.i(150135);
    if (this.a == null)
    {
      AppMethodBeat.o(150135);
      return null;
    }
    paramString = this.a.a(paramString);
    AppMethodBeat.o(150135);
    return paramString;
  }
  
  public dq a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150136);
    if (this.a == null)
    {
      AppMethodBeat.o(150136);
      return null;
    }
    paramString1 = this.a.a(paramString1, paramString2);
    AppMethodBeat.o(150136);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150138);
    if (this.a == null)
    {
      AppMethodBeat.o(150138);
      return null;
    }
    paramString1 = this.a.a(paramString1, paramString2, paramArrayOfByte);
    AppMethodBeat.o(150138);
    return paramString1;
  }
  
  public dq a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HashMap<String, String> paramHashMap, nt paramnt)
  {
    AppMethodBeat.i(155188);
    if (this.a == null)
    {
      AppMethodBeat.o(155188);
      return null;
    }
    paramString1 = this.a.a(paramString1, paramString2, paramArrayOfByte, paramInt, paramHashMap, paramnt);
    AppMethodBeat.o(155188);
    return paramString1;
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(150134);
    if (this.b)
    {
      AppMethodBeat.o(150134);
      return;
    }
    if (this.a != null)
    {
      this.a.a(paramContext.getApplicationContext());
      this.b = true;
    }
    AppMethodBeat.o(150134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dp
 * JD-Core Version:    0.7.0.1
 */