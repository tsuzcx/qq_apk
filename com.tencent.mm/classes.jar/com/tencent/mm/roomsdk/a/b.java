package com.tencent.mm.roomsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b
{
  private static b yjF;
  private HashMap<String, a> yjE;
  
  static
  {
    AppMethodBeat.i(80241);
    yjF = new b();
    AppMethodBeat.o(80241);
  }
  
  public b()
  {
    AppMethodBeat.i(80238);
    this.yjE = new HashMap();
    AppMethodBeat.o(80238);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(80240);
    int i = paramString.indexOf("@");
    if (i < 0) {}
    for (;;)
    {
      b localb = yjF;
      if (!localb.yjE.containsKey(paramString)) {
        localb.yjE.put(paramString, parama);
      }
      AppMethodBeat.o(80240);
      return;
      paramString = paramString.substring(i);
    }
  }
  
  public static a aoI(String paramString)
  {
    AppMethodBeat.i(80239);
    int i = paramString.indexOf("@");
    if (i < 0)
    {
      ab.e("MicroMsg.RoomServiceFactory", "get NotNullChatRoom %s", new Object[] { paramString });
      paramString = new com.tencent.mm.roomsdk.a.a.b();
      AppMethodBeat.o(80239);
      return paramString;
    }
    paramString = paramString.substring(i);
    b localb = yjF;
    if (localb.yjE.containsKey(paramString)) {}
    for (paramString = (a)localb.yjE.get(paramString); paramString == null; paramString = null)
    {
      paramString = new com.tencent.mm.roomsdk.a.a.b();
      AppMethodBeat.o(80239);
      return paramString;
    }
    AppMethodBeat.o(80239);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.b
 * JD-Core Version:    0.7.0.1
 */