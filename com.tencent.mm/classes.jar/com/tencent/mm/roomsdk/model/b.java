package com.tencent.mm.roomsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.model.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class b
{
  private static b acmu;
  private HashMap<String, a> acmt;
  
  static
  {
    AppMethodBeat.i(152758);
    acmu = new b();
    AppMethodBeat.o(152758);
  }
  
  public b()
  {
    AppMethodBeat.i(152755);
    this.acmt = new HashMap();
    AppMethodBeat.o(152755);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(152757);
    int i = paramString.indexOf("@");
    if (i < 0) {}
    for (;;)
    {
      b localb = acmu;
      if (!localb.acmt.containsKey(paramString)) {
        localb.acmt.put(paramString, parama);
      }
      AppMethodBeat.o(152757);
      return;
      paramString = paramString.substring(i);
    }
  }
  
  public static a btW(String paramString)
  {
    AppMethodBeat.i(152756);
    int i = paramString.indexOf("@");
    if (i < 0)
    {
      Log.e("MicroMsg.RoomServiceFactory", "get NotNullChatRoom %s", new Object[] { paramString });
      paramString = new com.tencent.mm.roomsdk.model.a.b();
      AppMethodBeat.o(152756);
      return paramString;
    }
    paramString = paramString.substring(i);
    b localb = acmu;
    if (localb.acmt.containsKey(paramString)) {}
    for (paramString = (a)localb.acmt.get(paramString); paramString == null; paramString = null)
    {
      paramString = new com.tencent.mm.roomsdk.model.a.b();
      AppMethodBeat.o(152756);
      return paramString;
    }
    AppMethodBeat.o(152756);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.roomsdk.model.b
 * JD-Core Version:    0.7.0.1
 */